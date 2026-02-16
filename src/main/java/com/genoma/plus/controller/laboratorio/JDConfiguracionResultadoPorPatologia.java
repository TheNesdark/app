package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import com.genoma.plus.jpa.entities.ResultadoPorPatologiaDTO;
import com.genoma.plus.jpa.projection.IProtocoloPorTipoResultado;
import com.genoma.plus.jpa.service.ResultadoPorPtologiaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDConfiguracionResultadoPorPatologia.class */
public class JDConfiguracionResultadoPorPatologia extends JDialog {
    private ConsultasMySQL xconsulta;
    private String[] xidTipoPatologia;
    private String[] xidTipoResultado;
    private Boolean xlleno;
    private final ResultadoPorPtologiaService xResultadoPorPtologiaService;
    List<IProtocoloPorTipoResultado> listadoOrdenes;
    private DefaultTableModel modeloTabla;
    private Object[] datos;
    private String xidProtocoloProcedimiento;
    private String xidProtocolo;
    private JButton JBGrabar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JComboBox<String> JCBTipoPatologiasL;
    private JComboBox<String> JCBTipoResultado;
    private JCheckBox JCEstado;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;

    public JDConfiguracionResultadoPorPatologia(Frame parent, boolean modal, String idProtocoloProcedimiento, String idProtocolo) {
        super(parent, modal);
        this.xconsulta = new ConsultasMySQL();
        this.xlleno = false;
        this.xResultadoPorPtologiaService = (ResultadoPorPtologiaService) Principal.contexto.getBean(ResultadoPorPtologiaService.class);
        this.listadoOrdenes = null;
        initComponents();
        setTitle("PROTOCOLO POR RESULTADOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.xidProtocoloProcedimiento = idProtocoloProcedimiento;
        this.xidProtocolo = idProtocolo;
        System.err.println("idProtocoloProcedimiento " + this.xidProtocoloProcedimiento);
        System.err.println("xidProtocolo " + this.xidProtocolo);
        mCargarCombo();
        crearTabla();
        mCargar(this.xidProtocoloProcedimiento);
        setLocationRelativeTo(null);
    }

    private void mCargarCombo() {
        this.xlleno = false;
        this.JCBTipoPatologiasL.removeAllItems();
        String sql = "SELECT\n    `l_patologialaboratorios`.`id`\n    , `l_patologialaboratorios`.`nombre`\nFROM\n    `l_protocoloxprocedimiento`\n    INNER JOIN `l_patologialaboratorios` \n        ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `l_patologialaboratorios`.`idProcedmiento`)\nWHERE (`l_patologialaboratorios`.`estado` =1\n    AND `l_protocoloxprocedimiento`.`Id` =" + this.xidProtocoloProcedimiento + ")\nGROUP BY `l_patologialaboratorios`.`id`\nORDER BY `l_patologialaboratorios`.`nombre` ASC;";
        this.xidTipoPatologia = this.xconsulta.llenarCombo(sql, this.xidTipoPatologia, this.JCBTipoPatologiasL);
        this.JCBTipoPatologiasL.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoPatologiasL.setSelectedIndex(-1);
        this.JCBTipoResultado.removeAllItems();
        this.xidTipoResultado = this.xconsulta.llenarCombo("SELECT\n    l_tiporesultado.`Id`, `l_tiporesultado`.`Nbre`\nFROM\n    `l_protocoloxtiporesultado`\n    INNER JOIN `l_tiporesultado` \n        ON (`l_protocoloxtiporesultado`.`Id_TipoResultado` = `l_tiporesultado`.`Id`)\nWHERE (`l_protocoloxtiporesultado`.`Id_Protocolo` ='" + this.xidProtocolo + "' AND l_protocoloxtiporesultado.`Estado`=0)ORDER BY `Nbre` ASC ", this.xidTipoResultado, this.JCBTipoResultado);
        this.JCBTipoResultado.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoResultado.setSelectedIndex(-1);
        this.xlleno = true;
    }

    private void mGrabar() {
        if (this.JCBTipoPatologiasL.getSelectedIndex() != -1) {
            if (this.JCBTipoResultado.getSelectedIndex() != -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.JTDetalle.getSelectedRow() == -1) {
                        if (!mVerificarDatosDoblesTabla(this.JCBTipoPatologiasL.getSelectedItem().toString(), this.JCBTipoResultado.getSelectedItem().toString())) {
                            ResultadoPorPatologiaDTO registro = ResultadoPorPatologiaDTO.builder().idPatologia(Integer.valueOf(Integer.parseInt(this.xidTipoPatologia[this.JCBTipoPatologiasL.getSelectedIndex()]))).idTipoResultado(Integer.valueOf(Integer.parseInt(this.xidTipoResultado[this.JCBTipoResultado.getSelectedIndex()]))).idProcedimientoxProtocolo(Integer.valueOf(Integer.parseInt(this.xidProtocoloProcedimiento))).estado(Boolean.valueOf(this.JCEstado.isSelected())).usuarioS(Principal.usuarioSistemaDTO.getLogin()).build();
                            this.xResultadoPorPtologiaService.crearIngreso(registro);
                        } else {
                            JOptionPane.showMessageDialog(this, "Ya existe esta configuracion guardada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else {
                        ResultadoPorPatologiaDTO registro2 = ResultadoPorPatologiaDTO.builder().id(Long.valueOf(this.modeloTabla.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString())).idPatologia(Integer.valueOf(Integer.parseInt(this.xidTipoPatologia[this.JCBTipoPatologiasL.getSelectedIndex()]))).idTipoResultado(Integer.valueOf(Integer.parseInt(this.xidTipoResultado[this.JCBTipoResultado.getSelectedIndex()]))).idProcedimientoxProtocolo(Integer.valueOf(Integer.parseInt(this.xidProtocoloProcedimiento))).estado(Boolean.valueOf(this.JCEstado.isSelected())).usuarioS(Principal.usuarioSistemaDTO.getLogin()).build();
                        this.xResultadoPorPtologiaService.crearIngreso(registro2);
                    }
                    mCargar(this.xidProtocoloProcedimiento);
                    System.out.print("entor a grabar ");
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoResultado.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de patologia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoPatologiasL.requestFocus();
    }

    public boolean mVerificarDatosDoblesTabla(String xvalor1, String xvalor2) {
        boolean estado = false;
        System.out.println(this.JTDetalle.getRowCount());
        if (this.JTDetalle.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < this.JTDetalle.getRowCount()) {
                    if (!this.JTDetalle.getValueAt(i, 2).toString().equals(xvalor1) || !this.JTDetalle.getValueAt(i, 3).toString().equals(xvalor2)) {
                        i++;
                    } else {
                        estado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return estado;
    }

    private void mCargar(String idProtocoloProcedimiento) {
        System.err.println("entor a buscar" + idProtocoloProcedimiento);
        this.listadoOrdenes = this.xResultadoPorPtologiaService.listaResltadoPorProtocolo(idProtocoloProcedimiento);
        System.err.println("lista".concat(this.listadoOrdenes.size() + ""));
        mCrearTabla(this.listadoOrdenes);
    }

    private void mCrearTabla(List<IProtocoloPorTipoResultado> listadoList) {
        crearTabla();
        if (listadoList.size() != -1) {
            for (int i = 0; i < listadoList.size(); i++) {
                this.modeloTabla.addRow(this.datos);
                this.modeloTabla.setValueAt(listadoList.get(i).getId(), i, 0);
                this.modeloTabla.setValueAt(listadoList.get(i).getIdProcedimientoxProtocolo(), i, 1);
                this.modeloTabla.setValueAt(listadoList.get(i).getNombrePatologia(), i, 2);
                this.modeloTabla.setValueAt(listadoList.get(i).getNombreTipoResultado(), i, 3);
                this.modeloTabla.setValueAt(listadoList.get(i).getestado(), i, 4);
            }
            this.modeloTabla.setRowCount(listadoList.size());
            this.modeloTabla.fireTableDataChanged();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTabla() {
        this.modeloTabla = new DefaultTableModel(new Object[0], new String[]{"id", "idprotocolo", "Patologia", "Resultado", "Estado"}) { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloTabla);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mNuevo() {
        this.JCBTipoPatologiasL.setSelectedIndex(-1);
        this.JCBTipoResultado.setSelectedIndex(-1);
        mCargar(this.xidProtocoloProcedimiento);
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JBGrabar = new JButton();
        this.JBNuevo = new JButton();
        this.JBSalir = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel3 = new JPanel();
        this.JCBTipoPatologiasL = new JComboBox<>();
        this.JCEstado = new JCheckBox();
        this.JCBTipoResultado = new JComboBox<>();
        setDefaultCloseOperation(2);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.2
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.3
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.4
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 206, -2).addGap(34, 34, 34).addComponent(this.JBGrabar, -1, 246, 32767).addGap(18, 18, 18).addComponent(this.JBSalir, -2, 196, -2).addGap(21, 21, 21)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBNuevo, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2))));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.5
            public void mouseClicked(MouseEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBTipoPatologiasL.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPatologiasL.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Patologia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPatologiasL.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.6
            public void itemStateChanged(ItemEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JCBTipoPatologiasLItemStateChanged(evt);
            }
        });
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setSelected(true);
        this.JCEstado.setText("Estado");
        this.JCEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDConfiguracionResultadoPorPatologia.7
            public void actionPerformed(ActionEvent evt) {
                JDConfiguracionResultadoPorPatologia.this.JCEstadoActionPerformed(evt);
            }
        });
        this.JCBTipoResultado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoPatologiasL, -2, 274, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoResultado, -2, 292, -2).addGap(18, 18, 18).addComponent(this.JCEstado, -2, 69, -2).addGap(37, 37, 37)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoPatologiasL, -1, -1, -2).addComponent(this.JCEstado).addComponent(this.JCBTipoResultado, -1, -1, -2)).addGap(10, 10, 10)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jScrollPane1)).addGap(5, 5, 5)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel3, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoPatologiasL.setSelectedItem(this.modeloTabla.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBTipoResultado.setSelectedItem(this.modeloTabla.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCEstado.setSelected(Boolean.valueOf(this.modeloTabla.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoPatologiasLItemStateChanged(ItemEvent evt) {
    }
}
