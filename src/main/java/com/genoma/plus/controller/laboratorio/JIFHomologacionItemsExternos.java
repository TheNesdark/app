package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.HomologacionItemsExternosDAOImpl;
import com.genoma.plus.dao.laboratorio.HomologacionItemsExternosDAO;
import com.genoma.plus.dto.laboratorio.HomologacionItemsExternosDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFHomologacionItemsExternos.class */
public class JIFHomologacionItemsExternos extends JInternalFrame {
    private String[] xidClasificacion;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private HomologacionItemsExternosDAO xHomologacionItemsExternosDAO;
    private JCheckBox JCHEsUltimoNivel;
    private JFormattedTextField JFTFIdCodigoPadre;
    private JFormattedTextField JFTFIdDetalleAnalito;
    private JFormattedTextField JFTFIdProcedimiento;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private int xUltimoNivel = 1;
    private Metodos xmt = new Metodos();

    public JIFHomologacionItemsExternos() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xHomologacionItemsExternosDAO = (HomologacionItemsExternosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("homologacionItemsExternosDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JFTFIdCodigoPadre.setText("");
        this.JTFNombre.setText("");
        this.JFTFIdDetalleAnalito.setText("");
        this.JFTFIdProcedimiento.setText("");
        this.JCHEsUltimoNivel.setSelected(true);
        this.xUltimoNivel = 1;
        mCargarDatosTabla();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                HomologacionItemsExternosDTO e = new HomologacionItemsExternosDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setIdCodigoPadre(Long.valueOf(this.JFTFIdCodigoPadre.getValue().toString()).longValue());
                    e.setNombreExterno(this.JTFNombre.getText());
                    e.setIdDetalleAnalito(Long.valueOf(this.JFTFIdDetalleAnalito.getValue().toString()).longValue());
                    e.setIdProcedimiento(Long.valueOf(this.JFTFIdProcedimiento.getValue().toString()).longValue());
                    e.setEsUltimoNivel(this.xUltimoNivel);
                    this.xHomologacionItemsExternosDAO.create(e);
                } else {
                    e.setEsUltimoNivel(this.xUltimoNivel);
                    e.setIdCodigoPadre(Long.valueOf(this.JFTFIdCodigoPadre.getValue().toString()).longValue());
                    e.setIdDetalleAnalito(Long.valueOf(this.JFTFIdDetalleAnalito.getValue().toString()).longValue());
                    e.setIdProcedimiento(Long.valueOf(this.JFTFIdProcedimiento.getValue().toString()).longValue());
                    this.xHomologacionItemsExternosDAO.update(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdCodigoPadre", "Nombre Externo", "IdDetalleAnalito", "IdProcedimiento", "Es Ultimo Nivel?"}) { // from class: com.genoma.plus.controller.laboratorio.JIFHomologacionItemsExternos.1
            Class[] types = {Long.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        List<HomologacionItemsExternosDTO> list = this.xHomologacionItemsExternosDAO.listaItemsExternos();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getIdCodigoPadre()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombreExterno(), x, 1);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getIdDetalleAnalito()), x, 2);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getIdProcedimiento()), x, 3);
            if (list.get(x).getEsUltimoNivel() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JFTFIdCodigoPadre = new JFormattedTextField();
        this.JTFNombre = new JTextField();
        this.JCHEsUltimoNivel = new JCheckBox();
        this.JFTFIdDetalleAnalito = new JFormattedTextField();
        this.JFTFIdProcedimiento = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("HOMOLOGACION DE ITEMS EXTERNOS");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifhomologacionitemsexternos");
        this.JFTFIdCodigoPadre.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Codigo Padre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFIdCodigoPadre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JFTFIdCodigoPadre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Externo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsUltimoNivel.setFont(new Font("Arial", 1, 12));
        this.JCHEsUltimoNivel.setText("Es Ultimo Nivel?");
        this.JCHEsUltimoNivel.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFHomologacionItemsExternos.2
            public void actionPerformed(ActionEvent evt) {
                JIFHomologacionItemsExternos.this.JCHEsUltimoNivelActionPerformed(evt);
            }
        });
        this.JFTFIdDetalleAnalito.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Detalle Analito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFIdDetalleAnalito.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JFTFIdDetalleAnalito.setFont(new Font("Arial", 1, 12));
        this.JFTFIdProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFIdProcedimiento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JFTFIdProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFHomologacionItemsExternos.3
            public void mouseClicked(MouseEvent evt) {
                JIFHomologacionItemsExternos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JFTFIdDetalleAnalito, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFIdProcedimiento, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsUltimoNivel).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 768, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JFTFIdCodigoPadre, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNombre, -2, 626, -2))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JFTFIdCodigoPadre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFIdDetalleAnalito, -2, 50, -2).addComponent(this.JFTFIdProcedimiento, -2, 50, -2)).addComponent(this.JCHEsUltimoNivel, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsUltimoNivelActionPerformed(ActionEvent evt) {
        if (this.JCHEsUltimoNivel.isSelected()) {
            this.xUltimoNivel = 1;
        } else {
            this.xUltimoNivel = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JFTFIdCodigoPadre.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JFTFIdDetalleAnalito.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JFTFIdProcedimiento.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.xUltimoNivel = 1;
                this.JCHEsUltimoNivel.setSelected(true);
            } else {
                this.xUltimoNivel = 0;
                this.JCHEsUltimoNivel.setSelected(false);
            }
        }
    }
}
