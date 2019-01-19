package com.javacore.file2.students;

import lombok.Builder;
import lombok.NonNull;

import java.util.Objects;

/**
 * Class represents a student.
 */
@Builder(builderMethodName = "helpBuilder")
public class Student {
    private String name;
    private long age;
    private long phoneNumber;
    private String email;

    /**
     * Forces to set {@code name} and {@code age} fields.
     *
     * @param name a student's name
     * @param age  a student's age starts from 16
     * @return the student builder
     */
    public static StudentBuilder builder(@NonNull String name, long age) {
        if (age < 16) {
            throw new IllegalArgumentException("Valid age stars with 16.");
        }
        return helpBuilder().name(name).age(age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                phoneNumber == student.phoneNumber &&
                name.equals(student.name) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, phoneNumber, email);
    }

    @Override
    public String toString() {
        return name + " (" +
                "age = " + age +
                ", phone = " + phoneNumber +
                ", email = " + ((email == null) ? "\"\"" : email) +
                ")";
    }
}
