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
    private List<Pokemon> pokemon;
    private List<Typ> typ;
    private List<Trainer> trainer;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        setTyp(new ArrayList<>());
        readtypJSON();
        setPokemon(new ArrayList<>());
        readPokemonJSON();
        setTrainer(new ArrayList<>());
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
     * reads all books
     * @return list of books
     */
    public List<Pokemon> readAllBooks() {
        return getPokemon();
    }

    /**
     * reads a book by its uuid
     * @param bookUUID
     * @return the Book (null=not found)
     */
    public Pokemon readPokemonByUUID(String id) {
        Pokemon pokemon = null;
        for (Pokemon entry : getpokemon()) {
            if (entry.getid().equals(id)) {
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

        return gettyp();
    }

    /**
     * reads a publisher by its uuid
     * @param publisherUUID
     * @return the Publisher (null=not found)
     */
    public Typ readPublisherByUUID(String publisherUUID) {
        Typ typ = null;
        for (Typ entry : gettyp()) {
            if (entry.gettyp().equals(typ)) {
                typ = entry;
            }
        }
        return typ;
    }

    public List<Trainer> readAllPublishers() {

        return gettrainer();
    }

    /**
     * reads a publisher by its uuid
     * @param trainerid
     * @return the Publisher (null=not found)
     */
    public Trainer readPublisherByUUID(String publisherUUID) {
        Trainer trainer = null;
        for (Trainer entry : gettrainer()) {
            if (entry.gettrainer().equals(trainer)) {
                trainer = entry;
            }
        }
        return trainer;
    }

    /**
     * reads the books from the JSON-file
     */
    private void readBookJSON() {
        try {
            String path = Config.getProperty("pokemonJSON");
            byte[] jsonData = Files.readAllBytes(
                    Paths.get(path)
            );
            ObjectMapper objectMapper = new ObjectMapper();
            Pokemon[] pokemons = objectMapper.readValue(jsonData, Pokemon[].class);
            for (Pokemon pokemon1 : pokemons) {
                getpokemon().add(pokemon);
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
            Typ[] typs = objectMapper.readValue(jsonData, Typ[].class);
            for (Typ typ : typs) {
                getPublisherList().add(typ);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * reads the publishers from the JSON-file
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
                getPublisherList().add(trainer);
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
    private List<Pokemon> getpokeon() {
        return pokemon;
    }

    /**
     * sets bookList
     *
     * @param bookList the value to set
     */
    private void setPokemon(List<Pokemon> bookList) {
        this.pokemon = pokemon;
    }

    /**
     * gets publisherList
     *
     * @return value of publisherList
     */
    private List<Typ> gettyp() {
        return typ;
    }

    /**
     * sets publisherList
     *
     * @param publisherList the value to set
     */
    private void setTyp(List<Typ> publisherList) {
        this.typ = typ;
    }


}
