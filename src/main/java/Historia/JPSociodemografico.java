package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSociodemografico.class */
public class JPSociodemografico extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private JComboBox[] xcomboBox1;
    private String[] xidgenerico;
    private JButton JBGrabar;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private Metodos xmt = new Metodos();

    public JPSociodemografico() {
        initComponents();
        mCargarTabla();
        mVerifica();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBGrabar = new JButton();
        setName("jpsociodemografico");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Historia.JPSociodemografico.1
            public void actionPerformed(ActionEvent evt) {
                JPSociodemografico.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 782, 32767).addComponent(this.jScrollPane2).addComponent(this.JBGrabar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 384, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 33, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    public void mGrabar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String sql = " INSERT INTO `so_p_sociodemografico_atencion` (`IdAtencion`,`IdProfesional`,`IdEspecialidad`,`FechaR`,`Observacion`,`UsuarioS`)\n VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
            String xEval = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                String sql2 = "INSERT INTO  `so_p_sociodem_detalle` (IdEvaluacion,`IdPregunta`, `Respuesta`, `UsuarioS`) VALUES ('" + xEval + "','" + this.xmodelo.getValueAt(i, 0) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            this.JBGrabar.setEnabled(false);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Orden", "Pregunta", "Respuesta"}) { // from class: Historia.JPSociodemografico.2
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                }
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private JComboBox mLlenaComboModelo(int xid, int xFila) {
        this.xcomboBox1[xFila] = new JComboBox();
        this.xcomboBox1[xFila].setName("combo" + xFila);
        this.xcomboBox1[xFila].removeAllItems();
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql = "SELECT  `so_p_respuestas`.`Id`,`so_p_respuestas`.`Nbre` FROM `so_p_sociodem_respuestas` INNER JOIN `so_p_respuestas`  ON (`so_p_sociodem_respuestas`.`IdRespuesta` = `so_p_respuestas`.`Id`)\n WHERE (`so_p_sociodem_respuestas`.`IdSociodem` ='" + xid + "')";
        this.xidgenerico = xct.llenarCombo(sql, this.xidgenerico, this.xcomboBox1[xFila]);
        this.xcomboBox1[xFila].setSelectedIndex(-1);
        xct.cerrarConexionBd();
        this.xlleno = true;
        return this.xcomboBox1[xFila];
    }

    private void mCargarTabla() {
        mCreaModelo();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , Orden,  `Nbre`  , `Tipo`  FROM `so_p_sociodemografica` ORDER BY `Orden` ASC;");
        try {
            if (xrs.next()) {
                xrs.last();
                this.xcomboBox1 = new JComboBox[xrs.getRow()];
                xrs.beforeFirst();
                int n = 0;
                EachRowRenderer rowRenderer = new EachRowRenderer();
                EachRowEditor rowEditor = new EachRowEditor(this.JTDetalle);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    if (xrs.getString("Tipo").equals("0")) {
                        DefaultCellEditor comboBoxEditor = new DefaultCellEditor(mLlenaComboModelo(xrs.getInt(1), n));
                        rowEditor.setEditorAt(n, comboBoxEditor);
                        this.xmodelo.setValueAt(" ", n, 3);
                    } else {
                        this.xmodelo.setValueAt("", n, 3);
                    }
                    n++;
                }
                this.JTDetalle.getColumn("Respuesta").setCellRenderer(rowRenderer);
                this.JTDetalle.getColumn("Respuesta").setCellEditor(rowEditor);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSociodemografico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerifica() {
        String sql = "SELECT Id FROM `so_p_sociodemografico_atencion` WHERE (IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.JBGrabar.setEnabled(false);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSociodemografico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
