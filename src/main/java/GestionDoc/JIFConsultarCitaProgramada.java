package GestionDoc;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFConsultarCitaProgramada.class */
public class JIFConsultarCitaProgramada extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private String xnombre;
    private String[][] xidempresa;
    private File xfile;
    private String[] xidespecialidad;
    private String[] xideconvenio;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JComboBox JCBEspecialidades;
    private JCheckBox JCHEmpresa;
    private JCheckBox JCHEspecialistas;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFDocumento;
    private JTextField JTFRuta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private long xnregistro = 0;
    private boolean xlleno = false;

    public JIFConsultarCitaProgramada(String titulo, String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setTitle(titulo.toUpperCase());
        mNuevo();
        mIniciarComponentes();
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        if (this.xnombre.equals("xjiconscprogramada")) {
            mCrearTabla();
        } else if (this.xnombre.equals("xjiconshc_atenciones")) {
            mCrearTabla1();
            this.JBTGenerar.setText("Exportar PDF");
        }
    }

    public void mBuscar() {
        if (this.JCHEspecialistas.isSelected()) {
            if (this.JCBEspecialidades.getSelectedIndex() != -1) {
                if (this.xnombre.equals("xjiconscprogramada")) {
                    mCargarDatosTabla();
                    return;
                } else {
                    if (this.xnombre.equals("xjiconshc_atenciones")) {
                        mCargarDatosTabla1();
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEspecialidades.requestFocus();
            return;
        }
        if (this.xnombre.equals("xjiconscprogramada")) {
            mCargarDatosTabla();
        } else if (this.xnombre.equals("xjiconshc_atenciones")) {
            mCargarDatosTabla1();
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Profesional", "Especialidad", "Fecha Citas", "Hora Inicial", "Hora Final"}) { // from class: GestionDoc.JIFConsultarCitaProgramada.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id_Atencion", "Fecha", "NHistoria", "Usuario", "Sexo", "Edad", "Eps", "Especialidad", "Profesional", "NArchivo", "Exportar?", "Id_Usuario"}) { // from class: GestionDoc.JIFConsultarCitaProgramada.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        mCrearTabla();
        try {
            this.xsql = null;
            if (this.JCHEspecialistas.isSelected() && this.xlleno) {
                this.xsql = "SELECT `profesional1`.`NProfesional`  , `profesional1`.`Especialidad`, `c_confcitas`.`Fecha_ConfCitas` , `c_confcitas`.`HoraInicial`, `c_confcitas`.`HoraFinal` FROM `c_confcitas`  INNER JOIN `baseserver`.`profesional1` ON (`c_confcitas`.`Id_Profesional` = `profesional1`.`Id_Persona`)WHERE(`c_confcitas`.`Fecha_ConfCitas`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_confcitas`.`Fecha_ConfCitas`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND profesional1.`Estado`=0 AND profesional1.`IdEspecialidad`='" + this.xidespecialidad[this.JCBEspecialidades.getSelectedIndex()] + "')GROUP BY profesional1.NProfesional, profesional1.Especialidad,`c_confcitas`.`Fecha_ConfCitas` ORDER BY c_confcitas.Fecha_ConfCitas DESC, `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC";
            } else {
                this.xsql = "SELECT `profesional1`.`NProfesional`  , `profesional1`.`Especialidad`, `c_confcitas`.`Fecha_ConfCitas` , `c_confcitas`.`HoraInicial`, `c_confcitas`.`HoraFinal` FROM `c_confcitas`  INNER JOIN `baseserver`.`profesional1` ON (`c_confcitas`.`Id_Profesional` = `profesional1`.`Id_Persona`)WHERE(`c_confcitas`.`Fecha_ConfCitas`>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_confcitas`.`Fecha_ConfCitas`<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND profesional1.`Estado`=0)GROUP BY profesional1.NProfesional, profesional1.Especialidad,`c_confcitas`.`Fecha_ConfCitas` ORDER BY c_confcitas.Fecha_ConfCitas DESC, `profesional1`.`Especialidad` ASC, `profesional1`.`NProfesional` ASC";
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarCitaProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1() {
        mCrearTabla1();
        try {
            this.xsql = null;
            if (this.JCHEspecialistas.isSelected()) {
                this.xsql = "SELECT `h_atencion`.`Id`, `h_atencion`.`Fecha_Atencion`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS Edad, `f_empresacontxconvenio`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, CONCAT(`h_atencion`.`Id`,'_',DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y'),'_',`persona`.`NoHistoria`,'_',`persona`.`NUsuario`,'_',`f_empresacontxconvenio`.`Nbre`,'_',`profesional1`.`Especialidad`) AS NArchivo, `persona`.`Id_persona` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Codigo_Dxp` <>'0000') AND `h_atencion`.`Id_Especialidad` ='" + this.xidespecialidad[this.JCBEspecialidades.getSelectedIndex()] + "') ORDER BY `profesional1`.`Especialidad` ASC, `h_atencion`.`Fecha_Atencion` ASC, `persona`.`NUsuario` ASC ";
            } else if (this.JCHEmpresa.isSelected()) {
                this.xsql = "SELECT `h_atencion`.`Id`, `h_atencion`.`Fecha_Atencion`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS Edad, `f_empresacontxconvenio`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, CONCAT(`persona`.`NoHistoria`,'_',`h_atencion`.`Id`,'_',DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y'),'_',`persona`.`NUsuario`,'_',`f_empresacontxconvenio`.`Nbre`,'_',`profesional1`.`Especialidad`) AS NArchivo, `persona`.`Id_persona` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Codigo_Dxp` <>'0000') AND `f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xideconvenio[this.JCBEmpresa.getSelectedIndex()] + "' ) ORDER BY `persona`.`NUsuario` ASC, `h_atencion`.`Fecha_Atencion` ASC, `profesional1`.`Especialidad` ASC ";
            } else if (!this.JTFDocumento.getText().isEmpty()) {
                this.xsql = "SELECT `h_atencion`.`Id`, `h_atencion`.`Fecha_Atencion`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS Edad, `f_empresacontxconvenio`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, CONCAT(`h_atencion`.`Id`,'_',DATE_FORMAT(`persona`.`NoHistoria`,'_',`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y'),'_',`persona`.`NUsuario`,'_',`f_empresacontxconvenio`.`Nbre`,'_',`profesional1`.`Especialidad`) AS NArchivo, `persona`.`Id_persona` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `persona`.`NoHistoria` ='" + this.JTFDocumento.getText() + "' AND (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Codigo_Dxp` <>'0000') ) ORDER BY `persona`.`NUsuario` ASC, `h_atencion`.`Fecha_Atencion` ASC, `profesional1`.`Especialidad` ASC";
            } else {
                this.xsql = "SELECT `h_atencion`.`Id`, `h_atencion`.`Fecha_Atencion`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, CONCAT(`persona`.`Edad`,' ', `persona`.`NTipoEdad`,'(s)') AS Edad, `f_empresacontxconvenio`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, CONCAT(`h_atencion`.`Id`,'_',DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y'),'_',`persona`.`NoHistoria`,'_',`persona`.`NUsuario`,'_',`f_empresacontxconvenio`.`Nbre`,'_',`profesional1`.`Especialidad`) AS NArchivo, `persona`.`Id_persona` FROM `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Codigo_Dxp` <>'0000') ) ORDER BY `profesional1`.`Especialidad` ASC, `h_atencion`.`Fecha_Atencion` ASC, `persona`.`NUsuario` ASC ";
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo.setValueAt(true, i, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(11)), i, 11);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarCitaProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEspecialidades = new JComboBox();
        this.JCHEspecialistas = new JCheckBox();
        this.JTFDocumento = new JTextField();
        this.JCBEmpresa = new JComboBox();
        this.JCHEmpresa = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        this.JCHSeleccionar = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN PYP");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiconscprogramada");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: GestionDoc.JIFConsultarCitaProgramada.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitaProgramada.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: GestionDoc.JIFConsultarCitaProgramada.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitaProgramada.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEspecialidades.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidades.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidades", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidades.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarCitaProgramada.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaProgramada.this.JCBEspecialidadesActionPerformed(evt);
            }
        });
        this.JCHEspecialistas.setFont(new Font("Arial", 1, 12));
        this.JCHEspecialistas.setText("Filtro");
        this.JTFDocumento.setToolTipText("");
        this.JTFDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCHEmpresa.setText("Filtro");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBEmpresa, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEmpresa, -2, 66, -2).addContainerGap(-1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEspecialidades, 0, 403, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEspecialistas, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDocumento, -2, 165, -2).addGap(20, 20, 20)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidades, -2, 51, -2).addComponent(this.JCHEspecialistas).addComponent(this.JTFDocumento, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, 51, -2).addComponent(this.JCHEmpresa)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFConsultarCitaProgramada.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCitaProgramada.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarCitaProgramada.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaProgramada.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Quitar Selección");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFConsultarCitaProgramada.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitaProgramada.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 946, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 367, -2).addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 324, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHSeleccionar).addGap(18, 18, 18))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 320, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JCHSeleccionar))).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JBTGenerar, -2, 51, -2))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getRowCount() != -1) {
            if (this.xnombre.equals("xjiconscprogramada")) {
                mExportar();
                return;
            }
            if (this.xnombre.equals("xjiconshc_atenciones")) {
                File directorio3 = new File(this.JTFRuta.getText() + "\\Atenciones_Sistematizadas");
                if (!directorio3.exists()) {
                    directorio3.mkdirs();
                    for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 10).toString()).booleanValue()) {
                            String[][] mparametros = new String[4][2];
                            mparametros[0][0] = "idatencion1";
                            mparametros[0][1] = this.JTBDetalle.getValueAt(x, 0).toString();
                            mparametros[1][0] = "idpaciente1";
                            mparametros[1][1] = this.JTBDetalle.getValueAt(x, 11).toString();
                            mparametros[2][0] = "SUBREPORT_DIR";
                            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                            String nbre = this.xmodelo.getValueAt(x, 9).toString();
                            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                if (this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals("690")) {
                                    this.xmt.mGenerarGrafico(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                                    mGenerarPDF("H_HistoriaClinicaSO_FPZ", mparametros, nbre, directorio3.getPath());
                                    new File(this.xmt.getRutaRep() + "/H_HistoriaClinicaSO_FPZ.pdf");
                                } else {
                                    mGenerarPDF("H_HistoriaClinica", mparametros, nbre, directorio3.getPath());
                                    new File(this.xmt.getRutaRep() + "/H_HistoriaClinica.pdf");
                                }
                            } else {
                                mGenerarPDF("H_HistoriaClinica1", mparametros, nbre, directorio3.getPath());
                                new File(this.xmt.getRutaRep() + "/H_HistoriaClinica1.pdf");
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            this.JCHSeleccionar.setText("Quitar Selección");
            mCambiarEstado(true);
        } else {
            this.JCHSeleccionar.setText("Seleccionar Todo");
            mCambiarEstado(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadesActionPerformed(ActionEvent evt) {
    }

    public void mCambiarEstado(boolean xestado) {
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 10);
        }
    }

    public void mGenerarPDF(String nbreArchivo, String[][] parametros, String narch, String ruta) {
        Connection con = this.xct.establecerConexionBd();
        Map parametro = new HashMap();
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception e) {
            }
        }
        String archivoreporte = this.xmt.getRutaRep() + nbreArchivo + ".jrxml";
        JasperReport report = JasperCompileManager.compileReport(archivoreporte);
        JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
        String narchivop = ruta + "\\" + narch + ".pdf";
        JasperExportManager.exportReportToPdfFile(print, narchivop);
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "fechaInicial";
        parametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
        parametros[1][0] = "fechaFinal";
        parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "R_MovimientoDocumentosClinico", parametros);
        this.xct.cerrarConexionBd();
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("MovimientoDocsClinicos", 0);
                for (int x = 0; x < this.JTBDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarCitaProgramada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarCitaProgramada.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mIniciarComponentes() {
        this.JCBEspecialidades.removeAllItems();
        this.xidespecialidad = this.xct.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM `profesional1` GROUP BY `IdEspecialidad` ORDER BY Especialidad;", this.xidespecialidad, this.JCBEspecialidades);
        this.xideconvenio = this.xct.llenarCombo("SELECT `Id_EmpresaCont`, `Nbre` FROM `f_empresacontxconvenio` GROUP BY `Id_EmpresaCont` ORDER BY Nbre;", this.xideconvenio, this.JCBEmpresa);
        this.JCBEspecialidades.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.xct.cerrarConexionBd();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
    }

    private void mCargarCombo() {
        this.JCBEspecialidades.removeAllItems();
        if (this.xnombre.equals("xjiconscprogramada")) {
            this.xidespecialidad = this.xct.llenarCombo("SELECT `profesional1`.`IdEspecialidad`, `profesional1`.`Especialidad` FROM `c_confcitas` INNER JOIN `baseserver`.`profesional1`  ON (`c_confcitas`.`Id_Profesional` = `profesional1`.`Id_Persona`) WHERE (`c_confcitas`.`Fecha_ConfCitas` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `c_confcitas`.`Fecha_ConfCitas` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') group by `profesional1`.`IdEspecialidad` ORDER BY `profesional1`.`Especialidad` ASC", this.xidespecialidad, this.JCBEspecialidades);
        } else if (this.xnombre.equals("xjiconshc_atenciones")) {
            this.xsql = "SELECT `g_especialidad`.`Id`, `g_especialidad`.`Nbre`  FROM  `g_especialidad` INNER JOIN  `h_atencion`  ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`) WHERE (`h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Codigo_Dxp` <>'0000')) GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ";
            this.xidespecialidad = this.xct.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidades);
        }
        this.JCBEspecialidades.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
    }
}
