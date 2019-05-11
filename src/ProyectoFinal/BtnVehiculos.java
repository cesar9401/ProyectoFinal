package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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
                eventoVehiculos();
            }
        };
        this.addActionListener(oyenteBtnVehiculos);
    }

    public void eventoVehiculos(){
        JFrame ventanaVehiculos = new JFrame("Dark Side - Vehicles");
        ventanaVehiculos.setSize(750, 650);
        ventanaVehiculos.setLocationRelativeTo(null);
        ventanaVehiculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaVehiculos.setLayout(null);

        JPanel panelVehiculos = new JPanel();
        panelVehiculos.setBounds(0, 80, 750, 570);

        TitledBorder bordeVehiculos = new TitledBorder("Dark Side - Vehicles");
        bordeVehiculos.setTitleJustification(TitledBorder.CENTER);
        bordeVehiculos.setTitleJustification(TitledBorder.TOP);
        panelVehiculos.setBorder(bordeVehiculos);
        panelVehiculos.setBackground(Color.LIGHT_GRAY);
        panelVehiculos.setLayout(null);

        ventana.panelInformacion.removeAll();
        ventana.inicializarLabels();
        ventanaVehiculos.add(ventana.panelInformacion);
        ventanaVehiculos.add(panelVehiculos);

        inicializarBotones(panelVehiculos);

        ventana.setVisible(false);
        ventanaVehiculos.setVisible(true);
    }

    public void inicializarBotones(JPanel panelVehiculos){

        JButton seleccionar = new JButton("Seleccionar Vehiculos");
        seleccionar.setFont(new Font("cooper black", 1, 18));
        seleccionar.setBounds(235, 40, 280, 50);
        panelVehiculos.add(seleccionar);

        JButton crear = new JButton("Crear Vehiculos");
        crear.setFont(new Font("cooper black", 1, 18));
        crear.setBounds(250, 120, 250, 50);
        panelVehiculos.add(crear);



    }
}