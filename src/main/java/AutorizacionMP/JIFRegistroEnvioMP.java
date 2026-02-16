package AutorizacionMP;

import Acceso.Principal;
import ParametrizacionN.JIFFEmpresaServicios;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFRegistroEnvioMP.class */
public class JIFRegistroEnvioMP extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private File xfile;
    private ButtonGroup JBGOpciones;
    public JDateChooser JDCFechaEnvio;
    public JDateChooser JDCFechaF;
    public JDateChooser JDCFechaI;
    private JPanel JPIFDatosConsulta;
    private JPanel JPIFDatosEnvio;
    private JRadioButton JRBEnviada;
    private JRadioButton JRBNoEnviada;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTable JTDetalle;
    public JTextPane JTPObservacion;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 0;

    public JIFRegistroEnvioMP() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosConsulta = new JPanel();
        this.JDCFechaI = new JDateChooser();
        this.JDCFechaF = new JDateChooser();
        this.JRBEnviada = new JRadioButton();
        this.JRBNoEnviada = new JRadioButton();
        this.JPIFDatosEnvio = new JPanel();
        this.JDCFechaEnvio = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setTitle("REGISTRO DE ENVIÓ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifregistroenvio");
        addInternalFrameListener(new InternalFrameListener() { // from class: AutorizacionMP.JIFRegistroEnvioMP.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroEnvioMP.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.JBGOpciones.add(this.JRBEnviada);
        this.JRBEnviada.setFont(new Font("Arial", 1, 12));
        this.JRBEnviada.setText("Enviadas");
        this.JRBEnviada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFRegistroEnvioMP.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroEnvioMP.this.JRBEnviadaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBNoEnviada);
        this.JRBNoEnviada.setFont(new Font("Arial", 1, 12));
        this.JRBNoEnviada.setSelected(true);
        this.JRBNoEnviada.setText("No Enviadas");
        this.JRBNoEnviada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFRegistroEnvioMP.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroEnvioMP.this.JRBNoEnviadaActionPerformed(evt);
            }
        });
        GroupLayout JPIFDatosConsultaLayout = new GroupLayout(this.JPIFDatosConsulta);
        this.JPIFDatosConsulta.setLayout(JPIFDatosConsultaLayout);
        JPIFDatosConsultaLayout.setHorizontalGroup(JPIFDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosConsultaLayout.createSequentialGroup().addComponent(this.JRBEnviada).addGap(18, 18, 18).addComponent(this.JRBNoEnviada)).addGroup(JPIFDatosConsultaLayout.createSequentialGroup().addComponent(this.JDCFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JDCFechaF, -2, 120, -2))).addContainerGap(-1, 32767)));
        JPIFDatosConsultaLayout.setVerticalGroup(JPIFDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFDatosConsultaLayout.createSequentialGroup().addGroup(JPIFDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaI, -2, 50, -2).addComponent(this.JDCFechaF, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIFDatosConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnviada).addComponent(this.JRBNoEnviada))));
        this.JPIFDatosEnvio.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE ENVIÓ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaEnvio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Envió", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaEnvio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaEnvio.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPIFDatosEnvioLayout = new GroupLayout(this.JPIFDatosEnvio);
        this.JPIFDatosEnvio.setLayout(JPIFDatosEnvioLayout);
        JPIFDatosEnvioLayout.setHorizontalGroup(JPIFDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosEnvioLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaEnvio, -2, 113, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion, -1, 513, 32767).addContainerGap()));
        JPIFDatosEnvioLayout.setVerticalGroup(JPIFDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDatosEnvioLayout.createSequentialGroup().addGroup(JPIFDatosEnvioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaEnvio, -2, -1, -2).addComponent(this.JSPObservacion, -2, 76, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFRegistroEnvioMP.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroEnvioMP.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 972, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JPIFDatosConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFDatosEnvio, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFDatosConsulta, -1, -1, 32767).addComponent(this.JPIFDatosEnvio, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 286, -2).addContainerGap(15, 32767)));
        getAccessibleContext().setAccessibleName("usuario");
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            Object[] botones = {"Etiqueta", "Formula", "Guia", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mImprimir();
                return;
            }
            if (n == 1) {
                mImprimir(1);
                String sql = "update h_ordenes set EstaEntregada=1 where Id='" + Principal.txtNo.getText() + "'";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            if (n == 2 && !this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).equals("")) {
                this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                return;
            }
            return;
        }
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTPObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnviadaActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoEnviadaActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mBuscar();
    }

    /* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFRegistroEnvioMP$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String dias_v = table.getValueAt(row, 11).toString();
            if (dias_v != null && dias_v.equals("0")) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JDCFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaF.setDate(this.xmetodos.getFechaActual());
        this.JDCFechaEnvio.setDate(this.xmetodos.getFechaActual());
        this.JTPObservacion.setText("");
        mCrearModeloDatos();
    }

    public void mGrabar() {
        if (this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString().equals("false")) {
            if (!Principal.txtNo.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "VERIFICAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "update d_programaenviomedicamentos set EstadoE=1, FechaEnvio='" + this.xmetodos.formatoAMD.format(this.JDCFechaEnvio.getDate()) + "', Observacion='" + this.JTPObservacion.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' where N_OrdenHc='" + Principal.txtNo.getText() + "'";
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Fecha Esti. Envío", "Días Rest.", "NÂ° HC", "Usuario", "Estado", "Fecha Envio", "Url Soporte", "ObservaciÃ³n", "Estado", "color"}) { // from class: AutorizacionMP.JIFRegistroEnvioMP.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT d_programaenviomedicamentos.N_OrdenHc,DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS Fecha ,DATE_FORMAT(DATE_ADD(h_ordenes.FechaOrden, INTERVAL(-8) DAY),'%d-%m-%Y') AS Fec_estimada,IF(DATEDIFF(h_ordenes.FechaOrden,NOW())<=0,'VENCIDO',DATEDIFF(h_ordenes.FechaOrden,NOW())) AS Diasr, persona.NoHistoria , persona.NUsuario , d_programaenviomedicamentos.EstadoE , d_programaenviomedicamentos.FechaEnvio , d_programaenviomedicamentos.UrlGuia , IF (d_programaenviomedicamentos.Observacion IS NULL,'',d_programaenviomedicamentos.Observacion) AS Observacion, IF(h_ordenes.EstaEntregada=0, 'NO ENTREGADA', IF(h_ordenes.EstaEntregada=1, 'IMPRESA','DESPACHADA' )) AS Estado, IF(h_ordenes.UrlGuiaEnvio='','',h_ordenes.UrlGuiaEnvio) AS Url, IF(DATEDIFF(h_ordenes.FechaOrden,NOW())<=8,0,1) AS Color FROM d_programaenviomedicamentos INNER JOIN h_ordenes  ON (d_programaenviomedicamentos.N_OrdenHc = h_ordenes.Id) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona) WHERE (h_ordenes.FechaOrden >='" + this.xmetodos.formatoAMD.format(this.JDCFechaI.getDate()) + "'  AND h_ordenes.FechaOrden <='" + this.xmetodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND d_programaenviomedicamentos.Estado=1 AND d_programaenviomedicamentos.EstadoE='" + this.xestado + "' AND h_ordenes.Estado=0 ) ORDER BY persona.NUsuario ASC, h_ordenes.FechaOrden ASC ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(13)), n, 11);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaServicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "id";
        mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
        mparametros[1][0] = "nbreUsuario";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "I_EtiquetaEnvioMP", mparametros);
    }

    private void mImprimir(int n) {
        try {
            String xnotasad = null;
            String tipo = "Farmacia";
            String sql = "SELECT Id_Atencion, Id, Date_Format(FechaOrden,'%d-%m-%Y') as Fecha FROM baseserver.h_ordenes where Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
            ConsultasMySQL xmt = new ConsultasMySQL();
            ResultSet rsm = xmt.traerRs(sql);
            rsm.first();
            long xida = rsm.getLong(1);
            if (rsm.getRow() != 0) {
                String sql2 = "SELECT Id_Atencion, Id, Date_Format(FechaOrden,'%d-%m-%Y') as Fecha FROM  baseserver.h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "' order by Id";
                rsm = this.xconsultas.traerRs(sql2);
                rsm.next();
                if (rsm.getRow() != 0) {
                    xnotasad = "Orden NÂ° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + rsm.getString(3);
                }
                this.xconsultas.cerrarConexionBd();
            }
            rsm.close();
            xmt.cerrarConexionBd();
            String[][] mparametros = new String[6][2];
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                mparametros[1][0] = "xp2";
                mparametros[1][1] = tipo;
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "RFormulaGeneralMP", mparametros);
                tipo = "Usuario";
            }
        } catch (SQLException e) {
        }
    }
}
