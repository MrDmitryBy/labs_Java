package com.metanit;

import java.text.DecimalFormat;
import java.util.Arrays;

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

    public int[] getMarks() { return marks; }

    @Override
    public String toString() {
        return "Abiturient{"
                + "id= " + id + " , fullname='" + surname
                + " " + name + " " + fathername
                + "', address='" + address
                + "', phone=" + phone
                + ", marks: " + Arrays.toString(marks)
                + '}';
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
    public byte listCheckHalfSum(int expSum) {
        if(listSumMarks()==expSum) {
            return 1;
        }
        return 0;
    }
    public void listOurHalfSum(int expSum) {
        if(listSumMarks()==expSum) {
            ShowAbiturient();
            System.out.println("Sum of marks: " + listSumMarks());
            System.out.println("--------------------------");
        }
    }
}