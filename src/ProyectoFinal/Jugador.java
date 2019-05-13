package ProyectoFinal;

import java.io.Serializable;

public class Jugador implements Serializable{

    private String nombre;
    private int oro;
    private int experiencia;
    private int nivel;
    private int partidasGanadas;
    protected int partidasPerdidas;

    public Jugador() {
        this.nombre = "";
        this.oro = 1000;
        this.experiencia = 0;
        this.nivel = 1;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
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

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public int getPartidas_Perdidas() {
        return partidasPerdidas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public void setPartidas_Perdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
}
