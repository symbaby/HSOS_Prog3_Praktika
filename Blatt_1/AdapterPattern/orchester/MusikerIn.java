package orchester;

import Aufgabe_1.Nachbar;

import javax.sound.midi.Instrument;
import java.net.URL;

public class MusikerIn extends Mitglied {

    private Instrumente instrument;

    MusikerIn(Instrumente instrument, String name){

        super(name);
        this.instrument = instrument;
    }

    public Instrumente getInstrument(){
        return this.instrument;
    }


    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(!this.getClass().equals(obj.getClass())){
            return false;
        }
        MusikerIn n = (MusikerIn) obj;
        if(this.instrument.equals((n.instrument)) && this.instrument.equals((n.instrument))){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 3;
        int result = 1;

        result = prime * result + instrument.hashCode() + instrument.hashCode();
        return result;
    }

}
