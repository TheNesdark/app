package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import General.JDBuscarDatos;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GProcedimiento;
import com.genoma.plus.jpa.entities.GProcedimientoxcntEntity;
import com.genoma.plus.jpa.service.GProcedimientoxcntService;
import com.genoma.plus.jpa.service.IGProcedimientoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JDHomologacionProcedimiento.class */
public class JDHomologacionProcedimiento extends JDialog {
    private Metodos metodos;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private List<String> listaPendientes;
    private final GProcedimientoxcntService gProcedimientoxcntService;
    private final IGProcedimientoService gProcedimientoService;
    List<GProcedimientoxcntEntity> ListaProcedimientoxcntEntity;
    private JButton JBCerrar;
    private JButton JBGrabar;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;

    public JDHomologacionProcedimiento(Frame parent, boolean modal, List<String> listaPendientes) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.listaPendientes = new ArrayList();
        this.gProcedimientoxcntService = (GProcedimientoxcntService) Principal.contexto.getBean(GProcedimientoxcntService.class);
        this.gProcedimientoService = (IGProcedimientoService) Principal.contexto.getBean(IGProcedimientoService.class);
        initComponents();
        setTitle("Homologacion de Procedimientos");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.listaPendientes.addAll(listaPendientes);
        mCargadatos();
    }

    public void mCargadatos() {
        mCrearModelo();
        for (int i = 0; i < this.listaPendientes.size(); i++) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(this.listaPendientes.get(i), i, 0);
            this.xmodelo.setValueAt("", i, 1);
            this.xmodelo.setValueAt("", i, 2);
            this.xmodelo.setValueAt(new JButton("Buscar"), i, 3);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo Externo", "CUP Genoma", "Nombre Procedimiento", "Accion"}) { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.1
            Class[] types = {String.class, Long.class, String.class, JButton.class};
            boolean[] canEdit = {false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.2
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBCerrar = new JButton();
        this.JBGrabar = new JButton();
        setDefaultCloseOperation(2);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.3
            public void mouseClicked(MouseEvent evt) {
                JDHomologacionProcedimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.4
            public void keyReleased(KeyEvent evt) {
                JDHomologacionProcedimiento.this.JTDetalleKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDHomologacionProcedimiento.this.JTDetalleKeyTyped(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBCerrar.setFont(new Font("Arial", 1, 12));
        this.JBCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBCerrar.setText("Salir");
        this.JBCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.5
            public void actionPerformed(ActionEvent evt) {
                JDHomologacionProcedimiento.this.JBCerrarActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JDHomologacionProcedimiento.6
            public void actionPerformed(ActionEvent evt) {
                JDHomologacionProcedimiento.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 579, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBCerrar, -2, 198, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 275, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBCerrar, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != 0) {
            this.ListaProcedimientoxcntEntity = new ArrayList();
            if (!this.metodos.mVerificarDatosLLeno(this.JTDetalle, 2)) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        GProcedimientoxcntEntity e = new GProcedimientoxcntEntity();
                        e.setIdProcedimiento(Long.valueOf(this.xmodelo.getValueAt(i, 1).toString()));
                        e.setCodigoCnt(this.xmodelo.getValueAt(i, 0).toString());
                        e.setEstado(1);
                        e.setFecha(this.metodos.getFechaActual());
                        e.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                        this.ListaProcedimientoxcntEntity.add(e);
                    }
                    this.gProcedimientoxcntService.saveAll(this.ListaProcedimientoxcntEntity);
                    dispose();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Aun faltan Procedimientos por Homologar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 3) {
            JDBuscarDatos JDBuscarDatos = new JDBuscarDatos(null, true, "BUSCAR PROCEDIMIENTOS", this);
            JDBuscarDatos.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyReleased(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 1) {
            System.out.println("entro en 1");
            if (evt.getKeyCode() == 10) {
                System.out.println("entro en 2");
                Optional<GProcedimiento> procedimiento = this.gProcedimientoService.getGProcedimiento(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
                if (procedimiento.isPresent()) {
                    System.out.println("entro en 3");
                    this.xmodelo.setValueAt(procedimiento.get().getNbre(), this.JTDetalle.getSelectedRow(), 2);
                } else {
                    this.xmodelo.setValueAt("", this.JTDetalle.getSelectedRow(), 2);
                }
            }
        }
    }
}
