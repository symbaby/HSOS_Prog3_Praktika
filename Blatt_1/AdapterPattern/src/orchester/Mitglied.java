package orchester;

 public abstract class Mitglied {
    private String name;

    public Mitglied(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
