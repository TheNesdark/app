package ComprasBS;

import Acceso.Principal;
import ParametrizacionN.JIFSSuministro;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFAutorizarReq.class */
public class JIFAutorizarReq extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xmodulo;
    private JIFSSuministro xjifsuministro;
    private File xfile;
    private boolean xlleno;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JPanel JPITipoAutor;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xautorizado = 1;
    private String xid = "";
    private boolean xestadog = false;

    public JIFAutorizarReq(String xnombre) {
        initComponents();
        setTitle("EVALUACIÓN REQUISICIÓN");
        this.xnombre = xnombre;
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPITipoAutor = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("MUNICIPIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifaurizacionreq");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ComprasBS.JIFAutorizarReq.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAutorizarReq.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addGap(43, 43, 43).addComponent(this.JDFechaF, -2, 120, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 45, -2).addComponent(this.JDFechaF, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFAutorizarReq.2
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizarReq.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPITipoAutor.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setSelected(true);
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizarReq.3
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizarReq.this.JRBSiActionPerformed(evt);
            }
        });
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: ComprasBS.JIFAutorizarReq.4
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizarReq.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoAutorLayout = new GroupLayout(this.JPITipoAutor);
        this.JPITipoAutor.setLayout(JPITipoAutorLayout);
        JPITipoAutorLayout.setHorizontalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAutorLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPITipoAutorLayout.setVerticalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoAutorLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPITipoAutor, -2, -1, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 782, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoAutor, -2, 52, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            Object[] botones = {"Visualizar Orden", "Autorizar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "ACCIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                if (this.JTDetalle.getSelectedRow() != -1) {
                    mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fila", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            if (n == 1) {
                mAutorizar(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                JDRespuestaEvaluacion dialog = new JDRespuestaEvaluacion(this);
                dialog.setLocation((this.xmetodos.getAnchoPantalla() / 2) / 2, (this.xmetodos.getAltoPantalla() / 2) / 2);
                dialog.setVisible(true);
                mCargarDatosTabla();
            }
        }
    }

    private void mImprimirDoc(String xid) {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = xid;
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Requisicion", mparametros);
        }
    }

    private void mAutorizar(String xid) {
        String sql = "update `cc_r_requisicion` set cc_r_requisicion.`Evaluado`=1 where cc_r_requisicion.`Id`='" + xid + "'";
        this.xconsulta.ejecutarSQL(sql);
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xautorizado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xautorizado = 0;
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xid = "";
        this.xestado = 1;
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = null;
            if (Principal.txtNo.getText().isEmpty()) {
                sql = " Insert into g_manualgenoma(`Id_Modulo` , `Nbre` , `Url`, `Estado`, `Fecha` , `UsuarioS`) ','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            }
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaR", "Unidad F", "Presupuesto", "Persona que Solicita"}) { // from class: ComprasBS.JIFAutorizarReq.5
            Class[] types = {Long.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(35);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT  `cc_r_requisicion`.`Id`  , `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre`  ,  `cc_r_requisicion`.`VPresupuestado`, `persona`.`NUsuario` FROM `cc_r_requisicion` INNER JOIN `cc_unidad_funcional` ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) INNER JOIN `rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`) INNER JOIN `persona` ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`) WHERE (`cc_r_requisicion`.`Autorizado`=1 and `cc_r_requisicion`.`Estado`=1 and `cc_r_requisicion`.`FechaR`>='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' and `cc_r_requisicion`.`FechaR`<='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') order by `cc_r_requisicion`.`FechaR` ASC;";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizarReq.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }
}
