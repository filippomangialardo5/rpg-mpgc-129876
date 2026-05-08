package it.unicam.cs.mpgc.rpg129876.game;

public class Dungeon {

    private Stanza stanzaCorrente;

    public Dungeon() {

        Stanza ingresso = new Stanza(
                "Ingresso",
                "L'entrata del dungeon."
        );

        Stanza corridoio = new Stanza(
                "Corridoio",
                "Un corridoio oscuro e silenzioso."
        );

        Stanza tesoro = new Stanza(
                "Tesoro",
                "Una stanza piena di oro e reliquie."
        );

        Stanza boss = new Stanza(
                "Boss Room",
                "Una presenza terrificante riempie la stanza."
        );

        ingresso.collegaStanza(Direzione.NORD, corridoio);

        corridoio.collegaStanza(Direzione.SUD, ingresso);
        corridoio.collegaStanza(Direzione.EST, tesoro);
        corridoio.collegaStanza(Direzione.NORD, boss);

        tesoro.collegaStanza(Direzione.OVEST, corridoio);

        boss.collegaStanza(Direzione.SUD, corridoio);

        stanzaCorrente = ingresso;
    }

    public Stanza getStanzaCorrente() {
        return stanzaCorrente;
    }

    public boolean muovi(Direzione direzione) {

        Stanza prossima =
                stanzaCorrente.getStanza(direzione);

        if (prossima == null) {
            return false;
        }

        stanzaCorrente = prossima;

        return true;
    }
}