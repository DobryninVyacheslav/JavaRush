package ru.lvl19.task5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        args[0] = "D:\\Program Data\\IdeaProjects\\JavaRush\\src\\main\\resources\\lvl19\\task5\\file.txt";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            Map<String, Double> map = getMap(fileReader);
            double maxValue = getMaxValue(map);
            List<String> listNames = new ArrayList<>();
            fullArrayList(map, maxValue, listNames);
            Collections.sort(listNames);
            listNames.stream().forEach(System.out::println);
        } catch (IOException e) {

        }
    }

    private static void fullArrayList(Map<String, Double> map, double maxValue, List<String> listNames) {
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() == maxValue) {
                listNames.add(pair.getKey());
            }
        }
    }

    private static double getMaxValue(Map<String, Double> map) {
        Optional<Map.Entry<String, Double>> maxEntry = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        return maxEntry.get().getValue();
    }

    private static Map<String, Double> getMap(BufferedReader fileReader) throws IOException {
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
        return map;
    }

}
