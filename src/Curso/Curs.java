/*

 */
package Curso;
import Asignatura.Asignatura;
import Listas.ListaAsignaturas;
import Interficies.Interficie_Data;
/**
 *
 * @author victo
 */
public abstract class Curs implements Interficie_Data{

    protected ListaAsignaturas asig;
    protected int codi;
    protected String nom;
    
    public Curs(ListaAsignaturas a, int codi, String nom){
        asig=a;
        this.codi=codi;
        this.nom=nom;
    }
    
    public abstract ListaAsignaturas getlista();
    
    @Override
    public boolean compare(Object x) {
        Curs curs=(Curs) x;
        if(this.nom==curs.getNom()){
            return true;
        }else{
            return false;
        }
        
    }
    @Override
    public abstract String toString();
    
    @Override
    public abstract String getNom();
    
    @Override
    public abstract int getCodi();
    
    @Override
    public abstract void setNom(String name);
    @Override
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
