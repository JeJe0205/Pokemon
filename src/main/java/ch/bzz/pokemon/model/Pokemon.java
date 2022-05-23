package ch.bzz.pokemon.model;

import ch.bzz.pokemon.data.DataHandler;

/**
 * a Pakemon
 */
public class Pokemon {
    private Typ typ;
    private Trainer trainer;

    private String pokemonID;
    private String name;
    private Boolean megaEvolution;
    private Double groesse;

    /**
     * gets the typID from the Typ-object
     * @return
     */
    public String getTypID() {
        return getTyp().getTypID();
    }

    /**
     * creates a Typ-object without the pokemonList
     * @param typID
     */
    public void setTypID(String typID) {
        setTyp( new Typ());
        Typ typ = DataHandler.getInstance().readTypByID(typID);
        getTyp().setTypID(typID);
        getTyp().setTyp(typ.getTyp());

    }
    /**
     * gets typ
     *
     * @return value of typ
     */
    public Typ getTyp() {
        return typ;
    }

    /**
     * sets typ
     *
     * @param typ the value to set
     */
    public void setTyp(Typ typ) {
        this.typ = typ;
    }
    /**
     * gets the trainerID from the Trainer-object
     * @return
     */
    public String getTrainerID() {
        return getTrainer().getTrainerID();
    }
    /**
     * creates a Trainer-object without the pokemonList
     * @param trainerID
     */
    public void setTrainerID(String trainerID) {
        setTrainer( new Trainer());
        Trainer trainer = DataHandler.getInstance().readTrainerByID(trainerID);
        getTrainer().setTrainerID(trainerID);
        getTrainer().setTrainer(trainer.getTrainer());

    }
    /**
     * gets trainer
     *
     * @return value of trainer
     */
    public Trainer getTrainer() {
        return trainer;
    }

    /**
     * sets trainer
     *
     * @param trainer the value to set
     */
    public void setTrainer(Trainer trainer) {
        this.trainer= trainer;
    }
    /**
     * gets trainer
     *
     * @return value of trainer
     */
    public Boolean getMegaEvolution() {
        return megaEvolution;
    }

    public void setMegaEvolution(Boolean megaEvolution) {
        this.megaEvolution = megaEvolution;
    }
    /**
     * gets groesse
     *
     * @return value of groesse
     */
    public Double getGroesse() {
        return groesse;
    }
    /**
     * sets groesse
     *
     * @param groesse the value to set
     */
    public void setGroesse(Double groesse) {
        this.groesse = groesse;
    }
    /**
     * gets pokemonID
     *
     * @return value of pokemonID
     */
    public String getPokemonID() {
        return pokemonID;
    }
    /**
     * sets pokemonID
     *
     * @param pokemonID the value to set
     */
    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
    }
    /**
     * gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }
    /**
     * sets name
     *
     * @param name the value to set
     */
    public void setName(String name) {
        this.name = name;
    }


}
