package com.company.ui;

import com.company.logik.KollisionsDetektion;
import com.company.util.Interaktionsbrett;

import java.awt.image.Kernel;

public class Ball {


    Rechteck form;
    Spielfeld spielfeld;

    int bewegungInXProFrame;
    int bewegungInYProFrame;


    public Ball(Spielfeld spielfeld){
        this.spielfeld = spielfeld;
        form = new Rechteck((spielfeld.getSpielflaeche().mitteX())-spielfeld.getSpielflaeche().getBreite() / 100,
                            spielfeld.getSpielflaeche().mitteY() - spielfeld.getSpielflaeche().getBreite() / 100,
                        spielfeld.getSpielflaeche().getBreite() / 50,
                        spielfeld.getSpielflaeche().getBreite() / 50);

        bewegungInXProFrame = 1;
        bewegungInYProFrame = 1;
    }


    public void bewegen(int anzahlFrames, KollisionsDetektion kollisionsDetektion){
        for(int i = 0; i < anzahlFrames; i++) {
            if(kollisionsDetektion.checkBeruehrungBallSpielfeldGrenzen(this)&&kollisionsDetektion.checkBeruehrungBallSchlaeger(this)){
                form.verschieben(bewegungInXProFrame, bewegungInYProFrame);
            }

        }
    }


    public void darstellen(Interaktionsbrett ib){
        form.darstellen(ib);
        form.ausfuellen(ib);
    }


    public Rechteck getForm(){
        return form;
    }

    public void umkehrenDerBewegungInX(){
       if(bewegungInXProFrame < 0 ){
           bewegungInXProFrame = 4;
       } else{
           bewegungInXProFrame = -4;
       }
    }

    public void umkehrenDerBewegungInY(){
        if(bewegungInYProFrame < 0){
            bewegungInYProFrame = 1;
        } else{
            bewegungInYProFrame = -1;
        }
    }


}
