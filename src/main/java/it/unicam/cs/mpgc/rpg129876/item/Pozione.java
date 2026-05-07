package it.unicam.cs.mpgc.rpg129876.item;

import it.unicam.cs.mpgc.rpg129876.model.Giocatore;

public class Pozione extends Oggetto {

    private int cura;

    public Pozione(String nome, String descrizione, int cura) {
        super(nome, descrizione);
        this.cura = cura;
    }

    public void usa(Giocatore giocatore) {
        giocatore.cura(cura);
    }

    public int getCura() {
        return cura;
    }
}