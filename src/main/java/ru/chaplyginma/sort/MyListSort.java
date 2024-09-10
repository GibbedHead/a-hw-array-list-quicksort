package ru.chaplyginma.sort;

import ru.chaplyginma.list.MyArrayList;

import java.util.Comparator;

public class MyListSort {

    public static <T> void quickSort(MyArrayList<T> list, Comparator<T> comparator) {
        qSort(list, comparator, 0, list.size() - 1);
    }

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
