package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFMovManual.class */
public class JIFMovManual extends JInternalFrame {
    private String[][] xidTipoDoc;
    DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JButton JBBuscar;
    private JComboBox JCTipoDocumento;
    private JDateChooser JDFFechaI;
    public JLabel JLCodigoDoc;
    private JTable JTDetalle;
    public JTextArea JTObservacion;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public String xidMovimiento = "";
    private int xConsecutivo = 0;

    public JIFMovManual() {
        initComponents();
        mIniciaComponentes();
        mCreaModeloMovimiento();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCTipoDocumento = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JLCodigoDoc = new JLabel();
        this.JBBuscar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MOVIMIENTO MANUAL");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifMovimientoManual");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFMovManual.1
            public void itemStateChanged(ItemEvent evt) {
                JIFMovManual.this.JCTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/factura.png")));
        this.JBBuscar.setToolTipText("Adjuntar Documento");
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFMovManual.2
            public void actionPerformed(ActionEvent evt) {
                JIFMovManual.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setLineWrap(true);
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Objeto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCTipoDocumento, -2, 414, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2)).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JCTipoDocumento, -1, 51, 32767).addComponent(this.JLCodigoDoc, -1, -1, 32767).addComponent(this.JBBuscar, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 63, -2).addGap(0, 14, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 10)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFMovManual.3
            public void mouseClicked(MouseEvent evt) {
                JIFMovManual.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 838, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 301, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    private void mIniciaComponentes() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        System.out.println("SELECT pp_tipo_documentos.`Id`,pp_tipo_documentos.`Nbre`,pp_tipo_documentos.Id_ClaseDoc, pp_clase_documento.IdPadre FROM \n`pp_tipo_documentos` INNER JOIN `pp_clase_documento` ON(pp_tipo_documentos.`Id_ClaseDoc`=pp_clase_documento.`Id`)\nWHERE `Id_ClaseDoc`IN (15,14,13, 12) ORDER BY IdPadre ASC");
        this.xidTipoDoc = this.xct.llenarComboyLista("SELECT pp_tipo_documentos.`Id`,pp_tipo_documentos.`Nbre`,pp_tipo_documentos.Id_ClaseDoc, pp_clase_documento.IdPadre FROM \n`pp_tipo_documentos` INNER JOIN `pp_clase_documento` ON(pp_tipo_documentos.`Id_ClaseDoc`=pp_clase_documento.`Id`)\nWHERE `Id_ClaseDoc`IN (15,14,13, 12) ORDER BY IdPadre ASC", this.xidTipoDoc, this.JCTipoDocumento, 4);
        this.JCTipoDocumento.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JCTipoDocumento.getSelectedIndex() > -1) {
            JDBuscaDocumentosMovManual x = new JDBuscaDocumentosMovManual(null, true, this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][2], this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCTipoDocumento.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloMovimiento() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.rubro", "Nombre", "Comprometido", "Obligado", "Saldo", "Reintegrado", "Valor a Reintegrar"}) { // from class: Presupuesto.JIFMovManual.4
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    public void mBuscaRubroMovimiento() {
        if (this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][2].equals("4")) {
            mLlenaModeloCompromiso();
        } else {
            mLlenaModeloObligacion();
        }
    }

    private void mLlenaModeloCompromiso() {
        mCreaModeloMovimiento();
        String sql = "SELECT COMP.Id_Rubro,COMP.Rubro, COMP.Valor AS VCom ,SUM(OBLI.Valor) AS VObl, (COMP.Valor- SUM(OBLI.Valor)) AS Diferencia, IF(REIN.Valor IS NULL,'0',REIN.Valor) AS Reintegrado\n\nFROM (SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre` AS Rubro\n    , `pp_detalle_movimiento`.`Valor`\n    ,`pp_detalle_movimiento`.`Id_Movimiento` AS IdCompromiso\n    \n    FROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_rubros`  ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`)\n    # inner join pp_movimiento on (pp_detalle_movimiento.`Id_Movimiento`=pp_movimiento.)\nWHERE (`pp_detalle_movimiento`.`Id_Movimiento` ='" + this.xidMovimiento + "'\n    AND `pp_detalle_movimiento`.`Estado` =1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) COMP\nLEFT JOIN \n(SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_movimiento`.`IdCompromiso`\n    \nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`)\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_MotivoAnulacion`=1\n    AND `pp_movimiento`.`IdCompromiso` ='" + this.xidMovimiento + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc`=5 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) OBLI\nON COMP.Id_Rubro=OBLI.Id_Rubro AND COMP.IdCompromiso=OBLI.IdCompromiso\nLEFT JOIN \n(SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_movimiento`.`IdCompromiso`\n    \nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`)\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_MotivoAnulacion`=1\n    AND `pp_movimiento`.`IdCompromiso` ='" + this.xidMovimiento + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc`=13 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) REIN\nON COMP.Id_Rubro=REIN.Id_Rubro AND COMP.IdCompromiso=REIN.IdCompromiso\n  group by OBLI.Id_Rubro";
        System.out.println("detR1--" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    if (xrs.getDouble("Diferencia") != 0.0d && xrs.getDouble("Reintegrado") == 0.0d) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                        this.xmodelo.setValueAt(0, n, 6);
                        n++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            if (this.JTDetalle.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Este Movimiento no tiene Reintegros pendientes", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JLCodigoDoc.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFMovManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloMovimientoObligacion() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.rubro", "Nombre", "Obligado", "Pagado", "Saldo", "Reintegrado"}) { // from class: Presupuesto.JIFMovManual.5
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    private void mLlenaModeloObligacion() {
        mCreaModeloMovimientoObligacion();
        String sql = "SELECT OBLI.Id_Rubro,OBLI.Rubro, OBLI.Valor AS VObl ,PAGO.Valor AS VPago, (OBLI.Valor- PAGO.Valor) AS Diferencia, IF(REIN.Valor IS NULL,'0',REIN.Valor) AS Reintegrado\n\nFROM (SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre` AS Rubro\n    , `pp_detalle_movimiento`.`Valor`\n    ,`pp_detalle_movimiento`.`Id_Movimiento` AS IdObligacion\n    \n    FROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `pp_rubros`  ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    # inner join pp_movimiento on (pp_detalle_movimiento.`Id_Movimiento`=pp_movimiento.)\nWHERE (`pp_detalle_movimiento`.`Id_Movimiento` ='" + this.xidMovimiento + "'\n    AND `pp_detalle_movimiento`.`Estado` =1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) OBLI\nLEFT JOIN \n(SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_movimiento`.`IdObligacion`\n    \nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_MotivoAnulacion`=1\n    AND `pp_movimiento`.`IdObligacion` ='" + this.xidMovimiento + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc`=6 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) PAGO\nON OBLI.Id_Rubro=PAGO.Id_Rubro AND OBLI.IdObligacion=PAGO.IdObligacion\nLEFT JOIN \n(SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_movimiento`.`IdObligacion`\n    \nFROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_detalle_movimiento`.`Estado` =1 AND pp_movimiento.`Id_MotivoAnulacion`=1\n    AND `pp_movimiento`.`IdObligacion` ='" + this.xidMovimiento + "'\n    AND `pp_tipo_documentos`.`Id_ClaseDoc`=15 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC) REIN\nON OBLI.Id_Rubro=REIN.Id_Rubro AND OBLI.IdObligacion=REIN.IdObligacion\n -- group by OBLI.Id_Rubro";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    if (xrs.getDouble("Diferencia") > 0.0d && xrs.getDouble("Reintegrado") == 0.0d) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                        n++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            if (this.JTDetalle.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Este Movimiento no tiene Reintegros pendientes", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JLCodigoDoc.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFMovManual.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarRCom() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            mConcecutivo();
            String sql = "INSERT INTO  `pp_movimiento`\n            ( `Id_Periodo`,\n             `Id_TipoDoc`,\n             `NoConcecutivo`,\n             `FechaD`,\n             `Observacion`,\n             `IdUsuarioR`,\n             `IdCompromiso`, \n             `UsuarioS`)\nVALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][0] + "','" + this.xConsecutivo + "','" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "','" + this.JTObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xidMovimiento + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
            String xMovimiento = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String sql2 = "INSERT INTO `pp_detalle_movimiento` ( `Id_Movimiento`,  `Id_Rubro`, `Id_Tercero`, `Valor`, idEncabezado)\nVALUES ('" + xMovimiento + "', '" + this.xmodelo.getValueAt(i, 0) + "',  '1','" + this.xmodelo.getValueAt(i, 6) + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }

    public void mGrabar() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()))) {
            if (this.JCTipoDocumento.getSelectedIndex() > -1) {
                System.out.println("getRowCount()-->" + this.JTDetalle.getRowCount());
                if (this.JTDetalle.getRowCount() > 0) {
                    if (this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][2].equals("4")) {
                        mGrabarRCom();
                        mCreaModeloMovimiento();
                    } else if (this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][2].equals("5")) {
                        mGrabarRObl();
                        mCreaModeloMovimientoObligacion();
                    }
                    this.JLCodigoDoc.setText("");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe cargar movimiento para conttinuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCTipoDocumento.requestFocus();
        }
    }

    private void mGrabarRObl() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            mConcecutivo();
            String sql = "INSERT INTO  `pp_movimiento`\n            ( `Id_Periodo`,\n             `Id_TipoDoc`,\n             `NoConcecutivo`,\n             `FechaD`,\n             `Observacion`,\n             `IdUsuarioR`,\n             `IdObligacion`, \n             `UsuarioS`)\nVALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][0] + "','" + this.xConsecutivo + "','" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "','" + this.JTObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xidMovimiento + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
            String xMovimiento = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String sql2 = "INSERT INTO `pp_detalle_movimiento` ( `Id_Movimiento`,  `Id_Rubro`, `Id_Tercero`, `Valor`)\nVALUES ('" + xMovimiento + "', '" + this.xmodelo.getValueAt(i, 0) + "',  '1','" + this.xmodelo.getValueAt(i, 4) + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][2] + "'  AND  pp_tipo_documentos.`Id`='" + this.xidTipoDoc[this.JCTipoDocumento.getSelectedIndex()][0] + "');";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }
}
