package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.H_GrupoSistemasDAO;
import com.genoma.plus.dao.general.H_TipoSistemasDAO;
import com.genoma.plus.dao.impl.general.H_GrupoSistemasDAOImpl;
import com.genoma.plus.dao.impl.general.H_TipoSistemasDAOImpl;
import com.genoma.plus.dto.general.H_GrupoSistemasDTO;
import com.genoma.plus.dto.general.H_TipoSistemasDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFH_TipoSistemas.class */
public class JIFH_TipoSistemas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private H_TipoSistemasDAO xH_TipoSistemasDAO;
    private int[] xidGrupo;
    private H_GrupoSistemasDAO xH_GruposistemasDAO;
    private JCheckBox JCBEstado;
    private JComboBox JCBGrupo;
    private JSpinner JSOrden;
    private JTextArea JTAVDefecto;
    private JTextField JTFNombre;
    private JTable JTTiposSistemas;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JIFH_TipoSistemas() {
        initComponents();
        springStart();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSOrden = new JSpinner();
        this.JCBEstado = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTAVDefecto = new JTextArea();
        this.JCBGrupo = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTTiposSistemas = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO SISTEMAS ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFH_TipoSistemas");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.general.JIFH_TipoSistemas.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFH_TipoSistemas.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEstado.setFont(new Font("Arial", 1, 12));
        this.JCBEstado.setForeground(Color.blue);
        this.JCBEstado.setText("Estado");
        this.JTAVDefecto.setColumns(20);
        this.JTAVDefecto.setFont(new Font("Arial", 1, 12));
        this.JTAVDefecto.setRows(1);
        this.JTAVDefecto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor por Defecto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAVDefecto.setPreferredSize(new Dimension(236, 50));
        this.jScrollPane2.setViewportView(this.JTAVDefecto);
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 435, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSOrden, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEstado)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 403, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBGrupo, -2, 172, -2))).addGap(0, 20, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 51, -2).addComponent(this.JSOrden, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBGrupo).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jScrollPane2, -2, 50, -2))).addContainerGap()));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTTiposSistemas.setFont(new Font("Arial", 1, 12));
        this.JTTiposSistemas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTTiposSistemas.setSelectionBackground(Color.white);
        this.JTTiposSistemas.setSelectionForeground(Color.red);
        this.JTTiposSistemas.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFH_TipoSistemas.2
            public void mouseClicked(MouseEvent evt) {
                JIFH_TipoSistemas.this.JTTiposSistemasMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTTiposSistemas);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 302, 32767)));
        pack();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xH_TipoSistemasDAO = (H_TipoSistemasDAOImpl) classPathXmlApplicationContext.getBean("TipoSistemasDAO");
        this.xH_GruposistemasDAO = (H_GrupoSistemasDAOImpl) classPathXmlApplicationContext.getBean("GrupoSistemasDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTiposSistemasMouseClicked(MouseEvent evt) {
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 1).toString());
        this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 4).toString()));
        this.JTAVDefecto.setText(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 5).toString());
        this.JCBEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 6).toString()).booleanValue());
        this.JCBGrupo.setSelectedIndex(Integer.parseInt(this.xmodelo.getValueAt(this.JTTiposSistemas.getSelectedRow(), 2).toString()) - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().equals("") && this.JCBGrupo.getSelectedIndex() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                H_TipoSistemasDTO xTipoS = new H_TipoSistemasDTO();
                xTipoS.setIdGrupo(this.xidGrupo[this.JCBGrupo.getSelectedIndex()]);
                xTipoS.setNombre(this.JTFNombre.getText());
                xTipoS.setOrden(((Integer) this.JSOrden.getValue()).intValue());
                xTipoS.setVDefecto(this.JTAVDefecto.getText());
                xTipoS.setEstado(Boolean.valueOf(this.JCBEstado.isSelected()));
                xTipoS.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                xTipoS.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                if (Principal.txtNo.getText().equals("")) {
                    this.xH_TipoSistemasDAO.mCreate(xTipoS);
                } else {
                    xTipoS.setId(Integer.parseInt(Principal.txtNo.getText()));
                    this.xH_TipoSistemasDAO.mUpdate(xTipoS);
                }
                mCargarDatosTabla();
                mNuevo();
            }
        }
    }

    public void mLlenarComboBox() {
        this.JCBGrupo.removeAllItems();
        List<H_GrupoSistemasDTO> listGrupos = this.xH_GruposistemasDAO.listGrupoSistemas();
        this.xidGrupo = new int[listGrupos.size()];
        for (int x = 0; x < listGrupos.size(); x++) {
            this.xidGrupo[x] = listGrupos.get(x).getId();
            this.JCBGrupo.addItem(listGrupos.get(x).getNombre());
        }
        this.JCBGrupo.setSelectedIndex(-1);
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JTAVDefecto.setText("");
        this.JSOrden.setValue(0);
        this.JCBEstado.setSelected(false);
        mLlenarComboBox();
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "idGrupo", "Grupo", "Orden", "Valor Defecto", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFH_TipoSistemas.3
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTTiposSistemas.setModel(this.xmodelo);
        this.JTTiposSistemas.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTTiposSistemas.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTTiposSistemas.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTTiposSistemas.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTTiposSistemas.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTTiposSistemas.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTTiposSistemas.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTTiposSistemas.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTTiposSistemas.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    public void mCargarDatosTabla() {
        List<Object[]> list = this.xH_TipoSistemasDAO.listTipoSistemas();
        mCrearModeloDatos();
        mLlenarComboBox();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 7; j++) {
                this.xmodelo.setValueAt(list.get(x)[j], x, j);
            }
        }
    }
}
