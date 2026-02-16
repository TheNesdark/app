package AutorizacionMP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFConsultarAuditorias.class */
public class JIFConsultarAuditorias extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private String[][] xidtipoempresa;
    private JButton JBTEnviar;
    private JComboBox JCBProveedor;
    private JCheckBox JCHQuitarS;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDatosEnvio;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCorreo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFConsultarAuditorias() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JCBProveedor = new JComboBox();
        this.JCHQuitarS = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDatosEnvio = new JPanel();
        this.JTFCorreo = new JTextField();
        this.JBTEnviar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE AUDITORIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadoauditoria");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProveedor.addItemListener(new ItemListener() { // from class: AutorizacionMP.JIFConsultarAuditorias.1
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarAuditorias.this.JCBProveedorItemStateChanged(evt);
            }
        });
        this.JCHQuitarS.setFont(new Font("Arial", 1, 12));
        this.JCHQuitarS.setText("Quitar Selección?");
        this.JCHQuitarS.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarAuditorias.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAuditorias.this.JCHQuitarSActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 110, -2).addGap(4, 4, 4).addComponent(this.JDCFechaF, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProveedor, -2, 505, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JCHQuitarS).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProveedor, -1, 52, 32767).addComponent(this.JCHQuitarS)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaF, GroupLayout.Alignment.LEADING, -1, 51, 32767))).addContainerGap(18, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPIDatosEnvio.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ENVIO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTEnviar.setFont(new Font("Arial", 1, 12));
        this.JBTEnviar.setForeground(Color.blue);
        this.JBTEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo.png")));
        this.JBTEnviar.setText("Enviar");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFConsultarAuditorias.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarAuditorias.this.JBTEnviarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosEnvioLayout = new GroupLayout(this.JPIDatosEnvio);
        this.JPIDatosEnvio.setLayout(JPIDatosEnvioLayout);
        JPIDatosEnvioLayout.setHorizontalGroup(JPIDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEnvioLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCorreo, -1, 643, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTEnviar, -2, 207, -2).addContainerGap()));
        JPIDatosEnvioLayout.setVerticalGroup(JPIDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEnvioLayout.createSequentialGroup().addGroup(JPIDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTEnviar, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JTFCorreo, GroupLayout.Alignment.LEADING)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 896, 32767).addComponent(this.JPIDatosEnvio, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 273, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosEnvio, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProveedorItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProveedor.getSelectedIndex() != -1) {
            this.JTFCorreo.setText(this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHQuitarSActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (this.JCHQuitarS.isSelected()) {
                this.xmodelo.setValueAt(false, x, 9);
            } else {
                this.xmodelo.setValueAt(true, x, 9);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 9)) {
            String xcuerpo = null;
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                    if (xcuerpo == null) {
                        xcuerpo = this.xmodelo.getValueAt(x, 0).toString() + "\t\t" + this.xmodelo.getValueAt(x, 1).toString() + "\t\t" + this.xmodelo.getValueAt(x, 2).toString() + "\t\t" + this.xmodelo.getValueAt(x, 3).toString() + "\t\t" + this.xmodelo.getValueAt(x, 7).toString() + "\n";
                    } else {
                        xcuerpo = xcuerpo + this.xmodelo.getValueAt(x, 0).toString() + "\t\t" + this.xmodelo.getValueAt(x, 1).toString() + "\t\t" + this.xmodelo.getValueAt(x, 2).toString() + "\t\t" + this.xmodelo.getValueAt(x, 3).toString() + "\t\t" + this.xmodelo.getValueAt(x, 7).toString() + "\n";
                    }
                }
            }
            this.xmt.mEnvioCorreoElectronico("Buenas, se ha realizado la recepción y auditoria de las siguiente(s) factura(s) :\n\nN° Auditoria\tFecha Auditoria\tN° Factura\tFecha Factura\tValor Factura\n" + xcuerpo + "\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), this.JTFCorreo.getText(), "RECEPCIÓN Y AUDITORIA DE FACTURA(S)", Principal.usuarioSistemaDTO.getLogin());
        }
    }

    public void mBuscar() {
        if (this.JCBProveedor.getSelectedIndex() != -1) {
            mCargarTabla();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProveedor.requestFocus();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JCBProveedor.removeAllItems();
        this.xsql = "SELECT cc_terceros.Id , cc_terceros.RazonSocialCompleta, cc_terceros.Correo FROM h_ordenes INNER JOIN d_auditoria_formulamp  ON (h_ordenes.Id_AuditoriaMP = d_auditoria_formulamp.Id) \nINNER JOIN cc_terceros  ON (d_auditoria_formulamp.Id_Empresa = cc_terceros.Id) GROUP BY cc_terceros.Id ORDER BY cc_terceros.RazonSocialCompleta ASC";
        this.xidtipoempresa = this.xct.llenarComboyLista(this.xsql, this.xidtipoempresa, this.JCBProveedor, 3);
        this.JCBProveedor.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearTabla();
        this.JTFCorreo.setText("");
        this.xlleno = true;
        this.JCBProveedor.requestFocus();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "FechaA", "N° Factura", "Fecha Factura", "SubTotal", "V/Iva", "V/Otros", "V/Total", "Observación", "Enviar"}) { // from class: AutorizacionMP.JIFConsultarAuditorias.4
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
    }

    private void mCargarTabla() {
        mCrearTabla();
        this.xsql = "SELECT d_auditoria_formulamp.Id, DATE_FORMAT(d_auditoria_formulamp.FechaA,'%d-%m-%Y') AS FechaAud, d_auditoria_formulamp.NFactura, DATE_FORMAT(d_auditoria_formulamp.FechaF,'%d-%m-%Y') AS FechaFact , d_auditoria_formulamp.Subtotal, d_auditoria_formulamp.Iva, d_auditoria_formulamp.OtroValor, (d_auditoria_formulamp.Subtotal+d_auditoria_formulamp.Iva+d_auditoria_formulamp.OtroValor) AS VTotal, d_auditoria_formulamp.Observacion FROM d_auditoria_formulamp INNER JOIN h_ordenes  ON (d_auditoria_formulamp.Id = h_ordenes.Id_AuditoriaMP) INNER JOIN g_empresa  ON (d_auditoria_formulamp.Id_Empresa = g_empresa.Id) WHERE (d_auditoria_formulamp.FechaA>='" + this.xmt.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND d_auditoria_formulamp.FechaA<='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_auditoria_formulamp.Id_Empresa='" + this.xidtipoempresa[this.JCBProveedor.getSelectedIndex()][0] + "') GROUP BY d_auditoria_formulamp.Id ORDER BY d_auditoria_formulamp.FechaA ASC ";
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(true, x, 9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarAuditorias.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
