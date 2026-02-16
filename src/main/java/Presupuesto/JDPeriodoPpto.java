package Presupuesto;

import Acceso.Menus;
import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDPeriodoPpto.class */
public class JDPeriodoPpto extends JDialog {
    private ConsultasMySQL xct;
    private String[][] xid;
    private Principal xjfprincipal;
    private Metodos xmt;
    private int xllamador;
    private JButton JBTOk;
    private JButton JBTSalir;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JYearChooser JYCAno;
    private JPanel jPanel1;

    public JDPeriodoPpto(Frame parent, boolean modal, int xllamador) {
        super(parent, "PERIODO PRESUPUESTO", modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xjfprincipal = (Principal) parent;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JYCAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        this.xllamador = xllamador;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JYCAno = new JYearChooser();
        this.JCHActivo = new JCheckBox();
        this.JBTOk = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Presupuesto.JDPeriodoPpto.1
            public void itemStateChanged(ItemEvent evt) {
                JDPeriodoPpto.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.setFont(new Font("Arial", 1, 12));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDPeriodoPpto.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDPeriodoPpto.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Presupuesto.JDPeriodoPpto.3
            public void actionPerformed(ActionEvent evt) {
                JDPeriodoPpto.this.JCHActivoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPeriodo, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo, -1, 77, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JYCAno, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, 43, -2).addComponent(this.JCHActivo))).addContainerGap(12, 32767)));
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Ok");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Presupuesto.JDPeriodoPpto.4
            public void actionPerformed(ActionEvent evt) {
                JDPeriodoPpto.this.JBTOkActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Presupuesto.JDPeriodoPpto.5
            public void actionPerformed(ActionEvent evt) {
                JDPeriodoPpto.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTOk, -2, 240, -2).addGap(10, 10, 10).addComponent(this.JBTSalir, -2, 240, -2).addGap(0, 0, 32767))).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTOk, -2, 40, -2).addComponent(this.JBTSalir, -2, 40, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            Principal.informacionGeneralPrincipalDTO.setIdPeriodoPresupuesto(this.xid[this.JCBPeriodo.getSelectedIndex()][0]);
            Principal.informacionGeneralPrincipalDTO.setIdMaestroRubro(this.xid[this.JCBPeriodo.getSelectedIndex()][1]);
            Principal.informacionGeneralPrincipalDTO.setAnoPresupuesto(String.valueOf(this.JYCAno.getValue()));
            if (this.xllamador == 0) {
                Principal principal = this.xjfprincipal;
                Menus menus = this.xjfprincipal.xMenus;
                principal.mActivarBarraMenu(Menus.barraMnuPresupuesto, 6);
                Principal.xclasePresupuesto.frmPrincipal.JLBPeridoC.setText(this.xid[this.JCBPeriodo.getSelectedIndex()][2] + " " + this.JCBPeriodo.getSelectedItem().toString() + " - " + this.JYCAno.getValue());
            }
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCargarCombo() {
        String sql;
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            sql = "SELECT `Id`, `Nbre`, idEncabezado, MONTH(pp_periodo.`FechaI`)  FROM `pp_periodo` WHERE (`Cerrado` =0 AND DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "') ORDER BY Id DESC";
        } else {
            sql = "SELECT `Id`, `Nbre`, idEncabezado, MONTH(pp_periodo.`FechaI`)  FROM `pp_periodo` WHERE (DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "') ORDER BY Id DESC ";
        }
        this.xid = this.xct.llenarComboyLista(sql, this.xid, this.JCBPeriodo, 4);
        this.xct.cerrarConexionBd();
    }
}
