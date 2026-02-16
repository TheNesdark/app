package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CTurno;
import com.genoma.plus.jpa.service.ICTurnoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIF_Turnos.class */
public class JIF_Turnos extends JInternalFrame {
    private ICTurnoService turnoService = (ICTurnoService) Principal.contexto.getBean(ICTurnoService.class);
    private DefaultTableModel modelo;
    private Object[] dato;
    private Metodos metodos;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFHoraFin;
    private JTextField JTFHoraInicio;
    private JTextField JTFNombre;

    public JIF_Turnos() {
        initComponents();
        nuevo();
        this.metodos = new Metodos();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFHoraInicio = new JTextField();
        this.JTFHoraFin = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TURNOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifturnosjpa");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraInicio.setFont(new Font("Arial", 1, 12));
        this.JTFHoraInicio.setToolTipText("");
        this.JTFHoraInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraFin.setFont(new Font("Arial", 1, 12));
        this.JTFHoraFin.setToolTipText("");
        this.JTFHoraFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFHoraInicio, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFHoraFin, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFHoraInicio, -2, 50, -2).addComponent(this.JTFHoraFin, -2, 50, -2)))).addGap(14, 14, 14)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 651, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 359, 32767).addContainerGap()));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Hora Inicio", "Hora Fin", "Estado"}) { // from class: com.genoma.plus.controller.general.JIF_Turnos.1
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    public void nuevo() {
        this.JTFNombre.setText("");
        this.JTFHoraInicio.setText("");
        this.JTFHoraFin.setText("");
        this.JCHEstado.setSelected(true);
        cargarDatosTabla();
    }

    private void cargarDatosTabla() {
        new ArrayList();
        List<CTurno> lista = this.turnoService.listaTurno();
        crearModelo();
        lista.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNombre(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getHoraInicio(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getHoraFin(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 4);
        });
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFHoraInicio.getText().isEmpty()) {
                if (!this.JTFHoraFin.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        CTurno turno = new CTurno();
                        turno.setNombre(this.JTFNombre.getText());
                        turno.setHoraInicio(this.JTFHoraInicio.getText());
                        turno.setHoraFin(this.JTFHoraFin.getText());
                        turno.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                        turno.setFecha(this.metodos.getFechaActual());
                        turno.setUsuarios(Principal.usuarioSistemaDTO.getLogin());
                        this.turnoService.save(turno);
                        nuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar la hora de fin", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFHoraFin.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la hora de inicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFHoraInicio.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }
}
