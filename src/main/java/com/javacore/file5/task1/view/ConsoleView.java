package com.javacore.file5.task1.view;

import com.javacore.file5.task1.FileSystemController;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Class interacts with user. It receives commands and prints a result.
 */
public class ConsoleView {
    private static final String DEFAULT_PATH = "C:\\";
    private static final String PREVIOUS_DIRECTORY = "..";

    private static final Logger log = Logger.getLogger(ConsoleView.class);

    private final FileSystemController fileSystem = new FileSystemController();
    private Path path = Paths.get(DEFAULT_PATH);


    public Path getPath() {
        return path;
    }

    public void changePath(String newDirectory) {
        final Path path;

        if (PREVIOUS_DIRECTORY.equals(newDirectory)) {
            if (this.path.getParent() != null) {
                this.path = this.path.getParent();
            }
            return;
        }

        try {
            if (checkNewPath(newDirectory)) {
                path = Paths.get(newDirectory);
            } else {
                path = Paths.get(this.path.toString(), newDirectory);
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid characters");
            return;
        }

        if (fileSystem.checkDirectoryPath(path)) {
            this.path = path;
        }
    }

    public void listFiles() {
        try {
            System.out.println(fileSystem.getDirectoryFilenames(path));
        } catch (IOException e) {
            System.out.println("Error: " + e.getClass().getSimpleName());
            log.error(e);
        }
    }

    /**
     * Creates a new file.
     *
     * @param filename a new file name (might be an absolute path)
     */
    public void createFile(String filename) {
        final Path path;
        try {
            if (checkNewPath(filename)) {
                path = Paths.get(filename);
            }
            else {
                path = Paths.get(this.path.toString(), filename);
            }

            if (!fileSystem.createTextFile(path)) {
                System.out.println("Unable to create a file \"" + filename + "\"");
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid characters");
        }
    }

    /**
     * Deletes a file.
     *
     * @param filename a file name to delete (might be an absolute path)
     */
    public void deleteFile(String filename) {
        final Path path;
        try {
            if (checkNewPath(filename)) {
                path = Paths.get(filename);
            }
            else {
                path = Paths.get(this.path.toString(), filename);
            }

            if (!fileSystem.deleteTextFile(path)) {
                System.out.println("Unable to delete a file \"" + filename + "\"");
            }
        } catch (InvalidPathException e) {
            System.out.println("Invalid characters");
        }
    }

    /**
     * Edits a file content.
     *
     * @param filename a file name to edit (might be an absolute path)
     */
    public void editFile(String filename) {
        final String fileText;
        final Path path;
        try {
            if (checkNewPath(filename)) {
                path = Paths.get(filename);
            }
            else {
                path = Paths.get(this.path.toString(), filename);
            }

            fileText = fileSystem.getFileText(path);
        } catch (InvalidPathException e) {
            System.out.println("Invalid characters");
            return;
        } catch (IOException e) {
            System.out.println("Unable to open a file \"" + filename + "\"");
            log.error(e);
            return;
        }

        new FileEditDialog(path, fileText);
    }

    private boolean checkNewPath(String newDirectory) {
        return newDirectory.matches(".:\\\\.*");
    }
}