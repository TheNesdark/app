package Salud_Ocupacional;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JDAgentes.class */
public class JDAgentes extends JDialog {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ConsultasMySQL xct;
    private JIFFAgenteMedicion xJIFFAgenteMedicion;
    private String xId;
    public JLabel JLSEG;
    private JTable JTDetalle;
    private JButton jButton1;
    private JScrollPane jScrollPane3;

    public JDAgentes(Frame parent, boolean modal, String xTitle, String xId, JIFFAgenteMedicion xJIFFAgenteMedicion) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xId = null;
        initComponents();
        this.xId = xId;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JLSEG.setText(xTitle);
        this.xJIFFAgenteMedicion = xJIFFAgenteMedicion;
        setLocationRelativeTo(null);
        mBuscaAgentes();
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLSEG = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.JLSEG.setFont(new Font("Arial", 1, 18));
        this.JLSEG.setForeground(Color.blue);
        this.JLSEG.setHorizontalAlignment(0);
        this.JLSEG.setBorder(new SoftBevelBorder(0));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JDAgentes.1
            public void keyPressed(KeyEvent evt) {
                JDAgentes.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTDetalle);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Agregar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDAgentes.2
            public void actionPerformed(ActionEvent evt) {
                JDAgentes.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLSEG, -1, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 500, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JLSEG, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            if (!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la Fila?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
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
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(i, 5).toString()).booleanValue()) {
                this.xJIFFAgenteMedicion.xmodelo.addRow(this.xJIFFAgenteMedicion.xdatos);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 0), this.xJIFFAgenteMedicion.xfila, 0);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 1), this.xJIFFAgenteMedicion.xfila, 1);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 2), this.xJIFFAgenteMedicion.xfila, 2);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 3), this.xJIFFAgenteMedicion.xfila, 3);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(this.xmodelo.getValueAt(i, 4), this.xJIFFAgenteMedicion.xfila, 4);
                this.xJIFFAgenteMedicion.xmodelo.setValueAt(false, this.xJIFFAgenteMedicion.xfila, 5);
                this.xJIFFAgenteMedicion.xfila++;
            }
        }
        dispose();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Agente", "OEL", "TLV", "Observación", "√"}) { // from class: Salud_Ocupacional.JDAgentes.3
            Class[] types = {Integer.class, String.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true, true, true};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(2);
    }

    private void mBuscaAgentes() {
        mCrearModeloDetalle();
        String sql = "SELECT `so_tipo_seg_tipogente`.`Id`, `so_tipo_agentes`.`Nbre` FROM `so_tipo_seg_tipogente`\n    INNER JOIN `so_tipo_agentes`  ON (`so_tipo_seg_tipogente`.`Id_TipoAgente` = `so_tipo_agentes`.`Id`) WHERE (`so_tipo_seg_tipogente`.`Id_Seg` ='" + this.xId + "'\n    AND `so_tipo_seg_tipogente`.`Estado` =1) ORDER BY `so_tipo_agentes`.`Nbre` asc";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(0, n, 2);
                    this.xmodelo.setValueAt(0, n, 3);
                    this.xmodelo.setValueAt("", n, 4);
                    this.xmodelo.setValueAt(true, n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAgenteMedicion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
