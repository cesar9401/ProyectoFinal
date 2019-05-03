package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnJugar6x4 extends JButton{

    protected Ventana ventana;
    protected JFrame ventanaJugar2 = new JFrame("Dark Side - Playing");
    protected JPanel tablero6x4;


    public BtnJugar6x4(JPanel panelMenu, Ventana ventana){
        this.setText("Jugar 6x4");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(300, 75, 150, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnJugar6x4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBtnJugar6x4();
            }
        };

        this.addActionListener(oyenteBtnJugar6x4);

    }

    public void eventoBtnJugar6x4(){
        ventanaJugar2.setSize(750, 680);
        ventanaJugar2.setLocationRelativeTo(null);
        ventanaJugar2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJugar2.setLayout(null);
        ventanaJugar2.add(ventana.panelInformacion);

        tablero6x4 = new JPanel();
        tablero6x4.setLayout(new GridLayout(6, 4));
        tablero6x4.setBackground(Color.GRAY);
        tablero6x4.setBounds(0, 80, 750, 570);

        TitledBorder bordeTablero = new TitledBorder("Dark Side - Playing 6x4");
        bordeTablero.setTitleJustification(TitledBorder.CENTER);
        bordeTablero.setTitleJustification(TitledBorder.TOP);
        tablero6x4.setBorder(bordeTablero);

        //ventana.control.getTablero1();
        ventana.control.getTablero2();
        //ventana.control.getTablero3();

        ventanaJugar2.add(tablero6x4);
        ventana.setVisible(false);
        ventanaJugar2.setVisible(true);
    }

}
