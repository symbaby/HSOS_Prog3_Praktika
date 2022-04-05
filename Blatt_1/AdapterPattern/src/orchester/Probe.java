package orchester;

import adapter.SimpleAudioAdapter;
import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.util.HashSet;

public class Probe implements Verhalten{

    // kp ob das richtig ist. Folie 33 OOP

    Orchester orchester;

    public Probe(Orchester orchester) throws IOException {
        this.orchester = orchester;
        spielen(orchester);
    }

    @Override
    public void spielen(Orchester orchester) throws IOException {
        SimpleAudioAdapter player = new SimpleAudioAdapter();
        for(Musiker m : orchester.musikerListe){
            System.out.println(m.getName());
            player.einmaligAbspielen(m.getInstrument().getInstrumentPfad());
        }
    }
}
