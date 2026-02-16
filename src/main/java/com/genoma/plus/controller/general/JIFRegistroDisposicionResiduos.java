package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.RegistroDisposicionResiduosDAO;
import com.genoma.plus.dao.impl.general.RegistroDisposicionResiduosDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.RegistroDisposicionResiduosDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFRegistroDisposicionResiduos.class */
public class JIFRegistroDisposicionResiduos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private RegistroDisposicionResiduosDAO xRegistroDisposicionResiduosDAO;
    private Object[] xDato;
    private String[] xidTercero;
    private String[] xidClasificacion;
    private JButton JBTAdicionarUF;
    private JComboBox<String> JCBTercero;
    private JComboBox<String> JCBTipoClasificacion;
    public JDateChooser JDFFecha;
    private JPanel JPInformacion;
    private JSpinner JSPCantidad;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTable JTDetalle;
    private JTextPane JTPObservacion;
    private int xEstado = 1;
    private Metodos xmetodos = new Metodos();

    public JIFRegistroDisposicionResiduos() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRegistroDisposicionResiduosDAO = (RegistroDisposicionResiduosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("registroDisposicionResiduosDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFFecha.setDate(this.xmetodos.getFechaActual());
        this.JCBTercero.setSelectedIndex(-1);
        this.JTPObservacion.setText("");
        this.JCBTipoClasificacion.setSelectedIndex(-1);
        this.JSPCantidad.setValue(0);
        mLlenarCombos();
        mCrearModeloTabla();
    }

    private void mLlenarCombos() {
        this.JCBTercero.removeAllItems();
        List<GCGenericoDTO> list1 = this.xRegistroDisposicionResiduosDAO.listaTerceros();
        this.xidTercero = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTercero[x] = String.valueOf(list1.get(x).getId());
            this.JCBTercero.addItem(list1.get(x).getNombre());
        }
        this.JCBTercero.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBTipoClasificacion.removeAllItems();
        List<GCGenericoDTO> list2 = this.xRegistroDisposicionResiduosDAO.listaClasificacionResiduos();
        this.xidClasificacion = new String[list2.size()];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xidClasificacion[x2] = String.valueOf(list2.get(x2).getId());
            this.JCBTipoClasificacion.addItem(list2.get(x2).getNombre());
        }
        this.JCBTipoClasificacion.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoClasificacion.setSelectedIndex(-1);
    }

    public void mGuardar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JTDetalle.getRowCount() > 0) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        RegistroDisposicionResiduosDTO e = new RegistroDisposicionResiduosDTO();
                        if (Principal.txtNo.getText().equals("")) {
                            e.setFecha(this.xmetodos.formatoAMD.format(this.JDFFecha.getDate()));
                            e.setIdTercero(this.xidTercero[this.JCBTercero.getSelectedIndex()]);
                            e.setObservacion(this.JTPObservacion.getText());
                            e.setIdTerceroRH(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                            String xIdRegistroResiduo = this.xRegistroDisposicionResiduosDAO.create_return_id(e);
                            Principal.txtNo.setText(xIdRegistroResiduo);
                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                e.setIdRDisposicion(Long.valueOf(xIdRegistroResiduo));
                                e.setIdTipoClasificacion(Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()));
                                e.setCantidad(Integer.valueOf(this.xmodelo.getValueAt(y, 2).toString()).intValue());
                                this.xRegistroDisposicionResiduosDAO.createDetalleResiduo(e);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro ya esta guardado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTercero.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdClasificacion", "Clasificacion", "Cantidad"}) { // from class: com.genoma.plus.controller.general.JIFRegistroDisposicionResiduos.1
            Class[] types = {Long.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mBuscaDatos() {
        mCrearModeloTabla();
        List<RegistroDisposicionResiduosDTO> list = this.xRegistroDisposicionResiduosDAO.listaRegistroDetalleResiduos(1);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getIdTipoClasificacion(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNTipoClasificacion(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getCantidad()), x, 2);
        }
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPInformacion = new JPanel();
        this.JDFFecha = new JDateChooser();
        this.JCBTercero = new JComboBox<>();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JCBTipoClasificacion = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPCantidad = new JSpinner();
        this.JBTAdicionarUF = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE DISPOSICION DE RESIDUOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifregistroresiduos");
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setToolTipText("");
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTPObservacion.setPreferredSize((Dimension) null);
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JDFFecha, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, 0, -1, 32767)).addComponent(this.JSPObservacion, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JDFFecha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 85, 32767).addContainerGap()));
        this.JCBTipoClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoClasificacion.setToolTipText("");
        this.JCBTipoClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFRegistroDisposicionResiduos.2
            public void keyPressed(KeyEvent evt) {
                JIFRegistroDisposicionResiduos.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPCantidad.setFont(new Font("Arial", 1, 12));
        this.JSPCantidad.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarUF.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarUF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarUF.setText("Adicionar");
        this.JBTAdicionarUF.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFRegistroDisposicionResiduos.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroDisposicionResiduos.this.JBTAdicionarUFActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JCBTipoClasificacion, -2, 448, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCantidad, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarUF, -1, 158, 32767)).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoClasificacion, -2, 50, -2).addComponent(this.JSPCantidad, -2, 50, -2)).addComponent(this.JBTAdicionarUF, -2, 53, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 329, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarUFActionPerformed(ActionEvent evt) {
        if (this.JCBTipoClasificacion.getSelectedIndex() != -1) {
            if (Integer.valueOf(this.JSPCantidad.getValue().toString()).intValue() != 0) {
                if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTDetalle, 1, this.JCBTipoClasificacion.getSelectedItem().toString())) {
                    System.out.println(this.JTDetalle.getRowCount());
                    this.xmodelo.addRow(this.xDato);
                    this.xmodelo.setValueAt(Long.valueOf(this.xidClasificacion[this.JCBTipoClasificacion.getSelectedIndex()]), this.JTDetalle.getRowCount() - 1, 0);
                    this.xmodelo.setValueAt(this.JCBTipoClasificacion.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JSPCantidad.getValue().toString()), this.JTDetalle.getRowCount() - 1, 2);
                    this.JCBTipoClasificacion.setSelectedIndex(-1);
                    this.JSPCantidad.setValue(0);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Esta clasificacion ya se encuentra registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La cantidad debe ser mayor a 0", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JSPCantidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoClasificacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (Principal.txtNo.getText().isEmpty() && evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea eliminar la fila seleccionada?", "ELIMINAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            }
        }
    }
}
