package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ResolucionDianDTO;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIF_ResolucionDian.class */
public class JIF_ResolucionDian extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private ResolucionDianDTO dto;
    private Object[] datos;
    private JButton JBTSede;
    private JCheckBox JCKEstado;
    private JDateChooser JDFechaFinal;
    private JDateChooser JDFechaInicial;
    private JSpinner JSPDiasPago;
    private JSpinner JSPNumeroFinal;
    private JSpinner JSPNumeroInicial;
    private JTextArea JTADescripcion;
    private JTable JTDetalle;
    private JTextField JTFPrefijo;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos xmt = new Metodos();
    private final IResolucionDianDAO dao = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
    private Integer id = 0;

    public JIF_ResolucionDian() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JDFechaInicial.setDate(this.xmt.getFechaActual());
        this.JDFechaFinal.setDate(this.xmt.getFechaActual());
        this.JSPDiasPago.setValue(new Integer(0));
        this.JSPNumeroInicial.setValue(new Integer(0));
        this.JSPNumeroFinal.setValue(new Integer(0));
        this.JTFPrefijo.setText("");
        this.JTADescripcion.setText("");
        this.JCKEstado.setSelected(true);
        mCarcarDatosTabla();
        this.id = 0;
    }

    public void mGrabar() {
        if (!this.JTFPrefijo.getText().isEmpty()) {
            if (!this.JTADescripcion.getText().isEmpty()) {
                if (Integer.parseInt(this.JSPNumeroInicial.getValue().toString()) > 0) {
                    if (Integer.parseInt(this.JSPNumeroFinal.getValue().toString()) > 0) {
                        String grabar = "guardar";
                        this.dto = new ResolucionDianDTO();
                        if (this.id.intValue() > 0) {
                            this.dto.setId(this.id);
                            grabar = "actualizar";
                        }
                        this.dto.setDescripcion(this.JTADescripcion.getText());
                        this.dto.setFechaI(this.JDFechaInicial.getDate());
                        this.dto.setFechaF(this.JDFechaFinal.getDate());
                        this.dto.setPrefijo(this.JTFPrefijo.getText());
                        this.dto.setNumeroI(Long.valueOf(Long.parseLong(this.JSPNumeroInicial.getValue().toString())));
                        this.dto.setNumeroF(Long.valueOf(Long.parseLong(this.JSPNumeroFinal.getValue().toString())));
                        this.dto.setDiasP(Integer.valueOf(Integer.parseInt(this.JSPDiasPago.getValue().toString())));
                        this.dto.setEstado(Boolean.valueOf(this.JCKEstado.isSelected()));
                        this.dto.setFecha(this.xmt.getFechaActual());
                        this.dto.setId_UsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                        Boolean activar = true;
                        int i = 0;
                        while (true) {
                            if (i < this.JTDetalle.getRowCount()) {
                                if (this.xmodelo.getValueAt(i, 0).toString().equals(this.id.toString()) || !Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue() || !this.JCKEstado.isSelected()) {
                                    i++;
                                } else {
                                    activar = false;
                                    JOptionPane.showMessageDialog(this, "Debe desactivar la resolución dian que esta activa", "VERIFICAR", 1);
                                    this.JTDetalle.setSelectionMode(i);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (activar.booleanValue()) {
                            int confirmacion = JOptionPane.showInternalConfirmDialog(this, "¿Seguro que desea " + grabar + "?", "CONFIRMAR", 0, 3);
                            if (confirmacion == 0) {
                                this.dao.grabar(this.dto);
                                mNuevo();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe agregar el numero final", "VERIFICAR", 1);
                    this.JSPNumeroFinal.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe agregar el numero inicial", "VERIFICAR", 1);
                this.JSPNumeroInicial.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe agregar una descripción", "VERIFICAR", 1);
            this.JTADescripcion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debes agregar un prefijo", "VERIFICAR", 1);
        this.JTFPrefijo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Descripcion", "FechaI", "FechaF", "Prefijo", "NumeroI", "NumeroF", "DiasP", "Estado", "Fecha", "Id_UsuarioS"}) { // from class: com.genoma.plus.controller.parametrizacion.JIF_ResolucionDian.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Integer.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
    }

    private void mCarcarDatosTabla() {
        mCrearModelo();
        List<ResolucionDianDTO> lis = this.dao.consultar();
        for (int i = 0; i < lis.size(); i++) {
            this.xmodelo.addRow(this.datos);
            this.xmodelo.setValueAt(lis.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(lis.get(i).getDescripcion(), i, 1);
            this.xmodelo.setValueAt(this.xmt.formatoDMA.format(lis.get(i).getFechaI()), i, 2);
            this.xmodelo.setValueAt(this.xmt.formatoDMA.format(lis.get(i).getFechaF()), i, 3);
            this.xmodelo.setValueAt(lis.get(i).getPrefijo(), i, 4);
            this.xmodelo.setValueAt(lis.get(i).getNumeroI(), i, 5);
            this.xmodelo.setValueAt(lis.get(i).getNumeroF(), i, 6);
            this.xmodelo.setValueAt(lis.get(i).getDiasP(), i, 7);
            this.xmodelo.setValueAt(lis.get(i).getEstado(), i, 8);
            this.xmodelo.setValueAt(this.xmt.formatoDMA.format(lis.get(i).getFecha()), i, 9);
            this.xmodelo.setValueAt(lis.get(i).getId_UsuarioS(), i, 10);
        }
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaInicial = new JDateChooser();
        this.JDFechaFinal = new JDateChooser();
        this.JSPDiasPago = new JSpinner();
        this.JSPNumeroInicial = new JSpinner();
        this.JSPNumeroFinal = new JSpinner();
        this.JTFPrefijo = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcion = new JTextArea();
        this.JCKEstado = new JCheckBox();
        this.JBTSede = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Resolucion Dian");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_ResolucionDian");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicial.setFont(new Font("Arial", 1, 12));
        this.JDFechaFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFinal.setFont(new Font("Arial", 1, 12));
        this.JSPDiasPago.setFont(new Font("Arial", 1, 12));
        this.JSPDiasPago.setModel(new SpinnerNumberModel(0, 0, 1000, 1));
        this.JSPDiasPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNumeroInicial.setFont(new Font("Arial", 1, 12));
        this.JSPNumeroInicial.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNumeroInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNumeroFinal.setFont(new Font("Arial", 1, 12));
        this.JSPNumeroFinal.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNumeroFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPrefijo.setFont(new Font("Arial", 1, 12));
        this.JTFPrefijo.setBorder(BorderFactory.createTitledBorder((Border) null, "Prefijo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPrefijo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIF_ResolucionDian.2
            public void actionPerformed(ActionEvent evt) {
                JIF_ResolucionDian.this.JTFPrefijoActionPerformed(evt);
            }
        });
        this.JTADescripcion.setColumns(20);
        this.JTADescripcion.setFont(new Font("Arial", 1, 12));
        this.JTADescripcion.setLineWrap(true);
        this.JTADescripcion.setRows(5);
        this.JTADescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTADescripcion);
        this.JCKEstado.setFont(new Font("Arial", 1, 12));
        this.JCKEstado.setSelected(true);
        this.JCKEstado.setText("Estado");
        this.JBTSede.setFont(new Font("Arial", 1, 12));
        this.JBTSede.setText("SEDE");
        this.JBTSede.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIF_ResolucionDian.3
            public void actionPerformed(ActionEvent evt) {
                JIF_ResolucionDian.this.JBTSedeActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaInicial, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaFinal, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDiasPago, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNumeroInicial, -2, 110, -2)).addComponent(this.JTFPrefijo)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNumeroFinal, -2, 102, -2).addGap(18, 18, 18).addComponent(this.JCKEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JBTSede, -1, -1, 32767)))).addComponent(this.jScrollPane1)).addGap(16, 16, 16)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNumeroInicial).addComponent(this.JSPDiasPago).addComponent(this.JSPNumeroFinal).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCKEstado)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicial, -2, 50, -2).addComponent(this.JDFechaFinal, -2, 50, -2))).addGap(0, 0, 32767))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFPrefijo, -1, 46, 32767).addComponent(this.JBTSede, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, -1, -2).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIF_ResolucionDian.4
            public void mouseClicked(MouseEvent evt) {
                JIF_ResolucionDian.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 213, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPrefijoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSedeActionPerformed(ActionEvent evt) {
        JDSedeResolucionDian form = new JDSedeResolucionDian(null, true);
        form.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedColumn() == 8) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue()) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue()) {
                    int v = JOptionPane.showInternalConfirmDialog(this, "¿Esta seguro que desea desactivar?", "CONFIRMAR", 0, 3);
                    if (v == 0) {
                        this.dao.updateEstado(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), Boolean.valueOf(!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue()));
                        mCarcarDatosTabla();
                        return;
                    }
                    return;
                }
                return;
            }
            Boolean activar = true;
            int i = 0;
            while (true) {
                if (i >= this.JTDetalle.getRowCount()) {
                    break;
                }
                if (!Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                    i++;
                } else {
                    activar = false;
                    JOptionPane.showMessageDialog(this, "Debe desactivar la resolución dian que esta activa", "VERIFICAR", 1);
                    this.JTDetalle.setSelectionMode(i);
                    break;
                }
            }
            if (activar.booleanValue()) {
                int v2 = JOptionPane.showInternalConfirmDialog(this, "¿Esta seguro que desea activar?", "CONFIRMAR", 0, 3);
                if (v2 == 0) {
                    this.dao.updateEstado(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), Boolean.valueOf(!Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue()));
                    mCarcarDatosTabla();
                    return;
                }
                return;
            }
            return;
        }
        this.id = Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
        this.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JDFechaInicial.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        this.JDFechaFinal.setDate(this.xmt.getPasarTextoAFecha(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
        this.JTFPrefijo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        this.JSPNumeroInicial.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString())));
        this.JSPNumeroFinal.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString())));
        this.JSPDiasPago.setValue(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString())));
        this.JCKEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
    }
}
