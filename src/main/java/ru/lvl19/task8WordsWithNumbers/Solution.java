package ru.lvl19.task8WordsWithNumbers;

import java.io.*;

/*
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            String[] words;

            while (reader.ready()) {
                words = reader.readLine().split(" ");
                for (String word : words) {
                    if (word.matches(".[0-9].+")) {
                        writer.write(word + " ");
                    }
                }
            }
        }
    }
}
