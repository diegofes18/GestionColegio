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
    public  boolean compare(Object x){
        Asignatura asig=(Asignatura)x;
        if(this.nom==asig.getNom()){
            return true;
        }else{
            return false;
        }
    }
  
    @Override
    public String toString() {
        if(listaalumn.getlength()==0){
            return ("Asignatura Obligatoria\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Credits "+ creditos+
                    "\nESTUDIANTS:\n   No hi ha estudiants matriculats\n");
        }else{
        return ("Asignatura Obligatoria\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Credits "+ creditos+"\nESTUDIANTS:\n   "
                +listaalumn.Mostrar_Lista()+"\n");    
        }
    }
    
    public String toString2() {
        if(listaalumn.getlength()==0){
            return ("Asignatura Obligatoria\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Credits "+ creditos+"\n");
        }else{
        return ("Asignatura Obligatoria\n"
                +"   Nom: "+ nom + ", Codi: "+ codi + ", Credits "+ creditos+"\n");    
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
        return false;
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
    public  Estudiant geteestu(int i){
        return this.listaalumn.getInfo(i);
    }

   
    
}
