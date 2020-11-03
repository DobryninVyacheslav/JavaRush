package ru.lvl19.task7;

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
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            int countWords = 0;
            String[] values;
            String line;
            while (reader.ready()) {
                line = reader.readLine();
                values = line.split(" ");

                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < words.size(); j++) {
                        if (values[i].equals(words.get(j)))
                            countWords++;
                    }
                }

                if (countWords == 2) {
                    System.out.println(line);
                }
                countWords = 0;
            }
        }
    }
}