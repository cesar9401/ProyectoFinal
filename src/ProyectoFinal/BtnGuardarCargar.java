package ProyectoFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BtnGuardarCargar extends JButton{
    Ventana ventana;

    public BtnGuardarCargar(JPanel panelMenu, Ventana ventana){
        this.setText("Guardar/Cargar");
        this.setFont(new Font("cooper black", 1, 18));
        this.setBounds(275, 450, 200, 50);
        panelMenu.add(this);
        this.ventana = ventana;

        ActionListener oyenteBtnGuardarCargar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoGuardarCargar();
            }
        };
        this.addActionListener(oyenteBtnGuardarCargar);
    }

    public void eventoGuardarCargar(){
        JDialog guardarCargar = new JDialog(ventana, "Guardar/Cargar");
        guardarCargar.setSize(300, 300);
        guardarCargar.setLocationRelativeTo(null);
        guardarCargar.setLayout(null);

        JPanel panelGC = new JPanel();
        panelGC.setBounds(0, 0, 300, 300);
        panelGC.setBackground(Color.LIGHT_GRAY);
        panelGC.setLayout(null);
        guardarCargar.add(panelGC);

        JButton guardar = new JButton("Guardar");
        guardar.setFont(new Font("cooper black", 1, 18));
        guardar.setBounds(80, 70, 140, 40);
        panelGC.add(guardar);

        ActionListener oyenteGuardar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoGuardar();
                guardarCargar.setVisible(false);
            }
        };
        guardar.addActionListener(oyenteGuardar);

        JButton cargar = new JButton("Cargar");
        cargar.setFont(new Font("cooper black", 1, 18));
        cargar.setBounds(80, 150, 140, 40);
        panelGC.add(cargar);

        ActionListener oyenteCargar= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoCargar();
                guardarCargar.setVisible(false);
                ventana.setVisible(false);
                ventana.remove(ventana.panelInformacion);
                ventana.panelInformacion.removeAll();
                ventana.inicializarLabels();
                ventana.add(ventana.panelInformacion);
                ventana.setVisible(true);

            }
        };
        cargar.addActionListener(oyenteCargar);

        guardarCargar.setVisible(true);

    }

    public void eventoGuardar(){
        try{
            ObjectOutputStream guardarJugador = new ObjectOutputStream(new FileOutputStream("jugador.txt"));
            guardarJugador.writeObject(ventana.jugador);
            guardarJugador.close();

            ObjectOutputStream guardarVehiculos = new ObjectOutputStream(new FileOutputStream("vehiculos.txt"));
            guardarVehiculos.writeObject(ventana.control.misVehiculos);
            guardarVehiculos.close();

        }catch (Exception e){

        }
    }

    public void eventoCargar(){
        try{
            ObjectInputStream cargarJugador = new ObjectInputStream(new FileInputStream("jugador.txt"));
            Jugador jugador_recuperado = (Jugador) cargarJugador.readObject();
            cargarJugador.close();

            ventana.jugador = jugador_recuperado;

            ObjectInputStream cargarVehiculos = new ObjectInputStream(new FileInputStream("vehiculos.txt"));
            Vehiculos[] vehiculos_recuperados = (Vehiculos[]) cargarVehiculos.readObject();
            cargarVehiculos.close();



            int contador=0;
            for(int i=0; i<vehiculos_recuperados.length; i++){
                if(vehiculos_recuperados[i] == null){
                    break;
                }
                contador++;
            }

            ventana.control.contadorVehiculos = contador;

            for(int i=0; i<ventana.control.contadorVehiculos; i++){
                ventana.control.misVehiculos[i] = vehiculos_recuperados[i];
            }

        }catch(Exception e){

        }
    }
}
