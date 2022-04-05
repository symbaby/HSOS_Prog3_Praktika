package com.company;


import com.company.ui.Steuerung;
import com.company.util.Interaktionsbrett;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*TODO Debug Methoden ab hier*/

        //EinUndAusgabe io = new EinUndAusgabe();
        /*
        NutzerEingabe e = new NutzerEingabe(io);
        Quadrat q1 = new Quadrat(25,25,40);
        q1.darstellenRahmen(ib);
        q1.darstellenFuellung(ib);
         */
        //SpielfeldDarstellung s = new SpielfeldDarstellung(ib);

       // s.abwischen();
        /*
        e.anzahlDerSimulationsschritte();
        e.anzahlZellenDesSpielfeldes();
        e.wahrscheinlichkeitDerBesiedlung();
        */

        /*TODO Fertiges Produkt ab hier*/
        Interaktionsbrett ib = new Interaktionsbrett();
        Steuerung s = new Steuerung();
        s.startDesSpiels(ib);




    }
}
