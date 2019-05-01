package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

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

    public Ventana(String nombreV){
        super(nombreV);
        this.setTitle(nombreV);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setLocationRelativeTo(null);
        setVisible(true);

        InicializarPaneles();
        InicializarLabels();

        BtnJugar btnJugar = new BtnJugar(panelMenu, this);
        BtnTienda btnTienda = new BtnTienda(panelMenu, this);
        BtnVehiculos btnVehiculos = new BtnVehiculos(panelMenu, this);
        BtnEstadisticas btnEstadisticas = new BtnEstadisticas(panelMenu, this);
        BtnNuevoJugador btnNuevoJugador = new BtnNuevoJugador(panelMenu, this);
        BtnGuardarCargar btnGuardarCargar = new BtnGuardarCargar(panelMenu, this);

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
