package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnJugar extends JButton{

        Ventana ventana;

    public BtnJugar(JPanel panelMenu, Ventana ventana){
        this.setText("Jugar");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(325, 75, 100, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnJugar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Jugando");
            }
        };

        this.addActionListener(oyenteBtnJugar);

    }

}
