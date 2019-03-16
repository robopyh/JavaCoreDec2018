package com.javacore.file4.task4;

import com.google.common.collect.Lists;
import com.javacore.file4.task4.model.Actor;
import com.javacore.file4.task4.model.Movie;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

public class TestMovieCollection {
    private static final Path BAD_FILE = Paths.get("src", "test", "123", "Collection.ser");
    private static final Path PATH = Paths.get("src", "test", "resources", "Collection.ser");

    private static final String[] names =
            "Harrison Ford,Rutger Hauer,Sean Young,Robert Downey Jr.,Chris Evans,Scarlett Johansson".split(",");
    private static final int[] ages = {76, 75, 59, 53, 37, 34};


    private static final String[] titles = "Blade Runner,Avengers".split(",");
    private static final int[] years = {1982, 2012};
    private static final String[] genres = "Cyberpunk,Comics".split(",");
    private static final Actor[] actors = {
            new Actor(names[0], ages[0]),
            new Actor(names[1], ages[1]),
            new Actor(names[2], ages[2]),
            new Actor(names[3], ages[3]),
            new Actor(names[4], ages[4]),
            new Actor(names[5], ages[5])
    };

    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Collectible<Movie> movieCollection;
    private  Movie movie1;
    private  Movie movie2;

    @BeforeEach
    public void setUpCollection() {
        movieCollection =  new MovieCollection();

        movie1 = new Movie(
                titles[0],
                years[0],
                genres[0],
                Lists.newArrayList(actors[0], actors[1], actors[2])
        );
        movie2 = new Movie(
                titles[1],
                years[1],
                genres[1],
                Lists.newArrayList(actors[3], actors[4], actors[5])
        );

        movieCollection.addAll(movie1, movie2);

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    public void testAddAllShowAll() {
        movieCollection.printAll();

        Assertions.assertEquals(movie1.toString() + "\n" + movie2.toString(), outContent.toString()
        );
    }

    @Test
    public void testDelete() {
        movieCollection.delete(movie2);

        Assertions.assertFalse(movieCollection.delete(movie2));

        movieCollection.printAll();
        Assertions.assertEquals(movie1.toString(), outContent.toString()
        );
    }

    @Test
    public void testClearAdd() {
        movieCollection.clear();

        movieCollection.printAll();
        Assertions.assertEquals("", outContent.toString());

        movieCollection.add(movie1);
        movieCollection.printAll();
        Assertions.assertEquals(movie1.toString(), outContent.toString()
        );
    }

    @Test
    public void testSaveLoad() {
        Assertions.assertTrue(movieCollection.save(PATH));
        Collectible result = Collectible.load(PATH).get();

        Assertions.assertEquals(movieCollection, result);
    }

    @Test
    public void testSaveLoadBadFile() {
        Assertions.assertFalse(movieCollection.save(BAD_FILE));
        Assertions.assertEquals(Optional.empty(), Collectible.load(BAD_FILE));
    }

    @Test
    public void testFind() {
        Set<Movie> result = movieCollection.find("Ford");

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(movie1, result.iterator().next());
    }
}
