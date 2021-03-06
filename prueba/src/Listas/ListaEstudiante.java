

package Listas;

import Interficies.Interficie_lista;
import Asignatura.Asignatura;
import Curso.Curs;
import Estudiant.Estudiant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class ListaEstudiante implements Interficie_lista {
    
    private ArrayList<Estudiant> lista; 
    
    public ListaEstudiante(){
        lista=new ArrayList<Estudiant>();
    }

    @Override
    public int getlength() {
        return lista.size();
    }

    @Override
    public void deleteObject(Object t) {
         for(int i=0;i<lista.size();i++){
             if(lista.get(i).compare1((Estudiant)t)){
                 lista.remove(i);
             }
         }
    }

    @Override
    public void ordena() {
       Collections.sort(lista, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                
                return ((Estudiant)a).getNom()
                        .compareTo(((Estudiant)b).getNom());
            }
        });
    }

    @Override
    public void addObject(Object a) {
        lista.add((Estudiant)a);
    }

   

    @Override
    public String getInfoName(int i) {
        String info;
        info=lista.get(i).getNom();
        return info;
    }

    
     public String toString(){
        String s="";
        for(int i=0;i<lista.size();i++){
                s+=lista.get(i).toString()+"\n";
        }
        
        return s;
    }

    public boolean perteneceObj(Estudiant x) {
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).compare1(x)){
                return true;
            }
        } 
        return false;
    }
    public void addestu(Estudiant x){
        
          lista.add(x);
        
    }
    
    public Estudiant getEstu_Nom(String n){
        Estudiant e=null;
        for(int i =0;i<lista.size();i++){
            if(lista.get(i).getNom().equals(n)){
                e=lista.get(i);
            }
        }
        return e;
    }
    public Estudiant getEstu(int i){
        return lista.get(i);
    }
    @Override
    public Object returnObject(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    @Override
    public boolean pertenece(String d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

    @Override
    public void actualiza(Object x, Object y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setLista(ArrayList<Estudiant> x){
        this.lista=x;
    }
    
}
