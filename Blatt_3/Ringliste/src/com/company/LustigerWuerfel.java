package com.company;

public class LustigerWuerfel {
    int x = 2;
    int y = 2;
    int seitenlaenge = 2;
    String eigenschaft;


    LustigerWuerfel(String eigenschaft){
        this.x = x++;
        this.y = y++;
        this.seitenlaenge = seitenlaenge++;
        this.eigenschaft = eigenschaft;
    }

    @Override
    public String toString(){
        return "Lustiger Wuerfel: x :" + this.x+ " y: " + this.y + " Seitenlanege: "+ this.seitenlaenge+" Eigenschaft:"+ this.eigenschaft;
    }
}
