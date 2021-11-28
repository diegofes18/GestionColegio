/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Asignatura.Asignatura;

import Estudiant.Estudiant;
import Listas.ListaCurso;
import Listas.ListaEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author berme
 */
public class MatricularEstudiante_1 extends JDialog implements ActionListener{
    
    private JTextField intr_dni, intr_nom, intr_asig;
    private JLabel l1,l2,l3;
    private String asig,nom,dni;
    private ListaEstudiante listaest;
    private JButton matricular;
    private ListaCurso listacurs;
    private Estudiant estu;
    private Asignatura asignatura;
    private boolean acepted ;
    
    public MatricularEstudiante_1(){
        
//        listaest=le;
//        listacurs=lc;
        acepted=false;
        this.setModal(true);
        initcomponents();
        this.add(intr_dni);
        this.add(intr_nom);
        this.add(intr_asig);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(matricular);
        this.setResizable(false);
        this.setSize(400,600);
        this.setTitle("Matricular un estudiant");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    private void initcomponents(){
        
        intr_nom=new JTextField();
        intr_dni=new JTextField();
        intr_asig=new JTextField();
        matricular=new JButton();
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        
        getContentPane().setLayout(null);
        
        l1.setText("Introduir Nom");
        l2.setText("Introduir DNI");
        l3.setText("Introduir Asignatura");
        matricular.setText("Matricular Estudiante");
        
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(l3);
        getContentPane().add(matricular);
        getContentPane().add(intr_dni);
        getContentPane().add(intr_nom);
        getContentPane().add(intr_asig);
        
        l1.setBounds(10, 20, 200, 30);
        l2.setBounds(10, 120, 200, 30);
        l3.setBounds(10, 220, 200, 30);
        matricular.setBounds(10,400,200,30);
        intr_nom.setBounds(160,20,200,30);
        intr_dni.setBounds(160,120,200,30);
        intr_asig.setBounds(160,220,200,30);
        matricular.addActionListener(this);
         
        
//        matricular.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                acepted=true;
//                dni = intr_dni.getText(); 
//                nom = intr_nom.getText(); 
//                asig = intr_asig.getText (); 
//                estu=new Estudiant(nom,dni);   
                
//                if (listaest.perteneceObj(estu)){
//                    
//                    System.out.print("ya existe");
//                    asignatura=listacurs.search(asig);
//                    estu=asignatura.getAsignatura_Estudiant().getEstudiant(estu.getDNI());
//                    estu.addasig(asignatura);
//                    asignatura.addestu(estu);
//                    listacurs.actualiza(asignatura,estu);
//                    estu.getEstudiant_Asignatura().Mostrar_Lista();
//                    
//                    
//                } else {
//                    //crear estudiante y añadir a la lista
//                    estu=new Estudiant(nom,dni);
//                    estu.setListaasig(new Estudiant_Asignatura());
//                    listaest.addestu(estu);
//                    //coger asignatura de lista curso
//                    asignatura=listacurs.search(asig);
//                    //añadir estudiante a asignatura
//                    asignatura.addestu(estu);
//                    //añadir asignatura a lista asignatura del estudiante
//                    estu.addasig(asignatura);
//                    //actualizar lista curso con la asignatura cambiada
//                    listacurs.actualiza(asignatura,estu);
                    
//              }
//                System.out.println(estu);
//                dispose();
//            }
//            
//        });
    }
    @Override
         public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              Object object = e.getSource();

              if (object.equals(matricular)) {
                asig = intr_asig.getText();
                dni = intr_dni.getText(); 
                nom = intr_nom.getText(); 
                estu=new Estudiant(nom,dni);
                acepted=true;
               }
              dispose();
   }
    
    //Getters
    public String getDNI(){
        return dni;
    }
    
    public String getStringasig(){
        
        return asig;
    }
    public Estudiant getestu(){
        return estu;
    }
            
    public Estudiant getEstu(){
        return estu;
    }
    public JButton getaceptar(){
        return matricular;
    }
    public boolean getAceptado(){
        return acepted;
    }
    public String getNom(){
        return nom;
    }
    public String getAsignatura(){
        return asig;
    }
    
    public void cerrarVentana() {
        this.dispose();
    }
    public ListaEstudiante getlistaestu(){
        return listaest;
    }
    public void MostrarMensaje(){
        JOptionPane.showMessageDialog(this, "Es necesario introducir datos en todos los campos");
    }
    
    
//        public static void main(String []args){
//        MatricularEstudiante_1 v=new MatricularEstudiante_1(); 
//        v.setVisible(true);
//        
//        
//    }
}
