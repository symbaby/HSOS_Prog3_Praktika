package com.company.logik;

import com.company.ui.Ball;
import com.company.ui.Spieler;
import com.company.ui.Spielfeld;
import com.company.util.Interaktionsbrett;

public class PongSpiel {
    private Interaktionsbrett ib;
    private Spieler spielerLinks;
    private Spieler spielerRechts;
    private Spielfeld spielfeld;
    private Ball ball;
    private KollisionsDetektion kollisionsDetektion;

    public PongSpiel(){
        ib = new Interaktionsbrett();
        ib.willTasteninfo(this);
        startAufstellung();
    }

    public void startAufstellung(){
        spielfeld = new Spielfeld();
        ball =  new Ball(spielfeld);
        spielerLinks = new Spieler(spielfeld,spielfeld.getSpielflaeche().getX() +20,spielfeld.getSpielflaeche().getY()*2);
        spielerRechts = new Spieler(spielfeld,spielfeld.getSpielflaeche().getX() + spielfeld.getSpielflaeche().getBreite() -30 ,spielfeld.getSpielflaeche().getY()*2);
        kollisionsDetektion = new KollisionsDetektion(ball,spielfeld,spielerLinks,spielerRechts);
    }

    public void spielen() throws InterruptedException {

        int fps = 60;
        int realFPS = 1000/fps;

        while(true){

            ib.textZeigen("Spieler 1 Punkte: " + spielerLinks.getPunkte() +  " | " + "Spieler 2 Punkte: " + spielerRechts.getPunkte());
            if(spielerLinks.getPunkte() >= 2 || spielerRechts.getPunkte() >= 2){
                if(spielerLinks.getPunkte() >= 2){
                    ib.textZeigen("Spieler 1 hat gewonnen!");
                } else if(spielerRechts.getPunkte() >= 2){
                    ib.textZeigen("Spieler 2 hat gewonnen!");
                }
                break;
            } else{
                ib.abwischen();
                spielfeld.spielfeldDarstellen(ib);

                spielerLinks.getSchlaeger().darstellen(ib);
                spielerRechts.getSchlaeger().darstellen(ib);

                spielerLinks.getSchlaeger().ausfuellen(ib);
                spielerRechts.getSchlaeger().ausfuellen(ib);


                ball.bewegen(1,kollisionsDetektion);
                ball.darstellen(ib);


                Thread.sleep(realFPS);
            }
        }
    }

    public void tasteGedrueckt(String input) {
        switch (input) {
            case "k":{
                spielerRechts.aufwaerts();
                break;
            }

            case "m":{
                spielerRechts.abwaerts();
                break;
            }


            case "a":{
                spielerLinks.aufwaerts();
                break;
            }


            case "y":{
                spielerLinks.abwaerts();
                break;
            }


            case "e":{
                System.out.println("Spiel wurde abgebrochen");
                System.exit(1);
                break;
            }
        }
    }

    public Spieler getSpielerLinks(){
        return spielerLinks;
    }

    public Spieler getSpielerRechts(){
        return spielerRechts;
    }
}
