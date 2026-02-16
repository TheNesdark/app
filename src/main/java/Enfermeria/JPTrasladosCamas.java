package Enfermeria;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPTrasladosCamas.class */
public class JPTrasladosCamas extends JPanel {
    private String xidAtencion;
    private boolean xlleno;
    private DefaultTableModel xmodeloHistorico;
    private Object[] xdatos;
    private String[][] xidComboCama;
    private String[][] xidComboPabellon;
    private JButton JBTrasladar;
    private JComboBox JCB_ACama;
    private JComboBox JCB_APabellon;
    private JDateChooser JDC_AFecha;
    private JLabel JLCama;
    private JLabel JLFecha;
    private JLabel JLPiso;
    private JTable JTDetalle;
    public JFormattedTextField JTFF_AHora;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String[] xDataCamaOrigen = new String[8];

    public JPTrasladosCamas(String xidAtencion) {
        this.xidAtencion = "";
        this.xlleno = false;
        initComponents();
        this.xidAtencion = xidAtencion;
        mBuscaCamaAsignada();
        this.JCB_APabellon.removeAllItems();
        this.xidComboPabellon = this.xct.llenarComboyLista("SELECT `f_unidadcama`.`Id`, `f_unidadcama`.`Nbre`, f_unidadcama.EsHosp, `f_unidadcama`.`idTipoAtencion` FROM `f_camas` INNER JOIN  `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) WHERE (`f_unidadcama`.`Estado` =1 AND `f_camas`.`Estado` =1) GROUP BY `f_unidadcama`.`Id` ORDER BY `f_unidadcama`.`Nbre` ASC ", this.xidComboPabellon, this.JCB_APabellon, 4);
        this.JCB_APabellon.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JDC_AFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_AHora.setValue(this.xmt.getFechaActual());
        mBuscaHistTraslados();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JLCama = new JLabel();
        this.JLPiso = new JLabel();
        this.JLFecha = new JLabel();
        this.jPanel2 = new JPanel();
        this.JCB_APabellon = new JComboBox();
        this.JCB_ACama = new JComboBox();
        this.JTFF_AHora = new JFormattedTextField();
        this.JDC_AFecha = new JDateChooser();
        this.JBTrasladar = new JButton();
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO TRASLADOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "CAMA ASIGNADA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLCama.setFont(new Font("Arial", 1, 12));
        this.JLCama.setHorizontalAlignment(0);
        this.JLCama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLPiso.setFont(new Font("Arial", 1, 12));
        this.JLPiso.setHorizontalAlignment(0);
        this.JLPiso.setBorder(BorderFactory.createTitledBorder((Border) null, "Piso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLFecha.setFont(new Font("Arial", 1, 12));
        this.JLFecha.setHorizontalAlignment(0);
        this.JLFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLFecha, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPiso, -2, 267, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCama, -2, 191, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLCama, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JLPiso, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(3, 3, 3)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE TRASLADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_APabellon.setFont(new Font("Arial", 1, 12));
        this.JCB_APabellon.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_APabellon.addItemListener(new ItemListener() { // from class: Enfermeria.JPTrasladosCamas.1
            public void itemStateChanged(ItemEvent evt) {
                JPTrasladosCamas.this.JCB_APabellonItemStateChanged(evt);
            }
        });
        this.JCB_APabellon.addActionListener(new ActionListener() { // from class: Enfermeria.JPTrasladosCamas.2
            public void actionPerformed(ActionEvent evt) {
                JPTrasladosCamas.this.JCB_APabellonActionPerformed(evt);
            }
        });
        this.JCB_ACama.setFont(new Font("Arial", 1, 12));
        this.JCB_ACama.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_AHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_AHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFF_AHora.setFont(new Font("Arial", 1, 12));
        this.JTFF_AHora.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JPTrasladosCamas.3
            public void keyPressed(KeyEvent evt) {
                JPTrasladosCamas.this.JTFF_AHoraKeyPressed(evt);
            }
        });
        this.JDC_AFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_AFecha.setDateFormatString("dd/MM/yyyy");
        this.JDC_AFecha.setFont(new Font("Arial", 1, 12));
        this.JBTrasladar.setFont(new Font("Arial", 1, 12));
        this.JBTrasladar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTrasladar.setText("Trasladar");
        this.JBTrasladar.addActionListener(new ActionListener() { // from class: Enfermeria.JPTrasladosCamas.4
            public void actionPerformed(ActionEvent evt) {
                JPTrasladosCamas.this.JBTrasladarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JDC_AFecha, -2, 116, -2).addGap(3, 3, 3).addComponent(this.JTFF_AHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_APabellon, -2, 236, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_ACama, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTrasladar, -2, 130, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDC_AFecha, -1, -1, 32767).addComponent(this.JTFF_AHora, GroupLayout.Alignment.LEADING, -2, 45, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTrasladar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_APabellon, -2, -1, -2).addComponent(this.JCB_ACama, -2, -1, -2)))).addGap(3, 3, 3)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 154, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_APabellon.getSelectedIndex() != -1) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.JCB_ACama.removeAllItems();
            String sql = "SELECT `f_camas`.`Id`, `f_camas`.`Nbre`, `f_tiposervtipoproced`.`Idtiposervicio`, f_camas.`Id_Procedimiento`  \n FROM `f_camas` INNER JOIN `g_procedimiento`   ON (`f_camas`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN `f_tipoprocedimiento` \n ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN `f_tiposervtipoproced` \n ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)\n WHERE (f_camas.Disponible=0  AND `f_camas`.`Estado` =1  AND `f_camas`.`Id_UnidadCamas` ='" + this.xidComboPabellon[this.JCB_APabellon.getSelectedIndex()][0] + "') \n  group by `f_camas`.`Id` ORDER BY `f_camas`.`Nbre` ASC ";
            System.out.println("" + sql);
            this.xidComboCama = xct1.llenarComboyLista(sql, this.xidComboCama, this.JCB_ACama, 4);
            this.JCB_ACama.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_APabellonActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_AHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFF_AHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTrasladarActionPerformed(ActionEvent evt) {
        mTrasladar();
        mBuscaHistTraslados();
    }

    private void mTrasladar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE `h_orden_hospitalizacion_traslado` SET `Id_CamaDestino`= '" + this.xidComboCama[this.JCB_ACama.getSelectedIndex()][0] + "', `Fecha_Egreso`='" + this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_AHora.getValue()) + "', `Id_Profesional`='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',`Id_Especialidad`='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',Id_UsuarioS='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', NDias='" + mCalculaDias(this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.JTFF_AHora.getValue().toString(), this.JLFecha.getText()) + "'  WHERE Id='" + this.xDataCamaOrigen[0] + "' ";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            String sql2 = "UPDATE `f_camas` SET Disponible=0 WHERE Id='" + this.xDataCamaOrigen[1] + "'";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
            String sql4 = "UPDATE `f_camas` SET Disponible=1 WHERE Id='" + this.xidComboCama[this.JCB_ACama.getSelectedIndex()][0] + "'";
            this.xct.ejecutarSQL(sql4);
            this.xct.cerrarConexionBd();
            String sql3 = "UPDATE ingreso SET `Id_TipoAtencion`='" + this.xidComboPabellon[this.JCB_APabellon.getSelectedIndex()][2] + "', Cama='" + this.xidComboCama[this.JCB_ACama.getSelectedIndex()][0] + "' WHERE Id='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(sql3);
            this.xct.cerrarConexionBd();
            String sql5 = "INSERT INTO  `h_orden_hospitalizacion_traslado` ( `IdOrdenHosp`,`Id_Atencion`,`Fecha_Ingreso`,`Id_CamaOrigen`, `Id_Profesional`,`Id_Especialidad`,`Id_UsuarioS`) VALUES ( '" + mBuscaIdOrdenHosp() + "','" + this.xidAtencion + "','" + this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.xmt.formatoH24.format(this.JTFF_AHora.getValue()) + "','" + this.xidComboCama[this.JCB_ACama.getSelectedIndex()][0] + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
            this.xct.ejecutarSQL(sql5);
            this.xct.cerrarConexionBd();
            mBuscaCamaAsignada();
            mNuevo();
        }
    }

    private void mNuevo() {
        this.JDC_AFecha.setDate(this.xmt.getFechaActual());
        this.JTFF_AHora.setValue(this.xmt.getFechaActual());
        this.JCB_APabellon.setSelectedIndex(-1);
        this.JCB_ACama.removeAllItems();
    }

    private void mBuscaCamaAsignada() {
        String sql = "SELECT h_orden_hospitalizacion_traslado.Id, DATE_FORMAT(`h_orden_hospitalizacion_traslado`.`Fecha_Ingreso`,'%Y-%m-%d %H:%i:%s') AS Fecha_Ingreso , `h_orden_hospitalizacion_traslado`.`Id_CamaOrigen` , `f_camas`.`Nbre` AS Cama , `f_unidadcama`.`Nbre` AS Piso ,`f_tiposervtipoproced`.`Idtiposervicio`, f_camas.`Id_Procedimiento` , f_procedimcentrocosto.`Id_CentroCosto`,f_tarifaprocedimiento.`Id_Manual` , f_tarifaprocedimiento.`VrMinimo`, f_tarifaprocedimiento.`VrMaximo` \n FROM  `h_orden_hospitalizacion_traslado`  \n INNER JOIN `f_camas`  ON (`h_orden_hospitalizacion_traslado`.`Id_CamaOrigen` = `f_camas`.`Id`)  \n INNER JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`) \n  INNER JOIN `g_procedimiento`   ON (`f_camas`.`Id_Procedimiento` = `g_procedimiento`.`Id`)  \n   INNER JOIN `f_tipoprocedimiento` ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) \n     INNER JOIN `f_tiposervtipoproced` ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)  \n     INNER JOIN `h_atencion` ON (h_atencion.`Id`=h_orden_hospitalizacion_traslado.`Id_Atencion`)\n     INNER JOIN `ingreso` ON (h_atencion.`Id_Ingreso`=ingreso.`Id`)\n     LEFT JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id_EmpresaConvenio`=ingreso.`Id_EmpresaContxConv`)\n     LEFT  JOIN  `f_tarifaprocedimiento` ON (g_procedimiento.`Id`= f_tarifaprocedimiento.`Id_Procedimiento`)  \n     AND (f_empresacontxconvenio.`Id_Manual`=f_tarifaprocedimiento.`Id_Manual`)     \n     LEFT JOIN `f_procedimcentrocosto` ON (g_procedimiento.`Id` = f_procedimcentrocosto.`Id_Procedimiento`) \n      \n      WHERE (`h_orden_hospitalizacion_traslado`.`Fecha_Egreso` IS NULL  AND `h_orden_hospitalizacion_traslado`.`Id_Atencion` ='" + this.xidAtencion + "' \n       AND `h_orden_hospitalizacion_traslado`.`Estado` =1) ";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xDataCamaOrigen[0] = xrs.getString("Id");
                this.xDataCamaOrigen[1] = xrs.getString("Id_CamaOrigen");
                this.JLFecha.setText(xrs.getString("Fecha_Ingreso"));
                this.JLPiso.setText(xrs.getString("Piso"));
                this.JLCama.setText(xrs.getString("Cama"));
                this.xDataCamaOrigen[2] = xrs.getString("Idtiposervicio");
                this.xDataCamaOrigen[3] = xrs.getString("Id_Procedimiento");
                this.xDataCamaOrigen[4] = xrs.getString("Id_CentroCosto");
                this.xDataCamaOrigen[5] = xrs.getString("Id_Manual");
                this.xDataCamaOrigen[6] = xrs.getString("VrMinimo");
                this.xDataCamaOrigen[7] = xrs.getString("VrMaximo");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasladosCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mBuscaIdOrdenHosp() {
        String xOrden = null;
        String sql = "SELECT `Id` FROM `h_orden_hospitalizacion` WHERE `Id_Atencion`= '" + this.xidAtencion + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xOrden = xrs.getString(1);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasladosCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOrden;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloHistorico = new DefaultTableModel(new Object[0], new String[]{"IdCama", "Cama", "Piso", "Fecha Ingreso", "Fecha Egreso", "No. días", "Valor"}) { // from class: Enfermeria.JPTrasladosCamas.5
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Integer.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloHistorico);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mBuscaHistTraslados() {
        mCrearModeloHistorico();
        String sql = "SELECT `h_orden_hospitalizacion_traslado`.`Id_CamaOrigen`, `f_camas`.`Nbre`, `f_unidadcama`.`Nbre`, DATE_FORMAT(`h_orden_hospitalizacion_traslado`.`Fecha_Ingreso`,'%Y-%m-%d %H:%i:%s') AS Fecha_Ingreso \n    , DATE_FORMAT(`h_orden_hospitalizacion_traslado`.`Fecha_Egreso`,'%Y-%m-%d %H:%i:%s') AS Fecha_Egreso, `h_orden_hospitalizacion_traslado`.`NDias`  FROM `h_orden_hospitalizacion_traslado` INNER JOIN `f_camas`  ON (`h_orden_hospitalizacion_traslado`.`Id_CamaOrigen` = `f_camas`.`Id`)\n    INNER JOIN `f_unidadcama`  ON (`f_camas`.`Id_UnidadCamas` = `f_unidadcama`.`Id`)\n WHERE (`h_orden_hospitalizacion_traslado`.`Fecha_Egreso` IS NOT NULL  AND `h_orden_hospitalizacion_traslado`.`Id_Atencion` ='" + this.xidAtencion + "' AND `h_orden_hospitalizacion_traslado`.`Estado` =1) ORDER BY `h_orden_hospitalizacion_traslado`.`Fecha_Egreso` DESC";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHistorico.addRow(this.xdatos);
                    this.xmodeloHistorico.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloHistorico.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHistorico.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHistorico.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHistorico.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHistorico.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                    this.xmodeloHistorico.setValueAt(0, n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasladosCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0125: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:22:0x0125 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x012a: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:24:0x012a */
    private double mCalculaTarifaCama() {
        double xvalort = 0.0d;
        try {
            try {
                String sql = "SELECT  `f_empresacontxconvenio`.`Id_Manual` , `f_empresacontxconvenio`.`EsCapitado` , `f_empresacontxconvenio`.`CualValor` , `f_empresacontxconvenio`.`FiltroProcxEmp`, `g_empresacont`.`Id_TipoPlan`, f_empresacontxconvenio.Id  , `f_estratoxemprcontconv`.`PorcSubsidio`, `f_estratoxemprcontconv`.`ValorMaximo` , `ingreso`.`SiCopago`, ingreso.`Id_TipoAtencion`, \n                    IF(f_v_datos_liquidacion_fac.IdLiquidacion IS NULL, 0,f_v_datos_liquidacion_fac.IdLiquidacion) AS IdLiquidacion, `f_estratoxemprcontconv`.`TopeAtencion` , `f_estratoxemprcontconv`.`ToPeAnual`, f_empresacontxconvenio.Id_GIps    \n                    FROM `ingreso` INNER JOIN `baseserver`.`f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont` ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN `f_estrato`  ON (`ingreso`.`Id_Estrato` = `f_estrato`.`Id`) \n                    INNER JOIN `profesional1`  ON (`ingreso`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`) AND (`ingreso`.`Id_Profesional` = `profesional1`.`Id_Persona`) INNER JOIN `g_tipoatencion`   ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) \n                    INNER JOIN `f_estratoxemprcontconv`  ON (`f_estratoxemprcontconv`.`Copago` = `ingreso`.`SiCopago`) AND (`f_estratoxemprcontconv`.`Id_EmpresaContConv` = `f_empresacontxconvenio`.`Id`) AND (`f_estratoxemprcontconv`.`Id_Estrato` = `f_estrato`.`Id`) \n                    LEFT JOIN `f_v_datos_liquidacion_fac`  ON (`ingreso`.`Id` = `f_v_datos_liquidacion_fac`.`Id_Ingreso`)   \n                    WHERE (`ingreso`.`Id` ='" + Principal.txtNo.getText() + "' AND `ingreso`.`Estado`=0) ORDER BY `ingreso`.`FechaIngreso` DESC,`ingreso`.`HoraIngreso` DESC ";
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrs = xct.traerRs(sql);
                Throwable th = null;
                if (xrs.next()) {
                    xrs.first();
                    if (xrs.getString("CualValor").equals("0")) {
                        xvalort = ((double) mCalculaDias(this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.JTFF_AHora.getValue().toString(), this.JLFecha.getText())) * Double.parseDouble(this.xDataCamaOrigen[6]);
                    } else {
                        xvalort = ((double) mCalculaDias(this.xmt.formatoAMD.format(this.JDC_AFecha.getDate()) + " " + this.JTFF_AHora.getValue().toString(), this.JLFecha.getText())) * Double.parseDouble(this.xDataCamaOrigen[7]);
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                xct.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasladosCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalort;
    }

    private int mCalculaDias(String xfechaE, String xfechaI) {
        int xdias = 0;
        String sql = "SELECT DATEDIFF('" + xfechaE + "','" + xfechaI + "') AS dias ";
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xdias = xrs.getInt("dias");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTrasladosCamas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdias;
    }
}
