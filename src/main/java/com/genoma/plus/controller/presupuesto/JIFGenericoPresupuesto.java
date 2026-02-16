package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.EntidadesContraloriaDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.OrigenIngresoDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.TipoDestinacionDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.TipoRecursosDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.TipoSituacionDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.TipoVigenciaDAOImpl;
import com.genoma.plus.dao.presupuesto.EntidadesContraloriaDAO;
import com.genoma.plus.dao.presupuesto.OrigenIngresoDAO;
import com.genoma.plus.dao.presupuesto.TipoDestinacionDAO;
import com.genoma.plus.dao.presupuesto.TipoRecursosDAO;
import com.genoma.plus.dao.presupuesto.TipoSituacionDAO;
import com.genoma.plus.dao.presupuesto.TipoVigenciaDAO;
import com.genoma.plus.dto.presupuesto.EntidadesContraloriaDTO;
import com.genoma.plus.dto.presupuesto.OrigenIngresoDTO;
import com.genoma.plus.dto.presupuesto.TipoDestinacionDTO;
import com.genoma.plus.dto.presupuesto.TipoRecursosDTO;
import com.genoma.plus.dto.presupuesto.TipoSituacionDTO;
import com.genoma.plus.dto.presupuesto.TipoVigenciaDTO;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JIFGenericoPresupuesto.class */
public class JIFGenericoPresupuesto extends JInternalFrame {
    private String titulo;
    private int id;
    private EntidadesContraloriaDAO xEntidadesContraloriaDAO;
    private OrigenIngresoDAO xOrigenIngresoDAO;
    private TipoDestinacionDAO xTipoDestinacionDAO;
    private TipoRecursosDAO xTipoRecursosDAO;
    private TipoSituacionDAO xTipoSituacionDAO;
    private TipoVigenciaDAO xTipoVigenciaDAO;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private Metodos metodos = new Metodos();
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JIFGenericoPresupuesto() {
        initComponents();
    }

    public JIFGenericoPresupuesto(String titulo, int id, String name) {
        initComponents();
        setName("xJIF" + name.trim());
        setTitle(titulo);
        this.titulo = titulo;
        this.id = id;
        sprintStart();
        mNuevo();
    }

