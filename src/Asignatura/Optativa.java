
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
    public boolean compare(Asignatura a){
        if((this.codigo==a.getCodigo())&&(this.name.equals(a.getName()))){
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public int getCodigo() {
        return super.codigo;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return ("ASIGNATURA OPTATIVA\n"
                +"Nombre: "+ name + ", Codigo: "+ codigo + ", Perfil "+ p); //To change body of generated methods, choose Tools | Templates.
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
