package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDValidarProcedimientos.class */
public class JDValidarProcedimientos extends JDialog {
    private DefaultTableModel modelo;
    private Object[] dato;
    private ConsultasMySQL xconsultasbd;
    private Metodos xmetodo;
    private String xnombre;
    private JButton JBTCerrar;
    private JScrollPane JSPDatos;
    private JTable JTBDatos;

    public JDValidarProcedimientos(Frame parent, boolean modal, String rsc, String xnombre) {
        super(parent, modal);
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xnombre = xnombre;
        setLocation(100, (this.xmetodo.getAltoPantalla() / 2) / 2);
        mCrearTablaDetalle();
        mCargarDatos(rsc);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDatos = new JScrollPane();
        this.JTBDatos = new JTable();
        this.JBTCerrar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CONSULTAR PROCEDMIENTO ORDENADO");
        this.JSPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBDatos.setFont(new Font("Arial", 1, 12));
        this.JTBDatos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatos.setRowHeight(25);
        this.JTBDatos.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatos.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatos.setSelectionMode(0);
        this.JSPDatos.setViewportView(this.JTBDatos);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JDValidarProcedimientos.1
            public void actionPerformed(ActionEvent evt) {
                JDValidarProcedimientos.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatos, -1, 889, 32767).addComponent(this.JBTCerrar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JSPDatos, -2, 207, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar, -2, 55, -2).addContainerGap(7, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        if (Principal.clasehistoriace.xjifhistoriaclinica != null) {
            try {
                Principal.clasehistoriace.xjifhistoriaclinica.setSelected(true);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIFValidarProcedimientos.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } else if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
            try {
                Principal.clasehistoriace.historia_Clinica_v2.setSelected(true);
            } catch (PropertyVetoException e2) {
                Logger.getLogger(JIFValidarProcedimientos.class.getName()).log(Level.SEVERE, (String) null, e2);
            }
        }
        dispose();
    }

    private void mCrearTablaDetalle() {
        this.modelo = new DefaultTableModel();
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Procedimiento");
        this.modelo.addColumn("Cantidad");
        this.modelo.addColumn("Medico");
        this.modelo.addRow(this.dato);
        this.JTBDatos.setModel(this.modelo);
        this.JTBDatos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDatos.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTBDatos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatos.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    private void mCargarDatos(String sql) {
        ResultSet rs = this.xconsultasbd.traerRs(sql);
        int i = 0;
        while (rs.next()) {
            try {
                this.modelo.setValueAt(this.xmetodo.formatoDMA.format((Date) rs.getDate(2)), i, 0);
                this.modelo.setValueAt(rs.getString(5), i, 1);
                this.modelo.setValueAt(rs.getString(6), i, 2);
                this.modelo.setValueAt(rs.getString(3), i, 3);
                this.modelo.addRow(this.dato);
                i++;
            } catch (SQLException e) {
                return;
            }
        }
        rs.close();
        this.xconsultasbd.cerrarConexionBd();
    }
}
