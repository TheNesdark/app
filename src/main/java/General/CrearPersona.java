package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/CrearPersona.class */
public class CrearPersona extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    public static String xTitulo;
    private String sql;
    private Persona frmPersona;
    private JButton btnActivar;
    private JButton btnDesactivar;
    private JButton btnGrabar;
    private JButton btnLimpiar;
    private JButton jButton2;
    private JLabel jLabel1;
    private JPanel panelFondo;

    public CrearPersona(Frame parent, boolean modal, int uso) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        setTitle(Principal.getTitulo());
        this.frmPersona = new Persona(this);
        cargarPanelPersona();
        if (uso == 1) {
            this.btnGrabar.setEnabled(true);
        } else if (uso == 2) {
            this.btnDesactivar.setEnabled(true);
        } else if (uso == 3) {
            this.btnActivar.setEnabled(true);
        }
    }

    private void activarUsuario() {
        if (this.metodos.getPregunta("Esta seguro de Activar este Usuario?") == 0) {
            this.sql = "UPDATE g_usuario SET Estado =0, FechaDA=NULL WHERE Id_persona ='" + this.frmPersona.IdPersona + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.frmPersona.marcarEstado(0);
            this.metodos.mostrarMensaje("Usuario Activado");
        }
    }

    public void cargarPanelPersona() {
        this.frmPersona.setVisible(true);
        this.panelFondo.setVisible(false);
        this.frmPersona.setBounds(5, 5, 920, 170);
        this.panelFondo.add(this.frmPersona);
        this.panelFondo.setVisible(true);
    }

    private void desactivarUsuario() {
        if (this.metodos.getPregunta("Esta seguro de DesActivar este Usuario?") == 0) {
            this.sql = "UPDATE g_usuario SET Estado =1, FechaDA='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "' WHERE Id_persona ='" + this.frmPersona.IdPersona + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.frmPersona.marcarEstado(1);
            this.metodos.mostrarMensaje("Usuario DesActivado");
        }
    }

    private void initComponents() {
        this.panelFondo = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton2 = new JButton();
        this.btnGrabar = new JButton();
        this.btnLimpiar = new JButton();
        this.btnDesactivar = new JButton();
        this.btnActivar = new JButton();
        setDefaultCloseOperation(2);
        setName("CrearPersona");
        this.panelFondo.setBorder(BorderFactory.createTitledBorder((Border) null, "MANEJO DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FOTO", 2, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout panelFondoLayout = new GroupLayout(this.panelFondo);
        this.panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup().addContainerGap(1022, 32767).addComponent(this.jLabel1, -2, 130, -2).addContainerGap()));
        panelFondoLayout.setVerticalGroup(panelFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -1, 165, 32767).addContainerGap()));
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setForeground(new Color(0, 0, 153));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton2.setText("Salir");
        this.jButton2.addActionListener(new ActionListener() { // from class: General.CrearPersona.1
            public void actionPerformed(ActionEvent evt) {
                CrearPersona.this.jButton2ActionPerformed(evt);
            }
        });
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setForeground(new Color(0, 0, 153));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("<html><P ALIGN=center>Grabar / Modificar");
        this.btnGrabar.setEnabled(false);
        this.btnGrabar.addActionListener(new ActionListener() { // from class: General.CrearPersona.2
            public void actionPerformed(ActionEvent evt) {
                CrearPersona.this.btnGrabarActionPerformed(evt);
            }
        });
        this.btnLimpiar.setFont(new Font("Arial", 1, 12));
        this.btnLimpiar.setForeground(new Color(0, 0, 153));
        this.btnLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnLimpiar.setText("<html><P ALIGN=center>Limpiar");
        this.btnLimpiar.addActionListener(new ActionListener() { // from class: General.CrearPersona.3
            public void actionPerformed(ActionEvent evt) {
                CrearPersona.this.btnLimpiarActionPerformed(evt);
            }
        });
        this.btnDesactivar.setFont(new Font("Arial", 1, 12));
        this.btnDesactivar.setForeground(new Color(0, 0, 153));
        this.btnDesactivar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.btnDesactivar.setText("<html><P ALIGN=center>Desactivar Usuario");
        this.btnDesactivar.setEnabled(false);
        this.btnDesactivar.addActionListener(new ActionListener() { // from class: General.CrearPersona.4
            public void actionPerformed(ActionEvent evt) {
                CrearPersona.this.btnDesactivarActionPerformed(evt);
            }
        });
        this.btnActivar.setFont(new Font("Arial", 1, 12));
        this.btnActivar.setForeground(new Color(0, 0, 153));
        this.btnActivar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaNP.png")));
        this.btnActivar.setText("<html><P ALIGN=center>Activar Usuario");
        this.btnActivar.setEnabled(false);
        this.btnActivar.addActionListener(new ActionListener() { // from class: General.CrearPersona.5
            public void actionPerformed(ActionEvent evt) {
                CrearPersona.this.btnActivarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelFondo, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.btnLimpiar, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGrabar, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnDesactivar, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnActivar, -2, 150, -2).addGap(18, 18, 18).addComponent(this.jButton2, -2, 150, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelFondo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnLimpiar, -2, 50, -2).addComponent(this.btnGrabar, -2, 50, -2).addComponent(this.jButton2, -2, 49, -2).addComponent(this.btnDesactivar, -2, 50, -2).addComponent(this.btnActivar, -2, 50, -2)).addContainerGap(13, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        this.frmPersona.grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLimpiarActionPerformed(ActionEvent evt) {
        this.frmPersona.nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDesactivarActionPerformed(ActionEvent evt) {
        desactivarUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnActivarActionPerformed(ActionEvent evt) {
        activarUsuario();
    }
}
