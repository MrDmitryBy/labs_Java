package com.metanit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Country {

    private String countryName;
    private String capital;
    private List<Region> regionsList = new ArrayList<>();


    static int numInput;
    static double doublInput;
    static String strInput;

    Country(String countryName, String capital) {
        this.countryName = countryName;
        this.capital = capital;
    }

    void setCountry(String countryName) {
        this.countryName = countryName;
    }

    void setCapital(String capital) {
        this.capital = capital;
    }

    void setRegionsList(List<Region> regionsList) {
        this.regionsList = regionsList;
    }


    String getCountry() {
        return countryName;
    }

    String getCapital() {
        return capital;
    }

    List<Region> getRegionsList() {
        return regionsList;
    }


     double SumTotalSquare() {
        double total = 0;
        for(int i =0;i < regionsList.size(); i++){
            total += regionsList.get(i).getSquare();
        }
        return total;
   }

    List<String> Center() {
        List<String> centers = new ArrayList<>();
        for(int i =0;i < regionsList.size(); i++){
            centers.add(regionsList.get(i).getCityCenter());
        }
        return centers;
    }

    @Override
    public String toString() {
        return "country='" + countryName +"', capital='"+ capital + "' ; regionsList='" + regionsList + "'";
    }

    //@Override
    public boolean equals(Country country) {
        if (this == country) return true;
        if (country == null || getClass() != country.getClass()) return false;

        Country that = (Country) country;
        if (!capital.equals(that.capital)) return false;
        return countryName.equals(that.countryName);
    }

    @Override
    public int hashCode() {
        int result = countryName.hashCode();
        result = 31 * result + capital.hashCode();
        return result;
    }

    static String strInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            strInput = sc.nextLine();
        } else {
            System.out.println("Недопустимый ввод");
            strInput();
        }
        return strInput;
    }

    static int numInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            numInput = sc.nextInt();
        } else {
            System.out.println("Недопустимый ввод");
            numInput();
        }
        return numInput;
    }

    static double doublInput() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            doublInput = sc.nextDouble();
        } else {
            System.out.println("Недопустимый ввод");
            doublInput();
        }
        return doublInput;
    }

    static Country addCountry() {
        Country country = new Country("","");
        System.out.print("Введите название страны: ");
        country.countryName = Country.strInput();
        System.out.print("Введите столицу: ");
        country.capital = Country.strInput();
        System.out.print("Введите количество областей: ");
        int n = Country.numInput();
        while(n!=0){
            country.regionsList.add(Region.addRegion());
            n-=1;
        }
        return country;
    }

}