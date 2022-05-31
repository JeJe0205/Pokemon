package ch.bzz.pokemon.data;

import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Typ;
import ch.bzz.pokemon.model.Trainer;
import ch.bzz.pokemon.service.Config;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * reads and writes the data in the JSON-files
 */
public class DataHandler {
    private static DataHandler instance = null;
    private static List<Pokemon> pokemonList;
    private static List<Typ> typList;
    private static List<Trainer> trainerList;

    /**
     * private constructor defeats instantiation
     */
    private DataHandler() {
        /*setTypList(new ArrayList<>());
        readTypJSON();
        setPokemonList(new ArrayList<>());
        readPokemonJSON();
        setTrainerList(new ArrayList<>());
        readTrainerJSON();*/
    }
    /**
     * gets the only instance of this class
     * @return instance
     */
    /*public static DataHandler getInstance() {
        if (instance == null)
            instance = new DataHandler();
        return instance;
    }*/


    /**
     * reads all pokemos
     * @return list of pokemons
     */
    public static List<Pokemon> readAllPokemons() {
        return getPokemonList();
    }

    /**
     * reads a pokemon by its id
     * @param pokemonID
     * @return the Pokemon (null=not found)
     */
    public static Pokemon readPokemonByID(String pokemonID) {
        Pokemon pokemon = null;
        for (Pokemon entry : getPokemonList()) {
            if (entry.getPokemonID().equals(pokemonID)) {
                pokemon = entry;
            }
        }
        return pokemon;
    }

    /**
     * inserts a new book into the bookList
     *
     * @param pokemon the book to be saved
     */
    public static void insertPokemon(Pokemon pokemon) {
        getPokemonList().add(pokemon);
        writePokemonJSON();
    }

    /**
     * updates the bookList
     */
    public static void updatePokemon() {
        writePokemonJSON();
    }

    /**
     * deletes a book identified by the bookUUID
     * @param pokemonID  the key
     * @return  success=true/false
     */
    public static boolean deletePokemon(String pokemonID) {
        Pokemon pokemon = readPokemonByID(pokemonID);
        if (pokemon != null) {
            getPokemonList().remove(pokemon);
            writePokemonJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * reads all Types
     * @return list of types
     */
    public static List<Typ> readAllTypes() {

        return getTypList();
    }

    /**
     * reads a Typ by its id
     * @param typID
     * @return the Typ (null=not found)
     */
    public static Typ readTypByID(String typID) {
        Typ typ = null;
        for (Typ entry : getTypList()) {
            if (entry.getTypID().equals(typID)) {
                typ = entry;
            }
        }
        return typ;
    }

    /**
     * inserts a new book into the bookList
     *
     * @param typ the book to be saved
     */
    public static void insertTyp(Typ typ) {
        getTypList().add(typ);
        writeTypJSON();
    }

    /**
     * updates the bookList
     */
    public static void updateTyp() {
        writeTypJSON();
    }

    /**
     * deletes a book identified by the bookUUID
     * @param typID  the key
     * @return  success=true/false
     */
    public static boolean deleteTyp(String typID) {
        Typ typ = readTypByID(typID);
        if (typ != null) {
            getTypList().remove(typ);
            writeTypJSON();
            return true;
        } else {
            return false;
        }
    }


    /**
     * reads all Trainers
     * @return list of trainers
     */
    public static List<Trainer> readAllTrainers() {

        return getTrainerList();
    }

    /**
     * reads a trainer by its id
     * @param trainerID
     * @return the Trainer (null=not found)
     */
    public static Trainer readTrainerByID(String trainerID) {
        Trainer trainer = null;
        for (Trainer entry : getTrainerList()) {
            if (entry.getTrainerID().equals(trainerID)) {
                trainer = entry;
            }
        }
        return trainer;
    }

    /**
     * inserts a new book into the bookList
     *
     * @param trainer the book to be saved
     */
    public static void insertTrainer(Trainer trainer) {
        getTrainerList().add(trainer);
        writeTrainerJSON();
    }

    /**
     * updates the bookList
     */
    public static void updateTrainer() {
        writeTrainerJSON();
    }

    /**
     * deletes a book identified by the bookUUID
     * @param trainerID  the key
     * @return  success=true/false
     */
    public static boolean deleteTrainer(String trainerID) {
        Trainer trainer = readTrainerByID(trainerID);
        if (trainer != null) {
            getTrainerList().remove(trainer);
            writeTrainerJSON();
            return true;
        } else {
            return false;
        }
    }

    /**
     * reads the pokemons from the JSON-file
     */
    private static void readPokemonJSON() {
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
     * writes the bookList to the JSON-file
     */
    private static void writePokemonJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("pokemonJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getPokemonList());
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
     * writes the bookList to the JSON-file
     */
    private static void writeTypJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("typJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getTypList());
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
     * writes the bookList to the JSON-file
     */
    private static void writeTrainerJSON() {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        FileOutputStream fileOutputStream = null;
        Writer fileWriter;

        String bookPath = Config.getProperty("trainerJSON");
        try {
            fileOutputStream = new FileOutputStream(bookPath);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
            objectWriter.writeValue(fileWriter, getTrainerList());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * gets pokemonList
     *
     * @return value of pokemonList
     */
    private static List<Pokemon> getPokemonList() {
        if (pokemonList == null) {
            setPokemonList(new ArrayList<>());
            readPokemonJSON();
        }
        return pokemonList;
    }
    /**
     * sets pokemonList
     *
     * @param pokemonList the value to set
     */

    private static void setPokemonList(List<Pokemon> pokemonList) {
        DataHandler.pokemonList = pokemonList;
    }
    /**
     * gets typLIst
     *
     * @return typList the value to set
     */

    private static List<Typ> getTypList() {
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

    private static List<Trainer> getTrainerList() {
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