package ProyectoFinal;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlJuego{

    Ventana ventana;

    TanqueEnemigo[] tanqueEnemigos = new TanqueEnemigo[3];
    AvionEnemigo[] avionEnemigos = new AvionEnemigo[3];
    Vehiculos[] misVehiculos = new Vehiculos[30];
    Casilla[][] Tablero1 = new Casilla[4][4];
    Casilla[][] Tablero2 = new Casilla[6][4];
    Casilla[][] Tablero3 = new Casilla[8][9];

    JPanel informacion = new JPanel();
    JTextArea informacionArea = new JTextArea();
    JPanel vsPC = new JPanel();
    JButton rendirse= new JButton("Rendirse");
    JTextField posX = new JTextField();
    JTextField posY = new JTextField();
    JLabel movX = new JLabel("PosX: ");
    JLabel movY = new JLabel("PosY: ");
    JButton mover = new JButton("Mover");
    JButton disparar = new JButton("Disparar");
    JRadioButton vehiculo1;
    JRadioButton vehiculo2;
    JRadioButton vehiculo3;

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
    protected int posV0=0;
    protected int posV1=1;
    protected int posV2=2;
    protected int posV = posV0;
    private int contadorVehiculos = 0;
    protected int X;
    protected int Y;
    protected boolean miTurno;

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
                Casilla casilla = new Casilla(j, i, tablero);

                /*ActionListener oyenteCasilla = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                     System.out.println("posX: "+casilla.getPosX()+" posY: "+casilla.getPosY());
                     if(!casilla.isEmpty()){
                         System.out.println("nombre: "+casilla.getVehiculo().getNombre());
                         System.out.println("nombre: "+casilla.getVehiculo().getPuntosVida());
                         posX.setText(Integer.toString(casilla.getPosX()));
                         posY.setText(Integer.toString(casilla.getPosY()));
                     }
                    }
                };
                casilla.addActionListener(oyenteCasilla);
                */

                MouseListener oyenteMCasilla = new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        posX.setText(Integer.toString(casilla.getPosX()));
                        posY.setText(Integer.toString(casilla.getPosY()));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        informacionArea.setText("posX: "+casilla.getPosX()+" posY: "+casilla.getPosY());
                        if(!casilla.isEmpty()){
                            informacionArea.append("\nNombre vehiculo: "+casilla.getVehiculo().getNombre());
                            informacionArea.append("\nPuntos de vida: "+casilla.getVehiculo().getPuntosVida());
                        }

                        if(casilla.isMontaña()){
                            informacionArea.append("\nPuntos de vida montaña: "+casilla.getVida());
                        }

                        if(casilla.isAgua()){
                            informacionArea.append("\nPuntos de vida del lago: "+casilla.getVida());
                        }

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        informacionArea.setText(null);
                    }
                };

                casilla.addMouseListener(oyenteMCasilla);
                tablero[i][j] = casilla;
                //tablero[i][j] = new Casilla(j, i, tablero);
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
                tablero[rdmX][rdmY].setVida(40);
                tablero[rdmX][rdmY].setIcon(new ImageIcon(montaña.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                //Tablero1[rdmX][rdmY].setText("Montaña");
                contador++;
            }

            if(!tablero[rdmX][rdmY].isMontaña() && !tablero[rdmX][rdmY].isAgua() && contador!=obstaculos){
                tablero[rdmX][rdmY].setVida(50);
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
                //rdm = (int)(Math.random()*3);
                tablero[rdmX][rdmY].setVehiculo(misVehiculos[posV]);
                X = rdmX;
                Y = rdmY;

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

        int k=0;
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
        informacion.setLayout(null);
        ventanaJugar.add(informacion);

        TitledBorder bordeInformacion = new TitledBorder("Informacion");
        bordeInformacion.setTitleJustification(TitledBorder.CENTER);
        bordeInformacion.setTitleJustification(TitledBorder.TOP);
        informacion.setBorder(bordeInformacion);

        informacionArea.setBounds(10, 20, 730, 50);
        informacionArea.setEditable(false);
        informacionArea.setOpaque(true);
        informacionArea.setBackground(Color.white);
        informacion.add(informacionArea);

        vsPC.setLayout(null);
        vsPC.setBackground(Color.GRAY);
        vsPC.setBounds(875, 0, 125, 680);
        ventanaJugar.add(vsPC);

        vsPlayer = new JPanel();
        vsPlayer.setLayout(null);
        vsPlayer.setBackground(Color.GRAY);
        vsPlayer.setBounds(0, 0, 125, 680);
        ventanaJugar.add(vsPlayer);

        rendirse.setBounds(10, 460, 105, 30);
        posX.setBounds(60, 140, 40, 30);
        movX.setBounds(10, 140, 50, 30);
        posY.setBounds(60, 180, 40, 30);
        movY.setBounds(10, 180, 50, 30);
        mover.setBounds(20, 220, 80, 30);
        disparar.setBounds(10, 260, 100, 30);

        JLabel cambiarV = new JLabel("Escoger Vehiculo");
        cambiarV.setBounds(5, 300, 115, 30);
        vsPC.add(cambiarV);

        vehiculo1 = new JRadioButton(misVehiculos[0].getNombre(), true);
        vehiculo1.setBounds(10, 340, 100, 30);
        vsPC.add(vehiculo1);
        vehiculo2 = new JRadioButton(misVehiculos[1].getNombre(), false);
        vehiculo2.setBounds(10, 380, 100, 30);
        vsPC.add(vehiculo2);
        vehiculo3 = new JRadioButton(misVehiculos[2].getNombre(), false);
        vehiculo3.setBounds(10, 420, 100, 30);
        vsPC.add(vehiculo3);

        ButtonGroup cambiarVehiculo = new ButtonGroup();
        cambiarVehiculo.add(vehiculo1);
        cambiarVehiculo.add(vehiculo2);
        cambiarVehiculo.add(vehiculo3);

        ActionListener oyenteV1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(posV!=posV0){
                    casillas[X][Y].setVehiculo(null);
                    posV = posV0;
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }

                    miTurno = false;
                    jugar(x, y, casillas, ventanaJugar);
                }
            }
        };
        vehiculo1.addActionListener(oyenteV1);

        ActionListener oyenteV2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(posV!=posV1){
                    casillas[X][Y].setVehiculo(null);
                    posV = posV1;
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    miTurno = false;
                    jugar(x, y, casillas, ventanaJugar);
                }
            }
        };
        vehiculo2.addActionListener(oyenteV2);

        ActionListener oyenteV3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(posV!=posV2){
                    casillas[X][Y].setVehiculo(null);
                    posV = posV2;
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    miTurno = false;
                    jugar(x, y, casillas, ventanaJugar);
                }
            }
        };
        vehiculo3.addActionListener(oyenteV3);

        ActionListener oyenteMover = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moverVehiculo(x, y, casillas, ventanaJugar);
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

                vsPC.removeAll();
                tablero.removeAll();
                informacion.removeAll();
                informacionArea.setText(null);
                ventanaJugar.remove(tablero);
                ventanaJugar.remove(vsPC);
                ventanaJugar.setVisible(false);
                ventana.setVisible(true);
            }

        };

        ActionListener oyenteDisparar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispararEnemigos(x, y, casillas, ventanaJugar);
            }
        };

        disparar.addActionListener(oyenteDisparar);
        rendirse.addActionListener(oyenteRedirse);
        mover.addActionListener(oyenteMover);
        vsPC.add(rendirse);
        vsPC.add(posX);
        vsPC.add(movX);
        vsPC.add(movY);
        vsPC.add(posY);
        vsPC.add(mover);
        vsPC.add(disparar);

        int random;
        random = (int)(Math.random()*2);
        if(random==0){
            miTurno = false;
        }else{
            miTurno = true;
        }
    }

    public void dispararEnemigos(int x, int y, Casilla[][] casillas, JFrame ventanaJugar){
        if(!posX.getText().equals("") && !posY.getText().equals("")){
            int fila = Integer.parseInt(posY.getText());
            int columna = Integer.parseInt(posX.getText());

            posY.setText("");
            posY.requestFocusInWindow();
            posX.setText("");
            posX.requestFocusInWindow();

            if(MovimientoValido0(fila, columna, x, y)){
                if(fila==X || columna ==Y){

                    if(casillas[fila][columna].isAgua() || casillas[fila][columna].isMontaña()){
                        casillas[fila][columna].setVida(casillas[fila][columna].getVida() - misVehiculos[posV].getAtaque());
                        informacionArea.setText("El vehiculo "+misVehiculos[posV].getNombre()+" le disparo a el obstaculo en la posicion ");
                        informacionArea.append("posX: "+casillas[fila][columna].getPosX()+" posY: "+casillas[fila][columna].getPosY());
                        informacionArea.append("\nVida del obstaculo: "+casillas[fila][columna].getVida());

                        if(casillas[fila][columna].getVida()<=0){
                            casillas[fila][columna].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));
                            casillas[fila][columna].setAgua(false);
                            casillas[fila][columna].setMontaña(false);

                            informacionArea.append("\nEl obstaculo con posicion ");
                            informacionArea.append("posX: "+casillas[fila][columna].getPosX()+" posY: "+casillas[fila][columna].getPosY());
                            informacionArea.append(" fue destruido");
                        }
                    }

                    if(!casillas[fila][columna].isEmpty()){
                        casillas[fila][columna].getVehiculo().setPuntosVida(casillas[fila][columna].getVehiculo().getPuntosVida() - misVehiculos[posV].getAtaque());

                        informacionArea.setText("Mi vehiculo "+misVehiculos[posV].getNombre()+" le disparo al vehiculo "+casillas[fila][columna].getVehiculo().getNombre());
                        informacionArea.append(" con posicion PosX: "+casillas[fila][columna].getPosX()+" posY: "+casillas[fila][columna].getPosY());
                        informacionArea.append("\nVehiculo: "+casillas[fila][columna].getVehiculo().getNombre());
                        informacionArea.append(", Puntos de vida: "+casillas[fila][columna].getVehiculo().getPuntosVida());

                        if(casillas[fila][columna].getVehiculo().getPuntosVida() <= 0){
                            casillas[fila][columna].setVehiculo(null);
                            casillas[fila][columna].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));

                            misVehiculos[posV].setEnemigosDestruidos(misVehiculos[posV].getEnemigosDestruidos()+1);
                            informacionArea.append("\nEl vehiculo fue destruido");

                        }

                    }

                }else{
                    informacionArea.setText("No se puede disparar porque no esta en la direccion de disparo");
                }
            }else{
                informacionArea.setText("Disparo fuera de rango");
            }
            miTurno = false;
            jugar(x, y, casillas, ventanaJugar);
        }
    }

    public void moverVehiculo(int x, int y, Casilla[][] casillas, JFrame ventanaJugar){

        if(!posX.getText().equals("") && !posY.getText().equals("")){
            int fila = Integer.parseInt(posY.getText());
            int columna = Integer.parseInt(posX.getText());

            posY.setText("");
            posY.requestFocusInWindow();
            posX.setText("");
            posX.requestFocusInWindow();

            if(MovimientoValido0(fila, columna, x, y)){
                if(fila==X || columna ==Y){
                    if(!casillas[fila][columna].isMontaña() && !casillas[fila][columna].isAgua() && casillas[fila][columna].isEmpty()){

                        if(casillas[X][Y].getVehiculo().isTanque()){
                            casillas[fila][columna].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[fila][columna].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));
                        }

                        casillas[fila][columna].setVehiculo(misVehiculos[posV]);
                        casillas[X][Y].setVehiculo(null);
                        casillas[X][Y].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                        X = fila;
                        Y = columna;

                    }else{
                        informacionArea.setText("El movimiento no es posible porque la casilla esta ocupada");
                    }

                }else{
                    informacionArea.setText("No corresponde al movimiento de una torre");
                }
            }else{
                informacionArea.setText("Movimiento fuera de rango");
            }
            miTurno = false;
            jugar(x, y, casillas, ventanaJugar);
        }

    }

    public boolean MovimientoValido0(int fila, int columna, int x, int y) {
        if (fila >= 0 && fila <x && columna >= 0 && columna <y) {
            return true;
        } else {
            return false;
        }
    }

    public void movimientoPC(int x, int y, Casilla[][] casillas, JFrame ventanaJugar){

        JDialog informar = new JDialog(ventanaJugar, "Informacion");
        informar.setSize(700, 150);
        informar.setLayout(null);
        informar.setLocationRelativeTo(null);

        JTextArea informacionArea2 = new JTextArea();
        informacionArea2.setBounds(20,20,660, 60);
        informacionArea2.setEditable(false);

        informar.add(informacionArea2);

        int k;
        int contador = -1;
        k = (int)(Math.random()*3);

        //Coordenadas del vehiculo que va a disparar
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!casillas[i][j].isEmpty() && casillas[i][j].getVehiculo().getNombre().endsWith("Enemigo")){
                    rdmX = i;
                    rdmY = j;
                    ++contador;
                    if(contador == k){
                        break;
                    }
                }
            }
        }

        int a;
        int b;
        //Coordenadas hacia donde va a dispara
        do{
            a = (int)(Math.random()*x);
            b = (int)(Math.random()*y);
        }while(rdmX!=a && rdmY!=b);

        informacionArea2.setText("El vehiculo: "+casillas[rdmX][rdmY].getVehiculo().getNombre()+" con posicion PosX: "+rdmY+" PosY: "+rdmX);
        informacionArea2.append(", disparo a la casilla x="+b+" y="+a);

        if(casillas[a][b].isEmpty() && !(casillas[a][b].isAgua() || casillas[a][b].isMontaña())){
            informacionArea2.append("\nCasilla vacia.");
        }

        if(casillas[a][b].isAgua()){
            casillas[a][b].setVida(casillas[a][b].getVida() - casillas[rdmX][rdmY].getVehiculo().getAtaque());
            informacionArea2.append("\ndonde se encuentra un lago");
            informacionArea2.append(", vida actual del lago: "+casillas[a][b].getVida());
            if(casillas[a][b].getVida()<=0){
                informacionArea2.append(", lago destruido.");
                casillas[a][b].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                casillas[a][b].setAgua(false);
            }
        }

        if(casillas[a][b].isMontaña()){
            casillas[a][b].setVida(casillas[a][b].getVida() - casillas[rdmX][rdmY].getVehiculo().getAtaque());
            informacionArea2.append("\ndonde se encuentra una montaña");
            informacionArea2.append(", vida actual de la montaña: "+casillas[a][b].getVida());
            if(casillas[a][b].getVida()<=0){
                informacionArea2.append(", montaña destruida.");
                casillas[a][b].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                casillas[a][b].setMontaña(false);
            }
        }

        if(!casillas[a][b].isEmpty() && !casillas[a][b].getVehiculo().getNombre().endsWith("Enemigo")){
            casillas[a][b].getVehiculo().setPuntosVida(casillas[a][b].getVehiculo().getPuntosVida() - casillas[rdmX][rdmY].getVehiculo().getAtaque());
            misVehiculos[posV].setPuntosVida(misVehiculos[posV].getPuntosVida() - casillas[rdmX][rdmY].getVehiculo().getAtaque());
            informacionArea2.append("\ndonde se encuentra el vehiculo: "+casillas[a][b].getVehiculo().getNombre());
            if(casillas[a][b].getVehiculo().getPuntosVida() <= 0){
                misVehiculos[posV].setPuntosVida(0);
                misVehiculos[posV].setCantDestruido(misVehiculos[posV].getCantDestruido() + 1);
                misVehiculos[posV].setEstado(false);
                informacionArea2.append("\nVida actual del vehiculo: "+casillas[a][b].getVehiculo().getPuntosVida());
                informacionArea2.append(", vehiculo destruido.");
                casillas[a][b].setVehiculo(null);

                boolean v0 = false;
                boolean v1 = false;
                boolean v2 = false;

                if(posV==posV0){
                    v0 = true;
                }
                if(posV==posV1){
                    v1=true;
                }
                if(posV==posV2){
                    v2=true;
                }

                if(v0){
                    vehiculo1.setEnabled(false);
                    if(misVehiculos[posV1].isEstado()){
                        posV=posV1;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo2.setSelected(true);
                    }
                    if(!misVehiculos[posV1].isEstado() && misVehiculos[posV2].isEstado()){
                        posV=posV2;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo3.setSelected(true);
                    }
                }

                if(v1){
                    vehiculo2.setEnabled(false);
                    if(misVehiculos[posV0].isEstado()){
                        posV=posV0;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo1.setSelected(true);
                    }
                    if(!misVehiculos[posV0].isEstado() && misVehiculos[posV2].isEstado()){
                        posV=posV2;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo3.setSelected(true);
                    }

                }

                if(v2){
                    vehiculo3.setEnabled(false);
                    if(misVehiculos[posV0].isEstado()){
                        posV=posV0;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo1.setSelected(true);
                    }
                    if(!misVehiculos[posV0].isEstado() && misVehiculos[posV1].isEstado()){
                        posV=posV1;
                        casillas[a][b].setVehiculo(misVehiculos[posV]);
                        if(casillas[a][b].getVehiculo().isTanque()){
                            casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }else{
                            casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        }
                        vehiculo2.setSelected(true);
                    }
                }
            }
        }
        informar.setVisible(true);
    }

    public void jugar(int x, int y, Casilla[][] casillas, JFrame ventanaJugar){

        int miVida = 0;
        int vidaEnemigos = 0;

        if(!miTurno){
            movimientoPC(x, y, casillas, ventanaJugar);
            miTurno = true;
        }
        miVida = misVehiculos[posV0].getPuntosVida() + misVehiculos[posV1].getPuntosVida() + misVehiculos[posV2].getPuntosVida();
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!casillas[i][j].isEmpty() && casillas[i][j].getVehiculo().getNombre().endsWith("Enemigo")){
                    vidaEnemigos+=casillas[i][j].getVehiculo().getPuntosVida();
                }
            }
        }

        if(vidaEnemigos<=0){
            //partidaGanada
        }
        if(miVida<=0){
            //partidaPerdida
        }
    }
}
