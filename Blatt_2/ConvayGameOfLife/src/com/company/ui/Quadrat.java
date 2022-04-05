package com.company.ui;

import com.company.util.Interaktionsbrett;

public class Quadrat {

    private int x;
    private int y;
    private int seitenlaenge;

    public Quadrat(int x, int y, int seitenlaenge){
        this.x=x;
        this.y=y;
        this.seitenlaenge=seitenlaenge;
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(this.x,this.y, this.seitenlaenge, this.seitenlaenge);
    };

    public void darstellenFuellung(Interaktionsbrett ib){
        for(int i = x; i<(x+seitenlaenge);i++){
            for(int j = y; j<(y+seitenlaenge);j++){
                ib.neuerPunkt(i, j);
            }
        }
    };





}
