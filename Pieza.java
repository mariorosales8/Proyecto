import java.security.Principal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**Clase que representa una pieza
 * @author Mario Rosales
 * @version 1.0
 */
public abstract class Pieza {
    protected char tipo;
    protected boolean color;  
    protected boolean seleccion;
    protected int x;
    protected int y;


     /**Metodo constructor que recibe el tipo y el color de la pieza
     * @param tipo El caracter que representa al tipo de pieza
     * @param color true si es blanca, false si es negra
     * @param x La posicion x
     * @param y La posicion y
     */
    public Pieza(char tipo, boolean color, int x, int y){
        this.tipo = tipo;
        this.color = color;
        this.x = x;
        this.y = y;
    }


    /**Metodo para obtener la posicion y
     * @return La posicion y
     */
    public int getY() {
        return y;
    }


    /**Metodo para asignar la posicion y
     * @param y La posicion y
     */
    public void setY(int y) {
        this.y = y;
    }


    /**Metodo para obtener la posicion x
     * @return La posicion x
     */
    public int getX() {
        return x;
    }


/**Metodo para asignar la posicion x
     * @param x La posicion x
     */
    public void setX(int x) {
        this.x = x;
    }



    /**Metodo para obtener el tipo de la pieza
     * @return Un caracter que representa el tipo
     */
    public char getTipo() {
        return tipo;
    }

    /**Metodo para asignar el tipo de la pieza
     *@param char El caracter que representa el tipo de la pieza
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }


    /**Metodo para obtener el color de la pieza
     * @return true si es blanca, false si es negra
     */
    public boolean getColor(){
        return color;
    }

    /**Metodo para asignar el color de la pieza
     *@param char true si es blanca, false si es negra
     */
    public void setColor(boolean color) {
        this.color = color;
    }


    /**Metodo para saber si la pieza esta seleccionada
     * @return Un booleano que indica si esta seleccionada o no
     */
    public boolean getSeleccion(){
        return seleccion;
    }

