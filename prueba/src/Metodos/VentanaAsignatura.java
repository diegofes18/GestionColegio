/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Asignatura.Asignatura;
import Asignatura.Obligatoria;
import Asignatura.Optativa;
import Asignatura.Perfil;
import Listas.ListaAsignaturas;
import Listas_ref.Asignatura_Estudiant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author marcc
 */
public class VentanaAsignatura extends JDialog {
    
    private JComboBox combo,combo2;
    private JTextField nom,codi,credit;
    private JLabel etiqueta1,etiqueta2,etiqueta3;
    private Asignatura asig;
    private Perfil perfil;
    private JButton boton;
    
    private Asignatura_Estudiant ase;
    
    public VentanaAsignatura(){
        ase=new Asignatura_Estudiant();
        this.setModal(true);
        initcomponents();
        this.add(combo);
        this.add(combo2);
        this.add(nom);
        this.add(codi);
        this.add(credit);
        this.add(etiqueta1);
        this.add(etiqueta2);
        this.add(etiqueta3); 
        this.setResizable(false);
        this.setSize(400,300);
        this.setTitle("Donar d'alta assignatura");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    
    private void initcomponents(){
        
        combo = new JComboBox();
        getContentPane().setLayout(null);
	combo.addItem("Obligatoria");
	combo.addItem("Optativa");
        getContentPane().add(combo);
        combo.setBounds(10,20,200,30);
        
        combo2=new JComboBox();
        getContentPane().setLayout(null);
	combo2.addItem("Teoric");
	combo2.addItem("Practic");
        getContentPane().add(combo2);
        combo2.setBounds(10,165,200,30);
        combo2.setVisible(false);
        
        nom=new JTextField();
        nom.setBounds(150, 75, 200, 30);
        getContentPane().add(nom);
        etiqueta1=new JLabel();
        etiqueta1.setText("Nom asignatura");
        etiqueta1.setBounds(10, 75, 200, 30);
        getContentPane().add(etiqueta1);
        
        codi=new JTextField();
        codi.setBounds(150, 120, 200, 30);
        getContentPane().add(codi);
        etiqueta2=new JLabel();
        etiqueta2.setText("Codi asignatura");
        etiqueta2.setBounds(10, 120, 200, 30);
        getContentPane().add(etiqueta2);
        
        credit=new JTextField();
        credit.setBounds(150, 165, 200, 30);
        getContentPane().add(credit);
        etiqueta3=new JLabel();
        etiqueta3.setText("Credits assignatura");
        etiqueta3.setBounds(10, 165, 200, 30);
        getContentPane().add(etiqueta3);
        credit.setVisible(true);
        etiqueta3.setVisible(true);
        
        boton=new JButton("ACEPTAR");
        boton.setBounds(10,215,100,30);
        add(boton);
        
        combo.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) combo.getSelectedItem();//get the selected item

                switch (s) {
                    case "Optativa":
                        combo2.setVisible(true);
                        credit.setVisible(false);
                        etiqueta3.setVisible(false);
                        break;
                    case "Obligatoria":
                        credit.setVisible(true);
                        etiqueta3.setVisible(true);
                        combo2.setVisible(false);
                        break;

                }
            }

            
        });
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String s = (String) combo.getSelectedItem();
                switch (s) {
                    case "Optativa":
                            perfil = null;
                            if(combo2.getSelectedItem()=="Teoric"){
                                perfil=perfil.teoric;
                            }else if(combo2.getSelectedItem()=="Practic"){
                                perfil=perfil.practic;
                            }
                         
                        asig=new Optativa(perfil,validaInt(codi.getText()),ase,nom.getText());
                         
                         break;
                         
                    case "Obligatoria":
                        asig=new Obligatoria(validaInt(credit.getText()),validaInt(codi.getText()),ase,nom.getText());
                       
                        break;

                }

                cerrarVentana();
                
            }
        });
        
      
        
    
    } 
    
    
    public void setAsig(Asignatura a){
        asig =a;
    }
    public Asignatura getAsig(){
        return asig;
    }
    
    private void cerrarVentana() {
        this.dispose();
    }
    
    public int validaInt(String number){
        int result = 0; //Valor default.
        try{
            if(number != null){
                result = Integer.parseInt(number);
        }
        }catch(NumberFormatException nfe){
        //*No es numerico!
    }
        return result;
}

}
