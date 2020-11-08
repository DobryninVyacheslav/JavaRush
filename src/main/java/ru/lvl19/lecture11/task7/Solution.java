package ru.lvl19.lecture11.task7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static final List<String> words = new ArrayList<>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }


    public static void main(String[] args) throws IOException {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            while(reader.ready()) {
                String line = reader.readLine();
                String[] wordsInLine = line.split(" ");
                int count = 0;
                for (String s : wordsInLine) {
                    if (words.contains(s)) count++;
                }
                if (count == 2) System.out.println();
            }
        }
    }
}
