package ru.chaplyginma.sort;

import ru.chaplyginma.list.MyArrayList;

import java.util.Comparator;

/**
 * Provides static methods for sorting instances of {@link MyArrayList} using
 * the QuickSort algorithm.
 *
 * <p>The QuickSort algorithm is a recursive divide-and-conquer algorithm. It works
 * by selecting a pivot element from the array and partitioning the array
 * around the pivot such that all elements smaller than the pivot are placed
 * before it, and all elements greater than the pivot are placed after it.
 * This process is then recursively applied to the subarrays before and after
 * the pivot until the entire array is sorted.
 */
public class MyListSort {

    /**
     * Sorts the given {@link MyArrayList} using the QuickSort algorithm
     * with a custom {@link Comparator} to define the ordering.
     *
     * @param list       The {@link MyArrayList} to be sorted.
     * @param comparator The {@link Comparator} to be used for comparing
     *                   elements.
     * @param <T>        The type of elements in the list.
     */
    public static <T> void quickSort(MyArrayList<T> list, Comparator<T> comparator) {
        qSort(list, comparator, 0, list.size() - 1);
    }

    /**
     * Sorts the given {@link MyArrayList} using the QuickSort algorithm
     * using the natural ordering of the elements (using {@link Comparable}).
     *
     * @param list The {@link MyArrayList} to be sorted.
     * @param <T>  The type of elements in the list.
     */
    public static <T extends Comparable<T>> void quickSort(MyArrayList<T> list) {
        qSort(list, Comparator.naturalOrder(), 0, list.size() - 1);
    }

    private static <T> void qSort(MyArrayList<T> list, Comparator<T> comparator, int left, int right) {
        if (left < right) {
            int pivot = partition(list, comparator, left, right);
            qSort(list, comparator, left, pivot);
            qSort(list, comparator, pivot + 1, right);
        }
    }

    private static <T> int partition(MyArrayList<T> list, Comparator<T> comparator, int left, int right) {
        T pivot = list.get((left + right) / 2);
        while (left <= right) {
            while (comparator.compare(list.get((left)), pivot) < 0) {
                left++;
            }
            while (comparator.compare(list.get((right)), pivot) > 0) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(list, left++, right--);
        }
        return right;
    }

    private static <T> void swap(MyArrayList<T> list, int left, int right) {
        T temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }
}
