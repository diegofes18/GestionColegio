/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Listas;

import Interficies.Interficie_lista;
import java.util.ArrayList;
import Asignatura.Asignatura;
import Curso.Curs;
import Estudiant.Estudiant;
import java.util.Collections;
import java.util.Comparator;
 

/**
 *
 * @author victo
 */
public class ListaAsignaturas implements Interficie_lista{
    
    
    private ArrayList<Asignatura> lista;
    
    public ListaAsignaturas(){
        lista = new ArrayList<Asignatura>();
    }

    @Override
    public int getlength() {
        return lista.size();
    }

    @Override
    public void deleteObject(Object t) {
          for (int i=0;i<lista.size();i++){
              if(lista.get(i).compare((Asignatura)t)){
                  lista.remove(i);
              }
          }
    }

    @Override
    public void ordena() {
       Collections.sort(lista, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                
                return ((Asignatura)a).getNom()
                        .compareTo(((Asignatura)b).getNom());
            }
        });
    }

    @Override
    public void addObject(Object a) {
        lista.add((Asignatura)a);
    }
    
    public String toString(){
        String s="";
        for(int i=0;i<lista.size();i++){
                s+=lista.get(i).toString()+"\n";
        }
        
        return s;
    }

    @Override
    public Asignatura search(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pertenece(String d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getInfoName(int i){
        String info;
        info=lista.get(i).getNom();
        return info;
    }

    public Asignatura getInfo(int i){
        return lista.get(i);
    }

    @Override
    public Object returnObject(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    @Override
    public void actualiza(Object x, Object y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curs returnCurs(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curs getCurs_Nom(String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Asignatura getAsig_Nom(String n){
        Asignatura c=null;
        for(int i =0;i<lista.size();i++){
            if(lista.get(i).getNom().equals(n)){
                c=lista.get(i);
            }
        }
        return c;
    }

   

    @Override
    public Estudiant getEstu_Nom(String n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
