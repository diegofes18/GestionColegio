/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Asignatura.Asignatura;
import Estudiant.Estudiant;
import Listas.ListaAsignaturas;
import Listas.ListaCurso;
import Listas.ListaEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author berme
 */
public class BajaCurso extends JDialog implements ActionListener{

    private JComboBox combo;
    private JLabel l1;
    private JButton aceptar;
    private ListaCurso lc;
    private ListaAsignaturas la;
    private ListaEstudiante le;
    private int numCursos;
    
    
    
    public BajaCurso(ListaCurso listac,int i,ListaAsignaturas listaasig,ListaEstudiante listaestu){
        this.lc=listac;
        this.la=listaasig;
        this.le=listaestu;
        this.numCursos=i;
        initcomponents();
        rellenarCombo(combo);
        this.add(combo);
        this.add(l1);
        this.add(aceptar);
        this.setResizable(false);
        this.setSize(480,400);
        this.setTitle("Donar de baixa un curs");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setModal(true);
    }
    
    private void initcomponents(){
        combo = new JComboBox();
        aceptar=new JButton();
        l1=new JLabel();
        getContentPane().setLayout(null);
        l1.setText("Seleccioni curs ");
        aceptar.setText("ACEPTAR");
        getContentPane().add(l1);
        getContentPane().add(aceptar);
        l1.setBounds(10, 20, 200, 30);
        combo.setBounds(220,20,200,30);
        aceptar.setBounds(100, 280, 300, 40);
      
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleted=combo.getSelectedItem().toString();
                
                for(int i=0;i<lc.getCurs_Nom(deleted).getlista().getlength();i++){
                    Asignatura asig=lc.getCurs_Nom(deleted).getAsignaturalist(i);
                    la.deleteObject(asig);
                    
                    for(int j=0;j<le.getlength();j++){
                        Estudiant est=le.getEstu(j);
                        for(int z=0;z<est.getEstudiant_Asignatura().getlength();z++){
                            if(est.getEstudiant_Asignatura().getInfo(z).compare(asig)){
                                est.getEstudiant_Asignatura().deleteObject(asig);
                            }
                        }
                }
                   
                }
                for(int j=0;j<le.getlength();j++){
                    if(le.getEstu(j).getEstudiant_Asignatura().getlength()==0){
                        Estudiant estudiante=le.getEstu(j);
                        le.deleteObject(estudiante);
                    }
                }
                
                lc.deleteObject(lc.getCurs_Nom(deleted));
                cerrarVentana();
               
            }
        });
    }
    
    private void cerrarVentana() {
        this.dispose();
    }
    
    public void rellenarCombo(JComboBox c){
            //variable para tomar el nombre
            String nombre;
            //se limpia el combo
            combo.removeAllItems();//limpia el combobox
            //try por si fallara al momento de rellenar
            try{
                //Se recorre con un for la lista de conductores
                for(int i = 0; i<numCursos; i++){
                    nombre = lc.returnCurs(i).getNom();
                    //Se arega un nuevo ítem al combobox
                    combo.addItem(nombre);
                }
            }catch(Exception e){ //capta el error y lo muestra
                JOptionPane.showMessageDialog(null,"Error al carregar ComboBox" + e);
            }
        }
    
    public void MostrarMensaje(){
        JOptionPane.showMessageDialog(this, "No hi ha cursos donats d'alta");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ListaEstudiante getLest(){
        return le;
    }
    
    public ListaAsignaturas getLasig(){
        return la;
    }
    
    public ListaCurso getLCurso(){
        return lc;
    }
}