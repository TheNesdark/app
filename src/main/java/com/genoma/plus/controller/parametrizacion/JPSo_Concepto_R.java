package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import General.JDFirmas;
import Historia.JDRegistro_SVE;
import Historia.JPSo_Concepto_E;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JPSo_Concepto_R.class */
public class JPSo_Concepto_R extends JPanel {
    private String[] xidtipor;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodeloH;
    private DefaultTableModel modcombos2;
    private clasesHistoriaCE xclase;
    private int xmod;
    private Object[] xdato;
    private String xsql;
    private String idIngreso;
    private JButton JBTAdicionar;
    private JButton JBTAdicionar1;
    private JButton JBTFirmar;
    private JComboBox JCBTipoR;
    private JLabel JLBNConcepto;
    private JPanel JPHistorico;
    private JPanel JPIDatosC;
    private JScrollPane JSPCEspecifico;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPRestricciones;
    private JTable JTCEspecifico;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JTextPane JTPRecomendacion;
    private JTable JTRestricciones;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String sql = "";

    public JPSo_Concepto_R(clasesHistoriaCE xclase, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mBuscar();
        mCargarDatosTabla();
        cargarDatosRecomendaciones();
    }

    public JPSo_Concepto_R(clasesHistoriaCE xclase, int xmod, String idingreso) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mBuscar();
        mCargarDatosTabla();
        this.idIngreso = idingreso;
        cargarDatosRecomendaciones();
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosC = new JPanel();
        this.JCBTipoR = new JComboBox();
        this.JSPRestricciones = new JScrollPane();
        this.JTRestricciones = new JTable();
        this.JSPCEspecifico = new JScrollPane();
        this.JTCEspecifico = new JTable();
        this.JBTAdicionar = new JButton();
        this.JLBNConcepto = new JLabel();
        this.JBTAdicionar1 = new JButton();
        this.JBTFirmar = new JButton();
        this.JSPObservacion = new JScrollPane();
        this.JTPRecomendacion = new JTextPane();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpconceptolaboral");
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "CONCEPTO DE APTITUD LABORAL (Ingreso, Periódico, Seguimiento, Cambio de Actividad, Post Incapacidad)", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoR.setFont(new Font("Arial", 1, 12));
        this.JCBTipoR.setToolTipText("APTO: Sin enfermedad aparente o hallazgos relevantes \nAPTO CON RESTRICCIÓN:Se identifica un hallazgo  o condición que requiere restricion para una tarea o actividad especifica \nAPLAZADO: Se requiere nueva valoración o ayuda diagnostica, antes de emitir concepto ocupacional.\nRECOMENDADO:Posee algún hallazgo o condición que limita su capacidad laboral y por lo tanto no se recomienda en esa labor, para proteger su salud");
        this.JCBTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoR.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.1
            public void itemStateChanged(ItemEvent evt) {
                JPSo_Concepto_R.this.JCBTipoRItemStateChanged(evt);
            }
        });
        this.JSPRestricciones.setBorder(BorderFactory.createTitledBorder((Border) null, "RESTRICCIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTRestricciones.setFont(new Font("Arial", 1, 12));
        this.JTRestricciones.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRestricciones.setRowHeight(25);
        this.JTRestricciones.setSelectionBackground(new Color(255, 255, 255));
        this.JTRestricciones.setSelectionForeground(new Color(255, 0, 0));
        this.JTRestricciones.setSelectionMode(0);
        this.JSPRestricciones.setViewportView(this.JTRestricciones);
        this.JSPCEspecifico.setBorder(BorderFactory.createTitledBorder((Border) null, "CONCEPTO ESPECÍFICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTCEspecifico.setFont(new Font("Arial", 1, 12));
        this.JTCEspecifico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTCEspecifico.setRowHeight(25);
        this.JTCEspecifico.setSelectionBackground(new Color(255, 255, 255));
        this.JTCEspecifico.setSelectionForeground(new Color(255, 0, 0));
        this.JTCEspecifico.setSelectionMode(0);
        this.JTCEspecifico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.2
            public void mouseClicked(MouseEvent evt) {
                JPSo_Concepto_R.this.JTCEspecificoMouseClicked(evt);
            }
        });
        this.JSPCEspecifico.setViewportView(this.JTCEspecifico);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_Concepto_R.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JLBNConcepto.setFont(new Font("Arial", 1, 18));
        this.JLBNConcepto.setForeground(new Color(255, 0, 0));
        this.JLBNConcepto.setHorizontalAlignment(0);
        this.JLBNConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Concepto", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/servicio.png")));
        this.JBTAdicionar1.setText("Registro SVE");
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_Concepto_R.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        this.JBTFirmar.setFont(new Font("Arial", 1, 12));
        this.JBTFirmar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTFirmar.setText("Firmar");
        this.JBTFirmar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_Concepto_R.this.JBTFirmarActionPerformed(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPRecomendacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPRecomendacion);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRestricciones).addComponent(this.JSPCEspecifico).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JBTAdicionar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar1, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTFirmar, -2, 180, -2).addGap(44, 44, 44).addComponent(this.JLBNConcepto, -1, 174, 32767)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBTipoR, -2, 276, -2).addGap(0, 0, 32767)).addComponent(this.JSPObservacion)).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JCBTipoR, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRestricciones, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPCEspecifico, -2, 137, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 157, -2).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionar, -1, 62, 32767).addComponent(this.JBTAdicionar1, -1, 62, 32767).addComponent(this.JBTFirmar, -1, 62, 32767)).addComponent(this.JLBNConcepto, -1, -1, 32767)).addContainerGap()));
        this.JTPDatos.addTab("DATOS", this.JPIDatosC);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.6
            public void mouseClicked(MouseEvent evt) {
                JPSo_Concepto_R.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 793, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 629, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        getAccessibleContext().setAccessibleName("xjpconceptolaboral");
        getAccessibleContext().setAccessibleDescription("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCEspecificoMouseClicked(MouseEvent evt) {
        if (this.JTCEspecifico.getSelectedColumn() == 2) {
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTCEspecifico.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo1.setValueAt("", this.JTCEspecifico.getSelectedRow(), 3);
            } else {
                this.xmodelo1.setValueAt("NO APLICA", this.JTCEspecifico.getSelectedRow(), 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1 && !this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString().equals("")) {
            this.xmt.mostrarPdf(this.xmodeloH.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
        mRegistroSVE();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoRItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoR.getSelectedIndex() != -1) {
            cargarCombo();
        }
    }

    public void mNuevo() {
        this.JLBNConcepto.setText("");
        this.JBTFirmar.setEnabled(false);
        mCargarDatosR();
        mCargarDatosCE();
        mCargarDatosRC();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Permanente", "Temporal", "N° Día", "Observación"}) { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.7
            Class[] types = {Integer.class, String.class, Boolean.class, Boolean.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRestricciones.setModel(this.xmodelo);
        this.JTRestricciones.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTRestricciones.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTRestricciones.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTRestricciones.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTRestricciones.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTRestricciones.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTRestricciones.getColumnModel().getColumn(4).setPreferredWidth(5);
        this.JTRestricciones.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaCE() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Si/No", "Observación"}) { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.8
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCEspecifico.setModel(this.xmodelo1);
        this.JTCEspecifico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTCEspecifico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTCEspecifico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTCEspecifico.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTCEspecifico.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTCEspecifico.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void mCrearTablaRC() {
    }

    /* JADX WARN: Finally extract failed */
    private void cargarDatosRecomendaciones() {
        if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
            try {
                this.xsql = "select ha.Recomendaciones  from h_atencion ha where ha.Id =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "";
                System.out.println(" Recomendaciones" + this.xsql);
                ResultSet xrs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (xrs.next() && this.JLBNConcepto.getText().isEmpty()) {
                        this.JTPRecomendacion.setText(xrs.getString("Recomendaciones"));
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
                } catch (Throwable th3) {
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(JPSo_Concepto_R.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCargarDatosR() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `Id`, `Nbre`, `Tipo` FROM `so_tipo_restriccion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTRestricciones, 1);
                this.xmt.mEstablecerTextEditor(this.JTRestricciones, 5);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    if (xrs.getBoolean(3)) {
                        this.xmodelo.setValueAt(false, x, 2);
                        this.xmodelo.setValueAt(false, x, 3);
                    } else {
                        this.xmodelo.setValueAt(false, x, 2);
                        this.xmodelo.setValueAt(false, x, 3);
                    }
                    this.xmodelo.setValueAt(new Integer(0), x, 4);
                    this.xmodelo.setValueAt("", x, 5);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Concepto_R.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosCE() {
        try {
            mCrearTablaCE();
            this.xsql = "SELECT `Id`, `Nbre` FROM  `so_concepto_especifico` WHERE (`Estado` =1) ORDER BY `Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTCEspecifico, 1);
                this.xmt.mEstablecerTextEditor(this.JTCEspecifico, 3);
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(false, x, 2);
                    this.xmodelo1.setValueAt("NO APLICA", x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Concepto_R.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosRC() {
    }

    public void mGrabar() {
        System.out.println("el id de atencioon: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        if (this.JLBNConcepto.getText().isEmpty()) {
            if (this.JCBTipoR.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    this.xsql = "insert into h_so_concepto_laboral (`Id_Atencion`, `Id_TipoC`, `Recomendaciones`,Id_UsuarioA, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtipor[this.JCBTipoR.getSelectedIndex()] + "','" + this.JTPRecomendacion.getText() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNConcepto.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.JBTFirmar.setEnabled(true);
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTRestricciones.getRowCount(); y++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(y, 2).toString()).booleanValue() || Boolean.valueOf(this.xmodelo.getValueAt(y, 3).toString()).booleanValue()) {
                            int xtipo = 0;
                            if (Boolean.valueOf(this.xmodelo.getValueAt(y, 2).toString()).booleanValue()) {
                                xtipo = 1;
                            } else if (Boolean.valueOf(this.xmodelo.getValueAt(y, 3).toString()).booleanValue()) {
                                xtipo = 0;
                            }
                            this.xsql = "insert into h_so_concepto_laboral_restricciones(`Id_Concepto_Lab`, `Id_Tipo_Restriccion`, `Tipo`, `NDias`, `Observacion`, `UsuarioS`) values ('" + this.JLBNConcepto.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + xtipo + "','" + this.xmodelo.getValueAt(y, 4) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    for (int y2 = 0; y2 < this.JTCEspecifico.getRowCount(); y2++) {
                        if (Boolean.valueOf(this.JTCEspecifico.getValueAt(y2, 2).toString()).booleanValue()) {
                            this.xsql = "insert into h_so_concepto_laboral_especifico(`Id_Concepto_laboral`, `Id_Concepto_Especifico`,`Tipo`, `Observacion`, `UsuarioS`) values ('" + this.JLBNConcepto.getText() + "','" + this.JTCEspecifico.getValueAt(y2, 0) + "','1','" + this.xmodelo1.getValueAt(y2, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() == 1) {
                        Principal.clasehistoriace.mActualizarVariable_ManPower("ConceptoI", this.JCBTipoR.getSelectedItem().toString(), "Observacion_CI", this.JTPRecomendacion.getText());
                    }
                    mImprimir();
                    Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
                    this.JBTAdicionar.setEnabled(false);
                    mBuscar();
                    mEnviarConceptoEmail();
                    mRegistroSVE();
                    if (Principal.xclaseso != null) {
                        Principal.xclaseso.actualizarEstadoAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdOrden(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdProcedimiento(), 2);
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoR.requestFocus();
        }
    }

    private void mRegistroSVE() {
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEsPeriodico().intValue() != 0) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdManPower() != null && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdManPower().intValue() != 0) {
                int m = JOptionPane.showInternalConfirmDialog(this, "Desea registrar el usuario?", "REGISTRO AL PROGRAMA DE SVE O SEGUIMIENTO", 1, 0);
                if (m == 0) {
                    JDRegistro_SVE dialog = new JDRegistro_SVE(this.xclase.frmPrincipal, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdManPower().intValue());
                    dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                    dialog.setVisible(true);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta clase de cita no se encuentra clasificada como periodico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mBuscar() {
        try {
            this.JCBTipoR.removeAllItems();
            this.xidtipor = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM  `so_tipo_concepto` WHERE (`Tipo` ='" + this.xmod + "' AND `Estado` =1) ORDER BY `Id` ASC", this.xidtipor, this.JCBTipoR);
            this.JCBTipoR.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `so_tipo_concepto`.`Nbre`, `h_so_concepto_laboral`.`Observacion` , `h_so_concepto_laboral`.`Id` FROM  `h_so_concepto_laboral` INNER JOIN  `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) WHERE (`h_so_concepto_laboral`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_concepto_laboral`.`Estado` =1)  ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBTipoR.setSelectedItem(xrs.getString(1));
                this.JTPRecomendacion.setText(xrs.getString(2));
                this.JLBNConcepto.setText(xrs.getString(3));
                this.JBTFirmar.setEnabled(true);
                ConsultasMySQL xct2 = new ConsultasMySQL();
                this.xsql = "SELECT `h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion`, `so_tipo_restriccion`.`Nbre`, `h_so_concepto_laboral_restricciones`.`Tipo`, `h_so_concepto_laboral_restricciones`.`NDias`, `h_so_concepto_laboral_restricciones`.`Observacion` FROM  `h_so_concepto_laboral_restricciones` INNER JOIN  `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) WHERE (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` ='" + this.JLBNConcepto.getText() + "') ORDER BY `so_tipo_restriccion`.`Nbre` ASC ";
                ResultSet rs = xct2.traerRs(this.xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    mCrearTabla();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTRestricciones, 1);
                    this.xmt.mEstablecerTextEditor(this.JTRestricciones, 5);
                    while (rs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                        this.xmodelo.setValueAt(rs.getString(2), x, 1);
                        if (xrs.getBoolean(3)) {
                            this.xmodelo.setValueAt(true, x, 2);
                        } else {
                            this.xmodelo.setValueAt(true, x, 3);
                        }
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 4);
                        this.xmodelo.setValueAt(rs.getString(5), x, 5);
                        x++;
                    }
                }
                rs.close();
                xct2.cerrarConexionBd();
                this.xsql = "SELECT `h_so_concepto_laboral_especifico`.`Id_Concepto_Especifico`, `so_concepto_especifico`.`Nbre`, `h_so_concepto_laboral_especifico`.`Tipo`, `h_so_concepto_laboral_especifico`.`Observacion` FROM  `h_so_concepto_laboral_especifico` INNER JOIN  `so_concepto_especifico`  ON (`h_so_concepto_laboral_especifico`.`Id_Concepto_Especifico` = `so_concepto_especifico`.`Id`) WHERE (`h_so_concepto_laboral_especifico`.`Id_Concepto_laboral` ='" + this.JLBNConcepto.getText() + "' AND `h_so_concepto_laboral_especifico`.`Estado` =1) ORDER BY `so_concepto_especifico`.`Nbre` ASC ";
                ResultSet rs2 = xct2.traerRs(this.xsql);
                if (rs2.next()) {
                    rs2.beforeFirst();
                    mCrearTablaCE();
                    int x2 = 0;
                    this.xmt.mEstablecerTextEditor(this.JTCEspecifico, 1);
                    this.xmt.mEstablecerTextEditor(this.JTCEspecifico, 3);
                    while (rs2.next()) {
                        this.xmodelo1.addRow(this.xdato);
                        this.xmodelo1.setValueAt(Long.valueOf(rs2.getLong(1)), x2, 0);
                        this.xmodelo1.setValueAt(rs2.getString(2), x2, 1);
                        this.xmodelo1.setValueAt(Boolean.valueOf(rs2.getBoolean(3)), x2, 2);
                        this.xmodelo1.setValueAt(rs2.getString(4), x2, 3);
                        x2++;
                    }
                }
                rs2.close();
                xct2.cerrarConexionBd();
                this.JBTAdicionar.setEnabled(false);
            } else {
                mNuevo();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Concepto_R.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarCombo() {
        this.xsql = "SELECT Recomendaciones  FROM so_tipo_concepto WHERE Nbre='" + this.JCBTipoR.getSelectedItem() + "'";
        System.out.println(this.xsql);
        try {
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    this.JTPRecomendacion.setText(rs.getString("Recomendaciones"));
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"No. Concepto", "Tipo Concepto", "Observación", "Fecha", "Url"}) { // from class: com.genoma.plus.controller.parametrizacion.JPSo_Concepto_R.9
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(6);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(130);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT  `h_so_concepto_laboral`.`Id` , `so_tipo_concepto`.`Nbre` , `h_so_concepto_laboral`.`Observacion`  , DATE_FORMAT (`h_so_concepto_laboral`.`Fecha`,'%d-%m-%Y') AS Fecha, `h_so_concepto_laboral`.Url_Soporte FROM `h_so_concepto_laboral` INNER JOIN `so_tipo_concepto`    ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) WHERE (`h_so_concepto_laboral`.`Id_UsuarioA` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `so_tipo_concepto`.`Estado` =1) ORDER BY `h_so_concepto_laboral`.`Fecha` DESC";
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
                    this.xmodeloH.addRow(this.xdato);
                    this.xmodeloH.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloH.setValueAt(xrs.getString(5), n, 4);
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
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JLBNConcepto.getText();
        mparametros[1][0] = "idatencion1";
        mparametros[1][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                System.out.println("ENTRO A IMPRESION DEL REPORTE DE CONCEPTO BIENESTAR SALUD");
                this.xmt.GenerarPdfBieneastarSalud(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), true);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Mineros", mparametros);
            mEnviarConceptoEmail();
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado", mparametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado_1", mparametros);
            mEnviarConceptoEmail();
        }
    }

    public void mImprimir2() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JLBNConcepto.getText();
        mparametros[1][0] = "idatencion1";
        mparametros[1][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                System.out.println("ENTRO A IMPRESION DEL REPORTE DE CONCEPTO BIENESTAR SALUD not bd");
                this.xmt.GenerarPdfBieneastarSalud(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Bienestar", mparametros, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()), false);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_1", mparametros);
                return;
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_SaludIntegral", mparametros);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Mineros", mparametros);
            mEnviarConceptoEmail();
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado", mparametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Firmado_1", mparametros);
            mEnviarConceptoEmail();
        }
    }

    private void mEnviarConceptoEmail() {
        String[] xdestino;
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            if (this.JTCEspecifico.getRowCount() != -1 || this.JTRestricciones.getRowCount() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea enviar correo electrónico del concepto?", "ENVIAR CORREO ELECTRÓNICO", 1, 0);
                if (x == 0) {
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "Id";
                    parametros[0][1] = this.JLBNConcepto.getText();
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + this.JLBNConcepto.getText() + ".pdf"));
                    this.xmt.CrearPDF(this.xmt.getRutaRep() + "H_So_Concepto_Aptitud_Correo", parametros, this.xmt.getRutaRep() + this.JLBNConcepto.getText());
                    if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario().equals("") && !clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailsupervisor().equals("")) {
                        xdestino = new String[1];
                        xdestino[0] = clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario();
                        xdestino[1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailsupervisor();
                        xdestino[0] = "evidencia@fundacionpanzenu.org.co";
                    } else if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario().equals("") && clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailsupervisor().equals("")) {
                        xdestino = new String[]{clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario(), "evidencia@fundacionpanzenu.org.co"};
                    } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailUsuario().equals("") && !clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailsupervisor().equals("")) {
                        xdestino = new String[]{clasesHistoriaCE.informacionAgendaMedicaDTO.getEmailsupervisor(), "evidencia@fundacionpanzenu.org.co"};
                    } else {
                        xdestino = new String[]{"evidencia@fundacionpanzenu.org.co"};
                    }
                    Email xenviar = new Email();
                    String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    xenviar.enviarAdjunto(xdestino, "Ver adjunto", remite, "CONCEPTO SALUD OCUPACIONAL - " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), this.JLBNConcepto.getText() + ".pdf", this.xmt.getRutaRep() + this.JLBNConcepto.getText() + ".pdf");
                    this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + this.JLBNConcepto.getText() + ".pdf"));
                }
            }
        }
    }
}
