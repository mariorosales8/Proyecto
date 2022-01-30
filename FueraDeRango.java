/**Excepcion para cuando se intenta mover a una casilla fuera del rango de movimiento de la pieza
 * @author Mario Rosales
 * @version 1.0
 */
public class FueraDeRango extends InvalidException{
    /**Metodo constructor sin parametros */
    public FueraDeRango(){
        System.out.println("Esa casilla esta fuera del rango de movimiento de la pieza. " + mensaje);
    }
}