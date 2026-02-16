package Enfermeria;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPControlLiquidos.class */
public class JPControlLiquidos extends JPanel {
    private String[] xIdViaIngestion;
    private String[] xIdViaEliminacion;
    private DefaultTableModel xmodeloIng;
    private DefaultTableModel xmodeloEli;
    private String xidAtencion;
    private Object[] xdatos;
    private String xidPersona;
    private JButton JBAgregar;
    private JButton JBAgregarEli;
    private JComboBox JCBVia;
    private JComboBox JCBViaEli;
    private JDateChooser JDCFecha;
    private JDateChooser JDCFechaEli;
    private JPanel JPEliminacion;
    private JPanel JPIngestion;
    private JTable JTDetalle;
    private JTable JTDetalleEli;
    private JTextField JTFClase;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFCantidadEli;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFHoraEli;
    private JTextField JTFObservacionEli;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xFilaIng = 0;
    private int xFilaEli = 0;

    public JPControlLiquidos(String xidAtencion, String xidPersona) {
        initComponents();
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JDCFechaEli.setDate(this.xmt.getFechaActual());
        this.JTFFHoraEli.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        mIniciaComponentes();
        this.xidPersona = xidPersona;
        this.xidAtencion = xidAtencion;
        this.JTFFCantidad.setValue(0);
        this.JTFFCantidadEli.setValue(0);
        mBuscaIng();
        mBuscaEli();
    }

