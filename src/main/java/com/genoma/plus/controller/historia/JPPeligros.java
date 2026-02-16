package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import ParametrizacionN.JIFGenericoCh;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.salud_ocupacional.JDSoportesSO;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO;
import com.genoma.plus.jpa.entities.HAtencionSoPeligrosSubcategoriaEntity;
import com.genoma.plus.jpa.service.HAtencionSoPeligroSubcategoriaService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPPeligros.class */
public class JPPeligros extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel modcombos;
    private Object[] xDato;
    private RevisionExamenSoDAO xRevisionExamenSoDAO;
    JTableComboBox[] xcomboBox3;
    private JTable tabla_combo;
    private JButton JBGuardarInter;
    private JScrollPane JSPDetalleP;
    private JTable JTDetalle;
    private final HAtencionSoPeligroSubcategoriaService service = (HAtencionSoPeligroSubcategoriaService) Principal.contexto.getBean(HAtencionSoPeligroSubcategoriaService.class);
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String selccionado = "";
    private String idatencion = "";
    private String xsql = "";
    private String xidatencion = "";
    private String observacion = "";
    ArrayList editors = new ArrayList();
    private boolean xlleno = false;

    public JPPeligros() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRevisionExamenSoDAO = (RevisionExamenSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("revisionExamenSoDAO");
    }

    public void mNuevo() {
        mCargarDatosTabla();
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            for (int i = 0; i < this.tabla_combo.getRowCount(); i++) {
                this.observacion = this.xmodelo.getValueAt(i, 4).toString();
                this.xidatencion = this.xmodelo.getValueAt(i, 3).toString();
                this.selccionado = this.xmodelo.getValueAt(i, 5).toString();
                if (this.xidatencion.isEmpty()) {
                    if (this.selccionado == "true") {
                        HAtencionSoPeligrosSubcategoriaEntity entity = new HAtencionSoPeligrosSubcategoriaEntity();
                        entity.setIdAtencion(Integer.valueOf(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
                        entity.setIdPeligroSubcategoria(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(i, 0).toString())));
                        entity.setObservacion(this.xmodelo.getValueAt(i, 4).toString());
                        entity.setIdProfesional(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString())));
                        entity.setIdEspesialdiad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
                        entity.setEstado("1");
                        System.out.println("la observacion es: " + this.xmodelo.getValueAt(i, 4).toString());
                        this.service.grabar(entity);
                    } else if (this.selccionado != "true" && this.observacion != "") {
                        JOptionPane.showInternalMessageDialog(this, "Tienes que chequearlo para poder guardar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else {
                    System.out.println(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 4).toString());
                    this.xsql = "UPDATE h_atencion_so_peligros_subcategoria  SET observacion='" + this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 4).toString() + "' WHERE idPeligroSubcategoria =" + Integer.parseInt(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString()) + " ";
                    System.out.println(this.xsql);
                    System.out.println("actualzo");
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                }
            }
            mNuevo();
        }
    }

    private JTableComboBox mLlenaComboModelo1(Long xid, int xFila) {
        try {
            this.xcomboBox3[xFila] = new JTableComboBox();
            this.xcomboBox3[xFila].setName("combo" + xFila);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String sql = "SELECT `NResultado` FROM `g_procedimiento_resultado` WHERE (`Id_Procedimiento` ='" + xid + "' AND `Estado` =1) ORDER BY `NResultado` ASC;";
            xct1.llenarComboTabla(sql, this.xcomboBox3[xFila], this.modcombos, 0);
            xct1.cerrarConexionBd();
            this.xlleno = true;
            this.xcomboBox3[xFila].setShowTableHeaders(false);
        } catch (IncompatibleLookAndFeelException e) {
            Logger.getLogger(JPPeligros.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return this.xcomboBox3[xFila];
    }

    private void mCambiaElementoCombo() {
        if (this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.xmodelo.setValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 0), this.tabla_combo.getSelectedRow(), 5);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdSubcategoriaPeligro", "Peligro", "Subcategoria", "IdAtencion Peligro", "observacion", "Accion"}) { // from class: com.genoma.plus.controller.historia.JPPeligros.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelo) { // from class: com.genoma.plus.controller.historia.JPPeligros.2
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 3 && row < JPPeligros.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JPPeligros.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.historia.JPPeligros.3
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.tabla_combo.setFont(new Font("Arial", 1, 12));
        this.tabla_combo.setSelectionBackground(Color.WHITE);
        this.tabla_combo.setSelectionForeground(Color.RED);
        JTable jTable = this.tabla_combo;
        JTable jTable2 = this.tabla_combo;
        jTable.setAutoResizeMode(0);
        this.tabla_combo.doLayout();
        this.tabla_combo.setModel(this.xmodelo);
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(130);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JSPDetalleP.getViewport().add(this.tabla_combo);
    }

    private void mCargarDatosTabla() {
        try {
            String sql = "with maestra as (\n\tselect gsps.idSubcategoria , gsp.Nbre nombrePeligro, gsps.nombre nombreSubcaterogia\n\tfrom g_so_peligros gsp \n\tinner join g_so_peligros_subcategoria gsps  on (gsp.Id=gsps.idPeligro)\t \n)\n,\nmovimiento as (\n\tselect hasps.idPeligroSubcategoria , hasps.observacion , hasps.id idAtencionPeligro\n\tfrom h_atencion_so_peligros_subcategoria hasps \n\twhere hasps.idAtencion =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "\n)\nselect m.idSubcategoria , m.nombrePeligro, m.nombreSubcaterogia, ifnull(n.observacion, '') observacion, ifnull(n.idAtencionPeligro, '') idAtencionPeligro\nfrom maestra m\nleft join movimiento n on (n.idPeligroSubcategoria=m.idSubcategoria)";
            mCrearTabla();
            System.out.println("el id de atencion es de:" + sql);
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xDato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("idSubcategoria")), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("nombrePeligro"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("nombreSubcaterogia"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("idAtencionPeligro"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("observacion"), n, 4);
                    if (!xrs.getString("observacion").isEmpty() || !xrs.getString("idAtencionPeligro").isEmpty()) {
                        this.xmodelo.setValueAt(true, n, 5);
                    } else {
                        this.xmodelo.setValueAt(false, n, 5);
                    }
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarSoportes(String tabla, int pos) {
        List<Object[]> listaSoporte = this.xRevisionExamenSoDAO.listaSoportes(tabla, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        if (!listaSoporte.isEmpty()) {
            for (int i = 0; i < listaSoporte.size(); i++) {
                this.xmodelo.setValueAt(true, pos, 7);
                this.xmodelo.setValueAt(listaSoporte.get(i)[0], pos, 8);
            }
            return;
        }
        this.xmodelo.setValueAt(new JButton("Pendiente"), pos, 6);
        this.xmodelo.setValueAt(false, pos, 7);
        this.xmodelo.setValueAt((Object) null, pos, 8);
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPPeligros.4
            public void mouseClicked(MouseEvent e) {
                JPPeligros.this.tabla_comboMouseClicked(e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tabla_comboMouseClicked(MouseEvent evt) {
        if (this.tabla_combo.getSelectedRow() > -1) {
            if (this.tabla_combo.getSelectedColumn() == 6) {
                if (!this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 6).toString().contains("Visualizar")) {
                    if (this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 6).toString().contains("Cargar")) {
                        JDSoportesSO xjd = new JDSoportesSO(null, true, Long.valueOf(Long.parseLong(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 0).toString())), Long.valueOf(Long.parseLong(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 1).toString())));
                        xjd.setLocationRelativeTo(this);
                        xjd.setVisible(true);
                        return;
                    }
                    return;
                }
                if (Long.parseLong(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 7).toString()) != 0) {
                    ImpresionReportesDAOImpl impresion = new ImpresionReportesDAOImpl();
                    impresion.mImprimirResultado(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 7).toString(), "", this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra(), this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra(), true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString(), true);
                    return;
                } else if (!this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 8).toString().startsWith("[B@")) {
                    this.xmt.mostrarPdf(this.xmt.Base64Decode(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 8).toString(), this.xmt.getRutaRep(), "SO_Soporte", "pdf"));
                    return;
                } else {
                    this.xmt.AbrirArchivosblob(this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 8), "SO_Soporte", "pdf", true);
                    return;
                }
            }
            if (this.tabla_combo.getSelectedColumn() == 3) {
                mCambiaElementoCombo();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGuardarInter = new JButton();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("jpeligros");
        this.JBGuardarInter.setFont(new Font("Arial", 1, 12));
        this.JBGuardarInter.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardarInter.setText("Guardar");
        this.JBGuardarInter.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPPeligros.5
            public void actionPerformed(ActionEvent evt) {
                JPPeligros.this.JBGuardarInterActionPerformed(evt);
            }
        });
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleP.setName("");
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPDetalleP.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleP).addComponent(this.JBGuardarInter, -1, 842, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleP, -2, 314, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGuardarInter, -2, 50, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarInterActionPerformed(ActionEvent evt) {
        mGrabar();
    }
}
