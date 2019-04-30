package ProyectoFinal;

public class Vehiculos{

    protected String nombre;
    protected int nivel;
    protected int experiencia;
    protected int PuntosVida;
    protected int PuntosPoder;

    public Vehiculos(){
        this.nombre = "";
        this.nivel = 1;
        this.experiencia = 0;
        this.PuntosPoder = 5;
        this.PuntosVida = 50;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosPoder() {
        return PuntosPoder;
    }

    public void setPuntosPoder(int puntosPoder) {
        PuntosPoder = puntosPoder;
    }

    public int getPuntosVida() {
        return PuntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        PuntosVida = puntosVida;
    }
}
