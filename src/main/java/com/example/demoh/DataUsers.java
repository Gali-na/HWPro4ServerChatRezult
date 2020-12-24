package com.example.demoh;

import java.util.HashMap;

public class DataUsers {
    private static HashMap<String, String> lodinParolUser= new HashMap<>();

    public DataUsers() {

    }

    public static HashMap<String, String> getLodinParolUser() {
        lodinParolUser.put("galina","1122");
        lodinParolUser.put("nataliy","1133");
        lodinParolUser.put("sergey","1144");
        lodinParolUser.put("andrey","1155");
        lodinParolUser.put("anton","1166");
        return lodinParolUser;
    }

    public synchronized void addDataUser(String login, String parol) {

        lodinParolUser.put(login, parol);
    }

}
