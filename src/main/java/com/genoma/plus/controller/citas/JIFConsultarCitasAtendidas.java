package com.genoma.plus.controller.citas;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.citas.InformesCitasDAO;
import com.genoma.plus.dao.impl.citas.InformesCitasDAOImpl;
import com.genoma.plus.dto.citas.ConsultarCitasAtendidasDTO;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/citas/JIFConsultarCitasAtendidas.class */
public class JIFConsultarCitasAtendidas extends JInternalFrame {
    private DefaultTableModel xmodeloP;
    private DefaultTableModel xmodeloNP;
    private Object[] xDato;
    private String[] xidEspecialidad;
    private String[] xidProfesional;
    private InformesCitasDAO xInformesCitasDAO;
    private JButton JBTExportar;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JCheckBox JChBFiltroProfesional;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JScrollPane JSDetalleNoProgramadas;
    private JScrollPane JSDetalleProgramadas;
    private JTable JTDetalleNoProgramadas;
    private JTable JTDetalleProgramadas;
    private JTextField JTFRuta;
    private JTabbedPane JTPTipoAtencion;
    private String xNombre = "";
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xvalidar = 0;

    public JIFConsultarCitasAtendidas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesCitasDAO = (InformesCitasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesCitasDAO");
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xvalidar = 1;
        this.JCBProfesional.removeAllItems();
        this.JChBFiltroProfesional.setSelected(true);
        mCrearTablaProgramadas();
        mCrearTablaNoProgramadas();
    }

