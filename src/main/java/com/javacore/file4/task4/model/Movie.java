package com.javacore.file4.task4.model;

import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private final String name;
    private final int year;
    private final String genre;
    private final List<Actor> actors;

    public Movie(String name, int year, String genre, List<Actor> actors) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return String.format("%s (%s, %d)\nCast: %s", name, genre, year, actors.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                Objects.equal(name, movie.name) &&
                Objects.equal(genre, movie.genre) &&
                Objects.equal(actors, movie.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, year, genre, actors);
    }
}
