package com.company;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EinUndAusgabe io = new EinUndAusgabe();


        Main app = new Main();

        Ringpuffer debug = new Ringpuffer.BufferBuilder(5)
                .mitUeberschreibung()
                .variableGroesse()
                .build();


        Ringpuffer a = new Ringpuffer.BufferBuilder(10)
                .fixeGroesse()
                .mitUeberschreibung()
                .build();


        Ringpuffer b = new Ringpuffer.BufferBuilder(10)
                .variableGroesse()
                .ohneUeberschreibung()
                .build();




        // Aussuchen was wir zeigen wollen
        //app.inputPerString(debug);
        //app.inputPerInt(debug);
        app.alleInputMoeglichkeiten(debug);

    }

    // Print All
    private void leseAktuelleEintraege(ArrayList zuLesende){
        System.out.println("Elemente die aktuell im Ringbuffer sind: ");
        for(int i = 0; i < zuLesende.size(); i++ ){
            System.out.print(zuLesende.get(i) + " || ");
        }
        System.out.println("");
    }

    // gepollte Elemente
    private  void ausgeleseneElementeAusgeben(ArrayList zuLesende){
        System.out.println("Elemente die ausgelesen worden sind: ");
        for(int i = 0; i < zuLesende.size(); i++){
            System.out.print(zuLesende.get(i) + ", ");
        }
        System.out.println("");
    }

    private void inputPerInt(Ringpuffer ring){
        int input = 0;


            System.out.println("Elemente mit Zahlen fuellen");
            Scanner scan = new Scanner(System.in);
            input = scan.nextInt();

            ring.offer(input);
            leseAktuelleEintraege(ring.getElements());
    }


    private void inputPerString(Ringpuffer ring){
        EinUndAusgabe io = new EinUndAusgabe();


        String input;
        System.out.println("Elemente mit String fuellen");
        input = io.leseString();
        ring.offer(input);
        leseAktuelleEintraege(ring.getElements());
    }

    private void inputLustigerWuerfel(Ringpuffer ring){
        LustigerWuerfel boese = new LustigerWuerfel("boese");
        LustigerWuerfel traurig = new LustigerWuerfel("traurig");
        LustigerWuerfel gluecklich = new LustigerWuerfel("gluecklich");


        System.out.println("Waehle einen Wuerfel:");
        System.out.println("1) boeser Wuerfel:");
        System.out.println("2) trauriger Wuerfel:");
        System.out.println("3) gleucklicher Wuerfel:");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch(input){
            case 1:
                ring.offer(boese);
                leseAktuelleEintraege(ring.getElements());
                break;
            case 2:
                ring.offer(traurig);
                leseAktuelleEintraege(ring.getElements());
                break;
            case 3:
                ring.offer(gluecklich);
                leseAktuelleEintraege(ring.getElements());
                break;
            default:
                System.out.println("Keine gueltige Eingabe!");
                inputLustigerWuerfel(ring);
        }

    }

    private void alleInputMoeglichkeiten(Ringpuffer ring){
        int inpt = 0;

        while(inpt != -1){
            System.out.println("1) String einfuegen");
            System.out.println("2) Integer einfuegen");
            System.out.println("3) LustigenWuerfel einfuegen");
            Scanner scan = new Scanner(System.in);
            inpt = scan.nextInt();

            switch (inpt){
                case 1:
                    inputPerString(ring);
                    break;
                case 2:
                    inputPerInt(ring);
                    break;
                case 3:
                    inputLustigerWuerfel(ring);
                    break;
                default:
                    System.out.println("Programm wurde beendet");
            }

        }
    }


}





