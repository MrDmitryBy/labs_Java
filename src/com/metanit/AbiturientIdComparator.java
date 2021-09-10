package com.metanit;

import java.util.Comparator;

class AbiturientIdComparator implements Comparator<Abiturient> {

    public int compare(Abiturient a, Abiturient b){
        if(a.getId()< b.getId())
            return 1;
        if(a.getId()> b.getId())
            return -1;
        else
            return 0;
    }
}