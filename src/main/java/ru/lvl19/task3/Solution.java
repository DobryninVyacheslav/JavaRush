package ru.lvl19.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            FileReader fileReader = new FileReader(fileName);
            fileReader.close();
            File file = new File(fileName);
            Document document = Jsoup.parse(file,"utf-8");
            document.outputSettings().prettyPrint(false);
            Elements elements = document.select(args[0]);
            for (Element element : elements) {
                System.out.println(element);
            }
        } catch (Exception e) {

        }
    }
}
