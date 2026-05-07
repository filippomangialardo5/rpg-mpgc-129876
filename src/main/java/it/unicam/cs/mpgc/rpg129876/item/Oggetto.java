package it.unicam.cs.mpgc.rpg129876.item;

// classe astratta perché è la base comune per tutti gli item
public abstract class Oggetto {

    protected String nome;
    protected String descrizione;

    public Oggetto(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }
}