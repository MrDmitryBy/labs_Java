package com.metanit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public interface Building {

    public String getName();
    public void setName(String name);

    public Date getBuildDate();
    public void setBuildDate(Calendar calendar);

    public String getArchitect();
    public void setArchitect(String architect);

    public String getStreet();
    public void setStreet(String street);

    public int getFloors();
    public void setFloors(int floors);

    public int getPlaceQuantity();
    public void setPlaceQuantity(int placeQuantity);

    public String getDirector();
    public void setDirector(String director);

    public ArrayList getStaff();
    public void setStaff(ArrayList staff);
}
