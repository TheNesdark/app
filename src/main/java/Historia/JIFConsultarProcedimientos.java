package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarProcedimientos.class */
public class JIFConsultarProcedimientos extends JInternalFrame {
    private DefaultTableModel xmodeloproc;
    private TableColumn column;
    private Object[] dato;
    private int xestado;
    private clasesHistoriaCE xclase;
    private ConsultasMySQL xconsultasbd;
    private Object[] xdato;
    private Metodos xmetodo;
    private String xNombre;
    private ButtonGroup JBGEstado;
    private JButton JBTCerrar;
    private JPanel JPITipoConsulta;
    private JRadioButton JRBActivas;
    private JRadioButton JRBAnuladas;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;

    public JIFConsultarProcedimientos(clasesHistoriaCE xclase) {
        this.xmodeloproc = new DefaultTableModel();
        this.column = null;
        this.xestado = 0;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xNombre = "";
        initComponents();
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        this.xclase = xclase;
        mCargarDatos();
    }

    public JIFConsultarProcedimientos(clasesHistoriaCE xclase, String xNombre) {
        this.xmodeloproc = new DefaultTableModel();
        this.column = null;
        this.xestado = 0;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xNombre = "";
        initComponents();
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        this.xNombre = xNombre;
        this.xclase = xclase;
        mCargarDatos();
    }

    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JBTCerrar = new JButton();
        this.JPITipoConsulta = new JPanel();
        this.JRBActivas = new JRadioButton();
        this.JRBAnuladas = new JRadioButton();
        setClosable(true);
        setTitle("CONSULTAR AYUDAS DIAGNÓSTICAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFConsultarProcedimientos.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFConsultarProcedimientos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleConsulta.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarProcedimientos.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarProcedimientos.this.JSPDetalleConsultaMouseClicked(evt);
            }
        });
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarProcedimientos.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarProcedimientos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarProcedimientos.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarProcedimientos.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JPITipoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGEstado.add(this.JRBActivas);
        this.JRBActivas.setFont(new Font("Arial", 1, 12));
        this.JRBActivas.setForeground(new Color(0, 0, 255));
        this.JRBActivas.setSelected(true);
        this.JRBActivas.setText("Activas");
        this.JRBActivas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarProcedimientos.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarProcedimientos.this.JRBActivasActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBAnuladas);
        this.JRBAnuladas.setFont(new Font("Arial", 1, 12));
        this.JRBAnuladas.setForeground(new Color(0, 0, 255));
        this.JRBAnuladas.setText("Anuladas");
        this.JRBAnuladas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarProcedimientos.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarProcedimientos.this.JRBAnuladasActionPerformed(evt);
            }
        });
        GroupLayout JPITipoConsultaLayout = new GroupLayout(this.JPITipoConsulta);
        this.JPITipoConsulta.setLayout(JPITipoConsultaLayout);
        JPITipoConsultaLayout.setHorizontalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBActivas).addGap(18, 18, 18).addComponent(this.JRBAnuladas).addContainerGap(-1, 32767)));
        JPITipoConsultaLayout.setVerticalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBActivas).addComponent(this.JRBAnuladas)).addContainerGap(14, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalleConsulta, -1, 824, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addComponent(this.JBTCerrar, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JPITipoConsulta, -2, -1, -2).addGap(28, 28, 28)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleConsulta, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTCerrar, -1, -1, 32767).addComponent(this.JPITipoConsulta, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        try {
            if (this.xclase.xjifhistoriaclinica != null) {
                this.xclase.xjifhistoriaclinica.setSelected(true);
            } else if (this.xclase.historia_Clinica_v2 != null) {
                this.xclase.historia_Clinica_v2.setSelected(true);
            }
            dispose();
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFConsultarProcedimientos.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivasActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladasActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        try {
            if (this.xclase.xjifhistoriaclinica != null) {
                this.xclase.xjifhistoriaclinica.setSelected(true);
            } else if (this.xclase.historia_Clinica_v2 != null) {
                this.xclase.historia_Clinica_v2.setSelected(true);
            }
        } catch (PropertyVetoException e) {
            Logger.getLogger(JIFConsultarProcedimientos.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleConsultaMouseClicked(MouseEvent evt) {
    }

    private void mCrearTablaDetalle() {
        this.xmodeloproc = new DefaultTableModel();
        this.xmodeloproc.addColumn("N Orden");
        this.xmodeloproc.addColumn("Fecha");
        this.xmodeloproc.addColumn("Profesional");
        this.xmodeloproc.addColumn("Estado");
        this.JTBDetalle.setModel(this.xmodeloproc);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(10);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(30);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(400);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(50);
    }

    private void mCargarDatos() {
        mCrearTablaDetalle();
        String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, h_ordenes.Estado, h_ordenes.EstaEntregada, h_atencion.Hora_Atencion FROM  h_ordenes INNER JOIN  h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN  ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)  INNER JOIN  g_profesional  ON (h_ordenes.Id_Profesional = g_profesional.Id_Persona) INNER JOIN  g_persona  ON (g_profesional.Id_Persona = g_persona.Id) WHERE ( h_ordenes.Id_TipoServicio ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdServicio() + "' AND ingreso.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and h_ordenes.Estado='" + this.xestado + "') ORDER BY h_ordenes.FechaOrden DESC, h_atencion.Hora_Atencion DESC ";
        ResultSet xrs = this.xconsultasbd.traerRs(sql);
        try {
            xrs.next();
            if (xrs.getRow() != 0) {
                ResultSet rss = this.xconsultasbd.traerRs(sql);
                int i = 0;
                while (rss.next()) {
                    this.xmodeloproc.addRow(this.dato);
                    this.xmodeloproc.setValueAt(Long.valueOf(rss.getLong(1)), i, 0);
                    this.xmodeloproc.setValueAt(this.xmetodo.formatoDMA.format((Date) rss.getDate(2)), i, 1);
                    this.xmodeloproc.setValueAt(rss.getString(3), i, 2);
                    if (rss.getInt(5) == 1) {
                        this.xmodeloproc.setValueAt("Impresa", i, 3);
                    } else {
                        this.xmodeloproc.setValueAt("Facturada", i, 3);
                    }
                    i++;
                }
                rss.close();
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
        this.xconsultasbd.cerrarConexionBd();
    }
}
