// Кирилло Дмитрий, 2 курс, 5 группа ММФ БГУ
// Вариант 4
// Abiturient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Оценки.
//  Создать массив объектов. Вывести:
//  a) список абитуриентов, имеющих неудовлетворительные оценки;
//  b) список абитуриентов, у которых сумма баллов выше заданной;
//  c) выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов
//      (вывести также полный список абитуриентов, имеющих полупроходную сумму).
package com.metanit;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

class Abiturient{

    static int counter=1;
    private int id;
    private String surname;
    private String name;
    private String fathername;
    private String address;
    private String phone;
    private int[] marks;

    Abiturient(){
        surname = name = fathername = phone =address = "Unknown";
        id = counter++;
    }
    Abiturient(String surname, String name, String fathername, String address, String phone, int[] marks) {
        id = counter++;
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMarks(int[] marks) {

        this.marks = marks;
    }

    public int getId(){
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFathername() {
        return fathername;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int[] getMarks() {
        return marks;
    }

    public void Show(){
        System.out.println("№"+id +". " + surname + " " + name + " " + fathername +
                "\nAdress: "  + address + "\nPhone: " + phone + "\nMarks: " + Arrays.toString(marks));
    }

    public void ShowAbiturient(){
        System.out.println("№"+id +". " + surname + " " + name + " " + fathername +
                "\nMarks: " + Arrays.toString(marks));
    }

    public void listBadMarks() {
        for(int i=0; i<getMarks().length; i++ ) {
            if(getMarks()[i]<=3) {
                ShowAbiturient();
                System.out.println("--------------------------");
                break;
            }
        }
    }

    public int listSumMarks() {
        int sum = 0;
        for(int i=0; i<getMarks().length; i++ ) {
            sum += getMarks()[i];
        }
        return sum;
    }

    public void listGoodSumMarks(int expSum) {
        if(listSumMarks()>expSum) {
            ShowAbiturient();
            System.out.println("Sum of marks: " + listSumMarks());
            System.out.println("--------------------------");
        }
    }
    public void listGoodAverageMarks() {
        DecimalFormat df2 = new DecimalFormat("#.##");
        df2.format((listSumMarks()/(double)getMarks().length));
        if((listSumMarks()/(double)getMarks().length)>=4.0) {
            ShowAbiturient();
            System.out.println("Marks average : " + df2.format((listSumMarks()/(double)getMarks().length)));
            System.out.println("--------------------------");
        }
    }
}

class AbiturientMarksComparator implements Comparator<Abiturient> {

    public int compare(Abiturient a, Abiturient b){
        if(a.listSumMarks()< b.listSumMarks())
            return 1;
        if(a.listSumMarks()> b.listSumMarks())
            return -1;
        else
            return 0;
    }
}

class AbiturientIdComparator implements Comparator<Abiturient> {

    public int compare(Abiturient a, Abiturient b){
        if(a.getId()< b.getId())
            return 1;
        if(a.getId()> b.getId())
            return -1;
        else
            return 0;
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int s = 0;
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
        System.out.println();
        System.out.println("You need to input " + n + " abiturients!");
        Abiturient [] list =new Abiturient[n];
        String abiturientSurname;
        String abiturientName;
        String abiturientFathername;
        String abiturientAddress;
        String abiturientPhone;
        for (int i = 0; i < n; i++) {
            scanner = new Scanner(System.in);
            list[i] = new Abiturient();
            System.out.print("Enter the " + (i+1) + " surname of a abiturient: ");
            abiturientSurname = scanner.nextLine();
            list[i].setSurname(abiturientSurname);
            System.out.print("Enter the " + (i+1) + " name of a abiturient: ");
            abiturientName = scanner.nextLine();
            list[i].setName(abiturientName);
            System.out.print("Enter the " + (i+1) + " fathername of a abiturient: ");
            abiturientFathername = scanner.nextLine();
            list[i].setFathername(abiturientFathername);
            System.out.print("Enter the " + (i+1) + " address of a abiturient: ");
            abiturientAddress = scanner.nextLine();
            list[i].setAddress(abiturientAddress);
            System.out.print("Enter the " + (i+1) + " phone of a abiturient: ");
            abiturientPhone = scanner.nextLine();
            list[i].setPhone(abiturientPhone);

            System.out.print("Enter quantity of marks of the " + (i+1) + " abiturient: ");
            if (scanner.hasNextInt()) {
                s = scanner.nextInt();
                if (s <= 0){
                    System.out.println("You make a mistake! Please, enter a positive integer number\nWork is over!");
                    System.exit(0);
                }
            }
            else {
                System.out.println("You make a mistake! Please, enter an integer number\nWork is over!");
                System.exit(0);
            }
            int[] abiturientMarks = new int[s];
            System.out.print("Enter numbers: ");
            for (int k = 0; k < s; k++){
                if (scanner.hasNextInt()) {
                    abiturientMarks[k] = scanner.nextInt();
                    if (abiturientMarks[k] <= 0 || abiturientMarks[k] > 10){
                        System.out.println("You make a mistake! Please, enter a positive mark(1-10)\nWork is over!");
                        System.exit(0);
                    }
                }
                else {
                    System.out.println("You make a mistake! Please, enter an integer number\nWork is over!");
                    System.exit(0);
                }
            }
            list[i].setMarks(abiturientMarks);

        }
        System.out.println("=========Abiturients=============");
        for (int i = 0; i < n; i++) {
            list[i].Show();
            System.out.println("--------------------------");
        }
        System.out.println("=========Bad Marks Abiturients=============");
        for (int i = 0; i < n; i++) {
            list[i].listBadMarks();
        }
        System.out.println("=========Good Sum Marks Abiturients=============");
        for (int i = 0; i < n; i++) {
            list[i].listGoodSumMarks(20);
        }
        System.out.println("=========Good Average Marks Abiturients=============");
        for (int i = 0; i < n; i++) {
            list[i].listGoodAverageMarks();
        }
        Comparator<Abiturient> abitComp = new AbiturientMarksComparator().thenComparing(new AbiturientIdComparator());
        TreeSet<Abiturient> abitur = new TreeSet(abitComp);
        for (int i = 0; i < n; i++) {
            abitur.add(list[i]);
        }
        System.out.println("=========COMPARATOR=============");
        int check = 2;
            for (Abiturient abit : abitur) {
                abit.ShowAbiturient();
                check--;
                if (check == 0) break;
            }
    }
}

