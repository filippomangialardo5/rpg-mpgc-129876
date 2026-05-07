package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.Nemico;
import it.unicam.cs.mpgc.rpg129876.game.Evento;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

    private List<Stanza> stanze;
    private int posizioneCorrente;

    public Dungeon() {
        stanze = new ArrayList<>();
        posizioneCorrente = 0;

        generaDungeon();
    }

    private void generaDungeon() {

        stanze.add(new Stanza(
                "Ingresso",
                "L'ingresso del dungeon è freddo e silenzioso.",
                null,
                new Evento(
                        "Antico Portale",
                        "Un enorme portale alle tue spalle si chiude lentamente."
                )
        ));

        stanze.add(new Stanza(
                "Sala delle Ossa",
                "Ossa umane ricoprono il pavimento.",
                new Nemico("Scheletro", 40, 6),
                new Evento(
                        "Sussurri",
                        "Voci lontane sembrano chiamare il tuo nome."
                )
        ));

        stanze.add(new Stanza(
                "Corridoio Oscuro",
                "Un lungo corridoio immerso nell'oscurità.",
                new Nemico("Goblin", 50, 8),
                new Evento(
                        "Simbolo Misterioso",
                        "Un simbolo rosso pulsa sulle pareti del dungeon."
                )
        ));
    }

    public Stanza getStanzaCorrente() {
        return stanze.get(posizioneCorrente);
    }

    public boolean avanza() {

        if (posizioneCorrente < stanze.size() - 1) {
            posizioneCorrente++;
            return true;
        }

        return false;
    }

    public boolean dungeonCompletato() {
        return posizioneCorrente == stanze.size() - 1;
    }
}