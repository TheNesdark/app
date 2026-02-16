package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.TipoEventoSCDAO;
import com.genoma.plus.dao.impl.general.TipoEventoSCDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoEventoSCDTO;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoEventoSC.class */
public class JIFTipoEventoSC extends JInternalFrame {
    private TipoEventoSCDAO xTipoEventoSCDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xidTipoCategoria;
    private JButton JBTDatosA;
    private JComboBox<String> JCBTipoCategoria;
    private JCheckBox JCHAnalisis;
    private JCheckBox JCHEsPanorama;
    private JCheckBox JCHEstado;
    private JCheckBox JCHMedicamentos;
    private JPanel JPInformacion;
    private JSpinner JSCV256;
    private JSpinner JSNDias;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPNotas;
    private JTable JTDetalle;
    public JTextPane JTFNombre;
    private int xmedicamento = 0;
    private int xestado = 1;
    private int xpanorama = 1;
    private int xanalisis = 1;
    private Metodos xmt = new Metodos();

    public JIFTipoEventoSC() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoEventoSCDAO = (TipoEventoSCDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoEventoSCDAO");
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JSNDias.setValue(new Integer(0));
        this.JSCV256.setValue(new Integer(0));
        this.JCHAnalisis.setSelected(true);
        this.xanalisis = 1;
        this.JCHEsPanorama.setSelected(true);
        this.xpanorama = 1;
        this.JCHMedicamentos.setSelected(false);
        this.xmedicamento = 0;
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JBTDatosA.setEnabled(false);
        Principal.mLimpiarDatosP();
        this.JCBTipoCategoria.removeAllItems();
        List<GCGenericoDTO> list1 = this.xTipoEventoSCDAO.listaTCategoria();
        this.xidTipoCategoria = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTipoCategoria[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoCategoria.addItem(list1.get(x).getNombre());
        }
        this.JCBTipoCategoria.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoCategoria.setSelectedIndex(-1);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().equals("")) {
                    TipoEventoSCDTO e = new TipoEventoSCDTO();
                    e.setNombre(this.JTFNombre.getText());
                    e.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e.setCV256(((Integer) this.JSCV256.getValue()).intValue());
                    e.setAnalisis(this.xanalisis);
                    e.setEsPanorama(this.xpanorama);
                    e.setAplicaM(this.xmedicamento);
                    e.setIdTipoCategoria(this.xidTipoCategoria[this.JCBTipoCategoria.getSelectedIndex()]);
                    e.setEstado(this.xestado);
                    this.xTipoEventoSCDAO.create(e);
                } else {
                    TipoEventoSCDTO e2 = new TipoEventoSCDTO();
                    e2.setNombre(this.JTFNombre.getText());
                    e2.setNDias(((Integer) this.JSNDias.getValue()).intValue());
                    e2.setCV256(((Integer) this.JSCV256.getValue()).intValue());
                    e2.setAnalisis(this.xanalisis);
                    e2.setEsPanorama(this.xpanorama);
                    e2.setAplicaM(this.xmedicamento);
                    e2.setIdTipoCategoria(this.xidTipoCategoria[this.JCBTipoCategoria.getSelectedIndex()]);
                    e2.setEstado(this.xestado);
                    e2.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xTipoEventoSCDAO.update(e2);
                }
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
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Nº DIas", "CV256", "Analisis?", "EsPanorama?", "Medicamentos?", "Estado", "Categoria"}) { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.1
            Class[] types = {Long.class, String.class, Integer.class, Integer.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<TipoEventoSCDTO> list = this.xTipoEventoSCDAO.list(this.JTFNombre.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getNDias()), x, 2);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getCV256()), x, 3);
            if (list.get(x).getAnalisis() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            if (list.get(x).getEsPanorama() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
            if (list.get(x).getAplicaM() == 1) {
                this.xmodelo.setValueAt(true, x, 6);
            } else {
                this.xmodelo.setValueAt(false, x, 6);
            }
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 7);
            } else {
                this.xmodelo.setValueAt(false, x, 7);
            }
            this.xmodelo.setValueAt(list.get(x).getIdTipoCategoria(), x, 8);
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JCHAnalisis = new JCheckBox();
        this.JSNDias = new JSpinner();
        this.JCHEsPanorama = new JCheckBox();
        this.JCHMedicamentos = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JSCV256 = new JSpinner();
        this.JSPNotas = new JScrollPane();
        this.JTFNombre = new JTextPane();
        this.JCBTipoCategoria = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTDatosA = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("NOMBRE DEL EVENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipoevento");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHAnalisis.setFont(new Font("Arial", 1, 12));
        this.JCHAnalisis.setSelected(true);
        this.JCHAnalisis.setText("Analisis?");
        this.JCHAnalisis.setToolTipText("Para identificar cuales requieren obligatoriamente un análisis");
        this.JCHAnalisis.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEventoSC.this.JCHAnalisisActionPerformed(evt);
            }
        });
        this.JSNDias.setFont(new Font("Arial", 1, 12));
        this.JSNDias.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNDias.setToolTipText("Días para calcular la fecha de vencimiento del análisis del evento");
        this.JSNDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEsPanorama.setFont(new Font("Arial", 1, 12));
        this.JCHEsPanorama.setSelected(true);
        this.JCHEsPanorama.setText("Es Panorama?");
        this.JCHEsPanorama.setToolTipText("Para identificar el registro que no está como evento en el panorama de riesgo");
        this.JCHEsPanorama.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEventoSC.this.JCHEsPanoramaActionPerformed(evt);
            }
        });
        this.JCHMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JCHMedicamentos.setSelected(true);
        this.JCHMedicamentos.setText("Medicamentos?");
        this.JCHMedicamentos.setToolTipText("Si el evento tiene relación con medicamentos");
        this.JCHMedicamentos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.4
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEventoSC.this.JCHMedicamentosActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEventoSC.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSCV256.setFont(new Font("Arial", 1, 12));
        this.JSCV256.setModel(new SpinnerNumberModel());
        this.JSCV256.setToolTipText("Numero de la columna en la resolución 256");
        this.JSCV256.setBorder(BorderFactory.createTitledBorder((Border) null, "CV256", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.6
            public void keyPressed(KeyEvent evt) {
                JIFTipoEventoSC.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTFNombre);
        this.JCBTipoCategoria.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Categoria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JSPNotas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSNDias, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSCV256, -2, 83, -2).addContainerGap()).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCBTipoCategoria, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHAnalisis).addGap(4, 4, 4).addComponent(this.JCHEsPanorama).addGap(2, 2, 2).addComponent(this.JCHMedicamentos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)))));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSNDias, -2, 61, -2).addComponent(this.JSCV256, -2, 61, -2))).addComponent(this.JSPNotas, -2, 79, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoCategoria, -2, 50, -2).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAnalisis).addComponent(this.JCHEsPanorama).addComponent(this.JCHMedicamentos)).addComponent(this.JCHEstado))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.7
            public void mouseClicked(MouseEvent evt) {
                JIFTipoEventoSC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTDatosA.setFont(new Font("Arial", 1, 13));
        this.JBTDatosA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.JBTDatosA.setText("Tipo Evento x Consecuencias/Acciones");
        this.JBTDatosA.setEnabled(false);
        this.JBTDatosA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoEventoSC.8
            public void actionPerformed(ActionEvent evt) {
                JIFTipoEventoSC.this.JBTDatosAActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JBTDatosA, -1, -1, 32767).addComponent(this.JPInformacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 364, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTDatosA, -2, 60, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnalisisActionPerformed(ActionEvent evt) {
        if (this.JCHAnalisis.isSelected()) {
            this.xanalisis = 1;
        } else {
            this.xanalisis = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPanoramaActionPerformed(ActionEvent evt) {
        if (this.JCHEsPanorama.isSelected()) {
            this.xpanorama = 1;
        } else {
            this.xpanorama = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMedicamentosActionPerformed(ActionEvent evt) {
        if (this.JCHMedicamentos.isSelected()) {
            this.xmedicamento = 1;
        } else {
            this.xmedicamento = 0;
        }
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
        this.JSNDias.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        this.JSCV256.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
            this.JCHAnalisis.setSelected(true);
            this.xanalisis = 1;
        } else {
            this.JCHAnalisis.setSelected(false);
            this.xanalisis = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
            this.JCHEsPanorama.setSelected(true);
            this.xpanorama = 1;
        } else {
            this.JCHEsPanorama.setSelected(false);
            this.xpanorama = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue()) {
            this.JCHMedicamentos.setSelected(true);
            this.xmedicamento = 1;
        } else {
            this.JCHMedicamentos.setSelected(false);
            this.xmedicamento = 0;
        }
        if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue()) {
            this.JCHEstado.setSelected(true);
            this.xestado = 1;
        } else {
            this.JCHEstado.setSelected(false);
            this.xestado = 0;
        }
        this.JCBTipoCategoria.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
        this.JBTDatosA.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTDatosAActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JD_SC_TEventoTConAcc detalle = new JD_SC_TEventoTConAcc(null, true);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }
}
