//12. Из текста удалить все слова заданной длины, начинающиеся на согласную букву.

package com.metanit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Quote.txt"));
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
                System.out.print("Введите длину слов, которые нужно удалить все слова заданной длины, " +
                        "начинающиеся на согласную букву: ");
                if (sc.hasNextInt()) {
                    flag = true;
                    len = sc.nextInt();
                } else {
                    System.out.println("Ошибка: введено отличное от целочисленного значение!");
                    sc.next();
                }
            }
            sc.close();


        System.out.println("Исходный текст: ");
        System.out.println(Text);

        String[] strArr = Text.split(" ");//разбиваем текст на массив слов
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<strArr.length;i++){

            char first = strArr[i].charAt(0); // первая буква каждого слова

            if(!((strArr[i].length()%len==0)  &&  ((first != 'а')&&(first != 'у')&&(first != 'о')&&(first != 'ы')
                    &&(first != 'и')&&(first != 'э')&&(first != 'я')&&(first != 'ю')&&(first != 'ё')&&(first != 'е')))){

                stringBuilder.append(strArr[i]).append(" ");
            }

        }
        String outText = stringBuilder.toString().trim();

        System.out.println("Модифицированный текст (убраны слова длины "+ len +"): ");
        System.out.print(outText+" "+"\n");
    }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
