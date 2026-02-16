package Sig;

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
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFRefConsultaNutricion.class */
public class JIFRefConsultaNutricion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar;
    private JCheckBox JCHSeleccionar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xestadog = false;
    private boolean xlleno = false;
    private boolean xtipog = false;

    public JIFRefConsultaNutricion(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTExportar = new JButton();
        this.JCHSeleccionar = new JCheckBox();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR USUARIOS ATENDIDOS EN NUTRICIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(966, 640));
        setMinimumSize(new Dimension(966, 640));
        setName("xjifreferenciac");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sig.JIFRefConsultaNutricion.1
            public void mouseClicked(MouseEvent evt) {
                JIFRefConsultaNutricion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFRefConsultaNutricion.2
            public void actionPerformed(ActionEvent evt) {
                JIFRefConsultaNutricion.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: Sig.JIFRefConsultaNutricion.3
            public void actionPerformed(ActionEvent evt) {
                JIFRefConsultaNutricion.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFRefConsultaNutricion.4
            public void mouseClicked(MouseEvent evt) {
                JIFRefConsultaNutricion.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 421, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 244, -2).addGap(131, 131, 131).addComponent(this.JCHSeleccionar))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(18, 32767).addComponent(this.JSPDetalle, -2, 501, -2).addGap(27, 27, 27).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSeleccionar).addComponent(this.JTFRuta, -2, 54, -2)).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 54, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            if (this.xnombre.equals("xjifAReferenciac") || this.xnombre.equals("xjifreferenciac") || this.xnombre.equals("xjifreferenciac3")) {
                mExportarDatos();
            } else if (this.xnombre.equals("xjifconsultarinfn")) {
                mExportarDatos1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            if (this.xnombre.equals("xjifconsultarinfn")) {
                if (this.JTDetalle.getSelectedColumn() == 0) {
                    String[][] parametros = new String[4][2];
                    parametros[0][0] = "idusuario";
                    parametros[0][1] = String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0));
                    parametros[1][0] = "usuario";
                    parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                    parametros[2][0] = "SUBREPORT_DIR";
                    parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros[3][0] = "SUBREPORTFIRMA_DIR";
                    parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoricoNutricional", parametros);
                    return;
                }
                return;
            }
            if (this.xnombre.equals("xjifAReferenciac") || this.xnombre.equals("xjifreferenciac")) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("true")) {
                    this.xmodelo.setValueAt(1, this.JTDetalle.getSelectedRow(), 6);
                } else {
                    this.xmodelo.setValueAt(1, this.JTDetalle.getSelectedRow(), 6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.xnombre.equals("xjifconsultarinfn")) {
            if (this.JCHSeleccionar.isSelected()) {
                mActivarDesactivar(true);
            } else {
                mActivarDesactivar(false);
            }
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

    private void mActivarDesactivar(boolean xestado) {
        if (this.JTDetalle.getRowCount() > 1) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), i, 4);
            }
        }
    }

    public void mBuscar() {
        if (this.xnombre.equals("xjifAReferenciac") || this.xnombre.equals("xjifreferenciac") || this.xnombre.equals("xjifreferenciac3")) {
            mCargarDatosTabla();
        } else if (this.xnombre.equals("xjifconsultarinfn")) {
            mCargarDatosTabla1();
        }
    }

    public void mGrabar() {
        if (this.xnombre.equals("xjifAReferenciac") || this.xnombre.equals("xjifreferenciac") || this.xnombre.equals("xjifreferenciac3")) {
            if (mVerificarDatosTabla() && this.JTDetalle.getRowCount() > 1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        System.out.println(this.xmodelo.getValueAt(i, 4).toString());
                        if (this.xmodelo.getValueAt(i, 5).toString().equals("true") && Integer.valueOf(this.xmodelo.getValueAt(i, 6).toString()).intValue() == 1) {
                            String sql = "UPDATE h_nutricional SET h_nutricional.AReferencia=1 WHERE id='" + this.xmodelo.getValueAt(i, 0).toString() + "'";
                            this.xconsulta.ejecutarSQL(sql);
                            this.xconsulta.cerrarConexionBd();
                        }
                        if (this.xmodelo.getValueAt(i, 5).toString().equals("false") && Integer.valueOf(this.xmodelo.getValueAt(i, 6).toString()).intValue() == 1) {
                            String sql2 = "UPDATE h_nutricional SET h_nutricional.AReferencia=0 WHERE id='" + this.xmodelo.getValueAt(i, 0).toString() + "'";
                            this.xconsulta.ejecutarSQL(sql2);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe exámen seleccionado", "VERIFICAR", 1);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "NHC", "Usuario", "IMC", "Ref?", "Cambio"}) { // from class: Sig.JIFRefConsultaNutricion.5
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(2);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "NHC", "Usuario", "Consultar?"}) { // from class: Sig.JIFRefConsultaNutricion.6
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    private boolean mVerificarDatosTabla() {
        boolean estado = false;
        if (this.JTDetalle.getRowCount() > 1) {
            int i = 0;
            while (true) {
                if (i > this.JTDetalle.getRowCount()) {
                    break;
                }
                if (!this.JTDetalle.getValueAt(i, 5).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT h_nutricional.Id, Date_Format(h_atencion.Fecha_Atencion, '%d-%m-%Y') as Fecha, persona.NoHistoria, persona.NUsuario,  h_nutricional.imc, h_nutricional.AReferencia FROM baseserver.h_nutricional INNER JOIN baseserver.h_atencion  ON (h_nutricional.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona ON (ingreso.Id_Usuario = persona.Id_persona) WHERE persona.Edad>=15 ORDER BY persona.NUsuario ASC, h_atencion.Fecha_Atencion ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(0, n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTabla1() {
        try {
            mCrearModeloDatos1();
            ResultSet xrs = this.xconsulta.traerRs("SELECT persona.Id_persona,DATE_FORMAT(MAX(h_atencion.Fecha_Atencion),'%d-%m-%Y') AS Fecha, persona.NoHistoria, persona.NUsuario       FROM h_nutricional INNER JOIN h_atencion  ON (h_nutricional.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) GROUP BY persona.NoHistoria ORDER BY persona.NUsuario ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(false, n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportarDatos() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "REFERENCIA DE CONSULTAS DE NUTRICION"));
                sheet.addCell(new Label(0, 1, "Fecha"));
                sheet.addCell(new Label(1, 1, "N° Historia"));
                sheet.addCell(new Label(2, 1, "Nombre"));
                sheet.addCell(new Label(3, 1, "IMC"));
                int y = 2;
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x, 1).toString()));
                    sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x, 2).toString()));
                    sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x, 3).toString()));
                    sheet.addCell(new Number(3, y, Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue()));
                    y++;
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportarDatos1() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                String xsql = "SELECT date_format(h_atencion.Fecha_Atencion, '%d-%m-%Y') as Fecha , h_nutricional.Talla , h_nutricional.Peso , h_nutricional.Imc, h_tipoestadonutricional.Nbre AS EstadoNutricional , h_nutricional.EstructuraM , h_nutricional.CCarpo, h_nutricional.CCintura, h_nutricional.CCadera, h_tiporiesgoemb.Nbre AS Riesgo, h_nutricional.PAgua, h_nutricional.PGrasa, h_nutricional.MOsea, h_nutricional.MViceral , h_nutricional.PesoLGrasa, h_nutricional.PesoUsual, h_nutricional.PesoObjetivo, persona.NUsuario, persona.NSexo, persona.Edad, persona.NTipoEdad, persona.NoHistoria, g_tipoempresa.Nbre, UCASE(g_parentesco.Nbre) AS Parentesco FROM h_nutricional INNER JOIN h_atencion  ON (h_nutricional.Id_Atencion = h_atencion.Id) INNER JOIN h_tipoestadonutricional  ON (h_tipoestadonutricional.Id = h_nutricional.Id_tipoestadonutricional) INNER JOIN h_tiporiesgoemb  ON (h_nutricional.Id_Riesgo = h_tiporiesgoemb.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) INNER JOIN g_usuario  ON (g_usuario.Id_persona= persona.Id_persona) INNER JOIN g_usuario_fpz  ON (g_usuario.Id_persona= g_usuario_fpz.Id_Persona) INNER JOIN g_tipoempresa  ON (g_tipoempresa.Id= g_usuario_fpz.Id_Empresa) INNER JOIN g_parentesco  ON (g_parentesco.Id= g_usuario_fpz.Id_Parentesco)  WHERE (ingreso.Id_Usuario in(" + mVerificarDatosParametro() + ")) ORDER BY persona.NUsuario asc,h_atencion.Fecha_Atencion ASC ";
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "HISTORIA NUTRICIONAL"));
                sheet.addCell(new Label(0, 1, "Fecha"));
                sheet.addCell(new Label(1, 1, "N° Historia"));
                sheet.addCell(new Label(2, 1, "Nombre"));
                sheet.addCell(new Label(3, 1, "Sexo"));
                sheet.addCell(new Label(4, 1, "Edad"));
                sheet.addCell(new Label(5, 1, "Talla"));
                sheet.addCell(new Label(6, 1, "Peso"));
                sheet.addCell(new Label(7, 1, "Imc"));
                sheet.addCell(new Label(8, 1, "Estado Nutricional"));
                sheet.addCell(new Label(9, 1, "Estructura M"));
                sheet.addCell(new Label(10, 1, "CCarpo"));
                sheet.addCell(new Label(11, 1, "CCintura"));
                sheet.addCell(new Label(12, 1, "CCadera"));
                sheet.addCell(new Label(13, 1, "Riesgo"));
                sheet.addCell(new Label(14, 1, "%Agua"));
                sheet.addCell(new Label(15, 1, "%Grasa"));
                sheet.addCell(new Label(16, 1, "MOsea"));
                sheet.addCell(new Label(17, 1, "MViceral"));
                sheet.addCell(new Label(18, 1, "Peso Libre Grasa"));
                sheet.addCell(new Label(19, 1, "Peso Usual"));
                sheet.addCell(new Label(20, 1, "Peso Objetivo"));
                sheet.addCell(new Label(21, 1, "Tipo Empresa"));
                sheet.addCell(new Label(22, 1, "Parentesco"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Label(1, x, rs.getString(22)));
                        sheet.addCell(new Label(2, x, rs.getString(18)));
                        sheet.addCell(new Label(3, x, rs.getString(19)));
                        sheet.addCell(new Label(4, x, rs.getString(20) + " " + rs.getString(21)));
                        sheet.addCell(new Number(5, x, rs.getDouble(2)));
                        sheet.addCell(new Number(6, x, rs.getDouble(3)));
                        sheet.addCell(new Number(7, x, rs.getDouble(4)));
                        sheet.addCell(new Label(8, x, rs.getString(5)));
                        sheet.addCell(new Number(9, x, rs.getDouble(6)));
                        sheet.addCell(new Number(10, x, rs.getDouble(7)));
                        sheet.addCell(new Number(11, x, rs.getDouble(8)));
                        sheet.addCell(new Number(12, x, rs.getDouble(9)));
                        sheet.addCell(new Label(13, x, rs.getString(10)));
                        sheet.addCell(new Number(14, x, rs.getDouble(11)));
                        sheet.addCell(new Number(15, x, rs.getDouble(12)));
                        sheet.addCell(new Number(16, x, rs.getDouble(13)));
                        sheet.addCell(new Number(17, x, rs.getDouble(14)));
                        sheet.addCell(new Number(18, x, rs.getDouble(15)));
                        sheet.addCell(new Number(19, x, rs.getDouble(16)));
                        sheet.addCell(new Number(20, x, rs.getDouble(17)));
                        sheet.addCell(new Label(21, x, rs.getString(23)));
                        sheet.addCell(new Label(22, x, rs.getString(24)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFRefConsultaNutricion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private String mVerificarDatosParametro() {
        String xparametros = "";
        if (this.JTDetalle.getRowCount() > 1) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.JTDetalle.getValueAt(i, 4).toString().equals("true")) {
                    xparametros = xparametros + this.xmodelo.getValueAt(i, 0).toString() + ",";
                }
            }
        }
        return xparametros.substring(0, xparametros.length() - 1);
    }
}
