package ch.bzz.pokemon.service;

import ch.bzz.pokemon.data.DataHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * test service
 */
@Path("test")
public class TestService {

    /**
     * confirms the application runs
     * @return  message
     */
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public Response listTyp() {

        return Response
                .status(200)
                .entity("Test passed")
                .build();
    }

    /**
     * restores the json-files
     * @return Response
     */
    @GET
    @Path("restore")
    @Produces(MediaType.TEXT_PLAIN)
    public Response restore() {
        try {
            java.nio.file.Path path = Paths.get(Config.getProperty("pokemonJSON"));
            String filename = path.getFileName().toString();
            String folder = path.getParent().toString();

            byte[] pokemonJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            FileOutputStream fileOutputStream = new FileOutputStream(Config.getProperty("pokemonJSON"));
            fileOutputStream.write(pokemonJSON);

            path = Paths.get(Config.getProperty("typJSON"));
            filename = path.getFileName().toString();
            folder = path.getParent().toString();

            byte[] typJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            fileOutputStream = new FileOutputStream(Config.getProperty("typJSON"));
            fileOutputStream.write(typJSON);

            path = Paths.get(Config.getProperty("trainerJSON"));
            filename = path.getFileName().toString();
            folder = path.getParent().toString();

            byte[] trainerJSON = Files.readAllBytes(Paths.get(folder, "backup", filename));
            fileOutputStream = new FileOutputStream(Config.getProperty("trainerJSON"));
            fileOutputStream.write(trainerJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataHandler.initLists();
        return Response
                .status(200)
                .entity("Erfolgreich")
                .build();
    }
}