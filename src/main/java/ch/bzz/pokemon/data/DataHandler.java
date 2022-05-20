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
        //setTrainerList(new ArrayList<>());
        //readTrainerJSON();
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
     * reads all books
     * @return list of books
     */
    public List<Pokemon> readAllPokemons() {
        return getPokemonList();
    }


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
     * reads all Publishers
     * @return list of publishers
     */
    public List<Typ> readAllPublishers() {

        return getTypList();
    }


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
     * reads the books from the JSON-file
     */
    private void readPokemonJSON() {
        try {
            String path = Config.getProperty("pokemonJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Pokemon[] books = objectMapper.readValue(jsonData, Pokemon[].class);
            for (Pokemon pokemon : pokemons) {
                getPokemonList().add(pokemon);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * reads the publishers from the JSON-file
     */
    private void readTypJSON() {
        try {
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(
                            Config.getProperty("typJSON")
                    )
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Typ[] publishers = objectMapper.readValue(jsonData, Typ[].class);
            for (Typ typ : types) {
                getTypList().add(typ);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * gets bookList
     *
     * @return value of bookList
     */
    private List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    /**
     * sets bookList
     *
     * @param bookList the value to set
     */
    private void setPokemonList(List<Pokemon> bookList) {
        this.pokemonList = pokemonList;
    }

    /**
     * gets publisherList
     *
     * @return value of publisherList
     */
    private List<Typ> getTypList() {
        return typList;
    }

    private void setTypList(List<Typ> typList) {
        this.typList = typList;
    }


}