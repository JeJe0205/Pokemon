package ch.bzz.pokemon.model;

import ch.bzz.pokemon.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.List;


/**
 * a Pakemon
 */
public class Pokemon {
    @JsonIgnore
    private Typ typ;
    @JsonIgnore
    private Trainer trainer;

    @FormParam("pokemonID")
    @Pattern(regexp = "ID-\\d{1,3}")
    @NotEmpty
    private String pokemonID;

    @FormParam("name")
    @NotEmpty
    @Size(min=1, max=10)
    private String name;

    @FormParam("megaEvolution")
    @Size(min=4, max=5)
    private boolean megaEvolution;

    @FormParam("groesse")
    @DecimalMin("0.1")
    @DecimalMin("20.0")
    private double groesse;


    public Typ getTyp() {
        return typ;
    }

    public void setTyp(Typ typ) {
        this.typ = typ;
    }

    public void setTypID(String typID) {
        setTyp( new Typ());
        Typ typ = DataHandler.readTypByID(typID);
        getTyp().setTypID(typID);
        getTyp().setTyp(typ.getTyp());

    }
    public String getTypID(){
        if (getTyp()== null)return null;
        return getTyp().getTypID();
    }
    /**

    /**
     * gets the trainerID from the Trainer-object
     * @return trainerID
     */
    public String getTrainerID() {
        if (getTrainer()==null)return null;
        return getTrainer().getTrainerID();
    }
    /**
     * creates a Trainer-object without the pokemonList
     * @param trainerID
     */
    public void setTrainerID(String trainerID) {
        setTrainer( new Trainer());
        Trainer trainer = DataHandler.readTrainerByID(trainerID);
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
    public boolean MegaEvolution() {
        return megaEvolution;
    }

    public void setMegaEvolution(boolean megaEvolution) {
        this.megaEvolution = megaEvolution;
    }
    /**
     * gets groesse
     *
     * @return value of groesse
     */
    public double getGroesse() {
        return groesse;
    }
    /**
     * sets groesse
     *
     * @param groesse the value to set
     */
    public void setGroesse(double groesse) {
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
