package Caja;

import Acceso.Principal;
import Facturacion.Facturac;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Caja/JIF_Cierre_Caja.class */
public class JIF_Cierre_Caja extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String[] xId_Caja;
    private Object[] xDato;
    private Facturac xJif_Facturac;
    private JButton JBTExportar;
    private JComboBox JCBCaja;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDCaja;
    private JPanel JPIDatos;
    private JPanel JPIHistorico;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPDetalle2;
    private JScrollPane JSPObservacionC;
    private JTextArea JTAObservacion;
    public JTable JTB_Detalle;
    public JTable JTB_Detalle1;
    public JTable JTB_Detalle2;
    private JFormattedTextField JTFF_TotalCierre;
    private JFormattedTextField JTFF_TotalCierres;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;

    public JIF_Cierre_Caja(Facturac frm) {
        initComponents();
        this.xJif_Facturac = frm;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JPIDCaja = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBCaja = new JComboBox();
        this.JTFF_TotalCierre = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTB_Detalle1 = new JTable();
        this.JSPObservacionC = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JPIHistorico = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTB_Detalle2 = new JTable();
        this.JTFF_TotalCierres = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRE DE CAJA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_cierre_caja");
        addInternalFrameListener(new InternalFrameListener() { // from class: Caja.JIF_Cierre_Caja.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_Cierre_Caja.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIF_Cierre_Caja.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Cierre_Caja.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JIF_Cierre_Caja.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Cierre_Caja.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBCaja.setFont(new Font("Arial", 1, 12));
        this.JCBCaja.setBorder(BorderFactory.createTitledBorder((Border) null, "Caja", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TotalCierre.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_TotalCierre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JTFF_TotalCierre.setHorizontalAlignment(4);
        this.JTFF_TotalCierre.setDisabledTextColor(new Color(0, 51, 153));
        this.JTFF_TotalCierre.setFont(new Font("Arial", 1, 18));
        this.JTFF_TotalCierre.setValue(0);
        GroupLayout JPIDCajaLayout = new GroupLayout(this.JPIDCaja);
        this.JPIDCaja.setLayout(JPIDCajaLayout);
        JPIDCajaLayout.setHorizontalGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBCaja, -2, 403, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_TotalCierre).addContainerGap()));
        JPIDCajaLayout.setVerticalGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGroup(JPIDCajaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCaja, -2, 50, -2).addComponent(this.JTFF_TotalCierre, -2, 50, -2))).addContainerGap(17, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTB_Detalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle.setEditingColumn(1);
        this.JTB_Detalle.setEditingRow(1);
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: Caja.JIF_Cierre_Caja.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Cierre_Caja.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTB_Detalle);
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO POR CONCEPTO DE PAGO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTB_Detalle1.setBorder(BorderFactory.createBevelBorder(0));
        this.JTB_Detalle1.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle1.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle1.setEditingColumn(1);
        this.JTB_Detalle1.setEditingRow(1);
        this.JTB_Detalle1.setRowHeight(25);
        this.JTB_Detalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle1.setSelectionForeground(Color.red);
        this.JSPDetalle1.setViewportView(this.JTB_Detalle1);
        this.JSPObservacionC.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacionC.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JSPObservacionC.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDCaja, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPDetalle1, -2, 387, -2).addGap(39, 39, 39).addComponent(this.JSPObservacionC, -2, 395, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDCaja, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 245, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle1, -1, 93, 32767).addComponent(this.JSPObservacionC)).addContainerGap()));
        this.JTPDatos.addTab("CIERRE", this.JPIDatos);
        this.JSPDetalle2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTB_Detalle2.setBorder(BorderFactory.createBevelBorder(0));
        this.JTB_Detalle2.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle2.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Detalle2.setEditingColumn(1);
        this.JTB_Detalle2.setEditingRow(1);
        this.JTB_Detalle2.setRowHeight(25);
        this.JTB_Detalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle2.setSelectionForeground(Color.red);
        this.JTB_Detalle2.addMouseListener(new MouseAdapter() { // from class: Caja.JIF_Cierre_Caja.5
            public void mouseClicked(MouseEvent evt) {
                JIF_Cierre_Caja.this.JTB_Detalle2MouseClicked(evt);
            }
        });
        this.JSPDetalle2.setViewportView(this.JTB_Detalle2);
        this.JTFF_TotalCierres.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_TotalCierres.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JTFF_TotalCierres.setHorizontalAlignment(4);
        this.JTFF_TotalCierres.setDisabledTextColor(new Color(0, 51, 153));
        this.JTFF_TotalCierres.setFont(new Font("Arial", 1, 18));
        this.JTFF_TotalCierres.setValue(0);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Caja.JIF_Cierre_Caja.6
            public void mouseClicked(MouseEvent evt) {
                JIF_Cierre_Caja.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Caja.JIF_Cierre_Caja.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Cierre_Caja.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIHistoricoLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 419, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 218, -2).addGap(34, 34, 34).addComponent(this.JTFF_TotalCierres, -2, 144, -2)).addComponent(this.JSPDetalle2, -2, 831, -2)).addGap(0, 0, 32767)));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap(18, 32767).addComponent(this.JSPDetalle2, -2, 403, -2).addGap(18, 18, 18).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFF_TotalCierres, -2, 50, -2)).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPIHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 845, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_Detalle2MouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle2.getSelectedRow() != -1) {
            mImprimir(this.xmodelo2.getValueAt(this.JTB_Detalle2.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle2.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle2, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JTB_Detalle.getRowCount() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into k_cierre_n(`Id_Caja` , `Id_Usuario` , `FechaI`  , `FechaF` , `Observacion` , `Valor`  , `UsuarioS` ) values('" + this.xId_Caja[this.JCBCaja.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "','" + this.JTAObservacion.getText() + "','" + this.JTFF_TotalCierre.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTB_Detalle.getRowCount(); y++) {
                        this.xsql = "update k_recibos_n set Id_Cierre='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar recibos para cerrar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    public void mBuscar() {
        if (this.JCBCaja.getSelectedIndex() != -1) {
            mCargar_DatosRecibo();
            mCargar_DatosConsolidado();
            mCargar_DatosHistorico();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTAObservacion.setText("");
        this.JTFF_TotalCierre.setValue(new Double(0.0d));
        mCrearTablaDetalle();
        mCrearTablaConsolidado();
        mCrearTablaHistorico();
        this.xlleno = true;
    }

    private void mLLenarCombo() {
        this.JCBCaja.removeAllItems();
        this.xsql = "SELECT  `k_caja`.`Id` , `k_caja`.`Nbre` FROM `k_recibos_n` INNER JOIN  `k_caja`  ON (`k_recibos_n`.`Id_Caja` = `k_caja`.`Id`) WHERE (`k_recibos_n`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `k_recibos_n`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `k_recibos_n`.`Estado` =1 and `k_recibos_n`.`Id_UsuarioS`='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "') GROUP BY `k_caja`.`Id` ORDER BY `k_caja`.`Nbre` ASC  ";
        this.xId_Caja = this.xct.llenarCombo(this.xsql, this.xId_Caja, this.JCBCaja);
        this.xct.cerrarConexionBd();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "N° Recibo", "Fecha", "Usuario", "Forma Pago", "N° Transacción", "V/Descuento", "V/Total"}) { // from class: Caja.JIF_Cierre_Caja.8
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    private void mCrearTablaConsolidado() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Concepto", "Valor"}) { // from class: Caja.JIF_Cierre_Caja.9
            Class[] types = {String.class, Double.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle1.setModel(this.xmodelo1);
        this.JTB_Detalle1.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Detalle1.getColumnModel().getColumn(1).setPreferredWidth(30);
    }

    private void mCrearTablaHistorico() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Caja", "Cajero", "F_Inicial", "F_Final", "Valor", "Observacion", "Id_Doc", "Estado"}) { // from class: Caja.JIF_Cierre_Caja.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Double.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle2.setModel(this.xmodelo2);
        this.JTB_Detalle2.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Detalle2.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_Detalle2.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Detalle2.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTB_Detalle2.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTB_Detalle2.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTB_Detalle2.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTB_Detalle2.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTB_Detalle2.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    private void mCargar_DatosRecibo() {
        try {
            mCrearTablaDetalle();
            this.xsql = "SELECT `k_recibos_n`.`Id`, `k_recibos_n`.`NoRecibo`, DATE_FORMAT(`k_recibos_n`.`FechaR`,'%d-%m-%Y') AS `Fecha`, CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2`) AS `NUsuario` , `k_formapago`.`Nbre`, `k_recibos_n`.`NTransaccion`, `k_recibos_n`.`VDescuento`, `k_recibos_n`.`Valor` FROM  `k_recibos_n` INNER JOIN `g_persona`  ON (`k_recibos_n`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN `k_formapago`  ON (`k_recibos_n`.`Id_FPago` = `k_formapago`.`Id`) WHERE (`k_recibos_n`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `k_recibos_n`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `k_recibos_n`.`Estado` =1 AND `k_recibos_n`.`Id_UsuarioS` ='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' and `k_recibos_n`.Id_Cierre=0  and `k_recibos_n`.`Id_Caja` ='" + this.xJif_Facturac.clasecaja.getIdCaja() + "') ORDER BY `k_recibos_n`.`NoRecibo` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xDato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), xnfila, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), xnfila, 7);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_ReciboCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_DatosConsolidado() {
        try {
            mCrearTablaConsolidado();
            this.xsql = "SELECT `k_formapago`.`Nbre` , SUM(`k_recibos_n`.`Valor`) AS Valor FROM  `k_recibos_n` INNER JOIN `g_persona`  ON (`k_recibos_n`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN `k_formapago`  ON (`k_recibos_n`.`Id_FPago` = `k_formapago`.`Id`) WHERE (`k_recibos_n`.`FechaR` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' and `k_recibos_n`.Id_Cierre=0 AND `k_recibos_n`.`FechaR` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `k_recibos_n`.`Estado` =1 AND `k_recibos_n`.`Id_UsuarioS` ='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' and `k_recibos_n`.`Id_Caja` ='" + this.xJif_Facturac.clasecaja.getIdCaja() + "')  GROUP BY `k_formapago`.`Id` ORDER BY `k_recibos_n`.`NoRecibo` ASC, `k_formapago`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            double xvalor = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xDato);
                    this.xmodelo1.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(2)), xnfila, 1);
                    xvalor += xrs.getDouble(2);
                    xnfila++;
                }
            }
            this.JTFF_TotalCierre.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_ReciboCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_DatosHistorico() {
        try {
            mCrearTablaHistorico();
            this.xsql = "SELECT  `k_cierre_n`.`Id` AS `Id_Cierre` , `k_caja`.`Nbre` AS `NCaja` , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NCajero`  , `k_cierre_n`.`FechaI` AS `FCierre_Inicial` , `k_cierre_n`.`FechaF` AS `FCierre_Final` , `k_cierre_n`.`Valor` AS `VTotalCierre` , `k_cierre_n`.`Observacion` AS `ObservacionCierre` , `k_cierre_n`.`Id_DocumentoC` , `k_cierre_n`.`Estado` FROM `k_cierre_n` INNER JOIN `rh_tipo_persona_cargon`   ON (`k_cierre_n`.`Id_Usuario` = `rh_tipo_persona_cargon`.`Id`)  INNER JOIN `k_caja`   ON (`k_caja`.`Id` = `k_cierre_n`.`Id_Caja`)    INNER JOIN `rh_unidadf_cargo`  ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`) INNER JOIN `g_persona`  ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)  INNER JOIN `rh_tipo_cargo`  ON (`rh_unidadf_cargo`.`Id_Cargo` = `rh_tipo_cargo`.`Id`) WHERE (`k_cierre_n`.Estado=1 and `k_cierre_n`.`FechaI`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `k_cierre_n`.`FechaI`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  ) ORDER BY `k_cierre_n`.`Id` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            double xvalor = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xDato);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo2.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo2.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo2.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo2.setValueAt(Long.valueOf(xrs.getLong(8)), xnfila, 7);
                    this.xmodelo2.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), xnfila, 8);
                    xvalor += xrs.getDouble(6);
                    xnfila++;
                }
            }
            this.JTFF_TotalCierres.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_ReciboCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            mImprimir(Principal.txtNo.getText());
        }
    }

    private void mImprimir(String xid) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xid;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "K_Cierre_Caja", mparametros);
    }
}
