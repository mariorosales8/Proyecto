/**Excepcion para cuando se selecciona una casilla que no tiene una pieza tuya
 * @author Mario Rosales
 * @version 1.0
 */
public class NoPiezaException extends InvalidException{
    /**Metodo constructor sin parametros */
    public NoPiezaException(){
        System.out.println("No hay una pieza tuya en esa casilla. " + mensaje);
    }
}
