package ru.chaplyginma.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyArrayListTest {

    @Test
    @DisplayName("Create empty list")
    void givenNoConstructorArguments_whenCreate_thenEmptyList() {
        MyArrayList<String> list = new MyArrayList<>();

        assertThat(list.isEmpty()).isTrue();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("Create list with collection provided")
    void givenCollection_whenCreate_thenAllElementsAddedToList() {
        MyArrayList<String> list = new MyArrayList<>(List.of("a", "b", "c"));

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.contains("a")).isTrue();
        assertThat(list.contains("b")).isTrue();
        assertThat(list.contains("c")).isTrue();
    }
}