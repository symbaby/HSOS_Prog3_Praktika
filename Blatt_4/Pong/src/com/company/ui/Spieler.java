package com.company.ui;


public class Spieler {

    private Spielfeld spielfeld;
    private Rechteck schlaeger;
    private int punkte = 0;

    public Spieler(Spielfeld spielfeld, int x, int y) {
        this.spielfeld = spielfeld;
        schlaeger = new Rechteck(x, y, spielfeld.getSpielflaeche().getBreite() / 100, spielfeld.getSpielflaeche().getHoehe() / 10);
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public Rechteck getSchlaeger() {
        return schlaeger;
    }

    public int punkteErhoehen() {
        return ++punkte;
    }

    public int getPunkte(){
        return punkte;
    }

    public void aufwaerts() {
        if (schlaeger.ueberschneidet(spielfeld.getSpielflaeche())) {
            this.schlaeger.verschieben(0, -10);
        }
    }


    public void abwaerts() {
        if (schlaeger.ueberschneidet(spielfeld.getSpielflaeche())) {
            this.schlaeger.verschieben(0, 10);
        }
    }


}
