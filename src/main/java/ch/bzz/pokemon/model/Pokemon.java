package ch.bzz.pokemon.model;

import ch.bzz.pokemon.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/**
 * a Pakemon
 */
public class Pokemon {
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

    @JsonIgnore
    private ArrayList<Typ> typList = new ArrayList<Typ>();
    @JsonIgnore
    private Trainer trainer;


    /**
     * sets the songList with a ArrayList with UUIDs
     * @param typIDList
     */
    public void setTypIDList(ArrayList<String> typIDList){
        ListIterator<String> iterator = typIDList.listIterator();
        while (iterator.hasNext()){
            Typ typ = DataHandler.readTypByID(iterator.next());
            typList.add(typ);
        }
    }

    /**
     * gets songUUIDList (ArrayList of the songUUIDs)
     * @return
     */
    public ArrayList<String> getTypIDList(){
        ArrayList<String> typIDList = new ArrayList<>();
        ListIterator<Typ> iterator = typList.listIterator();
        while (iterator.hasNext()){
            String typID = iterator.next().getTypID();
            typIDList.add(typID);
        }
        return typIDList;
    }

    /**
     * sets songUUIList (ArrayList) with a List
     * @param typIDList
     */
    public void setTypIDListWithList(List<String> typIDList){
        ArrayList<String> arrayList = new ArrayList<>();
        ListIterator<String> iterator = typIDList.listIterator();
        while (iterator.hasNext()){
            arrayList.add(iterator.next());
        }
        setTypIDList(arrayList);
    }

    /**
     * gets songList
     * @return
     */
    public ArrayList<Typ> getTypList() {
        return typList;
    }

    /**
     * sets songList
     * @param typList
     */
    public void setTypList(ArrayList<Typ> typList) {
        this.typList = typList;
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
        this.trainer = trainer;

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

    public String getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
    }
}
