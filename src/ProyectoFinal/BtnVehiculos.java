package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnVehiculos extends JButton{
    Ventana ventana;

    public BtnVehiculos(JPanel panelMenu, Ventana ventana){
        this.setText("Vehiculos");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(305, 225, 140, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnVehiculos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Vehiculos");
            }
        };
        this.addActionListener(oyenteBtnVehiculos);
    }
}