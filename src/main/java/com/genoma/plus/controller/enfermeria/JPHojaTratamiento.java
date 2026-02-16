package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.dao.enfermeria.HojaTratamientoDAO;
import com.genoma.plus.dao.impl.enfermeria.HojaTratamientoDAOImpl;
import com.genoma.plus.jpa.service.IHOrdenesUnidosisDetalleService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JPHojaTratamiento.class */
public class JPHojaTratamiento extends JPanel {
    private String xsql;
    private String xidatencion;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private HojaTratamientoDAO xHojaTratamientoDAO;
    private String nombreInternoLlamador;
    private final IHOrdenesUnidosisDetalleService detalleService;
    private JButton JBTExportar;
    private JButton JBT_DuplicarTto;
    private JCheckBox JCHFiltro;
    private JScrollPane JSPDHistorico;
    private JTable JTDHistorico;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private boolean lleno = false;

    public JPHojaTratamiento(String idAtencion, String nombreInternoLlamador, String nombreFormulario) {
        this.xidatencion = "0";
        initComponents();
        springStart();
        setName(nombreFormulario);
        this.xidatencion = idAtencion;
        this.nombreInternoLlamador = nombreInternoLlamador;
        this.detalleService = (IHOrdenesUnidosisDetalleService) Principal.contexto.getBean(IHOrdenesUnidosisDetalleService.class);
        mNuevo();
    }

