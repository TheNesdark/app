package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCargarGasto.class */
public class JIFCargarGasto extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private File xfile;
    private String[] xidperiodo;
    private ButtonGroup JBGOpciones;
    private JButton JBTImportar;
    private JComboBox JCBPerido;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle1;
    private JFormattedTextField JTFFTotal;
    private JTextField JTFRuta;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xnfila = 0;
    private boolean xestado = false;

    public JIFCargarGasto() {
        initComponents();
        this.xidperiodo = this.xconsultas.llenarCombo("SELECT Id, DATE_FORMAT(FechaI,'%m-%Y')AS Fecha FROM cc_periodo_contable WHERE (Estado =1) ORDER BY FechaI ASC", this.xidperiodo, this.JCBPerido);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBPerido = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JTFFTotal = new JFormattedTextField();
        this.JBTImportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR GASTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcargargasto");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPerido.setFont(new Font("Arial", 1, 12));
        this.JCBPerido.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Contable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPerido.addItemListener(new ItemListener() { // from class: Contabilidad.JIFCargarGasto.1
            public void itemStateChanged(ItemEvent evt) {
                JIFCargarGasto.this.JCBPeridoItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFCargarGasto.2
            public void mouseClicked(MouseEvent evt) {
                JIFCargarGasto.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPerido, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -1, 353, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 48, 32767).addComponent(this.JCBPerido, GroupLayout.Alignment.TRAILING, -1, 48, 32767)).addContainerGap()));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFCargarGasto.3
            public void keyPressed(KeyEvent evt) {
                JIFCargarGasto.this.JTResultadoKeyPressed(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        this.JTFFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotal.setHorizontalAlignment(4);
        this.JTFFTotal.setFont(new Font("Arial", 1, 13));
        this.JBTImportar.setFont(new Font("Arial", 1, 14));
        this.JBTImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTImportar.setText("Importar");
        this.JBTImportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCargarGasto.4
            public void actionPerformed(ActionEvent evt) {
                JIFCargarGasto.this.JBTImportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFFTotal, -1, 142, 32767).addGap(73, 73, 73).addComponent(this.JBTImportar, -2, 519, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -2, 417, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFTotal).addComponent(this.JBTImportar, -1, 53, 32767)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeridoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLS", new String[]{"xls"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            mImportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTResultado.getSelectedRow());
                this.xnfila--;
            }
            mCalcular();
        }
    }

    private void mBuscar() {
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"IdC", "Cuenta", "Valor", "Configurada?"}) { // from class: Contabilidad.JIFCargarGasto.5
            Class[] types = {Integer.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.xnfila = 0;
    }

    public void mGrabar() {
        if (this.JCBPerido.getSelectedIndex() != -1) {
            if (this.JTResultado.getRowCount() != -1) {
                if (!this.xestado) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                                String sql = "insert into cc_presupuesto(Id_PresupuestoPuc, Id_periodoC, Valor, Fecha, UsuarioS)values('" + this.xmodelo.getValueAt(x, 0).toString() + "','" + this.xidperiodo[this.JCBPerido.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(x, 2).toString() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                this.xconsultas.ejecutarSQL(sql);
                                this.xconsultas.cerrarConexionBd();
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta cargar información", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPerido.requestFocus();
    }

    public void mNuevo() {
        this.JCBPerido.setSelectedIndex(-1);
        this.JTFRuta.setText("");
        mCrearTabla();
        this.xestado = false;
        this.JCBPerido.requestFocus();
    }

    private void mImportar() {
        int xidpuc;
        try {
            String archivo = this.JTFRuta.getText();
            Workbook workbook = Workbook.getWorkbook(new File(archivo));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            sheet.getColumns();
            for (int x = 0; x < rows; x++) {
                Cell celdaCurso = sheet.getCell(0, x);
                Cell celdavalor = sheet.getCell(1, x);
                String valorCeldaCurso = celdaCurso.getContents();
                String xvalor = celdavalor.getContents();
                String sql = "SELECT Id, Id_Puc FROM cc_presupuesto_puc WHERE (Id_Puc ='" + valorCeldaCurso + "')";
                ResultSet xrs = this.xconsultas.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    xidpuc = xrs.getInt(1);
                } else {
                    xidpuc = 0;
                }
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Integer.valueOf(xidpuc), x, 0);
                this.xmodelo.setValueAt(valorCeldaCurso, x, 1);
                this.xmodelo.setValueAt(Double.valueOf(xvalor), x, 2);
                if (xidpuc == 0) {
                    this.xmodelo.setValueAt(false, x, 3);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                } else {
                    this.xmodelo.setValueAt(true, x, 3);
                    this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
                }
                xrs.close();
                this.xconsultas.cerrarConexionBd();
                this.xnfila++;
            }
            mCalcular();
            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFCargarGasto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFCargarGasto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        } catch (BiffException e) {
            Logger.getLogger(JIFCargarGasto.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void mCalcular() {
        double total = 0.0d;
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            total += Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue();
        }
        this.JTFFTotal.setValue(Double.valueOf(total));
    }

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCargarGasto$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 3).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
