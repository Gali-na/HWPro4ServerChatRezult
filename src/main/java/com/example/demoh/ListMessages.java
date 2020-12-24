package com.example.demoh;

import java.util.ArrayList;

public class ListMessages {
    private static ArrayList<Messag> messages = new ArrayList<>();

    public ListMessages() {
    }

    public static ArrayList<Messag> getLisMessages() {

        return messages;
    }

    public synchronized void  addMassege(Messag message) {

        messages.add(message);
    }
    @Override
    public String toString() {
       StringBuilder builder = new StringBuilder();
       for (Messag m : messages){
           builder.append(m);
           builder.append("\n");
       }

       return builder.toString();
    }
}