    /* JADX WARN: Type inference failed for: r3v102, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPEliminacion = new JPanel();
        this.jPanel2 = new JPanel();
        this.JDCFechaEli = new JDateChooser();
        this.JTFFHoraEli = new JFormattedTextField();
        this.JCBViaEli = new JComboBox();
        this.JTFObservacionEli = new JTextField();
        this.JTFFCantidadEli = new JFormattedTextField();
        this.JBAgregarEli = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleEli = new JTable();
        this.JPIngestion = new JPanel();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBVia = new JComboBox();
        this.JTFClase = new JTextField();
        this.JTFFCantidad = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBAgregar = new JButton();
        setName("xpControlLiquidos");
        this.JPEliminacion.setBorder(BorderFactory.createTitledBorder((Border) null, "ELIMINACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPEliminacion.setMaximumSize(new Dimension(401, 550));
        this.JPEliminacion.setMinimumSize(new Dimension(401, 550));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JDCFechaEli.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaEli.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaEli.setFont(new Font("Arial", 1, 12));
        this.JTFFHoraEli.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHoraEli.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHoraEli.setHorizontalAlignment(4);
        this.JTFFHoraEli.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHoraEli.setFont(new Font("Arial", 1, 12));
        this.JCBViaEli.setFont(new Font("Arial", 1, 12));
        this.JCBViaEli.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFObservacionEli.setFont(new Font("Arial", 1, 12));
        this.JTFObservacionEli.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidadEli.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad C.C.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidadEli.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
        this.JTFFCantidadEli.setHorizontalAlignment(0);
        this.JTFFCantidadEli.setText("0,0");
        this.JTFFCantidadEli.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFObservacionEli).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDCFechaEli, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHoraEli, -2, 96, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBViaEli, 0, 147, 32767).addComponent(this.JTFFCantidadEli)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFechaEli, GroupLayout.Alignment.LEADING, -1, 46, 32767).addComponent(this.JTFFHoraEli).addComponent(this.JCBViaEli)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFObservacionEli, -1, 52, 32767).addComponent(this.JTFFCantidadEli)).addGap(3, 3, 3)));
        this.JBAgregarEli.setFont(new Font("Arial", 1, 12));
        this.JBAgregarEli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregarEli.setText("Agregar");
        this.JBAgregarEli.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlLiquidos.1
            public void actionPerformed(ActionEvent evt) {
                JPControlLiquidos.this.JBAgregarEliActionPerformed(evt);
            }
        });
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleEli.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEli.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEli.setAutoResizeMode(0);
        this.JTDetalleEli.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEli.setSelectionForeground(Color.red);
        this.JTDetalleEli.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPControlLiquidos.2
            public void mouseClicked(MouseEvent evt) {
                JPControlLiquidos.this.JTDetalleEliMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleEli);
        GroupLayout JPEliminacionLayout = new GroupLayout(this.JPEliminacion);
        this.JPEliminacion.setLayout(JPEliminacionLayout);
        JPEliminacionLayout.setHorizontalGroup(JPEliminacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEliminacionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPEliminacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jScrollPane2, -2, 0, 32767).addComponent(this.JBAgregarEli, -1, -1, 32767)).addGap(3, 3, 3)));
        JPEliminacionLayout.setVerticalGroup(JPEliminacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEliminacionLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel2, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JBAgregarEli, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 361, -2)));
        this.JPIngestion.setBorder(BorderFactory.createTitledBorder((Border) null, "INGESTIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIngestion.setMaximumSize(new Dimension(401, 550));
        this.JPIngestion.setMinimumSize(new Dimension(401, 550));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex2) {
            ex2.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCBVia.setFont(new Font("Arial", 1, 12));
        this.JCBVia.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFClase.setFont(new Font("Arial", 1, 12));
        this.JTFClase.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad C.C.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
        this.JTFFCantidad.setHorizontalAlignment(0);
        this.JTFFCantidad.setText("0,0");
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFClase).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 96, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBVia, 0, 153, 32767).addComponent(this.JTFFCantidad)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDCFecha, GroupLayout.Alignment.LEADING, -1, 46, 32767).addComponent(this.JTFFHora).addComponent(this.JCBVia)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFClase, -1, 52, 32767).addComponent(this.JTFFCantidad)).addGap(3, 3, 3)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPControlLiquidos.3
            public void mouseClicked(MouseEvent evt) {
                JPControlLiquidos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBAgregar.setFont(new Font("Arial", 1, 12));
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAgregar.setText("Agregar");
        this.JBAgregar.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlLiquidos.4
            public void actionPerformed(ActionEvent evt) {
                JPControlLiquidos.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout JPIngestionLayout = new GroupLayout(this.JPIngestion);
        this.JPIngestion.setLayout(JPIngestionLayout);
        JPIngestionLayout.setHorizontalGroup(JPIngestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -2, 0, 32767).addComponent(this.JBAgregar, -1, -1, 32767));
        JPIngestionLayout.setVerticalGroup(JPIngestionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIngestionLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 361, -2)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIngestion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEliminacion, -2, -1, -2).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPEliminacion, -1, -1, 32767).addComponent(this.JPIngestion, -1, -1, 32767)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEliMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (this.JCBVia.getSelectedIndex() <= -1) {
            JOptionPane.showInternalMessageDialog(this, "por favor seleccione una Vía de administración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBVia.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFCantidad.getValue().toString()) > 0.0d) {
            this.xmodeloIng.addRow(this.xdatos);
            this.xmodeloIng.setValueAt("", this.xFilaIng, 0);
            this.xmodeloIng.setValueAt(this.xmt.formatoAMD.format(this.JDCFecha.getDate()), this.xFilaIng, 1);
            this.xmodeloIng.setValueAt(this.JTFFHora.getText(), this.xFilaIng, 2);
            this.xmodeloIng.setValueAt(this.xIdViaIngestion[this.JCBVia.getSelectedIndex()], this.xFilaIng, 3);
            this.xmodeloIng.setValueAt(this.JCBVia.getSelectedItem(), this.xFilaIng, 4);
            this.xmodeloIng.setValueAt(this.JTFClase.getText(), this.xFilaIng, 5);
            this.xmodeloIng.setValueAt(this.JTFFCantidad.getValue(), this.xFilaIng, 6);
            this.xmodeloIng.setValueAt(0, this.xFilaIng, 7);
            this.xFilaIng++;
            this.JDCFecha.setDate(this.xmt.getFechaActual());
            this.JTFFHora.setValue(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            this.JTFClase.setText("");
            this.JTFFCantidad.setValue(0);
            this.JCBVia.setSelectedIndex(-1);
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El valor de la cantidad debe ser diferente a Cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFCantidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarEliActionPerformed(ActionEvent evt) {
        if (this.JCBViaEli.getSelectedIndex() <= -1) {
            JOptionPane.showInternalMessageDialog(this, "por favor seleccione una Vía de administración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBViaEli.requestFocus();
            return;
        }
        if (Double.parseDouble(this.JTFFCantidadEli.getValue().toString()) > 0.0d) {
            this.xmodeloEli.addRow(this.xdatos);
            this.xmodeloEli.setValueAt("", this.xFilaEli, 0);
            this.xmodeloEli.setValueAt(this.xmt.formatoAMD.format(this.JDCFechaEli.getDate()), this.xFilaEli, 1);
            this.xmodeloEli.setValueAt(this.JTFFHoraEli.getText(), this.xFilaEli, 2);
            this.xmodeloEli.setValueAt(this.xIdViaEliminacion[this.JCBViaEli.getSelectedIndex()], this.xFilaEli, 3);
            this.xmodeloEli.setValueAt(this.JCBViaEli.getSelectedItem(), this.xFilaEli, 4);
            this.xmodeloEli.setValueAt(this.JTFObservacionEli.getText(), this.xFilaEli, 5);
            this.xmodeloEli.setValueAt(this.JTFFCantidadEli.getValue(), this.xFilaEli, 6);
            this.xmodeloEli.setValueAt(0, this.xFilaEli, 7);
            this.xFilaEli++;
            this.JDCFechaEli.setDate(this.xmt.getFechaActual());
            this.JTFFHoraEli.setValue(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
            this.JTFObservacionEli.setText("");
            this.JTFFCantidadEli.setValue(0);
            this.JCBViaEli.setSelectedIndex(-1);
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El valor de la cantidad debe ser diferente a Cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFCantidadEli.requestFocus();
    }

    private void mIniciaComponentes() {
        this.xIdViaIngestion = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `i_viaadministracion` WHERE (`Estado` =0 AND `AplicaControlDeLiquido` in(1,3)) ORDER BY Nbre ASC;", this.xIdViaIngestion, this.JCBVia);
        this.JCBVia.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xIdViaEliminacion = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `i_viaadministracion` WHERE (`Estado` =0 AND `AplicaControlDeLiquido` in(2,3)) ORDER BY Nbre ASC;", this.xIdViaEliminacion, this.JCBViaEli);
        this.JCBViaEli.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloIng() {
        this.xmodeloIng = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "IdVia", "Via", "Clase", "Cant.C.C.", "G"}) { // from class: Enfermeria.JPControlLiquidos.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloIng);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(65);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(65);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mBuscaIng() {
        mCreaModeloIng();
        String sql = " SELECT `h_control_liquidos`.`Id`, `h_control_liquidos`.`FechaR`, `h_control_liquidos`.`Hora`, h_control_liquidos.IdVia, `i_viaadministracion`.`Nbre`, `h_control_liquidos`.`Clase`, `h_control_liquidos`.`Cantidad`, h_control_liquidos.Estado\n FROM `h_control_liquidos`\n INNER JOIN `i_viaadministracion`  ON (`h_control_liquidos`.`IdVia` = `i_viaadministracion`.`Id`)\n WHERE (`h_control_liquidos`.`IdAtencion` ='" + this.xidAtencion + "'   AND `h_control_liquidos`.`Estado` =1  AND h_control_liquidos.Tipo=0) ORDER BY `h_control_liquidos`.`FechaR` DESC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xFilaIng = 0;
                while (xrs.next()) {
                    this.xmodeloIng.addRow(this.xdatos);
                    this.xmodeloIng.setValueAt(xrs.getString(1), this.xFilaIng, 0);
                    this.xmodeloIng.setValueAt(xrs.getString(2), this.xFilaIng, 1);
                    this.xmodeloIng.setValueAt(xrs.getString(3), this.xFilaIng, 2);
                    this.xmodeloIng.setValueAt(xrs.getString(4), this.xFilaIng, 3);
                    this.xmodeloIng.setValueAt(xrs.getString(5), this.xFilaIng, 4);
                    this.xmodeloIng.setValueAt(xrs.getString(6), this.xFilaIng, 5);
                    this.xmodeloIng.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xFilaIng, 6);
                    this.xmodeloIng.setValueAt(Integer.valueOf(xrs.getInt(8)), this.xFilaIng, 7);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    this.xFilaIng++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlLiquidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloEli() {
        this.xmodeloEli = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "IdVia", "Via", "Observación", "Cant.C.C.", "G"}) { // from class: Enfermeria.JPControlLiquidos.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEli.setModel(this.xmodeloEli);
        this.JTDetalleEli.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleEli.getColumnModel().getColumn(2).setPreferredWidth(65);
        this.JTDetalleEli.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalleEli.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalleEli.getColumnModel().getColumn(6).setPreferredWidth(65);
        this.JTDetalleEli.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleEli.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mBuscaEli() {
        mCreaModeloEli();
        String sql = " SELECT `h_control_liquidos`.`Id`, `h_control_liquidos`.`FechaR`, `h_control_liquidos`.`Hora`, h_control_liquidos.IdVia , `i_viaadministracion`.`Nbre`, `h_control_liquidos`.`Clase`, `h_control_liquidos`.`Cantidad`, h_control_liquidos.Estado\n FROM `h_control_liquidos`\n INNER JOIN `i_viaadministracion`  ON (`h_control_liquidos`.`IdVia` = `i_viaadministracion`.`Id`)\n WHERE (`h_control_liquidos`.`IdAtencion` ='" + this.xidAtencion + "'   AND `h_control_liquidos`.`Estado` =1  AND  h_control_liquidos.Tipo=1) ORDER BY `h_control_liquidos`.`FechaR` DESC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xFilaEli = 0;
                while (xrs.next()) {
                    this.xmodeloEli.addRow(this.xdatos);
                    this.xmodeloEli.setValueAt(xrs.getString(1), this.xFilaEli, 0);
                    this.xmodeloEli.setValueAt(xrs.getString(2), this.xFilaEli, 1);
                    this.xmodeloEli.setValueAt(xrs.getString(3), this.xFilaEli, 2);
                    this.xmodeloEli.setValueAt(xrs.getString(4), this.xFilaEli, 3);
                    this.xmodeloEli.setValueAt(xrs.getString(5), this.xFilaEli, 4);
                    this.xmodeloEli.setValueAt(xrs.getString(6), this.xFilaEli, 5);
                    this.xmodeloEli.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xFilaEli, 6);
                    this.xmodeloEli.setValueAt(Integer.valueOf(xrs.getInt(8)), this.xFilaEli, 7);
                    this.JTDetalleEli.setDefaultRenderer(Object.class, new MiRender());
                    this.xFilaEli++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlLiquidos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTDetalle.getRowCount() > -1) {
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (this.xmodeloIng.getValueAt(i, 7).toString().equals("0")) {
                        String sql1 = "INSERT INTO  `h_control_liquidos` (`IdAtencion`, `IdUsuario`,\n      `Tipo`, `FechaR`, `Hora`, `IdVia`, `Clase`, `Cantidad`, `IdProfesional`, `IdEspecialidad`, `UsuarioS`)\n VALUES ( '" + this.xidAtencion + "', '" + this.xidPersona + "', '0', '" + this.xmodeloIng.getValueAt(i, 1) + "',  '" + this.xmodeloIng.getValueAt(i, 2) + "', '" + this.xmodeloIng.getValueAt(i, 3) + "', '" + this.xmodeloIng.getValueAt(i, 5) + "', '" + Double.parseDouble(this.xmodeloIng.getValueAt(i, 6).toString()) + "',\n         '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql1);
                        this.xct.cerrarConexionBd();
                    }
                }
            }
            if (this.JTDetalleEli.getRowCount() > -1) {
                for (int i2 = 0; i2 < this.JTDetalleEli.getRowCount(); i2++) {
                    if (this.xmodeloEli.getValueAt(i2, 7).toString().equals("0")) {
                        String sql2 = "INSERT INTO  `h_control_liquidos` (`IdAtencion`, `IdUsuario`,\n      `Tipo`, `FechaR`, `Hora`, `IdVia`, `Clase`, `Cantidad`, `IdProfesional`, `IdEspecialidad`, `UsuarioS`)\n VALUES ( '" + this.xidAtencion + "', '" + this.xidPersona + "', '1', '" + this.xmodeloEli.getValueAt(i2, 1) + "',  '" + this.xmodeloEli.getValueAt(i2, 2) + "', '" + this.xmodeloEli.getValueAt(i2, 3) + "', '" + this.xmodeloEli.getValueAt(i2, 5) + "', '" + Double.parseDouble(this.xmodeloEli.getValueAt(i2, 6).toString()) + "',\n         '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    }
                }
            }
            mBuscaIng();
            mBuscaEli();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPControlLiquidos$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int xestado = Integer.valueOf(table.getValueAt(row, 7).toString()).intValue();
            if (xestado == 1) {
                cell.setBackground(new Color(70, 87, 240));
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mImprimir() {
        if (this.JTDetalle.getRowCount() > -1 || this.JTDetalleEli.getRowCount() > -1) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xidAtencion;
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ControlLiquidos", mparametros);
        }
    }
}
