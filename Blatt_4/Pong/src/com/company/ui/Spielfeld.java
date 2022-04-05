package com.company.ui;

import com.company.util.Interaktionsbrett;

public class Spielfeld {

    private Rechteck spielflaeche;
    private Rechteck mittelLinie;
    private Interaktionsbrett ib;

    static int MARGIN_X = 150;
    static int MARGIN_Y = 150;

    int x = 0;
    int y = 0;
    int laenge = 800;
    int hoehe = 400;

    public Spielfeld(){
        spielflaeche = new Rechteck(x + MARGIN_X,y + MARGIN_Y,laenge,hoehe);
        mittelLinie = new Rechteck(spielflaeche.getX()+ (spielflaeche.getBreite()/2), spielflaeche.getY(), 1,spielflaeche.getHoehe());

    }

    public void spielfeldDarstellen(Interaktionsbrett ib){
        spielflaeche.darstellen(ib);
        mittelLinie.darstellen(ib);
    }

    public Rechteck getSpielflaeche(){
        return spielflaeche;
    }

    public Rechteck getMittelLinie(){
        return mittelLinie;
    }




}
