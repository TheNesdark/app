package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GProcedimiento;
import com.genoma.plus.jpa.entities.GProcedimientoEmpresaRemision;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.IGProcedimientoEmpresaRemisionService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDProcedimientoEmpresaRemision.class */
public class JDProcedimientoEmpresaRemision extends JDialog {
    DefaultTableModel modelo;
    DefaultComboBoxModel combo;
    LocalDateTime fecha;
    private Metodos metodos;
    private Object[] datos;
    private final IGEmpresaService iges;
    private List<GEmpresa> listaEmpresa;
    private final GProcedimiento gProcedimiento;
    private final IGProcedimientoEmpresaRemisionService igpers;
    private JButton JBAdicionar;
    private JButton JBGrabar;
    private JButton JBSalir;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHBEstado;
    private JTextField JTFValor;
    private JTable JTableHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDProcedimientoEmpresaRemision(Frame parent, boolean modal, Long idProcedimiento) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.combo = new DefaultComboBoxModel();
        this.fecha = LocalDateTime.now();
        initComponents();
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.iges = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
        this.igpers = (IGProcedimientoEmpresaRemisionService) Principal.contexto.getBean(IGProcedimientoEmpresaRemisionService.class);
        this.listaEmpresa = new ArrayList();
        this.gProcedimiento = new GProcedimiento();
        this.gProcedimiento.setId(idProcedimiento);
        cargarComboEmpresa();
        crearModeloDatos();
        this.JCBEmpresa.setSelectedIndex(-1);
        autocompletarComboEmpresa();
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JTFValor = new JTextField();
        this.JCHBEstado = new JCheckBox();
        this.JBAdicionar = new JButton();
        this.JBGrabar = new JButton();
        this.JBSalir = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTableHistorico = new JTable();
        setDefaultCloseOperation(2);
        setTitle("PERIODOS");
        setFont(new Font("Arial", 1, 12));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 105, 0)));
        this.JCBEmpresa.setEditable(true);
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.1
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoEmpresaRemision.this.JCBEmpresaActionPerformed(evt);
            }
        });
        this.JTFValor.setFont(new Font("Arial", 1, 12));
        this.JTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFValor.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.2
            public void keyTyped(KeyEvent evt) {
                JDProcedimientoEmpresaRemision.this.JTFValorKeyTyped(evt);
            }
        });
        this.JCHBEstado.setFont(new Font("Arial", 1, 12));
        this.JCHBEstado.setSelected(true);
        this.JCHBEstado.setText("Estado");
        this.JCHBEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.3
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoEmpresaRemision.this.JCHBEstadoActionPerformed(evt);
            }
        });
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.4
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoEmpresaRemision.this.JBAdicionarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JCBEmpresa, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFValor, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JCHBEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.JBAdicionar, -2, 108, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(37, 37, 37).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAdicionar, -2, 35, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JTFValor, -2, -1, -2).addComponent(this.JCHBEstado))).addContainerGap(47, 32767)));
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.5
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoEmpresaRemision.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.6
            public void actionPerformed(ActionEvent evt) {
                JDProcedimientoEmpresaRemision.this.JBSalirActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTableHistorico.setFont(new Font("Arial", 1, 12));
        this.JTableHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTableHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.7
            public void mouseClicked(MouseEvent evt) {
                JDProcedimientoEmpresaRemision.this.JTableHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTableHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(56, 56, 56).addComponent(this.JBGrabar, -2, 250, -2).addGap(48, 48, 48).addComponent(this.JBSalir, -2, 250, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 288, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1 || !this.JTFValor.getText().isEmpty()) {
            cargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFValorKeyTyped(KeyEvent evt) {
        char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
        int b = 0;
        for (int i = 0; i <= 10; i++) {
            if (p[i] == evt.getKeyChar()) {
                b = 1;
            }
        }
        if (b == 0) {
            evt.consume();
            getToolkit().beep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTableHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Valor", "Estado"}) { // from class: ParametrizacionN.JDProcedimientoEmpresaRemision.8
            Class[] types = {String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTableHistorico.setModel(this.modelo);
        this.JTableHistorico.doLayout();
        this.JTableHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTableHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTableHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void cargarComboEmpresa() {
        this.JCBEmpresa.setModel(this.combo);
        this.listaEmpresa = this.iges.listarEmpresa();
        System.out.println("lista empresa .--->>>" + this.listaEmpresa);
        this.listaEmpresa.forEach(e -> {
            this.combo.addElement(e.getNbre());
        });
    }

    private void cargarDatosTabla() {
        Object[] campo = {this.JCBEmpresa.getSelectedItem().toString(), Double.valueOf(Double.parseDouble(this.JTFValor.getText())), Boolean.valueOf(this.JCHBEstado.isSelected())};
        this.modelo.addRow(campo);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JTFValor.setText("");
    }

    private void autocompletarComboEmpresa() {
        new AutoCompletarComboBox(this.JCBEmpresa);
    }

    private void grabar() {
        List<GProcedimientoEmpresaRemision> listaRemision = new ArrayList<>();
        for (int i = 0; i < this.JTableHistorico.getRowCount(); i++) {
            GProcedimientoEmpresaRemision gp = new GProcedimientoEmpresaRemision();
            gp.setGProcedimiento(this.gProcedimiento);
            gp.setGEmpresa(this.listaEmpresa.get(i));
            gp.setValor((Double) this.JTableHistorico.getValueAt(i, 1));
            gp.setEstado((Boolean) this.JTableHistorico.getValueAt(i, 2));
            gp.setFecha(this.fecha);
            String id = Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString();
            gp.setUsuario_sistema(Integer.valueOf(id));
            listaRemision.add(gp);
        }
        if (!listaRemision.isEmpty()) {
            this.igpers.grabarTodo(listaRemision);
        }
        JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
        crearModeloDatos();
    }
}
