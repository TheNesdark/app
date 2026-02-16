package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIFReporte.class */
public class JIFReporte extends JInternalFrame {
    private String[] xidarea;
    private String[] xidtipo;
    private String[] xidestado;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private char xevaluacion = 'C';
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private boolean xlleno;
    private ButtonGroup JBGEvaluacion;
    private JComboBox JCBArea;
    private JComboBox JCBEstado;
    private JComboBox JCBTipo;
    private JPanel JPDatosP;
    private JPanel JPEvaluacion;
    private JPanel JPIHistorico;
    private JRadioButton JRBA;
    private JRadioButton JRBP;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPHistorico;
    private JTable JTBHistorico;
    private JTextPane JTPDescripcion;

    public JIFReporte(String xnombre) {
        this.xlleno = false;
        initComponents();
        setName(xnombre);
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xidtipo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tiporeporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipo, this.JCBTipo);
        this.JCBTipo.setSelectedIndex(-1);
        this.xidestado = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipoestadoreporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidestado, this.JCBEstado);
        this.JCBEstado.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla("SELECT m_reporte.Id, Date_Format(m_reporte.FechaR, '%d-%m-%Y') as Fecha, m_reporte.DescripcionR, f_centrocosto.Nbre, m_tiporeporte.Nbre, m_reporte.TipoEvaluacion, persona.NUsuario, m_tipoestadoreporte.Nbre FROM baseserver.m_reporte INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.m_tiporeporte  ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id) INNER JOIN baseserver.m_tipoestadoreporte  ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id) INNER JOIN baseserver.persona  ON (persona.Id_persona = m_reporte.Id_UsuarioS) ORDER BY m_reporte.FechaR DESC ");
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEvaluacion = new ButtonGroup();
        this.JPDatosP = new JPanel();
        this.JCBArea = new JComboBox();
        this.JCBTipo = new JComboBox();
        this.JPEvaluacion = new JPanel();
        this.JRBP = new JRadioButton();
        this.JRBA = new JRadioButton();
        this.JSPDescripcion = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JPIHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.JCBEstado = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERAR REPORTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(889, 696));
        setName("jifreporte");
        this.JPDatosP.setBorder(BorderFactory.createEtchedBorder());
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPEvaluacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Evaluación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGEvaluacion.add(this.JRBP);
        this.JRBP.setFont(new Font("Arial", 1, 12));
        this.JRBP.setText("Preventivo");
        this.JRBP.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFReporte.1
            public void actionPerformed(ActionEvent evt) {
                JIFReporte.this.JRBPActionPerformed(evt);
            }
        });
        this.JBGEvaluacion.add(this.JRBA);
        this.JRBA.setFont(new Font("Arial", 1, 12));
        this.JRBA.setSelected(true);
        this.JRBA.setText("Correctivo");
        this.JRBA.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFReporte.2
            public void actionPerformed(ActionEvent evt) {
                JIFReporte.this.JRBAActionPerformed(evt);
            }
        });
        GroupLayout JPEvaluacionLayout = new GroupLayout(this.JPEvaluacion);
        this.JPEvaluacion.setLayout(JPEvaluacionLayout);
        JPEvaluacionLayout.setHorizontalGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEvaluacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBA).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBP).addGap(51, 51, 51)));
        JPEvaluacionLayout.setVerticalGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvaluacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBP).addComponent(this.JRBA)));
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLLE DEL REPORTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPDescripcion.setBorder(BorderFactory.createBevelBorder(0));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTPDescripcion);
        this.JPIHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JCBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstado.addItemListener(new ItemListener() { // from class: Mantenimiento.JIFReporte.3
            public void itemStateChanged(ItemEvent evt) {
                JIFReporte.this.JCBEstadoItemStateChanged(evt);
            }
        });
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEstado, -2, 274, -2)).addComponent(this.JSPHistorico)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addComponent(this.JCBEstado, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorico, -1, 295, 32767).addContainerGap()));
        GroupLayout JPDatosPLayout = new GroupLayout(this.JPDatosP);
        this.JPDatosP.setLayout(JPDatosPLayout);
        JPDatosPLayout.setHorizontalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcion).addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIHistorico, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPDatosPLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JCBArea, -2, 418, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipo, -2, 274, -2).addGap(18, 18, 18).addComponent(this.JPEvaluacion, -2, 223, -2)))).addContainerGap()));
        JPDatosPLayout.setVerticalGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosPLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipo, -2, 45, -2).addComponent(this.JCBArea, -2, 45, -2)).addComponent(this.JPEvaluacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcion, -2, 158, -2).addGap(18, 18, 18).addComponent(this.JPIHistorico, -1, -1, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosP, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosP, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPActionPerformed(ActionEvent evt) {
        this.xevaluacion = 'P';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAActionPerformed(ActionEvent evt) {
        this.xevaluacion = 'C';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEstadoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEstado.getSelectedIndex() != -1) {
            String xsql = "SELECT m_reporte.Id, Date_Format(m_reporte.FechaR, '%d-%m-%Y') as Fecha, m_reporte.DescripcionR, f_centrocosto.Nbre, m_tiporeporte.Nbre, m_reporte.TipoEvaluacion, persona.NUsuario, m_tipoestadoreporte.Nbre FROM baseserver.m_reporte INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.m_tiporeporte  ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id) INNER JOIN baseserver.m_tipoestadoreporte  ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id) INNER JOIN baseserver.persona  ON (persona.Id_persona = m_reporte.Id_UsuarioS) WHERE m_reporte.Id_EstadoReporte= '" + this.xidestado[this.JCBEstado.getSelectedIndex()] + "'ORDER BY m_reporte.FechaR DESC ";
            mCargarDatosTabla(xsql);
        }
    }

    public void nuevo() {
        this.JCBArea.setSelectedIndex(-1);
        this.JCBTipo.setSelectedIndex(-1);
        this.JRBA.setSelected(true);
        this.xevaluacion = 'C';
        this.JTPDescripcion.setText("");
        Principal.txtNo.setText("");
        Principal.txtEstado.setText("");
        this.JCBArea.requestFocus();
    }

    public void grabar() {
        if (this.JCBArea.getSelectedIndex() != -1) {
            if (this.JCBTipo.getSelectedIndex() != -1) {
                if (!this.JTPDescripcion.getText().isEmpty()) {
                    if (Principal.txtNo.getText().equals("")) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            Metodos xmt = new Metodos();
                            String sql = "insert into m_reporte(Id_Area, Id_TipoReporte, FechaR, TipoEvaluacion, Id_EstadoReporte, Id_sede, Id_UsuarioS, DescripcionR) values('" + this.xidarea[this.JCBArea.getSelectedIndex()] + "','" + this.xidtipo[this.JCBTipo.getSelectedIndex()] + "','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + this.xevaluacion + "','1','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.JTPDescripcion.getText() + "')";
                            Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("Evaluación");
                            String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                            String mensaje = "Se genero el reporte # " + Principal.txtNo.getText() + "\nArea : " + this.JCBArea.getSelectedItem() + "\nTipo : " + this.JCBTipo.getSelectedItem() + "\nEvalaluación : " + this.xevaluacion + "\n\nAsunto : \n" + this.JTPDescripcion.getText() + "\n\n\n\n " + Principal.usuarioSistemaDTO.getNombreUsuario();
                            Email em = new Email();
                            em.Send(xfrom, mensaje, "logistica@fundacionpanzenu.org.co", "REPORTE DE :" + this.JCBTipo.getSelectedItem().toString());
                            JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar la descripcion del reporte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un area", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBArea.requestFocus();
    }

    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Reporte", "Unidad Funcional", "Tipo", "TE", "Usuario"}) { // from class: Mantenimiento.JIFReporte.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarDatosTabla(String sql) {
        try {
            mCrearModelo();
            ResultSet rs = this.xconsulta.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    i++;
                }
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFReporte.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
