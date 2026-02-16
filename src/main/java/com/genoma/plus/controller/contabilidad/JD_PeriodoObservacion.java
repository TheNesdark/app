package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcPeriodoContableObservacion;
import com.genoma.plus.jpa.entities.RhTipoPersonaCargon;
import com.genoma.plus.jpa.service.ICcPeriodoContableObservacionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JD_PeriodoObservacion.class */
public class JD_PeriodoObservacion extends JDialog {
    private final CcPeriodoContable periodoContable;
    private DefaultTableModel modelo;
    private Object[] datos;
    private final ICcPeriodoContableObservacionService observacionService;
    private List<CcPeriodoContableObservacion> periodoContableObservacions;
    private final Metodos metodo;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPMotivo;
    private JTextPane JTAMotivo;
    private JTable JTBDetalle;

    public JD_PeriodoObservacion(Frame parent, boolean modal, CcPeriodoContable periodoContable) {
        super(parent, modal);
        this.metodo = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.periodoContable = periodoContable;
        this.observacionService = (ICcPeriodoContableObservacionService) Principal.contexto.getBean(ICcPeriodoContableObservacionService.class);
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPMotivo = new JScrollPane();
        this.JTAMotivo = new JTextPane();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("MOTIVO");
        this.JSPMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAMotivo.setFont(new Font("Arial", 1, 12));
        this.JSPMotivo.setViewportView(this.JTAMotivo);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JD_PeriodoObservacion.1
            public void actionPerformed(ActionEvent evt) {
                JD_PeriodoObservacion.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JD_PeriodoObservacion.2
            public void actionPerformed(ActionEvent evt) {
                JD_PeriodoObservacion.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotivo).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 200, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 200, -2)).addComponent(this.JSPDetalle, -1, 508, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JSPMotivo, -1, 87, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 146, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -1, 50, 32767).addComponent(this.JBTSalir, -1, 50, 32767)).addGap(22, 22, 22)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Fecha", "Motivo", "Usuario", "Fecha Hora Registro"}) { // from class: com.genoma.plus.controller.contabilidad.JD_PeriodoObservacion.3
            Class[] types = {Integer.class, Boolean.class, Date.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    void cargarDatos() {
        this.periodoContableObservacions = new ArrayList();
        this.periodoContableObservacions = this.observacionService.findByIdPeriodoOrderByFechaRegistroDesc(this.periodoContable);
        crearModeloDatos();
        this.metodo.mEstablecerTextEditor(this.JTBDetalle, 3);
        if (!this.periodoContableObservacions.isEmpty()) {
            this.periodoContableObservacions.forEach(e -> {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(e.getId(), this.JTBDetalle.getRowCount() - 1, 0);
                this.modelo.setValueAt(e.getForma(), this.JTBDetalle.getRowCount() - 1, 1);
                this.modelo.setValueAt(e.getFecha(), this.JTBDetalle.getRowCount() - 1, 2);
                this.modelo.setValueAt(e.getMotivo(), this.JTBDetalle.getRowCount() - 1, 3);
                this.modelo.setValueAt(e.getIdTerceroRh().getIdPersona().getApellido1().concat(" ").concat(e.getIdTerceroRh().getIdPersona().getApellido2()).concat(" ").concat(e.getIdTerceroRh().getIdPersona().getNombre1()).concat(" ").concat(e.getIdTerceroRh().getIdPersona().getNombre2()), this.JTBDetalle.getRowCount() - 1, 4);
                this.modelo.setValueAt(e.getFechaRegistro(), this.JTBDetalle.getRowCount() - 1, 5);
            });
        }
    }

    public void nuevo() {
        cargarDatos();
    }

    private void grabar() {
        if (!this.JTAMotivo.getText().isEmpty()) {
            RhTipoPersonaCargon rhTerceroTipocargo = new RhTipoPersonaCargon();
            rhTerceroTipocargo.setId(Principal.usuarioSistemaDTO.getIdPersonaCargo());
            CcPeriodoContableObservacion observacion = CcPeriodoContableObservacion.builder().estado(true).fecha(this.metodo.getFechaActual()).fechaRegistro(this.metodo.getFechaActual()).forma(this.periodoContable.getActivo()).idPeriodo(this.periodoContable).idTerceroRh(rhTerceroTipocargo).motivo(this.JTAMotivo.getText()).build();
            this.observacionService.grabar(observacion);
            cargarDatos();
            dispose();
        }
    }
}
