package com.javacore.file5.task1;

import com.javacore.file5.task1.view.ConsoleView;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestView {

    private static final String INVALID_CHARACTERS_PATH = "C:\\<>!^&*>\\1@#$_)_+2";
    private static final String BAD_NEW_PATH = "C:\\1234\\12";
    private static final String SYSTEM_NEW_PATH = "C:\\$Recycle.Bin\\S-1-5-18";
    private static final String GOOD_NEW_PATH = "D:\\Java";
    private static final String GOOD_NEW_DIRECTORY = "Users";
    private static final String GOOD_MULTIPLE_DIRECTORIES = "Users\\andre";
    private static final String PREVIOUS_DIRECTORY = "..";

    private static final String NEW_FILE_NAME = "file.txt";
    private static final String INVALID_CHARACTERS_FILE_NAME = "@$%^&*(ADAD><.txt";

    private final ConsoleView consoleView = new ConsoleView();

    @Test
    public void testCD() {
        consoleView.changePath(INVALID_CHARACTERS_PATH);
        assertEquals("C:\\", consoleView.getPath().toString());

        consoleView.changePath(BAD_NEW_PATH);
        assertEquals("C:\\", consoleView.getPath().toString());

        consoleView.changePath(GOOD_NEW_DIRECTORY);
        assertEquals("C:\\Users", consoleView.getPath().toString());

        consoleView.changePath(PREVIOUS_DIRECTORY);
        assertEquals("C:\\", consoleView.getPath().toString());

        consoleView.changePath(GOOD_MULTIPLE_DIRECTORIES);
        assertEquals("C:\\Users\\andre", consoleView.getPath().toString());

        consoleView.changePath(GOOD_NEW_PATH);
        assertEquals("D:\\Java", consoleView.getPath().toString());
    }

    @Test
    public void testListDirectoryFiles() {
        consoleView.changePath(GOOD_NEW_PATH);
        consoleView.listFiles();

        consoleView.changePath(SYSTEM_NEW_PATH);
        consoleView.listFiles();
    }

    @Test
    public void testMakeFile() {
        deleteTestFile();
        consoleView.changePath(GOOD_NEW_PATH);
        consoleView.createFile(NEW_FILE_NAME);

        deleteTestFile();
        consoleView.changePath(SYSTEM_NEW_PATH);
        consoleView.createFile(NEW_FILE_NAME);

        consoleView.createFile(INVALID_CHARACTERS_FILE_NAME);
    }

    @Test
    public void testDeleteFile() {
        createTestFile();
        consoleView.changePath(GOOD_NEW_PATH);
        consoleView.deleteFile(NEW_FILE_NAME);

        createTestFile();
        consoleView.changePath(SYSTEM_NEW_PATH);
        consoleView.deleteFile(NEW_FILE_NAME);

        consoleView.deleteFile(INVALID_CHARACTERS_FILE_NAME);
    }

    private void createTestFile() {
        try {
            Files.createFile(Paths.get(GOOD_NEW_PATH, NEW_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteTestFile() {
        try {
            Files.deleteIfExists(Paths.get(GOOD_NEW_PATH, NEW_FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}