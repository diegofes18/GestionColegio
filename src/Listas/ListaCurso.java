

package Listas;

import Asignatura.Asignatura;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Curso.Curs;
import Estudiant.Estudiant;
/**
 *
 * @author marcc
 */
public class ListaCurso implements Interficie_lista{

    private ArrayList<Curs> lista;

    public ListaCurso(){
        lista = new ArrayList<Curs>();
    }

    @Override
    public int getlength() {
        return lista.size();
    }

    @Override
    public void deleteObject(Object t) {
          for (int i=0;i<lista.size();i++){
              if(lista.get(i).compare((Curs)t)){
                  lista.remove(i);
              }
          }
    }

    @Override
    public void ordena() {
       Collections.sort(lista, new Comparator() {
            @Override
            public int compare(Object a, Object b) {

                return ((Curs)a).getNom()
                        .compareTo(((Curs)b).getNom());
            }
        });
    }

    @Override
    public void addObject(Object a) {
        lista.add((Curs)a);
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
        Asignatura as=null;
        
        for (int i=0;i<lista.size();i++){
            
            if(lista.get(i).searchString(a)){
                
                as=lista.get(i).search(a);
            }
            
        }
        return as;
    }
    
    public boolean pertenece(String d){
        boolean find =false;
        for (int i=0;i<lista.size();i++){
            
            if(lista.get(i).searchString(d)){
                find=true;
            }
            
        }
        return find;
    }

    @Override
    public String getInfoName(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object returnObject(Asignatura x){
        for(int i=0;i<lista.size();i++){
             if(lista.get(i).pertenece(x)){
                 return lista.get(i);
            }
        }
        return null;
    }

//    @Override
//    public boolean existObject(Object x) {
//        for(int i=0;i<lista.size();i++){
//             for(int j=0;j<lista.get(i).asigsize();j++){
//                 if(lista.get(i).getAsignaturalist(j).estupertenece((Estudiant)x)){
//                     return true;
//                 }
//             }
//        }
//        return false;
//    }

    @Override
    public Object returnObject(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualiza(Object x,Object y) {
        Asignatura a=(Asignatura) x;
         for(int i=0;i<lista.size();i++){
             for(int j=0;j<lista.get(i).asigsize();j++){
                 if(lista.get(i).getAsignaturalist(j).getName().equals(a.getName())){
                     lista.get(i).getAsignaturalist(j).addestu((Estudiant)y);
                 }
             }
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
