package ProyectoFinal;

import javax.swing.*;

public class Ventana extends JFrame{

    public Ventana(String nombreV){
        super(nombreV);
        this.setTitle(nombreV);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
