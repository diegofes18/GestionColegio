/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Curso;

import Asignatura.Asignatura;
import Listas.ListaAsignaturas;

/**
 *
 * @author victo
 */
public class  FP extends Curs {

    private static Tipos tipos;
        
    public FP(ListaAsignaturas l,int codi, String nom, Tipos t) {
        super(l,codi,nom);
        FP.tipos=t;
    }
    
    
    
    public void setTipo(Tipos a){
        FP.tipos=a;
    }
    
    public Tipos getTipo(){
        return FP.tipos;
    }

    @Override
    public String toString() {
        return "Codi: "+codi+" Nom: "+nom+" Tipus: "+tipos.toString(); 
    }

    @Override
    public  String getNom(){
        return nom;
    }
    
    @Override
    public  int getCodi(){
        return codi;
    }
    
    @Override
    public void setNom(String name){
        this.nom=name;
    }
    @Override
    public void setCodi(int cod){
        this.codi=cod;
    }

    @Override
    public boolean searchString(String a) {
        boolean find = false;
        
        for(int i=0;i<asig.getlength();i++){
            if(a.equals(asig.getInfoName(i))){
                find = true;
            }
        }
        
        return find;
    }

    @Override
    public String getNameAsignaturalist(int i) {
        return (String) asig.getInfoName(i);
    }

    @Override
    public Asignatura search(String d) {
        Asignatura as = null;
        for (int i=0;i<asig.getlength();i++){
            
            if(d.equals(asig.getInfoName(i))){
                return asig.getInfo(i);
            }
            
        }
        return as;
    }

    @Override
    public Asignatura getAsignaturalist(int i) {
        return (Asignatura) asig.getInfo(i);
    }

    @Override
    public boolean pertenece(Object x) {
        for (int i=0;i<asig.getlength();i++){
            if(asig.getInfo(i).compare((Asignatura)x)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int asigsize() {
        return asig.getlength(); 
        
    }

    @Override
    public void removeasig(Object x) {
        asig.deleteObject(x);
    }

    @Override
    public void addasig(Object x) {
        asig.addObject(x); 
    }

    @Override
    public ListaAsignaturas getlista(){
        return asig;
    }
    @Override
    public boolean compare(Object x) {
        Curs curs=(Curs) x;
        if(this.nom==curs.getNom()){
            return true;
        }else{
            return false;
        }
        
    }
    

    

    

    


    
}
