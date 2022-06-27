package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
import ch.bzz.pokemon.model.Trainer;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;


@Path("trainer")
public class TrainerService {  /**
 * reads a list of all trainers
 * @return list of all trainers
 */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrainers(
            @CookieParam("userRole") String userRole
    ){
        {
            int httpsStatus = 0;
            if (userRole == null || userRole.equals("guest")){
                httpsStatus = 403;
            }else if (userRole.equals("admin") || userRole.equals("user")) {
                httpsStatus = 200;
                List<Trainer> trainerList = DataHandler.readAllTrainers();
            }
            return Response
                    .status(200)
                    .entity(httpsStatus)
                    .build();
        }
    }
    /**
     * reads trainer by ID
     * @param trainerUUID
     * @return trainerID
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTrainer(
            @QueryParam("uuid") String trainerUUID,
            @CookieParam("userRole") String userRole
    ){
        int httpsStatus = 0;
        if (userRole == null || userRole.equals("guest")){
            httpsStatus = 403;
        }else if (userRole.equals("admin") || userRole.equals("user"))  {
            httpsStatus = 200;
            Trainer trainer = DataHandler.readTrainerByUUID(trainerUUID);
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
    public Response insertTrainer(
            @Valid @BeanParam Trainer trainer,
            @CookieParam("userRole") String userRole
          
    ){
        int httpsStatus;
        if (userRole == null || !userRole.equals("admin")){
            httpsStatus = 403;
        }else {
            httpsStatus = 200;
            trainer.setTrainerUUID(UUID.randomUUID().toString());
            DataHandler.insertTrainer(trainer);
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
    public Response updateTrainer(
            @Valid @BeanParam Trainer trainer,
            @CookieParam("userRole") String userRole
    ){
        if (userRole == null || !userRole.equals("admin")) {
            return Response.status(403).entity("").build();
        }
        int httpStatus = 200;
        Trainer oldTrainer = DataHandler.readTrainerByUUID(trainer.getTrainerUUID());
        if (oldTrainer != null){
            oldTrainer.setTrainerUUID(trainer.getTrainerUUID());
            oldTrainer.setTrainer(trainer.getTrainer());
            oldTrainer.setOrt(trainer.getOrt());


            DataHandler.updateTrainer();
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
     * @param trainerUUID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteTrainer(
            @QueryParam("uuid") String trainerUUID,
            @CookieParam("userRole") String userRole
    ){
        if (userRole == null || !userRole.equals("admin")) {
            return Response.status(403).entity("").build();
        }
        int httpStatus = 200;
        if (!DataHandler.deleteTrainer(trainerUUID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

