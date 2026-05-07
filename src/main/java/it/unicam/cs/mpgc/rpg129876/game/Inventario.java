package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.item.Oggetto;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Oggetto> oggetti;

    public Inventario() {
        oggetti = new ArrayList<>();
    }

    public void aggiungiOggetto(Oggetto oggetto) {
        oggetti.add(oggetto);
    }

    public List<Oggetto> getOggetti() {
        return oggetti;
    }

    public void mostraInventario() {

        if (oggetti.isEmpty()) {
            System.out.println("Inventario vuoto");
            return;
        }

        for (Oggetto oggetto : oggetti) {
            System.out.println("- " + oggetto.getNome());
        }
    }
}