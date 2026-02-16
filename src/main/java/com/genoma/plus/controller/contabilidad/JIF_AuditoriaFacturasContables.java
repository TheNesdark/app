package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.ConvertirBytesArrayAArchivo;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IDetalleUsuarioFirmaDocumentosContables;
import com.genoma.plus.jpa.service.IRadicacionDetalleAuditoriaDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIF_AuditoriaFacturasContables.class */
public class JIF_AuditoriaFacturasContables extends JInternalFrame {
    private DefaultTableModel modelo;
    private ConvertirBytesArrayAArchivo convertirBytesArrayAArchivo;
    private JButton JBExportar;
    private ButtonGroup JBG_Filtro;
    private JPanel JPI_DatosFiltro;
    private JPanel JPI_FiltroEstado;
    private JRadioButton JRB_Auditadas;
    private JRadioButton JRB_PorAuditar;
    private JRadioButton JRB_Todas;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextField JTF_BusquedaNombre;
    private JScrollPane jScrollPane1;
    private Metodos metodos = new Metodos();
    private final IRadicacionDetalleAuditoriaDAO documentoDetalleAuditoriaDAO = (IRadicacionDetalleAuditoriaDAO) Principal.contexto.getBean(IRadicacionDetalleAuditoriaDAO.class);
    private String estado = "TODAS";
    private String ruta = this.metodos.getDirectorioExportacion();

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    @Generated
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Generated
    public void setConvertirBytesArrayAArchivo(ConvertirBytesArrayAArchivo convertirBytesArrayAArchivo) {
        this.convertirBytesArrayAArchivo = convertirBytesArrayAArchivo;
    }

