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

    private String name;
    private String schwaechen;
}
