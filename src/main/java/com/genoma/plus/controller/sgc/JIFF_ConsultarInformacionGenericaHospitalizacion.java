package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.sgc.ConsultarInformacionGenericaHospitalizacionDAO;
import com.genoma.plus.dto.sgc.ConsultarInformacionGenericaHospitalizacionDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFF_ConsultarInformacionGenericaHospitalizacion.class */
public class JIFF_ConsultarInformacionGenericaHospitalizacion extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private Object[] xDatoF;
    private ConsultarInformacionGenericaHospitalizacionDAO xConsultarInformacionGenericaHospitalizacionDAO;
    private List<Object[]> listConvenio;
    private String nombre;
    private JButton JBTExportar;
    private JComboBox<String> JCBConvenio;
    private JCheckBox JChBFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JPanel jPConvenio;
    private JPanel jPOpcion;
    private JPanel jPanel3;
    private Metodos xmt = new Metodos();
    private ConsultarInformacionGenericaHospitalizacionDTO consultarInformacionGenericaHospitalizacionDTO = new ConsultarInformacionGenericaHospitalizacionDTO();
    private Boolean xy = false;

    public JIFF_ConsultarInformacionGenericaHospitalizacion(String nombre) {
        initComponents();
        this.nombre = nombre;
        springStart();
        mNuevo();
        if (!this.nombre.equals("Informe de camas")) {
            mCargarCombo();
        }
        setTitle(nombre.toUpperCase());
    }

    private void springStart() {
        this.xConsultarInformacionGenericaHospitalizacionDAO = (ConsultarInformacionGenericaHospitalizacionDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultarInformacionGenericaHospitalizacionDAOImpl");
    }

    public void mNuevo() {
        this.xy = false;
        if (!this.xy.booleanValue()) {
            System.out.println("Cargar fecha");
            this.JCBConvenio.removeAllItems();
            this.JDFechaI.setDate(this.xmt.getFechaActual());
            this.JDFechaF.setDate(this.xmt.getFechaActual());
            this.xy = true;
        }
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (this.nombre.equals("Total dias hospitalizados")) {
            mCrearModeloTotalDiasHospitalizado();
        }
        if (this.nombre.equals("Informe de camas")) {
            mCrearModeloInformeDeCamas();
            this.jPOpcion.setVisible(false);
            this.jPConvenio.setVisible(false);
        }
        if (this.nombre.equals("Pacientes ingresados")) {
            mCrearModeloPacientesIngresados();
        }
        if (this.nombre.equals("Pacientes egresados")) {
            mCrearModeloPacientesEgresados();
        }
        if (this.nombre.equals("Citas no programadas consulta externa")) {
            mCrearModeloCitasNoProgramadasConsultaExterna();
        }
        if (this.nombre.equals("Citas programadas")) {
            mCrearModeloCitasProgramadas();
        }
        this.JLBLCont.setText("0");
        this.JChBFiltro.setSelected(false);
    }

    private void mCrearModeloTotalDiasHospitalizado() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idIngreso", "tipoIdent", "NoDocumento", "FechaNac", "sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "DxIngreso", "FechaIngreso", "HoraIngreso", "fechaEgreso", "horaEgreso", "totalDiasHospitalizado", "totalHorasHospitalizacion", "NProfesional", "Especialidad", "convenio", "Id_Atencion"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
    }

    private void mCargarDatosTablaTotalDiasHospitalizado() {
        mCrearModeloTotalDiasHospitalizado();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mTotalDiasHospitalizado(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < 20; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloTotalDiasHospitalizadoFiltro() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idIngreso", "tipoIdent", "NoDocumento", "FechaNac", "sexo", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "DxIngreso", "FechaIngreso", "HoraIngreso", "fechaEgreso", "horaEgreso", "totalDiasHospitalizado", "totalHorasHospitalizacion", "NProfesional", "Especialidad", "Id_Atencion"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
    }

    private void mCargarDatosTablaTotalDiasHospitalizadoFiltro() {
        mCrearModeloTotalDiasHospitalizadoFiltro();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mTotalDiasHospitalizadoFiltro(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 19; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloInformeDeCamas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idCama ", "UnidadCama ", "Cama ", "horasCamaOcu ", "horasCamaDes ", "estadoActual"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void mCargarDatosTablaInformeDeCamas() {
        mCrearModeloInformeDeCamas();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mInformeDeCamas(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 6; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloPacientesIngresados() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idIngreso", "FechaIngreso", "HoraIngreso", "Id_Usuario", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "Id_Sexo", "Convenio", "Especialidad", "NProfesional", "tipoAtencion"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void mCargarDatosTablaPacientesIngresados() {
        mCrearModeloPacientesIngresados();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mPacientesIngresados(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 16; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloPacientesIngresadosFiltro() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idIngreso", "FechaIngreso", "HoraIngreso", "Id_Usuario", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "Id_Sexo", "Id", "Convenio", "Especialidad", "NProfesional", "tipoAtencion"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
    }

    private void mCargarDatosTablaPacientesIngresadosFiltro() {
        mCrearModeloPacientesIngresadosFiltro();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mPacientesIngresadosFiltro(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 17; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloPacientesEgresados() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idEgreso", "fechaEgreso", "horaEgreso", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "sexo", "FechaNac", "Id_Ingreso", "Id_Atencion", "DxP", "NDxP", "ObservacionG1", "NProfesional", "Especialidad", "convenio"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    }

    private void mCargarDatosTablaPacientesEgresados() {
        mCrearModeloPacientesEgresados();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mPacientesEgresados(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 19; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloPacientesEgresadosFiltro() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idEgreso", "fechaEgreso", "horaEgreso", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "sexo", "FechaNac", "Id_Ingreso", "Id_Atencion", "DxP", "NDxP", "ObservacionG1", "NProfesional", "Especialidad", "convenio"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    }

    private void mCargarDatosTablaPacientesEgresadosFiltro() {
        mCrearModeloPacientesEgresadosFiltro();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mPacientesEgresadosFiltro(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 19; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloCitasNoProgramadasConsultaExterna() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idCita", "idIngreso", "Fecha_Cita", "horaCita", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "sexo", "FechaNac", "claseCita", "convenio", "NProfesional", "Especialidad"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.8
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void mCargarDatosTablaCitasNoProgramadasConsultaExterna() {
        mCrearModeloCitasNoProgramadasConsultaExterna();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mCitasNoProgramadasConsultaExterna(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 16; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloCitasNoProgramadasConsultaExternaFiltro() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idCita", "idIngreso", "Fecha_Cita", "horaCita", "tipoIdent", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "sexo", "FechaNac", "claseCita", "convenio", "NProfesional", "Especialidad"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void mCargarDatosTablaCitasNoProgramadasConsultaExternaFiltro() {
        mCrearModeloCitasNoProgramadasConsultaExternaFiltro();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mCitasNoProgramadasConsultaExternaFiltro(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 16; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloCitasProgramadas() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idCita", "Fecha_Cita", "claseCita", "tipoIdenti", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "sexo", "convenio", "NProfesional", "Especialidad", "Id_ingreso"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    private void mCargarDatosTablaCitasProgramadas() {
        mCrearModeloCitasProgramadas();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mCitasProgramadas(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 15; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private void mCrearModeloCitasProgramadasFiltro() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"idCita", "Fecha_Cita", "claseCita", "tipoIdenti", "NoDocumento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "FechaNac", "sexo", "convenio", "NProfesional", "Especialidad", "Id_ingreso"}) { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    private void mCargarDatosTablaCitasProgramadasFiltro() {
        mCrearModeloCitasProgramadasFiltro();
        List<Object[]> list = this.xConsultarInformacionGenericaHospitalizacionDAO.mCitasProgramadasFiltro(this.consultarInformacionGenericaHospitalizacionDTO);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatoF);
            for (int y = 0; y < 15; y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
        this.JLBLCont.setText(list.size() + "");
    }

    public void mCargarCombo() {
        if (this.xy.booleanValue()) {
            this.consultarInformacionGenericaHospitalizacionDTO = new ConsultarInformacionGenericaHospitalizacionDTO();
            this.consultarInformacionGenericaHospitalizacionDTO.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            this.consultarInformacionGenericaHospitalizacionDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            this.JCBConvenio.removeAllItems();
            if (this.nombre.equals("Total dias hospitalizados")) {
                this.listConvenio = this.xConsultarInformacionGenericaHospitalizacionDAO.mCargarComboTotalDiasHospitalizado(this.consultarInformacionGenericaHospitalizacionDTO);
            } else if (this.nombre.equals("Pacientes ingresados")) {
                this.listConvenio = this.xConsultarInformacionGenericaHospitalizacionDAO.mCargarComboPacientesIngresados(this.consultarInformacionGenericaHospitalizacionDTO);
            } else if (this.nombre.equals("Pacientes egresados")) {
                this.listConvenio = this.xConsultarInformacionGenericaHospitalizacionDAO.mCargarComboPacientesEgresados(this.consultarInformacionGenericaHospitalizacionDTO);
            } else if (this.nombre.equals("Citas no programadas consulta externa")) {
                this.listConvenio = this.xConsultarInformacionGenericaHospitalizacionDAO.mCargarComboCitasNoProgramadasConsultaExterna(this.consultarInformacionGenericaHospitalizacionDTO);
            } else if (this.nombre.equals("Citas programadas")) {
                this.listConvenio = this.xConsultarInformacionGenericaHospitalizacionDAO.mCargarComboCitasProgramadas(this.consultarInformacionGenericaHospitalizacionDTO);
            }
            for (int i = 0; i < this.listConvenio.size(); i++) {
                this.JCBConvenio.addItem(this.listConvenio.get(i)[1].toString());
            }
            this.JCBConvenio.setSelectedIndex(-1);
        }
    }

    public void mBuscar() {
        this.consultarInformacionGenericaHospitalizacionDTO = new ConsultarInformacionGenericaHospitalizacionDTO();
        this.consultarInformacionGenericaHospitalizacionDTO.setFechaInicio(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.consultarInformacionGenericaHospitalizacionDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        if (this.JChBFiltro.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                for (int i = 0; i < this.listConvenio.size(); i++) {
                    if (this.JCBConvenio.getSelectedItem().equals(this.listConvenio.get(i)[1].toString())) {
                        this.consultarInformacionGenericaHospitalizacionDTO.setFiltroCombo(this.listConvenio.get(i)[0].toString());
                        if (this.nombre.equals("Total dias hospitalizados")) {
                            mCargarDatosTablaTotalDiasHospitalizadoFiltro();
                        } else if (!this.nombre.equals("Informe de camas")) {
                            if (this.nombre.equals("Pacientes ingresados")) {
                                mCargarDatosTablaPacientesIngresadosFiltro();
                            } else if (this.nombre.equals("Pacientes egresados")) {
                                mCargarDatosTablaPacientesEgresadosFiltro();
                            } else if (this.nombre.equals("Citas no programadas consulta externa")) {
                                mCargarDatosTablaCitasNoProgramadasConsultaExternaFiltro();
                            } else if (this.nombre.equals("Citas programadas")) {
                                mCargarDatosTablaCitasProgramadasFiltro();
                            }
                        }
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un convenio o desmarcar la opción de filtro", "Mensaje", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            mCrearModeloTotalDiasHospitalizadoFiltro();
            this.JLBLCont.setText("0");
            return;
        }
        if (this.nombre.equals("Total dias hospitalizados")) {
            mCargarDatosTablaTotalDiasHospitalizado();
            return;
        }
        if (this.nombre.equals("Informe de camas")) {
            this.consultarInformacionGenericaHospitalizacionDTO = new ConsultarInformacionGenericaHospitalizacionDTO();
            this.consultarInformacionGenericaHospitalizacionDTO.setFechaInicio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()));
            this.consultarInformacionGenericaHospitalizacionDTO.setFechaFinal(this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            mCargarDatosTablaInformeDeCamas();
            return;
        }
        if (this.nombre.equals("Pacientes ingresados")) {
            mCargarDatosTablaPacientesIngresados();
            return;
        }
        if (this.nombre.equals("Pacientes egresados")) {
            mCargarDatosTablaPacientesEgresados();
        } else if (this.nombre.equals("Citas no programadas consulta externa")) {
            mCargarDatosTablaCitasNoProgramadasConsultaExterna();
        } else if (this.nombre.equals("Citas programadas")) {
            mCargarDatosTablaCitasProgramadas();
        }
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPOpcion = new JPanel();
        this.JChBFiltro = new JCheckBox();
        this.jPConvenio = new JPanel();
        this.JCBConvenio = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel3 = new JPanel();
        this.JLBLCont = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("Informacion generica");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiff_ConsultarInformacionGenericaHospitalizacion");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.13
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JDFechaFPropertyChange(evt);
            }
        });
        this.jPOpcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Opcion", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.JChBFiltro.setText("Filtro");
        GroupLayout jPOpcionLayout = new GroupLayout(this.jPOpcion);
        this.jPOpcion.setLayout(jPOpcionLayout);
        jPOpcionLayout.setHorizontalGroup(jPOpcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPOpcionLayout.createSequentialGroup().addContainerGap().addComponent(this.JChBFiltro).addContainerGap(20, 32767)));
        jPOpcionLayout.setVerticalGroup(jPOpcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPOpcionLayout.createSequentialGroup().addComponent(this.JChBFiltro, -2, 31, -2).addGap(0, 0, 32767)));
        this.jPConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Dialog", 1, 12), new Color(0, 0, 255)));
        this.JCBConvenio.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.JCBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.14
            public void actionPerformed(ActionEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JCBConvenioActionPerformed(evt);
            }
        });
        GroupLayout jPConvenioLayout = new GroupLayout(this.jPConvenio);
        this.jPConvenio.setLayout(jPConvenioLayout);
        jPConvenioLayout.setHorizontalGroup(jPConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, GroupLayout.Alignment.TRAILING, 0, 733, 32767));
        jPConvenioLayout.setVerticalGroup(jPConvenioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConvenio, -2, 36, -2));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(95, 95, 95).addComponent(this.jPOpcion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPConvenio, -1, -1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(-1, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPOpcion, -1, -1, 32767).addComponent(this.jPConvenio, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "EXPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.15
            public void mouseClicked(MouseEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.16
            public void actionPerformed(ActionEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFF_ConsultarInformacionGenericaHospitalizacion.17
            public void actionPerformed(ActionEvent evt) {
                JIFF_ConsultarInformacionGenericaHospitalizacion.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 734, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Total de registros", 0, 0, new Font("Dialog", 1, 12), Color.blue));
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBLCont).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, 1243, 32767).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel3, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 378, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPExportar, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
        pack();
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xy.booleanValue() && !this.nombre.equals("Informe de camas")) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xy.booleanValue() && !this.nombre.equals("Informe de camas")) {
            mCargarCombo();
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }
}
