package ru.chaplyginma.list;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] data;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        data = new Object[initialCapacity];
        size = 0;
    }

    public MyArrayList(Collection<? extends E> c) {
        data = new Object[c.size()];
        addAll(c);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object search) {
        return indexOf(search) != -1;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (size == data.length) {
            grow();
        }
        data[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (size + c.size() > data.length) {
            grow(c.size());
        }
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        if (size + c.size() > data.length) {
            grow(c.size());
        }
        int fromIndex = index + c.size();
        System.arraycopy(data, index, data, fromIndex, size - index);
        int i = index;
        for (E e : c) {
            data[i++] = e;
        }
        size += c.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : data) {
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (Object o : data) {
            o = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        E old = (E) data[index];
        data[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        if (size == data.length) {
            grow();
        }
        System.arraycopy(data, index, data, index + 1, size - index - 1);
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        E old = (E) data[index];
        removeAt(index);
        size--;
        return old;
    }

    @Override
    public int indexOf(Object search) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (search == null) {
                if (data[i] == null) {
                    index = i;
                    break;
                }
            } else {
                if (data[i].equals(search)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object search) {
        int index = -1;
        for (int i = size - 1; i > 0; i--) {
            if (search == null) {
                if (data[i] == null) {
                    index = i;
                    break;
                }
            } else {
                if (data[i].equals(search)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                onlySetListElementsToString() +
                '}';
    }

    private String onlySetListElementsToString() {
        StringJoiner sj = new StringJoiner(", ");
        for (int i = 0; i < size; i++) {
            sj.add(data[i].toString());
        }
        return sj.toString();
    }

    private boolean isIndexOutOfBounds(int index) {
        return index < 0 && index >= size;
    }

    private void removeAt(int index) {
        System.arraycopy(data, index + 1, data, index, size - index - 1);
    }

    private void grow() {
        int newCapacity = (data.length / 2) * 3 + 1;
        growToNewCapacity(newCapacity);
    }

    private void grow(int addedSize) {
        int newCapacity = ((data.length + addedSize) / 2) * 3 + 1;
        growToNewCapacity(newCapacity);
    }

    private void growToNewCapacity(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
