/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiant;

import Asignatura.Asignatura;
import Interficies.Interficie_Data;
import Listas_ref.Estudiant_Asignatura;

/**
 *
 * @author marcc
 */
public class Estudiant implements Interficie_Data{
    
    private String DNI;
    private String nom; 
    private Estudiant_Asignatura listaasig;
    //Referencia assignatura/estudiant
    
    public Estudiant (String n, String dni){
       nom=n;
       DNI=dni;
        
        //Referencia assignatura/estudiant
    }
    @Override
    public void setNom(String name) {
        nom=name; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getNom(){
        return nom;
    }
    @Override
    public String toString(){
        return ("   Nom: "+this.nom+", DNI: "+this.DNI);
    }
    
    public String getDNI(){
        return DNI;
    }
    
    public Estudiant_Asignatura getEstudiant_Asignatura(){
        return listaasig;
    }
    
    public boolean compare1(Estudiant t){
        
        return (this.nom.equals(t.getNom()));
    }

    public void setListaasig(Estudiant_Asignatura listaasig) {
        this.listaasig = listaasig;
    }
    public void addasig(Asignatura x){
        this.listaasig.addObject(x);
    }

    @Override
    public int getCodi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setCodi(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean compare(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
