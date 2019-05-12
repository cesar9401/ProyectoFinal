package ProyectoFinal;

import javax.swing.*;

public class Casilla extends JButton{

    private Vehiculos vehiculo;
    private int vida;
    private boolean montaña;
    private boolean agua;
    protected int posX;
    protected int posY;

    ImageIcon tierra = new ImageIcon("tierra.jpg");
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("avion.gif");
    ImageIcon aguaIcon = new ImageIcon("agua.jpg");
    Ventana ventana;


    public Casilla(int posX, int posY){
        vehiculo = null;
        montaña = false;
        agua = false;
        vida = 0;
        this.posX = posX;
        this.posY = posY;

        /*ActionListener oyenteCasilla = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("posX: "+posX+" posY: "+posY);

                if(!isEmpty()){
                    System.out.println("nombre: "+vehiculo.getNombre());
                    System.out.println("vida: "+vehiculo.getPuntosVida());
                    ventana.control.posX.setText(""+posX);
                    ventana.control.posY.setText(""+posY);
                }
            }
        };
        this.addActionListener(oyenteCasilla);
        */

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
