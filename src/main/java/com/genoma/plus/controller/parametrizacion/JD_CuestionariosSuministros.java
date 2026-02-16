package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ISuministro;
import com.genoma.plus.jpa.entities.ISuministroTipocuestionario;
import com.genoma.plus.jpa.entities.SoTipoCuestionario;
import com.genoma.plus.jpa.entities.SoTipoCuestionarioClasificacion;
import com.genoma.plus.jpa.service.ISuministroTipocuestionarioService;
import com.genoma.plus.jpa.service.ITipoCuestionarioSaludOcupacionalService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JD_CuestionariosSuministros.class */
public class JD_CuestionariosSuministros extends JDialog {
    private ISuministro suministro;
    private List<SoTipoCuestionario> tipoCuestionarios;
    private final ITipoCuestionarioSaludOcupacionalService iTipoCuestionarioSaludOcupacionalService;
    private final ISuministroTipocuestionarioService iSuministroTipocuestionarioService;
    private List<ISuministroTipocuestionario> suministroTipocuestionarios;
    private DefaultTableModel modelo;
    private Object[] datos;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JCheckBox JCH_Seleccionar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JD_CuestionariosSuministros(Frame parent, boolean modal, ISuministro suministro) {
        super(parent, modal);
        this.iTipoCuestionarioSaludOcupacionalService = (ITipoCuestionarioSaludOcupacionalService) Principal.contexto.getBean(ITipoCuestionarioSaludOcupacionalService.class);
        this.iSuministroTipocuestionarioService = (ISuministroTipocuestionarioService) Principal.contexto.getBean(ISuministroTipocuestionarioService.class);
        initComponents();
        this.suministro = suministro;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        cargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JCH_Seleccionar = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("PARAMETRIZACIÓN ENCUESTA FARMACOVIGILANCIA(DISPARADORES)");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JD_CuestionariosSuministros.1
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionariosSuministros.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JD_CuestionariosSuministros.2
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionariosSuministros.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar todo?");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JD_CuestionariosSuministros.3
            public void actionPerformed(ActionEvent evt) {
                JD_CuestionariosSuministros.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Seleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Grabar, -2, 230, -2).addGap(37, 37, 37).addComponent(this.JBT_Salir, -2, 230, -2).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 638, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(287, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Salir, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2)).addComponent(this.JCH_Seleccionar, GroupLayout.Alignment.TRAILING)).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JSPDetalle, -2, 255, -2).addContainerGap(71, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() >= 1) {
            Grabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCH_Seleccionar.isSelected()) {
            this.JCH_Seleccionar.setText("Quitar selección");
            seleccionarDeseleccionar(true);
        } else {
            this.JCH_Seleccionar.setText("Seleccionar todo?");
            seleccionarDeseleccionar(false);
        }
    }

    private void seleccionarDeseleccionar(Boolean estado) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.JTDetalle.setValueAt(estado, x, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDetalle() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Cuestionario", "Grabada", "Estado", "Seleccionar", "idTabla"}) { // from class: com.genoma.plus.controller.parametrizacion.JD_CuestionariosSuministros.4
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, true, true, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
    }

    private void cargarDatos() {
        crearModeloDetalle();
        SoTipoCuestionarioClasificacion clasificacion = new SoTipoCuestionarioClasificacion();
        clasificacion.setId(2);
        this.tipoCuestionarios = this.iTipoCuestionarioSaludOcupacionalService.listaCuestionarioPorIdClasificacionEstado(clasificacion, true);
        this.suministroTipocuestionarios = this.iSuministroTipocuestionarioService.listaCuestionarioPorSuministro(this.suministro);
        if (!this.tipoCuestionarios.isEmpty()) {
            this.tipoCuestionarios.forEach(item -> {
                this.modelo.addRow(this.datos);
                this.JTDetalle.setValueAt(item.getId(), this.JTDetalle.getRowCount() - 1, 0);
                this.JTDetalle.setValueAt(item.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                if (!this.suministroTipocuestionarios.isEmpty()) {
                    this.suministroTipocuestionarios.forEach(itemCuestionario -> {
                        if (Objects.equals(item.getId(), itemCuestionario.getIdTipoCuestionario().getId())) {
                            this.JTDetalle.setValueAt(true, this.JTDetalle.getRowCount() - 1, 2);
                            this.JTDetalle.setValueAt(itemCuestionario.getEstado(), this.JTDetalle.getRowCount() - 1, 3);
                            this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 4);
                            this.JTDetalle.setValueAt(itemCuestionario.getId(), this.JTDetalle.getRowCount() - 1, 5);
                        }
                    });
                    return;
                }
                this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 2);
                this.JTDetalle.setValueAt(true, this.JTDetalle.getRowCount() - 1, 3);
                this.JTDetalle.setValueAt(false, this.JTDetalle.getRowCount() - 1, 4);
                this.JTDetalle.setValueAt((Object) null, this.JTDetalle.getRowCount() - 1, 5);
            });
        }
    }

    private void Grabar() {
        Metodos metodos = new Metodos();
        if (metodos.mVerificarDatosTablaTrue(this.JTDetalle, 4)) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.suministroTipocuestionarios = new ArrayList();
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(y, 4).toString()).booleanValue()) {
                        ISuministroTipocuestionario suministroTipocuestionario = new ISuministroTipocuestionario();
                        SoTipoCuestionario tipoCuestionario = new SoTipoCuestionario();
                        tipoCuestionario.setId(Integer.valueOf(this.JTDetalle.getValueAt(y, 0).toString()));
                        suministroTipocuestionario.setEstado(Boolean.valueOf(this.JTDetalle.getValueAt(y, 3).toString()));
                        if (this.JTDetalle.getValueAt(y, 5) != null) {
                            suministroTipocuestionario.setId(Integer.valueOf(this.JTDetalle.getValueAt(y, 5).toString()));
                        }
                        suministroTipocuestionario.setSuministro(this.suministro);
                        suministroTipocuestionario.setIdTipoCuestionario(tipoCuestionario);
                        suministroTipocuestionario.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        suministroTipocuestionario.setFecha(metodos.getFechaActual());
                        this.suministroTipocuestionarios.add(suministroTipocuestionario);
                    }
                }
                if (!this.suministroTipocuestionarios.isEmpty()) {
                    this.iSuministroTipocuestionarioService.grabar(this.suministroTipocuestionarios);
                    cargarDatos();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "No existe registro seleccionado en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }
}
