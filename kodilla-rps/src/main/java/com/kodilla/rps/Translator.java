package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public class Translator {
    private Map<String, String> translateMapEnPl = new HashMap<>();


    public Translator() {
        translateMapEnPl.put("Rock", "Kamień");
        translateMapEnPl.put("Scissors", "Nożyce");
        translateMapEnPl.put("Paper", "Papier");
    }

    public String translateEnPl(String word) {
        return translateMapEnPl.get(word);
    }

}
