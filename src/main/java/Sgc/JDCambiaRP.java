package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDCambiaRP.class */
public class JDCambiaRP extends JDialog {
    private JIFFicha5w1H xJIFFicha5w1H;
    private boolean xlleno;
    private String[] xidresponsable1;
    private String[] xidprocesoa;
    ConsultasMySQL xct;
    private JComboBox JCBProcesoI;
    public JComboBox JCBResponsableI;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;

    public JDCambiaRP(Frame parent, boolean modal, JIFFicha5w1H xJIFFicha5w1H) {
        super(parent, modal);
        this.xlleno = false;
        this.xct = new ConsultasMySQL();
        initComponents();
        setLocationRelativeTo(this);
        this.xJIFFicha5w1H = xJIFFicha5w1H;
        this.jLabel1.setText(xJIFFicha5w1H.JCBResponsableI.getSelectedItem().toString());
        mLlenaCombo();
        setTitle("ACTUALIZAR RESPONSABLES EN FICHA 5W1H");
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.JCBProcesoI = new JComboBox();
        this.JCBResponsableI = new JComboBox();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable Actual", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Nuevo Responsable", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBProcesoI.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoI.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoI.addItemListener(new ItemListener() { // from class: Sgc.JDCambiaRP.1
            public void itemStateChanged(ItemEvent evt) {
                JDCambiaRP.this.JCBProcesoIItemStateChanged(evt);
            }
        });
        this.JCBResponsableI.setFont(new Font("Arial", 1, 12));
        this.JCBResponsableI.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBResponsableI, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBProcesoI, GroupLayout.Alignment.LEADING, -2, 464, -2))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBProcesoI, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBResponsableI, -2, -1, -2)));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("Actualizar");
        this.jButton1.setToolTipText("Actualizar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Sgc.JDCambiaRP.2
            public void actionPerformed(ActionEvent evt) {
                JDCambiaRP.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 46, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -1, 43, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoIItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBProcesoI.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCBResponsableI.removeAllItems();
            String xsql = "SELECT rh_tipo_persona_cargon.Id, persona.NUsuario, persona.Corre FROM persona INNER JOIN rh_tipo_persona_cargon  ON (persona.Id_persona = rh_tipo_persona_cargon.Id_Persona) INNER JOIN s_sgc_usuario_tipoproceso  ON (s_sgc_usuario_tipoproceso.Id_Usuario = persona.Id_persona) WHERE (s_sgc_usuario_tipoproceso.Id_TipoProceso ='" + this.xidprocesoa[this.JCBProcesoI.getSelectedIndex()] + "') ORDER BY persona.NUsuario ASC ";
            this.xidresponsable1 = xct1.llenarCombo(xsql, this.xidresponsable1, this.JCBResponsableI);
            xct1.cerrarConexionBd();
            this.JCBResponsableI.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        int y = JOptionPane.showConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            String sql = "UPDATE `s_sgc_ficha5w1h` SET Id_TipoProceso='" + this.xidprocesoa[this.JCBProcesoI.getSelectedIndex()] + "' , Id_RhPersonaR='" + this.xidresponsable1[this.JCBResponsableI.getSelectedIndex()] + "' WHERE Id='" + Principal.txtNo.getText() + "'";
            System.out.println("actualiza-->" + sql);
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            this.xJIFFicha5w1H.JCBProcesoI.setSelectedItem(this.JCBProcesoI.getSelectedItem());
            this.xJIFFicha5w1H.JCBResponsableI.setSelectedItem(this.JCBResponsableI.getSelectedItem());
            this.xJIFFicha5w1H.mBuscarHistorico();
            dispose();
        }
    }

    private void mLlenaCombo() {
        this.xidprocesoa = this.xct.llenarCombo("SELECT Id, Nbre FROM s_sgc_tipoproceso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidprocesoa, this.JCBProcesoI);
        this.JCBProcesoI.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }
}
