package ru.lvl19.task3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = fileReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            consoleReader.close();
            fileReader.close();

            Document document = Jsoup.parse(stringBuilder.toString(),"utf-8", Parser.xmlParser());
            document.outputSettings().prettyPrint(false);
            Elements elements = document.select(args[0]);
            for (Element element : elements) {
                System.out.println(element);
            }
        } catch (Exception e) {

        }
    }
}
