package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Trainer;
import ch.bzz.pokemon.model.Typ;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;


@Path("pokemon")
public class PokemonService {
    /**
     * reads a list of all pokemons
     * @return list of all pokemons
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listPokemons(
            @CookieParam("userRole") String userRole
    ){
        int httpsStatus = 0;
        if (userRole == null || userRole.equals("guest")){
            httpsStatus = 403;
        }else if (userRole.equals("admin") || userRole.equals("user")) {
            httpsStatus = 200;
            List<Pokemon> pokemonList = DataHandler.readAllPokemons();
        }
        return Response
                .status(200)
                .entity(httpsStatus)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readPokemon(
            @NotEmpty
            @Pattern(regexp="ID-\\d{1,3}")
            @QueryParam("uuid") String pokemonUUID,
            @CookieParam("userRole") String userRole

    ){
        int httpsStatus = 0;
        if (userRole == null || userRole.equals("guest")){
            httpsStatus = 403;
        }else if (userRole.equals("admin") || userRole.equals("user")){
            httpsStatus = 200;
            Pokemon pokemon = DataHandler.readPokemonByUUID(pokemonUUID);
        }
        return Response
                .status(200)
                .entity(httpsStatus)
                .build();
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
            @FormParam("typID") String typID,
            @CookieParam("userRole") String userRole

    ){
        int httpsStatus;
        if (userRole == null || !userRole.equals("admin")){
            httpsStatus = 403;
        }else {
            httpsStatus = 200;
            pokemon.setTypUUID(UUID.randomUUID().toString());
            DataHandler.insertPokemon(pokemon);
        }
        return Response
                .status(200)
                .entity(httpsStatus)
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
            @FormParam("typUUID") String typUUID,
            @CookieParam("userRole") String userRole

    ){
        if (userRole == null || !userRole.equals("admin")) {
            return Response.status(403).entity("").build();
        }
        int httpStatus = 200;
        Pokemon oldPokemon = DataHandler.readPokemonByUUID(pokemon.getPokemonUUID());
        if (oldPokemon != null){
            oldPokemon.setName(pokemon.getName());
            oldPokemon.setGroesse(pokemon.getGroesse());
            oldPokemon.setMegaEvolution(pokemon.MegaEvolution());
            oldPokemon.setTrainerUUID(pokemon.getTrainerUUID());
            oldPokemon.setTypUUID(pokemon.getTyp().getTypUUID());

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
     * @param pokemonUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePokemon(
            @NotEmpty
            @Pattern(regexp="ID-\\d{1,3}")
            @QueryParam("uuid") String pokemonUUID,
            @CookieParam("userRole") String userRole
    )
    {if (userRole == null || !userRole.equals("admin")) {
        return Response.status(403).entity("").build();
    }
        int httpStatus = 200;
        if (!DataHandler.deletePokemon(pokemonUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

