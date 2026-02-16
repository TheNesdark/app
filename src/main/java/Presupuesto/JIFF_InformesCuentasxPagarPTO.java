package Presupuesto;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFF_InformesCuentasxPagarPTO.class */
public class JIFF_InformesCuentasxPagarPTO extends JInternalFrame {
    private DefaultTableModel xModelo;
    private DefaultTableModel xModeloVO;
    private Object[] xDato;
    private String xsql;
    private String[] xCombo;
    private String xidTercero;
    private JButton JBBuscaTercero;
    private JButton JBTExportar;
    public JLabel JLDocumento;
    public JLabel JLTercero;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JCheckBox jChTercero;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();

    public JIFF_InformesCuentasxPagarPTO() {
        initComponents();
        mNuevo();
    }

    private void mCrearTablaSocioDemO() {
        this.xModelo = new DefaultTableModel((Object[][]) null, getColumasUsuario());
        this.JTDetalle.setModel(this.xModelo);
    }

    public String getXidTercero() {
        return this.xidTercero;
    }

    public void setXidTercero(String xidTercero) {
        this.xidTercero = xidTercero;
    }

    private String[] getColumasUsuario() {
        String[] columna = null;
        ResultSet xrs = this.xct.traerRs("SELECT `Id`,CONCAT(Orden,'-',`Nbre`) AS Pregunta FROM  `so_p_sociodemografica` WHERE Estado=1 ORDER BY Orden ASC;");
        System.out.println("sql-->SELECT `Id`,CONCAT(Orden,'-',`Nbre`) AS Pregunta FROM  `so_p_sociodemografica` WHERE Estado=1 ORDER BY Orden ASC;");
        try {
            if (xrs.next()) {
                xrs.last();
                columna = new String[xrs.getRow()];
                System.out.println("TamVector-->" + xrs.getRow() + " Columna-->" + columna.length);
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    columna[n] = xrs.getString("Pregunta");
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFF_InformesCuentasxPagarPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return columna;
    }

    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha", "Cod_Rubro", "NombreRubro", "No.Identificacion", "Tercero", "Cod_CDP", "Cod_RP", "Cod_OP", "Vr_CDP", "Vr_RP", "Vr_OP", "Vr_Pago", "Cuenta_x_Pagar", "Valor_x_Obligar", "Cod_Causacion", "Objeto", "Contrato"}) { // from class: Presupuesto.JIFF_InformesCuentasxPagarPTO.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(200);
    }

    private void mCargarDatos() {
        mCrearModelo();
        try {
            this.xsql = null;
            if (this.jChTercero.isSelected()) {
                this.xsql = "SELECT DISP.FechaD, DISP.Id_R AS CodRubro,\n       DISP.N_R AS NombreRubro,\n       COMP.No_Identificacion,\n       COMP.RazonSocialCompleta,\n       DISP.NoConcecutivo AS Cod_Disponibilidad,\n       -- COMP.IdCompromiso,\n       COMP.NoConcecutivo AS Cod_Compromiso,\n       IFNULL(OBLI.NoConcecutivo,'') AS Cod_Obligacion,\n       IFNULL(DISP.Valor,0) Vr_Disponibilidad ,\n       IFNULL(COMP.Valor,0) Vr_Compromiso ,\n       IFNULL(OBLI.Valor,0) Vr_Obligacion ,\n       IFNULL(PAG.Valor,0) Vr_pago,\n       (IFNULL(OBLI.Valor,0)-IFNULL(PAG.Valor,0)) CxP_new,\n       -- (IFNULL(COMP.Valor,0)-IFNULL(PAG.Valor,0)) Cuenta_x_Pagar_OLD,\n       -- (IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)) Valor_x_Obligar,\n  IF(TMP.idObligacion IS NULL,(IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)),IF((IFNULL(OBLI.Valor,0)-IFNULL(PAG.Valor,0))=0,0,(IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)))) Valor_x_Obligar,        IFNULL(OBLI.IdDocContable,'') AS CodCausacion,\n       COMP.OBJETO,\n       COMP.CONTRATO\nFROM \n(SELECT        pp_movimiento.IdDisponibilidad, pp_movimiento.`FechaD`\n,pp_movimiento.`NoConcecutivo`\n\t     ,pp_rubros.Id Id_R\n\t     , pp_rubros.Nbre N_R\n\t     ,pp_rubros.TipoRubro \n\t     ,cc_terceros.id\n\t     , pp_movimiento.`Observacion` AS OBJETO\n\t     , SUM(\n\t\tCASE WHEN pp_clase_documento.Id IN(9,10) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor\n\t    \n\t FROM     pp_movimiento\n\t    INNER JOIN pp_periodo \n\t\tON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n\t    INNER JOIN pp_detalle_movimiento \n\t\tON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n\t    INNER JOIN pp_tipo_documentos \n\t\tON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n\t    INNER JOIN pp_rubros \n\t\tON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n\t    INNER JOIN pp_clase_documento \n\t\tON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n\t    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n\t    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      ) \t\n\t    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(9,10,11)  \n\t GROUP BY   pp_rubros.Id  ,pp_movimiento.IdDisponibilidad, cc_terceros.id ) DISP\nINNER JOIN \t \n\t \n(SELECT pp_movimiento.`Id` AS idCompromisoI, \n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n     ,pp_movimiento.IdDisponibilidad\n     ,pp_movimiento.IdCompromiso\n     ,pp_movimiento.`NoConcecutivo`\n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion\n     ,cc_terceros.RazonSocialCompleta\t\n     , pp_movimiento.`Observacion` AS OBJETO\n     , pp_movimiento.`NoDocumento` AS CONTRATO\t\n     , SUM(\n\t\tCASE WHEN pp_clase_documento.Id IN(4,12) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor\n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND  pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(4,12,13) AND pp_detalle_movimiento.Id_Tercero='" + getXidTercero() + "'  \n GROUP BY   pp_rubros.Id,pp_movimiento.IdDisponibilidad, pp_movimiento.IdCompromiso,  cc_terceros.id ) COMP\n ON DISP.Id_R=COMP.Id_R AND  DISP.IdDisponibilidad=COMP.IdDisponibilidad\n\nLEFT JOIN\n\n(SELECT pp_movimiento.`Id` AS idObligacionI, \n     \n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n ,pp_movimiento.NoConcecutivo \n     ,pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n  , pp_movimiento.`IdDocContable` \n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion\n     ,cc_terceros.RazonSocialCompleta\t\n     , SUM(CASE WHEN pp_clase_documento.Id IN(5,14) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor\n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND   pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )\t\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(5,14,15) AND pp_detalle_movimiento.Id_Tercero='" + getXidTercero() + "' \n GROUP BY   pp_rubros.Id ,pp_movimiento.IdCompromiso,pp_movimiento.IdObligacion,cc_terceros.id) OBLI\n\nON COMP.Id_R=OBLI.Id_R AND  COMP.IdCompromiso=OBLI.IdCompromiso\n\nLEFT JOIN\n\n(SELECT\n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n     ,pp_movimiento.IdObligacion\n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion \n     ,cc_terceros.RazonSocialCompleta\t\n     , SUM(pp_detalle_movimiento.Valor) Valor\n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND   pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )  \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(6) AND pp_detalle_movimiento.Id_Tercero='" + getXidTercero() + "'  \n GROUP BY   pp_rubros.Id ,pp_movimiento.IdObligacion, cc_terceros.id) PAG\n\nON OBLI.Id_R=PAG.Id_R AND  OBLI.IdObligacion=PAG.IdObligacion\n LEFT JOIN (SELECT\n    `pp_movimiento`.`IdCompromiso`\n    , `pp_tipo_documentos`.`Id`\n    , `pp_tipo_documentos`.`Nbre`\n    , `pp_tipo_documentos`.`Id_ClaseDoc`\n    ,`pp_movimiento`.`IdObligacion` AS idObligacion\n    \n FROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =5 AND pp_movimiento.`Id_MotivoAnulacion`=1) ) AS TMP\n    ON (TMP.`IdCompromiso`= COMP.idCompromisoI) AND (TMP.`IdObligacion`>OBLI.idObligacionI) WHERE (IFNULL(COMP.Valor,0)-IFNULL(PAG.Valor,0))>0 HAVING (Valor_x_Obligar<>0 OR CxP_new<>0) ORDER BY COMP.RazonSocialCompleta ASC , DISP.NoConcecutivo ASC, COMP.NoConcecutivo ASC";
            } else {
                this.xsql = "SELECT  DISP.FechaD, DISP.Id_R AS CodRubro,\n       DISP.N_R AS NombreRubro,\n       COMP.No_Identificacion,\n       COMP.RazonSocialCompleta,\n       DISP.NoConcecutivo AS Cod_Disponibilidad,\n       -- COMP.IdCompromiso,\n       COMP.NoConcecutivo AS Cod_Compromiso,\n       IFNULL(OBLI.NoConcecutivo,'') AS Cod_Obligacion,\n       IFNULL(DISP.Valor,0) Vr_Disponibilidad ,\n       IFNULL(COMP.Valor,0) Vr_Compromiso ,\n       IFNULL(OBLI.Valor,0) Vr_Obligacion ,\n       IFNULL(PAG.Valor,0) Vr_pago,\n       (IFNULL(OBLI.Valor,0)-IFNULL(PAG.Valor,0)) CxP_new,\n       -- (IFNULL(COMP.Valor,0)-IFNULL(PAG.Valor,0)) Cuenta_x_Pagar_OLD,\n       -- (IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)) Valor_x_Obligar,\n  IF(TMP.idObligacion IS NULL,(IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)),IF((IFNULL(OBLI.Valor,0)-IFNULL(PAG.Valor,0))=0,0,(IFNULL(COMP.Valor,0)-IFNULL(OBLI.Valor,0)))) Valor_x_Obligar,         IFNULL(OBLI.IdDocContable,'') AS CodCausacion,\n       COMP.OBJETO,\n       COMP.CONTRATO\nFROM \n(SELECT        pp_movimiento.IdDisponibilidad, pp_movimiento.`FechaD`\n,pp_movimiento.`NoConcecutivo`\n\t     ,pp_rubros.Id Id_R\n\t     , pp_rubros.Nbre N_R\n\t     ,pp_rubros.TipoRubro \n\t     ,cc_terceros.id\n\t     , pp_movimiento.`Observacion` AS OBJETO\n\t     , SUM(\n\t\tCASE WHEN pp_clase_documento.Id IN(9,10) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor\n\t    \n\t FROM     pp_movimiento\n\t    INNER JOIN pp_periodo \n\t\tON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n\t    INNER JOIN pp_detalle_movimiento \n\t\tON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n\t    INNER JOIN pp_tipo_documentos \n\t\tON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n\t    INNER JOIN pp_rubros \n\t\tON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n\t    INNER JOIN pp_clase_documento \n\t\tON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n\t    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n\t    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      ) \t\n\t    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(9,10,11)  \n\t GROUP BY   pp_rubros.Id  ,pp_movimiento.IdDisponibilidad, cc_terceros.id ) DISP\nINNER JOIN \t \n\t \n(SELECT pp_movimiento.`Id` AS idCompromisoI, \n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n     ,pp_movimiento.IdDisponibilidad\n     ,pp_movimiento.IdCompromiso\n     ,pp_movimiento.`NoConcecutivo`\n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion\n     ,cc_terceros.RazonSocialCompleta\t\n     , pp_movimiento.`Observacion` AS OBJETO\n     , pp_movimiento.`NoDocumento` AS CONTRATO\t\n     , SUM(\n\t\tCASE WHEN pp_clase_documento.Id IN(4,12) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor\n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND  pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(4,12,13)   \n GROUP BY   pp_rubros.Id,pp_movimiento.IdDisponibilidad, pp_movimiento.IdCompromiso,  cc_terceros.id ) COMP\n ON DISP.Id_R=COMP.Id_R AND  DISP.IdDisponibilidad=COMP.IdDisponibilidad\n\nLEFT JOIN\n\n(SELECT  pp_movimiento.`Id` AS idObligacionI, \n     \n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n ,pp_movimiento.NoConcecutivo \n     ,pp_movimiento.IdCompromiso\n     ,pp_movimiento.`IdObligacion`\n, pp_movimiento.`IdDocContable` \n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion\n     ,cc_terceros.RazonSocialCompleta\t\n    , SUM(CASE WHEN pp_clase_documento.Id IN(5,14) THEN\n\t\t  pp_detalle_movimiento.Valor\n\t\tELSE\n\t\t  pp_detalle_movimiento.Valor*(-1)\n\t\t END) Valor \n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND   pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )\t\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(5,14,15) \n GROUP BY   pp_rubros.Id ,pp_movimiento.IdCompromiso,pp_movimiento.IdObligacion,cc_terceros.id) OBLI\n\nON COMP.Id_R=OBLI.Id_R AND  COMP.IdCompromiso=OBLI.IdCompromiso\n\nLEFT JOIN\n\n(SELECT\n      pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n     ,pp_movimiento.IdObligacion\n     ,cc_terceros.id\n     ,cc_terceros.No_identificacion\n     ,cc_terceros.RazonSocialCompleta\t\n     , SUM(pp_detalle_movimiento.Valor) Valor\n    \n FROM     pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    INNER JOIN  cc_terceros ON cc_terceros.Id = pp_detalle_movimiento.Id_Tercero\n    WHERE pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' AND   pp_periodo.Id IN  ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n                \t\t\t\tWHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' ) pact\n                \t\t\t\tWHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n                \t\t\t\tOR pact.Id=pant.id\n                \t\t\t      )  \t\n    AND pp_movimiento.Id_MotivoAnulacion=1 AND TipoRubro='G' AND pp_clase_documento.Id IN(6)  \n GROUP BY   pp_rubros.Id ,pp_movimiento.IdObligacion, cc_terceros.id) PAG\n\n ON OBLI.Id_R=PAG.Id_R AND  OBLI.IdObligacion=PAG.IdObligacion \n LEFT JOIN (SELECT\n    `pp_movimiento`.`IdCompromiso`\n    , `pp_tipo_documentos`.`Id`\n    , `pp_tipo_documentos`.`Nbre`\n    , `pp_tipo_documentos`.`Id_ClaseDoc`\n    ,`pp_movimiento`.`IdObligacion` AS idObligacion\n    \n FROM\n    `baseserver`.`pp_detalle_movimiento`\n    INNER JOIN `baseserver`.`pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `baseserver`.`pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n WHERE ( `pp_tipo_documentos`.`Id_ClaseDoc` =5 AND pp_movimiento.`Id_MotivoAnulacion`=1) ) AS TMP\n    ON (TMP.`IdCompromiso`= COMP.idCompromisoI) AND (TMP.`IdObligacion`>OBLI.idObligacionI) WHERE (IFNULL(COMP.Valor,0)-IFNULL(PAG.Valor,0))>0 HAVING (Valor_x_Obligar<>0 OR CxP_new<>0)  ORDER BY COMP.RazonSocialCompleta ASC , DISP.NoConcecutivo ASC, COMP.NoConcecutivo ASC";
            }
            System.out.println("Consulta CxP ==>  " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    this.xModelo.addRow(this.xDato);
                    if (rs.getDouble("CxP_new") != 0.0d) {
                        this.xModelo.setValueAt(rs.getString("FechaD"), n, 0);
                        this.xModelo.setValueAt(rs.getString("CodRubro"), n, 1);
                        this.xModelo.setValueAt(rs.getString("NombreRubro"), n, 2);
                        this.xModelo.setValueAt(rs.getString("No_Identificacion"), n, 3);
                        this.xModelo.setValueAt(rs.getString("RazonSocialCompleta"), n, 4);
                        this.xModelo.setValueAt(rs.getString("Cod_Disponibilidad"), n, 5);
                        this.xModelo.setValueAt(rs.getString("Cod_Compromiso"), n, 6);
                        this.xModelo.setValueAt(rs.getString("Cod_Obligacion"), n, 7);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Disponibilidad")), n, 8);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Compromiso")), n, 9);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Obligacion")), n, 10);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Pago")), n, 11);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("CxP_new")), n, 12);
                        this.xModelo.setValueAt(0, n, 13);
                        this.xModelo.setValueAt(0, n, 14);
                        this.xModelo.setValueAt(rs.getString("OBJETO"), n, 15);
                        this.xModelo.setValueAt(rs.getString("CONTRATO"), n, 16);
                        if (rs.getDouble("Valor_x_Obligar") != 0.0d) {
                            n++;
                            this.xModelo.addRow(this.xDato);
                            this.xModelo.setValueAt(rs.getString("FechaD"), n, 0);
                            this.xModelo.setValueAt(rs.getString("CodRubro"), n, 1);
                            this.xModelo.setValueAt(rs.getString("NombreRubro"), n, 2);
                            this.xModelo.setValueAt(rs.getString("No_Identificacion"), n, 3);
                            this.xModelo.setValueAt(rs.getString("RazonSocialCompleta"), n, 4);
                            this.xModelo.setValueAt(rs.getString("Cod_Disponibilidad"), n, 5);
                            this.xModelo.setValueAt(rs.getString("Cod_Compromiso"), n, 6);
                            this.xModelo.setValueAt(rs.getString("Cod_Obligacion"), n, 7);
                            this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Disponibilidad")), n, 8);
                            this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Compromiso")), n, 9);
                            this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Obligacion")), n, 10);
                            this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Obligacion")), n, 11);
                            this.xModelo.setValueAt(0, n, 12);
                            this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Valor_x_Obligar")), n, 13);
                            this.xModelo.setValueAt(rs.getString("CodCausacion"), n, 14);
                            this.xModelo.setValueAt(rs.getString("OBJETO"), n, 15);
                            this.xModelo.setValueAt(rs.getString("CONTRATO"), n, 16);
                        }
                    } else {
                        this.xModelo.setValueAt(rs.getString("FechaD"), n, 0);
                        this.xModelo.setValueAt(rs.getString("CodRubro"), n, 1);
                        this.xModelo.setValueAt(rs.getString("NombreRubro"), n, 2);
                        this.xModelo.setValueAt(rs.getString("No_Identificacion"), n, 3);
                        this.xModelo.setValueAt(rs.getString("RazonSocialCompleta"), n, 4);
                        this.xModelo.setValueAt(rs.getString("Cod_Disponibilidad"), n, 5);
                        this.xModelo.setValueAt(rs.getString("Cod_Compromiso"), n, 6);
                        this.xModelo.setValueAt(rs.getString("Cod_Obligacion"), n, 7);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Disponibilidad")), n, 8);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Compromiso")), n, 9);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Obligacion")), n, 10);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Vr_Pago")), n, 11);
                        this.xModelo.setValueAt(0, n, 12);
                        this.xModelo.setValueAt(Double.valueOf(rs.getDouble("Valor_x_Obligar")), n, 13);
                        this.xModelo.setValueAt(rs.getString("CodCausacion"), n, 14);
                        this.xModelo.setValueAt(rs.getString("OBJETO"), n, 15);
                        this.xModelo.setValueAt(rs.getString("CONTRATO"), n, 16);
                    }
                    n++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFF_InformesCuentasxPagarPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModelo();
    }

    public void mBuscar() {
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel1 = new JPanel();
        this.JBBuscaTercero = new JButton();
        this.JLDocumento = new JLabel();
        this.JLTercero = new JLabel();
        this.jChTercero = new JCheckBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES DE CUENTAS X PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiffInformeCuentasxPagar");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFF_InformesCuentasxPagarPTO.2
            public void mouseClicked(MouseEvent evt) {
                JIFF_InformesCuentasxPagarPTO.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFF_InformesCuentasxPagarPTO.3
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformesCuentasxPagarPTO.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setEnabled(false);
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: Presupuesto.JIFF_InformesCuentasxPagarPTO.4
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformesCuentasxPagarPTO.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JLDocumento.setBackground(new Color(255, 255, 255));
        this.JLDocumento.setFont(new Font("Arial", 1, 12));
        this.JLDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDocumento.setEnabled(false);
        this.JLDocumento.setOpaque(true);
        this.JLTercero.setBackground(new Color(255, 255, 255));
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLTercero.setEnabled(false);
        this.JLTercero.setOpaque(true);
        this.jChTercero.setFont(new Font("Arial", 1, 12));
        this.jChTercero.setText("Filtro Tercero?");
        this.jChTercero.addActionListener(new ActionListener() { // from class: Presupuesto.JIFF_InformesCuentasxPagarPTO.5
            public void actionPerformed(ActionEvent evt) {
                JIFF_InformesCuentasxPagarPTO.this.jChTerceroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLDocumento, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTercero, -1, 420, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jChTercero, -2, 120, -2).addGap(413, 413, 413)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jChTercero).addComponent(this.JBBuscaTercero, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JLTercero, -1, -1, 32767).addComponent(this.JLDocumento, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 10)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jTabbedPane1.addTab("CUENTAS X PAGAR", this.jScrollPane1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 512, -2).addGap(35, 35, 35).addComponent(this.JBTExportar, -2, 225, -2).addGap(0, 404, 32767)).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jChTerceroActionPerformed(ActionEvent evt) {
        if (this.jChTercero.isSelected()) {
            this.JLDocumento.setEnabled(true);
            this.JLTercero.setEnabled(true);
            this.JBBuscaTercero.setEnabled(true);
        } else {
            this.JLDocumento.setEnabled(false);
            this.JLTercero.setEnabled(false);
            this.JBBuscaTercero.setEnabled(false);
            setXidTercero(null);
            this.JLDocumento.setText("");
            this.JLTercero.setText("");
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }
}
