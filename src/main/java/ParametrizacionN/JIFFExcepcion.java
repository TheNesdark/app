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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFExcepcion.class */
public class JIFFExcepcion extends JInternalFrame {
    private String[] xTipoManual;
    private String[] xTipoHonorario;
    private String[] xTipoCirugia;
    private String[] xTipoExcepcion;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private JComboBox JCBTipoCirugia;
    private JComboBox JCBTipoExcepcion;
    private JComboBox JCBTipoHonorario;
    private JComboBox JCBTipoManual;
    private JSpinner JSPDifVia_DifEsp;
    private JSpinner JSPDifVia_IgualEsp;
    private JSpinner JSPIgualVia_DifEsp;
    private JSpinner JSPIgualVia_IgualEsp;
    private JSpinner JSPUnicoBila;
    private JTable JTHistorico;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private boolean xestadog = false;
    private Metodos metodos = new Metodos();

    public JIFFExcepcion() {
        initComponents();
        mIniciarComponentes();
        mCargarDatosTabla();
        mNuevo();
    }

    private void mIniciarComponentes() {
        this.xTipoManual = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre`FROM `q_tipomanualqx`", this.xTipoManual, this.JCBTipoManual);
        this.JCBTipoManual.setSelectedIndex(-1);
        this.xTipoHonorario = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `q_tipohonorario`", this.xTipoHonorario, this.JCBTipoHonorario);
        this.JCBTipoHonorario.setSelectedIndex(-1);
        this.xTipoCirugia = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `q_tipocirugia`", this.xTipoCirugia, this.JCBTipoCirugia);
        this.JCBTipoCirugia.setSelectedIndex(-1);
        this.xTipoExcepcion = this.xconsulta.llenarCombo("SELECT `Id`, `Nbre` FROM `q_tipoexcepcion`", this.xTipoExcepcion, this.JCBTipoExcepcion);
        this.JCBTipoExcepcion.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Tipo Manual", "Tipo Honorario", "Tipo Cirugía", "Tipo Excepción", "Igual Vía - Igual Espec", "Igual Vía - Dif Espec", "Dif Vía - Igual Espec", "Dif Vía - Dif Espec", "Único Bila"}) { // from class: ParametrizacionN.JIFFExcepcion.1
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT   q_tipomanualqx  .  Nbre AS TipoManual ,   q_tipohonorario  .  Nbre AS TipoHonorario  ,   q_tipocirugia  .  Nbre AS TipoCirugia ,   q_tipoexcepcion  .  Nbre AS TipoExcepcion \n    ,   q_excepcion  .  IgualVia_IgualEsp  ,   q_excepcion  .  IgualVia_DifEsp  ,   q_excepcion  .  DifVia_IgualEsp  ,   q_excepcion  .  DifVia_DifEsp  \n    ,   q_excepcion  .  Unico_Bila \nFROM   q_excepcion  \n    INNER JOIN   q_tipomanualqx   \n        ON (  q_excepcion  .  Id_TipoManual   =   q_tipomanualqx  .  Id  )\n    INNER JOIN   q_tipohonorario   \n        ON (  q_excepcion  .  Id_TipoHonorario   =   q_tipohonorario  .  Id  )\n    INNER JOIN   q_tipoexcepcion   \n        ON (  q_excepcion  .  Id_TipoExcepcion   =   q_tipoexcepcion  .  Id  )\n    INNER JOIN   q_tipocirugia   \n        ON (  q_excepcion  .  Id_TipoCirugia   =   q_tipocirugia  .  Id  ) ORDER BY q_tipomanualqx.Nbre ASC, q_excepcion.Id_TipoHonorario ASC,q_excepcion.Id_TipoCirugia ASC ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(5)), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(8)), n, 7);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JCBTipoManual.setSelectedIndex(-1);
        this.JCBTipoHonorario.setSelectedIndex(-1);
        this.JCBTipoCirugia.setSelectedIndex(-1);
        this.JCBTipoExcepcion.setSelectedIndex(-1);
        this.JSPDifVia_DifEsp.setValue(new Integer(0));
        this.JSPDifVia_IgualEsp.setValue(new Integer(0));
        this.JSPIgualVia_DifEsp.setValue(new Integer(0));
        this.JSPIgualVia_IgualEsp.setValue(new Integer(0));
        this.JSPUnicoBila.setValue(new Integer(0));
        this.xestadog = false;
    }

    public void mEliminar() {
        if (this.JTHistorico.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que desea eliminar el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sqlup = "DELETE FROM  q_excepcion WHERE    Id_TipoManual    = '" + this.xTipoManual[this.JCBTipoManual.getSelectedIndex()] + "' AND    Id_TipoHonorario    = '" + this.xTipoHonorario[this.JCBTipoHonorario.getSelectedIndex()] + "' AND    Id_TipoCirugia    = '" + this.xTipoCirugia[this.JCBTipoCirugia.getSelectedIndex()] + "' AND    Id_TipoExcepcion    = '" + this.xTipoExcepcion[this.JCBTipoExcepcion.getSelectedIndex()] + "'";
                this.xconsulta.ejecutarSQL(sqlup);
                this.xconsulta.cerrarConexionBd();
                Principal.txtNo.setText("");
                JOptionPane.showInternalMessageDialog(this, "Se eliminó su registro con Exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (mValidarDatos() == 1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (!this.xestadog) {
                    this.xsql = "INSERT IGNORE INTO q_excepcion ( Id_TipoManual ,Id_TipoHonorario ,Id_TipoCirugia ,Id_TipoExcepcion ,Unico_Bila ,IgualVia_IgualEsp ,IgualVia_DifEsp,DifVia_IgualEsp ,DifVia_DifEsp) VALUES('" + this.xTipoManual[this.JCBTipoManual.getSelectedIndex()] + "','" + this.xTipoHonorario[this.JCBTipoHonorario.getSelectedIndex()] + "','" + this.xTipoCirugia[this.JCBTipoCirugia.getSelectedIndex()] + "','" + this.xTipoExcepcion[this.JCBTipoExcepcion.getSelectedIndex()] + "','" + this.JSPUnicoBila.getValue() + "','" + this.JSPIgualVia_IgualEsp.getValue() + "','" + this.JSPIgualVia_DifEsp.getValue() + "','" + this.JSPDifVia_IgualEsp.getValue() + "','" + this.JSPDifVia_DifEsp.getValue() + "')";
                } else {
                    this.xsql = "UPDATE q_excepcion SET IgualVia_IgualEsp='" + this.JSPIgualVia_IgualEsp.getValue() + "',IgualVia_DifEsp='" + this.JSPIgualVia_DifEsp.getValue() + "',DifVia_IgualEsp='" + this.JSPDifVia_IgualEsp.getValue() + "',DifVia_DifEsp='" + this.JSPDifVia_DifEsp.getValue() + "',Unico_Bila='" + this.JSPUnicoBila.getValue() + "' WHERE    Id_TipoManual    = '" + this.xTipoManual[this.JCBTipoManual.getSelectedIndex()] + "' AND    Id_TipoHonorario    = '" + this.xTipoHonorario[this.JCBTipoHonorario.getSelectedIndex()] + "' AND    Id_TipoCirugia    = '" + this.xTipoCirugia[this.JCBTipoCirugia.getSelectedIndex()] + "' AND    Id_TipoExcepcion    = '" + this.xTipoExcepcion[this.JCBTipoExcepcion.getSelectedIndex()] + "'";
                }
                this.metodos.mostrarMensaje("Datos Guardados Correctamente");
                System.out.println("Consulta-->" + this.xsql);
                this.xconsulta.ejecutarSQL(this.xsql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
            }
        }
    }

    private int mValidarDatos() {
        int retorno = 0;
        if (this.JCBTipoManual.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe seleccionar un Tipo de Manual");
            this.JCBTipoManual.requestFocus();
        } else if (this.JCBTipoHonorario.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe seleccionar un Tipo de Honorario");
            this.JCBTipoHonorario.requestFocus();
        } else if (this.JCBTipoCirugia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe seleccionar un Tipo de Cirugía");
            this.JCBTipoCirugia.requestFocus();
        } else if (this.JCBTipoExcepcion.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe seleccionar un Tipo de Excepción");
            this.JCBTipoExcepcion.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v55, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTipoManual = new JComboBox();
        this.JCBTipoHonorario = new JComboBox();
        this.JCBTipoCirugia = new JComboBox();
        this.JCBTipoExcepcion = new JComboBox();
        this.JSPUnicoBila = new JSpinner();
        this.jLabel1 = new JLabel();
        this.JSPIgualVia_DifEsp = new JSpinner();
        this.jLabel2 = new JLabel();
        this.JSPDifVia_DifEsp = new JSpinner();
        this.jLabel3 = new JLabel();
        this.JSPDifVia_IgualEsp = new JSpinner();
        this.jLabel4 = new JLabel();
        this.JSPIgualVia_IgualEsp = new JSpinner();
        this.jLabel5 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXCEPCIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Excepción");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoManual.setFont(new Font("Arial", 1, 12));
        this.JCBTipoManual.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Manual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoHonorario.setFont(new Font("Arial", 1, 12));
        this.JCBTipoHonorario.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Honorario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoCirugia.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cirugía", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoExcepcion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoExcepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Excepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoExcepcion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFExcepcion.2
            public void actionPerformed(ActionEvent evt) {
                JIFFExcepcion.this.JCBTipoExcepcionActionPerformed(evt);
            }
        });
        this.JSPUnicoBila.setFont(new Font("Arial", 1, 12));
        this.JSPUnicoBila.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.blue);
        this.jLabel1.setText("Único Bilateral");
        this.JSPIgualVia_DifEsp.setFont(new Font("Arial", 1, 12));
        this.JSPIgualVia_DifEsp.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(Color.blue);
        this.jLabel2.setText("Igual Vía - Diferente Especialidad");
        this.JSPDifVia_DifEsp.setFont(new Font("Arial", 1, 12));
        this.JSPDifVia_DifEsp.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setText("Diferente Vía - Diferente Especialidad");
        this.JSPDifVia_IgualEsp.setFont(new Font("Arial", 1, 12));
        this.JSPDifVia_IgualEsp.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("Diferente Vía - Igual Especialidad");
        this.JSPIgualVia_IgualEsp.setFont(new Font("Arial", 1, 12));
        this.JSPIgualVia_IgualEsp.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("Igual Vía - Igual Especialidad");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDifVia_IgualEsp, -2, 77, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDifVia_DifEsp, -2, 77, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPUnicoBila, -2, 82, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPIgualVia_IgualEsp, -2, 77, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPIgualVia_DifEsp, -2, 77, -2).addGap(0, 0, 32767)))).addComponent(this.JCBTipoCirugia, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBTipoManual, GroupLayout.Alignment.LEADING, 0, -1, 32767)).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoHonorario, 0, 370, 32767).addComponent(this.JCBTipoExcepcion, 0, -1, 32767)))).addGap(10, 10, 10)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoManual, -2, 50, -2).addComponent(this.JCBTipoHonorario, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoCirugia, -2, 50, -2).addComponent(this.JCBTipoExcepcion, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPUnicoBila, -2, 48, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5, -2, 30, -2).addComponent(this.JSPIgualVia_IgualEsp, -2, 40, -2).addComponent(this.jLabel3, -2, 30, -2).addComponent(this.JSPDifVia_DifEsp, -2, 42, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPIgualVia_DifEsp, -2, 40, -2).addComponent(this.jLabel2, -2, 30, -2)).addComponent(this.jLabel4, -2, 30, -2).addComponent(this.JSPDifVia_IgualEsp)))).addContainerGap(18, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFExcepcion.3
            public void mouseClicked(MouseEvent evt) {
                JIFFExcepcion.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addComponent(this.jScrollPane1, -2, 785, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 191, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        mSeleccionTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoExcepcionActionPerformed(ActionEvent evt) {
    }

    private void mSeleccionTabla() {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JCBTipoManual.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.JCBTipoHonorario.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString());
            this.JCBTipoCirugia.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString());
            this.JCBTipoExcepcion.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString());
            this.JSPIgualVia_IgualEsp.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()));
            this.JSPIgualVia_DifEsp.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()));
            this.JSPDifVia_IgualEsp.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString()));
            this.JSPDifVia_DifEsp.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString()));
            this.JSPUnicoBila.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString()));
        }
        this.xestadog = true;
    }
}
