package ProyectoFinal;

import javax.swing.*;
import java.awt.*;

public class Casilla extends JButton{
    private Vehiculos vehiculo;
    private int vida;
    private boolean destruible;
    protected BtnJugar btnJugar;

    public Casilla(){

        vehiculo = null;
        destruible = false;
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

    public boolean isDestruible() {
        return destruible;
    }

    public void setDestruible(boolean destruible) {
        this.destruible = destruible;
    }
}
