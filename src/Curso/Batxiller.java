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
public class Batxiller extends Curs{
    
    private static Any year;
    
    public Batxiller(ListaAsignaturas l,int codi, String nom, Any a) {
        super(l,codi, nom);
        year = a;
    }

    public void setAny(Any c){
        Batxiller.year=c;
    }
    public Any getAny(){
        return Batxiller.year;
    }

    @Override
    public String toString() {
       return "codi: "+codi+" nom: "+nom+" any: "+year; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getCodi() {
        return codi;
    }
    
    public ListaAsignaturas getlista(){
        return asig;
    }
    
    @Override
    public void setNom(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodi(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Asignatura search(String d) {
        Asignatura as = null;
        for (int i=0;i<asig.getlength();i++){
            
            if(d.equals(asig.getInfoName(i))){
                as=asig.getInfo(i);
            }
            
        }
        return as;
    }

    @Override
    public String getNameAsignaturalist(int i) {
        return (String) asig.getInfoName(i);
    }

    @Override
    public boolean searchString(String d) {
        boolean find = false;
        
        for(int i=0;i<asig.getlength();i++){
            if(d.equals(asig.getInfoName(i))){
                find = true;
            }
        }
        
        return find;
    }

    @Override
    public Asignatura getAsignaturalist(int i) {
        return  asig.getInfo(i);
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
        asig.deleteObject(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addasig(Object x) {
        asig.addObject(x); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
