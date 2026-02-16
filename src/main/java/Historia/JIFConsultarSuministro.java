package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarSuministro.class */
public class JIFConsultarSuministro extends JInternalFrame {
    private DefaultTableModel modelosuministro;
    private SimpleDateFormat xfechas;
    private TableColumn column;
    private Object[] dato;
    private ResultSet rs;
    private String idpaciente;
    private Object jifhistoria;
    private Object jifordenes;
    private int xestado;
    private ConsultasMySQL xconsultasbd;
    private Metodos xmetodo;
    private clasesHistoriaCE xclase;
    private String xnombre;
    private String xnTipoFormula;
    private ButtonGroup JBGTipo;
    private JButton JBTCerrar;
    private JLabel JLBTitulo;
    private JPanel JPITipoConsulta;
    private JRadioButton JRBActivas;
    private JRadioButton JRBAnuladas;
    private JScrollPane JSPDetalleConsulta;
    private JTable JTBDetalle;

    public JIFConsultarSuministro(Object jifhistoria, Object jifordenes, String idpaciente, String xnombre) {
        this.xfechas = new SimpleDateFormat("dd/MM/yyyy");
        this.column = null;
        this.xestado = 0;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xnTipoFormula = "";
        initComponents();
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        this.idpaciente = idpaciente;
        this.jifordenes = jifordenes;
        this.jifhistoria = jifhistoria;
        this.xnombre = xnombre;
        mCargarDatos(idpaciente);
    }

