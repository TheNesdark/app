package Historia;

import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFSeguimientosPac.class */
public class JIFSeguimientosPac extends JInternalFrame {
    public static int guardado = 0;
    public String[] xidmunicipio;
    public String[][] xidprofesional;
    private clasesHistoriaCE xclase;
    public Persona xjppersona;
    public JPOOrdenSuministroH xjpsuministro;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosUsuario;
    public JFormattedTextField JTFFNAtencion;
    public int xnquincenas = 3;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFSeguimientosPac(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mCargasPanelUsuario();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JTFFNAtencion = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("SEGUIMIENTO A USUARIOS HOSPITALIZADOS");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifformulapyp");
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFSeguimientosPac.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSeguimientosPac.this.formInternalFrameClosing(evt);
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
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFFNAtencion.setEditable(false);
        this.JTFFNAtencion.setBackground(new Color(0, 0, 153));
        this.JTFFNAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Atención", 2, 0, new Font("Tahoma", 1, 14), new Color(204, 255, 255)));
        this.JTFFNAtencion.setForeground(new Color(255, 255, 255));
        this.JTFFNAtencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNAtencion.setHorizontalAlignment(0);
        this.JTFFNAtencion.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFNAtencion.setEnabled(false);
        this.JTFFNAtencion.setFont(new Font("Arial", 1, 22));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosUsuarioLayout.createSequentialGroup().addContainerGap(970, 32767).addComponent(this.JTFFNAtencion, -2, 180, -2).addGap(18, 18, 18)));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosUsuarioLayout.createSequentialGroup().addComponent(this.JTFFNAtencion, -2, 78, -2).addContainerGap(70, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(663, 663, 663)));
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
        this.xjppersona.setBounds(1, 1, 1000, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }
}
