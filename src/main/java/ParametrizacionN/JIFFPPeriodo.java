package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFPPeriodo.class */
public class JIFFPPeriodo extends JInternalFrame {
    private int xCerrado = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private String[] xidencabezado;
    private JComboBox JCBEncabezado;
    private JCheckBox JCHCerrado;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFFPPeriodo() {
        initComponents();
        mNuevo();
        mCargarDatosTabla();
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCHCerrado.setSelected(false);
        this.xCerrado = 0;
        this.JCBEncabezado.removeAllItems();
        this.xidencabezado = this.xct.llenarCombo("SELECT id, nombre FROM pp_rubros_encabezado WHERE (Estado =1) ORDER BY nombre ASC", this.xidencabezado, this.JCBEncabezado);
        this.JCBEncabezado.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBEncabezado.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = " Insert into pp_periodo(Nbre, FechaI, FechaF, Cerrado, idEncabezado, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "','" + this.xCerrado + "','" + this.xidencabezado[this.JCBEncabezado.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql = " update pp_periodo set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',FechaI='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "',FechaF='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "',Cerrado='" + this.xCerrado + "',idEncabezado='" + this.xidencabezado[this.JCBEncabezado.getSelectedIndex()] + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mCargarDatosTabla();
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un Encabezado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEncabezado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ingrese un Nombre de Periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Encabezado", "Fecha I", "Fecha F", "Cerrado"}) { // from class: ParametrizacionN.JIFFPPeriodo.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xct.traerRs("SELECT `pp_periodo`.`Id`, `pp_periodo`.`Nbre`, `pp_rubros_encabezado`.`nombre` AS `Encabezado`, `pp_periodo`.`FechaI`, `pp_periodo`.`FechaF`, `pp_periodo`.`Cerrado` FROM `pp_periodo` INNER JOIN `pp_rubros_encabezado` ON (`pp_periodo`.`idEncabezado` = `pp_rubros_encabezado`.`id`) ORDER BY `pp_periodo`.`Nbre` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xModelo.setValueAt(xrs.getString(2), n, 1);
                    this.xModelo.setValueAt(xrs.getString(3), n, 2);
                    this.xModelo.setValueAt(xrs.getString(4), n, 3);
                    this.xModelo.setValueAt(xrs.getString(5), n, 4);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGBarrio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHCerrado = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBEncabezado = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PERIODO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Periodo");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHCerrado.setFont(new Font("Arial", 1, 12));
        this.JCHCerrado.setText("Cerrado");
        this.JCHCerrado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFPPeriodo.2
            public void actionPerformed(ActionEvent evt) {
                JIFFPPeriodo.this.JCHCerradoActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEncabezado.setFont(new Font("Arial", 1, 12));
        this.JCBEncabezado.setModel(new DefaultComboBoxModel(new String[]{" "}));
        this.JCBEncabezado.setSelectedIndex(-1);
        this.JCBEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEncabezado, 0, -1, 32767).addContainerGap()).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCerrado).addGap(22, 22, 22)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCHCerrado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBEncabezado, -2, 50, -2))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFPPeriodo.3
            public void mouseClicked(MouseEvent evt) {
                JIFFPPeriodo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -1, -1, 32767).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPDetalle, -1, 597, 32767).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 306, 32767).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradoActionPerformed(ActionEvent evt) {
        if (this.JCHCerrado.isSelected()) {
            this.xCerrado = 1;
        } else {
            this.xCerrado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBEncabezado.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            SimpleDateFormat form_fecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.JDFechaI.setDate(form_fecha.parse(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            } catch (ParseException ex) {
                Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            try {
                this.JDFechaF.setDate(form_fecha.parse(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            } catch (ParseException ex2) {
                Logger.getLogger(JIFConfSalaCirugias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            this.JCHCerrado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHCerrado.isSelected()) {
                this.xCerrado = 1;
            } else {
                this.xCerrado = 0;
            }
        }
    }
}
