package Historia;

import General.BuscarPersona;
import General.Persona;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFGenerarCertificado.class */
public class JIFGenerarCertificado extends JInternalFrame {
    private Metodos xmetodos = new Metodos();
    public Persona xjppersona;
    public JPCertificado xjpcertificado;
    private String xnombre;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosCertificado;
    private JPanel JPIFDatosUsuario;

    public JIFGenerarCertificado(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        mCargasPanelUsuario();
        mCargasPanelCertificacion();
        this.xjpcertificado.JBTGuardarTemp.setVisible(false);
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JPIFDatosCertificado = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSTANCIA DE ASISTENCIA A SERVICIOS DE SALUD");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(new Dimension(1020, 800));
        setName("jifconstanciaservicio");
        setPreferredSize(new Dimension(1020, 800));
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFGenerarCertificado.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerarCertificado.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 974, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JPIFDatosCertificado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIFDatosCertificado.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIFDatosCertificadoLayout = new GroupLayout(this.JPIFDatosCertificado);
        this.JPIFDatosCertificado.setLayout(JPIFDatosCertificadoLayout);
        JPIFDatosCertificadoLayout.setHorizontalGroup(JPIFDatosCertificadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 974, 32767));
        JPIFDatosCertificadoLayout.setVerticalGroup(JPIFDatosCertificadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 596, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFDatosCertificado, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIFDatosCertificado, -2, -1, -2).addContainerGap()));
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
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargasPanelCertificacion() {
        this.xjpcertificado = new JPCertificado(this);
        this.xjpcertificado.setVisible(true);
        this.JPIFDatosCertificado.setVisible(false);
        this.xjpcertificado.setBounds(5, 15, 800, 501);
        this.JPIFDatosCertificado.add(this.xjpcertificado);
        this.JPIFDatosCertificado.setVisible(true);
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    public void mNuevo() {
        Object[] botones = {"Usuario", "Certificado", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjppersona.nuevo();
            this.xjpcertificado.mNuevo();
        } else if (n == 1) {
            this.xjpcertificado.mNuevo();
        }
    }

    public void mGrabar() {
        this.xjppersona.grabar();
        this.xjpcertificado.mGrabar();
    }

    public void mImprimir() {
        this.xjpcertificado.mImprimir();
    }

    public void mAnular() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xjpcertificado.mAnular();
        }
    }
}
