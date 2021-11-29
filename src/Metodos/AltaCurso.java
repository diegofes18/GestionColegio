/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Asignatura.Asignatura;
import Curso.Any;
import Curso.Batxiller;
import Curso.Curs;
import Curso.FP;
import Curso.Tipos;
import Listas.ListaAsignaturas;
import Listas.ListaCurso;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author berme
 */
public class AltaCurso extends JDialog implements ActionListener{
   
    private JComboBox combo,combo2;
    private JTextField num_asig,codi,nom;
    private JLabel l1,l2,l3,l4;
    private JPanel panel;
    private JTextArea asigtxt;
    private JScrollPane scroll;
    private Curs curs;
    private String nom1;
    private int codi1;
    private int n;
    private ListaAsignaturas listaasig;
    private ListaAsignaturas la;
    private JButton introasig,aceptar;
    private Any any;
    private Tipos tipofp;
    private ListaCurso l;
    
    public AltaCurso(ListaCurso lc,ListaAsignaturas la){
        l=lc;
        listaasig=new ListaAsignaturas();
        for(int i=0;i<listaasig.getlength();i++){
            
        }
        this.la=la;
        this.setModal(true);
        initcomponents();
        this.add(panel);
        this.add(combo);
        this.add(num_asig);
        this.add(codi);
        this.add(nom);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(combo2);
        this.add(introasig);
        this.setResizable(false);
        this.setSize(480,520);
        this.setTitle("Donar d'alta curs");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
    }
    private void initcomponents(){
        combo = new JComboBox();
        combo2=new JComboBox();
        num_asig = new JTextField();
        codi = new JTextField();
        nom = new JTextField();
        introasig=new JButton();
        aceptar=new JButton();
        panel=new JPanel();
        asigtxt=new JTextArea(10,15);
        scroll=new JScrollPane(asigtxt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        panel.add(scroll);
        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        getContentPane().setLayout(null);
        combo.addItem("Seleccione modadlidad");
	combo.addItem("Bachiller");
	combo.addItem("FP");
        l1.setText("Seleccione Modalidad");
        l2.setText("Numero de asignaturas");
        l3.setText("Introduce nombre del curs");
        l4.setText("Introduce el codigo del curs");
        introasig.setText("Introducir Asignaturas");
        aceptar.setText("ACEPTAR");
        getContentPane().add(combo);
        getContentPane().add(num_asig);
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(l3);
        getContentPane().add(l4);
        getContentPane().add(combo2);
        getContentPane().add(introasig);
        getContentPane().add(codi);
        getContentPane().add(nom);
        getContentPane().add(aceptar);
        l2.setBounds(10, 80, 200, 30);
        l1.setBounds(10, 20, 200, 30);
        num_asig.setBounds(250,80,200,30);
        combo.setBounds(250,20,200,30);
        l3.setBounds(10, 140, 200, 30);
        l4.setBounds(10, 200, 300, 30);
        nom.setBounds(250,140,200,30);
        codi.setBounds(250,200,200,30);
        combo2.setBounds(10,260,200,30);
        introasig.setBounds(10,330,200,30);
        aceptar.setBounds(85, 430, 300, 40);
        panel.setBounds(250, 240, 200, 200);
        num_asig.setText("0");
        
        combo.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) combo.getSelectedItem();//get the selected item
                
                switch (s) {//check for a match
                    case "Seleccione Modalidad":
                        break;
                    case "Bachiller":
                        combo2.removeAllItems();
                        combo2.addItem("Primero");
                        combo2.addItem("Segundo");
                        System.out.print("bachiller");
                        break;
                   
                    case "FP":
                        combo2.removeAllItems();
                        combo2.addItem("Electronica");
                        combo2.addItem("Mecanica");
                        combo2.addItem("Informatica");
                        System.out.print("FP");
                        break;
                
                }
            }
        });
        
         combo2.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) combo2.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Seleccione Modalidad":
                        break;
                    case "Primero":
                        any=Any.Primer;
                        break;
                    case "Segundo":
                        any=Any.Segon;
                        break;
                    case "Electronica":
                        tipofp=Tipos.electronica;
                        break;
                    case "Mecanica":
                        tipofp=Tipos.mecanica;
                        break;
                    case "Informatica":
                        tipofp=Tipos.informatica;
                        break;

                }
            }
        });
        introasig.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                n=validaInt(num_asig.getText());
                
               for(int i=0;i<n;i++){ 
                    VentanaAsignatura vasig=new VentanaAsignatura();
                    vasig.setVisible(true);
                    listaasig.addObject(vasig.getAsig());
                    la.addObject(vasig.getAsig());
                    asigtxt.setText(listaasig.toString());
                } 
            }
        });
         aceptar.addActionListener(new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {
                codi1=validaInt(codi.getText());
                nom1=nom.getText();
                switch((String) combo.getSelectedItem()){
                    case "Bachiller":
                        curs=new Batxiller(listaasig,codi1,nom1,any);
                        l.addObject(curs);

                        break;
                    case "FP":
                        curs=new FP(listaasig,codi1,nom1,tipofp);
                        l.addObject(curs);

                        break;
                }
                cerrarVentana();
                listaasig.ordena();
               
            }
        });
       
    }
    public Curs getCurs(){
        return curs;
    }
    public ListaCurso getlistacurs(){
        return l;
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
    
//    public static void main(String []args){
//        AltaCurso vent=new AltaCurso();
//        vent.setVisible(true);
//    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addAsignatura(Asignatura a){
        listaasig.addObject(a);
    }
    
    public ListaAsignaturas getLista(){
        return la;
    }
    
    private void cerrarVentana() {
        this.dispose();
    }
    

    
}
