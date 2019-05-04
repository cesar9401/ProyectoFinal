package ProyectoFinal;

import javax.swing.*;
import java.awt.*;

public class ControlJuego{

    Ventana ventana;

    Tanque tanqueEjemplo = new Tanque();
    Avion avionEjemplo = new Avion();
    TanqueEnemigo[] tanqueEnemigos = new TanqueEnemigo[3];
    AvionEnemigo[] avionEnemigos = new AvionEnemigo[3];
    Vehiculos[] misVehiculos = new Vehiculos[30];
    Casilla[][] Tablero1 = new Casilla[4][4];
    Casilla[][] Tablero2 = new Casilla[6][4];
    Casilla[][] Tablero3 = new Casilla[8][9];

    ImageIcon montaña = new ImageIcon("montaña.jpg");
    ImageIcon agua = new ImageIcon("agua.jpg");
    ImageIcon asfalto = new ImageIcon("asfalto.jpg");
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("avion.gif");
    ImageIcon tanqueEnemigo = new ImageIcon("tanqueEnemigo.JPG");
    ImageIcon avionEnemigo = new ImageIcon("avionEnemigo.jpg");

    protected int rdm;
    protected int rdmX;
    protected int rdmY;
    private int contadorVehiculos = 0;

    public ControlJuego(Ventana ventana){
        this.ventana = ventana;
        crearVehiculosEnemigo();
    }

    public void crearVehiculosEnemigo(){
        for(int i=0; i<3; i++){
            tanqueEnemigos[i] = new TanqueEnemigo();
            avionEnemigos[i] = new AvionEnemigo();
        }
    }

    public void crearTanque(){
        if(contadorVehiculos<30){
            misVehiculos[contadorVehiculos] = new Tanque();
            misVehiculos[contadorVehiculos].setTanque(true);
            contadorVehiculos++;
        }
    }

    public void crearAvion(){
        if(contadorVehiculos<30){
            misVehiculos[contadorVehiculos] = new Avion();
            misVehiculos[contadorVehiculos].setTanque(false);
            contadorVehiculos++;
        }
    }

    public void getTablero(int x, int y,int ancho, int largo, int obstaculos, Casilla[][] tablero){
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                tablero[i][j] = new Casilla();
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
                //System.out.println(Tablero1[rdmX][rdmY].getVehiculo().isTanque());


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

    public void getTablero2(){
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                Tablero2[i][j] = new Casilla();
                ventana.btnJugar6x4.tablero6x4.add(Tablero2[i][j]);
            }
        }

        rdm = (int)(Math.random()*6+1);
        rdmX = (int)(Math.random()*6);
        rdmY = (int)(Math.random()*4);

        int contador = 0;
        do{
            if(!Tablero2[rdmX][rdmY].isMontaña() && !Tablero2[rdmX][rdmY].isAgua() && contador<rdm){
                Tablero2[rdmX][rdmY].setMontaña(true);
                Tablero2[rdmX][rdmY].setText("Montaña");
                rdmX = (int)(Math.random()*6);
                rdmY = (int)(Math.random()*4);
                contador++;
            }

            if(!Tablero2[rdmX][rdmY].isMontaña() && !Tablero2[rdmX][rdmY].isAgua() && contador!=6){
                Tablero2[rdmX][rdmY].setAgua(true);
                Tablero2[rdmX][rdmY].setText("Agua");
                rdmX = (int)(Math.random()*6);
                rdmY = (int)(Math.random()*4);
                contador++;
            }
            rdmX = (int)(Math.random()*6);
            rdmY = (int)(Math.random()*4);
        }while (contador != 6);
    }

    public void getTablero3(){
        for(int i=0; i<8; i++){
            for(int j=0; j<9; j++){
                Tablero3[i][j] = new Casilla();
                ventana.btnJugar8x9.tablero8x9.add(Tablero3[i][j]);
            }
        }

        rdm = (int)(Math.random()*18+1);
        rdmX = (int)(Math.random()*8);
        rdmY = (int)(Math.random()*9);

        int contador = 0;
        do{
            if(!Tablero3[rdmX][rdmY].isMontaña() && !Tablero3[rdmX][rdmY].isAgua() && contador<rdm){
                Tablero3[rdmX][rdmY].setMontaña(true);
                Tablero3[rdmX][rdmY].setText("Montaña");
                rdmX = (int)(Math.random()*8);
                rdmY = (int)(Math.random()*9);
                contador++;
            }

            if(!Tablero3[rdmX][rdmY].isMontaña() && !Tablero3[rdmX][rdmY].isAgua() && contador!=18){
                Tablero3[rdmX][rdmY].setAgua(true);
                Tablero3[rdmX][rdmY].setText("Agua");
                rdmX = (int)(Math.random()*8);
                rdmY = (int)(Math.random()*9);
                contador++;
            }
            rdmX = (int)(Math.random()*8);
            rdmY = (int)(Math.random()*9);
        }while (contador != 18);

        for(int i=0; i<8; i++){
            for(int j=0; j<9; j++){
                if(!Tablero3[i][j].isMontaña() && !Tablero3[i][j].isAgua()){
                    Tablero3[i][j].setBackground(Color.green);
                }
            }
        }
    }
}
