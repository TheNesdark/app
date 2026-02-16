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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFEscalaAbreviadaP.class */
public class JIFEscalaAbreviadaP extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xcat;
    private String[] xpreg;
    private JComboBox JCBCategoria;
    private JComboBox JCBPregunta;
    private JCheckBox JCHEstado;
    private JPanel JPRango;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JFormattedTextField JTFFDesde;
    private JFormattedTextField JTFFHasta;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private long xEstado = 1;

    public JIFEscalaAbreviadaP() {
        initComponents();
        this.JTFFDesde.setValue(0);
        this.JTFFHasta.setValue(0);
        mIniciaComponentes();
        mCargaDatos();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JCBCategoria = new JComboBox();
        this.JCBPregunta = new JComboBox();
        this.JPRango = new JPanel();
        this.JTFFDesde = new JFormattedTextField();
        this.JTFFHasta = new JFormattedTextField();
        this.JSPOrden = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ESCALA ABREVIADA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifEscalaAbreviada");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFEscalaAbreviadaP.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEscalaAbreviadaP.this.formInternalFrameClosing(evt);
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
        this.JCBCategoria.setFont(new Font("Arial", 1, 12));
        this.JCBCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoría", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPregunta.setFont(new Font("Arial", 1, 12));
        this.JCBPregunta.setBorder(BorderFactory.createTitledBorder((Border) null, "Pregunta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPRango.setBorder(BorderFactory.createTitledBorder((Border) null, "Rango (Meses)", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFFDesde.setBorder(BorderFactory.createTitledBorder((Border) null, "Desde", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFDesde.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFDesde.setHorizontalAlignment(4);
        this.JTFFDesde.setFont(new Font("Arial", 1, 12));
        this.JTFFHasta.setBorder(BorderFactory.createTitledBorder((Border) null, "Hasta", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFHasta.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#"))));
        this.JTFFHasta.setHorizontalAlignment(4);
        this.JTFFHasta.setFont(new Font("Arial", 1, 12));
        GroupLayout JPRangoLayout = new GroupLayout(this.JPRango);
        this.JPRango.setLayout(JPRangoLayout);
        JPRangoLayout.setHorizontalGroup(JPRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRangoLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFFDesde, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHasta, -2, 67, -2)));
        JPRangoLayout.setVerticalGroup(JPRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRangoLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPRangoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFDesde, -2, 48, -2).addComponent(this.JTFFHasta, -2, 48, -2))));
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFEscalaAbreviadaP.2
            public void mouseClicked(MouseEvent evt) {
                JIFEscalaAbreviadaP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFEscalaAbreviadaP.3
            public void actionPerformed(ActionEvent evt) {
                JIFEscalaAbreviadaP.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPRango, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 80, -2).addGap(26, 26, 26).addComponent(this.JCHEstado)).addGroup(layout.createSequentialGroup().addComponent(this.JCBCategoria, -2, 303, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPregunta, -2, 371, -2))).addGap(0, 0, 32767)).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCategoria, -1, 50, 32767).addComponent(this.JCBPregunta, -1, 50, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPRango, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(30, 30, 30).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPOrden, -2, 50, -2).addComponent(this.JCHEstado)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 314, -2).addContainerGap()));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Orden", "Pregunta", "Categoria", "Desde", "Hasta", "Estado"}) { // from class: ParametrizacionN.JIFEscalaAbreviadaP.4
            Class[] types = {Integer.class, Long.class, String.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCargaDatos() {
        try {
            mCreaModelo();
            ResultSet xrs = this.xct.traerRs("SELECT `p_escala_preg_categ`.`Id` , `p_escala_preg_categ`.`Orden` , `p_escala_preguntas`.`Nbre` , `p_escala_categoria`.`Nbre` ,  `p_escala_preg_categ`.`RangoMin`  , `p_escala_preg_categ`.`RangoMax` , `p_escala_preg_categ`.`Estado`  FROM `p_escala_preg_categ`  INNER JOIN  `p_escala_categoria`  ON (`p_escala_preg_categ`.`IdCategoria` = `p_escala_categoria`.`Id`)  INNER JOIN  `p_escala_preguntas`   ON (`p_escala_preg_categ`.`IdPregunta` = `p_escala_preguntas`.`Id`)  ORDER BY `p_escala_categoria`.`Nbre` ASC, `p_escala_preg_categ`.`Orden` ASC;");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JSPOrden.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString())));
        this.JCBPregunta.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        this.JCBCategoria.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        this.JTFFDesde.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())));
        this.JTFFHasta.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString())));
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xEstado = 1L;
        } else {
            this.JCHEstado.setSelected(false);
            this.xEstado = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1L;
        } else {
            this.xEstado = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mGuardar() {
        String sql;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JCBCategoria.getSelectedIndex() != -1) {
                if (this.JCBPregunta.getSelectedIndex() != -1) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        sql = "INSERT INTO  `p_escala_preg_categ`  ( `IdCategoria`, `IdPregunta`, `RangoMin`, `RangoMax`,  `Orden`, `Estado`, `UsuarioS`)  VALUES ('" + this.xcat[this.JCBCategoria.getSelectedIndex()] + "', '" + this.xpreg[this.JCBPregunta.getSelectedIndex()] + "', '" + this.JTFFDesde.getValue() + "', '" + this.JTFFHasta.getValue() + "', '" + this.JSPOrden.getValue() + "', '" + this.xEstado + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    } else {
                        sql = "UPDATE `p_escala_preg_categ` SET  `IdCategoria` = '" + this.xcat[this.JCBCategoria.getSelectedIndex()] + "', `IdPregunta` = '" + this.xpreg[this.JCBPregunta.getSelectedIndex()] + "', `RangoMin` = '" + this.JTFFDesde.getValue() + "', `RangoMax` = '" + this.JTFFHasta.getValue() + "',  `Orden` = '" + this.JSPOrden.getValue() + "', `Estado` = '" + this.xEstado + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE `Id` = '" + Principal.txtNo.getText() + "';";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mCargaDatos();
                    mNuevo();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Seleccione la pregunta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBPregunta.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Seleccione la categoría", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCategoria.requestFocus();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBCategoria.setSelectedIndex(-1);
        this.JCBPregunta.setSelectedIndex(-1);
        this.JTFFDesde.setValue(0);
        this.JTFFHasta.setValue(0);
        this.JSPOrden.setValue(0);
        this.JCHEstado.setSelected(true);
        this.xEstado = 1L;
    }

    private void mIniciaComponentes() {
        this.JCBCategoria.removeAllItems();
        this.xcat = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `p_escala_categoria` WHERE (`Estado` =1) ORDER BY Nbre", this.xcat, this.JCBCategoria);
        this.JCBCategoria.setSelectedIndex(-1);
        this.JCBPregunta.removeAllItems();
        this.xpreg = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `p_escala_preguntas` WHERE (`Estado` =1) ORDER BY Nbre", this.xpreg, this.JCBPregunta);
        this.JCBPregunta.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }
}
