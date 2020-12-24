package com.example.demoh;

import java.util.ArrayList;

public class ListMessadesPrivatChat {
    private static ArrayList<Messag> listPrivatChat = new ArrayList<>();

    public ListMessadesPrivatChat() {
    }

    public static ArrayList<Messag> getListPrivatChat() {
        return listPrivatChat;
    }

    public synchronized void  addMassege(Messag message) {
         listPrivatChat.add(message);
    }
}
