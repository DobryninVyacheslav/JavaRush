package ru.lvl19.lecture11.task9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    protected static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        getContentFromFile();
    }

    private static void getContentFromFile() throws IOException {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            StringBuilder sb = new StringBuilder();
            String[] words;
            while (reader.ready()) {
                words = reader.readLine().split(" ");
                replaceNumbers(sb, words);
            }
            printText(sb);
        }
    }

    private static void replaceNumbers(StringBuilder sb, String[] words) {
        for (String word : words) {
            try {
                sb.append(map.getOrDefault(Integer.parseInt(word), word)).append(" ");
            } catch (NumberFormatException e) {
                sb.append(word).append(" ");
            }
        }
        sb.append("\n");
    }

    private static void printText(StringBuilder sb) {
        System.out.println(sb);
    }
}