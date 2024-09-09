package ru.chaplyginma.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyArrayListTest {

    @Test
    @DisplayName("Create empty list")
    void givenNoConstructorArguments_whenCreate_thenEmptyList() {
        List<String> list = new MyArrayList<>();

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Create list with collection provided")
    void givenCollection_whenCreate_thenAllElementsAddedToList() {
        List<String> list = new MyArrayList<>(List.of("a", "b", "c"));

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.contains("a")).isTrue();
        assertThat(list.contains("b")).isTrue();
        assertThat(list.contains("c")).isTrue();
    }

    @Test
    @DisplayName("Create list with set capacity")
    void givenSetCapacity_whenCreate_thenEmptyList() {
        List<String> list = new MyArrayList<>(16);

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Test size")
    void given2ElementsAdded_whenSize_thenSieEq2() {
        List<String> list = new MyArrayList<>(List.of("a", "b"));

        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Added and removed 2 elements test for empty")
    void given2ElementsAddedAndRemoved_whenIsEmpty_thenTrue() {
        List<String> list = new MyArrayList<>(List.of("a", "b"));
        list.remove("a");
        list.remove("b");

        assertThat(list.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Test contains")
    void givenNonEmptyList_whenContains_thenReturnsTrue() {
        List<String> list = new MyArrayList<>(List.of("a", "b"));

        assertThat(list.contains("a")).isTrue();
    }

    @Test
    @DisplayName("Test add element")
    void givenEmptyList_whenAddElement_thenSizeEq1AndContainsElement() {
        List<String> list = new MyArrayList<>();
        list.add("a");

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.contains("a")).isTrue();
    }

    @Test
    @DisplayName("Test remvoe element")
    void given2ElementList_whenRemoveElement_thenSizeEq1AndContainsEqFalse() {
        List<String> list = new MyArrayList<>(List.of("a", "b"));
        list.remove("a");

        assertThat(list.size()).isEqualTo(1);
        assertThat(list.contains("a")).isFalse();
    }

    @Test
    @DisplayName("Test indexOf")
    void givenNonEmptyList_whenIndexOf_thenReturnsIndex() {
        List<String> list = new MyArrayList<>(List.of("a", "b"));

        assertThat(list.indexOf("a")).isEqualTo(0);
    }

    @Test
    @DisplayName("Test last indexOf")
    void givenNonEmptyListWith2SameElements_whenLastIndexOf_thenReturnsLastIndex() {
        List<String> list = new MyArrayList<>(List.of("a", "b", "a"));

        assertThat(list.lastIndexOf("a")).isEqualTo(2);
    }

    @Test
    @DisplayName("Test remove all")
    void givenNonEmptyListAndCollection_whenRemoveAll_thenReturnsListWithoutCollectionElements() {
        List<String> list = new MyArrayList<>(List.of("a", "b", "c"));
        List<String> collection = List.of("b", "c");

        list.removeAll(collection);

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Test retain all")
    void givenNonEmptyListAndCollection_whenRetainAll_thenReturnsListContainingOnlyCollectionElements() {
        List<String> list = new MyArrayList<>(List.of("a", "b", "c"));
        List<String> collection = List.of("b", "c");

        list.retainAll(collection);

        assertThat(list.size()).isEqualTo(2);
        assertThat(list.contains("a")).isFalse();
    }
}