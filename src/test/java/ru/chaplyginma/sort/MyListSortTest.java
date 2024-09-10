package ru.chaplyginma.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.chaplyginma.list.MyArrayList;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyListSortTest {

    @Test
    @DisplayName("Test sort list of integers and strings in natural order")
    void sort() {
        MyArrayList<Integer> integers = new MyArrayList<>(List.of(2, 3, 1, 9, 3, 4, 8, -1, 5, 11, -2, 0, 100, -100));
        MyListSort.quickSort(integers, Comparator.naturalOrder());
        assertThat(isListNonDecreasing(integers, Comparator.naturalOrder())).isTrue();

        MyArrayList<String> strings = new MyArrayList<>(List.of("t", "d", "a", "b", "c", "i", "g", "z", "h"));
        MyListSort.quickSort(strings, Comparator.naturalOrder());
        assertThat(isListNonDecreasing(strings, Comparator.naturalOrder())).isTrue();
    }

    private <T> boolean isListNonDecreasing(MyArrayList<T> list, Comparator<T> comparator) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (comparator.compare(list.get(i), list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}