package ProyectoFinal;

public class Boot{
    protected int turnos;
    protected int dañoDisparo;
    protected int dañoExplosion;
    protected boolean estado;

    public Boot(){
        this.turnos = 0;
        this.dañoDisparo = 75;
        this.dañoExplosion = 75;
        this.estado = false;
    }

    public int getDañoDisparo() {
        return dañoDisparo;
    }

    public int getDañoExplosion() {
        return dañoExplosion;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setDañoDisparo(int dañoDisparo) {
        this.dañoDisparo = dañoDisparo;
    }

    public void setDañoExplosion(int dañoExplosion) {
        this.dañoExplosion = dañoExplosion;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }
}