    /**Metodo para seleccionar o deseleccionar la pieza
     * @param Un booleano que indica si se selecciona o no
     */
    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }



    /**Metodo para mostrar como se ve la pieza en el juego
     * @return El String con el que se imprimirá la pieza
     */
    public String ver(){
        if(seleccion){
            return "<" + tipo + ">";
        }else
            if(color)
                return "(" + tipo + ")";
            else
                return "{" + tipo + "}";
        
    }



    /**Metodo para mover la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si se pudo mover o no
     */
    public boolean mover(int x, int y, Pieza[][] tablero){
        try {

            Pieza nuevaPza = tablero[y][x];

            //Si no hay una pieza en las coordenadas
            if (nuevaPza == null) {

                //Si la nueva posicion esta en el rango de movimiento de la pieza
                if(enRango(x, y, tablero)){
                
                    //Mueve la pieza
                    tablero[y][x] = this;
                    tablero[this.y][this.x] = null;

                    //Deselecciona la pieza
                    this.setSeleccion(false);

                    //Cambia la posicion x e y de la pieza
                    this.x = x;
                    this.y = y;

                    //Comprueba si hubo coronacion
                    if(this.tipo == 'p' && (this.y == 0 || this.y == 5)){
                        coronar(tablero);
                    }

                    return true;

                //Si no esta en rango
                }else{
                    throw new FueraDeRango();
                }

            //Si hay una pieza
            } else {
                
                //Verifica si la pieza es tuya
                if (color == nuevaPza.color) {
                    
                    //Deselecciona esta pieza y selecciona la nueva
                    setSeleccion(false);
                    nuevaPza.setSeleccion(true);

                    System.out.println("Seleccionaste otra pieza. ¿A donde quieres moverla?");
                    
                    return false;

                //Si la pieza no es tuya
                } else {

                    //Si esta en rango para comerla
                    if(enRango(x, y, tablero)){

                        //Descuento 1 al contador de la pieza comida
                        switch (tablero[y][x].getTipo()) {
                            case 'p':                                
                                if (tablero[y][x].getColor()) {
                                    Contador.bpeones -= 1;
                                } else {
                                    Contador.npeones -= 1;
                                }
                                break;

                            case 't':
                                if (tablero[y][x].getColor()) {
                                    Contador.btorres -= 1;
                                } else {
                                    Contador.ntorres -= 1;
                                }
                                break;

                            case 'c':
                                if (tablero[y][x].getColor()) {
                                    Contador.bcaballos -= 1;
                                } else {
                                    Contador.ncaballos -= 1;
                                }
                                break;

                            case 'D':
                                if (tablero[y][x].getColor()) {
                                    Contador.bdama -= 1;
                                } else {
                                    Contador.ndama -= 1;
                                }
                                break;
                                
                            case 'R':
                                if (tablero[y][x].getColor()) {
                                    Contador.brey -= 1;
                                } else {
                                    Contador.nrey -= 1;
                                }
                                break;
    
                            default:
                                break;
                        }
                        
                        //Mueve la pieza
                        tablero[y][x] = this;
                        tablero[this.y][this.x] = null;

                        //Deselecciona la pieza
                        this.setSeleccion(false);

                        //Cambia la posicion x e y de la pieza
                        this.x = x;
                        this.y = y;

                        //Comprueba si hubo coronacion
                        if(this.tipo == 'p' && (this.y == 0 || this.y == 5)){
                        coronar(tablero);
                    }
                        
                        return true;

                    //Si no esta en rango
                    }else{
                        throw new FueraDeRango();
                    }
                }
            }

        }catch(FueraDeRango e){
            return false;

        } catch (Exception e) {
                return false;
        }
    }


    public void coronar(Pieza[][] tablero){
        Scanner sc = new Scanner(System.in);

        //Descuenta 1 al numero de peones
        if(color){
            Contador.bpeones -= 1;
        }else{
            Contador.npeones -= 1;
        }

        boolean valido = true;

        System.out.println("Coronaste al peon. ¿Cual pieza quieres? (Escribe su letra)");


        do {
            valido = true;

            try{

                //Recibe la entrada del usuario
                switch (sc.nextLine()) {
                    
                    //Reina
                    case "D":
                        //Cambia las piezas
                        tablero[y][x] = new Dama(color, x, y);

                        //Aumenta 1 al contador de las reinas
                        if(color){
                            Contador.bdama += 1;
                        }else{
                            Contador.ndama += 1;
                        }

                        break;

                    //Rey
                    case "R":
                        //Cambia las piezas
                        tablero[y][x] = new Rey(color, x, y);

                        //Aumenta 1 al contador de los reyes
                        if(color){
                            Contador.brey += 1;
                        }else{
                            Contador.nrey += 1;
                        }

                        break;

                    //Torre
                    case "t":
                        //Cambia las piezas
                        tablero[y][x] = new Torre(color, x, y);

                        //Aumenta 1 al contador de las torres
                        if(color){
                            Contador.btorres += 1;
                        }else{
                            Contador.ntorres += 1;
                        }
                        
                        break;

                    //Caballo
                    case "c":
                        //Cambia las piezas
                        tablero[y][x] = new Caballo(color, x, y);

                        //Aumenta 1 al contador de los caballos
                        if(color){
                            Contador.bcaballos += 1;
                        }else{
                            Contador.ncaballos += 1;
                        }

                        break;

                    //Peon
                    case "p":
                        System.out.println("No puede ser un peon. Prueba con otra pieza");
                        valido = false;
                        break;
            
                    //Si no es ninguno de los anteriores
                    default:
                        System.out.println("Esa no es una pieza. Intentalo de nuevo");
                        valido = false;
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Entrada invalida. Intentalo de nuevo");
                valido = false;

            }catch(Exception e){
                System.out.println("Error. Intentalo de nuevo");
                valido = false;
            }

        } while (!valido);
    }



    

/**Metodo abstracto para verificar si una posicion esta en el rango de movimiento de la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si esta o no en el rango
     */
    public abstract boolean enRango(int x, int y, Pieza[][] tablero);
    




}
