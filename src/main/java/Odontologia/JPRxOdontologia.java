package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPRxOdontologia.class */
public class JPRxOdontologia extends JPanel {
    private Metodos xmt = new Metodos();
    public DefaultTableModel xmodeloprOtros;
    private Object[] xdatosprocO;
    private JScrollPane JSPDetalleOProcOtros;
    private JTable JTDetalleProcOtros;

    public JPRxOdontologia() {
        initComponents();
        mCargarDatosOtrosProcedimientos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaProcOtros() {
        this.xmodeloprOtros = new DefaultTableModel(new Object[0], new String[]{"CodPlaca", "Fecha", "CodCUP", "Procedimiento"}) { // from class: Odontologia.JPRxOdontologia.1
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProcOtros.setModel(this.xmodeloprOtros);
        this.JTDetalleProcOtros.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleProcOtros.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalleProcOtros.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleProcOtros.getColumnModel().getColumn(3).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalleOProcOtros = new JScrollPane();
        this.JTDetalleProcOtros = new JTable();
        setName("xjpRxOdontologia");
        this.JSPDetalleOProcOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProcOtros.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProcOtros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProcOtros.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProcOtros.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProcOtros.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPRxOdontologia.2
            public void mouseClicked(MouseEvent evt) {
                JPRxOdontologia.this.JTDetalleProcOtrosMouseClicked(evt);
            }
        });
        this.JTDetalleProcOtros.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPRxOdontologia.3
            public void keyPressed(KeyEvent evt) {
                JPRxOdontologia.this.JTDetalleProcOtrosKeyPressed(evt);
            }
        });
        this.JSPDetalleOProcOtros.setViewportView(this.JTDetalleProcOtros);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPDetalleOProcOtros).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleOProcOtros, -2, 236, -2).addContainerGap(-1, 32767)));
    }

    private void mCargarDatosOtrosProcedimientos() {
        try {
            mCrearModeloTablaProcOtros();
            String sql = "SELECT `o_hc_tratamiento_procedimiento`.`Id` AS CodPlaca\n\t, o_hc_tratamiento_procedimiento.`FechaR`\n    , `o_hc_tratamiento_procedimiento`.`IdProcedimiento` AS Cod_CUP\n    , `g_procedimiento`.`Nbre`\nFROM\n    `o_hc_tratamiento_procedimiento`\n    INNER JOIN `o_hc_tratamiento` \n        ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)\n    INNER JOIN `g_procedimiento` \n        ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `h_atencion` \n        ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `o_proced_x_grupo` \n        ON (`o_proced_x_grupo`.`IdProcedimiento` = `g_procedimiento`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\n    AND `o_proced_x_grupo`.`IdGrupo` =5) ORDER BY o_hc_tratamiento_procedimiento.`FechaR` DESC ;";
            System.out.println("Placas-->" + sql);
            ConsultasMySQL xct2 = new ConsultasMySQL();
            ResultSet xrs2 = xct2.traerRs(sql);
            this.xmt.mEstablecerTextEditor(this.JTDetalleProcOtros, 3);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                int n = 0;
                while (xrs2.next()) {
                    this.xmodeloprOtros.addRow(this.xdatosprocO);
                    this.xmodeloprOtros.setValueAt(xrs2.getString(1), n, 0);
                    this.xmodeloprOtros.setValueAt(xrs2.getString(2), n, 1);
                    this.xmodeloprOtros.setValueAt(xrs2.getString(3), n, 2);
                    this.xmodeloprOtros.setValueAt(xrs2.getString(4), n, 3);
                    n++;
                }
            }
            xrs2.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcOtrosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            String ruta = this.xmt.mTraerUrlBD(Principal.informacionIps.getUrlRxOdont() + this.xmodeloprOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 0).toString() + "\\");
            File folder = new File(ruta);
            System.out.println("Ruta-->" + ruta);
            if (folder.exists()) {
                mAbrirArchivo();
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe ninguna Placa con el código " + this.xmodeloprOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 0).toString(), "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private void mAbrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.xmt.mTraerUrlBD(Principal.informacionIps.getUrlRxOdont() + this.xmodeloprOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 0).toString() + "\\"));
        } catch (IOException ex) {
            Logger.getLogger(JPRxOdontologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcOtrosKeyPressed(KeyEvent evt) {
    }
}
