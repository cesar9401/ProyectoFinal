package ProyectoFinal;

public class Jugador{

    private String nombre;
    private int oro;
    private int experiencia;
    private int nivel;

    public Jugador() {
        this.nombre = "Player1";
        this.oro = 0;
        this.experiencia = 0;
        this.nivel = 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

}
