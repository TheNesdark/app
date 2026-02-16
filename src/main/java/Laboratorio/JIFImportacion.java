package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacion.class */
public class JIFImportacion extends JInternalFrame {
    private int xlleno;
    private Object[] dato;
    private String sql;
    public DefaultTableModel xmodelo;
    private claseLab xclaselab;
    private AbrirPuertos xClaseHilo;
    private Thread xhilo;
    private static List<String> portsFree;

    /* JADX INFO: renamed from: com, reason: collision with root package name */
    private static Com f27com;
    private static String xdatosrecibidos;
    public static Vector xvector;
    private String[] xlistaBact;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JButton JBTEscuchar;
    private JButton JBTGenerar2;
    private JButton JBTGrabar;
    private JButton JBTValidar;
    private JScrollPane JSPDatosTabla;
    private JTable JTBDatosTabla;
    private static SerialPort serialPort = new SerialPort();
    public static boolean xestado = true;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int estado = 2;
    private int filaGrid = 0;
    private boolean xvalidado = false;

    public JIFImportacion(claseLab xclaselab) {
        this.xlleno = 0;
        initComponents();
        this.xclaselab = xclaselab;
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            mCrearTabla1();
        } else {
            mCrearTabla1();
        }
        this.xlleno = 1;
        this.JBTGrabar.setEnabled(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Text1", "Text2", "Cod_Simple", "Fecha", "Info_Anal", "Id", "PDA_Inf", "Res", "WBC", "RBC", "HGB", "HCT", "MCV", "MCH", "MCHC", "PLT", "LYM%", "MXD%", "NEUT%", "LYM#", "MXD#", "NEUT#", "RDW-SD#", "RDW-CV#", "Validado", "Grabado", "S"}) { // from class: Laboratorio.JIFImportacion.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosTabla.setModel(this.xmodelo);
        this.JTBDatosTabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTBDatosTabla.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTBDatosTabla.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDatosTabla.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(13).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(14).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(15).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(16).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(17).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(18).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(19).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(20).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(21).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(22).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(23).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(24).setPreferredWidth(10);
        this.JTBDatosTabla.getColumnModel().getColumn(25).setPreferredWidth(10);
        this.JTBDatosTabla.getColumnModel().getColumn(26).setPreferredWidth(10);
        this.filaGrid = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Nº", "Fecha", "Nombre", "HCT", "HGB", "RBC", "MCV", "MCH", "MCHC", "WBC", "PLT", "MPV", "PDW", "PCT", "Validado", "Grabado"}) { // from class: Laboratorio.JIFImportacion.2
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosTabla.setModel(this.xmodelo);
        this.JTBDatosTabla.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBDatosTabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDatosTabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDatosTabla.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(13).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(14).setPreferredWidth(20);
        this.JTBDatosTabla.getColumnModel().getColumn(15).setPreferredWidth(20);
        this.filaGrid = 0;
    }

