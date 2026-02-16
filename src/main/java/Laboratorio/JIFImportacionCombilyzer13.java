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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionCombilyzer13.class */
public class JIFImportacionCombilyzer13 extends JInternalFrame {
    private Object[] dato;
    private String sql;
    public DefaultTableModel xmodelo;
    private AbrirPuertos1 xClaseHilo;
    private Thread xhilo;
    private static List<String> portsFree;

    /* JADX INFO: renamed from: com, reason: collision with root package name */
    private static Com f28com;
    private static String xdatosrecibidos;
    private int xtipo;
    private String[] xlistaBact;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private JButton JBTEscuchar;
    private JButton JBTGenerar2;
    private JButton JBTGrabar;
    private JButton JBTValidar;
    private JScrollPane JSPDatosI;
    private JTable JTBDatosI;
    private static SerialPort serialPort = new SerialPort();
    public static boolean xestado = true;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int filaGrid = 0;
    private boolean xvalidado = false;

    public JIFImportacionCombilyzer13(claseLab xclaselab, int xtipo) {
        this.xtipo = 0;
        initComponents();
        mCrearTabla();
        this.xtipo = xtipo;
        this.JBTGrabar.setEnabled(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "N° Orden", "", "", "UBG", "BIL", "KET", "CRE", "BLD", "PRO", "ALB", "NIT", "LEU", "GLU", "SG", "pH", "A:C", "Ok", "Grabar"}) { // from class: Laboratorio.JIFImportacionCombilyzer13.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosI.setModel(this.xmodelo);
        this.JTBDatosI.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDatosI.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDatosI.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBDatosI.getColumnModel().getColumn(4).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(5).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(6).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(7).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(8).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(9).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(10).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(11).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(12).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(13).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(14).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(15).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(16).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(17).setPreferredWidth(25);
        this.JTBDatosI.getColumnModel().getColumn(18).setPreferredWidth(25);
        this.filaGrid = 0;
    }

