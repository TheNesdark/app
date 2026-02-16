package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/JDCreacionNDocumento.class */
public class JDCreacionNDocumento extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String[][] xidmunicipio;
    private String[][] xidtipopoblacion;
    private String xsql;
    private boolean xlleno;
    private Persona xjppersona;
    private JButton JBTCargar;
    private JButton JBTSalir;
    private JComboBox JCBMunicipio;
    private JComboBox JCBTipoPoblacion;
    private JTextField JTFNumero;
    private JPanel jPanel1;

    public JDCreacionNDocumento(Frame parent, boolean modal, Persona xjppersona) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xlleno = false;
        initComponents();
        this.xjppersona = xjppersona;
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBMunicipio = new JComboBox();
        this.JCBTipoPoblacion = new JComboBox();
        this.JTFNumero = new JTextField();
        this.JBTCargar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CREACIÓN DE NUMERO DE DOCUMENTOS ");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: General.JDCreacionNDocumento.1
            public void itemStateChanged(ItemEvent evt) {
                JDCreacionNDocumento.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JCBTipoPoblacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPoblacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Población", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoPoblacion.addItemListener(new ItemListener() { // from class: General.JDCreacionNDocumento.2
            public void itemStateChanged(ItemEvent evt) {
                JDCreacionNDocumento.this.JCBTipoPoblacionItemStateChanged(evt);
            }
        });
        this.JTFNumero.setEditable(false);
        this.JTFNumero.setBackground(new Color(255, 255, 255));
        this.JTFNumero.setFont(new Font("Arial", 1, 18));
        this.JTFNumero.setForeground(new Color(255, 0, 0));
        this.JTFNumero.setHorizontalAlignment(0);
        this.JTFNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero de Identificación", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNumero).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBMunicipio, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoPoblacion, -2, 277, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMunicipio, -2, 50, -2).addComponent(this.JCBTipoPoblacion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 40, 32767).addComponent(this.JTFNumero, -2, 52, -2).addGap(22, 22, 22)));
        this.JBTCargar.setFont(new Font("Arial", 1, 14));
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCargar.setText("Cargar");
        this.JBTCargar.addActionListener(new ActionListener() { // from class: General.JDCreacionNDocumento.3
            public void actionPerformed(ActionEvent evt) {
                JDCreacionNDocumento.this.JBTCargarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 14));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JDCreacionNDocumento.4
            public void actionPerformed(ActionEvent evt) {
                JDCreacionNDocumento.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTCargar, -2, 300, -2).addGap(27, 27, 27).addComponent(this.JBTSalir, -1, 300, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTCargar, -1, 50, 32767).addComponent(this.JBTSalir, -1, 50, 32767)).addGap(20, 20, 20)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.JCBMunicipio.getSelectedIndex() != -1 && this.xlleno) {
            mContruirNumero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoPoblacionItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoPoblacion.getSelectedIndex() != -1 && this.xlleno) {
            mContruirNumero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        if (!this.JTFNumero.getText().isEmpty()) {
            this.xjppersona.txtHistoria.setText(this.JTFNumero.getText());
            this.xjppersona.txtIdentificacion.setText(this.JTFNumero.getText());
            this.xjppersona.cboMunicipio.setSelectedItem(this.JCBMunicipio.getSelectedItem());
            this.xjppersona.cboTipoIdentificacion.requestFocus();
            dispose();
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JCBMunicipio.removeAllItems();
        this.xsql = "SELECT  `g_municipio`.`Id` , UCASE(CONCAT(`g_municipio`.`Nbre`, '-', `g_departamento`.`Nbre`)) AS `Municipio`, g_pais.`Codigo` FROM `g_municipio`  INNER JOIN  `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)   INNER JOIN `g_pais` \n        ON (`g_pais`.`Id` = `g_departamento`.`CodPais`)WHERE (`g_municipio`.`Estado` =0) ORDER BY `Municipio` ASC ";
        this.xidmunicipio = this.xct.llenarComboyLista(this.xsql, this.xidmunicipio, this.JCBMunicipio, 3);
        this.xidtipopoblacion = this.xct.llenarComboyLista("SELECT `Id`, UCASE(`Nbre`) AS Nbre, `NConsecutivo`, `NRef` FROM  `g_tipo_poblacion`;", this.xidtipopoblacion, this.JCBTipoPoblacion, 4);
        this.JCBTipoPoblacion.setSelectedIndex(-1);
        this.JCBMunicipio.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFNumero.setText("");
        this.xlleno = true;
    }

    private void mContruirNumero() {
        String xnumero = "";
        if (this.JCBMunicipio.getSelectedIndex() != -1 && this.JCBTipoPoblacion.getSelectedIndex() != -1) {
            if (this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1].equals("COL") || this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1].equals("CO")) {
                xnumero = xnumero + "" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][0] + "" + this.xidtipopoblacion[this.JCBTipoPoblacion.getSelectedIndex()][2] + "" + this.xidtipopoblacion[this.JCBTipoPoblacion.getSelectedIndex()][1];
            } else {
                try {
                    this.xsql = "SELECT g_persona.NoDocumento\n  , lpad(max(MID(g_persona.NoDocumento ,4, LENGTH(g_persona.NoDocumento))+1), 6, '0') numero\nFROM g_usuario inner join g_persona on (g_usuario.Id_persona=g_persona.Id) \nWHERE g_persona.NoDocumento  LIKE'" + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1] + "%' and MID(g_usuario.NoHistoria ,4, 1)=0  \n  and  LENGTH(MID(g_persona.NoDocumento ,4, LENGTH(g_persona.NoDocumento)))=6\n  and g_persona.Id_TipoIdentificacion in ('MS', 'AS') and MID(g_usuario.NoHistoria ,4, 1)=0 ";
                    ResultSet rs = this.xct.getResultSet(this.xsql);
                    if (rs.next()) {
                        rs.first();
                        if (rs.getString("numero") == null) {
                            xnumero = xnumero + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1] + "" + this.xidtipopoblacion[this.JCBTipoPoblacion.getSelectedIndex()][1];
                        } else {
                            xnumero = xnumero + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1] + "" + rs.getString("numero");
                        }
                    } else {
                        xnumero = xnumero + this.xidmunicipio[this.JCBMunicipio.getSelectedIndex()][1] + "" + this.xidtipopoblacion[this.JCBTipoPoblacion.getSelectedIndex()][1];
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JDCreacionNDocumento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
            this.JTFNumero.setText(xnumero);
        }
    }
}
