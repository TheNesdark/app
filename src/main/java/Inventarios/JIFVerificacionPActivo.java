package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFVerificacionPActivo.class */
public class JIFVerificacionPActivo extends JInternalFrame {
    private Object[] xdatos;
    private String xidusuarios;
    public static boolean v = true;
    private JButton JBTArrancar;
    private JScrollPane JSPTablaFormulas;
    private JTable JTBVerificacionPA;
    private DefaultTableModel xmodelo = new DefaultTableModel();
    private GregorianCalendar fechaAnterior = new GregorianCalendar();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();

    public JIFVerificacionPActivo(String xidusuarios) {
        initComponents();
        this.xidusuarios = xidusuarios;
        this.fechaAnterior.add(2, -1);
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBTArrancar = new JButton();
        this.JSPTablaFormulas = new JScrollPane();
        this.JTBVerificacionPA = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("VERIFICACIÓN DE DESPACHO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JBTArrancar.setFont(new Font("Arial", 1, 12));
        this.JBTArrancar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTArrancar.setText("Salir");
        this.JBTArrancar.addActionListener(new ActionListener() { // from class: Inventarios.JIFVerificacionPActivo.1
            public void actionPerformed(ActionEvent evt) {
                JIFVerificacionPActivo.this.JBTArrancarActionPerformed(evt);
            }
        });
        this.JSPTablaFormulas.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBVerificacionPA.setFont(new Font("Arial", 1, 12));
        this.JTBVerificacionPA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBVerificacionPA.setRowHeight(25);
        this.JTBVerificacionPA.setSelectionBackground(new Color(255, 255, 255));
        this.JTBVerificacionPA.setSelectionForeground(new Color(255, 0, 0));
        this.JTBVerificacionPA.setSelectionMode(0);
        this.JTBVerificacionPA.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFVerificacionPActivo.2
            public void mouseClicked(MouseEvent evt) {
                JIFVerificacionPActivo.this.JTBVerificacionPAMouseClicked(evt);
            }
        });
        this.JSPTablaFormulas.setViewportView(this.JTBVerificacionPA);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTArrancar, GroupLayout.Alignment.LEADING, -1, 778, 32767).addComponent(this.JSPTablaFormulas, GroupLayout.Alignment.LEADING, -1, 778, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPTablaFormulas, -2, 305, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTArrancar, -1, 43, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTArrancarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerificacionPAMouseClicked(MouseEvent evt) {
        if (this.JTBVerificacionPA.getSelectedRow() != -1 && Integer.valueOf(this.xmodelo.getValueAt(this.JTBVerificacionPA.getSelectedRow(), 3).toString()).intValue() != 0) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar la formula?", "CONSULTAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmetodos.mImprimirFormula(Long.valueOf(this.xmodelo.getValueAt(this.JTBVerificacionPA.getSelectedRow(), 3).toString()).longValue(), 2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Suministro o Dispotivo Médicos", "Cantidad", "", "", ""}) { // from class: Inventarios.JIFVerificacionPActivo.3
            Class[] types = {String.class, String.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBVerificacionPA.setModel(this.xmodelo);
        this.JTBVerificacionPA.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBVerificacionPA.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBVerificacionPA.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBVerificacionPA.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBVerificacionPA.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String xsql = "SELECT DATE_FORMAT(i_salidas.FechaSalida,'%d/%m/%Y') AS fecha, CONCAT(i_suministro.Nbre,' ',i_presentacioncomercial.Nbre,' ',i_laboratorio.Nbre) AS Nombre, i_detallesalida.CantidadDespachada, i_salidas.OrdenH, i_suministro.IdPrincipioActivo, i_salidas.Id FROM i_salidas INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id)  INNER JOIN persona  ON (persona.Id_persona = i_salidas.IdDestino) INNER JOIN i_detallesalida  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (persona.Id_persona ='" + this.xidusuarios + "'  AND i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.fechaAnterior.getTime()) + "' AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "' AND i_salidas.Estado =0) ORDER BY i_salidas.FechaSalida DESC ";
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), n, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFVerificacionPActivo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir(long idorden) {
    }
}
