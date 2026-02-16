package com.genoma.plus.controller.historia;

import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.ListaDeChequeoDAO;
import com.genoma.plus.dao.impl.historia.ListaDeChequeoDAOImpl;
import com.genoma.plus.dto.historia.ListaDeChequeoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAListaChequeo.class */
public class JPAListaChequeo extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloHistorico;
    private ListaDeChequeoDAO listaDeChequeoDAO;
    private int idAtencion;
    private String nombre;
    private String tipoHistoria;
    private String IdUsuario;
    private Object[] data;
    private Object[] xdatoH;
    private boolean guardado;
    private Metodos metodos = new Metodos();
    private String fecha = "";
    private Color color = Color.WHITE;
    private JButton JBTGuardar;
    private JPanel JPHistorico;
    private JPanel JPI_Detalle;
    private JRadioButton JRBAplica;
    private JRadioButton JRBNoAplica;
    private JTable JTB_Antecedentes;
    private JTabbedPane JTB_Datos;
    private JTable JTHistorico;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;

    public JPAListaChequeo(int idAtencion, String nombre, String tipoHistoria) {
        initComponents();
        springStart();
        this.idAtencion = idAtencion;
        this.nombre = nombre;
        this.tipoHistoria = tipoHistoria;
        this.IdUsuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString();
        mCargarDatos();
        mCargarDatosHistorico();
    }

    private void springStart() {
        this.listaDeChequeoDAO = (ListaDeChequeoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("listaDeChequeoDAO");
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Detalle = new JPanel();
        this.JBTGuardar = new JButton();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTB_Antecedentes = new JTable();
        this.JRBAplica = new JRadioButton();
        this.JRBNoAplica = new JRadioButton();
        this.JPHistorico = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("JPAListaChequeo");
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        this.JTB_Datos.addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAListaChequeo.this.JTB_DatosAncestorRemoved(evt);
            }
        });
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.2
            public void actionPerformed(ActionEvent evt) {
                JPAListaChequeo.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JTB_Antecedentes.setFont(new Font("Arial", 1, 12));
        this.JTB_Antecedentes.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTB_Antecedentes.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.3
            public void mouseClicked(MouseEvent evt) {
                JPAListaChequeo.this.JTB_AntecedentesMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTB_Antecedentes);
        this.buttonGroup1.add(this.JRBAplica);
        this.JRBAplica.setText("Todo aplica");
        this.JRBAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.4
            public void actionPerformed(ActionEvent evt) {
                JPAListaChequeo.this.JRBAplicaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBNoAplica);
        this.JRBNoAplica.setText("Todo no aplica");
        this.JRBNoAplica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.5
            public void actionPerformed(ActionEvent evt) {
                JPAListaChequeo.this.JRBNoAplicaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 742, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBAplica).addGap(18, 18, 18).addComponent(this.JRBNoAplica)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 497, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAplica).addComponent(this.JRBNoAplica)).addGap(0, 24, 32767)));
        GroupLayout JPI_DetalleLayout = new GroupLayout(this.JPI_Detalle);
        this.JPI_Detalle.setLayout(JPI_DetalleLayout);
        JPI_DetalleLayout.setHorizontalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTGuardar, -1, 718, 32767).addContainerGap()).addComponent(this.jPanel1, -1, -1, 32767));
        JPI_DetalleLayout.setVerticalGroup(JPI_DetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_DetalleLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -1, -1, 32767).addGap(113, 113, 113)));
        this.JTB_Datos.addTab("DETALLE", this.JPI_Detalle);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.jScrollPane2.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 718, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 573, 32767).addContainerGap()));
        this.JTB_Datos.addTab("HISTORICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos, -2, 626, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DatosAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_AntecedentesMouseClicked(MouseEvent evt) {
        if (this.JTB_Antecedentes.getSelectedRow() != -1) {
            if (this.JTB_Antecedentes.getSelectedColumn() == 2) {
                if (((Boolean) this.xmodelo.getValueAt(this.JTB_Antecedentes.getSelectedRow(), 2)).booleanValue()) {
                    this.JTB_Antecedentes.setValueAt(true, this.JTB_Antecedentes.getSelectedRow(), 2);
                    this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 3);
                } else {
                    this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 2);
                    this.JTB_Antecedentes.setValueAt(true, this.JTB_Antecedentes.getSelectedRow(), 3);
                }
            }
            if (this.JTB_Antecedentes.getSelectedColumn() == 3) {
                if (((Boolean) this.xmodelo.getValueAt(this.JTB_Antecedentes.getSelectedRow(), 3)).booleanValue()) {
                    this.JTB_Antecedentes.setValueAt(true, this.JTB_Antecedentes.getSelectedRow(), 3);
                    this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 2);
                } else {
                    this.JTB_Antecedentes.setValueAt(false, this.JTB_Antecedentes.getSelectedRow(), 3);
                    this.JTB_Antecedentes.setValueAt(true, this.JTB_Antecedentes.getSelectedRow(), 2);
                }
            }
            this.JTB_Antecedentes.repaint();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoAplicaActionPerformed(ActionEvent evt) {
        mPorDefecto(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAplicaActionPerformed(ActionEvent evt) {
        mPorDefecto(true);
    }

    private void mPorDefecto(Boolean opcion) {
        for (int i = 0; i < this.JTB_Antecedentes.getRowCount(); i++) {
            this.JTB_Antecedentes.setValueAt(opcion, i, 2);
            this.JTB_Antecedentes.setValueAt(Boolean.valueOf(!opcion.booleanValue()), i, 3);
        }
    }

    private void mGrabar() {
        if (this.JTB_Antecedentes.isEditing()) {
            this.JTB_Antecedentes.getCellEditor().stopCellEditing();
        }
        if (JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
            for (int x = 0; x < this.JTB_Antecedentes.getRowCount(); x++) {
                System.out.println("numero de fila " + this.JTB_Antecedentes.getRowCount() + "valor x: " + x);
                ListaDeChequeoDTO listaDeChequeoDTO = new ListaDeChequeoDTO();
                listaDeChequeoDTO.setIdAtencion(this.idAtencion);
                listaDeChequeoDTO.setIdLista(((Integer) this.xmodelo.getValueAt(x, 0)).intValue());
                listaDeChequeoDTO.setAplica(((Boolean) this.xmodelo.getValueAt(x, 2)).booleanValue());
                listaDeChequeoDTO.setNombre(this.xmodelo.getValueAt(x, 1).toString());
                listaDeChequeoDTO.setObservacion(this.xmodelo.getValueAt(x, 4).toString());
                listaDeChequeoDTO.setEstado(true);
                if (((Integer) this.xmodelo.getValueAt(x, 5)).intValue() == 0) {
                    this.listaDeChequeoDAO.crearLista(listaDeChequeoDTO);
                } else {
                    System.out.println("prueba" + this.xmodelo.getValueAt(x, 5).toString());
                    listaDeChequeoDTO.setId(Integer.parseInt(this.xmodelo.getValueAt(x, 5).toString()));
                    this.listaDeChequeoDAO.updateLista(listaDeChequeoDTO);
                }
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mCargarDatos();
            mCargarDatosHistorico();
        }
    }

    private void mCargarDatos() {
        mCrearModelo();
        this.metodos.mEstablecerTextEditor(this.JTB_Antecedentes, 1);
        List<Object[]> listaDeChequeo = this.listaDeChequeoDAO.obtenerListaDeChequeo(this.idAtencion, this.nombre, this.tipoHistoria);
        if (!listaDeChequeo.isEmpty()) {
            for (int x = 0; x < listaDeChequeo.size(); x++) {
                this.xmodelo.addRow(this.data);
                this.xmodelo.setValueAt(listaDeChequeo.get(x)[0], x, 0);
                this.xmodelo.setValueAt(listaDeChequeo.get(x)[1], x, 1);
                if (((Boolean) listaDeChequeo.get(x)[2]).booleanValue()) {
                    this.xmodelo.setValueAt(true, x, 2);
                    this.xmodelo.setValueAt(false, x, 3);
                } else {
                    this.xmodelo.setValueAt(true, x, 3);
                    this.xmodelo.setValueAt(false, x, 2);
                }
                this.xmodelo.setValueAt(listaDeChequeo.get(x)[3], x, 4);
                this.xmodelo.setValueAt(listaDeChequeo.get(x)[4], x, 5);
                this.xmodelo.setValueAt(listaDeChequeo.get(x)[5], x, 6);
            }
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdCNivel", "NItems", "Aplica", "No Aplica", "Observacion", "Id", "VDefecto"}) { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.6
            Class[] types = {Long.class, String.class, Boolean.class, Boolean.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, true, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Antecedentes.setAutoResizeMode(4);
        this.JTB_Antecedentes.setModel(this.xmodelo);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTB_Antecedentes.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_Antecedentes.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_Antecedentes.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTB_Antecedentes.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTB_Antecedentes.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    private void mCargarDatosHistorico() {
        mCrearModeloHistorico();
        List<Object[]> listaDeChequeo = this.listaDeChequeoDAO.obtenerListaDeChequeoH(this.idAtencion, this.nombre, this.tipoHistoria, this.IdUsuario);
        for (int x = 0; x < listaDeChequeo.size(); x++) {
            this.xmodeloHistorico.addRow(this.xdatoH);
            this.xmodeloHistorico.setValueAt(listaDeChequeo.get(x)[0], x, 0);
            this.xmodeloHistorico.setValueAt(listaDeChequeo.get(x)[1], x, 1);
            this.xmodeloHistorico.setValueAt(Boolean.valueOf(listaDeChequeo.get(x)[2].equals("1")), x, 2);
            this.xmodeloHistorico.setValueAt(Boolean.valueOf(!listaDeChequeo.get(x)[2].equals("1")), x, 3);
            this.xmodeloHistorico.setValueAt(listaDeChequeo.get(x)[3], x, 4);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloHistorico = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Nombre", "Aplica", "No Aplica", "Observacion"}) { // from class: com.genoma.plus.controller.historia.JPAListaChequeo.7
            Class[] types = {String.class, String.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setAutoResizeMode(4);
        this.JTHistorico.setModel(this.xmodeloHistorico);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.metodos.mEstablecerTextEditor(this.JTHistorico, 1);
        this.metodos.mEstablecerTextEditor(this.JTHistorico, 4);
    }
}
