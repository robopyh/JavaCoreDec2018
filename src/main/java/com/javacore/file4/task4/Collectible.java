package com.javacore.file4.task4;

import java.io.*;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

/**
 * The interface represents a collection of objects, that can be saved and loaded via serialization.
 *
 * @param <E> a type of collectible objects
 */
public interface Collectible <E> extends Serializable {

    void add(E e);

    void addAll(E... e);

    /**
     * Delete boolean.
     *
     * @param e an object to delete
     * @return a boolean represents deleting success
     */
    boolean delete(E e);

    void clear();

    /**
     * Print all objects to <code>System.out</> stream via <code>toString()</>.
     */
    void printAll();

    /**
     * Find set of objects whose text representations (toString()) contains <code>String str</>.
     *
     * @param str a string to search
     * @return a set of found objects
     */
    Set<E> find(String str);

    /**
     * Save current instance to a file.
     *
     * @param path a file to save
     * @return a boolean represents write success
     */
    default boolean save(Path path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Load an instance from a file.
     *
     * @param path a file to load
     * @return an optional instance
     */
    static Optional<Collectible> load(Path path) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            Object object = inputStream.readObject();
            if (object instanceof Collectible) {
                Collectible collectible = (Collectible) object;
                return Optional.of(collectible);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
