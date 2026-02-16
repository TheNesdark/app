package General;

import Historia.JPI_Control_Impresion;
import Utilidades.Metodos;
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
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/* JADX INFO: renamed from: General.JD_Impresión_Central_Dc, reason: invalid class name */
/* JADX INFO: loaded from: GenomaP.jar:General/JD_Impresión_Central_Dc.class */
public class JD_Impresin_Central_Dc extends JDialog {
    private String xId_Atencion;
    private String xId_Usuario;
    private String xId_Ingreso;
    private String xTipo_Atencion;
    private String correoUsuario;
    private Integer idTipoHistoria;
    private JPI_Control_Impresion xjif_cimpresion;
    private Metodos xmt;
    private JButton JBTEjecutar;
    private JButton JBTSalir;
    private JPanel JPI_Datos;

    public JD_Impresin_Central_Dc(Frame parent, boolean modal, String xId_Atencion, String xId_Usuario, String xId_Ingreso, String xTipo_Atencion, Integer idTipoHistoria, String correoUsuario) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xId_Atencion = xId_Atencion;
        this.xId_Usuario = xId_Usuario;
        this.xId_Ingreso = xId_Ingreso;
        this.xTipo_Atencion = xTipo_Atencion;
        this.idTipoHistoria = idTipoHistoria;
        this.correoUsuario = correoUsuario;
        mCargarPanel();
    }

    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.JBTEjecutar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JPI_Datos.setPreferredSize(new Dimension(898, 608));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 898, 32767));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 608, 32767));
        this.JBTEjecutar.setFont(new Font("Arial", 1, 12));
        this.JBTEjecutar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTEjecutar.setText("Imprimir");
        this.JBTEjecutar.addActionListener(new ActionListener() { // from class: General.JD_Impresión_Central_Dc.1
            public void actionPerformed(ActionEvent evt) {
                JD_Impresin_Central_Dc.this.JBTEjecutarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JD_Impresión_Central_Dc.2
            public void actionPerformed(ActionEvent evt) {
                JD_Impresin_Central_Dc.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JBTEjecutar, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 335, -2).addGap(18, 18, 18)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEjecutar, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEjecutarActionPerformed(ActionEvent evt) {
        this.xjif_cimpresion.mImprimir();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCargarPanel() {
        this.xjif_cimpresion = new JPI_Control_Impresion(this.xId_Atencion, this.xId_Usuario, this.xId_Ingreso, this.xTipo_Atencion, this.idTipoHistoria, this.correoUsuario);
        this.xjif_cimpresion.setVisible(true);
        this.xjif_cimpresion.setBounds(1, 1, 898, 608);
        this.JPI_Datos.add(this.xjif_cimpresion);
        this.JPI_Datos.setVisible(true);
    }
}
