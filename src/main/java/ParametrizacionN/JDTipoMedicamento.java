package ParametrizacionN;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ISuministroTipoMedicamento;
import com.genoma.plus.jpa.entities.ITipoMedicamento;
import com.genoma.plus.jpa.projection.ISuministroTipoMedicamentoProjection;
import com.genoma.plus.jpa.service.ISuministroTipoMedicamentoService;
import com.genoma.plus.jpa.service.ITipoMedicamentoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDTipoMedicamento.class */
public class JDTipoMedicamento extends JDialog {
    private ISuministroTipoMedicamento iSuministroTipoMedicamento;
    private final ITipoMedicamentoService iTipoMedicamentoService;
    private final ISuministroTipoMedicamentoService iSuministroTipoMedicamentoService;
    private List<ITipoMedicamento> listTipoMedicamento;
    private List<ISuministroTipoMedicamento> listSuministroTipoMedicamento;
    private List<ISuministroTipoMedicamentoProjection> listISuministroTipoMedicamentoProjection;
    private ISuministroTipoMedicamentoProjection iSuministroTipoMedicamentoProject;
    private Metodos metodo;
    private DefaultTableModel modelo;
    private Object[] dato;
    private int idSuministro;
    private int id;
    private JButton JBTNActualizar;
    private JComboBox<String> JCBTipoMedicamento;
    private JCheckBox JCHEstado;
    private JTable JTBDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDTipoMedicamento(Frame parent, boolean modal, int idSuministro) {
        super(parent, modal);
        this.idSuministro = 0;
        initComponents();
        this.metodo = new Metodos();
        this.iSuministroTipoMedicamentoService = (ISuministroTipoMedicamentoService) Principal.contexto.getBean(ISuministroTipoMedicamentoService.class);
        this.iTipoMedicamentoService = (ITipoMedicamentoService) Principal.contexto.getBean(ITipoMedicamentoService.class);
        this.idSuministro = idSuministro;
        this.JCHEstado.setSelected(true);
        loadCombo();
        mNew();
    }

    public void save() {
        if (this.JCBTipoMedicamento.getSelectedIndex() != -1) {
            this.iSuministroTipoMedicamento = new ISuministroTipoMedicamento();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.iSuministroTipoMedicamento.setId(Principal.txtNo.getText());
                this.iSuministroTipoMedicamento.setUsuarioSistemaActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
                this.iSuministroTipoMedicamento.setFechaActualizacion(this.metodo.getFechaActual());
            } else {
                this.iSuministroTipoMedicamento.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
                this.iSuministroTipoMedicamento.setFecha(this.metodo.getFechaActual());
            }
            this.iSuministroTipoMedicamento.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
            this.iSuministroTipoMedicamento.setFecha(this.metodo.getFechaActual());
            this.iSuministroTipoMedicamento.setIdSuministro(Integer.valueOf(this.idSuministro));
            this.iSuministroTipoMedicamento.setIdTipoMedicamento(this.listTipoMedicamento.get(this.JCBTipoMedicamento.getSelectedIndex()));
            this.iSuministroTipoMedicamento.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            System.out.println("entro aqui");
            this.iSuministroTipoMedicamentoService.grabar(this.iSuministroTipoMedicamento);
        }
        mNew();
    }

    public void mNew() {
        this.JCBTipoMedicamento.setSelectedIndex(-1);
        this.JCHEstado.setSelected(false);
        loadDataTable();
        Principal.mLimpiarDatosP();
    }

    public void loadCombo() {
        this.listTipoMedicamento = new ArrayList();
        this.JCBTipoMedicamento.removeAllItems();
        this.JCBTipoMedicamento.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.listTipoMedicamento = this.iTipoMedicamentoService.getListFilterEstadoOrderByIdAsc(true);
        this.listTipoMedicamento.forEach(e -> {
            this.JCBTipoMedicamento.addItem(e.getNombre());
        });
    }

    public void createModelTable() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"id", "Suministro", "Codigo", "Nombre", "UsuarioSistema", "Estado", "Fecha"}) { // from class: ParametrizacionN.JDTipoMedicamento.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.modelo);
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(75);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(75);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(75);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    public void loadDataTable() {
        createModelTable();
        this.listISuministroTipoMedicamentoProjection = this.iSuministroTipoMedicamentoService.getListFilterEstadoOrderByidSuministro(Integer.valueOf(this.idSuministro));
        this.listISuministroTipoMedicamentoProjection.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.JTBDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getSuministro(), this.JTBDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getCodigo(), this.JTBDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getNombre(), this.JTBDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getUsuarioSistema(), this.JTBDetalle.getRowCount() - 1, 4);
            this.modelo.setValueAt(e.getEstado(), this.JTBDetalle.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getFecha(), this.JTBDetalle.getRowCount() - 1, 6);
        });
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTipoMedicamento = new JComboBox<>();
        this.JCHEstado = new JCheckBox();
        this.JBTNActualizar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTBDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Liberation Sans", 0, 13), new Color(0, 105, 0)));
        this.JCBTipoMedicamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Medicamento", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JCHEstado.setText("Estado");
        this.JBTNActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBTNActualizar.setText("GRABAR");
        this.JBTNActualizar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDTipoMedicamento.2
            public void actionPerformed(ActionEvent evt) {
                JDTipoMedicamento.this.JBTNActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCBTipoMedicamento, -2, 338, -2).addGap(31, 31, 31).addComponent(this.JCHEstado).addGap(26, 26, 26).addComponent(this.JBTNActualizar, -2, 225, -2).addContainerGap(50, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTNActualizar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoMedicamento, -2, 50, -2).addComponent(this.JCHEstado))).addContainerGap(19, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Liberation Sans", 0, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Liberation Sans", 1, 14));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDTipoMedicamento.3
            public void mouseClicked(MouseEvent evt) {
                JDTipoMedicamento.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 297, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.iSuministroTipoMedicamentoProject = this.listISuministroTipoMedicamentoProjection.get(this.JTBDetalle.getSelectedRow());
            this.JCHEstado.setSelected(this.listISuministroTipoMedicamentoProjection.get(this.JTBDetalle.getSelectedRow()).getEstado().booleanValue());
            this.JCBTipoMedicamento.setSelectedItem(this.modelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.id = Integer.parseInt(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNActualizarActionPerformed(ActionEvent evt) {
        save();
    }
}
