package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Typ;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
        List<Typ> typList = DataHandler.getInstance().readAllTypes();
        return Response
                .status(200)
                .entity(typList)
                .build();
    }
    /**
     * reads typ by id
     * @return
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTyp(
            @QueryParam("id") String typID
    ){
        Typ typ = DataHandler.getInstance().readTypByID(typID);
        return Response
                .status(200)
                .entity(typ)
                .build();
    }
}
