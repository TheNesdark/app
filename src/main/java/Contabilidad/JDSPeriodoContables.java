package Contabilidad;

import Acceso.Menus;
import Acceso.Menus1;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JDSPeriodoContables.class */
public class JDSPeriodoContables extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String[][] xid;
    private String xsql;
    private String xModulo;
    private Principal xjfprincipal;
    private int xidt;
    private int xtipo;
    private ButtonGroup JBG_Tipo;
    private JButton JBTOk;
    private JButton JBTSalir;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JLabel JLBTitulo;
    private JPanel JPI_TipoMov;
    private JRadioButton JRB_Tipo1;
    private JRadioButton JRB_Tipo2;
    private JYearChooser JYCAno;
    private JPanel jPanel1;
    private JSeparator jSeparator1;

    public JDSPeriodoContables(Frame parent, boolean modal, int xidt) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xidt = 0;
        this.xtipo = 0;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjfprincipal = (Principal) parent;
        initComponents();
        this.xidt = xidt;
        this.xModulo = this.xModulo;
        mNuevo();
        this.JPI_TipoMov.setVisible(false);
    }

    private void initComponents() {
        this.JBG_Tipo = new ButtonGroup();
        this.JLBTitulo = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.JBTOk = new JButton();
        this.JBTSalir = new JButton();
        this.jPanel1 = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JPI_TipoMov = new JPanel();
        this.JRB_Tipo1 = new JRadioButton();
        this.JRB_Tipo2 = new JRadioButton();
        setDefaultCloseOperation(2);
        setTitle("MÓDULO CONTABLE");
        this.JLBTitulo.setFont(new Font("Arial", 1, 18));
        this.JLBTitulo.setForeground(new Color(0, 102, 0));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("SELECCIÓN DE PERIODO CONTABLE");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder(0));
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Ok");
        this.JBTOk.addActionListener(new ActionListener() { // from class: Contabilidad.JDSPeriodoContables.1
            public void actionPerformed(ActionEvent evt) {
                JDSPeriodoContables.this.JBTOkActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Contabilidad.JDSPeriodoContables.2
            public void actionPerformed(ActionEvent evt) {
                JDSPeriodoContables.this.JBTSalirActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.setFont(new Font("Arial", 1, 12));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JDSPeriodoContables.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDSPeriodoContables.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JDSPeriodoContables.4
            public void actionPerformed(ActionEvent evt) {
                JDSPeriodoContables.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JPI_TipoMov.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTOS EN:", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Tipo.add(this.JRB_Tipo1);
        this.JRB_Tipo1.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo1.setSelected(true);
        this.JRB_Tipo1.setText("Colgaap");
        this.JRB_Tipo1.addActionListener(new ActionListener() { // from class: Contabilidad.JDSPeriodoContables.5
            public void actionPerformed(ActionEvent evt) {
                JDSPeriodoContables.this.JRB_Tipo1ActionPerformed(evt);
            }
        });
        this.JBG_Tipo.add(this.JRB_Tipo2);
        this.JRB_Tipo2.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo2.setText("Niif");
        this.JRB_Tipo2.addActionListener(new ActionListener() { // from class: Contabilidad.JDSPeriodoContables.6
            public void actionPerformed(ActionEvent evt) {
                JDSPeriodoContables.this.JRB_Tipo2ActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoMovLayout = new GroupLayout(this.JPI_TipoMov);
        this.JPI_TipoMov.setLayout(JPI_TipoMovLayout);
        JPI_TipoMovLayout.setHorizontalGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoMovLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Tipo1).addGap(18, 18, 18).addComponent(this.JRB_Tipo2).addContainerGap(15, 32767)));
        JPI_TipoMovLayout.setVerticalGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoMovLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Tipo1).addComponent(this.JRB_Tipo2))));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo, -1, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPI_TipoMov, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHActivo).addComponent(this.JYCAno, -2, -1, -2).addComponent(this.JCBPeriodo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_TipoMov, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLBTitulo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTOk, -2, 240, -2).addGap(10, 10, 10).addComponent(this.JBTSalir, -2, 240, -2)).addComponent(this.jSeparator1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jSeparator1, -2, 10, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTOk, -2, 40, -2).addComponent(this.JBTSalir, -2, 40, -2)).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.xidt != 3) {
                Principal.xclase.setXidperiodoc(Integer.valueOf(this.xid[this.JCBPeriodo.getSelectedIndex()][0]).intValue());
                Principal.xclase.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][1]);
                Principal.xclase.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][2]);
                Principal.xclase.setXfechai(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][1] + " 00:00:00"));
                Principal.xclase.setXfechaf(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][2] + " 23:59:59"));
                Principal.xclase.setxForma_Gn_Niif(this.xtipo);
                Principal.xclase.setNombrePeriodo(this.JCBPeriodo.getSelectedItem().toString());
                System.out.println("if " + this.xid[this.JCBPeriodo.getSelectedIndex()][3]);
                if (this.xid[this.JCBPeriodo.getSelectedIndex()][3].equals("1")) {
                    Principal.xclase.setXestadop(true);
                } else {
                    Principal.xclase.setXestadop(false);
                }
                Principal.xclase.frmPrincipal.JLBPeridoC.setText(this.JCBPeriodo.getSelectedItem().toString() + " - " + this.JYCAno.getValue());
                switch (this.xidt) {
                    case 0:
                        this.xjfprincipal.mActivarBarraMenu(Menus.barraMnuContabilidad, 6);
                        if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                            if (Principal.usuarioSistemaDTO.getLogin().equals("YROJASG")) {
                                Menus.JMIUAjusteDoc1.setEnabled(true);
                                Menus.JMIUModificacionDocC.setEnabled(true);
                            } else {
                                Menus.JMIUAjusteDoc1.setEnabled(false);
                                Menus.JMIUModificacionDocC.setEnabled(false);
                            }
                        }
                        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                            this.xjfprincipal.xMenus.JMICGPago.setVisible(true);
                        } else {
                            this.xjfprincipal.xMenus.JMICGPago.setVisible(false);
                        }
                        break;
                    case 1:
                        this.xjfprincipal.mActivarBarraMenu(Menus.barraMnuGCuentas, 9);
                        break;
                    case 2:
                        this.xjfprincipal.mActivarBarraMenu(Menus.barraMnuFacturacion, 9);
                        break;
                    case 4:
                        this.xjfprincipal.mActivarBarraMenu(Menus1.barraMnuTesoreria, 38);
                        break;
                }
            } else {
                Principal.xClaseInventario.setXidperiodoc(Integer.parseInt(this.xid[this.JCBPeriodo.getSelectedIndex()][0]));
                Principal.xClaseInventario.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][1]);
                Principal.xClaseInventario.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][2]);
                Principal.xClaseInventario.setXfechai(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][1] + " 00:00:00"));
                Principal.xClaseInventario.setXfechaf(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][2] + " 23:59:59"));
                System.out.println("else " + this.xid[this.JCBPeriodo.getSelectedIndex()][3]);
                if (this.xid[this.JCBPeriodo.getSelectedIndex()][3].equals("1")) {
                    Principal.xClaseInventario.setXestadop(true);
                    if (Principal.xclase != null) {
                        Principal.xclase.setXidperiodoc(Integer.valueOf(this.xid[this.JCBPeriodo.getSelectedIndex()][0]).intValue());
                        Principal.xclase.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][1]);
                        Principal.xclase.setXfechaperiodo(this.xid[this.JCBPeriodo.getSelectedIndex()][2]);
                        Principal.xclase.setXfechai(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][1] + " 00:00:00"));
                        Principal.xclase.setXfechaf(this.xmt.getPasarTextoAFechaHora(this.xid[this.JCBPeriodo.getSelectedIndex()][2] + " 23:59:59"));
                        Principal.xclase.setxForma_Gn_Niif(this.xtipo);
                        Principal.xclase.setNombrePeriodo(this.JCBPeriodo.getSelectedItem().toString());
                        Principal.xclase.setXestadop(true);
                    }
                } else {
                    Principal.xClaseInventario.setXestadop(false);
                    Principal.xclase.setXestadop(false);
                }
                Principal.xClaseInventario.frmPrincipal.JLBPeridoC.setText(this.xid[this.JCBPeriodo.getSelectedIndex()][5] + " - " + this.JCBPeriodo.getSelectedItem().toString() + " - " + this.JYCAno.getValue());
            }
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo2ActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo1ActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    private void mNuevo() {
        this.JYCAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        this.xtipo = 0;
        mCargarCombo();
        if (this.xidt == 3 || this.xidt == 4 || this.xidt == 1) {
            this.JCHActivo.setEnabled(false);
        }
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            if (this.xidt != 3) {
                this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado,  MONTH(`FechaI`)  FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
            } else {
                this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado,  MONTH(`FechaI`)  FROM i_periodo WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
            }
        } else if (this.xidt != 3) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado,  MONTH(`FechaI`) FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=0 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado,  MONTH(`FechaI`) FROM i_periodo WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=0  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 7);
        this.xct.cerrarConexionBd();
    }
}
