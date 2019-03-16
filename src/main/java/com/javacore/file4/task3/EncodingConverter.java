package com.javacore.file4.task3;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;

public class EncodingConverter {
    private final Charset inEncoding;
    private final Charset outEncoding;
    private final Path in;
    private final Path out;

    public EncodingConverter(Path in, Charset inEncoding, Path out, Charset outEncoding) {
        this.inEncoding = inEncoding;
        this.outEncoding = outEncoding;
        this.in = in;
        this.out = out;
    }

    public void convert() {
        try (
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(in.toString()), inEncoding);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(out.toString()), outEncoding)
        ) {

            int character;
            while ((character = inputStreamReader.read()) != -1) {
                outputStreamWriter.write(character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
