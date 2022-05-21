package ch.bzz.pokemon.model;

import java.util.List;

public class Pokemon {

    private String pokemonID;
    private String name;
    private Boolean megaEvolution;
    private Double groesse;
    private Trainer trainer;
    private Typ typ;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
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

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public String getPokemonID() { return pokemonID; }

    public void setPokemonID(String pokemonID) { this.pokemonID = pokemonID; }


}
