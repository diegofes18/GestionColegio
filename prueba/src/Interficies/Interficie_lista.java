

package Interficies;



/**
 *
 * @author berme
 */
public interface Interficie_lista {
      
    //devuelve longitud
    public int getlength();
    
   //devuelve string de la lista
    public String toString();
    
    //elimina un objeto de la lista
    public void deleteObject(Object t);
    
    //ordena la lista
    public void ordena();
    
    //añade un objeto al final de la lista
    public void addObject(Object a);
    
    public boolean pertenece(String d);
    
    public String getInfoName(int i);
    
    public Object returnObject(Object x);
    
    public void actualiza(Object x,Object y);
    

    
}
