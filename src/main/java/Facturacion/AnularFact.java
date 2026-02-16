package Facturacion;

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
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/AnularFact.class */
public class AnularFact extends JDialog {
    private claseFacturacion clasefacturacion;
    private Facturac frmFacturac;
    private Facturac1 frmFacturac1;
    private JCheckBox JCH_FiltroMasivo;
    private JButton btnIngreso;
    private JButton btnOrden;
    private JButton btnsalir;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public AnularFact(Frame parent, boolean modal, Facturac frm) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac = frm;
        this.frmFacturac.setNbusqueda(-1);
        setLocationRelativeTo(null);
    }

    public AnularFact(Frame parent, boolean modal, Facturac1 frm) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.frmFacturac1 = frm;
        this.frmFacturac1.setNbusqueda(-1);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.btnIngreso = new JButton();
        this.btnOrden = new JButton();
        this.btnsalir = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JCH_FiltroMasivo = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("Genoma Soft - Anulación");
        setIconImage(null);
        setIconImages(null);
        setMinimumSize(new Dimension(548, 191));
        this.btnIngreso.setFont(new Font("Arial", 1, 12));
        this.btnIngreso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.btnIngreso.setText("Ingreso");
        this.btnIngreso.addActionListener(new ActionListener() { // from class: Facturacion.AnularFact.1
            public void actionPerformed(ActionEvent evt) {
                AnularFact.this.btnIngresoActionPerformed(evt);
            }
        });
        this.btnOrden.setFont(new Font("Arial", 1, 12));
        this.btnOrden.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.btnOrden.setText("Ordenes");
        this.btnOrden.addActionListener(new ActionListener() { // from class: Facturacion.AnularFact.2
            public void actionPerformed(ActionEvent evt) {
                AnularFact.this.btnOrdenActionPerformed(evt);
            }
        });
        this.btnsalir.setFont(new Font("Arial", 1, 12));
        this.btnsalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnsalir.setText("Salir");
        this.btnsalir.addActionListener(new ActionListener() { // from class: Facturacion.AnularFact.3
            public void actionPerformed(ActionEvent evt) {
                AnularFact.this.btnsalirActionPerformed(evt);
            }
        });
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.jLabel2.setFont(new Font("Arial", 1, 18));
        this.jLabel2.setForeground(new Color(0, 102, 102));
        this.jLabel2.setText("¿ Que Desea Anular ?");
        this.JCH_FiltroMasivo.setFont(new Font("Arial", 1, 12));
        this.JCH_FiltroMasivo.setText("Anulación masiva");
        this.JCH_FiltroMasivo.addActionListener(new ActionListener() { // from class: Facturacion.AnularFact.4
            public void actionPerformed(ActionEvent evt) {
                AnularFact.this.JCH_FiltroMasivoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jLabel2, -2, 238, -2)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnIngreso, -2, 120, -2).addGap(18, 18, 18).addComponent(this.btnOrden, -2, 120, -2).addGap(30, 30, 30).addComponent(this.btnsalir, -2, 120, -2)).addComponent(this.JCH_FiltroMasivo)))).addContainerGap(21, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel1, -1, 39, 32767).addComponent(this.jLabel2, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCH_FiltroMasivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnIngreso, -2, 37, -2).addComponent(this.btnOrden, -2, 38, -2).addComponent(this.btnsalir, -2, 38, -2)).addContainerGap(8, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnsalirActionPerformed(ActionEvent evt) {
        this.frmFacturac.setNbusqueda(-1);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIngresoActionPerformed(ActionEvent evt) {
        this.frmFacturac.setNbusqueda(1);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnOrdenActionPerformed(ActionEvent evt) {
        this.frmFacturac.setNbusqueda(2);
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroMasivoActionPerformed(ActionEvent evt) {
        if (this.frmFacturac.frmIngreso.getEstadoFacturaOrdenes().intValue() == 0) {
            this.frmFacturac.setNbusqueda(3);
            dispose();
        } else {
            this.frmFacturac.setNbusqueda(-1);
            JOptionPane.showMessageDialog(this, "Ingreso con liquidacion ya armada y/o generada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        }
    }
}
