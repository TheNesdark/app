package Inventarios;

import Acceso.Principal;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAjustarPRMinMax.class */
public class JIFAjustarPRMinMax extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String[] xidcombo;
    private String xsql;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBUno;
    private JDateChooser JDFFFin;
    private JDateChooser JDFFInicio;
    private JLabel JLBNdias;
    private JPanel JPIDatos;
    private JPanel JPIDatosP;
    private JPanel JPIDetallec;
    private JPanel JPITipo;
    private JRadioButton JRBBodega;
    private JRadioButton JRBProveedores;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JSpinner JSPDiasAjus;
    private JSpinner JSPUnidadesPR;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTabbedPane JTPDatosSum;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xestado = true;
    private boolean xlleno = false;

    public JIFAjustarPRMinMax() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v87, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v97, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBUno = new JComboBox();
        this.JPITipo = new JPanel();
        this.JRBProveedores = new JRadioButton();
        this.JRBBodega = new JRadioButton();
        this.jButton2 = new JButton();
        this.jPanel1 = new JPanel();
        this.JDFFInicio = new JDateChooser();
        this.JDFFFin = new JDateChooser();
        this.JLBNdias = new JLabel();
        this.JSPDiasAjus = new JSpinner();
        this.jButton1 = new JButton();
        this.JSPUnidadesPR = new JSpinner();
        this.JTPDatosSum = new JTabbedPane();
        this.JPIDatosP = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDetallec = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AJUSTAR PUNTOS DE REPOSICION-MINIMOS Y MAXIMOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("xjifajustarpminmax");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFAjustarPRMinMax.1
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
                JIFAjustarPRMinMax.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUno.addItemListener(new ItemListener() { // from class: Inventarios.JIFAjustarPRMinMax.2
            public void itemStateChanged(ItemEvent evt) {
                JIFAjustarPRMinMax.this.JCBUnoItemStateChanged(evt);
            }
        });
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGOpciones.add(this.JRBProveedores);
        this.JRBProveedores.setFont(new Font("Arial", 1, 12));
        this.JRBProveedores.setSelected(true);
        this.JRBProveedores.setText("Proveedores");
        this.JRBProveedores.addActionListener(new ActionListener() { // from class: Inventarios.JIFAjustarPRMinMax.3
            public void actionPerformed(ActionEvent evt) {
                JIFAjustarPRMinMax.this.JRBProveedoresActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBBodega);
        this.JRBBodega.setFont(new Font("Arial", 1, 12));
        this.JRBBodega.setText("Bodega");
        this.JRBBodega.addActionListener(new ActionListener() { // from class: Inventarios.JIFAjustarPRMinMax.4
            public void actionPerformed(ActionEvent evt) {
                JIFAjustarPRMinMax.this.JRBBodegaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBBodega).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JRBProveedores).addContainerGap()));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProveedores).addComponent(this.JRBBodega)).addContainerGap(-1, 32767)));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Actualizar");
        this.jButton2.addActionListener(new ActionListener() { // from class: Inventarios.JIFAjustarPRMinMax.5
            public void actionPerformed(ActionEvent evt) {
                JIFAjustarPRMinMax.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPITipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUno, -2, 429, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton2, -2, 146, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPITipo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JCBUno, GroupLayout.Alignment.TRAILING))).addContainerGap(25, 32767)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA DE ROTACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFFInicio.setFont(new Font("Arial", 1, 12));
        this.JDFFFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFFin.setDateFormatString("dd/MM/yyyy");
        this.JDFFFin.setFont(new Font("Arial", 1, 12));
        this.JLBNdias.setFont(new Font("Arial", 1, 12));
        this.JLBNdias.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDiasAjus.setFont(new Font("Arial", 1, 12));
        this.JSPDiasAjus.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPDiasAjus.setToolTipText("N° de días de inventario en bodega");
        this.JSPDiasAjus.setBorder(BorderFactory.createTitledBorder((Border) null, "Días Ajustar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("Buscar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Inventarios.JIFAjustarPRMinMax.6
            public void actionPerformed(ActionEvent evt) {
                JIFAjustarPRMinMax.this.jButton1ActionPerformed(evt);
            }
        });
        this.JSPUnidadesPR.setFont(new Font("Arial", 1, 12));
        this.JSPUnidadesPR.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPUnidadesPR.setToolTipText("Tiempo para llegada de la compra");
        this.JSPUnidadesPR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo LLegada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNdias, -2, 97, -2).addGap(38, 38, 38).addComponent(this.JSPDiasAjus, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPUnidadesPR, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 146, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPUnidadesPR, GroupLayout.Alignment.LEADING).addComponent(this.JDFFInicio, -1, -1, 32767).addComponent(this.JDFFFin, -1, -1, 32767).addComponent(this.JLBNdias, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDiasAjus, -2, 52, -2)).addContainerGap()));
        this.JTPDatosSum.setForeground(new Color(0, 103, 0));
        this.JTPDatosSum.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAjustarPRMinMax.7
            public void mouseClicked(MouseEvent evt) {
                JIFAjustarPRMinMax.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 880, 32767).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 365, 32767).addContainerGap()));
        this.JTPDatosSum.addTab("DETALLE", this.JPIDatosP);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle1.setSelectionMode(0);
        this.JTDetalle1.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAjustarPRMinMax.8
            public void mouseClicked(MouseEvent evt) {
                JIFAjustarPRMinMax.this.JTDetalle1MouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        GroupLayout JPIDetallecLayout = new GroupLayout(this.JPIDetallec);
        this.JPIDetallec.setLayout(JPIDetallecLayout);
        JPIDetallecLayout.setHorizontalGroup(JPIDetallecLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetallecLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 880, 32767).addContainerGap()));
        JPIDetallecLayout.setVerticalGroup(JPIDetallecLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetallecLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1, -1, 365, 32767).addContainerGap()));
        this.JTPDatosSum.addTab("CROTACIÓN", this.JPIDetallec);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPDatosSum, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosSum).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBodegaActionPerformed(ActionEvent evt) {
        mCargarComboBodega();
        this.xestado = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProveedoresActionPerformed(ActionEvent evt) {
        mCargarComboBodega();
        this.xestado = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBUno.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalle1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JCBUno.getSelectedIndex() != -1) {
            mCargarDatosRotacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle1.getRowCount() != -1 && this.JTDetalle.getRowCount() != -1) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                int y = 0;
                while (true) {
                    if (y >= this.JTDetalle1.getRowCount()) {
                        break;
                    }
                    if (!this.xmodelo.getValueAt(x, 0).equals(this.xmodelo1.getValueAt(y, 0))) {
                        y++;
                    } else {
                        this.xmodelo.setValueAt(this.xmodelo1.getValueAt(y, 5), x, 6);
                        this.xmodelo.setValueAt(this.xmodelo1.getValueAt(y, 4), x, 7);
                        this.xmodelo.setValueAt(this.xmodelo1.getValueAt(y, 3), x, 8);
                        break;
                    }
                }
            }
        }
    }

    private void mCargarComboBodega() {
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodegas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        if (this.xestado) {
            this.xsql = "SELECT i_bodegas.Id, i_bodegas.Nbre FROM i_bodegas INNER JOIN i_reposiciones  ON (i_bodegas.Id = i_reposiciones.Id_Bodega) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC ";
        } else {
            this.xsql = "SELECT i_bodegas.Id , i_bodegas.Nbre FROM i_reposicionesbodegas INNER JOIN i_bodegas  ON (i_reposicionesbodegas.Id_Bodegas = i_bodegas.Id)  WHERE (i_bodegas.Estado =0) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC";
        }
        this.xidcombo = this.xct.llenarCombo(this.xsql, this.xidcombo, this.JCBUno);
        this.JCBUno.setSelectedItem(-1);
        this.xct.cerrarConexionBd();
    }

    private void mExportar(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "Producto"));
                sheet.addCell(new Label(2, 1, "Presentación Comercial"));
                sheet.addCell(new Label(3, 1, "Laboratorio"));
                sheet.addCell(new Label(4, 1, "Tipo Producto"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        sheet.addCell(new Label(4, x, rs.getString(5)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mExportar1(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Tipo Movimiento"));
                sheet.addCell(new Label(1, 1, "IdSalida"));
                sheet.addCell(new Label(2, 1, "Fecha"));
                sheet.addCell(new Label(3, 1, "Valor"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Number(3, x, rs.getDouble(4)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mExportar2(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Tipo Movimiento"));
                sheet.addCell(new Label(1, 1, "Nformula"));
                sheet.addCell(new Label(2, 1, "NItems"));
                sheet.addCell(new Label(3, 1, "Valor"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Number(2, x, rs.getLong(3)));
                        sheet.addCell(new Number(3, x, rs.getDouble(4)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        mCargarComboBodega();
        mCrearModeloDatosListadoP();
        mCrearModeloDatosR();
        this.JDFFInicio.setDate(this.xmt.getFechaActual());
        this.JDFFFin.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "L_PlanillaRemision", parametros);
            this.xct.cerrarConexionBd();
        }
    }

    public void mGrabar() {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
            if (x == 0) {
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 9).toString()).booleanValue()) {
                        this.xsql = "update i_reposiciones set PReposicion='" + this.xmodelo.getValueAt(y, 6) + "', Minimo='" + this.xmodelo.getValueAt(y, 7) + "', Maximo='" + this.xmodelo.getValueAt(y, 7) + "' where Id_Suministro='" + this.xmodelo.getValueAt(y, 0) + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                }
            }
        }
    }

    public void mBuscar() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            mCargarDatosListadoP();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosListadoP() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Producto", "Categoria", "PReposición", "Mínimo", "Máximo", "PReposiciónS", "MínimoS", "MáximoS", "A", "Prioridad", "IdPrioridas"}) { // from class: Inventarios.JIFAjustarPRMinMax.9
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, true, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosR() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Producto", "CantidadU", "Máximo", "Mínimo", "Reposición", "Encontro"}) { // from class: Inventarios.JIFAjustarPRMinMax.10
            Class[] types = {Long.class, String.class, Long.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    private void mCargarDatosListadoP() {
        try {
            this.xsql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre ) AS Nproducto , i_categoria.Nbre, i_reposiciones.PReposicion, i_reposiciones.Minimo, i_reposiciones.Maximo,i_prioridades.Nbre, i_prioridades.Id FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_prioridades ON (i_suministro.IdPrioridad = i_prioridades.Id) WHERE (i_reposiciones.Id_Bodega =2) GROUP BY i_suministro.Id ORDER BY Nproducto ASC ";
            mCrearModeloDatosListadoP();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo.setValueAt(new Long(0L), n, 6);
                    this.xmodelo.setValueAt(new Long(0L), n, 7);
                    this.xmodelo.setValueAt(new Long(0L), n, 8);
                    this.xmodelo.setValueAt(true, n, 9);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 11);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRotacion() {
        try {
            this.xsql = "SELECT i_suministro.CodigoAgrupacion, i_suministro.Nbre AS NSuministro, SUM(i_detallesalida.CantidadDespachada) AS Cantidad , DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "') AS NDias , ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad) AS Maximo , IF(ROUND(((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "'))*" + this.JSPDiasAjus.getValue() + ")) = 0,0,ROUND(((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "'))*" + this.JSPDiasAjus.getValue() + "))) AS PMinimo,  if(ROUND(((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "')) *" + this.JSPDiasAjus.getValue() + ") +  ((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "')) *" + this.JSPUnidadesPR.getValue() + ") )=0,1,ROUND(((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "')) *" + this.JSPDiasAjus.getValue() + ") +  ((ROUND(SUM(i_detallesalida.CantidadDespachada)/i_suministro.CantidadUnidad)/DATEDIFF('" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "')) *" + this.JSPUnidadesPR.getValue() + ") )) AS PReposicion   FROM i_detallesalida INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id)  INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFFInicio.getDate()) + "' AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFFFin.getDate()) + "' AND i_salidas.IdBodega ='" + this.xidcombo[this.JCBUno.getSelectedIndex()] + "' AND i_salidas.Estado =0 AND i_tiposmovimientos.Despacho =1) GROUP BY i_suministro.CodigoAgrupacion HAVING (Cantidad <>0) ORDER BY i_suministro.Nbre ASC ";
            mCrearModeloDatosR();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                this.JLBNdias.setText(xrs.getString(4));
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), n, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(7)), n, 4);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo1.setValueAt(false, n, 6);
                    this.JTDetalle1.setDefaultRenderer(Object.class, new MiRender1());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAjustarPRMinMax.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAjustarPRMinMax$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int xvalor = Integer.valueOf(table.getValueAt(row, 11).toString()).intValue();
            if (xvalor == 6) {
                cell.setBackground(Color.RED);
            } else if (xvalor == 7) {
                cell.setBackground(Color.YELLOW);
            } else if (xvalor == 8) {
                cell.setBackground(new Color(255, 51, 255));
            } else if (xvalor == 9) {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAjustarPRMinMax$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 6).toString()).booleanValue()) {
                cell.setBackground(Color.RED);
            }
            return cell;
        }
    }
}
