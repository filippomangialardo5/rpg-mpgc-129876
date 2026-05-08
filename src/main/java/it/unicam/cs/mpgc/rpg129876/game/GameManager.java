package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.Giocatore;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Giocatore giocatore;
    private Dungeon dungeon;

    public GameManager() {
        giocatore = new Giocatore("Eroe");
        dungeon = new Dungeon();
    }

    public List<String> esploraStanza() {

        List<String> output = new ArrayList<>();

        Stanza stanza = dungeon.getStanzaCorrente();

        output.add("\n=== " + stanza.getNome() + " ===");
        output.add(stanza.getDescrizione());

        if (stanza.getEvento() != null) {
            output.add("[EVENTO]");
            output.add(stanza.getEvento().getTitolo());
            output.add(stanza.getEvento().getDescrizione());
        }

        if (stanza.haNemico()) {

            output.add("Un nemico appare: "
                    + stanza.getNemico().getNome());

            Combattimento combattimento =
                    new Combattimento(giocatore, stanza.getNemico());

            combattimento.eseguiCombattimento();

            output.addAll(combattimento.getLog());
        }

        dungeon.avanza();

        return output;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }
}