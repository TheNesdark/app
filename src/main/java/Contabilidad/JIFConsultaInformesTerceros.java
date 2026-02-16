package Contabilidad;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultaInformesTerceros.class */
public class JIFConsultaInformesTerceros extends JInternalFrame {
    private String[][] xidtercero;
    private String xsql;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;
    public String idTercero = "";
    private JButton JBBuscaTercero;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    public JLabel JLBTercero;
    private JPanel JPIDatos;
    public JTextField JTFNit;

    public JIFConsultaInformesTerceros() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFNit = new JTextField();
        this.JLBTercero = new JLabel();
        this.JBBuscaTercero = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN POR PROVEEDOR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconfultainfproveedeor");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 13));
        this.JTFNit.setFont(new Font("Arial", 1, 12));
        this.JTFNit.setBorder(BorderFactory.createTitledBorder((Border) null, "Nit o CC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNit.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConsultaInformesTerceros.1
            public void focusLost(FocusEvent evt) {
                JIFConsultaInformesTerceros.this.JTFNitFocusLost(evt);
            }
        });
        this.JTFNit.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultaInformesTerceros.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultaInformesTerceros.this.JTFNitMouseClicked(evt);
            }
        });
        this.JTFNit.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultaInformesTerceros.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaInformesTerceros.this.JTFNitActionPerformed(evt);
            }
        });
        this.JTFNit.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFConsultaInformesTerceros.4
            public void keyPressed(KeyEvent evt) {
                JIFConsultaInformesTerceros.this.JTFNitKeyPressed(evt);
            }
        });
        this.JLBTercero.setFont(new Font("Arial", 1, 12));
        this.JLBTercero.setText("jLabel1");
        this.JLBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultaInformesTerceros.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultaInformesTerceros.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNit).addComponent(this.JDFechaI, -2, 120, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaF, -2, 120, -2).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JLBTercero, -2, 416, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBBuscaTercero, -2, 58, -2))).addContainerGap(42, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 41, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNit).addComponent(this.JLBTercero, -1, -1, 32767).addComponent(this.JBBuscaTercero, GroupLayout.Alignment.TRAILING, -1, 50, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(14, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNitKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscarTercero();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JTFNit.setText("");
        this.JLBTercero.setText("");
        this.idTercero = "";
        this.JDFechaI.requestFocus();
        this.xlleno = true;
    }

    public void mBuscarItem() {
    }

    private void mBuscarTercero() {
        if (!this.JTFNit.getText().isEmpty()) {
            try {
                this.xsql = "SELECT IF (Nbre='', CONCAT(`Nombre1`,' ',`Nombre2`,' ', `Apellido1`, ' ', `Apellido2` ) ,Nbre) AS Nbre FROM g_empresa WHERE (Estado =1 AND No_identificacion ='" + this.JTFNit.getText().trim() + "') ORDER BY Nbre ASC";
                ResultSet xrs = this.xconsulta.traerRs(this.xsql);
                if (xrs.next()) {
                    this.JLBTercero.setText(xrs.getString(1));
                }
                xrs.close();
                this.xconsulta.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultaInformesTerceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mImprimir() {
        if (!this.idTercero.isEmpty()) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.idTercero;
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "Fechai";
            mparametros[2][1] = this.xmetodos.formatoAMD.format(this.JDFechaI.getDate());
            mparametros[3][0] = "Fechaf";
            mparametros[3][1] = this.xmetodos.formatoAMD.format(this.JDFechaF.getDate());
            mparametros[4][0] = "SUBREPORT_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[5][0] = "SUBREPORTFIRMA_DIR";
            mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_RelacionPago", mparametros);
        }
    }
}
