
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
    public  boolean compare(Object x){
        Asignatura asig=(Asignatura)x;
        if(this.nom==asig.getNom()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public abstract String getNom();

    @Override
    public abstract int getCodi();

    @Override
    public abstract void setNom(String name); 

    @Override
    public abstract void setCodi(int codigo); 
    
    public abstract Asignatura_Estudiant getAsignatura_Estudiant();
    
    
    @Override
    public abstract String toString();
    
    public abstract boolean estupertenece(Estudiant x);
    
    public abstract void addestu(Estudiant x);
    
    public  Estudiant geteestu(int i){
        return this.listaalumn.getInfo(i);
    }
    
    
}
