package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ValidacionDetalleDTO;
import com.genoma.plus.jpa.entities.ValidacionEmpresaConvenioDTO;
import com.genoma.plus.jpa.entities.ValidacionEncabezadoDTO;
import com.genoma.plus.jpa.projection.GenericCombo;
import com.genoma.plus.jpa.projection.IHistoricoValidacionEncabezado;
import com.genoma.plus.jpa.service.IValidacionDetalleService;
import com.genoma.plus.jpa.service.IValidacionEmpresaConvenioService;
import com.genoma.plus.jpa.service.IValidacionEncabezadoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIF_CargarBaseEntidades.class */
public class JIF_CargarBaseEntidades extends JInternalFrame {
    private final Metodos metodos;
    private List<GenericCombo> listaEmpresas;
    private List<GenericCombo> listaConvenio;
    private DefaultTableModel modelo;
    private DefaultTableModel modeloConvenio;
    private DefaultTableModel modeloHistorico;
    private List<ValidacionDetalleDTO> validacionDetalleDTOs;
    private final List<ValidacionEmpresaConvenioDTO> validacionEmpresaConvenioDTOs;
    private Object[] dato;
    private JButton JBTCarguesA;
    private JComboBox<String> JCBEmpresa;
    private JCheckBox JCH_FiltroEmpresa;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_NCargue;
    private JPanel JPI_DatosEncabezado;
    private JPanel JPI_Historico;
    private JPanel JPI_Importacion;
    private JPanel JPI_Periodo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSP_Convenios;
    private JScrollPane JSP_Historico;
    private JTable JTBDetalle;
    private JTable JTB_Convenios;
    private JTable JTB_Historico;
    private JTabbedPane JTP_Datos;
    private JTabbedPane JTP_Detalle;
    private final JFileChooser FileChooser = new JFileChooser();
    private final IValidacionEncabezadoService validacionEncabezadoService = (IValidacionEncabezadoService) Principal.contexto.getBean(IValidacionEncabezadoService.class);
    private final IValidacionDetalleService validacionDetalleService = (IValidacionDetalleService) Principal.contexto.getBean(IValidacionDetalleService.class);
    private final IValidacionEmpresaConvenioService validacionEmpresaConvenioService = (IValidacionEmpresaConvenioService) Principal.contexto.getBean(IValidacionEmpresaConvenioService.class);
    private boolean lleno = false;

