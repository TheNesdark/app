package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.AtencionDietaDTO;
import com.genoma.plus.jpa.entities.TipoComidaDTO;
import com.genoma.plus.jpa.entities.TipoDietaDTO;
import com.genoma.plus.jpa.projection.IDetalleAtencionDieta;
import com.genoma.plus.jpa.service.IAtencionDietaDAO;
import com.genoma.plus.jpa.service.ITipoComidaDAO;
import com.genoma.plus.jpa.service.ITipoDietaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAtencionDieta.class */
public class JPAtencionDieta extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private AtencionDietaDTO xAtencionDietaDTO;
    private Integer[] dieta;
    private Integer[] comida;
    private JDObservacionDietaSuspendida xJIFObservacionDietaSuspendida;
    private JComboBox<String> JCBAlmuerzo;
    private JComboBox<String> JCBCena;
    private JComboBox<String> JCBDesayuno;
    private JComboBox<String> JCBDieta;
    private JCheckBox JCKBActivo;
    private JDateChooser JDFecha;
    private JTextArea JTAObservacion;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private final IAtencionDietaDAO xIAtencionDietaDAO = (IAtencionDietaDAO) Principal.contexto.getBean(IAtencionDietaDAO.class);
    private Metodos xmt = new Metodos();
    private final ITipoDietaDAO xITipoDietaDAO = (ITipoDietaDAO) Principal.contexto.getBean(ITipoDietaDAO.class);
    private final ITipoComidaDAO xITipoComidaDAO = (ITipoComidaDAO) Principal.contexto.getBean(ITipoComidaDAO.class);

    public JPAtencionDieta(clasesHistoriaCE ce) {
        initComponents();
        mNuevo();
    }

    private void mCargarCombo() {
        List<TipoDietaDTO> listDieta = this.xITipoDietaDAO.consultarTipoDieta();
        this.JCBDieta.removeAllItems();
        this.dieta = new Integer[listDieta.size()];
        for (int i = 0; i < listDieta.size(); i++) {
            this.JCBDieta.addItem(listDieta.get(i).getNombre());
            this.dieta[i] = Integer.valueOf(Integer.parseInt(listDieta.get(i).getId().toString()));
        }
        List<TipoComidaDTO> listComida = this.xITipoComidaDAO.consultarTipoComida();
        this.JCBDesayuno.removeAllItems();
        this.JCBAlmuerzo.removeAllItems();
        this.JCBCena.removeAllItems();
        this.comida = new Integer[listComida.size()];
        for (int i2 = 0; i2 < listComida.size(); i2++) {
            this.JCBDesayuno.addItem(listComida.get(i2).getNombre());
            this.JCBAlmuerzo.addItem(listComida.get(i2).getNombre());
            this.JCBCena.addItem(listComida.get(i2).getNombre());
            this.comida[i2] = Integer.valueOf(Integer.parseInt(listComida.get(i2).getId().toString()));
        }
        this.JCBDieta.setSelectedIndex(-1);
    }

    public void mNuevo() {
        this.JDFecha.setDate(this.xmt.getFechaActual());
        mCargarCombo();
        this.JTAObservacion.setText("");
        this.JCKBActivo.setSelected(true);
        mCargarDatoTabla();
    }

    public void mGrabar() {
        if (this.JCBDieta.getSelectedIndex() != -1) {
            if (this.JCBDesayuno.getSelectedIndex() != -1) {
                if (this.JCBAlmuerzo.getSelectedIndex() != -1) {
                    if (this.JCBCena.getSelectedIndex() != -1) {
                        if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion().isEmpty()) {
                            this.xAtencionDietaDTO = new AtencionDietaDTO();
                            this.xAtencionDietaDTO.setIdAtencion(Long.valueOf(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
                            this.xAtencionDietaDTO.setFechaInicio(this.JDFecha.getDate());
                            this.xAtencionDietaDTO.setIdTipoDieta(this.dieta[this.JCBDieta.getSelectedIndex()]);
                            this.xAtencionDietaDTO.setIdTipoComidaDesayuno(this.comida[this.JCBDesayuno.getSelectedIndex()]);
                            this.xAtencionDietaDTO.setIdTipoComidaAlmuerzo(this.comida[this.JCBAlmuerzo.getSelectedIndex()]);
                            this.xAtencionDietaDTO.setIdTipoComidaCena(this.comida[this.JCBCena.getSelectedIndex()]);
                            this.xAtencionDietaDTO.setObservacion(this.JTAObservacion.getText());
                            this.xAtencionDietaDTO.setActivo(Boolean.valueOf(this.JCKBActivo.isSelected()));
                            this.xAtencionDietaDTO.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                            this.xAtencionDietaDTO.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                            this.xAtencionDietaDTO.setEstado(Boolean.TRUE);
                            Boolean guardar = true;
                            int i = 0;
                            while (true) {
                                if (i >= this.JTDetalle.getRowCount()) {
                                    break;
                                }
                                if (!Boolean.valueOf(this.xmodelo.getValueAt(i, 6).toString()).booleanValue()) {
                                    i++;
                                } else {
                                    JOptionPane.showMessageDialog(this, "Debe suspender la dieta que está activa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    guardar = false;
                                    break;
                                }
                            }
                            if (guardar.booleanValue()) {
                                this.xIAtencionDietaDAO.grabar(this.xAtencionDietaDTO);
                            }
                            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                            mNuevo();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe seleccionar una atencion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar la cena", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBCena.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar el almuerzo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBAlmuerzo.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el desayuno", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBDesayuno.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar la dieta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBDieta.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "TipoDieta", "Desayuno", "Almuerzo", "Cena", "Observacion", "Activo", "ObservacionSuspencion", "Estado", "FechaInicio"}) { // from class: com.genoma.plus.controller.historia.JPAtencionDieta.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(350);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatoTabla() {
        List<IDetalleAtencionDieta> lis = this.xIAtencionDietaDAO.consultarHDieta(Long.valueOf(Long.parseLong(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())));
        mCrearModeloDatos();
        for (int i = 0; i < lis.size(); i++) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(lis.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(lis.get(i).getTipoDieta(), i, 1);
            this.xmodelo.setValueAt(lis.get(i).getDesayuno(), i, 2);
            this.xmodelo.setValueAt(lis.get(i).getAlmuerzo(), i, 3);
            this.xmodelo.setValueAt(lis.get(i).getCena(), i, 4);
            this.xmodelo.setValueAt(lis.get(i).getObservacion(), i, 5);
            this.xmodelo.setValueAt(lis.get(i).getActivo(), i, 6);
            this.xmodelo.setValueAt(lis.get(i).getObservacionSuspencion(), i, 7);
            this.xmodelo.setValueAt(lis.get(i).getEstado(), i, 8);
            this.xmodelo.setValueAt(this.xmt.formatoDMA.format(lis.get(i).getFechaInicio()), i, 9);
        }
        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBDieta = new JComboBox<>();
        this.JCBDesayuno = new JComboBox<>();
        this.JCBAlmuerzo = new JComboBox<>();
        this.JCBCena = new JComboBox<>();
        this.JCKBActivo = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DIETA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpAtencionDieta");
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAtencionDieta.2
            public void mouseClicked(MouseEvent evt) {
                JPAtencionDieta.this.jScrollPane1MouseClicked(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAtencionDieta.3
            public void mouseClicked(MouseEvent evt) {
                JPAtencionDieta.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBDieta.setFont(new Font("Arial", 1, 12));
        this.JCBDieta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo dieta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDesayuno.setFont(new Font("Arial", 1, 12));
        this.JCBDesayuno.setBorder(BorderFactory.createTitledBorder((Border) null, "Desayuno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAlmuerzo.setFont(new Font("Arial", 1, 12));
        this.JCBAlmuerzo.setBorder(BorderFactory.createTitledBorder((Border) null, "Almuerzo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCena.setFont(new Font("Arial", 1, 12));
        this.JCBCena.setBorder(BorderFactory.createTitledBorder((Border) null, "Cena", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCKBActivo.setFont(new Font("Arial", 1, 12));
        this.JCKBActivo.setSelected(true);
        this.JCKBActivo.setText("Activo");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(25, 25, 25).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBDesayuno, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBAlmuerzo, -2, 253, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCena, -2, 253, -2).addContainerGap(110, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 129, -2).addGap(18, 18, 18).addComponent(this.JCBDieta, -2, 323, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCKBActivo).addGap(47, 47, 47)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFecha, -1, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDieta, -2, 53, -2).addComponent(this.JCKBActivo))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDesayuno, -2, 53, -2).addComponent(this.JCBAlmuerzo, -2, 53, -2).addComponent(this.JCBCena, -2, 53, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("Comida", this.jPanel2);
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder(""));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 558, -2).addContainerGap(348, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 111, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("Observación", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 372, 32767).addContainerGap(-1, 32767)));
        getAccessibleContext().setAccessibleName("jpAtencionDieta");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jScrollPane1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.isColumnSelected(6) && Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue()) {
            this.xJIFObservacionDietaSuspendida = new JDObservacionDietaSuspendida(null, true, Long.valueOf(Long.parseLong(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString())));
            this.xJIFObservacionDietaSuspendida.setVisible(true);
            mNuevo();
            return;
        }
        if (evt.getClickCount() == 2) {
        }
    }
}
