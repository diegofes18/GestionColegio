/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estudiant;

import Asignatura.Asignatura;
import Listas_ref.Estudiant_Asignatura;

/**
 *
 * @author marcc
 */
public class Estudiant {
    
    private String DNI;
    private String nom; 
    private Estudiant_Asignatura listaasig;
    //Referencia assignatura/estudiant
    
    public Estudiant (String n, String dni){
       nom=n;
       DNI=dni;
        
        //Referencia assignatura/estudiant
    }
    
    public String getNom(){
        return nom;
    }
    
    public String getDNI(){
        return DNI;
    }
    
    public Estudiant_Asignatura getEstudiant_Asignatura(){
        return listaasig;
    }
    
    public String toString(){
        return ("Nom: "+this.nom+", DNI: "+this.DNI);
    }
    public boolean compare(Estudiant t){
        return (this.nom==t.getNom())&&(this.DNI==t.getDNI());
    }

    public void setListaasig(Estudiant_Asignatura listaasig) {
        this.listaasig = listaasig;
    }
    public void addasig(Asignatura x){
        this.listaasig.Add_Nodo(x);
    }
    
}
