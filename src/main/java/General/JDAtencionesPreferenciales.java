package General;

import Acceso.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/JDAtencionesPreferenciales.class */
public class JDAtencionesPreferenciales extends JDialog {
    private JButton JBAtencionAncianos;
    private JButton JBAtencionDiscapasitado;
    private JButton JBAtencionEmbarazada;

    /* JADX INFO: renamed from: JBNiños, reason: contains not printable characters */
    private JButton f4JBNios;
    private JButton JBT_Salir;
    private JCheckBox JCH_Clasificacion;
    private JPanel JPanelAtencion;
    private JPanel JPanelDiscapacitados;
    private JPanel JPanelEmbarazadas;
    private JPanel JPanelTeceraedad;
    private JPanel JPanelTeceraedad1;

    public JDAtencionesPreferenciales(Frame parent, boolean modal, JInternalFrame xjif) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(0);
        setLocationRelativeTo(xjif);
    }

    private void initComponents() {
        this.JPanelAtencion = new JPanel();
        this.JPanelDiscapacitados = new JPanel();
        this.JBAtencionDiscapasitado = new JButton();
        this.JPanelEmbarazadas = new JPanel();
        this.JBAtencionEmbarazada = new JButton();
        this.JPanelTeceraedad = new JPanel();
        this.f4JBNios = new JButton();
        this.JPanelTeceraedad1 = new JPanel();
        this.JBAtencionAncianos = new JButton();
        this.JBT_Salir = new JButton();
        this.JCH_Clasificacion = new JCheckBox();
        setDefaultCloseOperation(2);
        setMaximumSize(null);
        setMinimumSize(null);
        this.JPanelAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "ATENCIONES PREFERENCIALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPanelDiscapacitados.setBorder(BorderFactory.createTitledBorder((Border) null, "Discapacitado(a)", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBAtencionDiscapasitado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/discapacitado.png")));
        this.JBAtencionDiscapasitado.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.1
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.JBAtencionDiscapasitadoActionPerformed(evt);
            }
        });
        GroupLayout JPanelDiscapacitadosLayout = new GroupLayout(this.JPanelDiscapacitados);
        this.JPanelDiscapacitados.setLayout(JPanelDiscapacitadosLayout);
        JPanelDiscapacitadosLayout.setHorizontalGroup(JPanelDiscapacitadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelDiscapacitadosLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JBAtencionDiscapasitado, -2, 74, -2).addContainerGap(-1, 32767)));
        JPanelDiscapacitadosLayout.setVerticalGroup(JPanelDiscapacitadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAtencionDiscapasitado, -1, -1, 32767));
        this.JPanelEmbarazadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Embarazada", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBAtencionEmbarazada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Embarazada.png")));
        this.JBAtencionEmbarazada.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.2
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.JBAtencionEmbarazadaActionPerformed(evt);
            }
        });
        GroupLayout JPanelEmbarazadasLayout = new GroupLayout(this.JPanelEmbarazadas);
        this.JPanelEmbarazadas.setLayout(JPanelEmbarazadasLayout);
        JPanelEmbarazadasLayout.setHorizontalGroup(JPanelEmbarazadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelEmbarazadasLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JBAtencionEmbarazada, -2, 81, -2).addContainerGap(-1, 32767)));
        JPanelEmbarazadasLayout.setVerticalGroup(JPanelEmbarazadasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAtencionEmbarazada, -1, -1, 32767));
        this.JPanelTeceraedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Niño(a)", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.f4JBNios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AtencionpNiños.png")));
        this.f4JBNios.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.3
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.m9JBNiosActionPerformed(evt);
            }
        });
        GroupLayout JPanelTeceraedadLayout = new GroupLayout(this.JPanelTeceraedad);
        this.JPanelTeceraedad.setLayout(JPanelTeceraedadLayout);
        JPanelTeceraedadLayout.setHorizontalGroup(JPanelTeceraedadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelTeceraedadLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.f4JBNios).addGap(3, 3, 3)));
        JPanelTeceraedadLayout.setVerticalGroup(JPanelTeceraedadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.f4JBNios, -1, -1, 32767));
        this.JPanelTeceraedad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercera Edad", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBAtencionAncianos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ancianos.png")));
        this.JBAtencionAncianos.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.4
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.JBAtencionAncianosActionPerformed(evt);
            }
        });
        GroupLayout JPanelTeceraedad1Layout = new GroupLayout(this.JPanelTeceraedad1);
        this.JPanelTeceraedad1.setLayout(JPanelTeceraedad1Layout);
        JPanelTeceraedad1Layout.setHorizontalGroup(JPanelTeceraedad1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelTeceraedad1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JBAtencionAncianos).addGap(3, 3, 3)));
        JPanelTeceraedad1Layout.setVerticalGroup(JPanelTeceraedad1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAtencionAncianos, -1, -1, 32767));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.5
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JCH_Clasificacion.setFont(new Font("Arial", 1, 12));
        this.JCH_Clasificacion.setForeground(Color.blue);
        this.JCH_Clasificacion.setText("La clasificación es permanente?");
        this.JCH_Clasificacion.addActionListener(new ActionListener() { // from class: General.JDAtencionesPreferenciales.6
            public void actionPerformed(ActionEvent evt) {
                JDAtencionesPreferenciales.this.JCH_ClasificacionActionPerformed(evt);
            }
        });
        GroupLayout JPanelAtencionLayout = new GroupLayout(this.JPanelAtencion);
        this.JPanelAtencion.setLayout(JPanelAtencionLayout);
        JPanelAtencionLayout.setHorizontalGroup(JPanelAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPanelAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAtencionLayout.createSequentialGroup().addComponent(this.JCH_Clasificacion).addGap(0, 0, 32767)).addComponent(this.JBT_Salir, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPanelAtencionLayout.createSequentialGroup().addComponent(this.JPanelDiscapacitados, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPanelEmbarazadas, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPanelTeceraedad1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JPanelTeceraedad, -2, -1, -2))).addContainerGap()));
        JPanelAtencionLayout.setVerticalGroup(JPanelAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPanelAtencionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPanelAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPanelTeceraedad, -1, -1, 32767).addComponent(this.JPanelEmbarazadas, -1, -1, 32767).addComponent(this.JPanelDiscapacitados, -1, -1, 32767).addComponent(this.JPanelTeceraedad1, -1, -1, 32767)).addGap(15, 15, 15).addComponent(this.JCH_Clasificacion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Salir, -2, 44, -2).addContainerGap(12, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPanelAtencion, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPanelAtencion, -1, -1, 32767).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAtencionDiscapasitadoActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(1);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAtencionEmbarazadaActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(2);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAtencionAncianosActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(3);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JBNiñosActionPerformed, reason: contains not printable characters */
    public void m9JBNiosActionPerformed(ActionEvent evt) {
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(4);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_ClasificacionActionPerformed(ActionEvent evt) {
        if (this.JCH_Clasificacion.isSelected()) {
            Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(new Integer(1));
        } else {
            Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(new Integer(0));
        }
    }
}
