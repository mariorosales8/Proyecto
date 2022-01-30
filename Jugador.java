import java.io.Serializable;

/**Clase que guarda los datos de un jugador
 *@authorMario Rosales
 * @version 1.0
 */
public class Jugador implements Serializable{
    
    private String nombre;
    private int victorias;

    /**
     * Metodo constructor con 3 parametros
     * @param nombre El nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        victorias = 1;
    }


    /**Metodo para obtener el nombre
     * @return El nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }
    /**Metodo para asignar el nombre
     * @param derrotas El nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**Metodo para obtener el numero de victorias
     * @return La cantidad de victorias del jugador
     */
    public int getVictorias() {
        return victorias;
    }
    /**Metodo para asignar el numero de victorias
     * @param victorias La cantidad de victorias del jugador
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }




    public boolean menorQue(Jugador otro){
        if(this.victorias < otro.getVictorias()){
            return true;
        }else{
            return false;
        }
    }




    

    
}
