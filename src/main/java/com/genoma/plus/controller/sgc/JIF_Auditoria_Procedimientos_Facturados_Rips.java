package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JDCambioDatosIngresoLiquidacion;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.GContratos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.SubgruposervicioEntity;
import com.genoma.plus.jpa.projection.AuditoriaProcedimientosFacturadosRips;
import com.genoma.plus.jpa.projection.IGenericComboTresValores;
import com.genoma.plus.jpa.service.AuditoriaProcedimientosFacturadosRipsService;
import com.genoma.plus.jpa.service.IGContratosService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Auditoria_Procedimientos_Facturados_Rips.class */
public class JIF_Auditoria_Procedimientos_Facturados_Rips extends JInternalFrame {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private List<Integer> idEstado;
    private List<IGenericComboTresValores> listConvenio;
    private List<Integer> idConvenio;
    private GContratos gContratos;
    private ButtonGroup JBGFiltroEstado;
    private JButton JBTExportar;
    private JButton JBTRegistrarSeguimiento;
    private JComboBox JCBConvenio;
    private JCheckBox JCH_Filtro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JPanel JPIFiltroEstado;
    private JRadioButton JRBArmada;
    private JRadioButton JRBPorArmar;
    private JRadioButton JRBPresentada;
    private JRadioButton JRBTodas;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private final AuditoriaProcedimientosFacturadosRipsService xService = (AuditoriaProcedimientosFacturadosRipsService) Principal.contexto.getBean(AuditoriaProcedimientosFacturadosRipsService.class);
    private GEmpresa gEmpresa = new GEmpresa();
    private EmpresaContConvenioEntity empresaContConvenioEntity = new EmpresaContConvenioEntity();
    private List<GContratos> listGContratos = new ArrayList();
    private final IGContratosService iGContratosService = (IGContratosService) Principal.contexto.getBean(IGContratosService.class);
    private SubgruposervicioEntity subgruposervicioEntity = new SubgruposervicioEntity();

