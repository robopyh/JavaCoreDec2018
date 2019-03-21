package com.javacore.file5.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class TestController {
    private static final String GOOD_DIRECTORY = "C:\\Users\\andre\\GNS3\\";
    private static final String BAD_DIRECTORY = "C:\\Users\\andre\\GNS4\\";
    private static final String SYSTEM_DIRECTORY = "C:\\$Recycle.Bin\\S-1-5-18";

    private static final String GOOD_FILE = "C:\\Users\\andre\\GNS3\\configs\\vpcs_base_config.txt";
    private static final String BAD_FILE = "C:\\Users\\andre\\GNS3\\config\\123.txt";

    private static final String NEW_FILENAME = "new file.txt";

    private static final String DUMMY_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras dui dui, rhoncus eget augue lobortis, fringilla rutrum orci. Maecenas facilisis tincidunt ex, nec cursus magna pellentesque ullamcorper.";

    private final FileSystemController fileSystem = new FileSystemController();

    @AfterEach
    public void deleteNewFile() {
        try {
            Files.deleteIfExists(Paths.get(NEW_FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGoodDirectoryFilenames() throws IOException {
        String result = fileSystem.getDirectoryFilenames(Paths.get(GOOD_DIRECTORY));
        assertEquals("appliances\nconfigs\nimages\nprojects\nsymbols", result);
    }

    @Test
    public void testBadDirectoryFilenames() {
        assertThrows(IOException.class, () -> fileSystem.getDirectoryFilenames(Paths.get(BAD_DIRECTORY)));
    }

    @Test
    public void testSystemDirectoryFilenames() {
        assertThrows(IOException.class,
                () -> fileSystem.getDirectoryFilenames(Paths.get(SYSTEM_DIRECTORY)));
    }

    @Test
    public void testGetGoodFileText() throws IOException {
        final String result = fileSystem.getFileText(Paths.get(GOOD_FILE));
        assertEquals("# This the configuration for %h\n" +
                "#\n" +
                "# Uncomment the following line to enable DHCP\n" +
                "# dhcp\n" +
                "# or the line below to manually setup an IP address and subnet mask\n" +
                "# ip 192.168.1.1 255.0.0.0\n" +
                "#\n" +
                "\n" +
                "set pcname %h", result);
    }

    @Test
    public void testGetBadFileText() {
        assertThrows(IOException.class, () -> fileSystem.getFileText(Paths.get(BAD_FILE)));
    }

    @Test
    public void testCreateFile() {
        final Path path = Paths.get(NEW_FILENAME);
        assertTrue(fileSystem.createTextFile(path));
    }

    @Test
    public void testCreateFileBadPath() {
        final Path path = Paths.get(BAD_DIRECTORY, NEW_FILENAME);
        assertFalse(fileSystem.createTextFile(path));
    }

    @Test
    public void testEditFile() {
        final Path path = Paths.get(NEW_FILENAME);
        createNewFile();

        assertTrue(fileSystem.editTextFile(path, DUMMY_TEXT));
    }

    @Test
    public void testEditBadFile() {
        final Path path = Paths.get(BAD_FILE);
        assertFalse(fileSystem.editTextFile(path, DUMMY_TEXT));
    }

    @Test
    public void testEditSystemFile() {
        final Path path = Paths.get(SYSTEM_DIRECTORY, NEW_FILENAME);
        assertFalse(fileSystem.editTextFile(path, DUMMY_TEXT));
    }

    @Test
    public void testDeleteFile() {
        final Path path = Paths.get(NEW_FILENAME);
        createNewFile();

        assertTrue(fileSystem.deleteTextFile(path));
    }

    @Test
    public void testDeleteBadFile() {
        final Path path = Paths.get(BAD_FILE);
        assertFalse(fileSystem.deleteTextFile(path));
    }

    @Test
    public void testDeleteSystemFile() {
        final Path path = Paths.get(SYSTEM_DIRECTORY);
        assertFalse(fileSystem.deleteTextFile(path));
    }

    private void createNewFile() {
        try {
            Files.createFile(Paths.get(NEW_FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}