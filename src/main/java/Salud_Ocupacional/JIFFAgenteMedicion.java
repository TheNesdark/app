package Salud_Ocupacional;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFFAgenteMedicion.class */
public class JIFFAgenteMedicion extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo2;
    public Object[] xdatos;
    private String[] xIdSEG;
    private String[] xIdPeriodo;
    private String[] xIdSEGFiltro;
    private JButton JBActualizar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBseg;
    private JComboBox JCBsegFiltro;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFiltroTabla;
    private JCheckBox JCHPeriodo;
    public JTextArea JTAObservacion;
    public JTable JTDetalle;
    private JTextField JTFNombre;
    private JTable JTHistorico;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    public int xfila = 0;
    private int xestado = 1;

    public JIFFAgenteMedicion() {
        initComponents();
        mIniciaCombos();
        mCrearModeloDetalle();
        mBuscaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v96, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JTFNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCHEstado = new JCheckBox();
        this.JCHPeriodo = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.JCBseg = new JComboBox();
        this.jButton1 = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCBsegFiltro = new JComboBox();
        this.JCHFiltroTabla = new JCheckBox();
        this.JBActualizar = new JButton();
        this.jPanel4 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE VALORES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifMedicionSEG");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFAgenteMedicion.this.formInternalFrameClosing(evt);
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
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFAgenteMedicion.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.3
            public void actionPerformed(ActionEvent evt) {
                JIFFAgenteMedicion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCHPeriodo.setText("+");
        this.JCHPeriodo.setToolTipText("Periodos Antiguos");
        this.JCHPeriodo.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.4
            public void actionPerformed(ActionEvent evt) {
                JIFFAgenteMedicion.this.JCHPeriodoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHPeriodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, -1, -2).addComponent(this.JTFNombre, -2, -1, -2)).addComponent(this.JCHEstado).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHPeriodo))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 61, -2)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBseg.setFont(new Font("Arial", 1, 12));
        this.JCBseg.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBseg.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.5
            public void itemStateChanged(ItemEvent evt) {
                JIFFAgenteMedicion.this.JCBsegItemStateChanged(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.jButton1.setText("Seleccione Agentes");
        this.jButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.6
            public void actionPerformed(ActionEvent evt) {
                JIFFAgenteMedicion.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCBseg, -2, 484, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBseg, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.jButton1, -1, -1, 32767)).addGap(3, 3, 3)));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.7
            public void keyPressed(KeyEvent evt) {
                JIFFAgenteMedicion.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalle);
        this.JCBsegFiltro.setFont(new Font("Arial", 1, 12));
        this.JCBsegFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBsegFiltro.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.8
            public void itemStateChanged(ItemEvent evt) {
                JIFFAgenteMedicion.this.JCBsegFiltroItemStateChanged(evt);
            }
        });
        this.JCHFiltroTabla.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroTabla.setText("Filtrar tabla");
        this.JCHFiltroTabla.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.9
            public void actionPerformed(ActionEvent evt) {
                JIFFAgenteMedicion.this.JCHFiltroTablaActionPerformed(evt);
            }
        });
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBActualizar.setText("Actualizar Valores");
        this.JBActualizar.setToolTipText("Actualiza OEL y TLV");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.10
            public void actionPerformed(ActionEvent evt) {
                JIFFAgenteMedicion.this.JBActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING, -1, 727, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBsegFiltro, -2, 273, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltroTabla).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBActualizar, -1, -1, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 336, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBActualizar, GroupLayout.Alignment.TRAILING, -2, 43, -2).addComponent(this.JCBsegFiltro, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JCHFiltroTabla, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        this.jTabbedPane1.addTab("DATOS", this.jPanel2);
        this.jScrollPane4.setBorder((Border) null);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFFAgenteMedicion.11
            public void mouseClicked(MouseEvent evt) {
                JIFFAgenteMedicion.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane4.setViewportView(this.JTHistorico);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 717, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane4, -1, 607, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel4);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jTabbedPane1).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBsegItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPeriodoActionPerformed(ActionEvent evt) {
        String sql2;
        if (!this.JCHPeriodo.isSelected()) {
            sql2 = "SELECT `Id`, `Nbre`, `FechaI`, `FechaF` FROM `cc_periodo_financiero` WHERE Estado=1";
        } else {
            sql2 = "SELECT `Id`, `Nbre`, `FechaI`, `FechaF` FROM `cc_periodo_financiero`";
        }
        this.JCBPeriodo.removeAllItems();
        this.xIdPeriodo = this.xct.llenarCombo(sql2, this.xIdPeriodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        this.JCBPeriodo.setSelectedIndex(0);
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
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBPeriodo.setSelectedItem(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JTAObservacion.setText(this.xmodelo2.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            mBuscaDetalle();
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            if (!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la Fila?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se puede eliminar\nRegistro se encuentra Grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JCBseg.getSelectedIndex() > -1) {
            JDAgentes xWin = new JDAgentes(null, true, this.JCBseg.getSelectedItem().toString(), this.xIdSEG[this.JCBseg.getSelectedIndex()], this);
            xWin.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un SEG", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBsegFiltroItemStateChanged(ItemEvent evt) {
        if (this.JCBsegFiltro.getSelectedIndex() > -1 && this.JCHFiltroTabla.isSelected()) {
            mBuscaDetalleFiltro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroTablaActionPerformed(ActionEvent evt) {
        if (this.JCBsegFiltro.getSelectedIndex() > -1) {
            if (this.JCHFiltroTabla.isSelected()) {
                mBuscaDetalleFiltro();
                return;
            } else {
                this.JCBsegFiltro.setSelectedIndex(-1);
                mBuscaDetalle();
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un SEG para Filtrar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCHFiltroTabla.setSelected(false);
        this.JCBsegFiltro.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 5).toString()).booleanValue()) {
                    String sql1 = "UPDATE  `so_pe_edetalle` SET  `Valor` = '" + this.xmodelo.getValueAt(i, 2) + "',   `TLV` = '" + this.xmodelo.getValueAt(i, 3) + "', `Observacion` = '" + this.xmodelo.getValueAt(i, 4) + "' WHERE `Id_PEncabezado` = '" + Principal.txtNo.getText() + "'  AND `Id_Seg_Agente` = '" + this.xmodelo.getValueAt(i, 0) + "';";
                    this.xct.ejecutarSQL(sql1);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Periodo", "Nombre", "Observación"}) { // from class: Salud_Ocupacional.JIFFAgenteMedicion.12
            Class[] types = {Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo2);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(220);
    }

    private void mBuscaHistorico() {
        mModeloHistorico();
        ResultSet xrs = this.xct.traerRs(" SELECT `so_pe_encabezado`.`Id` , `cc_periodo_financiero`.`Nbre` , `so_pe_encabezado`.`Nbre` , `so_pe_encabezado`.`Observacion`  FROM `so_pe_encabezado` INNER JOIN `cc_periodo_financiero` ON (`so_pe_encabezado`.`Id_PeriodoF` = `cc_periodo_financiero`.`Id`)  WHERE (`so_pe_encabezado`.`Estado` =1)");
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdatos);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAgenteMedicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaRepetido() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            System.out.println(this.xIdSEG[this.JCBseg.getSelectedIndex()] + "-->" + this.xmodelo.getValueAt(i, 0));
            if (!this.xIdSEG[this.JCBseg.getSelectedIndex()].equals(this.xmodelo.getValueAt(i, 0).toString())) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "SEG x Agente", "OEL", "TLV", "Observación", "√"}) { // from class: Salud_Ocupacional.JIFFAgenteMedicion.13
            Class[] types = {Integer.class, String.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(12);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(12);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(220);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(2);
    }

    private void mIniciaCombos() {
        this.xIdSEG = this.xct.llenarCombo("SELECT `so_tipo_segmento`.`Id`, `so_tipo_segmento`.`Nbre` \nFROM `baseserver`.`so_tipo_seg_tipogente` INNER JOIN `baseserver`.`so_tipo_segmento` ON (`so_tipo_seg_tipogente`.`Id_Seg` = `so_tipo_segmento`.`Id`)\nINNER JOIN `baseserver`.`so_tipo_agentes` ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`)\nWHERE (`so_tipo_seg_tipogente`.`Estado` =1) group by so_tipo_segmento.Id order by `so_tipo_segmento`.`Nbre` ASC;", this.xIdSEG, this.JCBseg);
        this.xIdSEGFiltro = this.xct.llenarCombo("SELECT `so_tipo_segmento`.`Id`, `so_tipo_segmento`.`Nbre` \nFROM `baseserver`.`so_tipo_seg_tipogente` INNER JOIN `baseserver`.`so_tipo_segmento` ON (`so_tipo_seg_tipogente`.`Id_Seg` = `so_tipo_segmento`.`Id`)\nINNER JOIN `baseserver`.`so_tipo_agentes` ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`)\nWHERE (`so_tipo_seg_tipogente`.`Estado` =1) group by so_tipo_segmento.Id order by `so_tipo_segmento`.`Nbre` ASC;", this.xIdSEGFiltro, this.JCBsegFiltro);
        this.xct.cerrarConexionBd();
        this.JCBseg.setSelectedIndex(-1);
        this.JCBsegFiltro.setSelectedIndex(-1);
        this.xIdPeriodo = this.xct.llenarCombo("SELECT `Id`, `Nbre`, `FechaI`, `FechaF` FROM `cc_periodo_financiero` WHERE Estado=1", this.xIdPeriodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        this.JCBPeriodo.setSelectedIndex(0);
    }

    public void mNuevo() {
        this.JCBPeriodo.setSelectedIndex(-1);
        this.JTFNombre.setText("");
        this.JTAObservacion.setText("");
        this.JCBseg.setSelectedIndex(-1);
        for (int i = this.JTDetalle.getRowCount() - 1; i >= 0; i--) {
            this.xmodelo.removeRow(i);
            this.xfila = 0;
        }
        Principal.mLimpiarDatosP();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > 0) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        String sql1 = "INSERT INTO `so_pe_encabezado` (`Id_PeriodoF`,`Nbre`,`Observacion`,`Estado`, `UsuarioS`)\nVALUES ( '" + this.xIdPeriodo[this.JCBPeriodo.getSelectedIndex()] + "', '" + this.JTFNombre.getText() + "', '" + this.JTAObservacion.getText() + "', '" + this.xestado + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(sql1));
                        this.xct.cerrarConexionBd();
                        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                            if (!Boolean.valueOf(this.xmodelo.getValueAt(i, 5).toString()).booleanValue()) {
                                String sql2 = "INSERT INTO  `so_pe_edetalle` (`Id_PEncabezado`,  `Id_Seg_Agente`, `Valor`,TLV, `Observacion`)\nVALUES ('" + Principal.txtNo.getText() + "',  '" + this.xmodelo.getValueAt(i, 0) + "', '" + this.xmodelo.getValueAt(i, 2) + "','" + this.xmodelo.getValueAt(i, 3) + "', '" + this.xmodelo.getValueAt(i, 4) + "')";
                                this.xct.ejecutarSQL(sql2);
                                this.xct.cerrarConexionBd();
                            }
                        }
                    } else {
                        for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                            if (!Boolean.valueOf(this.xmodelo.getValueAt(i2, 5).toString()).booleanValue()) {
                                String sql22 = "INSERT INTO  `so_pe_edetalle` (`Id_PEncabezado`,  `Id_Seg_Agente`, `Valor`, TLV, `Observacion`)\nVALUES ('" + Principal.txtNo.getText() + "',  '" + this.xmodelo.getValueAt(i2, 0) + "', '" + this.xmodelo.getValueAt(i2, 2) + "','" + this.xmodelo.getValueAt(i2, 3) + "', '" + this.xmodelo.getValueAt(i2, 4) + "')";
                                this.xct.ejecutarSQL(sql22);
                                this.xct.cerrarConexionBd();
                            }
                        }
                    }
                    mBuscaDetalle();
                    mBuscaHistorico();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Agregar mediciones a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe escribir un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    private void mBuscaDetalle() {
        mCrearModeloDetalle();
        String sql = "SELECT `so_pe_edetalle`.`Id_Seg_Agente`, CONCAT(`so_tipo_segmento`.`Nbre` ,' - ' ,`so_tipo_agentes`.`Nbre`) AS seg_x_agente\n    , `so_pe_edetalle`.`Valor`,`so_pe_edetalle`.`TLV`, `so_pe_edetalle`.`Observacion`, `so_pe_edetalle`.`guardado`\n FROM `so_pe_edetalle`INNER JOIN `so_tipo_seg_tipogente` ON (`so_pe_edetalle`.`Id_Seg_Agente` = `so_tipo_seg_tipogente`.`Id`)\n    INNER JOIN `so_tipo_segmento` ON (`so_tipo_seg_tipogente`.`Id_Seg` = `so_tipo_segmento`.`Id`)INNER JOIN `so_tipo_agentes` \n        ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`) WHERE (`so_pe_edetalle`.`Estado` =1 AND `so_pe_edetalle`.`Id_PEncabezado` ='" + Principal.txtNo.getText() + "' ) ORDER BY CONCAT(`so_tipo_segmento`.`Nbre` ,' - ' ,`so_tipo_agentes`.`Nbre`)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xfila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), this.xfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), this.xfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), this.xfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), this.xfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), this.xfila, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), this.xfila, 5);
                    this.xfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAgenteMedicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaDetalleFiltro() {
        mCrearModeloDetalle();
        String sql = "SELECT `so_pe_edetalle`.`Id_Seg_Agente`, CONCAT(`so_tipo_segmento`.`Nbre` ,' - ' ,`so_tipo_agentes`.`Nbre`) AS seg_x_agente\n    , `so_pe_edetalle`.`Valor`,`so_pe_edetalle`.`TLV`, `so_pe_edetalle`.`Observacion`, `so_pe_edetalle`.`guardado`\n FROM `so_pe_edetalle`INNER JOIN `so_tipo_seg_tipogente` ON (`so_pe_edetalle`.`Id_Seg_Agente` = `so_tipo_seg_tipogente`.`Id`)\n    INNER JOIN `so_tipo_segmento` ON (`so_tipo_seg_tipogente`.`Id_Seg` = `so_tipo_segmento`.`Id`)INNER JOIN `so_tipo_agentes` \n        ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`) WHERE (`so_pe_edetalle`.`Estado` =1 AND `so_pe_edetalle`.`Id_PEncabezado` ='" + Principal.txtNo.getText() + "' AND so_tipo_seg_tipogente.Id_Seg='" + this.xIdSEGFiltro[this.JCBsegFiltro.getSelectedIndex()] + "') ORDER BY CONCAT(`so_tipo_segmento`.`Nbre` ,' - ' ,`so_tipo_agentes`.`Nbre`)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xfila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), this.xfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), this.xfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), this.xfila, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), this.xfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), this.xfila, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), this.xfila, 5);
                    this.xfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAgenteMedicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
