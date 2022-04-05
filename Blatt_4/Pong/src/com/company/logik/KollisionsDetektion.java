package com.company.logik;

import com.company.ui.Ball;
import com.company.ui.Spieler;
import com.company.ui.Spielfeld;

import java.util.Random;

public class KollisionsDetektion {
    Ball ball;
    Spielfeld spielfeld;
    Spieler spielerLeft;
    Spieler spielerRight;

    KollisionsDetektion(Ball ball, Spielfeld spielfeld, Spieler spielerLeft, Spieler spielerRight){
        this.ball = ball;
        this.spielfeld = spielfeld;
        this.spielerLeft = spielerLeft;
        this.spielerRight = spielerRight;
    }


    public boolean checkBeruehrungBallSpielfeldGrenzen(Ball ball){
        if (spielfeld.getSpielflaeche().oben() < ball.getForm().oben()
                && spielfeld.getSpielflaeche().unten() > ball.getForm().unten()
                && spielfeld.getSpielflaeche().rechts() > ball.getForm().rechts()
                && spielfeld.getSpielflaeche().links() < ball.getForm().links()) {
            return true;


        } else if(spielfeld.getSpielflaeche().oben() == ball.getForm().oben()){
            // new trajectory
            ball.umkehrenDerBewegungInY();
            return true;


        } else if(spielfeld.getSpielflaeche().unten() == ball.getForm().unten()){
            // new trajectory
            ball.umkehrenDerBewegungInY();
            return true;



        } else if(spielfeld.getSpielflaeche().links() >= ball.getForm().links()){

            // Ball bei Tor verschieben
            ball.getForm().verschiebenNach(spielfeld.getSpielflaeche().mitteX()-spielfeld.getSpielflaeche().getBreite() / 100,
                    spielfeld.getSpielflaeche().mitteY() - spielfeld.getSpielflaeche().getBreite() / 100);
            abprallen(ball);
            spielerRight.punkteErhoehen();



        } else if(spielfeld.getSpielflaeche().rechts() <= ball.getForm().rechts()){

            // Ball bei Tor verschieben
            ball.getForm().verschiebenNach(spielfeld.getSpielflaeche().mitteX()-spielfeld.getSpielflaeche().getBreite() / 100,
                    spielfeld.getSpielflaeche().mitteY() - spielfeld.getSpielflaeche().getBreite() / 100);
            abprallen(ball);
            spielerLeft.punkteErhoehen();
        }
        return true;
    }


    public boolean checkBeruehrungBallSchlaeger(Ball ball){
        if(spielerLeft.getSchlaeger().rechts()<ball.getForm().links() && spielerRight.getSchlaeger().links()>ball.getForm().rechts()){
            return true;

        }else if(spielerLeft.getSchlaeger().rechts() >= ball.getForm().links()
                && spielerLeft.getSchlaeger().oben()<= ball.getForm().unten()
                && spielerLeft.getSchlaeger().unten()>= ball.getForm().oben()){

            // new trajectory
            abprallen(ball);
            return true;


        } else if(spielerRight.getSchlaeger().links() <= ball.getForm().rechts()
                && spielerRight.getSchlaeger().oben()<= ball.getForm().unten()
                && spielerRight.getSchlaeger().unten()>= ball.getForm().oben()){

            // new trajectory
            abprallen(ball);
            return true;
        }

        return true;
    }


    public void abprallen(Ball ball){
        Random random = new Random();
        if(random.nextInt(100)+1 < 50){
            ball.umkehrenDerBewegungInX();
        } else {
            ball.umkehrenDerBewegungInX();
            ball.umkehrenDerBewegungInY();
        }
    }

}
