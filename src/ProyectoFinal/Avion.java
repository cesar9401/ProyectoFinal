package ProyectoFinal;

public class Avion extends Vehiculos{

    protected int ataque;
    protected int defensa;
    protected int punteria;
    protected int velocidad;

    public Avion(){
        this.ataque = 7;
        this.defensa = 3;
        this.punteria = 70;
        this.velocidad = 1;
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

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }
}
