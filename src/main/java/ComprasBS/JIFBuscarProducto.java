package ComprasBS;

import AutorizacionMP.JIFRProductosNAutorizados;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JIFBuscarProducto.class */
public class JIFBuscarProducto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xobjetollamador;
    private JIFOrdenCompra xjifordenc;
    private JIFRProductosNAutorizados xjifpnoautorizados;
    private JIFRequisicion xjifreq;
    private ButtonGroup JBGOpciones;
    private JPanel JPIDatos;
    private JScrollPane JSPResultado;
    private JTextField JTFNombreP;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();

    public JIFBuscarProducto(JInternalFrame xjif) {
        initComponents();
        mRealizarCasting(xjif);
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombreP = new JTextField();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("BUSQUEDA DE PRODUCTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jisbuscardatoscont");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.addKeyListener(new KeyAdapter() { // from class: ComprasBS.JIFBuscarProducto.1
            public void keyTyped(KeyEvent evt) {
                JIFBuscarProducto.this.JTFNombrePKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JIFBuscarProducto.this.JTFNombrePKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreP, -1, 782, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombreP).addGap(20, 20, 20)));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JIFBuscarProducto.2
            public void mouseClicked(MouseEvent evt) {
                JIFBuscarProducto.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING, -1, 818, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 346, -2).addContainerGap(27, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            if (this.xobjetollamador.equals("jifcompras") || this.xobjetollamador.equals("jifcompras1") || this.xobjetollamador.equals("jifcompras2")) {
                try {
                    this.xjifordenc.xcodigop = Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue();
                    this.xjifordenc.JTFNombreP.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
                    this.xjifordenc.JSPIva.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 2).toString()));
                    this.xjifordenc.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFBuscarProducto.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            } else if (this.xobjetollamador.equals("jifpnoautorizados")) {
                try {
                    this.xjifpnoautorizados.xidproducto = Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue();
                    this.xjifpnoautorizados.JTFNombreP.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
                    this.xjifpnoautorizados.JTFFValor.setValue(Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 4).toString()));
                    this.xjifpnoautorizados.setSelected(true);
                } catch (PropertyVetoException e2) {
                    Logger.getLogger(JIFBuscarProducto.class.getName()).log(Level.SEVERE, (String) null, e2);
                }
            } else if (this.xobjetollamador.equals("jifrequisicion")) {
                try {
                    this.xjifreq.xcodigop = Long.valueOf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString()).longValue();
                    this.xjifreq.JTFNombreP.setText(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
                    this.xjifreq.setSelected(true);
                } catch (PropertyVetoException e3) {
                    Logger.getLogger(JIFBuscarProducto.class.getName()).log(Level.SEVERE, (String) null, e3);
                }
            }
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFNombreP.getText().isEmpty()) {
                mCargarDatos();
            } else {
                mCrearTabla();
            }
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Producto", "Iva", "Valor", "Valor"}) { // from class: ComprasBS.JIFBuscarProducto.3
            Class[] types = {Long.class, String.class, Double.class, Double.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql = null;
        if (this.xobjetollamador.equals("jifcompras") || this.xobjetollamador.equals("jifcompras1") || this.xobjetollamador.equals("jifcompras2")) {
            sql = "SELECT i_suministro.Id, concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) AS NombreP, i_suministro.Iva,0 FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) like '" + this.JTFNombreP.getText() + "%' AND i_suministro.EstaActivo =1 AND i_suministro.IdTipoProducto ='" + this.xjifordenc.xidtipobien[this.xjifordenc.JCBTipoBien.getSelectedIndex()] + "') ORDER BY NombreP ASC ";
        } else if (this.xobjetollamador.equals("jifpnoautorizados")) {
            sql = "SELECT i_suministro.Id, concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) AS NombreP, i_suministro.Iva, i_suministro.ValorPLM FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) like '" + this.JTFNombreP.getText() + "%'  AND i_suministro.IdTipoProducto ='" + this.xjifpnoautorizados.xidtipop[this.xjifpnoautorizados.JCBTipoProducto.getSelectedIndex()] + "') ORDER BY NombreP ASC ";
        } else if (this.xobjetollamador.equals("jifrequisicion")) {
            sql = "SELECT i_suministro.Id, concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) AS NombreP, i_suministro.Iva,0 FROM i_suministro INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (concat(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre, ' ' ,i_laboratorio.Nbre) like '" + this.JTFNombreP.getText() + "%' AND i_suministro.EstaActivo =1 AND i_suministro.IdTipoProducto ='" + this.xjifreq.xidtipobien[this.xjifreq.JCBTipoBien.getSelectedIndex()] + "') ORDER BY NombreP ASC ";
        }
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 4);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifcompras")) {
            this.xjifordenc = (JIFOrdenCompra) frm;
            this.xobjetollamador = "jifcompras";
            return;
        }
        if (frm.getName().equals("jifcompras1")) {
            this.xjifordenc = (JIFOrdenCompra) frm;
            this.xobjetollamador = "jifcompras1";
            return;
        }
        if (frm.getName().equals("jifcompras2")) {
            this.xjifordenc = (JIFOrdenCompra) frm;
            this.xobjetollamador = "jifcompras2";
        } else if (frm.getName().equals("jifpnoautorizados")) {
            this.xjifpnoautorizados = (JIFRProductosNAutorizados) frm;
            this.xobjetollamador = "jifpnoautorizados";
        } else if (frm.getName().equals("jifrequisicion")) {
            this.xjifreq = (JIFRequisicion) frm;
            this.xobjetollamador = "jifrequisicion";
        }
    }
}
