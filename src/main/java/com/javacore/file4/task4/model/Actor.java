package com.javacore.file4.task4.model;

import com.google.common.base.Objects;

import java.io.Serializable;

public class Actor implements Serializable {
    private final String name;
    private final int age;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s (%d years)", name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return age == actor.age &&
                Objects.equal(name, actor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age);
    }
}
