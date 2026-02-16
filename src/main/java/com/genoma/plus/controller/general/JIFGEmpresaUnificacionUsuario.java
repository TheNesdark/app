package com.genoma.plus.controller.general;

import Acceso.Principal;
import Historia.JDPatologia;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.GConsultasSqlDAO;
import com.genoma.plus.dao.impl.general.GConsultasSqlDAOImpl;
import com.genoma.plus.dto.general.LogUsuariosDuplicadosDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFGEmpresaUnificacionUsuario.class */
public class JIFGEmpresaUnificacionUsuario extends JInternalFrame {
    private Metodos xmt = new Metodos();
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelod;
    private Object[] xdato;
    private GConsultasSqlDAO xGConsultasSqlDAO;
    private JLabel JLB_DAnterior;
    private JLabel JLB_DOriginal;
    private JPanel JPI_NHistoria;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    public JTextField JTF_ANHistoria;
    public JTextField JTF_ANId_Persona;
    public JTextField JTF_ANUsuario;
    public JTextField JTF_ONHistoria;
    public JTextField JTF_ONId_Persona;
    public JTextField JTF_ONUsuario;

    public JIFGEmpresaUnificacionUsuario() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_NHistoria = new JPanel();
        this.JTF_ONHistoria = new JTextField();
        this.JLB_DOriginal = new JLabel();
        this.JTF_ONUsuario = new JTextField();
        this.JTF_ONId_Persona = new JTextField();
        this.JLB_DAnterior = new JLabel();
        this.JTF_ANHistoria = new JTextField();
        this.JTF_ANUsuario = new JTextField();
        this.JTF_ANId_Persona = new JTextField();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Unificacion de Terceros  ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFGEmpresaUnificacionUsuario");
        this.JPI_NHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_ONHistoria.setEditable(false);
        this.JTF_ONHistoria.setFont(new Font("Arial", 1, 12));
        this.JTF_ONHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONHistoria.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario.1
            public void mouseClicked(MouseEvent evt) {
                JIFGEmpresaUnificacionUsuario.this.JTF_ONHistoriaMouseClicked(evt);
            }
        });
        this.JLB_DOriginal.setFont(new Font("Arial", 1, 12));
        this.JLB_DOriginal.setForeground(Color.red);
        this.JLB_DOriginal.setHorizontalAlignment(0);
        this.JLB_DOriginal.setText("TERCERO  NUEVO");
        this.JTF_ONUsuario.setEditable(false);
        this.JTF_ONUsuario.setFont(new Font("Arial", 1, 12));
        this.JTF_ONUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ONId_Persona.setEditable(false);
        this.JTF_ONId_Persona.setFont(new Font("Arial", 1, 12));
        this.JTF_ONId_Persona.setHorizontalAlignment(0);
        this.JTF_ONId_Persona.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_DAnterior.setFont(new Font("Arial", 1, 12));
        this.JLB_DAnterior.setForeground(Color.red);
        this.JLB_DAnterior.setHorizontalAlignment(0);
        this.JLB_DAnterior.setText("TERCERO ANTERIOR");
        this.JTF_ANHistoria.setEditable(false);
        this.JTF_ANHistoria.setFont(new Font("Arial", 1, 12));
        this.JTF_ANHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ANHistoria.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario.2
            public void mouseClicked(MouseEvent evt) {
                JIFGEmpresaUnificacionUsuario.this.JTF_ANHistoriaMouseClicked(evt);
            }
        });
        this.JTF_ANUsuario.setEditable(false);
        this.JTF_ANUsuario.setFont(new Font("Arial", 1, 12));
        this.JTF_ANUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ANId_Persona.setEditable(false);
        this.JTF_ANId_Persona.setFont(new Font("Arial", 1, 12));
        this.JTF_ANId_Persona.setHorizontalAlignment(0);
        this.JTF_ANId_Persona.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_NHistoriaLayout = new GroupLayout(this.JPI_NHistoria);
        this.JPI_NHistoria.setLayout(JPI_NHistoriaLayout);
        JPI_NHistoriaLayout.setHorizontalGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addComponent(this.JTF_ANHistoria, -2, 167, -2).addGap(14, 14, 14).addComponent(this.JTF_ANUsuario, -2, 663, -2).addGap(39, 39, 39).addComponent(this.JTF_ANId_Persona).addGap(81, 81, 81)).addGroup(GroupLayout.Alignment.TRAILING, JPI_NHistoriaLayout.createSequentialGroup().addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLB_DAnterior, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JLB_DOriginal, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPI_NHistoriaLayout.createSequentialGroup().addComponent(this.JTF_ONHistoria, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_ONUsuario, -2, 671, -2).addGap(34, 34, 34).addComponent(this.JTF_ONId_Persona))).addGap(82, 82, 82)))));
        JPI_NHistoriaLayout.setVerticalGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NHistoriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB_DOriginal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ONHistoria, -2, 50, -2).addComponent(this.JTF_ONUsuario, -2, 50, -2).addComponent(this.JTF_ONId_Persona, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_DAnterior).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_NHistoriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ANHistoria, -2, 50, -2).addComponent(this.JTF_ANUsuario, -2, 50, -2).addComponent(this.JTF_ANId_Persona, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(25);
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_NHistoria, -2, 926, 32767).addComponent(this.JSP_Detalle))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_NHistoria, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSP_Detalle, -2, 379, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ONHistoriaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDPatologia JDP = new JDPatologia((Frame) null, true, (Object) this, "1");
            JDP.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ANHistoriaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDPatologia JDP = new JDPatologia((Frame) null, true, (Object) this, "2");
            JDP.setVisible(true);
        }
    }

    private void springStart() {
        this.xGConsultasSqlDAO = (GConsultasSqlDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("GConsultasSqlDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "NSql", "NParamerto", "NOrden", "Ejecutar", "Tipo"}) { // from class: com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario.3
            Class[] types = {Long.class, String.class, String.class, Long.class, Long.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    public void mCargadatos() {
        mCrearModelo();
        List<Object[]> ListaConsultas = this.xGConsultasSqlDAO.ListaDeConsultas(2);
        for (int x = 0; x < ListaConsultas.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            for (int j = 0; j < 7; j++) {
                this.xmodelo.setValueAt(ListaConsultas.get(x)[j], x, j);
            }
        }
    }

    public void mGrabar() {
        if (!this.JTF_ONHistoria.getText().isEmpty()) {
            if (!this.JTF_ANHistoria.getText().isEmpty()) {
                LogUsuariosDuplicadosDTO lUDuplicados = new LogUsuariosDuplicadosDTO();
                lUDuplicados.setIdPersonaA(Integer.parseInt(this.JTF_ANId_Persona.getText()));
                lUDuplicados.setIdPersonaN(Integer.parseInt(this.JTF_ONId_Persona.getText()));
                lUDuplicados.setNomUsuarioA(this.JTF_ANUsuario.getText());
                lUDuplicados.setNomUsuarioN(this.JTF_ONUsuario.getText());
                lUDuplicados.setNHistoriaA(Integer.parseInt(this.JTF_ANHistoria.getText()));
                lUDuplicados.setNHistoriaN(Integer.parseInt(this.JTF_ONHistoria.getText()));
                lUDuplicados.setIdUsuario(Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString()).intValue());
                for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 5).toString()).booleanValue()) {
                        this.xGConsultasSqlDAO.InsertarDuplicados(lUDuplicados);
                        if (((Integer) this.xmodelo.getValueAt(x, 3)).intValue() == 1) {
                            this.xGConsultasSqlDAO.ejecuarSql1(this.xmodelo.getValueAt(x, 2).toString(), this.JTF_ANId_Persona.getText());
                        }
                        if (((Integer) this.xmodelo.getValueAt(x, 3)).intValue() == 2) {
                            this.xGConsultasSqlDAO.ejecutarSql2(this.xmodelo.getValueAt(x, 2).toString(), this.JTF_ONId_Persona.getText(), this.JTF_ANId_Persona.getText());
                        }
                    }
                }
                return;
            }
            this.xmt.mostrarMensaje("Selecionar Usuario Anterior");
            return;
        }
        this.xmt.mostrarMensaje("Selecionar Usuario Anterior");
    }

    public void mNuevo() {
        this.JTF_ONId_Persona.setText("");
        this.JTF_ONHistoria.setText("");
        this.JTF_ONUsuario.setText("");
        this.JTF_ANId_Persona.setText("");
        this.JTF_ANHistoria.setText("");
        this.JTF_ANUsuario.setText("");
        mCargadatos();
    }
}
