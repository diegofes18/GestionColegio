
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
        return nom; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodi() {
        return codi; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNom(String name) {
        nom=name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodi(int codigo) {
        codi=codigo; //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String toString() {
        if(listaalumn.size()==0){
            return ("ASIGNATURA OPTATIVA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Perfil "+ p+
                    "\n ESTUDIANTES:\n No hi ha estudiants matriculats\n");
        }else{
        return ("ASIGNATURA OPTATIVA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Perfil "+ p+
                "\n ESTUDIANTES:\n"+listaalumn.Mostrar_Lista()+"\n"); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    @Override
    public Asignatura_Estudiant getAsignatura_Estudiant() {
        return listaalumn;
    }

    @Override
    public boolean estupertenece(Estudiant x) {
        for(int i=0;i<listaalumn.size();i++){
            if(listaalumn.getInfo(i).compare(x)){
                return true;
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addestu(Estudiant x) {
        listaalumn.Add_Nodo(x); //To change body of generated methods, choose Tools | Templates.
    }
    
}
