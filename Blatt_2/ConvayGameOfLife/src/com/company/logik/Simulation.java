package com.company.logik;

public interface Simulation {

     void berechneAnfangsGeneration(int anzahahlDerZellen, int wahrscheinlichkeitDerBesiedlung) throws InterruptedException;

     void berechneFolgeGeneration(int berechnungsschritte);

     void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);


}
