package com.metanit;

import java.util.ArrayList;
import java.util.Calendar;

public class Theatre extends PublicBuilding {


    private String director;
    private ArrayList staff;
    private int placeQuantity;


    public int getPlaceQuantity(){
        return placeQuantity;
    };

    public void setPlaceQuantity(int placeQuantity){
        this.placeQuantity = placeQuantity;
    };

    Theatre(String name, Calendar calendar, int floors, String street, String architect,String director, ArrayList staff,
            int placeQuantity){
        super(name,calendar,floors,street,architect);
        this.placeQuantity = placeQuantity;
        this.director = director;
        this.staff = staff;
    }

    @Override
    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getDirector() {
        return director;
    }

    @Override
    public void setStaff(ArrayList staff){
        this.staff = staff;
    };

    @Override
    public ArrayList getStaff(){
        return staff;
    };
}
