package ProyectoFinal;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{

    private JPanel panelDetalle;
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

        panelDetalle = new JPanel();
        panelMenu = new JPanel();
        panelInformacion = new JPanel();

        player = new JLabel("Player: ");
        nombreJugador = new JLabel(""+jugador.getNombre());
        oro = new JLabel("      Oro: ");
        oroJugador = new JLabel(""+jugador.getOro());
        nivel = new JLabel("Nivel: ");
        nivelJugador = new JLabel(""+jugador.getNivel());
        experiencia = new JLabel("      Experiencia: ");
        experienciaJugador = new JLabel(""+jugador.getExperiencia());

        panelInformacion.add(player);
        panelInformacion.add(nombreJugador);
        panelInformacion.add(oro);
        panelInformacion.add(oroJugador);

        panelDetalle.add(nivel);
        panelDetalle.add(nivelJugador);
        panelDetalle.add(experiencia);
        panelDetalle.add(experienciaJugador);

        //this.setLayout(new BorderLayout());

        this.getContentPane().add(BorderLayout.NORTH, panelInformacion);
        this.getContentPane().add(BorderLayout.CENTER, panelMenu);
        this.getContentPane().add(BorderLayout.SOUTH, panelDetalle);
    }
}
