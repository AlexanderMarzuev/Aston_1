package org.example;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String file = "src/main/resources/student.json";
        List<Student> students = new ArrayList<>();
        Gson gson = new Gson();
        try (JsonReader reader = new JsonReader(new FileReader(file))) {
            reader.beginArray();
            while (reader.hasNext()) {
                Student student = gson.fromJson(reader, Student.class);
                students.add(student);
            }
            reader.endArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Book::getSize))
                .distinct().filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findAny()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Такой книги не существует"));
    }

}