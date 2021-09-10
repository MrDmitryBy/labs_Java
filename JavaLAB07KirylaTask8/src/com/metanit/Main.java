//8. Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном порядке по первой согласной букве слова.


package com.metanit;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static boolean startsWithVovel(String s) {
        return s.length() > 0 && !CompareByFirstConsonant.isConsonant(s.charAt(0));
    }
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("Song.txt"));

        try {
            StringBuilder sb = new StringBuilder();

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            br.close();
            String Text = sb.toString();
            System.out.println("");
            System.out.println("Текст песни: ");
            System.out.println(Text);
            List<String> words = new LinkedList<String>(Arrays.asList(Text.split("[\\s\\p{Punct}]+")));
            Collections.sort(words, CompareByFirstConsonant.getInstance());

            for (ListIterator<String> iterator = words.listIterator(); iterator.hasNext(); ) {
                if (!startsWithVovel(iterator.next()))
                    iterator.remove();
            }

            System.out.println(words);
        }
        catch (IOException var11) {
            System.out.println(var11.getMessage());
        }
    }
}
