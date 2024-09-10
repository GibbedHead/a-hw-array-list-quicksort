package ru.chaplyginma.model;

/**
 * Represents a person with a first name, last name, and age.
 *
 * <p>This class implements the {@link Comparable} interface, providing a natural
 * ordering based on last name, then first name, and finally age.
 */
public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Compares this {@code Person} object to another {@code Person} object.
     *
     * <p>The comparison is based on the following order:
     * 1. Last name (ascending)
     * 2. First name (ascending)
     * 3. Age (ascending)
     *
     * @param o The {@code Person} object to compare with.
     * @return A negative integer, zero, or a positive integer as this person
     * is less than, equal to, or greater than the specified person.
     */
    @Override
    public int compareTo(Person o) {
        int lastNameComparison = lastName.compareTo(o.lastName);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = firstName.compareTo(o.firstName);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        return Integer.compare(age, o.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
