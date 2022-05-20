package ch.bzz.pokemon.model;

public class Typ {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchwaechen() {
        return schwaechen;
    }

    public void setSchwaechen(String schwaechen) {
        this.schwaechen = schwaechen;
    }

    public String getTypID() {
        return typID;
    }

    public void setTypID(String typID) {
        this.typID = typID;
    }


    private String name;
    private String schwaechen;
    private String typID;

}
