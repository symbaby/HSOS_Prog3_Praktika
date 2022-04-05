package orchester;

import adapter.SimpleAudioAdapter;
import com.company.Main;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;

public class Orchester {

    String bezeichnung;
    Dirigent dirigent;
    HashSet<Musiker> musikerListe = new HashSet<>();
    Verhalten verhalten;
    String audioDateiKonzert;
    URL url;


    public Orchester(String bezeichnung, String audioDateiKonzert){
        this.bezeichnung = bezeichnung;
        this.audioDateiKonzert = audioDateiKonzert;
        url = Main.class.getResource(audioDateiKonzert);
    }

    public void addDirigent(Dirigent dirigent){
        this.dirigent = dirigent;
    }

    public void addMusiker(Musiker musiker){
        musikerListe.add(musiker);
    }

    public HashSet<Musiker> getMusikerListe() {
        return musikerListe;
    }

    public URL getAudiodateiKonzert(){
        return Main.class.getResource(audioDateiKonzert);
    }

    public String getBezeichnung(){
        return bezeichnung;
    }

    public void alleMusiker(){
        for(Musiker m : musikerListe){
            System.out.println(m);
        }
    }

    public void proben() throws IOException {
        this.verhalten  = new Probe(this);
    }

    public void auftritt() throws IOException {
        this.verhalten = new Konzert(this);
    }

    private class Konzert implements Verhalten{
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

    private class Probe implements Verhalten{

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


}
