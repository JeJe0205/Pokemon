package ch.bzz.pokemon.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

public class Typ {
    @FormParam("typ")
    @NotEmpty
    @Size(min=1, max=20)
    private String typ;
    @FormParam("typID")
    @NotEmpty
    @Pattern(regexp = "ID-\\d{1,2}" )
    private String typID;


    /**
     * gets typ
     *
     * @return value of typ
     */
    public String getTyp() {
        return typ;
    }

    /**
     * sets typ
     *
     * @param typ the value to set
     */

    public void setTyp(String typ) {
        this.typ = typ;
    }

    /**
     * gets typID
     *
     * @return value of typiD
     */

    public String getTypID() {
        return typID;
    }

    /**
     * sets publisherUUID
     *
     * @param typID the value to set
     */

    public void setTypID(String typID) {
        this.typID = typID;
    }

}
