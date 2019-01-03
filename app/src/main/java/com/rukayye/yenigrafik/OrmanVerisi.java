package com.rukayye.yenigrafik;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class OrmanVerisi {
    private String agacTipi;
    private String yil;
    private ArrayList<Entry> entries;

    public String getAgacTipi() {
        return agacTipi;
    }

    public void setAgacTipi(String agacTipi) {
        this.agacTipi = agacTipi;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }

    public void setEntries(ArrayList<Entry> entries) {
        this.entries = entries;
    }
}
