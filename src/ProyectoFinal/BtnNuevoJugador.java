package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnNuevoJugador extends JButton{
    Ventana ventana;

    public BtnNuevoJugador(JPanel panelMenu, Ventana ventana){
        this.setText("Nuevo Jugador");
        this.setFont(new Font("cooper black", 1, 18));
        this.setBounds(275, 375, 200, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnNuevoJugador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nuevo Jugador");
            }
        };
        this.addActionListener(oyenteBtnNuevoJugador);

    }
}
