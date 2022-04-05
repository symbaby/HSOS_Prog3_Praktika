package orchester;

import Aufgabe_1.Nachbar;

public class Musiker extends Mitglied{

    private Instrument instrument;

    public Musiker(String name, Instrument instrument) {
        super(name);
        this.instrument = instrument;
    }

    public Instrument getInstrument(){
        return instrument;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    // Um Duplikate zu vermeiden

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
        Musiker n = (Musiker) obj;
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
