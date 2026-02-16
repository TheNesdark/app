package Historia;

import Acceso.Principal;
import General.JDFirmas;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Concepto_E.class */
public class JPSo_Concepto_E extends JPanel {
    private String[] xidtipor;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private clasesHistoriaCE xclase;
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBTAdicionar;
    private JButton JBTFirmar;
    private JComboBox JCBTipoR;
    private JLabel JLBNConcepto;
    private JPanel JPHistorico;
    private JPanel JPIDatosC;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JTextPane JTPObservacion;

    public JPSo_Concepto_E(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mBuscar();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosC = new JPanel();
        this.JCBTipoR = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JBTAdicionar = new JButton();
        this.JLBNConcepto = new JLabel();
        this.JBTFirmar = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpconceptolaborale");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoR.setFont(new Font("Arial", 1, 12));
        this.JCBTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Concepto_E.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_Concepto_E.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JLBNConcepto.setFont(new Font("Arial", 1, 18));
        this.JLBNConcepto.setForeground(new Color(255, 0, 0));
        this.JLBNConcepto.setHorizontalAlignment(0);
        this.JLBNConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Concepto", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBTFirmar.setFont(new Font("Arial", 1, 12));
        this.JBTFirmar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTFirmar.setText("Firmar");
        this.JBTFirmar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Concepto_E.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_Concepto_E.this.JBTFirmarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBTipoR, -2, 276, -2).addGap(0, 0, 32767)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JBTAdicionar, -2, 468, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTFirmar, -2, 174, -2).addGap(3, 3, 3).addComponent(this.JLBNConcepto, -1, 140, 32767)).addComponent(this.JSPObservacion)).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JCBTipoR, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion, -1, 228, 32767).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNConcepto, -1, -1, 32767).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionar, -1, 53, 32767).addComponent(this.JBTFirmar, -1, 62, 32767))).addContainerGap()));
        this.JTPDatos.addTab("CONCEPTO DE APTITUD LABORAL (Egreso)", this.JPIDatosC);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 793, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 380, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTFirmarActionPerformed(ActionEvent evt) {
        if (!this.JLBNConcepto.getText().isEmpty()) {
            JDFirmas xJDFirmas = new JDFirmas(null, true, getName(), this.JLBNConcepto.getText());
            xJDFirmas.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Generar o Cargar un No de Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mNuevo() {
        this.JLBNConcepto.setText("");
        this.JTPObservacion.setText("");
    }

    public void mGrabar() {
        if (this.JLBNConcepto.getText().isEmpty()) {
            if (this.JCBTipoR.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    this.xsql = "insert into h_so_concepto_laboral (`Id_Atencion`, `Id_TipoC`, `Observacion`,Id_UsuarioA, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtipor[this.JCBTipoR.getSelectedIndex()] + "','" + this.JTPObservacion.getText() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNConcepto.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    this.JBTAdicionar.setEnabled(false);
                    Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        Principal.clasehistoriace.mActualizarVariable_ManPower("ConceptoE", this.JCBTipoR.getSelectedItem().toString(), "Observacion_CE", this.JTPObservacion.getText());
                    }
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoR.requestFocus();
        }
    }

    private void mBuscar() {
        try {
            this.JCBTipoR.removeAllItems();
            this.xidtipor = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM  `so_tipo_concepto` WHERE (`Tipo` =1 AND `Estado` =1) ORDER BY `Id` ASC", this.xidtipor, this.JCBTipoR);
            this.JCBTipoR.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `so_tipo_concepto`.`Nbre`, `h_so_concepto_laboral`.`Observacion` , `h_so_concepto_laboral`.`Id` FROM  `h_so_concepto_laboral` INNER JOIN  `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) WHERE (`h_so_concepto_laboral`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_concepto_laboral`.`Estado` =1)  ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBTipoR.setSelectedItem(xrs.getString(1));
                this.JTPObservacion.setText(xrs.getString(2));
                this.JLBNConcepto.setText(xrs.getString(3));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                mNuevo();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Concepto_E.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Concepto", "Tipo Concepto", "Observación", "Fecha"}) { // from class: Historia.JPSo_Concepto_E.3
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(6);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT  `h_so_concepto_laboral`.`Id` , `so_tipo_concepto`.`Nbre` , `h_so_concepto_laboral`.`Observacion`  , DATE_FORMAT (`h_so_concepto_laboral`.`Fecha`,'%d-%m-%Y') AS Fecha FROM `h_so_concepto_laboral` INNER JOIN  `so_tipo_concepto`    ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) WHERE (`h_so_concepto_laboral`.`Id_UsuarioA` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `so_tipo_concepto`.`Estado` =0) ORDER BY `h_so_concepto_laboral`.`Fecha` DESC";
            ResultSet xrs = this.xct.traerRs(sql);
            TableColumnModel cmodel = this.JTHistorico.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(2).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(2).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Concepto_E.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JLBNConcepto.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Egreso_Nuevo", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud", mparametros);
        }
    }
}
