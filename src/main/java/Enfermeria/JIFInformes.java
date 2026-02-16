package Enfermeria;

import Acceso.Principal;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JIFInformes.class */
public class JIFInformes extends JInternalFrame {
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private String[][] parametros;
    private String nbreArchivo;
    private Metodos metodos;
    private JButton btnAceptar;
    private JButton btnSalir;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JLabel lblTitulo;
    private JCalendar txtFechaFin;
    private JCalendar txtFechaIni;

    public JIFInformes() {
        initComponents();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.txtFechaIni = new JCalendar();
        this.txtFechaFin = new JCalendar();
        this.btnAceptar = new JButton();
        this.lblTitulo = new JLabel();
        this.btnSalir = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(501, 378));
        setMinimumSize(new Dimension(501, 378));
        setName("FIInformes");
        setNormalBounds(new Rectangle(0, 0, 400, 378));
        setPreferredSize(new Dimension(501, 378));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        this.jPanel1.setLayout((LayoutManager) null);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.setWeekOfYearVisible(false);
        this.jPanel1.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(10, 10, 220, 190);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.setWeekOfYearVisible(false);
        this.jPanel1.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(230, 10, 230, 190);
        getContentPane().add(this.jPanel1);
        this.jPanel1.setBounds(10, 50, 470, 210);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Enfermeria.JIFInformes.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnAceptar);
        this.btnAceptar.setBounds(10, 280, 220, 40);
        this.lblTitulo.setBackground(new Color(0, 0, 153));
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(204, 255, 255));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("INFORMES");
        this.lblTitulo.setOpaque(true);
        getContentPane().add(this.lblTitulo);
        this.lblTitulo.setBounds(10, 20, 470, 20);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Enfermeria.JIFInformes.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(this.btnSalir);
        this.btnSalir.setBounds(240, 280, 230, 40);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        mCargarInforme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mCargarInforme() {
        this.metodos = new Metodos();
        this.parametros = new String[5][2];
        this.parametros[0][0] = "fechaInicial";
        this.parametros[0][1] = this.formato.format(this.txtFechaIni.getDate());
        this.parametros[1][0] = "fechaFinal";
        this.parametros[1][1] = this.formato.format(this.txtFechaFin.getDate());
        this.parametros[2][0] = "xusuario";
        this.parametros[2][1] = Principal.usuarioSistemaDTO.getLogin();
        this.parametros[3][0] = "SUBREPORT_DIR";
        this.parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
        this.parametros[4][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.nbreArchivo = "H_RegistroDiarioEnfermeria";
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + this.nbreArchivo, this.parametros);
    }
}
