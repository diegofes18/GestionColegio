/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Asignatura;

import Estudiant.Estudiant;
import Listas_ref.Asignatura_Estudiant;

/**
 *
 * @author berme
 */
public class Obligatoria extends Asignatura{
    
    int creditos;

    public Obligatoria(int c,int cod,Asignatura_Estudiant ae ,String nombre) {
        super(cod, nombre,ae);
        this.creditos=c;
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
        return ("ASIGNATURA OBLIGATORIA\n"
                +"Nombre: "+ name + ", Codigo: "+ codigo + ", Creditos "+ creditos);    }

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
        this.listaalumn.Add_Nodo(x); //To change body of generated methods, choose Tools | Templates.
    }
    
}