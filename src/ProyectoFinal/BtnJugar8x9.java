package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnJugar8x9 extends JButton{

    protected Ventana ventana;
    protected JFrame ventanaJugar3 = new JFrame("Dark Side - Playing");
    protected JPanel tablero8x9;

    public BtnJugar8x9(JPanel panelMenu, Ventana ventana){
        this.setText("Jugar 8x9");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(525, 75, 150, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnJugar8x9 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBtnJugar8x9();
            }
        };

        this.addActionListener(oyenteBtnJugar8x9);

    }

    public void eventoBtnJugar8x9(){
        ventanaJugar3.setSize(750, 680);
        ventanaJugar3.setLocationRelativeTo(null);
        ventanaJugar3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJugar3.setLayout(null);
        ventanaJugar3.add(ventana.panelInformacion);

        tablero8x9 = new JPanel();
        tablero8x9.setLayout(new GridLayout(8, 9));
        tablero8x9.setBackground(Color.GRAY);
        tablero8x9.setBounds(0, 80, 750, 570);

        TitledBorder bordeTablero = new TitledBorder("Dark Side - Playing 8x9");
        bordeTablero.setTitleJustification(TitledBorder.CENTER);
        bordeTablero.setTitleJustification(TitledBorder.TOP);
        tablero8x9.setBorder(bordeTablero);

        ventana.control.getTablero(8, 9,71, 83, 18, ventana.control.Tablero3);
        for(int i=0; i<8; i++){
            for(int j=0; j<9; j++){
                tablero8x9.add(ventana.control.Tablero3[i][j]);
            }
        }

        //ventana.control.getTablero1();
        //ventana.control.getTablero2();
        //ventana.control.getTablero3();

        ventanaJugar3.add(tablero8x9);
        ventana.setVisible(false);
        ventanaJugar3.setVisible(true);


    }

}

