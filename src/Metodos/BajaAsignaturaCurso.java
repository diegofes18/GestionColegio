/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Curso.Curs;
import Listas.ListaAsignaturas;
import Listas.ListaCurso;
import Listas.ListaEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class BajaAsignaturaCurso extends JDialog implements ActionListener{

    private JComboBox combo,combo2;
    private JLabel l1,laasig;
    private JButton aceptar;
    private ListaCurso lc;
    private ListaAsignaturas la;
    private int numCursos;
    private int numasig;
    private ListaEstudiante le;
    
    public BajaAsignaturaCurso(ListaCurso listac,ListaAsignaturas la,ListaEstudiante le){
        this.lc=listac;
        this.numCursos=listac.getlength();
        this.la=la;
        this.numasig=la.getlength();
        this.le=le;
        initcomponents();
        rellenarCombo(combo);
        this.add(combo);
        this.add(combo2);
        this.add(l1);
        this.add(aceptar);
        this.setResizable(false);
        this.setSize(480,480);
        this.setTitle("Donar de baixa un curs");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setModal(true);
    }
    
    private void initcomponents(){
        combo = new JComboBox();
        combo2=new JComboBox();
        aceptar=new JButton();
        l1=new JLabel();
        laasig=new JLabel();
        getContentPane().setLayout(null);
        l1.setText("Seleccioni curs ");
        laasig.setText("Seleccioni asignatura ");
        aceptar.setText("ACEPTAR");
        getContentPane().add(l1);
        getContentPane().add(laasig);
        getContentPane().add(combo2);
        getContentPane().add(aceptar);
        l1.setBounds(10, 20, 200, 30);
        combo.setBounds(220,20,200,30);
        laasig.setBounds(10, 100, 200, 30);
        combo2.setBounds(220,100,200,30);
        aceptar.setBounds(100, 380, 300, 50);
        
        combo.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) combo.getSelectedItem();//get the selected item

                for(int i=0;i<lc.getlength();i++){
                    if(lc.returnCurs(i).getNom()==s){
                        rellenarCombo2(combo2,lc.returnCurs(i));
                    }
                }
            }

            
        });
      
        aceptar.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleted=combo2.getSelectedItem().toString();
                lc.deleteasig(la.getAsig_Nom(deleted));
                la.deleteObject(la.getAsig_Nom(deleted));
                for(int i=0;i<la.getAsig_Nom(deleted).getAsignatura_Estudiant().size();i++){
                    le.deleteObject(la.getAsig_Nom(deleted).geteestu(i));
                }
                System.out.println("ASIGNATURA DADA DE BAJA: "+deleted);
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
                //Se recorre con un for la lista
                for(int i = 0; i<numCursos; i++){
                   
                    nombre = lc.returnCurs(i).getNom();
                    //Se arega un nuevo ítem al combobox
                    combo.addItem(nombre);
                }
            }catch(Exception e){ //capta el error y lo muestra
                JOptionPane.showMessageDialog(null,"Error al cargar ComboBox" + e);
            }
        }
    
    public void rellenarCombo2(JComboBox c,Curs cu){
            //variable para tomar el nombre
            String nombre;
            //se limpia el combo
            combo2.removeAllItems();//limpia el combobox
            //try por si fallara al momento de rellenar
            try{
                //Se recorre con un for la lista
                for(int i = 0; i<cu.asigsize(); i++){
                   
                    nombre = cu.getNameAsignaturalist(i);
                    //Se arega un nuevo ítem al combobox
                    combo2.addItem(nombre);
                }
            }catch(Exception e){ //capta el error y lo muestra
                JOptionPane.showMessageDialog(null,"Error al cargar ComboBox" + e);
            }
        }
    
    

    
    public void MostrarMensaje(){
        JOptionPane.showMessageDialog(this, "No hay asignaturas dadas de alta");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}