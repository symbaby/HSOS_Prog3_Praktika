package orchester;

public class Dirigent extends Mitglied {

    String dirigentenStabMarke;

    public Dirigent(String dirigentenStabMarke, String name){
        super(name);
        this.dirigentenStabMarke = dirigentenStabMarke;
    }

}
