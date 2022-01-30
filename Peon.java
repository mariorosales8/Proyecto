/**Clase hija de Pieza que representa un peon
 *@authorMario Rosales
 * @version 1.0
 */
public class Peon extends Pieza{

    private boolean sinMover = true;


    /**Metodo constructor con 3 parametros
     * @param color true si es blanca, false si es negra
     * @param x La posicion x
     * @param y La posicion y
     */
    public Peon(boolean color, int x, int y) {
        super('p', color, x, y);
    }


    /**Metodo para verificar si una posicion esta en el rango de movimiento de la pieza
     * @param x La columna donde se quiere mover
     * @param y La fila donde se quiere mover
     * @param tablero Un arreglo con la posicion de todas las piezas
     * @return Un booleano que dice si esta o no en el rango
     */
    public boolean enRango(int x, int y, Pieza[][] tablero){
        try{

            Pieza nuevaPza = tablero[y][x];
            boolean arriba = true;
            boolean izquierda = true;
            boolean derecha = true;
            boolean abajo = true;


            //Comprueba si se puede salir del tablero por un lado
            if(this.x - 1 < 0){
                izquierda = false;
            }
            if(this.x + 1 > 5){
                derecha = false;
            }


            //Si el peon es blanco
            if (color) {
            
                //Comprueba si se puede salir del tablero por arriba
                if(this.y - 1 < 0){
                  arriba = false;
                }
                

                //Si el movimiento esta en el rango del peon
                if(arriba && ((x == this.x && tablero[this.y -1][this.x] == null && (y == this.y -1 || 
                (y == this.y - 2 && sinMover && nuevaPza == null)))  ||  (((izquierda && x == this.x -1) 
                || (derecha && x == this.x +1)) && y == this.y -1 && nuevaPza != null))){

                    sinMover = false;

                    return true;
                }

            //Si no es blanco
            }else {

                //Comprueba si se puede salir del tablero por abajo
                if(this.y + 1 > 5){
                    abajo = false;
                }
            
                //Si el movimiento esta en el rango del peon
                if(abajo && ((x == this.x && tablero[this.y +1][this.x] == null && (y == this.y +1 || 
                (y == this.y +2 && sinMover && nuevaPza == null)))  ||  (((izquierda && x == this.x -1) 
                || (derecha && x == this.x +1)) && y == this.y +1 && nuevaPza != null))){

                    sinMover = false;

                    return true;
                }

            }return false;

        }catch (Exception e) {
            return false;
        }
    }





    
}
