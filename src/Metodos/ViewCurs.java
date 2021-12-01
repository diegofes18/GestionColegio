/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Curso.Curs;
import Listas.ListaCurso;
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
 * @author marcc
 */
public class ViewCurs extends JDialog{
    
    private ListaCurso listacurs;
    private JComboBox combo;
    private JButton accept;
    private Curs curso;
    private JLabel l1;
    
    public ViewCurs(ListaCurso lc){
        this.setModal(true);
        listacurs=lc;
        this.setResizable(false);
        this.setSize(400,340);
        this.setTitle("Visualizar Curso");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initcomponents();
        rellenarCombo(combo);
        this.add(combo);
        this.add(l1);
        this.add(accept);
    }
    
    private void initcomponents(){
        combo = new JComboBox();
        accept=new JButton();
        l1=new JLabel();
        getContentPane().setLayout(null);
        l1.setText("Seleccioni curs ");
        accept.setText("ACEPTAR");
        getContentPane().add(l1);
        getContentPane().add(accept);
        l1.setBounds(10, 20, 200, 30);
        combo.setBounds(220,20,200,30);
        accept.setBounds(100, 280, 300, 40);
        
        accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                   curso= listacurs.returnCurs(combo.getSelectedIndex());

                
            }
        });
    }
    
    public void rellenarCombo(JComboBox c){
            //variable para tomar el nombre
            String nombre;
            //se limpia el combo
            combo.removeAllItems();//limpia el combobox
            //try por si fallara al momento de rellenar
            try{
                //Se recorre con un for la lista
                for(int i = 0; i<listacurs.getlength(); i++){
                   
                    nombre = listacurs.returnCurs(i).getNom();
                    //Se arega un nuevo ítem al combobox
                    combo.addItem(nombre);
                }
            }catch(Exception e){ //capta el error y lo muestra
                JOptionPane.showMessageDialog(null,"Error al cargar ComboBox" + e);
            }
        }
    
    public Curs getCurs(){
        return curso;
    }
    
}