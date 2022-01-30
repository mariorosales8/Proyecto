/**Clase hija de Pieza que representa al rey
 *@authorMario Rosales
 * @version 1.0
 */    
public class Rey extends Pieza{

    /**Metodo constructor con 3 parametros
    * @param color true si es blanca, false si es negra
    * @param x La posicion x
    * @param y La posicion y
    */
    public Rey(boolean color, int x, int y) {
        super('R', color, x, y);
    }


    /**Metodo para verificar si una posicion esta en el rango de movimiento de la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si esta o no en el rango
     */
    public boolean enRango(int x, int y, Pieza[][] tablero){

        //Si el movimiento esta en el rango del rey
        if ((x == this.x || x == this.x +1 || x == this.x -1) && 
        (y == this.y || y == this.y +1 || y == this.y-1)){
            
            return true;

        } else {
            return false;
        }

    }
}
