/**Excepcion para cuando se introduce una entrada invalida
 * @author Mario Rosales
 * @version 1.0
 */
public class EntradaInvalida extends Exception{
    /**Metodo constructor sin parametros */
    public EntradaInvalida(){
        System.out.println("Entrada invalida, intentalo de nuevo");
    }
}
