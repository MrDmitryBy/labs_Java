package com.metanit;

public class CountriesList {
    private Country [] list;
    public  CountriesList(int n){
        list = new Country[n];
    }

    public void lists() {
        for (int i = 0; i < list.length; i++) {
            list[i] = Country.addCountry();
        }
    }
    public void ShowCountries() {
        System.out.println("=========Countries=============");
        for (int i = 0; i < list.length; i++) {
            System.out.println("Страна = " + list[i].getCountry()+ " , столица = " + list[i].getCapital() + ";");
            System.out.println("Кол-во областей = " + list[i].getRegionsList().size() +
                    ", площадь страны = " + list[i].SumTotalSquare() + " км^2");
            System.out.println("Областные центры: " + list[i].Center());
            //list[i].setTotalSquare(0);
            System.out.println("--------------------------");
        }
    }

}
