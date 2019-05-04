package ProyectoFinal;

public class Tanque extends Vehiculos{

    protected int ataque;
    protected int defensa;
    protected int punteria;

    public Tanque(){
        this.ataque = 10;
        this.defensa = 6;
        this.punteria = 60;
        this.tanque = true;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setPunteria(int punteria) {
        this.punteria = punteria;
    }

    public int getPunteria() {
        return punteria;
    }

    public boolean isTanque() {
        return tanque;
    }

    public void setTanque(boolean tanque) {
        this.tanque = tanque;
    }
}
