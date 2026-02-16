package com.genoma.plus.controller.sig;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.impl.sig.InformeTratamientoOdontologicoDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dao.sig.InformeTratamientosOdontologicosDAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformesGenericoSO.class */
public class JIFInformesGenericoSO extends JInternalFrame {
    private InformesSgcDAO xInformesSgcDAO;
    private InformeTratamientosOdontologicosDAO informeTratamientosOdontologicosDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private WorkerSQL xWorkerSQL;
    private String[] xidEmpresa;
    private String xtitulo;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos3;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JFormattedTextField JTFFNRegistro;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private int xlleno = 0;

    public JIFInformesGenericoSO(String xtitulo, String xnombre) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xtitulo = xtitulo;
        springStart();
        mNuevo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xInformesSgcDAO = (InformesSgcDAOImpl) classPathXmlApplicationContext.getBean("informesSgcDAO");
        this.informeTratamientosOdontologicosDAO = (InformeTratamientoOdontologicoDAOImpl) classPathXmlApplicationContext.getBean("informeTratamientoOdontologicoDAOImpl");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        List<GenericoComboDTO> list = this.xInformesSgcDAO.cargarCombo("SELECT `Id`, `Nbre` FROM `f_empresacontxconvenio` WHERE (`Estado` =0) ORDER BY `Nbre` ASC;");
        this.xidEmpresa = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xidEmpresa[x] = String.valueOf(list.get(x).getId());
            this.JCBEmpresa.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBEmpresa.setSelectedIndex(-1);
        mCastModeloTabla();
        if (this.xtitulo.equals("Tratamientos Odontologicos por Facturar") || this.xtitulo.equals("Informe de Accidentes de Transito")) {
            this.JCHFiltro.setSelected(false);
            this.JCBEmpresa.setVisible(false);
            this.JCHFiltro.setVisible(false);
        }
    }

    private void mCastModeloTabla() {
        if (this.xtitulo.equals("Informe NOMA")) {
            mCreaModeloTablaNOMA();
            return;
        }
        if (this.xtitulo.equals("Informe Audiometría")) {
            mCrearModeloTablaAudiometria();
            return;
        }
        if (this.xtitulo.equals("Informe Espirometría1") || this.xtitulo.equals("Informe Espirometría")) {
            mCrearModeloTablaEspirometria();
            return;
        }
        if (this.xtitulo.equals("Informe Visiometria")) {
            mCrearModeloTablaVisiometria();
        } else if (this.xtitulo.equals("Tratamientos Odontologicos por Facturar")) {
            mCrearModeloTratamientoOdontolico();
        } else if (this.xtitulo.equals("Informe de Accidentes de Transito")) {
            mCrearModeloInformeAccidenteTransito();
        }
    }

    private void mCreaModeloTablaNOMA() {
        this.xModelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Doc", "No. Documento", "Nombre Usuario", "Edad", "Fecha Nac", "Sexo", "Cargo", "UnidadNegocio", "SEG", "FechaEvaluación", "CodEvaluación", "ClaseCita", "Concepto", "Restricción", "Hallazgo", "Observación", "IMC", "AntecedenteDME", "DIAGNOSTICO ACTIVO CIE 10", "Empresa", "HallazgoOMA", "Hallazgos", "Recomendaciones"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaAudiometria() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha Prueba", "No. Documento", "TipoDocumento", "Usuario", "Edad", "FechaNac", "Sexo", "UnidadNeg", "OD500", "OD1000 ", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "Prom_OD", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "Prom_OI", "ResultadoM", "ClaseCita", "ObservacionA", "Empresa", "Cargo", "Gerencia"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaEspirometria() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Fecha Prueba", "No. Documento", "TipoDocumento", "Usuario", "Edad", "FechaNac", "Sexo", "UnidadNeg", "FVCM", "FVCP ", "VEF1M", "VEF1P", "DVEF1", "DFVC", "IndicT", "ResultadoPrueba", "ResultadoMedico", "ClaseCita", "Empresa"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTratamientoOdontolico() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Documento", "Usuario", "Sexo", "Edad", "Convenio", "IdProcedimiento", "NProcedimiento", "Cantidad", "FechaInicio", "FechaRegistro "}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCrearModeloTablaVisiometria() {
        this.xModelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Tipo Documento", "No. Documento", "Nombre Usuario", "Edad", "Fecha Nac", "Sexo", "Cargo", "UnidadNegocio", "LContacto", "TLentec", "RLFormulado", "Tipo_Gafas", "UCorreccion", "TipoCorrecion", "R_VLAmbosO", "R_VLAmbosO_V", "R_VLAmbosO_T", "R_VLODerecho", "R_VLODerecho_V", "R_VLODerecho_T", "R_VLOIzquierdo", "R_VLOIzquierdo_V", "R_VLOIzquierdo_T", "R_VLEstereopsi", "R_VLEstereopsi_T", "R_VLPercepcion", "R_VLColor", "R_VLColor_T", "R_VLFVertical", "R_VLFVertical_T", "R_VLFLateral", "R_VLFLateral_T", "R_VCAmbosO", "R_VCAmbosO_V", "R_VCAmbosO_T", "R_VCODerecho", "R_VCODerecho_V", "R_VCODerecho_T", "R_VCOIzquierdo", "R_VCOIzquierdo_V", "R_VCOIzquierdo_T", "R_VCFVertical", "R_VCFVertical_T", "R_VCFLateral", "R_VCFLateral_T", "Interpretacion", "ObservacionVisio", "ResultadoM", "ClaseCita", "EmpresaF"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(38).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(39).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(40).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(41).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(42).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(43).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(44).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(45).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(46).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(47).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(48).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(49).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(50).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloInformeAccidenteTransito() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Tipo Documento", "No. Documento", "1er. Apellido", "2do. Apellido", "1er. Nombre", "2do. Nombre", "Edad", "Fecha Ingreso", "Fecha Evento", "Departamento ", "Municipio", "Zona", "Descripcion", "Tipo Vehiculo", "Marca Vehiculo", "Servicio"}) { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
                this.xWorkerSQL.execute();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBEmpresa.requestFocus();
                return;
            }
        }
        this.xWorkerSQL = new WorkerSQL("Cargando la información", this);
        this.xWorkerSQL.execute();
    }

    public void mCastCargarDatos() {
        if (this.xtitulo.equals("Informe NOMA")) {
            mCargarDatosNOMA();
            return;
        }
        if (this.xtitulo.equals("Informe Audiometría")) {
            mCargarDatosTablaAudiometria();
            return;
        }
        if (this.xtitulo.equals("Informe Espirometría") || this.xtitulo.equals("Informe Espirometría1")) {
            mCargarDatosTablaEspirometria();
            return;
        }
        if (this.xtitulo.equals("Informe Visiometria")) {
            mCargarDatosTablaVisiometria();
        } else if (this.xtitulo.equals("Tratamientos Odontologicos por Facturar")) {
            mCargarDatosTablaTratamientoOdontologico();
        } else if (this.xtitulo.equals("Informe de Accidentes de Transito")) {
            mCargarDatosInformeAccidenteTransito();
        }
    }

    public void mCargarDatosTablaVisiometria() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xInformesSgcDAO.ListInformeVisiometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
        } else {
            list = this.xInformesSgcDAO.ListInformeVisiometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
        }
        mCrearModeloTablaVisiometria();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 22);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            this.xModelo1.setValueAt(list.get(x)[16], x, 16);
            this.xModelo1.setValueAt(list.get(x)[17], x, 17);
            this.xModelo1.setValueAt(list.get(x)[18], x, 18);
            this.xModelo1.setValueAt(list.get(x)[19], x, 19);
            this.xModelo1.setValueAt(list.get(x)[20], x, 20);
            this.xModelo1.setValueAt(list.get(x)[21], x, 21);
            this.xModelo1.setValueAt(list.get(x)[22], x, 22);
            this.xModelo1.setValueAt(list.get(x)[23], x, 23);
            this.xModelo1.setValueAt(list.get(x)[24], x, 24);
            this.xModelo1.setValueAt(list.get(x)[25], x, 25);
            this.xModelo1.setValueAt(list.get(x)[26], x, 26);
            this.xModelo1.setValueAt(list.get(x)[27], x, 27);
            this.xModelo1.setValueAt(list.get(x)[28], x, 28);
            this.xModelo1.setValueAt(list.get(x)[29], x, 29);
            this.xModelo1.setValueAt(list.get(x)[30], x, 30);
            this.xModelo1.setValueAt(list.get(x)[31], x, 31);
            this.xModelo1.setValueAt(list.get(x)[32], x, 32);
            this.xModelo1.setValueAt(list.get(x)[33], x, 33);
            this.xModelo1.setValueAt(list.get(x)[34], x, 34);
            this.xModelo1.setValueAt(list.get(x)[35], x, 35);
            this.xModelo1.setValueAt(list.get(x)[36], x, 36);
            this.xModelo1.setValueAt(list.get(x)[37], x, 37);
            this.xModelo1.setValueAt(list.get(x)[38], x, 38);
            this.xModelo1.setValueAt(list.get(x)[39], x, 39);
            this.xModelo1.setValueAt(list.get(x)[40], x, 40);
            this.xModelo1.setValueAt(list.get(x)[41], x, 41);
            this.xModelo1.setValueAt(list.get(x)[42], x, 42);
            this.xModelo1.setValueAt(list.get(x)[43], x, 43);
            this.xModelo1.setValueAt(list.get(x)[44], x, 44);
            this.xModelo1.setValueAt(list.get(x)[45], x, 45);
            this.xModelo1.setValueAt(list.get(x)[46], x, 46);
            this.xModelo1.setValueAt(list.get(x)[47], x, 47);
            this.xModelo1.setValueAt(list.get(x)[48], x, 48);
            this.xModelo1.setValueAt(list.get(x)[49], x, 49);
            this.xModelo1.setValueAt(list.get(x)[50], x, 50);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    public void mCargarDatosTablaTratamientoOdontologico() {
        List<Object[]> list = this.informeTratamientosOdontologicosDAO.mListadoTratamientosOdontologicos(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "");
        mCrearModeloTratamientoOdontolico();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 6);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    private void mCargarDatosTablaEspirometria() {
        List<Object[]> list;
        if (this.xtitulo.equals("Informe Espirometría")) {
            if (this.JCHFiltro.isSelected()) {
                list = this.xInformesSgcDAO.ListInformeEspirometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
            } else {
                list = this.xInformesSgcDAO.ListInformeEspirometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
            }
        } else if (this.JCHFiltro.isSelected()) {
            list = this.xInformesSgcDAO.ListInformeEspirometria1(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
        } else {
            list = this.xInformesSgcDAO.ListInformeEspirometria1(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
        }
        mCrearModeloTablaEspirometria();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[6], x, 3);
            this.xModelo1.setValueAt(list.get(x)[3], x, 4);
            this.xModelo1.setValueAt(list.get(x)[4], x, 5);
            this.xModelo1.setValueAt(list.get(x)[5], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            this.xModelo1.setValueAt(list.get(x)[16], x, 16);
            this.xModelo1.setValueAt(list.get(x)[17], x, 17);
            this.xModelo1.setValueAt(list.get(x)[18], x, 18);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    private void mCargarDatosTablaAudiometria() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xInformesSgcDAO.ListInformeAudiometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
        } else {
            list = this.xInformesSgcDAO.ListInformeAudiometria(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
        }
        mCrearModeloTablaAudiometria();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            this.xModelo1.setValueAt(list.get(x)[16], x, 16);
            this.xModelo1.setValueAt(list.get(x)[17], x, 17);
            this.xModelo1.setValueAt(list.get(x)[18], x, 18);
            this.xModelo1.setValueAt(list.get(x)[19], x, 19);
            this.xModelo1.setValueAt(list.get(x)[20], x, 20);
            this.xModelo1.setValueAt(list.get(x)[21], x, 21);
            this.xModelo1.setValueAt(list.get(x)[22], x, 22);
            this.xModelo1.setValueAt(list.get(x)[23], x, 23);
            this.xModelo1.setValueAt(list.get(x)[24], x, 24);
            this.xModelo1.setValueAt(list.get(x)[25], x, 25);
            this.xModelo1.setValueAt(list.get(x)[26], x, 26);
            this.xModelo1.setValueAt(list.get(x)[27], x, 27);
            this.xModelo1.setValueAt(list.get(x)[28], x, 28);
            this.xModelo1.setValueAt(list.get(x)[29], x, 29);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    public void mCargarDatosNOMA() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xInformesSgcDAO.ListInformeNOMA(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()], 1);
        } else {
            list = this.xInformesSgcDAO.ListInformeNOMA(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", 0);
        }
        mCreaModeloTablaNOMA();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 22);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            this.xModelo1.setValueAt(list.get(x)[16], x, 16);
            this.xModelo1.setValueAt(mAntecendeteNoma(String.valueOf(list.get(x)[11])), x, 17);
            this.xModelo1.setValueAt(mDxNoma(String.valueOf(list.get(x)[11])), x, 18);
            this.xModelo1.setValueAt(list.get(x)[17], x, 19);
            this.xModelo1.setValueAt(list.get(x)[18], x, 20);
            this.xModelo1.setValueAt(list.get(x)[19], x, 21);
            this.xModelo1.setValueAt(list.get(x)[20], x, 22);
        }
        this.JTFFNRegistro.setText(String.valueOf(list.size()));
    }

    private void mCargarDatosInformeAccidenteTransito() {
        List<Object[]> list = this.xInformesSgcDAO.ListInformeAccidenteTransito(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        mCrearModeloInformeAccidenteTransito();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xModelo1.addRow(this.xdatos);
                this.xModelo1.setValueAt(list.get(x)[0], x, 0);
                this.xModelo1.setValueAt(list.get(x)[1], x, 1);
                this.xModelo1.setValueAt(list.get(x)[2], x, 2);
                this.xModelo1.setValueAt(list.get(x)[3], x, 3);
                this.xModelo1.setValueAt(list.get(x)[4], x, 4);
                this.xModelo1.setValueAt(list.get(x)[5], x, 5);
                this.xModelo1.setValueAt(list.get(x)[6], x, 6);
                this.xModelo1.setValueAt(list.get(x)[7], x, 7);
                this.xModelo1.setValueAt(list.get(x)[8], x, 8);
                this.xModelo1.setValueAt(list.get(x)[9], x, 9);
                this.xModelo1.setValueAt(list.get(x)[10], x, 10);
                this.xModelo1.setValueAt(list.get(x)[11], x, 11);
                this.xModelo1.setValueAt(list.get(x)[12], x, 12);
                this.xModelo1.setValueAt(list.get(x)[13], x, 13);
                this.xModelo1.setValueAt(list.get(x)[14], x, 14);
                this.xModelo1.setValueAt(list.get(x)[15], x, 15);
            }
            this.JTFFNRegistro.setText(String.valueOf(list.size()));
        }
    }

    private String mAntecendeteNoma(String xidPrueba) {
        String resultado = "-";
        String sqlp = "SELECT IF(GROUP_CONCAT(CONCAT(`so_segmento`.`Nbre`,': ' , `h_so_examen_osteo_detalle`.`Observacion`) SEPARATOR '\n') IS NULL, '', GROUP_CONCAT(CONCAT(`so_segmento`.`Nbre`,': ' , `h_so_examen_osteo_detalle`.`Observacion`) SEPARATOR '\n')) AS Antecedente\nFROM `h_so_examen_osteo_detalle` INNER JOIN  `so_segmento_x_encabezado`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)\nINNER JOIN  `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)\nWHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =1 AND `h_so_examen_osteo_detalle`.`Id_ExamenOsteo` ='" + xidPrueba + "');";
        ConsultasMySQL xctp = new ConsultasMySQL();
        ResultSet xrsp = xctp.traerRs(sqlp);
        try {
            if (xrsp.next()) {
                resultado = xrsp.getString(1);
            } else {
                resultado = "-";
            }
            xrsp.close();
            xctp.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesGenericoSO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    private String mDxNoma(String xidPrueba) {
        String resultado = "";
        String sqlp = "SELECT IF(GROUP_CONCAT(CONCAT(`so_segmento`.`Nbre`,': ' ,h_so_examen_osteo_detalle.`CodCIE10`,' ',`h_so_examen_osteo_detalle`.`Observacion`) SEPARATOR '\n') IS NULL, '', GROUP_CONCAT(CONCAT(`so_segmento`.`Nbre`,': ' ,h_so_examen_osteo_detalle.`CodCIE10`,' ',`h_so_examen_osteo_detalle`.`Observacion`) SEPARATOR '\n')) AS Antecedente\nFROM `h_so_examen_osteo_detalle` INNER JOIN  `so_segmento_x_encabezado`   ON (`h_so_examen_osteo_detalle`.`Id_Segmentos` = `so_segmento_x_encabezado`.`Id`)\nINNER JOIN  `so_segmento`   ON (`so_segmento_x_encabezado`.`Id_Segmento` = `so_segmento`.`Id`)\nWHERE (`so_segmento_x_encabezado`.`Id_EmcabezadoSeg` =2 AND `h_so_examen_osteo_detalle`.`Id_ExamenOsteo` ='" + xidPrueba + "');";
        ConsultasMySQL xctp = new ConsultasMySQL();
        ResultSet xrsp = xctp.traerRs(sqlp);
        try {
            if (xrsp.next()) {
                resultado = xrsp.getString(1);
            } else {
                resultado = "-";
            }
            xrsp.close();
            xctp.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesGenericoSO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos3 = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformegenericoso");
        this.JPIDatos3.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.7
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGenericoSO.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesGenericoSO.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformesGenericoSO.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPIDatos3Layout = new GroupLayout(this.JPIDatos3);
        this.JPIDatos3.setLayout(JPIDatos3Layout);
        JPIDatos3Layout.setHorizontalGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos3Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addGap(26, 26, 26)));
        JPIDatos3Layout.setVerticalGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos3Layout.createSequentialGroup().addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGroup(JPIDatos3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, GroupLayout.Alignment.LEADING, -2, 52, -2).addComponent(this.JCHFiltro))).addGap(17, 17, 17)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setAutoscrolls(true);
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setCellSelectionEnabled(true);
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNRegistro.setHorizontalAlignment(0);
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.10
            public void mouseClicked(MouseEvent evt) {
                JIFInformesGenericoSO.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformesGenericoSO.11
            public void actionPerformed(ActionEvent evt) {
                JIFInformesGenericoSO.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos3, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 175, 32767).addComponent(this.JTFFNRegistro, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 543, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 199, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos3, -2, -1, -2).addGap(1, 1, 1).addComponent(this.JSPDetalle, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFFNRegistro, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }
}
