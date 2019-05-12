package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnTienda extends JButton{
    Ventana ventana;
    protected String seleccion;

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
}
