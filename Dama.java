/**Clase hija de PiezaQueAvanza que representa a la reina
 *@authorMario Rosales
 * @version 1.0
 */    
public class Dama extends PiezaQueAvanza{

    /**Metodo constructor con 3 parametros
    * @param color true si es blanca, false si es negra
    * @param x La posicion x
    * @param y La posicion y
    */
    public Dama(boolean color, int x, int y) {
        super('D', color, x, y);
    }


    /**Metodo para verificar si una posicion esta en el rango de movimiento de la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si esta o no en el rango
     */
    public boolean enRango(int x, int y, Pieza[][] tablero){
        //Si el movimiento esta en el rango de la reina sin contar si hay piezas que lo impidan
        //if (x == this.x || y == this.y || x - this.x == y - this.y || x- this.x == this.y - y) {

        //Si la nueva posicion esta en la misma columna que la reina
        if (x == this.x) {
            //Si la nueva posicion esta arriba de la reina
            if(y - this.y < 0){
                return avanzar(x, y+1, tablero, 1);
            //Si esta abajo
            }else{
                return avanzar(x, y-1, tablero, 3);

            }

        } else {
            //Si la nueva posicion esta en la misma fila que la reina
            if(y == this.y){
                ////Si esta a la izquierda de la reina
                if(x - this.x < 0){
                    return avanzar(x+1, y, tablero, 0);
                //Si esta a la derecha
                }else{
                    return avanzar(x-1, y, tablero, 2);
    
                }
            }else{
                //Si la nueva posicion esta en la misma diagonal izquierda-arriba / derecha-abajo
                if (x - this.x == y - this.y) {
                    ////Si esta a la izquierda y arriba de la reina
                    if(x - this.x < 0){
                        return avanzar(x+1, y+1, tablero, 4);
                    //Si esta a la derecha y abajo
                    }else{
                        return avanzar(x-1, y-1, tablero, 6);

                    }
                
                } else {
                    //Si la nueva posicion esta en la misma diagonal izquierda-abajo / derecha-arriba
                    if(x- this.x == this.y - y){
                        ////Si esta a la izquierda y abajo de la reina
                        if(x - this.x < 0){
                            return avanzar(x+1, y-1, tablero, 7);
                        //Si esta a la derecha y arriba
                        }else{
                            return avanzar(x-1, y+1, tablero, 5);

                        }

                    //Si no está en la misma linea ni diagonal   
                    }else{
                        return false;
                    }
                }
            }
        } 
    }
}
