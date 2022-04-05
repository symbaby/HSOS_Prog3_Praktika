package com.company;

import java.io.Serializable;
import java.util.*;
import java.util.Scanner;

public class Ringpuffer <E> implements Queue<E>, Serializable, Cloneable {

    private ArrayList<E> elements;
    private ArrayList<E> readElements;
    private int writePos;
    private int readPos;
    private int capacity;
    private boolean fixedCapacity; // Legt fest ob Kapazitaet vergroestert werden darf
    private boolean discarding; // legt fest ob Elemente verwaltet werden koennen

    //zusaetzliche variablen
    private boolean ersterDurchlauf = true;
    int zaehler = 0;

    public Ringpuffer(int capacity){
        this.capacity = capacity;
        elements = new ArrayList<>(capacity);
    };

    // Hier wurde das Builderpattern genutzt. Die Initialiserung per IO Eingabe
    // war Todes nervig und kaum lesbar.
    // Mit den Builderpattern bisschen aufgeraeumt.
    public static class BufferBuilder{
        private Ringpuffer buffer;

        public BufferBuilder(int capacity){
            this.buffer = new Ringpuffer(capacity);
        }

        public BufferBuilder mitUeberschreibung(){
            this.buffer.setDiscardingTrue();
            return this;
        }

        public BufferBuilder ohneUeberschreibung(){
            this.buffer.setDiscardingFalse();
            return this;
        }

        public BufferBuilder fixeGroesse(){
            this.buffer.setFixedCapacityTrue();
            return this;
        }

        public BufferBuilder variableGroesse(){
            this.buffer.setFixedCapacityFalse();
            return this;
        }

        public Ringpuffer build(){
            return this.buffer;
        }

    }


    // Getter
    public ArrayList<E> getElements(){
        return elements;
    }

    public ArrayList<E> getReadElements(){
        return readElements;
    }

    public int getWritePos(){
        return writePos;
    }

    public int getReadPos(){
        return readPos;
    }

    public int getCapacity(){
        return capacity;
    }

    // Setter

    public void setFixedCapacityTrue(){
        fixedCapacity = true;
    }

    public void setFixedCapacityFalse(){
        fixedCapacity = false;
    }

    public void setDiscardingTrue(){
        discarding = true;
    }

    public void setDiscardingFalse(){
        discarding = false;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        if(elements.isEmpty()){
            return true;
        }else{return false;}
    }

    @Override
    public boolean offer(E e) {
        boolean istVoll = writePos - readPos == capacity;

        if(istVoll == true){
            System.out.println("Ringbuffer war voll, Daten werden zwischengespeichert");
            readElements = pollAndSafe();
            stelleUeberschreiben(e);
            return true;
        } else if(istVoll == false) {

            // Erster durchlauf der Liste, hier werden die ersten initialen Werte reingeschrieben
            if (writePos < capacity && ersterDurchlauf == true) {
                elements.add(writePos % capacity, e);
                //System.out.println(e + " wurde geaddet");
                writePos++;
                return true;
            } else {
                // Ab hier der zweite durchlauf der Liste wenn Informationen schon hinterlegt sind
                if(discarding == true || fixedCapacity == false){
                    auswahlOption(e);
                } else{
                    System.out.println("Elemente duerfen nicht ueberschrieben werden");
                    return false;
                }
            }
        }
        return  false;
    }

    @Override
    public E poll() {
        boolean isEmpty;
        isEmpty = writePos < readPos;

        if(!isEmpty){
            E nextValue = elements.get(readPos % capacity);
            readPos++;
            // System.out.println("Wurde gelesen: "+nextValue);
            return nextValue;
        }
        System.out.println("Daten wurden bereits ausgelesen");
        return null;
    }

    // Speichere die gelesenen Elemente in eine Liste und gebe sie aus
    public ArrayList<E> pollAndSafe(){
        ArrayList results = new ArrayList();
        while(readPos < writePos){
            results.add(poll());
        }
        return results;
    }

    private boolean stelleUeberschreiben(E e){
        elements.set(writePos % capacity, e);
        writePos++;
        System.out.println("Index: " + writePos%capacity + " wurde mit " + e + " ueberschrieben");
        return true;

    }

    private boolean ringpufferVergroessern(int input, E e){

        //TODO Fragen wie man es macht. Neue Zellen zwischen den Feld speichern oder hinten ranhaengen?

        int altCap = capacity;
        int newCapacity=capacity+input;


        System.out.println(newCapacity);
        ArrayList<E> neueElements = new ArrayList<E>(newCapacity);
        int pos = writePos % altCap;

        int indexAlt = 0;

        // Alle vor der SchreibPos
        for(int i = 0; i < pos; i++){
            neueElements.add(i,this.elements.get(indexAlt));
            indexAlt++;
        }

        // neue eingeschobene Felder
        for(int i = pos; i < pos+input;i++){  //KOMISCH

            if(i==pos){
                neueElements.add(i, e);
            }else{
                neueElements.add(i, null);
            }
        }

        // alte sachen hinten dran haengen
        for(int i = pos+input; i < newCapacity; i++){
            neueElements.add(i,this.elements.get(indexAlt));//FALSCH MORGEN FIXEN!!!!!!!!!
            indexAlt++;
        }

        this.ersterDurchlauf = false;
        this.writePos = (writePos-input+zaehler+1)+(2*input%newCapacity)-zaehler;
        this.zaehler++;
        this.elements = new ArrayList<E>(newCapacity);
        this.elements = neueElements;
        capacity=newCapacity;
        return true;

    }

    private boolean keineElementeEinfuegen(){
        System.out.println("Ringpuffer wurde nicht erhoeht");
        return false;
    }

    private void auswahlOption(E e){
        System.out.println("Wie moechtest du vorgehen? \n"
                + "[1] Vorhandene Elemente ueberschreiben \n" +
                "[2] Ringbuffer vergroessern \n" +
                "[3] nichts hinzufuegen");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        switch(input){
            case 1:{
                stelleUeberschreiben(e);
                break;
            }
            case 2:{
                System.out.println("Um wie viel moechtest du den Ringpuffer vergroessern?");
                scan = new Scanner(System.in);
                int anzahlFelder = scan.nextInt();
                ringpufferVergroessern(anzahlFelder, e);
                break;
            }
            case 3:{
                keineElementeEinfuegen();
                break;
            }
            default:{
                System.out.println("Gib was richtiges ein Bruder");
                auswahlOption(e);
            }
        }
    }

/*#######################################################################################################
* ############################# NICHT BENOETIGTE SACHEN #################################################
* #######################################################################################################*/

    @Override
    public boolean containsAll(Collection<?> c) { // brauchen wir nicht
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) { // brauchen wir nicht
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) { // brauchen wir nicht
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) { // brauchen wir nicht
        return false;
    }

    @Override
    public boolean contains(Object o) {  // brauchen wir nicht
        return false;
    }

    @Override
    public Iterator<E> iterator() { // brauchen wir nicht
        return null;
    }

    @Override
    public Object[] toArray() { // brauchen wir nicht
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) { // brauchen wir nicht
        return false;
    }

    @Override
    public <T> T[] toArray(T[] a) { // brauchen wir nicht
        return null;
    }

    @Override
    public E remove() {
        return null;    // brauch wir nicht
    }

    @Override
    public E element() {
        return null;  // brauchen wir nicht
    }

    @Override
    public E peek() {
        return null;    // brauchen wir nicht
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public void clear() {

    }


}
