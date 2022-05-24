package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
        List<Pokemon> pokemonList = DataHandler.getInstance().readAllPokemons();
        return Response
                .status(200)
                .entity(pokemonList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPokemon(
            @QueryParam("id") String pokemonID
    ){
        Pokemon pokemon = DataHandler.getInstance().readPokemonByID(pokemonID);
        int httpsStatus;
        if (pokemon == null){
            httpsStatus = 404;
        }else {
            httpsStatus = 288;
        }
        return Response
                .status(httpsStatus)
                .entity(pokemon)
                .build();
    }
}

