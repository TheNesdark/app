package Facturacion;

import Acceso.Principal;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Buscar.class */
public class Buscar extends JDialog {
    private claseFacturacion clasefacturacion;
    private Facturac frmFacturac;
    private Facturac1 frmFacturac1;
    private JButton btnCarnetVacunas;
    private JButton btnConsolidado;
    private JButton btnIngreso;
    private JButton btnOrden;
    private JButton btnUsuario;
    private JButton btnsalir;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public Buscar(Frame parent, boolean modal, Facturac frm) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac = frm;
        this.frmFacturac.setNbusqueda(-1);
        setLocationRelativeTo(null);
    }

    public Buscar(Frame parent, boolean modal, Facturac1 frm) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac1 = frm;
        this.frmFacturac.setNbusqueda(-1);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.btnUsuario = new JButton();
        this.btnIngreso = new JButton();
        this.btnOrden = new JButton();
        this.btnsalir = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.btnCarnetVacunas = new JButton();
        this.btnConsolidado = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Genoma Soft - Busqueda");
        setMinimumSize(new Dimension(548, 191));
        this.btnUsuario.setFont(new Font("Arial", 1, 12));
        this.btnUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.btnUsuario.setText("Usuario");
        this.btnUsuario.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.1
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnUsuarioActionPerformed(evt);
            }
        });
        this.btnIngreso.setFont(new Font("Arial", 1, 12));
        this.btnIngreso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.btnIngreso.setText("Ingreso");
        this.btnIngreso.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.2
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnIngresoActionPerformed(evt);
            }
        });
        this.btnOrden.setFont(new Font("Arial", 1, 12));
        this.btnOrden.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.btnOrden.setText("Ordenes");
        this.btnOrden.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.3
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnOrdenActionPerformed(evt);
            }
        });
        this.btnsalir.setFont(new Font("Arial", 1, 12));
        this.btnsalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnsalir.setText("Salir");
        this.btnsalir.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.4
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnsalirActionPerformed(evt);
            }
        });
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/buscar.jpg")));
        this.jLabel2.setFont(new Font("Arial", 1, 18));
        this.jLabel2.setForeground(new Color(0, 102, 102));
        this.jLabel2.setText("¿ Que Desea Buscar ?");
        this.btnCarnetVacunas.setFont(new Font("Arial", 1, 12));
        this.btnCarnetVacunas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.btnCarnetVacunas.setText("Carnet Vacunas");
        this.btnCarnetVacunas.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.5
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnCarnetVacunasActionPerformed(evt);
            }
        });
        this.btnConsolidado.setFont(new Font("Arial", 1, 12));
        this.btnConsolidado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.btnConsolidado.setText("Consolidado");
        this.btnConsolidado.addActionListener(new ActionListener() { // from class: Facturacion.Buscar.6
            public void actionPerformed(ActionEvent evt) {
                Buscar.this.btnConsolidadoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(68, 68, 68).addComponent(this.jLabel2, -2, 238, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.btnUsuario).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnIngreso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnOrden).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnConsolidado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnCarnetVacunas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnsalir, -2, 94, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1)).addGroup(layout.createSequentialGroup().addGap(54, 54, 54).addComponent(this.jLabel2))).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnsalir, -2, 38, -2).addComponent(this.btnUsuario, -2, 37, -2).addComponent(this.btnIngreso, -2, 37, -2).addComponent(this.btnOrden, -2, 38, -2).addComponent(this.btnCarnetVacunas, -2, 38, -2).addComponent(this.btnConsolidado, -2, 38, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnsalirActionPerformed(ActionEvent evt) {
        this.frmFacturac.setNbusqueda(-1);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUsuarioActionPerformed(ActionEvent evt) {
        this.frmFacturac.setNbusqueda(0);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIngresoActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.clasefacturacion.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            this.frmFacturac.setNbusqueda(1);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOrdenActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.frmFacturac.setNbusqueda(2);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCarnetVacunasActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.clasefacturacion.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            this.frmFacturac.setNbusqueda(4);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsolidadoActionPerformed(ActionEvent evt) {
        if (!this.frmFacturac.clasefacturacion.frmFacturac.frmPersona.getIdPersona().equals("0")) {
            this.frmFacturac.setNbusqueda(3);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }
}
