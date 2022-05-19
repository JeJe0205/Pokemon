package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Typ;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("type")
public class TypService {
    /**
     * reads a list of all books
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTyp(){
        List<Typ> typList = DataHandler.getInstance().readAllTyp();
        return Response
                .status(200)
                .entity(typList)
                .build();
    }

    @GET
    @Path("type")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTyp(
            @QueryParam("uuid") String bookUUID
    ){
        Typ typ = DataHandler.getInstance().readTypByUUID(bookUUID);
        return Response
                .status(200)
                .entity(typ)
                .build();
    }
}

