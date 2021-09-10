// Кирилло Дмитрий, 2 курс, 5 группа ММФ БГУ
// Вариант 4
// Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.
//  Создать массив объектов. Вывести:
//  a) список абитуриентов, имеющих неудовлетворительные оценки;
//  b) список абитуриентов, у которых сумма баллов выше заданной;
//  c) выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов
//      (вывести также полный список абитуриентов, имеющих полупроходную сумму).
package com.metanit;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int check = 0;
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Enter the quantity of abiturients: ");
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
        System.out.println("You need to input " + n + " abiturients!");
        AbiturientList list = new AbiturientList(n);
        list.lists();
        list.Show();

        list.listBadMarks();

        list.listGoodSumMarks();

        list.listGoodAverageMarks();

        list.listComparator();

        check = list.listCheckingHalfSum();

        list.listHalfSum(check);
    }
}

