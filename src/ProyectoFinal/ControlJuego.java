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
    Boot boot = new Boot();
    Casilla[][] Tablero1 = new Casilla[4][4];
    Casilla[][] Tablero2 = new Casilla[6][4];
    Casilla[][] Tablero3 = new Casilla[8][9];
    JRadioButton vehiculo1;
    JRadioButton vehiculo2;
    JRadioButton vehiculo3;

    JPanel informacion = new JPanel();
    JTextArea informacionArea = new JTextArea();
    JPanel vsPC = new JPanel();

    JTextField posX = new JTextField();
    JTextField posY = new JTextField();
    JLabel movX = new JLabel("PosX: ");
    JLabel movY = new JLabel("PosY: ");

    ImageIcon montaña = new ImageIcon("montaña.jpg");
    ImageIcon agua = new ImageIcon("agua.jpg");
    ImageIcon asfalto = new ImageIcon("tierra.jpg");
    ImageIcon tanque = new ImageIcon("tanque.jpg");
    ImageIcon avion = new ImageIcon("halconMilenario.jpg");
    ImageIcon tanqueEnemigo = new ImageIcon("tanqueEnemigo.JPG");
    ImageIcon avionEnemigo = new ImageIcon("avionEnemigo.jpg");
    ImageIcon newboot = new ImageIcon("boot.jpg");

    protected int rdm;
    protected int rdmX;
    protected int rdmY;
    /*protected int posV0=0;
    protected int posV1=1;
    protected int posV2=2;
    */

    protected int[] pos = {0, 1, 2};
    protected int posV = pos [0];

    protected int contadorVehiculos = 0;
    protected int X, Xboot;
    protected int Y, Yboot;
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

        for(int i=0; i<3; i++){
            if(misVehiculos[pos[i]].getPuntosVida()<10 && misVehiculos[pos[i]].getPuntosVida()>0){
                misVehiculos[pos[i]].setPuntosVida(25);
            }
        }


        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                Casilla casilla = new Casilla(j, i);

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

                        if(!casilla.isBootEmpty()){
                            informacionArea.append("\nBoot, turno: "+boot.getTurnos());
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
                posV = pos[0];
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
                    tablero[rdmX][rdmY].getVehiculo().setPuntosVida(100);
                    tablero[rdmX][rdmY].setIcon(new ImageIcon(tanqueEnemigo.getImage().getScaledInstance(largo, ancho, Image.SCALE_SMOOTH)));
                    m++;
                }else{
                    tablero[rdmX][rdmY].setVehiculo(avionEnemigos[n]);
                    tablero[rdmX][rdmY].getVehiculo().setPuntosVida(100);
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

        JButton colocarBoot = new JButton(" Set Boot");
        colocarBoot.setBounds(10, 460, 105, 30);
        vsPC.add(colocarBoot);
        if(!boot.isEstado()){
            colocarBoot.setEnabled(false);
        }

        ActionListener oyenteBoot = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eventoBoot(x, y, tablero, casillas, ventanaJugar);
                colocarBoot.setEnabled(false);
            }
        };
        colocarBoot.addActionListener(oyenteBoot);

        JButton rendirse = new JButton("Rendirse");
        rendirse.setBounds(10, 500, 105, 30);
        posX.setBounds(60, 140, 40, 30);
        movX.setBounds(10, 140, 50, 30);
        posY.setBounds(60, 180, 40, 30);
        movY.setBounds(10, 180, 50, 30);

        JButton mover = new JButton("Mover");
        mover.setBounds(20, 220, 80, 30);
        JButton disparar = new JButton("Disparar");
        disparar.setBounds(10, 260, 100, 30);

        JLabel cambiarV = new JLabel("Escoger Vehiculo");
        cambiarV.setBounds(5, 300, 115, 30);
        vsPC.add(cambiarV);


        vehiculo1 = new JRadioButton(misVehiculos[pos[0]].getNombre(), true);
        vehiculo1.setBounds(10, 340, 100, 30);
        vsPC.add(vehiculo1);
        vehiculo2 = new JRadioButton(misVehiculos[pos[1]].getNombre(), false);
        vehiculo2.setBounds(10, 380, 100, 30);
        vsPC.add(vehiculo2);
        vehiculo3 = new JRadioButton(misVehiculos[pos[2]].getNombre(), false);
        vehiculo3.setBounds(10, 420, 100, 30);
        vsPC.add(vehiculo3);

        ButtonGroup cambiarVehiculo = new ButtonGroup();
        cambiarVehiculo.add(vehiculo1);
        cambiarVehiculo.add(vehiculo2);
        cambiarVehiculo.add(vehiculo3);

        ActionListener oyenteV1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(posV!=pos[0]){
                    casillas[X][Y].setVehiculo(null);
                    posV = pos[0];
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    miTurno = false;
                    jugar(x, y, tablero, casillas, ventanaJugar);
                }
            }
        };

        vehiculo1.addActionListener(oyenteV1);

        ActionListener oyenteV2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(posV!=pos[1]){

                    casillas[X][Y].setVehiculo(null);
                    posV = pos[1];
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    miTurno = false;
                    jugar(x, y, tablero, casillas, ventanaJugar);
                }
            }
        };
        vehiculo2.addActionListener(oyenteV2);

        ActionListener oyenteV3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(posV!=pos[2]){

                    casillas[X][Y].setVehiculo(null);
                    posV = pos[2];
                    casillas[X][Y].setVehiculo(misVehiculos[posV]);
                    if(casillas[X][Y].getVehiculo().isTanque()){
                        casillas[X][Y].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }else{
                        casillas[X][Y].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[X][Y].getWidth(), casillas[X][Y].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    miTurno = false;
                    jugar(x, y, tablero, casillas, ventanaJugar);
                }
            }
        };
        vehiculo3.addActionListener(oyenteV3);

        ActionListener oyenteMover = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                moverVehiculo(x, y, tablero, casillas, ventanaJugar);
            }
        };

        MouseListener oyenteRendirse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                partidaPerdida(x, y, tablero, casillas, ventanaJugar);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                informacionArea.setText("¿Seguro que desea rendirse?");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                informacionArea.setText("");
            }
        };


        ActionListener oyenteDisparar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispararEnemigos(x, y, tablero, casillas, ventanaJugar);
            }
        };

        disparar.addActionListener(oyenteDisparar);
        rendirse.addMouseListener(oyenteRendirse);
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

    public void eventoBoot(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){

        if(!posX.getText().equals("") && !posY.getText().equals("")){
            int fila = Integer.parseInt(posY.getText());
            int columna = Integer.parseInt(posX.getText());

            posY.setText("");
            posY.requestFocusInWindow();
            posX.setText("");
            posX.requestFocusInWindow();

            if(MovimientoValido0(fila, columna, x, y)){
                if(fila==X || columna ==Y){
                    if(!casillas[fila][columna].isMontaña() && !casillas[fila][columna].isAgua() && casillas[fila][columna].isEmpty() && casillas[fila][columna].isBootEmpty()){


                        casillas[fila][columna].setTmp(boot);
                        Xboot = fila;
                        Yboot = columna;
                        casillas[fila][columna].setIcon(new ImageIcon(newboot.getImage().getScaledInstance(casillas[fila][columna].getWidth(), casillas[fila][columna].getHeight(), Image.SCALE_SMOOTH)));

                    }else{
                        informacionArea.setText("El movimiento no es posible porque la casilla esta ocupada");
                    }

                }else{
                    informacionArea.setText("No corresponde al movimiento de una torre");
                }
            }else{
                informacionArea.setText("Movimiento fuera de rango");
            }

            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            miTurno = false;
            jugar(x, y, tablero, casillas, ventanaJugar);
        }
    }

    public void dispararEnemigos(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){
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
            jugar(x, y, tablero, casillas, ventanaJugar);
        }
    }

    public void moverVehiculo(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){

        if(!posX.getText().equals("") && !posY.getText().equals("")){
            int fila = Integer.parseInt(posY.getText());
            int columna = Integer.parseInt(posX.getText());

            posY.setText("");
            posY.requestFocusInWindow();
            posX.setText("");
            posX.requestFocusInWindow();

            if(MovimientoValido0(fila, columna, x, y)){
                if(fila==X || columna ==Y){
                    if(!casillas[fila][columna].isMontaña() && !casillas[fila][columna].isAgua() && casillas[fila][columna].isEmpty() && casillas[fila][columna].isBootEmpty()){

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

            try{
                Thread.sleep(1500);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
            miTurno = false;
            jugar(x, y, tablero, casillas, ventanaJugar);
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

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(300, 80, 100, 30);
        informar.add(aceptar);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informar.setVisible(false);
                informar.removeAll();
            }
        };
        aceptar.addActionListener(oyenteAceptar);

        informar.add(informacionArea2);

        int l = 0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!casillas[i][j].isEmpty() && casillas[i][j].getVehiculo().getNombre().endsWith("Enemigo")){
                    l++;
                }
            }
        }

        if(l>0){

            int k;
            int contador = -1;
            k = (int)(Math.random()*l);

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

            int c, d;
            do{
                c = (int)(Math.random()*x);
                d = (int)(Math.random()*y);
            }while(Xboot!=c && Yboot!=d);

            if(boot.getTurnos()==6 && boot.isEstado()){
                boot.setEstado(false);
                boot.setTurnos(0);
                casillas[Xboot][Yboot].setTmp(null);
                casillas[Xboot][Yboot].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[Xboot][Yboot].getWidth(), casillas[Xboot][Yboot].getHeight(), Image.SCALE_SMOOTH)));
            }


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

                    if(posV==pos[0]){
                        v0 = true;
                    }
                    if(posV==pos[1]){
                        v1=true;
                    }
                    if(posV==pos[2]){
                        v2=true;
                    }

                    if(v0){
                        vehiculo1.setEnabled(false);
                        if(misVehiculos[pos[1]].isEstado()){
                            posV=pos[1];
                            casillas[a][b].setVehiculo(misVehiculos[posV]);
                            if(casillas[a][b].getVehiculo().isTanque()){
                                casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }else{
                                casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }
                            vehiculo2.setSelected(true);
                        }
                        if(!misVehiculos[pos[1]].isEstado() && misVehiculos[pos[2]].isEstado()){
                            posV=pos[2];
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
                        if(misVehiculos[pos[0]].isEstado()){
                            posV=pos[0];
                            casillas[a][b].setVehiculo(misVehiculos[posV]);
                            if(casillas[a][b].getVehiculo().isTanque()){
                                casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }else{
                                casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }
                            vehiculo1.setSelected(true);
                        }
                        if(!misVehiculos[pos[0]].isEstado() && misVehiculos[pos[2]].isEstado()){
                            posV=pos[2];
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
                        if(misVehiculos[pos[0]].isEstado()){
                            posV=pos[0];
                            casillas[a][b].setVehiculo(misVehiculos[posV]);
                            if(casillas[a][b].getVehiculo().isTanque()){
                                casillas[a][b].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }else{
                                casillas[a][b].setIcon(new ImageIcon(avion.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                            }
                            vehiculo1.setSelected(true);
                        }
                        if(!misVehiculos[pos[0]].isEstado() && misVehiculos[pos[1]].isEstado()){
                            posV=pos[1];
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

            if(boot.isEstado()){
                if(casillas[c][d].isEmpty() && !(casillas[c][d].isAgua() || casillas[c][d].isMontaña())){
                    informacionArea2.append("\nBoot disparo a  una casilla vacia.");
                    boot.setTurnos(boot.getTurnos() + 1);
                }
            }

            if(boot.isEstado()){
                if(casillas[c][d].isAgua() || casillas[c][d].isMontaña()){
                    casillas[c][d].setVida(casillas[c][d].getVida() - casillas[Xboot][Yboot].getTmp().getDañoDisparo());
                    informacionArea2.append("\nBoot disparo donde se encuentra un obstaculo");
                    informacionArea2.append(", vida actual del obstaculo: "+casillas[c][d].getVida());
                    if(casillas[c][d].getVida()<=0){
                        informacionArea2.append(", obstaculo destruido.");
                        casillas[c][d].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[a][b].getWidth(), casillas[a][b].getHeight(), Image.SCALE_SMOOTH)));
                        casillas[c][d].setAgua(false);
                        casillas[c][d].setMontaña(false);
                    }
                    boot.setTurnos(boot.getTurnos() + 1);
                }
            }

            if(boot.isEstado()){
                if(!casillas[c][d].isEmpty() && casillas[c][d].getVehiculo().getNombre().endsWith("Enemigo")){
                    casillas[c][d].getVehiculo().setPuntosVida(casillas[c][d].getVehiculo().getPuntosVida() - boot.getDañoDisparo());
                    informacionArea2.append("\nBoot disparo donde se encuentra el vehiculo: "+casillas[c][d].getVehiculo().getNombre());
                    informacionArea2.append(" puntos de Vida: "+casillas[c][d].getVehiculo().getPuntosVida());
                    if(casillas[c][d].getVehiculo().getPuntosVida() <= 0){
                        informacionArea2.append(", vehiculo destruido.");
                        casillas[c][d].setVehiculo(null);
                        casillas[c][d].setIcon(new ImageIcon(asfalto.getImage().getScaledInstance(casillas[c][d].getWidth(), casillas[c][d].getHeight(), Image.SCALE_SMOOTH)));
                    }
                    boot.setTurnos(boot.getTurnos() + 1);
                }
            }


            informar.setVisible(true);
        }

    }

    public void jugar(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){

        int miVida = 0;
        int vidaEnemigos = 0;


        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!casillas[i][j].isEmpty() && casillas[i][j].getVehiculo().getNombre().endsWith("Enemigo")){
                    vidaEnemigos+=casillas[i][j].getVehiculo().getPuntosVida();
                }
            }
        }

        if(vidaEnemigos<=0){
            //partidaGanada
            partidaGanada(x, y, tablero, casillas, ventanaJugar);
        }

        if(!miTurno && vidaEnemigos>0){
            movimientoPC(x, y, casillas, ventanaJugar);
            miTurno = true;
        }

        vidaEnemigos = 0;
        miVida = misVehiculos[pos[0]].getPuntosVida() + misVehiculos[pos[1]].getPuntosVida() + misVehiculos[pos[2]].getPuntosVida();
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(!casillas[i][j].isEmpty() && casillas[i][j].getVehiculo().getNombre().endsWith("Enemigo")){
                    vidaEnemigos+=casillas[i][j].getVehiculo().getPuntosVida();
                }
            }
        }

        if(miVida<=0){
            //partidaPerdida
            partidaPerdida(x, y, tablero, casillas, ventanaJugar);
        }
    }

    public void partidaGanada(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){
        JDialog pGanada = new JDialog(ventanaJugar, "Partida Ganada :)");
        pGanada.setSize(600, 220);
        pGanada.setLocationRelativeTo(null);
        pGanada.setLayout(null);
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setBounds(20, 20, 560, 100);
        ventana.jugador.setExperiencia(ventana.jugador.getExperiencia() + 125);
        ventana.jugador.setOro(ventana.jugador.getOro() + 125);
        ventana.jugador.setPartidasGanadas(ventana.jugador.getPartidasGanadas() + 1);

        misVehiculos[pos[0]].setExperiencia(misVehiculos[pos[0]].getExperiencia() + 125);
        misVehiculos[pos[1]].setExperiencia(misVehiculos[pos[1]].getExperiencia() + 125);
        misVehiculos[pos[2]].setExperiencia(misVehiculos[pos[2]].getExperiencia() + 125);

        misVehiculos[pos[0]].setPartidasGanadas(misVehiculos[pos[0]].getPartidasGanadas() + 1);
        misVehiculos[pos[1]].setPartidasGanadas(misVehiculos[pos[1]].getPartidasGanadas() + 1);
        misVehiculos[pos[2]].setPartidasGanadas(misVehiculos[pos[2]].getPartidasGanadas() + 1);
        boot.setEstado(false);


        info.setText("Felicidades, partida ganada");
        info.append("\nRecibes $125 de oro y 100 de xp");
        info.append("\nPartidas ganadas: "+ventana.jugador.getPartidasGanadas()+" Partidas perdidas: "+ventana.jugador.getPartidas_Perdidas());
        pGanada.add(info);

        System.out.println("experiencia: "+ventana.jugador.getExperiencia());
        System.out.println("oro: "+ventana.jugador.getOro());
        System.out.println("partidas ganadas: "+ventana.jugador.getPartidasGanadas());

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(250, 150, 100, 30);
        pGanada.add(aceptar);

        pGanada.setVisible(true);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pGanada.setVisible(false);
                eventoRendirse(x, y, tablero, ventanaJugar, casillas);
            }
        };
        aceptar.addActionListener(oyenteAceptar);
    }

    public void partidaPerdida(int x, int y, JPanel tablero, Casilla[][] casillas, JFrame ventanaJugar){
        JDialog pPerdida = new JDialog(ventanaJugar, "Partida Perdida :(");
        pPerdida.setSize(600, 220);
        pPerdida.setLocationRelativeTo(null);
        pPerdida.setLayout(null);
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setBounds(20, 20, 560, 100);
        ventana.jugador.setExperiencia(ventana.jugador.getExperiencia() + 20);
        ventana.jugador.setPartidas_Perdidas(ventana.jugador.getPartidas_Perdidas() + 1);
        ventana.jugador.setOro(ventana.jugador.getOro() + 20);

        misVehiculos[pos[0]].setExperiencia(misVehiculos[pos[0]].getExperiencia() + 20);
        misVehiculos[pos[1]].setExperiencia(misVehiculos[pos[1]].getExperiencia() + 20);
        misVehiculos[pos[2]].setExperiencia(misVehiculos[pos[2]].getExperiencia() + 20);

        misVehiculos[pos[0]].setPartidasPerdidas(misVehiculos[pos[0]].getPartidasPerdidas() + 1);
        misVehiculos[pos[1]].setPartidasPerdidas(misVehiculos[pos[1]].getPartidasPerdidas() + 1);
        misVehiculos[pos[2]].setPartidasPerdidas(misVehiculos[pos[2]].getPartidasPerdidas() + 1);
        boot.setEstado(false);

        info.setText("Sera para la proxima, partida perdida");
        info.append("\nRecibes $20 de oro y 20 de xp");
        info.append("\nPartidas ganadas: "+ventana.jugador.getPartidasGanadas()+" Partidas perdidas: "+ventana.jugador.getPartidas_Perdidas());
        pPerdida.add(info);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(250, 150, 100, 30);
        pPerdida.add(aceptar);
        pPerdida.setVisible(true);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pPerdida.setVisible(false);
                eventoRendirse(x, y, tablero, ventanaJugar, casillas);
            }
        };
        aceptar.addActionListener(oyenteAceptar);
    }

    public void eventoRendirse(int x, int y, JPanel tablero, JFrame ventanaJugar, Casilla[][] casillas){
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
        ventana.panelInformacion.removeAll();

        establecerNivel(ventanaJugar);
        ventana.inicializarLabels();
        //ventana.setVisible(true);

    }

    public void establecerNivel(JFrame ventanaJugar){
        int xp = ventana.jugador.getExperiencia();

        if(xp>0 && xp<=100){
            ventana.jugador.setNivel(1);
        }
        if(xp>100 && xp<=250){
            ventana.jugador.setNivel(2);
        }
        if(xp>250 && xp<=500){
            ventana.jugador.setNivel(3);
        }
        if(xp>500 && xp<=800){
            ventana.jugador.setNivel(4);
        }
        if(xp>800 && xp<=1200){
            ventana.jugador.setNivel(5);
        }
        if(xp>1200){
            ventana.jugador.setNivel(6);
        }

        for(int i=0; i<contadorVehiculos; i++){
            if(misVehiculos[i].getExperiencia()>0 && misVehiculos[i].getExperiencia()<=100){
                misVehiculos[i].setNivel(1);
            }

            if(misVehiculos[i].getExperiencia()>100 && misVehiculos[i].getExperiencia()<=250){
                misVehiculos[i].setNivel(2);
            }

            if(misVehiculos[i].getExperiencia()>250 && misVehiculos[i].getExperiencia()<=500){
                misVehiculos[i].setNivel(3);
            }

            if(misVehiculos[i].getExperiencia()>500 && misVehiculos[i].getExperiencia()<=800){
                misVehiculos[i].setNivel(4);
            }

            if(misVehiculos[i].getExperiencia()>800 && misVehiculos[i].getExperiencia()<=1200){
                misVehiculos[i].setNivel(5);
            }
            if(misVehiculos[i].getExperiencia()>1200){
                misVehiculos[i].setNivel(6);
            }

            misVehiculos[i].establecerAtributos();
        }

        JDialog informacion = new JDialog(ventanaJugar, "Informacion");
        informacion.setSize(600, 220);
        informacion.setLocationRelativeTo(null);
        informacion.setLayout(null);
        JTextArea info = new JTextArea();
        info.setEditable(false);
        info.setBounds(20, 20, 560, 100);

        info.setText(ventana.jugador.getNombre()+" Nivel: "+ventana.jugador.getNivel()+" Oro: "+ventana.jugador.getOro());
        info.append("\nVehiculos en partida:");
        info.append("\n"+misVehiculos[pos[0]].getNombre()+" Nivel: "+misVehiculos[pos[0]].getNivel()+" Vehiculos destruidos: "+misVehiculos[pos[0]].getEnemigosDestruidos());
        info.append(" Activo: "+misVehiculos[pos[0]].isEstado());
        info.append("\n"+misVehiculos[pos[1]].getNombre()+" Nivel: "+misVehiculos[pos[1]].getNivel()+" Vehiculos destruidos: "+misVehiculos[pos[1]].getEnemigosDestruidos());
        info.append(" Activo: "+misVehiculos[pos[1]].isEstado());
        info.append("\n"+misVehiculos[pos[2]].getNombre()+" Nivel: "+misVehiculos[pos[1]].getNivel()+" Vehiculos destruidos: "+misVehiculos[pos[2]].getEnemigosDestruidos());
        info.append(" Activo: "+misVehiculos[pos[2]].isEstado());
        informacion.add(info);

        JButton aceptar = new JButton("Aceptar");
        aceptar.setBounds(250, 150, 100, 30);
        informacion.add(aceptar);
        informacion.setVisible(true);

        ActionListener oyenteAceptar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informacion.setVisible(false);
                ventana.setVisible(true);
            }
        };
        aceptar.addActionListener(oyenteAceptar);
    }
}
