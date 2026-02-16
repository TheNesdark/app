package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import com.genoma.plus.jpa.projection.ICuenta;
import com.genoma.plus.jpa.projection.IDocumentosDescuadrados;
import com.genoma.plus.jpa.service.IDocumentosContablesDescuadrados;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFRevisionDocumentosDescuadrados.class */
public class JIFRevisionDocumentosDescuadrados extends JInternalFrame {
    private final IDocumentosContablesDescuadrados documentosDescuadrados = (IDocumentosContablesDescuadrados) Principal.contexto.getBean(IDocumentosContablesDescuadrados.class);
    private Object[] xdatos;
    public DefaultTableModel xmodelo;
    public DefaultTableModel modeloCuentas;
    private JButton JBCorregirNaturaleza;
    private JPanel JPDocumentosDescuadrados;
    private JTable JTCuentas;
    private JTable JTResultado;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;

    public JIFRevisionDocumentosDescuadrados() {
        initComponents();
        cargarDatos();
        cargarCuentasConErroresDePadres();
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JBCorregirNaturaleza = new JButton();
        this.JPDocumentosDescuadrados = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.jPanel3 = new JPanel();
        this.jPanel4 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTCuentas = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("Documentos Descuadrado");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap1.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBCorregirNaturaleza.setFont(new Font("Arial", 1, 12));
        this.JBCorregirNaturaleza.setText("Corregir Naturaleza");
        this.JBCorregirNaturaleza.setToolTipText("");
        this.JBCorregirNaturaleza.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFRevisionDocumentosDescuadrados.1
            public void actionPerformed(ActionEvent evt) {
                JIFRevisionDocumentosDescuadrados.this.JBCorregirNaturalezaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBCorregirNaturaleza, -2, 151, -2)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBCorregirNaturaleza, GroupLayout.Alignment.TRAILING, -1, 47, 32767));
        GroupLayout JPDocumentosDescuadradosLayout = new GroupLayout(this.JPDocumentosDescuadrados);
        this.JPDocumentosDescuadrados.setLayout(JPDocumentosDescuadradosLayout);
        JPDocumentosDescuadradosLayout.setHorizontalGroup(JPDocumentosDescuadradosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 6, 32767));
        JPDocumentosDescuadradosLayout.setVerticalGroup(JPDocumentosDescuadradosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 314, 32767));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.JTResultado);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 952, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 0, 32767));
        this.jTabbedPane1.addTab("Documentos Descuadrados", this.jPanel2);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jScrollPane2.setViewportView(this.JTCuentas);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 904, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, -1, -2).addGap(0, 0, 32767)));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -1, -1, 32767));
        this.jTabbedPane1.addTab("Sin Cuentas  padres", this.jPanel3);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 957, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.JPDocumentosDescuadrados, -1, -1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPDocumentosDescuadrados, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -1, 492, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2))).addGap(4, 4, 4)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCorregirNaturalezaActionPerformed(ActionEvent evt) {
        this.documentosDescuadrados.corregirNaturaleza();
    }

    private void cargarDatos() {
        crearModelo();
        List<IDocumentosDescuadrados> lista = this.documentosDescuadrados.listaDocumentosDescuadrados();
        for (int x = 0; x < lista.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(lista.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(lista.get(x).getConsecutivo(), x, 1);
            this.xmodelo.setValueAt(lista.get(x).getDescripcion(), x, 2);
            this.xmodelo.setValueAt(lista.get(x).getFechaD(), x, 3);
            this.xmodelo.setValueAt(lista.get(x).getDebito(), x, 4);
            this.xmodelo.setValueAt(lista.get(x).getCredito(), x, 5);
            this.xmodelo.setValueAt(lista.get(x).getDiferencia(), x, 6);
            this.xmodelo.setValueAt(lista.get(x).getNombre(), x, 7);
        }
    }

    private void crearModelo() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"id", "Consecutivo", "Descripcion", "Fecha", "Debito", "Credito", "Diferencia", "Tipo de Documento"}) { // from class: com.genoma.plus.controller.contabilidad.JIFRevisionDocumentosDescuadrados.2
            Class[] types = {Integer.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTResultado;
        JTable jTable2 = this.JTResultado;
        jTable.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(300);
    }

    private void cargarCuentasConErroresDePadres() {
        crearModeloCuentas();
        List<ICuenta> listaCuentas = this.documentosDescuadrados.listaCuentasSinPadre();
        for (int j = 0; j < listaCuentas.size(); j++) {
            this.modeloCuentas.addRow(this.xdatos);
            this.modeloCuentas.setValueAt(listaCuentas.get(j).getIdCuenta(), j, 0);
            this.modeloCuentas.setValueAt(listaCuentas.get(j).getNombreCuenta(), j, 1);
            this.modeloCuentas.setValueAt(listaCuentas.get(j).getPadreActual(), j, 2);
            this.modeloCuentas.setValueAt(listaCuentas.get(j).getPadreCorrecto(), j, 3);
        }
    }

    private void crearModeloCuentas() {
        this.modeloCuentas = new DefaultTableModel((Object[][]) null, new String[]{"id", "Nombre", "Padre Actual", "Padre Correcto"}) { // from class: com.genoma.plus.controller.contabilidad.JIFRevisionDocumentosDescuadrados.3
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTCuentas;
        JTable jTable2 = this.JTCuentas;
        jTable.setAutoResizeMode(0);
        this.JTCuentas.doLayout();
        this.JTCuentas.setModel(this.modeloCuentas);
        this.JTCuentas.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTCuentas.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTCuentas.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.JTCuentas.getColumnModel().getColumn(3).setPreferredWidth(90);
    }
}
