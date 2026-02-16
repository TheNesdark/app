package Historia;

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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFInformesH.class */
public class JIFInformesH extends JInternalFrame {
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

    public JIFInformesH(String xtitulo, String xname) {
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
        setTitle("GENERACION DE INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(575, 341));
        setMinimumSize(new Dimension(575, 341));
        setName("jifreportesh");
        setPreferredSize(new Dimension(575, 341));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.lblTitulo.setBackground(new Color(0, 0, 153));
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(255, 255, 255));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("GENERADOR DE INFORMES");
        this.lblTitulo.setOpaque(true);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.btnExportar.setFont(new Font("Arial", 1, 12));
        this.btnExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.btnExportar.setText("Exportar");
        this.btnExportar.addActionListener(new ActionListener() { // from class: Historia.JIFInformesH.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesH.this.btnExportarActionPerformed(evt);
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
        if (titulo.equals("CONSULTA NO PROGRAMADA")) {
            this.JCBUno.setVisible(true);
            mCargarComboTipoEmpresa();
        } else {
            this.JCBUno.setVisible(false);
        }
    }

    private void mCargarComboTipoEmpresa() {
        this.JCBUno.removeAllItems();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.xidtipodato = xmt.llenarCombo("SELECT Id, Nbre FROM baseserver.g_sedes ORDER BY Nbre ASC", this.xidtipodato, this.JCBUno);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
        this.btnExportar.setVisible(false);
    }

    private void generar() {
        if (this.xtitulo.equals("INCAPACIDADES")) {
            mExportarIncapacidades();
        }
    }

    private void mExportarIncapacidades() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                String xsql = "SELECT h_incapacidad.Id AS Id, persona.NoHistoria AS NHistoria, persona.Id_TipoIdentificacion AS TipoDoc, persona.NoDocumento AS Documento, persona.NUsuario AS NUsuario, DATE_FORMAT(h_incapacidad.FechaInicio, '%d-%m-%Y') AS FechaInicio , h_incapacidad.NDias, DATE_FORMAT(h_incapacidad.FechaFin, '%d-%m-%Y') AS FechaFinal, h_incapacidad.EsProrroga, h_tipomotivoincap.Nbre AS MotivoIncapacidad, h_tipojustificacionincap.Nbre AS TipoJustificacion, h_incapacidad.Id_Patologia AS Cie10, g_patologia.Nbre AS NPatologia , profesional.NProfesional AS Profesional, g_tipounidadnegocio.Nbre AS NUnidadNegocio, DATE_FORMAT(h_atencion.Fecha_Atencion, '%d-%m-%Y') AS FechaAtencion FROM baseserver.h_incapacidad INNER JOIN baseserver.h_atencion  ON (h_incapacidad.IdAtencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_empresacont  ON (h_incapacidad.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN baseserver.g_tipoempresa  ON (h_incapacidad.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN baseserver.g_tipounidadnegocio ON (h_incapacidad.Id_TipoUnidadNegocio= g_tipounidadnegocio.Id) INNER JOIN baseserver.f_empresacontxconvenio ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN baseserver.persona ON (persona.Id_persona = ingreso.Id_Usuario) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = h_incapacidad.Id_Profesional) INNER JOIN baseserver.g_patologia ON (h_incapacidad.Id_Patologia = g_patologia.Id) INNER JOIN baseserver.h_tipomotivoincap  ON (h_incapacidad.Id_MotivoIncap = h_tipomotivoincap.Id) INNER JOIN baseserver.h_tipojustificacionincap  ON (h_incapacidad.IdTipoJustificacion = h_tipojustificacionincap.Id) WHERE (h_incapacidad.Id_TipoEmpresa ='" + this.xidtipodato[this.JCBUno.getSelectedIndex()] + "' AND h_incapacidad.Estado =0 AND h_atencion.Fecha_Atencion>='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion<='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') ORDER BY h_atencion.Fecha_Atencion ASC";
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
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Number(1, x, rs.getLong(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Number(3, x, rs.getLong(4)));
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
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFInformesH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFInformesH.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            } catch (WriteException e) {
                Logger.getLogger(JIFInformesH.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
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

    public void mImprimir() {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "fechai";
        parametros[0][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
        parametros[1][0] = "fechaf";
        parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
        parametros[2][0] = "usuario";
        parametros[2][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[3][0] = "sede";
        parametros[3][1] = this.xidtipodato[this.JCBUno.getSelectedIndex()];
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ReporteDeAtencionNPMedico", parametros);
    }
}
