package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaInicial.class */
public class JPOdontogramaInicial extends JPanel {
    private Object[] datos;
    private Object[] datosProcedimiento;
    public DefaultTableModel modelo;
    public DefaultTableModel modeloProcedimiento;
    private JPPaletaConvenciones jifpaletaConvenciones;
    private JPOdontogramaDientes jpodontogramaDientes;
    private JPOdontogramaDientes jpodontogramaDientesProcedimiento;
    private String numeroDiente;
    private String numeroCara;
    public String labelDiente;
    public String panelDiente;
    private clasesHistoriaCE claseHistoriaClinica;
    private List<Integer> cantidadDientesMarcados;
    private JLabel JLBNMarcados;
    private JPanel JPDx;
    private JPanel JPImOdontograma;
    private JPanel JPOdontogramaI;
    private JScrollPane JSPDetalleO;
    private JScrollPane JSPDetalleOProc;
    private JPanel JSPPaleta;
    public JTable JTDetalleOdontologia;
    private JTable JTDetalleProc;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPDatosDxProc;
    private JPanel jPanel1;
    public int tipo = 1;
    private ConsultasMySQL consultasMySql = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private long ladoGeneral = 0;
    public long controlFigura = 0;
    private int dienteGeneral = 0;
    private int numeroFilas = 0;
    private int filasProcedimiento = 0;
    public long tipoprocedimiento = 0;

