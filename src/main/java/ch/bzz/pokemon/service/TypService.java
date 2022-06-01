package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Typ;
import com.sun.xml.internal.bind.v2.model.core.ID;


import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;


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
     * @return Response
     */
    @POST
    @Path("create")
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertTyp(
            @Valid @BeanParam Pokemon pokemon
    ){
        Typ typ = new Typ();

        DataHandler.insertTyp(typ);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     *
     * @param typID
     * @param typName
     * @return Response
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateTyp(
            @FormParam("typID") String typID,
            @FormParam("typ") String typName

    ){
        int httpStatus = 200;
        Typ typ = DataHandler.readTypByID(typID);
        if (typ != null){
            typ.setTyp(typName);

            DataHandler.updateTyp();
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
     * @param typID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteTyp(
            @QueryParam("id") String typID
    ){
        int httpStatus = 200;
        if (!DataHandler.deleteTyp(typID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

