package com.company.ui;

import com.company.logik.BeiAenderung;
import com.company.logik.Simulator;
import com.company.util.EinUndAusgabe;
import com.company.util.Interaktionsbrett;

// Steuerung = Observer

public class Steuerung implements BeiAenderung {

    private int anzahlZellen;
    private int wahrscheinlichkeit;
    private int anzahlSimulation;

    Interaktionsbrett ib;
    EinUndAusgabe io;
    SpielfeldDarstellung  spielfeldDarstellung;
    NutzerEingabe nutzerEingabe;
    Simulator simulator;

    public void startDesSpiels(Interaktionsbrett ib) throws InterruptedException {

        this.ib=ib;
        this.intialisierung();
        this.start();
    }

    private void intialisierung() {
        simulator = new Simulator();
        simulator.anmeldenFuerAktualisierungBeiAenderung(this);
        spielfeldDarstellung=new SpielfeldDarstellung(this.ib);
        io= new EinUndAusgabe();
        nutzerEingabe = new NutzerEingabe(io);

        this.anzahlZellen=nutzerEingabe.anzahlZellenDesSpielfeldes();
        this.wahrscheinlichkeit=nutzerEingabe.wahrscheinlichkeitDerBesiedlung();
        this.anzahlSimulation=nutzerEingabe.anzahlDerSimulationsschritte();

    }


    public void start() throws InterruptedException {
        //LEGIT
        simulator.berechneAnfangsGeneration(anzahlZellen,wahrscheinlichkeit);
        spielfeldDarstellung.spielfeldDarstellen(simulator.getEinwohner());

        while(anzahlSimulation > 1) {

            spielfeldDarstellung.spielfeldDarstellen(simulator.getEinwohner());

            simulator.naechsteGeneration();
            Thread.sleep(1000);

            spielfeldDarstellung.spielfeldDarstellen(simulator.getEinwohner());
            anzahlSimulation--;
        }
    }

    @Override
    public void aktualisieren(boolean[][] neueGenerarion) {
        spielfeldDarstellung.abwischen();
        spielfeldDarstellung.spielfeldDarstellen(neueGenerarion);
        System.out.println("Hurra, aktualisiert, muesste " +  anzahlSimulation + " passieren");
    }


}



