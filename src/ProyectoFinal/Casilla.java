package ProyectoFinal;

import javax.swing.*;

public class Casilla extends JButton{
    private Vehiculos vehiculo;
    private int vida;
    private boolean montaña;
    private boolean agua;
    protected int posX;
    protected int posY;


    public Casilla(){
        vehiculo = null;
        montaña = false;
        agua = false;
        vida = 0;
    }

    public boolean isEmpty()
    {
        if(vehiculo == null)
            return true;
        return false;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public boolean isAgua() {
        return agua;
    }

    public boolean isMontaña() {
        return montaña;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }

    public void setMontaña(boolean montaña) {
        this.montaña = montaña;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
