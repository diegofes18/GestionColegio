
package Asignatura;

import Estudiant.Estudiant;
import Listas_ref.Asignatura_Estudiant;

/**
 *
 * @author berme
 */
public class Optativa extends Asignatura {
    
    Perfil p;

    public Optativa(Perfil tipus,int cod, Asignatura_Estudiant ae,String nombre) {
        super(cod, nombre,ae);
        this.p=tipus;
    }
    
     @Override
    public String getNom() {
        return nom; 
    }
    

    @Override
    public int getCodi() {
        return codi; 
    }

    @Override
    public void setNom(String name) {
        nom=name; 
    }

    @Override
    public void setCodi(int codigo) {
        codi=codigo; 
    }


    @Override
    public String toString() {
        if(listaalumn.getlength()==0){
            return ("Asignatura Optativa\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Perfil "+ p+
                    "\nESTUDIANTS:\n   No hi ha estudiants matriculats\n");
        }else{
        return ("Asignatura Optativa\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Perfil "+ p+
                "\nESTUDIANTS:\n   "+listaalumn.Mostrar_Lista()+"\n"); 
             }
    }
    
    public String toString2() {
        if(listaalumn.getlength()==0){
            return ("Asignatura Optativa\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Perfil "+ p+"\n");
        }else{
        return ("Asignatura Optativa\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Perfil "+ p+"\n"); 
             }
    }
    
    @Override
    public Asignatura_Estudiant getAsignatura_Estudiant() {
        return listaalumn;
    }

    @Override
    public boolean estupertenece(Estudiant x) {
        for(int i=0;i<listaalumn.getlength();i++){
            if(listaalumn.getInfo(i).compare(x)){
                return true;
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addestu(Estudiant x) {
        boolean s=false;
        for(int i=0;i<listaalumn.getlength();i++){
            if(x.compare1(listaalumn.getInfo(i))){
                s=true;
            }
        }
        if(!s){
        this.listaalumn.addObject(x); 
        }
    }
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
    public  Estudiant geteestu(int i){
        return this.listaalumn.getInfo(i);
    }
    
}
