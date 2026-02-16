package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFMovManualOP_PP.class */
public class JIFFMovManualOP_PP extends JInternalFrame {
    private String[][] xCombo;
    private String xIdCompromiso;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    public String xIdClaseDoc;
    private JButton JBBuscar;
    private JCheckBox JCBSeleccionarTodo;
    private JComboBox JCTipoDocumento;
    private JDateChooser JDFFechaI;
    public JLabel JLCodigoDoc;
    private JFormattedTextField JLValor;
    public JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xConsecutivo = 0;
    public String xIdCompromisoObli = "";
    public String xidMovimiento = "";

    public JIFFMovManualOP_PP() {
        initComponents();
        mIniciarCombo();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    public String getxIdCompromiso() {
        return this.xIdCompromiso;
    }

    public void setxIdCompromiso(String xIdCompromiso) {
        this.xIdCompromiso = xIdCompromiso;
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCTipoDocumento = new JComboBox();
        this.JDFFechaI = new JDateChooser();
        this.JLCodigoDoc = new JLabel();
        this.JBBuscar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JLValor = new JFormattedTextField();
        this.JCBSeleccionarTodo = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MOVIMIENTO MANUAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifMovManualOP_PP");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFMovManualOP_PP.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFMovManualOP_PP.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFMovManualOP_PP.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFMovManualOP_PP.this.JCTipoDocumentoItemStateChanged(evt);
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
        this.JBBuscar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovManualOP_PP.3
            public void actionPerformed(ActionEvent evt) {
                JIFFMovManualOP_PP.this.JBBuscarActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCTipoDocumento, -2, 414, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -1, 211, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscar, -2, 51, -2))).addGap(20, 20, 20)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JCTipoDocumento).addComponent(this.JLCodigoDoc, -1, -1, 32767).addComponent(this.JBBuscar, -1, 51, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -1, 111, 32767).addContainerGap()));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 10)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFMovManualOP_PP.4
            public void mouseClicked(MouseEvent evt) {
                JIFFMovManualOP_PP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JLValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JLValor.setHorizontalAlignment(0);
        this.JLValor.setFont(new Font("Arial", 1, 14));
        this.JCBSeleccionarTodo.setText("Seleccionar todo");
        this.JCBSeleccionarTodo.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFMovManualOP_PP.5
            public void actionPerformed(ActionEvent evt) {
                JIFFMovManualOP_PP.this.JCBSeleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBSeleccionarTodo).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING)).addGap(0, 5, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JLValor, -2, 203, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSeleccionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLValor, -2, 58, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCTipoDocumento.getSelectedIndex() > -1) {
            System.out.println("xCombo--" + this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1]);
            if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("5")) {
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Compromiso", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xIdClaseDoc = "5";
            }
            if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("6")) {
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Obligación", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.xIdClaseDoc = "6";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarActionPerformed(ActionEvent evt) {
        if (this.JCTipoDocumento.getSelectedIndex() > -1) {
            JDBusquedaDocPTO x = new JDBusquedaDocPTO(null, true, this, this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1], "0");
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de movimiento", "VERIFICAR", 1);
            this.JCTipoDocumento.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSeleccionarTodoActionPerformed(ActionEvent evt) {
        if (this.xmodelo.getRowCount() > 0) {
            if (this.JCBSeleccionarTodo.isSelected()) {
                for (int i = 0; i < this.xmodelo.getRowCount(); i++) {
                    this.xmodelo.setValueAt(true, i, 7);
                }
                return;
            }
            for (int i2 = 0; i2 < this.xmodelo.getRowCount(); i2++) {
                this.xmodelo.setValueAt(false, i2, 7);
            }
        }
    }

    private void mIniciarCombo() {
        this.xCombo = this.xct.llenarComboyLista("SELECT `Id`  , `Nbre`, Id_ClaseDoc FROM `pp_tipo_documentos` WHERE (`Id_ClaseDoc` IN (5,6) AND `Estado` =1) ORDER BY `Id_ClaseDoc`;", this.xCombo, this.JCTipoDocumento, 3);
        this.xct.cerrarConexionBd();
        this.JCTipoDocumento.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDisponibilidad() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Rubro", "Compromiso", "Obligado", "Por Obligar", "IdTercero", "Tercero", "✓"}) { // from class: Presupuesto.JIFFMovManualOP_PP.6
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloMovimiento() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Rubro", "Valor"}) { // from class: Presupuesto.JIFFMovManualOP_PP.7
            Class[] types = {String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosPago() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Rubro", "Obligación", "Pagado", "Por Pagar", "IdTercero", "Tercero", "✓"}) { // from class: Presupuesto.JIFFMovManualOP_PP.8
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    public void mBuscaDetalleObligacion() {
        mCrearModeloMovimiento();
        String sql = "select r.Id, r.Nbre as rubro,dm.Valor  from pp_movimiento as pm \ninner join pp_detalle_movimiento as dm on (pm.Id=dm.Id_Movimiento)\ninner join pp_rubros r on (dm.id_rubro=r.id)\nwhere pm.Id=" + this.xidMovimiento + "";
        ResultSet xrs = this.xct.traerRs(sql);
        double valor = 0.0d;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("rubro"), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), n, 2);
                    valor += xrs.getDouble("Valor");
                    n++;
                }
            }
            this.JLValor.setValue(Double.valueOf(valor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovManualOP_PP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscaDetalleRubrosMovimiento() {
        if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("5")) {
            mCrearModeloDatosDisponibilidad();
            String sql = "SELECT D.NoConcecutivo\n, D.IdCompromiso\n,D.FechaD\n,D.TipoDoc\n,D.Observacion\n,D.Id_Tercero\n, D.NTercero \n,D.Id_rubro\n,D.NombreRubro\n,D.Compromiso\n,IFNULL(C.Obligacion,0) Obligacion\n,(D.Compromiso-IFNULL(C.Obligacion,0)) Por_Obligacion\n,Estado\n,D.IdDisponibilidad\n\n FROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n       , pp_tipo_documentos.Nbre AS TipoDoc \n       , IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n       , g_motivoanulacion.Nbre AS Estado \n       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n       ,pp_movimiento.IdDisponibilidad\n       ,pp_movimiento.IdCompromiso\n       ,pp_detalle_movimiento.Id_Rubro\n       ,pp_rubros.`Nbre` AS NombreRubro\n       ,pp_detalle_movimiento.Id_Tercero\n       , IF(cc_terceros.`Id_TipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n      FROM pp_movimiento  \n                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \n                INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n                WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n      GROUP BY pp_movimiento.IdCompromiso, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n      ORDER BY pp_movimiento.FechaD DESC) D\n      LEFT JOIN \n     (SELECT  pp_movimiento.IdDisponibilidad\n      , pp_movimiento.IdCompromiso\n      , pp_detalle_movimiento.Id_Rubro\n      , pp_detalle_movimiento.Id_Tercero\n   ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n        FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n        WHERE pp_tipo_documentos.Id_ClaseDoc IN (5) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n        GROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n  , pp_detalle_movimiento.Id_Rubro\n  , pp_detalle_movimiento.Id_Tercero\n      ) C\n     ON  D.IdCompromiso=C.IdCompromiso \n     AND D.Id_Rubro=C.Id_Rubro \n     AND D.Id_Tercero=C.Id_Tercero\n WHERE (D.IdCompromiso='" + getxIdCompromiso() + "' )\n     ORDER BY  D.IdCompromiso DESC, D.FechaD DESC";
            System.out.println("consulta que carga el detalle -> " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        if (xrs.getDouble("Por_Obligacion") > 0.0d) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs.getString("Id_rubro"), n, 0);
                            this.xmodelo.setValueAt(xrs.getString("NombreRubro"), n, 1);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Compromiso")), n, 2);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Obligacion")), n, 3);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Por_Obligacion")), n, 4);
                            this.xmodelo.setValueAt(xrs.getString("Id_Tercero"), n, 5);
                            this.xmodelo.setValueAt(xrs.getString("NTercero"), n, 6);
                            this.xmodelo.setValueAt(false, n, 7);
                            n++;
                        }
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFFMovManualOP_PP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("6")) {
            mCrearModeloDatosPago();
            String sql2 = "SELECT OP.NoConcecutivo\n, OP.IdCompromiso\n,OP.IdObligacion\n,OP.FechaD\n,OP.TipoDoc\n,OP.Observacion\n,OP.Id_Tercero\n,OP.NTercero \n,OP.Id_rubro\n,OP.NombreRubro\n,OP.Obligacion\n,IFNULL(PP.Pago,0) Pagado\n,(OP.Obligacion-IFNULL(PP.Pago,0)) Por_Pagar\n,Estado\n\n FROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n       , pp_tipo_documentos.Nbre AS TipoDoc \n       , IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n       , g_motivoanulacion.Nbre AS Estado \n       ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n       ,pp_movimiento.IdCompromiso\n       , pp_movimiento.`IdObligacion`\n       ,pp_detalle_movimiento.Id_Rubro\n       ,pp_rubros.`Nbre` AS NombreRubro\n       ,pp_detalle_movimiento.Id_Tercero\n       , IF(cc_terceros.`Id_TipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n      FROM pp_movimiento  \n                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`)\n                INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n                WHERE pp_tipo_documentos.Id_ClaseDoc IN (5) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n      GROUP BY pp_movimiento.IdObligacion, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n      ORDER BY pp_movimiento.FechaD DESC) OP\n      LEFT JOIN \n     (SELECT pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n      , pp_detalle_movimiento.Id_Rubro\n      , pp_detalle_movimiento.Id_Tercero\n   ,SUM(pp_detalle_movimiento.Valor) PAGO\n        FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n        WHERE pp_tipo_documentos.Id_ClaseDoc IN (6) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n        GROUP BY pp_movimiento.IdCompromiso, pp_movimiento.`IdObligacion`\n  , pp_detalle_movimiento.Id_Rubro\n  , pp_detalle_movimiento.Id_Tercero\n      ) PP\n     ON OP.IdObligacion=PP.IdObligacion \n     AND OP.Id_Rubro=PP.Id_Rubro \n     AND OP.Id_Tercero=PP.Id_Tercero\n     WHERE OP.IdObligacion='" + getxIdCompromiso() + "'\n      and OP.NoConcecutivo = '" + this.JLCodigoDoc.getText() + "'      ORDER BY  OP.IdObligacion DESC, OP.FechaD DESC";
            System.out.println("consulta detalle ----- > " + sql2);
            ResultSet xrs2 = this.xct.traerRs(sql2);
            try {
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    int n2 = 0;
                    while (xrs2.next()) {
                        if (xrs2.getDouble("Por_Pagar") != 0.0d) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(xrs2.getString("Id_rubro"), n2, 0);
                            this.xmodelo.setValueAt(xrs2.getString("NombreRubro"), n2, 1);
                            this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble("Obligacion")), n2, 2);
                            this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble("Pagado")), n2, 3);
                            this.xmodelo.setValueAt(Double.valueOf(xrs2.getDouble("Por_Pagar")), n2, 4);
                            this.xmodelo.setValueAt(xrs2.getString("Id_Tercero"), n2, 5);
                            this.xmodelo.setValueAt(xrs2.getString("NTercero"), n2, 6);
                            this.xmodelo.setValueAt(false, n2, 7);
                            n2++;
                        }
                    }
                }
                xrs2.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex2) {
                Logger.getLogger(JIFFMovManualOP_PP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void mGrabar() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()))) {
            if (this.JCTipoDocumento.getSelectedIndex() > -1) {
                if (this.JTDetalle.getRowCount() > 0) {
                    if (getxIdCompromiso() != null) {
                        if (mVerificaChulo()) {
                            if (Principal.txtNo.getText().isEmpty()) {
                                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    mConcecutivo();
                                    if (!this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("5")) {
                                        if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("6")) {
                                            String sql = "INSERT INTO `pp_movimiento`\n            (`Id_Periodo`,\n             `Id_TipoDoc`,\n             `NoConcecutivo`,\n             `FechaD`,\n             `Observacion`,\n             `IdUsuarioR`,\n             `IdCompromiso`,\n             `IdObligacion`,\n             `UsuarioS`)\nVALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',\n        '" + this.xCombo[this.JCTipoDocumento.getSelectedIndex()][0] + "',\n        '" + this.xConsecutivo + "',\n        '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "',\n        '" + this.JTAObservacion.getText() + "',\n        '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "',\n        '" + this.xIdCompromisoObli + "',\n        '" + getxIdCompromiso() + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                            String xIdMovimiento = this.xct.ejecutarSQLId(sql);
                                            this.xct.cerrarConexionBd();
                                            Principal.txtNo.setText(xIdMovimiento);
                                            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 7).toString()).booleanValue()) {
                                                    String sqlD = "INSERT INTO `pp_detalle_movimiento`\n            (`Id_Movimiento`,\n             `Id_Rubro`,\n             `Id_Tercero`,\n             `Valor`,\n             `idEncabezado`,\n             `Observacion`)\nVALUES ('" + xIdMovimiento + "',\n        '" + this.xmodelo.getValueAt(i, 0) + "',\n        '" + this.xmodelo.getValueAt(i, 5) + "',\n        '" + this.xmodelo.getValueAt(i, 4) + "',\n        '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "',\n        '" + this.JTAObservacion.getText() + "');";
                                                    this.xct.ejecutarSQL(sqlD);
                                                    this.xct.cerrarConexionBd();
                                                }
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    String sql2 = "INSERT INTO `pp_movimiento`\n            (`Id_Periodo`,\n             `Id_TipoDoc`,\n             `NoConcecutivo`,\n             `FechaD`,\n             `Observacion`,\n             `IdUsuarioR`,\n             `IdCompromiso`,\n             `UsuarioS`)\nVALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "',\n        '" + this.xCombo[this.JCTipoDocumento.getSelectedIndex()][0] + "',\n        '" + this.xConsecutivo + "',\n        '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "',\n        '" + this.JTAObservacion.getText() + "',\n        '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "',\n        '" + getxIdCompromiso() + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                    String xIdMovimiento2 = this.xct.ejecutarSQLId(sql2);
                                    this.xct.cerrarConexionBd();
                                    Principal.txtNo.setText(xIdMovimiento2);
                                    for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                        if (Boolean.valueOf(this.xmodelo.getValueAt(i2, 7).toString()).booleanValue()) {
                                            String sqlD2 = "INSERT INTO `pp_detalle_movimiento`\n            (`Id_Movimiento`,\n             `Id_Rubro`,\n             `Id_Tercero`,\n             `Valor`,\n             `idEncabezado`,\n             `Observacion`)\nVALUES ('" + xIdMovimiento2 + "',\n        '" + this.xmodelo.getValueAt(i2, 0) + "',\n        '" + this.xmodelo.getValueAt(i2, 5) + "',\n        '" + this.xmodelo.getValueAt(i2, 4) + "',\n        '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "',\n        '" + this.JTAObservacion.getText() + "');";
                                            this.xct.ejecutarSQL(sqlD2);
                                            this.xct.cerrarConexionBd();
                                        }
                                        String sqlU = "UPDATE `pp_movimiento` SET `IdObligacion` = '" + xIdMovimiento2 + "' WHERE `Id` = '" + xIdMovimiento2 + "';";
                                        this.xct.ejecutarSQL(sqlU);
                                        this.xct.cerrarConexionBd();
                                    }
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "No puede volver a guardar movimiento " + Principal.txtNo.getText(), "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("5")) {
                            JOptionPane.showMessageDialog(this, "Verifique que:\n1-Tenga por lo menos un registro seleccionado de la tabla\n2-Que el valor del rubro a Obligar sea mayor que cero\n3-Que el valor del rubro a Obligar sea menor o igual que lo Comprometido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        } else {
                            if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("6")) {
                                JOptionPane.showMessageDialog(this, "Verifique que:\n1-Tenga por lo menos un registro seleccionado de la tabla\n2-Que el valor del rubro a Pagar sea mayor que cero\n3-Que el valor del rubro a Pagar sea menor o igual que lo Obligado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Debe Cagar un movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe Cargar datos a la tabla seleccionado rubros de un movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCTipoDocumento.requestFocus();
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='" + this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1] + "'  AND  pp_tipo_documentos.`Id`='" + this.xCombo[this.JCTipoDocumento.getSelectedIndex()][0] + "') GROUP BY `pp_tipo_documentos`.`Id_ClaseDoc`,  pp_tipo_documentos.`Id`";
        System.out.println("Consecutivo ->" + sql);
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

    private boolean mVerificaChulo() {
        boolean xVerificado = false;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 7).toString()).booleanValue()) {
                if (Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue() > 0.0d && Double.valueOf(this.xmodelo.getValueAt(i, 4).toString()).doubleValue() <= Double.valueOf(this.xmodelo.getValueAt(i, 2).toString()).doubleValue()) {
                    xVerificado = true;
                } else {
                    xVerificado = false;
                    break;
                }
            }
        }
        return xVerificado;
    }

    public void mBuscar() {
        JDBusquedaMovPTO x = new JDBusquedaMovPTO((Frame) null, true, this, this.xIdClaseDoc);
        x.setVisible(true);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        setxIdCompromiso(null);
        this.xConsecutivo = 0;
        this.xIdCompromisoObli = "";
        this.JLCodigoDoc.setText("");
        this.JTAObservacion.setText("");
        this.JLValor.setValue(0);
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("5")) {
            mCrearModeloDatosDisponibilidad();
        } else if (this.xCombo[this.JCTipoDocumento.getSelectedIndex()][1].equals("6")) {
            mCrearModeloDatosPago();
        }
        this.JCTipoDocumento.setSelectedIndex(-1);
    }
}
