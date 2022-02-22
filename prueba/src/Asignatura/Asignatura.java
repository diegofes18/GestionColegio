
package Asignatura;

import Estudiant.Estudiant;
import Interficies.Interficie_Data;
import Listas_ref.Asignatura_Estudiant;

/**
 CLASE ASIGNATURA , PADRE DE OBLIGATORIA Y OPTATIVA
 */
public abstract class Asignatura implements Interficie_Data{
    
    protected String nom;
    protected int codi;
    protected Asignatura_Estudiant listaalumn;
    //add lista referencia estudiante
    
    public Asignatura (int cod,String nombre,Asignatura_Estudiant lae){
        codi=cod;
        nom=nombre;
        listaalumn =lae;
    }
    
    //metodos abstractos
    
    @Override
    public abstract boolean compare(Object x);
    
    @Override
    public abstract String getNom();
    
    @Override
    public abstract int getCodi();

    @Override
    public abstract void setNom(String name);

    @Override
    public abstract void setCodi(int codigo);
    
    @Override
    public abstract String toString();
    
    public abstract Asignatura_Estudiant getAsignatura_Estudiant();
    
    public abstract String toString2();
    
    public abstract boolean estupertenece(Estudiant x);
    
    public abstract void addestu(Estudiant x);
    
    public abstract Estudiant geteestu(int i);
    
    
}
