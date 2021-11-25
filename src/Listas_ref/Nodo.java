/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas_ref;

/**
 *
 * @author marcc
 */
public class Nodo {
    
    private Object obj;
    private Nodo seg;
    
    public Nodo(Object o,Nodo n) {
        obj = o;
        seg = n;
    }
    
    public Nodo Get_Nodo() {
        return seg;
    }
    
    public void Set_Nodo(Nodo n) {
        seg = n;
    }
    
    public Object Get_Object() {
        return obj;
    }
    
    public void Set_Object(Object o) {
        obj = o;
    }
    
    public boolean isEmpty() {
        return obj == null;
    }
}
