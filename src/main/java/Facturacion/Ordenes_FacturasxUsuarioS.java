package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Ordenes_FacturasxUsuarioS.class */
public class Ordenes_FacturasxUsuarioS extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private DefaultTableModel modcombos;
    private SimpleDateFormat formatoFecha;
    private JButton btnAceptar;
    private JButton btnSalir;
    private JTableComboBox cboUsuarioS;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;

    public Ordenes_FacturasxUsuarioS(Frame parent, boolean modal) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        cargarCombos();
    }

    private void initComponents() {
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        try {
            this.cboUsuarioS = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.btnAceptar = new JButton();
        this.btnSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Facturas y Ordenes Generadas por Usuarios del Sistema");
        this.txtFechaIni.setDate(new Date());
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Arial", 1, 14));
        this.txtFechaFin.setDate(new Date());
        this.txtFechaFin.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFin.setFont(new Font("Arial", 1, 14));
        this.cboUsuarioS.setModel(new DefaultComboBoxModel(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        this.cboUsuarioS.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes_FacturasxUsuarioS.1
            public void actionPerformed(ActionEvent evt) {
                Ordenes_FacturasxUsuarioS.this.btnAceptarActionPerformed(evt);
            }
        });
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Facturacion.Ordenes_FacturasxUsuarioS.2
            public void actionPerformed(ActionEvent evt) {
                Ordenes_FacturasxUsuarioS.this.btnSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(52, 52, 52).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.btnAceptar, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnSalir, -2, 173, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.txtFechaIni, -2, 162, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtFechaFin, -2, 171, -2)).addComponent(this.cboUsuarioS, -2, 383, -2)).addGap(67, 67, 67)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(67, 67, 67).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaIni, -1, 36, 32767).addComponent(this.txtFechaFin, -1, 36, 32767)).addGap(36, 36, 36).addComponent(this.cboUsuarioS, -2, 31, -2).addGap(51, 51, 51).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnAceptar, -2, 38, -2).addComponent(this.btnSalir)).addGap(56, 56, 56)));
        pack();
    }

    public void cargarCombos() {
        this.consultas.llenarComboTabla("SELECT persona.Id_persona AS Id, persona.NUsuario AS Usuario_del_Sistema,g_usuario_sist.Login AS Login FROM g_usuario_sist INNER JOIN persona ON (g_usuario_sist.Id_Persona = persona.Id_persona) INNER JOIN g_usuariosxmodulo ON (g_usuariosxmodulo.Id_persona = g_usuario_sist.Id_Persona) INNER JOIN g_modulos ON (g_usuariosxmodulo.Id_Modulo = g_modulos.Id) WHERE (g_modulos.GeneraFactura =1) GROUP BY g_usuario_sist.Login, persona.NUsuario ORDER BY persona.NUsuario ASC", this.cboUsuarioS, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    public void imprimir() {
        if (validarCampos() == 1) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "UsuarioS";
            mparametros[0][1] = this.cboUsuarioS.getPopupTable().getValueAt(this.cboUsuarioS.getSelectedIndex(), 2).toString();
            mparametros[1][0] = "FechaInicio";
            mparametros[1][1] = this.formatoFecha.format(this.txtFechaIni.getDate());
            mparametros[2][0] = "FechaFinal";
            mparametros[2][1] = this.formatoFecha.format(this.txtFechaFin.getDate());
            this.metodos.GenerarPDF("F_FacturasEventoxUsuarioS", mparametros);
            this.metodos.GenerarPDF("F_FacturasCapitaxUsuarioS", mparametros);
            dispose();
        }
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.txtFechaIni.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione Fecha de Inicio");
            this.txtFechaIni.requestFocus();
        } else if (this.txtFechaFin.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor seleccione Fecha Final");
            this.txtFechaFin.requestFocus();
        } else if (this.cboUsuarioS.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Usuario del Sistema");
            this.cboUsuarioS.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        imprimir();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() { // from class: Facturacion.Ordenes_FacturasxUsuarioS.3
            @Override // java.lang.Runnable
            public void run() {
                Ordenes_FacturasxUsuarioS dialog = new Ordenes_FacturasxUsuarioS(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() { // from class: Facturacion.Ordenes_FacturasxUsuarioS.3.1
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
}
