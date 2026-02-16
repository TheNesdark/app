package ParametrizacionN;

import Acceso.Principal;
import Presupuesto.JDClonarMaestro;
import Presupuesto.JDDecreto2193;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JDParametrizacionCGR;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFRubrosN.class */
public class JIFFRubrosN extends JInternalFrame {
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloR;
    private Object[] xdatos;
    public String[] xIdMaestro;
    private boolean xlleno;
    private JDAuditoriaRubros xJDAuditoriaRubros;
    private String[] datos;
    private JButton JBAuditRubro;
    private JButton JBDecreto2193;
    private JButton JBDecreto2194;
    private JButton JBParametrizacionCGR;
    private JButton JBTExportar;
    private JCheckBox JCHTercero;
    private JCheckBox JCHUltNivel;
    public JComboBox JCMaestro;
    private JPanel JPExportar;
    private JPanel JPFunciones;
    private JRadioButton JRIGastos;
    private JRadioButton JRIngresos;
    public JTable JTDetalleR;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private JTabbedPane JTPOpciones;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private Metodos xmt = new Metodos();
    private String xTipoR = "I";
    private int xUltimoN = 0;
    private int xAplicaTercero = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xRubroPadre = "";

    public JIFFRubrosN() {
        this.xlleno = false;
        initComponents();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xIdMaestro = this.xct.llenarCombo("SELECT id, nombre FROM `pp_rubros_encabezado` WHERE estado=1 ORDER BY DATE_FORMAT(fechaI,'%Y') DESC;", this.xIdMaestro, this.JCMaestro);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
        this.JCHTercero.setVisible(false);
        if (this.xlleno && this.xIdMaestro.length > 1) {
            this.JCMaestro.setSelectedIndex(-1);
            return;
        }
        this.JCMaestro.setSelectedIndex(0);
        System.out.println("JCMaestro-->" + this.JCMaestro.getSelectedIndex());
        mBuscarRubros();
    }

    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTFCodigo = new JTextField();
        this.jPanel2 = new JPanel();
        this.JRIGastos = new JRadioButton();
        this.JRIngresos = new JRadioButton();
        this.JTFNombre = new JTextField();
        this.JCHUltNivel = new JCheckBox();
        this.JCHTercero = new JCheckBox();
        this.JCMaestro = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleR = new JTable();
        this.JTPOpciones = new JTabbedPane();
        this.JPFunciones = new JPanel();
        this.JBDecreto2193 = new JButton();
        this.JBDecreto2194 = new JButton();
        this.JBAuditRubro = new JButton();
        this.JBParametrizacionCGR = new JButton();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MAESTRO DE RUBROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifMaestroRubros");
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFFRubrosN.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFRubrosN.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRIGastos);
        this.JRIGastos.setFont(new Font("Arial", 1, 12));
        this.JRIGastos.setText("Gastos");
        this.JRIGastos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.2
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JRIGastosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRIngresos);
        this.JRIngresos.setFont(new Font("Arial", 1, 12));
        this.JRIngresos.setSelected(true);
        this.JRIngresos.setText("Ingresos");
        this.JRIngresos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.3
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JRIngresosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRIngresos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRIGastos).addGap(2, 2, 2)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRIGastos).addComponent(this.JRIngresos)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHUltNivel.setFont(new Font("Arial", 1, 12));
        this.JCHUltNivel.setText("Último Nivel?");
        this.JCHUltNivel.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.4
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JCHUltNivelActionPerformed(evt);
            }
        });
        this.JCHTercero.setFont(new Font("Arial", 1, 12));
        this.JCHTercero.setText("Aplica Tercero?");
        this.JCHTercero.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.5
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JCHTerceroActionPerformed(evt);
            }
        });
        this.JCMaestro.setFont(new Font("Arial", 1, 12));
        this.JCMaestro.setBorder(BorderFactory.createTitledBorder((Border) null, "Maestro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCMaestro.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFFRubrosN.6
            public void itemStateChanged(ItemEvent evt) {
                JIFFRubrosN.this.JCMaestroItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JTFCodigo, -2, 149, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 480, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCMaestro, -2, 237, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHUltNivel).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHTercero).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 47, -2).addComponent(this.JTFNombre, -2, 47, -2)).addComponent(this.JCMaestro, -2, 49, -2)).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHUltNivel).addComponent(this.JCHTercero)).addComponent(this.jPanel2, -2, -1, -2)).addGap(10, 10, 10)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jTabbedPane1.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubrosN.7
            public void mouseClicked(MouseEvent evt) {
                JIFFRubrosN.this.jTabbedPane1MouseClicked(evt);
            }
        });
        this.jTabbedPane1.addPropertyChangeListener(new PropertyChangeListener() { // from class: ParametrizacionN.JIFFRubrosN.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFRubrosN.this.jTabbedPane1PropertyChange(evt);
            }
        });
        this.JTDetalleR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleR.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleR.setAutoResizeMode(0);
        this.JTDetalleR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleR.setSelectionForeground(Color.red);
        this.JTDetalleR.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubrosN.9
            public void mouseClicked(MouseEvent evt) {
                JIFFRubrosN.this.JTDetalleRMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleR);
        this.jTabbedPane1.addTab("RUBROS", this.jScrollPane2);
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JBDecreto2193.setFont(new Font("Arial", 1, 12));
        this.JBDecreto2193.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contrato2.png")));
        this.JBDecreto2193.setText("Decreto 2193");
        this.JBDecreto2193.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.10
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JBDecreto2193ActionPerformed(evt);
            }
        });
        this.JBDecreto2194.setFont(new Font("Arial", 1, 12));
        this.JBDecreto2194.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Copiar.png")));
        this.JBDecreto2194.setText("Clonar Maestro");
        this.JBDecreto2194.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.11
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JBDecreto2194ActionPerformed(evt);
            }
        });
        this.JBAuditRubro.setFont(new Font("Arial", 1, 12));
        this.JBAuditRubro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBAuditRubro.setText("Auditoria de rubros");
        this.JBAuditRubro.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.12
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JBAuditRubroActionPerformed(evt);
            }
        });
        this.JBParametrizacionCGR.setFont(new Font("Arial", 1, 12));
        this.JBParametrizacionCGR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Puc.png")));
        this.JBParametrizacionCGR.setText("Configuración CGR");
        this.JBParametrizacionCGR.setToolTipText("");
        this.JBParametrizacionCGR.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.13
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JBParametrizacionCGRActionPerformed(evt);
            }
        });
        GroupLayout JPFuncionesLayout = new GroupLayout(this.JPFunciones);
        this.JPFunciones.setLayout(JPFuncionesLayout);
        JPFuncionesLayout.setHorizontalGroup(JPFuncionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFuncionesLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JBDecreto2193).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBDecreto2194).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBAuditRubro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBParametrizacionCGR, -2, 187, -2).addContainerGap(256, 32767)));
        JPFuncionesLayout.setVerticalGroup(JPFuncionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFuncionesLayout.createSequentialGroup().addContainerGap().addGroup(JPFuncionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBDecreto2193, -1, -1, 32767).addComponent(this.JBParametrizacionCGR, -1, -1, 32767).addComponent(this.JBDecreto2194).addComponent(this.JBAuditRubro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(61, 61, 61)));
        this.JTPOpciones.addTab("FUNCIONES", this.JPFunciones);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFRubrosN.14
            public void mouseClicked(MouseEvent evt) {
                JIFFRubrosN.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFRubrosN.15
            public void actionPerformed(ActionEvent evt) {
                JIFFRubrosN.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -1, 651, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 213, -2).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar, -1, -1, 32767).addGroup(JPExportarLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFRuta, -2, 50, -2))).addContainerGap()));
        this.JTPOpciones.addTab("EXPORTAR", this.JPExportar);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jTabbedPane1).addComponent(this.JTPOpciones)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -1, 320, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPOpciones, -2, 100, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRIGastosActionPerformed(ActionEvent evt) {
        this.xTipoR = "G";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRIngresosActionPerformed(ActionEvent evt) {
        this.xTipoR = "I";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUltNivelActionPerformed(ActionEvent evt) {
        if (this.JCHUltNivel.isSelected()) {
            this.xUltimoN = 1;
        } else {
            this.xUltimoN = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTerceroActionPerformed(ActionEvent evt) {
        if (this.JCHTercero.isSelected()) {
            this.xAplicaTercero = 1;
        } else {
            this.xAplicaTercero = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleRMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            Principal.txtNo.setText(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 1).toString());
            if (this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 2).toString().equals("I")) {
                this.JRIngresos.setSelected(true);
                this.xTipoR = "I";
            } else {
                this.JRIGastos.setSelected(true);
                this.xTipoR = "G";
            }
            if (this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 3).toString().equals("Si")) {
                this.JCHUltNivel.setSelected(true);
                this.xUltimoN = 1;
            } else {
                this.JCHUltNivel.setSelected(false);
                this.xUltimoN = 0;
            }
            if (this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 4).toString().equals("Si")) {
                this.JCHTercero.setSelected(true);
                this.xAplicaTercero = 1;
            } else {
                this.JCHTercero.setSelected(false);
                this.xAplicaTercero = 0;
            }
            this.JCMaestro.setSelectedItem(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 5).toString());
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCMaestroItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCMaestro.getSelectedIndex() > -1 && this.xIdMaestro.length > 1) {
            mBuscarRubros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTabbedPane1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTabbedPane1MouseClicked(MouseEvent evt) {
        if (this.jTabbedPane1.getSelectedIndex() == 1 && this.xlleno && this.xIdMaestro.length > 1 && this.JCMaestro.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Seleccione un Maestro de rubro para visualizar los datos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCMaestro.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBDecreto2193ActionPerformed(ActionEvent evt) {
        if (this.JTDetalleR.getSelectedRow() != -1) {
            JDDecreto2193 x = new JDDecreto2193(this, null, true);
            x.setVisible(true);
        } else {
            this.xmt.mostrarMensaje("Debe selecionar un rubro");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBDecreto2194ActionPerformed(ActionEvent evt) {
        JDClonarMaestro xClon = new JDClonarMaestro(null, true);
        xClon.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleR.getRowCount() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleR, this.JTFRuta.getText(), getTitle() + ": " + this.jTabbedPane1.getTitleAt(0));
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAuditRubroActionPerformed(ActionEvent evt) {
        this.xJDAuditoriaRubros = new JDAuditoriaRubros(null, true, this);
        this.xJDAuditoriaRubros.setVisible(true);
    }

    private void JBRubroContraloriaActionPerformed(ActionEvent evt) {
        if (this.JTDetalleR.getSelectedRow() != -1) {
            this.datos = new String[5];
            this.datos[0] = this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 0).toString();
            this.datos[1] = this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 1).toString();
            this.datos[2] = this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 2).toString();
            this.datos[3] = this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 3).toString();
            this.datos[4] = this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 8).toString();
            if (this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 3).toString().equals("Si")) {
                System.out.println(this.xIdMaestro[this.JCMaestro.getSelectedIndex()]);
                JDParametrizacionCGR JDR = new JDParametrizacionCGR(null, false, this.datos[0], this.xIdMaestro[this.JCMaestro.getSelectedIndex()]);
                JDR.setVisible(true);
                return;
            }
            this.xmt.mostrarMensaje("Debe selecionar un rubro de ultimo nivel");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBParametrizacionCGRActionPerformed(ActionEvent evt) {
        if (this.JTDetalleR.getSelectedRow() != -1) {
            if (this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 3).toString().equals("Si")) {
                JDParametrizacionCGR jdparametrizacion = new JDParametrizacionCGR(null, false, this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 0).toString(), this.xIdMaestro[this.JCMaestro.getSelectedIndex()]);
                jdparametrizacion.setVisible(true);
            } else {
                this.xmt.mostrarMensaje("Debe selecionar un rubro de ultimo nivel");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloRubros() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre", "TipoR", "ÚltimoNivel", "AplicaTercero?", "Maestro", "Cod. 2193", "Decreto 2193", "rpadre"}) { // from class: ParametrizacionN.JIFFRubrosN.16
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleR.setModel(this.xmodeloR);
        this.JTDetalleR.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalleR.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTDetalleR.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTDetalleR.getColumnModel().getColumn(3).setPreferredWidth(60);
        this.JTDetalleR.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTDetalleR.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalleR.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalleR.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleR.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    public void mBuscarRubros() {
        String sql = "SELECT pp_rubros.`Id`, pp_rubros.`Nbre`, pp_rubros.`IdPadre`, pp_rubros.`TipoRubro`, IF(pp_rubros.`UltNivel`=1,'Si','No') AS UltNivel, IF(pp_rubros.`Aplica_Tercero`=1,'Si','No') AS Aplica_Tercero, pp_rubros_encabezado.nombre AS EncabezadoRubro, IFNULL(pp_resoluciones_rubro.`CodigoAlterno`,'') AS CodigoAlterno,IFNULL(pp_det_resoluciones.`Nbre`,'') AS Decreto2193\nFROM   `pp_rubros` INNER JOIN `pp_rubros_encabezado` ON(pp_rubros.`idEncabezadoRubro`=pp_rubros_encabezado.`id`)\n                LEFT JOIN `pp_resoluciones_rubro` ON (pp_rubros.`Id`=pp_resoluciones_rubro.`IdRubro`)\n                LEFT JOIN `pp_det_resoluciones` ON (pp_resoluciones_rubro.`CodigoAlterno`=pp_det_resoluciones.`CodigoAlterno`)\n                WHERE pp_rubros.`idEncabezadoRubro`='" + this.xIdMaestro[this.JCMaestro.getSelectedIndex()] + "' \n                 ORDER BY pp_rubros.orden ASC, Id ASC, IdPadre ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("sql-->" + sql);
        mCreaModeloRubros();
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloR.addRow(this.xdatos);
                    this.xmodeloR.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodeloR.setValueAt(xrs.getString("Nbre"), n, 1);
                    this.xmodeloR.setValueAt(xrs.getString("TipoRubro"), n, 2);
                    this.xmodeloR.setValueAt(xrs.getString("UltNivel"), n, 3);
                    this.xmodeloR.setValueAt(xrs.getString("Aplica_Tercero"), n, 4);
                    this.xmodeloR.setValueAt(xrs.getString("EncabezadoRubro"), n, 5);
                    this.xmodeloR.setValueAt(xrs.getString("CodigoAlterno"), n, 6);
                    this.xmodeloR.setValueAt(xrs.getString("Decreto2193"), n, 7);
                    this.xmodeloR.setValueAt(xrs.getString("IdPadre"), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubrosN.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        ConsultasMySQL xctg = new ConsultasMySQL();
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                if (this.JCMaestro.getSelectedIndex() > -1) {
                    mBuscaRubroPadre();
                    if (Principal.txtNo.getText().isEmpty()) {
                        if (!mExisteRubro()) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                if (this.xRubroPadre.equals("")) {
                                    this.xRubroPadre = "-1";
                                }
                                String sql = "INSERT INTO  `pp_rubros` (`Id`,`Nbre`,`IdPadre`,`TipoRubro`,`UltNivel`,`Aplica_Tercero`,idEncabezadoRubro,`UsuarioS`)\nVALUES ('" + this.JTFCodigo.getText() + "','" + this.JTFNombre.getText() + "','" + this.xRubroPadre + "','" + this.xTipoR + "','" + this.xUltimoN + "','" + this.xAplicaTercero + "','" + this.xIdMaestro[this.JCMaestro.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                xctg.ejecutarSQL(sql);
                                Principal.txtNo.setText(this.JTFCodigo.getText());
                                System.out.println("Insert-->" + sql);
                                xctg.cerrarConexionBd();
                                mGuardaRubroPtoInicial();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Rubro ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else {
                        int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x2 == 0) {
                            if (this.xRubroPadre.equals("")) {
                                this.xRubroPadre = "-1";
                            }
                            xctg.ejecutarSQL(" UPDATE  `pp_rubros`\n SET `Id` = '" + this.JTFCodigo.getText() + "', `Nbre` = '" + this.JTFNombre.getText() + "', `IdPadre` = '" + this.xRubroPadre + "', `TipoRubro` = '" + this.xTipoR + "', `UltNivel` = '" + this.xUltimoN + "', `Aplica_Tercero` = '" + this.xAplicaTercero + "',\n `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\n WHERE `Id` = '" + Principal.txtNo.getText() + "' AND idEncabezadoRubro='" + this.xIdMaestro[this.JCMaestro.getSelectedIndex()] + "';");
                            xctg.cerrarConexionBd();
                        }
                    }
                    mNuevo();
                    mBuscarRubros();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selccionar un Maestro de rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCMaestro.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCodigo.requestFocus();
    }

    private void mGuardaRubroPtoInicial() {
        String AnioActual = this.xmt.formatoANO.format(this.xmt.getFechaActual());
        String sql = "INSERT INTO pp_detalle_movimiento ( `idEncabezado` ,`Id_Movimiento`, `Id_Rubro`,`Id_Tercero`,`Tipo`,`Valor`)\nSELECT\n   pp_detalle_movimiento.`idEncabezado`\n   , pp_detalle_movimiento.`Id_Movimiento`\n   ,'" + this.JTFCodigo.getText() + "' `Id_Rubro`\n   , pp_detalle_movimiento.`Id_Tercero`\n   , pp_detalle_movimiento.`Tipo`\n   ,0\nFROM\n    `pp_movimiento`\n    INNER JOIN `pp_detalle_movimiento` ON (pp_detalle_movimiento.`Id_Movimiento`=pp_movimiento.`Id`)\n    WHERE pp_movimiento.`Id_TipoDoc`=3 \n    AND pp_movimiento.`Id_MotivoAnulacion`=1\n    AND DATE_FORMAT(pp_movimiento.`FechaD`, '%Y') =" + AnioActual + "\n    LIMIT 1";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
    }

    private void mBuscaRubroPadre() {
        this.xRubroPadre = "";
        int cont = this.JTFCodigo.getText().trim().length();
        System.out.println("cont-->" + cont);
        String sql = "SELECT Id FROM `pp_rubros` WHERE LENGTH(Id)<'" + cont + "' AND idEncabezadoRubro='" + this.xIdMaestro[this.JCMaestro.getSelectedIndex()] + "'";
        System.out.println("mBuscaRubroPadre-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                System.out.println("Entra a sql  if next");
                for (int i = 1; i < cont; i++) {
                    xrs.beforeFirst();
                    while (true) {
                        if (!xrs.next()) {
                            break;
                        }
                        System.out.println("entra a while next");
                        System.out.println("xrsId-->" + xrs.getString("Id") + " Rubro-->" + this.JTFCodigo.getText().substring(0, cont - i));
                        if (xrs.getString("Id").equals(this.JTFCodigo.getText().substring(0, cont - i))) {
                            System.out.println("entra a if set xRubroPadre");
                            this.xRubroPadre = xrs.getString("Id");
                            System.out.println("xRubroPadreSet-->" + this.xRubroPadre);
                            break;
                        }
                    }
                    if (!this.xRubroPadre.equals("")) {
                        break;
                    }
                }
            }
            System.out.println("xRubroPadre-->" + this.xRubroPadre);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubrosN.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mExisteRubro() {
        boolean xExiste = false;
        String sql = "SELECT Id FROM `pp_rubros` WHERE Id='" + this.JTFCodigo.getText() + "' AND idEncabezadoRubro='" + this.xIdMaestro[this.JCMaestro.getSelectedIndex()] + "'";
        System.out.println("mExisteRubro-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFRubrosN.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    public void mNuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JRIngresos.setSelected(true);
        this.xTipoR = "I";
        this.JCHUltNivel.setSelected(false);
        this.JCHTercero.setSelected(false);
        this.xUltimoN = 0;
        this.xAplicaTercero = 0;
        Principal.mLimpiarDatosP();
    }
}
