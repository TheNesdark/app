package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFEPreguntaxArea.class */
public class JIFEPreguntaxArea extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xtipoencuesta;
    private String[] xarea;
    private String[] xpregunta;
    private JComboBox JCBArea;
    private JComboBox JCBPregunta;
    private JComboBox JCBTipoEncuesta;
    private JCheckBox JCHEstado;
    private JPanel JIPDetalle;
    private JScrollPane JSDetalle;
    private JSpinner JSPUno;
    private JTable JTDetalle;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xgrabar = 0;

    public JIFEPreguntaxArea() {
        initComponents();
        this.xtipoencuesta = this.xconsulta.llenarCombo("SELECT Id,Nbre FROM t_encuestas ORDER BY Nbre ASC", this.xtipoencuesta, this.JCBTipoEncuesta);
        this.xarea = this.xconsulta.llenarCombo("SELECT Id,Nbre FROM g_areas ORDER BY Nbre ASC", this.xarea, this.JCBArea);
        this.xpregunta = this.xconsulta.llenarCombo("SELECT Id,Nbre FROM t_epregunta ORDER BY Nbre ASC", this.xpregunta, this.JCBPregunta);
        mCargarDatosTabla();
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JIPDetalle = new JPanel();
        this.JCBTipoEncuesta = new JComboBox();
        this.JCBArea = new JComboBox();
        this.JCBPregunta = new JComboBox();
        this.JSPUno = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("ENCUESTA PREGUNTAS POR AREA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifepreguntaxarea");
        addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEPreguntaxArea.1
            public void mouseClicked(MouseEvent evt) {
                JIFEPreguntaxArea.this.formMouseClicked(evt);
            }
        });
        this.JIPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoEncuesta.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEncuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Encuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPregunta.setFont(new Font("Arial", 1, 12));
        this.JCBPregunta.setBorder(BorderFactory.createTitledBorder((Border) null, "Pregunta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUno.setFont(new Font("Arial", 1, 12));
        this.JSPUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEPreguntaxArea.2
            public void actionPerformed(ActionEvent evt) {
                JIFEPreguntaxArea.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JIPDetalleLayout = new GroupLayout(this.JIPDetalle);
        this.JIPDetalle.setLayout(JIPDetalleLayout);
        JIPDetalleLayout.setHorizontalGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPDetalleLayout.createSequentialGroup().addComponent(this.JCBTipoEncuesta, -2, 339, -2).addGap(10, 10, 10).addComponent(this.JCBArea, 0, -1, 32767)).addGroup(JIPDetalleLayout.createSequentialGroup().addComponent(this.JCBPregunta, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPUno, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        JIPDetalleLayout.setVerticalGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEncuesta, -2, 50, -2).addComponent(this.JCBArea, -2, 50, -2)).addGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JIPDetalleLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JIPDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPUno, -2, 50, -2).addComponent(this.JCBPregunta, -2, 50, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JIPDetalleLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(23, 23, 23)))));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEPreguntaxArea.3
            public void mouseClicked(MouseEvent evt) {
                JIFEPreguntaxArea.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle, -1, 758, 32767).addComponent(this.JIPDetalle, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JIPDetalle, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSDetalle, -1, 241, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoEncuesta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBArea.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBPregunta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSPUno.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xgrabar = 1;
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JCBTipoEncuesta.setSelectedIndex(-1);
        this.JCBArea.setSelectedIndex(-1);
        this.JCBPregunta.setSelectedIndex(-1);
        this.JSPUno.setValue(new Integer(0));
        this.xgrabar = 0;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBTipoEncuesta.getSelectedIndex() != -1) {
            if (this.JCBArea.getSelectedIndex() != -1) {
                if (this.JCBPregunta.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.xgrabar == 0) {
                            sql = " Insert ignore into t_epreguntaxarea(Id_Tipo_Encuesta, Id_Area, Id_Pregunta, Orden, Estado, Fecha, UsuarioS)  values ('" + this.xtipoencuesta[this.JCBTipoEncuesta.getSelectedIndex()] + "','" + this.xarea[this.JCBArea.getSelectedIndex()] + "','" + this.xpregunta[this.JCBPregunta.getSelectedIndex()] + "','" + this.JSPUno.getValue() + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " update t_epreguntaxarea set Orden='" + this.JSPUno.getValue() + "', Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id_Tipo_Encuesta='" + this.xtipoencuesta[this.JCBTipoEncuesta.getSelectedIndex()] + "' and Id_Area='" + this.xarea[this.JCBArea.getSelectedIndex()] + "' and Id_Pregunta='" + this.xpregunta[this.JCBPregunta.getSelectedIndex()] + "'";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una pregunta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPregunta.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una area", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBArea.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de encuesta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoEncuesta.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo de Encuesta", "Area", "Pregunta", "Orden", "Estado"}) { // from class: ParametrizacionN.JIFEPreguntaxArea.4
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT`t_encuestas`.`Nbre`, `g_areas`.`Nbre`, `t_epregunta`.`Nbre`, `t_epreguntaxarea`.`Orden`, `t_epreguntaxarea`.`Estado`FROM`t_epreguntaxarea`INNER JOIN `g_areas` ON (`t_epreguntaxarea`.`Id_Area` = `g_areas`.`Id`)INNER JOIN `t_epregunta` ON (`t_epreguntaxarea`.`Id_Pregunta` = `t_epregunta`.`Id`)INNER JOIN `t_encuestas` ON (`t_epreguntaxarea`.`Id_Tipo_Encuesta` = `t_encuestas`.`Id`)ORDER BY `g_areas`.`Nbre` ASC, `t_epreguntaxarea`.`Orden` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEPreguntaxArea.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
