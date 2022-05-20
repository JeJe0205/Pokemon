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
import java.util.Arrays;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private List<Pokemon> pokemons;
    private List<Typ> types;
    private List<Trainer> trainers;

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

    private void setTrainer(ArrayList<Object> objects) {
    }

    private void readPokemonJSON() {
    }

    private void readtypJSON() {
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

    public Pokemon readPokemonByUUID(String id) {
        Pokemon pokemon = null;
        for (Pokemon entry : getPokemonList()) {
            if (entry.getId().equals(id)) {
                pokemon = entry;
            }
        }
        return pokemon;
    }

    /**
     * reads all Publishers
     * @return list of publishers
     */
    public List<Trainer> readAllTrainers() {

        return getTrainerList();
    }

    /**
     * reads a publisher by its uuid
     * @return the Publisher (null=not found)
     */
//    public Typ readPublisherByUUID(String publisherUUID) {
//        Typ typ = null;
//        for (Typ entry : gettyp()) {
//            if (entry.gettyp().equals(typ)) {
//                typ = entry;
//            }
//        }
//        return typ;
//    }

    public List<Trainer> readAllPublishers() {

        return getTrainerList();
    }

    /**
     * reads a publisher by its uuid
     * @param trainerid
     * @return the Publisher (null=not found)
     */
//    public Trainer readPublisherByUUID(String publisherUUID) {
//        Trainer trainer = null;
//        for (Trainer entry : getTrainerList()) {
//            if (entry.gettrainer().equals(trainer)) {
//                trainer = entry;
//            }
//        }
//        return trainer;
//    }

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
            this.pokemons.addAll(Arrays.asList(pokemons));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Pokemon getpokemon() {
        return null;
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
                getTypes().add(typ);
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
                getTrainerList().add(trainer);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<Trainer> getTrainerList() {
        return trainers;
    }

    /**
     * gets TODO
     *
     * @return value of bookList
     */
    private List<Pokemon> getPokemonList() {
        return pokemons;
    }

    /**
     * sets bookList
     *
     */
    private void setPokemon(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    /**
     * gets publisherList
     *
     * @return value of publisherList
     */
    private List<Typ> getTypes() {
        return types;
    }

    /**
     * sets publisherList
     *
     */
    private void setTyp(List<Typ> typeList) {
        this.types = types;
    }


    public List<Typ> readAllTypes() {
        return types;
    }
}
