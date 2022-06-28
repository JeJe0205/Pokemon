package ch.bzz.pokemon.data;

import ch.bzz.pokemon.model.User;
import ch.bzz.pokemon.service.Config;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static final UserData instance = new UserData();

    public static User findUser(String username, String passwort){
        User user = new User();
        List<User> userList = readJson();

        for (User entry: userList){
            if (entry.getUsername().equals(username) && entry.getPasswort().equals(passwort)){
                user = entry;
            }

        }
        return user;
    }

    private static List<User> readJson(){
        List<User> userList = new ArrayList<>();
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(Config.getProperty("userJSON")));
            ObjectMapper objectMapper = new ObjectMapper();
            User[] users = objectMapper.readValue(jsonData, User[].class);
            for (User user : users){
                userList.add(user);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return userList;
    }
}
