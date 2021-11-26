/*
DIEGO BERMEJO CABAÑAS
MARC CAÑELLAS
VICTOR CANELO
 */
package practicaalg1;

import Asignatura.Asignatura;
import Estudiant.Estudiant;
import Listas.ListaAsignaturas;
import Listas.ListaCurso;
import Listas.ListaEstudiante;
import Listas_ref.Estudiant_Asignatura;
import Metodos.AltaCurso;
import Metodos.BajaAsignaturaCurso;
import Metodos.BajaCurso;
import Metodos.MatricularEstudiante_1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author berme
 */
public class PracticaAlg1 extends JFrame {

    private Container contenedor;
    ListaCurso listacurs;
    ListaEstudiante listaestudiant;
    ListaAsignaturas listaasig;

    public static void main(String[] args) {
        try { //Control de l'aspecte
            javax.swing.UIManager.setLookAndFeel(
                    javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No s'ha establert el look desitjat: " + e);
        }
        new PracticaAlg1().setVisible(true);

    }

    //constructor
    public PracticaAlg1() {
        setTitle("Gestion Colegio");
        listacurs = new ListaCurso();
        listaestudiant = new ListaEstudiante();
        listaasig = new ListaAsignaturas();
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(0, 0);
        setDefaultCloseOperation(PracticaAlg1.EXIT_ON_CLOSE);
        setSize(1600, 800);
        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        initcomponents();
    }

    private void initcomponents() {

        JPanel opciones = new JPanel();
        opciones.setLayout(new FlowLayout());
        JButton[] botones = new JButton[7];
        String[] titlebot = {"Donar de alta curs", "Matricular estudiant de asignatura",
            "Donar de baixa curs", "Donar de baixa asignatura", "Llista asignatures curs",
            "Llista de cursos de asignatura", "Llista asignatures de estudiant"};
        for (int i = 0; i < 7; i++) {
            botones[i] = new JButton(titlebot[i]);
            botones[i].setFont(new Font("arial", Font.BOLD, 15));
            botones[i].setForeground(Color.BLACK);
            botones[i].setBackground(Color.WHITE);
            opciones.add(botones[i]);
        }
        contenedor.add(opciones, BorderLayout.NORTH);
        JEditorPane viewer = new JEditorPane();
        viewer.setContentType("text/html");
        viewer.setEditable(false);
        viewer.setText(
"<p>&nbsp;</p>\n" +
"<h1 style=text-align: center; color: #3f7320;>PRACTICA 1:Gestion de Colegio</h1>\n" +
"\n" +
"\n" +
"<h3 style=text-align: center; color: #3f7320;>by Diego Bermejo, Marc Ca&ntilde;ellas y Victor Canelo</p>\n" +
"<h3 style=text-align: center; color: #3f7320;>😁</h3>\n" +
 "<p><br /><strong></strong></p>");
        
        JScrollPane scrollPane = new JScrollPane(viewer);
        scrollPane.setBounds(50, 50, 300, 300);
        contenedor.add(scrollPane, BorderLayout.CENTER);
       
        //acciones
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                AltaCurso altac = new AltaCurso(listacurs,listaasig);
                altac.setVisible(true);
                listacurs = altac.getlistacurs();
                listaasig=altac.getLista();
                listacurs.ordena();
                listaasig.ordena();
            }
        });

        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MatricularEstudiante_1 me = new MatricularEstudiante_1();
                me.setVisible(true);
                Asignatura asignatura;
                Estudiant estu;
                if (listaestudiant.perteneceObj(me.getestu())) {

                    System.out.print("ya existe");
                    asignatura = listacurs.search(me.getStringasig());
                    estu = asignatura.getAsignatura_Estudiant().getEstudiant(me.getestu().getDNI());
                    estu.addasig(asignatura);
                    asignatura.addestu(estu);
                    listacurs.actualiza(asignatura, estu);
                    listacurs.ordena();
                    estu.getEstudiant_Asignatura().Mostrar_Lista();

                } else {
                    //crear estudiante y añadir a la lista
                    estu = me.getestu();
                    estu.setListaasig(new Estudiant_Asignatura());
                    listaestudiant.addestu(estu);
                    //coger asignatura de lista curso
                    asignatura = listacurs.search(me.getStringasig());
                    //añadir estudiante a asignatura
                    asignatura.addestu(estu);
                    //añadir asignatura a lista asignatura del estudiante
                    estu.addasig(asignatura);
                    //actualizar lista curso con la asignatura cambiada
                    listacurs.actualiza(asignatura, estu);
                    listacurs.ordena();
                    listaestudiant.ordena();
                    System.out.println(me.getStringasig());
                    System.out.println(me.getEstu());
                    System.out.print(me.getestu().getEstudiant_Asignatura().Mostrar_Lista());
                }
            }

        });
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BajaCurso bc=new BajaCurso(listacurs,listacurs.getlength());
                if(listacurs.getlength()==0){
                    bc.setVisible(false);
                    bc.MostrarMensaje();
                }else{
                bc.setVisible(true);
                }   
            }
        });

        botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                BajaAsignaturaCurso bc=new BajaAsignaturaCurso(listacurs,listaasig);
                if(listaasig.getlength()==0){
                    bc.setVisible(false);
                    bc.MostrarMensaje();
                }else{
                bc.setVisible(true);
                }
            }
        });

        botones[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  viewer.setText(listaasig.toString());
            }
        });

        botones[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewer.setText(listaestudiant.toString());
            }
        });

        botones[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewer.setText(listacurs.toString());
            
            }
        });

    }
}
