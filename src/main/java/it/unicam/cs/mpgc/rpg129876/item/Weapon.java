package it.unicam.cs.mpgc.rpg129876.item;

public class Weapon extends Item {

    private int bonusAttacco;

    public Weapon(String nome,
                  int bonusAttacco) {

        super(nome, ItemType.WEAPON);

        this.bonusAttacco = bonusAttacco;
    }

    public int getBonusAttacco() {

        return bonusAttacco;
    }

    @Override
    public String toString() {

        return getNome()
                + " (ATK +"
                + bonusAttacco
                + ")";
    }
}