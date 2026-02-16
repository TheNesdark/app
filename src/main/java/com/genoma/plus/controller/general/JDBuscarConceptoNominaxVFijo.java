package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.BuscarConceptoNominaxVFijoDAO;
import com.genoma.plus.dao.impl.general.BuscarConceptoNominaxVFijoDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.BuscarConceptoNominaxVFijoDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDBuscarConceptoNominaxVFijo.class */
public class JDBuscarConceptoNominaxVFijo extends JDialog {
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private BuscarConceptoNominaxVFijoDAO xBuscarConceptoNominaxVFijoDAO;
    private Object[] xDato;
    private String[] xIdTerceroCombo;
    private boolean xSeleccionar;
    private String xidunidadfc;
    private String xnombre;
    private int xIdtercero;
    private int xestado;
    private JComboBox comboBox;
    private JButton JBTAdicionar;
    private JCheckBox JCHSeleccionar;
    private JPanel JPDBusqueda;
    private JScrollPane JSPResultado;
    private JTextField JTFConcepto;
    private JTable JTResultado;

    public JDBuscarConceptoNominaxVFijo(Frame parent, boolean modal, int xidterceroc, String xidunidadfc, String xnombre) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xSeleccionar = true;
        this.xIdtercero = 0;
        this.xestado = 1;
        this.comboBox = new JComboBox();
        initComponents();
        springStart();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("BUSCAR CONCEPTOS DE NOMINA");
        this.xidunidadfc = xidunidadfc;
        this.xIdtercero = xidterceroc;
        this.xnombre = xnombre;
        mCargarDatosTabla();
        this.xIdTerceroCombo = mLLenaCombo(this.comboBox);
    }

    private void springStart() {
        this.xBuscarConceptoNominaxVFijoDAO = (BuscarConceptoNominaxVFijoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("buscarConceptoNominaxVFijoDAO");
    }

    private String[] mLLenaCombo(JComboBox xCombo) {
        xCombo.removeAllItems();
        List<GCGenericoDTO> list = this.xBuscarConceptoNominaxVFijoDAO.listTerceros();
        String[] xDatos = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            xDatos[x] = String.valueOf(list.get(x).getId());
            xCombo.addItem(list.get(x).getNombre());
        }
        if (list.size() > 1) {
            xCombo.setSelectedIndex(-1);
        }
        return xDatos;
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Tercero", "TCalculo", "NCalculo", "MTercero", "Valor", "ValorEmpresa", "Estado", "Selecionar?"}) { // from class: com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo.1
            Class[] types = {Integer.class, String.class, String.class, Integer.class, String.class, Integer.class, Double.class, Double.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, true, false, false, false, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(50);
        TableColumn sportColumn = this.JTResultado.getColumnModel().getColumn(2);
        sportColumn.setCellEditor(new DefaultCellEditor(this.comboBox));
    }

    private void mCargarDatosTabla() {
        List<BuscarConceptoNominaxVFijoDTO> list = this.xBuscarConceptoNominaxVFijoDAO.list(this.xidunidadfc, this.JTFConcepto.getText());
        mCrearTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNConcepto(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getTCalculo(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getMTercero()), x, 5);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getValor()), x, 6);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getValorE()), x, 7);
            this.xmodelo.setValueAt(true, x, 8);
            this.xmodelo.setValueAt(true, x, 9);
            this.JTResultado.setDefaultRenderer(Object.class, new MiRender());
            mverificar(x);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDBuscarConceptoNominaxVFijo$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String Tercero = table.getValueAt(row, 2).toString();
            if (Tercero.toString().equals("")) {
                cell.setBackground(Color.red);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mverificar(int fila) {
        String xtcalculo = this.xmodelo.getValueAt(fila, 3).toString();
        int xmtercero = Integer.parseInt(this.xmodelo.getValueAt(fila, 5).toString());
        this.xmodelo.getValueAt(fila, 6).toString();
        this.xmodelo.getValueAt(fila, 7).toString();
        if (xmtercero == 1) {
            this.xmodelo.setValueAt(this.xnombre, fila, 2);
            this.xmodelo.setValueAt(true, fila, 9);
        } else {
            this.xmodelo.setValueAt("", fila, 2);
            this.xmodelo.setValueAt(false, fila, 9);
        }
        if (xtcalculo.equals("2")) {
            this.xmodelo.setValueAt("Día", fila, 4);
        } else if (xtcalculo.equals("3")) {
            this.xmodelo.setValueAt("Porcentaje", fila, 4);
        } else if (xtcalculo.equals("4")) {
            this.xmodelo.setValueAt("Valor", fila, 4);
        }
    }

    private String mDdevuelveValorCombo(String dato) {
        String sqls = "SELECT Id FROM `cc_terceros` WHERE (RazonSocialCompleta ='" + dato + "' AND `EsNomina` =1)";
        System.out.println(sqls);
        ConsultasMySQL xct = new ConsultasMySQL();
        String xv = xct.traerDato(sqls);
        xct.cerrarConexionBd();
        return xv;
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBTAdicionar = new JButton();
        this.JPDBusqueda = new JPanel();
        this.JTFConcepto = new JTextField();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JCHSeleccionar = new JCheckBox();
        setDefaultCloseOperation(2);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo.2
            public void actionPerformed(ActionEvent evt) {
                JDBuscarConceptoNominaxVFijo.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JPDBusqueda.setBorder(BorderFactory.createEtchedBorder());
        this.JTFConcepto.setFont(new Font("Arial", 1, 12));
        this.JTFConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConcepto.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo.3
            public void keyReleased(KeyEvent evt) {
                JDBuscarConceptoNominaxVFijo.this.JTFConceptoKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDBuscarConceptoNominaxVFijo.this.JTFConceptoKeyTyped(evt);
            }
        });
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDBuscarConceptoNominaxVFijo.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setSelected(true);
        this.JCHSeleccionar.setText("Seleccionar Todo?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDBuscarConceptoNominaxVFijo.5
            public void actionPerformed(ActionEvent evt) {
                JDBuscarConceptoNominaxVFijo.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout JPDBusquedaLayout = new GroupLayout(this.JPDBusqueda);
        this.JPDBusqueda.setLayout(JPDBusquedaLayout);
        JPDBusquedaLayout.setHorizontalGroup(JPDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPResultado).addGroup(JPDBusquedaLayout.createSequentialGroup().addComponent(this.JTFConcepto, -2, 770, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar, -1, 136, 32767))).addGap(15, 15, 15)));
        JPDBusquedaLayout.setVerticalGroup(JPDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPDBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFConcepto, -2, -1, -2).addComponent(this.JCHSeleccionar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -1, 196, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDBusqueda, -1, -1, 32767).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDBusqueda, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 38, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 9)) {
            for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 8).toString()).booleanValue()) {
                    this.xestado = 1;
                } else {
                    this.xestado = 0;
                }
                if (mDdevuelveValorCombo(this.xmodelo.getValueAt(x, 2).toString()) != "" && Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                    System.out.println(this.xmodelo.getValueAt(x, 9).toString());
                    BuscarConceptoNominaxVFijoDTO e = new BuscarConceptoNominaxVFijoDTO();
                    e.setIdTerceroC(String.valueOf(this.xIdtercero));
                    e.setId(Integer.valueOf(this.xmodelo.getValueAt(x, 0).toString()).intValue());
                    e.setTCalculo(this.xmodelo.getValueAt(x, 3).toString());
                    e.setValor(Double.valueOf(this.xmodelo.getValueAt(x, 6).toString()).doubleValue());
                    e.setValorE(Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue());
                    e.setIdCNTercero(Integer.valueOf(mDdevuelveValorCombo(this.xmodelo.getValueAt(x, 2).toString())).intValue());
                    e.setEstado(this.xestado);
                    this.xBuscarConceptoNominaxVFijoDAO.create(e);
                }
            }
            Principal.claseparametrizacionn.xjifusuarioxcargo.mNuevo_ConceptoNomina();
            Principal.claseparametrizacionn.xjifusuarioxcargo.mCargarDatos_CN();
            Principal.claseparametrizacionn.xjifusuarioxcargo.xGrabarCN = false;
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "No se ha selecionado ningun concepto para cargar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFConceptoKeyReleased(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFConceptoKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            this.xSeleccionar = true;
        } else {
            this.xSeleccionar = false;
        }
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(this.xSeleccionar), x, 9);
        }
    }
}
