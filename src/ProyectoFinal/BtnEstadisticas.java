package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnEstadisticas extends JButton {
   Ventana ventana;

    public BtnEstadisticas(JPanel panelMenu, Ventana ventana) {
        this.setText("Estadisticas");
        this.setFont(new Font("cooper black", 1, 18));
        this.setBounds(295, 300, 160, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnEstadisticas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Estadisticas");
            }
        };
        this.addActionListener(oyenteBtnEstadisticas);
    }
}
