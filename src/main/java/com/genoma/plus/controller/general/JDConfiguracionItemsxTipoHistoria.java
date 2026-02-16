package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.ConfiguracionItemsxTipoHistoriaDAO;
import com.genoma.plus.dao.impl.general.ConfiguracionItemsxTipoHistoriaDAOImpl;
import com.genoma.plus.dto.general.ConfiguracionItemsxTipoHistoriaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDConfiguracionItemsxTipoHistoria.class */
public class JDConfiguracionItemsxTipoHistoria extends JDialog {
    private int xEstado;
    private int xGuardar;
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private ConfiguracionItemsxTipoHistoriaDAO xConfiguracionItemsxTipoHistoriaDAO;
    private String[] xIdTipoHistoria;
    private JButton JBT_Grabar;
    private JButton JBT_Salir1;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFFiltro;

    public JDConfiguracionItemsxTipoHistoria(Frame parent, boolean modal) {
        super(parent, modal);
        this.xEstado = 1;
        this.xGuardar = 0;
        initComponents();
        setTitle("CONFIGURACION DE ITEMS POR TIPO DE HISTORIA");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xConfiguracionItemsxTipoHistoriaDAO = (ConfiguracionItemsxTipoHistoriaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("configuracionItemsxTipoHistoriaDAO");
    }

    public void mNuevo() {
        mCargarDatosTabla();
    }

    public void mGrabar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            ConfiguracionItemsxTipoHistoriaDTO e = new ConfiguracionItemsxTipoHistoriaDTO();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                e.setIdConfiguracion(Long.valueOf(this.xModelo.getValueAt(i, 0).toString()));
                e.setIdTipoHistoria(Principal.txtNo.getText());
                e.setOrden(Integer.valueOf(this.xModelo.getValueAt(i, 2).toString()).intValue());
                if (Boolean.valueOf(this.xModelo.getValueAt(i, 4).toString()).booleanValue()) {
                    e.setEstado(1);
                } else {
                    e.setEstado(0);
                }
                if (this.xModelo.getValueAt(i, 3).toString().equals("SIN GRABAR") && Boolean.valueOf(this.xModelo.getValueAt(i, 4).toString()).booleanValue()) {
                    this.xConfiguracionItemsxTipoHistoriaDAO.mCreate(e);
                } else {
                    this.xConfiguracionItemsxTipoHistoriaDAO.mUpdate(e);
                }
            }
            mNuevo();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo de Historia", "Nº Orden", "Grabado", "Seleccionar"}) { // from class: com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria.1
            Class[] types = {Long.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<Object[]> list = this.xConfiguracionItemsxTipoHistoriaDAO.mListar(Principal.txtNo.getText(), this.JTFFiltro.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            if (list.get(x)[3].toString().equals("ACTIVO")) {
                this.xModelo.setValueAt(true, x, 4);
            } else {
                this.xModelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JTFFiltro = new JTextField();
        setDefaultCloseOperation(2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria.2
            public void mouseClicked(MouseEvent evt) {
                JDConfiguracionItemsxTipoHistoria.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria.3
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionItemsxTipoHistoria.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria.4
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionItemsxTipoHistoria.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar Item", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDConfiguracionItemsxTipoHistoria.5
            public void keyPressed(KeyEvent evt) {
                JDConfiguracionItemsxTipoHistoria.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, -2, 697, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Grabar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir1, -2, 354, -2)))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro, -2, 697, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro, -2, 50, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 264, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addGap(10, 10, 10)));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }
}
