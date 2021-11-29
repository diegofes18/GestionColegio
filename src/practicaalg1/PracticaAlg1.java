/*
DIEGO BERMEJO CABAÑAS
MARC CAÑELLAS
VICTOR CANELO
 */
package practicaalg1;

import Asignatura.Asignatura;
import Curso.Curs;
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
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author berme
 */
public class PracticaAlg1 extends JFrame {

    private Container contenedor;
    ListaCurso listacurs;
    ListaEstudiante listaestudiant;
    ListaAsignaturas listaasig;
    private JPanel panel;
    private JComboBox combocurs;
    private JLabel etiquetacurs;
    private JTextArea mostrallista;
    private BajaCurso bc;
    private AltaCurso ac;
    private MatricularEstudiante_1 me;
    private BajaAsignaturaCurso bae;
    private JScrollPane scrollPane;

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
        combocurs = new JComboBox();
        etiquetacurs = new JLabel("Seleccione un curso");
        mostrallista = new JTextArea(30,25);
        mostrallista.setVisible(false);
        combocurs.setVisible(false);
        etiquetacurs.setVisible(false);
        panel=new JPanel();
        listaestudiant = new ListaEstudiante();
        listaasig = new ListaAsignaturas();
        scrollPane = new JScrollPane(mostrallista,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVisible(false);
        panel.add(scrollPane);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation(0, 0);
        this.add(combocurs);
        this.add(etiquetacurs);
        
        this.add(panel);
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
        
        combocurs.setBounds(250, 100, 250, 30);
        etiquetacurs.setBounds(75, 100, 250, 30);
        
        panel.setBounds(1050,100,800,800);
        contenedor.add(opciones, BorderLayout.NORTH);
        JEditorPane viewer = new JEditorPane();
        viewer.setContentType("text/html");
        viewer.setEditable(false);
        viewer.setText(
                "<p>&nbsp;</p>\n"
                + "<h1 style=text-align: center; color: #3f7320;>PRACTICA 1: Gestion de Colegio</h1>\n"
                + "\n"
                + "\n"
                + "<h3 style=text-align: center; color: #3f7320;>by Diego Bermejo, Marc Ca&ntilde;ellas y Victor Canelo</p>\n"
                + "<h3 style=text-align: center; color: #3f7320;>😁</h3>\n"
                + "<p><br /><strong></strong></p>");
        //acciones
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scrollPane.setVisible(false);
                ac = new AltaCurso(listacurs, listaasig);
                ac.setLocationRelativeTo(PracticaAlg1.this);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                ac.setVisible(true);
                listacurs = ac.getlistacurs();
                listaasig = ac.getLista();
                listacurs.ordena();
                listaasig.ordena();
            }
        });

        botones[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                me = new MatricularEstudiante_1(listaasig, listaasig.getlength());
                scrollPane.setVisible(false);
                me.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                me.setVisible(true);
                Asignatura asignatura;
                Estudiant estu;

                if (listaestudiant.perteneceObj(me.getestu())) {
                    asignatura = listacurs.search(me.getStringasig());
                    estu = asignatura.getAsignatura_Estudiant().getEstudiant(me.getestu().getDNI());
                    estu.addasig(asignatura);
                    asignatura.addestu(estu);
                    listacurs.actualiza(asignatura, estu);
                    listacurs.ordena();
                    estu.getEstudiant_Asignatura().Mostrar_Lista();

                } else {
                    if (listaasig.getlength() != 0) {
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
            }

        });
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scrollPane.setVisible(false);
                bc = new BajaCurso(listacurs, listacurs.getlength());
                bc.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                if (listacurs.getlength() == 0) {
                    bc.setVisible(false);
                    bc.MostrarMensaje();
                } else {
                    bc.setVisible(true);
                }
            }
        });

        botones[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                scrollPane.setVisible(false);
                bae = new BajaAsignaturaCurso(listacurs, listaasig, listaestudiant);
                bae.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                if (listaasig.getlength() == 0) {
                    bae.setVisible(false);
                    bae.MostrarMensaje();
                } else {
                    bae.setVisible(true);
                }
            }
        });

        botones[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (listacurs.getlength() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay ningun curso dado de alta");
                } else {
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listacurs.getlength(); i++) {
                        name = listacurs.returnCurs(i).getNom();
                        combocurs.addItem(name);
                    }
                    etiquetacurs.setVisible(true);
                    Curs c = listacurs.returnCurs(combocurs.getSelectedIndex());
                    mostrallista.setVisible(true);
                    mostrallista.setText(c.getlista().toString());

                }
            }
        });

        botones[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (listaasig.getlength() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay ninguna asignatura dada de alta");
                } else {
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listaasig.getlength(); i++) {
                        name = listaasig.getInfoName(i);
                        combocurs.addItem(name);
                    }
                    etiquetacurs.setVisible(true);
                    Asignatura a = listaasig.getAsig_Nom((String)combocurs.getSelectedItem());
                    mostrallista.setVisible(true);
                    Curs c=(Curs)listacurs.returnObject(a);
                    if(a.getAsignatura_Estudiant().size()==0){
                        mostrallista.setText("CURSO:\n"+c.toString()+"\n ESTUDIANTES:\n No hay estudiantes matriculados\n");
                    }else{
                    mostrallista.setText("CURSO:\n"+c.toString()+"\n ESTUDIANTES:\n"+a.getAsignatura_Estudiant().Mostrar_Lista()+"\n");

                }
                }
            }
        });

        botones[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (listaestudiant.getlength() == 0) {
                    JOptionPane.showMessageDialog(null, "No hay ningun estudiante dado de alta");
                } else {
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listaasig.getlength(); i++) {
                        name = listaestudiant.getInfoName(i);
                        combocurs.addItem(name);
                    }
                    etiquetacurs.setVisible(true);
                    Estudiant e = listaestudiant.getEstu_Nom((String)combocurs.getSelectedItem());
                    mostrallista.setVisible(true);
                    if(e.getEstudiant_Asignatura().size()==0){
                        mostrallista.setText("Este estudiante no pertenece a ninguna asignatura");
                    }else{
                        mostrallista.setText("ASIGNATURAS:\n"+e.getEstudiant_Asignatura().Mostrar_Lista());

                }
                }

            }
        });

    }
}