    public void mBuscar() {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (!this.JChBFiltroProfesional.isSelected()) {
                mBuscaDatosProgramadas(-1);
                mBuscaDatosNoProgramadas(-1);
                return;
            } else if (this.JCBProfesional.getSelectedIndex() != -1) {
                this.xInformesCitasDAO.deleteInformacionConsolidadoCitasTmp();
                mBuscaDatosProgramadas(0);
                mBuscaDatosNoProgramadas(0);
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProfesional.requestFocus();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    public void mImprimir() {
        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
            if (this.JCBProfesional.getSelectedIndex() != -1) {
                String[][] mparametros = new String[6][2];
                mparametros[0][0] = "FechaI";
                mparametros[0][1] = this.xmt.formatoAMD1.format(this.JDFechaI.getDate());
                mparametros[1][0] = "FechaF";
                mparametros[1][1] = this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
                mparametros[2][0] = "Id_Profesional";
                mparametros[2][1] = this.xidProfesional[this.JCBProfesional.getSelectedIndex()];
                mparametros[3][0] = "Id_Especialidad";
                mparametros[3][1] = this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()];
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                if (!this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()].equals("360")) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Consolidado_CitasAtendidas", mparametros);
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Consolidado_CitasAtendidas_Imagenes_Diagnostico", mparametros);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProfesional.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una Especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBEspecialidad.requestFocus();
    }

    private void mBuscaDatosProgramadas(int bandera) {
        List<ConsultarCitasAtendidasDTO> list;
        if (bandera == -1) {
            list = this.xInformesCitasDAO.listProgramadas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], "-1");
        } else {
            list = this.xInformesCitasDAO.listProgramadas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], this.xidProfesional[this.JCBProfesional.getSelectedIndex()]);
        }
        mCrearTablaProgramadas();
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloP.addRow(this.xDato);
            this.xmodeloP.setValueAt(list.get(x).getFecha(), x, 0);
            this.xmodeloP.setValueAt(list.get(x).getHora(), x, 1);
            this.xmodeloP.setValueAt(list.get(x).getNDocumento(), x, 2);
            this.xmodeloP.setValueAt(list.get(x).getUsuario(), x, 3);
            this.xmodeloP.setValueAt(list.get(x).getSexo(), x, 4);
            this.xmodeloP.setValueAt(list.get(x).getEdad(), x, 5);
            this.xmodeloP.setValueAt(list.get(x).getTipoCita(), x, 6);
            this.xmodeloP.setValueAt(list.get(x).getEntidad(), x, 7);
            this.xmodeloP.setValueAt(list.get(x).getIps(), x, 8);
            this.xmodeloP.setValueAt(list.get(x).getEstado(), x, 9);
            this.xmodeloP.setValueAt(list.get(x).getNIngreso(), x, 10);
            this.xmodeloP.setValueAt(list.get(x).getNFactura(), x, 11);
            this.xmodeloP.setValueAt(list.get(x).getNOrdenS(), x, 12);
            this.xmodeloP.setValueAt(list.get(x).getEspecialidad(), x, 13);
            this.xmodeloP.setValueAt(list.get(x).getProfesional(), x, 14);
        }
        if (bandera == -1) {
            this.xInformesCitasDAO.addConsolidadoCitasTmp(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], "Todos", 0);
        } else {
            this.xInformesCitasDAO.addConsolidadoCitasTmp(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], this.xidProfesional[this.JCBProfesional.getSelectedIndex()], 0);
        }
    }

    private void mCrearTablaProgramadas() {
        this.xmodeloP = new DefaultTableModel() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodeloP.addColumn("Fecha");
        this.xmodeloP.addColumn("Hora");
        this.xmodeloP.addColumn("Documento");
        this.xmodeloP.addColumn("Usuario");
        this.xmodeloP.addColumn("Sexo");
        this.xmodeloP.addColumn("Edad");
        this.xmodeloP.addColumn("Clase de Cita");
        this.xmodeloP.addColumn("Entidad");
        this.xmodeloP.addColumn("Ips");
        this.xmodeloP.addColumn("Estado");
        this.xmodeloP.addColumn("NIngreso");
        this.xmodeloP.addColumn("NFactura");
        this.xmodeloP.addColumn("NOrdenServicio");
        this.xmodeloP.addColumn("Especialidad");
        this.xmodeloP.addColumn("Profesional");
        JTable jTable = this.JTDetalleProgramadas;
        JTable jTable2 = this.JTDetalleProgramadas;
        jTable.setAutoResizeMode(0);
        this.JTDetalleProgramadas.doLayout();
        this.JTDetalleProgramadas.setModel(this.xmodeloP);
        this.JTDetalleProgramadas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleProgramadas.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleProgramadas.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleProgramadas.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleProgramadas.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleProgramadas.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleProgramadas.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalleProgramadas.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalleProgramadas.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleProgramadas.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleProgramadas.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleProgramadas.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleProgramadas.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalleProgramadas.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalleProgramadas.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalleProgramadas.setModel(this.xmodeloP);
    }

    private void mBuscaDatosNoProgramadas(int bandera) {
        List<ConsultarCitasAtendidasDTO> list;
        if (bandera == -1) {
            list = this.xInformesCitasDAO.listNoProgramadas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], "-1");
        } else {
            list = this.xInformesCitasDAO.listNoProgramadas(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], this.xidProfesional[this.JCBProfesional.getSelectedIndex()]);
        }
        mCrearTablaNoProgramadas();
        for (int x = 0; x < list.size(); x++) {
            this.xmodeloNP.addRow(this.xDato);
            this.xmodeloNP.setValueAt(list.get(x).getFecha(), x, 0);
            this.xmodeloNP.setValueAt(list.get(x).getHora(), x, 1);
            this.xmodeloNP.setValueAt(list.get(x).getNDocumento(), x, 2);
            this.xmodeloNP.setValueAt(list.get(x).getUsuario(), x, 3);
            this.xmodeloNP.setValueAt(list.get(x).getSexo(), x, 4);
            this.xmodeloNP.setValueAt(list.get(x).getEdad(), x, 5);
            this.xmodeloNP.setValueAt(list.get(x).getTipoCita(), x, 6);
            this.xmodeloNP.setValueAt(list.get(x).getEntidad(), x, 7);
            this.xmodeloNP.setValueAt(list.get(x).getIps(), x, 8);
            this.xmodeloNP.setValueAt(list.get(x).getEstado(), x, 9);
            this.xmodeloNP.setValueAt(list.get(x).getNIngreso(), x, 10);
            this.xmodeloNP.setValueAt(list.get(x).getNFactura(), x, 11);
            this.xmodeloNP.setValueAt(list.get(x).getNOrdenS(), x, 12);
            this.xmodeloNP.setValueAt(list.get(x).getEspecialidad(), x, 13);
            this.xmodeloNP.setValueAt(list.get(x).getProfesional(), x, 14);
        }
        if (bandera == -1) {
            this.xInformesCitasDAO.addConsolidadoCitasTmp(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], "Todos", 0);
        } else {
            this.xInformesCitasDAO.addConsolidadoCitasTmp(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()], this.xidProfesional[this.JCBProfesional.getSelectedIndex()], 0);
        }
    }

    private void mCrearTablaNoProgramadas() {
        this.xmodeloNP = new DefaultTableModel() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodeloNP.addColumn("Fecha");
        this.xmodeloNP.addColumn("Hora");
        this.xmodeloNP.addColumn("Documento");
        this.xmodeloNP.addColumn("Usuario");
        this.xmodeloNP.addColumn("Sexo");
        this.xmodeloNP.addColumn("Edad");
        this.xmodeloNP.addColumn("Clase de Cita");
        this.xmodeloNP.addColumn("Entidad");
        this.xmodeloNP.addColumn("Ips");
        this.xmodeloNP.addColumn("Estado");
        this.xmodeloNP.addColumn("NIngreso");
        this.xmodeloNP.addColumn("NFactura");
        this.xmodeloNP.addColumn("NOrdenServicio");
        this.xmodeloNP.addColumn("Especialidad");
        this.xmodeloNP.addColumn("Profesional");
        JTable jTable = this.JTDetalleNoProgramadas;
        JTable jTable2 = this.JTDetalleNoProgramadas;
        jTable.setAutoResizeMode(0);
        this.JTDetalleNoProgramadas.doLayout();
        this.JTDetalleNoProgramadas.setModel(this.xmodeloNP);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalleNoProgramadas.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalleNoProgramadas.setModel(this.xmodeloNP);
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBEspecialidad.removeAllItems();
        this.xidEspecialidad = this.xct.llenarCombo("(SELECT g_especialidad.Id \n, g_especialidad.Nbre AS NEspecialidad \nFROM g_persona \nINNER JOIN c_citas ON (g_persona.Id = c_citas.Id_Usuario)\nINNER JOIN f_empresacontxconvenio ON (c_citas.Id_EmpresaCont = f_empresacontxconvenio.Id) \nINNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)\nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id) \nINNER JOIN ingreso ON (ingreso.Id = c_citas.Id_ingreso) \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona AS g_persona_1 ON (g_persona_1.Id = c_citas.Id_Profesional) \nINNER JOIN g_especialidad ON (g_especialidad.Id = h_atencion.Id_Especialidad) \n                WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' )\nGROUP BY NEspecialidad ORDER BY NEspecialidad ASC)\nUNION\n(SELECT g_especialidad.Id \n, g_especialidad.Nbre AS NEspecialidad \nFROM g_persona \nINNER JOIN c_citasnp ON (g_persona.Id = c_citasnp.Id_Usuario)\nINNER JOIN f_empresacontxconvenio ON (c_citasnp.Id_EmpresaCont = f_empresacontxconvenio.Id) \nINNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)\nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id) \nINNER JOIN ingreso ON (ingreso.Id = c_citasnp.Id_ingreso) \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona AS g_persona_1 ON (g_persona_1.Id = c_citasnp.Id_Profesional) \nINNER JOIN g_especialidad ON (g_especialidad.Id = h_atencion.Id_Especialidad) \n                WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' )\nGROUP BY NEspecialidad ORDER BY NEspecialidad ASC)", this.xidEspecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JChBFiltroProfesional = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPTipoAtencion = new JTabbedPane();
        this.JSDetalleProgramadas = new JScrollPane();
        this.JTDetalleProgramadas = new JTable();
        this.JSDetalleNoProgramadas = new JScrollPane();
        this.JTDetalleNoProgramadas = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CITAS ATENDIDAS POR PROFESIONAL");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarcitasprofesional");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitasAtendidas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarCitasAtendidas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.5
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarCitasAtendidas.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JChBFiltroProfesional.setText("Filtro Profesional");
        this.JChBFiltroProfesional.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.6
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarCitasAtendidas.this.JChBFiltroProfesionalItemStateChanged(evt);
            }
        });
        this.JChBFiltroProfesional.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.7
            public void stateChanged(ChangeEvent evt) {
                JIFConsultarCitasAtendidas.this.JChBFiltroProfesionalStateChanged(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProfesional, 0, -1, 32767).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JChBFiltroProfesional).addGap(0, 0, 32767))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(-1, 32767)).addGroup(JPDatosLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JCBProfesional, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JChBFiltroProfesional)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.8
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCitasAtendidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitasAtendidas.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JIFConsultarCitasAtendidas.10
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCitasAtendidas.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTPTipoAtencion.setForeground(Color.red);
        this.JTPTipoAtencion.setFont(new Font("Arial", 1, 14));
        this.JSDetalleProgramadas.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleProgramadas.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProgramadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleProgramadas.setSelectionBackground(Color.white);
        this.JTDetalleProgramadas.setSelectionForeground(Color.red);
        this.JSDetalleProgramadas.setViewportView(this.JTDetalleProgramadas);
        this.JTPTipoAtencion.addTab("PROGRAMADAS", this.JSDetalleProgramadas);
        this.JSDetalleNoProgramadas.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleNoProgramadas.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNoProgramadas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleNoProgramadas.setSelectionBackground(Color.white);
        this.JTDetalleNoProgramadas.setSelectionForeground(Color.red);
        this.JSDetalleNoProgramadas.setViewportView(this.JTDetalleNoProgramadas);
        this.JTPTipoAtencion.addTab("NO PROGRAMADAS", this.JSDetalleNoProgramadas);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPTipoAtencion).addComponent(this.JPDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 637, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, 342, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPTipoAtencion, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, 50, 32767).addComponent(this.JTFRuta, -1, 50, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xvalidar == 1) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xvalidar == 1) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xidProfesional = this.xct.llenarCombo("(SELECT c_citas.Id_Profesional ,  CONCAT(g_persona_1.Nombre1,' ', g_persona_1.Nombre2,' ',g_persona_1.Apellido1,' ',g_persona_1.Apellido2)  AS NProfesional FROM g_persona INNER JOIN c_citas ON (g_persona.Id = c_citas.Id_Usuario)\nINNER JOIN f_empresacontxconvenio ON (c_citas.Id_EmpresaCont = f_empresacontxconvenio.Id) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)\nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id) INNER JOIN ingreso ON (ingreso.Id = c_citas.Id_ingreso) INNER JOIN h_atencion\nON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN g_persona AS g_persona_1 ON (g_persona_1.Id = c_citas.Id_Profesional) INNER JOIN g_especialidad\nON (g_especialidad.Id = c_citas.Id_Especialidad)\n WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' \n AND c_citas.Id_Especialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' )\nGROUP BY NProfesional ORDER BY NProfesional ASC)\nUNION\n(SELECT c_citasnp.Id_Profesional ,  CONCAT(g_persona_1.Nombre1,' ', g_persona_1.Nombre2,' ',g_persona_1.Apellido1,' ',g_persona_1.Apellido2)  AS NProfesional \nFROM g_persona \nINNER JOIN c_citasnp ON (g_persona.Id = c_citasnp.Id_Usuario)\nINNER JOIN f_empresacontxconvenio ON (c_citasnp.Id_EmpresaCont = f_empresacontxconvenio.Id) \nINNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id)\nINNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id) \nINNER JOIN ingreso ON (ingreso.Id = c_citasnp.Id_ingreso) \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) \nINNER JOIN g_persona AS g_persona_1 ON (g_persona_1.Id = c_citasnp.Id_Profesional) \nINNER JOIN g_especialidad ON (g_especialidad.Id = c_citasnp.Id_Especialidad)\n WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'  \n AND c_citasnp.Id_Especialidad ='" + this.xidEspecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' )\nGROUP BY NProfesional ORDER BY NProfesional ASC)", this.xidProfesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTPTipoAtencion.getSelectedIndex() == 0) {
                if (this.JTDetalleProgramadas.getRowCount() > -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleProgramadas, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.JTDetalleNoProgramadas.getRowCount() > -1) {
                int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleNoProgramadas, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JChBFiltroProfesionalItemStateChanged(ItemEvent evt) {
        System.out.println("Estado Cambiado de JCHeckBox");
        if (this.JChBFiltroProfesional.isSelected()) {
            this.JCBProfesional.setEnabled(true);
        } else {
            this.JCBProfesional.setEnabled(false);
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JChBFiltroProfesionalStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }
}
