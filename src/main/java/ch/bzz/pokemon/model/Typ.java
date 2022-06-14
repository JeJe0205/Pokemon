package ch.bzz.pokemon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import java.util.ArrayList;
import java.util.List;

public class Typ {
    @JsonIgnore
    private List<Pokemon> pokemonList;
    @FormParam("typ")
    @NotEmpty
    @Size(min=1, max=20)
    private String typ;
    @FormParam("typID")
    @NotEmpty
    @Pattern(regexp = "ID-\\d{1,2}" )
    private String typID;


    /**
     * gets typ
     *
     * @return value of typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     * sets typ
     *
     * @param typ the value to set
     */

    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * gets typID
     *
     * @return value of typiD
     */

    public String getTypID() {
        return typID;
    }

    /**
     * sets publisherUUID
     *
     * @param typID the value to set
     */

    public void setTypID(String typID) {
        this.typID = typID;
    }


    /**
     * gets pokemonList
     *
     * @return value of pokemonList
     */

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    /**
     * sets pokemonList
     *
     * @param pokemonList the value to set
     */

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

}
