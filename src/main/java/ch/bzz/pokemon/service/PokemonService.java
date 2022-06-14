package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;



@Path("pokemon")
public class PokemonService {
    /**
     * reads a list of all pokemons
     * @return list of all pokemons
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPokemons(){
        List<Pokemon> pokemonList = DataHandler.readAllPokemons();
        Response response = Response
                .status(200)
                .entity(pokemonList)
                .build();
        return response;
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPokemon(
            @NotEmpty
            @Pattern(regexp="ID-\\d{1,3}")
            @QueryParam("id") String pokemonID
    ){
        Pokemon pokemon = DataHandler.readPokemonByID(pokemonID);
        int httpsStatus;
        if (pokemon == null){
            httpsStatus = 404;
        }else {
            httpsStatus = 288;
        }
        Response response = Response
                .status(httpsStatus)
                .entity(pokemon)
                .build();
        return response;
    }

    /**
     *
     * @return Response
     */

    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertPokemon(
            @Valid @BeanParam Pokemon pokemon,
            @Pattern(regexp="ID-\\d{1,3}")
            @FormParam("trainerID") String trainerID,
            @FormParam("typIDList") List<String> typIDList

    ){

        //pokemon.setPokemonID(ID.randomID().toString());
        pokemon.setTrainerID(trainerID);
        pokemon.setTypIDListWithList(typIDList);
        DataHandler.insertPokemon(pokemon);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     *
     * @return Response
     */

    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updatePokemon(
            @Valid @BeanParam Pokemon pokemon,
            @Pattern(regexp="ID-\\d{1,3}")
            @FormParam("trainerID") String trainerID,
            @FormParam("typIDList") List<String> typIDList

    ){
        int httpStatus = 200;
        Pokemon oldPokemon = DataHandler.readPokemonByID(pokemon.getPokemonID());
        if (oldPokemon != null){
            oldPokemon.setName(pokemon.getName());
            oldPokemon.setGroesse(pokemon.getGroesse());
            oldPokemon.setMegaEvolution(pokemon.MegaEvolution());
            oldPokemon.setTrainerID(pokemon.getTrainerID());
            oldPokemon.setTypList(pokemon.getTypList());
            oldPokemon.setTypIDListWithList(typIDList);
            DataHandler.updatePokemon();
        }else {
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }

    /**
     * delets a pokemon indentified by its uuid
     * @param pokemonID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePokemon(
            @NotEmpty
            @Pattern(regexp="ID-\\d{1,3}")
            @QueryParam("id") String pokemonID
    ){
        int httpStatus = 200;
        if (!DataHandler.deletePokemon(pokemonID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

