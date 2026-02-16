package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.DetalleContenidoHCDAO;
import com.genoma.plus.dao.impl.general.DetalleContenidoHCDAOImpl;
import com.genoma.plus.dto.general.DetalleContenidoHCDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFHCDetalleContenidoHc.class */
public class JIFHCDetalleContenidoHc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidcontenido;
    private String[] xidprograma;
    private DetalleContenidoHCDAO xDetalleContenidoHCDAO;
    private JComboBox JCBContenido;
    private JComboBox JCBPrograma;
    private JCheckBox JCHAPrograma;
    private JCheckBox JCHASexo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPEdadI;
    private JSpinner JSPEdadM;
    private JSpinner JSPOrden;
    private JTextArea JTAVPorDefecto;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private int xsexo = 0;
    private int xnidprograma = 0;
    private boolean xlleno = false;

    public JIFHCDetalleContenidoHc() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBContenido = new JComboBox();
        this.JSPOrden = new JSpinner();
        this.JCHAPrograma = new JCheckBox();
        this.JCBPrograma = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JCHASexo = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAVPorDefecto = new JTextArea();
        this.jPanel1 = new JPanel();
        this.JSPEdadI = new JSpinner();
        this.JSPEdadM = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("DETALLE CONTENIDO HC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifdetallecontenidohc");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFHCDetalleContenidoHc.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBContenido.setFont(new Font("Arial", 1, 12));
        this.JCBContenido.setBorder(BorderFactory.createTitledBorder((Border) null, "Contenido", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAPrograma.setFont(new Font("Arial", 1, 12));
        this.JCHAPrograma.setText("Programa?");
        this.JCHAPrograma.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.2
            public void actionPerformed(ActionEvent evt) {
                JIFHCDetalleContenidoHc.this.JCHAProgramaActionPerformed(evt);
            }
        });
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrograma.addItemListener(new ItemListener() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.3
            public void itemStateChanged(ItemEvent evt) {
                JIFHCDetalleContenidoHc.this.JCBProgramaItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.4
            public void actionPerformed(ActionEvent evt) {
                JIFHCDetalleContenidoHc.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHASexo.setFont(new Font("Arial", 1, 12));
        this.JCHASexo.setText("Aplica Sexo?");
        this.JCHASexo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.5
            public void actionPerformed(ActionEvent evt) {
                JIFHCDetalleContenidoHc.this.JCHASexoActionPerformed(evt);
            }
        });
        this.JTAVPorDefecto.setColumns(20);
        this.JTAVPorDefecto.setRows(5);
        this.JTAVPorDefecto.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor POr Defecto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAVPorDefecto);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Edad (DIas)", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel1.setRequestFocusEnabled(false);
        this.JSPEdadI.setFont(new Font("Arial", 1, 12));
        this.JSPEdadI.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadI.setBorder(BorderFactory.createTitledBorder((Border) null, "Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadI.setPreferredSize((Dimension) null);
        this.JSPEdadI.setRequestFocusEnabled(false);
        this.JSPEdadM.setFont(new Font("Arial", 1, 12));
        this.JSPEdadM.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPEdadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEdadM.setPreferredSize((Dimension) null);
        this.JSPEdadM.setRequestFocusEnabled(false);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPEdadI, -2, 140, -2).addGap(41, 41, 41).addComponent(this.JSPEdadM, -2, 130, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPEdadI, -2, 50, -2).addComponent(this.JSPEdadM, -2, 50, -2)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 315, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBContenido, 0, -1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHASexo).addComponent(this.JCHAPrograma)).addGap(18, 18, 18).addComponent(this.JCBPrograma, -2, 358, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 81, -2).addGap(18, 18, 18).addComponent(this.JCHEstado))).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 315, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(33, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCBContenido, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPrograma, -2, -1, -2).addComponent(this.JSPOrden, -2, -1, -2).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCHASexo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAPrograma))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -2, 0, 32767)).addContainerGap(12, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.6
            public void mouseClicked(MouseEvent evt) {
                JIFHCDetalleContenidoHc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 229, -2).addContainerGap()));
        pack();
    }

    private void springStart() {
        this.xDetalleContenidoHCDAO = (DetalleContenidoHCDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("DetalleContenidoHCDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBContenido.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSPOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JCHASexo.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.xsexo = 1;
            } else {
                this.xsexo = 0;
            }
            if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).intValue() != 0) {
                this.JCHAPrograma.setSelected(true);
                this.JCBPrograma.setSelectedItem(this.xconsulta.traerDato("SELECT Nbre FROM g_tipoprograma WHERE (Id_TipoPrograma ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString() + "')"));
                this.xconsulta.cerrarConexionBd();
                this.xnidprograma = Integer.valueOf(this.xidprograma[this.JCBPrograma.getSelectedIndex()]).intValue();
            } else {
                this.JCHAPrograma.setSelected(false);
                this.JCBPrograma.setSelectedIndex(-1);
                this.xnidprograma = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.JTAVPorDefecto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JSPEdadI.setValue(Integer.valueOf(((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7)).intValue()));
            this.JSPEdadM.setValue(Integer.valueOf(((Integer) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8)).intValue()));
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
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAProgramaActionPerformed(ActionEvent evt) {
        if (this.JCHAPrograma.isSelected()) {
            this.JCBPrograma.setEnabled(true);
            this.JCBPrograma.setSelectedIndex(-1);
        } else {
            this.JCBPrograma.setEnabled(false);
            this.JCBPrograma.setSelectedIndex(-1);
            this.xnidprograma = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHASexoActionPerformed(ActionEvent evt) {
        if (this.JCHASexo.isSelected()) {
            this.xsexo = 1;
        } else {
            this.xsexo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProgramaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBPrograma.getSelectedIndex() != -1) {
            this.xnidprograma = Integer.valueOf(this.xidprograma[this.JCBPrograma.getSelectedIndex()]).intValue();
        } else {
            this.xnidprograma = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JTFNombre.setText("");
        this.JCBContenido.removeAllItems();
        this.xidcontenido = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_chistoria WHERE (Nivel in(1,10) AND Estado =1) ORDER BY Nbre ASC", this.xidcontenido, this.JCBContenido);
        this.JCBContenido.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCBPrograma.removeAllItems();
        this.xidprograma = this.xconsulta.llenarCombo("SELECT Id_TipoPrograma, Nbre FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xnidprograma = 0;
        this.JCBPrograma.setEnabled(false);
        this.xsexo = 0;
        this.JCHASexo.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xlleno = true;
        mCargarDatosTabla();
        this.JTAVPorDefecto.setText("");
        this.JSPEdadI.setValue(0);
        this.JSPEdadM.setValue(0);
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBContenido.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                DetalleContenidoHCDTO xDcontenido = new DetalleContenidoHCDTO();
                xDcontenido.setNombre(this.JTFNombre.getText());
                xDcontenido.setIdCHistoria(Integer.parseInt(this.xidcontenido[this.JCBContenido.getSelectedIndex()]));
                xDcontenido.setOrden(((Integer) this.JSPOrden.getValue()).intValue());
                xDcontenido.setSexo(this.xsexo);
                xDcontenido.setPrograma(this.xnidprograma);
                xDcontenido.setVPorDefecto(this.JTAVPorDefecto.getText());
                xDcontenido.setEdadI(((Integer) this.JSPEdadI.getValue()).intValue());
                xDcontenido.setEdadF(((Integer) this.JSPEdadM.getValue()).intValue());
                xDcontenido.setEstado(this.JCHEstado.isSelected());
                xDcontenido.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xDetalleContenidoHCDAO.mCreate(xDcontenido);
                    } else {
                        xDcontenido.setId(Integer.parseInt(Principal.txtNo.getText()));
                        this.xDetalleContenidoHCDAO.mUpdate(xDcontenido);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un contenido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBContenido.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFHCDetalleContenidoHc.7
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class, String.class, Integer.class, Integer.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(25);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        List<Object[]> listadoDetalleContenido = this.xDetalleContenidoHCDAO.listadoDetalleCHC();
        String[] xencabezado = {"Id", "Nombre", "Contenido", "N° Orden", "Sexo?", "IdPrograma", "VPor Defecto", "Edad Inicio", "Edad fin", "Estado"};
        mCrearModeloDatos(xencabezado);
        for (int x = 0; x < listadoDetalleContenido.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 10; j++) {
                this.xmodelo.setValueAt(listadoDetalleContenido.get(x)[j], x, j);
            }
        }
    }
}
