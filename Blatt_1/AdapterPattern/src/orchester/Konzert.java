package orchester;

import adapter.SimpleAudioAdapter;
import com.company.Main;
import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class Konzert implements Verhalten{
    Orchester orchester;

    // kp ob das richtig ist. Folie 33 OOP
    // Aber methode werden erkannt. ziemlich nice

    Konzert(Orchester orchester) throws IOException {
        this.orchester = orchester;
        spielen(orchester);
    }

    @Override
    public void spielen(Orchester orchester) throws IOException {
        //SimpleAudioPlayer player = new SimpleAudioPlayer(Main.class.getResource("/Audiodateien/All_Together.wav"));
        //player.play(0);
        SimpleAudioAdapter player = new SimpleAudioAdapter();
        player.einmaligAbspielen(orchester.getAudiodateiKonzert());
    }

}
