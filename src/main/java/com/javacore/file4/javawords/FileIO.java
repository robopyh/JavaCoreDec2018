package com.javacore.file4.javawords;

import java.nio.file.Path;

public interface FileIO {
    String read(Path path);
    void write(String lines, Path path);
}
