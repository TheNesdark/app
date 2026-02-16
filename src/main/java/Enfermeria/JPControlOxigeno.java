package Enfermeria;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPControlOxigeno.class */
public class JPControlOxigeno extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xIdProf;
    private String[] xIdEsp;
    private String[] xTipoOxigeno;
    private boolean xlleno;
    private JButton JBTermina;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBMedico;
    private JComboBox JCBTipoDeOxigeno;
    private JDateChooser JDCFecha;
    private JDateChooser JDCFechaF;
    private JTable JTDetalle;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFHoraF;
    private JFormattedTextField JTFFIO2;
    private JFormattedTextField JTFLitros;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private String xidatencion = "";
    Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xOrdenOx = "";
    private int xGuardado = 0;

    public JPControlOxigeno(String xnombre) {
        this.xlleno = false;
        initComponents();
        mRealizarCasting(xnombre);
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JTFFHoraF.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.xIdEsp = this.xct.llenarCombo("SELECT  `IdEspecialidad` , `Especialidad` FROM `profesional1` GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC", this.xIdEsp, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        cargarComboOxigeno();
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JTFLitros.setValue(0);
        mBuscar();
    }

    private void mRealizarCasting(String xnombre) {
        if (xnombre.equals("xjifhistoriauh")) {
            this.xidatencion = Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText();
        } else if (xnombre.equals("jifhistoriaclinica")) {
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        }
    }

    private void cargarComboOxigeno() {
        this.xTipoOxigeno = this.xct.llenarCombo("SELECT `id`,`nombre` FROM `h_tipo_oxigeno`", this.xTipoOxigeno, this.JCBTipoDeOxigeno);
        this.JCBTipoDeOxigeno.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private boolean mVerificaExistencia() {
        boolean xExiste = false;
        String sql = "SELECT Cierre FROM `h_orden_oxigeno` WHERE IdAtencion='" + this.xidatencion + "' AND Cierre=0 AND Estado=1";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlOxigeno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    public void mGuardar() {
        String sql;
        if (!this.JTFLitros.getText().equals("0")) {
            if (this.JCBMedico.getSelectedIndex() > -1) {
                if (this.JCBTipoDeOxigeno.getSelectedIndex() > -1) {
                    int x = JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if (this.xGuardado == 0) {
                            if (!mVerificaExistencia()) {
                                String sql2 = "insert into  `h_orden_oxigeno`\n            ( `IdAtencion`,`idTipoOxigeno` ,`FechaI`, `HoraI`, `Litros`,`idEspecialidadOrdena`  ,`idProfesionalOrdena`  ,`MedOrdena`,\n             `IdTipoAtencion`, `IdProfesional`, `IdEspecialidad`,  `UsuarioS`, `fi_O2`)\n values ( '" + this.xidatencion + "'," + this.xTipoOxigeno[this.JCBTipoDeOxigeno.getSelectedIndex()] + ", '" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "', '" + this.JTFFHora.getText() + "', '" + this.JTFLitros.getText().replaceAll(",", ".") + "'," + this.xIdEsp[this.JCBEspecialidad.getSelectedIndex()] + " ," + this.xIdProf[this.JCBMedico.getSelectedIndex()] + " ,'" + this.JCBMedico.getSelectedItem() + "', '" + Principal.claseenfer.xjifhc_uhh.xId_TipoAtencion + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',\n'" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "'," + this.JTFFIO2.getText() + ");";
                                this.xOrdenOx = this.xct.ejecutarSQLId(sql2);
                            } else {
                                JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "Aplicacion de oxigeno por finalizar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        } else {
                            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).intValue() != 0) {
                                sql = "UPDATE `h_orden_oxigeno` SET `idTipoOxigeno` =" + this.xTipoOxigeno[this.JCBTipoDeOxigeno.getSelectedIndex()] + ", `FechaI` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "',`HoraI`='" + this.JTFFHora.getText() + "',`Litros`=" + this.JTFLitros.getText() + ",`fi_O2`=" + this.JTFFIO2.getText() + ",`FechaR`='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "',`HoraR`='" + this.JTFFHoraF.getText() + "'\n\t,`idEspecialidadOrdena`=" + this.xIdEsp[this.JCBEspecialidad.getSelectedIndex()] + ",`idProfesionalOrdena`=" + this.xIdProf[this.JCBMedico.getSelectedIndex()] + ",`MedOrdena`='" + this.JCBMedico.getSelectedItem() + "',`IdTipoAtencion`=" + Principal.claseenfer.xjifhc_uhh.xId_TipoAtencion + ",`IdProfesional`= " + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + ",`IdEspecialidad`= " + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + ",\n\t`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE id=" + this.xOrdenOx + ";";
                            } else {
                                sql = "UPDATE `h_orden_oxigeno` SET `idTipoOxigeno` =" + this.xTipoOxigeno[this.JCBTipoDeOxigeno.getSelectedIndex()] + ", `FechaI` ='" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "',`HoraI`='" + this.JTFFHora.getText() + "',`Litros`=" + this.JTFLitros.getText() + ",`fi_O2`=" + this.JTFFIO2.getText() + "\t,`idEspecialidadOrdena`=" + this.xIdEsp[this.JCBEspecialidad.getSelectedIndex()] + ",`idProfesionalOrdena`=" + this.xIdProf[this.JCBMedico.getSelectedIndex()] + ",`MedOrdena`='" + this.JCBMedico.getSelectedItem() + "',`IdTipoAtencion`=" + Principal.claseenfer.xjifhc_uhh.xId_TipoAtencion + ",`IdProfesional`= " + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + ",`IdEspecialidad`= " + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + ",\n`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE id=" + this.xOrdenOx + ";";
                            }
                            this.xct.ejecutarSQL(sql);
                        }
                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        this.xct.cerrarConexionBd();
                        mBuscar();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "Seleccione el tipo de oxigeno", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDeOxigeno.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "Seleccione el profesional que ordena", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMedico.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "El valor de Litros de ser diferente de Cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFLitros.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaI", "HoraI", "Litros", "FechaT", "HoraT", "MédicoOrdena", "TipoAtencion", "Profesional", "Especialidad", "Cierre", "idTipoOxigeno", "Tipo De Oxigeno", "idEspecialidadOrdena", "idProfesionalOrdena", "FIO2"}) { // from class: Enfermeria.JPControlOxigeno.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(80);
    }

    private void mBuscar() {
        try {
            String sql = "SELECT `h_orden_oxigeno`.`Id` , DATE_FORMAT(`h_orden_oxigeno`.`FechaI`,'%d-%m-%Y') AS FechaI\n                        , DATE_FORMAT(`h_orden_oxigeno`.`HoraI`,'%H:%i:%s') AS HoraI , `h_orden_oxigeno`.`Litros`\n                         , IF(DATE_FORMAT(`h_orden_oxigeno`.`FechaR`,'%d-%m-%Y')IS NULL,'',DATE_FORMAT(`h_orden_oxigeno`.`FechaR`,'%d-%m-%Y')) AS FechaR , \n                    IF(DATE_FORMAT(`h_orden_oxigeno`.`HoraR`,'%H:%i:%s') IS NULL,'',DATE_FORMAT(`h_orden_oxigeno`.`HoraR`,'%H:%i:%s')) AS HoraR\n                        , `h_orden_oxigeno`.`MedOrdena`  ,  `g_tipoatencion`.`Nbre` AS TipoAtencion,\n                        CONCAT(`profesional1`.`NProfesional` ,'-',`profesional1`.`Especialidad`), \n                        `profesional1`.`Especialidad`, h_orden_oxigeno.Cierre, `h_orden_oxigeno`.`idTipoOxigeno`, `h_tipo_oxigeno`.`nombre`,`idEspecialidadOrdena`,`idProfesionalOrdena` ,`fi_O2` \n                    FROM `h_orden_oxigeno` \n                    INNER JOIN `profesional1`  \n                     ON (`h_orden_oxigeno`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_orden_oxigeno`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\n                    INNER JOIN  `g_tipoatencion` \n                     ON (`h_orden_oxigeno`.`IdTipoAtencion` = `g_tipoatencion`.`Id`)\n                    INNER JOIN `h_tipo_oxigeno`\n                     ON (`h_orden_oxigeno`.`idTipoOxigeno` = `h_tipo_oxigeno`.`id`)WHERE (`h_orden_oxigeno`.`Estado` =1 AND h_orden_oxigeno.`IdAtencion`='" + this.xidatencion + "') ORDER BY `h_orden_oxigeno`.`FechaI` DESC;";
            mCrearTablaHistorico();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                int xfila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), xfila, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), xfila, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), xfila, 9);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(11)), xfila, 10);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(12)), xfila, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), xfila, 12);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(14)), xfila, 13);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(15)), xfila, 14);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(16)), xfila, 15);
                    xfila++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlOxigeno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JTFLitros = new JFormattedTextField();
        this.JCBMedico = new JComboBox();
        this.JBTermina = new JButton();
        this.JCBEspecialidad = new JComboBox();
        this.JDCFechaF = new JDateChooser();
        this.JTFFHoraF = new JFormattedTextField();
        this.JCBTipoDeOxigeno = new JComboBox();
        this.JTFFIO2 = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("xpControlOxigeno");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFLitros.setBorder(BorderFactory.createTitledBorder((Border) null, "Litros x Minuto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLitros.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.#"))));
        this.JTFLitros.setHorizontalAlignment(4);
        this.JTFLitros.setFont(new Font("Arial", 1, 12));
        this.JCBMedico.setFont(new Font("Arial", 1, 12));
        this.JCBMedico.setBorder(BorderFactory.createTitledBorder((Border) null, "Médico que ordena", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTermina.setFont(new Font("Arial", 1, 12));
        this.JBTermina.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Citas29x27.png")));
        this.JBTermina.setText("Finalizar Tiempo");
        this.JBTermina.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlOxigeno.2
            public void actionPerformed(ActionEvent evt) {
                JPControlOxigeno.this.JBTerminaActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Enfermeria.JPControlOxigeno.3
            public void itemStateChanged(ItemEvent evt) {
                JPControlOxigeno.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Terminación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setForeground(Color.red);
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraF.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Terminación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHoraF.setForeground(Color.red);
        try {
            this.JTFFHoraF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
        this.JTFFHoraF.setHorizontalAlignment(4);
        this.JTFFHoraF.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHoraF.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraF.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlOxigeno.4
            public void actionPerformed(ActionEvent evt) {
                JPControlOxigeno.this.JTFFHoraFActionPerformed(evt);
            }
        });
        this.JCBTipoDeOxigeno.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDeOxigeno.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo De Oxigeno", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIO2.setBorder(BorderFactory.createTitledBorder((Border) null, "FIO2", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIO2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.#"))));
        this.JTFFIO2.setHorizontalAlignment(4);
        this.JTFFIO2.setText("0");
        this.JTFFIO2.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraF, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTermina, -2, 309, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBTipoDeOxigeno, -2, 261, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLitros, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFIO2, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMedico, -2, 218, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora).addComponent(this.JTFLitros).addComponent(this.JCBMedico, -2, -1, -2).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JTFFIO2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaF, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHoraF, -2, 44, -2).addComponent(this.JBTermina, -2, 44, -2).addComponent(this.JCBTipoDeOxigeno, -2, -1, -2))).addContainerGap(21, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPControlOxigeno.5
            public void mouseClicked(MouseEvent evt) {
                JPControlOxigeno.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 322, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() > -1) {
            this.JCBMedico.removeAllItems();
            this.xIdProf = this.xct.llenarCombo("SELECT  `Id_Persona` , `NProfesional` FROM  `profesional1` WHERE (`IdEspecialidad` ='" + this.xIdEsp[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY NProfesional;", this.xIdProf, this.JCBMedico);
            this.JCBMedico.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTerminaActionPerformed(ActionEvent evt) {
        if (!this.xOrdenOx.equals("")) {
            if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()) == 0) {
                try {
                    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    Date xFechaI = formateador.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1) + " " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2));
                    Date xFechaF = formateador.parse(this.xmt.formatoDMA1.format(this.JDCFechaF.getDate()) + " " + this.JTFFHoraF.getText());
                    String FechaInicial = formateador.format(xFechaI);
                    String FechaTerminacion = formateador.format(xFechaF);
                    if (compararFechasConDate(FechaInicial, FechaTerminacion) <= 0) {
                        int x = JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Esta seguro de Guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "UPDATE `h_orden_oxigeno` SET `FechaR`='" + this.xmt.formatoAMD.format(this.JDCFechaF.getDate()) + "', `HoraR`='" + this.JTFFHoraF.getText() + "', Cierre=1 WHERE `Id`='" + this.xOrdenOx + "'";
                            this.xct.ejecutarSQL(sql);
                            this.xct.cerrarConexionBd();
                            mBuscar();
                            this.xOrdenOx = "";
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "La Fecha u Hora de Finalización\nNo puede ser menor a la Fecha u Hora de inicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    return;
                } catch (ParseException ex) {
                    Logger.getLogger(JPControlOxigeno.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "Ya tiene asignado una fecha y hora de finalización", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(Principal.claseenfer.xjifhc_uhh, "Debe seleccionar un registro de la Tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() > -1) {
            this.xOrdenOx = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            SimpleDateFormat xFechaI = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date dateI = xFechaI.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                this.JDCFecha.setDate(dateI);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.JTFFHora.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFLitros.setValue(Double.valueOf(Double.parseDouble(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString())));
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).equals("")) {
                SimpleDateFormat xFecha = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = xFecha.parse(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                    this.JDCFechaF.setDate(date);
                } catch (ParseException e2) {
                    e2.printStackTrace();
                }
                this.JTFFHoraF.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            } else {
                this.JDCFechaF.setDate(this.xmt.getFechaActual());
                this.JTFFHoraF.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            }
            this.JCBTipoDeOxigeno.setSelectedIndex(posCombo(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()), this.xTipoOxigeno));
            this.JCBEspecialidad.setSelectedIndex(posCombo(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13).toString()), this.xIdEsp));
            this.JCBMedico.setSelectedIndex(posCombo(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()), this.xIdProf));
            this.xGuardado = 1;
            this.JTFFIO2.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString());
        }
    }

    private int posCombo(int id, String[] arr) {
        int pos = 0;
        for (int x = 0; x < arr.length; x++) {
            if (id == Integer.parseInt(arr[x])) {
                pos = x;
            }
        }
        return pos;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraFActionPerformed(ActionEvent evt) {
    }

    public void mImprimir() {
        if (!this.xidatencion.equals("")) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xidatencion;
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ControlOxigeno", mparametros);
        }
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFLitros.setValue(0);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBMedico.removeAllItems();
        this.JCBTipoDeOxigeno.setSelectedIndex(-1);
        this.JDCFechaF.setDate(this.xmt.getFechaActual());
        this.JTFFHoraF.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.xOrdenOx = "";
        this.xGuardado = 0;
        this.JTFFIO2.setText("0");
        mBuscar();
    }

    private int compararFechasConDate(String fecha1, String fechaActual) {
        int resultado = 0;
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            Date fechaDate1 = formateador.parse(fecha1);
            Date fechaDate2 = formateador.parse(fechaActual);
            if (fechaDate1.before(fechaDate2)) {
                resultado = -1;
            } else if (fechaDate2.before(fechaDate1)) {
                resultado = 1;
            } else {
                resultado = 0;
            }
        } catch (ParseException e) {
        }
        return resultado;
    }

    public void mAnular() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "update h_orden_oxigeno set Estado=0 where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(xsql);
                this.xct.cerrarConexionBd();
                mBuscar();
            }
        }
    }
}
