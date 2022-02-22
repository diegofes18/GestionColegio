/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas_ref;

import Asignatura.Asignatura;
import Curso.Curs;
import Estudiant.Estudiant;
import Interficies.Interficie_lista;

/**
 *
 * @author marcc
 */
public class Estudiant_Asignatura implements Interficie_lista{
    
    private Nodo primer;
    private Nodo buid;
    
    public  Estudiant_Asignatura() {
        primer =  null;
    }
   
    @Override
    public void addObject(Object a) {
        Nodo b =  new Nodo ((Asignatura)a, null );
        
        if (primer !=  null){
            Nodo i = primer;
            
            while (i.Get_Nodo() != null ){
                i = i.Get_Nodo();
            }
            i.Set_Nodo(b);
            
        } else {
            primer = b;
           
        }
    }


    @Override
    public int getlength() {
        Nodo aux = primer;
        int t = 0 ;
        if (aux !=null) {
            t ++ ;
         while (aux.Get_Nodo()!= null ) {
                t ++ ;
                aux = aux.Get_Nodo();
         }}
         return t;
    }

    @Override
    public void deleteObject(Object t) {
        if (primer != null) {
             
            if (primer.Get_Object().equals(t)) {
                Nodo removed = primer;
                
                if (primer.Get_Nodo() == null) {
                    primer = null;
                    removed.Set_Nodo(null);
                    
                    Nodo j = buid;
                    
                    if (j != null) {
                        
                        while (j.Get_Nodo() != null) {
                            j = j.Get_Nodo();
                        }
                        
                        j.Set_Nodo(removed);
                        
                    } else {
                        buid = removed;
                    }
                    
                } else {
                    primer = primer.Get_Nodo();
                    removed.Set_Nodo(null);
                    Nodo j = buid;
                    
                    if (j != null){
                        
                        while (j.Get_Nodo() != null) {
                            j = j.Get_Nodo();
                        }
                        j.Set_Nodo(removed);
                    } else {
                        buid = removed;
                    }
                }
                
            } else {
                boolean trobat = false;
                Nodo i = primer;
                
                while (!trobat && i.Get_Nodo() != null) {
                    
                    if (i.Get_Nodo().Get_Object().equals(t)) {
                        trobat = true;
                        
                    } else {
                        i = i.Get_Nodo();
                    }
                }
                
                Nodo removed = i.Get_Nodo();
                
                if (trobat) {
                    i.Set_Nodo(removed.Get_Nodo());
                    removed.Set_Nodo(null);
                    Nodo j = buid;
                    
                    if (j != null) {
                        
                        while (j.Get_Nodo() != null) {
                            j = j.Get_Nodo();
                        }
                        
                        j.Set_Nodo(removed);
                        
                    } else {
                        buid = removed;
                    }
                } else {
                    System.out.println("Element no trobat");
                }
            }
        } else {
            System.out.println("Llista buida\n");
        }
    }

    @Override
    public void ordena() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @Override
    public boolean pertenece(String d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInfoName(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object returnObject(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualiza(Object x, Object y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String Mostrar_Lista(){

        String s="";
        Nodo aux = primer;

        if (!aux.isEmpty()){
            s+=aux.Get_Object().toString()+"\n   ";

            while(aux.Get_Nodo() != null){
                aux = aux.Get_Nodo();
                s+=(aux.Get_Object()).toString()+"\n   ";
            }
        }
        else{
            return null;

    }
        return s;

    }
    
    public  Asignatura  getInfo ( int  i ) {
        Nodo aux = primer;
        int j = 0 ;
        if (aux != null) {

        while ( ! aux.isEmpty () && j < i) {
            j ++ ;
            if (aux.Get_Nodo() != null ){
                aux = aux.Get_Nodo ();
            }
        }
        return (Asignatura)aux.Get_Object();
          }
        else {
            return  null ;
        }

    }
    
}
