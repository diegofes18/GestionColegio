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
        if(listaalumn.size()==0){
            return ("ASIGNATURA OBLIGATORIA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Creditos "+ creditos+
                    "\n ESTUDIANTES:\n No hi ha estudiants matriculats\n");
        }else{
        return ("ASIGNATURA OBLIGATORIA\n"
                +"Nombre: "+ nom + ", Codigo: "+ codi + ", Creditos "+ creditos+"\n ESTUDIANTES:\n"
                +listaalumn.Mostrar_Lista()+"\n");    
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
        this.listaalumn.Add_Nodo(x); //To change body of generated methods, choose Tools | Templates.
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
    
}
