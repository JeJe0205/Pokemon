package ch.bzz.pokemon.model;

public class Trainer {
    private String trainerID;
    private String trainer;
    private String ort;

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