    public JIFConsultarSuministro(clasesHistoriaCE xclase, String xnombre, String nTipoFormula) {
        this.xfechas = new SimpleDateFormat("dd/MM/yyyy");
        this.column = null;
        this.xestado = 0;
        this.xconsultasbd = new ConsultasMySQL();
        this.xmetodo = new Metodos();
        this.xnTipoFormula = "";
        initComponents();
        this.xclase = xclase;
        this.xnombre = xnombre;
        this.xnTipoFormula = nTipoFormula;
        setLocation((this.xmetodo.getAnchoPantalla() / 2) / 2, (this.xmetodo.getAltoPantalla() / 2) / 2);
        this.idpaciente = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mCargarDatos(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
    }

    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalleConsulta = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBTitulo = new JLabel();
        this.JBTCerrar = new JButton();
        this.JPITipoConsulta = new JPanel();
        this.JRBActivas = new JRadioButton();
        this.JRBAnuladas = new JRadioButton();
        setClosable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JSPDetalleConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFConsultarSuministro.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarSuministro.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleConsulta.setViewportView(this.JTBDetalle);
        this.JLBTitulo.setBackground(new Color(255, 255, 255));
        this.JLBTitulo.setFont(new Font("Tahoma", 1, 18));
        this.JLBTitulo.setForeground(Color.blue);
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("ORDENES DE SUMINISTROS");
        this.JLBTitulo.setBorder(BorderFactory.createEtchedBorder());
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setForeground(Color.blue);
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarSuministro.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministro.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JPITipoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGTipo.add(this.JRBActivas);
        this.JRBActivas.setFont(new Font("Arial", 1, 12));
        this.JRBActivas.setForeground(Color.blue);
        this.JRBActivas.setSelected(true);
        this.JRBActivas.setText("Activas");
        this.JRBActivas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarSuministro.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministro.this.JRBActivasActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBAnuladas);
        this.JRBAnuladas.setFont(new Font("Arial", 1, 12));
        this.JRBAnuladas.setForeground(Color.blue);
        this.JRBAnuladas.setText("Anuladas");
        this.JRBAnuladas.addActionListener(new ActionListener() { // from class: Historia.JIFConsultarSuministro.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarSuministro.this.JRBAnuladasActionPerformed(evt);
            }
        });
        GroupLayout JPITipoConsultaLayout = new GroupLayout(this.JPITipoConsulta);
        this.JPITipoConsulta.setLayout(JPITipoConsultaLayout);
        JPITipoConsultaLayout.setHorizontalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBActivas).addGap(18, 18, 18).addComponent(this.JRBAnuladas).addContainerGap(-1, 32767)));
        JPITipoConsultaLayout.setVerticalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBActivas).addComponent(this.JRBAnuladas)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleConsulta, GroupLayout.Alignment.TRAILING, -1, 826, 32767).addComponent(this.JLBTitulo, GroupLayout.Alignment.TRAILING, -1, 826, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBTCerrar, -1, 612, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoConsulta, -2, -1, -2).addGap(26, 26, 26)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleConsulta, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTCerrar, -1, -1, 32767).addComponent(this.JPITipoConsulta, -1, -1, 32767)).addContainerGap(21, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        try {
            if (this.JTBDetalle.getSelectedRow() != -1) {
                if (this.xnombre.equals("jpsuministroh")) {
                    Object[] botones = {"Imprimir", "Cargar", "Transladar Items", "Cerrar"};
                    int n = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                    JPOOrdenSuministroH jifo = this.xclase.xjifhistoriaclinica.xjpsuministroh;
                    if (n == 0) {
                        jifo.mVerHImpresion(Long.valueOf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()).longValue());
                    } else if (n == 1) {
                        jifo.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), true);
                        this.xclase.xjifhistoriaclinica.xjpsuministroh.JBTAdicionarHC.setVisible(true);
                    } else if (n == 2) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            if (this.xnTipoFormula.equals(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString())) {
                                jifo.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), false);
                                this.xclase.xjifhistoriaclinica.xjpsuministroh.JBTAdicionarHC.setVisible(true);
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Tipo de formula no se puede trasladar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.xclase.xjifhistoriaclinica.xjpsuministroh.JBTAdicionarHC.setVisible(true);
                            }
                        } else {
                            jifo.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), false);
                            this.xclase.xjifhistoriaclinica.xjpsuministroh.JBTAdicionarHC.setVisible(false);
                        }
                    }
                    this.xclase.xjifhistoriaclinica.setSelected(true);
                    dispose();
                } else if (this.xnombre.equals("jpsuministroh1")) {
                    Object[] botones2 = {"Imprimir", "Cargar", "Transladar Items", "Cerrar"};
                    int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar");
                    JPOOrdenSuministroH jifo2 = null;
                    if (this.xclase.historia_Clinica_v2 != null) {
                        jifo2 = this.xclase.historia_Clinica_v2.funcionalidadPanelHistoriaClinica.xjpsuministroh;
                    } else if (this.xclase.historia_Clinica_v4 != null) {
                        jifo2 = this.xclase.historia_Clinica_v4.funcionalidadPanelHistoriaClinica.xjpsuministroh;
                    }
                    if (n2 == 0) {
                        jifo2.mVerHImpresion(Long.valueOf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()).longValue());
                    } else if (n2 == 1) {
                        jifo2.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), true);
                        jifo2.JBTAdicionar.setVisible(true);
                    } else if (n2 == 2) {
                        if (Principal.informacionIps.getEsFpz().intValue() != 0 || this.xnTipoFormula.equals(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString())) {
                            jifo2.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), false);
                            jifo2.JBTAdicionar.setVisible(true);
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Tipo de formula no se puede trasladar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            jifo2.JBTAdicionar.setVisible(true);
                        }
                    }
                    if (this.xclase.historia_Clinica_v2 != null) {
                        this.xclase.historia_Clinica_v2.setSelected(true);
                    } else if (this.xclase.historia_Clinica_v4 != null) {
                        this.xclase.historia_Clinica_v4.setSelected(true);
                    }
                    dispose();
                } else if (this.xnombre.equals("jifformulapyp")) {
                    Object[] botones3 = {"Imprimir", "Cargar", "Transladar Items", "Cerrar"};
                    int n3 = JOptionPane.showInternalOptionDialog(this, "Que desea realizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones3, "Cerrar");
                    if (n3 == 0) {
                        this.xclase.xjifformulaspyp.xjpsuministro.mVerHImpresion(Long.valueOf(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()).longValue());
                    } else if (n3 == 1) {
                        this.xclase.xjifformulaspyp.xjpsuministro.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), true);
                    } else if (n3 == 2) {
                        this.xclase.xjifformulaspyp.xjpsuministro.mBuscarSuministro(this.modelosuministro.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString(), false);
                    }
                    this.xclase.xjifformulaspyp.setSelected(true);
                    dispose();
                }
            }
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivasActionPerformed(ActionEvent evt) {
        this.xestado = 0;
        mCargarDatos(this.idpaciente);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnuladasActionPerformed(ActionEvent evt) {
        this.xestado = 1;
        mCargarDatos(this.idpaciente);
    }

    private void mCrearTablaDetalle() {
        this.modelosuministro = new DefaultTableModel();
        this.modelosuministro = new DefaultTableModel() { // from class: Historia.JIFConsultarSuministro.5
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.modelosuministro.addColumn("N Orden");
        this.modelosuministro.addColumn("Fecha");
        this.modelosuministro.addColumn("Tipo Formula");
        this.modelosuministro.addColumn("Profesional");
        this.modelosuministro.addColumn("Estado");
        this.JTBDetalle.setModel(this.modelosuministro);
        this.column = this.JTBDetalle.getColumnModel().getColumn(0);
        this.column.setPreferredWidth(80);
        this.column = this.JTBDetalle.getColumnModel().getColumn(1);
        this.column.setPreferredWidth(150);
        this.column = this.JTBDetalle.getColumnModel().getColumn(2);
        this.column.setPreferredWidth(350);
        this.column = this.JTBDetalle.getColumnModel().getColumn(3);
        this.column.setPreferredWidth(400);
        this.column = this.JTBDetalle.getColumnModel().getColumn(4);
        this.column.setPreferredWidth(100);
    }

    private void mCargarDatos(String id) {
        mCrearTablaDetalle();
        String sql = "SELECT h_ordenes.Id, h_ordenes.FechaOrden, h_tipoformula.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, h_ordenes.Estado, h_ordenes.EstaEntregada FROM h_tipoformula INNER JOIN h_ordenes ON (h_tipoformula.Id = h_ordenes.IdTipoFormula) INNER JOIN h_atencion  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN baseserver.ingreso  ON (ingreso.Id = h_atencion.Id_Ingreso) INNER JOIN baseserver.g_profesional  ON (`h_ordenes`.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.g_persona ON (g_profesional.Id_Persona = g_persona.Id) WHERE (h_ordenes.Id_TipoServicio =7 and ingreso.Id_Usuario='" + id + "' and h_ordenes.Estado='" + this.xestado + "' ) ORDER BY h_ordenes.FechaOrden desc; ";
        this.rs = this.xconsultasbd.traerRs(sql);
        try {
            this.rs.next();
            if (this.rs.getRow() != 0) {
                this.rs = this.xconsultasbd.traerRs(sql);
                int i = 0;
                while (this.rs.next()) {
                    this.modelosuministro.addRow(this.dato);
                    this.modelosuministro.setValueAt(Long.valueOf(this.rs.getLong(1)), i, 0);
                    this.modelosuministro.setValueAt(this.xfechas.format((Date) this.rs.getDate(2)), i, 1);
                    this.modelosuministro.setValueAt(this.rs.getString(3), i, 2);
                    this.modelosuministro.setValueAt(this.rs.getString(4), i, 3);
                    if (this.rs.getInt(6) == 0) {
                        this.modelosuministro.setValueAt("Impresa", i, 4);
                    } else if (this.rs.getInt(6) == 1) {
                        this.modelosuministro.setValueAt("Empacada", i, 4);
                    } else if (this.rs.getInt(6) == 2 || this.rs.getInt(6) == 3) {
                        this.modelosuministro.setValueAt("Despachada", i, 4);
                    }
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender1());
                    i++;
                }
                this.xconsultasbd.cerrarConexionBd();
            }
            this.rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarSuministro$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 4).toString().equals("Impresa")) {
                cell.setBackground(Color.WHITE);
            } else if (table.getValueAt(row, 4).toString().equals("Empacada")) {
                cell.setBackground(new Color(255, 153, 153));
            } else if (table.getValueAt(row, 4).toString().equals("Despachada")) {
                cell.setBackground(new Color(177, 251, 177));
            }
            return cell;
        }
    }
}
