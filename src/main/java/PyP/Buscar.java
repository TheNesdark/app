package PyP;

import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:PyP/Buscar.class */
public class Buscar extends JDialog {
    private Metodos metodos;
    private JIFCACervix frmToma;
    private CACervixResultado frmResultado;
    private JButton btnCitologia;
    private JButton btnUsuario;
    private JButton btnsalir;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public Buscar(Frame parent, boolean modal, JInternalFrame frm) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        casting(frm);
        setLocationRelativeTo(null);
    }

    private void buscarUsuario() {
        if (this.frmToma != null) {
            this.frmToma.mBuscarPersona();
        } else if (this.frmResultado != null) {
            this.frmResultado.buscarPersona();
        }
        dispose();
    }

    private void cargarCitologia() {
        if (this.frmToma != null) {
            this.frmToma.mBuscarHCitologia();
        } else if (this.frmResultado != null) {
            this.frmResultado.buscarCitologia();
        } else {
            dispose();
        }
    }

    private void casting(JInternalFrame frm) {
        if (!frm.getName().equals("CACervixToma")) {
            if (frm.getName().equals("CACervixResultado")) {
                this.frmResultado = (CACervixResultado) frm;
                return;
            }
            return;
        }
        this.frmToma = (JIFCACervix) frm;
    }

    private void initComponents() {
        this.btnUsuario = new JButton();
        this.btnCitologia = new JButton();
        this.btnsalir = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("Genoma Soft - Busqueda");
        setMinimumSize(new Dimension(548, 191));
        this.btnUsuario.setFont(new Font("Arial", 1, 12));
        this.btnUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.btnUsuario.setText("Usuario");
        this.btnUsuario.addActionListener(new ActionListener() { // from class: PyP.Buscar.1
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnUsuarioActionPerformed(evt);
            }
        });
        this.btnCitologia.setFont(new Font("Arial", 1, 12));
        this.btnCitologia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.btnCitologia.setText("Citologías");
        this.btnCitologia.addActionListener(new ActionListener() { // from class: PyP.Buscar.2
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnCitologiaActionPerformed(evt);
            }
        });
        this.btnsalir.setFont(new Font("Arial", 1, 12));
        this.btnsalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnsalir.setText("Salir");
        this.btnsalir.addActionListener(new ActionListener() { // from class: PyP.Buscar.3
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnsalirActionPerformed(evt);
            }
        });
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscar.jpg")));
        this.jLabel2.setFont(new Font("Arial Black", 0, 18));
        this.jLabel2.setForeground(new Color(0, 102, 102));
        this.jLabel2.setText("¿ Que Desea Buscar ?");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.btnUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCitologia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnsalir, -2, 94, -2)).addGroup(layout.createSequentialGroup().addGap(64, 64, 64).addComponent(this.jLabel2, -2, 238, -2))).addGap(50, 50, 50)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(37, 37, 37).addComponent(this.jLabel2).addGap(35, 35, 35).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnUsuario, -2, 37, -2).addComponent(this.btnCitologia, -2, 38, -2).addComponent(this.btnsalir, -2, 38, -2)))).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnsalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUsuarioActionPerformed(ActionEvent evt) {
        buscarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCitologiaActionPerformed(ActionEvent evt) {
        cargarCitologia();
    }
}