    public JIF_Auditoria_Procedimientos_Facturados_Rips() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JRBTodas.setSelected(true);
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.idEstado = new ArrayList();
        this.idEstado.add(0);
        this.idEstado.add(1);
        this.idEstado.add(2);
        this.JLBLCont.setText("0");
    }

    private void mCrearModeloAuditoria_Procedimientos() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Seleccionar", "IdIngreso", "No_FacturaCapita", "FechaIngreso", "NoDocumento", "NombreUsuario", "FechaNacimiento", "Edad", "Sexo", "Convenio", "CausaExterna", "IdItmemProcedimiento", "Id_Procedimiento", "NombrProcedimiento", "Cantidad", "Id_TipofinProc", "NombreFinProcedimiento", "DxIngreso", "Id", "Fecha_FacturaCapita", "SubgrupoFactura", "EstaArmada", "No_FacturaEvento", "Id_DxPrincipal", "Id_TipoDx", "DxRelacional1", "DxRelacional2", "DxRelacional3", "FiltroAplicaDx", "Servicio", "IdConvenio", "Programa PyM", "idEmpresa", "Usuario_Sistemas", "Id Persona", "TipoRecaudo", "valorCuotaCop", "Valor"}) { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.1
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
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
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(34).setPreferredWidth(80);
        if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
            this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(100);
            this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(100);
            this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(100);
            return;
        }
        this.JTDetalle.getColumnModel().getColumn(35).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(35).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(36).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(37).setMaxWidth(0);
    }

    private void mCargarDatosTablaAuditoria_Procedimientos() {
        mCrearModeloAuditoria_Procedimientos();
        List<AuditoriaProcedimientosFacturadosRips> list = this.xService.ContultarAuditoriaProcedimientos(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), this.idEstado, this.idConvenio);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(false, x, 0);
            this.xModelo.setValueAt(list.get(x).getIdIngreso(), x, 1);
            this.xModelo.setValueAt(list.get(x).getNo_FacturaCapita(), x, 2);
            this.xModelo.setValueAt(list.get(x).getFechaIngreso(), x, 3);
            this.xModelo.setValueAt(list.get(x).getNoDocumento(), x, 4);
            this.xModelo.setValueAt(list.get(x).getNombreUsuario(), x, 5);
            this.xModelo.setValueAt(list.get(x).getFechaNacimiento(), x, 6);
            this.xModelo.setValueAt(list.get(x).getEdad(), x, 7);
            this.xModelo.setValueAt(list.get(x).getSexo(), x, 8);
            this.xModelo.setValueAt(list.get(x).getConvenio(), x, 9);
            this.xModelo.setValueAt(list.get(x).getCausaExterna(), x, 10);
            this.xModelo.setValueAt(list.get(x).getIdItmemProcedimiento(), x, 11);
            this.xModelo.setValueAt(list.get(x).getId_Procedimiento(), x, 12);
            this.xModelo.setValueAt(list.get(x).getNombrProcedimiento(), x, 13);
            this.xModelo.setValueAt(list.get(x).getCantidad(), x, 14);
            this.xModelo.setValueAt(list.get(x).getId_TipofinProc(), x, 15);
            this.xModelo.setValueAt(list.get(x).getNombreFinProcedimiento(), x, 16);
            this.xModelo.setValueAt(list.get(x).getDxIngreso(), x, 17);
            this.xModelo.setValueAt(list.get(x).getIdLiquidacion(), x, 18);
            this.xModelo.setValueAt(list.get(x).getFecha_FacturaCapita(), x, 19);
            this.xModelo.setValueAt(list.get(x).getSubgrupoFactura(), x, 20);
            this.xModelo.setValueAt(list.get(x).getEstaArmada(), x, 21);
            this.xModelo.setValueAt(list.get(x).getNo_FacturaEvento(), x, 22);
            this.xModelo.setValueAt(list.get(x).getId_DxPrincipal(), x, 23);
            this.xModelo.setValueAt(list.get(x).getId_TipoDx(), x, 24);
            this.xModelo.setValueAt(list.get(x).getDxRelacional1(), x, 25);
            this.xModelo.setValueAt(list.get(x).getDxRelacional2(), x, 26);
            this.xModelo.setValueAt(list.get(x).getDxRelacional3(), x, 27);
            this.xModelo.setValueAt(list.get(x).getFiltroAplicaDx(), x, 28);
            this.xModelo.setValueAt(list.get(x).getTipoServicio(), x, 29);
            this.xModelo.setValueAt(list.get(x).getIdConvenio(), x, 30);
            this.xModelo.setValueAt(list.get(x).getProgramas(), x, 31);
            this.xModelo.setValueAt(list.get(x).getIdEmpresa(), x, 32);
            this.xModelo.setValueAt(list.get(x).getUsuarioSistema(), x, 33);
            this.xModelo.setValueAt(list.get(x).getIdPersona(), x, 34);
            this.xModelo.setValueAt(list.get(x).getTipoRecaudo(), x, 35);
            this.xModelo.setValueAt(list.get(x).getvalorCuotaCop(), x, 36);
            this.xModelo.setValueAt(list.get(x).getValor(), x, 37);
        }
        this.JLBLCont.setText(list.size() + "");
    }

    private Boolean verificarEstadoArmado() {
        Boolean estado = false;
        int i = 0;
        while (true) {
            if (i < this.JTDetalle.getRowCount()) {
                if (!Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue() || Integer.valueOf(this.JTDetalle.getValueAt(i, 21).toString()).intValue() != 2) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            } else {
                break;
            }
        }
        return estado;
    }

    public void mBuscar() {
        this.idConvenio = new ArrayList();
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCBConvenio.getSelectedIndex() != -1) {
                this.idConvenio.add(this.listConvenio.get(this.JCBConvenio.getSelectedIndex()).getId());
                mCargarDatosTablaAuditoria_Procedimientos();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un convenio", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                this.JCBConvenio.requestFocus();
                return;
            }
        }
        this.listConvenio.forEach(item -> {
            this.idConvenio.add(item.getId());
        });
        mCargarDatosTablaAuditoria_Procedimientos();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltroEstado = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIFiltroEstado = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBPorArmar = new JRadioButton();
        this.JRBArmada = new JRadioButton();
        this.JRBPresentada = new JRadioButton();
        this.JLBLCont = new JLabel();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JCBConvenio = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("Auditoria de Procedimientos Facturados Rips");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_AuditoriaProcedimientosFacRips");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(12, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addContainerGap(7, 32767)));
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
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.4
            public void mouseClicked(MouseEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 467, -2).addGap(0, 0, 0).addComponent(this.JBTExportar, -2, 145, -2).addContainerGap(-1, 32767)));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 48, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addContainerGap(-1, 32767)));
        this.JPIFiltroEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Estado (Factura/Orden)", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGFiltroEstado.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todos");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltroEstado.add(this.JRBPorArmar);
        this.JRBPorArmar.setFont(new Font("Arial", 1, 12));
        this.JRBPorArmar.setText("Por Armar");
        this.JRBPorArmar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JRBPorArmarActionPerformed(evt);
            }
        });
        this.JBGFiltroEstado.add(this.JRBArmada);
        this.JRBArmada.setFont(new Font("Arial", 1, 12));
        this.JRBArmada.setText("Armada");
        this.JRBArmada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JRBArmadaActionPerformed(evt);
            }
        });
        this.JBGFiltroEstado.add(this.JRBPresentada);
        this.JRBPresentada.setFont(new Font("Arial", 1, 12));
        this.JRBPresentada.setText("Presentada");
        this.JRBPresentada.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JRBPresentadaActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroEstadoLayout = new GroupLayout(this.JPIFiltroEstado);
        this.JPIFiltroEstado.setLayout(JPIFiltroEstadoLayout);
        JPIFiltroEstadoLayout.setHorizontalGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorArmar)).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addComponent(this.JRBArmada).addGap(18, 18, 18).addComponent(this.JRBPresentada))).addContainerGap(16, 32767)));
        JPIFiltroEstadoLayout.setVerticalGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBPorArmar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIFiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBArmada).addComponent(this.JRBPresentada))));
        this.JLBLCont.setFont(new Font("Arial", 1, 18));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        this.JLBLCont.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Actualización Datos(Convenio y subgrupo)");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.10
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIF_Auditoria_Procedimientos_Facturados_Rips.11
            public void actionPerformed(ActionEvent evt) {
                JIF_Auditoria_Procedimientos_Facturados_Rips.this.JCBConvenioActionPerformed(evt);
            }
        });
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, -2, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 306, -2).addGap(18, 18, 18).addComponent(this.JPIFiltroEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBConvenio, -2, 399, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBLCont, -2, 137, -2))).addGroup(layout.createSequentialGroup().addComponent(this.JPExportar, -2, -1, -2).addGap(81, 81, 81).addComponent(this.JBTRegistrarSeguimiento, -2, 365, -2))).addGap(0, 6, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPDatos, -2, 87, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBLCont, -2, 60, -2).addComponent(this.JCBConvenio, -2, -1, -2)).addComponent(this.JPIFiltroEstado, -2, -1, -2))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Filtro))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 391, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPExportar, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JBTRegistrarSeguimiento, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
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
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.idEstado = new ArrayList();
        this.idEstado.add(0);
        this.idEstado.add(1);
        this.idEstado.add(2);
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorArmarActionPerformed(ActionEvent evt) {
        this.idEstado = new ArrayList();
        this.idEstado.add(0);
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBArmadaActionPerformed(ActionEvent evt) {
        this.idEstado = new ArrayList();
        this.idEstado.add(1);
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPresentadaActionPerformed(ActionEvent evt) {
        this.idEstado = new ArrayList();
        this.idEstado.add(2);
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() >= 1) {
            if (!verificarEstadoArmado().booleanValue()) {
                EmpresaContConvenioEntity idEmpresaCont = this.empresaContConvenioEntity;
                GEmpresa idEmpresa = this.gEmpresa;
                List<Long> idIngreso = new ArrayList<>();
                List<Long> idLiquidacion = new ArrayList<>();
                String empresaId = "";
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                        idIngreso.add(Long.valueOf(this.JTDetalle.getValueAt(i, 1).toString()));
                        idLiquidacion.add(Long.valueOf(this.JTDetalle.getValueAt(i, 18).toString()));
                        empresaId = this.JTDetalle.getValueAt(i, 32).toString();
                        System.out.println("empresa id -> " + empresaId);
                        idEmpresa.setId(Long.valueOf(empresaId));
                        idEmpresaCont.setId(Integer.valueOf(Integer.parseInt(empresaId)));
                    }
                }
                System.out.println("id empresa -> " + idEmpresa);
                idEmpresaCont.setId(Integer.valueOf(Integer.parseInt(empresaId)));
                System.out.println(" idEmpresaCont.getId() -> " + idEmpresaCont.getId());
                System.out.println("id empresa cont -> " + idEmpresaCont);
                JDCambioDatosIngresoLiquidacion cambioDatosIngresoLiquidacion = new JDCambioDatosIngresoLiquidacion(null, true, idEmpresa, idIngreso, idLiquidacion, idEmpresaCont);
                cambioDatosIngresoLiquidacion.setLocationRelativeTo(this);
                cambioDatosIngresoLiquidacion.setVisible(true);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Has seleccionado uno o varios items ya presentados;\nFavo revisar!!", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        llenarComboConvenio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        llenarComboConvenio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioActionPerformed(ActionEvent evt) {
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

    private void llenarComboConvenio() {
        this.JCBConvenio.removeAllItems();
        this.listConvenio = new ArrayList();
        this.listConvenio = this.xService.ConvenioAuditoriaProcedimientos(this.JDFechaI.getDate(), this.JDFechaF.getDate());
        if (!this.listConvenio.isEmpty()) {
            this.listConvenio.forEach(item -> {
                this.JCBConvenio.addItem(item.getNombre());
            });
            if (this.listConvenio.size() > 0) {
                this.JCBConvenio.setSelectedIndex(-1);
            }
        }
    }
}
