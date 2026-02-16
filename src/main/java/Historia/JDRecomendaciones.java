package Historia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDRecomendaciones.class */
public class JDRecomendaciones extends JDialog {
    private ConsultasMySQL xct;
    private JScrollPane JSPHistoricoA;
    private JTextPane JTPHistoricoA;

    public JDRecomendaciones(Frame parent, boolean modal, String xpatologia) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDatos(xpatologia);
    }

    private void initComponents() {
        this.JSPHistoricoA = new JScrollPane();
        this.JTPHistoricoA = new JTextPane();
        setDefaultCloseOperation(2);
        setTitle("RECOMENDACIONES");
        this.JSPHistoricoA.setBorder(BorderFactory.createTitledBorder((Border) null, "RECOMENDACIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHistoricoA.setEditable(false);
        this.JTPHistoricoA.setContentType("text/html");
        this.JTPHistoricoA.setFont(new Font("Arial", 1, 12));
        this.JTPHistoricoA.setCursor(new Cursor(0));
        this.JSPHistoricoA.setViewportView(this.JTPHistoricoA);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 643, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoA, -1, 623, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 427, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoA, -1, 405, 32767).addContainerGap())));
        pack();
    }

    private void mCargarDatos(String xidpatologia) {
        try {
            String xsql = "SELECT `Recomedaciones`, `Prioridad` FROM `g_patologia_recomedaciones` WHERE (`Id_Patologia` ='" + xidpatologia + "' AND `Estado` =1) ORDER BY `Prioridad` DESC, `Orden` ASC ";
            ResultSet xrs = this.xct.traerRs(xsql);
            String xparte1 = "";
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (xrs.getInt(2) == 3) {
                        if (xrs.getRow() == 1) {
                            xparte1 = "<font face='Arial' color='red' size=4>" + xrs.getString(1) + "</font><br>";
                        } else {
                            xparte1 = xparte1 + "<br>--------------------------------------------------------------------------------------<br><font face='Arial' color='red' size=4>" + xrs.getString(1) + "</font><br>";
                        }
                    } else if (xrs.getInt(2) == 2) {
                        if (xrs.getRow() == 1) {
                            xparte1 = "<font face='Arial' color='orange' size=4>" + xrs.getString(1) + "</font><br>";
                        } else {
                            xparte1 = xparte1 + "<br>--------------------------------------------------------------------------------------<br><font face='Arial' color='orange' size=4>" + xrs.getString(1) + "</font><br>";
                        }
                    } else if (xrs.getRow() == 1) {
                        xparte1 = "<font face='Arial' color='green' size=4>" + xrs.getString(1) + "</font><br>";
                    } else {
                        xparte1 = xparte1 + "<br>--------------------------------------------------------------------------------------<br><font face='Arial' color='green' size=4>" + xrs.getString(1) + "</font><br>";
                    }
                }
            }
            this.JTPHistoricoA.setText(xparte1);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDRecomendaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
