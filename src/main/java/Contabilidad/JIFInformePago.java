package Contabilidad;

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
import java.beans.PropertyVetoException;
import java.io.File;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFInformePago.class */
public class JIFInformePago extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidtipodocumento;
    private String[][] xidtercero;
    private String xsql;
    private int xtipoforma;
    private boolean xlleno;
    private ButtonGroup JBGSeleccion;
    private JButton JBTGenerar;
    private JComboBox JCBTercero;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xautorizado = 1;
    private int xnentradas = 0;
    private boolean xlleno1 = false;

    public JIFInformePago() {
        this.xlleno = false;
        initComponents();
        this.xlleno = true;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTercero = new JComboBox();
        this.JBTGenerar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE PAGOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifenviardoctercero");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFInformePago.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFInformePago.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 13));
        this.JCBTercero.setFont(new Font("Arial", 0, 13));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFInformePago.2
            public void itemStateChanged(ItemEvent evt) {
                JIFInformePago.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Modificar29x27.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFInformePago.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformePago.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(313, 313, 313).addComponent(this.JBTGenerar, -1, 671, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTercero, 0, 714, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2)).addComponent(this.JCBTercero, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JBTGenerar, -1, 50, 32767).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFInformePago.4
            public void mouseClicked(MouseEvent evt) {
                JIFInformePago.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 1010, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 366, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 9)) {
            mGenerarPDF();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un docuemento a generar", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTDetalle.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (!this.xlleno1 || this.JCBTercero.getSelectedIndex() != -1) {
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xnentradas = 0;
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.xlleno = false;
        this.JCBTercero.removeAllItems();
        mCrearModeloDatos();
        this.xlleno = true;
        this.JDFechaI.requestFocus();
    }

    private void mImprimirDoc(String xid, String xnombrea, String xtipodoc) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = xid;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "TipoDoc";
        mparametros[2][1] = xtipodoc;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xnombrea, mparametros);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "N° Factura", "Fecha Factura", "NPuc", "Valor", "UrlFactura", "IdFacInterna", "IdComprobante", "Enviar?"}) { // from class: Contabilidad.JIFInformePago.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    public void mBuscar() {
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(false, n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformePago.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRecorrerTablaG(String xruta1) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                String nbre = "" + this.xmodelo.getValueAt(x, 0).toString();
                String[][] mparametros = new String[3][2];
                mparametros[0][0] = "IdC";
                mparametros[0][1] = this.xmodelo.getValueAt(x, 0).toString();
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[2][0] = "TipoDoc";
                this.xmetodos.mGenerarPDF("CC_LiquidacionFactura", mparametros, nbre, xruta1);
            }
        }
    }

    private void mGenerarPDF() {
        File directorio2 = new File("C:\\Genoma\\DocumentosC\\");
        if (directorio2.exists()) {
            Metodos.mBorrarDirectorio(directorio2);
            String xruta = directorio2.getPath();
            mRecorrerTablaG(xruta);
        } else if (directorio2.mkdirs()) {
            String xruta2 = directorio2.getPath();
            mRecorrerTablaG(xruta2);
        }
    }
}
