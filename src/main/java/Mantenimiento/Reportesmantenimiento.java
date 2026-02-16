package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/Reportesmantenimiento.class */
public class Reportesmantenimiento extends JInternalFrame {
    public static claseMantenimiento clasemant;
    private String[] xidarea;
    private String[] xidtipo;
    private String[] xidestado;
    private JComboBox Eva;
    private JComboBox JCB;
    private JComboBox JCBArea;
    private JComboBox JCBestado;
    private JComboBox JCBtipo;
    private JDateChooser fechados;
    private JDateChooser fechauno;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private Metodos xmetodo = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();

    public Reportesmantenimiento() {
        initComponents();
        this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
        this.JCBArea.setSelectedIndex(-1);
        this.xidestado = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipoestadoreporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidestado, this.JCBestado);
        this.JCBestado.setSelectedIndex(-1);
        this.xidtipo = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tiporeporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipo, this.JCBtipo);
        this.JCBtipo.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    private void initComponents() {
        this.JCB = new JComboBox();
        this.jPanel1 = new JPanel();
        this.fechauno = new JDateChooser();
        this.jLabel1 = new JLabel();
        this.fechados = new JDateChooser();
        this.jPanel2 = new JPanel();
        this.JCBArea = new JComboBox();
        this.jPanel3 = new JPanel();
        this.JCBestado = new JComboBox();
        this.jButton1 = new JButton();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jPanel4 = new JPanel();
        this.JCBtipo = new JComboBox();
        this.Eva = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REPORTES MATENIMIENTO ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(736, 380));
        setMinimumSize(new Dimension(736, 380));
        getContentPane().setLayout(new AbsoluteLayout());
        this.JCB.setFont(new Font("Arial", 1, 12));
        this.JCB.setModel(new DefaultComboBoxModel(new String[]{"--", "Todos", "Evaluacion", "Tipo", "Tipo y Area", "Tipo y Estado", "Tipo y Fecha", "Fecha", "Area", "Area y Fecha", "Estado Reporte", "Estado Reporte y Fecha", "Estado Reporte y Area", "Estado Reporte, Area y Fecha"}));
        this.JCB.setBorder(BorderFactory.createTitledBorder((Border) null, "parametro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB.addActionListener(new ActionListener() { // from class: Mantenimiento.Reportesmantenimiento.1
            public void actionPerformed(ActionEvent evt) {
                Reportesmantenimiento.this.JCBActionPerformed(evt);
            }
        });
        getContentPane().add(this.JCB, new AbsoluteConstraints(10, 20, 220, -1));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fechas Reporte", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.fechauno.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12)));
        this.fechauno.setDateFormatString("yyyy-MM-dd");
        this.fechauno.setEnabled(false);
        this.fechauno.setFont(new Font("Arial", 1, 12));
        this.fechauno.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Reportesmantenimiento.2
            public void mouseClicked(MouseEvent evt) {
                Reportesmantenimiento.this.fechaunoMouseClicked(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 1, 18));
        this.jLabel1.setText("Y");
        this.fechados.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12)));
        this.fechados.setDateFormatString("yyyy-MM-dd");
        this.fechados.setEnabled(false);
        this.fechados.setFont(new Font("Arial", 1, 12));
        this.fechados.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Reportesmantenimiento.3
            public void mouseClicked(MouseEvent evt) {
                Reportesmantenimiento.this.fechadosMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.fechauno, -1, 308, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(115, 115, 115).addComponent(this.jLabel1)).addComponent(this.fechados, -1, 304, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.fechauno, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fechados, -2, -1, -2).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 79, 330, -1));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Areas Reporte", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.setEnabled(false);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBArea, 0, 338, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBArea, -2, 45, -2).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(350, 0, 350, 80));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Reporte", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBestado.setFont(new Font("Arial", 1, 12));
        this.JCBestado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBestado.setEnabled(false);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBestado, 0, 338, 32767));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCBestado, -2, 45, -2).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel3, new AbsoluteConstraints(350, 170, 350, -1));
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setForeground(new Color(0, 102, 204));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.jButton1.setText("GENERAR REPORTE");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.Reportesmantenimiento.4
            public void actionPerformed(ActionEvent evt) {
                Reportesmantenimiento.this.jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton1, new AbsoluteConstraints(10, 260, 690, 50));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("jLabel2");
        getContentPane().add(this.jLabel2, new AbsoluteConstraints(50, 320, -1, -1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("jLabel2");
        getContentPane().add(this.jLabel3, new AbsoluteConstraints(560, 320, -1, -1));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reporte", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBtipo.setFont(new Font("Arial", 1, 12));
        this.JCBtipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBtipo.setEnabled(false);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBtipo, 0, 298, 32767).addGap(40, 40, 40)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBtipo, -2, 45, -2).addContainerGap(-1, 32767)));
        getContentPane().add(this.jPanel4, new AbsoluteConstraints(350, 80, 350, -1));
        this.Eva.setFont(new Font("Arial", 1, 12));
        this.Eva.setModel(new DefaultComboBoxModel(new String[]{"P", "C"}));
        this.Eva.setBorder(BorderFactory.createTitledBorder((Border) null, "Evaluacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Eva.setEnabled(false);
        this.Eva.addActionListener(new ActionListener() { // from class: Mantenimiento.Reportesmantenimiento.5
            public void actionPerformed(ActionEvent evt) {
                Reportesmantenimiento.this.EvaActionPerformed(evt);
            }
        });
        getContentPane().add(this.Eva, new AbsoluteConstraints(240, 20, 100, -1));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActionPerformed(ActionEvent evt) {
        if (this.JCB.getSelectedItem().equals("Fecha")) {
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.JCBArea.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Evaluacion")) {
            this.Eva.setEnabled(true);
            this.JCBArea.setEnabled(false);
            this.JCBestado.setEnabled(false);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Area")) {
            this.JCBArea.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Area y Fecha")) {
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.JCBArea.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte")) {
            this.JCBestado.setEnabled(true);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            this.JCBArea.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte y Fecha")) {
            this.JCBestado.setEnabled(true);
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.JCBArea.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte y Area")) {
            this.JCBestado.setEnabled(true);
            this.JCBArea.setEnabled(true);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte, Area y Fecha")) {
            this.JCBestado.setEnabled(true);
            this.JCBArea.setEnabled(true);
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo")) {
            this.JCBtipo.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            this.JCBArea.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo y Area")) {
            this.JCBtipo.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.JCBArea.setEnabled(true);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo y Estado")) {
            this.JCBtipo.setEnabled(true);
            this.JCBestado.setEnabled(true);
            this.JCBArea.setEnabled(false);
            this.fechauno.setEnabled(false);
            this.fechados.setEnabled(false);
            this.Eva.setEnabled(false);
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo y Fecha")) {
            this.JCBtipo.setEnabled(true);
            this.JCBestado.setEnabled(false);
            this.JCBArea.setEnabled(false);
            this.fechauno.setEnabled(true);
            this.fechados.setEnabled(true);
            this.Eva.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JCB.getSelectedItem().equals("Fecha")) {
            imprimir3();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Todos")) {
            imprimirtodo();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Evaluacion")) {
            imprimir20();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Area")) {
            imprimir();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Area y Fecha")) {
            imprimir7();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte")) {
            imprimir2();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte y Fecha")) {
            imprimir6();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte y Area")) {
            imprimir4();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Estado Reporte, Area y Fecha")) {
            imprimir5();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo")) {
            imprimir8();
            return;
        }
        if (this.JCB.getSelectedItem().equals("Tipo y Area")) {
            imprimir9();
        } else if (this.JCB.getSelectedItem().equals("Tipo y Estado")) {
            imprimir11();
        } else if (this.JCB.getSelectedItem().equals("Tipo y Fecha")) {
            imprimir10();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EvaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fechaunoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fechadosMouseClicked(MouseEvent evt) {
    }

    public void imprimir() {
        String[][] mparametros = new String[4][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBArea.getSelectedItem().toString();
        mparametros[1][0] = "sede";
        mparametros[1][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes", mparametros);
        }
    }

    public void imprimirtodo() {
        String[][] mparametros = new String[3][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "sede";
        mparametros[0][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportestodos.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportestodos", mparametros);
        }
    }

    public void imprimir20() {
        String[][] mparametros = new String[4][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "pc";
        mparametros[0][1] = this.Eva.getSelectedItem().toString();
        mparametros[1][0] = "sede";
        mparametros[1][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes20.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes20", mparametros);
        }
    }

    public void imprimir2() {
        String[][] mparametros = new String[4][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBestado.getSelectedItem().toString();
        mparametros[1][0] = "sede";
        mparametros[1][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes2.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes2", mparametros);
        }
    }

    public void imprimir3() {
        String[][] mparametros = new String[5][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        this.jLabel2.setText(this.xmetodo.formatoAMD.format(this.fechauno.getDate()));
        this.jLabel3.setText(this.xmetodo.formatoAMD.format(this.fechados.getDate()));
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.jLabel2.getText();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.jLabel3.getText();
        mparametros[2][0] = "sede";
        mparametros[2][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes3.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes3", mparametros);
        }
    }

    public void imprimir4() {
        String[][] mparametros = new String[5][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBArea.getSelectedItem().toString();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.JCBestado.getSelectedItem().toString();
        mparametros[2][0] = "sede";
        mparametros[2][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes4.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes4", mparametros);
        }
    }

    public void imprimir5() {
        String[][] mparametros = new String[7][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        this.jLabel2.setText(this.xmetodo.formatoAMD.format(this.fechauno.getDate()));
        this.jLabel3.setText(this.xmetodo.formatoAMD.format(this.fechados.getDate()));
        mparametros[2][0] = "Id3";
        mparametros[2][1] = this.jLabel2.getText();
        mparametros[3][0] = "Id4";
        mparametros[3][1] = this.jLabel3.getText();
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBArea.getSelectedItem().toString();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.JCBestado.getSelectedItem().toString();
        mparametros[4][0] = "sede";
        mparametros[4][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[5][0] = "SUBREPORT_DIR";
        mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[6][0] = "SUBREPORTFIRMA_DIR";
        mparametros[6][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes5.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes5", mparametros);
        }
    }

    public void imprimir6() {
        String[][] mparametros = new String[6][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        this.jLabel2.setText(this.xmetodo.formatoAMD.format(this.fechauno.getDate()));
        this.jLabel3.setText(this.xmetodo.formatoAMD.format(this.fechados.getDate()));
        mparametros[1][0] = "Id3";
        mparametros[1][1] = this.jLabel2.getText();
        mparametros[2][0] = "Id4";
        mparametros[2][1] = this.jLabel3.getText();
        mparametros[0][0] = "Id2";
        mparametros[0][1] = this.JCBestado.getSelectedItem().toString();
        mparametros[3][0] = "sede";
        mparametros[3][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[4][0] = "SUBREPORT_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes6.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes6", mparametros);
        }
    }

    public void imprimir7() {
        String[][] mparametros = new String[6][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        this.jLabel2.setText(this.xmetodo.formatoAMD.format(this.fechauno.getDate()));
        this.jLabel3.setText(this.xmetodo.formatoAMD.format(this.fechados.getDate()));
        mparametros[1][0] = "Id3";
        mparametros[1][1] = this.jLabel2.getText();
        mparametros[2][0] = "Id4";
        mparametros[2][1] = this.jLabel3.getText();
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBArea.getSelectedItem().toString();
        mparametros[3][0] = "sede";
        mparametros[3][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[4][0] = "SUBREPORT_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes7.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes7", mparametros);
        }
    }

    public void imprimir8() {
        String[][] mparametros = new String[4][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBtipo.getSelectedItem().toString();
        mparametros[1][0] = "sede";
        mparametros[1][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes8.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes8", mparametros);
        }
    }

    public void imprimir9() {
        String[][] mparametros = new String[5][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, (Icon) null, botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBArea.getSelectedItem().toString();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.JCBtipo.getSelectedItem().toString();
        mparametros[2][0] = "sede";
        mparametros[2][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes9.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes9", mparametros);
        }
    }

    public void imprimir10() {
        String[][] mparametros = new String[6][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        this.jLabel2.setText(this.xmetodo.formatoAMD.format(this.fechauno.getDate()));
        this.jLabel3.setText(this.xmetodo.formatoAMD.format(this.fechados.getDate()));
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.jLabel2.getText();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.jLabel3.getText();
        mparametros[2][0] = "Id3";
        mparametros[2][1] = this.JCBtipo.getSelectedItem().toString();
        mparametros[3][0] = "sede";
        mparametros[3][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[4][0] = "SUBREPORT_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[5][0] = "SUBREPORTFIRMA_DIR";
        mparametros[5][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes10.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes10", mparametros);
        }
    }

    public void imprimir11() {
        String[][] mparametros = new String[5][2];
        Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JCBtipo.getSelectedItem().toString();
        mparametros[1][0] = "Id2";
        mparametros[1][1] = this.JCBestado.getSelectedItem().toString();
        mparametros[2][0] = "sede";
        mparametros[2][1] = Principal.sedeUsuarioSeleccionadaDTO.getId().toString();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        if (n == 0) {
            this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "m_estadisticasreportes11.jasper", mparametros);
        } else if (n == 1) {
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "m_estadisticasreportes11", mparametros);
        }
    }
}
