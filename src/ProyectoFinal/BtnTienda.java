package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BtnTienda extends JButton{
    Ventana ventana;
    protected String seleccion;
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("halconMilenario.jpg");

    public BtnTienda(JPanel panelMenu, Ventana ventana){
        this.setText("Tienda");
        this.setFont(new Font("cooper black", 1, 18));
        setBounds(315, 150, 120, 50);
        panelMenu.add(this);
        this.ventana = ventana;
        seleccion = "tanque";

        ActionListener oyenteBtnTienda = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoTienda();
            }
        };

        this.addActionListener(oyenteBtnTienda);
    }

    public void eventoTienda(){
        JFrame ventanaTienda = new JFrame("Dark Side - Store");
        ventanaTienda.setSize(750, 600);
        ventanaTienda.setLocationRelativeTo(null);
        ventanaTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaTienda.setLayout(null);

        ventana.panelInformacion.removeAll();
        ventana.inicializarLabels();
        ventanaTienda.add(ventana.panelInformacion);

        JPanel panelTienda = new JPanel();
        panelTienda.setBounds(0, 80, 750, 520);
        panelTienda.setBackground(Color.LIGHT_GRAY);
        panelTienda.setLayout(null);
        ventanaTienda.add(panelTienda);

        TitledBorder bordeTienda = new TitledBorder("Dark Side - Store");
        bordeTienda.setTitleJustification(TitledBorder.CENTER);
        bordeTienda.setTitleJustification(TitledBorder.TOP);
        panelTienda.setBorder(bordeTienda);

        inicializarBotones(ventanaTienda, panelTienda);

        ventana.setVisible(false);
        ventanaTienda.setVisible(true);

    }

    public void inicializarBotones(JFrame ventanaTienda, JPanel panelTienda){

        JButton comprarVehiculo = new JButton("Comprar Vehiculo $175");
        comprarVehiculo.setFont(new Font("cooper black", 1, 16));
        comprarVehiculo.setBounds(235, 40, 280, 50);
        panelTienda.add(comprarVehiculo);

        ActionListener oyenteComprar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoComprar(ventanaTienda);
            }
        };
        comprarVehiculo.addActionListener(oyenteComprar);


        JButton restaurarVida = new JButton("Restaurar Vida $100");
        restaurarVida.setFont(new Font("cooper black", 1, 16));
        restaurarVida.setBounds(240, 120, 270, 50);
        panelTienda.add(restaurarVida);
        restaurarVida.setEnabled(true);
        if(ventana.jugador.getOro()<100){
            restaurarVida.setEnabled(false);
        }

        ActionListener oyenteRestaurar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoRestaurar(ventanaTienda);
            }
        };
        restaurarVida.addActionListener(oyenteRestaurar);


        JButton regresar = new JButton("Regresar");
        regresar.setFont(new Font("cooper black", 1, 18));
        regresar.setBounds(310, 200, 130, 50);
        panelTienda.add(regresar);

        ActionListener oyenteRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaTienda.setVisible(false);
                ventanaTienda.removeAll();
                ventana.panelInformacion.removeAll();
                ventana.inicializarLabels();
                ventana.add(ventana.panelInformacion);
                ventana.setVisible(true);
            }
        };
        regresar.addActionListener(oyenteRegresar);


    }

    public void eventoComprar(JFrame ventanaTienda){
        JDialog comprar = new JDialog(ventanaTienda, "Dark Side - New Vehicle");
        comprar.setSize(300, 300);
        comprar.setLayout(null);
        comprar.setLocationRelativeTo(null);

        JPanel fondo = new JPanel();
        fondo.setBackground(Color.LIGHT_GRAY);
        fondo.setLayout(null);
        fondo.setBounds(0, 0, 300, 300);
        comprar.add(fondo);

        JRadioButton tanque = new JRadioButton("Tanque", true);
        tanque.setBounds(40, 100, 100, 40);
        fondo.add(tanque);

        ActionListener oyenteTanque = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = "tanque";
            }
        };
        tanque.addActionListener(oyenteTanque);

        JRadioButton avion = new JRadioButton("Avion", false);
        avion.setBounds(160, 100, 100, 40);
        fondo.add(avion);

        ActionListener oyenteAvion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = "avion";
            }
        };
        avion.addActionListener(oyenteAvion);

        ButtonGroup vehiculo = new ButtonGroup();
        vehiculo.add(tanque);
        vehiculo.add(avion);

        JLabel lnombre = new JLabel("Nombre");
        lnombre.setBounds(50, 60, 80, 30);
        fondo.add(lnombre);

        JTextField nombre = new JTextField("VehiculoNuevo");
        nombre.setBounds(150, 60, 120, 30);
        fondo.add(nombre);

        JButton aceptar = new JButton("ACEPTAR $175");
        aceptar.setFont(new Font("cooper black", 1, 18));
        aceptar.setBounds(50, 160, 200, 40);
        fondo.add(aceptar);
        if(ventana.jugador.getOro()>=175 && ventana.control.contadorVehiculos<30){
            aceptar.setEnabled(true);

        }else{
            aceptar.setEnabled(false);

        }

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seleccion.equals("tanque")){
                    ventana.control.crearTanque(nombre.getText());
                    JOptionPane.showMessageDialog(null, "El vehiculo de tipo tanque fue creado");
                }else{
                    ventana.control.crearAvion(nombre.getText());
                    JOptionPane.showMessageDialog(null, "El vehiculo de tipo avion fue creado");
                }
                ventana.jugador.setOro(ventana.jugador.getOro() - 175);
                seleccion = "tanque";
                ventanaTienda.setVisible(false);
                ventanaTienda.remove(ventana.panelInformacion);
                ventana.panelInformacion.removeAll();
                ventana.inicializarLabels();
                ventanaTienda.add(ventana.panelInformacion);
                ventanaTienda.setVisible(true);
                comprar.setVisible(false);
                comprar.removeAll();
            }
        };
        aceptar.addActionListener(oyenteAceptar);



        comprar.setVisible(true);
    }

    public void eventoRestaurar(JFrame eventoRestaurar){
        Casilla[][] casillasVehiculos = new Casilla[5][6];
        JDialog seleccionarVehiculos = new JDialog(eventoRestaurar, "Dark Side - Vehicles");
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
                        if(!casilla.isEmpty()){

                            int pos = (casilla.getPosY()+1)*(casilla.getPosX()+1) + 5*casilla.getPosY();
                            pos--;
                            ventana.control.misVehiculos[pos].setPuntosVida(50);
                            ventana.jugador.setOro(ventana.jugador.getOro() - 100);
                            if(!ventana.control.misVehiculos[pos].isEstado()){
                                ventana.control.misVehiculos[pos].setEstado(true);
                            }


                            JOptionPane.showMessageDialog(null, "El vehiculo: "+casilla.getVehiculo().getNombre()+" ha sido restaurado");


                            //ventana.control.pos[contador] = pos
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

                    if(casillasVehiculos[i][j].getVehiculo().getPuntosVida() == 50){
                        casillasVehiculos[i][j].setEnabled(false);
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
