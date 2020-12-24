package com.example.demoh;

import java.util.HashMap;

public class DataUsersPrivateChat {
    private static HashMap<String, String> lodinParolUsersPrivateChat= new HashMap<>();

    public DataUsersPrivateChat() {

    }

    public static HashMap<String, String> getLodinParolUser() {
        lodinParolUsersPrivateChat.put("galina","1122");
        lodinParolUsersPrivateChat.put("nataliy","1133");
        lodinParolUsersPrivateChat.put("sergey","1144");
        return lodinParolUsersPrivateChat;
    }
}
