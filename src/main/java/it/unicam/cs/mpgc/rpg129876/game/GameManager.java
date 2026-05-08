package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.Giocatore;
import it.unicam.cs.mpgc.rpg129876.model.Nemico;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Giocatore giocatore;
    private Dungeon dungeon;
    private Nemico nemicoCorrente;
    private boolean inCombattimento;

    public GameManager() {
        giocatore = new Giocatore("Eroe");
        dungeon = new Dungeon();
        inCombattimento=false;
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

            nemicoCorrente = stanza.getNemico();
            inCombattimento = true;

            output.add("Il combattimento ha inizio!");
        }

        dungeon.avanza();

        return output;
    }

    public Giocatore getGiocatore() {
        return giocatore;
    }

    public boolean isInCombattimento() {
        return inCombattimento;
    }

    public List<String> attacca() {

        List<String> output = new ArrayList<>();

        if (!inCombattimento) {
            output.add("Nessun nemico presente.");
            return output;
        }

        int dannoGiocatore = giocatore.getAttacco();
        nemicoCorrente.subisciDanno(dannoGiocatore);

        output.add("Hai inflitto "
                + dannoGiocatore
                + " danni a "
                + nemicoCorrente.getNome());

        if (!nemicoCorrente.isVivo()) {

            output.add("Hai sconfitto il nemico!");

            giocatore.guadagnaEsperienza(50);

            inCombattimento = false;
            nemicoCorrente = null;

            return output;
        }

        int dannoNemico = nemicoCorrente.getAttacco();

        giocatore.subisciDanno(dannoNemico);

        output.add(nemicoCorrente.getNome()
                + " ti colpisce per "
                + dannoNemico
                + " danni.");

        if (!giocatore.isVivo()) {
            output.add("GAME OVER");
        }

        return output;
    }

    public List<String> cura() {

        List<String> output = new ArrayList<>();

        giocatore.cura(20);

        output.add("Hai recuperato 20 HP.");

        return output;
    }

    public List<String> fuggi() {

        List<String> output = new ArrayList<>();

        if (!inCombattimento) {
            output.add("Non c'è nessun nemico.");
            return output;
        }

        inCombattimento = false;
        nemicoCorrente = null;

        output.add("Sei fuggito dal combattimento.");

        return output;
    }
}