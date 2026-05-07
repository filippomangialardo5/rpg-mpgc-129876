package it.unicam.cs.mpgc.rpg129876.game;

public class Evento {

    private String titolo;
    private String descrizione;

    public Evento(String titolo, String descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void mostraEvento() {

        System.out.println("\n[EVENTO]");
        System.out.println(titolo);
        System.out.println(descrizione);
    }
}