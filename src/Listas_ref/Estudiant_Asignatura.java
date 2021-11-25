/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas_ref;

import Asignatura.Asignatura;

/**
 *
 * @author marcc
 */
public class Estudiant_Asignatura {
    
    private Nodo primer;
    private Nodo buid;
    
    public  Estudiant_Asignatura() {
        primer =  null;
    }
    
    public  void  Add_Nodo(Asignatura  x){
        
        Nodo a =  new Nodo (x, null );
        
        if (primer !=  null){
            Nodo i = primer;
            
            while (i.Get_Nodo() != null ){
                i = i.Get_Nodo();
            }
            i.Set_Nodo(a);
            
        } else {
            primer = a;
           
        }
    }
    
    public void Mostrar_Lista(){
        
        Nodo aux = primer;
        
        if (!aux.isEmpty()){
            System.out.println(aux.Get_Object().toString());
            
            while(aux.Get_Nodo() != null){
                aux = aux.Get_Nodo();
                System.out.println(aux.Get_Object().toString());
                
            }
        }
        else
        System.out.println("Llista buida");
        
    }
    
    public void Remove(Object o) {
        
         if (primer != null) {
             
            if (primer.Get_Object().equals(o)) {
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
                    
                    if (i.Get_Nodo().Get_Object().equals(o)) {
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
    
}
