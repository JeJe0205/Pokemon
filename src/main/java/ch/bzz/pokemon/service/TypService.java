package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Typ;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("typ")
public class TypService {
    /**
     * reads a list of all types
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTypes(){
        List<Typ> typList = DataHandler.readAllTypes();
        return Response
                .status(200)
                .entity(typList)
                .build();
    }
    /**
     * reads typ by ID
     * @param typID
     * @return typID
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTyp(
            @QueryParam("id") String typID
    ){
        Typ typ = DataHandler.readTypByID(typID);
        int httpsStatus;
        if (typ == null){
            httpsStatus = 404;
        }else {
            httpsStatus = 288;
        }
        return Response
                .status(httpsStatus)
                .entity(typ)
                .build();
    }

    /**
     *
     * @param name
     * @param megaEvolution
     * @param groesse
     * @param trainerID
     * @param typID
     * @return
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertTyp(
            @FormParam("typ") String typ,
            @FormParam("typID") String typID
    ){
        Typ typ = new Typ();
        typ.setTypID(ID.randomID().toString());
        typ.setTyp(typ);
        typ.setTypID(typID);


        DataHandler.insertTyp(typ);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateTyp(
            @FormParam("typID") String typID,
            @FormParam("typ") String typ

    ){
        int httpStatus = 200;
        Typ typ = DataHandler.readTypByID(typID);
        if (typ != null){
            pokemon.setName(name);
            pokemon.setMegaEvolution(megaEvolution);
            pokemon.setGroesse(groesse);
            pokemon.setTrainerID(trainerID);
            pokemon.setTypID(typID);

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

