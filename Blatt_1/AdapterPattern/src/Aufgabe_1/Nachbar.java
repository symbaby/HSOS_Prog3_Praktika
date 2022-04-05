package Aufgabe_1;

public class Nachbar {

    private String vorname;
    private String nachname;

    public Nachbar(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname(){
        return vorname;
    }

    public String getNachname(){
        return nachname;
    }

    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    @Override
    public String toString(){
        return "Hallo " + getVorname() + " " + getNachname() + "\t";
    }

    /* Equals und HashCode ueberladen
    damit ich keine doppelten Eintraege
    in der zu auszugebender Liste habe.
    */

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
        Nachbar n = (Nachbar)obj;
        if(this.vorname.equals((n.vorname)) && this.nachname.equals((n.nachname))){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        final int prime = 3;
        int result = 1;

        result = prime * result + nachname.hashCode() + vorname.hashCode();
        return result;
    }


}
