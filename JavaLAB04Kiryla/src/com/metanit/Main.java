// Кирилло Дмитрий, 2 курс, 5 группа ММФ БГУ
// Вариант 4
//Создать объект класса Государство, используя классы Область, Район, Город.
// Методы: вывести на консоль столицу, количество областей, площадь, областные центры.

package com.metanit;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Введите количество стран: ");
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
            if (n <= 0){
                System.out.println("You make a mistake! Please, enter a positive integer number\nWork is over!");
                System.exit(0);
            }
        }
        else {
            System.out.println("You make a mistake! Please, enter an integer number\nWork is over!");
            System.exit(0);
        }
        System.out.println("Вам нужно ввести " + n + " стран!");
        CountriesList list = new CountriesList(n);
        list.lists();
        list.ShowCountries();
    }
}
