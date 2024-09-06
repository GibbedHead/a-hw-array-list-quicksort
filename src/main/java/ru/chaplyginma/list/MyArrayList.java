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
        size = c.size();
        addAll(c);
    }

    private void grow() {
        int newCapacity = (data.length / 2) * 3 + 1;
        growToNewCapacity(newCapacity);
    }

    private void grow(int addedSize) {
        int newCapacity = (data.length + addedSize / 2) * 3 + 1;
        growToNewCapacity(newCapacity);
    }

    private void growToNewCapacity(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
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
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for (Object o : data) {
            o = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object search) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (search == null) {
                if (data[i] == null) {
                    index = i;
                }
            } else {
                if (data[i].equals(search)) {
                    index = i;
                }
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
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
}
