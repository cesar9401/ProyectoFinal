package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{

    private JPanel panelMenu;
    private JPanel panelInformacion;
    private JLabel player;
    private JLabel nombreJugador;
    private JLabel oro;
    private JLabel oroJugador;
    private JLabel nivel;
    private JLabel nivelJugador;
    private JLabel experiencia;
    private JLabel experienciaJugador;
    Jugador jugador = new Jugador();
    private JFrame inicio;
    private JTextField nombreField;

    public Ventana(String nombreV){
        super(nombreV);
        this.setTitle(nombreV);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 650);
        setLocationRelativeTo(null);

        InicializarInicio();
        InicializarPaneles();
        InicializarLabels();

        BtnJugar btnJugar = new BtnJugar(panelMenu, this);
        BtnTienda btnTienda = new BtnTienda(panelMenu, this);
        BtnVehiculos btnVehiculos = new BtnVehiculos(panelMenu, this);
        BtnEstadisticas btnEstadisticas = new BtnEstadisticas(panelMenu, this);
        BtnNuevoJugador btnNuevoJugador = new BtnNuevoJugador(panelMenu, this);
        BtnGuardarCargar btnGuardarCargar = new BtnGuardarCargar(panelMenu, this);

        //this.setVisible(true);

    }

    public void InicializarInicio(){
        inicio = new JFrame("Bienenido a Dark Side");
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicio.setSize(600, 250);
        inicio.setLocationRelativeTo(null);


        JPanel bienvenida = new JPanel();
        bienvenida.setLayout(null);
        bienvenida.setBackground(Color.LIGHT_GRAY);

        JLabel mensaje = new JLabel();
        mensaje.setFont(new Font("cooper black", 1, 14));
        mensaje.setText("Bienvenido a Dark Side novato, ingresa tu nombre: ");
        mensaje.setBounds(100, 20, 500, 40);

        nombreField = new JTextField();
        nombreField.setBounds(250, 80, 100, 30);

        JButton aceptar = new JButton("¡Comenzar!");
        aceptar.setFont(new Font("cooper black", 1, 14));
        aceptar.setBounds(225, 130, 150, 40);

        ActionListener comenzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoComenzar();
            }
        };
        aceptar.addActionListener(comenzar);


        bienvenida.add(nombreField);
        bienvenida.add(mensaje);
        bienvenida.add(aceptar);
        inicio.add(bienvenida);
        inicio.setVisible(true);
    }

    public void eventoComenzar(){
        jugador.setNombre(nombreField.getText());
        nombreJugador.setText(""+jugador.getNombre());
        inicio.setVisible(false);
        this.setVisible(true);
    }

    public void InicializarPaneles(){
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
        panelMenu.setBounds(0, 80, 750, 670);

        this.getContentPane().add(BorderLayout.NORTH, panelInformacion);
        this.getContentPane().add(BorderLayout.CENTER, panelMenu);

        panelMenu.setLayout(null);
    }

    public void InicializarLabels(){
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
