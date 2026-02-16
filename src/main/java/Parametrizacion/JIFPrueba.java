package Parametrizacion;

import Utilidades.ConsultasMySQL;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFPrueba.class */
public class JIFPrueba extends JInternalFrame {
    private DefaultTableModel modelo;
    private ConsultasMySQL consultasMySQL;
    private String sql;
    private Object[] dato;
    private String[] combobox;
    private final boolean numeroDocumentoEditable = true;
    private JComboBox<String> JCB_TipoDcmento;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField txtNumeroId;
    private JTextField txtnombre;

    public JIFPrueba() {
        initComponents();
        this.consultasMySQL = new ConsultasMySQL();
        cargarTabla();
        this.combobox = this.consultasMySQL.llenarCombo("SELECT  gt.Nbre,gt.Nbre  FROM g_tipoidentificacion gt ", this.combobox, this.JCB_TipoDcmento);
        this.JCB_TipoDcmento.setSelectedItem(-1);
        this.consultasMySQL.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Nombre Completo", "Tipo de Documento", "Numero de Identificacion", "uuid"}) { // from class: Parametrizacion.JIFPrueba.1
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTable1.setModel(this.modelo);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.jTable1.removeColumn(this.jTable1.getColumnModel().getColumn(3));
    }

    /* JADX WARN: Finally extract failed */
    private void cargarTabla() {
        try {
            crearTabla();
            this.sql = "SELECT p.name, p.TipoDocumento, p.NumeroDocumento FROM 0_prueba p";
            ResultSet rs = this.consultasMySQL.traerRs(this.sql);
            Throwable th = null;
            try {
                rs.next();
                if (rs.getRow() != 0) {
                    rs.beforeFirst();
                    int i = 0;
                    while (rs.next()) {
                        this.modelo.addRow(this.dato);
                        this.modelo.setValueAt(rs.getString(1), i, 0);
                        this.modelo.setValueAt(rs.getString(2), i, 1);
                        this.modelo.setValueAt(rs.getString(3), i, 2);
                        i++;
                    }
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
                this.consultasMySQL.cerrarConexionBd();
            } catch (Throwable th3) {
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        rs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPrueba.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar() {
        if (!this.txtnombre.getText().isEmpty()) {
            if (this.JCB_TipoDcmento.getSelectedIndex() != -1) {
                if (!this.txtNumeroId.getText().isEmpty()) {
                    String nombre = capitalizarPalabras(this.txtnombre.getText());
                    if (this.jTable1.getSelectedRow() != -1) {
                        this.sql = "UPDATE 0_prueba SET name='" + nombre + "', TipoDocumento='" + this.combobox[this.JCB_TipoDcmento.getSelectedIndex()] + "' WHERE NumeroDocumento='" + this.txtNumeroId.getText() + "'";
                    } else {
                        this.sql = "INSERT INTO 0_prueba (name, TipoDocumento, NumeroDocumento)\nVALUES('" + nombre + "','" + this.combobox[this.JCB_TipoDcmento.getSelectedIndex()] + "','" + this.txtNumeroId.getText() + "')";
                    }
                    this.consultasMySQL.ejecutarSQL(this.sql);
                    this.consultasMySQL.cerrarConexionBd();
                    cargarTabla();
                    nuevo();
                    return;
                }
                JOptionPane.showMessageDialog(this, "El campo documento no puede ser nulo o estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.txtnombre.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "El campo documento no puede ser nulo o estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_TipoDcmento.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "El campo nombre no puede ser nulo o estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.txtNumeroId.requestFocus();
    }

    public void nuevo() {
        this.txtNumeroId.setText("");
        this.txtnombre.setText("");
        this.JCB_TipoDcmento.setSelectedIndex(-1);
        cargarTabla();
    }

    private String capitalizarPalabras(String input) {
        String[] palabras = input.split("\\s");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0))).append(palabra.substring(1)).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.jPanel1 = new JPanel();
        this.txtnombre = new JTextField();
        this.JCB_TipoDcmento = new JComboBox<>();
        this.txtNumeroId = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("PRUEBA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Menu Prueba");
        this.jScrollPane1.setViewportBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setRowHeight(25);
        this.jTable1.setSelectionMode(0);
        this.jTable1.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFPrueba.2
            public void mouseClicked(MouseEvent evt) {
                JIFPrueba.this.jTable1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtnombre.setFont(new Font("Arial", 1, 12));
        this.txtnombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Del Paciente", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtnombre.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFPrueba.3
            public void actionPerformed(ActionEvent evt) {
                JIFPrueba.this.txtnombreActionPerformed(evt);
            }
        });
        this.JCB_TipoDcmento.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDcmento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNumeroId.setFont(new Font("Arial", 1, 12));
        this.txtNumeroId.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Identificacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCB_TipoDcmento, -2, 200, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtNumeroId, -2, 303, -2).addComponent(this.txtnombre, -2, 529, -2))).addContainerGap(12, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtnombre, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNumeroId, -2, 50, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JCB_TipoDcmento, -2, 50, -2))).addContainerGap(18, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 226, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtnombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.jTable1.getSelectedRow() != -1) {
            this.txtnombre.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0).toString());
            this.txtNumeroId.setText(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 2).toString());
            this.txtNumeroId.setEditable(true);
            for (int i = 0; i < this.combobox.length; i++) {
                if (this.combobox[i].equals(this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1).toString())) {
                    this.JCB_TipoDcmento.setSelectedIndex(i);
                    return;
                }
            }
        }
    }
}
