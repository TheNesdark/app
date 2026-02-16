package Salud_Ocupacional;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFTest_Fatiga.class */
public class JIFTest_Fatiga extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public Persona xjppersona;
    public JPTestFatiga xjpprueba;
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private String xnombre;
    private JPanel JPIDatosPrueba;
    private JPanel JPIFDatosUsuario;

    public JIFTest_Fatiga(String xnombre) {
        this.xnombre = "";
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        mCargasPanelUsuario();
        mCargasPanelPrueba();
    }

    private void initComponents() {
        this.JPIFDatosUsuario = new JPanel();
        this.JPIDatosPrueba = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("TEST DE FATIGA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftestfatiga");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFTest_Fatiga.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFTest_Fatiga.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 972, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIDatosPrueba.setBorder(BorderFactory.createTitledBorder((Border) null, "PRUEBA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIDatosPruebaLayout = new GroupLayout(this.JPIDatosPrueba);
        this.JPIDatosPrueba.setLayout(JPIDatosPruebaLayout);
        JPIDatosPruebaLayout.setHorizontalGroup(JPIDatosPruebaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIDatosPruebaLayout.setVerticalGroup(JPIDatosPruebaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 491, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, -1, -1, 32767).addComponent(this.JPIDatosPrueba, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosPrueba, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    private void mCargasPanelPrueba() {
        this.xjpprueba = new JPTestFatiga(this);
        this.xjpprueba.setVisible(true);
        this.JPIDatosPrueba.setVisible(false);
        this.xjpprueba.setBounds(5, 15, 950, 483);
        this.JPIDatosPrueba.add(this.xjpprueba);
        this.JPIDatosPrueba.setVisible(true);
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void mGrabar() {
        this.xjpprueba.mGrabar();
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
        this.xjpprueba.mNuevo();
    }

    public void mImprimir() {
        this.xjpprueba.mImprimir();
    }

    public void mBuscarDato() {
        this.xjpprueba.mCargarDatosTablaHistorico();
    }
}
