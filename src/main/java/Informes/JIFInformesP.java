package Informes;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFInformesP.class */
public class JIFInformesP extends JInternalFrame {
    private String[] xidtipodato;
    private String xtitulo;
    private JComboBox JCBUno;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JButton btnExportar;
    private JPanel jPanel2;
    private JLabel lblTitulo;
    private int filaArbol = 0;
    private int cboLleno = 0;
    private String xestado = "1";
    Metodos xmt = new Metodos();
    ConsultasMySQL xconsultabd = new ConsultasMySQL();

    public JIFInformesP(String xtitulo, String xname) {
        initComponents();
        setName(xname);
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.xtitulo = xtitulo;
        mActivarComponentes(xtitulo);
    }

    private void initComponents() {
        this.lblTitulo = new JLabel();
        this.jPanel2 = new JPanel();
        this.JCBUno = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.btnExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERADOR DE INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(575, 341));
        setMinimumSize(new Dimension(575, 341));
        setName("jifgenerador");
        setPreferredSize(new Dimension(575, 341));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.lblTitulo.setBackground((Color) null);
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(0, 102, 0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("GENERADOR DE INFORMES");
        this.lblTitulo.setOpaque(true);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.btnExportar.setFont(new Font("Arial", 1, 12));
        this.btnExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.btnExportar.setText("Exportar");
        this.btnExportar.addActionListener(new ActionListener() { // from class: Informes.JIFInformesP.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesP.this.btnExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 243, 32767).addComponent(this.JDFechaF, -2, 136, -2)).addComponent(this.btnExportar, -1, 521, 32767).addComponent(this.JCBUno, GroupLayout.Alignment.TRAILING, 0, 521, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 61, -2).addComponent(this.JDFechaF, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCBUno, -2, 50, -2).addGap(18, 18, 18).addComponent(this.btnExportar, -2, 50, -2).addGap(24, 24, 24)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.lblTitulo, GroupLayout.Alignment.LEADING, -1, 545, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lblTitulo, -2, 30, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnExportarActionPerformed(ActionEvent evt) {
        generar();
    }

    private void mActivarComponentes(String titulo) {
        this.lblTitulo.setText(this.lblTitulo.getText() + " - " + titulo.toUpperCase());
        if (titulo.equals("INCAPACIDADES")) {
            this.JCBUno.setVisible(true);
            mCargarComboTipoEmpresa();
        } else {
            this.JCBUno.setVisible(false);
        }
    }

    private void mCargarComboTipoEmpresa() {
        this.JCBUno.removeAllItems();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.xidtipodato = xmt.llenarCombo("SELECT Id, Nbre FROM baseserver.g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipodato, this.JCBUno);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
    }

    private void generar() {
        if (this.xtitulo.equals("INCAPACIDADES")) {
            mExportarIncapacidades();
        } else if (this.xtitulo.equals("Consolidado de Citas")) {
            mExportarDFisioterpia();
        }
    }

    private void mExportarIncapacidades() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                String xsql = "SELECT h_incapacidad.Id AS Id, persona.NoHistoria AS NHistoria, persona.Id_TipoIdentificacion AS TipoDoc, persona.NoDocumento AS Documento, persona.NUsuario AS NUsuario, DATE_FORMAT(h_incapacidad.FechaInicio, '%d-%m-%Y') AS FechaInicio , h_incapacidad.NDias, DATE_FORMAT(h_incapacidad.FechaFin, '%d-%m-%Y') AS FechaFinal, h_incapacidad.EsProrroga, h_tipomotivoincap.Nbre AS MotivoIncapacidad, h_tipojustificacionincap.Nbre AS TipoJustificacion, h_incapacidad.Id_Patologia AS Cie10, g_patologia.Nbre AS NPatologia , profesional.NProfesional AS Profesional, g_tipounidadnegocio.Nbre AS NUnidadNegocio, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d-%m-%Y') AS FechaAtencion, persona.Codigo1Sap, f_empresacontxconvenio.Nbre, IF(h_incapacidad.TipoIncapacidad=0,'AMBULATORIO', 'HOSPITALIZACIÓN') AS TipoIncapacidad FROM baseserver.h_incapacidad INNER JOIN baseserver.h_atencion  ON (h_incapacidad.IdAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_empresacont  ON (h_incapacidad.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN baseserver.g_tipoempresa  ON (h_incapacidad.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN baseserver.g_tipounidadnegocio ON (h_incapacidad.Id_TipoUnidadNegocio= g_tipounidadnegocio.Id) INNER JOIN baseserver.f_empresacontxconvenio ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN baseserver.persona ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_incapacidad.Id_Profesional) INNER JOIN baseserver.g_patologia ON (h_incapacidad.Id_Patologia = g_patologia.Id) INNER JOIN baseserver.h_tipomotivoincap  ON (h_incapacidad.Id_MotivoIncap = h_tipomotivoincap.Id) INNER JOIN baseserver.h_tipojustificacionincap  ON (h_incapacidad.IdTipoJustificacion = h_tipojustificacionincap.Id) WHERE (h_incapacidad.Id_TipoEmpresa ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' AND h_incapacidad.Estado =0 AND h_incapacidad.Fecha>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " 00:00:00' AND h_incapacidad.Fecha<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " 23:59:59' and h_incapacidad.Estado=0) ORDER BY h_atencion.Fecha_Atencion ASC";
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "ID"));
                sheet.addCell(new Label(1, 1, "NHistoria"));
                sheet.addCell(new Label(2, 1, "TipoDoc"));
                sheet.addCell(new Label(3, 1, "N° Documento"));
                sheet.addCell(new Label(4, 1, "Nombre Usuario"));
                sheet.addCell(new Label(5, 1, "Fecha Inicio"));
                sheet.addCell(new Label(6, 1, "NDías"));
                sheet.addCell(new Label(7, 1, "Fecha Final"));
                sheet.addCell(new Label(8, 1, "EsProrroga"));
                sheet.addCell(new Label(9, 1, "Motivo Incapacidad"));
                sheet.addCell(new Label(10, 1, "Tipo Justificacion"));
                sheet.addCell(new Label(11, 1, "Cie10"));
                sheet.addCell(new Label(12, 1, "NPatología"));
                sheet.addCell(new Label(13, 1, "NProfesional"));
                sheet.addCell(new Label(14, 1, "NUnidadNegocio"));
                sheet.addCell(new Label(15, 1, "FechaAtención"));
                sheet.addCell(new Label(16, 1, "Codigo1Sap"));
                sheet.addCell(new Label(17, 1, "Eps"));
                sheet.addCell(new Label(18, 1, "Tipo"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        sheet.addCell(new Label(4, x, rs.getString(5)));
                        sheet.addCell(new Label(5, x, rs.getString(6)));
                        sheet.addCell(new Number(6, x, rs.getLong(7)));
                        sheet.addCell(new Label(7, x, rs.getString(8)));
                        sheet.addCell(new Number(8, x, rs.getLong(9)));
                        sheet.addCell(new Label(9, x, rs.getString(10)));
                        sheet.addCell(new Label(10, x, rs.getString(11)));
                        sheet.addCell(new Label(11, x, rs.getString(12)));
                        sheet.addCell(new Label(12, x, rs.getString(13)));
                        sheet.addCell(new Label(13, x, rs.getString(14)));
                        sheet.addCell(new Label(14, x, rs.getString(15)));
                        sheet.addCell(new Label(15, x, rs.getString(16)));
                        sheet.addCell(new Label(16, x, rs.getString(17)));
                        sheet.addCell(new Label(17, x, rs.getString(18)));
                        sheet.addCell(new Label(18, x, rs.getString(19)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    private void mExportarUsuarioCronicos(String xsql) {
        if (mValidarEspecialidad()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, "USUARIOS CRONICOS"));
                    sheet.addCell(new Label(0, 1, "Fecha"));
                    sheet.addCell(new Label(1, 1, "N° Historia"));
                    sheet.addCell(new Label(2, 1, "Nombre"));
                    sheet.addCell(new Label(3, 1, "Sexo"));
                    sheet.addCell(new Label(4, 1, "Edad"));
                    sheet.addCell(new Label(5, 1, "Codigo Cie10"));
                    sheet.addCell(new Label(6, 1, "Nombre Patología"));
                    sheet.addCell(new Label(7, 1, "Clase de Cita"));
                    sheet.addCell(new Label(8, 1, "Cantidad"));
                    sheet.addCell(new Label(9, 1, "Eps"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    ResultSet rs = xt2.traerRs(xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 2;
                        while (rs.next()) {
                            sheet.addCell(new Label(0, x, rs.getString(1)));
                            sheet.addCell(new Label(1, x, rs.getString(2)));
                            sheet.addCell(new Label(2, x, rs.getString(3)));
                            sheet.addCell(new Label(3, x, rs.getString(4)));
                            sheet.addCell(new Label(4, x, rs.getString(5) + " " + rs.getString(6)));
                            sheet.addCell(new Label(5, x, rs.getString(7)));
                            sheet.addCell(new Label(6, x, rs.getString(8)));
                            sheet.addCell(new Label(7, x, rs.getString(9)));
                            sheet.addCell(new Label(8, x, rs.getString(10)));
                            sheet.addCell(new Label(9, x, rs.getString(11)));
                            x++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                    new SimpleDateFormat("yyyy/MM/dd");
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    private void mExportarProcedimientosxEmpresa(String xsql) {
        if (mValidarEspecialidad()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    Metodos metodos = new Metodos();
                    WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, "PROCEDIMIENTOS REALIZADOS X EMPRESA DEL PERIODO " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + "  Al  " + metodos.formatoDMA.format(this.JDFechaF.getDate())));
                    sheet.addCell(new Label(0, 1, "Empresa"));
                    sheet.addCell(new Label(1, 1, "Nombre del Procedimiento"));
                    sheet.addCell(new Label(2, 1, "Cantidad"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    ResultSet rs = xt2.traerRs(xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 2;
                        while (rs.next()) {
                            sheet.addCell(new Label(0, x, rs.getString(1)));
                            sheet.addCell(new Label(1, x, rs.getString(2)));
                            sheet.addCell(new Number(2, x, rs.getLong(3)));
                            x++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                    workbook.write();
                    workbook.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex2) {
                    Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    private boolean mValidarEspecialidad() {
        boolean estado = false;
        if (this.JCBUno.getSelectedIndex() != -1) {
            estado = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la especialidad", "VERIFICAR", 0);
            this.JCBUno.requestFocus();
        }
        return estado;
    }

    public void mImprimirInforme() {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "periodo";
        parametros[0][1] = "del  " + this.xmt.formatoDMA.format(this.JDFechaI.getDate()) + "  al  " + this.xmt.formatoDMA.format(this.JDFechaF.getDate());
        parametros[1][0] = "fechai";
        parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
        parametros[2][0] = "fechaf";
        parametros[2][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
        parametros[3][0] = "usuario";
        parametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.xtitulo.equals("Médicos Generales")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "E_AtencionesxMedicosGeneralesFact", parametros);
            return;
        }
        if (this.xtitulo.equals("Médicos Especialistas")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "E_AtencionesxEspecialistasFact", parametros);
        } else if (this.xtitulo.equals("Remisiones x Medicos Generales")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "E_RemisionesxMedicosGeneralesFact", parametros);
        } else if (this.xtitulo.equals("Remisiones x Medicos PyP")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "E_RemisionesxMedicosGeneralesFactPyP", parametros);
        }
    }

    private void mExportarDFisioterpia() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                String xsql = "SELECT profesional1.NProfesional, c_clasecita.Nbre, COUNT(profesional1.NProfesional) AS Cantidad, IF(c_citas.Asistida=1,'Si','No') AS Tipo FROM c_citas INNER JOIN c_clasecita  ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = c_citas.Id_Profesional) AND (c_citas.Id_Especialidad = profesional1.IdEspecialidad)  WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND c_citas.Id_MotivoDesistida =1 AND c_clasecita.Id_Especialidad =1) GROUP BY profesional1.NProfesional, c_clasecita.Nbre, c_citas.Asistida ORDER BY profesional1.NProfesional ASC, c_clasecita.Nbre ASC ";
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Profesional"));
                sheet.addCell(new Label(1, 1, "Tipo de Cita"));
                sheet.addCell(new Label(2, 1, "Cantidad"));
                sheet.addCell(new Label(3, 1, "Asistio?"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Label(0, x, rs.getString(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Number(2, x, rs.getInt(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFInformesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }
}
