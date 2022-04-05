package audio;
import java.io.IOException;
import java.net.URL;

public interface StdAudioPlayer {

    void einmaligAbspielen(URL url) throws IOException;
    void wiederholtAbspielen(URL url, int anzahlWiederholung) throws IOException;
    boolean tonAn();
    boolean tonAus();
}
