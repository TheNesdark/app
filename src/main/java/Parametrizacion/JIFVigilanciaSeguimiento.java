package Parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoVigilanciaDTO;
import com.genoma.plus.jpa.entities.TipoVigilanciaSeguimientoEntity;
import com.genoma.plus.jpa.entities.VigilanciaSeguimientoEntity;
import com.genoma.plus.jpa.projection.IVigilanciaSeguimientoProjections;
import com.genoma.plus.jpa.service.ITipoVigilanciaSeguimientoService;
import com.genoma.plus.jpa.service.ITipoVigilanciaService;
import com.genoma.plus.jpa.service.VigilanciaSeguimientoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Parametrizacion/JIFVigilanciaSeguimiento.class */
public class JIFVigilanciaSeguimiento extends JInternalFrame {
    List<TipoVigilanciaSeguimientoEntity> listSeguimiento;
    List<TipoVigilanciaDTO> listVigilancia;
    private VigilanciaSeguimientoEntity vigilanciaSeguimientoEntity;
    private DefaultTableModel xmodelo;
    private List<IVigilanciaSeguimientoProjections> listVigilanciaSeguimiento;
    private Object[] xdatos;
    private JComboBox<String> JCBTipoSeguimiento;
    private JComboBox<String> JCBTipoVigilancia;
    private JCheckBox JCHEstado;
    private JLabel JLBEstado;
    private JLabel JLBId;
    private JScrollPane JSPDetalle;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JScrollPane jScrollPane1;
    private final ITipoVigilanciaSeguimientoService tipoSeguimiento = (ITipoVigilanciaSeguimientoService) Principal.contexto.getBean(ITipoVigilanciaSeguimientoService.class);
    private final ITipoVigilanciaService tipoVigilancia = (ITipoVigilanciaService) Principal.contexto.getBean(ITipoVigilanciaService.class);
    private final VigilanciaSeguimientoService vigilanciaSeguimientoService = (VigilanciaSeguimientoService) Principal.contexto.getBean(VigilanciaSeguimientoService.class);
    private Metodos metodos = new Metodos();

    public JIFVigilanciaSeguimiento() {
        initComponents();
        mNuevo();
        this.JCBTipoSeguimiento.setSelectedIndex(-1);
        this.JCBTipoVigilancia.setSelectedIndex(-1);
    }

    public void mNuevo() {
        this.JCBTipoSeguimiento.setSelectedIndex(-1);
        this.JCBTipoVigilancia.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JLBEstado.setText("");
        this.JLBId.setText("");
        this.listSeguimiento = new ArrayList();
        this.listSeguimiento = this.tipoSeguimiento.listaSeguimiento();
        if (!this.listSeguimiento.isEmpty()) {
            this.listSeguimiento.forEach(item -> {
                this.JCBTipoSeguimiento.addItem(item.getNbre());
            });
        }
        this.listVigilancia = new ArrayList();
        this.listVigilancia = this.tipoVigilancia.listaTipoVigilancia();
        if (!this.listVigilancia.isEmpty()) {
            this.listVigilancia.forEach(item2 -> {
                this.JCBTipoVigilancia.addItem(item2.getNombre());
            });
        }
        this.JTAObservacion.setText("");
        mCargarDatosTabla();
        this.vigilanciaSeguimientoEntity = new VigilanciaSeguimientoEntity();
    }

    public void mResgistro() {
        TipoVigilanciaDTO tipoVigilanciaDTO = new TipoVigilanciaDTO();
        tipoVigilanciaDTO.setId(this.listVigilancia.get(this.JCBTipoVigilancia.getSelectedIndex()).getId());
        TipoVigilanciaSeguimientoEntity seguimientoEntity = new TipoVigilanciaSeguimientoEntity();
        seguimientoEntity.setId(this.listSeguimiento.get(this.JCBTipoSeguimiento.getSelectedIndex()).getId());
        this.vigilanciaSeguimientoEntity.setIdTVigilancia(tipoVigilanciaDTO);
        this.vigilanciaSeguimientoEntity.setIdTVSeguimiento(seguimientoEntity);
        this.vigilanciaSeguimientoEntity.setObservacion(this.JTAObservacion.getText());
        this.vigilanciaSeguimientoEntity.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
        this.vigilanciaSeguimientoEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.vigilanciaSeguimientoEntity = this.vigilanciaSeguimientoService.grabar(this.vigilanciaSeguimientoEntity);
    }

