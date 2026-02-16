package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
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
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPReuConteoArticulaciones.class */
public class JPReuConteoArticulaciones extends JPanel {
    private JPReuArticulaciones xJPReuArticulacionesDolorosas;
    private JPReuArticulaciones xJPReuArticulacionesInflamadas;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xidTest;
    private JButton JBCalcular;
    private JLabel JLCDAI;
    private JLabel JLCDAIClasificacion;
    private JLabel JLDAS28;
    private JLabel JLDAS28Clasificacion;
    private JLabel JLSDAI;
    private JLabel JLSDAIClasificacion;
    private JLabel JLVGMAE;
    private JLabel JLVGPAE;
    private JLabel JLVProteina;
    private JLabel JLVSG;
    private JLabel JLVVGPES;
    private JPanel JPArticulacionDolorosas;
    private JPanel JPArticulacionInflamadas;
    private JSlider JSLEnferMedico;
    private JSlider JSLEnferPaciente;
    private JSlider JSLProteina;
    private JSlider JSLVGPES;
    private JSlider JSLVSG;
    private JTable JTHistorico;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;

    public JPReuConteoArticulaciones() {
        initComponents();
        this.xidTest = "";
        mIniciaComponentes();
        mBuscaHistorico();
        mBuscaDatosAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion(), 1);
    }

    private void mBuscaDatosAtencion(String variable, int tipo) {
        String condicion;
        if (tipo == 0) {
            condicion = "where h_reumatologia_examen.id='" + variable + "'";
        } else {
            condicion = "where h_reumatologia_examen.idatencion='" + variable + "' and h_reumatologia_examen.estado=1";
        }
        String sql = "select h_reumatologia_examen.id,h_reumatologia_examen.vgpae,h_reumatologia_examen.vgmae,h_reumatologia_examen.proteinareactiva\n,h_reumatologia_examen.vsg,h_reumatologia_examen.vgpes, h_reumatologia_examen.cdai\n,h_reumatologia_examen.cdai_clasificacion,h_reumatologia_examen.sdai,h_reumatologia_examen.sdai_clasificacion\n,h_reumatologia_examen.das28,h_reumatologia_examen.das28_clasificacion\nfrom h_reumatologia_examen\n" + condicion;
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JLVGPAE.setText(xrs.getString("vgpae"));
                this.JSLEnferPaciente.setValue(xrs.getInt("vgpae"));
                this.JLVGMAE.setText(xrs.getString("vgmae"));
                this.JSLEnferMedico.setValue(xrs.getInt("vgmae"));
                this.JLVProteina.setText(xrs.getString("proteinareactiva"));
                this.JLVSG.setText(xrs.getString("vsg"));
                this.JSLVSG.setValue(xrs.getInt("vsg"));
                this.JLVVGPES.setText(xrs.getString("vgpes"));
                this.JSLVGPES.setValue(xrs.getInt("vgpes"));
                this.JLCDAI.setText(xrs.getString("cdai"));
                this.JLCDAIClasificacion.setText(xrs.getString("cdai_clasificacion"));
                this.JLSDAI.setText(xrs.getString("sdai"));
                this.JLSDAIClasificacion.setText(xrs.getString("sdai_clasificacion"));
                this.JLDAS28.setText(xrs.getString("das28"));
                this.JLDAS28Clasificacion.setText(xrs.getString("das28_clasificacion"));
                this.xidTest = xrs.getString("id");
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPReuConteoArticulaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciaComponentes() {
        if (this.xJPReuArticulacionesDolorosas == null) {
            this.xJPReuArticulacionesDolorosas = new JPReuArticulaciones();
        }
        if (this.xJPReuArticulacionesInflamadas == null) {
            this.xJPReuArticulacionesInflamadas = new JPReuArticulaciones();
        }
        this.xJPReuArticulacionesDolorosas.setVisible(true);
        this.JPArticulacionDolorosas.setVisible(false);
        this.xJPReuArticulacionesDolorosas.setBounds(8, 15, 261, 263);
        this.JPArticulacionDolorosas.add(this.xJPReuArticulacionesDolorosas);
        this.JPArticulacionDolorosas.setVisible(true);
        this.xJPReuArticulacionesInflamadas.setVisible(true);
        this.JPArticulacionInflamadas.setVisible(false);
        this.xJPReuArticulacionesInflamadas.setBounds(8, 15, 261, 263);
        this.JPArticulacionInflamadas.add(this.xJPReuArticulacionesInflamadas);
        this.JPArticulacionInflamadas.setVisible(true);
        this.JSLProteina.setMajorTickSpacing(10);
        this.JSLProteina.setMaximum(100);
        Hashtable labelTable = new Hashtable();
        for (int i = 0; i <= 100; i++) {
            if (i % 10 == 0) {
                labelTable.put(new Integer(i), new JLabel("" + (i / 10)));
            }
        }
        this.JSLProteina.setLabelTable(labelTable);
        this.JSLProteina.setMinorTickSpacing(0);
        this.JSLProteina.setPaintLabels(true);
    }

    /* JADX WARN: Type inference failed for: r3v124, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPArticulacionDolorosas = new JPanel();
        this.JPArticulacionInflamadas = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JSLEnferPaciente = new JSlider();
        this.JSLEnferMedico = new JSlider();
        this.jLabel6 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JLVGPAE = new JLabel();
        this.JLVGMAE = new JLabel();
        this.jButton1 = new JButton();
        this.JSLProteina = new JSlider();
        this.JLVProteina = new JLabel();
        this.jButton2 = new JButton();
        this.JSLVSG = new JSlider();
        this.JLVSG = new JLabel();
        this.JSLVGPES = new JSlider();
        this.jPanel4 = new JPanel();
        this.jLabel3 = new JLabel();
        this.JLCDAIClasificacion = new JLabel();
        this.JLCDAI = new JLabel();
        this.jPanel6 = new JPanel();
        this.jLabel4 = new JLabel();
        this.JLSDAIClasificacion = new JLabel();
        this.JLSDAI = new JLabel();
        this.jPanel7 = new JPanel();
        this.jLabel7 = new JLabel();
        this.JLDAS28Clasificacion = new JLabel();
        this.JLDAS28 = new JLabel();
        this.JLVVGPES = new JLabel();
        this.JBCalcular = new JButton();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpExamenReumatologia");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPArticulacionDolorosas.setBorder(BorderFactory.createTitledBorder((Border) null, "Conteo articulaciones dolorosas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPArticulacionDolorosas.setMaximumSize(new Dimension(280, 300));
        this.JPArticulacionDolorosas.setMinimumSize(new Dimension(280, 300));
        this.JPArticulacionDolorosas.setPreferredSize(new Dimension(280, 300));
        GroupLayout JPArticulacionDolorosasLayout = new GroupLayout(this.JPArticulacionDolorosas);
        this.JPArticulacionDolorosas.setLayout(JPArticulacionDolorosasLayout);
        JPArticulacionDolorosasLayout.setHorizontalGroup(JPArticulacionDolorosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 282, 32767));
        JPArticulacionDolorosasLayout.setVerticalGroup(JPArticulacionDolorosasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.JPArticulacionInflamadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Conteo articulaciones inflamadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPArticulacionInflamadas.setMaximumSize(new Dimension(280, 300));
        this.JPArticulacionInflamadas.setMinimumSize(new Dimension(280, 300));
        GroupLayout JPArticulacionInflamadasLayout = new GroupLayout(this.JPArticulacionInflamadas);
        this.JPArticulacionInflamadas.setLayout(JPArticulacionInflamadasLayout);
        JPArticulacionInflamadasLayout.setHorizontalGroup(JPArticulacionInflamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 268, 32767));
        JPArticulacionInflamadasLayout.setVerticalGroup(JPArticulacionInflamadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("<html><p style=\"text-align: justify\">Muy bien</p></html>");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("<html><p style=\"text-align: justify\">Muy bien</p></html>");
        this.JSLEnferPaciente.setMajorTickSpacing(1);
        this.JSLEnferPaciente.setMaximum(10);
        this.JSLEnferPaciente.setPaintLabels(true);
        this.JSLEnferPaciente.setPaintTicks(true);
        this.JSLEnferPaciente.setToolTipText("");
        this.JSLEnferPaciente.setValue(0);
        this.JSLEnferPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Valoración global del paciente de la actividad de la enfermedad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLEnferPaciente.setPreferredSize(new Dimension(200, 63));
        this.JSLEnferPaciente.addChangeListener(new ChangeListener() { // from class: Historia.JPReuConteoArticulaciones.1
            public void stateChanged(ChangeEvent evt) {
                JPReuConteoArticulaciones.this.JSLEnferPacienteStateChanged(evt);
            }
        });
        this.JSLEnferMedico.setMajorTickSpacing(1);
        this.JSLEnferMedico.setMaximum(10);
        this.JSLEnferMedico.setPaintLabels(true);
        this.JSLEnferMedico.setPaintTicks(true);
        this.JSLEnferMedico.setToolTipText("");
        this.JSLEnferMedico.setValue(0);
        this.JSLEnferMedico.setBorder(BorderFactory.createTitledBorder((Border) null, "Valoración global del médico de la actividad de la enfermedad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLEnferMedico.addChangeListener(new ChangeListener() { // from class: Historia.JPReuConteoArticulaciones.2
            public void stateChanged(ChangeEvent evt) {
                JPReuConteoArticulaciones.this.JSLEnferMedicoStateChanged(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("<html><p style=\"text-align: justify\">Muy mal</p></html>");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("<html><p style=\"text-align: justify\">Muy mal</p></html>");
        this.JLVGPAE.setFont(new Font("Arial", 1, 14));
        this.JLVGPAE.setForeground(Color.red);
        this.JLVGPAE.setHorizontalAlignment(0);
        this.JLVGPAE.setText("0");
        this.JLVGPAE.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLVGMAE.setFont(new Font("Arial", 1, 14));
        this.JLVGMAE.setForeground(Color.red);
        this.JLVGMAE.setHorizontalAlignment(0);
        this.JLVGMAE.setText("0");
        this.JLVGMAE.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton1.setText("...");
        this.jButton1.setToolTipText("Consultar resultado");
        this.JSLProteina.setMajorTickSpacing(10);
        this.JSLProteina.setPaintLabels(true);
        this.JSLProteina.setPaintTicks(true);
        this.JSLProteina.setToolTipText("");
        this.JSLProteina.setValue(0);
        this.JSLProteina.setBorder(BorderFactory.createTitledBorder((Border) null, "Proteína C reactiva en mg/dl", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLProteina.addChangeListener(new ChangeListener() { // from class: Historia.JPReuConteoArticulaciones.3
            public void stateChanged(ChangeEvent evt) {
                JPReuConteoArticulaciones.this.JSLProteinaStateChanged(evt);
            }
        });
        this.JLVProteina.setFont(new Font("Arial", 1, 14));
        this.JLVProteina.setForeground(Color.red);
        this.JLVProteina.setHorizontalAlignment(0);
        this.JLVProteina.setText("0");
        this.JLVProteina.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jButton2.setText("...");
        this.jButton2.setToolTipText("Consultar resultado");
        this.JSLVSG.setMajorTickSpacing(50);
        this.JSLVSG.setMaximum(200);
        this.JSLVSG.setMinorTickSpacing(5);
        this.JSLVSG.setPaintLabels(true);
        this.JSLVSG.setPaintTicks(true);
        this.JSLVSG.setToolTipText("");
        this.JSLVSG.setValue(0);
        this.JSLVSG.setBorder(BorderFactory.createTitledBorder((Border) null, "Velocidad de sedimentación globular (mm/hora)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLVSG.addChangeListener(new ChangeListener() { // from class: Historia.JPReuConteoArticulaciones.4
            public void stateChanged(ChangeEvent evt) {
                JPReuConteoArticulaciones.this.JSLVSGStateChanged(evt);
            }
        });
        this.JLVSG.setFont(new Font("Arial", 1, 14));
        this.JLVSG.setForeground(Color.red);
        this.JLVSG.setHorizontalAlignment(0);
        this.JLVSG.setText("0");
        this.JLVSG.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLVGPES.setMajorTickSpacing(10);
        this.JSLVGPES.setMinorTickSpacing(5);
        this.JSLVGPES.setPaintLabels(true);
        this.JSLVGPES.setPaintTicks(true);
        this.JSLVGPES.setToolTipText("");
        this.JSLVGPES.setValue(0);
        this.JSLVGPES.setBorder(BorderFactory.createTitledBorder((Border) null, "Valoración global del paciente de su estado de salud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSLVGPES.addChangeListener(new ChangeListener() { // from class: Historia.JPReuConteoArticulaciones.5
            public void stateChanged(ChangeEvent evt) {
                JPReuConteoArticulaciones.this.JSLVGPESStateChanged(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "CDAI", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Puntuación:");
        this.JLCDAIClasificacion.setFont(new Font("Arial", 1, 14));
        this.JLCDAIClasificacion.setForeground(Color.red);
        this.JLCDAIClasificacion.setHorizontalAlignment(2);
        this.JLCDAI.setFont(new Font("Arial", 1, 18));
        this.JLCDAI.setForeground(Color.red);
        this.JLCDAI.setHorizontalAlignment(2);
        this.JLCDAI.setText("0");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCDAI, -2, 45, -2).addGap(0, 0, 32767)).addComponent(this.JLCDAIClasificacion, -1, -1, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JLCDAI)).addGap(10, 10, 10).addComponent(this.JLCDAIClasificacion, -2, 18, -2).addGap(10, 10, 10)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "SDAI", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Puntuación:");
        this.JLSDAIClasificacion.setFont(new Font("Arial", 1, 14));
        this.JLSDAIClasificacion.setForeground(Color.red);
        this.JLSDAIClasificacion.setHorizontalAlignment(2);
        this.JLSDAI.setFont(new Font("Arial", 1, 18));
        this.JLSDAI.setForeground(Color.red);
        this.JLSDAI.setHorizontalAlignment(2);
        this.JLSDAI.setText("0");
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLSDAI, -2, 45, -2).addGap(0, 0, 32767)).addComponent(this.JLSDAIClasificacion, -1, -1, 32767)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.JLSDAI)).addGap(10, 10, 10).addComponent(this.JLSDAIClasificacion, -2, 18, -2).addGap(10, 10, 10)));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "DAS28", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Puntuación:");
        this.JLDAS28Clasificacion.setFont(new Font("Arial", 1, 12));
        this.JLDAS28Clasificacion.setForeground(Color.red);
        this.JLDAS28Clasificacion.setHorizontalAlignment(2);
        this.JLDAS28.setFont(new Font("Arial", 1, 18));
        this.JLDAS28.setForeground(Color.red);
        this.JLDAS28.setHorizontalAlignment(2);
        this.JLDAS28.setText("0");
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLDAS28, -1, -1, 32767)).addComponent(this.JLDAS28Clasificacion, -1, -1, 32767)).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.JLDAS28)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLDAS28Clasificacion, -2, 32, -2)));
        this.JLVVGPES.setFont(new Font("Arial", 1, 14));
        this.JLVVGPES.setForeground(Color.red);
        this.JLVVGPES.setHorizontalAlignment(0);
        this.JLVVGPES.setText("0");
        this.JLVVGPES.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBCalcular.setFont(new Font("Arial", 1, 12));
        this.JBCalcular.setText("Calcular Test");
        this.JBCalcular.addActionListener(new ActionListener() { // from class: Historia.JPReuConteoArticulaciones.6
            public void actionPerformed(ActionEvent evt) {
                JPReuConteoArticulaciones.this.JBCalcularActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2, -2, 28, -2).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSLEnferPaciente, -2, 473, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSLVSG, -2, 473, -2).addComponent(this.JSLVGPES, GroupLayout.Alignment.TRAILING, -2, 473, -2)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLVSG, -2, 54, -2).addComponent(this.JLVVGPES, -2, 54, -2).addComponent(this.JLVProteina, -2, 54, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addComponent(this.JBCalcular, -2, 206, -2).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPArticulacionDolorosas, -1, 294, 32767).addGap(18, 18, 18).addComponent(this.JPArticulacionInflamadas, -2, -1, -2).addGap(212, 212, 212)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -2, 27, -2).addComponent(this.jButton1, -2, 28, -2)).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSLEnferMedico, -1, 473, 32767).addComponent(this.JSLProteina, -1, 473, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5, -2, 27, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 27, -2).addGap(481, 481, 481).addComponent(this.jLabel6, -2, 27, -2))).addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLVGPAE, -1, 54, 32767).addComponent(this.JLVGMAE, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel6, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel7, -1, -1, 32767)))).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(317, 317, 317).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBCalcular, -2, 32, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSLEnferPaciente, -2, 60, -2).addGap(67, 67, 67).addComponent(this.JLVProteina, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSLVSG, -2, 60, -2).addComponent(this.jButton2, -2, 56, -2).addComponent(this.JLVSG, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLVVGPES, -1, -1, 32767).addComponent(this.JSLVGPES, -2, 60, -2)))).addContainerGap(94, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPArticulacionDolorosas, -2, 294, -2).addComponent(this.JPArticulacionInflamadas, -2, 294, 32767)).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addGap(63, 63, 63)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 56, -2).addGap(0, 4, 32767)).addComponent(this.jLabel6).addComponent(this.JLVGPAE, -1, -1, 32767)).addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.jLabel2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSLEnferMedico, -2, 60, -2).addComponent(this.JLVGMAE, -2, 58, -2)).addGap(0, 0, 32767))).addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSLProteina, -2, 60, -2).addComponent(this.jButton1, -1, -1, 32767)).addGap(226, 226, 226))).addContainerGap(-1, 32767))));
        this.jTabbedPane1.addTab("TEST", this.jPanel1);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setAutoResizeMode(0);
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPReuConteoArticulaciones.7
            public void mouseClicked(MouseEvent evt) {
                JPReuConteoArticulaciones.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 804, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 297, -2).addContainerGap(422, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSLEnferPacienteStateChanged(ChangeEvent evt) {
        this.JLVGPAE.setText("" + this.JSLEnferPaciente.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSLEnferMedicoStateChanged(ChangeEvent evt) {
        this.JLVGMAE.setText("" + this.JSLEnferMedico.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSLProteinaStateChanged(ChangeEvent evt) {
        this.JLVProteina.setText(String.format("%.1f", Double.valueOf(((double) this.JSLProteina.getValue()) / 10.0d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSLVSGStateChanged(ChangeEvent evt) {
        this.JLVSG.setText("" + this.JSLVSG.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSLVGPESStateChanged(ChangeEvent evt) {
        this.JLVVGPES.setText("" + this.JSLVGPES.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularActionPerformed(ActionEvent evt) {
        mCalculaTest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.jTabbedPane1.setSelectedIndex(0);
            mBuscaDatosAtencion(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString(), 0);
        }
    }

    private void mCalculaTest() {
        int CDAI = Integer.parseInt(this.JLVGPAE.getText()) + Integer.parseInt(this.JLVGMAE.getText()) + this.xJPReuArticulacionesDolorosas.suma + this.xJPReuArticulacionesInflamadas.suma;
        this.JLCDAI.setText("" + CDAI);
        if (CDAI <= 2.8d) {
            this.JLCDAIClasificacion.setText("En remisión");
        } else if (CDAI > 2.8d && CDAI <= 10) {
            this.JLCDAIClasificacion.setText("Actividad baja");
        } else if (CDAI > 10 && CDAI <= 22) {
            this.JLCDAIClasificacion.setText("Actividad moderada");
        } else if (CDAI > 22) {
            this.JLCDAIClasificacion.setText("Actividad alta");
        }
        double SDAI = Double.parseDouble(this.JLVGPAE.getText()) + Double.parseDouble(this.JLVGMAE.getText()) + Double.parseDouble(this.JLVProteina.getText().replace(',', '.')) + Double.parseDouble(this.xJPReuArticulacionesDolorosas.JLArticulaciones.getText()) + Double.parseDouble(this.xJPReuArticulacionesInflamadas.JLArticulaciones.getText());
        this.JLSDAI.setText("" + SDAI);
        if (SDAI <= 3.3d) {
            this.JLSDAIClasificacion.setText("En remisión");
        } else if (SDAI > 3.3d && SDAI <= 11.0d) {
            this.JLSDAIClasificacion.setText("Actividad baja");
        } else if (SDAI > 11.0d && SDAI <= 26.0d) {
            this.JLSDAIClasificacion.setText("Actividad moderada");
        } else if (SDAI > 26.0d) {
            this.JLSDAIClasificacion.setText("Actividad alta");
        }
        double DAS = (0.56d * Math.sqrt(this.xJPReuArticulacionesDolorosas.suma)) + (0.28d * Math.sqrt(this.xJPReuArticulacionesInflamadas.suma)) + (0.7d * Math.log(Integer.parseInt(this.JLVSG.getText()))) + (0.014d * ((double) Integer.parseInt(this.JLVVGPES.getText())));
        this.JLDAS28.setText("" + String.format("%.2f", Double.valueOf(DAS)).replace(',', '.'));
        if (DAS <= 2.6d) {
            this.JLDAS28Clasificacion.setText("<html><p style=\"text-align: justify\">Remisión de la enfermedad</p></html>");
            return;
        }
        if (DAS > 2.6d && DAS <= 3.2d) {
            this.JLDAS28Clasificacion.setText("<html><p style=\"text-align: justify\">Actividad de la enfermedad BAJA</p></html>");
            return;
        }
        if (DAS > 3.2d && DAS <= 5.1d) {
            this.JLDAS28Clasificacion.setText("<html><p style=\"text-align: justify\">Actividad de la enfermedad MODERADA</p></html>");
        } else if (DAS > 5.1d) {
            this.JLDAS28Clasificacion.setText("<html><p style=\"text-align: justify\">Actividad de la enfermedad ALTA</p></html>");
        }
    }

    public void mGuardar() {
        if (!this.JLCDAIClasificacion.getText().isEmpty() && !this.JLSDAIClasificacion.getText().isEmpty() && !this.JLDAS28Clasificacion.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.xidTest.equals("")) {
                    String sql = "INSERT INTO h_reumatologia_examen\n(idatencion, idusuario, fechar, idprofesional, idespecialidad, articulacionesdolorosas, articulacionesinflamadas, vgpae, vgmae, proteinareactiva, vsg, vgpes, cdai, cdai_clasificacion, sdai, sdai_clasificacion, das28, das28_clasificacion,usuarios)\n VALUES('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.xJPReuArticulacionesDolorosas.suma + "', '" + this.xJPReuArticulacionesInflamadas.suma + "', '" + this.JLVGPAE.getText() + "', '" + this.JLVGMAE.getText() + "', '" + Double.parseDouble(this.JLVProteina.getText().replace(',', '.')) + "', '" + this.JLVSG.getText() + "', '" + this.JLVVGPES.getText() + "', '" + this.JLCDAI.getText() + "', '" + this.JLCDAIClasificacion.getText() + "', '" + Double.parseDouble(this.JLSDAI.getText().replace(',', '.')) + "', '" + this.JLSDAIClasificacion.getText() + "', '" + Double.parseDouble(this.JLDAS28.getText().replace(',', '.')) + "', '" + this.JLDAS28Clasificacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xidTest = this.xct.ejecutarSQLId(sql);
                    this.xct.cerrarConexionBd();
                } else {
                    String sql2 = "UPDATE h_reumatologia_examen\nSET articulacionesdolorosas='" + this.xJPReuArticulacionesDolorosas.suma + "', articulacionesinflamadas='" + this.xJPReuArticulacionesInflamadas.suma + "', vgpae='" + this.JLVGPAE.getText() + "', vgmae='" + this.JLVGMAE.getText() + "', proteinareactiva='" + Double.parseDouble(this.JLVProteina.getText().replace(',', '.')) + "', vsg='" + this.JLVSG.getText() + "', vgpes='" + this.JLVVGPES.getText() + "', cdai='" + this.JLCDAI.getText() + "', cdai_clasificacion='" + this.JLCDAIClasificacion.getText() + "', sdai='" + Double.parseDouble(this.JLSDAI.getText().replace(',', '.')) + "', sdai_clasificacion='" + this.JLSDAIClasificacion.getText() + "', das28='" + Double.parseDouble(this.JLDAS28.getText().replace(',', '.')) + "', das28_clasificacion='" + this.JLDAS28Clasificacion.getText() + "',  usuarios='" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE id='" + this.xidTest + "';";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                mGuardaImagen1();
                mBuscaHistorico();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe calcular los Test", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGuardaImagen1() {
        this.xmt.traerImagenGraficasPanel(this.JPArticulacionDolorosas, "dolorosas");
        this.xmt.traerImagenGraficasPanel(this.JPArticulacionInflamadas, "inflamadas");
        try {
            this.xmt.guardarImagenBlobReumatologia(this.xidTest);
        } catch (SQLException ex) {
            Logger.getLogger(JPReuConteoArticulaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaHistorico() {
        String sql = "select h_reumatologia_examen.id, h_reumatologia_examen.fechar,h_reumatologia_examen.cdai\n,h_reumatologia_examen.cdai_clasificacion,h_reumatologia_examen.sdai,h_reumatologia_examen.sdai_clasificacion\n,h_reumatologia_examen.das28,h_reumatologia_examen.das28_clasificacion,profesional1.NProfesional, profesional1.Especialidad\nfrom h_reumatologia_examen\ninner join profesional1 on (h_reumatologia_examen.idprofesional=profesional1.Id_Persona) and (h_reumatologia_examen.idespecialidad=profesional1.IdEspecialidad)\nwhere h_reumatologia_examen.estado=1 and h_reumatologia_examen.idusuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\norder by h_reumatologia_examen.fechar DESC";
        mModeloEncabezado();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPReuConteoArticulaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloEncabezado() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "CDAI", "CDAI-CLASIFICACIÓN", "SDAI", "SDAI-CLASIFICACIÓN", "DAS28", "DAS28-CLASIFICACIÓN", "Profesional", "Especialidad"}) { // from class: Historia.JPReuConteoArticulaciones.8
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Double.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(135);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(220);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(220);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(220);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(220);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(220);
    }
}
