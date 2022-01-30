import java.io.Serializable;

/**Clase que guarda el numero de jugadores serializados que hay
 *@authorMario Rosales
 * @version 1.0
 */
public class Serializados implements Serializable{
    private int serializados;

    /**Metodo constructor sin parametros */
    public Serializados(){
    serializados = 0;
    }

    /**Metodo para obtener el numero de serializados
     * @return El valor de serializados
     */
    public int getSerializados() {
        return serializados;
    }
    /**Metodo para asignar el numero de serializados
     * @param serializados El numero de jugadores serializados
     */
    public void setSerializados(int serializados) {
        this.serializados = serializados;
    }
    
}
