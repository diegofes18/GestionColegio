
package Asignatura;

import Interficies.Interficie_Data;
import Estudiant.Estudiant;
import Listas_ref.Asignatura_Estudiant;

/**
 CLASE ASIGNATURA , PADRE DE OBLIGATORIA Y OPTATIVA
 */
public abstract class Asignatura implements Interficie_Data{
    
    protected String nom;
    protected int codi;
    protected Asignatura_Estudiant lista;
    //add lista referencia estudiante
    
    public Asignatura (int cod,String nombre,Asignatura_Estudiant lae){
        codi=cod;
        nom=nombre;
        lista =lae;
    }
    
    //metodos 
    

    @Override
    public boolean compare(Object a){
        Asignatura asig= (Asignatura)a;
        if((this.codi==asig.getCodi())&&(this.nom.equals(asig.getNom()))){
            return true;
        }
        return false;
    }
    
    @Override
    public abstract String toString();
    
    @Override
    public String getNom() {
        return nom;
    }
    @Override
    public int getCodi(){
        return codi;
    }
    
    public  void setNom(String name){
        this.nom=name;
    }
    
    public  void setCodi(int cod){
        this.codi=cod;
    }
    
    
    public  Asignatura_Estudiant gelista(){
        return lista;
    }
    
   public boolean estupertenece(Estudiant x) {
        for(int i=0;i<lista.size();i++){
            if(lista.getInfo(i).compare(x)){
                return true;
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }
    
    public void addestu(Estudiant x) {
        this.lista.Add_Nodo(x); //To change body of generated methods, choose Tools | Templates.
    }
    
    public  Estudiant geteestu(int i){
        return this.lista.getInfo(i);
    }
    
    
}
