package ch.bzz.pokemon.data;

import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Typ;
import ch.bzz.pokemon.model.Trainer;
import ch.bzz.pokemon.service.Config;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Pokemon> pokemonList;
    private List<Typ> typList;
    private List<Trainer> trainerList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setTypList(new ArrayList<>());
        readTypJSON();
        setPokemonList(new ArrayList<>());
        readPokemonJSON();
        setTrainerList(new ArrayList<>());
        readTrainerJSON();
    }
    /**
     * gets the only instance of this class
     * @return
     */
    public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }


    /**
     * reads all pokemos
     * @return list of pokemons
     */
    public List<Pokemon> readAllPokemons() {
        return getPokemonList();
    }

    /**
     * reads a pokemon by its id
     * @param pokemonID
     * @return the Pokemon (null=not found)
     */
    public Pokemon readPokemonByID(String pokemonID) {
        Pokemon pokemon = null;
        for (Pokemon entry : getPokemonList()) {
            if (entry.getPokemonID().equals(pokemonID)) {
                pokemon = entry;
            }
        }
        return pokemon;
    }

    /**
     * reads all Types
     * @return list of types
     */
    public List<Typ> readAllTypes() {

        return getTypList();
    }

    /**
     * reads a Typ by its id
     * @param typID
     * @return the Typ (null=not found)
     */
    public Typ readTypByID(String typID) {
        Typ typ = null;
        for (Typ entry : getTypList()) {
            if (entry.getTypID().equals(typID)) {
                typ = entry;
            }
        }
        return typ;
    }

    /**
     * reads all Trainers
     * @return list of trainers
     */
    public List<Trainer> readAllTrainers() {

        return getTrainerList();
    }

    /**
     * reads a trainer by its id
     * @param trainerID
     * @return the Trainer (null=not found)
     */
    public Trainer readTrainerByID(String trainerID) {
        Trainer trainer = null;
        for (Trainer entry : getTrainerList()) {
            if (entry.getTrainerID().equals(trainerID)) {
                trainer = entry;
            }
        }
        return trainer;
    }

    /**
     * reads the pokemons from the JSON-file
     */
    private void readPokemonJSON() {
        try {
            String path = Config.getProperty("pokemonJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Pokemon[] pokemons = objectMapper.readValue(jsonData, Pokemon[].class);
            for (Pokemon pokemon : pokemons) {
                getPokemonList().add(pokemon);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the types from the JSON-file
     */
    private void readTypJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("typJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Typ[] types = objectMapper.readValue(jsonData, Typ[].class);
            for (Typ typ : types) {
                getTypList().add(typ);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * reads the trainers from the JSON-file
     */
    private void readTrainerJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("trainerJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Trainer[] trainers = objectMapper.readValue(jsonData, Trainer[].class);
            for (Trainer trainer : trainers) {
                getTrainerList().add(trainer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * gets pokemonList
     *
     * @return value of pokemonList
     */
    private List<Pokemon> getPokemonList() {
        return pokemonList;
    }
    /**
     * sets pokemonList
     *
     * @param pokemonList the value to set
     */

    private void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
    /**
     * gets typLIst
     *
     * @return typList the value to set
     */

    private List<Typ> getTypList() {
        return typList;
    }
    /**
     * sets typList
     *
     * @param typList the value to set
     */

    private void setTypList(List<Typ> typList) {
        this.typList = typList;
    }
    /**
     * gets trainerList
     *
     * @return value of trainerList
     */

    private List<Trainer> getTrainerList() {
        return trainerList;
    }
    /**
     * sets trainerList
     *
     * @param trainerList the value to set
     */
    private void setTrainerList(List<Trainer> trainerList) {
        this.trainerList = trainerList;
    }


}