package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.*;

import java.util.ArrayList;
import java.util.List;

public class Combattimento {

    private Giocatore giocatore;
    private Nemico nemico;
    private List<String> log;

    public Combattimento(Giocatore giocatore, Nemico nemico) {
        this.giocatore = giocatore;
        this.nemico = nemico;
        this.log = new ArrayList<>();
    }

    public void eseguiCombattimento() {

        log.add("Inizia il combattimento tra " + giocatore.getNome() +
                " e " + nemico.getNome());

        while (giocatore.isVivo() && nemico.isVivo()) {

            turnoGiocatore();

            if (nemico.isVivo()) {
                turnoNemico();
            }
        }

        if (giocatore.isVivo()) {
            log.add("Il giocatore ha vinto!");
            giocatore.guadagnaEsperienza(50);
        } else {
            log.add("Il giocatore è stato sconfitto...");
        }
    }

    private void turnoGiocatore() {
        nemico.subisciDanno(giocatore.getAttacco());
        log.add(giocatore.getNome() + " attacca e infligge danno.");
    }

    private void turnoNemico() {
        giocatore.subisciDanno(nemico.getAttacco());
        log.add(nemico.getNome() + " attacca e infligge danno.");
    }

    public List<String> getLog() {
        return log;
    }
}