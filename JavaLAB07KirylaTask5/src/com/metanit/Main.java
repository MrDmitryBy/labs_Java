package com.metanit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("HymnUSSR.txt"));

        try {
            StringBuilder sb = new StringBuilder();

            for(String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            br.close();
            String Text = sb.toString();
            System.out.println("");
            //String[] sentence = Text.split("[\\!|\\.|\\?|\\n|\\,|\\:]\\s?");
            String[] sentence = Text.split("[\\,|\\:|\\n]\\s?");
            String[] sentenceResult = new String[sentence.length];

            for(int i = 0; i < sentence.length; ++i) {
                sentenceResult[i] = sentence[i].trim().replaceAll("(?U)^(\\w+)(.*)(\\b\\w+)([.?!]?$)",
                        "$3$2$1$4");
            }

            for (String s : sentenceResult){
                System.out.println(s);
            }
        } catch (IOException var11) {
            System.out.println(var11.getMessage());
        }

    }
}