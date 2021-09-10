package com.metanit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class District {

    private String district;
    private List<City> citiesList = new ArrayList<>();


    District(String district) {
        this.district = district;
    }

    void setDistrict(String district) {
        this.district = district;
    }

    void setCitiesList(List<City> citiesList) {
        this.citiesList = citiesList;
    }

    String getDistrict() {
        return district;
    }

    List<City> getCitiesList() {
        return citiesList;
    }

    @Override
    public String toString() {
        return "district='" + district + "' ; citiesList='" + citiesList + "'";
    }
    //@Override
    public boolean equals(District districtor) {
        if (this == districtor) return true;
        if (districtor == null || getClass() != districtor.getClass()) return false;

        District that = (District) districtor;

        return district.equals(that.district);
    }

    @Override
    public int hashCode() {
        int result = district.hashCode();
        result = 31 * result;
        return result;
    }


    static District addDistrict() {
        District district = new District("");
        System.out.println("Введите райной: ");
        district.district = Country.strInput();
        System.out.print("Введите количество городов: ");
        int j = Country.numInput();
        while(j!=0){
            district.citiesList.add(City.addCity());
            j-=1;
        }
        return district;
    }
}
