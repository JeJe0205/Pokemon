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

    @FormParam("pokemonUUID")
    @Pattern(regexp = "ID-\\d{1,3}")
    @NotEmpty
    private String pokemonUUID;

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

    public void setTypUUID(String typUUID) {
        setTyp( new Typ());
        Typ typ = DataHandler.readTypByUUID(typUUID);
        getTyp().setTypUUID(typUUID);
        getTyp().setTyp(typ.getTyp());

    }
    public String getTypUUID(){
        if (getTyp()== null)return null;
        return getTyp().getTypUUID();
    }
    /**

    /**
     * gets the trainerID from the Trainer-object
     * @return trainerID
     */
    public String getTrainerUUID() {
        if (getTrainer()==null)return null;
        return getTrainer().getTrainerUUID();
    }
    /**
     * creates a Trainer-object without the pokemonList
     * @param trainerUUID
     */
    public void setTrainerUUID(String trainerUUID) {
        setTrainer( new Trainer());
        Trainer trainer = DataHandler.readTrainerByUUID(trainerUUID);
        getTrainer().setTrainerUUID(trainerUUID);
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
    public String getPokemonUUID() {
        return pokemonUUID;
    }
    /**
     * sets pokemonID
     *
     * @param pokemonID the value to set
     */
    public void setPokemonUUID(String pokemonID) {
        this.pokemonUUID = pokemonUUID;
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
