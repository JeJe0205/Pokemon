package ch.bzz.pokemon.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * a pokemon trainer
 */
public class Trainer {
    @FormParam("trainerID")
    @Pattern(regexp = "ID-\\d{1,2}" )
    @NotEmpty
    private String trainerID;
    @FormParam("trainer")
    @NotEmpty
    @Size(min=1, max=10)
    private String trainer;
    @FormParam("ort")
    @NotEmpty
    @Size(min=1, max=20)
    private String ort;

    /**
     * gets trainer
     *
     * @return value of trainer
     */
    public String getTrainer() {
        return trainer;
    }

    /**
     * sets trainer
     *
     * @param trainer the value to set
     */

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    /**
     * gets trainerID
     *
     * @return value of trainerID
     */
    public String getTrainerID() {
        return trainerID;
    }

    /**
     * sets trainerID
     *
     * @param trainerID the value to set
     */

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    /**
     * gets ort
     *
     * @return value of ort
     */
    public String getOrt() {
        return ort;
    }

    /**
     * sets ort
     *
     * @param ort the value to set
     */

    public void setOrt(String ort) {
        this.ort = ort;
    }


}
