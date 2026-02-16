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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFConceptoPagoGlosa.class */
public class JIFFConceptoPagoGlosa extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xtipo = -1;
    private int xcompleto = 0;
    private int visualizar014 = 1;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup JBGTipo;
    private JCheckBox JCHCompleto;
    private JCheckBox JCHEstado;
    private JCheckBox JCHVisualizar;
    private JPanel JPICuentasC;
    private JPanel JPIDatos;
    private JPanel JPITipo;
    private JRadioButton JRBDevolucion;
    private JRadioButton JRBGlosa;
    private JRadioButton JRBPago;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFConcepto;
    private JTextField JTFCredito;
    private JTextField JTFDebito;

    public JIFFConceptoPagoGlosa() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFConcepto = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPICuentasC = new JPanel();
        this.JTFDebito = new JTextField();
        this.JTFCredito = new JTextField();
        this.JPITipo = new JPanel();
        this.JRBPago = new JRadioButton();
        this.JRBGlosa = new JRadioButton();
        this.JRBDevolucion = new JRadioButton();
        this.JCHCompleto = new JCheckBox();
        this.JCHVisualizar = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCEPTO DE PAGO O GLOSA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconceptopagoglosa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFConceptoPagoGlosa.this.formInternalFrameClosing(evt);
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
        this.JTFConcepto.setFont(new Font("Arial", 1, 12));
        this.JTFConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.2
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPICuentasC.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Contables", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFDebito.setFont(new Font("Arial", 1, 12));
        this.JTFDebito.setToolTipText("");
        this.JTFDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCredito.setFont(new Font("Arial", 1, 12));
        this.JTFCredito.setToolTipText("");
        this.JTFCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasCLayout = new GroupLayout(this.JPICuentasC);
        this.JPICuentasC.setLayout(JPICuentasCLayout);
        JPICuentasCLayout.setHorizontalGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDebito, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCredito, -1, 130, 32767).addContainerGap()));
        JPICuentasCLayout.setVerticalGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDebito, -2, -1, -2).addComponent(this.JTFCredito, -2, -1, -2)));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBPago);
        this.JRBPago.setFont(new Font("Arial", 1, 12));
        this.JRBPago.setSelected(true);
        this.JRBPago.setText("Pago");
        this.JRBPago.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.3
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JRBPagoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBGlosa);
        this.JRBGlosa.setFont(new Font("Arial", 1, 12));
        this.JRBGlosa.setText("Glosa");
        this.JRBGlosa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.4
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JRBGlosaActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBDevolucion);
        this.JRBDevolucion.setFont(new Font("Arial", 1, 12));
        this.JRBDevolucion.setText("Devolucion");
        this.JRBDevolucion.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.5
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JRBDevolucionActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPago).addGap(18, 18, 18).addComponent(this.JRBGlosa).addGap(18, 18, 18).addComponent(this.JRBDevolucion).addContainerGap(-1, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPago).addComponent(this.JRBGlosa).addComponent(this.JRBDevolucion)).addContainerGap(-1, 32767)));
        this.JCHCompleto.setFont(new Font("Arial", 1, 12));
        this.JCHCompleto.setText("Completo?");
        this.JCHCompleto.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.6
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JCHCompletoActionPerformed(evt);
            }
        });
        this.JCHVisualizar.setFont(new Font("Liberation Sans", 1, 12));
        this.JCHVisualizar.setText("visualizarInforme014");
        this.JCHVisualizar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.7
            public void actionPerformed(ActionEvent evt) {
                JIFFConceptoPagoGlosa.this.JCHVisualizarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFConcepto, -2, 643, -2).addGap(18, 18, 18).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPITipo, -2, -1, -2).addGap(28, 28, 28).addComponent(this.JPICuentasC, -2, -1, -2).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHVisualizar).addComponent(this.JCHCompleto)))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFConcepto, -2, -1, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPICuentasC, -1, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHVisualizar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCompleto)).addComponent(this.JPITipo, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.8
            public void mouseClicked(MouseEvent evt) {
                JIFFConceptoPagoGlosa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 351, 32767).addContainerGap()));
        pack();
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
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFConcepto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFDebito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFCredito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if ("PAGO".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.xtipo = 0;
                this.JRBPago.setSelected(true);
            } else if ("GLOSA".equals(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.xtipo = 1;
                this.JRBGlosa.setSelected(true);
            } else {
                this.xtipo = 2;
                this.JRBDevolucion.setSelected(true);
            }
            this.JCHCompleto.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            if (this.JCHCompleto.isSelected()) {
                this.xcompleto = 1;
            } else {
                this.xcompleto = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JCHVisualizar.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHVisualizar.isSelected()) {
                this.visualizar014 = 1;
            } else {
                this.visualizar014 = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPagoActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGlosaActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCompletoActionPerformed(ActionEvent evt) {
        if (this.JCHCompleto.isSelected()) {
            this.xcompleto = 1;
        } else {
            this.xcompleto = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDevolucionActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHVisualizarActionPerformed(ActionEvent evt) {
        if (this.JCHVisualizar.isSelected()) {
            this.visualizar014 = 1;
        } else {
            this.visualizar014 = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFConcepto.setText("");
        mCargarDatosTabla();
        this.JCHEstado.setSelected(true);
        this.JTFCredito.setText("");
        this.JTFDebito.setText("");
        this.xestado = 1;
        this.xtipo = 0;
        this.xcompleto = 0;
        this.JCHCompleto.setSelected(false);
        this.JRBPago.setSelected(true);
        this.JCHVisualizar.setSelected(false);
        this.JTFConcepto.requestFocus();
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFConcepto.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = " Insert into f_tipoconcepto_pago(Nbre, CCredito, CDebito, Tipo,Completo,visualizarInforme014, UsuarioS)  values ('" + this.JTFConcepto.getText() + "','" + this.JTFCredito.getText() + "','" + this.JTFDebito.getText() + "','" + this.xtipo + "','" + this.xcompleto + "','" + this.visualizar014 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = " update f_tipoconcepto_pago set Estado='" + this.xestado + "', CDebito='" + this.JTFDebito.getText() + "', CCredito='" + this.JTFCredito.getText() + "', Nbre='" + this.JTFConcepto.getText() + "', Tipo='" + this.xtipo + "', Completo='" + this.xcompleto + "', visualizarInforme014='" + this.visualizar014 + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Concepto no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFConcepto.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Credito", "Debito", "Tipo", "Completo?", "Estado", "visualizarInforme014"}) { // from class: ParametrizacionN.JIFFConceptoPagoGlosa.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, CCredito, CDebito, IF(Tipo=0,'PAGO',IF(Tipo=1,'GLOSA','DEVOLUCION'))AS Tipo, Completo, Estado, visualizarInforme014 FROM f_tipoconcepto_pago ORDER BY Nbre ASC ");
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        int n = 0;
                        while (xrs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                            this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                            this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                            this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), n, 5);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                            this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                            n++;
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsulta.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFFConceptoPagoGlosa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
