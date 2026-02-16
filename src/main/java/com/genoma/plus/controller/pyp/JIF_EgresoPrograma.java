package com.genoma.plus.controller.pyp;

import Acceso.Principal;
import General.Persona;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GUsuarioxprograma;
import com.genoma.plus.jpa.service.IGUsuarioprogramaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_EgresoPrograma.class */
public class JIF_EgresoPrograma extends JInternalFrame {
    private Object[] dato;
    private Persona frmPersona;
    private JP_EngresoProgramas jpEgresoEngresoProgramas;
    private JP_EngresoControlPrenatal jpEngresoControlPrenatal;
    private List<GUsuarioxprograma> listaProgramasUsuario;
    private DefaultTableModel xmodelo;
    private JPanel JPEgresos;
    private JScrollPane JSPHistoricoUsuario;
    private JTable JTHistoricoUsuario;
    private JTabbedPane JTP_Datos;
    private JPanel panelPersona;
    private Metodos metodos = new Metodos();
    private final IGUsuarioprogramaService iUsuarioPorProgramaService = (IGUsuarioprogramaService) Principal.contexto.getBean(IGUsuarioprogramaService.class);

    public JIF_EgresoPrograma() {
        initComponents();
        cargarPanelPersona();
        mNuevo();
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(15, 10, 980, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    public void mMostrarPanel(JPanel formulario, int width, int height) {
        mLimpiarPanel();
        formulario.setBounds(15, 10, width, height);
        this.JPEgresos.add(formulario);
        this.JPEgresos.setVisible(true);
    }

    public void mLimpiarPanel() {
        this.JPEgresos.setVisible(false);
        this.JPEgresos.removeAll();
        this.JPEgresos.setVisible(true);
    }

    public void mLimpiar() {
        this.JTP_Datos.setEnabledAt(1, false);
        mLimpiarPanel();
        this.JTP_Datos.setSelectedIndex(0);
    }

    public void mNuevo() {
        crearModeloTablaHistoricoProgramaPaciente();
        mLimpiar();
        this.frmPersona.nuevo();
    }

    public void mBuscar() {
        this.frmPersona.buscarPersona();
        mLimpiar();
    }

    public void mGrabar() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaHistoricoProgramaPaciente() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha Ingreso", "Programa", "Cardinal", "EsIngreso", "Estado", "EsPrenatal", "idPrograma"}) { // from class: com.genoma.plus.controller.pyp.JIF_EgresoPrograma.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoUsuario.setModel(this.xmodelo);
        this.JTHistoricoUsuario.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistoricoUsuario.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.JTHistoricoUsuario.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTHistoricoUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistoricoUsuario.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTHistoricoUsuario.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHistoricoUsuario.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistoricoUsuario.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistoricoUsuario.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTHistoricoUsuario.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistoricoUsuario.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistoricoUsuario.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    public void cargarHistoricoProgramasPaciente(String idPaciente) {
        crearModeloTablaHistoricoProgramaPaciente();
        this.listaProgramasUsuario = this.iUsuarioPorProgramaService.buscarPorIdUsuario(Long.valueOf(idPaciente));
        if (!this.listaProgramasUsuario.isEmpty()) {
            for (int i = 0; i < this.listaProgramasUsuario.size(); i++) {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(this.listaProgramasUsuario.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaProgramasUsuario.get(i).getFechaIngreso(), i, 1);
                this.xmodelo.setValueAt(this.listaProgramasUsuario.get(i).getIdPrograma().getNbre(), i, 2);
                this.xmodelo.setValueAt(Boolean.valueOf(this.listaProgramasUsuario.get(i).getCardinal().toString()), i, 3);
                this.xmodelo.setValueAt(Boolean.valueOf(this.listaProgramasUsuario.get(i).isEsIngreso()), i, 4);
                this.xmodelo.setValueAt(Boolean.valueOf(!this.listaProgramasUsuario.get(i).isEstado()), i, 5);
                this.xmodelo.setValueAt(this.listaProgramasUsuario.get(i).getIdPrograma().getEsPrenatal(), i, 6);
                this.xmodelo.setValueAt(this.listaProgramasUsuario.get(i).getIdPrograma().getIdTipoPrograma(), i, 7);
            }
        }
    }

    private void initComponents() {
        this.panelPersona = new JPanel();
        this.JTP_Datos = new JTabbedPane();
        this.JSPHistoricoUsuario = new JScrollPane();
        this.JTHistoricoUsuario = new JTable();
        this.JPEgresos = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("EGRESO A PROGRAMAS DE PROMOCIÓN Y PREVENCIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifegresoprograma");
        this.panelPersona.setLayout((LayoutManager) null);
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSPHistoricoUsuario.setBorder((Border) null);
        this.JSPHistoricoUsuario.setViewportBorder(BorderFactory.createEtchedBorder());
        this.JSPHistoricoUsuario.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoUsuario.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoUsuario.setRowHeight(25);
        this.JTHistoricoUsuario.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoUsuario.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistoricoUsuario.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JIF_EgresoPrograma.2
            public void mouseClicked(MouseEvent evt) {
                JIF_EgresoPrograma.this.JTHistoricoUsuarioMouseClicked(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                JIF_EgresoPrograma.this.JTHistoricoUsuarioMouseReleased(evt);
            }
        });
        this.JSPHistoricoUsuario.setViewportView(this.JTHistoricoUsuario);
        this.JTP_Datos.addTab("HISTÓRICO", this.JSPHistoricoUsuario);
        GroupLayout JPEgresosLayout = new GroupLayout(this.JPEgresos);
        this.JPEgresos.setLayout(JPEgresosLayout);
        JPEgresosLayout.setHorizontalGroup(JPEgresosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1125, 32767));
        JPEgresosLayout.setVerticalGroup(JPEgresosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 348, 32767));
        this.JTP_Datos.addTab("EGRESO", this.JPEgresos);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.panelPersona, -2, 1130, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTP_Datos, -2, 1130, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.panelPersona, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTP_Datos, -2, 379, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoUsuarioMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoUsuarioMouseClicked(MouseEvent evt) {
        if (this.JTHistoricoUsuario.getSelectedRow() != -1) {
            this.JTP_Datos.setEnabledAt(1, true);
            this.JPEgresos.removeAll();
            if (this.xmodelo.getValueAt(this.JTHistoricoUsuario.getSelectedRow(), 6).toString().equals("1")) {
                this.jpEngresoControlPrenatal = new JP_EngresoControlPrenatal(this.listaProgramasUsuario.get(this.JTHistoricoUsuario.getSelectedRow()).getId());
                mMostrarPanel(this.jpEngresoControlPrenatal, 1125, 348);
            } else {
                this.jpEgresoEngresoProgramas = new JP_EngresoProgramas(this.listaProgramasUsuario.get(this.JTHistoricoUsuario.getSelectedRow()).getId());
                mMostrarPanel(this.jpEgresoEngresoProgramas, 1125, 348);
            }
            this.JTP_Datos.setSelectedIndex(1);
        }
    }
}
