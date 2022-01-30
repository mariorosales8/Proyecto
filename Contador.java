/**
 *Clase para contar cuantas fichas quedan
 *@author Mario Rosales
 *@version 1.0
 */
public class Contador {
    static int bpeones = 6;
    static int btorres = 2;
    static int bcaballos = 2;
    static int bdama = 1;
    static int brey = 1;

    static int npeones = 6;
    static int ntorres = 2;
    static int ncaballos = 2;
    static int ndama = 1;
    static int nrey = 1;


    /**Metodo para comprobar si algun jugador gano
     * @param color El color del jugador que se va a comprobar
     * @return Un booleano que dice si ya gano o no
     */
    public static boolean ganar(boolean color){
        if(color){
            if(npeones*ntorres*ncaballos*ndama*nrey == 0)
            return true;
        else
            return false;
        }else{
            if(bpeones*btorres*bcaballos*bdama*brey == 0)
                return true;
        else
            return false;
        }
    }
}
