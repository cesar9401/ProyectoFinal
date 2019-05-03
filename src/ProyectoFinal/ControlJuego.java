package ProyectoFinal;

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
    protected int rdmMontaña;
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
            contadorVehiculos++;
        }
    }

    public void crearAvion(){
        if(contadorVehiculos<30){
            misVehiculos[contadorVehiculos] = new Avion();
        }
    }

    public void getTablero1(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                Tablero1[i][j] = new Casilla();
                ventana.btnJugar4x4.tablero4x4.add(Tablero1[i][j]);
            }
        }

        rdmMontaña = (int)(Math.random()*4+1);
        rdmX = (int)(Math.random()*4);
        rdmY = (int)(Math.random()*4);

        int contador = 0;
        do{
            if(!Tablero1[rdmX][rdmY].isMontaña() && !Tablero1[rdmX][rdmY].isAgua() && contador<=rdmMontaña){
                Tablero1[rdmX][rdmY].setMontaña(true);
                Tablero1[rdmX][rdmY].setText("Montaña");
                rdmX = (int)(Math.random()*4);
                rdmY = (int)(Math.random()*4);
                contador++;
            }

            if(!Tablero1[rdmX][rdmY].isMontaña() && !Tablero1[rdmX][rdmY].isAgua() && contador!=4){
                Tablero1[rdmX][rdmY].setAgua(true);
                Tablero1[rdmX][rdmY].setText("Agua");
                rdmX = (int)(Math.random()*4);
                rdmY = (int)(Math.random()*4);
                contador++;
            }
            rdmX = (int)(Math.random()*4);
            rdmY = (int)(Math.random()*4);
        }while (contador != 4);
    }

    public void getTablero2(){
        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                Tablero2[i][j] = new Casilla();
                ventana.btnJugar6x4.tablero6x4.add(Tablero2[i][j]);
            }
        }

        rdmMontaña = (int)(Math.random()*6+1);
        rdmX = (int)(Math.random()*6);
        rdmY = (int)(Math.random()*4);

        int contador = 0;
        do{
            if(!Tablero2[rdmX][rdmY].isMontaña() && !Tablero2[rdmX][rdmY].isAgua() && contador<=rdmMontaña){
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

        rdmMontaña = (int)(Math.random()*18+1);
        rdmX = (int)(Math.random()*8);
        rdmY = (int)(Math.random()*9);

        int contador = 0;
        do{
            if(!Tablero3[rdmX][rdmY].isMontaña() && !Tablero3[rdmX][rdmY].isAgua() && contador<=rdmMontaña){
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
    }

}
