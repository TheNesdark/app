package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFFormulacionMedica.class */
public class JIFFormulacionMedica extends JInternalFrame {
    public static Object[] dato;
    public static String[] xidtipoformula;
    public static String[] xmunicipio;
    public static String[] xsede;
    public static DefaultTableModel xmodelo;
    public static Object[] xdato;
    private boolean xlleno = false;
    private long xnorden = 0;
    private long xidatencion = 0;
    Subproceso ct = new Subproceso();
    Thread t = new Thread(this.ct);
    public static JComboBox JCBMunicipio;
    public static JComboBox JCBSede;
    public static JComboBox JCBTipoFormula;
    public static JCheckBox JCHFiltro;
    public static JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPTablaFormulas;
    private static JTable JTBDetalle;
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static ConsultasMySQL xconsultabd = new ConsultasMySQL();
    public static Metodos xmt = new Metodos();
    public static boolean v = true;

    public JIFFormulacionMedica() {
        initComponents();
        mNuevo();
        this.t.start();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        JCBMunicipio = new JComboBox();
        JDFechaI = new JDateChooser();
        JCBTipoFormula = new JComboBox();
        JCBSede = new JComboBox();
        JCHFiltro = new JCheckBox();
        this.JSPTablaFormulas = new JScrollPane();
        JTBDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR FORMULACIÓN MEDICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifformulacionmedica");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        JCBMunicipio.setFont(new Font("Arial", 1, 12));
        JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JDFechaI.setDateFormatString("dd/MM/yyyy");
        JDFechaI.setFont(new Font("Arial", 1, 12));
        JCBTipoFormula.setFont(new Font("Arial", 1, 12));
        JCBTipoFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBTipoFormula.addItemListener(new ItemListener() { // from class: Inventarios.JIFFormulacionMedica.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFormulacionMedica.this.JCBTipoFormulaItemStateChanged(evt);
            }
        });
        JCBSede.setFont(new Font("Arial", 1, 12));
        JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCHFiltro.setFont(new Font("Arial", 1, 12));
        JCHFiltro.setText("Filtro?");
        JCHFiltro.addActionListener(new ActionListener() { // from class: Inventarios.JIFFormulacionMedica.2
            public void actionPerformed(ActionEvent evt) {
                JIFFormulacionMedica.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(JDFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JCBTipoFormula, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCBMunicipio, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JCBSede, 0, 184, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JCHFiltro).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JCBTipoFormula, -1, 54, 32767).addComponent(JCBMunicipio, -1, 54, 32767).addComponent(JCBSede, -1, 54, 32767).addComponent(JCHFiltro))).addGroup(JPIDatosLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(JDFechaI, -1, 54, 32767))).addContainerGap()));
        this.JSPTablaFormulas.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMULAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        JTBDetalle.setFont(new Font("Arial", 1, 12));
        JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        JTBDetalle.setRowHeight(25);
        JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        JTBDetalle.setSelectionMode(0);
        JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFFormulacionMedica.3
            public void mouseClicked(MouseEvent evt) {
                JIFFormulacionMedica.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPTablaFormulas.setViewportView(JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPTablaFormulas, GroupLayout.Alignment.LEADING, -1, 910, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPTablaFormulas, -2, 341, -2).addContainerGap(23, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (JTBDetalle.getSelectedRow() != -1) {
            setXnorden(Long.valueOf(xmodelo.getValueAt(JTBDetalle.getSelectedRow(), 0).toString()).longValue());
            setXidatencion(Long.valueOf(xmodelo.getValueAt(JTBDetalle.getSelectedRow(), 6).toString()).longValue());
            Object[] botones = {"Visualizar", "Actualizar Estado", "Despacho", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "FORMULA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                mImprimir(getXnorden(), 1);
                return;
            }
            if (n == 1) {
                String xsql = "update h_ordenes set EstaEntregada=3 where Id='" + getXnorden() + "'";
                xconsultabd.ejecutarSQL(xsql);
                xconsultabd.cerrarConexionBd();
            } else if (n == 2) {
                Principal.xClaseInventario.cargarPantalla("Despachos1");
                setVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoFormulaItemStateChanged(ItemEvent evt) {
        if (!this.xlleno || JCBTipoFormula.getSelectedIndex() == -1) {
            return;
        }
        mCargarDatosTabla();
    }

    public long getXnorden() {
        return this.xnorden;
    }

    public void setXnorden(long xnorden) {
        this.xnorden = xnorden;
    }

    public long getXidatencion() {
        return this.xidatencion;
    }

    public void setXidatencion(long xidatencion) {
        this.xidatencion = xidatencion;
    }

    public static void mLimpiarModelo() {
        int vx = modelo.getRowCount();
        for (int i = 0; i < vx; i++) {
            modelo.removeRow(0);
        }
    }

    private void mImprimir(long idorden, int n) {
        try {
            String xnotasad = null;
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM h_ordenes where Id='" + getXnorden() + "'";
            new Metodos();
            ResultSet rsm = xconsultabd.traerRs(sql);
            if (rsm.next()) {
                rsm.first();
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet xrsm = xct.traerRs(sql);
                xrsm.next();
                if (xrsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + xrsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xmt.formatoDMA.format((Date) xrsm.getDate(3));
                }
                xrsm.close();
                xct.cerrarConexionBd();
            }
            rsm.close();
            xconsultabd.cerrarConexionBd();
            String[][] mparametros = new String[6][2];
            String usuario = Principal.usuarioSistemaDTO.getLogin();
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = String.valueOf(idorden);
                mparametros[1][0] = "xp2";
                mparametros[1][1] = "Farmacia";
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = usuario;
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = xmt.getSO() + xmt.getBarra() + "Reportes" + xmt.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = xmt.getSO() + xmt.getBarra() + "Firmas" + xmt.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    String xsql = "SELECT  `g_relacionlaboral`.`Id` FROM  `h_ordenes` INNER JOIN`h_atencion`  ON (`h_ordenes`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN`ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN`g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN`g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_usuario`.`Id_persona`) INNER JOIN`g_relacionlaboral`  ON (`g_usuario_fpz`.`Id_RelacionLaboral` = `g_relacionlaboral`.`Id`) WHERE (`h_ordenes`.`Id` ='" + idorden + "') ";
                    ResultSet xrs = xconsultabd.traerRs(xsql);
                    if (xrs.next()) {
                        xrs.first();
                        if (xrs.getInt(1) == 1) {
                            xmt.GenerarPDF(xmt.getRutaRep() + "RFormulaGeneralMP", mparametros);
                        } else {
                            xmt.GenerarPDF(xmt.getRutaRep() + "RFormulaGeneralMP_Directivos", mparametros);
                        }
                    }
                    xrs.close();
                    xconsultabd.cerrarConexionBd();
                } else if (Principal.informacionIps.getFormaImpresionReporte().intValue() == 0) {
                    if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                        xmt.PresentacionImpresora(xmt.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                    } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                        xmt.PresentacionImpresora(xmt.getRutaRep() + "RFormulaGeneralMP2.jasper", mparametros);
                    }
                } else {
                    Object[] botones = {"Visualizar", "Imprimir", "Cerrar"};
                    int m = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                    if (m == 0) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            xmt.GenerarPDF(xmt.getRutaRep() + "RFormulaGeneralMP1", mparametros);
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            xmt.GenerarPDF(xmt.getRutaRep() + "RFormulaGeneralMP2", mparametros);
                        }
                    } else if (m == 1) {
                        if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 1) {
                            xmt.PresentacionImpresora(xmt.getRutaRep() + "RFormulaGeneralMP1.jasper", mparametros);
                        } else if (Principal.informacionIps.getTipoReporteImprimir().intValue() == 2) {
                            xmt.PresentacionImpresora(xmt.getRutaRep() + "RFormulaGeneralMP2.jasper", mparametros);
                        }
                    }
                }
            }
            rsm.close();
            xconsultabd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public void mNuevo() {
        JDFechaI.setDate(xmt.getFechaActual());
        xidtipoformula = xconsultabd.llenarCombo("SELECT Id, Nbre FROM h_tipoformula WHERE (Estado =0) ORDER BY Nbre ASC", xidtipoformula, JCBTipoFormula);
        xmunicipio = xconsultabd.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", xmunicipio, JCBMunicipio);
        JCBMunicipio.setSelectedItem("MONTELIBANO");
        xsede = xconsultabd.llenarCombo("SELECT Id, Nbre FROM g_sedes order by Nbre ", xsede, JCBSede);
        JCBSede.setSelectedItem("BETANCI");
        xconsultabd.cerrarConexionBd();
        this.xlleno = true;
        mCrearTabla();
    }

    private static void mCrearTabla() {
        xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "N° HC", "Nombre Usuario", "Especialidad", "Profesional", "IdAtencion", "Hora", "Tipo Formula", "Estado", "Convenio"}) { // from class: Inventarios.JIFFormulacionMedica.4
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Long.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = JTBDetalle;
        JTable jTable2 = JTBDetalle;
        jTable.setAutoResizeMode(0);
        JTBDetalle.doLayout();
        JTBDetalle.setModel(xmodelo);
        JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(200);
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFFormulacionMedica$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long atendido = Long.parseLong(table.getValueAt(row, 9).toString());
            if (atendido == 3) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public static void mCargarDatosTabla() {
        String sql;
        try {
            if (JCHFiltro.isSelected()) {
                sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS Fecha, g_usuario.NoHistoria,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido1`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS nombre, profesional1.Especialidad, profesional1.NProfesional, h_ordenes.Id_Atencion, TIME(h_ordenes.Fecha) AS Hora, h_ordenes.EstaEntregada, h_tipoformula.Nbre, f_empresacontxconvenio.`Nbre` Convenio FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id`= ingreso.`Id_EmpresaContxConv`) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN `g_usuario` ON (g_usuario.`Id_persona` = ingreso.Id_Usuario)  INNER JOIN `g_persona` ON (g_usuario.`Id_persona` = g_persona.`Id`)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN h_tipoformula  ON (h_ordenes.IdTipoFormula = h_tipoformula.Id) WHERE ( h_ordenes.Estado =0 AND h_ordenes.IdTipoFormula ='" + xidtipoformula[JCBTipoFormula.getSelectedIndex()] + "' AND h_ordenes.IdMunicipio ='" + xmunicipio[JCBMunicipio.getSelectedIndex()] + "' AND f_empresacontxconvenio.`AgendaInventario`=1 AND h_ordenes.EstaEntregada in(0,3) AND ingreso.Id_Sede='" + xsede[JCBSede.getSelectedIndex()] + "' and h_ordenes.FechaOrden='" + xmt.formatoAMD1.format(JDFechaI.getDate()) + "') GROUP BY h_ordenes.Id ORDER BY h_ordenes.Fecha desc, CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido1`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) ASC ";
            } else {
                sql = "SELECT h_ordenes.Id, DATE_FORMAT(h_ordenes.FechaOrden,'%d-%m-%Y') AS Fecha, g_usuario.NoHistoria,CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido1`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) AS nombre, profesional1.Especialidad, profesional1.NProfesional, h_ordenes.Id_Atencion, TIME(h_ordenes.Fecha) AS Hora, h_ordenes.EstaEntregada, h_tipoformula.Nbre, f_empresacontxconvenio.`Nbre` Convenio FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id`= ingreso.`Id_EmpresaContxConv`) INNER JOIN h_ordenes  ON (h_ordenes.Id_Atencion = h_atencion.Id) INNER JOIN h_itemordenessum  ON (h_itemordenessum.Id_HOrdenes = h_ordenes.Id) INNER JOIN `g_usuario` ON (g_usuario.`Id_persona` = ingreso.Id_Usuario)  INNER JOIN `g_persona` ON (g_usuario.`Id_persona` = g_persona.`Id`)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_ordenes.Id_Profesional) AND (profesional1.IdEspecialidad = h_ordenes.Id_Especialidad) INNER JOIN h_tipoformula  ON (h_ordenes.IdTipoFormula = h_tipoformula.Id) WHERE (h_ordenes.Estado =0 AND h_ordenes.IdMunicipio ='" + xmunicipio[JCBMunicipio.getSelectedIndex()] + "' AND f_empresacontxconvenio.`AgendaInventario`=1 AND h_ordenes.EstaEntregada in(0,3) AND ingreso.Id_Sede='" + xsede[JCBSede.getSelectedIndex()] + "' and h_ordenes.FechaOrden='" + xmt.formatoAMD1.format(JDFechaI.getDate()) + "') GROUP BY h_ordenes.Id ORDER BY h_ordenes.Fecha desc, CONCAT(g_persona.`Apellido1`,' ', g_persona.`Apellido1`,' ',g_persona.`Nombre1`,' ',g_persona.`Nombre2`) ASC ";
            }
            ResultSet rs = xconsultabd.traerRs(sql);
            System.out.println(sql);
            mCrearTabla();
            if (rs.next()) {
                rs.last();
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    xmodelo.addRow(xdato);
                    xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    xmodelo.setValueAt(rs.getString(2), i, 1);
                    xmodelo.setValueAt(rs.getString(3), i, 2);
                    xmodelo.setValueAt(rs.getString(4), i, 3);
                    xmodelo.setValueAt(rs.getString(5), i, 4);
                    xmodelo.setValueAt(rs.getString(6), i, 5);
                    xmodelo.setValueAt(Long.valueOf(rs.getLong(7)), i, 6);
                    xmodelo.setValueAt(rs.getString(8), i, 7);
                    xmodelo.setValueAt(rs.getString(10), i, 8);
                    xmodelo.setValueAt(Long.valueOf(rs.getLong(9)), i, 9);
                    xmodelo.setValueAt(rs.getString("Convenio"), i, 10);
                    JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    i++;
                }
            }
            rs.close();
            xconsultabd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarFormulas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
