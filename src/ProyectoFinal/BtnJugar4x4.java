package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnJugar4x4 extends JButton{

    protected Ventana ventana;
    protected JFrame ventanaJugar1 = new JFrame("Dark Side - Playing");
    protected JPanel tablero4x4, panelVs1;
    //JButton rendirse = new JButton("Rendirse");


    public BtnJugar4x4(JPanel panelMenu, Ventana ventana){
        this.setText("Jugar 4x4");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(75, 75, 150, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnJugar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBtnJugar4x4();
            }
        };

        this.addActionListener(oyenteBtnJugar);

    }

    public void eventoBtnJugar4x4(){
        ventanaJugar1.setSize(1000, 680);
        ventanaJugar1.setLocationRelativeTo(null);
        ventanaJugar1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaJugar1.setLayout(null);

        tablero4x4 = new JPanel();
        tablero4x4.setLayout(new GridLayout(4, 4));
        tablero4x4.setBackground(Color.GRAY);
        tablero4x4.setBounds(125, 80, 750, 570);

        TitledBorder bordeTablero = new TitledBorder("Dark Side - Playing 4x4");
        bordeTablero.setTitleJustification(TitledBorder.CENTER);
        bordeTablero.setTitleJustification(TitledBorder.TOP);
        tablero4x4.setBorder(bordeTablero);

        ventana.control.panelsYBotonesJugar(4, 4, tablero4x4, panelVs1, ventanaJugar1, ventana.control.Tablero1);
        ventana.control.getTablero(4, 4,140, 185, 4, ventana.control.Tablero1);

        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tablero4x4.add(ventana.control.Tablero1[i][j]);
            }
        }

        ventanaJugar1.add(tablero4x4);
        ventana.setVisible(false);
        ventanaJugar1.setVisible(true);

        ventana.control.jugar(4, 4, ventana.control.Tablero1, ventanaJugar1);

    }


}
