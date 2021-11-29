/*

 */
package Curso;
import Asignatura.Asignatura;
import Listas.ListaAsignaturas;
/**
 *
 * @author victo
 */
public abstract class Curs {

    protected ListaAsignaturas asig;
    protected int codi;
    protected String nom;
    
    public Curs(ListaAsignaturas a, int codi, String nom){
        asig=a;
        this.codi=codi;
        this.nom=nom;
    }
    public ListaAsignaturas getlista(){
        return asig;
    }
    public abstract boolean compare(Curs c);
    @Override
    public abstract String toString();
    
    public abstract String getNom();
    
    public abstract int getCodi();
    
    public abstract void setNom(String name);
    
    public abstract void setCodi(int cod);
    
    public abstract String getNameAsignaturalist(int i);
    
    public abstract Asignatura getAsignaturalist(int i);
    
    public abstract Asignatura search(String a);
    
    public abstract boolean searchString(String d);
    
    public abstract int asigsize();
    
    public abstract boolean pertenece(Object x);
    
    public abstract void removeasig(Object x);
    
    public abstract void addasig(Object x);
    
}
