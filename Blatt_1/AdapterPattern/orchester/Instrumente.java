package orchester;

import com.company.Main;

import javax.sound.midi.Instrument;
import java.net.URL;

public class Instrumente {

    private String audiodatei(){
        return "test";
    }

    public String getAudio(){
       //muss noch definiert werden!!!
        return null;
    }

    private String instrument = null;


    // Hardcoded, ist Schrott aber fuer das Praktikum einfach mal gelassen
    public final Instrumente SAXOPHON = new Instrumente("/Audiodateien/Baritone.wav");
    public final Instrumente AKKORDION = new Instrumente("/Audiodateien/Accordion.wav");
    public final Instrumente SCHLAGZEUG = new Instrumente("/Audiodateien/Drum.wav");

    public Instrumente(String instrument){
        this.instrument = instrument;

    }

    public String  getInstrument(){
        return this.instrument;
    }



}
