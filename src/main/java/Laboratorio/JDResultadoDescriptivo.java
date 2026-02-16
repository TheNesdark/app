package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JDResultadoDescriptivo.class */
public class JDResultadoDescriptivo extends JDialog {
    private ConsultasMySQL xct;
    private JIFPlanillaTrabajo xjifplanilla;
    private String frmllamador;
    private String xsql;
    private String xidtiporesultado;
    private int xtipo;
    private int xpos;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JScrollPane JSPDescripcionT;
    private JTextPane JTPDescripcion;

    public JDResultadoDescriptivo(Frame parent, boolean modal, String protocolo, JInternalFrame frmRm, int xpos, int xtipo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xidtiporesultado = "0";
        this.xtipo = 0;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xtipo = xtipo;
        this.xpos = xpos;
        mBuscarTipoResultado(protocolo);
        realizarcasting(frmRm);
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            mBuscarTipoResultado1(protocolo);
            this.JBTGrabar.setEnabled(true);
        }
    }

    private void initComponents() {
        this.JSPDescripcionT = new JScrollPane();
        this.JTPDescripcion = new JTextPane();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("TIPO DE RESULTADO");
        setName("CapturarResultado");
        addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDResultadoDescriptivo.1
            public void keyPressed(KeyEvent evt) {
                JDResultadoDescriptivo.this.formKeyPressed(evt);
            }
        });
        this.JSPDescripcionT.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTPDescripcion.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDResultadoDescriptivo.2
            public void keyTyped(KeyEvent evt) {
                JDResultadoDescriptivo.this.JTPDescripcionKeyTyped(evt);
            }
        });
        this.JSPDescripcionT.setViewportView(this.JTPDescripcion);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.setEnabled(false);
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JDResultadoDescriptivo.3
            public void actionPerformed(ActionEvent evt) {
                JDResultadoDescriptivo.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDResultadoDescriptivo.4
            public void keyPressed(KeyEvent evt) {
                JDResultadoDescriptivo.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Laboratorio.JDResultadoDescriptivo.5
            public void actionPerformed(ActionEvent evt) {
                JDResultadoDescriptivo.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDescripcionT).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 320, -2).addGap(18, 18, 18).addComponent(this.JBTSalir, -2, 320, -2).addGap(0, 3, 32767))).addContainerGap()));
        layout.linkSize(0, new Component[]{this.JBTGrabar, this.JBTSalir});
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPDescripcionT, -2, 283, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 60, -2).addComponent(this.JBTSalir, -2, 60, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mAsignar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAsignar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPDescripcionKeyTyped(KeyEvent evt) {
        if (this.frmllamador.equals("PlanillaTrabajo") && !Boolean.valueOf(this.xjifplanilla.xmodelo1.getValueAt(this.xjifplanilla.JTBDetalleAnalito.getSelectedRow(), 9).toString()).booleanValue()) {
            if (!this.JTPDescripcion.getText().isEmpty()) {
                this.JBTGrabar.setEnabled(true);
            } else {
                this.JBTGrabar.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            dispose();
        }
    }

    private void mAsignar() {
        if (this.frmllamador.equals("PlanillaTrabajo")) {
            dispose();
            if (this.xtipo == 0) {
                this.xjifplanilla.mAsignarResultado(this.JTPDescripcion.getText(), this.xidtiporesultado, false);
            } else {
                this.xjifplanilla.xmodelo1.setValueAt(this.JTPDescripcion.getText(), this.xjifplanilla.JTBDetalleAnalito.getSelectedRow(), this.xpos);
            }
        }
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("xjifplanillatrabajo")) {
            this.xjifplanilla = (JIFPlanillaTrabajo) frm;
            this.frmllamador = "PlanillaTrabajo";
            this.JTPDescripcion.setText(this.xjifplanilla.xmodelo1.getValueAt(this.xjifplanilla.JTBDetalleAnalito.getSelectedRow(), this.xpos).toString());
            return;
        }
        this.frmllamador = "";
    }

    private void mBuscarTipoResultado(String xid) {
        try {
            this.xsql = "SELECT `l_tiporesultado`.`Id` FROM `l_protocoloxtiporesultado` INNER JOIN  `l_tiporesultado`  ON (`l_protocoloxtiporesultado`.`Id_TipoResultado` = `l_tiporesultado`.`Id`) INNER JOIN  `l_protocolos`   ON (`l_protocoloxtiporesultado`.`Id_Protocolo` = `l_protocolos`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`   ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_protocoloxprocedimiento`.`Id` ='" + xid + "' ) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.xidtiporesultado = xrs.getString(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDResultadoDescriptivo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarTipoResultado1(String xid) {
        try {
            this.xsql = "SELECT\n `l_protocolos`.`Comentario`\nFROM\n    `l_protocoloxprocedimiento`\n    INNER JOIN `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\nWHERE ( `l_protocoloxprocedimiento`.`Id` ='" + xid + "' ) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JTPDescripcion.setText(xrs.getString(1));
            }
            System.err.println("xsql" + this.xsql);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDResultadoDescriptivo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
