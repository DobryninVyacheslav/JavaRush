package ru.lvl19.task2;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter =  new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter =  new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter =  new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter =  new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter =  new FileWriter(fd);
    }

    public static void main(String[] args) {
        try {
            Path resourceDirectory = Paths.get("src/main/resources" +
                    FileConsoleWriter.class.getPackageName().replaceAll("^ru|.", "/") + "file.txt");
            FileConsoleWriter writer = new FileConsoleWriter(resourceDirectory.toAbsolutePath().toString());
            writer.write("privet".toCharArray(), 1,2);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        System.out.println(String.copyValueOf(cbuf, off, len));
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(String.copyValueOf(cbuf));
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
