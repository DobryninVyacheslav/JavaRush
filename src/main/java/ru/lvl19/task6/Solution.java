package ru.lvl19.task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
/*
Хуан Хуанович
*/
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while (reader.ready()) {
                line = reader.readLine();

                PEOPLE.add(new Person(
                        line.replaceAll("\\d", "").trim(),
                        format.parse(line.replaceAll("\\D", " ").trim())
                ));
            }
        }
    }
}

