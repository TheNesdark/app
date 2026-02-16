package com.genoma.plus.controller.imagenesdx;

import Acceso.Principal;
import General.Persona;
import Utilidades.Metodos;
import com.genoma.plus.dao.imagenesdx.InformeLecturaUsuariosDAO;
import com.genoma.plus.dao.impl.imagenesdx.InformeLecturaUsuariosDAOImpl;
import com.genoma.plus.dto.imagenesdx.InformeLecturaUsuariosDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/imagenesdx/JIFFInformeLecturaUsuarios.class */
public class JIFFInformeLecturaUsuarios extends JInternalFrame {
    private InformeLecturaUsuariosDAO xInformeLecturaUsuariosDAO;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    public Persona frmPersona;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JPanel panelPersona;

    public JIFFInformeLecturaUsuarios(String nombre) {
        initComponents();
        setName(nombre);
        springStart();
        this.frmPersona = new Persona(this);
        cargarPanelPersona();
        mNuevo();
    }

    private void springStart() {
        this.xInformeLecturaUsuariosDAO = (InformeLecturaUsuariosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeLecturaUsuariosDAO");
    }

    public void cargarPanelPersona() {
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(5, 15, 961, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Procedimiento", "Especialidad", "Profesional", "IdEncabezado"}) { // from class: com.genoma.plus.controller.imagenesdx.JIFFInformeLecturaUsuarios.1
            Class[] types = {String.class, String.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    public void mCargarDatosTabla(String xidpersona) {
        mModelo();
        Principal.txtNo.setText(xidpersona);
        List<InformeLecturaUsuariosDTO> list = this.xInformeLecturaUsuariosDAO.list(xidpersona);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getFechaRec(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNProcedimiento(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getEspecialidad(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNProfesional(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getIdEncabezado()), x, 4);
        }
    }

    public void mBuscar() {
        this.frmPersona.buscar(3);
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        mModelo();
        this.frmPersona.nuevo();
        this.frmPersona.requestFocus();
    }

    public void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = String.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Radiologia_Informe_Lectura_RadiologosAs", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_Radiologia_Informe_Lectura", mparametros);
        }
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.panelPersona = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE LECTURAS POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiffinformelecturausuarios");
        this.panelPersona.setEnabled(false);
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 186, 32767));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.imagenesdx.JIFFInformeLecturaUsuarios.2
            public void mouseClicked(MouseEvent evt) {
                JIFFInformeLecturaUsuarios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.panelPersona, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 967, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 257, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mImprimir();
        }
    }
}
