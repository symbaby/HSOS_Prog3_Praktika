package com.company.ui;

import com.company.util.Interaktionsbrett;

public class Rechteck {

    private int x;
    private int y;
    private int breite;
    private int hoehe;

    public Rechteck(int x, int y, int breite, int hoehe){
        this.x = x;
        this.y = y;
        this.breite = breite;
        this.hoehe = hoehe;

    }

    public void darstellen(Interaktionsbrett ib){
        ib.neuesRechteck(this.x,this.y,this.breite,this.hoehe);
    }


    //GETTER
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getHoehe(){
        return hoehe;
    }

    public int getBreite(){return breite;}

    public int oben() {
        return y;
    }

    /*###########################################*/

    public int unten() {
        return y + hoehe;
    }

    public int links() {
        return x;
    }

    public int rechts() {
        return x + breite;
    }

    public int mitteY() {
        return (hoehe / 2 + y);
    }

    public int mitteX() {
        return (breite / 2 + x);
    }


    // Abwischfunktion nicht vergessen
    public void verschieben(int dx, int dy){
       this.x += dx;
       this.y += dy;
    }

    // Fuer Ball Resetten
    public void verschiebenNach(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean ueberschneidet(Rechteck spielfeld){
        if (this.oben() > spielfeld.oben() && this.unten() < spielfeld.unten()) {
            return true;
        } else if(this.oben() == spielfeld.oben()){
            verschieben(0,10);
            return true;
        } else if(this.unten() == spielfeld.unten()){
            verschieben(0,-10);
            return true;
        }

        return false;
    }


    public void ausfuellen(Interaktionsbrett ib){
        for(int i = x; i<(x+ breite); i++){
            for(int j = y; j<(y+ hoehe); j++){
                ib.neuerPunkt(i, j);
            }
        }
    }
}
