package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_PEjercicio.class */
public class JPSo_PEjercicio extends JPanel {
    private String[] xidtipor;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private clasesHistoriaCE xclase;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloh;
    private Object[] xdato;
    private JButton JBTAdicionar;
    private JLabel JLBNConcepto;
    private JPanel JPHistorico;
    private JPanel JPIDatosC;
    private JScrollPane JSPActividades;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTable JTActividades;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JTextPane JTPObservacion;

    public JPSo_PEjercicio(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mBuscar();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosC = new JPanel();
        this.JSPActividades = new JScrollPane();
        this.JTActividades = new JTable();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JBTAdicionar = new JButton();
        this.JLBNConcepto = new JLabel();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpprescripcionejercicio");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPActividades.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTIVIDADES", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTActividades.setFont(new Font("Arial", 1, 12));
        this.JTActividades.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTActividades.setRowHeight(25);
        this.JTActividades.setSelectionBackground(new Color(255, 255, 255));
        this.JTActividades.setSelectionForeground(new Color(255, 0, 0));
        this.JTActividades.setSelectionMode(0);
        this.JTActividades.addFocusListener(new FocusAdapter() { // from class: Historia.JPSo_PEjercicio.1
            public void focusLost(FocusEvent evt) {
                JPSo_PEjercicio.this.JTActividadesFocusLost(evt);
            }
        });
        this.JTActividades.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPSo_PEjercicio.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPSo_PEjercicio.this.JTActividadesPropertyChange(evt);
            }
        });
        this.JTActividades.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_PEjercicio.3
            public void keyPressed(KeyEvent evt) {
                JPSo_PEjercicio.this.JTActividadesKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JPSo_PEjercicio.this.JTActividadesKeyReleased(evt);
            }
        });
        this.JSPActividades.setViewportView(this.JTActividades);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación General", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPSo_PEjercicio.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_PEjercicio.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JLBNConcepto.setFont(new Font("Arial", 1, 18));
        this.JLBNConcepto.setForeground(new Color(255, 0, 0));
        this.JLBNConcepto.setHorizontalAlignment(0);
        this.JLBNConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Concepto", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JBTAdicionar, -2, 639, -2).addGap(10, 10, 10).addComponent(this.JLBNConcepto, -1, 140, 32767)).addComponent(this.JSPActividades)).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPActividades, -1, 260, 32767).addGap(6, 6, 6).addComponent(this.JSPObservacion, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBNConcepto, -1, -1, 32767).addComponent(this.JBTAdicionar, -1, 62, 32767)).addContainerGap()));
        this.JTPDatos.addTab("PRESCRIPCIÓN DE ACTIVIDAD FÍSICA", this.JPIDatosC);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_PEjercicio.5
            public void mouseClicked(MouseEvent evt) {
                JPSo_PEjercicio.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 789, 32767).addGap(14, 14, 14)));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 267, -2).addContainerGap(157, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTActividadesKeyPressed(KeyEvent evt) {
        mSeleccionarAplicar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTActividadesFocusLost(FocusEvent evt) {
        mSeleccionarAplicar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTActividadesKeyReleased(KeyEvent evt) {
        mSeleccionarAplicar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTActividadesPropertyChange(PropertyChangeEvent evt) {
        mSeleccionarAplicar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.JLBNConcepto.setText(this.xmodeloh.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            mImprimir();
        }
    }

    private void mSeleccionarAplicar() {
        if (this.JTActividades.getRowCount() != -1) {
            for (int x = 0; x < this.JTActividades.getRowCount(); x++) {
                if (!this.JTActividades.getValueAt(x, 3).equals("")) {
                    this.xmodelo.setValueAt(true, x, 4);
                } else {
                    this.xmodelo.setValueAt(false, x, 4);
                }
            }
        }
    }

    public void mNuevo() {
        this.JLBNConcepto.setText("");
        this.JTPObservacion.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Ejercicio", "Forma de Realización", "Aplica?"}) { // from class: Historia.JPSo_PEjercicio.6
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTActividades.setModel(this.xmodelo);
        this.JTActividades.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTActividades.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTActividades.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTActividades.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTActividades.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTActividades.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTActividades.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    public void mGrabar() {
        if (this.JLBNConcepto.getText().isEmpty()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTActividades, 4)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "insert into h_so_pejercicio (`Id_Atencion`, `Observacion`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLBNConcepto.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTActividades.getRowCount(); y++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(y, 4).toString()).booleanValue()) {
                            this.xsql = "insert into h_so_pejercicio_detalle (`Id_Prescrpcion`, `Id_TEjercicio`, `FRealizacion`) values('" + this.JLBNConcepto.getText() + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    this.JBTAdicionar.setEnabled(false);
                    mImprimir();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existen datos seleccionado para grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mBuscar() {
        try {
            this.xsql = "SELECT `so_tipo_ejercicio`.`Id`, `so_encabezado`.`Nbre`, `so_tipo_ejercicio`.`Nbre`, `h_so_pejercicio_detalle`.`FRealizacion`, h_so_pejercicio.`Observacion`, `h_so_pejercicio`.Id FROM  `h_so_pejercicio_detalle` INNER JOIN `h_so_pejercicio`  ON (`h_so_pejercicio_detalle`.`Id_Prescrpcion` = `h_so_pejercicio`.`Id`) INNER JOIN  `so_tipo_ejercicio`  ON (`h_so_pejercicio_detalle`.`Id_TEjercicio` = `so_tipo_ejercicio`.`Id`) INNER JOIN  `so_encabezado`  ON (`so_tipo_ejercicio`.`Id_Encabezado` = `so_encabezado`.`Id`) WHERE (`h_so_pejercicio`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_pejercicio`.`Estado` =1) ORDER BY `so_encabezado`.`Orden` ASC, `so_tipo_ejercicio`.`Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearTabla();
            if (xrs.next()) {
                xrs.first();
                this.JLBNConcepto.setText(xrs.getString(6));
                this.JTPObservacion.setText(xrs.getString(5));
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTActividades, 3);
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 3);
                    this.xmodelo.setValueAt(true, x, 4);
                    x++;
                }
                this.JBTAdicionar.setEnabled(false);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                mNuevo();
                ConsultasMySQL xct1 = new ConsultasMySQL();
                this.xsql = "SELECT `so_tipo_ejercicio`.`Id`, `so_encabezado`.`Nbre`, `so_tipo_ejercicio`.`Nbre` FROM `so_tipo_ejercicio` INNER JOIN `so_encabezado`  ON (`so_tipo_ejercicio`.`Id_Encabezado` = `so_encabezado`.`Id`) WHERE (`so_tipo_ejercicio`.`Estado` =1) ORDER BY `so_encabezado`.`Orden` ASC, `so_tipo_ejercicio`.`Orden` ASC ";
                ResultSet xrs1 = xct1.traerRs(this.xsql);
                this.xmt.mEstablecerTextEditor(this.JTActividades, 3);
                if (xrs1.next()) {
                    xrs1.beforeFirst();
                    int x2 = 0;
                    while (xrs1.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs1.getInt(1)), x2, 0);
                        this.xmodelo.setValueAt(xrs1.getString(2), x2, 1);
                        this.xmodelo.setValueAt(xrs1.getString(3), x2, 2);
                        this.xmodelo.setValueAt("", x2, 3);
                        this.xmodelo.setValueAt(false, x2, 4);
                        x2++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_PEjercicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBNConcepto.getText().isEmpty()) {
            Object[] botones1 = {"Visualizar", "Enviar a correo electronico", "Cerrar"};
            int x = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "VISUALIZACION", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones1, "Cerrar");
            if (x != 0) {
                if (x == 1) {
                    mEnviarEmailRecordatorio();
                    return;
                }
                return;
            }
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNConcepto.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Prescipcion_Ejercicio", mparametros);
        }
    }

    private void mEnviarEmailRecordatorio() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JLBNConcepto.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            Email xenviar = new Email();
            this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + this.JLBNConcepto.getText() + ".pdf"));
            this.xmt.CrearPDF(this.xmt.getRutaRep() + "H_So_Prescipcion_Ejercicio", mparametros, this.xmt.getRutaRep() + this.JLBNConcepto.getText());
            String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            List<String> correoE = new ArrayList<>();
            correoE.add("cdeportes_1@fundacionpanzenu.org.co");
            xenviar.enviarAdjunto(correoE, "Ver adjunto", remite, "PRESCRIPCIÓN DE EJERCICIO SEÑOR(A) " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario(), this.JLBNConcepto.getText() + ".pdf", this.xmt.getRutaRep() + this.JLBNConcepto.getText() + ".pdf");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "Id"}) { // from class: Historia.JPSo_PEjercicio.7
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloh);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT  `h_so_pejercicio`.`Id_Atencion`  , `h_atencion`.`Fecha_Atencion` , `profesional1`.`NProfesional`, h_so_pejercicio.`Id` FROM `h_so_pejercicio` INNER JOIN `h_atencion`  ON (`h_so_pejercicio`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdato);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloh.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_PEjercicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
