package orchester;

import com.company.Main;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class Orchester implements Verhalten {

    String bezeichnung;
    Dirigent dirigent;
    HashSet <MusikerIn> musikerArray = new HashSet<>();
    Verhalten verhalten;
    String audioDateiKonzert; //hier wird der Praf der wav.Datei übergeben

    Orchester(String bezeichnung, String audioDateiKonzert){
        this.bezeichnung=bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
    }

    @Override
    public void spielen(Orchester orchester) {

    }

    public void addDirigent(Dirigent dirigent){
        this.dirigent=dirigent;
    }

    public void addMusikerIn(MusikerIn musikerin){
        this.musikerArray.add(musikerin);
    }

    public HashSet getMusikerIn(){
        return this.musikerArray;
    }

    public URL getAudiodateiKonzert(){
        URL url = Main.class.getResource(this.audioDateiKonzert);
        return url;
    }

    public void proben(Orchester orchester){
        // dafuq
    }

    public void auftreten(Orchester orchester){
        // dafuq
    }

    public void spielen(){
        // dafuq
    }
}
