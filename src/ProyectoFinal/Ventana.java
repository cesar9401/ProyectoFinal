package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Ventana extends JFrame{

    protected JPanel panelMenu, panelInformacion;
    private JLabel player, nombreJugador, oro, oroJugador, nivel, nivelJugador;
    private JLabel experiencia, experienciaJugador, informacionVehiculos;
    private JPanel bienvenida;
    private JButton confirmar, comenzar;
    private JLabel vehiculo1, vehiculo2, vehiculo3;
    private JRadioButton tanque1, avion1, tanque2, avion2, tanque3, avion3;
    private ButtonGroup vehiculos1, vehiculos2, vehiculos3;
    protected Jugador jugador = new Jugador();

    protected BtnJugar4x4 btnJugar4x4;
    protected BtnJugar6x4 btnJugar6x4;
    protected BtnJugar8x9 btnJugar8x9;
    protected BtnTienda btnTienda;
    protected BtnVehiculos btnVehiculos;
    protected BtnEstadisticas btnEstadisticas;
    protected BtnNuevoJugador btnNuevoJugador;
    protected BtnGuardarCargar btnGuardarCargar;

    private String seleccion1 = "tanque";
    private String seleccion2 = "tanque";
    private String seleccion3 = "tanque";

    private JFrame inicio;
    private JTextField nombreField;
    ControlJuego control;


    public Ventana(String nombreV){
        super(nombreV);
        this.setTitle(nombreV);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 650);
        setLocationRelativeTo(null);

        inicializarInicio();
        inicializarPaneles();
        inicializarLabels();

        btnJugar4x4 = new BtnJugar4x4(panelMenu, this);
        btnJugar6x4 = new BtnJugar6x4(panelMenu, this);
        btnJugar8x9 = new BtnJugar8x9(panelMenu, this);
        btnTienda = new BtnTienda(panelMenu, this);
        btnVehiculos = new BtnVehiculos(panelMenu, this);
        btnEstadisticas = new BtnEstadisticas(panelMenu, this);
        btnNuevoJugador = new BtnNuevoJugador(panelMenu, this);
        btnGuardarCargar = new BtnGuardarCargar(panelMenu, this);
        control = new ControlJuego(this);



        //this.setVisible(true);

    }

    public void inicializarInicio(){
        inicio = new JFrame("Dark Side");
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setSize(600, 440);
        inicio.setLocationRelativeTo(null);

        bienvenida = new JPanel();
        bienvenida.setLayout(null);
        bienvenida.setBackground(Color.LIGHT_GRAY);

        //Mensaje de bienvenida
        JLabel mensaje = new JLabel();
        mensaje.setFont(new Font("cooper black", 1, 14));
        mensaje.setText("Bienvenido a Dark Side novato, ingresa tu nombre: ");
        mensaje.setBounds(100, 20, 500, 40);

        //Caja de texto para nombre
        nombreField = new JTextField();
        nombreField.setBounds(155, 80, 100, 30);

        //Boton para confirmar nombre
        confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("cooper black", 1, 14));
        confirmar.setBounds(305, 80, 140, 30);
        ActionListener oyenteConfirmar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoConfirmar();
            }
        };
        confirmar.addActionListener(oyenteConfirmar);

        //Label para informacion de crear vehiculos
        informacionVehiculos = new JLabel();
        informacionVehiculos.setFont(new Font("cooper black", 1, 12));
        informacionVehiculos.setText("Para jugar necesitas de 3 vehiculos, puedes escoger entre aviones y tanques");
        informacionVehiculos.setBounds(10, 120, 580, 40);
        informacionVehiculos.setEnabled(false);

        //Label para vehiculo1 y radiobotones
        vehiculo1 = new JLabel("Vehiculo 1");
        vehiculo1.setFont(new Font("cooper black", 1, 12));
        vehiculo1.setBounds(100, 160, 80, 40);
        vehiculo1.setEnabled(false);

        tanque1 = new JRadioButton("Tanque", true);
        tanque1.setBounds(100, 200, 80, 40);
        tanque1.setEnabled(false);

        avion1 = new JRadioButton("Avion", false);
        avion1.setBounds(100, 260, 80, 40);
        avion1.setEnabled(false);

        vehiculos1 = new ButtonGroup();
        vehiculos1.add(tanque1);
        vehiculos1.add(avion1);

        ActionListener paraTanque1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion1 = "tanque";
            }
        };
        tanque1.addActionListener(paraTanque1);

        ActionListener paraAvion1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion1 = "avion";
            }
        };
        avion1.addActionListener(paraAvion1);

        //Label para vehiculo2 y radiobotones
        vehiculo2 = new JLabel("Vehiculo 2");
        vehiculo2.setFont(new Font("cooper black", 1, 12));
        vehiculo2.setBounds(260, 160, 80, 40);
        vehiculo2.setEnabled(false);

        tanque2 = new JRadioButton("Tanque", true);
        tanque2.setBounds(260, 200, 80, 40);
        tanque2.setEnabled(false);

        avion2 = new JRadioButton("Avion", false);
        avion2.setBounds(260, 260, 80, 40);
        avion2.setEnabled(false);
        vehiculos2 = new ButtonGroup();
        vehiculos2.add(tanque2);
        vehiculos2.add(avion2);

        ActionListener paraTanque2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion1 = "tanque";
            }
        };
        tanque2.addActionListener(paraTanque2);

        ActionListener paraAvion2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion2 = "avion";
            }
        };
        avion2.addActionListener(paraAvion2);

        //Label para vehiculo3 y radiobotones
        vehiculo3 = new JLabel("Vehiculo 3");
        vehiculo3.setFont(new Font("cooper black", 1, 12));
        vehiculo3.setBounds(420, 160, 80, 40);
        vehiculo3.setEnabled(false);

        tanque3 = new JRadioButton("Tanque", true);
        tanque3.setBounds(420, 200, 80, 40);
        tanque3.setEnabled(false);

        avion3 = new JRadioButton("Avion", false);
        avion3.setBounds(420, 260, 80, 40);
        avion3.setEnabled(false);
        vehiculos3 = new ButtonGroup();
        vehiculos3.add(tanque3);
        vehiculos3.add(avion3);

        ActionListener paraTanque3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion1 = "tanque";
            }
        };
        tanque3.addActionListener(paraTanque3);

        ActionListener paraAvion3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion3 = "avion";
            }
        };
        avion3.addActionListener(paraAvion3);

        //Boton para iniciar el Menu principal
        comenzar = new JButton("¡Comenzar!");
        comenzar.setFont(new Font("cooper black", 1, 14));
        comenzar.setBounds(225, 320, 150, 40);
        comenzar.setEnabled(false);
        ActionListener oyenteComenzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoComenzar();
            }
        };
        comenzar.addActionListener(oyenteComenzar);

        bienvenida.add(mensaje);
        bienvenida.add(nombreField);
        bienvenida.add(confirmar);
        bienvenida.add(informacionVehiculos);
        bienvenida.add(vehiculo1);
        bienvenida.add(tanque1);
        bienvenida.add(avion1);
        bienvenida.add(vehiculo2);
        bienvenida.add(tanque2);
        bienvenida.add(avion2);
        bienvenida.add(vehiculo3);
        bienvenida.add(tanque3);
        bienvenida.add(avion3);
        bienvenida.add(comenzar);
        inicio.add(bienvenida);
        inicio.setVisible(true);
    }

    public void eventoConfirmar(){
        jugador.setNombre(nombreField.getText());
        nombreJugador.setText(""+jugador.getNombre());
        informacionVehiculos.setEnabled(true);
        vehiculo1.setEnabled(true);
        tanque1.setEnabled(true);
        avion1.setEnabled(true);
        vehiculo2.setEnabled(true);
        tanque2.setEnabled(true);
        avion2.setEnabled(true);
        vehiculo3.setEnabled(true);
        tanque3.setEnabled(true);
        avion3.setEnabled(true);
        comenzar.setEnabled(true);
    }

    public void eventoComenzar(){
        inicio.setVisible(false);
        this.setVisible(true);

        if(seleccion1.equals("tanque")){
            control.crearTanque();
        }else{
            control.crearAvion();
        }

        if(seleccion2.equals("tanque")){
            control.crearTanque();
        }else{
            control.crearAvion();
        }

        if(seleccion3.equals("tanque")){
            control.crearTanque();
        }else{
            control.crearAvion();
        }
    }

    public void inicializarPaneles(){
        panelMenu = new JPanel();
        panelInformacion = new JPanel();

        TitledBorder bordeMenu = new TitledBorder("Dark Side - Main");
        bordeMenu.setTitleJustification(TitledBorder.CENTER);
        bordeMenu.setTitleJustification(TitledBorder.TOP);
        panelMenu.setBorder(bordeMenu);


        TitledBorder bordeInformacion = new TitledBorder("Jugador Actual");
        bordeInformacion.setTitleJustification(TitledBorder.CENTER);
        bordeInformacion.setTitleJustification(TitledBorder.TOP);
        panelInformacion.setBorder(bordeInformacion);

        this.setLayout(null);
        panelInformacion.setBackground(Color.LIGHT_GRAY);
        panelInformacion.setBounds(0, 0, 750, 80);

        panelMenu.setBackground(Color.GRAY);
        panelMenu.setBounds(0, 80, 750, 570);

        this.getContentPane().add(BorderLayout.NORTH, panelInformacion);
        this.getContentPane().add(BorderLayout.CENTER, panelMenu);

        panelMenu.setLayout(null);
    }

    public void inicializarLabels(){
        player = new JLabel("Player: ");
        nombreJugador = new JLabel(""+jugador.getNombre());
        oro = new JLabel("      Oro: ");
        oroJugador = new JLabel(""+jugador.getOro());
        nivel = new JLabel("      Nivel: ");
        nivelJugador = new JLabel(""+jugador.getNivel());
        experiencia = new JLabel("            Experiencia: ");
        experienciaJugador = new JLabel(""+jugador.getExperiencia());



        panelInformacion.add(player);
        panelInformacion.add(nombreJugador);
        panelInformacion.add(oro);
        panelInformacion.add(oroJugador);
        panelInformacion.add(nivel);
        panelInformacion.add(nivelJugador);
        panelInformacion.add(experiencia);
        panelInformacion.add(experienciaJugador);

    }

}
