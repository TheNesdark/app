package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFVacunacionEsquema.class */
public class JIFVacunacionEsquema extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String xid;
    private String[] xidgenerico1;
    private String[] xidgenerico2;
    private String[] xidgenerico3;
    private String[] xidgenerico4;
    private JComboBox JCBDosis;
    private JComboBox JCBEdad;
    private JComboBox JCBEsquema;
    private JComboBox JCBVacuna;
    private JPanel JPIDatos;
    private JSpinner JSNOrden;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JDesktopPane jDesktopPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xesgrupo = 0;
    private boolean xestadog = false;

    public JIFVacunacionEsquema(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mIniciarComponentes();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jDesktopPane1 = new JDesktopPane();
        this.JPIDatos = new JPanel();
        this.JCBVacuna = new JComboBox();
        this.JCBDosis = new JComboBox();
        this.JCBEdad = new JComboBox();
        this.JCBEsquema = new JComboBox();
        this.JSNOrden = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("VACUNACION POR ESQUEMA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifvacunaesquema");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFVacunacionEsquema.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFVacunacionEsquema.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBVacuna.setFont(new Font("Arial", 1, 12));
        this.JCBVacuna.setBorder(BorderFactory.createTitledBorder((Border) null, "Vacuna", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDosis.setFont(new Font("Arial", 1, 12));
        this.JCBDosis.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEdad.setFont(new Font("Arial", 1, 12));
        this.JCBEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEsquema.setFont(new Font("Arial", 1, 12));
        this.JCBEsquema.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Esquema", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSNOrden.setFont(new Font("Arial", 1, 12));
        this.JSNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBVacuna, GroupLayout.Alignment.TRAILING, 0, 593, 32767).addComponent(this.JCBDosis, 0, 589, 32767).addComponent(this.JCBEdad, 0, 593, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBEsquema, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JSNOrden, -2, 128, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBVacuna, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JCBDosis, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEdad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEsquema, -2, -1, -2).addComponent(this.JSNOrden)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFVacunacionEsquema.2
            public void mouseClicked(MouseEvent evt) {
                JIFVacunacionEsquema.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 625, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 221, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBVacuna.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBDosis.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBEdad.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBEsquema.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JSNOrden.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.JCBVacuna.setSelectedIndex(-1);
        this.JCBDosis.setSelectedIndex(-1);
        this.JCBEdad.setSelectedIndex(-1);
        this.JCBEsquema.setSelectedIndex(-1);
        this.JCBVacuna.requestFocus();
        this.JSNOrden.setValue(new Integer(0));
        Principal.txtNo.setText("");
    }

    private boolean mVerfica() {
        boolean xexiste = false;
        int i = 0;
        while (true) {
            if (i < this.JTDetalle.getRowCount()) {
                if (!this.JCBVacuna.getSelectedItem().equals(this.xmodelo.getValueAt(i, 1).toString()) || !this.JCBDosis.getSelectedItem().equals(this.xmodelo.getValueAt(i, 2).toString()) || !this.JCBEdad.getSelectedItem().equals(this.xmodelo.getValueAt(i, 3).toString()) || !this.JCBEsquema.getSelectedItem().equals(this.xmodelo.getValueAt(i, 4).toString())) {
                    i++;
                } else {
                    xexiste = true;
                    break;
                }
            } else {
                break;
            }
        }
        return xexiste;
    }

    public void mGrabar() {
        String sql = null;
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBVacuna.getSelectedIndex() != -1) {
                if (this.JCBDosis.getSelectedIndex() != -1) {
                    if (this.JCBEdad.getSelectedIndex() != -1) {
                        if (this.JCBEsquema.getSelectedIndex() != -1) {
                            if (!mVerfica()) {
                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (n == 0) {
                                    sql = " Insert into `p_vacunacion_esquema`(`IdVacuna` , `IdDosis` , `IdEdad` , `IdTipoEsquema`, `NOrden`,`UsuarioS`, `Fecha`)  values ('" + this.xidgenerico1[this.JCBVacuna.getSelectedIndex()] + "','" + this.xidgenerico2[this.JCBDosis.getSelectedIndex()] + "','" + this.xidgenerico3[this.JCBEdad.getSelectedIndex()] + "','" + this.xidgenerico4[this.JCBEsquema.getSelectedIndex()] + "','" + this.JSNOrden.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
                                }
                                this.xconsulta.ejecutarSQL(sql);
                                this.xconsulta.cerrarConexionBd();
                                mCargarDatosTabla();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "La Configuración ya existe, por favor verifique sus datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el esquema", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBEsquema.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Edad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBEdad.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la dosis", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBDosis.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Vacuna", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBVacuna.requestFocus();
            return;
        }
        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n2 == 0) {
            String sql2 = " update p_vacunacion_esquema set NOrden='" + this.JSNOrden.getValue() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' Where Id='" + Principal.txtNo.getText() + "'";
            this.xconsulta.ejecutarSQL(sql2);
            this.xconsulta.cerrarConexionBd();
            mCargarDatosTabla();
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Vacuna", "Dosis", "Edad", "Tipo Esquema", "No Orden"}) { // from class: ParametrizacionN.JIFVacunacionEsquema.3
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `p_vacunacion_esquema`.`Id`, `p_vacunacion_vacunas`.`Nbre` , `p_vacunacion_dosis`.`Nbre` , `p_vacunacion_edad`.`Nbre`, `p_vacunacion_tipoesquema`.`Nbre`,`p_vacunacion_esquema`.`NOrden` FROM `p_vacunacion_esquema` INNER JOIN `baseserver`.`p_vacunacion_vacunas`  ON (`p_vacunacion_esquema`.`IdVacuna` = `p_vacunacion_vacunas`.`Id`)INNER JOIN `p_vacunacion_dosis` ON (`p_vacunacion_esquema`.`IdDosis` = `p_vacunacion_dosis`.`Id`)INNER JOIN `p_vacunacion_edad`  ON (`p_vacunacion_esquema`.`IdEdad` = `p_vacunacion_edad`.`Id`)INNER JOIN `baseserver`.`p_vacunacion_tipoesquema` ON (`p_vacunacion_esquema`.`IdTipoEsquema` = `p_vacunacion_tipoesquema`.`Id`)ORDER BY `p_vacunacion_vacunas`.`Nbre`; ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFVacunacionEsquema.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarComponentes() {
        this.xidgenerico1 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM p_vacunacion_vacunas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico1, this.JCBVacuna);
        this.JCBVacuna.setSelectedIndex(-1);
        this.xidgenerico2 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM p_vacunacion_dosis WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico2, this.JCBDosis);
        this.JCBDosis.setSelectedIndex(-1);
        this.xidgenerico3 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM p_vacunacion_edad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico3, this.JCBEdad);
        this.JCBEdad.setSelectedIndex(-1);
        this.xidgenerico4 = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM p_vacunacion_tipoesquema WHERE (Estado =0) ORDER BY Nbre ASC", this.xidgenerico4, this.JCBEsquema);
        this.JCBEsquema.setSelectedIndex(0);
        this.xconsulta.cerrarConexionBd();
    }
}
