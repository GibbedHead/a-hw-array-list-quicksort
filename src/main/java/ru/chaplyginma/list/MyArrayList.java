package ru.chaplyginma.list;

import java.util.*;

/**
 * A custom implementation of a resizable array list, which allows for dynamic
 * storage of elements. This class provides methods to manipulate the list such
 * as adding, removing, and sorting elements. The list automatically expands
 * its capacity when needed.
 *
 * @param <E> the type of elements in this list
 */
public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] data;

    /**
     * Constructs an empty list with the default initial capacity (10).
     */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative.");
        }
        data = new Object[initialCapacity];
        size = 0;
    }

    /**
     * Constructs a list containing the elements of the specified collection.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public MyArrayList(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException("Collection cannot be null.");
        }
        data = new Object[c.size()];
        addAll(c);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that {@code Objects.equals(o, e)}.
     *
     * @param search element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    @Override
    public boolean contains(Object search) {
        return indexOf(search) != -1;
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public Object[] toArray() {
        return data.clone();
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add}).
     */
    @Override
    public boolean add(E e) {
        if (size == data.length) {
            grow();
        }
        data[size++] = e;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that {@code o.equals(get(i))} (if such an element
     * exists).  Returns {@code true} if this list contained the specified
     * element (or equivalently, if this list changed as a result of the
     * call).
     *
     * @param o element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
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

    /**
     * Returns {@code true} if this list contains all of the elements of the
     * specified collection.
     *
     * @param c collection to be checked for containment in this list
     * @return {@code true} if this list contains all of the elements of the
     * specified collection
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Appends all the elements in the specified collection to the end of this list,
     * in the order that they are returned by the specified collection's iterator.
     * <p>
     * Attempts to add all elements from the specified collection will be
     * successful if, and only if, this list has enough capacity to accommodate
     * the elements. If the list does not have enough capacity, it will be
     * resized to ensure that all elements are added.
     *
     * @param c collection containing elements to be added to this list
     * @return {@code true} (as specified by {@link Collection#addAll})
     */
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

    /**
     * Inserts all the elements in the specified collection into this
     * list at the specified position.  Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (increases
     * their indices). The new elements will appear in the list in the order
     * that they are returned by the specified collection's iterator.
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param c     collection containing elements to be added to this list
     * @return {@code true} (as specified by {@link Collection#addAll})
     * @throws IndexOutOfBoundsException if {@code index} is out of range
     *                                   ({@code index < 0 || index > size()})
     */
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

    /**
     * Removes all of this list's elements that are also contained in the
     * specified collection.
     *
     * @param c collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : data) {
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return true;
    }

    /**
     * Removes all the elements from this list.
     */
    @Override
    public void clear() {
        for (Object o : data) {
            o = null;
        }
        size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bounds", index));
        }
        return (E) data[index];
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index   index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   ({@code index < 0 || index >= size()})
     */
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

    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position and any
     * subsequent elements to the right increases their indices.
     *
     * @param index   index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if {@code index} is out of range
     *                                   ({@code index < 0 || index > size()})
     */
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

    /**
     * Removes the element at the specified position in this list.
     * Returns the element which was removed from the list.
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
     */
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

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param search the element to search for
     * @return the index of the first occurrence of the specified element,
     * or -1 if this list does not contain the element
     */
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

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param search the element to search for
     * @return the index of the last occurrence of the specified element,
     * or -1 if this list does not contain the element
     */
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

    /**
     * Sorts the list using the provided comparator. The list will be
     * sorted in-place.
     *
     * @param c the comparator to determine the order of the list
     */
    @SuppressWarnings("unchecked")
    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) data, c);
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    /**
     * This method is not implemented in this class as it is not in homework.
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    /**
     * Returns a string representation of the list, including its elements.
     * The elements are represented in a readable format.
     *
     * @return a string representation of the list
     */
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
