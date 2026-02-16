package Presupuesto;

import Acceso.Principal;
import ComprasBS.JIFOrdenCompra;
import ComprasBS.JIFOrdenServicio;
import ComprasBS.JIFSolicitudContrato;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDBusquedaDocPTO.class */
public class JDBusquedaDocPTO extends JDialog {
    private JIFFMovimiento xJIFFMovimiento;
    private JIFOrdenCompra xJIFOrdenCompra;
    private JIFOrdenServicio xJIFOrdenServicio;
    private JIFSolicitudContrato xJIFSolicitudContrato;
    private JIFMovManual xJIFMovManual;
    private JIFFMovManualOP_PP xJIFFMovManualOP_PP;
    private JIFCompromisoPresupuestal jifcompromisopresupuestal;
    private String xTipoDoc;
    private String xIdPadre;
    private DefaultTableModel xmodelo;
    private DefaultTableModel modeloCompromiso;
    private Object[] xdatos;
    private Object xLlamador;
    private Date xFechaDoc;
    private boolean xlleno;
    private JButton JBT_Salir;
    private JYearChooser JDAno;
    private JLabel JLAutorizar;
    private JLabel JLMaestro;
    private JRadioButton JRBCon;
    private JRadioButton JRBSin;
    private JRadioButton JRBTodo;
    private JTable JTDetalle;
    private JTextField JTFNo;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xDocumento = "";

