package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.SoporteCarpetasDTO;
import com.genoma.plus.jpa.service.ISoporteCarpetasDAO;
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
import java.io.File;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDSoporteCarpeta.class */
public class JDSoporteCarpeta extends JDialog {
    private Metodos xmt;
    private Object[] xdatos;
    private List<SoporteCarpetasDTO> listaSoporteCarpetas;
    private final ISoporteCarpetasDAO xISoporteCarpetasDAO;
    private DefaultTableModel xmodelo;
    private boolean grabado;
    private long idConvenio;
    private JButton JBT_Grabar;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JCheckBox JCHEstado;
    private JLabel JLEstructura;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombreCarpeta;
    private JTextField JTFRutaCarpeta;
    private JTextField JTFSeparador;
    private JButton jButton1;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;

    public JDSoporteCarpeta(Frame parent, boolean modal, Long idConvenio) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xISoporteCarpetasDAO = (ISoporteCarpetasDAO) Principal.contexto.getBean(ISoporteCarpetasDAO.class);
        this.grabado = false;
        this.idConvenio = 0L;
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("SOPORTE POR CONVENIO");
        this.idConvenio = idConvenio.longValue();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JTFNombreCarpeta = new JTextField();
        this.JTFRutaCarpeta = new JTextField();
        this.JTFSeparador = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JLEstructura = new JLabel();
        this.jButton1 = new JButton();
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jList1 = new JList<>();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.1
            public void mouseClicked(MouseEvent evt) {
                JDSoporteCarpeta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPInformacion.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCarpeta.setFont(new Font("Arial", 1, 12));
        this.JTFNombreCarpeta.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de la Carpeta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreCarpeta.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.2
            public void focusLost(FocusEvent evt) {
                JDSoporteCarpeta.this.JTFNombreCarpetaFocusLost(evt);
            }
        });
        this.JTFNombreCarpeta.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.3
            public void keyPressed(KeyEvent evt) {
                JDSoporteCarpeta.this.JTFNombreCarpetaKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDSoporteCarpeta.this.JTFNombreCarpetaKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDSoporteCarpeta.this.JTFNombreCarpetaKeyTyped(evt);
            }
        });
        this.JTFRutaCarpeta.setFont(new Font("Arial", 1, 12));
        this.JTFRutaCarpeta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Generacion de la Carpeta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaCarpeta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.4
            public void mouseClicked(MouseEvent evt) {
                JDSoporteCarpeta.this.JTFRutaCarpetaMouseClicked(evt);
            }
        });
        this.JTFSeparador.setFont(new Font("Arial", 1, 12));
        this.JTFSeparador.setBorder(BorderFactory.createTitledBorder((Border) null, "Separador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSeparador.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.5
            public void focusLost(FocusEvent evt) {
                JDSoporteCarpeta.this.JTFSeparadorFocusLost(evt);
            }
        });
        this.JTFSeparador.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.6
            public void keyReleased(KeyEvent evt) {
                JDSoporteCarpeta.this.JTFSeparadorKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDSoporteCarpeta.this.JTFSeparadorKeyTyped(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JLEstructura.setFont(new Font("Arial", 1, 12));
        this.JLEstructura.setForeground(new Color(0, 103, 0));
        this.JLEstructura.setBorder(BorderFactory.createTitledBorder((Border) null, "Validador de Formato", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JTFNombreCarpeta, -2, 497, -2).addComponent(this.JTFRutaCarpeta, -2, 497, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFSeparador, -2, 87, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JLEstructura, -2, 594, -2))).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreCarpeta, -2, 50, -2).addComponent(this.JTFSeparador, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRutaCarpeta, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLEstructura, -2, 33, -2)));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TXT_24px.png")));
        this.jButton1.setText("Configuracion de Archivos");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.7
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpeta.this.jButton1ActionPerformed(evt);
            }
        });
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.8
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpeta.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.9
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpeta.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.10
            public void actionPerformed(ActionEvent evt) {
                JDSoporteCarpeta.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.jList1.setBorder(BorderFactory.createTitledBorder((Border) null, "Formato de Nombre del Archivo", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jList1.setModel(new AbstractListModel<String>() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.11
            String[] strings = {"<html><strong><span style=\"color: #ff0000;\">#</span>: <span style=\"color: #000000;\">NumeroFactura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">$</span>: <span style=\"color: #000000;\">FechaCorta (DDMMYYYY) + Hora Actual&nbsp;</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">&amp;</span>: <span style=\"color: #000000;\">FechaLarga (DDMMYYYYHHMMSS) + Hora Actual </span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">N</span>: <span style=\"color: #000000;\">NIT Convenio</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">X</span>: <span style=\"color: #000000;\">NIT Entidad que Genera</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">P</span>: <span style=\"color: #000000;\">Prefijo Factura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">Z</span>: <span style=\"color: #000000;\">Prefijo Factura + NumeroFactura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">C</span>: <span style=\"color: #000000;\"># Contrato Convenio</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">R</span>: <span style=\"color: #000000;\">Fecha Radicado Factura (DDMMYYYY)</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">I</span>: <span style=\"color: #000000;\">No Ingreso</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">A</span>: <span style=\"color: #000000;\">No Atencion</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">V</span>: <span style=\"color: #000000;\">Valor Factura</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">E</span>: <span style=\"color: #000000;\">Fecha Evento ECAT (DDMMYYYY)</span></strong></html>", "<html><strong><span style=\"color: #ff0000;\">'xxxx'</span>: <span style=\"color: #000000;\">Texto Fijo dentro de Comilla Simple</span></strong></html>"};

            public int getSize() {
                return this.strings.length;
            }

            /* JADX INFO: renamed from: getElementAt, reason: merged with bridge method [inline-methods] */
            public String m66getElementAt(int i) {
                return this.strings[i];
            }
        });
        this.jList1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.12
            public void mouseClicked(MouseEvent evt) {
                JDSoporteCarpeta.this.jList1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jList1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Grabar, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Salir1, -2, 319, -2)).addComponent(this.jButton1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, -2).addComponent(this.JSPDetalle)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 203, -2).addGap(10, 10, 10)).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 425, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.jButton1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
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
            this.JTFNombreCarpeta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFSeparador.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFRutaCarpeta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaCarpetaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRutaCarpeta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRutaCarpeta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRutaCarpeta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorKeyTyped(KeyEvent evt) {
        if (this.JTFSeparador.getText().length() == 3) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JDSoporteCarpetaArchivos jd = new JDSoporteCarpetaArchivos(null, true, Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCarpetaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCarpetaKeyReleased(KeyEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCarpetaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorFocusLost(FocusEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSeparadorKeyReleased(KeyEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreCarpetaFocusLost(FocusEvent evt) {
        this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jList1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (!((String) this.jList1.getSelectedValue()).contains("Texto Fijo dentro de Comilla Simple")) {
                this.JTFNombreCarpeta.setText(this.JTFNombreCarpeta.getText() + this.xmt.InsertarPrefijoSoportesDigitalizados(this.jList1.getSelectedIndex(), ""));
            } else {
                String texto = JOptionPane.showInputDialog("Digite Descripcion");
                if (texto != null && !texto.isEmpty()) {
                    this.JTFNombreCarpeta.setText(this.JTFNombreCarpeta.getText() + this.xmt.InsertarPrefijoSoportesDigitalizados(this.jList1.getSelectedIndex(), texto));
                }
            }
            this.JLEstructura.setText(this.xmt.generarNombreSoportesDigitalizados(this.JTFNombreCarpeta.getText(), this.JTFSeparador.getText()));
        }
    }

    public void mNuevo() {
        this.grabado = false;
        this.JTFNombreCarpeta.setText("");
        this.JTFRutaCarpeta.setText("");
        this.JTFSeparador.setText("");
        this.JLEstructura.setText("");
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFRutaCarpeta.getText().isEmpty()) {
            if (!this.JLEstructura.equals("ERROR")) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    SoporteCarpetasDTO e = new SoporteCarpetasDTO();
                    e.setIdConvenio(Long.valueOf(this.idConvenio));
                    e.setNombre(this.JTFNombreCarpeta.getText());
                    e.setRuta(this.JTFRutaCarpeta.getText());
                    e.setSeparador(this.JTFSeparador.getText());
                    e.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                    e.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    if (this.grabado) {
                        e.setId(Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
                    }
                    this.xISoporteCarpetasDAO.grabar(e);
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Se detecta error en la estructura del formato de la carpeta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombreCarpeta.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe la ruta de la carpeta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRutaCarpeta.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Separador", "Ruta", "Estado"}) { // from class: com.genoma.plus.controller.general.JDSoporteCarpeta.13
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listaSoporteCarpetas = this.xISoporteCarpetasDAO.consultarSoporteCarpetasConvenio(Long.valueOf(this.idConvenio));
        if (!this.listaSoporteCarpetas.isEmpty()) {
            for (int i = 0; i < this.listaSoporteCarpetas.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaSoporteCarpetas.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaSoporteCarpetas.get(i).getNombre(), i, 1);
                this.xmodelo.setValueAt(this.listaSoporteCarpetas.get(i).getSeparador(), i, 2);
                this.xmodelo.setValueAt(this.listaSoporteCarpetas.get(i).getRuta(), i, 3);
                this.xmodelo.setValueAt(this.listaSoporteCarpetas.get(i).getEstado(), i, 4);
            }
        }
    }
}
