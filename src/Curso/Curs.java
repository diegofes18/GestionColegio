/*

 */
package Curso;
import Interficies.Interficie_Data;
import Asignatura.Asignatura;
import Listas.ListaAsignaturas;
/**
 *
 * @author victo
 */
public abstract class Curs implements Interficie_Data{

    protected ListaAsignaturas lista;
    protected int codi;
    protected String nom;
    
    public Curs(ListaAsignaturas a, int codi, String nom) {
        lista=a;
        this.codi=codi;
        this.nom=nom;
    }
    
    
    
    public abstract String getNameAsignaturalist(int i);
    
    public abstract Asignatura getAsignaturalist(int i);
    
    public abstract Asignatura search(String a);
    
    public abstract boolean searchString(String d);
    
    public abstract int asigsize();
    
    public abstract boolean pertenece(Object x);
    
    public abstract void removeasig(Object x);
    
    public abstract void addasig(Object x);
    
}
