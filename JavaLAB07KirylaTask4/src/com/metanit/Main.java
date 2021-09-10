// 4. Во всех вопросительных предложениях текста найти и напечатать без повторений слова заданной длины.

package com.metanit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Verse.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();

            String Text = sb.toString();
            System.out.println("");
            Scanner sc = new Scanner(System.in);
            int len = 0;
            boolean flag = false;
            while (!flag) {
                System.out.print("Введите длину слов, которые нужно выбрать без повторений " +
                        "из вопросительных предложений: ");
                if (sc.hasNextInt()) {
                    flag = true;
                    len = sc.nextInt();
                } else {
                    System.out.println("Ошибка: введено отличное от целочисленного значение!");
                    sc.next();
                }
            }
            sc.close();

            StringTokenizer stringTokenizer = new StringTokenizer(Text, "\n:.!?", true);
            String last = "";
            String current = "";
            String[] sentence = new String[0];
            String[] words = new String[0];

            while (stringTokenizer.hasMoreTokens()) {
                // сохраняем очередное предложение во временной переменной
                last = current;
                // получаем очередное "предложение"
                current = stringTokenizer.nextToken().trim();
                // если полученное предложение является экземпляром "?"
                if (current.equals("?") == true) {
                    // добавляем предыдущее предложение в массив предложений
                    String[] anotherSentence = new String[sentence.length + 1];
                    System.arraycopy(sentence, 0, anotherSentence, 0, sentence.length);
                    anotherSentence[sentence.length] = last + current;
                    sentence = new String[anotherSentence.length];
                    System.arraycopy(anotherSentence, 0, sentence, 0, anotherSentence.length);
                }
            }
            // вывод результатов отбора вопросительных предложегний
            if (sentence.length > 0) {
                System.out.println("\nСписок вопросительных предложений:");
                for (int i = 0; i < sentence.length; i++) {
                    System.out.println(sentence[i]);
                }

                // разбиение вопросительных предложений на слова и выборка уникальных слов указанной длины

                for (int i = 0; i < sentence.length; i++) {
                    StringTokenizer stringTokenizer2 = new StringTokenizer(sentence[i], " \n\t,.:;!?“”-\"");
                    while (stringTokenizer2.hasMoreTokens()) {
                        // получаем очередное слово
                        String tok = stringTokenizer2.nextToken().trim();
                        if (tok.length() == len) {
                            // ищем слово среди уже существующих в массиве слов
                            boolean b = false;
                            for (int j = 0; j < words.length; j++) {
                                String string = words[j];
                                // если слово найдено
                                if (string.equalsIgnoreCase(tok) == true) {
                                    b = true;
                                    break;
                                }
                            }
                            // если слово не было найдено в списке слов нужной длины
                            if (b == false) {
                                // добавляем слово в массив слов нужной длины
                                String[] dic2 = new String[words.length + 1];
                                System.arraycopy(words, 0, dic2, 0, words.length);
                                dic2[words.length] = tok;
                                words = new String[dic2.length];
                                System.arraycopy(dic2, 0, words, 0, dic2.length);
                            }
                        }
                    }
                }
                if (words.length > 0) {
                    System.out.println("Список уникальных слов указанной длины "+ len+ ":\n");
                    for (int i = 0; i < words.length; i++)
                        System.out.println(words[i]);
                } else
                    System.out.println("В вопросительных предложениях не найдено " +
                            "ни одного слово указанной длины "+ len+ ":\n");
            } else System.out.println("Не найдено ни одного вопросительного предложения!\n");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}







