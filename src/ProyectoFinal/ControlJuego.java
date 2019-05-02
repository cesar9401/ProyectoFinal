package ProyectoFinal;

public class ControlJuego{

    Ventana ventana;
    BtnJugar btnJugar;

    Tanque tanqueEjemplo = new Tanque();
    Avion avionEjemplo = new Avion();
    TanqueEnemigo[] tanqueEnemigos = new TanqueEnemigo[3];
    AvionEnemigo[] avionEnemigos = new AvionEnemigo[3];
    Vehiculos[] misVehiculos = new Vehiculos[30];
    Casilla[][] Tablero1 = new Casilla[4][4];
    Casilla[][] Tablero2 = new Casilla[6][4];
    Casilla[][] Tablero3 = new Casilla[8][9];
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

    }

    public void getTablero2(){

    }

    public void getTablero3(){

    }

}
