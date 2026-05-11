package it.unicam.cs.mpgc.rpg129876.item;

public class Item {

    private String nome;

    private ItemType tipo;

    public Item(String nome,
                ItemType tipo) {

        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public ItemType getTipo() {
        return tipo;
    }

    @Override
    public String toString() {

        return nome;
    }
}