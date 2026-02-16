package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Laboratorio.Imprimir;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.laboratorio.dto.StickerPrintDto;
import com.genoma.plus.dao.impl.laboratorio.RecepcionStikerDAOImpl;
import com.genoma.plus.dao.laboratorio.RecepcionStikerDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFRecepcionStikersCitologia.class */
public class JIFRecepcionStikersCitologia extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private RecepcionStikerDAO xRecepcionStikerDAO;
    private String[] xIdMunicipio;
    private String IdConcatenado;
    private List<JCheckBox> checkBoxes;
    private List<String> listSedes;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDPeriodo;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFBuscar;
    private JTextField JTFDesde;
    private JTextField JTFFalseCombobox;
    private JTextField JTFHasta;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPopupMenu jPopupMenu1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos(false);
    private boolean xlleno = false;
    private String listSedesSeleccionadas = "";

    public JIFRecepcionStikersCitologia() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRecepcionStikerDAO = (RecepcionStikerDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("recepcionStikerDAO");
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCHFiltro.setSelected(false);
        this.JCHSeleccionar.setSelected(true);
        mCargarComboSede();
        mCreaModeloTabla();
        this.IdConcatenado = "";
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "IdRecepcion", "No. Documento", "Usuario", "Sede", "Impreso?", "idRecepcion", "idOrden"}) { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.1
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    public void mBuscar() {
        mCargarDatos();
    }

    private void mCargarComboSede() {
        try {
            this.jPopupMenu1.removeAll();
            this.checkBoxes = new ArrayList();
            this.listSedes = new ArrayList();
            ResultSet xrs = this.xct.traerRs("SELECT\n\tgs.Id,\n\tconcat(gs.Nbre,' (',gm.Nbre,')') as sede\nFROM\n\tl_detallerecepcion ld\nINNER JOIN l_recepcion lr on\n\t(ld.Id_Recepcion = lr.Id)\nINNER JOIN g_sedes gs on\n\t(lr.Id_Sede = gs.Id)\nINNER JOIN g_procedimiento gp ON\n\t(ld.Id_Procedim = gp.Id)\nINNER JOIN g_municipio gm  ON\n\t(gs.Id_Municipio = gm.Id )\nWHERE\n\t(lr.Estado = 0)\nGROUP BY gs.Id\nORDER BY gs.Nbre ASC");
            Throwable th = null;
            try {
                try {
                    mCreaModeloTabla();
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        while (xrs.next()) {
                            this.listSedes.add(xrs.getString(1));
                            JCheckBox checkBox = new JCheckBox(xrs.getString(2));
                            checkBox.addItemListener(e -> {
                                updateTextField();
                            });
                            this.checkBoxes.add(checkBox);
                            this.jPopupMenu1.add(checkBox);
                        }
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                    updateTextField();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Imprimir.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatos() {
        List<Object[]> list;
        if (this.JCHFiltro.isSelected()) {
            list = this.xRecepcionStikerDAO.ListRecepcionStikersCitologiaBySedes(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), null, this.JTFBuscar.getText(), 0);
        } else {
            list = this.xRecepcionStikerDAO.ListRecepcionStikersCitologiaBySedes(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.listSedesSeleccionadas, this.JTFBuscar.getText(), 1);
        }
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(false, x, 0);
            this.xmodelo.setValueAt(list.get(x)[0], x, 1);
            this.xmodelo.setValueAt(list.get(x)[1], x, 2);
            this.xmodelo.setValueAt(list.get(x)[2], x, 3);
            this.xmodelo.setValueAt(list.get(x)[3], x, 4);
            if (Integer.parseInt(list.get(x)[5].toString()) == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
            this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo.setValueAt(list.get(x)[7], x, 7);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        }
        mConcatenar();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFRecepcionStikersCitologia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean Impreso = Boolean.parseBoolean(table.getValueAt(row, 5).toString());
            if (Impreso) {
                cell.setBackground(Color.green);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void togglePopup() {
        if (this.jPopupMenu1.isVisible()) {
            this.jPopupMenu1.setVisible(false);
        } else {
            showPopup();
        }
    }

    private void showPopup() {
        Point location = this.JTFFalseCombobox.getLocationOnScreen();
        this.jPopupMenu1.setLocation(location.x, location.y + this.JTFFalseCombobox.getHeight());
        this.jPopupMenu1.setVisible(true);
    }

    private void updateTextField() {
        List<String> seleccionados = new ArrayList<>();
        StringBuilder idSedes = new StringBuilder();
        for (int x = 0; x < this.checkBoxes.size(); x++) {
            if (this.checkBoxes.get(x).isSelected()) {
                seleccionados.add(this.checkBoxes.get(x).getText());
                idSedes.append(",").append(this.listSedes.get(x));
            }
        }
        this.listSedesSeleccionadas = idSedes.length() > 0 ? idSedes.substring(1) : "";
        this.JTFFalseCombobox.setText(seleccionados.isEmpty() ? "Seleccionar opciones..." : "Sedes Seleccionadas (" + seleccionados.size() + ")");
    }

    private void mSeleccionar(boolean xestado) {
        this.IdConcatenado = "";
        if (this.JTDetalle.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 0);
                this.IdConcatenado += this.xmodelo.getValueAt(x, 6).toString() + ",";
            }
        }
    }

    private void mConcatenar() {
        this.IdConcatenado = "";
        if (this.JTDetalle.getRowCount() > 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.parseBoolean(this.xmodelo.getValueAt(x, 0).toString())) {
                    this.IdConcatenado += this.xmodelo.getValueAt(x, 6).toString() + ",";
                }
            }
        }
    }

    public void mImprimir() {
        Object[] botones = {"Visualizacion", "Impresion", "Cerrar"};
        int n = JOptionPane.showOptionDialog((Component) null, "Que desea hacer?", "FORMA DE GENERACIÓN DE STIKER", 0, 3, (Icon) null, botones, "Cerrar");
        if (n == 0) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.IdConcatenado + "-1";
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            System.out.println(this.xmt.getRutaRep());
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                this.xmt.PresentacionImpresora("l_stiker_n_Historico_Fonnegra.jasper", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "l_stiker_n_Historico", parametros);
                return;
            }
        }
        if (n == 1) {
            String sql = "update l_recepcion set ImpresionStiker = 1 where Id IN(" + this.IdConcatenado + " -1)";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            Map<String, Object> parameters = new HashMap<>();
            List<String> lista = Arrays.asList(this.IdConcatenado.split(","));
            parameters.put("idRecepcion", lista);
            StickerPrintDto stickerPrintDto = this.xmt.getInfoStickerV2("JIFRecepcionStickerCitologias", parameters);
            this.xmt.mImprimir_CodBarraZebraV2(stickerPrintDto);
            String sql2 = "update l_recepcion set ImpresionStiker = 1 where Id IN(" + this.IdConcatenado + " -1)";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPopupMenu1 = new JPopupMenu();
        this.JPIDPeriodo = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHFiltro = new JCheckBox();
        this.JCHSeleccionar = new JCheckBox();
        this.JTFFalseCombobox = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFBuscar = new JTextField();
        this.jPanel1 = new JPanel();
        this.JTFDesde = new JTextField();
        this.JTFHasta = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPRESIÓN DE STIKERS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_recepcionstikers_citologia");
        this.JPIDPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "PERÍODO", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikersCitologia.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikersCitologia.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.4
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcionStikersCitologia.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.5
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcionStikersCitologia.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JTFFalseCombobox.setEditable(false);
        this.JTFFalseCombobox.setFont(new Font("Arial", 1, 12));
        this.JTFFalseCombobox.setText("Seleccionar opciones...");
        this.JTFFalseCombobox.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFalseCombobox.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.6
            public void mouseClicked(MouseEvent evt) {
                JIFRecepcionStikersCitologia.this.JTFFalseComboboxMouseClicked(evt);
            }

            public void mousePressed(MouseEvent evt) {
                JIFRecepcionStikersCitologia.this.JTFFalseComboboxMousePressed(evt);
            }
        });
        GroupLayout JPIDPeriodoLayout = new GroupLayout(this.JPIDPeriodo);
        this.JPIDPeriodo.setLayout(JPIDPeriodoLayout);
        JPIDPeriodoLayout.setHorizontalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHFiltro).addComponent(this.JCHSeleccionar, GroupLayout.Alignment.TRAILING)).addContainerGap()).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(261, 261, 261).addComponent(this.JTFFalseCombobox, -2, 348, -2).addContainerGap(150, 32767))));
        JPIDPeriodoLayout.setVerticalGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 55, -2).addComponent(this.JDFechaF, -2, 55, -2))).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar))).addGap(10, 10, 10)).addGroup(JPIDPeriodoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPeriodoLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JTFFalseCombobox, -2, -1, -2).addContainerGap(25, 32767))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.7
            public void mouseClicked(MouseEvent evt) {
                JIFRecepcionStikersCitologia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFRecepcionStikersCitologia.this.JTDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por usuario / número recepcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.9
            public void keyPressed(KeyEvent evt) {
                JIFRecepcionStikersCitologia.this.JTFBuscarKeyPressed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por rango de recepciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.JTFDesde.setFont(new Font("Arial", 1, 16));
        this.JTFDesde.setHorizontalAlignment(0);
        this.JTFHasta.setFont(new Font("Arial", 1, 16));
        this.JTFHasta.setHorizontalAlignment(0);
        this.JTFHasta.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFRecepcionStikersCitologia.10
            public void keyPressed(KeyEvent evt) {
                JIFRecepcionStikersCitologia.this.JTFHastaKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Desde");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Hasta");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDesde, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFHasta, -2, 104, -2).addContainerGap(18, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDesde, -2, -1, -2).addComponent(this.JTFHasta, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(0, 0, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFBuscar, -2, 245, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -1, 881, 32767).addComponent(this.JPIDPeriodo, -1, -1, 32767)).addGap(10, 10, 10)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDPeriodo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 369, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFBuscar, -1, 54, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap(22, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarComboSede();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarComboSede();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mCargarComboSede();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        mConcatenar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMouseClicked(MouseEvent evt) {
        togglePopup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFalseComboboxMousePressed(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHastaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            if (!this.JTFDesde.getText().isEmpty()) {
                List<Object[]> list = this.xRecepcionStikerDAO.ListRecepcionByRangosCitologia(Integer.valueOf(this.JTFDesde.getText()), Integer.valueOf(this.JTFHasta.getText()));
                mCreaModeloTabla();
                for (int x = 0; x < list.size(); x++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(false, x, 0);
                    this.xmodelo.setValueAt(list.get(x)[0], x, 1);
                    this.xmodelo.setValueAt(list.get(x)[1], x, 2);
                    this.xmodelo.setValueAt(list.get(x)[2], x, 3);
                    this.xmodelo.setValueAt(list.get(x)[3], x, 4);
                    if (Integer.parseInt(list.get(x)[5].toString()) == 1) {
                        this.xmodelo.setValueAt(true, x, 5);
                    } else {
                        this.xmodelo.setValueAt(false, x, 5);
                    }
                    this.xmodelo.setValueAt(list.get(x)[6], x, 6);
                    this.xmodelo.setValueAt(list.get(x)[7], x, 7);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                }
                mConcatenar();
                return;
            }
            JOptionPane.showInternalOptionDialog(this, "Ingrese un valor inicial", "BUSCAR", 1, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            Principal.claselab.cargarPantalla("Recepcion");
            Principal.claselab.frmRecep.txtNoOrden.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            Principal.claselab.frmRecep.buscarOrden();
            Principal.claselab.frmRecep.activarNumeracionCitologia();
            Principal.txtNo.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            dispose();
        }
    }
}
