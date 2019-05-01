package ProyectoFinal;

public class Vehiculos{

    protected String nombre;
    private int nivel;
    private int experiencia;
    protected int PuntosVida;
    protected int PuntosPoder;
    private boolean estado;
    private int enemigosDestruidos;
    private int cantDestruido;


    public Vehiculos(){
        this.nombre = "";
        this.nivel = 1;
        this.experiencia = 0;
        this.PuntosPoder = 5;
        this.PuntosVida = 50;
        this.estado = true; //true = activo, false = destruido
        this.enemigosDestruidos = 0;
        this.cantDestruido = 0;
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

}
