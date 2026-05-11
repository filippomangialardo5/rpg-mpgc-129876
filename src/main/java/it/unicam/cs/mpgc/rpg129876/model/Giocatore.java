package it.unicam.cs.mpgc.rpg129876.model;

import it.unicam.cs.mpgc.rpg129876.game.Inventario;
import it.unicam.cs.mpgc.rpg129876.item.Item;
import it.unicam.cs.mpgc.rpg129876.item.Weapon;
import it.unicam.cs.mpgc.rpg129876.item.ItemType;

import java.util.ArrayList;
import java.util.List;

public class Giocatore extends Personaggio {

    private int esperienza;
    private int livello;
    private List<Item> inventario;
    private Weapon armaEquipaggiata;

    public Giocatore(String nome) {
        super(nome, 100, 10);
        this.esperienza = 0;
        this.livello = 1;
        inventario = new ArrayList<>();
        armaEquipaggiata = null;
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

    public int getEsperienza() {
        return esperienza;
    }

    public void aggiungiItem(Item item) {

        inventario.add(item);
    }

    public List<Item> getInventario() {

        return inventario;
    }

    public void equipaggiaArma(Weapon weapon) {

        armaEquipaggiata = weapon;
    }

    public Weapon getArmaEquipaggiata() {

        return armaEquipaggiata;
    }

    public int getAttaccoTotale() {

        int bonus = 0;

        if (armaEquipaggiata != null) {

            bonus =
                    armaEquipaggiata.getBonusAttacco();
        }

        return getAttacco() + bonus;
    }

    public boolean usaPozione() {

        for (int i = 0;
             i < inventario.size();
             i++) {

            Item item = inventario.get(i);

            if (item.getTipo()
                    == ItemType.POTION) {

                inventario.remove(i);

                setVita(getVita() + 20);

                return true;
            }
        }

        return false;
    }
}