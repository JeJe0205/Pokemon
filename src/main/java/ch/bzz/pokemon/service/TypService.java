package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
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


@Path("typ")
public class TypService {
    /**
     * reads a list of all types
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTypes(
            @CookieParam("userRole") String userRole
    ){
        int httpsStatus = 0;
        if (userRole == null || userRole.equals("guest")){
            httpsStatus = 403;
        }else if (userRole.equals("admin") || userRole.equals("user")) {
            httpsStatus = 200;
            List<Typ> typList = DataHandler.readAllTypes();
        }
        return Response
                .status(200)
                .entity(httpsStatus)
                .build();
    }
    /**
     * reads typ by ID
     * @param typUUID
     * @return typID
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTyp(
            @NotEmpty
            @Pattern(regexp="ID-\\d{1,3}")
            @QueryParam("uuid") String typUUID,
            @CookieParam("userRole") String userRole
    ){
        int httpsStatus = 0;
        if (userRole == null || userRole.equals("guest")){
            httpsStatus = 403;
        }else if (userRole.equals("admin") || userRole.equals("user"))  {
            httpsStatus = 200;
            Typ typ = DataHandler.readTypByUUID(typUUID);
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
    public Response insertTyp(
            @Valid @BeanParam Typ typ,
            @CookieParam("userRole") String userRole
    ){
        int httpsStatus;
        if (userRole == null || !userRole.equals("admin")){
            httpsStatus = 403;
        }else {
            httpsStatus = 200;
            typ.setTypUUID(UUID.randomUUID().toString());
            typ.setTyp(typ.getTypUUID());
            DataHandler.insertTyp(typ);
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
    public Response updateTyp(
            @Valid @BeanParam Typ typ,
            @CookieParam("userRole") String userRole

    ){
        if (userRole == null || !userRole.equals("admin")) {
            return Response.status(403).entity("").build();
        }
        int httpStatus = 200;
        Typ oldTyp = DataHandler.readTypByUUID(typ.getTypUUID());
        if (oldTyp != null){
            oldTyp.setTyp(typ.getTyp());
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
     * @param typUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteTyp(
            @QueryParam("uuid") String typUUID,
                @CookieParam("userRole") String userRole
    ){
        if (userRole == null || !userRole.equals("admin")) {
            return Response.status(403).entity("").build();
        }
        int httpStatus = 200;
        if (!DataHandler.deleteTyp(typUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

