import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 *Clase para jugar ajedrez en la variante de extincion
 *@author Mario Rosales
 *@version 1.0
 */
public class Ajedrez {
    /**Metodo principal
     * @param args Un arreglo de Strings con los nombres de los jugadores
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fin = false;
        boolean turno = true;
        boolean valido = false;
        boolean valido2 = false;
        int coordenada = 0; 
        int nuevaCoor = 0;
        String j = "";
        String j1 = "";
        String j2 ="";
        boolean com = false;
        int turnos = 200;


        //Si no hay argumentos
        if(args.length == 0){
            //SERIALIZABLEEEEEES
        
        //Si hay argumentos
        }else{
            //El primero es el jugador 1
            j1 = args[0];

            //Si no hay otro argumento
            if(args.length == 1){
                //El jugador 2 es la computadora
                j2 = "la computadora";
                com = true;
            //Si hay otro argumento
            }else{
                //Ese argumento es el jugador 2
                j2 = args[1];
                com = false;
            }
        

            Random rn = new Random();

            System.out.println("Elige el numero maximo de turnos\n1) 20 turnos\n2) 40 turnos\n3)100 turnos\n0) Salir");
            do{
                valido = true;

                try {
                    switch (sc.nextInt()) {
                        case 1:
                            turnos = 40;
                            break;

                        case 2:
                            turnos = 80;
                            break;

                        case 3:
                            turnos = 200;
                            break;

                        case 0:
                            System.exit(0);
                    
                        default:
                            System.out.println("Entrada invalida. Intentalo de nuevo");
                            valido = false;
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Intentalo de nuevo");
                    valido = false;

                } catch (Exception e) {
                    System.out.println("Error. Intentalo de nuevo");
                    valido = false;
                }
            }while(!valido);

            //Coloca las piezas
            inicio();

            while(!fin){
                //Se acomoda el nombre del jugador al que le toca
                if (turno) {
                    j = j1;
                } else {
                    j = j2;
                }

                System.out.println("¿Que pieza quieres mover, " + j + 
                "? (Escribe columna y fila sin espacios)");
                print();
                
                do{
                    valido = true;
                    try{

                        //Si es turno de una persona
                        if(turno || !com){
                            //Lee la coordenada que escriba el usuario
                            coordenada = sc.nextInt();
                        
                        //Si es turno de la computadora
                        }else{
                            coordenada = rn.nextInt(6)*10 + rn.nextInt(6);
                        }

                        Pieza selec = tablero[coordenada % 10][coordenada / 10];
                        //Verifica que la casilla no este vacia
                        if(selec != null){
                            
                            //Verifica que la pieza sea de la persona a la que le toca
                            if(turno == selec.getColor()){

                                //Selecciona la pieza
                                selec.setSeleccion(true);
                                
                            }else{
                                throw new NoPiezaException(); 
                            }
                        }else{
                            throw new NoPiezaException();
                        }


                            System.out.println("¿A donde quieres moverla?");
                            print();
                
                            do {
                                valido2 = true;
                                
                                try {

                                    //Si es turno de una persona
                                    if(turno || !com){
                                        //Lee la coordenada que escriba el usuario
                                        nuevaCoor = sc.nextInt();
                        
                                    //Si es turno de la computadora
                                    }else{
                                        nuevaCoor = rn.nextInt(6)*10 + rn.nextInt(6);
                                    }
                                    
                                    
                                    //Si no esta en el rango de movimiento de la pieza
                                    if(!selec.mover(nuevaCoor / 10, nuevaCoor % 10, tablero, com)){
                                        
                                        //Si se selecciono otra pieza tuya, se cambia a esa pieza
                                        if(tablero[nuevaCoor % 10][nuevaCoor / 10].getColor() == turno){
                                            selec = tablero[nuevaCoor % 10][nuevaCoor / 10];

                                        }
                                        
                                        valido2 = false;


                                    }

                                }catch(InputMismatchException e){
                                    System.out.println("Entrada invalida. Intentalo de nuevo");
                                    valido2 = false;
                                    sc.nextLine();

                                } catch (NullPointerException e) {
                                    valido2 = false;

                                } catch (Exception e) {
                                    System.out.println("Entrada invalida. Intentalo de nuevo");
                                    valido2 = false;
                                    
                                }finally{
                                    print();
                                }
                
                            } while (!valido2);


                    }catch(NoPiezaException e){
                        valido = false;

                    }catch(InputMismatchException e){
                        System.out.println("Entrada invalida. Intentalo de nuevo");
                        valido = false;
                        sc.nextLine();
                        
                    }catch(Exception e){
                        System.out.println("Entrada invalida. Intentalo de nuevo");
                        valido = false;
                    }
                }while(!valido);

                //Comprueba si ya gano el jugador actual
                if(Contador.ganar(turno)){
                    System.out.println("\n ¡¡¡¡Gana " + j + "!!!!\n\n");
                    fin = true;
                }

                //Pasa el turno al otro jugador
                turno = !turno;

                //Descuenta uno al numero de turnos restantes
                turnos--;
                //Si ya se acabaron los turnos
                if(turnos == 0){
                    //Gana un jugador aleatorio
                    if(rn.nextBoolean()){
                        j = j1;
                    }else{
                        j = j2;
                    }
                    System.out.println("Limite de turnos\n\n ¡¡¡¡Gana " + j + "!!!!\n\n");
                    fin = true;
                }


            }
        }
            
    }
        
    





    //Tablero de 6x6
    static Pieza[][] tablero = new Pieza[6][6];


    /**Metodo para colocar las piezas en su posición inicial */
    public static void inicio(){
        //Peones blancos
        tablero[4][0] = new Peon(true, 0, 4);
        tablero[4][1] = new Peon(true, 1, 4);
        tablero[4][2] = new Peon(true, 2, 4);
        tablero[4][3] = new Peon(true, 3, 4);
        tablero[4][4] = new Peon(true, 4, 4);
        tablero[4][5] = new Peon(true, 5, 4);
        //Peones negros
        tablero[1][0] = new Peon(false, 0, 1);
        tablero[1][1] = new Peon(false, 1, 1);
        tablero[1][2] = new Peon(false, 2, 1);
        tablero[1][3] = new Peon(false, 3, 1);
        tablero[1][4] = new Peon(false, 4, 1);
        tablero[1][5] = new Peon(false, 5, 1);

        //Caballos blancos
        tablero[5][1] = new Caballo(true, 1, 5);
        tablero[5][4] = new Caballo(true, 4, 5);
        //Caballos negros
        tablero[0][1] = new Caballo(false, 1, 0);
        tablero[0][4] = new Caballo(false, 4, 0);

        //Torres blancas
        tablero[5][0] = new Torre(true, 0, 5);
        tablero[5][5] = new Torre(true, 5, 5);
        //Torres negras
        tablero[0][0] = new Torre(false, 0, 0);
        tablero[0][5] = new Torre(false, 5, 0);

        //Rey blanco
        tablero[5][3] = new Rey(true, 3, 5);
        //Rey negro
        tablero[0][3] = new Rey(false, 3, 0);

        //Reina blanca
        tablero[5][2] = new Dama(true, 2, 5);
        tablero[0][2] = new Dama(false, 2, 0);

    }

    /**Metodo para imprimir el tablero en pantalla 
    */
    public static void print(){
        //Bucle que recorre las filas
        for(int i=0; i < tablero.length; i++){

            //Bucle que imprime una fila completa
            for(int j=0; j < tablero[i].length; j++){
                //Comprueba que la casilla no este vacia
                if(tablero[i][j] != null)
                    System.out.print("|" + tablero[i][j].ver());
                else
                    System.out.print("|   ");
            }
            System.out.println("| " + i);
        }

        //Bucle que imprime los numeros de las columnas
        for(int i=0; i<=5; i++){
            System.out.print("  " + i + " ");
        }
        System.out.println();

    }
    
}