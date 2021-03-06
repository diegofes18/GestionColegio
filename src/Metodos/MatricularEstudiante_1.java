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
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    
    private JTextField intr_dni, intr_nom;
    private JLabel l1,l2,l3;
    private String asig,nom,dni;
    private ListaEstudiante listaest;
    private JButton matricular;
    private Estudiant estu;
    private ListaAsignaturas listaasig;
    private boolean acepted ;
    private JComboBox combo;
    private int numasig;
    
    public MatricularEstudiante_1(ListaAsignaturas la, int i){
        
//        listaest=le;
//        listacurs=lc;
        acepted=false;
        listaasig=la;
        numasig=i;
        this.setModal(true);
        initcomponents();
        rellenarCombo(combo);
        this.add(combo);
        this.add(intr_dni);
        this.add(intr_nom);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(matricular);
        this.setResizable(false);
        this.setSize(400,340);
        this.setTitle("Matricular un estudiant");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    private void initcomponents(){
        combo=new JComboBox();
        intr_nom=new JTextField();
        intr_dni=new JTextField();
        matricular=new JButton();
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        
        getContentPane().setLayout(null);
        
        l1.setText("Introduir Nom");
        l2.setText("Introduir DNI");
        l3.setText("Seleccionar Asignatura");
        matricular.setText("Matricular Estudiante");
        
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(l3);
        getContentPane().add(matricular);
        getContentPane().add(intr_dni);
        getContentPane().add(intr_nom);
        getContentPane().add(combo);
        
        l1.setBounds(10, 20, 200, 30);
        l2.setBounds(10, 80, 200, 30);
        l3.setBounds(10, 140, 200, 30);
        matricular.setBounds(85,220,200,40);
        intr_nom.setBounds(160,20,200,30);
        intr_dni.setBounds(160,80,200,30);
        combo.setBounds(160, 140, 200, 30);
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
//                    //crear estudiante y a??adir a la lista
//                    estu=new Estudiant(nom,dni);
//                    estu.setListaasig(new Estudiant_Asignatura());
//                    listaest.addestu(estu);
//                    //coger asignatura de lista curso
//                    asignatura=listacurs.search(asig);
//                    //a??adir estudiante a asignatura
//                    asignatura.addestu(estu);
//                    //a??adir asignatura a lista asignatura del estudiante
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
                dni = intr_dni.getText(); 
                nom = intr_nom.getText(); 
                estu=new Estudiant(nom,dni);
                asig=(String) combo.getSelectedItem();
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
    
    
    public void rellenarCombo(JComboBox c){
            //variable para tomar el nombre
            String nombre;
            //se limpia el combo
            combo.removeAllItems();//limpia el combobox
            //try por si fallara al momento de rellenar
            try{
                //Se recorre con un for la lista de conductores
                for(int i = 0; i<numasig; i++){
                    nombre = listaasig.getInfoName(i);
                    //Se arega un nuevo ??tem al combobox
                    combo.addItem(nombre);
                }
            }catch(Exception e){ //capta el error y lo muestra
                JOptionPane.showMessageDialog(null,"Error al cargar ComboBox" + e);
            }
        }
}
