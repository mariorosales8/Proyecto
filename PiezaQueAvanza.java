/**Clase abstratca hija de Pieza que representa una pieza que avanza muchas casillas
 *@authorMario Rosales
 * @version 1.0
 */    
public abstract class PiezaQueAvanza extends Pieza{

    /**Metodo constructor con 3 parametros
    * @param color true si es blanca, false si es negra
    * @param x La posicion x
    * @param y La posicion y
    */
    public PiezaQueAvanza(char tipo, boolean color, int x, int y) {
        super(tipo, color, x, y);
    }
    

    /**Funcion recursiva para comprobar si la pieza se puede mover a una cierta posicion en una direccion
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @param direccion Un entero que representa la direccion a moverse
     * @return Un boolean que dice si se puede mover o no a esa posicion
     */
    public boolean avanzar(int x, int y, Pieza[][] tablero, int direccion){

        //Si la posicion que recibio la funcion es la posicion de la pieza, devuelve true
        if(x == this.x && y == this.y){
            return true;
        }else
            //Si no, si la posicion tiene otra pieza, devuelve false
            if(tablero[y][x] != null){
                return false;
        }

        //Si no se cumple algun caso base
        switch (direccion) {
            case 0:
                return avanzar(x+1, y, tablero, direccion);

            case 1:
                return avanzar(x, y+1, tablero, direccion);
            
            case 2:
                return avanzar(x-1, y, tablero, direccion);

            case 3:
                return avanzar(x, y-1, tablero, direccion);
                
            case 4:
                return avanzar(x+1, y+1, tablero, direccion);
            
            case 5:
                return avanzar(x-1, y+1, tablero, direccion);

            case 6:
                return avanzar(x-1, y-1, tablero, direccion);

            case 7:
                return avanzar(x+1, y-1, tablero, direccion);

            default:
                break;
        }
        return false;
    }
}
