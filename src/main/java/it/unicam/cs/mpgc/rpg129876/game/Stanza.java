package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.Nemico;

public class Stanza {

    private String nome;
    private String descrizione;
    private Nemico nemico;
    private Evento evento;

    public Stanza(String nome,
                  String descrizione,
                  Nemico nemico,
                  Evento evento) {

        this.nome = nome;
        this.descrizione = descrizione;
        this.nemico = nemico;
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Nemico getNemico() {
        return nemico;
    }

    public Evento getEvento() {return evento;}
    
    public boolean haNemico() {
        return nemico != null && nemico.isVivo();
    }
}