package ProyectoFinal;

import java.util.Scanner;
public class MenuPrincipal{

    Scanner entrada = new Scanner(System.in);
    public MenuPrincipal(){}

    public void MostrarMenu()
    {

        //Se ejecuta al inicio del programa

        //Crea 6 vehiculos enemigos por defecto asi como tambien inicializa los escenario por defecto

        //Si se desea iniciar partida, asigna el primer escenario a un arreglo que contiene el escenario a usar actualmente

        //Si se desea iniciar partida, asigna los primeros tres vehiculos creados a un arreglo para usar durante una partida

        int op;

        //Menu principal del juego
        do
        {

            System.out.println("\n1 - Jugar");
            System.out.println("2 - Vehiculos");
            System.out.println("3 - Escenarios");
            System.out.println("4 - Tienda");
            System.out.println("5 - Estadisticas");
            System.out.println("6 - Salir");
            System.out.print("Opcion: ");
            op = entrada.nextInt();
            System.out.println("");

            switch (op)
            {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:
                    break;

                case 6:
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 6);
    }


}
