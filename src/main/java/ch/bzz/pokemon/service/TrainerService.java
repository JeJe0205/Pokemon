package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;
import ch.bzz.pokemon.model.Pokemon;
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
    /**
     * reads a list of all books
     * @return
     */
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTrainer(){
        List<Trainer> trainerList = DataHandler.getInstance().readAllTrainer();
        return Response
                .status(200)
                .entity(tainerList)
                .build();
    }

    @GET
    @Path("trainer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response readTrainer(
            @QueryParam("uuid") String bookUUID
    ){ Trainer trainer = DataHandler.getInstance().readTrainerByUUID(bookUUID);
        return Response
                .status(200)
                .entity(trainer)
                .build();
    }
}

