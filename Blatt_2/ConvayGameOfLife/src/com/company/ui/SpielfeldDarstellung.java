package com.company.ui;
import com.company.util.*;

public class SpielfeldDarstellung {

    Interaktionsbrett ib;
    private static int MARGIN = 50;


    public SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib=ib;
    }

    public void spielfeldDarstellen(boolean [][] spielfeld){

        int x=MARGIN;
        int y=MARGIN;
        //int hoehe=spielfeld.length;
        int hoehe = 720/spielfeld.length;


        for(int i = 0;i< spielfeld.length;i++){

            for( int j =0; j< spielfeld[0].length;j++){


                Quadrat q = new Quadrat(x,y,hoehe);
                q.darstellenRahmen(ib);
                if(spielfeld[i][j]==true){
                    q.darstellenFuellung(ib);
                }
                //ERSTE ITERATION DER ZWEITEN FOR FAENGT BEI (0/0) an -> (10/0) -> (20/0) -> (30/0) -> ........... -> (100/0)
                x= x+hoehe;
            }

            x=MARGIN;
            y=y+hoehe;
            //SPRINGT IN DIE NAECHSTE Y-REIHE (0/10) an -> (10/10) -> (20/10) -> (30/10) -> ........... -> (100/10)
        }
    }



    public void abwischen(){
        ib.abwischen();
    }
}