    private void mCargarDatos() {
        try {
            f27com.close();
            String[] xdato1 = xdatosrecibidos.split("D");
            for (String str : xdato1) {
                System.out.println("Datos split " + str);
            }
            mCrearTabla1();
            for (int i = 1; i < xdato1.length; i++) {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt("D", this.filaGrid, 0);
                this.xmodelo.setValueAt(xdato1[i].toString().substring(0, 1), this.filaGrid, 1);
                this.xmodelo.setValueAt(xdato1[i].toString().substring(1, 2), this.filaGrid, 2);
                this.xmodelo.setValueAt(xdato1[i].toString().substring(2, 11), this.filaGrid, 3);
                this.xmodelo.setValueAt(Long.valueOf(xdato1[i].toString().substring(16, 26).trim()), this.filaGrid, 5);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(33, 39)).doubleValue() / 1000.0d), this.filaGrid, 8);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(39, 44)).doubleValue() / 10000.0d), this.filaGrid, 9);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(44, 49)).doubleValue() / 1000.0d), this.filaGrid, 10);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(49, 54)).doubleValue() / 1000.0d), this.filaGrid, 11);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(54, 59)).doubleValue() / 1000.0d), this.filaGrid, 12);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(59, 64)).doubleValue() / 1000.0d), this.filaGrid, 13);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(64, 69)).doubleValue() / 1000.0d), this.filaGrid, 14);
                this.xmodelo.setValueAt(Long.valueOf(Long.valueOf(xdato1[i].toString().substring(69, 74)).longValue() / 100), this.filaGrid, 15);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(74, 79)).doubleValue() / 1000.0d), this.filaGrid, 16);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(79, 84)).doubleValue() / 1000.0d), this.filaGrid, 17);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(84, 89)).doubleValue() / 1000.0d), this.filaGrid, 18);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(89, 94)).doubleValue() / 1000.0d), this.filaGrid, 19);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(94, 99)).doubleValue() / 1000.0d), this.filaGrid, 20);
                this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(xdato1[i].toString().substring(99, 104)).doubleValue() / 1000.0d), this.filaGrid, 21);
                this.xmodelo.setValueAt(false, this.filaGrid, 24);
                this.xmodelo.setValueAt(false, this.filaGrid, 25);
                this.xmodelo.setValueAt(true, this.filaGrid, 26);
                System.out.println(xdato1[i].toString().substring(104, 109));
                this.filaGrid++;
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos1() {
        try {
            System.out.println(" TVector : " + xvector.size());
            for (int x = 0; x < xvector.size(); x++) {
                System.out.println(" DVector : " + xvector.get(x));
                StringTokenizer tokens = new StringTokenizer(xvector.get(x).toString(), ",");
                System.out.println(tokens.countTokens());
                int xcolumna = tokens.countTokens();
                String[][] xdatos = new String[xcolumna][1];
                int i = 0;
                this.xmodelo.addRow(this.dato);
                while (tokens.hasMoreElements()) {
                    String str = tokens.nextToken();
                    System.out.println(str);
                    xdatos[i][0] = str;
                    this.xmodelo.setValueAt(xdatos[1][0], this.filaGrid, 0);
                    this.xmodelo.setValueAt(xdatos[2][0], this.filaGrid, 1);
                    this.xmodelo.setValueAt(xdatos[4][0], this.filaGrid, 2);
                    for (int y = 2; y < 14; y++) {
                        if (this.JTBDatosTabla.getColumnName(y).equals(str)) {
                            this.xmodelo.setValueAt(Double.valueOf(tokens.nextToken()), this.filaGrid, y);
                        }
                    }
                    i++;
                }
                this.filaGrid++;
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        String xv1;
        String xv2;
        String xv12;
        String xv22;
        int xalterado;
        if (this.xvalidado) {
            for (int x = 0; x < this.JTBDatosTabla.getRowCount(); x++) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 24).toString()).booleanValue() && Boolean.valueOf(this.xmodelo.getValueAt(x, 25).toString()).booleanValue()) {
                        ConsultasMySQL xmt = new ConsultasMySQL();
                        this.sql = "SELECT l_resultados.Id FROM l_detalleresultado INNER JOIN l_resultados  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) WHERE (l_resultados.Id_Recepcion ='" + this.xmodelo.getValueAt(x, 5).toString() + "'   AND l_protocoloxprocedimiento.Id_Procedim =902210) GROUP BY l_resultados.Id ";
                        ResultSet rs = xmt.traerRs(this.sql);
                        try {
                            if (!rs.next()) {
                                this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, Id_Especialidad, fecha, UsuarioS) VALUES('" + this.xmodelo.getValueAt(x, 5).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                mActualizarEstadoProcedimiento(this.xmodelo.getValueAt(x, 5).toString());
                                String noResult = this.consultas.ejecutarSQLId(this.sql);
                                this.consultas.cerrarConexionBd();
                                String xsql = "SELECT persona.Edad, persona.IdSexo FROM persona INNER JOIN l_recepcion  ON (persona.Id_persona = l_recepcion.Id_Paciente)   WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 5).toString() + "')";
                                ResultSet xrs = this.consultas.traerRs(xsql);
                                int xedad = 0;
                                String xsexo = "";
                                try {
                                    if (xrs.next()) {
                                        xrs.first();
                                        xedad = xrs.getInt(1);
                                        xsexo = xrs.getString(2);
                                    }
                                    xrs.close();
                                    this.consultas.cerrarConexionBd();
                                    String xsql2 = "SELECT l_protocoloxprocedimiento.Id, l_protocolos.Nbre, l_protocolos.Abreviatura, `l_protocolos`.`VrMinM`, `l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMaxF` FROM l_protocoloxprocedimiento INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_protocoloxprocedimiento.Id_Procedim =902210 AND l_protocolos.EdadIni <='" + xedad + "' AND l_protocolos.EdadFin >='" + xedad + "') ";
                                    ResultSet xrs1 = this.consultas.traerRs(xsql2);
                                    if (xrs1.next()) {
                                        xrs1.beforeFirst();
                                        while (xrs1.next()) {
                                            int y = 0;
                                            while (true) {
                                                if (y <= 23) {
                                                    System.out.println("Columna " + this.JTBDatosTabla.getColumnName(y));
                                                    System.out.println("Consulta " + xrs1.getString(3));
                                                    if (!xrs1.getString(3).equals(this.JTBDatosTabla.getColumnName(y))) {
                                                        y++;
                                                    } else {
                                                        if (xsexo.equals("M")) {
                                                            xv12 = xrs1.getString(4);
                                                            xv22 = xrs1.getString(5);
                                                        } else {
                                                            xv12 = xrs1.getString(6);
                                                            xv22 = xrs1.getString(7);
                                                        }
                                                        if (Double.valueOf(this.xmodelo.getValueAt(x, y).toString()).doubleValue() < Double.valueOf(xv12).doubleValue() || Double.valueOf(this.xmodelo.getValueAt(x, y).toString()).doubleValue() > Double.valueOf(xv22).doubleValue()) {
                                                            xalterado = 1;
                                                        } else {
                                                            xalterado = 0;
                                                        }
                                                        ConsultasMySQL xmt1 = new ConsultasMySQL();
                                                        this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, IdProfesionalV, IdEspecialidadV, Id_ProtocolProcedim, Id_Procedimiento, Resultado, VrNumerico, Alterado,  VReferencia1, VReferencia2)  VALUES('" + noResult + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + xrs1.getInt(1) + "','902210','82','" + this.xmodelo.getValueAt(x, y).toString() + "','" + xalterado + "','" + xv12 + "','" + xv22 + "')";
                                                        System.out.println(this.xmodelo.getValueAt(x, y).toString());
                                                        xmt1.ejecutarSQL(this.sql);
                                                        xmt1.cerrarConexionBd();
                                                        String xsql3 = "update l_detallerecepcion set `Alterado`=" + xalterado + ", `Resultado`=1  , `FechaResultado`='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' WHERE (`Id_Recepcion` ='" + this.xmodelo.getValueAt(x, 5).toString() + "' AND `Id_Procedim`=902210 and `Alterado`<>1)";
                                                        System.out.println("Actualizar  l_detallerecepcion : " + xsql3);
                                                        xmt1.ejecutarSQL(xsql3);
                                                        xmt1.cerrarConexionBd();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    xrs1.close();
                                    this.consultas.cerrarConexionBd();
                                } catch (SQLException ex) {
                                    Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                }
                            }
                            rs.close();
                            xmt.cerrarConexionBd();
                        } catch (SQLException ex2) {
                            Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                        this.JBTGrabar.setEnabled(false);
                    }
                } else if (Boolean.valueOf(this.xmodelo.getValueAt(x, 14).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                    ConsultasMySQL xmt2 = new ConsultasMySQL();
                    this.sql = "SELECT l_resultados.Id FROM l_detalleresultado INNER JOIN l_resultados  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) WHERE (l_resultados.Id_Recepcion ='" + this.xmodelo.getValueAt(x, 0).toString() + "'   AND l_protocoloxprocedimiento.Id_Procedim =902210) GROUP BY l_resultados.Id ";
                    ResultSet rs2 = xmt2.traerRs(this.sql);
                    try {
                        if (!rs2.next()) {
                            this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, fecha, UsuarioS) VALUES('" + this.xmodelo.getValueAt(x, 0).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            mActualizarEstadoProcedimiento(this.xmodelo.getValueAt(x, 0).toString());
                            String noResult2 = this.consultas.ejecutarSQLId(this.sql);
                            String xsql4 = "SELECT persona.Edad, persona.IdSexo FROM persona INNER JOIN l_recepcion  ON (persona.Id_persona = l_recepcion.Id_Paciente)   WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 0).toString() + "')";
                            ResultSet xrs2 = this.consultas.traerRs(xsql4);
                            int xedad2 = 0;
                            String xsexo2 = "";
                            try {
                                if (xrs2.next()) {
                                    xrs2.first();
                                    xedad2 = xrs2.getInt(1);
                                    xsexo2 = xrs2.getString(2);
                                }
                                xrs2.close();
                                this.consultas.cerrarConexionBd();
                                String xsql5 = "SELECT l_protocoloxprocedimiento.Id, l_protocolos.Nbre, l_protocolos.Abreviatura, `l_protocolos`.`VrMinM`, `l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMaxF` FROM l_protocoloxprocedimiento INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_protocoloxprocedimiento.Id_Procedim =902210 AND l_protocolos.EdadIni <='" + xedad2 + "' AND l_protocolos.EdadFin >='" + xedad2 + "') ";
                                ResultSet xrs12 = this.consultas.traerRs(xsql5);
                                if (xrs12.next()) {
                                    xrs12.beforeFirst();
                                    while (xrs12.next()) {
                                        int y2 = 0;
                                        while (true) {
                                            if (y2 <= 13) {
                                                System.out.println("Columna " + this.JTBDatosTabla.getColumnName(y2));
                                                System.out.println("Consulta " + xrs12.getString(3));
                                                if (!xrs12.getString(3).equals(this.JTBDatosTabla.getColumnName(y2))) {
                                                    y2++;
                                                } else {
                                                    if (xsexo2.equals("M")) {
                                                        xv1 = xrs12.getString(4);
                                                        xv2 = xrs12.getString(5);
                                                    } else {
                                                        xv1 = xrs12.getString(6);
                                                        xv2 = xrs12.getString(7);
                                                    }
                                                    ConsultasMySQL xmt12 = new ConsultasMySQL();
                                                    this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_ProtocolProcedim, Resultado, VrNumerico, VReferencia1, VReferencia2)  VALUES('" + noResult2 + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + xrs12.getInt(1) + "','82','" + this.xmodelo.getValueAt(x, y2).toString() + "','" + xv1 + "','" + xv2 + "')";
                                                    System.out.println(this.xmodelo.getValueAt(x, y2).toString());
                                                    xmt12.ejecutarSQL(this.sql);
                                                    xmt12.cerrarConexionBd();
                                                }
                                            }
                                        }
                                    }
                                }
                                xrs12.close();
                                this.consultas.cerrarConexionBd();
                            } catch (SQLException ex3) {
                                Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                            }
                        }
                        rs2.close();
                        xmt2.cerrarConexionBd();
                    } catch (SQLException ex4) {
                        Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                    }
                }
            }
        }
    }

    private void mGrabar1() {
        String xv1;
        String xv2;
        if (this.xvalidado) {
            for (int x = 0; x < this.JTBDatosTabla.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 14).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                    ConsultasMySQL xmt = new ConsultasMySQL();
                    this.sql = "SELECT l_resultados.Id FROM l_detalleresultado INNER JOIN l_resultados  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) WHERE (l_resultados.Id_Recepcion ='" + this.xmodelo.getValueAt(x, 0).toString() + "'   AND l_protocoloxprocedimiento.Id_Procedim =902210) GROUP BY l_resultados.Id ";
                    ResultSet rs = xmt.traerRs(this.sql);
                    try {
                        if (!rs.next()) {
                            this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, Id_Especialidad, fecha, UsuarioS) VALUES('" + this.xmodelo.getValueAt(x, 0).toString() + "','" + this.xmodelo.getValueAt(x, 1).toString() + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            mActualizarEstadoProcedimiento(this.xmodelo.getValueAt(x, 5).toString());
                            String noResult = this.consultas.ejecutarSQLId(this.sql);
                            String xsql = "SELECT persona.Edad, persona.IdSexo FROM persona INNER JOIN l_recepcion  ON (persona.Id_persona = l_recepcion.Id_Paciente)   WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 0).toString() + "')";
                            ResultSet xrs = this.consultas.traerRs(xsql);
                            int xedad = 0;
                            String xsexo = "";
                            try {
                                if (xrs.next()) {
                                    xrs.first();
                                    xedad = xrs.getInt(1);
                                    xsexo = xrs.getString(2);
                                }
                                xrs.close();
                                this.consultas.cerrarConexionBd();
                                String xsql2 = "SELECT l_protocoloxprocedimiento.Id, l_protocolos.Nbre, l_protocolos.Abreviatura, `l_protocolos`.`VrMinM`, `l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMaxF` FROM l_protocoloxprocedimiento INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_protocoloxprocedimiento.Id_Procedim =902210 AND l_protocolos.EdadIni <='" + xedad + "' AND l_protocolos.EdadFin >='" + xedad + "') ";
                                ResultSet xrs1 = this.consultas.traerRs(xsql2);
                                if (xrs1.next()) {
                                    xrs1.beforeFirst();
                                    while (xrs1.next()) {
                                        int y = 0;
                                        while (true) {
                                            if (y <= 13) {
                                                System.out.println("Columna " + this.JTBDatosTabla.getColumnName(y));
                                                System.out.println("Consulta " + xrs1.getString(3));
                                                if (!xrs1.getString(3).equals(this.JTBDatosTabla.getColumnName(y))) {
                                                    y++;
                                                } else {
                                                    if (xsexo.equals("M")) {
                                                        xv1 = xrs1.getString(4);
                                                        xv2 = xrs1.getString(5);
                                                    } else {
                                                        xv1 = xrs1.getString(6);
                                                        xv2 = xrs1.getString(7);
                                                    }
                                                    ConsultasMySQL xmt1 = new ConsultasMySQL();
                                                    this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, Id_ProtocolProcedim, Resultado, VrNumerico, VReferencia1, VReferencia2)  VALUES('" + noResult + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + xrs1.getInt(1) + "','82','" + this.xmodelo.getValueAt(x, y).toString() + "','" + xv1 + "','" + xv2 + "')";
                                                    System.out.println(this.xmodelo.getValueAt(x, y).toString());
                                                    xmt1.ejecutarSQL(this.sql);
                                                    xmt1.cerrarConexionBd();
                                                }
                                            }
                                        }
                                    }
                                }
                                xrs1.close();
                                this.consultas.cerrarConexionBd();
                            } catch (SQLException ex) {
                                Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                            }
                        }
                        rs.close();
                        xmt.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JIFImportacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                }
            }
        }
    }

    private void mActualizarEstadoProcedimiento(String xid) {
        ConsultasMySQL xct = new ConsultasMySQL();
        String xsql = "update l_detallerecepcion set Resultado=1  where Id_Recepcion='" + xid + "' and Id_Procedim=902210";
        xct.ejecutarSQL(xsql);
        xct.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacion$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int atendido = Integer.parseInt(table.getValueAt(row, 6).toString());
            if (atendido == 0) {
                cell.setBackground(new Color(0, 0, 102));
            } else if (atendido == 1) {
                cell.setBackground(new Color(103, 0, 103));
            }
            cell.setForeground(Color.WHITE);
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JSPDatosTabla = new JScrollPane();
        this.JTBDatosTabla = new JTable();
        this.JBTGenerar2 = new JButton();
        this.JBTEscuchar = new JButton();
        this.JBTGrabar = new JButton();
        this.JBTValidar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("IMPORTACIÓN DE RESULTADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1141, 583));
        setName("Importacion");
        this.JSPDatosTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosTabla.setAutoscrolls(true);
        this.JTBDatosTabla.setFont(new Font("Arial", 1, 12));
        this.JTBDatosTabla.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosTabla.setAutoResizeMode(4);
        this.JTBDatosTabla.setRowHeight(25);
        this.JTBDatosTabla.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosTabla.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosTabla.setSelectionMode(0);
        this.JTBDatosTabla.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFImportacion.3
            public void mouseClicked(MouseEvent evt) {
                JIFImportacion.this.JTBDatosTablaMouseClicked(evt);
            }
        });
        this.JSPDatosTabla.setViewportView(this.JTBDatosTabla);
        this.JBTGenerar2.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cerrar_puerto.png")));
        this.JBTGenerar2.setText("Cerrar Puerto RS232");
        this.JBTGenerar2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacion.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportacion.this.JBTGenerar2ActionPerformed(evt);
            }
        });
        this.JBTEscuchar.setFont(new Font("Arial", 1, 12));
        this.JBTEscuchar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/abrir_puerto.png")));
        this.JBTEscuchar.setText("Abrir Puerto RS232");
        this.JBTEscuchar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacion.5
            public void actionPerformed(ActionEvent evt) {
                JIFImportacion.this.JBTEscucharActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.setEnabled(false);
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacion.6
            public void actionPerformed(ActionEvent evt) {
                JIFImportacion.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTValidar.setFont(new Font("Arial", 1, 12));
        this.JBTValidar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidar.setText("Validar");
        this.JBTValidar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacion.7
            public void actionPerformed(ActionEvent evt) {
                JIFImportacion.this.JBTValidarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JBTEscuchar, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar2, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTValidar, -2, 250, -2).addGap(10, 10, 10).addComponent(this.JBTGrabar, -2, 250, -2)).addComponent(this.JSPDatosTabla, -2, 1024, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosTabla, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTValidar, -1, -1, 32767).addComponent(this.JBTGenerar2, -1, -1, 32767).addComponent(this.JBTEscuchar, -1, -1, 32767).addComponent(this.JBTGrabar, -1, -1, 32767)).addContainerGap()));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosTablaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerar2ActionPerformed(ActionEvent evt) {
        xestado = false;
        this.xhilo.stop();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            mCargarDatos();
        } else {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEscucharActionPerformed(ActionEvent evt) {
        xestado = true;
        iniciarHilo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidarActionPerformed(ActionEvent evt) {
        if (this.JTBDatosTabla.getRowCount() != -1) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                for (int x = 0; x < this.JTBDatosTabla.getRowCount(); x++) {
                    this.sql = "SELECT l_recepcion.Id FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 5) + "' AND l_detallerecepcion.Id_Procedim=902210) ";
                    ResultSet xrs = this.consultas.traerRs(this.sql);
                    try {
                        if (xrs.next()) {
                            this.xmodelo.setValueAt(true, x, 24);
                            ConsultasMySQL xct = new ConsultasMySQL();
                            this.sql = "SELECT `l_resultados`.`Id_Recepcion` FROM  `l_detalleresultado` INNER JOIN  `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_resultados`.`Id_Recepcion` ='" + xrs.getString(1) + "' AND `l_protocolos`.`Abreviatura` ='HCT' AND `l_protocoloxprocedimiento`.`Id_Procedim` =902210) GROUP BY `l_protocoloxprocedimiento`.`Id` ";
                            ResultSet rs = xct.traerRs(this.sql);
                            if (!rs.next()) {
                                this.xmodelo.setValueAt(true, x, 25);
                            } else {
                                this.xmodelo.setValueAt(false, x, 25);
                            }
                            rs.close();
                            xct.cerrarConexionBd();
                        } else {
                            this.xmodelo.setValueAt(false, x, 24);
                        }
                        xrs.close();
                        this.consultas.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFImportacionCombilyzer13.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
                this.xvalidado = true;
                this.JBTGrabar.setEnabled(true);
                return;
            }
            for (int x2 = 0; x2 < this.JTBDatosTabla.getRowCount(); x2++) {
                this.sql = "SELECT l_recepcion.Id FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x2, 0) + "' AND l_detallerecepcion.Id_Procedim=902210) ";
                ResultSet xrs2 = this.consultas.traerRs(this.sql);
                try {
                    if (xrs2.next()) {
                        this.xmodelo.setValueAt(true, x2, 14);
                        ConsultasMySQL xct2 = new ConsultasMySQL();
                        this.sql = "SELECT `l_resultados`.`Id_Recepcion` FROM  `l_detalleresultado` INNER JOIN  `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_resultados`.`Id_Recepcion` ='" + xrs2.getString(1) + "' AND `l_protocolos`.`Abreviatura` ='HCT' AND `l_protocoloxprocedimiento`.`Id_Procedim` =902210) GROUP BY `l_protocoloxprocedimiento`.`Id` ";
                        ResultSet rs2 = xct2.traerRs(this.sql);
                        if (rs2.next()) {
                            this.xmodelo.setValueAt(true, x2, 15);
                        } else {
                            this.xmodelo.setValueAt(false, x2, 15);
                        }
                        rs2.close();
                        xct2.cerrarConexionBd();
                    } else {
                        this.xmodelo.setValueAt(false, x2, 14);
                    }
                    xrs2.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFImportacionCombilyzer13.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
            this.xvalidado = true;
            this.JBTGrabar.setEnabled(true);
        }
    }

    public static void mAbirPuerto() {
        try {
            xvector = new Vector();
            portsFree = serialPort.getFreeSerialPort();
            if (portsFree != null && portsFree.size() > 0) {
                for (String free : portsFree) {
                    System.out.println("Free port: " + free);
                }
                Parameters parameters = new Parameters();
                parameters.setPort(portsFree.get(0));
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    parameters.setBaudRate(Baud._9600);
                } else {
                    parameters.setBaudRate(Baud._9600);
                }
                System.out.println("Open port: " + portsFree.get(0));
                f27com = new Com(parameters);
                System.out.println("<Send Data>");
                String recibido = "";
                String caracter = "";
                while (true) {
                    if ((recibido.equals(" ") || recibido.equals("\n")) && !recibido.equals("TRANSFER FINISHW")) {
                        break;
                    }
                    System.out.println(caracter);
                    caracter = f27com.receiveSingleString();
                    recibido = recibido + caracter;
                    xdatosrecibidos = recibido;
                    System.out.println(recibido);
                }
                f27com.close();
            } else {
                System.out.println("No Free ports!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void iniciarHilo() {
        if (this.xClaseHilo == null) {
            this.xClaseHilo = new AbrirPuertos(this);
        }
        if (this.xhilo == null) {
            this.xhilo = new Thread(this.xClaseHilo);
        }
        this.xhilo.start();
    }
}
