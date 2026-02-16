package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.TipoConAccionDAO;
import com.genoma.plus.dao.impl.general.TipoConAccionDAOImpl;
import com.genoma.plus.dto.general.TipoConAccionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoConsecuenciAcciones.class */
public class JIFTipoConsecuenciAcciones extends JInternalFrame {
    private TipoConAccionDAO xTipoConAccion;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JPanel JPInformacion;
    private JPanel JPTipo;
    private JRadioButton JRBConsecuencias;
    private JRadioButton JRBCorrectiva;
    private JRadioButton JRBPreventiva;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPNombre;
    private JTable JTDetalle;
    private JTextArea JTFNombre;
    private ButtonGroup buttonGroup1;
    private int xtipo = 0;
    private int xestado = 1;
    private Metodos xmt = new Metodos();

    public JIFTipoConsecuenciAcciones() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoConAccion = (TipoConAccionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoConAccionDAO");
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JRBConsecuencias.setSelected(true);
        this.xtipo = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        Principal.mLimpiarDatosP();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().equals("")) {
                    TipoConAccionDTO e = new TipoConAccionDTO();
                    e.setNombre(this.JTFNombre.getText());
                    e.setTipo(this.xtipo);
                    e.setEstado(this.xestado);
                    this.xTipoConAccion.create(e);
                    mNuevo();
                    return;
                }
                TipoConAccionDTO e2 = new TipoConAccionDTO();
                e2.setNombre(this.JTFNombre.getText());
                e2.setTipo(this.xtipo);
                e2.setEstado(this.xestado);
                e2.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                this.xTipoConAccion.update(e2);
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NoTipo", "Tipo", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.1
            Class[] types = {Long.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<TipoConAccionDTO> list = this.xTipoConAccion.list();
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getTipo()), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNTipo(), x, 3);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPInformacion = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JPTipo = new JPanel();
        this.JRBPreventiva = new JRadioButton();
        this.JRBCorrectiva = new JRadioButton();
        this.JRBConsecuencias = new JRadioButton();
        this.JSPNombre = new JScrollPane();
        this.JTFNombre = new JTextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CONSECUENCIA - ACCIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjtipoconaccion");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConsecuenciAcciones.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup1.add(this.JRBPreventiva);
        this.JRBPreventiva.setFont(new Font("Arial", 1, 12));
        this.JRBPreventiva.setText("Acciones Preventivas");
        this.JRBPreventiva.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConsecuenciAcciones.this.JRBPreventivaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBCorrectiva);
        this.JRBCorrectiva.setFont(new Font("Arial", 1, 12));
        this.JRBCorrectiva.setText("Correctivo Inmediato");
        this.JRBCorrectiva.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConsecuenciAcciones.this.JRBCorrectivaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBConsecuencias);
        this.JRBConsecuencias.setFont(new Font("Arial", 1, 12));
        this.JRBConsecuencias.setSelected(true);
        this.JRBConsecuencias.setText("Consecuencias");
        this.JRBConsecuencias.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConsecuenciAcciones.this.JRBConsecuenciasActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addContainerGap().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBConsecuencias).addComponent(this.JRBCorrectiva).addComponent(this.JRBPreventiva)).addContainerGap(-1, 32767)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addComponent(this.JRBConsecuencias).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCorrectiva).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPreventiva).addContainerGap()));
        this.JSPNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setColumns(20);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setRows(5);
        this.JSPNombre.setViewportView(this.JTFNombre);
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPTipo, -2, -1, -2).addComponent(this.JCHEstado)).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEstado).addGap(1, 1, 1)).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JSPNombre, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoConsecuenciAcciones.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoConsecuenciAcciones.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 631, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 230, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCorrectivaActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConsecuenciasActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPreventivaActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()) == 0) {
            this.JRBConsecuencias.setSelected(true);
            this.xtipo = 0;
        }
        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()) == 1) {
            this.JRBCorrectiva.setSelected(true);
            this.xtipo = 1;
        }
        if (Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()) == 2) {
            this.JRBPreventiva.setSelected(true);
            this.xtipo = 2;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xestado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.xestado = 0;
        }
    }
}
