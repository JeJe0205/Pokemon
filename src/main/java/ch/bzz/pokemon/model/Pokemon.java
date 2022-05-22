package ch.bzz.pokemon.model;

public class Pokemon {

    public String getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }



    private String pokemonID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private Boolean megaEvolution;
    private Double groesse;
    private Trainer trainer;
    private Typ typ;



}
