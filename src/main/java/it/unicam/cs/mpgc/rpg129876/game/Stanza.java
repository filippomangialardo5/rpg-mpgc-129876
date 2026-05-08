package it.unicam.cs.mpgc.rpg129876.game;

import it.unicam.cs.mpgc.rpg129876.model.Nemico;

import java.util.HashMap;
import java.util.Map;

public class Stanza {

    private String nome;
    private String descrizione;

    private Nemico nemico;

    private Evento evento;

    private Map<Direzione, Stanza> uscite;

    public Stanza(String nome,
                  String descrizione) {

        this.nome = nome;
        this.descrizione = descrizione;

        this.nemico = null;
        this.evento = null;

        uscite = new HashMap<>();
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

    public Evento getEvento() {
        return evento;
    }

    public void setNemico(Nemico nemico) {
        this.nemico = nemico;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean haNemico() {
        return nemico != null;
    }

    public void collegaStanza(Direzione direzione,
                              Stanza stanza) {

        uscite.put(direzione, stanza);
    }

    public Stanza getStanza(Direzione direzione) {

        return uscite.get(direzione);
    }

    public Map<Direzione, Stanza> getUscite() {

        return uscite;
    }
}