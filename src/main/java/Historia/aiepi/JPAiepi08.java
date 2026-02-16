package Historia.aiepi;

import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi08.class */
public class JPAiepi08 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private JScrollPane JSPDiagnosticos;
    private JTable JTDx;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JPAiepi08() {
        initComponents();
        mBuscarResultados();
    }

    public void mBuscarResultados() {
        String sql = "SELECT `p_aiepi_encabezado`.`Id` , DATE_FORMAT(`p_aiepi_encabezado`.`FechaR`, '%d-%m-%Y') AS FechaR  , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`, p_aiepi_encabezado.IdAtencion FROM `p_aiepi_encabezado` INNER JOIN  `profesional1`  ON (`p_aiepi_encabezado`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`p_aiepi_encabezado`.`IdEspecialista` = `profesional1`.`IdEspecialidad`) WHERE (`p_aiepi_encabezado`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND p_aiepi_encabezado.Estado=1) ORDER BY p_aiepi_encabezado.FechaR  DESC";
        mCreaModelodx();
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDx.addRow(this.xdatos);
                    this.xmodeloDx.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloDx.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloDx.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloDx.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloDx.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi01.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelodx() {
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Profesional", "Especialidad", "IdAtencion"}) { // from class: Historia.aiepi.JPAiepi08.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDx.setModel(this.xmodeloDx);
        this.JTDx.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDx.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDx.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDx.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDx.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDx.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDx.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JTDx.addMouseListener(new MouseAdapter() { // from class: Historia.aiepi.JPAiepi08.2
            public void mouseClicked(MouseEvent evt) {
                JPAiepi08.this.JTDxMouseClicked(evt);
            }
        });
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDiagnosticos, -1, 715, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDiagnosticos, -2, 256, -2).addContainerGap(30, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDxMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xmodeloDx.getValueAt(this.JTDx.getSelectedRow(), 4).toString();
            mparametros[1][0] = "idpaciente1";
            mparametros[1][1] = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica", mparametros);
        }
    }
}
