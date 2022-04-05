package orchester;

import adapter.SimpleAudioAdapter;

public class Probe implements Verhalten{

    @Override
    public void spielen(Orchester orchester) {
        for(MusikerIn m: orchester.musikerArray){

            SimpleAudioAdapter player = new SimpleAudioAdapter();
            player.einmaligAbspielen(m.getInstrument().getAudio());
        }
    }
}
