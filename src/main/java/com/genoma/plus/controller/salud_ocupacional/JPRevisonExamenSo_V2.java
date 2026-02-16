package com.genoma.plus.controller.salud_ocupacional;

import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ImpresionReportesDAOImpl;
import com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO;
import com.genoma.plus.dto.salud_ocupacional.RevisionExamenSoDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
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
import org.springframework.util.SerializationUtils;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JPRevisonExamenSo_V2.class */
public class JPRevisonExamenSo_V2 extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel modcombos;
    private Object[] xDato;
    private RevisionExamenSoDAO xRevisionExamenSoDAO;
    private clasesHistoriaCE xclase;
    private String[] xidresultado;
    JTableComboBox[] xcomboBox3;
    private JTable tabla_combo;
    private JButton JBGuardarInter;
    private JScrollPane JSPDetalleP;
    private Metodos xmt = new Metodos();
    ArrayList editors = new ArrayList();
    private boolean xlleno = false;

    public JPRevisonExamenSo_V2(clasesHistoriaCE xclase) {
        initComponents();
        springStart();
        this.xclase = xclase;
        mNuevo();
        setEventoMouseClicked(this.tabla_combo);
    }

    private void springStart() {
        this.xRevisionExamenSoDAO = (RevisionExamenSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("revisionExamenSoDAO");
    }

    public void mNuevo() {
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.tabla_combo.isEditing()) {
            this.tabla_combo.getCellEditor().stopCellEditing();
        }
        if (!this.xmt.mVerificarDatosLLeno(this.tabla_combo, 5)) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int i = 0; i < this.tabla_combo.getRowCount(); i++) {
                    RevisionExamenSoDTO e = new RevisionExamenSoDTO();
                    e.setResultadoTexto(this.xmodelo.getValueAt(i, 5).toString());
                    e.setObservacion(this.xmodelo.getValueAt(i, 4).toString());
                    e.setIdOrdenes(Long.valueOf(this.xmodelo.getValueAt(i, 0).toString()));
                    e.setIdProcedimiento(Long.valueOf(this.xmodelo.getValueAt(i, 1).toString()));
                    this.xRevisionExamenSoDAO.updateRevisionExamen(e);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    this.xclase.mCambiarEstadoOrdenProcedimiento(2);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Aun tiene registros sin seleccionar el resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
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
            Logger.getLogger(JPRevisonExamenSo_V2.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return this.xcomboBox3[xFila];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCambiaElementoCombo() {
        if (this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.xmodelo.setValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox3[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 0), this.tabla_combo.getSelectedRow(), 5);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdOrdenes", "IdProcedimiento", "Procedimiento", "Resultado", "Observacion", "idResultado", "Accion", "idRecepcion", "Archivo"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.1
            Class[] types = {Long.class, Long.class, String.class, JTableComboBox[].class, String.class, String.class, JButton.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, true, true, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelo) { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.2
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 3 && row < JPRevisonExamenSo_V2.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JPRevisonExamenSo_V2.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.3
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.tabla_combo.setFont(new Font("Arial", 1, 12));
        this.tabla_combo.setSelectionBackground(Color.WHITE);
        this.tabla_combo.setSelectionForeground(Color.RED);
        this.tabla_combo.setRowHeight(100);
        JTable jTable = this.tabla_combo;
        JTable jTable2 = this.tabla_combo;
        jTable.setAutoResizeMode(0);
        this.tabla_combo.doLayout();
        this.tabla_combo.setModel(this.xmodelo);
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.tabla_combo.getColumnModel().getColumn(1).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(370);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.tabla_combo.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(7).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JSPDetalleP.getViewport().add(this.tabla_combo);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xRevisionExamenSoDAO.listRevisionExamen2(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso()));
        mCrearTabla();
        this.xmt.mEstablecerTextEditor(this.tabla_combo, 2);
        this.xmt.mEstablecerTextEditor(this.tabla_combo, 4);
        if (!list.isEmpty()) {
            this.xcomboBox3 = new JTableComboBox[list.size()];
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list.get(x)[3], x, 5);
                if (list.get(x)[6].toString().equals("Salud Ocupacional")) {
                    mCargarSoportes("so_soporte_concepto", x);
                } else if (list.get(x)[6].toString().contains("Visiometria")) {
                    mCargarSoportes("so_soporte_optometria", x);
                } else if (!list.get(x)[6].toString().contains("Espirometria")) {
                    if (list.get(x)[6].toString().contains("Audiometria")) {
                        mCargarSoportes("so_soporte_audiometria", x);
                    } else if (list.get(x)[6].toString().contains("Psicologica")) {
                        this.xmodelo.setValueAt(SerializationUtils.serialize(list.get(x)[5]), x, 8);
                    }
                }
                this.xmodelo.setValueAt(Long.valueOf(Long.parseLong(list.get(x)[8].toString())), x, 7);
                if (list.get(x)[6].toString().contains("Psicologica") && this.xmodelo.getValueAt(x, 8) == null) {
                    this.xmodelo.setValueAt(new JButton("Cargar"), x, 6);
                    this.xmodelo.setValueAt("No Realizado", x, 3);
                    this.xmodelo.setValueAt("No Realizado", x, 5);
                } else if (this.xmodelo.getValueAt(x, 8) != null || Long.parseLong(list.get(x)[8].toString()) != 0) {
                    this.xmodelo.setValueAt(new JButton("Visualizar"), x, 6);
                    this.xmodelo.setValueAt("Realizado", x, 3);
                    this.xmodelo.setValueAt("Realizado", x, 5);
                } else {
                    this.xmodelo.setValueAt(new JButton("Pendiente"), x, 6);
                    this.xmodelo.setValueAt("No Realizado", x, 3);
                    this.xmodelo.setValueAt("No Realizado", x, 5);
                }
                DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo1(Long.valueOf(Long.parseLong(list.get(x)[1].toString())), x));
                this.editors.add(defaultCellEditor);
                this.xcomboBox3[x].addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.4
                    public void itemStateChanged(ItemEvent e) {
                        JPRevisonExamenSo_V2.this.mCambiaElementoCombo();
                    }
                });
            }
            if (!this.xmt.mVerificarDatosLLeno(this.tabla_combo, 5)) {
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
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
        tbl.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.5
            public void mouseClicked(MouseEvent e) {
                JPRevisonExamenSo_V2.this.tabla_comboMouseClicked(e);
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

    private void initComponents() {
        this.JBGuardarInter = new JButton();
        this.JSPDetalleP = new JScrollPane();
        setName("jprevisionexamenso");
        this.JBGuardarInter.setFont(new Font("Arial", 1, 12));
        this.JBGuardarInter.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardarInter.setText("Guardar");
        this.JBGuardarInter.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JPRevisonExamenSo_V2.6
            public void actionPerformed(ActionEvent evt) {
                JPRevisonExamenSo_V2.this.JBGuardarInterActionPerformed(evt);
            }
        });
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
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
