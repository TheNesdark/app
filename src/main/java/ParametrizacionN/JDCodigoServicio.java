package ParametrizacionN;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GCodigoServicio;
import com.genoma.plus.jpa.entities.GProcedimientoCodigoServicio;
import com.genoma.plus.jpa.projection.IGProcedimientoCodigoServicioProjection;
import com.genoma.plus.jpa.service.IGCodigoServicioService;
import com.genoma.plus.jpa.service.IGProcedimientoCodigoServicioService;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDCodigoServicio.class */
public class JDCodigoServicio extends JDialog {
    private final IGProcedimientoCodigoServicioService iGProcedimientoCodigoServicioService;
    private final IGCodigoServicioService gCodigoServicioService;
    private GProcedimientoCodigoServicio gProcedimientoCodigoServicio;
    private IGProcedimientoCodigoServicioProjection iGProcedimientoCodigoServicioProjection;
    private List<GProcedimientoCodigoServicio> listGprocedimientoCodigoServicio;
    private List<GCodigoServicio> listCodigoServicio;
    private List<IGProcedimientoCodigoServicioProjection> listProcedimientoServicioProjection;
    private Metodos metodos;
    private DefaultTableModel modelo;
    private Object[] dato;
    private int idGProcedimiento;
    private int id;
    private JButton JBTNActualizar;
    private JComboBox<String> JCBCodigoServicio;
    private JCheckBox JCHEstado;
    private JTable JTBHistorico;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDCodigoServicio(Frame parent, boolean modal, int idProcedimiento) {
        super(parent, modal);
        this.idGProcedimiento = 0;
        initComponents();
        this.idGProcedimiento = idProcedimiento;
        this.metodos = new Metodos();
        this.iGProcedimientoCodigoServicioService = (IGProcedimientoCodigoServicioService) Principal.contexto.getBean(IGProcedimientoCodigoServicioService.class);
        this.gCodigoServicioService = (IGCodigoServicioService) Principal.contexto.getBean(IGCodigoServicioService.class);
        mNew();
        loadComboServicio();
    }

    public void mNew() {
        this.JCBCodigoServicio.setSelectedIndex(-1);
        this.JCHEstado.setSelected(false);
        loadDataTable();
        Principal.mLimpiarDatosP();
    }

    public void mSave() {
        if (this.JCBCodigoServicio.getSelectedIndex() != -1) {
            this.gProcedimientoCodigoServicio = new GProcedimientoCodigoServicio();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.gProcedimientoCodigoServicio.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                this.gProcedimientoCodigoServicio.setUsuarioSistemaActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
                this.gProcedimientoCodigoServicio.setFechaActualizacion(this.metodos.getFechaActual());
            } else {
                this.gProcedimientoCodigoServicio.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
                this.gProcedimientoCodigoServicio.setFecha(this.metodos.getFechaActual());
            }
            this.gProcedimientoCodigoServicio.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
            this.gProcedimientoCodigoServicio.setFecha(this.metodos.getFechaActual());
            this.gProcedimientoCodigoServicio.setIdgGcodservicio(this.listCodigoServicio.get(this.JCBCodigoServicio.getSelectedIndex()));
            this.gProcedimientoCodigoServicio.setIdGprocedimiento(Integer.valueOf(this.idGProcedimiento));
            this.gProcedimientoCodigoServicio.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.iGProcedimientoCodigoServicioService.grabar(this.gProcedimientoCodigoServicio);
        }
        mNew();
    }

    public void loadComboServicio() {
        this.listCodigoServicio = new ArrayList();
        this.JCBCodigoServicio.removeAllItems();
        this.JCBCodigoServicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.listCodigoServicio = this.gCodigoServicioService.getListFilterEstadoOrderByIdAsc(true);
        this.listCodigoServicio.forEach(e -> {
            this.JCBCodigoServicio.addItem(e.getNombre());
        });
    }

    public void createModelTable() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"id", "Procedimiento", "Codigo", "Nombre", "UsuarioSistema", "Estado", "Fecha"}) { // from class: ParametrizacionN.JDCodigoServicio.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.modelo);
        this.JTBHistorico.setAutoResizeMode(0);
        this.JTBHistorico.doLayout();
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(75);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(75);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(75);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(150);
    }

    public void loadDataTable() {
        System.out.println("Entro auqi" + this.idGProcedimiento);
        createModelTable();
        this.listProcedimientoServicioProjection = this.iGProcedimientoCodigoServicioService.getListFilterEstadoOrderByidProcedimiento(Integer.valueOf(this.idGProcedimiento));
        this.listProcedimientoServicioProjection.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.JTBHistorico.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getProcedimiento(), this.JTBHistorico.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getCodigo(), this.JTBHistorico.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getNombre(), this.JTBHistorico.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getUsuarioSistema(), this.JTBHistorico.getRowCount() - 1, 4);
            this.modelo.setValueAt(e.getEstado(), this.JTBHistorico.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getFecha(), this.JTBHistorico.getRowCount() - 1, 6);
        });
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBCodigoServicio = new JComboBox<>();
        this.JCHEstado = new JCheckBox();
        this.JBTNActualizar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTBHistorico = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Liberation Sans", 0, 13), new Color(0, 105, 0)));
        this.JCBCodigoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo de Servicio", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JCBCodigoServicio.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCodigoServicio.2
            public void actionPerformed(ActionEvent evt) {
                JDCodigoServicio.this.JCBCodigoServicioActionPerformed(evt);
            }
        });
        this.JCHEstado.setText("Estado");
        this.JBTNActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBTNActualizar.setText("GRABAR");
        this.JBTNActualizar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDCodigoServicio.3
            public void actionPerformed(ActionEvent evt) {
                JDCodigoServicio.this.JBTNActualizarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCBCodigoServicio, -2, 338, -2).addGap(31, 31, 31).addComponent(this.JCHEstado).addGap(26, 26, 26).addComponent(this.JBTNActualizar, -2, 225, -2).addContainerGap(50, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTNActualizar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCodigoServicio, -2, 50, -2).addComponent(this.JCHEstado))).addContainerGap(19, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Liberation Sans", 0, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Liberation Sans", 1, 14));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDCodigoServicio.4
            public void mouseClicked(MouseEvent evt) {
                JDCodigoServicio.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTBHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 297, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNActualizarActionPerformed(ActionEvent evt) {
        mSave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.iGProcedimientoCodigoServicioProjection = this.listProcedimientoServicioProjection.get(this.JTBHistorico.getSelectedRow());
            this.JCHEstado.setSelected(this.listProcedimientoServicioProjection.get(this.JTBHistorico.getSelectedRow()).getEstado().booleanValue());
            this.JCBCodigoServicio.setSelectedItem(this.modelo.getValueAt(this.JTBHistorico.getSelectedRow(), 3).toString());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString());
            this.id = Integer.parseInt(Principal.txtNo.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCodigoServicioActionPerformed(ActionEvent evt) {
    }
}
