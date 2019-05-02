package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnJugar extends JButton{

    protected Ventana ventana;
    protected JFrame ventanaJugar = new JFrame("Dark Side - Playing");
    protected JPanel tablero;
    Casilla[][] Tablero1;

    public BtnJugar(JPanel panelMenu, Ventana ventana){
        this.setText("Jugar");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(325, 75, 100, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnJugar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBtnJugar();
            }
        };

        this.addActionListener(oyenteBtnJugar);

    }

    public void eventoBtnJugar(){
        ventanaJugar.setSize(750, 650);
        ventanaJugar.setLocationRelativeTo(null);
        ventanaJugar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJugar.setLayout(null);
        ventanaJugar.add(ventana.panelInformacion);

        tablero = new JPanel();
        tablero.setLayout(new GridLayout(4, 4));
        tablero.setBackground(Color.GRAY);
        tablero.setBounds(0, 80, 750, 670);

        TitledBorder bordeTablero = new TitledBorder("Dark Side - Playing");
        bordeTablero.setTitleJustification(TitledBorder.CENTER);
        bordeTablero.setTitleJustification(TitledBorder.TOP);
        tablero.setBorder(bordeTablero);

        ventanaJugar.add(tablero);
        ventana.setVisible(false);
        ventanaJugar.setVisible(true);

    }

}
