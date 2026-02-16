package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.beans.PropertyVetoException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFFormulasPyP.class */
public class JIFFormulasPyP extends JInternalFrame {
    public static int guardado = 0;
    public String[] xidmunicipio;
    public String[][] xidprofesional;
    private clasesHistoriaCE xclase;
    public Persona xjppersona;
    public JPOOrdenSuministroH xjpsuministro;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIFondo;
    public JFormattedTextField JTFFNAtencion;
    public int xnquincenas = 3;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFFormulasPyP(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mCargasPanelUsuario();
        mCargarPanelFormula();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFondo = new JPanel();
        this.JPIFDatosUsuario = new JPanel();
        this.JTFFNAtencion = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FORMULAS PROMOCIÓN Y PREVENCIÓN ");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1214, 892));
        setName("jifformulapyp");
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFFormulasPyP.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFormulasPyP.this.formInternalFrameClosing(evt);
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
        this.JPIFondo.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIFondoLayout = new GroupLayout(this.JPIFondo);
        this.JPIFondo.setLayout(JPIFondoLayout);
        JPIFondoLayout.setHorizontalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 864, 32767));
        JPIFondoLayout.setVerticalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 630, 32767));
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNAtencion.setBackground(new Color(0, 0, 153));
        this.JTFFNAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Atención", 2, 0, new Font("Tahoma", 1, 14), new Color(204, 255, 255)));
        this.JTFFNAtencion.setEditable(false);
        this.JTFFNAtencion.setForeground(new Color(255, 255, 255));
        this.JTFFNAtencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNAtencion.setHorizontalAlignment(0);
        this.JTFFNAtencion.setDisabledTextColor(new Color(255, 255, 255));
        this.JTFFNAtencion.setEnabled(false);
        this.JTFFNAtencion.setFont(new Font("Arial", 1, 22));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosUsuarioLayout.createSequentialGroup().addContainerGap(970, 32767).addComponent(this.JTFFNAtencion, -2, 180, -2).addGap(18, 18, 18)));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosUsuarioLayout.createSequentialGroup().addComponent(this.JTFFNAtencion, -2, 78, -2).addContainerGap(75, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFondo, -2, -1, -2).addContainerGap(326, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFondo, -2, -1, -2).addGap(23, 23, 23)));
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

    private void mCargarPanelFormula() {
        this.xjpsuministro = new JPOOrdenSuministroH("Formulas PyP", this.xclase);
        mostrarPanel(this.xjpsuministro);
    }

    public void mostrarPanel(JPanel formulario) {
        formulario.setBounds(5, 5, 850, 597);
        this.JPIFondo.add(formulario);
        this.JPIFondo.setVisible(true);
    }

    public void grabar() {
        if (this.xjpsuministro.mVerificarDatos() && this.JTFFNAtencion.getText().isEmpty()) {
            this.xjppersona.grabar();
            this.xjpsuministro.grabar();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe adicionar un medicamento", "VERIFICAR INFORMACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    private void mLimpiarComponentes() {
        this.JTFFNAtencion.setText((String) null);
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Formula", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            mLimpiarComponentes();
            this.xjppersona.nuevo();
            this.xjpsuministro.nuevo();
        } else if (n == 1) {
            mLimpiarComponentes();
            this.xjpsuministro.nuevo();
        }
    }

    public void buscar() {
        String[][] strArr = new String[2][2];
        Object[] botones = {"Usuario", "Atenciones", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
            frmBuscar.setVisible(true);
        } else if (n == 1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xjppersona.getIdPersona()));
            Component jIFConsultarSuministro = new JIFConsultarSuministro(this.xclase, "jifformulapyp", "");
            Principal.PanelPpal.add(jIFConsultarSuministro, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarSuministro.setVisible(true);
            try {
                jIFConsultarSuministro.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFFormulasPyP.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void imprimir() {
        this.xjpsuministro.mImprimir(Long.valueOf(this.xjpsuministro.JTFNordenSum.getText()).longValue(), 2);
    }

    public void mAnular() {
        this.xjpsuministro.anular();
    }
}
