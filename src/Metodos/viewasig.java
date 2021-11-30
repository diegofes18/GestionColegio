
package Metodos;

import Asignatura.Asignatura;

import Curso.Curs;
import Listas.ListaAsignaturas;
import Listas.ListaCurso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;


public class viewasig extends JDialog{
    
    private JComboBox combo,combo2;
    private Curs curso;
    private ListaCurso listacurs;
    private JButton boton;
    private ListaAsignaturas listaasig;
    private Asignatura asig;
    
    public viewasig(ListaCurso lc,ListaAsignaturas la){
        this.listacurs=lc;
        this.listaasig=la;
       
        combo = new JComboBox();
        getContentPane().setLayout(null);
	for(int i=0;i<lc.getlength();i++){
            combo.addItem(lc.returnCurs(i).getNom());
        }
        getContentPane().add(combo);
        combo.setBounds(10,20,200,30);
        
        combo2=new JComboBox();
        getContentPane().setLayout(null);
        getContentPane().add(combo2);
        combo2.setBounds(10,165,200,30);
        combo2.setVisible(true);
        
        boton=new JButton("ACEPTAR");
        boton.setBounds(10,215,100,30);
        add(boton);
        this.setModal(true);
        this.add(combo);
        this.add(combo2);
        this.setResizable(false);
        this.setSize(400,300);
        this.setTitle("Visualizar Asignatura");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        combo.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) combo.getSelectedItem();//get the selected item
                for(int i=0;i<listacurs.getCurs_Nom(s).getlista().getlength();i++){
                    combo2.addItem(listacurs.getCurs_Nom(s).getAsignaturalist(i).getName());
                }
                
            }
        });
        
         boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int i = combo2.getSelectedIndex();
                asig=listaasig.getInfo(i);
                dispose();
            }
        });
         
         
    }
   public Asignatura getAsig(){
       return asig;
   } 
}
