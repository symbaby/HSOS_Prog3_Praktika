package orchester;
import com.company.Main;
import java.net.URL;

public class Instrument {

    // Muessen static sein
    public static final Instrument SAXOPHON = new Instrument("/Audiodateien/Baritone.wav");
    public static final Instrument SCHLAGZEUG = new Instrument("/Audiodateien/Drum.wav");
    public static final Instrument AKKORDION = new Instrument("/Audiodateien/Accordion.wav");

    public String audiodatei;

     public Instrument(String audiodatei){
        this.audiodatei = audiodatei;
    }

    public String getAudiodatei(){
         return audiodatei;
    }

    public URL getInstrumentPfad(){
         return Main.class.getResource(getAudiodatei());
    }


}
