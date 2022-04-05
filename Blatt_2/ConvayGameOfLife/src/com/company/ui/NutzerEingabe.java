package com.company.ui;

import com.company.util.EinUndAusgabe;

// Aufgabe 2.2

public class NutzerEingabe {

    EinUndAusgabe io;

    private int anzahlZellen;
    private int wahrscheinlichkeit;
    private int anzahlSimulation;

    private int grenze = 10001;

    public NutzerEingabe(EinUndAusgabe io){
        this.io=io;
    }
    //GETTER
    public int anzahlZellenDesSpielfeldes(){
        System.out.println("Anzahl der Zellen eingeben: ");
        anzahlZellen = io.leseInteger();
        if(anzahlZellen>=grenze){
            System.out.println("Zahl muss kleiner sein als " + grenze);
            anzahlZellenDesSpielfeldes();
        }
        return anzahlZellen;
    };
    //GETTER
    public int wahrscheinlichkeitDerBesiedlung(){
        System.out.println("Wahrscheinlichkeit der Besiedlung eingeben: ");
        wahrscheinlichkeit= io.leseInteger();
        if(wahrscheinlichkeit<1||wahrscheinlichkeit>100){
            System.out.println("Zahl muss zwischen 1-100 liegen");
            wahrscheinlichkeitDerBesiedlung();
        }
        return wahrscheinlichkeit;
    }
    //GETTER
    public int anzahlDerSimulationsschritte(){
        System.out.println("Anzahl der Simulationschritte eingeben: ");
        anzahlSimulation = io.leseInteger();
        if(anzahlSimulation<1){
            System.out.println("Min 1 Durchlauf:");
            anzahlDerSimulationsschritte();
        }
        return anzahlSimulation;
    }

}
