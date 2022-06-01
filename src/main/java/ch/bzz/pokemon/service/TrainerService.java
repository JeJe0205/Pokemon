package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Trainer;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("trainer")
public class TrainerService {  /**
 * reads a list of all trainers
 * @return list of all trainers
 */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrainers(){
        List<Trainer> trainerList = DataHandler.readAllTrainers();
        return Response
                .status(200)
                .entity(trainerList)
                .build();
    }
    /**
     * reads trainer by ID
     * @param trainerID
     * @return trainerID
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTrainer(
            @QueryParam("id") String trainerID
    ){
        Trainer trainer = DataHandler.readTrainerByID(trainerID);
        int httpsStatus;
        if (trainer == null){
            httpsStatus = 404;
        }else {
            httpsStatus = 288;
        }
        return Response
                .status(httpsStatus)
                .entity(trainer)
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
            @Valid @BeanParam Trainer trainer
          
    ){

        DataHandler.insertTrainer(trainer);
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
    public Response updateTrainer(
            @Valid @BeanParam Trainer trainer
    ){
        int httpStatus = 200;
        Trainer oldTrainer = DataHandler.readTrainerByID(trainer.getTrainerID());
        if (oldTrainer != null){
            oldTrainer.setTrainerID(trainer.getTrainerID());
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
     * @param trainerID the key
     * @return Response
     */
    @DELETE
    @Path("delete")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteTrainer(
            @QueryParam("id") String trainerID
    ){
        int httpStatus = 200;
        if (!DataHandler.deleteTrainer(trainerID)){
            httpStatus = 410;
        }
        return Response
                .status(httpStatus)
                .entity("")
                .build();
    }
}

