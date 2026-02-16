package Sig;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFGeneracion_Archivos.class */
public class JIFGeneracion_Archivos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String xnombre;
    private String xsql;
    private String[] xidempresa;
    private String[][] xano;
    private File xfile;
    private JButton JBTExportar;
    private JComboBox JCBAno;
    private JComboBox JCBTipoEmpresa;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JLabel JLBNRegistro;
    private JPanel JPIFiltro;
    private JPanel JPI_Historia;
    private JPanel JPI_Incapacidades;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFGeneracion_Archivos(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        setTitle(getTitle() + " - " + xnombre);
        mNuevo();
    }

    private void initComponents() {
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLBNRegistro = new JLabel();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Incapacidades = new JPanel();
        this.JPIFiltro = new JPanel();
        this.JCBAno = new JComboBox();
        this.JCBTipoEmpresa = new JComboBox();
        this.JPI_Historia = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERADOR DE ARCHIVOS EN PDF");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFGeneracion_Archivos.1
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracion_Archivos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFGeneracion_Archivos.2
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracion_Archivos.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBAno.setFont(new Font("Arial", 1, 12));
        this.JCBAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBAno.addItemListener(new ItemListener() { // from class: Sig.JIFGeneracion_Archivos.3
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracion_Archivos.this.JCBAnoItemStateChanged(evt);
            }
        });
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoEmpresa.addItemListener(new ItemListener() { // from class: Sig.JIFGeneracion_Archivos.4
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracion_Archivos.this.JCBTipoEmpresaItemStateChanged(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoEmpresa, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, 32767).addComponent(this.JCBAno, -2, 101, -2).addGap(34, 34, 34)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEmpresa, -2, 50, -2).addComponent(this.JCBAno, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPI_IncapacidadesLayout = new GroupLayout(this.JPI_Incapacidades);
        this.JPI_Incapacidades.setLayout(JPI_IncapacidadesLayout);
        JPI_IncapacidadesLayout.setHorizontalGroup(JPI_IncapacidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_IncapacidadesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIFiltro, -2, -1, -2).addContainerGap()));
        JPI_IncapacidadesLayout.setVerticalGroup(JPI_IncapacidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_IncapacidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTP_Datos.addTab("INCAPACIDADES", this.JPI_Incapacidades);
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_HistoriaLayout = new GroupLayout(this.JPI_Historia);
        this.JPI_Historia.setLayout(JPI_HistoriaLayout);
        JPI_HistoriaLayout.setHorizontalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 123, 32767).addComponent(this.JDFFechaF, -2, 131, -2).addGap(103, 103, 103)));
        JPI_HistoriaLayout.setVerticalGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoriaLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(JPI_HistoriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addContainerGap(75, 32767)));
        this.JTP_Datos.addTab("HISTORIA", this.JPI_Historia);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNRegistro, -2, 139, -2).addGap(0, 0, 32767)).addComponent(this.JTP_Datos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JLBNRegistro, -2, 58, -2)).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 50, -2).addGap(28, 28, 28)));
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
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            if (this.JCBAno.getSelectedIndex() != -1) {
                mCrearArchivos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el año a consultar ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        if (this.JTP_Datos.getSelectedIndex() == 1) {
            mCrear_Archivos_HC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoEmpresa.getSelectedIndex() != -1) {
            this.xlleno = false;
            this.JCBAno.removeAllItems();
            this.xsql = "SELECT DATE_FORMAT(`Fecha`,'%Y'), DATE_FORMAT(`Fecha`,'%Y')  AS `Ano`, COUNT(`Id`) FROM `h_incapacidad`  WHERE (`Id_TipoEmpresa` ='" + this.xidempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "' AND `Estado` =0) GROUP BY `Ano` ORDER BY `Ano` ASC ";
            this.xano = this.xct.llenarComboyLista(this.xsql, this.xano, this.JCBAno, 3);
            this.JCBAno.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAnoItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBAno.getSelectedIndex() != -1) {
            this.JLBNRegistro.setText(this.xano[this.JCBAno.getSelectedIndex()][1]);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBAno.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JCBTipoEmpresa.removeAllItems();
        if (this.xnombre.equals("INCAPACIDADES")) {
            this.xsql = "SELECT  `g_tipoempresa`.`Id` , `g_tipoempresa`.`Nbre` FROM `h_incapacidad` INNER JOIN  `g_tipoempresa`  ON (`h_incapacidad`.`Id_TipoEmpresa` = `g_tipoempresa`.`Id`) WHERE (`h_incapacidad`.`Estado` =0) GROUP BY `g_tipoempresa`.`Id` ORDER BY `g_tipoempresa`.`Nbre` ASC ";
            this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBTipoEmpresa);
            this.JCBTipoEmpresa.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
    }

    private void mCrearArchivos() {
        new File(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "L_Resultados.pdf");
        File directorio = new File(this.JTFRuta.getText() + this.JCBAno.getSelectedItem());
        if (directorio.mkdir()) {
            try {
                this.xsql = "SELECT `h_incapacidad`.`Id`  , CONCAT(`h_incapacidad`.`Id`, '_', DATE_FORMAT(`h_incapacidad`.`Fecha`,'%d-%m-%Y') , '_', `persona`.`NoDocumento`, '_', `persona`.`NUsuario`) AS NArchivo FROM `persona` INNER JOIN  `h_incapacidad`   ON (`persona`.`Id_persona` = `h_incapacidad`.`Id_Usuario`) WHERE (`h_incapacidad`.`Id_TipoEmpresa` ='" + this.xidempresa[this.JCBTipoEmpresa.getSelectedIndex()] + "' AND `h_incapacidad`.`Estado` =0 AND DATE_FORMAT(`h_incapacidad`.`Fecha`,'%Y') ='" + this.JCBAno.getSelectedItem() + "') ORDER BY `h_incapacidad`.`Id` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String[][] parametros = new String[3][2];
                        parametros[0][0] = "norden";
                        parametros[0][1] = xrs.getString(1);
                        parametros[1][0] = "SUBREPORT_DIR";
                        parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        parametros[2][0] = "SUBREPORTFIRMA_DIR";
                        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + xrs.getString(1) + ".pdf"));
                        this.xmt.CrearPDF(this.xmt.getRutaRep() + "RIncapacidad", parametros, this.xmt.getRutaRep() + xrs.getString(2));
                        String adjunto = this.xmt.getRutaRep() + xrs.getString(2) + ".pdf";
                        File f1 = new File(this.xmt.getRutaRep() + "/RIncapacidad.pdf");
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JIFGeneracion_Archivos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "El directorio : " + directorio.getPath() + ";\nya se encuentra creado, favor eliminar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mCrear_Archivos_HC() {
        try {
            File directorio = new File(this.JTFRuta.getText() + this.xmt.formatoANO.format(this.JDFFechaI.getDate()));
            if (directorio.mkdir()) {
                this.xsql = "SELECT  `h_atencion`.`Id` , `persona`.`Id_persona` , CONCAT(`h_atencion`.`Id`,'_',DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y'),'_', `persona`.`NoHistoria`,'_',`persona`.`Id_TipoIdentificacion`,'_',`persona`.`NoDocumento`,'_',`persona`.`NUsuario`,'_',`c_clasecita`.`Nbre` ,'_',`profesional1`.`Especialidad` ,'_',`profesional1`.`NProfesional`) AS `NArchivo` , `h_tipohistoria`.`Reporte` , `profesional1`.`IdEspecialidad` FROM  `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `h_tipohistoria`  ON (`c_clasecita`.`Id_Historia` = `h_tipohistoria`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' and `h_atencion`.`Fecha_Atencion`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and `h_atencion`.`Fecha_Atencion`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') ORDER BY `h_atencion`.`Fecha_Atencion` ASC ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        String[][] mparametros = new String[4][2];
                        mparametros[0][0] = "idatencion1";
                        mparametros[0][1] = xrs.getString(1);
                        mparametros[1][0] = "idpaciente1";
                        mparametros[1][1] = xrs.getString(2);
                        mparametros[2][0] = "SUBREPORT_DIR";
                        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                        if (xrs.getString(5).equals("690")) {
                            this.xmt.mGenerarGrafico(xrs.getString(1));
                        }
                        if (xrs.getString(5).equals("1023") || xrs.getString(5).equals("1024") || xrs.getString(5).equals("461") || xrs.getString(5).equals("1032") || xrs.getString(5).equals("250")) {
                            System.out.println("Si entre a la condicion para imprimir el odontograma");
                            String xTratamiento = null;
                            String sql = "SELECT `Id` FROM  `o_hc_tratamiento` WHERE (`Id_Atencion` ='" + xrs.getString(1) + "')";
                            ConsultasMySQL xct1 = new ConsultasMySQL();
                            ResultSet xrs1 = xct1.traerRs(sql);
                            if (xrs.next()) {
                                xrs.first();
                                xTratamiento = xrs.getString(1);
                            }
                            xrs1.close();
                            xct1.cerrarConexionBd();
                            this.xmt.mTraerDatosDienteDxOdontInicial(xrs.getString(2));
                            this.xmt.mTraerDatosDienteProcOdontInicial(xrs.getString(2));
                            this.xmt.traerImagenOdontograma();
                            this.xmt.mTraerDatosDienteDxTratamiento(xTratamiento);
                            this.xmt.traerImagenOdontogramaDx();
                            this.xmt.mTraerDatosDienteProcTratamiento(xTratamiento);
                            this.xmt.traerImagenOdontogramaProc();
                            this.xmt.mTraerDatosDienteMarcadosControlPlaca(xTratamiento);
                            this.xmt.traerImagenOdontogramaControlPlaca();
                        }
                        this.xmt.CrearPDF(this.xmt.getRutaRep() + xrs.getString(4), mparametros, this.xmt.getRutaRep() + xrs.getString(4));
                        new File(this.xmt.getRutaRep() + xrs.getString(4) + ".pdf");
                        String adjunto = this.xmt.getRutaRep() + xrs.getString(3) + ".pdf";
                        File f1 = new File(this.xmt.getRutaRep() + "/" + xrs.getString(4) + ".pdf");
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(directorio, f2.getName()));
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGeneracion_Archivos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
