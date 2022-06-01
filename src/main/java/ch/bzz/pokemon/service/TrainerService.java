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
            @Valid @BeanParam Pokemon pokemon
          
    ){
        Trainer trainer = new Trainer();

        DataHandler.insertTrainer(trainer);
        return Response
                .status(200)
                .entity("")
                .build();
    }

    /**
     *
     * @param trainerID
     * @param trainerName
     * @param ort
     * @return Response
     */
    @POST
    @Path("update")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateTrainer(
            @FormParam("trainerID") String trainerID,
            @FormParam("trainer") String trainerName,
            @FormParam("ort") String ort
    ){
        int httpStatus = 200;
        Trainer trainer = DataHandler.readTrainerByID(trainerID);
        if (trainer != null){
            trainer.setTrainerID(trainerID);
            trainer.setTrainer(trainerName);
            trainer.setOrt(ort);


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