    public void mGrabar() {
        if (this.vigilanciaSeguimientoEntity == null) {
            this.vigilanciaSeguimientoEntity = new VigilanciaSeguimientoEntity();
        }
        if (this.JCBTipoSeguimiento.getSelectedIndex() != -1 && this.JCBTipoVigilancia.getSelectedIndex() != -1) {
            if (this.JLBId.getText().isEmpty()) {
                mResgistro();
                this.JLBEstado.setText("ACTIVO");
                this.JLBId.setText(this.vigilanciaSeguimientoEntity.getId().toString());
                JOptionPane.showInternalMessageDialog(this, "          Registro Exitoso!", "SUCCES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Ok.png"))));
                mCargarDatosTabla();
                return;
            }
            this.vigilanciaSeguimientoEntity.setId(Integer.valueOf(this.JLBId.getText()));
            mResgistro();
            JOptionPane.showInternalMessageDialog(this, "         Registro Actualizado!", "SUCCES", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Ok.png"))));
            mCargarDatosTabla();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Los campos tipo vigilancia y tipo seguimiento son obligatorios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Vigilancia", "Tipo Seguimiento", "Observacion", "Fecha", "UsuarioSistema", "Estado", "idv", "ids"}) { // from class: Parametrizacion.JIFVigilanciaSeguimiento.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listVigilanciaSeguimiento = this.vigilanciaSeguimientoService.listarVigilanciaSeguimiento();
        if (!this.listVigilanciaSeguimiento.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 1);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 2);
            for (int i = 0; i < this.listVigilanciaSeguimiento.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getTipoVigilancia(), i, 1);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getTipoSeguimiento(), i, 2);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getObservacion(), i, 3);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getFecha(), i, 4);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getUsuarioS(), i, 5);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getEstado(), i, 6);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getIdVigilancia(), i, 7);
                this.xmodelo.setValueAt(this.listVigilanciaSeguimiento.get(i).getIdVigilancia(), i, 8);
            }
        }
    }

    public void estado() {
        if (this.JCHEstado.isSelected()) {
            this.JLBEstado.setText("ACTIVO");
        } else {
            this.JLBEstado.setText("INACTIVO");
        }
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JCBTipoVigilancia = new JComboBox<>();
        this.JCBTipoSeguimiento = new JComboBox<>();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JLBEstado = new JLabel();
        this.JLBId = new JLabel();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("VIGILANCIA SEGUIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifVigilancia");
        this.JCBTipoVigilancia.setFont(new Font("Arial", 1, 12));
        this.JCBTipoVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Vigilancia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Seguimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Parametrizacion.JIFVigilanciaSeguimiento.2
            public void mouseClicked(MouseEvent evt) {
                JIFVigilanciaSeguimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(new Color(255, 0, 0));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBId.setBackground(new Color(255, 255, 255));
        this.JLBId.setFont(new Font("Arial", 1, 18));
        this.JLBId.setForeground(new Color(255, 0, 0));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Parametrizacion.JIFVigilanciaSeguimiento.3
            public void actionPerformed(ActionEvent evt) {
                JIFVigilanciaSeguimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, -1, 766, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCBTipoVigilancia, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addComponent(this.JCBTipoSeguimiento, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBId, -1, -1, 32767).addComponent(this.JLBEstado, -1, 114, 32767)).addGap(8, 8, 8))).addGap(31, 31, 31)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(22, 22, 22).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoVigilancia, -2, 50, -2).addComponent(this.JLBId, -2, 50, -2)).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoSeguimiento, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JLBEstado, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 185, -2).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JLBId.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
            this.JCBTipoVigilancia.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoSeguimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            estado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        estado();
    }
}
