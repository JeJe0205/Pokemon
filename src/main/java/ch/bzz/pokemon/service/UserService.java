package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.UserData;
import ch.bzz.pokemon.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

/**
 * services for authentication and authorization of users
 */

@Path("user")
public class UserService {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(
            @FormParam("username") String username,
            @FormParam("passwort") String passwort
    ){
        int httpStatus;
        User user = UserData.findUser(username,passwort);
        if (user == null || user.getRole() == null || user.getRole().equals("guest")){
            httpStatus = 404;
        }else {
            httpStatus = 200;
        }
        Response response = Response
                .status(httpStatus)
                .entity("")
                .build();
        return response;
    }

    @DELETE
    @Path("logout")
    @Produces(MediaType.TEXT_PLAIN)
    public Response logout(){
        Response response = Response
                .status(200)
                .entity("")
                .build();
        return response;
    }

}