    public JPOdontogramaInicial() {
        initComponents();
        mNuevo();
        crearModeloTablaDx();
        crearModeloTablaProcedimiento();
        cargarDxProcedimientos();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPOdontogramaI = new JPanel();
        this.JPImOdontograma = new JPanel();
        this.JTPDatosDxProc = new JTabbedPane();
        this.JPDx = new JPanel();
        this.JSPDetalleO = new JScrollPane();
        this.JTDetalleOdontologia = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPDetalleOProc = new JScrollPane();
        this.JTDetalleProc = new JTable();
        this.JLBNMarcados = new JLabel();
        this.JSPPaleta = new JPanel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA INICIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifOdontogramaI");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPImOdontograma.setBackground(new Color(255, 255, 255));
        GroupLayout JPImOdontogramaLayout = new GroupLayout(this.JPImOdontograma);
        this.JPImOdontograma.setLayout(JPImOdontogramaLayout);
        JPImOdontogramaLayout.setHorizontalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPImOdontogramaLayout.setVerticalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 340, 32767));
        this.JTPDatosDxProc.setForeground(new Color(255, 0, 0));
        this.JTPDatosDxProc.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleO.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DIANÓSTICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleOdontologia.setFont(new Font("Arial", 1, 12));
        this.JTDetalleOdontologia.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleOdontologia.setRowHeight(25);
        this.JTDetalleOdontologia.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleOdontologia.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleOdontologia.setSelectionMode(0);
        this.JTDetalleOdontologia.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaInicial.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaInicial.this.JTDetalleOdontologiaMouseClicked(evt);
            }
        });
        this.JTDetalleOdontologia.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontogramaInicial.2
            public void keyPressed(KeyEvent evt) {
                JPOdontogramaInicial.this.JTDetalleOdontologiaKeyPressed(evt);
            }
        });
        this.JSPDetalleO.setViewportView(this.JTDetalleOdontologia);
        GroupLayout JPDxLayout = new GroupLayout(this.JPDx);
        this.JPDx.setLayout(JPDxLayout);
        JPDxLayout.setHorizontalGroup(JPDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDxLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleO, -1, 674, 32767).addContainerGap()));
        JPDxLayout.setVerticalGroup(JPDxLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDxLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleO, -1, 195, 32767).addContainerGap()));
        this.JTPDatosDxProc.addTab("Diagnósticos", this.JPDx);
        this.JSPDetalleOProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProc.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProc.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProc.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontogramaInicial.3
            public void keyPressed(KeyEvent evt) {
                JPOdontogramaInicial.this.JTDetalleProcKeyPressed(evt);
            }
        });
        this.JSPDetalleOProc.setViewportView(this.JTDetalleProc);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 694, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JSPDetalleOProc, -1, 679, 32767).addGap(8, 8, 8))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 207, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleOProc, -1, 195, 32767).addContainerGap())));
        this.JTPDatosDxProc.addTab("Procedimientos", this.jPanel1);
        this.JLBNMarcados.setFont(new Font("Arial", 1, 14));
        this.JLBNMarcados.setHorizontalAlignment(0);
        this.JLBNMarcados.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Marcados", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPOdontogramaILayout = new GroupLayout(this.JPOdontogramaI);
        this.JPOdontogramaI.setLayout(JPOdontogramaILayout);
        JPOdontogramaILayout.setHorizontalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontograma, -1, -1, 32767).addComponent(this.JTPDatosDxProc).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaILayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLBNMarcados, -2, 111, -2)));
        JPOdontogramaILayout.setVerticalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JPImOdontograma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNMarcados, -1, 36, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosDxProc, -2, 250, -2).addContainerGap()));
        this.JTPDatos.addTab("DIANÓSTICOS Y PROCEDIMIENTOS", this.JPOdontogramaI);
        this.JSPPaleta.setMinimumSize(new Dimension(100, 600));
        this.JSPPaleta.setPreferredSize(new Dimension(165, 600));
        GroupLayout JSPPaletaLayout = new GroupLayout(this.JSPPaleta);
        this.JSPPaleta.setLayout(JSPPaletaLayout);
        JSPPaletaLayout.setHorizontalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        JSPPaletaLayout.setVerticalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPPaleta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.JSPPaleta, GroupLayout.Alignment.TRAILING, -1, 690, 32767));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOdontologiaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOdontologiaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGridProcedimiento();
        }
    }

    public void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila seleccionada?") == 0) {
            this.modelo.removeRow(this.JTDetalleOdontologia.getSelectedRow());
            this.numeroFilas--;
            this.metodos.mostrarMensaje("Registro Eliminado");
        }
    }

    public void eliminarFilaGridProcedimiento() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila seleccionada?") == 0) {
            this.modeloProcedimiento.removeRow(this.JTDetalleProc.getSelectedRow());
            this.filasProcedimiento--;
            this.metodos.mostrarMensaje("Registro Eliminado");
        }
    }

    private void cargarDxProcedimientos() {
        traerDatosDientesDx();
        cargarDatosProcedimientos();
        traerDatosDientesProc();
    }

    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, 1);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    private void mNuevo() {
        cargarPanelConvenciones();
        cargarPanelOdontograma();
        this.JLBNMarcados.setText("0");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaDx() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N°Diente", "Cara", "Proceso", "Observacion", "esCavitacional", "esObturacionCarie", "esPerdidoCarie"}) { // from class: Odontologia.JPOdontogramaInicial.4
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleOdontologia;
        JTable jTable2 = this.JTDetalleOdontologia;
        jTable.setAutoResizeMode(0);
        this.JTDetalleOdontologia.doLayout();
        this.JTDetalleOdontologia.setModel(this.modelo);
        this.JTDetalleOdontologia.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleOdontologia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleOdontologia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleOdontologia.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleOdontologia.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleOdontologia.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalleOdontologia.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleOdontologia.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleOdontologia.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleOdontologia.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.numeroFilas = 0;
    }

    private void adicionarTabla() {
        int esCavitacional;
        int esPerdidoCarie;
        int esObturadoCarie;
        if (!verificarDienteTabla(this.dienteGeneral, this.jifpaletaConvenciones.procedimientoPaleta, this.modelo)) {
            esCavitacional = -1;
            esPerdidoCarie = -1;
            esObturadoCarie = -1;
            switch (this.jifpaletaConvenciones.procedimientoPaleta) {
                case "Caries":
                    if (this.JTDetalleOdontologia.getRowCount() > 0) {
                        if (this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 1).toString().equals(this.numeroDiente)) {
                            esCavitacional = Integer.parseInt(this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 5).toString());
                        } else if (JOptionPane.showConfirmDialog((Component) null, "Carie seleccionada es cavitacional?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                            esCavitacional = 1;
                        } else {
                            esCavitacional = 0;
                        }
                        break;
                    } else {
                        if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Caries")) {
                            esCavitacional = JOptionPane.showConfirmDialog((Component) null, "Carie seleccionada es cavitacional?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                        }
                        break;
                    }
                    break;
                case "Amalgama Desadaptada":
                case "Ionomero Bueno":
                case "Amalgama Buena":
                case "Ionomero Desadaptado":
                case "Ionomero Indicado":
                case "Resina Buena":
                case "Resina Desadaptada":
                case "Resina Indicada":
                    if (this.JTDetalleOdontologia.getRowCount() > 0) {
                        if (this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 1).toString().equals(this.numeroDiente)) {
                            esObturadoCarie = Integer.parseInt(this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 5).toString());
                        } else if (JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                            esObturadoCarie = 1;
                        } else {
                            esObturadoCarie = 0;
                        }
                        break;
                    } else {
                        if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Amalgama Desadaptada") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Amalgama Buena") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Bueno") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Desadaptado") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Indicado") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Buena") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Desadaptada") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Indicada")) {
                            esObturadoCarie = JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                        }
                        break;
                    }
                    break;
                case "Extracciones - Diente Ausente Clinicamente":
                case "Extraccion Indicada":
                case "Extracciones - Zona Desdentada Remplazada":
                    if (this.JTDetalleOdontologia.getRowCount() > 0) {
                        if (this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 1).toString().equals(this.numeroDiente)) {
                            esPerdidoCarie = Integer.valueOf(this.JTDetalleOdontologia.getValueAt(this.JTDetalleOdontologia.getRowCount() - 1, 5).toString()).intValue();
                        } else if (JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                            esPerdidoCarie = 1;
                        } else {
                            esPerdidoCarie = 0;
                        }
                        break;
                    } else {
                        if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Extracciones - Diente Ausente Clinicamente") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Extraccion Indicada") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Extracciones - Zona Desdentada Remplazada")) {
                            esPerdidoCarie = JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                        }
                        break;
                    }
                    break;
            }
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(Integer.valueOf(this.dienteGeneral), this.JTDetalleOdontologia.getRowCount() - 1, 0);
            this.modelo.setValueAt(this.numeroDiente, this.JTDetalleOdontologia.getRowCount() - 1, 1);
            this.modelo.setValueAt(this.numeroCara, this.JTDetalleOdontologia.getRowCount() - 1, 2);
            this.modelo.setValueAt(this.jifpaletaConvenciones.procedimientoPaleta, this.JTDetalleOdontologia.getRowCount() - 1, 3);
            this.modelo.setValueAt("", this.JTDetalleOdontologia.getRowCount() - 1, 4);
            this.modelo.setValueAt(Integer.valueOf(esCavitacional), this.JTDetalleOdontologia.getRowCount() - 1, 5);
            this.modelo.setValueAt(Integer.valueOf(esObturadoCarie), this.JTDetalleOdontologia.getRowCount() - 1, 6);
            this.modelo.setValueAt(Integer.valueOf(esPerdidoCarie), this.JTDetalleOdontologia.getRowCount() - 1, 7);
            this.numeroFilas++;
            this.controlFigura = 0L;
            verificarCantidadDientesMarcados();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaProcedimiento() {
        this.modeloProcedimiento = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N° Diente", "Cara", "Proceso", "Observación", "Realizado", "esObturacionCarie", "esPerdidoCarie"}) { // from class: Odontologia.JPOdontogramaInicial.5
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleProc;
        JTable jTable2 = this.JTDetalleOdontologia;
        jTable.setAutoResizeMode(0);
        this.JTDetalleProc.doLayout();
        this.JTDetalleProc.setModel(this.modeloProcedimiento);
        this.JTDetalleProc.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleProc.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleProc.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleProc.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalleProc.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.filasProcedimiento = 0;
    }

    public boolean verificarEdadDientesMarcados() {
        verificarCantidadDientesMarcados();
        boolean estado = false;
        String[] datos = clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad().split(" ");
        int edad = Integer.valueOf(datos[0]).intValue();
        System.out.println("" + edad);
        System.out.println("" + this.JLBNMarcados.getText());
        if (edad < 5 && Integer.valueOf(this.JLBNMarcados.getText()).intValue() < 20) {
            estado = true;
        } else if (edad >= 5 && Integer.valueOf(this.JLBNMarcados.getText()).intValue() <= 32) {
            estado = true;
        }
        return estado;
    }

    public void verificarCantidadDientesMarcados() {
        this.cantidadDientesMarcados = new ArrayList();
        for (int i = 0; i < this.JTDetalleOdontologia.getRowCount(); i++) {
            this.cantidadDientesMarcados.add(Integer.valueOf(this.JTDetalleOdontologia.getValueAt(i, 1).toString()));
        }
        for (int i2 = 0; i2 < this.JTDetalleProc.getRowCount(); i2++) {
            this.cantidadDientesMarcados.add(Integer.valueOf(this.JTDetalleProc.getValueAt(i2, 1).toString()));
        }
        Collections.sort(this.cantidadDientesMarcados);
        int posicionInicial = 0;
        int numeroMarcardos = 0;
        for (int i3 = 0; i3 < this.cantidadDientesMarcados.size(); i3++) {
            if (posicionInicial != this.cantidadDientesMarcados.get(i3).intValue()) {
                numeroMarcardos++;
                posicionInicial = this.cantidadDientesMarcados.get(i3).intValue();
            }
        }
        this.JLBNMarcados.setText("" + numeroMarcardos);
    }

    private void adicionarTablaProc() {
        if (!verificarDienteTabla(this.dienteGeneral, this.jifpaletaConvenciones.procedimientoPaleta, this.modeloProcedimiento)) {
            int esPerdidoCarie = -1;
            int esObturadoCarie = -1;
            System.out.println("paleta : " + this.jifpaletaConvenciones.procedimientoPaleta);
            if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Amalgama Desadaptada") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Amalgama Buena") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Bueno") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Desadaptado") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Ionomero Indicado") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Buena") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Desadaptada") || this.jifpaletaConvenciones.procedimientoPaleta.equals("Resina Indicada")) {
                esObturadoCarie = this.JTDetalleProc.getRowCount() > 0 ? this.JTDetalleProc.getValueAt(this.JTDetalleProc.getRowCount() - 1, 1).toString().equals(this.numeroDiente) ? Integer.valueOf(this.JTDetalleProc.getValueAt(this.JTDetalleProc.getRowCount() - 1, 6).toString()).intValue() : JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0 : JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
            } else if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Extraccion de Diente")) {
                if (this.JTDetalleProc.getRowCount() > 0) {
                    esPerdidoCarie = this.JTDetalleProc.getValueAt(this.JTDetalleProc.getRowCount() - 1, 1).toString().equals(this.numeroDiente) ? Integer.valueOf(this.JTDetalleProc.getValueAt(this.JTDetalleProc.getRowCount() - 1, 7).toString()).intValue() : JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                } else if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Extraccion de Diente")) {
                    esPerdidoCarie = JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                }
            }
            this.modeloProcedimiento.addRow(this.datosProcedimiento);
            this.modeloProcedimiento.setValueAt(Integer.valueOf(this.dienteGeneral), this.JTDetalleProc.getRowCount() - 1, 0);
            this.modeloProcedimiento.setValueAt(this.numeroDiente, this.JTDetalleProc.getRowCount() - 1, 1);
            this.modeloProcedimiento.setValueAt(this.numeroCara, this.JTDetalleProc.getRowCount() - 1, 2);
            this.modeloProcedimiento.setValueAt(this.jifpaletaConvenciones.procedimientoPaleta, this.JTDetalleProc.getRowCount() - 1, 3);
            this.modeloProcedimiento.setValueAt("", this.JTDetalleProc.getRowCount() - 1, 4);
            this.modeloProcedimiento.setValueAt(false, this.JTDetalleProc.getRowCount() - 1, 5);
            this.modeloProcedimiento.setValueAt(Integer.valueOf(esObturadoCarie), this.JTDetalleProc.getRowCount() - 1, 6);
            this.modeloProcedimiento.setValueAt(Integer.valueOf(esPerdidoCarie), this.JTDetalleProc.getRowCount() - 1, 7);
            this.filasProcedimiento++;
            this.controlFigura = 0L;
            verificarCantidadDientesMarcados();
        }
    }

    private boolean verificarDienteTabla(int idDiente, String proceso, DefaultTableModel modelo) {
        boolean existe = false;
        int i = 0;
        while (true) {
            if (i < modelo.getRowCount()) {
                if (Integer.valueOf(modelo.getValueAt(i, 0).toString()).intValue() != idDiente || !modelo.getValueAt(i, 3).toString().equals(proceso)) {
                    i++;
                } else {
                    existe = true;
                    break;
                }
            } else {
                break;
            }
        }
        return existe;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaInicial$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 5).toString()).longValue() == 0) {
                cell.setBackground(new Color(255, 102, 0));
            } else {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    private void cargarPanelConvenciones() {
        this.jifpaletaConvenciones = new JPPaletaConvenciones(this);
        this.jifpaletaConvenciones.setVisible(false);
        this.JSPPaleta.setVisible(false);
        this.jifpaletaConvenciones.setBounds(1, 1, 165, 680);
        this.JSPPaleta.add(this.jifpaletaConvenciones);
        this.JSPPaleta.setVisible(true);
        this.jifpaletaConvenciones.setVisible(true);
    }

    private void cargarPanelOdontograma() {
        this.jpodontogramaDientes = new JPOdontogramaDientes(this);
        this.jpodontogramaDientes.setVisible(false);
        this.JPImOdontograma.setVisible(false);
        this.jpodontogramaDientes.Verde.setVisible(false);
        this.jpodontogramaDientes.Amarillo.setVisible(false);
        this.jpodontogramaDientes.Rojo.setVisible(false);
        this.jpodontogramaDientes.setBounds(1, 1, 699, 340);
        this.JPImOdontograma.add(this.jpodontogramaDientes);
        this.JPImOdontograma.setVisible(true);
        this.jpodontogramaDientes.setVisible(true);
    }

    public void asignarFigura(JPanel panel) {
        if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
            montarFigurar(panel);
            return;
        }
        if (Integer.valueOf(panel.getName()).intValue() == 18 || Integer.valueOf(panel.getName()).intValue() == 28 || Integer.valueOf(panel.getName()).intValue() == 38 || Integer.valueOf(panel.getName()).intValue() == 48) {
            montarFigurar(panel);
        } else if (verificarEdadDientesMarcados()) {
            montarFigurar(panel);
        } else {
            JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>No se puden hacer mas registros de los máximo&nbsp;permitidos; </p><font face='Arial' color='red' size=4><br>- 20 dientes para los menores de 5 años <br>- 28 para las personas de 5 años y más años de edad. <br>COP por persona(Resolución 202 de 2021)</html>", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void montarFigurar(JPanel panel) {
        if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 42.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 49.0d) {
            System.out.println("Cara Abajo 2");
            this.ladoGeneral = 6L;
            traerDatosDientes(panel);
            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                quitarElementoOdontograma(panel);
            } else {
                recorrerPanel(panel, "6", this.jifpaletaConvenciones.procedimientoPaleta);
                this.controlFigura = 1L;
                verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
            }
        } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 53.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 62.0d) {
            System.out.println("Cara Abajo 1");
            this.ladoGeneral = 7L;
            traerDatosDientes(panel);
            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                quitarElementoOdontograma(panel);
            } else {
                recorrerPanel(panel, "7", this.jifpaletaConvenciones.procedimientoPaleta);
                this.controlFigura = 1L;
                verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
            }
        } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() < 30.0d || Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() > 42.0d) {
            if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 24.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 29.0d) {
                System.out.println("Cara Arriba 2 ");
                this.ladoGeneral = 2L;
                traerDatosDientes(panel);
                if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "2", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 10.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 20.0d) {
                System.out.println("Cara Arriba 1 ");
                this.ladoGeneral = 1L;
                traerDatosDientes(panel);
                if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "1", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
                }
            }
        } else if (panel.getMousePosition().x >= 23 && panel.getMousePosition().x <= 33) {
            System.out.println("Derecha");
            this.ladoGeneral = 3L;
            traerDatosDientes(panel);
            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                quitarElementoOdontograma(panel);
            } else {
                recorrerPanel(panel, "3", this.jifpaletaConvenciones.procedimientoPaleta);
                this.controlFigura = 1L;
                verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
            }
        } else if (panel.getMousePosition().x >= 16 && panel.getMousePosition().x <= 22) {
            System.out.println("Centro");
            this.ladoGeneral = 4L;
            traerDatosDientes(panel);
            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                quitarElementoOdontograma(panel);
            } else {
                recorrerPanel(panel, "4", this.jifpaletaConvenciones.procedimientoPaleta);
                this.controlFigura = 1L;
                verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
            }
        } else if (panel.getMousePosition().x >= 0 && panel.getMousePosition().x <= 15) {
            System.out.println("IZquierda");
            this.ladoGeneral = 5L;
            traerDatosDientes(panel);
            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                quitarElementoOdontograma(panel);
            } else {
                recorrerPanel(panel, "5", this.jifpaletaConvenciones.procedimientoPaleta);
                this.controlFigura = 1L;
                verificarTipoProceso(this.jifpaletaConvenciones.procedimientoPaleta);
            }
        }
        if (verificarProcesoLado(panel)) {
            System.out.println("Si tiene capa 8...");
        }
    }

    private void recorrerPanel(JPanel panel, String xlado, String procesoedimiento) {
        String sql;
        try {
            if (this.jifpaletaConvenciones.completo == 0) {
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `baseserver`.`o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procesoedimiento + "' AND o_odontograma_figuras.Lado='" + xlado + "')";
            } else {
                xlado = "8";
                this.ladoGeneral = 8L;
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `baseserver`.`o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procesoedimiento + "' AND o_odontograma_figuras.Lado='" + xlado + "' AND o_odontograma_figuras.`Sombra`=0)";
            }
            System.out.println("datos que entran " + panel + "-" + xlado + "-" + procesoedimiento + "sql: " + sql);
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                String ruta = this.metodos.getDirectorioExportacion() + resultSet.getString("Ruta").replace("\\", this.metodos.getBarra());
                int x = 0;
                while (true) {
                    if (x >= panel.getComponentCount()) {
                        break;
                    }
                    if (panel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                        JLabel jlabel = panel.getComponent(x);
                        if (jlabel.getName().equals(xlado)) {
                            jlabel.setIcon(new ImageIcon(ruta));
                            break;
                        }
                    }
                    x++;
                }
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void quitarElementoOdontograma(JPanel panel) {
        int x = 0;
        while (true) {
            if (x >= panel.getComponentCount()) {
                break;
            }
            if (panel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel jlabel = panel.getComponent(x);
                if (jlabel.getName().equals(Long.valueOf(this.ladoGeneral).toString())) {
                    jlabel.setIcon((Icon) null);
                    this.controlFigura = 0L;
                    break;
                }
            }
            x++;
        }
        for (int i = 0; i < this.JTDetalleOdontologia.getRowCount(); i++) {
            if (Objects.equals(Integer.valueOf(this.JTDetalleOdontologia.getValueAt(i, 1).toString()), Integer.valueOf(panel.getName()))) {
                this.modelo.removeRow(i);
            }
        }
        for (int i2 = 0; i2 < this.JTDetalleProc.getRowCount(); i2++) {
            if (Objects.equals(Integer.valueOf(this.JTDetalleProc.getValueAt(i2, 1).toString()), Integer.valueOf(panel.getName()))) {
                this.modeloProcedimiento.removeRow(i2);
            }
        }
        verificarCantidadDientesMarcados();
    }

    private void traerDatosDientes(JPanel panel) {
        try {
            if (this.jifpaletaConvenciones.completo == 1) {
                this.ladoGeneral = 8L;
            }
            String sql = "SELECT  `o_odontograma_diente_cara`.`Id` , `o_odontograma_diente`.`Nbre` AS diente , `o_odontograma_caras`.`Nbre` AS cara FROM `o_odontograma_diente_cara` INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_odontograma_diente_cara`.`Lado` ='" + this.ladoGeneral + "'   AND `o_odontograma_diente`.`Nbre` ='" + panel.getName() + "')";
            System.out.println("trae Dato dientes: " + sql);
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                this.dienteGeneral = resultSet.getInt(1);
                this.numeroDiente = resultSet.getString(2);
                this.numeroCara = resultSet.getString(3);
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesDx() {
        String sql;
        try {
            if (Principal.informacionIps.getAplica3280().intValue() == 0) {
                sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicialdx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_odontograma_inicialdx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicialdx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicialdx`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            } else {
                sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicialdx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_odontograma_inicialdx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicialdx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicialdx`.Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' and `o_hc_odontograma_inicialdx`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            }
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.jpodontogramaDientes.getComponentCount(); u++) {
                        if (this.jpodontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.jpodontogramaDientes.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel jlabel = jpanel.getComponent(x);
                                        if (jlabel.getName().equals(resultSet.getString(2))) {
                                            jlabel.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
            cargarDatosDx();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesProc() {
        String sql;
        try {
            if (Principal.informacionIps.getAplica3280().intValue() == 0) {
                sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicial_proc`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_odontograma_inicial_proc` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicial_proc`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicial_proc`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            } else {
                sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicial_proc`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_odontograma_inicial_proc` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicial_proc`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicial_proc`.Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' and `o_hc_odontograma_inicial_proc`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            }
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.jpodontogramaDientes.getComponentCount(); u++) {
                        if (this.jpodontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.jpodontogramaDientes.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel jlabel = jpanel.getComponent(x);
                                        if (jlabel.getName().equals(resultSet.getString(2))) {
                                            jlabel.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosDx() {
        try {
            crearModeloTablaDx();
            String sql = "SELECT  `o_hc_odontograma_inicialdx`.`IdDienteCara` , `o_odontograma_diente`.`Nbre` , `o_odontograma_caras`.`Nbre` , `o_hc_odontograma_inicialdx`.Proceso, IF(o_hc_odontograma_inicialdx.Observacion IS NULL,'',o_hc_odontograma_inicialdx.Observacion) AS Observacion, o_hc_odontograma_inicialdx.esCavitacional, o_hc_odontograma_inicialdx.esObturadoCarie, o_hc_odontograma_inicialdx.esPerdidaCarie   FROM `o_hc_odontograma_inicialdx` INNER JOIN  `o_odontograma_diente_cara`   ON (`o_hc_odontograma_inicialdx`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN  `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_hc_odontograma_inicialdx`.Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' and  `o_hc_odontograma_inicialdx`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') order by `o_odontograma_diente`.`Nbre` ASC";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet resultSet2 = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleOdontologia, 4);
            if (resultSet2.next()) {
                resultSet2.beforeFirst();
                this.numeroFilas = 0;
                while (resultSet2.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt(1)), this.numeroFilas, 0);
                    this.modelo.setValueAt(Long.valueOf(resultSet2.getLong(2)), this.numeroFilas, 1);
                    this.modelo.setValueAt(resultSet2.getString(3), this.numeroFilas, 2);
                    this.modelo.setValueAt(resultSet2.getString(4), this.numeroFilas, 3);
                    this.modelo.setValueAt(resultSet2.getString(5), this.numeroFilas, 4);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt("esCavitacional")), this.numeroFilas, 5);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt("esObturadoCarie")), this.numeroFilas, 6);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt("esPerdidaCarie")), this.numeroFilas, 7);
                    this.numeroFilas++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosProcedimientos() {
        try {
            crearModeloTablaProcedimiento();
            String sql = "SELECT  `o_hc_odontograma_inicial_proc`.`IdDienteCara` , `o_odontograma_diente`.`Nbre` , `o_odontograma_caras`.`Nbre` , `o_hc_odontograma_inicial_proc`.`Proceso` , IF(`o_hc_odontograma_inicial_proc`.`Observacion` IS NULL,'',`o_hc_odontograma_inicial_proc`.`Observacion`)AS Observacion , `o_hc_odontograma_inicial_proc`.`Estado`, o_hc_odontograma_inicial_proc.esObturadoCarie, o_hc_odontograma_inicial_proc.esPerdidaCarie FROM  `o_hc_odontograma_inicial_proc` INNER JOIN `baseserver`.`o_odontograma_diente_cara`  ON (`o_hc_odontograma_inicial_proc`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN  `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_hc_odontograma_inicial_proc`.Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' and `o_hc_odontograma_inicial_proc`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY `o_odontograma_diente`.`Nbre` ASC ";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet resultSet2 = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleProc, 4);
            if (resultSet2.next()) {
                resultSet2.beforeFirst();
                this.filasProcedimiento = 0;
                while (resultSet2.next()) {
                    this.modeloProcedimiento.addRow(this.datosProcedimiento);
                    this.modeloProcedimiento.setValueAt(Integer.valueOf(resultSet2.getInt(1)), this.filasProcedimiento, 0);
                    this.modeloProcedimiento.setValueAt(Long.valueOf(resultSet2.getLong(2)), this.filasProcedimiento, 1);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(3), this.filasProcedimiento, 2);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(4), this.filasProcedimiento, 3);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(5), this.filasProcedimiento, 4);
                    this.modeloProcedimiento.setValueAt(Boolean.valueOf(resultSet2.getBoolean(6)), this.filasProcedimiento, 5);
                    this.modeloProcedimiento.setValueAt(Integer.valueOf(resultSet2.getInt("esObturadoCarie")), this.filasProcedimiento, 6);
                    this.modeloProcedimiento.setValueAt(Integer.valueOf(resultSet2.getInt("esPerdidaCarie")), this.filasProcedimiento, 7);
                    this.filasProcedimiento++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Eliminar el Odontograma Inicial?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "DELETE FROM `o_hc_odontograma_inicial_proc` WHERE `Id_Tratamiento` = " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + " AND IdUsuario=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "";
            System.out.println("Eliminando Procedimientos Odontograma Inicial \n" + sql);
            this.consultasMySql.ejecutarSQL(sql);
            this.consultasMySql.cerrarConexionBd();
            String sql2 = "DELETE FROM `o_hc_odontograma_inicialdx` WHERE `Id_Tratamiento` = " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + " AND IdUsuario=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "";
            System.out.println("Eliminando Odontograma Incial \n" + sql2);
            this.consultasMySql.ejecutarSQL(sql2);
            this.consultasMySql.cerrarConexionBd();
            this.consultasMySql.ejecutarSQL("update o_hc_tratamiento_dx set Estado=0 where Id_Tratamiento=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "");
            this.consultasMySql.cerrarConexionBd();
            this.consultasMySql.ejecutarSQL("update o_hc_tratamiento_procedimiento set Estado=0 where Id_Tratamiento=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "");
            this.consultasMySql.cerrarConexionBd();
            this.JPImOdontograma.removeAll();
            this.JSPPaleta.removeAll();
            this.jpodontogramaDientes = null;
            this.jpodontogramaDientesProcedimiento = null;
            mNuevo();
            crearModeloTablaDx();
            crearModeloTablaProcedimiento();
            System.out.println("Este es el tratamiento-->>> " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento());
            cargarDxProcedimientos();
        }
    }

    public void mGrabar() {
        if (this.JTDetalleOdontologia.getRowCount() > 0 || this.JTDetalleProc.getRowCount() > 0) {
            if (!verificarTratamientoDx() && !verificarTratamientoProcedimiento()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int y = 0; y < this.JTDetalleOdontologia.getRowCount(); y++) {
                        String sql = "insert into o_hc_odontograma_inicialdx(`Id_Tratamiento` , IdUsuario, `IdDienteCara`  ,  Proceso,Observacion, esCavitacional, esObturadoCarie, esPerdidaCarie, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 3) + "','" + this.modelo.getValueAt(y, 4) + "','" + this.modelo.getValueAt(y, 5) + "','" + this.modelo.getValueAt(y, 6) + "','" + this.modelo.getValueAt(y, 7) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("consulta de insercion " + sql);
                        this.consultasMySql.ejecutarSQL(sql);
                        this.consultasMySql.cerrarConexionBd();
                        String sql2 = "insert into o_hc_tratamiento_dx(`Id_Tratamiento` , `IdDienteCara`  ,  Proceso, Observacion, esCavitacional, esObturadoCarie, esPerdidaCarie,  `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 3) + "','" + this.modelo.getValueAt(y, 4) + "','" + this.modelo.getValueAt(y, 5) + "','" + this.modelo.getValueAt(y, 6) + "','" + this.modelo.getValueAt(y, 7) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("consulta de insercion en DX de odontograma Clinico-->" + sql2);
                        this.consultasMySql.ejecutarSQL(sql2);
                        this.consultasMySql.cerrarConexionBd();
                    }
                    for (int y2 = 0; y2 < this.JTDetalleProc.getRowCount(); y2++) {
                        String sql3 = "insert into o_hc_odontograma_inicial_proc (`Id_Tratamiento` ,IdUsuario, `IdDienteCara`  , `Proceso` , `Observacion`, esObturadoCarie, esPerdidaCarie, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.modeloProcedimiento.getValueAt(y2, 0) + "','" + this.modeloProcedimiento.getValueAt(y2, 3) + "','" + this.modeloProcedimiento.getValueAt(y2, 4) + "','" + this.modeloProcedimiento.getValueAt(y2, 6) + "','" + this.modeloProcedimiento.getValueAt(y2, 7) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("consulta de insercion " + sql3);
                        this.consultasMySql.ejecutarSQL(sql3);
                        this.consultasMySql.cerrarConexionBd();
                    }
                    this.consultasMySql.ejecutarSQL("UPDATE o_hc_tratamiento SET OdonInicial=1 WHERE Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'");
                    this.consultasMySql.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, " No se puede Guardar la información \n Odontograma ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, " Debe diligenciar el odontograma", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public boolean verificarSombras() {
        boolean existe = false;
        String sql = "SELECT `IdDienteCara` FROM `o_hc_odontograma_inicialdx` WHERE (`IdDienteCara` ='" + this.dienteGeneral + "' AND `Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        System.out.println("Este es la verificacion de la sombra:: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existe = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    public boolean verificarProcesoLado(JPanel panel) {
        boolean existeValor = false;
        String sql = "SELECT `o_odontograma_diente`.`Nbre`   , `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicialdx`.`Id_Tratamiento` FROM `o_hc_odontograma_inicialdx` INNER JOIN `baseserver`.`o_odontograma_diente_cara`  ON (`o_hc_odontograma_inicialdx`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) WHERE (`o_odontograma_diente`.`Nbre` ='" + panel.getName() + "'  AND `o_odontograma_diente_cara`.`Lado` =8   AND `o_hc_odontograma_inicialdx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        System.out.println("Este es la verificacion de capa 8:: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existeValor = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existeValor;
    }

    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 17) {
            System.out.println("Presionó Control");
        }
        System.out.println("Presionó " + evt.getKeyCode());
    }

    private boolean verificarTratamientoDx() {
        boolean cerrado = false;
        String sql = "SELECT `IdUsuario` , `Id_Tratamiento` , `IdUsuario` FROM `o_hc_odontograma_inicialdx` WHERE (`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and  Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' ) GROUP BY `IdUsuario`";
        System.out.println("VerDx-->" + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                cerrado = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return cerrado;
    }

    private boolean verificarTratamientoProcedimiento() {
        boolean cerrado = false;
        String sql = "SELECT `IdUsuario` , `Id_Tratamiento` , `IdUsuario` FROM `o_hc_odontograma_inicial_proc` WHERE (`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and  Id_Tratamiento='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "') GROUP BY `IdUsuario`";
        System.out.println("VerProc-->" + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                cerrado = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return cerrado;
    }

    private void verificarTipoProceso(String proceso) {
        String sql = "SELECT `Id` , `Nbre` , `Tipo` FROM `o_odontograma_proceso` WHERE (`Nbre` ='" + proceso + "')";
        ConsultasMySQL consultasMySql = new ConsultasMySQL();
        ResultSet resultSet = consultasMySql.traerRs(sql);
        try {
            if (resultSet.next()) {
                resultSet.first();
                if (resultSet.getLong("Tipo") == 0) {
                    this.JTPDatosDxProc.setSelectedIndex(0);
                    adicionarTabla();
                } else {
                    this.JTPDatosDxProc.setSelectedIndex(1);
                    adicionarTablaProc();
                }
            }
            resultSet.close();
            consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
