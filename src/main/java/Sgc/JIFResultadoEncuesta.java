package Sgc;

import Acceso.Principal;
import Informes.JFGrafico;
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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFResultadoEncuesta.class */
public class JIFResultadoEncuesta extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String[] xidencuesta;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private JButton JBTEnviarCorreo;
    public JButton JBTGrafico;
    private JButton JBTGrafico1;
    private JComboBox JCBEncuesta;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBPromedio;
    private JPanel JPIDatos;
    private JPanel JPObservacion;
    private JScrollPane JSPConsolidadoR;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPPreguntas;
    private JFormattedTextField JTFFNAsignadas;
    private JFormattedTextField JTFFNDiferencia;
    private JFormattedTextField JTFFNRespondida;
    private JFormattedTextField JTFFPParticipacion;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTextPane JTPObservacion;
    public JTable JTPreguntas;
    public JTable JTRespuesta;
    private JPanel jPanel1;

    public JIFResultadoEncuesta() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v81, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEncuesta = new JComboBox();
        this.JSPConsolidadoR = new JScrollPane();
        this.JTRespuesta = new JTable();
        this.JBTGrafico = new JButton();
        this.JBTGrafico1 = new JButton();
        this.JTFRuta = new JTextField();
        this.jPanel1 = new JPanel();
        this.JTFFNAsignadas = new JFormattedTextField();
        this.JTFFNRespondida = new JFormattedTextField();
        this.JTFFNDiferencia = new JFormattedTextField();
        this.JTFFPParticipacion = new JFormattedTextField();
        this.JBTEnviarCorreo = new JButton();
        this.JLBPromedio = new JLabel();
        this.JTPDatos = new JTabbedPane();
        this.JSPPreguntas = new JScrollPane();
        this.JTPreguntas = new JTable();
        this.JPObservacion = new JPanel();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        setClosable(true);
        setIconifiable(true);
        setTitle("RESULTADO ENCUESTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifresultadoencuesta");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEncuesta.setFont(new Font("Arial", 1, 12));
        this.JCBEncuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Encuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEncuesta, 0, 675, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JCBEncuesta)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 58, -2).addComponent(this.JDFechaF, -1, -1, 32767)))).addContainerGap()));
        this.JSPConsolidadoR.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO DE RESPUESTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPConsolidadoR.setFont(new Font("Arial", 1, 12));
        this.JTRespuesta.setFont(new Font("Arial", 1, 12));
        this.JTRespuesta.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTRespuesta.setRowHeight(25);
        this.JTRespuesta.setSelectionBackground(new Color(255, 255, 255));
        this.JTRespuesta.setSelectionForeground(Color.red);
        this.JTRespuesta.setSelectionMode(0);
        this.JSPConsolidadoR.setViewportView(this.JTRespuesta);
        this.JBTGrafico.setFont(new Font("Arial", 1, 12));
        this.JBTGrafico.setForeground(Color.red);
        this.JBTGrafico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.JBTGrafico.setText("Ver Grafico");
        this.JBTGrafico.setName("BotonU");
        this.JBTGrafico.addActionListener(new ActionListener() { // from class: Sgc.JIFResultadoEncuesta.1
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoEncuesta.this.JBTGraficoActionPerformed(evt);
            }
        });
        this.JBTGrafico1.setFont(new Font("Arial", 1, 12));
        this.JBTGrafico1.setForeground(Color.red);
        this.JBTGrafico1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGrafico1.setText("Exportar");
        this.JBTGrafico1.addActionListener(new ActionListener() { // from class: Sgc.JIFResultadoEncuesta.2
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoEncuesta.this.JBTGrafico1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFResultadoEncuesta.3
            public void mouseClicked(MouseEvent evt) {
                JIFResultadoEncuesta.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS GENERALES ENCUESTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNAsignadas.setEditable(false);
        this.JTFFNAsignadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Asignadas", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNAsignadas.setForeground(Color.red);
        this.JTFFNAsignadas.setHorizontalAlignment(0);
        this.JTFFNAsignadas.setFont(new Font("Arial", 1, 18));
        this.JTFFNRespondida.setEditable(false);
        this.JTFFNRespondida.setBorder(BorderFactory.createTitledBorder((Border) null, "Respondidas", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNRespondida.setForeground(Color.red);
        this.JTFFNRespondida.setHorizontalAlignment(0);
        this.JTFFNRespondida.setFont(new Font("Arial", 1, 18));
        this.JTFFNDiferencia.setEditable(false);
        this.JTFFNDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Faltante", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFNDiferencia.setForeground(Color.red);
        this.JTFFNDiferencia.setHorizontalAlignment(0);
        this.JTFFNDiferencia.setFont(new Font("Arial", 1, 18));
        this.JTFFPParticipacion.setEditable(false);
        this.JTFFPParticipacion.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFPParticipacion.setForeground(Color.red);
        this.JTFFPParticipacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPParticipacion.setHorizontalAlignment(0);
        this.JTFFPParticipacion.setFont(new Font("Arial", 1, 18));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFFNAsignadas, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNRespondida, -1, 167, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNDiferencia, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPParticipacion, -2, 46, -2).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNAsignadas, -2, -1, -2).addComponent(this.JTFFNRespondida, -2, -1, -2).addComponent(this.JTFFNDiferencia, -2, -1, -2).addComponent(this.JTFFPParticipacion, -2, -1, -2)).addContainerGap(22, 32767)));
        this.JBTEnviarCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTEnviarCorreo.setForeground(Color.red);
        this.JBTEnviarCorreo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/enviar.png")));
        this.JBTEnviarCorreo.setText("Enviar Correo de Recordatorio");
        this.JBTEnviarCorreo.setEnabled(false);
        this.JBTEnviarCorreo.addActionListener(new ActionListener() { // from class: Sgc.JIFResultadoEncuesta.4
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoEncuesta.this.JBTEnviarCorreoActionPerformed(evt);
            }
        });
        this.JLBPromedio.setFont(new Font("Arial", 1, 12));
        this.JLBPromedio.setForeground(Color.red);
        this.JLBPromedio.setHorizontalAlignment(0);
        this.JLBPromedio.setBorder(BorderFactory.createTitledBorder((Border) null, "Promedio", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPPreguntas.setFont(new Font("Arial", 1, 12));
        this.JTPreguntas.setFont(new Font("Arial", 1, 12));
        this.JTPreguntas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPreguntas.setRowHeight(25);
        this.JTPreguntas.setSelectionBackground(new Color(255, 255, 255));
        this.JTPreguntas.setSelectionForeground(Color.red);
        this.JTPreguntas.setSelectionMode(0);
        this.JTPreguntas.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFResultadoEncuesta.5
            public void mouseClicked(MouseEvent evt) {
                JIFResultadoEncuesta.this.JTPreguntasMouseClicked(evt);
            }
        });
        this.JSPPreguntas.setViewportView(this.JTPreguntas);
        this.JTPDatos.addTab("PREGUNTAS", this.JSPPreguntas);
        this.JSPObservacion.setAutoscrolls(true);
        this.JTPObservacion.setContentType("text/html");
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPObservacionLayout = new GroupLayout(this.JPObservacion);
        this.JPObservacion.setLayout(JPObservacionLayout);
        JPObservacionLayout.setHorizontalGroup(JPObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 561, 32767).addGroup(JPObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPObservacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPObservacion, -2, 541, -2).addContainerGap(-1, 32767))));
        JPObservacionLayout.setVerticalGroup(JPObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 512, 32767).addGroup(JPObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObservacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion, -2, 490, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("OBSERVACIÓN", this.JPObservacion);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrafico, -1, 427, 32767).addComponent(this.JBTGrafico1, -1, 427, 32767).addComponent(this.JSPConsolidadoR, GroupLayout.Alignment.TRAILING, -1, 427, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JBTEnviarCorreo, -1, 427, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBPromedio, -1, -1, 32767)))).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JSPConsolidadoR, -2, 195, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JLBPromedio, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEnviarCorreo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGrafico, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrafico1, -2, 50, -2)).addComponent(this.JTPDatos)).addContainerGap(40, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPreguntasMouseClicked(MouseEvent evt) {
        if (this.JTPreguntas.getSelectedRow() != -1) {
            mCargarDatosTablaTRespuesta();
            this.JLBPromedio.setText(this.xmodelo.getValueAt(this.JTPreguntas.getSelectedRow(), 3).toString());
            mLlenarObservacionesPregunta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGraficoActionPerformed(ActionEvent evt) {
        if (this.JTRespuesta.getRowCount() > -1 && this.JTPreguntas.getSelectedRow() != -1) {
            JFGrafico demo = new JFGrafico(this);
            demo.pack();
            demo.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrafico1ActionPerformed(ActionEvent evt) {
        if (this.JCBEncuesta.getSelectedIndex() != -1) {
            mExportar();
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
    public void JBTEnviarCorreoActionPerformed(ActionEvent evt) {
        this.xsql = "SELECT persona.NUsuario, persona.Corre  FROM persona INNER JOIN t_e_tipo_encuesta_detalle  ON (persona.Id_persona = t_e_tipo_encuesta_detalle.Id_UsuarioG) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_e_tipo_encuesta_detalle.Diligencio =0) ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de enviar el correo", "Confirmación", 0);
                if (x == 0) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String xmensaje = "Señor(a),\nSe le recuerda que usted tiene la encuesta : " + this.JCBEncuesta.getSelectedItem().toString() + ", pendiente por respoder.\nFavor entrar a Genoma y diligenciarla.";
                        this.xmt.mEnvioCorreoElectronico(xmensaje, xrs.getString(2), "Encuesta Pendiente por Responder", Principal.usuarioSistemaDTO.getLogin());
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    WritableSheet sheet1 = workbook.createSheet("Observaciones", 1);
                    this.xsql = "SELECT t_epregunta.Id_tipor, t_etipo_r.Nbre FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) INNER JOIN t_etipo_respuesta  ON (t_detalle_encuesta_registro.Id_Respuesta = t_etipo_respuesta.Id) INNER JOIN t_etipo_r  ON (t_etipo_respuesta.Id_tipor = t_etipo_r.Id) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.FechaEncuestas >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_encuestas_registro.FechaEncuestas <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY t_epregunta.Id_tipor ";
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    ResultSet rs1 = xct2.traerRs(this.xsql);
                    if (rs1.next()) {
                        rs1.beforeFirst();
                        int xposfil = 1;
                        while (rs1.next()) {
                            ConsultasMySQL xct3 = new ConsultasMySQL();
                            this.xsql = "SELECT Id, Nbre FROM t_etipo_respuesta WHERE (Id_tipor ='" + rs1.getInt(1) + "')";
                            ResultSet rs2 = xct3.traerRs(this.xsql);
                            String[][] xidatos = (String[][]) null;
                            if (rs2.next()) {
                                rs2.last();
                                int x = 1;
                                int y = 0;
                                xidatos = new String[rs2.getRow()][2];
                                rs2.beforeFirst();
                                while (rs2.next()) {
                                    sheet.addCell(new Label(x, xposfil, rs2.getString(2)));
                                    xidatos[y][0] = String.valueOf(x);
                                    xidatos[y][1] = rs2.getString(1);
                                    y++;
                                    x++;
                                }
                            }
                            rs2.close();
                            xct3.cerrarConexionBd();
                            xposfil++;
                            this.xsql = "SELECT t_epregunta.Id, t_epregunta.Nbre, t_etipo_respuesta.Id, t_etipo_respuesta.Nbre, count(t_detalle_encuesta_registro.Id_Respuesta), t_epregunta.Id_tipor FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) INNER JOIN t_etipo_respuesta  ON (t_detalle_encuesta_registro.Id_Respuesta = t_etipo_respuesta.Id) INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.FechaEncuestas >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_encuestas_registro.FechaEncuestas <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND t_epregunta.Id_tipor ='" + rs1.getInt(1) + "' ) GROUP BY t_epregunta.Id ";
                            ResultSet xrs = this.xct.traerRs(this.xsql);
                            if (xrs.next()) {
                                xrs.beforeFirst();
                                System.out.println(xidatos.length);
                                while (xrs.next()) {
                                    sheet.addCell(new Label(0, xposfil, xrs.getString(2)));
                                    xposfil++;
                                    for (int z = 0; z < xidatos.length; z++) {
                                        this.xsql = "SELECT COUNT(t_detalle_encuesta_registro.Id_Respuesta) FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) INNER JOIN t_etipo_respuesta  ON (t_detalle_encuesta_registro.Id_Respuesta = t_etipo_respuesta.Id) INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.FechaEncuestas >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_encuestas_registro.FechaEncuestas <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'AND t_epregunta.Id ='" + xrs.getString(1) + "' AND t_etipo_respuesta.Id ='" + xidatos[z][1] + "') GROUP BY t_etipo_respuesta.Id ";
                                        System.out.println("pos c " + xidatos[z][0]);
                                        System.out.println("valor " + xidatos[z][1]);
                                        ConsultasMySQL xct4 = new ConsultasMySQL();
                                        ResultSet rs4 = xct4.traerRs(this.xsql);
                                        if (rs4.next()) {
                                            rs4.first();
                                            sheet.addCell(new Number(Integer.valueOf(xidatos[z][0]).intValue(), xposfil - 1, rs4.getInt(1)));
                                        } else {
                                            sheet.addCell(new Number(Integer.valueOf(xidatos[z][0]).intValue(), xposfil - 1, new Integer(0).intValue()));
                                        }
                                        rs4.close();
                                        xct4.cerrarConexionBd();
                                    }
                                }
                            }
                            xrs.close();
                            this.xct.cerrarConexionBd();
                        }
                    }
                    rs1.close();
                    xct2.cerrarConexionBd();
                    ConsultasMySQL xct42 = new ConsultasMySQL();
                    int p = 1;
                    this.xsql = "SELECT t_encuestas_registro.Id_TipoEncuestaD, t_encuestas_registro.ObservacionG  FROM t_encuestas_registro INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id)  WHERE (t_encuestas_registro.FechaEncuestas >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_encuestas_registro.FechaEncuestas <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.ObservacionG<>'') ";
                    ResultSet rs42 = xct42.traerRs(this.xsql);
                    if (rs42.next()) {
                        rs42.beforeFirst();
                        sheet1.addCell(new Label(0, 0, "GENERALES"));
                        while (rs42.next()) {
                            sheet1.addCell(new Label(0, p, rs42.getString(2)));
                            p++;
                        }
                    }
                    rs42.close();
                    xct42.cerrarConexionBd();
                    this.xsql = "SELECT t_epregunta.Nbre , t_detalle_encuesta_registro.ObservacionG FROM t_encuestas_registro INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) INNER JOIN t_detalle_encuesta_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) WHERE (t_encuestas_registro.FechaEncuestas >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_encuestas_registro.FechaEncuestas <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' and  t_detalle_encuesta_registro.ObservacionG <>'')  ORDER BY t_epregunta.Nbre DESC ";
                    ResultSet rs43 = xct42.traerRs(this.xsql);
                    if (rs43.next()) {
                        rs43.beforeFirst();
                        int p2 = p + 3;
                        sheet1.addCell(new Label(0, p2, "ESPECIFICAS POR PREGUNTA"));
                        int p3 = p2 + 1;
                        while (rs43.next()) {
                            sheet1.addCell(new Label(0, p3, rs43.getString(1)));
                            sheet1.addCell(new Label(1, p3, rs43.getString(2)));
                            p3++;
                        }
                    }
                    rs43.close();
                    xct42.cerrarConexionBd();
                    workbook.write();
                    workbook.close();
                    return;
                } catch (WriteException e) {
                    Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, e);
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ubicación", "Validación", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JTFRuta.requestFocus();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBEncuesta.removeAllItems();
        this.xsql = "SELECT t_e_tipo_encuesta.Id, CONCAT(t_encuestas.Nbre,' - ', t_e_tipo_encuesta.`Nbre`)  FROM t_e_tipo_encuesta_detalle INNER JOIN t_e_tipo_encuesta  ON (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta = t_e_tipo_encuesta.Id)  INNER JOIN t_encuestas  ON (t_e_tipo_encuesta.Id_TipoEncuesta = t_encuestas.Id) INNER JOIN s_sgc_tipoproceso  ON (t_e_tipo_encuesta.Id_TipoProceso = s_sgc_tipoproceso.Id)  INNER JOIN s_sgc_procesos  ON (s_sgc_tipoproceso.Id_Proceso = s_sgc_procesos.Id) WHERE (t_e_tipo_encuesta.Id_TipoProceso ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "' and t_e_tipo_encuesta.Estado=1)  group  by t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ORDER BY t_encuestas.Nbre ASC ";
        this.xidencuesta = this.xct.llenarCombo(this.xsql, this.xidencuesta, this.JCBEncuesta);
        this.JCBEncuesta.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFFNAsignadas.setValue(new Integer(0));
        this.JTFFNDiferencia.setValue(new Integer(0));
        this.JTFFNRespondida.setValue(new Integer(0));
        this.JTFFPParticipacion.setValue(new Integer(0));
        this.JTFRuta.setText("C:\\plantilla");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Drescripción", "NEncuesta", "%"}) { // from class: Sgc.JIFResultadoEncuesta.6
            Class[] types = {Long.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPreguntas.setModel(this.xmodelo);
        this.JTPreguntas.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTPreguntas.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTPreguntas.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosR() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Drescripción", "Cantidad", "%"}) { // from class: Sgc.JIFResultadoEncuesta.7
            Class[] types = {Long.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRespuesta.setModel(this.xmodelo1);
        this.JTRespuesta.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTRespuesta.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTRespuesta.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTRespuesta.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosTablaPregunta() {
        try {
            this.xsql = "SELECT t_detalle_encuesta_registro.Id_Pregunta, t_epregunta.Nbre, COUNT(DISTINCT(t_encuestas_registro.Id)) AS Cantidad, IF(t_epregunta.`CValor`=1,ROUND((SUM(t_detalle_encuesta_registro.ValorN)/COUNT(DISTINCT(t_encuestas_registro.Id))),2),0)  AS promedio  FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' and t_encuestas_registro.FechaEncuestas>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' and t_encuestas_registro.FechaEncuestas<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' ) GROUP BY t_epregunta.Nbre ";
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                this.JTFFNRespondida.setValue(Long.valueOf(xrs.getLong(3)));
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaTRespuesta() {
        this.xsql = "SELECT t_etipo_respuesta.Id, t_etipo_respuesta.Nbre FROM t_etipo_respuesta INNER JOIN t_etipo_r   ON (t_etipo_respuesta.Id_tipor = t_etipo_r.Id) INNER JOIN t_epregunta  ON (t_epregunta.Id_tipor = t_etipo_r.Id) WHERE (t_epregunta.Id ='" + this.xmodelo.getValueAt(this.JTPreguntas.getSelectedRow(), 0) + "') ";
        mCrearModeloDatosR();
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Integer.valueOf(mBuscarResultadoRespuesta(xrs.getInt(1))), n, 2);
                    this.xmodelo1.setValueAt(Double.valueOf((Long.valueOf(this.xmodelo1.getValueAt(n, 2).toString()).longValue() / Double.valueOf(this.JTFFNRespondida.getValue().toString()).doubleValue()) * 100.0d), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mBuscarResultadoRespuesta(int xidrespuesta) {
        int xvalor = 0;
        try {
            this.xsql = "SELECT COUNT(t_detalle_encuesta_registro.Id_Encuestas) FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro  ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id) INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id) INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id) INNER JOIN t_etipo_respuesta  ON (t_detalle_encuesta_registro.Id_Respuesta = t_etipo_respuesta.Id) WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_e_tipo_encuesta_detalle.`Estado`=1 AND t_detalle_encuesta_registro.Id_Pregunta ='" + this.xmodelo.getValueAt(this.JTPreguntas.getSelectedRow(), 0) + "' AND t_encuestas_registro.FechaEncuestas>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND t_encuestas_registro.FechaEncuestas<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND t_detalle_encuesta_registro.Id_Respuesta='" + xidrespuesta + "' ) GROUP BY t_detalle_encuesta_registro.Id_Pregunta, t_detalle_encuesta_registro.Id_Respuesta ORDER BY COUNT(t_detalle_encuesta_registro.Id_Encuestas) DESC ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs = xct1.traerRs(this.xsql);
            if (rs.next()) {
                rs.first();
                xvalor = rs.getInt(1);
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalor;
    }

    public void mBuscar() {
        if (this.JCBEncuesta.getSelectedIndex() != -1) {
            mCargarDatosTablaPregunta();
            mCrearModeloDatosR();
            mBuscarEncuestasAsignadas();
            this.JTPObservacion.setText("");
            this.JLBPromedio.setText("0.0");
        }
    }

    private void mBuscarEncuestasAsignadas() {
        try {
            this.xsql = "SELECT COUNT(Id_UsuarioG) AS Cantidad FROM t_e_tipo_encuesta_detalle WHERE (Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND Id_UsuarioG <>0 AND t_e_tipo_encuesta_detalle.`Estado`=1 ) GROUP BY Id_Tipo_Encuesta ";
            ConsultasMySQL xct3 = new ConsultasMySQL();
            ResultSet xrs = xct3.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTFFNAsignadas.setValue(Integer.valueOf(xrs.getInt(1)));
            } else {
                this.JTFFNAsignadas.setValue(new Integer(0));
            }
            if (Integer.valueOf(this.JTFFNAsignadas.getValue().toString()).intValue() > 0) {
                this.JTFFNDiferencia.setValue(Integer.valueOf(Integer.valueOf(this.JTFFNAsignadas.getValue().toString()).intValue() - Integer.valueOf(this.JTFFNRespondida.getValue().toString()).intValue()));
                this.JTFFPParticipacion.setValue(Integer.valueOf((Integer.valueOf(this.JTFFNRespondida.getValue().toString()).intValue() * 100) / Integer.valueOf(this.JTFFNAsignadas.getValue().toString()).intValue()));
                if (Integer.valueOf(this.JTFFPParticipacion.getValue().toString()).intValue() < 100) {
                    this.JBTEnviarCorreo.setEnabled(true);
                } else {
                    this.JBTEnviarCorreo.setEnabled(false);
                }
            }
            xrs.close();
            xct3.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarObservacionesPregunta() {
        try {
            this.JTPObservacion.setText("");
            String xtexto = "";
            String xtexto1 = "";
            String xtextot = "";
            this.xsql = "SELECT t_detalle_encuesta_registro.`ObservacionG`   FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro   ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id)  INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id)  INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id)  WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.FechaEncuestas>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND t_detalle_encuesta_registro.`ObservacionG` <>'' AND t_encuestas_registro.FechaEncuestas<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' )  order by t_detalle_encuesta_registro.`ObservacionG`";
            System.out.println(" Encuenta : " + this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    x++;
                    xtexto = x == 1 ? xtexto + "<br>" + xrs.getString(1) + "<br>--------------------------------------------------------------------------------------" : xtexto + "<br>" + xrs.getString(1) + "<br>--------------------------------------------------------------------------------------";
                }
                xtextot = "<font face='Arial' color='red' size=4>OBSERVACIONES GENERAL POR ENCUESTA </font><br>\n" + xtexto + "\n";
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT t_encuestas_registro.`ObservacionG`   FROM t_detalle_encuesta_registro INNER JOIN t_encuestas_registro   ON (t_detalle_encuesta_registro.Id_Encuestas = t_encuestas_registro.Id)  INNER JOIN t_e_tipo_encuesta_detalle  ON (t_encuestas_registro.Id_TipoEncuestaD = t_e_tipo_encuesta_detalle.Id)  INNER JOIN t_epregunta  ON (t_detalle_encuesta_registro.Id_Pregunta = t_epregunta.Id)  WHERE (t_e_tipo_encuesta_detalle.Id_Tipo_Encuesta ='" + this.xidencuesta[this.JCBEncuesta.getSelectedIndex()] + "' AND t_encuestas_registro.FechaEncuestas>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND t_detalle_encuesta_registro.Id_Pregunta='" + this.xmodelo.getValueAt(this.JTPreguntas.getSelectedRow(), 0) + "'  AND t_encuestas_registro.`ObservacionG` <>'' AND t_encuestas_registro.FechaEncuestas<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  )  order by t_encuestas_registro.`ObservacionG`";
            System.out.println(" Encuenta : " + this.xsql);
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                int x2 = 0;
                while (xrs2.next()) {
                    x2++;
                    xtexto1 = x2 == 1 ? xtexto1 + "<br>" + xrs2.getString(1) + "<br>--------------------------------------------------------------------------------------" : xtexto1 + "<br>" + xrs2.getString(1) + "<br>--------------------------------------------------------------------------------------";
                }
                xtextot = xtextot + "\n<font face='Arial' color='red' size=4>OBSERVACIONES POR PREGUNTA </font><br>\n" + xtexto1 + "\n";
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.JTPObservacion.setText(xtextot);
            this.JTPObservacion.setCaretPosition(0);
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoEncuesta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
