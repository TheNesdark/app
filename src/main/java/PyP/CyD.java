package PyP;

import General.Persona;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:PyP/CyD.class */
public class CyD extends JInternalFrame {
    public Persona frmPersona;
    private clasePyP clasepyp;
    private JButton btnAlimentacion;
    private JButton btnLenguaje;
    private JButton btnMFina;
    private JButton btnMGruesa;
    private JButton btnPSocial;
    private JButton btnResultado;
    private JLabel jLabel1;
    private JDesktopPane panelFondo;
    private JPanel panelPersona;
    private Alimentacion frmAlimento = null;
    private MotricidadGruesa frmMG = null;
    private MotricidadFina frmMF = null;
    private MotricidadGruesa frmMGruesa = null;
    private MotricidadFina frmMFina = null;
    private ValoracionLenguaje frmVLenguaje = null;
    private ValoracionPersonal frmVPersonal = null;
    private ValoracionResultado frmVResultado = null;
    private Metodos metodos = new Metodos();

    public CyD(clasePyP clase) {
        initComponents();
        this.clasepyp = clase;
        cargarPanelPersona();
    }

    public void cargarPanel(JPanel frm) {
        this.panelFondo.removeAll();
        frm.setBounds(1, 1, 1187, 595);
        this.panelFondo.add(frm);
        this.panelFondo.setVisible(true);
        frm.setVisible(true);
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(0, 0, 1100, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    public void grabar() {
        if (!this.panelFondo.getComponent(0).getName().equals("Alimentacion")) {
            if (!this.panelFondo.getComponent(0).getName().equals("MotricidadGruesa")) {
                if (this.panelFondo.getComponent(0).getName().equals("MotricidadFina")) {
                    this.frmMF.grabar();
                    return;
                }
                return;
            }
            this.frmMG.grabar();
            return;
        }
        this.frmAlimento.grabar();
    }

    public void nuevo() {
        if (!this.panelFondo.getComponent(0).getName().equals("Alimentacion")) {
            if (!this.panelFondo.getComponent(0).getName().equals("MotricidadGruesa")) {
                if (this.panelFondo.getComponent(0).getName().equals("MotricidadFina")) {
                    this.frmMF.nuevo();
                    return;
                }
                return;
            }
            this.frmMG.nuevo();
            return;
        }
        this.frmAlimento.nuevo();
    }

    private void initComponents() {
        this.btnPSocial = new JButton();
        this.btnAlimentacion = new JButton();
        this.btnMGruesa = new JButton();
        this.btnMFina = new JButton();
        this.btnLenguaje = new JButton();
        this.panelPersona = new JPanel();
        this.btnResultado = new JButton();
        this.panelFondo = new JDesktopPane();
        this.jLabel1 = new JLabel();
        setClosable(true);
        setTitle("PROGRAMA DE CRECIMIENTO Y DESARROLLO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1207, 796));
        setName("CyD");
        setPreferredSize(new Dimension(1207, 796));
        getContentPane().setLayout(new AbsoluteLayout());
        this.btnPSocial.setFont(new Font("Arial", 1, 12));
        this.btnPSocial.setText("Valoración Personal Social");
        this.btnPSocial.addActionListener(new ActionListener() { // from class: PyP.CyD.1
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnPSocialActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnPSocial, new AbsoluteConstraints(1020, 120, 180, 30));
        this.btnAlimentacion.setFont(new Font("Arial", 1, 12));
        this.btnAlimentacion.setText("Alimentación");
        this.btnAlimentacion.addActionListener(new ActionListener() { // from class: PyP.CyD.2
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnAlimentacionActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnAlimentacion, new AbsoluteConstraints(1020, 0, 180, 30));
        this.btnMGruesa.setFont(new Font("Arial", 1, 12));
        this.btnMGruesa.setText("Motricidad Gruesa");
        this.btnMGruesa.addActionListener(new ActionListener() { // from class: PyP.CyD.3
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnMGruesaActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnMGruesa, new AbsoluteConstraints(1020, 30, 180, 30));
        this.btnMFina.setFont(new Font("Arial", 1, 12));
        this.btnMFina.setText("Motricidad Fina");
        this.btnMFina.addActionListener(new ActionListener() { // from class: PyP.CyD.4
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnMFinaActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnMFina, new AbsoluteConstraints(1020, 60, 180, 30));
        this.btnLenguaje.setFont(new Font("Arial", 1, 12));
        this.btnLenguaje.setText("Valoración del Lenguaje");
        this.btnLenguaje.addActionListener(new ActionListener() { // from class: PyP.CyD.5
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnLenguajeActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnLenguaje, new AbsoluteConstraints(1020, 90, 180, 30));
        this.panelPersona.setBorder(BorderFactory.createEtchedBorder());
        this.panelPersona.setFont(new Font("Arial", 1, 12));
        getContentPane().add(this.panelPersona, new AbsoluteConstraints(0, 0, 970, 170));
        this.btnResultado.setFont(new Font("Arial", 1, 12));
        this.btnResultado.setText("Resultados");
        this.btnResultado.addActionListener(new ActionListener() { // from class: PyP.CyD.6
            public void actionPerformed(ActionEvent evt) {
                CyD.this.btnResultadoActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnResultado, new AbsoluteConstraints(1020, 150, 180, 30));
        getContentPane().add(this.panelFondo, new AbsoluteConstraints(0, 230, 1190, 530));
        this.jLabel1.setBackground(new Color(0, 0, 0));
        this.jLabel1.setFont(new Font("Arial", 1, 24));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("jLabel1");
        this.jLabel1.setOpaque(true);
        getContentPane().add(this.jLabel1, new AbsoluteConstraints(0, 190, 1190, 40));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAlimentacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMGruesaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMFinaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLenguajeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPSocialActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnResultadoActionPerformed(ActionEvent evt) {
    }
}
