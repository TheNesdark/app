package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFIncapacidades.class */
public class JIFIncapacidades extends JInternalFrame {
    public static int guardado = 0;
    public String[] xidmunicipio;
    public String[][] xidprofesional;
    public clasesHistoriaCE xclase;
    public Persona xjppersona;
    public JPOOrdenSuministroH xjpsuministro;
    public JPAIncapacidad xjpincapacidad;
    private ButtonGroup JBGOpciones;
    private JPanel JPIFDatosUsuario;
    private JPanel JPIFondo;
    public int xnquincenas = 3;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFIncapacidades(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mCargasPanelUsuario();
        mCargarPanelIncapacidad();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFondo = new JPanel();
        this.JPIFDatosUsuario = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("INCAPACIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifincapacidad");
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFIncapacidades.1
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
                JIFIncapacidades.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFondo.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIFondoLayout = new GroupLayout(this.JPIFondo);
        this.JPIFondo.setLayout(JPIFondoLayout);
        JPIFondoLayout.setHorizontalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 864, 32767));
        JPIFondoLayout.setVerticalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 592, 32767));
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1014, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addComponent(this.JPIFondo, -2, -1, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFondo, -2, -1, -2)));
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

    private void mCargarPanelIncapacidad() {
        this.xjpincapacidad = new JPAIncapacidad(this.xclase, "xjifregincapacidad");
        mostrarPanel(this.xjpincapacidad);
    }

    public void mostrarPanel(JPanel formulario) {
        formulario.setBounds(5, 5, 850, 580);
        this.JPIFondo.add(formulario);
        this.JPIFondo.setVisible(true);
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("") || Principal.txtNo.getText() == null) {
            if (this.xjpincapacidad.validarComponentes()) {
                this.xjppersona.grabar();
                mGuardarDato();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Incapacidad ya grabada", "VERIFICAR INFORMACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    public void mGuardarDato() {
        String sql = "Insert into baseserver.ingreso (Id_Usuario, FechaIngreso, HoraIngreso, Id_EmpresaContxConv, Id_Estrato, Id_OrigenAdmision, Id_CausaExterna, Id_Especialidad, Id_Profesional, Id_TipoAtencion, Id_Contrato, EsAtencion,  NAcompanante, TelefonoAcomp, NPersonaResp, TelefonoPResp, Id_Parentesco, Fecha, UsuarioS) Values('" + this.xjppersona.getIdPersona() + "','" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()) + "','" + this.xjppersona.listaEmpresa[this.xjppersona.cboEps.getSelectedIndex()][1] + "','10','1','" + this.xjpincapacidad.idtipoenfermedad[this.xjpincapacidad.JCBTipoEnfermedad.getSelectedIndex()][0] + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','1','1','1','','','','','5','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        String ningreso = this.xconsultasbd.ejecutarSQLId(sql);
        this.xconsultasbd.cerrarConexionBd();
        String sql2 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + ningreso + "','154','" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "','" + this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()) + "','','','1','','','','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
        String natencion = this.xconsultasbd.ejecutarSQLId(sql2);
        this.xconsultasbd.cerrarConexionBd();
        this.xjpincapacidad.mGuardadDatosIncapacidadManuales(natencion, this.xjppersona.getIdPersona());
    }

    public void mAnular() {
        if (!this.xjpincapacidad.JTFFNIncapacidad.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xjpincapacidad.anular();
            }
        }
    }

    private void mLimpiarComponentes() {
        Principal.txtNo.setText("");
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Incapacidad", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            mLimpiarComponentes();
            this.xjppersona.nuevo();
            this.xjpincapacidad.nuevo();
        } else if (n == 1) {
            mLimpiarComponentes();
            this.xjpincapacidad.nuevo();
        }
    }

    public void buscar() {
        String[][] strArr = new String[2][2];
        Object[] botones = {"Usuario", "Incapacidades", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
            frmBuscar.setVisible(true);
        } else if (n == 1) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.xjppersona.getIdPersona()));
            Component jIFConsultarInforOtros = new JIFConsultarInforOtros(this.xclase, "jifincapacidad");
            Principal.PanelPpal.add(jIFConsultarInforOtros, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarInforOtros.setVisible(true);
            try {
                jIFConsultarInforOtros.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFIncapacidades.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void imprimir1() {
        if (!Principal.txtNo.getText().equals("") || Principal.txtNo.getText() != null) {
            this.xjpincapacidad.imprimir();
        }
    }
}
