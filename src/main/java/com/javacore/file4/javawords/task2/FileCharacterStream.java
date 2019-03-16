package com.javacore.file4.javawords.task2;

import com.javacore.file4.javawords.FileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;

public class FileCharacterStream implements FileIO {
    @Override
    public String read(Path path) {
        final StringBuilder sb = new StringBuilder();

        try (FileReader fileReader = new FileReader(path.toString())) {
            int character;

            while ((character = fileReader.read()) != -1) {
                sb.append((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    @Override
    public void write(String lines, Path path) {
        try (FileWriter fileWriter = new FileWriter(path.toString()); IntStream stream = lines.chars()) {
            stream.forEach(b -> {
                try {
                    fileWriter.write(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
