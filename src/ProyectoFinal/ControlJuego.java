package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlJuego{

    Ventana ventana;
    Tanque tanqueEjemplo;
    Avion avionEjemplo;

    TanqueEnemigo[] tanqueEnemigos = new TanqueEnemigo[3];
    AvionEnemigo[] avionEnemigos = new AvionEnemigo[3];
    Vehiculos[] misVehiculos = new Vehiculos[30];
    Casilla[][] Tablero1 = new Casilla[4][4];
    Casilla[][] Tablero2 = new Casilla[6][4];
    Casilla[][] Tablero3 = new Casilla[8][9];

    JPanel informacion = new JPanel();
    JPanel vsPC = new JPanel();
    JButton rendirse= new JButton("Rendirse");
    JTextField posX = new JTextField();
    JTextField posY = new JTextField();
    JLabel movX = new JLabel("PosX: ");
    JLabel movY = new JLabel("PosY: ");
    JButton mover = new JButton("Mover");

    ImageIcon montaña = new ImageIcon("montaña.jpg");
    ImageIcon agua = new ImageIcon("agua.jpg");
    ImageIcon asfalto = new ImageIcon("tierra.jpg");
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("halconMilenario.jpg");
    ImageIcon tanqueEnemigo = new ImageIcon("tanqueEnemigo.JPG");
    ImageIcon avionEnemigo = new ImageIcon("avionEnemigo.jpg");

    protected int rdm;
    protected int rdmX;
    protected int rdmY;
    private int contadorVehiculos = 0;
    protected int X = 0;
    protected int Y = 0;

    public ControlJuego(Ventana ventana){
        this.ventana = ventana;
        crearVehiculosEnemigo();
        tanqueEjemplo = null;
        avionEjemplo = null;
    }

    public void crearVehiculosEnemigo(){
        for(int i=0; i<3; i++){
            tanqueEnemigos[i] = new TanqueEnemigo();
            avionEnemigos[i] = new AvionEnemigo();
        }
    }

    public void crearTanque(String nombre){
        if(contadorVehiculos<30){
            misVehiculos[contadorVehiculos] = new Tanque();
            misVehiculos[contadorVehiculos].setTanque(true);
            misVehiculos[contadorVehiculos].setNombre(nombre);
            contadorVehiculos++;
        }
    }

    public void crearAvion(String nombre){
        if(contadorVehiculos<30){
            misVehiculos[contadorVehiculos] = new Avion();
            misVehiculos[contadorVehiculos].setTanque(false);
            misVehiculos[contadorVehiculos].setNombre(nombre);
            contadorVehiculos++;
        }
    }

    public void getTablero(int x, int y,int ancho, int largo, int obstaculos, Casilla[][] tablero){
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                tablero[i][j] = new Casilla(j, i, tablero);
                //ventana.btnJugar4x4.tablero4x4.add(Tablero1[i][j]);
            }
        }

        rdm = (int)(Math.random()*obstaculos+1);
        int contador = 0;
        do{
            rdmX = (int)(Math.random()*x);
            rdmY = (int)(Math.random()*y);

            if(!tablero[rdmX][rdmY].isMontaña() && !tablero[rdmX][rdmY].isAgua() && contador<rdm){
                tablero[rdmX][rdmY].setMontaña(true);

                tablero[rdmX][rdmY].setIcon(new ImageIcon(montaña.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                //Tablero1[rdmX][rdmY].setText("Montaña");
                contador++;
            }

            if(!tablero[rdmX][rdmY].isMontaña() && !tablero[rdmX][rdmY].isAgua() && contador!=obstaculos){
                tablero[rdmX][rdmY].setAgua(true);

                tablero[rdmX][rdmY].setIcon(new ImageIcon(agua.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                //Tablero1[rdmX][rdmY].setText("Agua");
                contador++;
            }
        }while (contador != obstaculos);

        contador = 0;
        int m=0;
        int n=0;
        do{
            rdmX = (int)(Math.random()*x);
            rdmY = (int)(Math.random()*y);
            if(!tablero[rdmX][rdmY].isMontaña() && !tablero[rdmX][rdmY].isAgua() && tablero[rdmX][rdmY].isEmpty() && contador==0){
                rdm = (int)(Math.random()*3);
                tablero[rdmX][rdmY].setVehiculo(misVehiculos[rdm]);
                X = rdmX;
                Y = rdmY;
                System.out.println(tablero[rdmX][rdmY].getVehiculo().isTanque());


                if(tablero[rdmX][rdmY].getVehiculo().isTanque()){
                    tablero[rdmX][rdmY].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                }
                else{
                    tablero[rdmX][rdmY].setIcon(new ImageIcon(avion.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                }
                contador++;
            }

            if(!tablero[rdmX][rdmY].isMontaña() && !tablero[rdmX][rdmY].isAgua() && tablero[rdmX][rdmY].isEmpty()){
                rdm = (int)(Math.random()*2);
                if(rdm==0){
                    tablero[rdmX][rdmY].setVehiculo(tanqueEnemigos[m]);
                    tablero[rdmX][rdmY].setIcon(new ImageIcon(tanqueEnemigo.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                    m++;
                }else{
                    tablero[rdmX][rdmY].setVehiculo(avionEnemigos[n]);
                    tablero[rdmX][rdmY].setIcon(new ImageIcon(avionEnemigo.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                    n++;
                }
                contador++;
            }
        }while(contador!=4);

        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!tablero[i][j].isMontaña() && !tablero[i][j].isAgua() && tablero[i][j].isEmpty()){
                    tablero[i][j].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                }

            }
        }
    }

    public void panelsYBotonesJugar(int x, int y, JPanel tablero, JPanel vsPlayer, JFrame ventanaJugar, Casilla[][] casillas){

        informacion.setBackground(Color.LIGHT_GRAY);
        informacion.setBounds(125, 0, 750, 80);
        ventanaJugar.add(informacion);

        TitledBorder bordeInformacion = new TitledBorder("Informacion");
        bordeInformacion.setTitleJustification(TitledBorder.CENTER);
        bordeInformacion.setTitleJustification(TitledBorder.TOP);
        informacion.setBorder(bordeInformacion);

        vsPC.setLayout(null);
        vsPC.setBackground(Color.GRAY);
        vsPC.setBounds(875, 0, 125, 680);
        ventanaJugar.add(vsPC);

        vsPlayer = new JPanel();
        vsPlayer.setLayout(null);
        vsPlayer.setBackground(Color.GRAY);
        vsPlayer.setBounds(0, 0, 125, 680);
        ventanaJugar.add(vsPlayer);

        rendirse.setBounds(10, 100, 105, 30);
        posX.setBounds(60, 140, 40, 30);
        movX.setBounds(10, 140, 50, 30);
        posY.setBounds(60, 180, 40, 30);
        movY.setBounds(10, 180, 50, 30);
        mover.setBounds(10, 220, 80, 30);


        ActionListener oyenteMover = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moverVehiculo(x, y, casillas);

            }
        };

        ActionListener oyenteRedirse = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(int i=0; i<x; i++){
                    for(int j=0; j<y; j++){
                        casillas[i][j] = null;
                    }
                }

                tablero.removeAll();
                ventanaJugar.remove(tablero);
                ventanaJugar.remove(vsPC);
                ventanaJugar.setVisible(false);
                ventana.setVisible(true);
            }

        };
        rendirse.addActionListener(oyenteRedirse);
        mover.addActionListener(oyenteMover);
        vsPC.add(rendirse);
        vsPC.add(posX);
        vsPC.add(movX);
        vsPC.add(movY);
        vsPC.add(posY);
        vsPC.add(mover);

    }


    public void moverVehiculo(int x, int y, Casilla[][] casillas){

        if(!posX.getText().equals("") && !posY.getText().equals("")){
            int fila = Integer.parseInt(posY.getText());
            int columna = Integer.parseInt(posX.getText());

            posY.setText("");
            posY.requestFocusInWindow();
            posX.setText("");
            posX.requestFocusInWindow();

            System.out.println("x: "+x+" y: "+y);
            System.out.println(fila+" "+columna);

            if(MovimientoValido0(fila, columna, x, y)){
                if(fila==X || columna ==Y){
                    if(!casillas[fila][columna].isMontaña() && !casillas[fila][columna].isAgua() && casillas[fila][columna].isEmpty()){

                        if(casillas[X][Y].getVehiculo().isTanque()){
                            casillas[fila][columna].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[fila][columna].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));
                        }

                        casillas[fila][columna].setVehiculo(casillas[X][Y].getVehiculo());
                        casillas[X][Y].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                        casillas[X][Y].setVehiculo(null);
                        X = fila;
                        Y = columna;

                    }else{
                        System.out.println("no es posible el movimiento");
                    }

                }else{
                    System.out.println("no corresponde a movimiento de torre");
                }
            }else{
                System.out.println("fuera de rango");
            }
        }
    }

    public boolean MovimientoValido0(int fila, int columna, int x, int y) {
        if (fila >= 0 && fila <x && columna >= 0 && columna <y) {
            return true;
        } else {
            return false;
        }
    }


}