    @Generated
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Generated
    public void setJBExportar(JButton JBExportar) {
        this.JBExportar = JBExportar;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJPI_DatosFiltro(JPanel JPI_DatosFiltro) {
        this.JPI_DatosFiltro = JPI_DatosFiltro;
    }

    @Generated
    public void setJPI_FiltroEstado(JPanel JPI_FiltroEstado) {
        this.JPI_FiltroEstado = JPI_FiltroEstado;
    }

    @Generated
    public void setJRB_Auditadas(JRadioButton JRB_Auditadas) {
        this.JRB_Auditadas = JRB_Auditadas;
    }

    @Generated
    public void setJRB_PorAuditar(JRadioButton JRB_PorAuditar) {
        this.JRB_PorAuditar = JRB_PorAuditar;
    }

    @Generated
    public void setJRB_Todas(JRadioButton JRB_Todas) {
        this.JRB_Todas = JRB_Todas;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJTF_BusquedaNombre(JTextField JTF_BusquedaNombre) {
        this.JTF_BusquedaNombre = JTF_BusquedaNombre;
    }

    @Generated
    public void setJScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    @Generated
    public IRadicacionDetalleAuditoriaDAO getDocumentoDetalleAuditoriaDAO() {
        return this.documentoDetalleAuditoriaDAO;
    }

    @Generated
    public String getEstado() {
        return this.estado;
    }

    @Generated
    public ConvertirBytesArrayAArchivo getConvertirBytesArrayAArchivo() {
        return this.convertirBytesArrayAArchivo;
    }

    @Generated
    public String getRuta() {
        return this.ruta;
    }

    public JIF_AuditoriaFacturasContables(String titulo) {
        initComponents();
        setTitle(titulo);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_DatosFiltro = new JPanel();
        this.JPI_FiltroEstado = new JPanel();
        this.JRB_Todas = new JRadioButton();
        this.JRB_PorAuditar = new JRadioButton();
        this.JRB_Auditadas = new JRadioButton();
        this.JTF_BusquedaNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPI_DatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPI_FiltroEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRB_Todas.setBackground(new Color(255, 255, 255));
        this.JBG_Filtro.add(this.JRB_Todas);
        this.JRB_Todas.setFont(new Font("Arial", 1, 12));
        this.JRB_Todas.setSelected(true);
        this.JRB_Todas.setText("Todas");
        this.JRB_Todas.setOpaque(true);
        this.JRB_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.1
            public void actionPerformed(ActionEvent evt) {
                JIF_AuditoriaFacturasContables.this.JRB_TodasActionPerformed(evt);
            }
        });
        this.JRB_PorAuditar.setBackground(Color.red);
        this.JBG_Filtro.add(this.JRB_PorAuditar);
        this.JRB_PorAuditar.setFont(new Font("Arial", 1, 12));
        this.JRB_PorAuditar.setForeground(new Color(255, 255, 255));
        this.JRB_PorAuditar.setText("Por Auditar");
        this.JRB_PorAuditar.setOpaque(true);
        this.JRB_PorAuditar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.2
            public void actionPerformed(ActionEvent evt) {
                JIF_AuditoriaFacturasContables.this.JRB_PorAuditarActionPerformed(evt);
            }
        });
        this.JRB_Auditadas.setBackground(new Color(0, 103, 0));
        this.JBG_Filtro.add(this.JRB_Auditadas);
        this.JRB_Auditadas.setFont(new Font("Arial", 1, 12));
        this.JRB_Auditadas.setForeground(new Color(255, 255, 255));
        this.JRB_Auditadas.setText("Auditadas");
        this.JRB_Auditadas.setOpaque(true);
        this.JRB_Auditadas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.3
            public void actionPerformed(ActionEvent evt) {
                JIF_AuditoriaFacturasContables.this.JRB_AuditadasActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroEstadoLayout = new GroupLayout(this.JPI_FiltroEstado);
        this.JPI_FiltroEstado.setLayout(JPI_FiltroEstadoLayout);
        JPI_FiltroEstadoLayout.setHorizontalGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_PorAuditar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_Auditadas).addContainerGap(-1, 32767)));
        JPI_FiltroEstadoLayout.setVerticalGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todas).addComponent(this.JRB_PorAuditar).addComponent(this.JRB_Auditadas)).addContainerGap(-1, 32767)));
        this.JTF_BusquedaNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_BusquedaNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda por nombre/documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DatosFiltroLayout = new GroupLayout(this.JPI_DatosFiltro);
        this.JPI_DatosFiltro.setLayout(JPI_DatosFiltroLayout);
        JPI_DatosFiltroLayout.setHorizontalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroEstado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTF_BusquedaNombre, -2, 470, -2).addContainerGap(283, 32767)));
        JPI_DatosFiltroLayout.setVerticalGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_BusquedaNombre, -2, 50, -2).addComponent(this.JPI_FiltroEstado, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.4
            public void mouseClicked(MouseEvent evt) {
                JIF_AuditoriaFacturasContables.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.5
            public void mouseClicked(MouseEvent evt) {
                JIF_AuditoriaFacturasContables.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBExportar.setFont(new Font("Arial", 1, 12));
        this.JBExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBExportar.setText("Exportar");
        this.JBExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.6
            public void actionPerformed(ActionEvent evt) {
                JIF_AuditoriaFacturasContables.this.JBExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatosFiltro, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 493, -2).addGap(18, 18, 18).addComponent(this.JBExportar, -2, 149, -2).addGap(0, 0, 32767))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1079, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 419, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(118, 118, 118).addComponent(this.jScrollPane1, -2, 385, -2).addContainerGap(72, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() != 8 && getTitle().equals("Auditoría Facturas Contables".toUpperCase())) {
                JD_RegistroDocumentosAuitoria e = new JD_RegistroDocumentosAuitoria(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
                e.setLocationRelativeTo(this);
                e.setVisible(true);
            } else if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 8) {
                this.convertirBytesArrayAArchivo = new ConvertirBytesArrayAArchivo();
                setRuta(this.JTFRuta.getText());
                if (this.ruta != null) {
                    this.metodos.AbrirArchivosblob(this.modelo.getValueAt(getJTDetalle().getSelectedRow(), 8), "soporte", "pdf", true);
                }
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + getMetodos().getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBExportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            getMetodos().mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodasActionPerformed(ActionEvent evt) {
        setEstado("TODAS");
        cargarAuditores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PorAuditarActionPerformed(ActionEvent evt) {
        setEstado("POR_AUDITAR");
        cargarAuditores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AuditadasActionPerformed(ActionEvent evt) {
        setEstado("AUDITADAS");
        cargarAuditores();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Tercero", "No. Factura", "Fecha", "Valor", "idAuditoria", "Fecha Auditoria", "Detalle", "Valor Glosado", "Soporte", "Nombre Auditor", "Cargo"}) { // from class: com.genoma.plus.controller.contabilidad.JIF_AuditoriaFacturasContables.7
            Class[] types = {String.class, String.class, String.class, Double.class, Long.class, Date.class, String.class, Double.class, Byte.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
    }

    private void nuevo() {
        this.JRB_Todas.setSelected(true);
        setEstado(">=1");
        this.JTF_BusquedaNombre.setText("");
        this.JTFRuta.setText(getMetodos().getDirectorioExportacion() + "Planilla");
        cargarAuditores();
    }

    public void cargarAuditores() {
        List<IDetalleUsuarioFirmaDocumentosContables> listaFacturasPorAuditar;
        crearModeloTabla();
        if (getTitle().equals("Auditoría Facturas Contables")) {
            listaFacturasPorAuditar = this.documentoDetalleAuditoriaDAO.listadoFacturasParaAuditar(Principal.usuarioSistemaDTO.getIdPersonaCargo(), getEstado(), this.JTF_BusquedaNombre.getText());
        } else {
            listaFacturasPorAuditar = this.documentoDetalleAuditoriaDAO.listadoFacturasParaAuditarSinFiltroIdPersonaCargo(getEstado(), this.JTF_BusquedaNombre.getText());
        }
        if (!listaFacturasPorAuditar.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 0);
            for (IDetalleUsuarioFirmaDocumentosContables listaAuditore : listaFacturasPorAuditar) {
                if (listaAuditore.getNombreEmpresa() != null) {
                    Object[] fila = {listaAuditore.getNombreEmpresa(), listaAuditore.getNumeroFactura(), listaAuditore.getFechaFactura(), listaAuditore.getValorFactura(), listaAuditore.getIdAuditoria(), listaAuditore.getFechaAuditoria(), listaAuditore.getDetalleAuditoria(), listaAuditore.getValorGlosado(), listaAuditore.getSoporte(), listaAuditore.getNombreAuditor(), listaAuditore.getCargoAuditor()};
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    this.modelo.addRow(fila);
                }
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIF_AuditoriaFacturasContables$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5) == null) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(new Color(0, 103, 0));
                cell.setForeground(Color.WHITE);
            }
            return cell;
        }
    }

    @Generated
    public JButton getJBExportar() {
        return this.JBExportar;
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JPanel getJPI_DatosFiltro() {
        return this.JPI_DatosFiltro;
    }

    @Generated
    public JPanel getJPI_FiltroEstado() {
        return this.JPI_FiltroEstado;
    }

    @Generated
    public JRadioButton getJRB_Auditadas() {
        return this.JRB_Auditadas;
    }

    @Generated
    public JRadioButton getJRB_PorAuditar() {
        return this.JRB_PorAuditar;
    }

    @Generated
    public JRadioButton getJRB_Todas() {
        return this.JRB_Todas;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JTextField getJTF_BusquedaNombre() {
        return this.JTF_BusquedaNombre;
    }

    @Generated
    public JScrollPane getJScrollPane1() {
        return this.jScrollPane1;
    }
}
