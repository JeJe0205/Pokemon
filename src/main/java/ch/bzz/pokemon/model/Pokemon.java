package ch.bzz.pokemon.model;

import java.util.List;

public class Pokemon {
    public List<Typ> getString() {
        return String;
    }

    public void setString(List<Typ> string) {
        String = string;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public Integer getPokedexnr() {
        return pokedexnr;
    }

    public void setPokedexnr(Integer pokedexnr) {
        this.pokedexnr = pokedexnr;
    }

    public Boolean getMegaEvolution() {
        return megaEvolution;
    }

    public void setMegaEvolution(Boolean megaEvolution) {
        this.megaEvolution = megaEvolution;
    }

    public Double getGroesse() {
        return groesse;
    }

    public void setGroesse(Double groesse) {
        this.groesse = groesse;
    }

    public java.lang.String getTrainer() {
        return trainer;
    }

    public void setTrainer(java.lang.String trainer) {
        this.trainer = trainer;
    }

    private List<Typ>String;
    private String name;
    private Integer pokedexnr;
    private Boolean megaEvolution;
    private Double groesse;
    private String trainer;
}
