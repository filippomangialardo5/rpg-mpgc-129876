package it.unicam.cs.mpgc.rpg129876;

import it.unicam.cs.mpgc.rpg129876.game.*;
import it.unicam.cs.mpgc.rpg129876.item.Pozione;
import it.unicam.cs.mpgc.rpg129876.model.*;

public class Main {

    public static void main(String[] args) {

        Giocatore giocatore = new Giocatore("Eroe");

        // AGGIUNTA INVENTARIO
        Pozione pozione = new Pozione(
                "Pozione Piccola",
                "Recupera 20 HP",
                20
        );

        giocatore.getInventario().aggiungiOggetto(pozione);

        System.out.println("\nInventario:");
        giocatore.getInventario().mostraInventario();

        Dungeon dungeon = new Dungeon();

        do {

            Stanza stanza = dungeon.getStanzaCorrente();

            System.out.println("\n=== " + stanza.getNome() + " ===");
            System.out.println(stanza.getDescrizione());

            if (stanza.getEvento() != null) {
                stanza.getEvento().mostraEvento();
            }

            if (stanza.haNemico()) {

                System.out.println("Un nemico appare: "
                        + stanza.getNemico().getNome());

                Combattimento combattimento =
                        new Combattimento(giocatore, stanza.getNemico());

                combattimento.eseguiCombattimento();

                for (String log : combattimento.getLog()) {
                    System.out.println(log);
                }
            }

        } while (dungeon.avanza() && giocatore.isVivo());

        if (giocatore.isVivo()) {
            System.out.println("\nHai completato il dungeon!");
        } else {
            System.out.println("\nGame Over");
        }
    }
}