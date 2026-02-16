package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.laboratorio.dto.StickerPrintDto;
import com.genoma.plus.dao.impl.laboratorio.RecepcionStikerDAOImpl;
import com.genoma.plus.dao.laboratorio.RecepcionStikerDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFRecepcionStikers.class */
public class JIFRecepcionStikers extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private RecepcionStikerDAO xRecepcionStikerDAO;
    private String[] xIdMunicipio;
    private String IdConcatenado;
    private JComboBox JCBMunicipio;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDPeriodo;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFBuscar;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos(false);
    private boolean xlleno = false;

    public JIFRecepcionStikers() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRecepcionStikerDAO = (RecepcionStikerDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("recepcionStikerDAO");
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCHFiltro.setSelected(false);
        this.JCHSeleccionar.setSelected(true);
        mCargarCombo();
        mCreaModeloTabla();
        this.IdConcatenado = "";
        this.xlleno = true;
    }

    private void mCargarCombo() {
        this.JCBMunicipio.removeAllItems();
        List<Object[]> list = this.xRecepcionStikerDAO.ListMunicipiosRecepcion(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xIdMunicipio = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xIdMunicipio[x] = list.get(x)[0].toString();
            this.JCBMunicipio.addItem(list.get(x)[1].toString());
        }
        this.JCBMunicipio.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdRecepcion", "No. Historia", "Usuario", "Municipio", "Seleccionar", "Impreso?"}) { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(130);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    public void mBuscar() {
        mCargarDatos();
    }

    public void mCargarDatos() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xRecepcionStikerDAO.ListRecepcionStikers(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()], this.JTFBuscar.getText(), 1);
        } else {
            list = this.xRecepcionStikerDAO.ListRecepcionStikers(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), "", this.JTFBuscar.getText(), 0);
        }
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            if (Integer.valueOf(list.get(x)[5].toString()).intValue() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        }
        mConcatenar();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFRecepcionStikers$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean Impreso = Boolean.valueOf(table.getValueAt(row, 5).toString()).booleanValue();
            if (Impreso) {
                cell.setBackground(Color.green);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mSeleccionar(boolean xestado) {
        this.IdConcatenado = "";
        if (this.JTDetalle.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 4);
                this.IdConcatenado += this.xmodelo.getValueAt(x, 0).toString() + ",";
            }
        }
    }

    private void mConcatenar() {
        this.IdConcatenado = "";
        if (this.JTDetalle.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 4).toString()).booleanValue()) {
                    this.IdConcatenado += this.xmodelo.getValueAt(x, 0).toString() + ",";
                }
            }
        }
    }

    public void mImprimir() {
        String xsql;
        Object[] botones = {"Visualizacion", "Impresion", "Cerrar"};
        int n = JOptionPane.showOptionDialog((Component) null, "Que desea hacer?", "FORMA DE GENERACIÓN DE STIKER", 0, 3, (Icon) null, botones, "Cerrar");
        if (n == 0) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.IdConcatenado + "-1";
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            System.out.println(this.xmt.getRutaRep());
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                this.xmt.PresentacionImpresora("l_stiker_n_Historico_Fonnegra.jasper", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "l_stiker_n_Historico", parametros);
                return;
            }
        }
        if (n == 1) {
            String sql = "update l_recepcion set ImpresionStiker = 1 where Id IN(" + this.IdConcatenado + " -1)";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                try {
                    if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Orina',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion, persona.`NUsuario` AS Dato1, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE (`l_recepcion`.`Id` IN(" + this.IdConcatenado + "-1)) GROUP BY idRecepcion,  l_areas.`Id`, l_tipomuestra.`Id` ORDER BY idRecepcion ASC";
                    } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Urine',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion, persona.`NUsuario` AS Dato1, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE (`l_recepcion`.`Id` IN(" + this.IdConcatenado + "-1)) GROUP BY idRecepcion,  l_areas.`Id`, l_tipomuestra.`Id` ORDER BY idRecepcion ASC";
                    } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                        xsql = "SELECT\n\tCONCAT(`l_recepcion`.`Id`, ifnull(UPPER(SUBSTRING(l_tipomuestra.Abreviatura, 1, 1)), ''), ifnull(l_protocoloxprocedimiento.`NAdicional`, '')) AS idRecepcion,\n\tpersona.`NUsuario` AS Dato1,\n\tCONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y') AS Fecha ,\n\tIFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-',\n\t'',\n\tGROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n\t'') AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen ,\n\tpersona.`NMunicipio`\n\t-- , `l_protocolos`.`Nbre`\n\t-- , `l_protocolos`.`Id`\n\t-- , `l_tipomuestra`.`Id`\n\t-- ,`g_procedimiento`.`Nbre`\n\t-- , `l_areas`.Nbre as Areas\n\tFROM d_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n\t(`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)\n\tAND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n\t(`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE\n\t(`l_recepcion`.`Id` = '" + this.IdConcatenado + "')\nGROUP BY\n\tidRecepcion,\n\tl_areas.`Id`,\n\tl_tipomuestra.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                        xsql = "SELECT\nCASE WHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=0 THEN \n\tIF(l_tipo_equipos.`Nbre`='COBAS U411',LPAD(CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')),6,'0'),CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')))\n\tWHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=1 THEN\n\tIF(l_tipo_equipos.`Nbre`='COBAS U411',CONCAT(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)), UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')),CONCAT(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)), UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')))\n\tEND idRecepcion,\n        persona.`NUsuario` AS Dato1,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id`  IN(" + this.IdConcatenado + " -1) AND l_detallerecepcion.PMuestra=0)\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                        xsql = "SELECT\n\t`l_recepcion`.`Id` AS idRecepcion,\n\tpersona.`NUsuario` AS Dato1,\n\tCONCAT(`persona`.`Id_TipoIdentificacion`,' ',persona.`NoHistoria`,' EDAD: ',persona.`Edad`,' ',persona.`NTipoEdad`,'(s) GENERO:', `persona`.`IdSexo`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`,'%d/%m/%Y %h:%i:%s %p') AS Fecha ,\n\tIF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`REF` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM\n\td_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE\n\t(`l_recepcion`.`Id` IN(" + this.IdConcatenado + " -1) AND l_detallerecepcion.PMuestra=0)\nGROUP BY\n\t`l_recepcion`.`Id`,\n\t`l_tipomuestra`.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                        if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                            xsql = "SELECT\n\tCONCAT(lr.consecutivo, UPPER(lt.indicativo), '', IFNULL(lp.NAdicional, ''), IF(lp.CNOrden_Recepcion = 1, lp.Orden, '')) as idRecepcion,\n\tCONCAT(gp2.Apellido1, ' ', gp2.Apellido2, ' ', gp2.Nombre1, ' ', gp2.Nombre2) AS pacienteNombre,\n\tCONCAT(gp2.Id_TipoIdentificacion,': ', gu.NoHistoria, ' - EDAD: ', gp2.Edad, ' ', left(gt2.Nbre,1), ' - GENERO: ', gp2.Id_Sexo) AS pacienteInformacion,\n\tDATE_FORMAT(lr.FechaRecep, '%d-%m-%Y %h:%i:%s %p') AS fechaRecepcion,\n\tCONCAT('MUESTRA: ', IFNULL(IF(GROUP_CONCAT(DISTINCT lt.Abreviatura SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT lt.Abreviatura SEPARATOR '-')), ''), if(gp.EsRemitido = 0,'',' - REMISION')) AS tipoMuestra,\n\tCONCAT('EXM: ', GROUP_CONCAT(DISTINCT gp.Ref SEPARATOR '-')) AS examen,\n\tgm.Nbre as municipio\nFROM \n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr ON\n\t(ld.Id_Recepcion = ld.id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN l_areas la ON\n\t(la.Id = gp.Id_Area)\nINNER JOIN g_persona gp2 ON\n\t(gp2.Id = lr.Id_Paciente)\nINNER JOIN g_tipoedad gt2 ON\n\t(gt2.Id = gp2.Id_TipoEdad)\nINNER JOIN g_municipio gm ON\n\t(gm.Id = gp2.Id_Municipio)\nINNER JOIN g_usuario gu ON\n\t(gu.Id_persona = gp2.Id)\nINNER JOIN l_tipo_tubo ltt ON\n\t(gp.Id_Tubo = ltt.Id)\nLEFT JOIN l_recepcion_citologia lrc ON\n\t(lrc.Id_Recepcion = lr.Id)\nLEFT JOIN l_protocoloxprocedimiento lp ON\n\t(lp.Id_Procedim = gp.Id)\n\tAND (lp.Estado = 0)\nLEFT JOIN l_protocolos lp2 ON\n\t(lp2.Id = lp.Id_Protocolo)\nLEFT JOIN l_procedimiento_equipo lpe ON\n\t(lpe.Id_Procedimiento = gp.Id)\nLEFT JOIN l_tipo_equipos lte ON\n\t(lpe.Id_Equipo = lte.Id)\nLEFT JOIN l_tipomuestra lt ON\n\t(lt.Id = gp.Id_TipoMuestra)\nINNER JOIN f_ordenes fo ON\n\t(fo.Id = lr.Id_OrdenFacturac)\nINNER JOIN ingreso i ON\n\t(i.Id = fo.Id_Ingreso)\nINNER JOIN g_tipoatencion gt ON\n\t(gt.Id = i.Id_TipoAtencion)\nWHERE\n\t(lr.Id IN (" + this.IdConcatenado + " -1))\n\t\tAND ld.PMuestra = 0)\nGROUP BY\n\tidRecepcion,\n\tla.Id,\n\tgp.EsRemitido;";
                        } else {
                            xsql = "SELECT\n\tCONCAT(lr.id, UPPER(lt.indicativo), '', IFNULL(lp.NAdicional, ''), IF(lp.CNOrden_Recepcion = 1, lp.Orden, '')) as idRecepcion,\n\tCONCAT(gp2.Apellido1, ' ', gp2.Apellido2, ' ', gp2.Nombre1, ' ', gp2.Nombre2) AS pacienteNombre,\n\tCONCAT(gp2.Id_TipoIdentificacion,': ', gu.NoHistoria, ' - EDAD: ', gp2.Edad, ' ', left(gt2.Nbre,1), ' - GENERO: ', gp2.Id_Sexo) AS pacienteInformacion,\n\tDATE_FORMAT(lr.FechaRecep, '%d-%m-%Y %h:%i:%s %p') AS fechaRecepcion,\n\tCONCAT('MUESTRA: ', IFNULL(IF(GROUP_CONCAT(DISTINCT lt.Abreviatura SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT lt.Abreviatura SEPARATOR '-')), ''), if(gp.EsRemitido = 0,'',' - REMISION')) AS tipoMuestra,\n\tCONCAT('EXM: ', GROUP_CONCAT(DISTINCT gp.Ref SEPARATOR '-')) AS examen,\n\tgm.Nbre as municipio\nFROM \n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr ON\n\t(ld.Id_Recepcion = ld.id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN l_areas la ON\n\t(la.Id = gp.Id_Area)\nINNER JOIN g_persona gp2 ON\n\t(gp2.Id = lr.Id_Paciente)\nINNER JOIN g_tipoedad gt2 ON\n\t(gt2.Id = gp2.Id_TipoEdad)\nINNER JOIN g_municipio gm ON\n\t(gm.Id = gp2.Id_Municipio)\nINNER JOIN g_usuario gu ON\n\t(gu.Id_persona = gp2.Id)\nINNER JOIN l_tipo_tubo ltt ON\n\t(gp.Id_Tubo = ltt.Id)\nLEFT JOIN l_recepcion_citologia lrc ON\n\t(lrc.Id_Recepcion = lr.Id)\nLEFT JOIN l_protocoloxprocedimiento lp ON\n\t(lp.Id_Procedim = gp.Id)\n\tAND (lp.Estado = 0)\nLEFT JOIN l_protocolos lp2 ON\n\t(lp2.Id = lp.Id_Protocolo)\nLEFT JOIN l_procedimiento_equipo lpe ON\n\t(lpe.Id_Procedimiento = gp.Id)\nLEFT JOIN l_tipo_equipos lte ON\n\t(lpe.Id_Equipo = lte.Id)\nLEFT JOIN l_tipomuestra lt ON\n\t(lt.Id = gp.Id_TipoMuestra)\nINNER JOIN f_ordenes fo ON\n\t(fo.Id = lr.Id_OrdenFacturac)\nINNER JOIN ingreso i ON\n\t(i.Id = fo.Id_Ingreso)\nINNER JOIN g_tipoatencion gt ON\n\t(gt.Id = i.Id_TipoAtencion)\nWHERE\n\t(lr.Id IN (" + this.IdConcatenado + " -1)\n\t\tAND ld.PMuestra = 0)\nGROUP BY\n\tidRecepcion,\n\tla.Id,\n\tgp.EsRemitido;";
                        }
                    } else {
                        xsql = "SELECT l_recepcion.`Id`as idRecepcion, persona.`NUsuario` as Dato1, concat('No.HC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`,' ', persona.`NTipoEdad`, '(s)') as Datos2\n ,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n  ,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n    ,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Id` IN(" + this.IdConcatenado + " -1)) GROUP BY `l_recepcion`.`Id`, `l_tipomuestra`.`Id`";
                    }
                    ResultSet xrs = this.xct.traerRs(xsql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.xmt.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion"), xrs.getString("Dato1"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), xrs.getString("NMunicipio"), this.xmt.getInfoSticker());
                            if (0 % 10 == 0) {
                                try {
                                    Thread.sleep(1000L);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(JIFRecepcionStikers.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                }
                                System.out.println(0);
                            }
                        }
                    }
                    xrs.close();
                    this.xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFRecepcionStikers.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    return;
                }
            }
            Map<String, Object> parameters = new HashMap<>();
            List<String> lista = Arrays.asList(this.IdConcatenado.split(","));
            parameters.put("idRecepcion", lista);
            StickerPrintDto stickerPrintDto = this.xmt.getInfoStickerV2("JIFRecepcionSticker", parameters);
            this.xmt.mImprimir_CodBarraZebraV2(stickerPrintDto);
            String sql2 = "update l_recepcion set ImpresionStiker = 1 where Id IN(" + this.IdConcatenado + " -1)";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDPeriodo = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JCHSeleccionar = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFBuscar = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPRESION DE STIKERS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifrecepcionstikers");
        this.JPIDPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "PERÍODO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikers.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikers.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.4
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcionStikers.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.5
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcionStikers.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDPeriodoLayout = new GroupLayout(this.JPIDPeriodo);
        this.JPIDPeriodo.setLayout(JPIDPeriodoLayout);
        JPIDPeriodoLayout.setHorizontalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMunicipio, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltro).addComponent(this.JCHSeleccionar, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPIDPeriodoLayout.setVerticalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 55, -2).addComponent(this.JDFechaF, -2, 55, -2))).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMunicipio, -2, -1, -2).addGroup(JPIDPeriodoLayout.createSequentialGroup().addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar))))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikers.this.JTDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por Usuario o No. Recepcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikers.7
            public void keyPressed(KeyEvent evt) {
                JIFRecepcionStikers.this.JTFBuscarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFBuscar).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -1, 769, 32767).addComponent(this.JPIDPeriodo, -1, -1, 32767)).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDPeriodo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 369, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFBuscar, -2, 50, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mCargarCombo();
        } else {
            this.JCBMunicipio.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        mConcatenar();
    }
}
