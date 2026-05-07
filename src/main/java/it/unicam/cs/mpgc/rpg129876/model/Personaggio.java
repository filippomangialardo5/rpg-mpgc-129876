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

    public void subisciDanno(int danno) {
        this.vita -= danno;
        if (this.vita < 0) {
            this.vita = 0;
        }
    }

    public boolean isVivo() {
        return vita > 0;
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

    public void cura(int puntiVita) {
        this.vita += puntiVita;
    }
}