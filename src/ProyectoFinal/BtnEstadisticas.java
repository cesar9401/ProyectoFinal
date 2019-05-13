package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnEstadisticas extends JButton {
   Ventana ventana;

    public BtnEstadisticas(JPanel panelMenu, Ventana ventana) {
        this.setText("Estadisticas");
        this.setFont(new Font("cooper black", 1, 18));
        this.setBounds(295, 300, 160, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnEstadisticas = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoEstadisticas();
                ventana.setVisible(false);
            }
        };
        this.addActionListener(oyenteBtnEstadisticas);

    }

    public void eventoEstadisticas(){

        JFrame ventanaEstadisticas = new JFrame("Dark Side - Stats");
        ventanaEstadisticas.setSize(700, 480);
        ventanaEstadisticas.setLocationRelativeTo(null);
        ventanaEstadisticas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaEstadisticas.setLayout(null);

        informacionJugador(ventanaEstadisticas);
        informacionMejorVehiculoGanadas(ventanaEstadisticas);
        informacionMejorVehiculoKills(ventanaEstadisticas);
        informacionPeorVehiculoPerdidas(ventanaEstadisticas);
        informacionPeorVehiculoKills(ventanaEstadisticas);

        JPanel panelBtn = new JPanel();
        panelBtn.setBounds(350, 300, 350, 150);
        panelBtn.setLayout(null);
        panelBtn.setBackground(Color.LIGHT_GRAY);
        ventanaEstadisticas.add(panelBtn);

        TitledBorder bordeBtn = new TitledBorder("Dark Side - Stats");
        bordeBtn.setTitleJustification(TitledBorder.CENTER);
        bordeBtn.setTitleJustification(TitledBorder.TOP);
        panelBtn.setBorder(bordeBtn);
        panelBtn.setBackground(Color.LIGHT_GRAY);


        JButton regresar = new JButton("Regresar");
        regresar.setFont(new Font("cooper black", 1, 18));
        regresar.setBounds(110, 40, 130, 50);
        panelBtn.add(regresar);

        ActionListener oyenteRegresar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaEstadisticas.setVisible(false);
                ventanaEstadisticas.removeAll();
                ventana.setVisible(true);
            }
        };
        regresar.addActionListener(oyenteRegresar);

        ventanaEstadisticas.setVisible(true);



    }

    public void informacionJugador(JFrame ventanaEstadisticas){
        JPanel panelJugador = new JPanel();
        panelJugador.setBounds(0, 0, 350, 150);
        panelJugador.setLayout(null);
        ventanaEstadisticas.add(panelJugador);

        TitledBorder bordeJugador = new TitledBorder("Dark Side - Player");
        bordeJugador.setTitleJustification(TitledBorder.CENTER);
        bordeJugador.setTitleJustification(TitledBorder.TOP);
        panelJugador.setBorder(bordeJugador);
        panelJugador.setBackground(Color.LIGHT_GRAY);

        JLabel nombre = new JLabel("Nombre: ");
        nombre.setBounds(20, 20, 90, 20);
        panelJugador.add(nombre);

        JLabel lnombre= new JLabel(ventana.jugador.getNombre());
        lnombre.setBounds(120, 20, 100, 20);
        panelJugador.add(lnombre);

        JLabel nivel = new JLabel("Nivel: ");
        nivel.setBounds(20, 40, 90, 20);
        panelJugador.add(nivel);

        JLabel lnivel = new JLabel(Integer.toString(ventana.jugador.getNivel()));
        lnivel.setBounds(120, 40, 100, 20);
        panelJugador.add(lnivel);

        JLabel partidasGanadas = new JLabel("Victorias: ");
        partidasGanadas.setBounds(20, 60, 90, 20);
        panelJugador.add(partidasGanadas);

        JLabel lpartidasGanadas = new JLabel(Integer.toString(ventana.jugador.getPartidasGanadas()));
        lpartidasGanadas.setBounds(120, 60, 100, 20);
        panelJugador.add(lpartidasGanadas);

        JLabel partidasPerdidas = new JLabel("Derrotas: ");
        partidasPerdidas.setBounds(20, 80, 90, 20);
        panelJugador.add(partidasPerdidas);

        JLabel lpartidasPerdidas = new JLabel(Integer.toString(ventana.jugador.getPartidas_Perdidas()));
        lpartidasPerdidas.setBounds(120, 80, 100, 20);
        panelJugador.add(lpartidasPerdidas);
    }

    public void informacionMejorVehiculoGanadas(JFrame ventanaEstadisticas){
        JPanel panelVehiculo1 = new JPanel();
        panelVehiculo1.setBounds(350, 0, 350, 150);
        panelVehiculo1.setLayout(null);
        ventanaEstadisticas.add(panelVehiculo1);
        panelVehiculo1.setBackground(Color.LIGHT_GRAY);

        TitledBorder bordeVehiculo1 = new TitledBorder("Vehicle Best Winner");
        bordeVehiculo1.setTitleJustification(TitledBorder.CENTER);
        bordeVehiculo1.setTitleJustification(TitledBorder.TOP);
        panelVehiculo1.setBorder(bordeVehiculo1);

        Vehiculos tmp;
        tmp = ventana.control.misVehiculos[0];

        for(int i=0; i<ventana.control.contadorVehiculos; i++){
            if(ventana.control. misVehiculos[i].getPartidasGanadas()> tmp.getPartidasGanadas()){
                tmp = ventana.control.misVehiculos[i];
            }
        }

        JLabel nombre1 = new JLabel("Nombre: ");
        nombre1.setBounds(20, 20, 90, 20);
        panelVehiculo1.add(nombre1);

        JLabel lnombre1= new JLabel(tmp.getNombre());
        lnombre1.setBounds(120, 20, 100, 20);
        panelVehiculo1.add(lnombre1);

        JLabel nivel1 = new JLabel("Nivel: ");
        nivel1.setBounds(20, 40, 90, 20);
        panelVehiculo1.add(nivel1);

        JLabel lnivel1 = new JLabel(Integer.toString(tmp.getNivel()));
        lnivel1.setBounds(120, 40, 100, 20);
        panelVehiculo1.add(lnivel1);

        JLabel partidasGanadas1 = new JLabel("Victorias: ");
        partidasGanadas1.setBounds(20, 60, 90, 20);
        panelVehiculo1.add(partidasGanadas1);

        JLabel lpartidasGanadas1 = new JLabel(Integer.toString(tmp.getPartidasGanadas()));
        lpartidasGanadas1.setBounds(120, 60, 100, 20);
        panelVehiculo1.add(lpartidasGanadas1);

        JLabel partidasPerdidas1 = new JLabel("Derrotas: ");
        partidasPerdidas1.setBounds(20, 80, 90, 20);
        panelVehiculo1.add(partidasPerdidas1);

        JLabel lpartidasPerdidas1 = new JLabel(Integer.toString(tmp.getPartidasPerdidas()));
        lpartidasPerdidas1.setBounds(120, 80, 100, 20);
        panelVehiculo1.add(lpartidasPerdidas1);

        JLabel enemigosDestruidos = new JLabel("Kills: ");
        enemigosDestruidos.setBounds(20, 100, 90, 20);
        panelVehiculo1.add(enemigosDestruidos);

        JLabel lenemigosEstruidos = new JLabel(""+tmp.getEnemigosDestruidos());
        lenemigosEstruidos.setBounds(120, 100, 100, 20);
        panelVehiculo1.add(lenemigosEstruidos);

        JLabel muertes = new JLabel("#Destroyed");
        muertes.setBounds(20, 120, 100, 20);
        panelVehiculo1.add(muertes);

        JLabel lmuertes = new JLabel(""+tmp.getCantDestruido());
        lmuertes.setBounds(120, 120, 100, 20);
        panelVehiculo1.add(lmuertes);
    }

    public void informacionMejorVehiculoKills(JFrame ventanaEstadisticas){
        JPanel panelVehiculo1 = new JPanel();
        panelVehiculo1.setBounds(0, 150, 350, 150);
        panelVehiculo1.setLayout(null);
        ventanaEstadisticas.add(panelVehiculo1);
        panelVehiculo1.setBackground(Color.LIGHT_GRAY);

        TitledBorder bordeVehiculo1 = new TitledBorder("Vehicle Best Killer");
        bordeVehiculo1.setTitleJustification(TitledBorder.CENTER);
        bordeVehiculo1.setTitleJustification(TitledBorder.TOP);
        panelVehiculo1.setBorder(bordeVehiculo1);

        Vehiculos tmp;
        tmp = ventana.control.misVehiculos[0];

        for(int i=0; i<ventana.control.contadorVehiculos; i++){
            if(ventana.control. misVehiculos[i].getEnemigosDestruidos()> tmp.getEnemigosDestruidos()){
                tmp = ventana.control.misVehiculos[i];
            }
        }

        JLabel nombre1 = new JLabel("Nombre: ");
        nombre1.setBounds(20, 20, 90, 20);
        panelVehiculo1.add(nombre1);

        JLabel lnombre1= new JLabel(tmp.getNombre());
        lnombre1.setBounds(120, 20, 100, 20);
        panelVehiculo1.add(lnombre1);

        JLabel nivel1 = new JLabel("Nivel: ");
        nivel1.setBounds(20, 40, 90, 20);
        panelVehiculo1.add(nivel1);

        JLabel lnivel1 = new JLabel(""+tmp.getNivel());
        lnivel1.setBounds(120, 40, 100, 20);
        panelVehiculo1.add(lnivel1);

        JLabel partidasGanadas1 = new JLabel("Victorias: ");
        partidasGanadas1.setBounds(20, 60, 90, 20);
        panelVehiculo1.add(partidasGanadas1);

        JLabel lpartidasGanadas1 = new JLabel(""+tmp.getPartidasGanadas());
        lpartidasGanadas1.setBounds(120, 60, 100, 20);
        panelVehiculo1.add(lpartidasGanadas1);

        JLabel partidasPerdidas1 = new JLabel("Derrotas: ");
        partidasPerdidas1.setBounds(20, 80, 90, 20);
        panelVehiculo1.add(partidasPerdidas1);

        JLabel lpartidasPerdidas1 = new JLabel(""+tmp.getPartidasPerdidas());
        lpartidasPerdidas1.setBounds(120, 80, 100, 20);
        panelVehiculo1.add(lpartidasPerdidas1);

        JLabel enemigosDestruidos = new JLabel("Kills: ");
        enemigosDestruidos.setBounds(20, 100, 90, 20);
        panelVehiculo1.add(enemigosDestruidos);

        JLabel lenemigosEstruidos = new JLabel(""+tmp.getEnemigosDestruidos());
        lenemigosEstruidos.setBounds(120, 100, 100, 20);
        panelVehiculo1.add(lenemigosEstruidos);

        JLabel muertes = new JLabel("#Destroyed");
        muertes.setBounds(20, 120, 100, 20);
        panelVehiculo1.add(muertes);

        JLabel lmuertes = new JLabel(""+tmp.getCantDestruido());
        lmuertes.setBounds(120, 120, 100, 20);
        panelVehiculo1.add(lmuertes);
    }

    public void informacionPeorVehiculoPerdidas(JFrame ventanaEstadisticas){
        JPanel panelVehiculo1 = new JPanel();
        panelVehiculo1.setBounds(350, 150, 350, 150);
        panelVehiculo1.setLayout(null);
        ventanaEstadisticas.add(panelVehiculo1);
        panelVehiculo1.setBackground(Color.LIGHT_GRAY);

        TitledBorder bordeVehiculo1 = new TitledBorder("Vehicle Worst Winner");
        bordeVehiculo1.setTitleJustification(TitledBorder.CENTER);
        bordeVehiculo1.setTitleJustification(TitledBorder.TOP);
        panelVehiculo1.setBorder(bordeVehiculo1);

        Vehiculos tmp;
        tmp = ventana.control.misVehiculos[0];

        for(int i=0; i<ventana.control.contadorVehiculos; i++){
            if(ventana.control. misVehiculos[i].getPartidasPerdidas()> tmp.getPartidasPerdidas()){
                tmp = ventana.control.misVehiculos[i];
            }
        }

        JLabel nombre1 = new JLabel("Nombre: ");
        nombre1.setBounds(20, 20, 90, 20);
        panelVehiculo1.add(nombre1);

        JLabel lnombre1= new JLabel(tmp.getNombre());
        lnombre1.setBounds(120, 20, 100, 20);
        panelVehiculo1.add(lnombre1);

        JLabel nivel1 = new JLabel("Nivel: ");
        nivel1.setBounds(20, 40, 90, 20);
        panelVehiculo1.add(nivel1);

        JLabel lnivel1 = new JLabel(""+tmp.getNivel());
        lnivel1.setBounds(120, 40, 100, 20);
        panelVehiculo1.add(lnivel1);

        JLabel partidasGanadas1 = new JLabel("Victorias: ");
        partidasGanadas1.setBounds(20, 60, 90, 20);
        panelVehiculo1.add(partidasGanadas1);

        JLabel lpartidasGanadas1 = new JLabel(""+tmp.getPartidasGanadas());
        lpartidasGanadas1.setBounds(120, 60, 100, 20);
        panelVehiculo1.add(lpartidasGanadas1);

        JLabel partidasPerdidas1 = new JLabel("Derrotas: ");
        partidasPerdidas1.setBounds(20, 80, 90, 20);
        panelVehiculo1.add(partidasPerdidas1);

        JLabel lpartidasPerdidas1 = new JLabel(""+tmp.getPartidasPerdidas());
        lpartidasPerdidas1.setBounds(120, 80, 100, 20);
        panelVehiculo1.add(lpartidasPerdidas1);

        JLabel enemigosDestruidos = new JLabel("Kills: ");
        enemigosDestruidos.setBounds(20, 100, 90, 20);
        panelVehiculo1.add(enemigosDestruidos);

        JLabel lenemigosEstruidos = new JLabel(""+tmp.getEnemigosDestruidos());
        lenemigosEstruidos.setBounds(120, 100, 100, 20);
        panelVehiculo1.add(lenemigosEstruidos);

        JLabel muertes = new JLabel("#Destroyed");
        muertes.setBounds(20, 120, 100, 20);
        panelVehiculo1.add(muertes);

        JLabel lmuertes = new JLabel(""+tmp.getCantDestruido());
        lmuertes.setBounds(120, 120, 100, 20);
        panelVehiculo1.add(lmuertes);
    }

    public void informacionPeorVehiculoKills(JFrame ventanaEstadisticas){
        JPanel panelVehiculo1 = new JPanel();
        panelVehiculo1.setBounds(0, 300, 350, 150);
        panelVehiculo1.setLayout(null);
        ventanaEstadisticas.add(panelVehiculo1);
        panelVehiculo1.setBackground(Color.LIGHT_GRAY);

        TitledBorder bordeVehiculo1 = new TitledBorder("Vehicle Worst Killer");
        bordeVehiculo1.setTitleJustification(TitledBorder.CENTER);
        bordeVehiculo1.setTitleJustification(TitledBorder.TOP);
        panelVehiculo1.setBorder(bordeVehiculo1);

        Vehiculos tmp;
        tmp = ventana.control.misVehiculos[0];

        for(int i=0; i<ventana.control.contadorVehiculos; i++){
            if(ventana.control. misVehiculos[i].getEnemigosDestruidos() < tmp.getEnemigosDestruidos()){
                tmp = ventana.control.misVehiculos[i];
            }
        }

        JLabel nombre1 = new JLabel("Nombre: ");
        nombre1.setBounds(20, 20, 90, 20);
        panelVehiculo1.add(nombre1);

        JLabel lnombre1= new JLabel(tmp.getNombre());
        lnombre1.setBounds(120, 20, 100, 20);
        panelVehiculo1.add(lnombre1);

        JLabel nivel1 = new JLabel("Nivel: ");
        nivel1.setBounds(20, 40, 90, 20);
        panelVehiculo1.add(nivel1);

        JLabel lnivel1 = new JLabel(""+tmp.getNivel());
        lnivel1.setBounds(120, 40, 100, 20);
        panelVehiculo1.add(lnivel1);

        JLabel partidasGanadas1 = new JLabel("Victorias: ");
        partidasGanadas1.setBounds(20, 60, 90, 20);
        panelVehiculo1.add(partidasGanadas1);

        JLabel lpartidasGanadas1 = new JLabel(""+tmp.getPartidasGanadas());
        lpartidasGanadas1.setBounds(120, 60, 100, 20);
        panelVehiculo1.add(lpartidasGanadas1);

        JLabel partidasPerdidas1 = new JLabel("Derrotas: ");
        partidasPerdidas1.setBounds(20, 80, 90, 20);
        panelVehiculo1.add(partidasPerdidas1);

        JLabel lpartidasPerdidas1 = new JLabel(""+tmp.getPartidasPerdidas());
        lpartidasPerdidas1.setBounds(120, 80, 100, 20);
        panelVehiculo1.add(lpartidasPerdidas1);

        JLabel enemigosDestruidos = new JLabel("Kills: ");
        enemigosDestruidos.setBounds(20, 100, 90, 20);
        panelVehiculo1.add(enemigosDestruidos);

        JLabel lenemigosEstruidos = new JLabel(""+tmp.getEnemigosDestruidos());
        lenemigosEstruidos.setBounds(120, 100, 100, 20);
        panelVehiculo1.add(lenemigosEstruidos);

        JLabel muertes = new JLabel("#Destroyed");
        muertes.setBounds(20, 120, 100, 20);
        panelVehiculo1.add(muertes);

        JLabel lmuertes = new JLabel(""+tmp.getCantDestruido());
        lmuertes.setBounds(120, 120, 100, 20);
        panelVehiculo1.add(lmuertes);
    }
}
