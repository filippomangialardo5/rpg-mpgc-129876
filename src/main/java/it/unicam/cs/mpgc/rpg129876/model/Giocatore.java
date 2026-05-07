package it.unicam.cs.mpgc.rpg129876.model;

import it.unicam.cs.mpgc.rpg129876.game.Inventario;

public class Giocatore extends Personaggio {

    private int esperienza;
    private int livello;
    private Inventario inventario;

    public Giocatore(String nome) {
        super(nome, 100, 10);
        this.esperienza = 0;
        this.livello = 1;
        this.inventario = new Inventario();
    }

    public void guadagnaEsperienza(int exp) {
        this.esperienza += exp;

        if (esperienza >= 100) {
            livello++;
            esperienza = 0;
            vita += 20;
            attacco += 5;
        }
    }

    public int getLivello() {
        return livello;
    }

    public Inventario getInventario() {
        return inventario;
    }
}