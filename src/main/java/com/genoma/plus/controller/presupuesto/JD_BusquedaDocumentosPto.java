package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import com.genoma.plus.jpa.dto.SolicitudPresupuesto;
import com.genoma.plus.jpa.entities.PpSolicitudPto;
import com.genoma.plus.jpa.entities.PpSolicitudPtoDetalle;
import com.genoma.plus.jpa.projection.IPpSolicitudPtoDetalleProjection;
import com.genoma.plus.jpa.projection.IPpSolicitudPtoProjection;
import com.genoma.plus.jpa.service.IPpSolicitudPtoDetalleService;
import com.genoma.plus.jpa.service.IPpSolicitudPtoService;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JD_BusquedaDocumentosPto.class */
public class JD_BusquedaDocumentosPto extends JDialog {
    private JIFFMovimiento_new movimiento_new;
    private DefaultTableModel modelo;
    private IPpSolicitudPtoService iPpSolicitudPtoService;
    private List<SolicitudPresupuesto> listSolicitudPresupuesto;
    private Optional<PpSolicitudPto> listSolicitudPto;
    private Object[] dato;
    private String filtro;
    private String objetoLlamador;
    private SolicitudPresupuesto solicitudPto;
    private IPpSolicitudPtoDetalleService iPpSolicitudPtoDetalleService;
    private List<PpSolicitudPtoDetalle> listPpSolicitudPtoDetalle;
    private PpSolicitudPtoDetalle ppSolicitudPtoDetalle;
    private IPpSolicitudPtoDetalleProjection detalleProjection;
    private List<IPpSolicitudPtoProjection> projectionSolicitud;
    private boolean iniciado;
    private ButtonGroup JBG_Filtro;
    private JYearChooser JDAno;
    private JPanel JPI_Filtro;
    private JRadioButton JRBCon;
    private JRadioButton JRBSin;
    private JRadioButton JRBTodo;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFNo;

