package it.unicam.cs.mpgc.rpg129876.model;

// classe abstract perche non si può creare un “Personaggio generico”
public abstract class Personaggio {

    // protected perché sarà accessibile da classi figlie
    protected String nome;
    protected int vita;
    protected int attacco;

    public Personaggio(String nome, int vita, int attacco) {
        this.nome = nome;
        this.vita = vita;
        this.attacco = attacco;
    }

    public void attacca(Personaggio nemico) {
        nemico.subisciDanno(this.attacco);
    }

    public String getNome() {
        return nome;
    }

    public int getVita() {
        return vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void subisciDanno(int danno) {
        vita -= danno;

        if (vita < 0) {
            vita = 0;
        }
    }

    public void cura(int valore) {vita += valore;}

    public boolean isVivo() {return vita > 0;}
}