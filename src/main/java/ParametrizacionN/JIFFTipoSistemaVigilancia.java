package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.SoTipoSistemaVigilancia;
import com.genoma.plus.jpa.service.ISoTipoSistemaVigilanciaService;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFTipoSistemaVigilancia.class */
public class JIFFTipoSistemaVigilancia extends JInternalFrame {
    private List<SoTipoSistemaVigilancia> listarTSV;
    private final ISoTipoSistemaVigilanciaService iTipoSistemaVigilanciaService;
    private SoTipoSistemaVigilancia tipoSistemaVigilancia;
    private boolean estado = true;
    private Metodos metodos;
    private DefaultTableModel modelo;
    private Object[] dato;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;

    public JIFFTipoSistemaVigilancia() {
        initComponents();
        this.metodos = new Metodos();
        this.modelo = new DefaultTableModel();
        this.listarTSV = new ArrayList();
        this.iTipoSistemaVigilanciaService = (ISoTipoSistemaVigilanciaService) Principal.contexto.getBean(ISoTipoSistemaVigilanciaService.class);
        this.tipoSistemaVigilancia = new SoTipoSistemaVigilancia();
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Tipo sistema de vigilancia");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifftiposistemavigilancia");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTipoSistemaVigilancia.1
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoSistemaVigilancia.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFTipoSistemaVigilancia.2
            public void actionPerformed(ActionEvent evt) {
                JIFFTipoSistemaVigilancia.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 374, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JTFNombre, -2, -1, -2)).addContainerGap(21, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JSPDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoSistemaVigilancia.3
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoSistemaVigilancia.this.JSPDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFTipoSistemaVigilancia.4
            public void mouseClicked(MouseEvent evt) {
                JIFFTipoSistemaVigilancia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addGap(15, 15, 15)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 309, 32767).addContainerGap()));
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
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).booleanValue());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.tipoSistemaVigilancia = new SoTipoSistemaVigilancia();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.tipoSistemaVigilancia.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
            }
            this.tipoSistemaVigilancia.setNombre(this.JTFNombre.getText());
            this.tipoSistemaVigilancia.setEstado(Boolean.valueOf(this.estado));
            this.tipoSistemaVigilancia.setFecha(this.metodos.getFechaActual());
            this.tipoSistemaVigilancia.setIdUsuarioRh(Integer.valueOf(Integer.parseInt(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString())));
            this.iTipoSistemaVigilanciaService.save(this.tipoSistemaVigilancia);
        } else {
            JOptionPane.showMessageDialog((Component) null, "Ingrese un nombre");
            this.JTFNombre.requestFocus();
        }
        nuevo();
    }

    public void nuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        Principal.mLimpiarDatosP();
        cargarDatosTabla();
    }

    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Nombre", "Estado", "Id"}) { // from class: ParametrizacionN.JIFFTipoSistemaVigilancia.5
            Class[] types = {String.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(380);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listarTSV = this.iTipoSistemaVigilanciaService.getListAllOrderByNombre();
        this.listarTSV.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getNombre(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getEstado(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getId(), this.JTDetalle.getRowCount() - 1, 2);
        });
    }
}
