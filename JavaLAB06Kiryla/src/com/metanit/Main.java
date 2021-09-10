// Кирилло Дмитрий, 2 курс, 5 группа ММФ БГУ
// Вариант 4
// interface Здание abstract class Общественное Здание class Театр.
package com.metanit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        Building building =new Theatre("Moscow Art Theater. A.P. Chekhova",
                new GregorianCalendar(1898, Calendar.JANUARY,22), 7,
                "Kamergersky lane,1, Moscow","Fedor Shehtel","Sergey Zhenovach",
                new ArrayList<>(Arrays.asList("Konstantin Khabenskiy", "Igor Vernik","Dmitry Nazarov")),850);
        // Интерфейс не имеет метода getName, необходимо явное приведение
        String name = ((Theatre)building).getName();
        System.out.println("");
        System.out.println("Theatre name : " + name);
        System.out.println("Build date: " + building.getBuildDate());
        System.out.println("Address: " + building.getStreet());
        System.out.println("Floors: " + building.getFloors());
        System.out.println("Seats in the hall: " + building.getPlaceQuantity());
        System.out.println("Director: " + building.getDirector());
        System.out.println("Theatre actors: " + building.getStaff());
        System.out.println("Theatre architect: " + building.getArchitect());


        Theatre theatre =new Theatre("National Academic Theater named after Yanka Kupala",
                new GregorianCalendar(1920, 8,14), 5,
                "st. Engels, 7, Minsk","Karol Kozlovsky","Alexander Shestakov",
                new ArrayList<>(Arrays.asList("Maria Zakharevich", "Zoya Belohvostik",
                        "Nikolay Kirichenko")),623);

        System.out.println("");
        System.out.println("");
        System.out.println("Theatre name : " + theatre.getName());
        System.out.println("Build date: " + theatre.getBuildDate());
        System.out.println("Address: " + theatre.getStreet());
        System.out.println("Floors: " + theatre.getFloors());
        System.out.println("Seats in the hall: " + theatre.getPlaceQuantity());
        System.out.println("Director: " + theatre.getDirector());
        System.out.println("Theatre actors: " + theatre.getStaff());
        System.out.println("Theatre architect: " + theatre.getArchitect());
    }
}
