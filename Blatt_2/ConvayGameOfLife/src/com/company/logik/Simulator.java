package com.company.logik;

import java.util.ArrayList;
import java.util.List;

public class Simulator implements Simulation {

// Simulator = Subjekt

    // Angemeldete beobachter werden hier gespeichert
    private List<BeiAenderung> beobachter = new ArrayList<>();

    //spaeter den array auf private mit Interfaces
    private boolean[][] einwohner;

    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) {
        // = naechste Gen andere Methode
    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beobachter.add(beiAenderung);
    }

    @Override
    public void berechneAnfangsGeneration(int anzahlZellen, int meineZahl) throws InterruptedException {
        einwohner = new boolean[(int) Math.sqrt(anzahlZellen)][(int) Math.sqrt(anzahlZellen)];

        for (int i = 0; i < einwohner.length; i++) {
            for (int j = 0; j < einwohner[0].length; j++) {
                int random = (int) (Math.random() * 100);
                einwohner[i][j] = einwohner[i][j] = meineZahl > random;
            }
        }
        naechsteGeneration();
    }

    public void benachrichtigen() throws InterruptedException {
        for(BeiAenderung b : beobachter){
            b.aktualisieren(einwohner);
        }
    }

    public void naechsteGeneration() throws InterruptedException {
        boolean[][] nextGen = new boolean[einwohner.length][einwohner[0].length];
        // naechste generation
        for(int i = 0; i < einwohner.length; i++){
            for(int k = 0; k < einwohner[0].length; k++){
                boolean status = einwohner[i][k]; // ist legit
               // System.out.println(status);
                // zaehle nachbar
                int nachbar = zaehleNachbar(einwohner,i,k);
                // Die Regeln des Game of Life
                if((status == false) && nachbar == 3){
                    nextGen[i][k] = true;
                } else if((status == true) && (nachbar < 2 || nachbar > 3)){
                    nextGen[i][k] = false;
                }else{
                    nextGen[i][k] = status;
                }
            }
        }
        // tiefe für weiterverarbeitung
       // einwohner = generationKopieren(nextGen);
        einwohner = nextGen;
        benachrichtigen();
    }


    public int zaehleNachbar(boolean[][] generation,int x,int y) {
        int num = 0;

        // Open Border Implementation weil die ecken sich nie  veraendert haben
        // Rechnen mit Restklassen , Restklassenring = laenge vom spielfeld
        for(int i = -1; i < 2; i++){
            for(int k = -1; k < 2; k++){
                int zeile = (x + i + generation.length) % generation.length;
                int spalte = (y + k + generation[0].length) % generation[0].length;
                if(generation[zeile][spalte] == true){
                    num++;
                }
            }
        }
        if( generation[x][y] == true){ num--; }
        return num;
    }


    // Tiefe Kopie
    public boolean[][] generationKopieren(boolean[][] origGen) {
        boolean[][] kopie = new boolean[origGen.length][origGen[0].length];
        for(int i = 0; i < origGen.length; i++){
            for(int k = 0; k < origGen[0].length; k++){
                kopie[i][k] = origGen[i][k];
            }
        }
        return kopie;
    }


    public boolean[][] getEinwohner(){
        return einwohner;
    }


}




