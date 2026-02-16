package PyP;

import Acceso.Principal;
import Historia.JPAAntecedenteGineco;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:PyP/Antecedentes.class */
public class Antecedentes extends JDialog {
    private JPAAntecedenteGineco frmAGineco;
    private JIFCACervix frmToma;
    private CACervixResultado frmResultado;
    private JTabbedPane jTabbedPane1;
    private JLabel lblTitulo;
    private JDesktopPane pGineco;
    private JPanel pGinecologico;

    public Antecedentes(Frame parent, boolean modal, JInternalFrame frm) {
        super(parent, modal);
        initComponents();
        casting(frm);
        iniciar();
        setLocationRelativeTo(null);
    }

    private void casting(JInternalFrame frm) {
        if (!frm.getName().equals("TomaCACervix")) {
            if (frm.getName().equals("ResultadoCACervix")) {
                this.frmResultado = (CACervixResultado) frm;
                return;
            }
            return;
        }
        this.frmToma = (JIFCACervix) frm;
    }

    private void cargarPaneles() {
        this.frmAGineco = new JPAAntecedenteGineco(Principal.clasepyp, 0, false);
        this.frmAGineco.setBounds(2, 2, 900, 535);
        this.pGineco.add(this.frmAGineco);
        this.pGinecologico.setVisible(true);
        this.frmAGineco.setVisible(true);
    }

    private void iniciar() {
        cargarPaneles();
        if (this.frmToma != null) {
            this.lblTitulo.setText(this.frmToma.frmPersona.getApellido1() + " " + this.frmToma.frmPersona.getApellido2() + " " + this.frmToma.frmPersona.getNombre1() + " " + this.frmToma.frmPersona.getNombre2());
        } else if (this.frmResultado != null) {
            this.lblTitulo.setText(this.frmResultado.frmPersona.getApellido1() + " " + this.frmResultado.frmPersona.getApellido2() + " " + this.frmResultado.frmPersona.getNombre1() + " " + this.frmResultado.frmPersona.getNombre2());
        }
    }

    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.pGinecologico = new JPanel();
        this.pGineco = new JDesktopPane();
        this.lblTitulo = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("Antecedentes Personales");
        setMinimumSize(new Dimension(961, 662));
        setName("Antecedentes");
        this.jTabbedPane1.setForeground(new Color(0, 102, 102));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        GroupLayout pGinecologicoLayout = new GroupLayout(this.pGinecologico);
        this.pGinecologico.setLayout(pGinecologicoLayout);
        pGinecologicoLayout.setHorizontalGroup(pGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(pGinecologicoLayout.createSequentialGroup().addContainerGap().addComponent(this.pGineco, -1, 916, 32767).addContainerGap()));
        pGinecologicoLayout.setVerticalGroup(pGinecologicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, pGinecologicoLayout.createSequentialGroup().addContainerGap().addComponent(this.pGineco, -1, 547, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("Ginecológicos", this.pGinecologico);
        this.lblTitulo.setBackground(new Color(0, 0, 102));
        this.lblTitulo.setFont(new Font("Arial", 1, 18));
        this.lblTitulo.setForeground(new Color(255, 255, 255));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("ANTECEDENTES GINECÓLOGICO");
        this.lblTitulo.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblTitulo, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblTitulo, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 600, -2).addContainerGap(-1, 32767)));
        pack();
    }
}
