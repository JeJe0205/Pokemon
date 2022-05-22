package ch.bzz.pokemon.model;

public class Trainer {
    private String trainerID;
    private String trainer;
    private String ort;

    public String getTrainerID() {
        return trainerID;
    }

    public void setTrainerID(String trainerID) {
        this.trainerID = trainerID;
    }

    public String getVorname() {
        return trainer;
    }

    public void setVorname(String vorname) {
        this.trainer = vorname;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
}
