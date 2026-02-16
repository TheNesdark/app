package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.ITipoMedicamento;
import com.genoma.plus.jpa.service.ITipoMedicamentoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFTipoMedicamento.class */
public class JIFTipoMedicamento extends JInternalFrame {
    private ITipoMedicamento iTipoMedicamento;
    private final ITipoMedicamentoService iTipoMedicamentoService;
    private List<ITipoMedicamento> listTipoMedicamento;
    private DefaultTableModel modelo;
    private Object[] datos;
    private Metodos metodo;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JTable JTBHistorico;
    private JTextField JTFCodigo;
    private JTextField JTFTipoMedicamento;
    private JPanel jPanel1;

    public JIFTipoMedicamento() {
        initComponents();
        this.iTipoMedicamentoService = (ITipoMedicamentoService) Principal.contexto.getBean(ITipoMedicamentoService.class);
        loadDataTable();
    }

    public void mNew() {
        this.JTFCodigo.setText("");
        this.JTFTipoMedicamento.setText("");
        this.JCHEstado.setSelected(false);
        loadDataTable();
        Principal.mLimpiarDatosP();
    }

    public void mSave() {
        if (!this.JTFTipoMedicamento.getText().isEmpty() && !this.JTFCodigo.getText().isEmpty()) {
            this.iTipoMedicamento = new ITipoMedicamento();
            if (!Principal.txtNo.getText().isEmpty()) {
                this.iTipoMedicamento = this.listTipoMedicamento.get(this.JTBHistorico.getSelectedRow());
                this.iTipoMedicamento.setUsuarioSistemaActualizacion(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
                this.iTipoMedicamento.setCodigo(this.JTFCodigo.getText());
                this.iTipoMedicamento.setNombre(this.JTFTipoMedicamento.getText());
                this.iTipoMedicamento.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            } else {
                this.iTipoMedicamento.setCodigo(this.JTFCodigo.getText());
                this.iTipoMedicamento.setNombre(this.JTFTipoMedicamento.getText());
                this.iTipoMedicamento.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
                this.iTipoMedicamento.setUsuarioSistema(Principal.usuarioSistemaDTO.getNombreUsuario().toString());
            }
            this.iTipoMedicamentoService.save(this.iTipoMedicamento);
        } else {
            JOptionPane.showMessageDialog((Component) null, "Faltan datos por llenar");
            this.JTFTipoMedicamento.requestFocus();
            this.JTFCodigo.requestFocus();
        }
        mNew();
    }

    public void createModelTable() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Codigo", "Nombre", "Estado", "UsuarioSistema", "Fecha"}) { // from class: ParametrizacionN.JIFTipoMedicamento.1
            Class[] types = {String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(335);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(129);
    }

    public void loadDataTable() {
        createModelTable();
        this.listTipoMedicamento = this.iTipoMedicamentoService.getListAllOrderById();
        this.listTipoMedicamento.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getCodigo(), this.JTBHistorico.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNombre(), this.JTBHistorico.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getEstado(), this.JTBHistorico.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getUsuarioSistema(), this.JTBHistorico.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getFecha(), this.JTBHistorico.getRowCount() - 1, 4);
        });
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFTipoMedicamento = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setTitle("TIPO DE MEDICAMENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jiftipomedicamento");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Liberation Sans", 1, 14), Color.red));
        this.JTBHistorico.setFont(new Font("Liberation Sans", 1, 14));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFTipoMedicamento.2
            public void mouseClicked(MouseEvent evt) {
                JIFTipoMedicamento.this.JTBHistoricoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBHistorico);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Liberation Sans", 1, 14), new Color(0, 105, 0)));
        this.JTFTipoMedicamento.setFont(new Font("Liberation Sans", 1, 12));
        this.JTFTipoMedicamento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Medicamento", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JTFCodigo.setFont(new Font("Liberation Sans", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Liberation Sans", 1, 14), Color.blue));
        this.JCHEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFTipoMedicamento, -2, 435, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JTFCodigo, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(17, 17, 17)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JTFCodigo, -1, 50, 32767)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFTipoMedicamento, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHEstado)))).addContainerGap(21, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.jPanel1, -1, 818, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 326, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.iTipoMedicamento = this.listTipoMedicamento.get(this.JTBHistorico.getSelectedRow());
            this.JTFCodigo.setText(this.listTipoMedicamento.get(this.JTBHistorico.getSelectedRow()).getCodigo());
            this.JTFTipoMedicamento.setText(this.listTipoMedicamento.get(this.JTBHistorico.getSelectedRow()).getNombre());
            this.JCHEstado.setSelected(this.listTipoMedicamento.get(this.JTBHistorico.getSelectedRow()).getEstado().booleanValue());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString());
        }
    }
}
