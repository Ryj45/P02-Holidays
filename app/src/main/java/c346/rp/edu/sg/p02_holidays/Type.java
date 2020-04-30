package c346.rp.edu.sg.p02_holidays;

import android.content.Context;

import java.util.ArrayList;

public class Type {
    private String type;
    private ArrayList<Holidays> holidaysArray;

    public Type(String type, ArrayList<Holidays> holidaysArray){
        this.type = type;
        this.holidaysArray =holidaysArray;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Holidays> getHolidaysArray() {
        return holidaysArray;
    }
}
