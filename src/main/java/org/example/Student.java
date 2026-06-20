package org.example;

import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private List<Book> books;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(books, student.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, books);
    }
}
