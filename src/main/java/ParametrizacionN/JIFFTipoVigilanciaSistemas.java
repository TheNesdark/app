package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.SoTipoSistemaVigilancia;
import com.genoma.plus.jpa.entities.SoTipoVigilanciaSistemas;
import com.genoma.plus.jpa.entities.TipoVigilanciaDTO;
import com.genoma.plus.jpa.service.ISoTipoSistemaVigilanciaService;
import com.genoma.plus.jpa.service.ISoTipoVigilanciaSistemaService;
import com.genoma.plus.jpa.service.ITipoVigilanciaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTipoVigilanciaSistemas.class */
public class JIFFTipoVigilanciaSistemas extends JInternalFrame {
    private List<SoTipoVigilanciaSistemas> listarTVS;
    private final ISoTipoVigilanciaSistemaService iTipoVigilanciaSistemaService;
    private SoTipoVigilanciaSistemas tipoVigilanciaSistema;
    private List<SoTipoSistemaVigilancia> listarTSV;
    private final ISoTipoSistemaVigilanciaService iTipoSistemaVigilanciaService;
    private SoTipoSistemaVigilancia tipoSistemaVigilancia;
    private List<TipoVigilanciaDTO> listarTipoVigilancia;
    private final ITipoVigilanciaService iTipoVigilanciaService;
    private TipoVigilanciaDTO tipoVigilanciaDTO;
    private boolean estado = true;
    private Metodos metodos;
    private DefaultTableModel modelo;
    private Object[] dato;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JComboBox cboSistema;
    private JComboBox cboVigilancia;

    public JIFFTipoVigilanciaSistemas() {
        initComponents();
        this.metodos = new Metodos();
        this.modelo = new DefaultTableModel();
        this.listarTVS = new ArrayList();
        this.listarTSV = new ArrayList();
        this.listarTipoVigilancia = new ArrayList();
        this.listarTSV = new ArrayList();
        this.iTipoSistemaVigilanciaService = (ISoTipoSistemaVigilanciaService) Principal.contexto.getBean(ISoTipoSistemaVigilanciaService.class);
        this.tipoSistemaVigilancia = new SoTipoSistemaVigilancia();
        this.iTipoVigilanciaSistemaService = (ISoTipoVigilanciaSistemaService) Principal.contexto.getBean(ISoTipoVigilanciaSistemaService.class);
        this.iTipoVigilanciaService = (ITipoVigilanciaService) Principal.contexto.getBean(ITipoVigilanciaService.class);
        this.tipoVigilanciaSistema = new SoTipoVigilanciaSistemas();
        this.tipoVigilanciaDTO = new TipoVigilanciaDTO();
        cargarDatosTabla();
        nuevo();
        cargarComboSistema();
        cargarComboVigilancia();
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.cboSistema = new JComboBox();
        this.cboVigilancia = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Tipo vigilancia sistema");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifftipovigilanciasistema");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.cboSistema.setFont(new Font("Arial", 1, 12));
        this.cboSistema.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Sistema", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboVigilancia.setFont(new Font("Arial", 1, 12));
        this.cboVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Vigilancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTipoVigilanciaSistemas.1
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoVigilanciaSistemas.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.cboSistema, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addComponent(this.cboVigilancia, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(23, 23, 23).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboSistema, -2, 50, -2).addComponent(this.JCHEstado).addComponent(this.cboVigilancia, -2, 50, -2)).addContainerGap(19, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoVigilanciaSistemas.2
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoVigilanciaSistemas.this.JSPDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoVigilanciaSistemas.3
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoVigilanciaSistemas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -1, 275, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("Tipo sistema vigilancia");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.estado = true;
        } else {
            this.estado = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.JCHEstado.setSelected(Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.cboSistema.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.cboVigilancia.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleMouseClicked(MouseEvent evt) {
    }

    public void grabar() {
        if (this.cboSistema.getSelectedIndex() != -1 || this.cboVigilancia.getSelectedIndex() != -1) {
            this.tipoVigilanciaSistema = new SoTipoVigilanciaSistemas();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.tipoVigilanciaSistema.setId(Short.valueOf(Short.parseShort(Principal.txtNo.getText())));
            }
            this.tipoVigilanciaSistema.setIdTipoSistema(this.listarTSV.get(this.cboSistema.getSelectedIndex()));
            this.tipoVigilanciaSistema.setIdTipoVigilancia(this.listarTipoVigilancia.get(this.cboVigilancia.getSelectedIndex()));
            this.tipoVigilanciaSistema.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.tipoVigilanciaSistema.setFecha(this.metodos.getFechaActual());
            this.tipoVigilanciaSistema.setIdUsuarioRh(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString())));
            this.iTipoVigilanciaSistemaService.save(this.tipoVigilanciaSistema);
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese los datos");
        }
        nuevo();
        cargarDatosTabla();
    }

    public void nuevo() {
        this.JCHEstado.setSelected(true);
        this.cboSistema.setSelectedIndex(-1);
        this.cboVigilancia.setSelectedIndex(-1);
        Principal.mLimpiarDatosP();
    }

    private void cargarComboSistema() {
        this.listarTSV = this.iTipoSistemaVigilanciaService.getListAllOrderByNombre();
        System.out.println("sistema lista -> " + this.listarTSV.size());
        this.cboSistema.removeAllItems();
        this.listarTSV.forEach(items -> {
            this.cboSistema.addItem(items.getNombre());
        });
        if (this.listarTSV.size() > 1) {
            this.cboSistema.setSelectedIndex(-1);
        }
    }

    private void cargarComboVigilancia() {
        this.listarTipoVigilancia = this.iTipoVigilanciaService.listaTipoVigilancia();
        this.cboVigilancia.removeAllItems();
        this.listarTipoVigilancia.forEach(items -> {
            this.cboVigilancia.addItem(items.getNombre());
        });
        if (this.listarTipoVigilancia.size() > 1) {
            this.cboVigilancia.setSelectedIndex(-1);
        }
    }

    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Tipo Vigilancia", "Tipo Sistema", "Estado", "Id"}) { // from class: ParametrizacionN.JIFFTipoVigilanciaSistemas.4
            Class[] types = {String.class, String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(310);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(310);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listarTVS = this.iTipoVigilanciaSistemaService.getListAllOrderById();
        this.listarTVS.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getIdTipoVigilancia().getNombre(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getIdTipoSistema().getNombre(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getId(), this.JTDetalle.getRowCount() - 1, 3);
        });
    }
}
