package ru.chaplyginma.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.chaplyginma.list.MyArrayList;
import ru.chaplyginma.model.Person;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyListSortTest {

    @Test
    @DisplayName("Test sort list of integers and strings in natural order")
    void testSortListOfIntegersAndStrings() {
        MyArrayList<Integer> integers = new MyArrayList<>(List.of(2, 3, 1, 9, 3, 4, 8, -1, 5, 11, -2, 0, 100, -100));
        MyListSort.quickSort(integers, Comparator.naturalOrder());
        assertThat(isListNonDecreasing(integers, Comparator.naturalOrder())).isTrue();

        MyArrayList<String> strings = new MyArrayList<>(List.of("t", "d", "a", "b", "c", "i", "g", "z", "h"));
        MyListSort.quickSort(strings, Comparator.naturalOrder());
        assertThat(isListNonDecreasing(strings, Comparator.naturalOrder())).isTrue();
    }

    @Test
    @DisplayName("Test sort list of custom class")
    void testSortListOfCustomClass() {
        MyArrayList<Person> people = new MyArrayList<>(List.of(
                new Person("Anna", "Antonova", 25),
                new Person("Anna", "Antonova", 22),
                new Person("Elena", "Antonova", 22),
                new Person("Elena", "Filipova", 22),
                new Person("Anna", "Antonova", 18)
        ));
        MyListSort.quickSort(people);

        assertThat(isListNonDecreasing(people, Comparator.naturalOrder())).isTrue();
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