    public JD_BusquedaDocumentosPto(Frame parent, boolean modal, String titulo, Integer idClaseDocumento, Object llamador) {
        super(parent, modal);
        this.iniciado = false;
        initComponents();
        this.iPpSolicitudPtoService = (IPpSolicitudPtoService) Principal.contexto.getBean(IPpSolicitudPtoService.class);
        this.iPpSolicitudPtoDetalleService = (IPpSolicitudPtoDetalleService) Principal.contexto.getBean(IPpSolicitudPtoDetalleService.class);
        setTitle(titulo);
        casting(llamador);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBSin = new JRadioButton();
        this.JRBCon = new JRadioButton();
        this.JDAno = new JYearChooser();
        this.JTFNo = new JTextField();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBG_Filtro.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.1
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaDocumentosPto.this.JRBTodoActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBSin);
        this.JRBSin.setFont(new Font("Arial", 1, 12));
        this.JRBSin.setSelected(true);
        this.JRBSin.setText("Genrico1");
        this.JRBSin.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.2
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaDocumentosPto.this.JRBSinActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBCon);
        this.JRBCon.setFont(new Font("Arial", 1, 12));
        this.JRBCon.setText("Genrico1");
        this.JRBCon.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.3
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaDocumentosPto.this.JRBConActionPerformed(evt);
            }
        });
        this.JDAno.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_BusquedaDocumentosPto.this.JDAnoPropertyChange(evt);
            }
        });
        this.JTFNo.setFont(new Font("Arial", 1, 12));
        this.JTFNo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.5
            public void keyPressed(KeyEvent evt) {
                JD_BusquedaDocumentosPto.this.JTFNoKeyPressed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSin).addGap(18, 18, 18).addComponent(this.JRBCon).addGap(18, 18, 18).addComponent(this.JRBTodo, -2, 77, -2).addGap(18, 18, 18).addComponent(this.JDAno, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNo, -2, 143, -2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPI_FiltroLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBSin).addComponent(this.JRBCon))).addGroup(GroupLayout.Alignment.LEADING, JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDAno, -2, 50, -2).addComponent(this.JTFNo, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSP_Detalle.setAutoscrolls(true);
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.6
            public void mouseClicked(MouseEvent evt) {
                JD_BusquedaDocumentosPto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 809, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_Detalle, -1, 797, 32767).addComponent(this.JPI_Filtro, -1, -1, 32767)).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 426, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -1, 322, 32767).addContainerGap())));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.iniciado) {
            buscaSolicitudes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinActionPerformed(ActionEvent evt) {
        buscaSolicitudes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConActionPerformed(ActionEvent evt) {
        buscaSolicitudes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.objetoLlamador.equals("JIFFMovimiento_new")) {
            if (this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7) == null || this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString().isEmpty() || this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString().equals("")) {
                this.movimiento_new.idSolicitud = Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.movimiento_new.JLCodigoDoc.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                double valorNumerico = Double.parseDouble(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                DecimalFormat formato = new DecimalFormat("#");
                String valorFormateado = formato.format(valorNumerico);
                System.out.println("------------- +" + valorFormateado);
                this.movimiento_new.JFTFValorDoc.setText(valorFormateado);
                this.movimiento_new.JTObservacion.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.movimiento_new.detalleProjections = consultaRubroSolicitud();
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Esta Solicitud ya tiene Disponibilidad asociada", "VERIFICAR", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            System.out.println("entraaaaa ");
            buscaSolicitudes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        buscaSolicitudes();
    }

    private void nuevo() {
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE SOLICITUDES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JRBSin.setText("Sin Disponibilidad");
        this.JRBCon.setText("Con Disponibilidad");
        buscaSolicitudes();
        this.iniciado = true;
    }

    private void buscaSolicitudes() {
        this.projectionSolicitud = new ArrayList();
        if (!this.JTFNo.getText().isEmpty()) {
            this.projectionSolicitud = this.iPpSolicitudPtoService.getListSolicitudText(Integer.valueOf(this.JDAno.getValue()), this.JTFNo.getText());
        } else if (this.JRBSin.isSelected()) {
            this.projectionSolicitud = this.iPpSolicitudPtoService.getListSolicitudSin(Integer.valueOf(this.JDAno.getValue()));
        } else if (this.JRBCon.isSelected()) {
            this.projectionSolicitud = this.iPpSolicitudPtoService.getListSolicitudCon(Integer.valueOf(this.JDAno.getValue()));
        } else if (this.JRBTodo.isSelected()) {
            this.projectionSolicitud = this.iPpSolicitudPtoService.getListSolicitudTodo(Integer.valueOf(this.JDAno.getValue()));
        }
        crearModeloSolicitud();
        if (!this.projectionSolicitud.isEmpty()) {
            this.projectionSolicitud.forEach(e -> {
                this.modelo.addRow(this.dato);
                this.JTDetalle.setValueAt(e.getIdSol(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(e.getNConsecutivo(), this.JTDetalle.getRowCount() - 1, 1);
                this.JTDetalle.setValueAt(e.getFechaR(), this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(e.getObservacionG(), this.JTDetalle.getRowCount() - 1, 3);
                this.JTDetalle.setValueAt(e.getVPresupuestado(), this.JTDetalle.getRowCount() - 1, 4);
                this.JTDetalle.setValueAt(e.getNUsuario(), this.JTDetalle.getRowCount() - 1, 5);
                this.JTDetalle.setValueAt(e.getUnidadF(), this.JTDetalle.getRowCount() - 1, 6);
                this.JTDetalle.setValueAt(e.getIdSolicitud(), this.JTDetalle.getRowCount() - 1, 7);
                this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            });
        }
    }

    private void casting(Object objetoLlamador) {
        switch (objetoLlamador.getClass().getSimpleName()) {
            case "JIFFMovimiento_new":
                this.objetoLlamador = "JIFFMovimiento_new";
                this.movimiento_new = (JIFFMovimiento_new) objetoLlamador;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloSolicitud() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Numero Consecutivo", "Fecha", "Observación", "Valor", "Usuario", "Unidad Funcional", "idSolicitudM"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaDocumentosPto.7
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    private List<IPpSolicitudPtoDetalleProjection> consultaRubroSolicitud() {
        List<IPpSolicitudPtoDetalleProjection> detalleProjections = this.iPpSolicitudPtoDetalleService.getListIdMovimiento(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()));
        if (detalleProjections == null || detalleProjections.isEmpty()) {
            System.out.println("La proyección es nula o no trajo resultados.");
        }
        return detalleProjections;
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JD_BusquedaDocumentosPto$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Object xvalor = table.getValueAt(row, 7);
            if (xvalor != null && !xvalor.toString().isEmpty()) {
                cell.setBackground(new Color(155, 255, 153));
            } else {
                cell.setBackground(new Color(255, 255, 255));
            }
            return cell;
        }
    }
}
