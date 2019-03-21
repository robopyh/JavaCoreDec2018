package com.javacore.file5.task1;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Class provides methods for interaction with file system.
 */
public class FileSystemController{

    public static final Logger log = Logger.getLogger(FileSystemController.class);

    /**
     * Gets directory filenames.
     *
     * @param path the directory path
     * @return list of the directory filenames
     * @throws IOException if an I/O error occurs when opening the directory
     */
    public String getDirectoryFilenames(Path path) throws IOException {
        return Files.list(path)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.joining("\n"))
                .trim();
    }

    /**
     * Gets a file text.
     *
     * @param path the file path
     * @return the file text
     * @throws IOException if an I/O error occurs reading from the file or a malformed or unmappable byte sequence is read
     */
    public String getFileText(Path path) throws IOException {
        return String.join("\n", Files.readAllLines(path));
    }

    /**
     * Creates a new text file.
     *
     * @param path the file path
     * @return true if the file was created by this method; false if the file could not be created
     */
    public boolean createTextFile(Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            log.error(e);
            return false;
        }

        return true;
    }

    /**
     * Edits a text file content.
     *
     * @param path the file path
     * @param text new text
     * @return true if the file was modified by this method; false if the file could not be opened
     */
    public boolean editTextFile(Path path, String text) {
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            log.error(e);
            return false;
        }

        return true;
    }

    /**
     * Deletes a text file.
     *
     * @param path the file path
     * @return true if the file was deleted by this method; false if the file could not be deleted because it did not exist
     */
    public boolean deleteTextFile(Path path) {
        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            log.error(e);
            return false;
        }
    }

    /**
     * Checks is directory path correct.
     *
     * @param path the directory path
     * @return true if the file is a directory; false if the file does not exist, is not a directory, or it cannot be determined if the file is a directory or not.
     */
    public boolean checkDirectoryPath(Path path) {
        return  Files.isDirectory(path);
    }
}