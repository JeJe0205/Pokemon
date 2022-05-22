package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Trainer;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("trainer")
public class TrainerService {
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrainers(){
        List<Trainer> trainerList = DataHandler.getInstance().readAllTrainers();
        return Response
                .status(200)
                .entity(trainerList)
                .build();
    }

    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTyp(
            @QueryParam("id") String trainerID
    ){
        Trainer trainer = DataHandler.getInstance().readTrainerByID(trainerID);
        return Response
                .status(200)
                .entity(trainer)
                .build();
    }
}

