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
import java.beans.PropertyVetoException;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFSMovimientoxBodega.class */
public class JIFSMovimientoxBodega extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidbodega;
    private ButtonGroup JBGTipoMov;
    private JCheckBox JCHAfectaCosto;
    private JCheckBox JCHDespacho;
    private JCheckBox JCHEsInvIni;
    private JCheckBox JCHEstado;
    private JCheckBox JCHGeneraFaltante;
    private JCheckBox JCHRDRecepcion;
    private JCheckBox JCHSalidaxFormula;
    private JCheckBox JCHTraslado;
    private JPanel JPICuentasC;
    private JPanel JPIDatos;
    private JPanel JPITipoMov;
    private JPanel JPI_Salida;
    private JPanel JPI_Salida1;
    private JRadioButton JRBEntrada;
    private JRadioButton JRBSalida;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCredito;
    private JTextField JTFDebito;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;
    private int xafectacosto = 0;
    private int xsalidaxformula = 0;
    private int xtipomovimiento = 0;
    private int xgenerafaltante = 0;
    private int xdespacho = 0;
    private int xtraslado = 0;
    private int xdatosadicionalesr = 0;
    private int xesinvini = 0;
    private String xid = "";
    private String xCuentaEquivocada = "";
    private boolean xestadog = false;

    public JIFSMovimientoxBodega() {
        initComponents();
        mCargarDatosTabla();
        mActivar_Desactivar(0);
        if ("0".equals(mValidarCuentasContable(Principal.txtNo.getText()))) {
            this.JTFDebito.setEnabled(false);
            this.JTFCredito.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r3v109, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoMov = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JPITipoMov = new JPanel();
        this.JRBEntrada = new JRadioButton();
        this.JRBSalida = new JRadioButton();
        this.JCHEstado = new JCheckBox();
        this.JPICuentasC = new JPanel();
        this.JTFDebito = new JTextField();
        this.JTFCredito = new JTextField();
        this.JPI_Salida = new JPanel();
        this.JCHSalidaxFormula = new JCheckBox();
        this.JCHTraslado = new JCheckBox();
        this.JCHDespacho = new JCheckBox();
        this.JCHGeneraFaltante = new JCheckBox();
        this.JPI_Salida1 = new JPanel();
        this.JCHAfectaCosto = new JCheckBox();
        this.JCHRDRecepcion = new JCheckBox();
        this.JCHEsInvIni = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MOVIMIENTO POR BODEGA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmovimientosbodega");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipoMov.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGTipoMov.add(this.JRBEntrada);
        this.JRBEntrada.setFont(new Font("Arial", 1, 12));
        this.JRBEntrada.setText("Entrada");
        this.JRBEntrada.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.1
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JRBEntradaActionPerformed(evt);
            }
        });
        this.JBGTipoMov.add(this.JRBSalida);
        this.JRBSalida.setFont(new Font("Arial", 1, 12));
        this.JRBSalida.setText("Salida");
        this.JRBSalida.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.2
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JRBSalidaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoMovLayout = new GroupLayout(this.JPITipoMov);
        this.JPITipoMov.setLayout(JPITipoMovLayout);
        JPITipoMovLayout.setHorizontalGroup(JPITipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMovLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEntrada).addGap(18, 18, 18).addComponent(this.JRBSalida).addContainerGap()));
        JPITipoMovLayout.setVerticalGroup(JPITipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoMovLayout.createSequentialGroup().addGroup(JPITipoMovLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEntrada).addComponent(this.JRBSalida)).addContainerGap()));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.3
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPICuentasC.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Contables", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFDebito.setFont(new Font("Arial", 1, 12));
        this.JTFDebito.setToolTipText("");
        this.JTFDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCredito.setFont(new Font("Arial", 1, 13));
        this.JTFCredito.setToolTipText("");
        this.JTFCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasCLayout = new GroupLayout(this.JPICuentasC);
        this.JPICuentasC.setLayout(JPICuentasCLayout);
        JPICuentasCLayout.setHorizontalGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebito, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCredito, -2, 117, -2).addContainerGap()));
        JPICuentasCLayout.setVerticalGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasCLayout.createSequentialGroup().addGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebito, -2, -1, -2).addComponent(this.JTFCredito, -2, -1, -2)).addContainerGap()));
        this.JPI_Salida.setBorder(BorderFactory.createTitledBorder((Border) null, "SALIDA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHSalidaxFormula.setFont(new Font("Arial", 1, 12));
        this.JCHSalidaxFormula.setText("Salida por Formula");
        this.JCHSalidaxFormula.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.4
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHSalidaxFormulaActionPerformed(evt);
            }
        });
        this.JCHTraslado.setFont(new Font("Arial", 1, 12));
        this.JCHTraslado.setText("Traslado?");
        this.JCHTraslado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.5
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHTrasladoActionPerformed(evt);
            }
        });
        this.JCHDespacho.setFont(new Font("Arial", 1, 12));
        this.JCHDespacho.setText("Despacho?");
        this.JCHDespacho.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.6
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHDespachoActionPerformed(evt);
            }
        });
        this.JCHGeneraFaltante.setFont(new Font("Arial", 1, 12));
        this.JCHGeneraFaltante.setText("Genera Faltante?");
        this.JCHGeneraFaltante.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.7
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHGeneraFaltanteActionPerformed(evt);
            }
        });
        GroupLayout JPI_SalidaLayout = new GroupLayout(this.JPI_Salida);
        this.JPI_Salida.setLayout(JPI_SalidaLayout);
        JPI_SalidaLayout.setHorizontalGroup(JPI_SalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SalidaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_SalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SalidaLayout.createSequentialGroup().addComponent(this.JCHSalidaxFormula).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHDespacho)).addGroup(JPI_SalidaLayout.createSequentialGroup().addComponent(this.JCHTraslado).addGap(18, 18, 18).addComponent(this.JCHGeneraFaltante)))));
        JPI_SalidaLayout.setVerticalGroup(JPI_SalidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SalidaLayout.createSequentialGroup().addGroup(JPI_SalidaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSalidaxFormula).addComponent(this.JCHDespacho)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addGroup(JPI_SalidaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHTraslado).addComponent(this.JCHGeneraFaltante)).addContainerGap()));
        this.JPI_Salida1.setBorder(BorderFactory.createTitledBorder((Border) null, "ENTRADA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHAfectaCosto.setFont(new Font("Arial", 1, 12));
        this.JCHAfectaCosto.setText("Afecta Costo?");
        this.JCHAfectaCosto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.8
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHAfectaCostoActionPerformed(evt);
            }
        });
        this.JCHRDRecepcion.setFont(new Font("Arial", 1, 12));
        this.JCHRDRecepcion.setText("R.Datos Recepción?");
        this.JCHRDRecepcion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.9
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHRDRecepcionActionPerformed(evt);
            }
        });
        GroupLayout JPI_Salida1Layout = new GroupLayout(this.JPI_Salida1);
        this.JPI_Salida1.setLayout(JPI_Salida1Layout);
        JPI_Salida1Layout.setHorizontalGroup(JPI_Salida1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Salida1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Salida1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAfectaCosto).addComponent(this.JCHRDRecepcion)).addContainerGap(-1, 32767)));
        JPI_Salida1Layout.setVerticalGroup(JPI_Salida1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Salida1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHAfectaCosto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2, 32767).addComponent(this.JCHRDRecepcion).addContainerGap()));
        this.JCHEsInvIni.setFont(new Font("Arial", 1, 12));
        this.JCHEsInvIni.setText("Es Inventario Inicial?");
        this.JCHEsInvIni.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFSMovimientoxBodega.10
            public void actionPerformed(ActionEvent evt) {
                JIFSMovimientoxBodega.this.JCHEsInvIniActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTFNombre, -2, 478, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPITipoMov, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEsInvIni)).addGap(10, 10, 10)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Salida, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPI_Salida1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPICuentasC, -2, -1, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHEsInvIni).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JPITipoMov, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Salida, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPI_Salida1, -2, -1, -2).addComponent(this.JPICuentasC, -2, -1, -2)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFSMovimientoxBodega.11
            public void mouseClicked(MouseEvent evt) {
                JIFSMovimientoxBodega.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 381, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).intValue() == 0) {
                this.JRBEntrada.setSelected(true);
                this.xtipomovimiento = 0;
                mActivar_Desactivar(1);
            } else {
                this.JRBSalida.setSelected(true);
                this.xtipomovimiento = 1;
                mActivar_Desactivar(2);
            }
            this.JCHAfectaCosto.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JCHSalidaxFormula.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCHGeneraFaltante.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JCHTraslado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            this.JCHDespacho.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            this.JTFDebito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString());
            this.JTFCredito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString());
            this.JCHRDRecepcion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()).booleanValue());
            this.JCHEsInvIni.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()).booleanValue());
            mIniciarCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAfectaCostoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSalidaxFormulaActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHGeneraFaltanteActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDespachoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntradaActionPerformed(ActionEvent evt) {
        this.xtipomovimiento = 0;
        mActivar_Desactivar(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSalidaActionPerformed(ActionEvent evt) {
        this.xtipomovimiento = 1;
        mActivar_Desactivar(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTrasladoActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRDRecepcionActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsInvIniActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    private void mActivar_Desactivar(int x) {
        if (x == 0) {
            this.JCHAfectaCosto.setEnabled(false);
            this.JCHGeneraFaltante.setEnabled(false);
            this.JCHDespacho.setEnabled(false);
            this.JCHSalidaxFormula.setEnabled(false);
            this.JCHTraslado.setEnabled(false);
            this.JCHRDRecepcion.setEnabled(false);
            return;
        }
        if (x == 1) {
            this.JCHAfectaCosto.setEnabled(true);
            this.JCHRDRecepcion.setEnabled(true);
            this.JCHGeneraFaltante.setEnabled(false);
            this.JCHDespacho.setEnabled(false);
            this.JCHSalidaxFormula.setEnabled(false);
            this.JCHTraslado.setEnabled(false);
            return;
        }
        if (x == 2) {
            this.JCHGeneraFaltante.setEnabled(true);
            this.JCHDespacho.setEnabled(true);
            this.JCHSalidaxFormula.setEnabled(true);
            this.JCHTraslado.setEnabled(true);
            this.JCHAfectaCosto.setEnabled(false);
            this.JCHRDRecepcion.setEnabled(false);
        }
    }

    public void mNuevo() {
        this.xid = "";
        this.JTFNombre.setText("");
        this.JCHAfectaCosto.setSelected(false);
        this.JCHGeneraFaltante.setSelected(false);
        this.JCHDespacho.setSelected(false);
        this.JCHSalidaxFormula.setSelected(false);
        this.JCHTraslado.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JCHRDRecepcion.setSelected(false);
        this.JRBEntrada.setSelected(true);
        this.JCHEsInvIni.setSelected(false);
        this.JTFDebito.setText("");
        this.JTFCredito.setText("");
        this.xtipomovimiento = 0;
        mCargarDatosTabla();
        mIniciarCheck();
        mActivar_Desactivar(0);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        String sql;
        String sql2;
        if ("0".equals(mValidarCuentasContable(Principal.txtNo.getText()))) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.xid.isEmpty()) {
                        sql2 = " Insert into i_tiposmovimientos(Nbre, TipoMovimiento, Bodega, AfectaCosto, SalidaPorFormula, Faltante, Traslado, Despacho, RDatosAdicionales, CPuc_Debito, CPuc_Credito, EsInventarioIncial, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xtipomovimiento + "','" + Principal.txtNo.getText() + "','" + this.xafectacosto + "','" + this.xsalidaxformula + "','" + this.xgenerafaltante + "','" + this.xtraslado + "','" + this.xdespacho + "','" + this.xdatosadicionalesr + "','" + this.JTFDebito.getText() + "','" + this.JTFCredito.getText() + "','" + this.xesinvini + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        sql2 = " update i_tiposmovimientos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',TipoMovimiento='" + this.xtipomovimiento + "', AfectaCosto='" + this.xafectacosto + "',SalidaPorFormula='" + this.xsalidaxformula + "',Faltante='" + this.xgenerafaltante + "', Traslado='" + this.xtraslado + "',Despacho='" + this.xdespacho + "',RDatosAdicionales='" + this.xdatosadicionalesr + "', CPuc_Debito ='" + this.JTFDebito.getText() + "',CPuc_Credito='" + this.JTFCredito.getText() + "',EsInventarioIncial='" + this.xesinvini + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "' and Bodega='" + Principal.txtNo.getText() + "'";
                    }
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!mVerificaUltNivel(this.JTFDebito.getText().trim())) {
                if (!mVerificaUltNivel(this.JTFCredito.getText().trim())) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        if (this.xid.isEmpty()) {
                            sql = " Insert into i_tiposmovimientos(Nbre, TipoMovimiento, Bodega, AfectaCosto, SalidaPorFormula, Faltante, Traslado, Despacho, RDatosAdicionales, CPuc_Debito, CPuc_Credito, EsInventarioIncial, Estado, Fecha, UsuarioS)  values ('" + this.JTFNombre.getText().toUpperCase() + "','" + this.xtipomovimiento + "','" + Principal.txtNo.getText() + "','" + this.xafectacosto + "','" + this.xsalidaxformula + "','" + this.xgenerafaltante + "','" + this.xtraslado + "','" + this.xdespacho + "','" + this.xdatosadicionalesr + "','" + this.JTFDebito.getText() + "','" + this.JTFCredito.getText() + "','" + this.xesinvini + "','" + this.xestado + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            sql = " update i_tiposmovimientos set Nbre='" + this.JTFNombre.getText().toUpperCase() + "',TipoMovimiento='" + this.xtipomovimiento + "', AfectaCosto='" + this.xafectacosto + "',SalidaPorFormula='" + this.xsalidaxformula + "',Faltante='" + this.xgenerafaltante + "', Traslado='" + this.xtraslado + "',Despacho='" + this.xdespacho + "',RDatosAdicionales='" + this.xdatosadicionalesr + "', CPuc_Debito ='" + this.JTFDebito.getText() + "',CPuc_Credito='" + this.JTFCredito.getText() + "',EsInventarioIncial='" + this.xesinvini + "',Estado='" + this.xestado + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.xid + "' and Bodega='" + Principal.txtNo.getText() + "'";
                        }
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "El Codigo PUC " + this.xCuentaEquivocada + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "El Codigo PUC " + this.xCuentaEquivocada + " NO es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Movimiento", "", "Afecta Costo?", "Salida x Formula", "Genera Faltante?", "Traslado?", "Despacho?", "Estado", "", "Debito", "Credito", "DAdiconaleRecepcion", "Inventario Inicial?"}) { // from class: ParametrizacionN.JIFSMovimientoxBodega.12
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT i_tiposmovimientos.Id, IF(i_tiposmovimientos.TipoMovimiento=0,'ENTRADA','SALIDA') AS NTipoMovimiento, i_tiposmovimientos.Nbre , i_tiposmovimientos.TipoMovimiento, i_tiposmovimientos.AfectaCosto, i_tiposmovimientos.SalidaPorFormula, i_tiposmovimientos.Faltante, i_tiposmovimientos.Traslado, i_tiposmovimientos.Despacho, i_tiposmovimientos.Estado, i_bodegas.Nbre, i_tiposmovimientos.CPuc_Debito, i_tiposmovimientos.CPuc_Credito, i_tiposmovimientos.RDatosAdicionales, i_tiposmovimientos.EsInventarioIncial FROM baseserver.i_tiposmovimientos INNER JOIN baseserver.i_bodegas  ON (i_tiposmovimientos.Bodega = i_bodegas.Id) WHERE (i_bodegas.Id ='" + Principal.txtNo.getText() + "') ORDER BY i_tiposmovimientos.TipoMovimiento ASC, i_tiposmovimientos.Nbre ASC ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(14)), n, 13);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(15)), n, 14);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSPresentacionFarmaceuta.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciarCheck() {
        if (this.JCHAfectaCosto.isSelected()) {
            this.xafectacosto = 1;
        } else {
            this.xafectacosto = 0;
        }
        if (this.JCHSalidaxFormula.isSelected()) {
            this.xsalidaxformula = 1;
        } else {
            this.xsalidaxformula = 0;
        }
        if (this.JCHGeneraFaltante.isSelected()) {
            this.xgenerafaltante = 1;
        } else {
            this.xgenerafaltante = 0;
        }
        if (this.JCHDespacho.isSelected()) {
            this.xdespacho = 1;
        } else {
            this.xdespacho = 0;
        }
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
        if (this.JCHTraslado.isSelected()) {
            this.xtraslado = 1;
        } else {
            this.xtraslado = 0;
        }
        if (this.JCHRDRecepcion.isSelected()) {
            this.xdatosadicionalesr = 1;
        } else {
            this.xdatosadicionalesr = 0;
        }
        if (this.JCHEsInvIni.isSelected()) {
            this.xesinvini = 1;
        } else {
            this.xesinvini = 0;
        }
    }

    private boolean mVerificaUltNivel(String xcampo) {
        boolean xOk = false;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            String sql = "SELECT `Id`,`UNivel` FROM `cc_puc` WHERE Id='" + xcampo + "'";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getInt("UNivel") == 0) {
                        xOk = true;
                        this.xCuentaEquivocada = xrs.getString("Id");
                        break;
                    }
                }
                xrs.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFSMovimientoxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xOk;
    }

    private String mValidarCuentasContable(String dato) {
        String sqls = "SELECT `Contabilidad` FROM `i_bodegas` WHERE (`Id` ='" + dato + "');";
        System.out.println(sqls);
        ConsultasMySQL xct = new ConsultasMySQL();
        String xv = xct.traerDato(sqls);
        xct.cerrarConexionBd();
        return xv;
    }
}
