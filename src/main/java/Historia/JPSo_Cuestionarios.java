package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Cuestionarios.class */
public class JPSo_Cuestionarios extends JPanel {
    public int xtipo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloR;
    private String xsql;
    private Integer idClasificacion;
    private Integer forma;
    private JButton JBTGrabar;
    public JLabel JLBNRegistro;
    private JLabel JLBResultado;
    private JLabel JLBResultado1;
    private JPanel JPIPreguntas;
    private JPanel JPIResultado;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalleP;
    private JScrollPane JSPObservacionG;
    private JTextArea JTAObservacionG;
    public JTable JTDetalleCR;
    public JTable JTDetalleP;
    private JTabbedPane JTPDatos;

    public JPSo_Cuestionarios(String xnombre, int xtipo, Integer idClasificacion) {
        this.xtipo = 1;
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, xnombre, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xtipo = xtipo;
        this.idClasificacion = idClasificacion;
        if (this.idClasificacion.intValue() != 0) {
            buscarIdCuestionarioPorIdClasificacion();
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIPreguntas = new JPanel();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalleP = new JTable();
        this.JSPObservacionG = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JPIResultado = new JPanel();
        this.JSPConsolidado = new JScrollPane();
        this.JTDetalleCR = new JTable();
        this.JLBResultado = new JLabel();
        this.JLBResultado1 = new JLabel();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CUESTIONARIOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjpcuestionarios_so");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleP.setRowHeight(25);
        this.JTDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleP.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleP.setSelectionMode(0);
        this.JTDetalleP.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Cuestionarios.1
            public void mouseClicked(MouseEvent evt) {
                JPSo_Cuestionarios.this.JTDetallePMouseClicked(evt);
            }
        });
        this.JTDetalleP.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Cuestionarios.2
            public void keyPressed(KeyEvent evt) {
                JPSo_Cuestionarios.this.JTDetallePKeyPressed(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTDetalleP);
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setTabSize(1);
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacionG.setViewportView(this.JTAObservacionG);
        GroupLayout JPIPreguntasLayout = new GroupLayout(this.JPIPreguntas);
        this.JPIPreguntas.setLayout(JPIPreguntasLayout);
        JPIPreguntasLayout.setHorizontalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleP, -1, 767, 32767).addComponent(this.JSPObservacionG)).addContainerGap(18, 32767)));
        JPIPreguntasLayout.setVerticalGroup(JPIPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleP, -1, 407, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionG, -2, 65, -2).addContainerGap()));
        this.JTPDatos.addTab("PREGUNTAS", this.JPIPreguntas);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleCR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleCR.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleCR.setRowHeight(25);
        this.JTDetalleCR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleCR.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleCR.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_Cuestionarios.3
            public void mouseClicked(MouseEvent evt) {
                JPSo_Cuestionarios.this.JTDetalleCRMouseClicked(evt);
            }
        });
        this.JTDetalleCR.addKeyListener(new KeyAdapter() { // from class: Historia.JPSo_Cuestionarios.4
            public void keyPressed(KeyEvent evt) {
                JPSo_Cuestionarios.this.JTDetalleCRKeyPressed(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTDetalleCR);
        this.JLBResultado.setFont(new Font("Arial", 1, 14));
        this.JLBResultado.setForeground(new Color(255, 9, 244));
        this.JLBResultado.setHorizontalAlignment(0);
        this.JLBResultado1.setFont(new Font("Arial", 1, 14));
        this.JLBResultado1.setForeground(new Color(255, 9, 244));
        this.JLBResultado1.setHorizontalAlignment(0);
        GroupLayout JPIResultadoLayout = new GroupLayout(this.JPIResultado);
        this.JPIResultado.setLayout(JPIResultadoLayout);
        JPIResultadoLayout.setHorizontalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPConsolidado, -1, 775, 32767).addComponent(this.JLBResultado, -1, -1, 32767).addComponent(this.JLBResultado1, -1, -1, 32767)).addContainerGap()));
        JPIResultadoLayout.setVerticalGroup(JPIResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResultadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPConsolidado, -2, 151, -2).addGap(18, 18, 18).addComponent(this.JLBResultado, -2, 43, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBResultado1, -2, 43, -2).addContainerGap(228, 32767)));
        this.JTPDatos.addTab("RESULTADO", this.JPIResultado);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSo_Cuestionarios.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_Cuestionarios.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 650, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistro, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 536, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGrabar, -2, 56, -2).addComponent(this.JLBNRegistro, -2, 55, -2)).addContainerGap(13, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePMouseClicked(MouseEvent evt) {
        mCargarResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePKeyPressed(KeyEvent evt) {
        if (this.JTDetalleP.getSelectedColumn() == 3 && evt.getKeyCode() == 10) {
            mCargarResultado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCRKeyPressed(KeyEvent evt) {
    }

    private void mCargarResultado() {
        if (this.JTDetalleP.getSelectedColumn() == 3 && !this.JLBNRegistro.getText().isEmpty() && Long.valueOf(this.xmodelo.getValueAt(this.JTDetalleP.getSelectedRow(), 6).toString()).longValue() == 0 && Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalleP.getSelectedRow(), 8).toString()).intValue() != 3) {
            JDSo_Cuestionario_Respuesta xjdrespuesta = new JDSo_Cuestionario_Respuesta(null, true, this);
            xjdrespuesta.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            xjdrespuesta.setVisible(true);
        }
    }

    private void mNuevo() {
        mCrearRegistro();
    }

    public void mGrabar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            this.xsql = "update h_so_cuestionarios_encabezado set Observacion='" + this.JTAObservacionG.getText() + "', Cerrado=1 where Id='" + this.JLBNRegistro.getText() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            for (int y = 0; y < this.JTDetalleP.getRowCount(); y++) {
                this.xsql = "update h_so_cuestionario_detalle set Observacion='" + this.xmodelo.getValueAt(y, 4) + "' where Id='" + this.xmodelo.getValueAt(y, 6) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            Principal.clasehistoriace.mCambiarEstadoOrdenProcedimiento();
            mCargarDatosTabla(1);
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            this.JBTGrabar.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaS() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "N°", "Pregunta", "Respuesta", "Observación", "ManejaSub", "id_cuestionario", "ValorC", "Tipo"}) { // from class: Historia.JPSo_Cuestionarios.6
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleP.setModel(this.xmodelo);
        this.JTDetalleP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalleP.getColumnModel().getColumn(2).setPreferredWidth(410);
        this.JTDetalleP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleP.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalleP.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleP.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Id", "Dimensión", "Puntaje", "Promedio"}) { // from class: Historia.JPSo_Cuestionarios.7
            Class[] types = {Long.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleCR.setModel(this.xmodeloR);
        this.JTDetalleCR.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleCR.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleCR.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleCR.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTabla(int xforma) {
        try {
            mCrearModeloTablaS();
            if (xforma == 0) {
                this.xsql = "SELECT so_tipo_preguntas.`Id`, so_tipo_preguntas.`Nbre`, so_tipo_preguntas.`Maneja_Sub` , str.Tipo \nFROM `so_tipo_preguntas` \ninner join so_tipo_pregunta_respuesta stpr on (stpr.Id_Pregunta=so_tipo_preguntas.Id)\ninner join so_tipo_respuesta str on (str.Id=stpr.Id_Tipo_Respuesta)\nWHERE (so_tipo_preguntas.`Id_TipoC` =" + this.xtipo + " AND so_tipo_preguntas.`Estado` =1)\ngroup by so_tipo_preguntas.`Id`\nORDER BY so_tipo_preguntas.`Orden` ASC ";
            } else {
                this.xsql = "SELECT `so_tipo_preguntas`.`Id`, `so_tipo_preguntas`.`Nbre`, `so_tipo_preguntas`.`Maneja_Sub` , `h_so_cuestionario_detalle`.`ValorR`, IF(`h_so_cuestionario_detalle`.`Observacion` IS NULL,'',`h_so_cuestionario_detalle`.`Observacion`)  AS ObsP, `h_so_cuestionario_detalle`.`Id`, IF(`h_so_cuestionarios_encabezado`.`Observacion` IS NULL,'',`h_so_cuestionarios_encabezado`.`Observacion`) AS ObsP, `h_so_cuestionarios_encabezado`.`Cerrado`, 0  Tipo FROM  `h_so_cuestionario_detalle` INNER JOIN  `h_so_cuestionarios_encabezado`  ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`) INNER JOIN  `so_tipo_preguntas`  ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) WHERE (`h_so_cuestionarios_encabezado`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `h_so_cuestionarios_encabezado`.`Id_Cuestionario` ='" + this.xtipo + "' AND `h_so_cuestionarios_encabezado`.`Estado` =1) ORDER BY `so_tipo_preguntas`.`Orden` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalleP, 2);
                this.xmt.mEstablecerTextEditor(this.JTDetalleP, 4);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(x + 1), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), x, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("Tipo")), x, 8);
                    if (xforma == 0) {
                        this.xmodelo.setValueAt("", x, 3);
                        this.xmodelo.setValueAt("", x, 4);
                        this.xmodelo.setValueAt(0, x, 6);
                    } else {
                        this.JTAObservacionG.setText(xrs.getString(7));
                        this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                        this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), x, 6);
                        if (xrs.getBoolean(8)) {
                            this.JBTGrabar.setEnabled(false);
                        } else {
                            this.JBTGrabar.setEnabled(true);
                        }
                    }
                    x++;
                }
                mCargarDatosC();
            } else {
                mCargarDatosTabla(0);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearRegistro() {
        try {
            this.xsql = "SELECT `Id` FROM `h_so_cuestionarios_encabezado` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Cuestionario ='" + this.xtipo + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNRegistro.setText(xrs.getString(1));
                mCargarDatosTabla(1);
                this.forma = 1;
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                this.xsql = "insert into h_so_cuestionarios_encabezado(`Id_Usuario`,`Id_Atencion`, `FechaR`, `Id_Cuestionario`, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xtipo + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                this.xct.cerrarConexionBd();
                mCargarDatosTabla(0);
                this.forma = 0;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        if (!this.JLBNRegistro.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.JLBNRegistro.getText();
            mparametros[1][0] = "P1";
            mparametros[1][1] = this.JLBResultado.getText();
            mparametros[2][0] = "P2";
            mparametros[2][1] = this.JLBResultado1.getText();
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (this.xtipo == 12) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Fatiga", mparametros);
                    return;
                }
                if (this.xtipo == 9) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_Estilo_Afronamiento", mparametros);
                    return;
                } else if (this.xtipo == 10 || this.xtipo == 11) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral", mparametros);
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario_FIntalaboral_Consolidado", mparametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
                    return;
                }
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Cuestionario", mparametros);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_Cuestionarios$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 5).toString()).longValue() == 0) {
                cell.setBackground(new Color(255, 102, 0));
            } else {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    private void mCargarDatosC() {
        try {
            mCrearModeloTablaR();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "";
            if (this.xtipo == 9) {
                this.xsql = "SELECT `so_tipo_pregunta_dimension`.`Id`, `so_tipo_pregunta_dimension`.`Nbre` AS `Dimension`, SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`) AS `SValor` , (SUM(`so_tipo_pregunta_respuesta`.`VCuantitativo`)/COUNT(`h_so_cuestionario_detalle`.`Id_Pregunta`)) as total     FROM  `h_so_cuestionario_detalle` INNER JOIN `h_so_cuestionarios_encabezado` ON (`h_so_cuestionario_detalle`.`Id_Cuestionario` = `h_so_cuestionarios_encabezado`.`Id`) INNER JOIN `so_tipo_preguntas` ON (`h_so_cuestionario_detalle`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) INNER JOIN `so_tipo_cuestionario` ON (`h_so_cuestionarios_encabezado`.`Id_Cuestionario` = `so_tipo_cuestionario`.`Id`) INNER JOIN `so_tipo_pregunta_dimension` ON (`so_tipo_preguntas`.`Id_Dimension` = `so_tipo_pregunta_dimension`.`Id`) INNER JOIN `so_tipo_pregunta_dominio` ON (`so_tipo_pregunta_dimension`.`Id_Dominio` = `so_tipo_pregunta_dominio`.`Id`) INNER JOIN `so_tipo_respuesta` ON (`h_so_cuestionario_detalle`.`Id_Respuesta` = `so_tipo_respuesta`.`Id`) INNER JOIN `so_tipo_pregunta_respuesta` ON (`so_tipo_pregunta_respuesta`.`Id_Pregunta` = `so_tipo_preguntas`.`Id`) AND (`so_tipo_pregunta_respuesta`.`Id_Tipo_Respuesta` = `so_tipo_respuesta`.`Id`) WHERE (`h_so_cuestionarios_encabezado`.`Id` ='" + this.JLBNRegistro.getText() + "'  AND `h_so_cuestionarios_encabezado`.`Estado`=1) GROUP BY `so_tipo_pregunta_dimension`.`Id` ";
            }
            if (!this.xsql.equals("")) {
                ResultSet xrs1 = xct1.traerRs(this.xsql);
                if (xrs1.next()) {
                    xrs1.beforeFirst();
                    int x = 0;
                    while (xrs1.next()) {
                        this.xmodeloR.addRow(this.xdatos);
                        this.xmodeloR.setValueAt(Long.valueOf(xrs1.getLong(1)), x, 0);
                        this.xmodeloR.setValueAt(xrs1.getString(2), x, 1);
                        this.xmodeloR.setValueAt(Double.valueOf(xrs1.getDouble(3)), x, 2);
                        this.xmodeloR.setValueAt(Double.valueOf(xrs1.getDouble(4)), x, 3);
                        x++;
                    }
                    if (this.xtipo == 9) {
                        if (Double.valueOf(this.xmodeloR.getValueAt(0, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() || Double.valueOf(this.xmodeloR.getValueAt(1, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue()) {
                            this.JLBResultado.setText("PREVALECE EL ENFRENTAMIENTO ACTIVO DE LAS TENSIONES Y SUS ORIGENES - VERDADERO");
                        } else {
                            this.JLBResultado.setText("PREVALECE EL ENFRENTAMIENTO ACTIVO DE LAS TENSIONES Y SUS ORIGENES - FALSO");
                        }
                        if (Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(0, 3).toString()).doubleValue() || Double.valueOf(this.xmodeloR.getValueAt(2, 3).toString()).doubleValue() > Double.valueOf(this.xmodeloR.getValueAt(1, 3).toString()).doubleValue()) {
                            this.JLBResultado1.setText("ENFRENTAMIENTO PREDOMINANTE EVITATIVO DE LAS SITUACIONES GENERADORAS DE TENSIÓN - FALSO");
                        } else {
                            this.JLBResultado1.setText("ENFRENTAMIENTO PREDOMINANTE EVITATIVO DE LAS SITUACIONES GENERADORAS DE TENSIÓN - FALSO");
                        }
                    }
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarIdCuestionarioPorIdClasificacion() {
        try {
            this.xsql = "SELECT Id from so_tipo_cuestionario where so_tipo_cuestionario.idClasificacion =" + this.idClasificacion + " and so_tipo_cuestionario.Estado =1";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xtipo = xrs.getInt("Id");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_Cuestionarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
