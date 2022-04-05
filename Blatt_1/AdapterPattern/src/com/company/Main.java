package com.company;

import Aufgabe_1.Nachbar;
import adapter.SimpleAudioAdapter;
import de.hsos.prog3.audio.SimpleAudioPlayer;
import orchester.*;


import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Main app = new Main();

        /*TODO Kommentare entfernen um Aufgabe 1 zu starten*/
        //app.Aufgabe_1();


        /* TODO Kommentare entfernen um Aufgabe 1.3 zu starten*/
        /*
        URL instrument = app.Instrumentauswahl();
        app.abspielOptionen(instrument);
*/


        String audioDatei = "/Audiodateien/All_Together.wav";

        Orchester o = new Orchester("Frittenficker", audioDatei);

        Dirigent klotz = new Dirigent("Klotz");
        o.addDirigent(klotz);

        Musiker trompete = new Musiker("Thigma", Instrument.SAXOPHON);
        Musiker akkordion = new Musiker("Miro", Instrument.AKKORDION);
        Musiker trommel = new Musiker("Patrick", Instrument.SCHLAGZEUG);

        o.addMusiker(trompete);
        o.addMusiker(akkordion);
        o.addMusiker(trommel);

        //System.out.println(o.getAudiodateiKonzert());
        //System.out.println(o.getBezeichnung());

        o.auftritt();
        o.proben();

        o.alleMusiker();
        System.out.println(o.getBezeichnung());

        //System.out.println(trompete.getInstrument().getInstrumentPfad());


    }

    public void Aufgabe_1(){
        /* Als Collection das HashSet genommen da ich keine Duplikate haben moechte*/
        HashSet<Nachbar> list = new HashSet<>();

        list.add(new Nachbar("Berkan", "Yildiz"));
        list.add(new Nachbar("Berkan", "Yildiz"));
        list.add(new Nachbar("Maximilian", "Jaesch"));
        list.add(new Nachbar("Tim", "Cirksena"));
        list.add(new Nachbar("Johannes", "Belaschow"));
        list.add(new Nachbar("Abdu","Azatemuer"));

        /* HashSet Collection mit ueberladener toString ausgeben */
        System.out.println(list);


    }

    public void Aufgabe_1_3_DEBUG() throws IOException {
        URL url = Main.class.getResource("/Audiodateien/Baritone.wav");
        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        player.setDebug(false);
        player.verboseLogging(true);
        player.play(0);
    }

    public URL Instrumentauswahl(){

        System.out.println("Willkommen in Praktikumsaufgabe 1.3" + "\n" +
                "Bitte Instrument auswaehlen:" + "\n" +
                "1. Accordion, 2. Baritone, 3. Drum, 4. All Together");

        Scanner io = new Scanner(System.in);
        int input = io.nextInt();



        switch(input){
            case 1:{
                URL url = Main.class.getResource("/Audiodateien/Accordion.wav");
                System.out.println("Accordion wurde ausgewaehlt.");
                return url;
            }
            case 2:{
                URL url = Main.class.getResource("/Audiodateien/Baritone.wav");
                System.out.println("Baritone wurde ausgewaehlt.");
                return url;
            }
            case 3:{
                URL url = Main.class.getResource("/Audiodateien/Drum.wav");
                System.out.println("Drum wurde ausgewaehlt.");
                return url;
            }
            case 4:{
                URL url = Main.class.getResource("/Audiodateien/All_Together.wav");
                System.out.println("All Together wurde ausgewaehlt.");
                return url;
            }
            case 5:{
                System.out.println("Bitte Instrument auswaehlen");
            }
        }
        return null;

    }

    public void abspielOptionen(URL url) throws IOException {
        Scanner ioInt = new Scanner(System.in);
        SimpleAudioAdapter player = new SimpleAudioAdapter();

        System.out.println("Soll Ton abgespielt werden?   0=Nein, 1=Ja");
        int input = ioInt.nextInt();

        if(input == 0){
            player.tonAus();
        } else{
            player.tonAn();
        }


        System.out.println("Wie oft soll das Instrument abgespielt werden? 1 - n");
        input = ioInt.nextInt();

        if(input > 1){
            System.out.println("Spiele " + input + "mal ab");
            player.wiederholtAbspielen(url,input);
        } else{
            System.out.println("Spiele einmalig ab");
            player.einmaligAbspielen(url);
        }
    }

}
