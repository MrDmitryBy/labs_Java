package com.metanit;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class AbiturientList {

    int halfSum = 0;
    int checkHalfSum = 0;
    private Abiturient [] list;
    public  AbiturientList(int n){
        list = new Abiturient[n];
    }

    public void lists() {

        int s = 0;
        String abiturientSurname;
        String abiturientName;
        String abiturientFathername;
        String abiturientAddress;
        String abiturientPhone;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < list.length; i++) {
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
    }
        public void Show(){
            System.out.println("=========Abiturients=============");
            for (int i = 0; i < list.length; i++) {
                list[i].Show();
                System.out.println("--------------------------");
            }
        }
        public void listBadMarks() {
            System.out.println("=========Bad Marks Abiturients=============");
            for (int i = 0; i < list.length; i++) {
              list[i].listBadMarks();
            }
        }
        public void listGoodSumMarks() {
            System.out.println("=========Good Sum Marks Abiturients=============");
            for (int i = 0; i < list.length; i++) {
                list[i].listGoodSumMarks(20);
            }
        }
        public void listGoodAverageMarks() {
            System.out.println("=========Good Average Marks Abiturients=============");
            for (int i = 0; i < list.length; i++) {
                list[i].listGoodAverageMarks();
            }
        }
        public void listComparator() {
            Comparator<Abiturient> abitComp = new AbiturientMarksComparator().thenComparing(new AbiturientIdComparator());
            TreeSet<Abiturient> abitur = new TreeSet(abitComp);
            for (int i = 0; i < list.length; i++) {
                abitur.add(list[i]);
            }
            System.out.println("=========COMPARATOR=============");
            int check = 2;
            for (Abiturient abit : abitur) {
                halfSum = abit.listSumMarks();
                abit.ShowAbiturient();
                check--;
                if (check == 0) break;
            }
        }
        public int listCheckingHalfSum(){
            for (int i = 0; i < list.length; i++) {
                if(list[i].listCheckHalfSum(halfSum) == 1)
                    checkHalfSum++;
            }
            return checkHalfSum;
        }
        public void listHalfSum(int checkout){
        if (checkout == 1){
            System.out.println("========There is no Abiturients with Half sum=============");
        }
        else {
            System.out.println("========Half sum Abiturients=============");
            System.out.println("Half sum: " + halfSum);
            for (int i = 0; i < list.length; i++) {
                list[i].listOurHalfSum(halfSum);
            }
        }
        }
}
