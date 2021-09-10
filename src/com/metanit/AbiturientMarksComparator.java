package com.metanit;

import java.util.Comparator;

class AbiturientMarksComparator implements Comparator<Abiturient> {

    public int compare(Abiturient a, Abiturient b){
        if(a.listSumMarks()< b.listSumMarks())
            return 1;
        if(a.listSumMarks()> b.listSumMarks())
            return -1;
        else
            return 0;
    }
}
