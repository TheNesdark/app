package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPCertificado.class */
public class JPCertificado extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] dato;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private String[] xidtiposervicio;
    private String[][] xidtipoempresa;
    private boolean xestado;
    private JIFGenerarCertificado xjifgeneracion;
    private String xfrmllamador;
    public JButton JBTGuardarTemp;
    private JComboBox JCBServicio;
    private JComboBox JCBTipoEmpresa;
    private JDateChooser JDCFecha;
    private JPanel JPIMotivoConsulta;
    private JScrollPane JSPDetalleNotas;
    private JScrollPane JSPNotas;
    private JTable JTBDetalle;
    private JFormattedTextField JTFFHora;
    public JTextField JTFNombrePart;
    public JTextPane JTPNota;

    public JPCertificado(JInternalFrame nbreFrm) {
        this.xestado = false;
        initComponents();
        realizarcasting(nbreFrm);
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setText(this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()));
        this.xidtipoempresa = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, ExigeNit FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresa, 3);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.xidtiposervicio = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM f_centrocosto WHERE (servicio =0) ORDER BY Nbre ASC", this.xidtiposervicio, this.JCBServicio);
        this.JCBServicio.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        this.xestado = true;
    }

    private void initComponents() {
        this.JPIMotivoConsulta = new JPanel();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JBTGuardarTemp = new JButton();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JSPDetalleNotas = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBTipoEmpresa = new JComboBox();
        this.JTFNombrePart = new JTextField();
        this.JCBServicio = new JComboBox();
        setName("jpcetificacion");
        setPreferredSize(new Dimension(800, 501));
        this.JPIMotivoConsulta.setBorder(BorderFactory.createEtchedBorder(0, Color.white, (Color) null));
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JBTGuardarTemp.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardarTemp.setText("Guardar");
        this.JBTGuardarTemp.addActionListener(new ActionListener() { // from class: Historia.JPCertificado.1
            public void actionPerformed(ActionEvent evt) {
                JPCertificado.this.JBTGuardarTempActionPerformed(evt);
            }
        });
        this.JBTGuardarTemp.addKeyListener(new KeyAdapter() { // from class: Historia.JPCertificado.2
            public void keyPressed(KeyEvent evt) {
                JPCertificado.this.JBTGuardarTempKeyPressed(evt);
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPCertificado.3
            public void mouseClicked(MouseEvent evt) {
                JPCertificado.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleNotas.setViewportView(this.JTBDetalle);
        this.JCBTipoEmpresa.setEditable(true);
        this.JCBTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEmpresa.addItemListener(new ItemListener() { // from class: Historia.JPCertificado.4
            public void itemStateChanged(ItemEvent evt) {
                JPCertificado.this.JCBTipoEmpresaItemStateChanged(evt);
            }
        });
        this.JTFNombrePart.setFont(new Font("Arial", 1, 12));
        this.JTFNombrePart.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa (Solo para particulares)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombrePart.setEnabled(false);
        this.JCBServicio.setEditable(true);
        this.JCBServicio.setFont(new Font("Arial", 1, 12));
        this.JCBServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIMotivoConsultaLayout = new GroupLayout(this.JPIMotivoConsulta);
        this.JPIMotivoConsulta.setLayout(JPIMotivoConsultaLayout);
        JPIMotivoConsultaLayout.setHorizontalGroup(JPIMotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIMotivoConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPIMotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleNotas, GroupLayout.Alignment.LEADING, -1, 756, 32767).addComponent(this.JSPNotas, GroupLayout.Alignment.LEADING, -1, 756, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIMotivoConsultaLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoEmpresa, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombrePart, -1, 274, 32767)).addComponent(this.JCBServicio, GroupLayout.Alignment.LEADING, -2, 373, -2).addComponent(this.JBTGuardarTemp, GroupLayout.Alignment.LEADING, -1, 756, 32767)).addContainerGap()));
        JPIMotivoConsultaLayout.setVerticalGroup(JPIMotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMotivoConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPIMotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIMotivoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 53, -2).addComponent(this.JCBTipoEmpresa, -2, 55, -2).addComponent(this.JTFNombrePart, -2, 53, -2)).addComponent(this.JDCFecha, -2, 56, -2)).addGap(18, 18, 18).addComponent(this.JCBServicio, -2, 55, -2).addGap(18, 18, 18).addComponent(this.JSPNotas, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleNotas, -2, 125, -2).addGap(18, 18, 18).addComponent(this.JBTGuardarTemp).addContainerGap(31, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIMotivoConsulta, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIMotivoConsulta, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1 && this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0) != null) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            Principal.txtEstado.setText("ACTIVA");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.JCBTipoEmpresa.getSelectedIndex() != -1) {
            if (this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][1].equals("1")) {
                this.JTFNombrePart.setEnabled(false);
            } else {
                this.JTFNombrePart.setEnabled(true);
                this.JTFNombrePart.requestFocus();
            }
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTipoEmpresa.getSelectedIndex() != -1) {
                if (this.JCBServicio.getSelectedIndex() != -1) {
                    String sql = "insert into  h_cetificadoasistencia (FechaP, Hora, Id_Usuario, Id_AtencionH, Id_Empresa, EmpresaP, Id_CentroCosto, Id_Profesional, Id_Especialidad, Observacion, Estado, Fecha, UsuarioS) values ('" + this.xmetodo.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + mTraerIdUduario() + "','0','" + this.xidtipoempresa[this.JCBTipoEmpresa.getSelectedIndex()][0] + "','" + this.JTFNombrePart.getText() + "','" + this.xidtiposervicio[this.JCBServicio.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.JTPNota.getText() + "','1','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
                    this.xconsultasbd.cerrarConexionBd();
                    mCargarDatosTabla(mTraerIdUduario());
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBServicio.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoEmpresa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setText(this.xmetodo.formatoH24.format(this.xmetodo.getFechaActual()));
        this.JCBServicio.setSelectedIndex(-1);
        this.JCBTipoEmpresa.setSelectedIndex(-1);
        this.JTFNombrePart.setText((String) null);
        this.JTPNota.setText((String) null);
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String sql = "update h_cetificadoasistencia set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            Principal.txtEstado.setText("ANULADA");
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            Object[] botones = {"Impresora", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            mparametros[0][0] = "id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (n == 0) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RCertificado_Medico.jasper", mparametros);
                    return;
                } else if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RConstaciaAsistencia_1.jasper", mparametros);
                    return;
                } else {
                    this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RConstaciaAsistencia.jasper", mparametros);
                    return;
                }
            }
            if (n == 1) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RCertificado_Medico", mparametros);
                } else if (Principal.informacionIps.getNombreIps().equals("IPS TERAPIAS Y ESTETICA INTEGRAL SAS")) {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RConstaciaAsistencia_1", mparametros);
                } else {
                    this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RConstaciaAsistencia", mparametros);
                }
            }
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha y Hora", "Servicio", "Especialidad", "Profesional"}) { // from class: Historia.JPCertificado.5
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public void mCargarDatosTabla(String xidusuario) {
        try {
            mCrearTabla();
            String sql = "SELECT h_cetificadoasistencia.Id, DATE_FORMAT(h_cetificadoasistencia.FechaP,'%d-%m-%Y')as Fecha, h_cetificadoasistencia.Hora, f_centrocosto.Nbre, profesional1.Especialidad, profesional1.NProfesional FROM  h_cetificadoasistencia INNER JOIN f_centrocosto  ON (h_cetificadoasistencia.Id_CentroCosto = f_centrocosto.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_cetificadoasistencia.Id_Profesional) AND (profesional1.IdEspecialidad = h_cetificadoasistencia.Id_Especialidad) WHERE (h_cetificadoasistencia.Id_Usuario ='" + xidusuario + "' and h_cetificadoasistencia.Estado=1) ORDER BY h_cetificadoasistencia.FechaP DESC, h_cetificadoasistencia.Hora DESC ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(rs.getString(2) + " " + rs.getString(3), i, 1);
                    this.xmodelo.setValueAt(rs.getString(4), i, 2);
                    this.xmodelo.setValueAt(rs.getString(5), i, 3);
                    this.xmodelo.setValueAt(rs.getString(6), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPCertificado.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("jifconstanciaservicio1")) {
            this.xjifgeneracion = (JIFGenerarCertificado) frm;
            this.xfrmllamador = "jifconstanciaservicio1";
        } else if (frm.getName().equals("jifconstanciaservicio")) {
            this.xjifgeneracion = (JIFGenerarCertificado) frm;
            this.xfrmllamador = "jifconstanciaservicio";
        } else {
            this.xfrmllamador = "";
        }
    }

    private String mTraerIdUduario() {
        String xid = "";
        if (this.xfrmllamador.equals("jifconstanciaservicio1") || this.xfrmllamador.equals("jifconstanciaservicio")) {
            xid = this.xjifgeneracion.xjppersona.getIdPersona();
        }
        return xid;
    }
}
