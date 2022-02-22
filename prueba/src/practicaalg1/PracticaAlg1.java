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
    
    private JPanel panel;
    private JButton acceptvisu,acceptasig,acceptestu;
    private JComboBox combocurs;
    private JLabel etiquetacurs, etiquetaestu, etiquetaasig;
    private JTextArea mostrallista;
    private BajaCurso bc;
    private AltaCurso ac;
    private MatricularEstudiante_1 me;
    private BajaAsignaturaCurso bae;
    private JScrollPane scrollPane;
    ListaAsignaturas listaasig;
    private JEditorPane viewer;

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
        setTitle("Gestio Col·legi");
        listacurs = new ListaCurso();
        combocurs = new JComboBox();
        etiquetacurs = new JLabel("Seleccioni un curs");
        etiquetaestu= new JLabel("Seleccioni un estudiant");
        etiquetaasig=new JLabel("Seleccioni una asignatura");
        mostrallista = new JTextArea(40,45);
        mostrallista.setVisible(false);
        combocurs.setVisible(false);
        etiquetacurs.setVisible(false);
        acceptvisu=new JButton();
        acceptasig=new JButton();
        acceptestu=new JButton();
        acceptvisu.setBounds(650,600,200,75);
        acceptasig.setBounds(650,600,200,75);
        acceptestu.setBounds(650,600,200,75);
        
        acceptvisu.setText("VISUALITZAR");
        acceptvisu.setVisible(false);
        acceptasig.setText("VISUALITZAR");
        acceptasig.setVisible(false);
        acceptestu.setText("VISUALITZAR");
        acceptestu.setVisible(false);
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
        this.add(etiquetaestu);
        this.add(etiquetaasig);
        this.add(acceptvisu);
        this.add(acceptasig);
        this.add(acceptestu);
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
        String[] titlebot = {"Donar d'alta curs", "Matricular estudiant de asignatura",
            "Donar de baixa curs", "Donar de baixa asignatura", "Llista asignatures curs",
            "Llista de cursos de asignatura", "Llista asignatures de estudiant"};
        for (int i = 0; i < 7; i++) {
            botones[i] = new JButton(titlebot[i]);
            botones[i].setFont(new Font("arial", Font.BOLD, 15));
            botones[i].setForeground(Color.BLACK);
            botones[i].setBackground(Color.WHITE);
            opciones.add(botones[i]);
        }

        combocurs.setBounds(250, 100, 300, 50);
        etiquetacurs.setBounds(75, 100, 300, 50);
        etiquetaestu.setBounds(75, 100, 300, 50);
        etiquetaasig.setBounds(75, 100, 300, 50);
        
        panel.setBounds(800,80,1000,800);
        contenedor.add(opciones, BorderLayout.NORTH);
        viewer = new JEditorPane();
        viewer.setContentType("text/html");
        viewer.setEditable(false);
        viewer.setText(
                "<p>&nbsp;</p>\n"
                + "<h1 style=text-align: center; color: #3f7320;>PRACTICA 1: Gestio de Col·legi</h1>\n"
                + "\n"
                + "\n"
                + "<h3 style=text-align: center; color: #3f7320;>by Diego Bermejo, Marc Ca&ntilde;ellas y Victor Canelo</p>\n"
                + "<h3 style=text-align: center; color: #3f7320;>😁</h3>\n"
                + "<p><br /><strong></strong></p>");
        viewer.setVisible(true);
        this.add(viewer);
        etiquetacurs.setVisible(false);
        etiquetaestu.setVisible(false);
        etiquetaasig.setVisible(false);
        panel.setVisible(false);
        
        //acciones
        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewer.setVisible(false);
                scrollPane.setVisible(false);
                ac = new AltaCurso(listacurs, listaasig);
                ac.setLocationRelativeTo(PracticaAlg1.this);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                etiquetaestu.setVisible(false);
                etiquetaasig.setVisible(false);
                acceptvisu.setVisible(false);
                acceptasig.setVisible(false);
                acceptestu.setVisible(false);
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
                viewer.setVisible(false);
                me = new MatricularEstudiante_1(listaasig, listaasig.getlength());
                scrollPane.setVisible(false);
                me.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                etiquetaestu.setVisible(false);
                etiquetaasig.setVisible(false);
                acceptvisu.setVisible(false);
                acceptasig.setVisible(false);
                acceptestu.setVisible(false);
                me.setVisible(true);
                Asignatura asignatura;
                Estudiant estu;

                if (listaestudiant.perteneceObj(me.getestu())) {
                    asignatura = listacurs.search(me.getStringasig());
                    estu = listaestudiant.getEstu_Nom(me.getestu().getNom());
                    estu.addasig(asignatura);
                    asignatura.addestu(estu);
                    listacurs.actualiza(asignatura, estu);
                    listacurs.ordena();
                    estu.getEstudiant_Asignatura().Mostrar_Lista();

                } else {
                    
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
                        System.out.print("LISTAESTUDIANTES: "+listaestudiant.toString());
                        System.out.println(me.getStringasig());
                        System.out.println(me.getEstu());
                        System.out.print(me.getestu().getEstudiant_Asignatura().Mostrar_Lista());
                    

                }
            }

        });
        botones[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewer.setVisible(false);
                scrollPane.setVisible(false);
                bc = new BajaCurso(listacurs, listacurs.getlength(),listaasig,listaestudiant);
                bc.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                etiquetaestu.setVisible(false);
                etiquetaasig.setVisible(false);
                acceptvisu.setVisible(false);
                acceptasig.setVisible(false);
                acceptestu.setVisible(false);
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
                viewer.setVisible(false);
                scrollPane.setVisible(false);
                bae = new BajaAsignaturaCurso(listacurs, listaasig, listaestudiant);
                bae.setLocationRelativeTo(PracticaAlg1.this);
                mostrallista.setVisible(false);
                combocurs.setVisible(false);
                etiquetacurs.setVisible(false);
                etiquetaestu.setVisible(false);
                etiquetaasig.setVisible(false);
                acceptvisu.setVisible(false);
                acceptasig.setVisible(false);
                acceptestu.setVisible(false);
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
                    JOptionPane.showMessageDialog(null, "No hi ha cursos donats d'alta");
                } else {
                    viewer.setVisible(false);
                    etiquetacurs.setVisible(true);
                    etiquetaestu.setVisible(false);
                    etiquetaasig.setVisible(false);
                    acceptvisu.setVisible(true);
                    acceptasig.setVisible(false);
                    acceptestu.setVisible(false);
                    combocurs.removeAllItems();
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    panel.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listacurs.getlength(); i++) {
                        name = listacurs.returnCurs(i).getNom();
                        combocurs.addItem(name);
                    }

                }
            }
        });

        botones[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if (listaasig.getlength() == 0) {
                    JOptionPane.showMessageDialog(null, "No hi ha asignatures donades d'alta");
                } else {
                    viewer.setVisible(false);
                    etiquetacurs.setVisible(false);
                    etiquetaestu.setVisible(false);
                    etiquetaasig.setVisible(true);
                    acceptasig.setVisible(true);
                    acceptestu.setVisible(false);
                    acceptvisu.setVisible(false);
                    combocurs.removeAllItems();
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    panel.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listaasig.getlength(); i++) {
                        name = listaasig.getInfoName(i);
                        combocurs.addItem(name);
                    }
                    
                }
            }
        });

        botones[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (listaestudiant.getlength() == 0) {
                    JOptionPane.showMessageDialog(null, "No hi ha estudiants donats d'alta");
                } else {
                    viewer.setVisible(false);
                    etiquetacurs.setVisible(false);
                    etiquetaestu.setVisible(true);
                    etiquetaasig.setVisible(false);
                    acceptasig.setVisible(false);
                    acceptestu.setVisible(true);
                    acceptvisu.setVisible(false);
                    combocurs.removeAllItems();
                    panel.setVisible(true);
                    combocurs.setVisible(true);
                    scrollPane.setVisible(true);
                    //rellenar combo
                    String name;
                    for (int i = 0; i < listaestudiant.getlength(); i++) {
//                        if(listaestudiant.getEstu(i).getEstudiant_Asignatura().getlength()==0){
//                        
//                        }
//                        else{
                        name = listaestudiant.getInfoName(i);
                        combocurs.addItem(name);
//                        }
                    }
                }

            }
        });
        acceptvisu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                    Curs c = listacurs.returnCurs(combocurs.getSelectedIndex());
                    mostrallista.setVisible(true);
                    mostrallista.setText(c.getlista().toString());
                
            }
        });
        
        acceptasig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                    Asignatura a = listaasig.getInfo(combocurs.getSelectedIndex());
                    mostrallista.setVisible(true);
                    Curs c=(Curs)listacurs.returnObject(a);
                    if(a.getAsignatura_Estudiant().getlength()==0){
                        mostrallista.setText("CURS:\n   "+c.toString()+"\nESTUDIANTS:\n   No hi ha estudiants matriculats\n");
                    }else{
                        String s="CURS:\n   "+c.toString()+"\nESTUDIANTS:\n";
                        for(int i=0;i<a.getAsignatura_Estudiant().getlength();i++){
                            s+=a.getAsignatura_Estudiant().getInfo(i).toString()+"\n";
                        }
                        mostrallista.setText(s);
                    }
                }
            
        });
        
        acceptestu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                    Estudiant e = listaestudiant.getEstu(combocurs.getSelectedIndex());
                    mostrallista.setVisible(true);
                    if(e.getEstudiant_Asignatura().getlength()==0){
                        mostrallista.setText("Aquest estudiant ya no pertany a l'escola");
                    }else{
                        String cadena="";
                        for(int i=0;i<e.getEstudiant_Asignatura().getlength();i++){
                            Curs c=(Curs)listacurs.returnObject(e.getEstudiant_Asignatura().getInfo(i));
                            cadena+="CURS DE L'ASIGNATURA: "+c.getNom()+"\n"+"ASIGNATURA:\n"+e.getEstudiant_Asignatura().getInfo(i).toString2()+"\n";
                                    
                        }
                        mostrallista.setText(cadena);
                        

                        }
                }
            
        });

    }
}
