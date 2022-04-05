package adapter;

import audio.StdAudioPlayer;
import de.hsos.prog3.audio.SimpleAudioPlayer;

import java.io.IOException;
import java.net.URL;

public class SimpleAudioAdapter implements StdAudioPlayer {

    private boolean ton = true;

    @Override
    public void einmaligAbspielen(URL url) throws IOException {
        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        if(ton==true){
            player.setDebug(false);
            player.verboseLogging(true);
        } else{
            player.setDebug(true);
            player.verboseLogging(true);
        }
        player.play(0);
    }

    @Override
    public void wiederholtAbspielen(URL url, int anzahlWiederholung) throws IOException {
        SimpleAudioPlayer player = new SimpleAudioPlayer(url);
        if(ton == true){
            player.setDebug(false);
            player.verboseLogging(true);
        } else{
            player.setDebug(true);
            player.verboseLogging(true);
        }
        player.play(anzahlWiederholung-1);
    }

    @Override
    public boolean tonAn() {
        return ton = true;
    }

    @Override
    public boolean tonAus() {
        return ton = false;
    }


}
