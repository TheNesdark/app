package Historia;

import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.beans.PropertyVetoException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFPermisosMedicos.class */
public class JIFPermisosMedicos extends JInternalFrame {
    public static int guardado = 0;
    public String[] xidmunicipio;
    public String[][] xidprofesional;
    private clasesHistoriaCE xclase;
    public Persona xjppersona;
    public JPPermisosMedicos xjppermiso;
    public String xname;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIFondo;
    public int xnquincenas = 3;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFPermisosMedicos(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mCargasPanelUsuario();
        mCargarPanelPermiso();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFondo = new JPanel();
        this.JPIFDatosUsuario = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PERMISO MEDICO");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1003, 840));
        setName("jifpermisomedicos");
        setPreferredSize(new Dimension(1003, 840));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFPermisosMedicos.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFPermisosMedicos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFondo.setBorder(BorderFactory.createEtchedBorder());
        this.JPIFondo.setPreferredSize(new Dimension(868, 590));
        GroupLayout JPIFondoLayout = new GroupLayout(this.JPIFondo);
        this.JPIFondo.setLayout(JPIFondoLayout);
        JPIFondoLayout.setHorizontalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 864, 32767));
        JPIFondoLayout.setVerticalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 586, 32767));
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 957, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 155, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addComponent(this.JPIFondo, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIFondo, -2, -1, -2).addGap(32, 32, 32)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(10, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargarPanelPermiso() {
        this.xjppermiso = new JPPermisosMedicos(this.xclase);
        mostrarPanel(this.xjppermiso);
    }

    public void mostrarPanel(JPanel formulario) {
        formulario.setBounds(10, 10, 840, 570);
        this.JPIFondo.add(formulario);
        this.JPIFondo.setVisible(true);
    }

    public void grabar() {
        if (this.xjppermiso.JTFN.getText().isEmpty()) {
            this.xjppersona.grabar();
            this.xjppermiso.grabar();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Permiso grabado", "VERIFICAR INFORMACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    public void anular() {
        this.xjppermiso.anular();
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Permiso", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjppersona.nuevo();
            this.xjppermiso.nuevo();
        } else if (n == 1) {
            this.xjppermiso.nuevo();
        }
    }

    public void buscar() {
        this.xjppermiso.buscar();
    }

    public void imprimir() {
        this.xjppermiso.imprimir();
    }
}
