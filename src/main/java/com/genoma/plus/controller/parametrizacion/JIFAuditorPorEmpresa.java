package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.parametrizacion.AuditorPorEmpresaDAOImpl;
import com.genoma.plus.dao.parametrizacion.AuditorPorEmpresaDAO;
import com.genoma.plus.dto.parametrizacion.AuditorPorEmpresaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFAuditorPorEmpresa.class */
public class JIFAuditorPorEmpresa extends JInternalFrame {
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private AuditorPorEmpresaDAO xAuditorPorEmpresaDAO;
    private List<Object[]> lider;
    private JComboBox JCBLider;
    private JCheckBox JCKBEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIFAuditorPorEmpresa() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xAuditorPorEmpresaDAO = (AuditorPorEmpresaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("auditorPorEmpresaDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r3v21, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBLider = new JComboBox();
        this.JCKBEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITOR POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifAuditorPorEmpresa");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBLider.setFont(new Font("Arial", 1, 13));
        this.JCBLider.setBorder(BorderFactory.createTitledBorder((Border) null, "Lider", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCKBEstado.setFont(new Font("Arial", 1, 12));
        this.JCKBEstado.setSelected(true);
        this.JCKBEstado.setText("Estado");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBLider, -2, 408, -2).addGap(18, 18, 18).addComponent(this.JCKBEstado).addContainerGap(197, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBLider, -2, -1, -2).addComponent(this.JCKBEstado)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFAuditorPorEmpresa.1
            public void mouseClicked(MouseEvent evt) {
                JIFAuditorPorEmpresa.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 748, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 229, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            for (int i = 0; i < this.lider.size(); i++) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString().equals(this.lider.get(i)[1])) {
                    this.JCBLider.setSelectedIndex(i);
                    this.JCKBEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
                    return;
                }
            }
        }
    }

    public void mCargarCombo() {
        this.lider = this.xAuditorPorEmpresaDAO.mCargarCombo();
        this.JCBLider.removeAllItems();
        for (int i = 0; i < this.lider.size(); i++) {
            this.JCBLider.addItem(this.lider.get(i)[1]);
        }
        this.JCBLider.setSelectedIndex(-1);
        this.JCBLider.requestFocus();
    }

    public void mNuevo() {
        mCargarCombo();
        mCargarDatosTabla();
        this.JCKBEstado.setSelected(true);
    }

    public void mGrabar() {
        String estado;
        if (this.JCBLider.getSelectedIndex() != -1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                if (this.JCKBEstado.isSelected()) {
                    estado = "1";
                } else {
                    estado = "0";
                }
                AuditorPorEmpresaDTO validaDTO = new AuditorPorEmpresaDTO();
                validaDTO.setIdEmpresa(Principal.txtNo.getText());
                validaDTO.setIdPersonaCargoRh(this.lider.get(this.JCBLider.getSelectedIndex())[0].toString());
                String validar = this.xAuditorPorEmpresaDAO.mValidarExiste(validaDTO);
                if (validar.isEmpty()) {
                    AuditorPorEmpresaDTO insertDTO = new AuditorPorEmpresaDTO();
                    insertDTO.setIdEmpresa(Principal.txtNo.getText());
                    insertDTO.setIdPersonaCargoRh(this.lider.get(this.JCBLider.getSelectedIndex())[0].toString());
                    insertDTO.setFecha(this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()));
                    insertDTO.setEstado(estado);
                    insertDTO.setIdUsuarioRh(this.lider.get(this.JCBLider.getSelectedIndex())[2].toString());
                    this.xAuditorPorEmpresaDAO.mGrabar(insertDTO);
                } else {
                    AuditorPorEmpresaDTO updateDTO = new AuditorPorEmpresaDTO();
                    updateDTO.setEstado(estado);
                    updateDTO.setId(validar);
                    this.xAuditorPorEmpresaDAO.mUpdate(updateDTO);
                }
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un lider", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Auditor", "Cargo", "fecha", "estado"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFAuditorPorEmpresa.2
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        AuditorPorEmpresaDTO dto = new AuditorPorEmpresaDTO();
        dto.setIdEmpresa(Principal.txtNo.getText());
        List<Object[]> tabla = this.xAuditorPorEmpresaDAO.mCargarTabla(dto);
        mCrearModeloDatos();
        for (int i = 0; i < tabla.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(tabla.get(i)[0], i, 0);
            this.xmodelo.setValueAt(tabla.get(i)[1], i, 1);
            this.xmodelo.setValueAt(tabla.get(i)[2], i, 2);
            this.xmodelo.setValueAt(tabla.get(i)[3], i, 3);
            System.out.println("Dato: " + tabla.get(i)[4].toString() + "\nBoolean.parseBoolean: " + Boolean.parseBoolean(tabla.get(i)[4].toString()) + "\nBoolean.valueOf: " + Boolean.valueOf(tabla.get(i)[4].toString()));
            this.xmodelo.setValueAt(Boolean.valueOf(tabla.get(i)[4].equals("1")), i, 4);
        }
    }
}
