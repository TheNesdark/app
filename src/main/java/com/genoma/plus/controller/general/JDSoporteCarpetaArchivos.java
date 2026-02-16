package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ReportesDTO;
import com.genoma.plus.jpa.entities.SoporteCarpetasArchivosDTO;
import com.genoma.plus.jpa.projection.ISoporteCarpetasArchivos;
import com.genoma.plus.jpa.service.IReportesService;
import com.genoma.plus.jpa.service.ISoporteCarpetasArchivosDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDSoporteCarpetaArchivos.class */
public class JDSoporteCarpetaArchivos extends JDialog {
    private Metodos xmt;
    private Object[] xdatos;
    private List<ReportesDTO> listaReportes;
    private List<ISoporteCarpetasArchivos> listaSoporteCarpetasArchivos;
    private final ISoporteCarpetasArchivosDAO xISoporteCarpetasArchivosDAO;
    private final IReportesService reportesService;
    private DefaultTableModel xmodelo;
    private boolean grabado;
    private long idCarpeta;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JComboBox<String> JCBReportes;
    private JCheckBox JCHEstado;
    private JCheckBox JCHUnificado;
    private JLabel JLEstructura;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTextField JTFNombreArchivo;
    private JTextField JTFSeparador;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;

    public JDSoporteCarpetaArchivos(Frame parent, boolean modal, Long idCarpeta) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xISoporteCarpetasArchivosDAO = (ISoporteCarpetasArchivosDAO) Principal.contexto.getBean(ISoporteCarpetasArchivosDAO.class);
        this.reportesService = (IReportesService) Principal.contexto.getBean(IReportesService.class);
        this.grabado = false;
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("ARCHIVOS POR CARPETA");
        this.idCarpeta = idCarpeta.longValue();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JTFNombreArchivo = new JTextField();
        this.JTFSeparador = new JTextField();
        this.JCBReportes = new JComboBox<>();
        this.JCHUnificado = new JCheckBox();
        this.JSPOrden = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JLEstructura = new JLabel();
        this.JBT_NUevo = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jList1 = new JList<>();
        setDefaultCloseOperation(2);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.1
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpetaArchivos.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.2
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpetaArchivos.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.3
            public void mouseClicked(MouseEvent evt) {
                JDSoporteCarpetaArchivos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPInformacion.setFont(new Font("Arial", 1, 12));
        this.JTFNombreArchivo.setFont(new Font("Arial", 1, 12));
        this.JTFNombreArchivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreArchivo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.4
            public void keyReleased(KeyEvent evt) {
                JDSoporteCarpetaArchivos.this.JTFNombreArchivoKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDSoporteCarpetaArchivos.this.JTFNombreArchivoKeyTyped(evt);
            }
        });
        this.JTFSeparador.setFont(new Font("Arial", 1, 12));
        this.JTFSeparador.setBorder(BorderFactory.createTitledBorder((Border) null, "Separador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSeparador.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.5
            public void focusLost(FocusEvent evt) {
                JDSoporteCarpetaArchivos.this.JTFSeparadorFocusLost(evt);
            }
        });
        this.JTFSeparador.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.6
            public void keyReleased(KeyEvent evt) {
                JDSoporteCarpetaArchivos.this.JTFSeparadorKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDSoporteCarpetaArchivos.this.JTFSeparadorKeyTyped(evt);
            }
        });
        this.JCBReportes.setFont(new Font("Arial", 1, 12));
        this.JCBReportes.setBorder(BorderFactory.createTitledBorder((Border) null, "Reporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBReportes.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.7
            public void keyReleased(KeyEvent evt) {
                JDSoporteCarpetaArchivos.this.JCBReportesKeyReleased(evt);
            }
        });
        this.JCHUnificado.setFont(new Font("Arial", 1, 12));
        this.JCHUnificado.setForeground(Color.blue);
        this.JCHUnificado.setText("Es Reporte Unificado?");
        this.JCHUnificado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.8
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpetaArchivos.this.JCHUnificadoActionPerformed(evt);
            }
        });
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, (Comparable) null, 99, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JLEstructura.setFont(new Font("Arial", 1, 12));
        this.JLEstructura.setForeground(new Color(0, 103, 0));
        this.JLEstructura.setBorder(BorderFactory.createTitledBorder((Border) null, "Validador de Formato", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLEstructura, -1, -1, 32767).addComponent(this.JCBReportes, 0, -1, 32767).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCHUnificado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addComponent(this.JTFNombreArchivo, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFSeparador, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 71, -2))).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBReportes, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreArchivo, -2, 50, -2).addComponent(this.JTFSeparador, -2, 50, -2).addComponent(this.JSPOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHUnificado).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLEstructura, -2, 42, -2).addContainerGap()));
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.9
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpetaArchivos.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.jList1.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato de Nombre del Archivo", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jList1.setModel(new AbstractListModel<String>() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.10
            String[] strings = {"<html><strong><span style=\"color: #ff0000;\">#</span>: <span style=\"color: #000000;\">NumeroFactura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">$</span>: <span style=\"color: #000000;\">FechaCorta (DDMMYYYY) + Hora Actual&nbsp;</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">&amp;</span>: <span style=\"color: #000000;\">FechaLarga (DDMMYYYYHHMMSS) + Hora Actual </span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">N</span>: <span style=\"color: #000000;\">NIT Convenio</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">X</span>: <span style=\"color: #000000;\">NIT Entidad que Genera</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">P</span>: <span style=\"color: #000000;\">Prefijo Factura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">Z</span>: <span style=\"color: #000000;\">Prefijo Factura + NumeroFactura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">C</span>: <span style=\"color: #000000;\"># Contrato Convenio</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">R</span>: <span style=\"color: #000000;\">Fecha Radicado Factura (DDMMYYYY)</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">I</span>: <span style=\"color: #000000;\">No Ingreso</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">A</span>: <span style=\"color: #000000;\">No Atencion</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">V</span>: <span style=\"color: #000000;\">Valor Factura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">E</span>: <span style=\"color: #000000;\">Fecha Evento ECAT (DDMMYYYY)</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">'xxxx'</span>: <span style=\"color: #000000;\">Texto Fijo dentro de Comilla Simple</span></strong></html>"};

            public int getSize() {
                return this.strings.length;
            }

            /* JADX INFO: renamed from: getElementAt, reason: merged with bridge method [inline-methods] */
            public String m67getElementAt(int i) {
                return this.strings[i];
            }
        });
        this.jList1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.11
            public void mouseClicked(MouseEvent evt) {
                JDSoporteCarpetaArchivos.this.jList1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jList1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 319, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 252, 32767)).addComponent(this.jScrollPane1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.grabado = true;
            this.JCBReportes.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombreArchivo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFSeparador.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHUnificado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JSPOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreArchivo.getText(), this.JTFSeparador.getText()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorKeyTyped(KeyEvent evt) {
        if (this.JTFSeparador.getText().length() == 3) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreArchivoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUnificadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBReportesKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreArchivoKeyReleased(KeyEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreArchivo.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorKeyReleased(KeyEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreArchivo.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorFocusLost(FocusEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreArchivo.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jList1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (!((String) this.jList1.getSelectedValue()).contains("Texto Fijo dentro de Comilla Simple")) {
                this.JTFNombreArchivo.setText(this.JTFNombreArchivo.getText() + this.xmt.InsertarPrefijoSoportesDigitalizados(this.jList1.getSelectedIndex(), ""));
            } else {
                String texto = JOptionPane.showInputDialog("Digite Descripcion");
                if (texto != null && !texto.isEmpty()) {
                    this.JTFNombreArchivo.setText(this.JTFNombreArchivo.getText() + this.xmt.InsertarPrefijoSoportesDigitalizados(this.jList1.getSelectedIndex(), texto));
                }
            }
            this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreArchivo.getText(), this.JTFSeparador.getText()));
        }
    }

    public void mNuevo() {
        this.grabado = false;
        this.listaReportes = this.reportesService.listaReportesPorEstadoOrdenadoPorNombre(true);
        this.JCBReportes.removeAllItems();
        this.listaReportes.forEach(next -> {
            this.JCBReportes.addItem(next.getNbre());
        });
        this.JCBReportes.setSelectedIndex(-1);
        this.JTFNombreArchivo.setText("");
        this.JTFSeparador.setText("");
        this.JCHUnificado.setSelected(false);
        this.JSPOrden.setValue(0);
        this.JLEstructura.setText("");
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.JCBReportes.getSelectedIndex() != -1) {
            if (!this.JTFNombreArchivo.getText().isEmpty()) {
                if (!this.JLEstructura.equals("ERROR")) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        SoporteCarpetasArchivosDTO e = new SoporteCarpetasArchivosDTO();
                        e.setSopCarpetasId(Long.valueOf(this.idCarpeta));
                        e.setGReportesId(this.listaReportes.get(this.JCBReportes.getSelectedIndex()).getId());
                        e.setNombre(this.JTFNombreArchivo.getText());
                        e.setSeparador(this.JTFSeparador.getText());
                        if (this.JCHUnificado.isSelected()) {
                            e.setUnificado(true);
                        } else {
                            e.setUnificado(false);
                        }
                        e.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()));
                        e.setEstado(this.JCHEstado.isSelected());
                        e.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                        if (this.grabado) {
                            e.setId(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                            this.xISoporteCarpetasArchivosDAO.grabar(e);
                        } else {
                            this.xISoporteCarpetasArchivosDAO.grabar(e);
                        }
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Se detecta error en la estructura del formato del Archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JTFNombreArchivo.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar el nombre de la carpeta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombreArchivo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un reporte", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBReportes.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Reporte", "Nombre", "Separador", "Es Unificado?", "Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.JDSoporteCarpetaArchivos.12
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listaSoporteCarpetasArchivos = this.xISoporteCarpetasArchivosDAO.consultarArchivosSoporteCarpetas(Long.valueOf(this.idCarpeta));
        if (!this.listaSoporteCarpetasArchivos.isEmpty()) {
            for (int i = 0; i < this.listaSoporteCarpetasArchivos.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaSoporteCarpetasArchivos.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaSoporteCarpetasArchivos.get(i).getReporte(), i, 1);
                this.xmodelo.setValueAt(this.listaSoporteCarpetasArchivos.get(i).getNombre(), i, 2);
                this.xmodelo.setValueAt(this.listaSoporteCarpetasArchivos.get(i).getSeparador(), i, 3);
                this.xmodelo.setValueAt(Boolean.valueOf(this.listaSoporteCarpetasArchivos.get(i).getUnificado()), i, 4);
                this.xmodelo.setValueAt(this.listaSoporteCarpetasArchivos.get(i).getOrden(), i, 5);
                this.xmodelo.setValueAt(Boolean.valueOf(this.listaSoporteCarpetasArchivos.get(i).getEstado()), i, 6);
            }
        }
    }
}
