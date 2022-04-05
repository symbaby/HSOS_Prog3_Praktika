package orchester;

public abstract class Mitglied {

    private String name;

    public Mitglied(String name){
        super();
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
