package ProyectoFinal;

public class Tanque extends Vehiculos{

    protected int ataque;
    protected int defensa;
    protected int punteria;

    public Tanque(){
        this.ataque = 25;
        this.defensa = 5;
        this.punteria = 75;
        this.tanque = true;
    }

    @Override
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    @Override
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
