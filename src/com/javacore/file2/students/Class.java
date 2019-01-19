package com.javacore.file2.students;

import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Abstract class represents a group of {@link Student} combined by a discipline.
 *
 * @param <V> type of the {@code grade}, must be {@link Integer} or {@link Double}
 */
abstract public class Class<V extends Number> {
    private final Map<Student, V> studentMap = new HashMap<>();

    /**
     * Adds student to the group.
     *
     * @param student a new student
     * @param grade   a new student's grade
     */
    public void addStudent(@NonNull Student student, @NonNull V grade) {
        if (grade.doubleValue() > 5.0 || grade.doubleValue() < 1.0) {
            throw new IllegalArgumentException("Grade range is defined is from 1.0 to 5.0");
        }

        if (this.isContainsStudent(student)) {
            throw new IllegalArgumentException("The group already contains this student");
        }
        else {
            studentMap.put(student, grade);
        }
    }

    /**
     * Removes student from the group.
     *
     * @param student a student
     */
    public void removeStudent(@NonNull Student student) {
        if (this.isContainsStudent(student)) {
            studentMap.remove(student);
        }
        else {
            throw new IllegalArgumentException("The group doesn't contain this student");
        }
    }

    /**
     * Shows all students.
     */
    public void showAllStudents() {
        System.out.println(this.getClass().getSimpleName() + ": ");
        for (Map.Entry<Student, V> studentEntry : studentMap.entrySet()) {
            System.out.println(studentEntry.getKey().toString() + " has grade " + studentEntry.getValue());
        }
        System.out.println();
    }

    /**
     * Shows is the group contains a student.
     *
     * @param student a student
     * @return True if it contains and False otherwise
     */
    public boolean isContainsStudent(@NonNull Student student) {
        Stream<Map.Entry<Student, V>> stream = studentMap.entrySet().stream();
        return stream.anyMatch(e -> e.getKey().equals(student));
    }

    /**
     * Gets student's grade.
     *
     * @param student a student
     * @return a grade
     */
    public V getGrade(@NonNull Student student) {
        if (this.isContainsStudent(student)) {
            return studentMap.get(student);
        }
        else {
            throw new IllegalArgumentException("The group doesn't contain this student");
        }
    }

    /**
     * Sets a student's grade.
     *
     * @param student a student
     * @param grade   a grade
     */
    public void setGrade(@NonNull Student student,@NonNull V grade) {
        if (grade.doubleValue() > 5.0 || grade.doubleValue() < 1.0) {
            throw new IllegalArgumentException("Grade range is defined is from 1.0 to 5.0");
        }

        if (this.isContainsStudent(student)) {
            studentMap.replace(student, grade);
        }
        else {
            throw new IllegalArgumentException("The group doesn't contain this student");
        }
    }
}
