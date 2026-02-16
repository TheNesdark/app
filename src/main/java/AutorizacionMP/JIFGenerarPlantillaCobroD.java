package AutorizacionMP;

import Acceso.Principal;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFGenerarPlantillaCobroD.class */
public class JIFGenerarPlantillaCobroD extends JInternalFrame {
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private String sql;
    private String[] xidtipoempresa;
    private ButtonGroup JBGSoporte;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHSeleccionar;
    private JCheckBox JCHSeleccionar1;
    private JDateChooser JDCFecha;
    private JPanel JPIDatos;
    private JScrollPane JSPHC;
    private JScrollPane JSPHC1;
    private JTextField JTFRuta;
    private JTable JTHistorico;
    private JTable JTHistorico1;
    private JTabbedPane JTPDatos;

    public JIFGenerarPlantillaCobroD() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSoporte = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCHSeleccionar = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHSeleccionar1 = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JSPHC = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JSPHC1 = new JScrollPane();
        this.JTHistorico1 = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERAR PLANTILLA PARA DESCUENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenerarplantillacd");
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerarPlantillaCobroD.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarPlantillaCobroD.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarPlantillaCobroD.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.4
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarPlantillaCobroD.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHSeleccionar1.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar1.setText("Descuentos Liquidados?");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHSeleccionar1).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 295, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa).addComponent(this.JCHSeleccionar)).addComponent(this.JTFRuta).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -2, 54, -2).addComponent(this.JDCFecha, -2, -1, -2)))).addGap(18, 18, 18).addComponent(this.JCHSeleccionar1).addContainerGap()));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPHC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPHC.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.5
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarPlantillaCobroD.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHC.setViewportView(this.JTHistorico);
        this.JTPDatos.addTab("DETALLE", this.JSPHC);
        this.JSPHC1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPHC1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setFont(new Font("Arial", 1, 12));
        this.JTHistorico1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico1.setRowHeight(25);
        this.JTHistorico1.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico1.setSelectionForeground(Color.red);
        this.JTHistorico1.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.6
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarPlantillaCobroD.this.JTHistorico1MouseClicked(evt);
            }
        });
        this.JSPHC1.setViewportView(this.JTHistorico1);
        this.JTPDatos.addTab("CONSOLIDADO PLANTILLA", this.JSPHC1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -1, 364, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTPDatos.getSelectedIndex() == 1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTHistorico1, this.JTFRuta.getText(), getTitle());
                return;
            }
            return;
        }
        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTHistorico, this.JTFRuta.getText(), getTitle() + ": DETALLE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorico1MouseClicked(MouseEvent evt) {
    }

    private void mSeleccionar(boolean xestado) {
        if (this.JTHistorico.getRowCount() > 0) {
            for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 5);
            }
        }
    }

    public void mGrabar() {
        if (!mVerificarDatosTablaTrue()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTHistorico, 5)) {
                int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (xv == 0) {
                    this.sql = "Insert into d_relacion (FechaI, FechaF, Fecha, UsuarioS) values ('" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(this.sql));
                    this.xconsultas.cerrarConexionBd();
                    for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                        if (Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue() != 0.0d) {
                            this.sql = "insert into d_detalle_relacion(Id_Relacion, Id_Descuento, VADescontar) values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 6).toString() + "'," + this.xmodelo.getValueAt(x, 7) + ")";
                            this.xconsultas.ejecutarSQL(this.sql);
                            this.xconsultas.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar descuentos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen datos sin codigo de 1Sap;\nFavor completar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mGrabar1() {
        double xvalorg;
        if (!mVerificarDatosTablaTrue()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTHistorico, 5)) {
                int xv = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (xv == 0) {
                    this.sql = "Insert into d_relacion (FechaI, FechaF, Fecha, UsuarioS) values ('" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(this.sql));
                    this.xconsultas.cerrarConexionBd();
                    for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 5).toString()).booleanValue()) {
                            double xvalord = Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue();
                            this.sql = "SELECT d_descuento.`Id`, ROUND(IF(d_descuento.Liquidar=1, (SUM(d_descuento.Valor)-SUM(d_descuento.VDescontado)),(IF(g_relacionlaboral.AplicaTopeD=1,  IF(SUM(d_descuento.VDescontarQ)<=g_relacionlaboral.TopeDescuento,SUM(d_descuento.VDescontarQ), g_relacionlaboral.TopeDescuento) , SUM(d_descuento.VDescontarQ))))) AS VDescontar  FROM persona INNER JOIN d_descuento  ON (persona.Id_persona = d_descuento.Id_PersonaDescuento)  INNER JOIN g_usuario_fpz ON (persona.Id_persona = g_usuario_fpz.Id_Persona)  INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id)  INNER JOIN g_relacionlaboral  ON (g_usuario_fpz.Id_RelacionLaboral = g_relacionlaboral.Id) WHERE (d_descuento.EsAcumulado =1 AND d_descuento.Estado =0 AND (d_descuento.Valor-d_descuento.VDescontado)<>0   AND d_descuento.Id_PersonaDescuento ='" + this.xmodelo.getValueAt(x, 0) + "' AND g_usuario_fpz.Id_Empresa ='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()] + "')  GROUP BY d_descuento.`Id`, d_descuento.Id_PersonaDescuento ORDER BY persona.NUsuario ";
                            ResultSet xrs = this.xconsultas.traerRs(this.sql);
                            try {
                                if (xrs.next()) {
                                    xrs.beforeFirst();
                                    ConsultasMySQL xct = new ConsultasMySQL();
                                    while (xrs.next()) {
                                        if (xrs.getDouble(2) <= xvalord) {
                                            xvalorg = xrs.getDouble(2);
                                            xvalord -= xrs.getDouble(2);
                                        } else {
                                            xvalorg = xvalord;
                                        }
                                        this.sql = "insert into d_detalle_relacion(Id_Relacion, Id_Descuento, VADescontar) values ('" + Principal.txtNo.getText() + "','" + xrs.getLong(1) + "',Round(" + xvalorg + "))";
                                        xct.ejecutarSQL(this.sql);
                                        xct.cerrarConexionBd();
                                    }
                                }
                                xrs.close();
                                this.xconsultas.cerrarConexionBd();
                            } catch (SQLException ex) {
                                Logger.getLogger(JIFGenerarPlantillaCobroD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            }
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar descuentos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Existen datos sin codigo de 1Sap;\nFavor completar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xidtipoempresa = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mCrearTabla();
    }

    public void mBuscar() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            mCargarTabla();
            mCargarTabla1();
            mCalcular_VDescuento();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimir() {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "N° HC", "Código 1Sap", "Usuario", "V/Descuento", "Cargar?", "Id_Descuento", "VD"}) { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.7
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Long.class, Double.class};
            boolean[] canEdit = {false, true, true, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "N° HC", "Código 1Sap", "Usuario", "V/Descuento", "RLaboral"}) { // from class: AutorizacionMP.JIFGenerarPlantillaCobroD.8
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico1.setModel(this.xmodelo1);
        this.JTHistorico1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico1.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico1.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico1.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistorico1.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTHistorico1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico1.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarTabla() {
        mCrearTabla();
        this.sql = "SELECT `d_descuento`.`Id_PersonaDescuento` , `g_usuario`.`NoHistoria` , `g_persona`.`Codigo1Sap` , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuarios` , IF(`g_relacionlaboral`.`AplicaTopeD`=0,IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0), IF((IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0))> `g_relacionlaboral`.`TopeDescuento`, `g_relacionlaboral`.`TopeDescuento`,(IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0)))) AS `VD` ,`d_descuento`.`Id` FROM  `g_persona` INNER JOIN  `d_descuento`  ON (`g_persona`.`Id` = `d_descuento`.`Id_PersonaDescuento`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz`.`Id_Empresa` = `g_tipoempresa`.`Id`) INNER JOIN  `g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE ( `g_tipoempresa`.id='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `d_descuento`.`Valor` <>`d_descuento`.`VDescontado` AND `d_descuento`.`Estado` =0) HAVING (`VD` <>0) ORDER BY NUsuarios ASC, `d_descuento`.`Id` asc";
        ResultSet rs = this.xconsultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(false, x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 6);
                    this.xmodelo.setValueAt(0, x, 7);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarPlantillaCobroD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarTabla1() {
        mCrearTabla1();
        this.sql = "SELECT`d_descuento`.`Id_PersonaDescuento` ,`g_usuario`.`NoHistoria` , `g_persona`.`Codigo1Sap` , CONCAT(`g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2` ,' ', `g_persona`.`Nombre1`,' ', `g_persona`.`Nombre2`) AS `NUsuarios` , IF(`g_relacionlaboral`.`AplicaTopeD`=0,SUM(IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0)), IF((SUM(IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0)))> `g_relacionlaboral`.`TopeDescuento`, `g_relacionlaboral`.`TopeDescuento`,(SUM(IF(`d_descuento`.`VDescontado`<`d_descuento`.`Valor`, IF( ((`d_descuento`.`Valor`-`d_descuento`.`VDescontado`)<`d_descuento`.`VDescontarQ`)  ,(`d_descuento`.`Valor`-`d_descuento`.`VDescontado`) ,`d_descuento`.`VDescontarQ`),0)))))AS `VD` ,g_relacionlaboral.`Nbre` AS RLaboral  FROM  `g_persona` INNER JOIN  `d_descuento`  ON (`g_persona`.`Id` = `d_descuento`.`Id_PersonaDescuento`) INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`) INNER JOIN  `g_tipoempresa`  ON (`g_usuario_fpz`.`Id_Empresa` = `g_tipoempresa`.`Id`) INNER JOIN  `g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE ( `g_tipoempresa`.id='" + this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `d_descuento`.`Valor` <>`d_descuento`.`VDescontado` AND `d_descuento`.`Estado` =0) GROUP BY `d_descuento`.`Id_PersonaDescuento` HAVING (`VD` <>0) ORDER BY NUsuarios ASC ";
        ResultSet rs = this.xconsultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo1.setValueAt(rs.getString(6), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarPlantillaCobroD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificarDatosTablaTrue() {
        boolean estado = false;
        if (this.xidtipoempresa[this.JCBEmpresa.getSelectedIndex()].equals("1") && this.JTHistorico.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTHistorico.getRowCount()) {
                    if (!this.JTHistorico.getValueAt(i, 2).toString().equals("0") || !Boolean.valueOf(this.JTHistorico.getValueAt(i, 5).toString()).booleanValue()) {
                        i++;
                    } else {
                        estado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return estado;
    }

    private void mCalcular_VDescuento() {
        for (int x = 0; x < this.JTHistorico1.getRowCount(); x++) {
            double xvalor = Double.valueOf(this.xmodelo1.getValueAt(x, 4).toString()).doubleValue();
            for (int y = 0; y < this.JTHistorico.getRowCount(); y++) {
                if (this.xmodelo.getValueAt(y, 0).toString().equals(this.xmodelo1.getValueAt(x, 0).toString())) {
                    if (xvalor >= Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue()) {
                        this.xmodelo.setValueAt(Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()), y, 7);
                        xvalor -= Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
                    } else {
                        this.xmodelo.setValueAt(Double.valueOf(xvalor), y, 7);
                        xvalor -= xvalor;
                    }
                }
            }
        }
    }
}
