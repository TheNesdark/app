package Historia;

import Acceso.Principal;
import General.JDFirmas;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/jpsoActaCompromiso.class */
public class jpsoActaCompromiso extends JPanel {
    private String[] xidtipor;
    private final Metodos xmt = new Metodos();
    private final ConsultasMySQL xct = new ConsultasMySQL();
    private final clasesHistoriaCE xclase;
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton jbtnFirma;
    private JButton jbtnGrabar;
    private JLabel jlblNoActa;
    private JPanel jpHistorico;
    private JPanel jpObservacion;
    private JScrollPane jspHistorico;
    private JScrollPane jspObservacion;
    private JTable jtHistorico;
    private JTabbedPane jtpDatos;
    private JTextPane jtpObservacion;

    public jpsoActaCompromiso(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        buscar();
        cargarDatosTabla();
        this.jbtnFirma.setVisible(false);
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jtpDatos = new JTabbedPane();
        this.jpObservacion = new JPanel();
        this.jspObservacion = new JScrollPane();
        this.jtpObservacion = new JTextPane();
        this.jbtnGrabar = new JButton();
        this.jlblNoActa = new JLabel();
        this.jbtnFirma = new JButton();
        this.jpHistorico = new JPanel();
        this.jspHistorico = new JScrollPane();
        this.jtHistorico = new JTable();
        setName("soActaCompromiso");
        this.jtpDatos.setForeground(new Color(0, 103, 0));
        this.jtpDatos.setFont(new Font("Arial", 1, 14));
        this.jpObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jspObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jtpObservacion.setFont(new Font("Arial", 1, 12));
        this.jspObservacion.setViewportView(this.jtpObservacion);
        this.jtpObservacion.getAccessibleContext().setAccessibleName("");
        this.jbtnGrabar.setFont(new Font("Arial", 1, 12));
        this.jbtnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jbtnGrabar.setText("Grabar");
        this.jbtnGrabar.addActionListener(new ActionListener() { // from class: Historia.jpsoActaCompromiso.1
            public void actionPerformed(ActionEvent evt) {
                jpsoActaCompromiso.this.jbtnGrabarActionPerformed(evt);
            }
        });
        this.jlblNoActa.setFont(new Font("Arial", 1, 18));
        this.jlblNoActa.setForeground(new Color(255, 0, 0));
        this.jlblNoActa.setHorizontalAlignment(0);
        this.jlblNoActa.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Acta", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.jbtnFirma.setFont(new Font("Arial", 1, 12));
        this.jbtnFirma.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.jbtnFirma.setText("Firmar");
        this.jbtnFirma.addActionListener(new ActionListener() { // from class: Historia.jpsoActaCompromiso.2
            public void actionPerformed(ActionEvent evt) {
                jpsoActaCompromiso.this.jbtnFirmaActionPerformed(evt);
            }
        });
        GroupLayout jpObservacionLayout = new GroupLayout(this.jpObservacion);
        this.jpObservacion.setLayout(jpObservacionLayout);
        jpObservacionLayout.setHorizontalGroup(jpObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObservacionLayout.createSequentialGroup().addContainerGap().addGroup(jpObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObservacionLayout.createSequentialGroup().addComponent(this.jbtnGrabar, -2, 468, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbtnFirma, -2, 174, -2).addGap(3, 3, 3).addComponent(this.jlblNoActa, -2, 140, -2)).addComponent(this.jspObservacion)).addContainerGap()));
        jpObservacionLayout.setVerticalGroup(jpObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpObservacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jspObservacion, -1, 447, 32767).addGap(5, 5, 5).addGroup(jpObservacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jlblNoActa, -2, 50, -2).addGroup(jpObservacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jbtnGrabar, -2, 50, -2).addComponent(this.jbtnFirma, -2, 50, -2))).addContainerGap()));
        this.jtpDatos.addTab("OBSERVACIÓN GENERAL", this.jpObservacion);
        this.jtHistorico.setFont(new Font("Arial", 1, 12));
        this.jtHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jtHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.jtHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.jspHistorico.setViewportView(this.jtHistorico);
        GroupLayout jpHistoricoLayout = new GroupLayout(this.jpHistorico);
        this.jpHistorico.setLayout(jpHistoricoLayout);
        jpHistoricoLayout.setHorizontalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jspHistorico, -1, 793, 32767).addContainerGap()));
        jpHistoricoLayout.setVerticalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jspHistorico, -1, 504, 32767).addContainerGap()));
        this.jtpDatos.addTab("HISTÓRICO", this.jpHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jtpDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jtpDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jbtnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jbtnFirmaActionPerformed(ActionEvent evt) {
        if (!this.jlblNoActa.getText().isEmpty()) {
            JDFirmas xJDFirmas = new JDFirmas(null, true, getName(), this.jlblNoActa.getText());
            xJDFirmas.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Guardar el Acta de Compromiso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void nuevo() {
        this.jlblNoActa.setText("");
        this.jtpObservacion.setText("");
    }

    public void grabar() {
        if (!validarActaActiva()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "¿Está seguro de guardar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "INSERT INTO h_so_acta_compromiso (id_Atencion, id_usuario_atendido,observacion, id_profesional)values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.jtpObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                this.jlblNoActa.setText(this.xct.ejecutarSQLId(this.xsql));
                this.xct.cerrarConexionBd();
                this.jbtnGrabar.setEnabled(false);
                cargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe el acta de compromiso con esta atención.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        buscar();
    }

    public void anular() {
        int x = JOptionPane.showInternalConfirmDialog(this, "¿Está seguro de anular el Acta de Ccompromiso?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String sql = "UPDATE h_so_acta_compromiso SET estado =0 WHERE id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND id_profesional ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "';";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            cargarDatosTabla();
        }
    }

    private boolean validarActaActiva() {
        Boolean activa = false;
        try {
            this.xct.cerrarConexionBd();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT id, observacion FROM h_so_acta_compromiso WHERE id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND estado =1 ORDER BY fecha DESC;";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                activa = true;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(jpsoActaCompromiso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return activa.booleanValue();
    }

    private void buscar() {
        try {
            this.xct.cerrarConexionBd();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT id, DATE_FORMAT(fecha,'%Y-%m-%d') AS fecha, observacion FROM h_so_acta_compromiso WHERE id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND estado =1 ORDER BY fecha DESC;";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.jtpObservacion.setText(xrs.getString(3));
                this.jlblNoActa.setText(xrs.getString(1));
            } else {
                nuevo();
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(jpsoActaCompromiso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Acta", "Fecha", "Observación"}) { // from class: Historia.jpsoActaCompromiso.3
            Class[] types = {Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jtHistorico.setModel(this.xmodelo);
        this.jtHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.jtHistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    private void cargarDatosTabla() {
        try {
            crearModeloDatos();
            String sql = "SELECT id, DATE_FORMAT(fecha,'%Y-%m-%d') AS fecha,observacion FROM h_so_acta_compromiso WHERE id_usuario_atendido ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND estado =1 ORDER BY fecha DESC;;";
            System.out.println("SQL Histórico : " + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            TableColumnModel cmodel = this.jtHistorico.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(1).setCellEditor(textEditor);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(jpsoActaCompromiso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void imprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idActa";
        mparametros[0][1] = this.jlblNoActa.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_SO_Acta_Compromiso", mparametros);
    }
}
