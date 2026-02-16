package com.genoma.plus.controller.imagenesdx;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.inventario.InformesDespachoPacienteDAOImpl;
import com.genoma.plus.dao.inventario.InformesDespachoPacienteDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.inventario.InformesDespachoPacienteDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/imagenesdx/JIFInformesDespachoPaciente.class */
public class JIFInformesDespachoPaciente extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private InformesDespachoPacienteDAO xInformesDespachoPacienteDAO;
    private DefaultTableModel xModelo1;
    private DefaultTableModel xModelo2;
    private DefaultTableModel xModelo3;
    private DefaultTableModel xModelo4;
    private Object[] xdatos;
    private File xfile;
    private String[] xidBodega;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPInformacion;
    private JScrollPane JSPAuditoria;
    private JScrollPane JSPEmpresa;
    private JScrollPane JSPPaciente;
    private JScrollPane JSProducto;
    private JTable JTAuditoria;
    private JTable JTEmpresa;
    private JTextField JTFRuta;
    private JTabbedPane JTPTablas;
    private JTable JTPaciente;
    private JTable JTProducto;

    public JIFInformesDespachoPaciente() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesDespachoPacienteDAO = (InformesDespachoPacienteDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesDespachoPacienteDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBBodega.removeAllItems();
        List<GCGenericoDTO> list1 = this.xInformesDespachoPacienteDAO.listabodegas();
        this.xidBodega = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidBodega[x] = String.valueOf(list1.get(x).getId());
            this.JCBBodega.addItem(list1.get(x).getNombre());
        }
        this.JCBBodega.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBBodega.setSelectedIndex(-1);
        mCreaModeloPaciente();
        mCreaModeloAuditoria();
        mCreaModeloProducto();
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mCargarDatosPaciente();
            mCargarDatosAuditoria();
            mCargarDatosProducto();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar una Bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBBodega.requestFocus();
        }
    }

    public void mImprimir() {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            String[][] parametros = (String[][]) null;
            String nbreArchivo = "";
            if (this.JTPTablas.getSelectedIndex() == 0) {
                parametros = new String[8][2];
                parametros[0][0] = "idBodega";
                parametros[0][1] = this.xidBodega[this.JCBBodega.getSelectedIndex()];
                parametros[1][0] = "nbreBodega";
                parametros[1][1] = this.JCBBodega.getSelectedItem().toString();
                parametros[2][0] = "fechaInicial";
                parametros[2][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
                parametros[3][0] = "fechaFinal";
                parametros[3][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
                parametros[4][0] = "login";
                parametros[4][1] = Principal.usuarioSistemaDTO.getLogin();
                parametros[5][0] = "ruta";
                parametros[5][1] = this.xmt.getRutaRep();
                parametros[6][0] = "SUBREPORT_DIR";
                parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[7][0] = "SUBREPORTFIRMA_DIR";
                parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                nbreArchivo = "I_DespachosxFechaxPaciente";
            } else if (this.JTPTablas.getSelectedIndex() == 1) {
                parametros = new String[7][2];
                parametros[0][0] = "idBodega";
                parametros[0][1] = this.xidBodega[this.JCBBodega.getSelectedIndex()].toString();
                parametros[1][0] = "fechaInicial";
                parametros[1][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
                parametros[2][0] = "fechaFinal";
                parametros[2][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
                parametros[3][0] = "login";
                parametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                parametros[4][0] = "ruta";
                parametros[4][1] = this.xmt.getRutaRep();
                parametros[5][0] = "SUBREPORT_DIR";
                parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[6][0] = "SUBREPORTFIRMA_DIR";
                parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                nbreArchivo = "I_DespachosxFechaxPaciente_Auditoria";
            } else if (this.JTPTablas.getSelectedIndex() == 2) {
                parametros = new String[8][2];
                parametros[0][0] = "nbreBodega";
                parametros[0][1] = this.JCBBodega.getSelectedItem().toString();
                parametros[1][0] = "idBodega";
                parametros[1][1] = this.xidBodega[this.JCBBodega.getSelectedIndex()].toString();
                parametros[2][0] = "usuario";
                parametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                parametros[3][0] = "fechaInicial";
                parametros[3][1] = this.xmt.formatoAMD.format(this.JDFechaI.getDate());
                parametros[4][0] = "fechaFinal";
                parametros[4][1] = this.xmt.formatoAMD.format(this.JDFechaF.getDate());
                parametros[5][0] = "ruta";
                parametros[5][1] = this.xmt.getRutaRep();
                parametros[6][0] = "SUBREPORT_DIR";
                parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[7][0] = "SUBREPORTFIRMA_DIR";
                parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                nbreArchivo = "I_DespachosxFechaxProducto1";
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + nbreArchivo, parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar una Bodega", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBBodega.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloPaciente() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "No. Orden", "No. Historia", "Usuario", "Producto", "Lote", "Fecha Vencimiento", "Cantidad Solicitada", "Cantidad Despachada", "Valor"}) { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTPaciente;
        JTable jTable2 = this.JTPaciente;
        jTable.setAutoResizeMode(0);
        this.JTPaciente.doLayout();
        this.JTPaciente.setModel(this.xModelo1);
        this.JTPaciente.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTPaciente.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTPaciente.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTPaciente.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTPaciente.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    private void mCargarDatosPaciente() {
        List<InformesDespachoPacienteDTO> list = this.xInformesDespachoPacienteDAO.listaPacientes(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaF.getDate()), this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        mCreaModeloPaciente();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x).getId(), x, 0);
            this.xModelo1.setValueAt(list.get(x).getFechaSalida(), x, 1);
            this.xModelo1.setValueAt(list.get(x).getOrdenH(), x, 2);
            this.xModelo1.setValueAt(list.get(x).getNoHistoria(), x, 3);
            this.xModelo1.setValueAt(list.get(x).getUsuario(), x, 4);
            this.xModelo1.setValueAt(list.get(x).getProducto(), x, 5);
            this.xModelo1.setValueAt(list.get(x).getLote(), x, 6);
            this.xModelo1.setValueAt(list.get(x).getFechaVencimiento(), x, 7);
            this.xModelo1.setValueAt(Integer.valueOf(list.get(x).getCantidadSolicitada()), x, 8);
            this.xModelo1.setValueAt(Integer.valueOf(list.get(x).getCantidadDespachada()), x, 9);
            this.xModelo1.setValueAt(list.get(x).getValor(), x, 10);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloAuditoria() {
        this.xModelo2 = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Id", "No. Historia", "Usuario", "Suministros", "Formula Solicitada", "Bodega"}) { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.2
            Class[] types = {String.class, Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTAuditoria;
        JTable jTable2 = this.JTAuditoria;
        jTable.setAutoResizeMode(0);
        this.JTAuditoria.doLayout();
        this.JTAuditoria.setModel(this.xModelo2);
        this.JTAuditoria.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTAuditoria.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTAuditoria.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTAuditoria.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTAuditoria.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTAuditoria.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTAuditoria.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    private void mCargarDatosAuditoria() {
        List<InformesDespachoPacienteDTO> list = this.xInformesDespachoPacienteDAO.listaAuditoria(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaF.getDate()), this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        mCreaModeloAuditoria();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTAuditoria, 4);
            this.xmt.mEstablecerTextEditor(this.JTAuditoria, 5);
            this.xModelo2.addRow(this.xdatos);
            this.xModelo2.setValueAt(list.get(x).getFechaSalida(), x, 0);
            this.xModelo2.setValueAt(list.get(x).getId(), x, 1);
            this.xModelo2.setValueAt(list.get(x).getNoHistoria(), x, 2);
            this.xModelo2.setValueAt(list.get(x).getUsuario(), x, 3);
            this.xModelo2.setValueAt(list.get(x).getProducto(), x, 4);
            this.xModelo2.setValueAt(list.get(x).getFSolicitada(), x, 5);
            this.xModelo2.setValueAt(list.get(x).getBodega(), x, 6);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloProducto() {
        this.xModelo3 = new DefaultTableModel(new Object[0], new String[]{"Producto", "Cantidad", "Grupo", "Lote", "Fecha Inicio", "Fecha Fin"}) { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.3
            Class[] types = {String.class, Integer.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTProducto;
        JTable jTable2 = this.JTProducto;
        jTable.setAutoResizeMode(0);
        this.JTProducto.doLayout();
        this.JTProducto.setModel(this.xModelo3);
        this.JTProducto.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTProducto.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTProducto.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTProducto.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTProducto.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTProducto.getColumnModel().getColumn(5).setPreferredWidth(120);
    }

    private void mCargarDatosProducto() {
        List<InformesDespachoPacienteDTO> list = this.xInformesDespachoPacienteDAO.listaProducto(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaF.getDate()), this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        mCreaModeloProducto();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo3.addRow(this.xdatos);
            this.xModelo3.setValueAt(list.get(x).getProducto(), x, 0);
            this.xModelo3.setValueAt(Integer.valueOf(list.get(x).getCantidadSolicitada()), x, 1);
            this.xModelo3.setValueAt(list.get(x).getGrupo(), x, 2);
            this.xModelo3.setValueAt(list.get(x).getLote(), x, 3);
            this.xModelo3.setValueAt(list.get(x).getFechaSalida(), x, 4);
            this.xModelo3.setValueAt(list.get(x).getFechaVencimiento(), x, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloEmpresa() {
        this.xModelo4 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nº Contrato", "FechaC", "FechaF", "Duracion", "Tercero", "Unidad Funcional", "Tipo Documento", "Objetivo General", "Valor Presupuesto", "Iva", "Administrador", "Cargo", "IdDiponibilidad", "Es Prorroga?", "Estado", "Validacion", "Seguimientos", "Documentos", "Adicion", "Alerta"}) { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, String.class, String.class, Long.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTEmpresa;
        JTable jTable2 = this.JTEmpresa;
        jTable.setAutoResizeMode(0);
        this.JTEmpresa.doLayout();
        this.JTEmpresa.setModel(this.xModelo4);
        this.JTEmpresa.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTEmpresa.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTEmpresa.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTEmpresa.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTEmpresa.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTEmpresa.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTEmpresa.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTEmpresa.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTEmpresa.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTEmpresa.getColumnModel().getColumn(15).setPreferredWidth(80);
        this.JTEmpresa.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTEmpresa.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTEmpresa.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTEmpresa.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTEmpresa.getColumnModel().getColumn(18).setPreferredWidth(300);
        this.JTEmpresa.getColumnModel().getColumn(19).setPreferredWidth(300);
        this.JTEmpresa.getColumnModel().getColumn(20).setPreferredWidth(100);
    }

    private void mCargarDatosEmpresa() {
        List<InformesDespachoPacienteDTO> list = this.xInformesDespachoPacienteDAO.listaEmpresa(this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xmt.formatoAMDG.format(this.JDFechaI.getDate()), this.xidBodega[this.JCBBodega.getSelectedIndex()]);
        mCreaModeloEmpresa();
        for (int x = 0; x < list.size(); x++) {
        }
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPTablas = new JTabbedPane();
        this.JSPPaciente = new JScrollPane();
        this.JTPaciente = new JTable();
        this.JSPAuditoria = new JScrollPane();
        this.JTAuditoria = new JTable();
        this.JSProducto = new JScrollPane();
        this.JTProducto = new JTable();
        this.JSPEmpresa = new JScrollPane();
        this.JTEmpresa = new JTable();
        this.JPInformacion = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBBodega = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE DESPACHOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformesdespachopaciente");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JTPTablas.setForeground(Color.red);
        this.JTPTablas.setFont(new Font("Arial", 1, 14));
        this.JTPaciente.setFont(new Font("Arial", 1, 12));
        this.JTPaciente.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPaciente.setSelectionBackground(Color.white);
        this.JTPaciente.setSelectionForeground(Color.red);
        this.JSPPaciente.setViewportView(this.JTPaciente);
        this.JTPTablas.addTab("PACIENTE", this.JSPPaciente);
        this.JTAuditoria.setFont(new Font("Arial", 1, 12));
        this.JTAuditoria.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAuditoria.setSelectionBackground(Color.white);
        this.JTAuditoria.setSelectionForeground(Color.red);
        this.JSPAuditoria.setViewportView(this.JTAuditoria);
        this.JTPTablas.addTab("AUDITORIA", this.JSPAuditoria);
        this.JTProducto.setFont(new Font("Arial", 1, 12));
        this.JTProducto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTProducto.setSelectionBackground(Color.white);
        this.JTProducto.setSelectionForeground(Color.red);
        this.JSProducto.setViewportView(this.JTProducto);
        this.JTPTablas.addTab("PRODUCTO", this.JSProducto);
        this.JTEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTEmpresa.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTEmpresa.setSelectionBackground(Color.white);
        this.JTEmpresa.setSelectionForeground(Color.red);
        this.JSPEmpresa.setViewportView(this.JTEmpresa);
        this.JTPTablas.addTab("EMPRESA", this.JSPEmpresa);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBBodega, 0, -1, 32767).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2)).addComponent(this.JCBBodega, -2, 50, -2)).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformesDespachoPaciente.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.imagenesdx.JIFInformesDespachoPaciente.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformesDespachoPaciente.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPInformacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 151, -2)).addComponent(this.JTPTablas, -1, 762, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPTablas, -2, 331, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addGap(10, 10, 10)));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            switch (this.JTPTablas.getSelectedIndex()) {
                case 0:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTPaciente, this.JTFRuta.getText(), getTitle() + " POR: " + this.JTPTablas.getTitleAt(0));
                    break;
                case 1:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTAuditoria, this.JTFRuta.getText(), getTitle() + " PARA: " + this.JTPTablas.getTitleAt(1));
                    break;
                case 2:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTProducto, this.JTFRuta.getText(), getTitle() + " POR: " + this.JTPTablas.getTitleAt(2));
                    break;
                case 3:
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTEmpresa, this.JTFRuta.getText(), getTitle() + " POR: " + this.JTPTablas.getTitleAt(3));
                    break;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }
}
