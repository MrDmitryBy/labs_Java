package com.metanit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleToIntFunction;

class Region {

    private String region;
    private double square;
    private String cityCenter;
    private List<District> districtsList = new ArrayList<>();


    Region(String region, double square,String cityCenter) {
        this.region = region;
        this.square = square;
        this.cityCenter = cityCenter;
    }

    void setRegion(String region) {
        this.region = region;
    }

    void setSquare(double square) {
        this.square = square;
    }

    void setCityCenter(String cityCenter) {
        this.cityCenter = cityCenter;
    }

    void setDistrictsList(List<District> districtsList) {
        this.districtsList = districtsList;
    }

    String getRegion() {
        return region;
    }

    double getSquare() {
        return square;
    }

    String getCityCenter(){
        return cityCenter;
    }

    List<District> getDistrictsList() {
        return districtsList;
    }

    @Override
    public String toString() {
        return "region='" + region +"', square="+ square + " ; districtsList='" + districtsList + "'";
    }

    //@Override
    public boolean equals(Region regionas) {
        if (this == regionas) return true;
        if (regionas == null || getClass() != regionas.getClass()) return false;

        Region that = (Region) regionas;

        if (square != that.square) return false;
        return region.equals(that.region);
    }

    @Override
    public int hashCode() {
        int result = region.hashCode();
        result = 31 * result + (int) square;
        return result;
    }

    static Region addRegion() {
        Region region = new Region("", 0,"");
        System.out.print("Введите область: ");
        region.region = Country.strInput();
        System.out.print("Введите областной центр: ");
        region.cityCenter = Country.strInput();
        System.out.print("Введите площадь в км^2: ");
        region.square = Country.doublInput();
        System.out.print("Введите количество районов: ");
        int k = Country.numInput();
        while(k!=0){
            region.districtsList.add(District.addDistrict());
            k-=1;
        }
        return region;
    }

}