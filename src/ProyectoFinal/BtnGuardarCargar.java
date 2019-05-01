package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnGuardarCargar extends JButton{
    Ventana ventana;

    public BtnGuardarCargar(JPanel panelMenu, Ventana ventana){
        this.setText("Guardar/Cargar");
        this.setFont(new Font("cooper black", 1, 18));
        this.setBounds(275, 450, 200, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnGuardarCargar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guardar/Cargar");
            }
        };
        this.addActionListener(oyenteBtnGuardarCargar);
    }
}