    public JDBusquedaDocPTO(Frame parent, boolean modal, Object xLlamador, String xTipoDoc, String xIdPadre) {
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("BÚSQUEDA DE DOCUMENTOS");
        System.out.println("Clase Doc-->" + xTipoDoc + " IdPadre-->" + xIdPadre);
        mCasting(xLlamador);
        this.xTipoDoc = xTipoDoc;
        this.xIdPadre = xIdPadre;
        mBuscaEmcabezado_x_Anio();
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
            if (this.xTipoDoc.equals("9")) {
                this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE SOLICITUDES", 2, 0, new Font("Arial", 1, 14), Color.red));
                mBuscaSolicitudes();
                this.JRBSin.setText("Sin Disponibilidad");
                this.JRBCon.setText("Con Disponibilidad");
            } else if (this.xTipoDoc.equals("4")) {
                this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE DISPONIBILIDADES", 2, 0, new Font("Arial", 1, 14), Color.red));
                mBuscaDisponibilidadDetalle();
                this.JRBSin.setText("Sin Compromiso");
                this.JRBCon.setText("Con Compromiso");
            }
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFOrdenCompra") || this.xLlamador.getClass().getSimpleName().equals("JIFOrdenServicio") || this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudContrato")) {
            this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE DISPONIBILIDADES", 2, 0, new Font("Arial", 1, 14), Color.red));
            mBuscaDisponibilidad();
            this.JRBSin.setText("Sin Compromiso");
            this.JRBCon.setText("Con Compromiso");
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovManualOP_PP")) {
            if (this.xTipoDoc.equals("5")) {
                this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE COMPROMISOS", 2, 0, new Font("Arial", 1, 14), Color.red));
                this.JRBSin.setText("Sin Obligación");
                this.JRBCon.setText("Con Obligación");
                this.JLAutorizar.setVisible(false);
                mBuscaDatosCompromisoManual();
            } else if (this.xTipoDoc.equals("6")) {
                this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE OBLIGACIONES", 2, 0, new Font("Arial", 1, 14), Color.red));
                mBuscaDatosObligacionManual();
                this.JRBSin.setText("Sin Pagos");
                this.JRBCon.setText("Con Pagos");
                this.JLAutorizar.setVisible(false);
            }
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DE DISPONIBILIDADES", 2, 0, new Font("Arial", 1, 14), Color.red));
            cargarDatosDisponibilidadNueva();
            this.JRBSin.setText("Sin Compromiso");
            this.JRBCon.setText("Con Compromiso");
        }
        this.xlleno = true;
    }

    private void mCasting(Object xLlamador) {
        switch (xLlamador.getClass().getSimpleName()) {
            case "JIFFMovimiento":
                this.xJIFFMovimiento = (JIFFMovimiento) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFOrdenCompra":
                this.xJIFOrdenCompra = (JIFOrdenCompra) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFOrdenServicio":
                this.xJIFOrdenServicio = (JIFOrdenServicio) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFSolicitudContrato":
                this.xJIFSolicitudContrato = (JIFSolicitudContrato) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFMovManual":
                this.xJIFMovManual = (JIFMovManual) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFFMovManualOP_PP":
                this.xJIFFMovManualOP_PP = (JIFFMovManualOP_PP) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFCompromisoPresupuestal":
                this.jifcompromisopresupuestal = (JIFCompromisoPresupuestal) xLlamador;
                this.xLlamador = xLlamador;
                break;
        }
    }

    private void mBuscaEmcabezado_x_Anio() {
        String sql = "SELECT pp_periodo.`idEncabezado`,  pp_rubros_encabezado.`nombre`\nFROM `pp_periodo` \nINNER JOIN `pp_rubros_encabezado` ON (`pp_periodo`.`idEncabezado` = `pp_rubros_encabezado`.`id`)\nWHERE DATE_FORMAT(pp_periodo.`FechaI`,'%Y')='" + this.JDAno.getValue() + "' \nGROUP BY DATE_FORMAT(pp_periodo.`FechaI`,'%Y')";
        System.out.println("" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                Principal.informacionGeneralPrincipalDTO.setIdMaestroRubro(xrs.getString("idEncabezado"));
                this.JLMaestro.setText(xrs.getString("nombre"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSol() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NConsecutivo", "Fecha", "Observación", "Usuario", "Unidad Funcional", "IdRbro", "Valor"}) { // from class: Presupuesto.JDBusquedaDocPTO.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(380);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(210);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(70);
    }

    private void mBuscaSolicitudes() {
        String sql = null;
        System.out.println("Principal.informacionIps.getTiposolicitudcdp() -> " + Principal.informacionIps.getTiposolicitudcdp());
        if (Principal.informacionIps.getTiposolicitudcdp() == 0) {
            if (!this.JTFNo.getText().isEmpty()) {
                sql = "SELECT `cc_r_requisicion`.`Id` AS IdSol  ,cc_r_requisicion.NConsecutivo, `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre` AS UnidadF, `cc_r_requisicion`.`VPresupuestado` \n , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) NUsuario , cc_r_requisicion.`ObservacionG`,if(pp_movimiento.`IdSolicitud` is null,'',pp_movimiento.`Id`) AS IdRubro \nFROM `cc_r_requisicion` INNER JOIN  `cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `rh_tipo_persona_cargon`.`Id_Persona`)\nLEFT JOIN `pp_movimiento` ON (`cc_r_requisicion`.`Id`=pp_movimiento.`IdSolicitud`)WHERE ( date_format(`cc_r_requisicion`.`FechaR`,'%Y')='" + this.JDAno.getValue() + "' AND `cc_r_requisicion`.`Estado` =1 AND `cc_r_requisicion`.`Id` = '" + this.JTFNo.getText() + "')  ORDER BY   `cc_r_requisicion`.`Id` DESC,`cc_r_requisicion`.`FechaR` DESC;";
            } else if (this.JRBSin.isSelected()) {
                sql = "SELECT `cc_r_requisicion`.`Id` AS IdSol  ,cc_r_requisicion.NConsecutivo, `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre` AS UnidadF, `cc_r_requisicion`.`VPresupuestado` \n , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) NUsuario , cc_r_requisicion.`ObservacionG`,if(pp_movimiento.`IdSolicitud` is null,'',pp_movimiento.`Id`) AS IdRubro \nFROM `cc_r_requisicion` INNER JOIN  `cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `rh_tipo_persona_cargon`.`Id_Persona`)\nLEFT JOIN `pp_movimiento` ON (`cc_r_requisicion`.`Id`=pp_movimiento.`IdSolicitud`)WHERE (date_format(`cc_r_requisicion`.`FechaR`,'%Y')='" + this.JDAno.getValue() + "' AND `cc_r_requisicion`.`Estado` =1 AND IF(pp_movimiento.`IdSolicitud` IS NULL,'',pp_movimiento.`Id`)='')  ORDER BY  `cc_r_requisicion`.`Id` DESC,`cc_r_requisicion`.`FechaR` DESC;";
            } else if (this.JRBCon.isSelected()) {
                sql = "SELECT `cc_r_requisicion`.`Id` AS IdSol  ,cc_r_requisicion.NConsecutivo, `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre` AS UnidadF, `cc_r_requisicion`.`VPresupuestado` \n , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) NUsuario , cc_r_requisicion.`ObservacionG`,if(pp_movimiento.`IdSolicitud` is null,'',pp_movimiento.`Id`) AS IdRubro \nFROM `cc_r_requisicion` INNER JOIN  `cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `rh_tipo_persona_cargon`.`Id_Persona`)\nLEFT JOIN `pp_movimiento` ON (`cc_r_requisicion`.`Id`=pp_movimiento.`IdSolicitud`)WHERE (date_format(`cc_r_requisicion`.`FechaR`,'%Y')='" + this.JDAno.getValue() + "' AND `cc_r_requisicion`.`Estado` =1 AND IF(pp_movimiento.`IdSolicitud` IS NULL,'',pp_movimiento.`Id`)<>'')  ORDER BY   `cc_r_requisicion`.`Id` DESC,`cc_r_requisicion`.`FechaR` DESC;";
            } else if (this.JRBTodo.isSelected()) {
                sql = "SELECT `cc_r_requisicion`.`Id` AS IdSol  ,cc_r_requisicion.NConsecutivo, `cc_r_requisicion`.`FechaR` , `cc_unidad_funcional`.`Nbre` AS UnidadF, `cc_r_requisicion`.`VPresupuestado` \n , CONCAT(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) NUsuario , cc_r_requisicion.`ObservacionG`,if(pp_movimiento.`IdSolicitud` is null,'',pp_movimiento.`Id`) AS IdRubro \nFROM `cc_r_requisicion` INNER JOIN  `cc_unidad_funcional`   ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon`  ON (`cc_r_requisicion`.`Id_Persona_cargo` = `rh_tipo_persona_cargon`.`Id`) \nINNER JOIN  `g_persona`  ON (`g_persona`.`Id` = `rh_tipo_persona_cargon`.`Id_Persona`)\nLEFT JOIN `pp_movimiento` ON (`cc_r_requisicion`.`Id`=pp_movimiento.`IdSolicitud`)WHERE ( date_format(`cc_r_requisicion`.`FechaR`,'%Y')='" + this.JDAno.getValue() + "' AND `cc_r_requisicion`.`Estado` =1)  ORDER BY   `cc_r_requisicion`.`Id` DESC,`cc_r_requisicion`.`FechaR` DESC;";
            }
        } else if (!this.JTFNo.getText().isEmpty()) {
            sql = "SELECT sp.`Id` AS IdSol,\nsp.NConsecutivo, \nsp.`FechaR` , \nuf.`Nbre` AS UnidadF, \nsp.Valor as VPresupuestado\n, concat(pe.Nombre1, ' ',pe.Nombre2,' ',pe.Apellido1,' ',pe.Apellido2) NUsuario , \nsp.Descripcion as ObservacionG,\nif(mo.`IdSolicitud` is null,'',mo.`Id`) AS IdRubro \nFROM pp_solicitud_pto sp \nINNER JOIN  `cc_unidad_funcional` uf  ON (sp.idunidadfuncional = uf.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon` pc ON (sp.IdUsuarioCargon = pc.`Id`) \nINNER JOIN  g_persona pe  ON (pe.Id = pc.Id_Persona)\nLEFT JOIN `pp_movimiento` mo ON (sp.`Id`=mo.`IdSolicitud`)\n-- WHERE ( date_format(sp.`FechaR`,'%Y')=2019 AND sp.`Estado` =1)  \n-- ORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;\nWHERE ( date_format(sp.`FechaR`,'%Y')=" + this.JDAno.getValue() + " AND sp.`Estado` =1 AND sp.`Id` = '" + this.JTFNo.getText() + "')  \nORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;";
        } else if (this.JRBSin.isSelected()) {
            sql = "SELECT sp.`Id` AS IdSol,\nsp.NConsecutivo, \nsp.`FechaR` , \nuf.`Nbre` AS UnidadF, \nsp.Valor as VPresupuestado\n, concat(pe.Nombre1, ' ',pe.Nombre2,' ',pe.Apellido1,' ',pe.Apellido2) NUsuario , \nsp.Descripcion as ObservacionG,\nif(mo.`IdSolicitud` is null,'',mo.`Id`) AS IdRubro \nFROM pp_solicitud_pto sp \nINNER JOIN  `cc_unidad_funcional` uf  ON (sp.idunidadfuncional = uf.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon` pc ON (sp.IdUsuarioCargon = pc.`Id`) \nINNER JOIN  g_persona pe  ON (pe.Id = pc.Id_Persona)\nLEFT JOIN `pp_movimiento` mo ON (sp.`Id`=mo.`IdSolicitud`)\n-- WHERE ( date_format(sp.`FechaR`,'%Y')=2019 AND sp.`Estado` =1)  \n-- ORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;\nWHERE (date_format(sp.`FechaR`,'%Y')=" + this.JDAno.getValue() + " AND sp.`Estado` =1 AND IF(mo.`IdSolicitud` IS NULL,'',mo.`Id`)='')  \nORDER BY  sp.`Id` DESC,sp.`FechaR` DESC;";
        } else if (this.JRBCon.isSelected()) {
            sql = "SELECT sp.`Id` AS IdSol,\nsp.NConsecutivo, \nsp.`FechaR` , \nuf.`Nbre` AS UnidadF, \nsp.Valor as VPresupuestado\n, concat(pe.Nombre1, ' ',pe.Nombre2,' ',pe.Apellido1,' ',pe.Apellido2) NUsuario , \nsp.Descripcion as ObservacionG,\nif(mo.`IdSolicitud` is null,'',mo.`Id`) AS IdRubro \nFROM pp_solicitud_pto sp \nINNER JOIN  `cc_unidad_funcional` uf  ON (sp.idunidadfuncional = uf.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon` pc ON (sp.IdUsuarioCargon = pc.`Id`) \nINNER JOIN  g_persona pe  ON (pe.Id = pc.Id_Persona)\nLEFT JOIN `pp_movimiento` mo ON (sp.`Id`=mo.`IdSolicitud`)\n-- WHERE ( date_format(sp.`FechaR`,'%Y')=2019 AND sp.`Estado` =1)  \n-- ORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;\nWHERE (date_format(sp.`FechaR`,'%Y')=" + this.JDAno.getValue() + " AND sp.`Estado` =1 AND IF(mo.`IdSolicitud` IS NULL,'',mo.`Id`)<>'')  \nORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;";
        } else if (this.JRBTodo.isSelected()) {
            sql = "SELECT sp.`Id` AS IdSol,\nsp.NConsecutivo, \nsp.`FechaR` , \nuf.`Nbre` AS UnidadF, \nsp.Valor as VPresupuestado\n, concat(pe.Nombre1, ' ',pe.Nombre2,' ',pe.Apellido1,' ',pe.Apellido2) NUsuario , \nsp.Descripcion as ObservacionG,\nif(mo.`IdSolicitud` is null,'',mo.`Id`) AS IdRubro \nFROM pp_solicitud_pto sp \nINNER JOIN  `cc_unidad_funcional` uf  ON (sp.idunidadfuncional = uf.`Id`) \nINNER JOIN  `rh_tipo_persona_cargon` pc ON (sp.IdUsuarioCargon = pc.`Id`) \nINNER JOIN  g_persona pe  ON (pe.Id = pc.Id_Persona)\nLEFT JOIN `pp_movimiento` mo ON (sp.`Id`=mo.`IdSolicitud`)\n-- WHERE ( date_format(sp.`FechaR`,'%Y')=2019 AND sp.`Estado` =1)  \n-- ORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;\nWHERE ( date_format(sp.`FechaR`,'%Y')=" + this.JDAno.getValue() + " AND sp.`Estado` =1)  \nORDER BY   sp.`Id` DESC,sp.`FechaR` DESC;";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        mCrearModeloDatosSol();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        System.out.println("Solicitudes-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("IdSol"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("NConsecutivo"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("FechaR"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("ObservacionG"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("NUsuario"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("UnidadF"), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("IdRubro"), n, 6);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("VPresupuestado")), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDisponibilidadDetalle() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "TipoDocumento", "Observacion", "ValorDispo.", "ValorCompr.", "PorEjecutar", "Estado", "IdDisponibilidad"}) { // from class: Presupuesto.JDBusquedaDocPTO.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(180);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(220);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(110);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
    }

    private void mBuscaDisponibilidadDetalle() {
        String sql = null;
        if (!this.JTFNo.getText().isEmpty()) {
            sql = "SELECT D.NoConcecutivo,\n                    D.FechaD\n                    ,D.TipoDoc\n                    ,D.Observacion\n                    ,D.Disponibilidad\n                    ,IFNULL(C.Compromiso,0) Compromiso\n                    ,(D.Disponibilidad-IFNULL(C.Compromiso,0)) Por_Ejecutar\n                    ,Estado\n                    ,D.IdDisponibilidad\n                    \n                     FROM \n                    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDoc \n                           , pp_movimiento.Observacion \n                           , g_motivoanulacion.Nbre AS Estado \n                           ,SUM(pp_detalle_movimiento.Valor) DISPONIBILIDAD\n                           ,pp_movimiento.IdDisponibilidad\n                           -- , pp_detalle_movimiento.`Id_Rubro`\n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 \n                         GROUP BY pp_movimiento.IdDisponibilidad -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.IdDisponibilidad -- , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                             GROUP BY   pp_movimiento.IdDisponibilidad\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad\n                         WHERE(D.NoConcecutivo = '" + this.JTFNo.getText() + "')\n                         ORDER BY D.IdDisponibilidad DESC, D.FechaD DESC";
        } else if (this.JRBSin.isSelected()) {
            sql = "SELECT D.NoConcecutivo,\n                    D.FechaD\n                    ,D.TipoDoc\n                    ,D.Observacion\n                    ,D.Disponibilidad\n                    ,IFNULL(C.Compromiso,0) Compromiso\n                    ,(D.Disponibilidad-IFNULL(C.Compromiso,0)) Por_Ejecutar\n                    ,Estado\n                    ,D.IdDisponibilidad\n                    \n                     FROM \n                    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDoc \n                           , pp_movimiento.Observacion \n                           , g_motivoanulacion.Nbre AS Estado \n                           ,SUM(pp_detalle_movimiento.Valor) DISPONIBILIDAD\n                           ,pp_movimiento.IdDisponibilidad\n                           -- , pp_detalle_movimiento.`Id_Rubro`\n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                         GROUP BY pp_movimiento.IdDisponibilidad -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.IdDisponibilidad -- , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                             GROUP BY   pp_movimiento.IdDisponibilidad\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad\n                         WHERE((D.Disponibilidad-IFNULL(C.Compromiso,0))<>0)\n                         -- group by  D.IdDisponibilidad \n                         ORDER BY D.IdDisponibilidad DESC, D.FechaD DESC";
        } else if (this.JRBCon.isSelected()) {
            sql = "SELECT D.NoConcecutivo,\n                    D.FechaD\n                    ,D.TipoDoc\n                    ,D.Observacion\n                    ,D.Disponibilidad\n                    ,IFNULL(C.Compromiso,0) Compromiso\n                    ,(D.Disponibilidad-IFNULL(C.Compromiso,0)) Por_Ejecutar\n                    ,Estado\n                    ,D.IdDisponibilidad\n                    \n                     FROM \n                    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDoc \n                           , pp_movimiento.Observacion \n                           , g_motivoanulacion.Nbre AS Estado \n                           ,SUM(pp_detalle_movimiento.Valor) DISPONIBILIDAD\n                           ,pp_movimiento.IdDisponibilidad\n                           -- , pp_detalle_movimiento.`Id_Rubro`\n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 \n                         GROUP BY pp_movimiento.IdDisponibilidad -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.IdDisponibilidad -- , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                             GROUP BY   pp_movimiento.IdDisponibilidad\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad\n                         WHERE((D.Disponibilidad-IFNULL(C.Compromiso,0))=0)\n                         -- group by  D.IdDisponibilidad \n                         ORDER BY D.IdDisponibilidad DESC, D.FechaD DESC";
        } else if (this.JRBTodo.isSelected()) {
            sql = "SELECT D.NoConcecutivo,\n                    D.FechaD\n                    ,D.TipoDoc\n                    ,D.Observacion\n                    ,D.Disponibilidad\n                    ,IFNULL(C.Compromiso,0) Compromiso\n                    ,(D.Disponibilidad-IFNULL(C.Compromiso,0)) Por_Ejecutar\n                    ,Estado\n                    ,D.IdDisponibilidad\n                    \n                     FROM \n                    (SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n                      , pp_tipo_documentos.Nbre AS TipoDoc \n                           , pp_movimiento.Observacion \n                           , g_motivoanulacion.Nbre AS Estado \n                           ,SUM(pp_detalle_movimiento.Valor) DISPONIBILIDAD\n                           ,pp_movimiento.IdDisponibilidad\n                           -- , pp_detalle_movimiento.`Id_Rubro`\n                          FROM pp_movimiento  \n                                    INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                                    INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                                    INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                                    WHERE pp_tipo_documentos.Id_ClaseDoc IN (9,10) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                         GROUP BY pp_movimiento.IdDisponibilidad -- , pp_tipo_documentos.Id_ClaseDoc\n                          ORDER BY pp_movimiento.FechaD DESC) D\n                          LEFT JOIN \n                         (SELECT  pp_movimiento.IdDisponibilidad -- , pp_detalle_movimiento.`Id_Rubro`\n                       ,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n                            FROM pp_movimiento  \n                            INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                            INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                            INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                            WHERE pp_tipo_documentos.Id_ClaseDoc IN (4) AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \n                             GROUP BY   pp_movimiento.IdDisponibilidad\n                          ) C\n                         ON D.IdDisponibilidad=C.IdDisponibilidad\n                         ORDER BY D.IdDisponibilidad DESC, D.FechaD DESC";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        mCrearModeloDatosDisponibilidadDetalle();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        System.out.println("Disponibilidades-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("FechaD"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("TipoDoc"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("Observacion"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Disponibilidad"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("Compromiso"), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("Por_Ejecutar"), n, 6);
                    this.xmodelo.setValueAt(xrs.getString("Estado"), n, 7);
                    this.xmodelo.setValueAt(xrs.getString("IdDisponibilidad"), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosDisponibilidad() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "Fecha", "TipoDocumento", "Observacion", "Estado", "IdCompromiso", "IdDisp", "Valor"}) { // from class: Presupuesto.JDBusquedaDocPTO.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(220);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(110);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
    }

    private void mBuscaDisponibilidad() {
        String sql = null;
        if (!this.JTFNo.getText().isEmpty()) {
            sql = "SELECT `pp_movimiento`.`Id` AS IdDispo \n, `pp_movimiento`.`FechaD` \n, `pp_tipo_documentos`.`Nbre` AS TipoDoc \n, `pp_movimiento`.`Observacion` \n, `g_motivoanulacion`.`Nbre` AS Estado \n, IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`) AS IdCompromiso, pp_movimiento.NoConcecutivo \n, SUM(pp_detalle_movimiento.`Valor`) AS TotalDispo\nFROM `pp_movimiento`  \nINNER JOIN  `g_motivoanulacion` ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`) \nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN  `pp_detalle_movimiento` ON (pp_movimiento.`Id` = pp_detalle_movimiento.`Id_Movimiento`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc`=9 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `pp_movimiento`.`NoConcecutivo`= '" + this.JTFNo.getText() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 ) \nGROUP BY pp_movimiento.`Id`\nORDER BY  `pp_movimiento`.`Id` DESC,`pp_movimiento`.`FechaD` DESC ";
        } else if (this.JRBSin.isSelected()) {
            sql = "SELECT `pp_movimiento`.`Id` AS IdDispo \n, `pp_movimiento`.`FechaD` \n, `pp_tipo_documentos`.`Nbre` AS TipoDoc \n, `pp_movimiento`.`Observacion` \n, `g_motivoanulacion`.`Nbre` AS Estado \n, IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`) AS IdCompromiso, pp_movimiento.NoConcecutivo \n, SUM(pp_detalle_movimiento.`Valor`) AS TotalDispo\nFROM `pp_movimiento`  \nINNER JOIN  `g_motivoanulacion` ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`) \nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN  `pp_detalle_movimiento` ON (pp_movimiento.`Id` = pp_detalle_movimiento.`Id_Movimiento`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc`=9 AND IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`)='' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 ) \nGROUP BY pp_movimiento.`Id`\nORDER BY  `pp_movimiento`.`Id` DESC,`pp_movimiento`.`FechaD` DESC ";
        } else if (this.JRBCon.isSelected()) {
            sql = "SELECT `pp_movimiento`.`Id` AS IdDispo \n, `pp_movimiento`.`FechaD` \n, `pp_tipo_documentos`.`Nbre` AS TipoDoc \n, `pp_movimiento`.`Observacion` \n, `g_motivoanulacion`.`Nbre` AS Estado \n, IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`) AS IdCompromiso, pp_movimiento.NoConcecutivo \n, SUM(pp_detalle_movimiento.`Valor`) AS TotalDispo\nFROM `pp_movimiento`  \nINNER JOIN  `g_motivoanulacion` ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`) \nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN  `pp_detalle_movimiento` ON (pp_movimiento.`Id` = pp_detalle_movimiento.`Id_Movimiento`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc`=9 AND IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`)<>'' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 ) \nGROUP BY pp_movimiento.`Id`\nORDER BY `pp_movimiento`.`Id` DESC,`pp_movimiento`.`FechaD` DESC";
        } else if (this.JRBTodo.isSelected()) {
            sql = "SELECT `pp_movimiento`.`Id` AS IdDispo \n, `pp_movimiento`.`FechaD` \n, `pp_tipo_documentos`.`Nbre` AS TipoDoc \n, `pp_movimiento`.`Observacion` \n, `g_motivoanulacion`.`Nbre` AS Estado \n, IF(`pp_movimiento`.`IdCompromiso`=0,'',`pp_movimiento`.`IdCompromiso`) AS IdCompromiso, pp_movimiento.NoConcecutivo \n, SUM(pp_detalle_movimiento.`Valor`) AS TotalDispo\nFROM `pp_movimiento`  \nINNER JOIN  `g_motivoanulacion` ON (`pp_movimiento`.`Id_MotivoAnulacion` = `g_motivoanulacion`.`Id`) \nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nINNER JOIN  `pp_detalle_movimiento` ON (pp_movimiento.`Id` = pp_detalle_movimiento.`Id_Movimiento`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc`=9 AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND DATE_FORMAT(`pp_movimiento`.`FechaD`,'%Y')='" + this.JDAno.getValue() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 ) \nGROUP BY pp_movimiento.`Id`\nORDER BY  `pp_movimiento`.`Id` DESC,`pp_movimiento`.`FechaD` DESC ";
        }
        ResultSet xrs = this.xct.traerRs(sql);
        mCrearModeloDatosDisponibilidad();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        System.out.println("Disponibilidades-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("FechaD"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("TipoDoc"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("Observacion"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Estado"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("IdCompromiso"), n, 5);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo.setValueAt(xrs.getString("IdDispo"), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("TotalDispo")), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JRBTodo = new JRadioButton();
        this.JRBSin = new JRadioButton();
        this.JRBCon = new JRadioButton();
        this.JDAno = new JYearChooser();
        this.JLMaestro = new JLabel();
        this.JLAutorizar = new JLabel();
        this.JTFNo = new JTextField();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane2.setAutoscrolls(true);
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDBusquedaDocPTO.4
            public void mouseClicked(MouseEvent evt) {
                JDBusquedaDocPTO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.buttonGroup1.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaDocPTO.5
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaDocPTO.this.JRBTodoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSin);
        this.JRBSin.setFont(new Font("Arial", 1, 12));
        this.JRBSin.setSelected(true);
        this.JRBSin.setText("Genrico1");
        this.JRBSin.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaDocPTO.6
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaDocPTO.this.JRBSinActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBCon);
        this.JRBCon.setFont(new Font("Arial", 1, 12));
        this.JRBCon.setText("Genrico1");
        this.JRBCon.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaDocPTO.7
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaDocPTO.this.JRBConActionPerformed(evt);
            }
        });
        this.JDAno.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDBusquedaDocPTO.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDBusquedaDocPTO.this.JDAnoPropertyChange(evt);
            }
        });
        this.JLMaestro.setFont(new Font("Arial", 1, 12));
        this.JLMaestro.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Maestro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLAutorizar.setBackground(Color.red);
        this.JLAutorizar.setFont(new Font("Arial", 1, 12));
        this.JLAutorizar.setForeground(Color.white);
        this.JLAutorizar.setText("Sin Autorizar");
        this.JLAutorizar.setOpaque(true);
        this.JTFNo.setFont(new Font("Arial", 1, 12));
        this.JTFNo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNo.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JDBusquedaDocPTO.9
            public void focusLost(FocusEvent evt) {
                JDBusquedaDocPTO.this.JTFNoFocusLost(evt);
            }
        });
        this.JTFNo.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDBusquedaDocPTO.10
            public void keyTyped(KeyEvent evt) {
                JDBusquedaDocPTO.this.JTFNoKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JDBusquedaDocPTO.this.JTFNoKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSin).addGap(18, 18, 18).addComponent(this.JRBCon).addGap(18, 18, 18).addComponent(this.JRBTodo, -2, 77, -2).addGap(18, 18, 18).addComponent(this.JDAno, -2, 85, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNo, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLMaestro, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLAutorizar, -2, 74, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLMaestro, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(27, 27, 27).addComponent(this.JLAutorizar, -2, 23, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBSin).addComponent(this.JRBCon))).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDAno, -2, 50, -2).addComponent(this.JTFNo, -2, 50, -2))).addGap(0, 0, 32767))).addContainerGap()));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Presupuesto.JDBusquedaDocPTO.11
            public void actionPerformed(ActionEvent evt) {
                JDBusquedaDocPTO.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 911, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JBT_Salir, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 384, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 50, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        System.out.println("tipo documento " + this.xTipoDoc);
        if (this.JTDetalle.getRowCount() > -1 && evt.getClickCount() == 2) {
            if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
                if (this.xTipoDoc.equals("9")) {
                    if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString().equals("")) {
                        this.xJIFFMovimiento.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                        this.xJIFFMovimiento.xIdSolicitud = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                        this.xJIFFMovimiento.JTObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                        this.xJIFFMovimiento.JFTFValorDoc.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
                        this.xJIFFMovimiento.mBuscaRubrosSolicitud(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue());
                        dispose();
                        System.out.println("ffffffff");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Esta Solicitud ya tiene Disponibilidad asociada", "VERIFICAR", 1);
                    return;
                }
                if (this.xTipoDoc.equals("4")) {
                    if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString().equals("0")) {
                        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()) > 0 && Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()) > 0) {
                            this.xJIFFMovimiento.conAdicion = true;
                        }
                        mNoDocument(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                        this.xJIFFMovimiento.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xJIFFMovimiento.xIdMovDisponibilidad = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).intValue();
                        this.xJIFFMovimiento.JTObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                        this.xJIFFMovimiento.mBuscaRubros(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                        this.xJIFFMovimiento.JTFNoFactura.setText(this.xDocumento);
                        this.xJIFFMovimiento.txtFechaFact.setDate(this.xFechaDoc);
                        this.xJIFFMovimiento.JFTFValorDoc.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
                        dispose();
                        System.out.println("Entro en lo del compromiso ");
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Esta Disponibilidad ya tiene Compromiso asociado", "VERIFICAR", 1);
                    return;
                }
                return;
            }
            if (this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudContrato")) {
                if (this.xTipoDoc.equals("9")) {
                    this.xJIFSolicitudContrato.JLCodigoDoc1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xJIFSolicitudContrato.JFTFValorDoc1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
                    dispose();
                    return;
                } else {
                    if (this.xTipoDoc.equals("4")) {
                        if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("")) {
                            mNoDocument(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
                            this.xJIFSolicitudContrato.JLCodigoDoc1.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            this.xJIFSolicitudContrato.JFTFValorDoc1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()));
                            dispose();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Esta Disponibilidad ya tiene Compromiso asociado", "VERIFICAR", 1);
                        return;
                    }
                    return;
                }
            }
            if (this.xLlamador.getClass().getSimpleName().equals("JIFOrdenCompra")) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("")) {
                    this.xJIFOrdenCompra.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xJIFOrdenCompra.xIdMovDisponibilidad = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).intValue();
                    dispose();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Esta Disponibilidad ya tiene Compromiso asociado", "VERIFICAR", 1);
                return;
            }
            if (this.xLlamador.getClass().getSimpleName().equals("JIFOrdenServicio")) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().equals("")) {
                    this.xJIFOrdenServicio.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.xJIFOrdenServicio.xIdMovDisponibilidad = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).intValue();
                    dispose();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Esta Disponibilidad ya tiene Compromiso asociado", "VERIFICAR", 1);
                return;
            }
            if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovManualOP_PP")) {
                if (this.xTipoDoc.equals("5")) {
                    if (this.JRBSin.isSelected()) {
                        this.xJIFFMovManualOP_PP.setxIdCompromiso(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                        this.xJIFFMovManualOP_PP.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xJIFFMovManualOP_PP.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                        this.xJIFFMovManualOP_PP.mBuscaDetalleRubrosMovimiento();
                    } else {
                        JOptionPane.showMessageDialog(this, "Solo puede cargar rubros sin Obligación", "VERIFICAR", 1);
                    }
                } else if (this.xTipoDoc.equals("6")) {
                    if (this.JRBSin.isSelected()) {
                        this.xJIFFMovManualOP_PP.setxIdCompromiso(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                        this.xJIFFMovManualOP_PP.xIdCompromisoObli = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12).toString();
                        this.xJIFFMovManualOP_PP.JLCodigoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.xJIFFMovManualOP_PP.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                        this.xJIFFMovManualOP_PP.mBuscaDetalleRubrosMovimiento();
                    } else {
                        JOptionPane.showMessageDialog(this, "Solo puede cargar rubros sin Pagos", "VERIFICAR", 1);
                    }
                }
                dispose();
                return;
            }
            if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
                if (this.modeloCompromiso.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString().equals("0")) {
                    List<String> compromiso = new ArrayList<>();
                    for (int i = 0; i < this.modeloCompromiso.getColumnCount(); i++) {
                        System.out.println("modeloCompromiso.getValueAt(JTDetalle.getSelectedRow(), i).toString() -> " + this.modeloCompromiso.getValueAt(this.JTDetalle.getSelectedRow(), i).toString());
                        compromiso.add(this.modeloCompromiso.getValueAt(this.JTDetalle.getSelectedRow(), i).toString());
                    }
                    this.jifcompromisopresupuestal.cargarCompromisoNuevo(compromiso);
                    dispose();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Esta Disponibilidad ya tiene Compromiso asociado", "VERIFICAR", 1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinActionPerformed(ActionEvent evt) {
        mBusquedasMovimientos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConActionPerformed(ActionEvent evt) {
        mBusquedasMovimientos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
        mBusquedasMovimientos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDAnoPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mBuscaEmcabezado_x_Anio();
            mBusquedasMovimientos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            mBusquedasMovimientos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mBusquedasMovimientos() {
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
            if (this.xTipoDoc.equals("9")) {
                mBuscaSolicitudes();
                return;
            } else {
                if (this.xTipoDoc.equals("4")) {
                    mBuscaDisponibilidadDetalle();
                    return;
                }
                return;
            }
        }
        if (this.xLlamador.getClass().getSimpleName().equals("JIFOrdenCompra") || this.xLlamador.getClass().getSimpleName().equals("JIFOrdenServicio") || this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudContrato")) {
            System.out.println("Estoy en Pantalla-->" + this.xLlamador.getClass().getSimpleName());
            mBuscaDisponibilidad();
            return;
        }
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovManualOP_PP")) {
            if (this.xTipoDoc.equals("5")) {
                mBuscaDatosCompromisoManual();
                return;
            } else {
                if (this.xTipoDoc.equals("6")) {
                    mBuscaDatosObligacionManual();
                    return;
                }
                return;
            }
        }
        if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            cargarDatosDisponibilidadNueva();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDBusquedaDocPTO$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String xvalor = table.getValueAt(row, 6).toString();
            if (!xvalor.equals("")) {
                cell.setBackground(new Color(51, 153, 255));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mNoDocument(String xDispo) {
        String sql = "SELECT `Id` , `FechaC` FROM `cc_orden_compra` WHERE (`IdDisponibilidad` = '" + xDispo + "' AND `Estado` =1);";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xDocumento = xrs.getString(1);
                this.xFechaDoc = xrs.getDate(2);
            } else {
                this.xDocumento = "";
                this.xFechaDoc = this.xmt.getFechaActual();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCompromisoManual() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "IdCompromiso", "Fecha", "TipoDoc", "Observacion", "IdTercero", "IdRubro", "NombreRubro", "Compromiso", "Obligacion", "Por_Obligar", "Estado", "IdDisponibilidad"}) { // from class: Presupuesto.JDBusquedaDocPTO.12
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
    }

    private void mBuscaDatosCompromisoManual() {
        mCrearModeloDatosCompromisoManual();
        String sql = null;
        if (!this.JTFNo.getText().isEmpty()) {
            sql = "SELECT D.NoConcecutivo\n, D.IdCompromiso\n,D.FechaD\n,D.TipoDoc\n,D.Observacion\n,D.Id_Tercero \n,D.Id_rubro\n,D.NombreRubro\n,D.Compromiso\n,IFNULL(C.Obligacion,0) Obligacion\n,(D.Compromiso-IFNULL(C.Obligacion,0)) Por_Obligacion\n,Estado\n,D.IdDisponibilidad\n\nFROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n, pp_tipo_documentos.Nbre AS TipoDoc \n, IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n, g_motivoanulacion.Nbre AS Estado \n,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n,pp_movimiento.IdDisponibilidad\n,pp_movimiento.IdCompromiso\n,pp_detalle_movimiento.Id_Rubro\n,pp_rubros.`Nbre` AS NombreRubro\n,pp_detalle_movimiento.Id_Tercero\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nINNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \nWHERE pp_tipo_documentos.Id_ClaseDoc IN (4)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1   \nGROUP BY pp_movimiento.IdCompromiso, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\nORDER BY pp_movimiento.FechaD DESC) D\nLEFT JOIN \n(SELECT  pp_movimiento.IdDisponibilidad\n, pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n,SUM(pp_detalle_movimiento.Valor) OBLIGACION\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (5)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \nGROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n) C\nON  D.IdCompromiso=C.IdCompromiso \nAND D.Id_Rubro=C.Id_Rubro \nAND D.Id_Tercero=C.Id_Tercero\nWHERE (D.NoConcecutivo = '" + this.JTFNo.getText() + "')\nORDER BY  D.IdCompromiso DESC, D.FechaD DESC";
        } else if (this.JRBTodo.isSelected()) {
            sql = "SELECT D.NoConcecutivo\n, D.IdCompromiso\n,D.FechaD\n,D.TipoDoc\n,D.Observacion\n,D.Id_Tercero \n,D.Id_rubro\n,D.NombreRubro\n,D.Compromiso\n,IFNULL(C.Obligacion,0) Obligacion\n,(D.Compromiso-IFNULL(C.Obligacion,0)) Por_Obligacion\n,Estado\n,D.IdDisponibilidad\n\nFROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n, pp_tipo_documentos.Nbre AS TipoDoc \n, IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n, g_motivoanulacion.Nbre AS Estado \n,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n,pp_movimiento.IdDisponibilidad\n,pp_movimiento.IdCompromiso\n,pp_detalle_movimiento.Id_Rubro\n,pp_rubros.`Nbre` AS NombreRubro\n,pp_detalle_movimiento.Id_Tercero\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nINNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \nWHERE pp_tipo_documentos.Id_ClaseDoc IN (4)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1   \nGROUP BY pp_movimiento.IdCompromiso, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\nORDER BY pp_movimiento.FechaD DESC) D\nLEFT JOIN \n(SELECT  pp_movimiento.IdDisponibilidad\n, pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n,SUM(pp_detalle_movimiento.Valor) OBLIGACION\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (5)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \nGROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n) C\nON  D.IdCompromiso=C.IdCompromiso \nAND D.Id_Rubro=C.Id_Rubro \nAND D.Id_Tercero=C.Id_Tercero\nORDER BY  D.IdCompromiso DESC, D.FechaD DESC";
        } else if (this.JRBSin.isSelected()) {
            sql = "SELECT D.NoConcecutivo\n, D.IdCompromiso\n,D.FechaD\n,D.TipoDoc\n,D.Observacion\n,D.Id_Tercero \n,D.Id_rubro\n,D.NombreRubro\n,D.Compromiso\n,IFNULL(C.Obligacion,0) Obligacion\n,(D.Compromiso-IFNULL(C.Obligacion,0)) Por_Obligacion\n,Estado\n,D.IdDisponibilidad\n\nFROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n, pp_tipo_documentos.Nbre AS TipoDoc \n, IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n, g_motivoanulacion.Nbre AS Estado \n,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n,pp_movimiento.IdDisponibilidad\n,pp_movimiento.IdCompromiso\n,pp_detalle_movimiento.Id_Rubro\n,pp_rubros.`Nbre` AS NombreRubro\n,pp_detalle_movimiento.Id_Tercero\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nINNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (4)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1 \nGROUP BY pp_movimiento.IdCompromiso, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\nORDER BY pp_movimiento.FechaD DESC) D\nLEFT JOIN \n(SELECT  pp_movimiento.IdDisponibilidad\n, pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n,SUM(pp_detalle_movimiento.Valor) OBLIGACION\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (5)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \nGROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n) C\nON  D.IdCompromiso=C.IdCompromiso \nAND D.Id_Rubro=C.Id_Rubro \nAND D.Id_Tercero=C.Id_Tercero\nWHERE (D.Compromiso-IFNULL(C.Obligacion,0))  > 0\nORDER BY  D.IdCompromiso DESC, D.FechaD DESC";
        } else if (this.JRBCon.isSelected()) {
            sql = "SELECT D.NoConcecutivo\n, D.IdCompromiso\n,D.FechaD\n,D.TipoDoc\n,D.Observacion\n,D.Id_Tercero \n,D.Id_rubro\n,D.NombreRubro\n,D.Compromiso\n,IFNULL(C.Obligacion,0) Obligacion\n,(D.Compromiso-IFNULL(C.Obligacion,0)) Por_Obligacion\n,Estado\n,D.IdDisponibilidad\n\nFROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n, pp_tipo_documentos.Nbre AS TipoDoc \n, IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n, g_motivoanulacion.Nbre AS Estado \n,SUM(pp_detalle_movimiento.Valor) COMPROMISO\n,pp_movimiento.IdDisponibilidad\n,pp_movimiento.IdCompromiso\n,pp_detalle_movimiento.Id_Rubro\n,pp_rubros.`Nbre` AS NombreRubro\n,pp_detalle_movimiento.Id_Tercero\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nINNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \nWHERE pp_tipo_documentos.Id_ClaseDoc IN (4)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \nGROUP BY pp_movimiento.IdCompromiso, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\nORDER BY pp_movimiento.FechaD DESC) D\nLEFT JOIN \n(SELECT  pp_movimiento.IdDisponibilidad\n, pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n,SUM(pp_detalle_movimiento.Valor) OBLIGACION\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (5)  AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND `Id_MotivoAnulacion`= 1 AND `pp_detalle_movimiento`.`Estado`= 1  \nGROUP BY pp_movimiento.IdDisponibilidad  , pp_movimiento.IdCompromiso\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n) C\nON D.IdCompromiso=C.IdCompromiso \nAND D.Id_Rubro=C.Id_Rubro \nAND D.Id_Tercero=C.Id_Tercero\nWHERE IFNULL(C.Obligacion,0)  > 0 \nORDER BY  D.IdCompromiso DESC, D.FechaD DESC";
        }
        System.out.println("Compromisos Radicacion Tercero-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("IdCompromiso"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("TipoDoc"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id_Tercero"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("Id_rubro"), n, 6);
                    this.xmodelo.setValueAt(xrsB.getString("NombreRubro"), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Compromiso")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Obligacion")), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Por_Obligacion")), n, 10);
                    this.xmodelo.setValueAt(xrsB.getString("Estado"), n, 11);
                    this.xmodelo.setValueAt(xrsB.getString("IdDisponibilidad"), n, 12);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosObligacionManual() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.", "IdObligacion", "Fecha", "TipoDoc", "Observacion", "IdTercero", "IdRubro", "NombreRubro", "Obligación", "Pagado", "Por_Pagar", "Estado", "IdCompromiso"}) { // from class: Presupuesto.JDBusquedaDocPTO.13
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
    }

    private void mBuscaDatosObligacionManual() {
        mCrearModeloDatosObligacionManual();
        String sql = null;
        String pago = "";
        if (Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR")) {
            if (this.JRBSin.isSelected()) {
                pago = " AND (OP.Obligacion-IFNULL(PP.Pago,0))  > 0 ";
            } else if (this.JRBCon.isSelected()) {
                pago = " AND IFNULL(PP.Pago,0)  > 0 ";
            }
        }
        if (!this.JTFNo.getText().isEmpty()) {
            sql = "SELECT OP.NoConcecutivo\n, OP.IdCompromiso\n,OP.IdObligacion\n,OP.FechaD\n,OP.TipoDoc\n,OP.Observacion\n,OP.Id_Tercero\n,OP.NTercero \n,OP.Id_rubro\n,OP.NombreRubro\n,OP.Obligacion\n,IFNULL(PP.Pago,0) Pagado\n,(OP.Obligacion-IFNULL(PP.Pago,0)) Por_Pagar\n,Estado\n\n FROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n       , pp_tipo_documentos.Nbre AS TipoDoc \n       , IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n       , g_motivoanulacion.Nbre AS Estado \n       ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n       ,pp_movimiento.IdCompromiso\n       , pp_movimiento.`IdObligacion`\n       ,pp_detalle_movimiento.Id_Rubro\n       ,pp_rubros.`Nbre` AS NombreRubro\n       ,pp_detalle_movimiento.Id_Tercero\n       , IF(cc_terceros.`Id_TipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n      FROM pp_movimiento  \n                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \n                INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n                WHERE pp_tipo_documentos.Id_ClaseDoc IN (5)\n      GROUP BY pp_movimiento.IdCompromiso,pp_movimiento.idObligacion, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n      ORDER BY pp_movimiento.FechaD DESC) OP\n      LEFT JOIN \n     (SELECT pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n      , pp_detalle_movimiento.Id_Rubro\n      , pp_detalle_movimiento.Id_Tercero\n   ,SUM(pp_detalle_movimiento.Valor) PAGO\n        FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n        WHERE pp_tipo_documentos.Id_ClaseDoc IN (6) \n        GROUP BY pp_movimiento.IdCompromiso, pp_movimiento.`IdObligacion`\n  , pp_detalle_movimiento.Id_Rubro\n  , pp_detalle_movimiento.Id_Tercero\n      ) PP\n     ON OP.IdObligacion=PP.IdObligacion \n     AND OP.Id_Rubro=PP.Id_Rubro \n     AND OP.Id_Tercero=PP.Id_Tercero\n     WHERE (OP.NoConcecutivo = '" + this.JTFNo.getText() + "')\n     " + pago + " ORDER BY  OP.IdObligacion DESC, OP.FechaD DESC\n -- WHERE (D.Id_Tercero='\\+this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0]+\\')";
        } else if (this.JRBTodo.isSelected()) {
            sql = "SELECT OP.NoConcecutivo\n, OP.IdCompromiso\n,OP.IdObligacion\n,OP.FechaD\n,OP.TipoDoc\n,OP.Observacion\n,OP.Id_Tercero\n,OP.NTercero \n,OP.Id_rubro\n,OP.NombreRubro\n,OP.Obligacion\n,IFNULL(PP.Pago,0) Pagado\n,(OP.Obligacion-IFNULL(PP.Pago,0)) Por_Pagar\n,Estado\n\n FROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n       , pp_tipo_documentos.Nbre AS TipoDoc \n       , IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n       , g_motivoanulacion.Nbre AS Estado \n       ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n       ,pp_movimiento.IdCompromiso\n       , pp_movimiento.`IdObligacion`\n       ,pp_detalle_movimiento.Id_Rubro\n       ,pp_rubros.`Nbre` AS NombreRubro\n       ,pp_detalle_movimiento.Id_Tercero\n       , IF(cc_terceros.`Id_TipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n      FROM pp_movimiento  \n                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \n                INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n                WHERE pp_tipo_documentos.Id_ClaseDoc IN (5)\n      GROUP BY pp_movimiento.IdCompromiso,pp_movimiento.idObligacion, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n      ORDER BY pp_movimiento.FechaD DESC) OP\n      LEFT JOIN \n     (SELECT pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n      , pp_detalle_movimiento.Id_Rubro\n      , pp_detalle_movimiento.Id_Tercero\n   ,SUM(pp_detalle_movimiento.Valor) PAGO\n        FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n        WHERE pp_tipo_documentos.Id_ClaseDoc IN (6) \n        GROUP BY pp_movimiento.IdCompromiso, pp_movimiento.`IdObligacion`\n  , pp_detalle_movimiento.Id_Rubro\n  , pp_detalle_movimiento.Id_Tercero\n      ) PP\n     ON OP.IdObligacion=PP.IdObligacion \n     AND OP.Id_Rubro=PP.Id_Rubro \n     AND OP.Id_Tercero=PP.Id_Tercero\n     -- where IFNULL(C.Obligacion,0)  > 0\n     ORDER BY  OP.IdObligacion DESC, OP.FechaD DESC\n -- WHERE (D.Id_Tercero='\\+this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0]+\\')";
        } else if (this.JRBSin.isSelected()) {
            sql = "SELECT OP.NoConcecutivo\n, OP.IdCompromiso\n,OP.IdObligacion\n,OP.FechaD\n,OP.TipoDoc\n,OP.Observacion\n,OP.Id_Tercero\n,OP.NTercero \n,OP.Id_rubro\n,OP.NombreRubro\n,OP.Obligacion\n,IFNULL(PP.Pago,0) Pagado\n,(OP.Obligacion-IFNULL(PP.Pago,0)) Por_Pagar\n,Estado\n\n FROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n       , pp_tipo_documentos.Nbre AS TipoDoc \n       , IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n       , g_motivoanulacion.Nbre AS Estado \n       ,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n       ,pp_movimiento.IdCompromiso\n       , pp_movimiento.`IdObligacion`\n       ,pp_detalle_movimiento.Id_Rubro\n       ,pp_rubros.`Nbre` AS NombreRubro\n       ,pp_detalle_movimiento.Id_Tercero\n       , IF(cc_terceros.`Id_TipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n      FROM pp_movimiento  \n                INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n                INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n                INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n                INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \n                INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n                WHERE pp_tipo_documentos.Id_ClaseDoc IN (5)\n      GROUP BY pp_movimiento.IdCompromiso,pp_movimiento.idObligacion, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n      ORDER BY pp_movimiento.FechaD DESC) OP\n      LEFT JOIN \n     (SELECT pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n      , pp_detalle_movimiento.Id_Rubro\n      , pp_detalle_movimiento.Id_Tercero\n   ,SUM(pp_detalle_movimiento.Valor) PAGO\n        FROM pp_movimiento  \n        INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n        INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n        INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n        WHERE pp_tipo_documentos.Id_ClaseDoc IN (6) \n        GROUP BY pp_movimiento.IdCompromiso, pp_movimiento.`IdObligacion`\n  , pp_detalle_movimiento.Id_Rubro\n  , pp_detalle_movimiento.Id_Tercero\n      ) PP\n     ON OP.IdObligacion=PP.IdObligacion \n     AND OP.Id_Rubro=PP.Id_Rubro \n     AND OP.Id_Tercero=PP.Id_Tercero\n     WHERE (OP.Obligacion-IFNULL(PP.Pago,0))  > 0\n     ORDER BY  OP.IdObligacion DESC, OP.FechaD DESC\n -- WHERE (D.Id_Tercero='\\+this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0]+\\')";
        } else if (this.JRBCon.isSelected()) {
            sql = "SELECT OP.NoConcecutivo\n, OP.IdCompromiso\n,OP.IdObligacion\n,OP.FechaD\n,OP.TipoDoc\n,OP.Observacion\n,OP.Id_Tercero\n,OP.NTercero \n,OP.Id_rubro\n,OP.NombreRubro\n,OP.Obligacion\n,IFNULL(PP.Pago,0) Pagado\n,(OP.Obligacion-IFNULL(PP.Pago,0)) Por_Pagar\n,Estado\n\nFROM \n(SELECT  pp_movimiento.`NoConcecutivo`, pp_movimiento.FechaD \n, pp_tipo_documentos.Nbre AS TipoDoc \n, IF(pp_movimiento.Observacion IS NULL,'',pp_movimiento.Observacion) AS Observacion \n, g_motivoanulacion.Nbre AS Estado \n,SUM(pp_detalle_movimiento.Valor) OBLIGACION\n,pp_movimiento.IdCompromiso\n, pp_movimiento.`IdObligacion`\n,pp_detalle_movimiento.Id_Rubro\n,pp_rubros.`Nbre` AS NombreRubro\n,pp_detalle_movimiento.Id_Tercero\n, IF(cc_terceros.`Id_tipoIdentificacion`='NI',cc_terceros.`RazonSocialCompleta`,CONCAT(cc_terceros.`Apellido1`,' ',cc_terceros.`Apellido2`,' ',cc_terceros.`Nombre1`,' ',cc_terceros.`Nombre2`)) AS NTercero\n    FROM pp_movimiento  \n  INNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \n  INNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n  INNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\n  INNER JOIN `pp_rubros` ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.`Id`) AND (pp_detalle_movimiento.`idEncabezado`=`pp_rubros`.`idEncabezadoRubro`) \n  INNER JOIN cc_terceros ON (pp_detalle_movimiento.`Id_Tercero`= cc_terceros.`Id`)\n  WHERE pp_tipo_documentos.Id_ClaseDoc IN (5)\n    GROUP BY pp_movimiento.IdCompromiso,pp_movimiento.idObligacion, pp_tipo_documentos.Id_ClaseDoc,pp_detalle_movimiento.Id_Rubro,pp_detalle_movimiento.Id_Tercero\n    ORDER BY pp_movimiento.FechaD DESC) OP\n    LEFT JOIN \n   (SELECT pp_movimiento.IdCompromiso\n   ,pp_movimiento.`IdObligacion`\n    , pp_detalle_movimiento.Id_Rubro\n    , pp_detalle_movimiento.Id_Tercero\n ,SUM(pp_detalle_movimiento.Valor) PAGO\nFROM pp_movimiento  \nINNER JOIN  g_motivoanulacion ON (pp_movimiento.Id_MotivoAnulacion = g_motivoanulacion.Id) \nINNER JOIN  pp_tipo_documentos  ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\nINNER JOIN pp_detalle_movimiento ON (pp_movimiento.Id = pp_detalle_movimiento.Id_Movimiento)\nWHERE pp_tipo_documentos.Id_ClaseDoc IN (6) \nGROUP BY pp_movimiento.IdCompromiso, pp_movimiento.`IdObligacion`\n, pp_detalle_movimiento.Id_Rubro\n, pp_detalle_movimiento.Id_Tercero\n    ) PP\n   ON OP.IdObligacion=PP.IdObligacion \n   AND OP.Id_Rubro=PP.Id_Rubro \n   AND OP.Id_Tercero=PP.Id_Tercero\n   WHERE IFNULL(PP.Pago,0)  > 0\n   ORDER BY  OP.IdObligacion DESC, OP.FechaD DESC\n-- WHERE (D.Id_Tercero='\\+this.xJIFRadicacion.xidempresa[this.xJIFRadicacion.JCBEmpresa.getSelectedIndex()][0]+\\')";
        }
        System.out.println("Obligacion por pagar Tercero-->" + sql);
        ResultSet xrsB = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        int n = 0;
        try {
            if (xrsB.next()) {
                xrsB.beforeFirst();
                while (xrsB.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrsB.getString("NoConcecutivo"), n, 0);
                    this.xmodelo.setValueAt(xrsB.getString("IdObligacion"), n, 1);
                    this.xmodelo.setValueAt(xrsB.getString("FechaD"), n, 2);
                    this.xmodelo.setValueAt(xrsB.getString("TipoDoc"), n, 3);
                    this.xmodelo.setValueAt(xrsB.getString("Observacion"), n, 4);
                    this.xmodelo.setValueAt(xrsB.getString("Id_Tercero"), n, 5);
                    this.xmodelo.setValueAt(xrsB.getString("Id_rubro"), n, 6);
                    this.xmodelo.setValueAt(xrsB.getString("NombreRubro"), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Obligacion")), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Pagado")), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrsB.getDouble("Por_Pagar")), n, 10);
                    this.xmodelo.setValueAt(xrsB.getString("Estado"), n, 11);
                    this.xmodelo.setValueAt(xrsB.getString("IdCompromiso"), n, 12);
                    n++;
                }
            }
            xrsB.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaMovPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDisponibilidadNuevo() {
        this.modeloCompromiso = new DefaultTableModel(new Object[0], new String[]{"Consecutivo", "Tipo de documento", "Codigo de Rubro", "Nombre de Rubro", "Tercero", "Centro de Costo", "Fuente de Financiación", "Codigo de Cpc", "Nombre de Cpc", "Tipo de Vigencia", "idCompromiso", "Observación", "Valor Disponibilidad", "Valor Compromiso", "Por Ejecutar", "Estado", "idDisponibilidad", "idRubro", "idTercero", "idRubroCentroCosto", "idRubroFuenteFinanciacion", "idCpc", "idTipoVigencia"}) { // from class: Presupuesto.JDBusquedaDocPTO.14
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modeloCompromiso);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(150);
    }

    private void cargarDatosDisponibilidadNueva() {
        crearModeloDisponibilidadNuevo();
        String sql = "WITH tempCargarDatosDisponibilidad AS (\n               SELECT \n                    pp_detalle_movimiento.Id detalleMovimiento,\n                    pp_movimiento.Id mov,\n                    pp_tipo_documentos.Nbre AS TipoDocumento,\n                    pp_movimiento.NoConcecutivo AS Consecutivo,\n                    pp_rubros.Id AS CodigoRubro,\n                    pp_rubros.Nbre AS NombreRubro,\n                    IFNULL(g_empresa.Nbre, CONCAT(g_empresa.Nombre1,' ',g_empresa.Nombre2,' ', g_empresa.Apellido1,' ',g_empresa.Apellido2)) AS Tercero,\n                    pp_rubros_centrocostos.nombre AS CentroCosto,\n                    pp_rubros_fuente_financiacion.nombre AS FuenteFinanciacion,\n                    pp_rubros_cpc.id AS CodigoCpc,\n                    pp_rubros_cpc.nombre AS NombreCpc,\n                    pp_tipo_vigencia.Nombre AS TipoVigencia,\n                    IFNULL(Compromiso.idCompromiso, 0) AS IdCompromiso,\n                    pp_movimiento.Observacion,\n                    IFNULL(sumDisponibilidad.Disponibilidad,0)+IFNULL(sumAdicion.Adicion,0)-IFNULL(sumReintegro.Reintegro,0) Disponibilidad,\n                    IFNULL(Compromiso.Compromiso,0)+IFNULL(sumAdicionC.AdicionC,0)-IFNULL(sumReintegroC.ReintegroC,0) Compromiso,\n                    IF((IFNULL(sumDisponibilidad.Disponibilidad,0)+IFNULL(sumAdicion.Adicion,0)-IFNULL(sumReintegro.Reintegro,0))=IFNULL(Compromiso.Compromiso,0)+IFNULL(sumAdicionC.AdicionC,0)-IFNULL(sumReintegroC.ReintegroC,0),0,((IFNULL(sumDisponibilidad.Disponibilidad,0)+IFNULL(sumAdicion.Adicion,0)-IFNULL(sumReintegro.Reintegro,0))-(IFNULL(Compromiso.Compromiso,0)+IFNULL(sumAdicionC.AdicionC,0)-IFNULL(sumReintegroC.ReintegroC,0)))) Por_Ejecutar,\n                    pp_detalle_movimiento.Estado,\n                    pp_movimiento.Id idDisponibilidad,\n                    pp_rubros.Id idRubro,\n                    pp_detalle_movimiento.id_tercero idTercero,\n                    pp_rubros_centrocostos.id idRubroCentroCostos,\n                    pp_rubros_fuente_financiacion.id idRubroFuenteFinanciacion,\n                    pp_rubros_cpc.id idCpc,\n                    pp_tipo_vigencia.Id idTipoVigencia\n                FROM\n                    pp_detalle_movimiento\n                    INNER JOIN pp_movimiento ON pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id\n                    INNER JOIN pp_tipo_documentos ON pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id\n                    INNER JOIN pp_rubros ON pp_rubros.Id = pp_detalle_movimiento.Id_Rubro\n                    INNER JOIN pp_rubros_centrocostos ON pp_detalle_movimiento.idRubrosCentroCostos = pp_rubros_centrocostos.id\n                    INNER JOIN pp_rubros_cpc ON pp_detalle_movimiento.idRubrosCpc = pp_rubros_cpc.id\n                    INNER JOIN pp_rubros_fuente_financiacion ON pp_detalle_movimiento.idRubrosFunteFinanciacion = pp_rubros_fuente_financiacion.id\n                    INNER JOIN g_empresa ON g_empresa.Id = pp_detalle_movimiento.Id_Tercero\n                    INNER JOIN pp_tipo_vigencia ON pp_tipo_vigencia.Id = pp_detalle_movimiento.idTopoVigencia\n                    LEFT JOIN (\n                        SELECT \n                            m.id,\n                            SUM(dm.valor) AS Disponibilidad\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                            INNER JOIN pp_tipo_documentos ON m.Id_TipoDoc = pp_tipo_documentos.Id\n                        WHERE pp_tipo_documentos.Id_ClaseDoc = 9\n                        GROUP BY \n                            m.id\n                    ) sumDisponibilidad ON pp_movimiento.IdDisponibilidad = sumDisponibilidad.id\n                    \n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            SUM(dm.valor) AS Adicion\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc = 7 \n                        GROUP BY \n                            m.id\n                    ) sumAdicion ON pp_movimiento.IdDisponibilidad = sumAdicion.idDisponibilidad\n                    \n                    LEFT JOIN (\n                        SELECT \n                            m.idDisponibilidad,\n                            SUM(dm.valor) AS Reintegro\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc = 8  \n                        GROUP BY \n                            m.id\n                    ) sumReintegro ON pp_movimiento.IdDisponibilidad = sumReintegro.idDisponibilidad\n                    \n                    LEFT JOIN (\n                        SELECT \n                \t    m.Id,\n                            m.idCompromiso,\n                            SUM(dm.valor) AS Compromiso\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc IN (5) AND dm.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND idCompromiso <> 0 \n                        GROUP BY \n                            m.id\n                    ) Compromiso ON pp_movimiento.IdCompromiso = Compromiso.idCompromiso\n                    \n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS AdicionC\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc = 11\n                        GROUP BY \n                            m.id\n                    ) sumAdicionC ON pp_movimiento.idCompromiso = sumAdicionC.idCompromiso\n                    \n                    LEFT JOIN (\n                        SELECT \n                            m.idCompromiso,\n                            SUM(dm.valor) AS ReintegroC\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc = 14 \n                        GROUP BY \n                            m.id) sumReintegroC ON pp_movimiento.idCompromiso = sumReintegroC.idCompromiso\n                            \n                    LEFT JOIN (\n                \tSELECT m.idObligacion,\n                            SUM(dm.valor) AS obligacion\n                        FROM \n                            pp_movimiento m\n                            INNER JOIN pp_detalle_movimiento dm ON m.id = dm.Id_movimiento\n                        WHERE m.id_tipoDoc = 5\n                        GROUP BY m.id) obligacion ON pp_movimiento.IdObligacion = obligacion.idObligacion\n                    WHERE pp_tipo_documentos.Id NOT IN (3)\n                    AND DATE_FORMAT(pp_movimiento.FechaD, '%Y')= '" + this.JDAno.getValue() + "'\n                    AND pp_detalle_movimiento.idEncabezado = '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'\n                    AND pp_tipo_documentos.Id_ClaseDoc = 9\n                    GROUP BY pp_movimiento.idDisponibilidad)\n                SELECT\n                  TipoDocumento,\n                  Consecutivo,\n                  CodigoRubro,\n                  NombreRubro,\n                  Tercero,\n                  CentroCosto,\n                  FuenteFinanciacion,\n                  CodigoCpc,\n                  NombreCpc,\n                  TipoVigencia,\n                  IdCompromiso,\n                  Observacion,\n                  Disponibilidad,\n                  Compromiso,\n                  Por_Ejecutar,\n                  Estado,\n                  idDisponibilidad,\n                  idRubro,\n                  idTercero, \n                  idRubroCentroCostos,\n                  idRubroFuenteFinanciacion,\n                  idCpc,\n                  idTipoVigencia\n                FROM\n                  tempCargarDatosDisponibilidad";
        try {
            ConsultasMySQL consultasMySQL = new ConsultasMySQL();
            consultasMySQL.ejecutarSQL(sql);
            if (!this.JTFNo.getText().isEmpty()) {
                sql = sql + " WHERE Consecutivo = '" + this.JTFNo.getText() + "'";
            } else if (this.JRBSin.isSelected()) {
                sql = sql + " WHERE Compromiso < Disponibilidad";
            } else if (this.JRBCon.isSelected()) {
                sql = sql + " WHERE Compromiso = Disponibilidad";
            } else if (this.JRBTodo.isSelected()) {
            }
            System.out.println("" + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int fila = 0;
                while (xrs.next()) {
                    this.modeloCompromiso.addRow(this.xdatos);
                    this.modeloCompromiso.setValueAt(xrs.getString("Consecutivo"), fila, 0);
                    this.modeloCompromiso.setValueAt(xrs.getString("TipoDocumento"), fila, 1);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoRubro"), fila, 2);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreRubro"), fila, 3);
                    this.modeloCompromiso.setValueAt(xrs.getString("Tercero"), fila, 4);
                    this.modeloCompromiso.setValueAt(xrs.getString("CentroCosto"), fila, 5);
                    this.modeloCompromiso.setValueAt(xrs.getString("FuenteFinanciacion"), fila, 6);
                    this.modeloCompromiso.setValueAt(xrs.getString("CodigoCpc"), fila, 7);
                    this.modeloCompromiso.setValueAt(xrs.getString("NombreCpc"), fila, 8);
                    this.modeloCompromiso.setValueAt(xrs.getString("TipoVigencia"), fila, 9);
                    this.modeloCompromiso.setValueAt(xrs.getString("IdCompromiso"), fila, 10);
                    this.modeloCompromiso.setValueAt(xrs.getString("Observacion"), fila, 11);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("Disponibilidad")), fila, 12);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("Compromiso")), fila, 13);
                    this.modeloCompromiso.setValueAt(Double.valueOf(xrs.getDouble("Por_Ejecutar")), fila, 14);
                    this.modeloCompromiso.setValueAt(xrs.getString("Estado"), fila, 15);
                    this.modeloCompromiso.setValueAt(xrs.getString("IdDisponibilidad"), fila, 16);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubro"), fila, 17);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTercero"), fila, 18);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroCentroCostos"), fila, 19);
                    this.modeloCompromiso.setValueAt(xrs.getString("idRubroFuenteFinanciacion"), fila, 20);
                    this.modeloCompromiso.setValueAt(xrs.getString("idCpc"), fila, 21);
                    this.modeloCompromiso.setValueAt(xrs.getString("idTipoVigencia"), fila, 22);
                    fila++;
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBusquedaDocPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
