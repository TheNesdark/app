package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarMedicamentosActivos.class */
public class JIFConsultarMedicamentosActivos extends JInternalFrame {
    private Object[] dato;
    private String xnombre;
    private JButton JBTCerrar;
    private JScrollPane JSPDatos;
    private JTable JTBDatos;
    private DefaultTableModel modelo = new DefaultTableModel();
    private SimpleDateFormat xffechan = new SimpleDateFormat("dd/MM/yyyy");
    private Metodos consultar = new Metodos();

    public JIFConsultarMedicamentosActivos(String rsc, int xid, String xnombre) throws SQLException {
        initComponents();
        this.xnombre = xnombre;
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.modelo.addColumn("Fecha");
        this.modelo.addColumn("Suministro");
        this.modelo.addColumn("Dosis - Frecuencia");
        this.modelo.addColumn("Durac.");
        this.modelo.addColumn("Cant.");
        this.modelo.addColumn("Dias Tto.");
        this.modelo.addColumn("Medico");
        this.modelo.addColumn("Tipo Formula");
        this.modelo.addRow(this.dato);
        this.JTBDatos.setModel(this.modelo);
        this.JTBDatos.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTBDatos.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTBDatos.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDatos.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDatos.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBDatos.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.JTBDatos.getColumnModel().getColumn(6).setPreferredWidth(250);
        this.JTBDatos.getColumnModel().getColumn(7).setPreferredWidth(150);
        if (xid == 0) {
            ResultSet rs = xmt.traerRs(rsc);
            int i = 0;
            while (rs.next()) {
                this.modelo.setValueAt(rs.getString(1), i, 0);
                this.modelo.setValueAt(rs.getString(2), i, 1);
                this.modelo.setValueAt(rs.getString(3), i, 2);
                this.modelo.setValueAt(rs.getString(4), i, 3);
                this.modelo.setValueAt(rs.getString(5), i, 4);
                this.modelo.setValueAt(rs.getString(8), i, 5);
                this.modelo.setValueAt(rs.getString(6), i, 6);
                this.modelo.setValueAt(rs.getString(7), i, 7);
                this.modelo.addRow(this.dato);
                i++;
            }
            rs.close();
            xmt.cerrarConexionBd();
            return;
        }
        ResultSet rs2 = xmt.traerRs(rsc);
        int i2 = 0;
        while (rs2.next()) {
            this.modelo.setValueAt(this.xffechan.format((Date) rs2.getDate(8)), i2, 0);
            this.modelo.setValueAt(rs2.getString(4), i2, 1);
            this.modelo.setValueAt(rs2.getString(9), i2, 2);
            this.modelo.setValueAt(rs2.getString(10), i2, 3);
            this.modelo.setValueAt(rs2.getString(2), i2, 4);
            this.modelo.setValueAt(rs2.getString(7), i2, 5);
            this.modelo.setValueAt(rs2.getString(5), i2, 6);
            this.modelo.setValueAt(rs2.getString(6), i2, 7);
            this.modelo.addRow(this.dato);
            i2++;
        }
        rs2.close();
        xmt.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDatos = new JScrollPane();
        this.JTBDatos = new JTable();
        this.JBTCerrar = new JButton();
        setClosable(true);
        setTitle("CONSULTAR MEDICAMENTO ACTIVO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarmedicamentos");
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
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarMedicamentosActivos.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarMedicamentosActivos.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTCerrar, -1, -1, 32767).addComponent(this.JSPDatos, -1, 1070, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatos, -2, 234, -2).addGap(18, 18, 18).addComponent(this.JBTCerrar, -1, 59, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        System.out.println("" + this.xnombre);
        switch (this.xnombre) {
            case "Historia":
                try {
                    if (Principal.clasehistoriace.xjifhistoriaclinica != null) {
                        Principal.clasehistoriace.xjifhistoriaclinica.setSelected(true);
                    }
                    if (Principal.clasehistoriace.historia_Clinica_Cirugia != null) {
                        Principal.clasehistoriace.historia_Clinica_Cirugia.setSelected(true);
                    }
                    if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
                        Principal.clasehistoriace.historia_Clinica_v2.setSelected(true);
                    }
                    if (Principal.clasehistoriace.historia_Clinica_v4 != null) {
                        Principal.clasehistoriace.historia_Clinica_v4.setSelected(true);
                        break;
                    }
                    break;
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFConsultarMedicamentosActivos.class.getName()).log(Level.SEVERE, (String) null, e);
                    break;
                }
                break;
        }
        dispose();
    }
}
