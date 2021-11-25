
package Asignatura;

import Estudiant.Estudiant;
import Listas_ref.Asignatura_Estudiant;

/**
 CLASE ASIGNATURA , PADRE DE OBLIGATORIA Y OPTATIVA
 */
public abstract class Asignatura {
    
    protected String name;
    protected int codigo;
    protected Asignatura_Estudiant listaalumn;
    //add lista referencia estudiante
    
    public Asignatura (int cod,String nombre,Asignatura_Estudiant lae){
        codigo=cod;
        name=nombre;
        listaalumn =lae;
    }
    
    //metodos abstractos
    public abstract boolean compare(Asignatura a);

    public abstract String getName();

    public abstract int getCodigo();

    public abstract void setName(String name); 

    public abstract void setCodigo(int codigo); 
    
    public abstract Asignatura_Estudiant getAsignatura_Estudiant();
    
    
    public abstract String toString();
    
    public abstract boolean estupertenece(Estudiant x);
    
    public abstract void addestu(Estudiant x);
    
    
    
}
