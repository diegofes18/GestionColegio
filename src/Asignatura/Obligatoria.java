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
    public String toString() {
        if(lista.size()==0){
            return ("ASIGNATURA OBLIGATORIA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Creditos "+ creditos+
                    "\n ESTUDIANTES:\n No hi ha estudiants matriculats\n");
        }else{
        return ("ASIGNATURA OBLIGATORIA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Creditos "+ creditos+"\n ESTUDIANTES:\n"
                +lista.Mostrar_Lista()+"\n");    
        }
    }

    
    @Override
    public boolean estupertenece(Estudiant x) {
        for(int i=0;i<lista.size();i++){
            if(lista.getInfo(i).compare(x)){
                return true;
            }
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }


}
