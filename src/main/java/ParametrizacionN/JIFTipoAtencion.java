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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoAtencion.class */
public class JIFTipoAtencion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private ButtonGroup BGAtencion;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHEstado;
    private JPanel JPAgenda;
    private JPanel JPIDatos;
    private JRadioButton JRBAmbulatorio;
    private JRadioButton JRBHospitalizacion;
    private JRadioButton JRBUrgencias;
    private JScrollPane JSDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xespecial = 0;
    private int xambito = 0;
    private boolean xestadog = false;
    private int Index = 1;

    public JIFTipoAtencion() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.BGAtencion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JCHEspecial = new JCheckBox();
        this.JSPOrden = new JSpinner();
        this.JPAgenda = new JPanel();
        this.JRBAmbulatorio = new JRadioButton();
        this.JRBHospitalizacion = new JRadioButton();
        this.JRBUrgencias = new JRadioButton();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE ATENCION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipoatencion");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoAtencion.1
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setText("GenHosp");
        this.JCHEspecial.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoAtencion.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JCHEspecialActionPerformed(evt);
            }
        });
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "AGENDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.BGAtencion.add(this.JRBAmbulatorio);
        this.JRBAmbulatorio.setSelected(true);
        this.JRBAmbulatorio.setText("Ambulatorio");
        this.JRBAmbulatorio.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoAtencion.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JRBAmbulatorioActionPerformed(evt);
            }
        });
        this.BGAtencion.add(this.JRBHospitalizacion);
        this.JRBHospitalizacion.setText("Hospitalizacion");
        this.JRBHospitalizacion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoAtencion.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JRBHospitalizacionActionPerformed(evt);
            }
        });
        this.BGAtencion.add(this.JRBUrgencias);
        this.JRBUrgencias.setText("Urgencias");
        this.JRBUrgencias.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFTipoAtencion.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JRBUrgenciasActionPerformed(evt);
            }
        });
        GroupLayout JPAgendaLayout = new GroupLayout(this.JPAgenda);
        this.JPAgenda.setLayout(JPAgendaLayout);
        JPAgendaLayout.setHorizontalGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAgendaLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JRBAmbulatorio).addGap(42, 42, 42).addComponent(this.JRBHospitalizacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.JRBUrgencias).addContainerGap()));
        JPAgendaLayout.setVerticalGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAgendaLayout.createSequentialGroup().addGap(8, 8, 8).addGroup(JPAgendaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAmbulatorio).addComponent(this.JRBHospitalizacion).addComponent(this.JRBUrgencias)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre).addComponent(this.JPAgenda, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPOrden, -2, 66, -2).addComponent(this.JCHEstado).addComponent(this.JCHEspecial))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JSPOrden, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JCHEspecial).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPAgenda, -2, -1, -2)))));
        this.JSDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoAtencion.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoAtencion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSDetalle, -1, 486, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -1, -1, 32767))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSDetalle, -1, 234, 32767).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEspecialActionPerformed(ActionEvent evt) {
        if (this.JCHEspecial.isSelected()) {
            this.xespecial = 1;
        } else {
            this.xespecial = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAmbulatorioActionPerformed(ActionEvent evt) {
        this.xambito = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHospitalizacionActionPerformed(ActionEvent evt) {
        this.xambito = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrgenciasActionPerformed(ActionEvent evt) {
        this.xambito = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCHEspecial.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            if (this.JCHEspecial.isSelected()) {
                this.xespecial = 1;
            } else {
                this.xespecial = 0;
            }
            if (1 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()))) {
                this.xambito = 1;
                this.JRBAmbulatorio.setSelected(true);
            } else if (2 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()))) {
                this.xambito = 2;
                this.JRBHospitalizacion.setSelected(true);
            } else if (3 == Integer.parseInt(String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()))) {
                this.xambito = 3;
                this.JRBUrgencias.setSelected(true);
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.JSPOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JSPOrden.setValue(Integer.valueOf("0"));
        this.JRBAmbulatorio.setSelected(true);
        this.JRBHospitalizacion.setSelected(false);
        this.JRBUrgencias.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JCHEspecial.setSelected(false);
        this.xambito = 1;
        this.xespecial = 0;
        this.xestado = 0;
        mCargarDatosTabla();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into g_tipoatencion(Nbre, GenHosp, Id_TipoAmbito, Estado, Orden,Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xespecial + "','" + this.xambito + "','" + this.xestado + "','" + this.JSPOrden.getValue() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update g_tipoatencion set Nbre='" + this.JTFNombre.getText().toUpperCase() + "', GenHosp='" + this.xespecial + "', Id_TipoAmbito='" + this.xambito + "', Estado='" + this.xestado + "', Orden='" + this.JSPOrden.getValue() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede estar nulo   ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "GenHosp", "VAmbito", "Ambito", "Estado", "Orden"}) { // from class: ParametrizacionN.JIFTipoAtencion.7
            Class[] types = {Long.class, String.class, Boolean.class, Integer.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(40);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT`g_tipoatencion`.`Id`, `g_tipoatencion`.`Nbre`, `g_tipoatencion`.`GenHosp`, `g_tipoatencion`.`Id_TipoAmbito`, `g_tipoambito`.`Nbre`, `g_tipoatencion`.`Estado`, `g_tipoatencion`.`Orden`\nFROM`g_tipoatencion`INNER JOIN `g_tipoambito` ON (`g_tipoatencion`.`Id_TipoAmbito` = `g_tipoambito`.`Id`)ORDER BY `g_tipoatencion`.`Nbre` ASC, `g_tipoatencion`.`Orden` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFTipoAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
