package ComprasBS;

import Acceso.Principal;
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

/* JADX INFO: loaded from: GenomaP.jar:ComprasBS/JDRespuestaEvaluacion.class */
public class JDRespuestaEvaluacion extends JDialog {
    public DefaultTableModel xmodelo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Object[] xdato;
    private JIFAutorizarReq xjifautorizacion;
    private Metodos xmetodos;
    private JButton JBTCerrar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JDRespuestaEvaluacion(JIFAutorizarReq xjifautorizacion) {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjifautorizacion = xjifautorizacion;
        mCargarDetalle();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCerrar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("RESPUESTA");
        setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ComprasBS.JDRespuestaEvaluacion.1
            public void mouseClicked(MouseEvent evt) {
                JDRespuestaEvaluacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTCerrar.setText("Grabar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: ComprasBS.JDRespuestaEvaluacion.2
            public void actionPerformed(ActionEvent evt) {
                JDRespuestaEvaluacion.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTCerrar, GroupLayout.Alignment.LEADING, -1, 516, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 516, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 199, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar, -2, 48, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        mGrabar();
        dispose();
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Sí / No"}) { // from class: ComprasBS.JDRespuestaEvaluacion.3
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
    }

    private void mCargarDetalle() {
        mCrearTablaDetalle();
        ResultSet rs = this.xct.traerRs("SELECT  `t_epregunta`.`Id` , `t_epregunta`.`Nbre` FROM `t_tipoencuestaxpregunta` INNER JOIN `baseserver`.`t_epregunta` ON (`t_tipoencuestaxpregunta`.`Id_Pregunta` = `t_epregunta`.`Id`) WHERE (`t_tipoencuestaxpregunta`.`Id_Tipo_Encuesta` =55  AND `t_epregunta`.`Estado` =1) ORDER BY `t_epregunta`.`Id`  aSC");
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(false, x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mGrabar() {
        int i;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 2).toString().equals("true")) {
                i = 1;
            } else {
                i = 0;
            }
            int valor = i;
            String sql = "insert ignore into  t_respuestas_requisicion(`Id_requisicion` , `Id_Pregunta` , `Respuesta` ,  `UsuarioS`)values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + valor + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        }
    }
}
