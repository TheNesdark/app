package Sig;

import Acceso.Menus1;
import Acceso.Principal;
import Sgc.claseSgc;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JDMapaProceso.class */
public class JDMapaProceso extends JDialog {
    Principal xjfp;
    private ConsultasMySQL xct;
    private Menus1 xMenus;
    private JButton JBAtencion;
    private JButton JBCalidad;
    private JButton JBCompras;
    private JButton JBConsulta;
    private JButton JBFarmacia;
    private JButton JBFinanciera;
    private JButton JBHumanos;
    private JButton JBLogistica;
    private JButton JBPYP;
    private JButton JBPlaneacion;
    private JButton JBRX;
    private JButton JBSalud_Ocupacional;
    private JButton JBSeguridad;
    private JButton JBSistemas;
    private JButton JBTerapia;
    private JButton JBUrgencia;
    private JPanel JPIMapa;
    private JLabel jLabel1;

    public JDMapaProceso(Frame parent, boolean modal) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        this.xjfp = (Principal) parent;
        this.xMenus = new Menus1(this.xjfp);
        mDesactivarBotones();
        mActivarBotones();
    }

    private void initComponents() {
        this.JPIMapa = new JPanel();
        this.JBSistemas = new JButton();
        this.JBAtencion = new JButton();
        this.JBCalidad = new JButton();
        this.JBConsulta = new JButton();
        this.JBTerapia = new JButton();
        this.JBUrgencia = new JButton();
        this.JBRX = new JButton();
        this.JBPYP = new JButton();
        this.JBFarmacia = new JButton();
        this.JBPlaneacion = new JButton();
        this.JBHumanos = new JButton();
        this.JBLogistica = new JButton();
        this.JBCompras = new JButton();
        this.JBSeguridad = new JButton();
        this.JBFinanciera = new JButton();
        this.JBSalud_Ocupacional = new JButton();
        this.jLabel1 = new JLabel();
        setDefaultCloseOperation(2);
        this.JPIMapa.setLayout(new AbsoluteLayout());
        this.JBSistemas.setBackground(new Color(255, 255, 255));
        this.JBSistemas.setFont(new Font("Arial", 1, 16));
        this.JBSistemas.setForeground(new Color(0, 103, 0));
        this.JBSistemas.setText("<html><P ALIGN=center>SISTEMA DE INFORMACIÓN");
        this.JBSistemas.setName("5");
        this.JBSistemas.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.1
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBSistemasActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBSistemas, new AbsoluteConstraints(380, 620, 280, 40));
        this.JBAtencion.setBackground(new Color(255, 255, 255));
        this.JBAtencion.setFont(new Font("Arial", 1, 16));
        this.JBAtencion.setForeground(new Color(0, 103, 0));
        this.JBAtencion.setText("ATENCIÓN AL USUARIO");
        this.JBAtencion.setName("22");
        this.JBAtencion.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.2
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBAtencionActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBAtencion, new AbsoluteConstraints(230, 450, 550, 40));
        this.JBCalidad.setBackground(new Color(255, 255, 255));
        this.JBCalidad.setFont(new Font("Arial", 1, 16));
        this.JBCalidad.setForeground(new Color(0, 103, 0));
        this.JBCalidad.setText("<html><P ALIGN=center>GESTIÓN DE CALIDAD");
        this.JBCalidad.setName("2");
        this.JBCalidad.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.3
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBCalidadActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBCalidad, new AbsoluteConstraints(570, 130, 140, 50));
        this.JBConsulta.setBackground(new Color(255, 255, 255));
        this.JBConsulta.setFont(new Font("Arial", 1, 16));
        this.JBConsulta.setForeground(new Color(0, 102, 0));
        this.JBConsulta.setText("<html><P ALIGN=center>CONSULTA EXTERNA");
        this.JBConsulta.setName("6");
        this.JBConsulta.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.4
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBConsultaActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBConsulta, new AbsoluteConstraints(250, 240, 140, 50));
        this.JBTerapia.setBackground(new Color(255, 255, 255));
        this.JBTerapia.setFont(new Font("Arial", 1, 16));
        this.JBTerapia.setForeground(new Color(0, 103, 0));
        this.JBTerapia.setText("<html><P ALIGN=center>APOYO TERAPÉUTICO");
        this.JBTerapia.setName("15");
        this.JBTerapia.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.5
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBTerapiaActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBTerapia, new AbsoluteConstraints(620, 310, 140, 50));
        this.JBUrgencia.setBackground(new Color(255, 255, 255));
        this.JBUrgencia.setFont(new Font("Arial", 1, 16));
        this.JBUrgencia.setForeground(new Color(0, 102, 0));
        this.JBUrgencia.setText("URGENCIAS");
        this.JBUrgencia.setEnabled(false);
        this.JBUrgencia.setName("10");
        this.JBUrgencia.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.6
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBUrgenciaActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBUrgencia, new AbsoluteConstraints(430, 240, 140, 50));
        this.JBRX.setBackground(new Color(255, 255, 255));
        this.JBRX.setFont(new Font("Arial", 1, 16));
        this.JBRX.setForeground(new Color(0, 103, 0));
        this.JBRX.setText("<html><P ALIGN=center>APOYO DIAGNÓSTICO");
        this.JBRX.setName("11");
        this.JBRX.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.7
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBRXActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBRX, new AbsoluteConstraints(430, 310, 140, 50));
        this.JBPYP.setBackground(new Color(255, 255, 255));
        this.JBPYP.setFont(new Font("Arial", 1, 16));
        this.JBPYP.setForeground(new Color(0, 103, 0));
        this.JBPYP.setText("<html><P ALIGN=center>PROMOCIÓN Y PREVENCIÓN");
        this.JBPYP.setName("21");
        this.JBPYP.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.8
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBPYPActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBPYP, new AbsoluteConstraints(620, 240, 140, 50));
        this.JBFarmacia.setBackground(new Color(255, 255, 255));
        this.JBFarmacia.setFont(new Font("Arial", 1, 16));
        this.JBFarmacia.setForeground(new Color(0, 103, 0));
        this.JBFarmacia.setText("<html><P ALIGN=center>SERVICIO FARMACÉUTICO");
        this.JBFarmacia.setName("14");
        this.JBFarmacia.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.9
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBFarmaciaActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBFarmacia, new AbsoluteConstraints(230, 400, 550, 40));
        this.JBPlaneacion.setBackground(new Color(255, 255, 255));
        this.JBPlaneacion.setFont(new Font("Arial", 1, 16));
        this.JBPlaneacion.setForeground(new Color(0, 103, 0));
        this.JBPlaneacion.setText("<html><P ALIGN=center>PLANEACIÓN ESTRATÉGICA");
        this.JBPlaneacion.setName("1");
        this.JBPlaneacion.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.10
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBPlaneacionActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBPlaneacion, new AbsoluteConstraints(290, 130, 140, 50));
        this.JBHumanos.setBackground(new Color(255, 255, 255));
        this.JBHumanos.setFont(new Font("Arial", 1, 14));
        this.JBHumanos.setForeground(new Color(0, 103, 0));
        this.JBHumanos.setText("<html><P ALIGN=center>GESTIÓN DE RECURSOS HUMANOS");
        this.JBHumanos.setName("16");
        this.JBHumanos.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.11
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBHumanosActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBHumanos, new AbsoluteConstraints(370, 540, 140, 50));
        this.JBLogistica.setBackground(new Color(255, 255, 255));
        this.JBLogistica.setFont(new Font("Arial", 1, 14));
        this.JBLogistica.setForeground(new Color(0, 103, 0));
        this.JBLogistica.setText("<html><P ALIGN=center>GESTIÓN DE INFRAESTRUCTURA");
        this.JBLogistica.setName("17");
        this.JBLogistica.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.12
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBLogisticaActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBLogistica, new AbsoluteConstraints(220, 540, 140, 50));
        this.JBCompras.setBackground(new Color(255, 255, 255));
        this.JBCompras.setFont(new Font("Arial", 1, 14));
        this.JBCompras.setForeground(new Color(0, 103, 0));
        this.JBCompras.setText("<html><P ALIGN=center>GESTIÓN DE COMPRAS");
        this.JBCompras.setName("18");
        this.JBCompras.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.13
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBComprasActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBCompras, new AbsoluteConstraints(670, 540, 140, 50));
        this.JBSeguridad.setBackground(new Color(255, 255, 255));
        this.JBSeguridad.setFont(new Font("Arial", 1, 16));
        this.JBSeguridad.setForeground(new Color(0, 103, 0));
        this.JBSeguridad.setText("SEGURIDAD CLÍNICA");
        this.JBSeguridad.setName("100");
        this.JPIMapa.add(this.JBSeguridad, new AbsoluteConstraints(400, 40, 210, 40));
        this.JBFinanciera.setBackground(new Color(255, 255, 255));
        this.JBFinanciera.setFont(new Font("Arial", 1, 14));
        this.JBFinanciera.setForeground(new Color(0, 103, 0));
        this.JBFinanciera.setText("<html><P ALIGN=center>GESTIÓN FINANCIERA");
        this.JBFinanciera.setName("19");
        this.JBFinanciera.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.14
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBFinancieraActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBFinanciera, new AbsoluteConstraints(520, 540, 140, 50));
        this.JBSalud_Ocupacional.setBackground(new Color(255, 255, 255));
        this.JBSalud_Ocupacional.setFont(new Font("Arial", 1, 16));
        this.JBSalud_Ocupacional.setForeground(new Color(0, 103, 0));
        this.JBSalud_Ocupacional.setText("<html><P ALIGN=center>SALUD OCUPACIONAL");
        this.JBSalud_Ocupacional.setName("22");
        this.JBSalud_Ocupacional.addActionListener(new ActionListener() { // from class: Sig.JDMapaProceso.15
            public void actionPerformed(ActionEvent evt) {
                JDMapaProceso.this.JBSalud_OcupacionalActionPerformed(evt);
            }
        });
        this.JPIMapa.add(this.JBSalud_Ocupacional, new AbsoluteConstraints(250, 310, 140, 50));
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/procesos.jpg")));
        this.JPIMapa.add(this.jLabel1, new AbsoluteConstraints(10, -10, 1000, 710));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIMapa, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIMapa, -1, 767, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBPYPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSigPyP, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBPYP.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSistemasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP5, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBSistemas.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBHumanosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP16, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBHumanos.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBPlaneacionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP1, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBPlaneacion.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBPlaneacion.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalidadActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP2, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBCalidad.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBCalidad.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBConsultaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP6, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBConsulta.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBConsulta.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBUrgenciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP9, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBUrgencia.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBUrgencia.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFarmaciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP14, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBFarmacia.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBFarmacia.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTerapiaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP15, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBTerapia.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBTerapia.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBLogisticaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP17, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBLogistica.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBLogistica.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBComprasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFinancieraActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP19, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBFinanciera.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBFinanciera.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAtencionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP22, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBAtencion.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBAtencion.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBRXActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP11, 1);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBRX.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBRX.getName()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalud_OcupacionalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjfp;
        Menus1 menus1 = this.xMenus;
        principal.mActivarBarraMenu(Menus1.JMBSgcP4, 22);
        Principal.informacionGeneralPrincipalDTO.setIdTipoProceso(Long.valueOf(this.JBSalud_Ocupacional.getName()));
        Principal.informacionGeneralPrincipalDTO.setNombreProceso(mBNombreProceso(this.JBSalud_Ocupacional.getName()));
        dispose();
    }

    private void mInicarClases() {
        Principal principal = this.xjfp;
        Principal.xclasesgc = new claseSgc();
    }

    private String mBNombreProceso(String xidp) {
        String xsql = "SELECT Nbre FROM s_sgc_tipoproceso WHERE (Id ='" + xidp + "')";
        String xnombrep = this.xct.traerDato(xsql);
        this.xct.cerrarConexionBd();
        return xnombrep;
    }

    private void mDesactivarBotones() {
        for (int x = 0; x < this.JPIMapa.getComponentCount(); x++) {
            if (this.JPIMapa.getComponent(x).getClass().toString().equals("class javax.swing.JButton")) {
                JButton xbt = this.JPIMapa.getComponent(x);
                xbt.setEnabled(false);
            }
        }
    }

    private void mActivarBotones() {
        try {
            String sql = "SELECT Id_TipoProceso FROM s_sgc_usuario_tipoproceso WHERE (Id_Usuario ='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Estado =1) ORDER BY Id_TipoProceso ASC ";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    for (int x = 0; x < this.JPIMapa.getComponentCount(); x++) {
                        if (this.JPIMapa.getComponent(x).getClass().toString().equals("class javax.swing.JButton")) {
                            JButton xbt = this.JPIMapa.getComponent(x);
                            if (xbt.getName().equals(xrs.getString(1))) {
                                xbt.setEnabled(true);
                            }
                        }
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDMapaProceso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
