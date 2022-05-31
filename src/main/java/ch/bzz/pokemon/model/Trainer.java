package ch.bzz.pokemon.model;

/**
 * a pokemon trainer
 */
public class Trainer {
    private String trainerID;
    private String trainer;
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