    private void sprintStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xEntidadesContraloriaDAO = (EntidadesContraloriaDAOImpl) classPathXmlApplicationContext.getBean("EntidadesContraloriaDAO");
        this.xOrigenIngresoDAO = (OrigenIngresoDAOImpl) classPathXmlApplicationContext.getBean("OrigenIngresoDAO");
        this.xTipoDestinacionDAO = (TipoDestinacionDAOImpl) classPathXmlApplicationContext.getBean("TipoDestinacionDAO");
        this.xTipoRecursosDAO = (TipoRecursosDAOImpl) classPathXmlApplicationContext.getBean("TipoRecursosDAO");
        this.xTipoSituacionDAO = (TipoSituacionDAOImpl) classPathXmlApplicationContext.getBean("TipoSituacionDAO");
        this.xTipoVigenciaDAO = (TipoVigenciaDAOImpl) classPathXmlApplicationContext.getBean("TipoVigenciaDAO");
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFCodigo = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo).addGap(11, 11, 11).addComponent(this.JTFNombre, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addGap(18, 18, 18)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(23, 23, 23).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 49, -2).addComponent(this.JTFCodigo, -2, 49, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JCHEstado))).addContainerGap(-1, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JIFGenericoPresupuesto.1
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoPresupuesto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 545, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 322, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(24, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3)).booleanValue());
        }
    }

    public void mNuevo() {
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        mCargarDatos();
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo", "Nombre", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JIFGenericoPresupuesto.2
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(70);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> listado = null;
        switch (this.id) {
            case 1:
                listado = this.xEntidadesContraloriaDAO.listaEntidadesContraloria();
                break;
            case 2:
                listado = this.xOrigenIngresoDAO.listaOrigenIngreso();
                break;
            case 3:
                listado = this.xTipoDestinacionDAO.listaTipoDestinacion();
                break;
            case 4:
                listado = this.xTipoRecursosDAO.listaTipoRecursos();
                break;
            case 5:
                listado = this.xTipoSituacionDAO.listaTipoSituacion();
                break;
            case 6:
                listado = this.xTipoVigenciaDAO.listaTipoVigencia();
                break;
        }
        for (int x = 0; x < listado.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 4; j++) {
                this.xmodelo.setValueAt(listado.get(x)[j], x, j);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    switch (this.id) {
                        case 1:
                            EntidadesContraloriaDTO EContraloriaDTO = new EntidadesContraloriaDTO();
                            EContraloriaDTO.setCodigo(this.JTFCodigo.getText());
                            EContraloriaDTO.setNombre(this.JTFNombre.getText());
                            EContraloriaDTO.setEstado(this.JCHEstado.isSelected());
                            EContraloriaDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                            if (Principal.txtNo.getText().isEmpty()) {
                                this.xEntidadesContraloriaDAO.mCreate(EContraloriaDTO);
                            } else {
                                EContraloriaDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                this.xEntidadesContraloriaDAO.mUpdate(EContraloriaDTO);
                            }
                            break;
                        case 2:
                            if (this.JTFCodigo.getText().length() < 5) {
                                OrigenIngresoDTO OIngresoDTO = new OrigenIngresoDTO();
                                OIngresoDTO.setCodigo(this.JTFCodigo.getText());
                                OIngresoDTO.setNombre(this.JTFNombre.getText());
                                OIngresoDTO.setEstado(this.JCHEstado.isSelected());
                                OIngresoDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                if (Principal.txtNo.getText().isEmpty()) {
                                    this.xOrigenIngresoDAO.mCreate(OIngresoDTO);
                                } else {
                                    OIngresoDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                    this.xOrigenIngresoDAO.mUpdate(OIngresoDTO);
                                }
                            } else {
                                this.metodos.mostrarMensaje("La longitud del campo codigo no puede ser mayor a 4");
                            }
                            break;
                        case 3:
                            if (this.JTFCodigo.getText().length() < 6) {
                                TipoDestinacionDTO TDestinacionDTO = new TipoDestinacionDTO();
                                TDestinacionDTO.setCodigo(this.JTFCodigo.getText());
                                TDestinacionDTO.setNombre(this.JTFNombre.getText());
                                TDestinacionDTO.setEstado(this.JCHEstado.isSelected());
                                TDestinacionDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                if (Principal.txtNo.getText().isEmpty()) {
                                    this.xTipoDestinacionDAO.mCreate(TDestinacionDTO);
                                } else {
                                    TDestinacionDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                    this.xTipoDestinacionDAO.mUpdate(TDestinacionDTO);
                                }
                            } else {
                                this.metodos.mostrarMensaje("La longitud del codigo no puede ser mayor a 5 ");
                            }
                            break;
                        case 4:
                            if (this.JTFCodigo.getText().length() < 4) {
                                TipoRecursosDTO TRecursosDTO = new TipoRecursosDTO();
                                TRecursosDTO.setCodigo(this.JTFCodigo.getText());
                                TRecursosDTO.setNombre(this.JTFNombre.getText());
                                TRecursosDTO.setEstado(this.JCHEstado.isSelected());
                                TRecursosDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                if (Principal.txtNo.getText().isEmpty()) {
                                    this.xTipoRecursosDAO.mCreate(TRecursosDTO);
                                } else {
                                    TRecursosDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                    this.xTipoRecursosDAO.mUpdate(TRecursosDTO);
                                }
                            } else {
                                this.metodos.mostrarMensaje("La longitud del codigo no puede ser mayor a 3 ");
                            }
                            break;
                        case 5:
                            if (this.JTFCodigo.getText().length() < 4) {
                                TipoSituacionDTO TSituacionDTO = new TipoSituacionDTO();
                                TSituacionDTO.setCodigo(this.JTFCodigo.getText());
                                TSituacionDTO.setNombre(this.JTFNombre.getText());
                                TSituacionDTO.setEstado(this.JCHEstado.isSelected());
                                TSituacionDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                if (Principal.txtNo.getText().isEmpty()) {
                                    this.xTipoSituacionDAO.mCreate(TSituacionDTO);
                                } else {
                                    TSituacionDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                    this.xTipoSituacionDAO.mUpdate(TSituacionDTO);
                                }
                            } else {
                                this.metodos.mostrarMensaje("La longitud del codigo no puede ser mayor a 3");
                            }
                            break;
                        case 6:
                            if (this.JTFCodigo.getText().length() < 4) {
                                TipoVigenciaDTO TVigenciaDTO = new TipoVigenciaDTO();
                                TVigenciaDTO.setCodigo(this.JTFCodigo.getText());
                                TVigenciaDTO.setNombre(this.JTFNombre.getText());
                                TVigenciaDTO.setEstado(this.JCHEstado.isSelected());
                                TVigenciaDTO.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                                if (Principal.txtNo.getText().isEmpty()) {
                                    this.xTipoVigenciaDAO.mCreate(TVigenciaDTO);
                                } else {
                                    TVigenciaDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                    this.xTipoVigenciaDAO.mUpdate(TVigenciaDTO);
                                }
                            } else {
                                this.metodos.mostrarMensaje("La longitud del codigo no puede ser mayor a 3");
                            }
                            break;
                    }
                }
                mNuevo();
                return;
            }
            this.metodos.mostrarMensaje("El campo nombre no puede estar vacio ");
            return;
        }
        this.metodos.mostrarMensaje("El campo codigo no puede estar vacio");
    }
}
