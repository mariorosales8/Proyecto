/**Clase hija de PiezaQueAvanza que representa una torre
 *@authorMario Rosales
 * @version 1.0
 */
public class Torre extends PiezaQueAvanza{
    /**Metodo constructor con 3 parametros
     * @param color true si es blanca, false si es negra
     * @param x La posicion x
     * @param y La posicion y
     */
    public Torre(boolean color, int x, int y) {
        super('t', color, x, y);
    }
    
    /**Metodo para verificar si una posicion esta en el rango de movimiento de la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si esta o no en el rango
     */
    public boolean enRango(int x, int y, Pieza[][] tablero){

        //Si la nueva posicion esta en la misma columna que la torre
        if (x == this.x) {
            //Si la nueva posicion esta arriba de la torre
            if(y - this.y < 0){
                return avanzar(x, y+1, tablero, 1);
            //Si esta abajo
            }else{
                return avanzar(x, y-1, tablero, 3);

            }

        } else {
            //Si la nueva posicion esta en la misma fila que la torre
            if(y == this.y){
                ////Si la nueva posicion esta a la izquierda de la torre
                if(x - this.x < 0){
                    return avanzar(x+1, y, tablero, 0);
                //Si esta a la derecha
                }else{
                    return avanzar(x-1, y, tablero, 2);
    
                }

            //Si no esta en la misma fila ni en la misma columna
            }else{
                return false;
            }
        }

    }



}
