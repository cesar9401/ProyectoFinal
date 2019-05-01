package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnTienda extends JButton{
    Ventana ventana;

    public BtnTienda(JPanel panelMenu, Ventana ventana){
        this.setText("Tienda");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(315, 150, 120, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnTienda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tienda");
            }
        };

        this.addActionListener(oyenteBtnTienda);
    }
}
