package ComprasBS;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JDBuscarInformacion.class */
public class JDBuscarInformacion extends Dialog {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xct;
    public String[] xtipodocumento;
    private String xsql;
    private String xname;
    private Object[] xdato;
    private JIFOrdenCompra xjifcomprabien;
    private int xtipo;
    private JButton JBTBuscar;
    private JButton JBTGenerar;
    private JComboBox JCBTipoDocumento;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatosB;
    private JScrollPane JSPResultado;
    private JTextField JTFRuta;
    private JTable JTResultado;
    private JPanel jPanel1;

    public JDBuscarInformacion(Frame parent, boolean modal, JInternalFrame xjif, int xtipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.xsql = null;
        this.xtipo = 0;
        initComponents();
        this.xtipo = xtipo;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mHacerCastingJFInternos(xjif);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosB = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBTipoDocumento = new JComboBox();
        this.JBTBuscar = new JButton();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setBackground(new Color(236, 233, 216));
        setForeground(new Color(255, 255, 255));
        setTitle("BUSCAR");
        addWindowListener(new WindowAdapter() { // from class: ComprasBS.JDBuscarInformacion.1
            public void windowClosing(WindowEvent evt) {
                JDBuscarInformacion.this.closeDialog(evt);
            }
        });
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 13));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 13));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTBuscar.setFont(new Font("Arial", 1, 12));
        this.JBTBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBTBuscar.setText("Buscar");
        this.JBTBuscar.addActionListener(new ActionListener() { // from class: ComprasBS.JDBuscarInformacion.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInformacion.this.JBTBuscarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDocumento, -2, 357, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTBuscar, -1, -1, 32767)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, -1, -2).addComponent(this.JDCFechaF, -2, -1, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBLayout.createSequentialGroup().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTBuscar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBTipoDocumento)).addGap(84, 84, 84)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JDBuscarInformacion.3
            public void mouseClicked(MouseEvent evt) {
                JDBuscarInformacion.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JDBuscarInformacion.4
            public void mouseClicked(MouseEvent evt) {
                JDBuscarInformacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: ComprasBS.JDBuscarInformacion.5
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInformacion.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, -1, 746, 32767).addComponent(this.JPIDatosB, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 492, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap(14, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeDialog(WindowEvent evt) {
        setVisible(false);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            if (this.xname.equals("jifcompras")) {
                try {
                    if (this.xtipo == 0) {
                        this.xjifcomprabien.JTFNRequisicion.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                        this.xjifcomprabien.mBuscarDatosRequisicion(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                        this.xjifcomprabien.setSelected(true);
                    }
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JDBuscarInformacion.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
            dispose();
        }
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
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    private void mNuevo() {
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTipoDocumento.removeAllItems();
        this.xtipodocumento = this.xct.llenarCombo("SELECT  Id , Nbre , Estado  FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xtipodocumento, this.JCBTipoDocumento);
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCargarDatosTabla();
        this.JDCFechaI.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ComprasBS.JDBuscarInformacion.6
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = null;
            String[] xencabezado = {"Id", "Fecha", "Observación", "Estado", "Disponibilidad"};
            if (this.xname.equals("jifcompras")) {
                if (this.xjifcomprabien.getTitle().equals("ORDEN DE COMPRA") && this.xtipo == 0) {
                    sql = "SELECT cc_r_requisicion.Id , DATE_FORMAT(cc_r_requisicion.FechaR,'%d-%m-%Y') AS fechaR , cc_r_requisicion.ObservacionG , cc_r_requisicion.Estado,IF(pp_mov.Id IS NULL,'',pp_mov.Id) AS IdDisponibilidad\nFROM cc_r_requisicion LEFT JOIN(SELECT `pp_movimiento`.`Id` , `pp_movimiento`.`IdSolicitud` FROM `pp_movimiento` INNER JOIN `pp_tipo_documentos` \nON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`) WHERE (`pp_movimiento`.`Id_MotivoAnulacion` =1 AND `pp_tipo_documentos`.`Id_ClaseDoc` =22)) pp_mov\nON (pp_mov.IdSolicitud=cc_r_requisicion.`Id`) WHERE (cc_r_requisicion.FechaR >='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND cc_r_requisicion.FechaR <='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND `cc_r_requisicion`.`Autorizado`=1 ) ORDER BY DATE_FORMAT(cc_r_requisicion.FechaR,'%d-%m-%Y') DESC ";
                }
                mCrearModeloDatos(xencabezado);
                System.out.println(sql);
                ResultSet xrs = this.xct.traerRs(sql);
                Throwable th = null;
                try {
                    try {
                        if (xrs.next()) {
                            xrs.beforeFirst();
                            int n = 0;
                            while (xrs.next()) {
                                this.xmodelo.addRow(this.xdato);
                                this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                                this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                                this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                                this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), n, 3);
                                this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                                n++;
                            }
                        }
                        if (xrs != null) {
                            if (0 != 0) {
                                try {
                                    xrs.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs.close();
                            }
                        }
                        this.xct.cerrarConexionBd();
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscarInformacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mHacerCastingJFInternos(JInternalFrame xjif) {
        if (xjif.getName().equals("jifcompras")) {
            this.xjifcomprabien = (JIFOrdenCompra) xjif;
            this.xname = xjif.getName();
        }
    }
}
