package ru.lvl19.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            String line;
            Map<String, Double> map = new HashMap<>();
            while ((line = fileReader.readLine()) != null) {
                String[] keyValue = line.split(" ");
                if (map.get(keyValue[0]) == null) {
                    map.put(keyValue[0], Double.parseDouble(keyValue[1]));
                } else {
                    double value = map.get(keyValue[0]);
                    map.put(keyValue[0], Double.parseDouble(keyValue[1]) + value);
                }
            }
            map.entrySet().stream().sorted(Map.Entry.<String,Double>comparingByKey()).
                    forEach((s) -> System.out.println(s.toString().replace("="," ")));
        } catch (IOException e) {

        }
    }
}