    private void springStart() {
        this.xHojaTratamientoDAO = (HojaTratamientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("hojaTratamientoDAO");
    }

    public void mNuevo() {
        this.lleno = false;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        cargarTabla();
        if (this.nombreInternoLlamador.equals("jifLiqServicios")) {
            this.JBT_DuplicarTto.setVisible(true);
        } else {
            this.JBT_DuplicarTto.setVisible(false);
        }
        this.lleno = true;
    }

    public void mGrabar() {
        System.out.println("medico " + this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 11).toString());
        System.out.println("usuario " + Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        if (this.nombreInternoLlamador.equals("jifLiqServicios")) {
            if (this.JTDHistorico.isEditing()) {
                this.JTDHistorico.getCellEditor().stopCellEditing();
            }
            this.xHojaTratamientoDAO.updateTratamiento(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 3).toString().trim(), Integer.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 4).toString().trim()).intValue(), this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 5).toString().trim(), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 9).toString().trim()), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 10).toString().trim()), this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 0).toString().trim());
        } else if (Objects.equals(Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 11).toString()))) {
            if (this.JTDHistorico.isEditing()) {
                this.JTDHistorico.getCellEditor().stopCellEditing();
            }
            this.xHojaTratamientoDAO.updateTratamiento(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 3).toString().trim(), Integer.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 4).toString().trim()).intValue(), this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 5).toString().trim(), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 9).toString().trim()), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 10).toString().trim()), this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 0).toString().trim());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Solo el usuario que realizo esta aplicacion puede modificar este registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        mNuevo();
    }

    public void mImprimir() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[5][2];
        parametros[0][0] = "idAtencion";
        parametros[0][1] = this.xidatencion;
        parametros[1][0] = "nbreUsuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        parametros[4][0] = "nbreUsuario";
        parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        metodos.GenerarPDF(metodos.getRutaRep() + "Pajonal_Hoja_Tratamiento", parametros);
    }

    public void mAnular() {
        if (this.nombreInternoLlamador.equals("jifLiqServicios")) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                List<Long> idOrdenUnidosis = new ArrayList<>();
                List<Long> idSuministro = new ArrayList<>();
                int[] dato = this.JTDHistorico.getSelectedRows();
                for (int i = 0; i < dato.length; i++) {
                    idOrdenUnidosis.add(Long.valueOf(this.JTDHistorico.getValueAt(dato[i], 9).toString()));
                    idSuministro.add(Long.valueOf(this.JTDHistorico.getValueAt(dato[i], 10).toString()));
                }
                if (idOrdenUnidosis.size() > 1) {
                    this.detalleService.anularListaUnidosis(idOrdenUnidosis, idSuministro, Principal.usuarioSistemaDTO.getLogin());
                    mNuevo();
                    return;
                } else {
                    Principal.clasefacturacion.xjiliqServicio.xJPHojaTratamiento.mAnularSuministro();
                    return;
                }
            }
            return;
        }
        if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
            int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x2 == 0) {
                Anular frm = new Anular(null, true, "xjphojatratamiento", 3);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                return;
            }
            return;
        }
        if (Objects.equals(Principal.usuarioSistemaDTO.getIdUsuarioSistema(), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 11).toString()))) {
            int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x3 == 0) {
                Anular frm2 = new Anular(null, true, "xjphojatratamiento", 3);
                frm2.setLocationRelativeTo(this);
                frm2.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Solo el usuario que realizo esta aplicacion puede anular este registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mAnularSuministro(List<Long> idAplicacion, List<Long> idSuministro) {
        this.xHojaTratamientoDAO.deleteResultado(idAplicacion, idSuministro);
        mNuevo();
    }

    public void mAnularSuministro() {
        this.xHojaTratamientoDAO.deleteResultado(Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 9).toString()), Long.valueOf(this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 10).toString()));
        mNuevo();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.1
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {true, false, false, true, true, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("Tipo Producto");
        this.xmodelo.addColumn("Producto");
        this.xmodelo.addColumn("Hora");
        this.xmodelo.addColumn("Cantidad");
        this.xmodelo.addColumn("Observacion");
        this.xmodelo.addColumn("Profesional");
        this.xmodelo.addColumn("Especialidad");
        this.xmodelo.addColumn("Servicio");
        this.xmodelo.addColumn("Id_Ordenes_Aplicacion");
        this.xmodelo.addColumn("Id_Suministro");
        this.xmodelo.addColumn("Id_Persona");
        this.JTDHistorico.setAutoResizeMode(0);
        this.JTDHistorico.doLayout();
        this.JTDHistorico.setModel(this.xmodelo);
        this.JTDHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDHistorico.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDHistorico.getColumnModel().getColumn(11).setMaxWidth(0);
    }

    private void cargarTabla() {
        mCrearTabla();
        List<Object[]> list = this.xHojaTratamientoDAO.listaHojaTratamiento(this.xidatencion, this.JCHFiltro.isSelected(), this.nombreInternoLlamador);
        if (!list.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTDHistorico, 2);
            this.xmt.mEstablecerTextEditor(this.JTDHistorico, 5);
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list.get(x)[7], x, 6);
                this.xmodelo.setValueAt(list.get(x)[6], x, 7);
                this.xmodelo.setValueAt(list.get(x)[8], x, 8);
                this.xmodelo.setValueAt(list.get(x)[9], x, 9);
                this.xmodelo.setValueAt(list.get(x)[10], x, 10);
                this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDHistorico = new JScrollPane();
        this.JTDHistorico = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHFiltro = new JCheckBox();
        this.JBT_DuplicarTto = new JButton();
        setName("xjphojatratamiento");
        this.JSPDHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDHistorico.setRowHeight(25);
        this.JTDHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDHistorico.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPHojaTratamiento.this.JTDHistoricoPropertyChange(evt);
            }
        });
        this.JTDHistorico.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.3
            public void keyPressed(KeyEvent evt) {
                JPHojaTratamiento.this.JTDHistoricoKeyPressed(evt);
            }
        });
        this.JSPDHistorico.setViewportView(this.JTDHistorico);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.4
            public void mouseClicked(MouseEvent evt) {
                JPHojaTratamiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.5
            public void actionPerformed(ActionEvent evt) {
                JPHojaTratamiento.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Visualizar mis Aplicaciones");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.6
            public void actionPerformed(ActionEvent evt) {
                JPHojaTratamiento.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JBT_DuplicarTto.setFont(new Font("Arial", 1, 12));
        this.JBT_DuplicarTto.setForeground(Color.red);
        this.JBT_DuplicarTto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_DuplicarTto.setText("Duplicar");
        this.JBT_DuplicarTto.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPHojaTratamiento.7
            public void actionPerformed(ActionEvent evt) {
                JPHojaTratamiento.this.JBT_DuplicarTtoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHFiltro).addGap(648, 648, 648)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDHistorico).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 394, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, -1, 32767).addGap(45, 45, 45).addComponent(this.JBT_DuplicarTto, -1, -1, 32767).addGap(9, 9, 9))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDHistorico, -1, 364, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBT_DuplicarTto, -1, -1, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        cargarTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDHistorico.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDHistorico, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "HOJA DE APLICACION DE MEDICAMENTOS");
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDHistoricoPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno && this.JTDHistorico.getSelectedRow() != -1 && !this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 3).toString().isEmpty() && !this.xmodelo.getValueAt(this.JTDHistorico.getSelectedRow(), 4).toString().isEmpty() && !this.JTDHistorico.isEditing()) {
            mGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_DuplicarTtoActionPerformed(ActionEvent evt) {
        if (this.JTDHistorico.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de duplicar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String idOrdenNueva = this.xHojaTratamientoDAO.createAplicacionTratamiento_return_id(this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 9).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 10).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 0).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 3).toString().trim());
                this.xHojaTratamientoDAO.crearDetalleAplicacionTratamiento(this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 9).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 10).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 0).toString().trim(), this.JTDHistorico.getValueAt(this.JTDHistorico.getSelectedRow(), 3).toString().trim(), idOrdenNueva);
                mNuevo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDHistoricoKeyPressed(KeyEvent evt) {
        System.out.println("" + evt.getKeyCode());
    }
}