    public JIF_CargarBaseEntidades() {
        initComponents();
        this.metodos = new Metodos();
        this.validacionDetalleDTOs = new ArrayList();
        this.validacionEmpresaConvenioDTOs = new ArrayList();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v75, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Importacion = new JPanel();
        this.JPI_DatosEncabezado = new JPanel();
        this.JCBEmpresa = new JComboBox<>();
        this.JPI_Periodo = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JBTCarguesA = new JButton();
        this.JLB_NCargue = new JLabel();
        this.JTP_Detalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JSP_Convenios = new JScrollPane();
        this.JTB_Convenios = new JTable();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        this.JCH_FiltroEmpresa = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGUE INFORMACIÓN DE USUARIOS PARA VALIDACIÓN DE DERECHO");
        setFont(new Font("Arial", 0, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifCargueInformacionEntidades");
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_DatosEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN ENCABEZADO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_CargarBaseEntidades.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JPI_Periodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período de vigencia", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_PeriodoLayout = new GroupLayout(this.JPI_Periodo);
        this.JPI_Periodo.setLayout(JPI_PeriodoLayout);
        JPI_PeriodoLayout.setHorizontalGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 125, -2).addContainerGap(-1, 32767)));
        JPI_PeriodoLayout.setVerticalGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PeriodoLayout.createSequentialGroup().addGroup(JPI_PeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addGap(0, 9, 32767)));
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBTCarguesA.setText("Importar Archivo");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.2
            public void actionPerformed(ActionEvent evt) {
                JIF_CargarBaseEntidades.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JLB_NCargue.setFont(new Font("Arial", 1, 14));
        this.JLB_NCargue.setHorizontalAlignment(0);
        this.JLB_NCargue.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPI_DatosEncabezadoLayout = new GroupLayout(this.JPI_DatosEncabezado);
        this.JPI_DatosEncabezado.setLayout(JPI_DatosEncabezadoLayout);
        JPI_DatosEncabezadoLayout.setHorizontalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JCBEmpresa, -2, 439, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Periodo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCarguesA, -1, -1, 32767).addGap(38, 38, 38).addComponent(this.JLB_NCargue, -2, 123, -2).addContainerGap()));
        JPI_DatosEncabezadoLayout.setVerticalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Periodo, -1, -1, 32767).addComponent(this.JCBEmpresa, -2, 50, -2).addComponent(this.JBTCarguesA, -1, -1, 32767).addComponent(this.JLB_NCargue, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JTP_Detalle.setForeground(Color.red);
        this.JTP_Detalle.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTP_Detalle.addTab("DETALLE USUARIOS", this.JSPDetalle);
        this.JSP_Convenios.setBorder((Border) null);
        this.JSP_Convenios.setFont(new Font("Arial", 1, 12));
        this.JSP_Convenios.setPreferredSize(new Dimension(1330, 426));
        this.JTB_Convenios.setFont(new Font("Arial", 1, 12));
        this.JTB_Convenios.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Convenios.setAutoResizeMode(0);
        this.JTB_Convenios.setSelectionMode(0);
        this.JSP_Convenios.setViewportView(this.JTB_Convenios);
        this.JTP_Detalle.addTab("CONVENIOS", this.JSP_Convenios);
        GroupLayout JPI_ImportacionLayout = new GroupLayout(this.JPI_Importacion);
        this.JPI_Importacion.setLayout(JPI_ImportacionLayout);
        JPI_ImportacionLayout.setHorizontalGroup(JPI_ImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ImportacionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosEncabezado, -1, -1, 32767).addComponent(this.JTP_Detalle, -2, 0, 32767)).addContainerGap()));
        JPI_ImportacionLayout.setVerticalGroup(JPI_ImportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ImportacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Detalle, -1, 516, 32767)));
        this.JTP_Datos.addTab("IMPORTACIÓN", this.JPI_Importacion);
        this.JSP_Historico.setBorder((Border) null);
        this.JSP_Historico.setFont(new Font("Arial", 1, 12));
        this.JSP_Historico.setPreferredSize(new Dimension(1330, 426));
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setAutoResizeMode(0);
        this.JTB_Historico.setSelectionMode(0);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.3
            public void mouseClicked(MouseEvent evt) {
                JIF_CargarBaseEntidades.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        this.JCH_FiltroEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroEmpresa.setText("Filtro por empresa");
        this.JCH_FiltroEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.4
            public void actionPerformed(ActionEvent evt) {
                JIF_CargarBaseEntidades.this.JCH_FiltroEmpresaActionPerformed(evt);
            }
        });
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCH_FiltroEmpresa).addContainerGap(937, 32767)).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(21, 32767).addComponent(this.JSP_Historico, -2, 1051, -2).addContainerGap(22, 32767))));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCH_FiltroEmpresa).addContainerGap(602, 32767)).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(66, 66, 66).addComponent(this.JSP_Historico, -2, 563, -2).addContainerGap(17, 32767))));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        if (!file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        try {
            cargarDatosTabla(file);
        } catch (IOException ex) {
            Logger.getLogger(JIF_CargarBaseEntidades.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.lleno && this.JCBEmpresa.getSelectedIndex() >= 0) {
            this.listaConvenio = this.validacionEncabezadoService.listaConvenio(this.listaEmpresas.get(this.JCBEmpresa.getSelectedIndex()).getId());
            System.out.println("Despues");
            crearModeloDatosConvenio();
            this.listaConvenio.forEach(next -> {
                this.modeloConvenio.addRow(this.dato);
                this.modeloConvenio.setValueAt(next.getId(), this.JTB_Convenios.getRowCount() - 1, 0);
                this.modeloConvenio.setValueAt(next.getNombre(), this.JTB_Convenios.getRowCount() - 1, 1);
                this.modeloConvenio.setValueAt(false, this.JTB_Convenios.getRowCount() - 1, 2);
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroEmpresaActionPerformed(ActionEvent evt) {
        if (this.JCH_FiltroEmpresa.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                cargarDatosHistoricos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTP_Datos.setSelectedIndex(0);
                return;
            }
        }
        cargarDatosHistoricos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTB_Historico.getSelectedColumn() != 0) {
                if (this.JTB_Historico.getSelectedColumn() == 6) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar estado", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        ValidacionEncabezadoDTO e = this.validacionEncabezadoService.consultarValidacionDetalleId(Integer.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()));
                        e.setEstado(Boolean.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 6).toString()));
                        this.validacionEncabezadoService.crear(e);
                        return;
                    }
                    return;
                }
                return;
            }
            this.JLB_NCargue.setText("" + this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            this.JCBEmpresa.setSelectedItem(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 1));
            this.JDFechaI.setDate(this.metodos.getPasarTextoaFecha(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 2).toString()));
            this.JDFechaF.setDate(this.metodos.getPasarTextoaFecha(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 3).toString()));
            this.validacionDetalleDTOs = this.validacionDetalleService.listaValidacionDetalle(Integer.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()));
            cargarDetalleCargue();
            List<ValidacionEmpresaConvenioDTO> convenioDTOs = this.validacionEmpresaConvenioService.listaFiltroIdValidacion(Integer.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()));
            convenioDTOs.forEach(next -> {
                for (int x2 = 0; x2 < this.JTB_Convenios.getRowCount(); x2++) {
                    if (Objects.equals(Long.valueOf(this.JTB_Convenios.getValueAt(x2, 0).toString()), next.getId())) {
                        this.modeloConvenio.setValueAt(true, x2, 2);
                    }
                }
            });
            this.JTP_Datos.setSelectedIndex(0);
            this.JTP_Detalle.setSelectedIndex(0);
        }
    }

    public void cargarDatosTabla(File file) throws IOException {
        crearModeloDatos();
        this.validacionDetalleDTOs = new ArrayList();
        try {
            System.out.println("" + file.getAbsolutePath());
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            for (int j = 1; j < sheet.getRows(); j++) {
                ValidacionDetalleDTO detalleDTO = new ValidacionDetalleDTO();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell = sheet.getCell(i, j);
                    switch (i) {
                        case 0:
                            detalleDTO.setTipoDocumento(cell.getContents());
                            break;
                        case 1:
                            detalleDTO.setNumeroDocumento(cell.getContents());
                            break;
                        case 2:
                            detalleDTO.setApellido1(cell.getContents());
                            break;
                        case 3:
                            detalleDTO.setApellido2(cell.getContents());
                            break;
                        case 4:
                            detalleDTO.setNombre1(cell.getContents());
                            break;
                        case 5:
                            detalleDTO.setNombre2(cell.getContents());
                            break;
                        case 6:
                            detalleDTO.setFechaNacimiento(cell.getContents());
                            break;
                        case 7:
                            detalleDTO.setSexo(cell.getContents());
                            break;
                        case 8:
                            detalleDTO.setDireccion(cell.getContents());
                            break;
                        case 9:
                            detalleDTO.setTelefono(cell.getContents());
                            break;
                    }
                }
                this.validacionDetalleDTOs.add(detalleDTO);
            }
            cargarDetalleCargue();
        } catch (BiffException e) {
        }
    }

    private void cargarDetalleCargue() {
        this.validacionDetalleDTOs.stream().map(validacionDetalleDTO -> {
            this.modelo.addRow(this.dato);
            return validacionDetalleDTO;
        }).forEachOrdered(validacionDetalleDTO2 -> {
            int nfila = this.JTBDetalle.getRowCount() - 1;
            this.modelo.setValueAt(validacionDetalleDTO2.getTipoDocumento(), nfila, 0);
            this.modelo.setValueAt(validacionDetalleDTO2.getNumeroDocumento(), nfila, 1);
            this.modelo.setValueAt(validacionDetalleDTO2.getApellido1(), nfila, 2);
            this.modelo.setValueAt(validacionDetalleDTO2.getApellido2(), nfila, 3);
            this.modelo.setValueAt(validacionDetalleDTO2.getNombre1(), nfila, 4);
            this.modelo.setValueAt(validacionDetalleDTO2.getNombre2(), nfila, 5);
            this.modelo.setValueAt(validacionDetalleDTO2.getFechaNacimiento(), nfila, 6);
            this.modelo.setValueAt(validacionDetalleDTO2.getSexo(), nfila, 7);
            this.modelo.setValueAt(validacionDetalleDTO2.getDireccion(), nfila, 8);
            this.modelo.setValueAt(validacionDetalleDTO2.getTelefono(), nfila, 9);
        });
    }

    public void nuevo() {
        this.lleno = false;
        this.JLB_NCargue.setText("");
        this.listaConvenio = new ArrayList();
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        llenarCombo();
        crearModeloDatos();
        crearModeloDatosConvenio();
        cargarDatosHistoricos();
        this.lleno = true;
    }

    private void llenarCombo() {
        this.JCBEmpresa.removeAllItems();
        this.listaEmpresas = this.validacionEncabezadoService.listaEmpresasConvenio();
        this.listaEmpresas.forEach(next -> {
            this.JCBEmpresa.addItem(next.getNombre());
        });
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"TipoDoc", "Documento", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "Fecha Nacimiento", "Sexo", "Direccion", "Telefono"}) { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    private void crearModeloDatosConvenio() {
        this.modeloConvenio = new DefaultTableModel((Object[][]) null, new String[]{"id", "Nombre Convenio", "agregar?"}) { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.6
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Convenios.setModel(this.modeloConvenio);
        JTable jTable = this.JTB_Convenios;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTB_Convenios.doLayout();
        this.JTB_Convenios.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Convenios.getColumnModel().getColumn(1).setPreferredWidth(800);
        this.JTB_Convenios.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void crearModeloDatosHistorico() {
        this.modeloHistorico = new DefaultTableModel((Object[][]) null, new String[]{"id", "Empresa", "Fecha Inicio", "Fecha Fin", "Realizador del Cargue ", "Fecha Cargue", "Estado"}) { // from class: com.genoma.plus.controller.general.JIF_CargarBaseEntidades.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.modeloHistorico);
        JTable jTable = this.JTB_Historico;
        JTable jTable2 = this.JTB_Historico;
        jTable.setAutoResizeMode(0);
        this.JTB_Historico.doLayout();
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarDatosHistoricos() {
        List<IHistoricoValidacionEncabezado> lista;
        crearModeloDatosHistorico();
        if (this.JCH_FiltroEmpresa.isSelected()) {
            lista = this.validacionEncabezadoService.listarHistoricoEncabezadoFiltradoPorEmpresa(this.listaEmpresas.get(this.JCBEmpresa.getSelectedIndex()).getId());
        } else {
            lista = this.validacionEncabezadoService.listarHistoricoEncabezado();
        }
        lista.forEach(next -> {
            this.modeloHistorico.addRow(this.dato);
            int nfila = this.JTB_Historico.getRowCount() - 1;
            this.modeloHistorico.setValueAt(next.getId(), nfila, 0);
            this.modeloHistorico.setValueAt(next.getNombreEmpresa(), nfila, 1);
            this.modeloHistorico.setValueAt(next.getFechaInicio(), nfila, 2);
            this.modeloHistorico.setValueAt(next.getFechaFin(), nfila, 3);
            this.modeloHistorico.setValueAt(next.getUsuarioCargue(), nfila, 4);
            this.modeloHistorico.setValueAt(next.getFechaCargue(), nfila, 5);
            this.modeloHistorico.setValueAt(next.getEstado(), nfila, 6);
        });
    }

    public void grabar() {
        if (this.JLB_NCargue.getText().isEmpty()) {
            if (this.metodos.mVerificarDatosTablaTrue(this.JTB_Convenios, 2)) {
                if (this.JTBDetalle.getRowCount() >= 1) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        ValidacionEncabezadoDTO e = new ValidacionEncabezadoDTO();
                        e.setIdEmpresa(this.listaEmpresas.get(this.JCBEmpresa.getSelectedIndex()).getId());
                        e.setFechaInicio(this.JDFechaI.getDate());
                        e.setFechaFin(this.JDFechaF.getDate());
                        e.setEstado(true);
                        e.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        Integer idValidacion = this.validacionEncabezadoService.crear(e);
                        this.validacionDetalleDTOs.forEach(next -> {
                            next.setIdValidacion(idValidacion);
                        });
                        this.validacionDetalleService.crear(this.validacionDetalleDTOs);
                        for (int x = 0; x < this.JTB_Convenios.getRowCount(); x++) {
                            if (Boolean.valueOf(this.modeloConvenio.getValueAt(x, 2).toString()).booleanValue()) {
                                ValidacionEmpresaConvenioDTO c = new ValidacionEmpresaConvenioDTO();
                                c.setIdValidacion(idValidacion);
                                c.setIdEmpresaConvenio(Long.valueOf(this.JTB_Convenios.getValueAt(x, 0).toString()));
                                c.setEstado(true);
                                c.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                this.validacionEmpresaConvenioDTOs.add(c);
                            }
                        }
                        this.validacionEmpresaConvenioService.crear(this.validacionEmpresaConvenioDTOs);
                        this.JLB_NCargue.setText("" + idValidacion);
                    }
                    cargarDatosHistoricos();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe carga información de la empresa", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un convenio", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTP_Detalle.setSelectedIndex(1);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Cargue ya grabado", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }
}
