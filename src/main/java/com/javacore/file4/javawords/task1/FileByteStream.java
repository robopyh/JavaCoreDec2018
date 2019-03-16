package com.javacore.file4.javawords.task1;

import com.javacore.file4.javawords.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class FileByteStream implements FileIO {
    @Override
    public String read(Path path) {
        final StringBuilder sb = new StringBuilder();

        try (FileInputStream fileInputStream = new FileInputStream(path.toString())) {
            int character;

            while ((character = fileInputStream.read()) != -1) {
                sb.appendCodePoint(character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    public void write(String lines, Path path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path.toString()); IntStream stream = lines.chars()) {
            stream.forEach(b -> {
                try {
                    fileOutputStream.write(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
