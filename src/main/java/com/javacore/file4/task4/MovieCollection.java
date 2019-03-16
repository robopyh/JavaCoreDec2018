package com.javacore.file4.task4;

import com.google.common.base.Objects;
import com.javacore.file4.task4.model.Movie;

import java.util.*;

public class MovieCollection implements Collectible<Movie>{
    private final Set<Movie> movieSet = new LinkedHashSet<>();

    @Override
    public void add(Movie movie) {
        movieSet.add(movie);
    }

    @Override
    public void addAll(Movie... movies) {
        movieSet.addAll(Arrays.asList(movies));
    }

    @Override
    public boolean delete(Movie movie) {
        if (movieSet.contains(movie)) {
            movieSet.remove(movie);
            return true;
        }

        return false;
    }

    @Override
    public void clear() {
        movieSet.clear();
    }

    @Override
    public void printAll() {
        StringBuilder sb = new StringBuilder();
        for (Movie movie : movieSet) {
            sb.append(movie.toString()).append("\n");
        }
        System.out.print(sb.toString().trim());
    }

    @Override
    public Set<Movie> find(String str) {
        final Set<Movie> result = new HashSet<>();

        for (Movie movie : movieSet) {
            if (movie.toString().contains(str)) {
                result.add(movie);
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCollection that = (MovieCollection) o;
        return Objects.equal(movieSet, that.movieSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(movieSet);
    }
}
