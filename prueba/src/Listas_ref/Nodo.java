/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listas_ref;

import Interficies.Interficie_Data;

/**
 *
 * @author marcc
 */
public class Nodo implements Interficie_Data{
    
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

    @Override
    public boolean compare(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCodi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNom(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodi(int cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
