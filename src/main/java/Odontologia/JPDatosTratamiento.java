package Odontologia;

import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPDatosTratamiento.class */
public class JPDatosTratamiento extends JPanel {
    private Object[] xdato;
    private String xsql;
    private String[] xidprocedimiento;
    private String[] xidtipodx1;
    private String[][] xidservicio;
    private DefaultTableModel xmodelodetalletto;
    private JButton JBTAdicionar;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBTipoDx1;
    private JComboBox JCBTipoServicio;
    private JPanel JPIDatosTto;
    private JScrollPane JSPDetalleTto;
    private JSpinner JSPNCitas;
    private JSpinner JSPNDiente;
    private JTable JTDetalleTto;
    public JTextField JTFCDxP1;
    private JTextField JTFNCodigoDxP1;
    private boolean xlleno = false;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xnfilamodelodetalletto = 0;

    public JPDatosTratamiento() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosTto = new JPanel();
        this.JCBTipoServicio = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JSPNDiente = new JSpinner();
        this.JSPNCitas = new JSpinner();
        this.JTFCDxP1 = new JTextField();
        this.JTFNCodigoDxP1 = new JTextField();
        this.JCBTipoDx1 = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.JSPDetalleTto = new JScrollPane();
        this.JTDetalleTto = new JTable();
        this.JPIDatosTto.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoServicio.addItemListener(new ItemListener() { // from class: Odontologia.JPDatosTratamiento.1
            public void itemStateChanged(ItemEvent evt) {
                JPDatosTratamiento.this.JCBTipoServicioItemStateChanged(evt);
            }
        });
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNDiente.setFont(new Font("Arial", 1, 12));
        this.JSPNDiente.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNDiente.setBorder(BorderFactory.createTitledBorder((Border) null, "Diente N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNCitas.setFont(new Font("Arial", 1, 12));
        this.JSPNCitas.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPNCitas.setBorder(BorderFactory.createTitledBorder((Border) null, "Citas N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCDxP1.addFocusListener(new FocusAdapter() { // from class: Odontologia.JPDatosTratamiento.2
            public void focusLost(FocusEvent evt) {
                JPDatosTratamiento.this.JTFCDxP1FocusLost(evt);
            }
        });
        this.JTFCDxP1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPDatosTratamiento.3
            public void keyPressed(KeyEvent evt) {
                JPDatosTratamiento.this.JTFCDxP1KeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP1.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNCodigoDxP1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPDatosTratamiento.4
            public void mouseClicked(MouseEvent evt) {
                JPDatosTratamiento.this.JTFNCodigoDxP1MouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP1.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPDatosTratamiento.5
            public void keyPressed(KeyEvent evt) {
                JPDatosTratamiento.this.JTFNCodigoDxP1KeyPressed(evt);
            }
        });
        this.JCBTipoDx1.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Odontologia.JPDatosTratamiento.6
            public void actionPerformed(ActionEvent evt) {
                JPDatosTratamiento.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosTtoLayout = new GroupLayout(this.JPIDatosTto);
        this.JPIDatosTto.setLayout(JPIDatosTtoLayout);
        JPIDatosTtoLayout.setHorizontalGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addComponent(this.JTFCDxP1, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP1, -2, 499, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDx1, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, 171, 32767)).addGroup(JPIDatosTtoLayout.createSequentialGroup().addComponent(this.JCBTipoServicio, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProcedimiento, -2, 507, -2).addGap(6, 6, 6).addComponent(this.JSPNDiente, -2, 84, -2).addGap(18, 18, 18).addComponent(this.JSPNCitas, -2, 84, -2)))));
        JPIDatosTtoLayout.setVerticalGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTtoLayout.createSequentialGroup().addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoServicio, -2, -1, -2).addComponent(this.JCBProcedimiento, -2, -1, -2).addComponent(this.JSPNDiente, -2, 46, -2).addComponent(this.JSPNCitas, -2, 46, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAdicionar, -1, -1, 32767).addComponent(this.JCBTipoDx1).addGroup(JPIDatosTtoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP1, -2, 50, -2).addComponent(this.JTFNCodigoDxP1, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalleTto.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleTto.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTto.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleTto.setRowHeight(25);
        this.JTDetalleTto.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleTto.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleTto.setSelectionMode(0);
        this.JSPDetalleTto.setViewportView(this.JTDetalleTto);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosTto, -1, -1, 32767).addComponent(this.JSPDetalleTto)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosTto, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalleTto, -2, 184, -2).addContainerGap(21, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoServicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoServicio.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBProcedimiento.removeAllItems();
            this.xsql = "SELECT `Id`, `Nbre` FROM `g_procedimiento` WHERE (`EsOdontologico` =1 AND `Estado` =0 AND `Id_tipoprocedimiento` ='" + this.xidservicio[this.JCBTipoServicio.getSelectedIndex()][1] + "') ORDER BY `Nbre` ASC";
            this.xidprocedimiento = xct1.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
            this.JCBProcedimiento.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1FocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP1, this.JTFNCodigoDxP1, 1);
        mBuscarGuiasPatologias(this.JTFCDxP1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxP1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP1, this.JTFNCodigoDxP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxP1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            if (!this.JTFCDxP1.getText().isEmpty()) {
                if (this.JCBTipoDx1.getSelectedIndex() != -1) {
                    this.xmodelodetalletto.addRow(this.xdato);
                    this.xmodelodetalletto.setValueAt(this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()], this.xnfilamodelodetalletto, 0);
                    this.xmodelodetalletto.setValueAt(this.JCBProcedimiento.getSelectedItem().toString(), this.xnfilamodelodetalletto, 1);
                    this.xmodelodetalletto.setValueAt(this.JSPNDiente.getValue(), this.xnfilamodelodetalletto, 2);
                    this.xmodelodetalletto.setValueAt(this.JSPNCitas.getValue(), this.xnfilamodelodetalletto, 3);
                    this.xmodelodetalletto.setValueAt(this.JTFCDxP1.getText(), this.xnfilamodelodetalletto, 4);
                    this.xmodelodetalletto.setValueAt(this.JTFNCodigoDxP1.getText(), this.xnfilamodelodetalletto, 5);
                    this.xmodelodetalletto.setValueAt(this.xidtipodx1[this.JCBTipoDx1.getSelectedIndex()], this.xnfilamodelodetalletto, 6);
                    this.xmodelodetalletto.setValueAt(this.JCBTipoDx1.getSelectedItem().toString(), this.xnfilamodelodetalletto, 7);
                    this.xnfilamodelodetalletto++;
                    mLimpiarDatosAtencionTto();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de dx", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDx1.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo de dx no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP1.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProcedimiento.requestFocus();
    }

    private void mNuevo() {
        this.xsql = "SELECT `f_tiposervicio`.`Id`, `f_tiposervicio`.`Nbre`, `f_tipoprocedimiento`.`Id` FROM  `g_procedimiento` INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `f_tiposervicio`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) WHERE (`f_tipoprocedimiento`.`Id` in (18,10) AND `g_procedimiento`.`Estado` =0) GROUP BY `f_tiposervicio`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC ";
        this.xidservicio = this.xct.llenarComboyLista(this.xsql, this.xidservicio, this.JCBTipoServicio, 3);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.xidtipodx1 = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_tipodiagnostico`", this.xidtipodx1, this.JCBTipoDx1);
        this.JCBTipoDx1.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBTipoServicio.requestFocus();
        mCrearTablaDetalleTto();
        this.xlleno = true;
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "Odontolgia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    private void mBuscarGuiasPatologias(String codigo) {
        try {
            String sql = "SELECT PathGuia FROM h_patologiaxguiamanejo WHERE (Id_Patologia ='" + codigo + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                int x = JOptionPane.showInternalConfirmDialog(this, "El código tiene una guia asociada \n\t\t Desea consultarla?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xmt.mostrarPdf(xrs.getString(1));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFHistoriaOdontologica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLimpiarDatosAtencionTto() {
        this.JSPNDiente.setValue(new Integer(0));
        this.JSPNCitas.setValue(new Integer(1));
        this.JTFCDxP1.setText("");
        this.JTFNCodigoDxP1.setText("");
        this.JCBTipoServicio.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleTto() {
        this.xmodelodetalletto = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "NDiente", "NCitas", "Dx", "Nombre Diagnóstico", "IdTipoDx", "Tipo Dx"}) { // from class: Odontologia.JPDatosTratamiento.7
            Class[] types = {Long.class, String.class, Long.class, Long.class, String.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTto.setModel(this.xmodelodetalletto);
        this.JTDetalleTto.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleTto.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleTto.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalleTto.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleTto.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.xnfilamodelodetalletto = 0;
    }
}
