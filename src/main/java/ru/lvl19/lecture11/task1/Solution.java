package ru.lvl19.lecture11.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        try {
            String[] fileNames = readFileNames();
            BufferedReader readerF1 = new BufferedReader(new FileReader(fileNames[0]));
            BufferedReader readerF2 = new BufferedReader(new FileReader(fileNames[1]));
            List<String> file1 = getFileText(readerF1);
            List<String> file2 = getFileText(readerF2);
            int i = 0;
            int j = 0;
            while (i < file1.size() && j < file2.size()) {
                if (file1.get(i).equals(file2.get(j))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    i++;
                    j++;
                } else {
                    if (j + 1 < file2.size() && file1.get(i).equals(file2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, file2.get(j)));
                        j++;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                        i++;
                    }
                }
            }
            if (i < file1.size()) lines.add(new LineItem(Type.REMOVED, file1.get(i)));
            if (j < file2.size()) lines.add(new LineItem(Type.ADDED, file2.get(j)));

            for (LineItem line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String[] readFileNames() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String firstFileName = reader.readLine();
            String secondFileName = reader.readLine();
            return new String[]{firstFileName, secondFileName};
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    private static ArrayList<String> getFileText(BufferedReader reader) {
        try (reader) {
            ArrayList<String> text = new ArrayList<>();
            while (reader.ready()) {
                text.add(reader.readLine());
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
