package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDGenericoCb.class */
public class JDGenericoCb extends JDialog {
    private String[][] xid;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String xnombre;
    private String xsql;
    private JIFGestionSolicitudes xjifgests;
    private JComboBox JCBGenrico1;
    private JPanel JPIDatos;
    private JButton btnOk;
    private JButton btnSalir;

    public JDGenericoCb(Frame parent, boolean modal, JInternalFrame xjif) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCastingInterno(xjif);
        mNuevo();
    }

    public JDGenericoCb(Frame parent, boolean modal, String xnombre) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xnombre = xnombre;
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.btnOk = new JButton();
        this.btnSalir = new JButton();
        this.JPIDatos = new JPanel();
        this.JCBGenrico1 = new JComboBox();
        setDefaultCloseOperation(2);
        this.btnOk.setFont(new Font("Arial", 1, 12));
        this.btnOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnOk.setText("Ok");
        this.btnOk.addActionListener(new ActionListener() { // from class: Sgc.JDGenericoCb.1
            public void actionPerformed(ActionEvent evt) {
                JDGenericoCb.this.btnOkActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Sgc.JDGenericoCb.2
            public void actionPerformed(ActionEvent evt) {
                JDGenericoCb.this.btnSalirActionPerformed(evt);
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBGenrico1.setFont(new Font("Arial", 1, 12));
        this.JCBGenrico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona Asignada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCBGenrico1, 0, 768, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBGenrico1, -2, -1, -2).addContainerGap(24, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.btnOk, -2, 408, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnSalir, -1, 398, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(31, 31, 31).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnOk, -1, -1, 32767).addComponent(this.btnSalir, -1, 58, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOkActionPerformed(ActionEvent evt) {
        if (this.JCBGenrico1.getSelectedIndex() != -1) {
            if (this.xnombre.equals("jifgestionsolicitudes")) {
                this.xjifgests.mCrearEncuestaSatisfaccion(this.xid[this.JCBGenrico1.getSelectedIndex()][0], this.JCBGenrico1.getSelectedItem().toString());
                dispose();
            } else if (this.xnombre.equals("xjfprincipal")) {
                System.out.println(this.xid[this.JCBGenrico1.getSelectedIndex()][1]);
                Principal.informacionGeneralPrincipalDTO.setIdSolicitudEncuesta(Long.valueOf(this.xid[this.JCBGenrico1.getSelectedIndex()][1]));
                Principal.informacionGeneralPrincipalDTO.setIdTipoEncuesta(Long.valueOf(this.xid[this.JCBGenrico1.getSelectedIndex()][0]));
                Principal.clasegeneral.cargarPantalla("Encuesta");
                dispose();
            }
        }
    }

    private void mCastingInterno(JInternalFrame frm) {
        if (frm.getName().equals("jifgestionsolicitudes")) {
            this.xjifgests = (JIFGestionSolicitudes) frm;
            this.xnombre = "jifgestionsolicitudes";
        }
    }

    private void mNuevo() {
        if (this.xnombre.equals("jifgestionsolicitudes")) {
            this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ENCUESTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
            this.JCBGenrico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT t_e_tipo_encuesta_detalle.Id, t_encuestas.Nbre, t_e_tipo_encuesta_detalle.Id_TipoProceso FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (t_e_tipo_encuesta_detalle.Id_TipoProceso ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "') GROUP BY t_e_tipo_encuesta.Id ORDER BY t_encuestas.Nbre ASC ";
            this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBGenrico1, 3);
            this.JCBGenrico1.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            return;
        }
        if (this.xnombre.equals("xjfprincipal")) {
            this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ENCUESTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
            this.JCBGenrico1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT t_e_tipo_encuesta_detalle.Id, concat(t_encuestas.Nbre,' - Solicitud N°.', t_e_tipo_encuesta_detalle.Id_Solicitud ), t_e_tipo_encuesta_detalle.Id_Solicitud FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id) INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id) INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (t_e_tipo_encuesta_detalle.Id_UsuarioG ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "'AND t_e_tipo_encuesta_detalle.Diligencio =0) ";
            this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBGenrico1, 3);
            this.JCBGenrico1.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }
}
