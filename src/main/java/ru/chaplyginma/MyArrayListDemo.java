package ru.chaplyginma;

import ru.chaplyginma.list.MyArrayList;

import java.util.List;

public class MyArrayListDemo {

    public static void main(String[] args) {
        List<String> stringList = new MyArrayList<>();
        System.out.println("---------------");
        System.out.println("Empty list");
        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Add first element");
        stringList.add("A");
        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Add second element");
        stringList.add("B");
        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Add more elements");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        stringList.add("F");

        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Test if contains element 'B' and 'Z");
        System.out.println(stringList.contains("B"));
        System.out.println(stringList.contains("Z"));

        System.out.println("---------------");
        System.out.println("Test if contains element null");
        System.out.println(stringList.contains(null));
        System.out.println("---------------");
        System.out.println("Add null and test if contains element null");
        stringList.add(null);
        System.out.println(stringList.contains(null));

        System.out.println("---------------");
        System.out.println("Remove null");
        stringList.remove(null);
        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Remove and add elements");
        stringList.remove("B");
        System.out.println(stringList.remove("Z"));
        stringList.remove("E");
        stringList.add("G");
        System.out.println(stringList);

        System.out.println("---------------");
        System.out.println("Index of last element");
        System.out.println(stringList.indexOf("G"));

        System.out.println("---------------");
        System.out.println("Clear list, test if contain G, add 'AA'");
        stringList.clear();
        System.out.println(stringList);
        System.out.println(stringList.contains("G"));
        stringList.add("AA");
        System.out.println(stringList);
    }
}
