package Historia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDRCreatinina.class */
public class JDRCreatinina extends JDialog {
    private JPFiltroIFG xJPFiltroIFG;
    private DefaultTableModel xmodelo;
    ConsultasMySQL xct;
    private Object[] xdatos;
    private JScrollPane JSPResultado;
    private JTable JTResultado;
    private JButton jButton1;

    public JDRCreatinina(Frame parent, boolean modal, JPFiltroIFG xJPFiltroIFG) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        setTitle("RESULTADOS CREATININA");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xJPFiltroIFG = xJPFiltroIFG;
        setLocationRelativeTo(null);
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jButton1 = new JButton();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton1.setText("Salir");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDRCreatinina.1
            public void actionPerformed(ActionEvent evt) {
                JDRCreatinina.this.jButton1ActionPerformed(evt);
            }
        });
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE RESULTADOS CREATININA", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JDRCreatinina.2
            public void mouseClicked(MouseEvent evt) {
                JDRCreatinina.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, -1, 336, 32767).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 190, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addGap(6, 6, 6)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getRowCount() > -1) {
            this.xJPFiltroIFG.JTFFCreatinina.setValue(Double.valueOf(Double.parseDouble(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 1).toString())));
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Resultado", "IdResultado"}) { // from class: Historia.JDRCreatinina.3
            Class[] types = {Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT  DATE_FORMAT(`l_detalleresultado`.`Fecha`,'%d-%m-%Y') AS Fecha,`l_detalleresultado`.`Resultado` ,`l_detalleresultado`.`Id_Resultado`  FROM `l_detalleresultado` INNER JOIN `baseserver`.`l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)  INNER JOIN `baseserver`.`l_recepcion`   ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)  WHERE (`l_recepcion`.`Id_Paciente` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `l_detalleresultado`.`Id_ProtocolProcedim` =340) ORDER BY `l_detalleresultado`.`Fecha` DESC";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDRCreatinina.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
