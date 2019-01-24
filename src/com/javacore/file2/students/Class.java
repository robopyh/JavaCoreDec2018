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
     * @param grade   a new student's grade from the interval [1.0, 5.0]
     * @throws IllegalArgumentException will be thrown if {@code grade} is less than 1.0 or greater than 5.0 OR
     * if {@code student} already contains in the group
     */
    public void addStudent(@NonNull Student student, @NonNull V grade) throws IllegalArgumentException{
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
     * @param student a student from this group
     * @throws IllegalArgumentException will be thrown if {@code student} doesn't contains in the group
     */
    public void removeStudent(@NonNull Student student) throws IllegalArgumentException{
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
     * @param student a student from this group
     * @return a student's grade from the interval [1.0, 5.0]
     * @throws IllegalArgumentException will be thrown if {@code student} doesn't contains in the group
     */
    public V getGrade(@NonNull Student student) throws IllegalArgumentException{
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
     * @param student a student from this group
     * @param grade   a new student's grade from the interval [1.0, 5.0]
     * @throws IllegalArgumentException will be thrown if {@code grade} is less than 1.0 or greater than 5.0 OR
     * if {@code student} already contains in the group
     */
    public void setGrade(@NonNull Student student,@NonNull V grade) throws IllegalArgumentException{
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
