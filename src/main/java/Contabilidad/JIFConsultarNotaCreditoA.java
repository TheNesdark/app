package Contabilidad;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarNotaCreditoA.class */
public class JIFConsultarNotaCreditoA extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String xobjetollamador;
    private int xtipoforma;
    private JIFGeneracionPagos xjifgeneracionp;
    private ButtonGroup JBGSeleccion;
    private JButton JBTAplicar;
    private JPanel JPIDatosAplicacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFNetoPagar;
    private JFormattedTextField JTFFSaldo;
    private JFormattedTextField JTFFVAPlicar;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xautorizado = 1;

    public JIFConsultarNotaCreditoA(String xname, JInternalFrame xjif) {
        initComponents();
        setName(xname);
        mRealizarCasting(xjif);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosAplicacion = new JPanel();
        this.JTFFNetoPagar = new JFormattedTextField();
        this.JTFFVAPlicar = new JFormattedTextField();
        this.JTFFSaldo = new JFormattedTextField();
        this.JBTAplicar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA DE NOTAS CREDITOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsultarnotacredito");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFConsultarNotaCreditoA.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarNotaCreditoA.this.formInternalFrameClosing(evt);
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
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarNotaCreditoA.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarNotaCreditoA.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarNotaCreditoA.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarNotaCreditoA.this.JTDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosAplicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA LA APLICACIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFNetoPagar.setBorder(BorderFactory.createTitledBorder((Border) null, "Neto a Pagar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNetoPagar.setHorizontalAlignment(4);
        this.JTFFNetoPagar.setFont(new Font("Arial", 1, 13));
        this.JTFFVAPlicar.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Aplicar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVAPlicar.setHorizontalAlignment(4);
        this.JTFFVAPlicar.setFont(new Font("Arial", 1, 13));
        this.JTFFSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor a Pagar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSaldo.setHorizontalAlignment(4);
        this.JTFFSaldo.setFont(new Font("Arial", 1, 13));
        this.JBTAplicar.setFont(new Font("Arial", 1, 12));
        this.JBTAplicar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAplicar.setText("Aplicar");
        this.JBTAplicar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarNotaCreditoA.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarNotaCreditoA.this.JBTAplicarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosAplicacionLayout = new GroupLayout(this.JPIDatosAplicacion);
        this.JPIDatosAplicacion.setLayout(JPIDatosAplicacionLayout);
        JPIDatosAplicacionLayout.setHorizontalGroup(JPIDatosAplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAplicacionLayout.createSequentialGroup().addComponent(this.JTFFNetoPagar, -2, 185, -2).addGap(18, 18, 18).addComponent(this.JTFFVAPlicar, -2, 185, -2).addGap(18, 18, 18).addComponent(this.JTFFSaldo, -2, 185, -2).addGap(51, 51, 51).addComponent(this.JBTAplicar, -1, 200, 32767)));
        JPIDatosAplicacionLayout.setVerticalGroup(JPIDatosAplicacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAplicacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAplicacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAplicar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFFNetoPagar, GroupLayout.Alignment.LEADING).addComponent(this.JTFFVAPlicar, GroupLayout.Alignment.LEADING).addComponent(this.JTFFSaldo, GroupLayout.Alignment.LEADING)).addContainerGap(22, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 858, 32767).addComponent(this.JPIDatosAplicacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 234, -2).addGap(18, 18, 18).addComponent(this.JPIDatosAplicacion, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mCalcularValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            mCalcularValores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAplicarActionPerformed(ActionEvent evt) {
        if (this.xobjetollamador.equals("jifgenerarpagos") && this.JTDetalle.getSelectedRow() != -1 && Double.valueOf(this.JTFFVAPlicar.getValue().toString()).doubleValue() != 0.0d) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de aplicar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(y, 7).toString()).booleanValue()) {
                        String sql = "insert into cc_descuento_notac(Id_NotaC, Id_DocumentoC, Valor) values ('" + this.xmodelo.getValueAt(y, 0) + "','" + this.xjifgeneracionp.xmodelo.getValueAt(this.xjifgeneracionp.JTResultado.getSelectedRow(), 0) + "','" + this.xmodelo.getValueAt(y, 5) + "')";
                        this.xconsulta.ejecutarSQL(sql);
                        this.xconsulta.cerrarConexionBd();
                        if (Double.valueOf(this.xmodelo.getValueAt(y, 6).toString()).doubleValue() == 0.0d) {
                            String sql2 = "update cc_radicacion_notac set Pagada=1 where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                            this.xconsulta.ejecutarSQL(sql2);
                            this.xconsulta.cerrarConexionBd();
                        }
                    }
                }
                this.xjifgeneracionp.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0), this.xjifgeneracionp.JTResultado.getSelectedRow(), 11);
                this.xjifgeneracionp.xmodelo.setValueAt(this.JTFFVAPlicar.getValue(), this.xjifgeneracionp.JTResultado.getSelectedRow(), 12);
                this.xjifgeneracionp.xmodelo.setValueAt(Double.valueOf(this.JTFFSaldo.getValue().toString()), this.xjifgeneracionp.JTResultado.getSelectedRow(), 4);
                this.xjifgeneracionp.mTotalizarReembolso();
                dispose();
            }
        }
    }

    public void mNuevo() {
        mCargarDatosTabla();
        this.JTFFSaldo.setValue(new Integer(0));
        this.JTFFVAPlicar.setValue(new Integer(0));
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
        }
    }

    private void mCalcularValores() {
        double xvalora = 0.0d;
        double xvalorant = Double.valueOf(this.JTFFVAPlicar.getValue().toString()).doubleValue();
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 7).toString()).booleanValue()) {
                xvalora += Double.valueOf(this.xmodelo.getValueAt(x, 5).toString()).doubleValue();
            }
        }
        if (xvalora < Double.valueOf(this.JTFFNetoPagar.getValue().toString()).doubleValue()) {
            this.JTFFVAPlicar.setValue(Double.valueOf(xvalora));
            this.JTFFSaldo.setValue(Double.valueOf(Double.valueOf(this.JTFFNetoPagar.getValue().toString()).doubleValue() - xvalora));
            this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).doubleValue() - Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).doubleValue()), this.JTDetalle.getSelectedRow(), 6);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Varlor a descontar no puede ser mayor al neto a pagar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFVAPlicar.setValue(Double.valueOf(xvalorant));
            this.xmodelo.setValueAt(false, this.JTDetalle.getSelectedRow(), 7);
            this.JTFFSaldo.setValue(Double.valueOf(Double.valueOf(this.JTFFNetoPagar.getValue().toString()).doubleValue() - 0.0d));
            this.xmodelo.setValueAt(new Integer(0), this.JTDetalle.getSelectedRow(), 6);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "Observación", "Valor NC", "Valor Descontado", "Valor a Descontar", "Saldo", "Aplicar?"}) { // from class: Contabilidad.JIFConsultarNotaCreditoA.5
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        try {
            if (this.xobjetollamador.equals("jifgenerarpagos")) {
                this.xsql = "SELECT cc_radicacion_notac.Id, cc_radicacion_notac.Fecha, cc_radicacion_notac.Observacion, SUM(cc_radicacion_notac.SubTotal+ cc_radicacion_notac.Iva+ cc_radicacion_notac.Flete+ cc_radicacion_notac.Otros) AS Total, cc_detalle_documentoc.VDebito         FROM cc_documentoc INNER JOIN cc_radicacion_notac  ON (cc_documentoc.Id = cc_radicacion_notac.Id_DocumentoC) INNER JOIN cc_detalle_documentoc  ON (cc_radicacion_notac.Id_CuentaAuxPPagar = cc_detalle_documentoc.Id_Puc) AND (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (cc_radicacion_notac.Id_Proveedor ='" + this.xjifgeneracionp.xmodelo.getValueAt(this.xjifgeneracionp.JTResultado.getSelectedRow(), 9) + "' AND cc_radicacion_notac.Pagada =0 and cc_radicacion_notac.Estado=1)  GROUP BY cc_radicacion_notac.Id ";
                this.JTFFNetoPagar.setValue(Double.valueOf(this.xjifgeneracionp.xmodelo.getValueAt(this.xjifgeneracionp.JTResultado.getSelectedRow(), 4).toString()));
            }
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.xsql = "SELECT sum(Valor) FROM cc_descuento_notac WHERE (Id_NotaC ='" + xrs.getLong(1) + "') GROUP BY Id_NotaC";
                    ResultSet rs = xct.traerRs(this.xsql);
                    if (rs.next()) {
                        rs.first();
                        this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(1)), n, 4);
                    } else {
                        this.xmodelo.setValueAt(new Integer(0), n, 4);
                    }
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5) - Double.valueOf(this.xmodelo.getValueAt(n, 4).toString()).doubleValue()), n, 5);
                    this.xmodelo.setValueAt(new Integer(0), n, 6);
                    this.xmodelo.setValueAt(false, n, 7);
                    n++;
                    rs.close();
                    xct.cerrarConexionBd();
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarNotaCreditoA.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifgenerarpagos")) {
            this.xjifgeneracionp = (JIFGeneracionPagos) frm;
            this.xobjetollamador = "jifgenerarpagos";
        }
    }
}
