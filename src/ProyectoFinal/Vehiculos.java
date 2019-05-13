package ProyectoFinal;

import java.io.Serializable;

public class Vehiculos implements Serializable{

    protected String nombre;
    private int nivel;
    private int experiencia;
    protected int PuntosVida;
    protected int PuntosPoder;
    private boolean estado;
    private int enemigosDestruidos;
    private int cantDestruido;
    protected boolean tanque;
    protected int ataque;
    private int partidasGanadas;
    private int partidasPerdidas;


    public Vehiculos(){
        this.nombre = "";
        this.nivel = 1;
        this.experiencia = 0;
        this.PuntosPoder = 5;
        this.PuntosVida = 50;
        this.estado = true; //true = activo, false = destruido
        this.enemigosDestruidos = 0;
        this.cantDestruido = 0;
        this.tanque = false;
        this.ataque = 0;
        this.partidasGanadas = 0;
        this.partidasPerdidas = 0;
    }

    public void establecerAtributos(){
        ataque = getNivel();
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

    public boolean isEstado() {
        return estado;
    }

    public int getCantDestruido() {
        return cantDestruido;
    }

    public int getEnemigosDestruidos() {
        return enemigosDestruidos;
    }

    public void setCantDestruido(int cantDestruido) {
        this.cantDestruido = cantDestruido;
    }

    public void setEnemigosDestruidos(int enemigosDestruidos) {
        this.enemigosDestruidos = enemigosDestruidos;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setTanque(boolean tanque) {
        this.tanque = tanque;
    }

    public boolean isTanque() {
        return tanque;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

}
