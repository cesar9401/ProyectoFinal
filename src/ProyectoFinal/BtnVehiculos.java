package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnVehiculos extends JButton{
    Ventana ventana;
    Casilla[][] casillasVehiculos = new Casilla[5][6];
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("halconMilenario.jpg");
    int contador;

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
                contador = 0;
            }
        };
        this.addActionListener(oyenteBtnVehiculos);
    }

    public void eventoVehiculos(){
        JFrame ventanaVehiculos = new JFrame("Dark Side - Vehicles");
        ventanaVehiculos.setSize(750, 490);
        ventanaVehiculos.setLocationRelativeTo(null);
        ventanaVehiculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaVehiculos.setLayout(null);

        JPanel panelVehiculos = new JPanel();
        panelVehiculos.setBounds(0, 80, 750, 380);

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

        inicializarBotones(ventanaVehiculos, panelVehiculos);

        ventana.setVisible(false);
        ventanaVehiculos.setVisible(true);
    }

    public void inicializarBotones(JFrame ventanaVehiculos, JPanel panelVehiculos){

        JButton seleccionar = new JButton("Seleccionar Vehiculos");
        seleccionar.setFont(new Font("cooper black", 1, 18));
        seleccionar.setBounds(235, 40, 280, 50);
        panelVehiculos.add(seleccionar);

        ActionListener oyenteSeleccionar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoSeleccionar(ventanaVehiculos);
            }
        };
        seleccionar.addActionListener(oyenteSeleccionar);

        JButton verEnemigos = new JButton("Vehiculos Enemigos");
        verEnemigos.setFont(new Font("cooper black", 1, 18));
        verEnemigos.setBounds(250, 120, 250, 50);
        panelVehiculos.add(verEnemigos);

        ActionListener oyenteVerEnemigos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        verEnemigos.addActionListener(oyenteVerEnemigos);

        JButton verVehiculos = new JButton("Ver mis Vehiculos");
        verVehiculos.setFont(new Font("cooper black", 1, 18));
        verVehiculos.setBounds(250, 200, 250, 50);
        panelVehiculos.add(verVehiculos);

        ActionListener oyenteVerVehiculos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoVerVehiculos(ventanaVehiculos);
            }
        };
        verVehiculos.addActionListener(oyenteVerVehiculos);


        JButton regresar = new JButton("Regresar");
        regresar.setFont(new Font("cooper black", 1, 18));
        regresar.setBounds(310, 280, 130, 50);
        panelVehiculos.add(regresar);

        ActionListener oyenteRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaVehiculos.setVisible(false);
                ventanaVehiculos.removeAll();
                ventana.panelInformacion.removeAll();
                ventana.inicializarLabels();
                ventana.add(ventana.panelInformacion);
                ventana.setVisible(true);
            }
        };
        regresar.addActionListener(oyenteRegresar);
    }

    public void eventoVerVehiculos(JFrame ventanaVehiculos){
        JDialog seleccionarVehiculos = new JDialog(ventanaVehiculos, "Dark Side - Vehicles");
        seleccionarVehiculos.setSize(600, 600);
        seleccionarVehiculos.setLayout(null);
        seleccionarVehiculos.setLocationRelativeTo(null);

        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(0, 0, 600, 80);
        panelInfo.setBackground(Color.LIGHT_GRAY);
        seleccionarVehiculos.add(panelInfo);

        JTextArea infoV = new JTextArea();
        infoV.setBounds(10, 10, 580, 60);
        infoV.setEditable(false);
        infoV.setBackground(Color.LIGHT_GRAY);
        panelInfo.add(infoV);

        JPanel mostrarVehiculos = new JPanel();
        mostrarVehiculos.setBounds(0, 80, 600, 400);
        mostrarVehiculos.setBackground(Color.LIGHT_GRAY);
        mostrarVehiculos.setLayout(new GridLayout(5, 6));

        JPanel vehiculosJugar = new JPanel();
        vehiculosJugar.setBounds(0, 480, 600, 120);
        vehiculosJugar.setBackground(Color.LIGHT_GRAY);
        vehiculosJugar.setLayout(null);
        seleccionarVehiculos.add(vehiculosJugar);

        JButton aceptar = new JButton("ACEPTAR");
        aceptar.setFont(new Font("cooper black", 1, 14));
        aceptar.setBounds(230, 20, 140, 40);
        vehiculosJugar.add(aceptar);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarVehiculos.setVisible(false);
                seleccionarVehiculos.removeAll();
            }
        };
        aceptar.addActionListener(oyenteAceptar);


        int k=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<6; j++){
                Casilla casilla = new Casilla(j, i);

                MouseListener oyenteBtn = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(!casilla.isEmpty()){
                            infoV.setText("Nombre Vehiculo: "+casilla.getVehiculo().getNombre());
                            infoV.append(" Nivel: "+casilla.getVehiculo().getNivel());
                            infoV.append("\nAtaque: "+casilla.getVehiculo().getAtaque()+" Puntos de vida: "+casilla.getVehiculo().getPuntosVida());
                            infoV.append(" Estado: "+casilla.getVehiculo().isEstado()+"\nEnemimgos Destruidos: "+casilla.getVehiculo().getEnemigosDestruidos());
                            infoV.append(" Veces que ha sido destruido: "+casilla.getVehiculo().getCantDestruido());

                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        infoV.setText("");
                    }
                };
                casilla.addMouseListener(oyenteBtn);

                casillasVehiculos[i][j] = casilla;

                if(k<=ventana.control.contadorVehiculos){
                    casillasVehiculos[i][j].setVehiculo(ventana.control.misVehiculos[k]);
                    k++;
                }

                if(!casillasVehiculos[i][j].isEmpty()){
                    if(casillasVehiculos[i][j].getVehiculo().isTanque()){
                        casillasVehiculos[i][j].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                    }else{
                        casillasVehiculos[i][j].setIcon(new ImageIcon(avion.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                    }
                }

                if(casillasVehiculos[i][j].isEmpty()){
                    casillasVehiculos[i][j].setEnabled(false);
                }

                mostrarVehiculos.add(casillasVehiculos[i][j]);
            }
        }

        seleccionarVehiculos.add(mostrarVehiculos);
        seleccionarVehiculos.setVisible(true);

    }

    public void eventoSeleccionar(JFrame ventanaVehiculos){
        JDialog seleccionarVehiculos = new JDialog(ventanaVehiculos, "Dark Side - Select Vehicles");
        seleccionarVehiculos.setSize(600, 630);
        seleccionarVehiculos.setLayout(null);
        seleccionarVehiculos.setLocationRelativeTo(null);

        JPanel panelInfo = new JPanel();
        panelInfo.setBounds(0, 0, 600, 80);
        panelInfo.setBackground(Color.LIGHT_GRAY);
        seleccionarVehiculos.add(panelInfo);

        JTextArea infoV = new JTextArea();
        infoV.setBounds(10, 10, 580, 60);
        infoV.setEditable(false);
        infoV.setBackground(Color.LIGHT_GRAY);

        infoV.setFont(new Font("cooper black", 1, 14));
        infoV.setText("\nSolo puedes seleccionar 3 vehiculos para usar");
        infoV.append("\ndurante la partida, siempre y cuando esten activos");
        panelInfo.add(infoV);

        JPanel mostrarVehiculos = new JPanel();
        mostrarVehiculos.setBounds(0, 80, 600, 400);
        mostrarVehiculos.setBackground(Color.LIGHT_GRAY);
        mostrarVehiculos.setLayout(new GridLayout(5, 6));

        JPanel vehiculosJugar = new JPanel();
        vehiculosJugar.setBounds(0, 480, 600, 150);
        vehiculosJugar.setBackground(Color.LIGHT_GRAY);
        vehiculosJugar.setLayout(null);
        seleccionarVehiculos.add(vehiculosJugar);

        Casilla[] tmp = new Casilla[3];
        JLabel[] etiqueta = new JLabel[3];
        for(int i=0; i<3; i++){
            JLabel etiTmp = new JLabel();

            Casilla tmp2 = new Casilla(0, i);
            tmp2.setEnabled(false);

            etiqueta[i] = etiTmp;
            tmp[i] = tmp2;
            vehiculosJugar.add(tmp[i]);
            vehiculosJugar.add(etiqueta[i]);
        }

        tmp[0].setBounds(300, 0, 100, 80);
        tmp[1].setBounds(400, 0, 100, 80);
        tmp[2].setBounds(500, 0, 100, 80);

        etiqueta[0].setBounds(310, 80, 100, 30);
        etiqueta[0].setText("Vehiculo 1");
        etiqueta[1].setBounds(410, 80, 100, 30);
        etiqueta[1].setText("Vehiculo 2");
        etiqueta[2].setBounds(510, 80, 100, 30);
        etiqueta[2].setText("Vehiculo 3");

        JButton aceptar = new JButton("ACEPTAR");
        aceptar.setFont(new Font("cooper black", 1, 14));
        aceptar.setEnabled(false);
        aceptar.setBounds(80, 20, 140, 40);
        vehiculosJugar.add(aceptar);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarVehiculos.setVisible(false);
                seleccionarVehiculos.removeAll();
                contador = 0;
            }
        };
        aceptar.addActionListener(oyenteAceptar);

        JButton cancelar = new JButton("CANCELAR");
        cancelar.setFont(new Font("cooper black", 1, 14));
        cancelar.setBounds(80, 60, 140, 40);
        vehiculosJugar.add(cancelar);

        ActionListener oyenteCancelar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador = 0;
                seleccionarVehiculos.setVisible(false);
                seleccionarVehiculos.removeAll();
                eventoSeleccionar(ventanaVehiculos);
            }
        };
        cancelar.addActionListener(oyenteCancelar);


        int k=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<6; j++){
                Casilla casilla = new Casilla(j, i);

                MouseListener oyenteBtn = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if(!casilla.isEmpty()){
                            if(contador<3){
                                int pos = (casilla.getPosY()+1)*(casilla.getPosX()+1);
                                pos--;
                                ventana.control.pos[contador] = pos;
                                casilla.setEnabled(false);
                                tmp[contador].setVehiculo(casilla.getVehiculo());
                                tmp[contador].setEnabled(true);
                                etiqueta[contador].setText(tmp[contador].getVehiculo().getNombre());
                                if(tmp[contador].getVehiculo().isTanque()){
                                    tmp[contador].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                                }else{
                                    tmp[contador].setIcon(new ImageIcon(avion.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                                }
                                contador++;
                            }
                            if(contador == 3){
                                aceptar.setEnabled(true);
                            }
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(!casilla.isEmpty()){
                            infoV.setFont(null);
                            infoV.setText("Nombre Vehiculo: "+casilla.getVehiculo().getNombre());
                            infoV.append(" Nivel: "+casilla.getVehiculo().getNivel());
                            infoV.append("\nAtaque: "+casilla.getVehiculo().getAtaque()+" Puntos de vida: "+casilla.getVehiculo().getPuntosVida());
                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        infoV.setFont(new Font("cooper black", 1, 14));
                        infoV.setText("\nSolo puedes seleccionar 3 vehiculos para usar");
                        infoV.append("\ndurante la partida, siempre y cuando esten activos");
                    }
                };
                casilla.addMouseListener(oyenteBtn);

                casillasVehiculos[i][j] = casilla;


                if(k<=ventana.control.contadorVehiculos){
                    casillasVehiculos[i][j].setVehiculo(ventana.control.misVehiculos[k]);
                    k++;
                }

                if(!casillasVehiculos[i][j].isEmpty()){
                    if(casillasVehiculos[i][j].getVehiculo().isTanque()){
                        casillasVehiculos[i][j].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                    }else{
                        casillasVehiculos[i][j].setIcon(new ImageIcon(avion.getImage().getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
                    }
                }

                if(casillasVehiculos[i][j].isEmpty()){
                    casillasVehiculos[i][j].setEnabled(false);
                }

                mostrarVehiculos.add(casillasVehiculos[i][j]);
            }
        }

        seleccionarVehiculos.add(mostrarVehiculos);
        seleccionarVehiculos.setVisible(true);
    }
}