package ch.bzz.pokemon.model;

import ch.bzz.pokemon.data.DataHandler;

public class Pokemon {
    private Typ typ;
    private Trainer trainer;

    private String pokemonID;
    private String name;
    private Boolean megaEvolution;
    private Double groesse;

    public String getTypID() {
        return getTyp().getTypID();
    }

    public void setTypID(String typID) {
        setTyp( new Typ());
        Typ typ = DataHandler.getInstance().readTypByID(typID);
        getTyp().setTypID(typID);
        getTyp().setTyp(typ.getTyp());

    }

    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public String getTrainerID() {
        return getTrainer().getTrainerID();
    }

    public void setTrainerID(String trainerID) {
        setTrainer( new Trainer());
        Trainer trainer = DataHandler.getInstance().readTrainerByID(trainerID);
        getTrainer().setTrainerID(trainerID);
        getTrainer().setTrainer(trainer.getTrainer());

    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer= trainer;
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

    public String getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
