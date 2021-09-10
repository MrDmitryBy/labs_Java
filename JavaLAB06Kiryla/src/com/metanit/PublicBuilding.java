package com.metanit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class PublicBuilding implements Building{

    private String name;
    private Date buildDate;
    private int floors;
    private String street;
    private String architect;


    public abstract void setDirector(String director);
    public abstract String getDirector();

    public abstract void setStaff(ArrayList staff);
    public abstract ArrayList getStaff();


    PublicBuilding(){
        this.name = "unknown";
        this.floors = 0;
        this.street = "unknown";
        this.architect = "unknown";
    }

    PublicBuilding(String name, Calendar calendar, int floors, String street, String architect) {
        this.name = name;
        this.buildDate = calendar.getTime();
        this.floors = floors;
        this.street = street;
        this.architect = architect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Calendar calendar) {
        this.buildDate = calendar.getTime();
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public String getStreet(){
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getArchitect(){
        return architect;
    }

    public void setArchitect(String architect){
        this.architect = architect;
    }
}
