package ch.bzz.pokemon.model;

public class User {
    private String userUUID;
    private String username;
    private String passwort;
    private String role;


    /**
     * gets userUUID
     *
     * @return value of userUUID
     */

    public String getUserUUID() {
        return userUUID;
    }

    /**
     * sets userUUID
     *
     * @param userUUID the value to set
     */

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    /**
     * gets username
     *
     * @return value of username
     */

    public String getUsername() {
        return username;
    }

    /**
     * sets username
     *
     * @param username the value to set
     */

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * gets password
     *
     * @return value of password
     */

    public String getPasswort() {
        return passwort;
    }

    /**
     * sets password
     *
     * @param passwort the value to set
     */

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    /**
     * gets role
     *
     * @return value of role
     */

    public String getRole() {
        return role;
    }

    /**
     * sets role
     *
     * @param role the value to set
     */

    public void setRole(String role) {
        this.role = role;
    }
}

