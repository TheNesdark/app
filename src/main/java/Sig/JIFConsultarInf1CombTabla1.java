package Sig;

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
import javax.swing.BorderFactory;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFConsultarInf1CombTabla1.class */
public class JIFConsultarInf1CombTabla1 extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private String xtipofiltro;
    private Object[] xdato;
    private String xnombre;
    private String[] xiddatoc;
    private JButton JBTExportar;
    private JComboBox JCBComboxUno;
    private JCheckBox JCHFiltroR;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipoc = 0;

    public JIFConsultarInf1CombTabla1(String xnombre, String xtitulo) {
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JCBComboxUno = new JComboBox();
        this.JCHFiltroR = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultardatosg");
        addInternalFrameListener(new InternalFrameListener() { // from class: Sig.JIFConsultarInf1CombTabla1.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarInf1CombTabla1.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInf1CombTabla1.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInf1CombTabla1.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFConsultarInf1CombTabla1.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInf1CombTabla1.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCBComboxUno.setFont(new Font("Arial", 1, 12));
        this.JCBComboxUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltroR.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroR.setForeground(Color.blue);
        this.JCHFiltroR.setText("Filtro por Recepción");
        this.JCHFiltroR.addActionListener(new ActionListener() { // from class: Sig.JIFConsultarInf1CombTabla1.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInf1CombTabla1.this.JCHFiltroRActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBComboxUno, -2, 497, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 423, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltroR).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar, -2, 211, -2))).addGap(20, 20, 20)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addComponent(this.JCBComboxUno, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JCHFiltroR)).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 295, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
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
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroRActionPerformed(ActionEvent evt) {
        this.xtipofiltro = "in (6412,14167,8471,6744,14329)";
    }

    public void mBuscar() {
        this.xtipoc = 0;
        if (this.JCHFiltroR.isSelected()) {
            if (this.JCBComboxUno.getSelectedIndex() != -1) {
                mCargarDetalle();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la especialdiad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        mCargarDetalle();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBComboxUno.removeAllItems();
        this.xsql = "SELECT g_especialidad.Id, g_especialidad.Nbre FROM c_citas INNER JOIN g_especialidad  ON (c_citas.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC ";
        this.xiddatoc = this.xct.llenarCombo(this.xsql, this.xiddatoc, this.JCBComboxUno);
        this.JCBComboxUno.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTablaDetalle();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id Clase Cita", "Nombre Clase Cita", "Cantidad Total", "Personal", "%Personal", "Telefonia", "%Telofonia", "Web", "%Web", "Demanda Incluida", "%Demanda Incluida"}) { // from class: Sig.JIFConsultarInf1CombTabla1.5
            Class[] types = {Long.class, String.class, Integer.class, Integer.class, Double.class, Integer.class, Double.class, Integer.class, Double.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        if (this.JCHFiltroR.isSelected()) {
            this.xsql = "with maestra as (\n\tSELECT c_clasecita.Id idClaseCita, c_clasecita.Nbre as nombreClaseCita\n\t, count(c_citas.Telefonica) cantidad\n\t, if(c_citas.Telefonica=0, 'PERSONAL', if(c_citas.Telefonica=1, 'TELEFONICA', if(c_citas.Telefonica=2, 'VIA WEB', 'DEMANDA INDUCIDA'))) formaAsignacion \n\t\n\t, SUM(count(c_citas.Telefonica)) over (PARTITION BY c_clasecita.Id ) cantidaTotal\n\tFROM c_citas \n\tINNER JOIN c_clasecita  ON (c_citas.Id_ClaseCita = c_clasecita.Id)\n\tINNER JOIN g_usuario_sist ON (g_usuario_sist.Login = c_citas.UsuarioS)\n\tWHERE (c_citas.Id_MotivoDesistida =1 \n\tAND c_citas.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND  '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \n\tand  c_citas.Id_Especialidad ='" + this.xiddatoc[this.JCBComboxUno.getSelectedIndex()] + "'\n\tand g_usuario_sist.Id_Persona =" + this.xtipofiltro + "\n\t)\n\tGROUP BY c_clasecita.Nbre, c_citas.Telefonica \n)\nselect m.idClaseCita\n, m.nombreClaseCita\n, m.cantidaTotal\n, max(if(m.formaAsignacion='PERSONAL', m.cantidad, 0)) personal\n, max(if(m.formaAsignacion='PERSONAL',  round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajePersonal\n, max(if(m.formaAsignacion='TELEFONICA', m.cantidad, 0)) telefonica\n, max(if(m.formaAsignacion='TELEFONICA',   round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeTelefonica\n, max(if(m.formaAsignacion='VIA WEB', m.cantidad, 0)) web\n, max(if(m.formaAsignacion='VIA WEB',   round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeWeb\n, max(if(m.formaAsignacion='DEMANDA INDUCIDA', m.cantidad, 0)) demandaInducida\n, max(if(m.formaAsignacion='DEMANDA INDUCIDA',  round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeDemandaInducida\nfrom maestra m\ngroup by  m.idClaseCita";
        } else {
            this.xsql = "with maestra as (\n\tSELECT c_clasecita.Id idClaseCita, c_clasecita.Nbre as nombreClaseCita\n\t, count(c_citas.Telefonica) cantidad\n\t, if(c_citas.Telefonica=0, 'PERSONAL', if(c_citas.Telefonica=1, 'TELEFONICA', if(c_citas.Telefonica=2, 'VIA WEB', 'DEMANDA INDUCIDA'))) formaAsignacion \n\t\n\t, SUM(count(c_citas.Telefonica)) over (PARTITION BY c_clasecita.Id ) cantidaTotal\n\tFROM c_citas \n\tINNER JOIN c_clasecita  ON (c_citas.Id_ClaseCita = c_clasecita.Id)\n\tWHERE (c_citas.Id_MotivoDesistida =1 AND c_citas.Fecha_Cita BETWEEN '" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND  '" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' and  c_citas.Id_Especialidad ='" + this.xiddatoc[this.JCBComboxUno.getSelectedIndex()] + "')\n\tGROUP BY c_clasecita.Nbre, c_citas.Telefonica \n)\nselect m.idClaseCita\n, m.nombreClaseCita\n, m.cantidaTotal\n, max(if(m.formaAsignacion='PERSONAL', m.cantidad, 0)) personal\n, max(if(m.formaAsignacion='PERSONAL',  round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajePersonal\n, max(if(m.formaAsignacion='TELEFONICA', m.cantidad, 0)) telefonica\n, max(if(m.formaAsignacion='TELEFONICA',   round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeTelefonica\n, max(if(m.formaAsignacion='VIA WEB', m.cantidad, 0)) web\n, max(if(m.formaAsignacion='VIA WEB',   round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeWeb\n, max(if(m.formaAsignacion='DEMANDA INDUCIDA', m.cantidad, 0)) demandaInducida\n, max(if(m.formaAsignacion='DEMANDA INDUCIDA',  round(((m.cantidad/m.cantidaTotal)*100),2), 0)) pocentajeDemandaInducida\nfrom maestra m\ngroup by  m.idClaseCita";
        }
        System.out.println(" primera : " + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong("idClaseCita")), this.JTDetalle.getRowCount() - 1, 0);
                    this.xmodelo.setValueAt(rs.getString("nombreClaseCita"), this.JTDetalle.getRowCount() - 1, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("cantidaTotal")), this.JTDetalle.getRowCount() - 1, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("personal")), this.JTDetalle.getRowCount() - 1, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("pocentajePersonal")), this.JTDetalle.getRowCount() - 1, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("telefonica")), this.JTDetalle.getRowCount() - 1, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("pocentajeTelefonica")), this.JTDetalle.getRowCount() - 1, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("web")), this.JTDetalle.getRowCount() - 1, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("pocentajeWeb")), this.JTDetalle.getRowCount() - 1, 8);
                    this.xmodelo.setValueAt(Integer.valueOf(rs.getInt("demandaInducida")), this.JTDetalle.getRowCount() - 1, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble("pocentajeDemandaInducida")), this.JTDetalle.getRowCount() - 1, 10);
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mExportar() {
        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
    }
}
