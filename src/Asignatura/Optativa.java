
package Asignatura;

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
    public String toString() {
        if(lista.size()==0){
            return ("ASIGNATURA OPTATIVA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Perfil "+ p+
                    "\n ESTUDIANTES:\n No hi ha estudiants matriculats\n");
        }else{
        return ("ASIGNATURA OPTATIVA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Perfil "+ p+
                "\n ESTUDIANTES:\n"+lista.Mostrar_Lista()+"\n"); //To change body of generated methods, choose Tools | Templates.
    }
    }
  

   
    
}