    private void mCargarDatos() {
        try {
            f28com.close();
            String[] xdato1 = xdatosrecibidos.split("\n");
            for (int i = 1; i < xdato1.length; i = i + 18 + 1) {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(this.metodos.formatoDMA.format(this.metodos.getFechaActual()), this.filaGrid, 0);
                this.xmodelo.setValueAt(xdato1[i + 1].toString().substring(4, xdato1[i + 1].length()).trim(), this.filaGrid, 1);
                this.xmodelo.setValueAt("31", this.filaGrid, 2);
                this.xmodelo.setValueAt("82", this.filaGrid, 3);
                if (this.xtipo == 0) {
                    this.xmodelo.setValueAt(xdato1[i + 3].toString().substring(11, 14).trim(), this.filaGrid, 4);
                } else if (this.xtipo == 1) {
                    this.xmodelo.setValueAt(xdato1[i + 3].toString().substring(12, 16).trim(), this.filaGrid, 4);
                }
                this.xmodelo.setValueAt(xdato1[i + 4].toString().substring(5, xdato1[i + 4].length()).trim(), this.filaGrid, 5);
                this.xmodelo.setValueAt(xdato1[i + 5].toString().substring(5, xdato1[i + 5].length()).trim(), this.filaGrid, 6);
                this.xmodelo.setValueAt(xdato1[i + 6].toString().substring(5, xdato1[i + 6].length()).trim(), this.filaGrid, 8);
                this.xmodelo.setValueAt(xdato1[i + 7].toString().substring(5, xdato1[i + 7].length()).trim(), this.filaGrid, 9);
                this.xmodelo.setValueAt(xdato1[i + 8].toString().substring(5, xdato1[i + 8].length()).trim(), this.filaGrid, 11);
                this.xmodelo.setValueAt(xdato1[i + 9].toString().substring(5, xdato1[i + 9].length()).trim(), this.filaGrid, 12);
                this.xmodelo.setValueAt(xdato1[i + 10].toString().substring(5, xdato1[i + 10].length()).trim(), this.filaGrid, 13);
                this.xmodelo.setValueAt(xdato1[i + 11].toString().substring(5, xdato1[i + 11].length()).trim(), this.filaGrid, 14);
                this.xmodelo.setValueAt(xdato1[i + 12].toString().substring(5, xdato1[i + 12].length()).trim(), this.filaGrid, 15);
                this.xmodelo.setValueAt(xdato1[i + 13].toString().substring(5, xdato1[i + 13].length()).trim(), this.filaGrid, 16);
                this.xmodelo.setValueAt(false, this.filaGrid, 17);
                this.xmodelo.setValueAt(false, this.filaGrid, 18);
                this.filaGrid++;
            }
        } catch (Exception ex) {
            Logger.getLogger(JIFImportacionCombilyzer13.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        String xv1;
        String xv2;
        if (this.xvalidado) {
            for (int x = 0; x < this.JTBDatosI.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 17).toString()).booleanValue() && !Boolean.valueOf(this.xmodelo.getValueAt(x, 18).toString()).booleanValue()) {
                    this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional,Id_Especialidad, fecha, UsuarioS) VALUES('" + this.xmodelo.getValueAt(x, 1).toString() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    String noResult = this.consultas.ejecutarSQLId(this.sql);
                    String xsql = "SELECT persona.Edad, persona.IdSexo FROM persona INNER JOIN l_recepcion  ON (persona.Id_persona = l_recepcion.Id_Paciente)   WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 1).toString() + "')";
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
                        String xsql2 = "SELECT l_protocoloxprocedimiento.Id, l_protocolos.Nbre, l_protocolos.Abreviatura, `l_protocolos`.`VrMinM`, `l_protocolos`.`VrMaxM`, `l_protocolos`.`VrMinF`, `l_protocolos`.`VrMaxF` FROM l_protocoloxprocedimiento INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_protocoloxprocedimiento.Id_Procedim =907106 AND l_protocolos.EdadIni <='" + xedad + "' AND l_protocolos.EdadFin >='" + xedad + "') ";
                        ResultSet xrs1 = this.consultas.traerRs(xsql2);
                        if (xrs1.next()) {
                            xrs1.beforeFirst();
                            while (xrs1.next()) {
                                int y = 0;
                                while (true) {
                                    if (y > 16) {
                                        break;
                                    }
                                    if (y != 7 && y != 10) {
                                        System.out.println("Columna " + this.JTBDatosI.getColumnName(y));
                                        System.out.println("Consulta " + xrs1.getString(3));
                                        if (xrs1.getString(3).equals(this.JTBDatosI.getColumnName(y))) {
                                            if (xsexo.equals("M")) {
                                                xv1 = xrs1.getString(4);
                                                xv2 = xrs1.getString(5);
                                            } else {
                                                xv1 = xrs1.getString(6);
                                                xv2 = xrs1.getString(7);
                                            }
                                            ConsultasMySQL xmt1 = new ConsultasMySQL();
                                            this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo,Id_Especialidad, Id_ProtocolProcedim, Id_Procedimiento, Resultado, VrNumerico, VReferencia1, VReferencia2) VALUES('" + noResult + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + xrs1.getInt(1) + "','907106','82','" + this.xmodelo.getValueAt(x, y).toString() + "','" + xv1 + "','" + xv2 + "')";
                                            System.out.println(this.xmodelo.getValueAt(x, y).toString());
                                            xmt1.ejecutarSQL(this.sql);
                                            xmt1.cerrarConexionBd();
                                        }
                                    }
                                    y++;
                                }
                            }
                        }
                        xrs1.close();
                        this.consultas.cerrarConexionBd();
                        this.xvalidado = false;
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFImportacionCombilyzer13.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Falta proceso de validad de recepción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionCombilyzer13$MiRender.class */
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

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JSPDatosI = new JScrollPane();
        this.JTBDatosI = new JTable();
        this.JBTGenerar2 = new JButton();
        this.JBTEscuchar = new JButton();
        this.JBTGrabar = new JButton();
        this.JBTValidar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("IMPORTACIÓN DE EQUIPO DE ORINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        setName("jifimportacionorina");
        this.JSPDatosI.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A IMPORTAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDatosI.setHorizontalScrollBarPolicy(31);
        this.JSPDatosI.setVerticalScrollBarPolicy(21);
        this.JSPDatosI.setAutoscrolls(true);
        this.JTBDatosI.setFont(new Font("Arial", 1, 12));
        this.JTBDatosI.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosI.setAutoResizeMode(4);
        this.JTBDatosI.setRowHeight(25);
        this.JTBDatosI.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosI.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosI.setSelectionMode(0);
        this.JTBDatosI.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFImportacionCombilyzer13.2
            public void mouseClicked(MouseEvent evt) {
                JIFImportacionCombilyzer13.this.JTBDatosIMouseClicked(evt);
            }
        });
        this.JSPDatosI.setViewportView(this.JTBDatosI);
        this.JBTGenerar2.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/cerrar_puerto.png")));
        this.JBTGenerar2.setText("Cerrar Puerto RS232");
        this.JBTGenerar2.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionCombilyzer13.3
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCombilyzer13.this.JBTGenerar2ActionPerformed(evt);
            }
        });
        this.JBTEscuchar.setFont(new Font("Arial", 1, 12));
        this.JBTEscuchar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/abrir_puerto.png")));
        this.JBTEscuchar.setText("Abrir Puerto RS232");
        this.JBTEscuchar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionCombilyzer13.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCombilyzer13.this.JBTEscucharActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionCombilyzer13.5
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCombilyzer13.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTValidar.setFont(new Font("Arial", 1, 12));
        this.JBTValidar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidar.setText("Validar");
        this.JBTValidar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionCombilyzer13.6
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCombilyzer13.this.JBTValidarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatosI, -1, 1144, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTEscuchar, -2, 270, -2).addGap(18, 18, 18).addComponent(this.JBTGenerar2, -2, 270, -2).addGap(18, 18, 18).addComponent(this.JBTValidar, -2, 270, -2).addGap(19, 19, 19).addComponent(this.JBTGrabar, -2, 270, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosI, -2, 463, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGenerar2, -2, 50, -2).addComponent(this.JBTGrabar, -2, 50, -2).addComponent(this.JBTValidar, -2, 50, -2)).addComponent(this.JBTEscuchar, GroupLayout.Alignment.LEADING, -2, 50, -2)).addGap(23, 23, 23)));
        getAccessibleContext().setAccessibleName("");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosIMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerar2ActionPerformed(ActionEvent evt) {
        xestado = false;
        this.xhilo.stop();
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEscucharActionPerformed(ActionEvent evt) {
        xestado = true;
        iniciarHilo1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidarActionPerformed(ActionEvent evt) {
        if (this.JTBDatosI.getRowCount() != -1) {
            for (int x = 0; x < this.JTBDatosI.getRowCount(); x++) {
                this.sql = "SELECT l_recepcion.Id FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Id ='" + this.xmodelo.getValueAt(x, 1) + "' AND l_detallerecepcion.Id_Procedim=907106) ";
                ResultSet xrs = this.consultas.traerRs(this.sql);
                try {
                    if (xrs.next()) {
                        this.xmodelo.setValueAt(true, x, 17);
                        ConsultasMySQL xct = new ConsultasMySQL();
                        this.sql = "SELECT `l_resultados`.`Id_Recepcion` FROM  `l_detalleresultado` INNER JOIN  `l_resultados`  ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`) INNER JOIN  `l_protocoloxprocedimiento`  ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`) INNER JOIN  `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) WHERE (`l_resultados`.`Id_Recepcion` ='" + xrs.getString(1) + "' AND `l_protocolos`.`Abreviatura` ='Ph' AND `l_protocoloxprocedimiento`.`Id_Procedim` =907106) GROUP BY `l_protocoloxprocedimiento`.`Id` ";
                        ResultSet rs = xct.traerRs(this.sql);
                        if (rs.next()) {
                            this.xmodelo.setValueAt(true, x, 18);
                        } else {
                            this.xmodelo.setValueAt(false, x, 18);
                        }
                        rs.close();
                        xct.cerrarConexionBd();
                    } else {
                        this.xmodelo.setValueAt(false, x, 17);
                    }
                    xrs.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFImportacionCombilyzer13.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
            this.xvalidado = true;
            this.JBTGrabar.setEnabled(true);
        }
    }

    public static void mAbirPuerto() {
        try {
            portsFree = serialPort.getFreeSerialPort();
            if (portsFree != null && portsFree.size() > 0) {
                for (String free : portsFree) {
                    System.out.println("Free port: " + free);
                }
                Parameters parameters = new Parameters();
                parameters.setPort(portsFree.get(0));
                parameters.setBaudRate(Baud._9600);
                System.out.println("Open port: " + portsFree.get(0));
                f28com = new Com(parameters);
                String recibido = "";
                String caracter = "";
                System.out.println("<Send Data>");
                while (!recibido.equals(" ") && !recibido.equals("\n")) {
                    System.out.println(caracter);
                    caracter = f28com.receiveSingleString();
                    recibido = recibido + caracter;
                    xdatosrecibidos = recibido;
                    System.out.println(recibido);
                }
            } else {
                System.out.println("No Free ports!!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void iniciarHilo1() {
        if (this.xClaseHilo == null) {
            this.xClaseHilo = new AbrirPuertos1(this);
        }
        if (this.xhilo == null) {
            this.xhilo = new Thread(this.xClaseHilo);
        }
        this.xhilo.start();
    }
}
