package Presupuesto;

import Acceso.Principal;
import General.ImportFile_xlsx;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFCarguePTOInicial.class */
public class JIFFCarguePTOInicial extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloHt;
    public DefaultTableModel modeloPresupuestoExcel;
    private Object[] xdatos;
    private String[][] xIdDocumento;
    private ImportFile_xlsx modelKLJ;
    private JButton JBAdicion;
    private JButton JBBloqueo;
    private JButton JBImportar;
    private JButton JBReintegro;
    private JButton JBTraslados;
    private JComboBox JCBTipoDocumento;
    private JLabel JLBloqueo;
    private JSpinner JSPPorcentaje;
    public JTable JTDetalle;
    private JTable JTDetalleHistorico;
    public JTextArea JTObservacion;
    private JCheckBox jCheckBox1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFecha;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private JFileChooser FileChooser = new JFileChooser();
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private String xRubroEquivocado = "";
    private int xBloqueo = 0;

    public JIFFCarguePTOInicial() {
        initComponents();
        mCrearModeloDatos();
        this.txtFecha.setDate(this.xmt.getFechaActual());
        mInicia();
        mBuscaDatosHist();
    }

    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JCBTipoDocumento = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTObservacion = new JTextArea();
        this.JSPPorcentaje = new JSpinner();
        this.jCheckBox1 = new JCheckBox();
        this.JLBloqueo = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBImportar = new JButton();
        this.jPanel5 = new JPanel();
        this.JBReintegro = new JButton();
        this.JBAdicion = new JButton();
        this.JBTraslados = new JButton();
        this.JBBloqueo = new JButton();
        this.jPanel3 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CARGUE DE PRESUPUESTO INICIAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifPTOInicial");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFCarguePTOInicial.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFCarguePTOInicial.this.formInternalFrameClosing(evt);
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
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFCarguePTOInicial.2
            public void keyPressed(KeyEvent evt) {
                JIFFCarguePTOInicial.this.txtFechaKeyPressed(evt);
            }
        });
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFCarguePTOInicial.3
            public void itemStateChanged(ItemEvent evt) {
                JIFFCarguePTOInicial.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JCBTipoDocumento.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.4
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JCBTipoDocumentoActionPerformed(evt);
            }
        });
        this.JTObservacion.setColumns(1);
        this.JTObservacion.setFont(new Font("Arial", 1, 12));
        this.JTObservacion.setRows(1);
        this.JTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTObservacion);
        this.JSPPorcentaje.setFont(new Font("Arial", 1, 12));
        this.JSPPorcentaje.setToolTipText("Porcentaje a Valores");
        this.JSPPorcentaje.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setText("Aplicar % a Valores");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.5
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.JLBloqueo.setFont(new Font("Arial", 1, 14));
        this.JLBloqueo.setForeground(Color.red);
        this.JLBloqueo.setHorizontalAlignment(0);
        this.JLBloqueo.setToolTipText("Estado PTO Inicial");
        this.JLBloqueo.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, -2, 444, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPorcentaje, -2, 71, -2).addComponent(this.jCheckBox1))).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBloqueo, -2, 137, -2)))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.jScrollPane1, -2, 580, -2).addContainerGap(168, 32767))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocumento, -1, 52, 32767).addComponent(this.JLBloqueo, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCheckBox1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPPorcentaje, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 50, -2).addGap(0, 0, 32767))).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.jScrollPane1, -2, 63, -2).addContainerGap(-1, 32767))));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFCarguePTOInicial.6
            public void mouseClicked(MouseEvent evt) {
                JIFFCarguePTOInicial.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBImportar.setFont(new Font("Arial", 1, 12));
        this.JBImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImportar.setText("Importar Archivo de Excel");
        this.JBImportar.setToolTipText("");
        this.JBImportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.7
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JBImportarActionPerformed(evt);
            }
        });
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Operaciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBReintegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.JBReintegro.setToolTipText("Reducción");
        this.JBReintegro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.8
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JBReintegroActionPerformed(evt);
            }
        });
        this.JBAdicion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBAdicion.setToolTipText("Adición");
        this.JBAdicion.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.9
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JBAdicionActionPerformed(evt);
            }
        });
        this.JBTraslados.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cuentasxempresa.png")));
        this.JBTraslados.setToolTipText("Traslados");
        this.JBTraslados.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.10
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JBTrasladosActionPerformed(evt);
            }
        });
        this.JBBloqueo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/bloqueo.png")));
        this.JBBloqueo.setToolTipText("Bloquear Presupuesto Inicial");
        this.JBBloqueo.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFCarguePTOInicial.11
            public void actionPerformed(ActionEvent evt) {
                JIFFCarguePTOInicial.this.JBBloqueoActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JBReintegro, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicion, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTraslados, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBloqueo, -2, 49, -2).addContainerGap(166, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBAdicion, -1, -1, 32767).addComponent(this.JBReintegro, -1, -1, 32767).addComponent(this.JBTraslados, -2, 0, 32767).addComponent(this.JBBloqueo, -2, 0, 32767)).addContainerGap(8, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JBImportar, -2, 268, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addGap(0, 95, 32767)).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 333, -2).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel5, -2, -1, -2).addComponent(this.JBImportar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel2);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 11));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(Color.red);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFCarguePTOInicial.12
            public void mouseClicked(MouseEvent evt) {
                JIFFCarguePTOInicial.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalleHistorico);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane3, -1, 573, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jTabbedPane1, -2, 620, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    public void mBuscaMovimiento(String xId) {
        String sql;
        mCrearModeloDatos();
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
            sql = "SELECT `pp_movimiento`.`Id` AS IdMovimiento, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS TipoDocumento, `pp_movimiento`.`Observacion`, pp_movimiento.Bloqueo \n    , `pp_detalle_movimiento`.`Id_Rubro`,`pp_rubros`.`Cod_Alterno`, concat(idpadre.Nbre , ' - ', `pp_rubros`.`Nbre`) AS NombreRubro, `pp_detalle_movimiento`.`Valor`, `pp_detalle_movimiento`.`Id_Tercero`,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero \n    , `pp_detalle_movimiento`.`Observacion` AS ObsDetalle, `pp_detalle_movimiento`.`Estado`, pp_movimiento.IdSolicitud, pp_movimiento.IdDisponibilidad \n FROM `pp_detalle_movimiento` INNER JOIN   `pp_movimiento` ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN   `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n    INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n    inner join pp_rubros idpadre on (idpadre.id=pp_rubros.IdPadre)  \n WHERE (`pp_movimiento`.`Id` ='" + xId + "' AND pp_movimiento.Id_MotivoAnulacion=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC;";
        } else {
            sql = "SELECT `pp_movimiento`.`Id` AS IdMovimiento, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS TipoDocumento, `pp_movimiento`.`Observacion`, pp_movimiento.Bloqueo \n    , `pp_detalle_movimiento`.`Id_Rubro`,`pp_rubros`.`Cod_Alterno`, `pp_rubros`.`Nbre` AS NombreRubro, `pp_detalle_movimiento`.`Valor`, `pp_detalle_movimiento`.`Id_Tercero`,IF(`g_empresa`.Nbre='',CONCAT(`g_empresa`.Apellido1,' ',`g_empresa`.Apellido2,' ',`g_empresa`.Nombre1,' ',`g_empresa`.Nombre2),`g_empresa`.Nbre) AS NTercero \n    , `pp_detalle_movimiento`.`Observacion` AS ObsDetalle, `pp_detalle_movimiento`.`Estado`, pp_movimiento.IdSolicitud, pp_movimiento.IdDisponibilidad \n FROM `pp_detalle_movimiento` INNER JOIN   `pp_movimiento` ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN   `pp_rubros`   ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN   `g_empresa`   ON (`pp_detalle_movimiento`.`Id_Tercero` = `g_empresa`.`Id`)\n    INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE (`pp_movimiento`.`Id` ='" + xId + "' AND pp_movimiento.Id_MotivoAnulacion=1 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "') ORDER BY `pp_detalle_movimiento`.`Id_Rubro` ASC;";
        }
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs = xct2.traerRs(sql);
        System.out.println("Movimiento-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString("IdMovimiento"));
                this.txtFecha.setDate(xrs.getDate("FechaD"));
                this.JCBTipoDocumento.setSelectedItem(xrs.getString("TipoDocumento"));
                this.JTObservacion.setText(xrs.getString("Observacion"));
                this.xBloqueo = xrs.getInt("Bloqueo");
                if (this.xBloqueo == 0) {
                    this.JLBloqueo.setText("ACTIVO");
                    this.JBBloqueo.setEnabled(true);
                } else {
                    this.JLBloqueo.setText("BLOQUEADO");
                    this.JBBloqueo.setEnabled(false);
                }
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id_Rubro"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Cod_Alterno"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("NombreRubro"), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), n, 3);
                    n++;
                }
            }
            xrs.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImportarActionPerformed(ActionEvent evt) {
        Importar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            mBuscaMovimiento(this.xmodeloHt.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString());
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            mAplicaPorcentaje();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBReintegroActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDReduccionPTOInicial x = new JDReduccionPTOInicial(null, true, this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDAdicionesPTOInicial x = new JDAdicionesPTOInicial(null, true, this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTrasladosActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDTrasladoPTOInicial x = new JDTrasladoPTOInicial(null, true, this);
            x.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debe cargar un Movimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBloqueoActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de Bloquear el PTO Inicial?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE pp_movimiento SET Bloqueo=1 WHERE Id='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            this.xBloqueo = 1;
            this.JBBloqueo.setEnabled(false);
            this.JLBloqueo.setText("BLOQUEADO");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoActionPerformed(ActionEvent evt) {
    }

    private void Importar() {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        if (!file.getName().endsWith("xlsx")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel con la extensión 'xlsx'...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        try {
            this.modelKLJ = new ImportFile_xlsx();
            this.modelKLJ.Importar(file, this.JTDetalle);
        } catch (Exception ex) {
            Logger.getLogger(JIFFCarguePTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void CrearTabla(File file) throws IOException {
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            this.columna.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                this.columna.add(cell1.getContents());
            }
            this.filas.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                    Cell cell = sheet.getCell(i2, j);
                    if (i2 == 3) {
                        d.add(Double.valueOf(cell.getContents().replaceAll(",", ".")));
                    } else {
                        d.add(cell.getContents());
                    }
                }
                d.add("\n");
                this.xmodelo.addRow(d);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    private boolean mVerificaUltNivel() {
        this.modeloPresupuestoExcel = this.modelKLJ.getModeloT();
        this.JTDetalle.setModel(this.modeloPresupuestoExcel);
        boolean xOk = false;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            String sql = "SELECT `Id`,`UltNivel` FROM `pp_rubros` WHERE Id='" + this.modeloPresupuestoExcel.getValueAt(i, 0).toString() + "' AND idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'";
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getInt("UltNivel") == 0) {
                        xOk = true;
                        this.xRubroEquivocado = xrs.getString("Id");
                        break;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFFCarguePTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xOk;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdRubro", "Cod.Alterno", "Nombre", "Valor"}) { // from class: Presupuesto.JIFFCarguePTOInicial.13
            Class[] types = {String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mInicia() {
        this.xIdDocumento = this.xct.llenarComboyLista("SELECT pp_tipo_documentos.Id AS IdDoc, pp_tipo_documentos.Nbre AS NombreDoc,pp_tipo_documentos.Id_ClaseDoc,pp_clase_documento.`Nbre` AS NombreClaseDoc,pp_clase_documento.`IdPadre` FROM `pp_tipo_documentos`  INNER JOIN `pp_clase_documento` \n        ON (`pp_tipo_documentos`.`Id_ClaseDoc` = `pp_clase_documento`.`Id`)WHERE (pp_tipo_documentos.Estado=1  AND pp_tipo_documentos.Id_ClaseDoc=1) ORDER BY pp_tipo_documentos.Nbre ASC", this.xIdDocumento, this.JCBTipoDocumento, 5);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private boolean mVerificaExistenciaPtoInicial() {
        String AnioActual = this.xmt.formatoANO.format(this.xmt.getFechaActual());
        boolean xexiste = false;
        String sql = "SELECT `pp_movimiento`.`Id`\nFROM  `pp_movimiento` INNER JOIN `pp_tipo_documentos`   ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n\t\t      INNER JOIN `pp_periodo`  ON (`pp_movimiento`.`Id_Periodo` = `pp_periodo`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` =1 AND DATE_FORMAT(`pp_periodo`.`FechaI`,'%Y')='" + AnioActual + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFCarguePTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    public void mGrabar() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.txtFecha.getDate()))) {
            if (Principal.txtNo.getText().isEmpty()) {
                if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                    if (this.JTDetalle.getRowCount() > 0) {
                        if (!mVerificaUltNivel()) {
                            if (!mVerificaExistenciaPtoInicial()) {
                                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    String sql = "INSERT INTO `pp_movimiento` ( `Id_Periodo`,`Id_TipoDoc`,`FechaD`,`Observacion`,IdUsuarioR, `UsuarioS`)  VALUES ( '" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "','" + this.xIdDocumento[this.JCBTipoDocumento.getSelectedIndex()][0] + "','" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.JTObservacion.getText() + "' ,'" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                    System.out.println("Inserta Encabezado Mov-->" + sql);
                                    String xCargue = this.xct.ejecutarSQLId(sql);
                                    Principal.txtNo.setText(xCargue);
                                    this.xct.cerrarConexionBd();
                                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                        String sqld = " insert into  `pp_detalle_movimiento` (`idEncabezado`, `Id_Movimiento`,`Id_Rubro`,`Id_Tercero`,`idRubrosFunteFinanciacion`, `idRubrosCentroCostos`, `idRubrosCpc`, `idTopoVigencia`, `Valor`,`Observacion`,)\n values ('" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "','" + xCargue + "', '" + this.JTDetalle.getValueAt(i, 0) + "','" + Principal.informacionIps.getIdEmpresa() + "','" + this.JTDetalle.getValueAt(i, 10) + "','" + this.JTDetalle.getValueAt(i, 11) + "','" + this.JTDetalle.getValueAt(i, 1) + "','" + this.JTDetalle.getValueAt(i, 5) + "','" + this.JTDetalle.getValueAt(i, 3) + "','" + this.JTObservacion.getText() + "');";
                                        this.xct.ejecutarSQL(sqld);
                                        this.xct.cerrarConexionBd();
                                    }
                                    mBuscaDatosHist();
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Ya existe un Presupuesto Inicial en el presente año", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "El rubro " + this.xRubroEquivocado + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDocumento.requestFocus();
                return;
            }
            System.out.println("xBloqueo-->" + this.xBloqueo);
            if (this.xBloqueo == 0) {
                int n2 = JOptionPane.showConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                        String sql2 = "UPDATE `pp_movimiento` SET   `Observacion` = '" + this.JTObservacion.getText() + "'    \nWHERE `Id` = '" + Principal.txtNo.getText() + "' ";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        String sql3 = "UPDATE `pp_detalle_movimiento` SET   `Valor` = '" + this.xmodelo.getValueAt(i2, 3) + "'    \nWHERE `Id_Movimiento` = '" + Principal.txtNo.getText() + "' AND Id_Rubro='" + this.xmodelo.getValueAt(i2, 0) + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' ";
                        this.xct.ejecutarSQL(sql3);
                        this.xct.cerrarConexionBd();
                    }
                    mBuscaMovimiento(Principal.txtNo.getText());
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "No se puede actualizar, presupuesto está bloqueado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mBuscaDatosHist() {
        mCrearModeloDatosHist();
        String sql = "SELECT `pp_movimiento`.`Id`, `pp_movimiento`.`FechaD`, `pp_tipo_documentos`.`Nbre` AS Documento, `pp_movimiento`.`Observacion`, `g_motivoanulacion`.`Nbre` AS Anulacion, pp_periodo.Nbre AS Periodo, DATE_FORMAT(pp_periodo.FechaI,'%Y') AS Anio \n FROM `pp_movimiento` INNER JOIN   `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n INNER JOIN   `g_motivoanulacion`  ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`)\n INNER JOIN   `pp_periodo`  ON (`pp_movimiento`.`Id_Periodo` = pp_periodo.`Id`)  WHERE(pp_tipo_documentos.Id_ClaseDoc=1 and  DATE_FORMAT(pp_periodo.FechaI,'%Y')='" + this.xmt.mDevuelveAnnoPpt() + "' ) ORDER BY `pp_movimiento`.`Id`DESC, `pp_movimiento`.`FechaD` DESC ";
        System.out.println("Movimientos-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodeloHt.addRow(this.xdatos);
                    this.xmodeloHt.setValueAt(xrsB.getString("Id"), n, 0);
                    this.xmodeloHt.setValueAt(xrsB.getString("FechaD"), n, 1);
                    this.xmodeloHt.setValueAt(xrsB.getString("Documento"), n, 2);
                    this.xmodeloHt.setValueAt(xrsB.getString("Observacion"), n, 3);
                    this.xmodeloHt.setValueAt(xrsB.getString("Anulacion"), n, 4);
                    this.xmodeloHt.setValueAt(xrsB.getString("Periodo"), n, 5);
                    this.xmodeloHt.setValueAt(xrsB.getString("Anio"), n, 6);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosHist() {
        this.xmodeloHt = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Documento", "Observación", "Estado", "Periodo", "Año"}) { // from class: Presupuesto.JIFFCarguePTOInicial.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloHt);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalleHistorico.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalleHistorico.getColumnModel().getColumn(6).setPreferredWidth(15);
    }

    private void mAplicaPorcentaje() {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            double x = (Double.parseDouble(this.xmodelo.getValueAt(i, 3).toString()) * Double.parseDouble(this.JSPPorcentaje.getValue().toString())) / 100.0d;
            double xResultado = Double.parseDouble(this.xmodelo.getValueAt(i, 3).toString()) + x;
            this.xmodelo.setValueAt(Double.valueOf(xResultado), i, 3);
        }
    }
}
