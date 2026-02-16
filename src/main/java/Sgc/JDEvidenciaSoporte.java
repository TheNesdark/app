package Sgc;

import Acceso.Principal;
import ComprasBS.JIFSolicitudContrato;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDEvidenciaSoporte.class */
public class JDEvidenciaSoporte extends JDialog {
    private ConsultasMySQL xconsulta;
    File directorio;
    private Metodos xmetodos;
    private DefaultTableModel xmodelo;
    public String xdocumento;
    public String XId;
    private Object[] xdatos;
    private int xestado;
    private int xguardar;
    private File xfile;
    private JIFSolicitudContrato xJIFSolicitudContrato;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir;
    private JCheckBox JCHEstado;
    private JDateChooser JDCFecha;
    private JPanel JPI_Datos;
    private JScrollPane JSP_PObservacion;
    private JTextPane JTA_PObservacion;
    private JTable JTDetalle;
    private JTextField JTFRutaEvidencia;
    private JScrollPane jScrollPane1;

    public JDEvidenciaSoporte(String xid, String xdocumento, Frame parent, boolean modal) {
        super(parent, modal);
        this.xconsulta = new ConsultasMySQL();
        this.xmetodos = new Metodos();
        this.xestado = 1;
        this.xguardar = 0;
        initComponents();
        System.out.println(xdocumento);
        System.out.println(xid);
        this.XId = xid;
        this.xdocumento = xdocumento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("SOPORTE DE DOCUMENTOS POR CONTRATO");
        mNuevo();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JDCFecha = new JDateChooser();
        this.JTFRutaEvidencia = new JTextField();
        this.JSP_PObservacion = new JScrollPane();
        this.JTA_PObservacion = new JTextPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        addWindowListener(new WindowAdapter() { // from class: Sgc.JDEvidenciaSoporte.1
            public void windowClosing(WindowEvent evt) {
                JDEvidenciaSoporte.this.formWindowClosing(evt);
            }
        });
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Sgc.JDEvidenciaSoporte.2
            public void actionPerformed(ActionEvent evt) {
                JDEvidenciaSoporte.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.setMaxSelectableDate(new Date(253370786507000L));
        this.JTFRutaEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTFRutaEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Evidencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaEvidencia.addMouseListener(new MouseAdapter() { // from class: Sgc.JDEvidenciaSoporte.3
            public void mouseClicked(MouseEvent evt) {
                JDEvidenciaSoporte.this.JTFRutaEvidenciaMouseClicked(evt);
            }
        });
        this.JSP_PObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_PObservacion.setFont(new Font("Arial", 1, 12));
        this.JSP_PObservacion.setViewportView(this.JTA_PObservacion);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaEvidencia, -1, 367, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JSP_PObservacion)).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JTFRutaEvidencia, -2, -1, -2).addComponent(this.JDCFecha, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(9, 9, 9).addComponent(this.JSP_PObservacion, -1, 61, 32767).addContainerGap()));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JDEvidenciaSoporte.4
            public void mouseClicked(MouseEvent evt) {
                JDEvidenciaSoporte.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: Sgc.JDEvidenciaSoporte.5
            public void actionPerformed(ActionEvent evt) {
                JDEvidenciaSoporte.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: Sgc.JDEvidenciaSoporte.6
            public void actionPerformed(ActionEvent evt) {
                JDEvidenciaSoporte.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Sgc.JDEvidenciaSoporte.7
            public void actionPerformed(ActionEvent evt) {
                JDEvidenciaSoporte.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Datos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, 196, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 200, -2))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 210, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(187, 187, 187).addComponent(this.jScrollPane1, -2, 183, -2).addContainerGap(84, 32767))));
        pack();
    }

    private void mNuevo() {
        this.directorio = new File(this.xmetodos.mRutaSoporte("JDEvidenciaSoporte"));
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JTFRutaEvidencia.setText((String) null);
        this.JTA_PObservacion.setText((String) null);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xguardar = 0;
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFRutaEvidencia.getText().isEmpty()) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.xguardar == 0) {
                    if (this.JTDetalle.getRowCount() > 0) {
                        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                            String sql2 = "UPDATE cc_orden_compra_documento_evidencia SET Estado = 0 , Id_UsuarioS ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Fecha ='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "'Where Id='" + this.xmodelo.getValueAt(y, 0).toString() + "'";
                            System.out.println("update Estados---->" + sql2);
                            this.xconsulta.ejecutarSQL(sql2);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                    File directorio = new File(this.xmetodos.mRutaSoporte("JDEvidenciaSoporte"));
                    String sql3 = "INSERT INTO `cc_orden_compra_documento_evidencia` ( `Id_orden_compra_documento`,  `FechaE`, `Observacion`, Estado, Id_UsuarioS,Fecha)VALUES ('" + this.XId + "','" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTA_PObservacion.getText() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                    String xidDoc = this.xconsulta.ejecutarSQLId(sql3);
                    String adjunto = xidDoc + "_" + this.xdocumento + ".pdf";
                    System.out.println(adjunto);
                    sql = "UPDATE cc_orden_compra_documento_evidencia set Evidencia='" + this.xmetodos.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    File f1 = new File(this.JTFRutaEvidencia.getText());
                    File f2 = new File(adjunto);
                    f1.renameTo(f2);
                    f2.renameTo(new File(directorio, f2.getName()));
                } else {
                    sql = "UPDATE cc_orden_compra_documento_evidencia SET Observacion = '" + this.JTA_PObservacion.getText() + "', Estado = '" + this.xestado + "', Id_UsuarioS ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Fecha ='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "'Where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "'";
                }
                System.out.println("update---->" + sql);
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "El campo evidencia no puede estar vacio", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRutaEvidencia.requestFocus();
    }

    public void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT    `cc_orden_compra_documento_evidencia`.`Id`    , `cc_orden_compra_documento`.`Id`    , `cc_orden_compra_documento_evidencia`.`FechaE`    , `cc_orden_compra_documento_evidencia`.`Observacion`    , `cc_orden_compra_documento_evidencia`.`Evidencia`    , `cc_orden_compra_documento_evidencia`.`Estado`    , `cc_orden_compra_documento_evidencia`.`Id_UsuarioS`    , `cc_orden_compra_documento_evidencia`.`Fecha`FROM    `cc_orden_compra_documento_evidencia`    INNER JOIN `cc_orden_compra_documento`         ON (`cc_orden_compra_documento_evidencia`.`Id_orden_compra_documento` = `cc_orden_compra_documento`.`Id`)WHERE (`cc_orden_compra_documento`.`Id` = '" + this.XId + "');";
            ResultSet xrs = this.xconsulta.traerRs(sql);
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
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDEvidencias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id Documento", "Fecha", "Observacion", "Evidencia", "Estado"}) { // from class: Sgc.JDEvidenciaSoporte.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaEvidenciaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRutaEvidencia.setText(this.xmetodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JDCFecha.setDate(java.sql.Date.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JTA_PObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFRutaEvidencia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xguardar = 1;
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString();
                this.xmetodos.mostrarPdf(this.directorio + "\\" + rutaa);
                mostrarPdf(rutaa);
            }
        }
    }

    private void mostrarPdf(String rutaa) {
        try {
            File archivo = new File(rutaa);
            if (archivo.exists()) {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            }
        } catch (IOException ex) {
            this.xconsulta.mostrarErrorIO(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        Principal.clasecomprabn.xJIFSolicitudContrato.mCargarDatos_Documentos(Principal.txtNo.getText());
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowClosing(WindowEvent evt) {
        Principal.clasecomprabn.xJIFSolicitudContrato.mCargarDatos_Documentos(Principal.txtNo.getText());
    }
}
