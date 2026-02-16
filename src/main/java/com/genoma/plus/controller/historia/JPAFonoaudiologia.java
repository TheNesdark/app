package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.FonoaudiologiaDAO;
import com.genoma.plus.dao.impl.historia.FonoaudiologiaDAOImpl;
import com.genoma.plus.dto.historia.FonoaudiologiaDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAFonoaudiologia.class */
public class JPAFonoaudiologia extends JPanel {
    private clasesHistoriaCE xClaseHC;
    private FonoaudiologiaDAO xFonoaudiologiaDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private JButton JBTGuardar;
    private JButton JBTNuevo;
    private JTabbedPane JTPFonoaudiologia;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jspHistorico;
    private JTable jtHistorico;
    private JTextPane jtpExploracionDBA;
    private JTextPane jtpExploracionFCS;
    private JTextPane jtpExploracionOFA;
    private JTextPane jtpFonacion;
    private JTextPane jtpOrganosSentidos;
    private JTextPane jtpProcesosMotBasicos;
    private JLabel lblRegistro;
    private Metodos xmt = new Metodos();
    private final FonoaudiologiaDTO xFonoaudiologiaDTO = new FonoaudiologiaDTO();

    public JPAFonoaudiologia(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mNuevo();
    }

    public JPAFonoaudiologia() {
    }

    private void springStart() {
        this.xFonoaudiologiaDAO = (FonoaudiologiaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("fonoaudiologiaDAO");
    }

    private void mNuevo() {
        mCargarDatosTabla();
        cargarPaneles();
        this.lblRegistro.setText("");
        mBuscarAtencion();
    }

    private void cargarPaneles() {
        this.jtpOrganosSentidos.setText("OTOSCOPIA:\nOTROS:\n");
        this.jtpExploracionOFA.setText("NARIZ: Normal\nPALADAR: Normal\nLENGUA: Normal\nDIENTE: Normal, completos\nLABIOS: Normal\nAMIGDALAS: Normal\nMEJILLAS: Normal\nA.T.M.: Normal\nOBSERVACIONES:");
        this.jtpProcesosMotBasicos.setText("RESPIRACIÓN: Normal\nFONACIÓN: Normal\nARTICULACIÓN: Normal\nRESONANCIA: Normal\nPROSODIA: Normal");
        this.jtpFonacion.setText("LECTURA:\n\nESCRITURA:");
        this.jtpExploracionFCS.setText("PRAXIAS:\n\nGNOSIAS:\n\nLENGUAJE:");
        this.jtpExploracionDBA.setText("ATENCIÓN: Normal\nMEMORIA: Normal\nCONCENTRACIÓN: Normal\nHABITUACIÓN: Normal\nMOTIVACIÓN: Normal");
    }

    public void mGrabar() {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar", "Grabar Información Fonoaudiolgía @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
            if (this.lblRegistro.getText().equals("")) {
                this.xFonoaudiologiaDTO.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xFonoaudiologiaDTO.setOrganosSentidos(this.jtpOrganosSentidos.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setProcesosMotBasicos(this.jtpProcesosMotBasicos.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionOFA(this.jtpExploracionOFA.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setFonacion(this.jtpFonacion.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionFCS(this.jtpExploracionFCS.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionDBA(this.jtpExploracionDBA.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                String xIdFono = this.xFonoaudiologiaDAO.mCreate(this.xFonoaudiologiaDTO);
                this.lblRegistro.setText(xIdFono);
            } else {
                this.xFonoaudiologiaDTO.setOrganosSentidos(this.jtpOrganosSentidos.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setProcesosMotBasicos(this.jtpProcesosMotBasicos.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionOFA(this.jtpExploracionOFA.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setFonacion(this.jtpFonacion.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionFCS(this.jtpExploracionFCS.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setExploracionDBA(this.jtpExploracionDBA.getText().toUpperCase());
                this.xFonoaudiologiaDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.xFonoaudiologiaDTO.setId(Integer.parseInt(this.lblRegistro.getText()));
                this.xFonoaudiologiaDTO.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xFonoaudiologiaDAO.mUpdate(this.xFonoaudiologiaDTO);
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha_Atencion", "Id_Atención", "Audición", "E. OFA", "P. Mot Bas", "Lecto_Escritura", "E. FCS", "E. DBA"}) { // from class: com.genoma.plus.controller.historia.JPAFonoaudiologia.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jtHistorico.setModel(this.xmodelo);
        this.jtHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.jtHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.jtHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.jtHistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.jtHistorico.getColumnModel().getColumn(8).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        FonoaudiologiaDAO fonoaudiologiaDAO = this.xFonoaudiologiaDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<FonoaudiologiaDTO> list = fonoaudiologiaDAO.listFonoaudiologia(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFechaAtencion(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getIdAtencion()), x, 2);
            this.xmodelo.setValueAt(list.get(x).getOrganosSentidos(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getExploracionOFA(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getProcesosMotBasicos(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getFonacion(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getExploracionFCS(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getExploracionDBA(), x, 8);
        }
    }

    private void mBuscarAtencion() {
        if (this.jtHistorico.getRowCount() >= 1) {
            int i = 0;
            while (i < this.jtHistorico.getRowCount()) {
                String string = this.jtHistorico.getValueAt(i, 2).toString();
                clasesHistoriaCE claseshistoriace = this.xClaseHC;
                if (string.equals(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())) {
                    this.jtpOrganosSentidos.setText(this.jtHistorico.getValueAt(i, 3).toString());
                    this.jtpExploracionOFA.setText(this.jtHistorico.getValueAt(i, 4).toString());
                    this.jtpProcesosMotBasicos.setText(this.jtHistorico.getValueAt(i, 5).toString());
                    this.jtpFonacion.setText(this.jtHistorico.getValueAt(i, 6).toString());
                    this.jtpExploracionFCS.setText(this.jtHistorico.getValueAt(i, 7).toString());
                    this.jtpExploracionDBA.setText(this.jtHistorico.getValueAt(i, 8).toString());
                    this.JTPFonoaudiologia.setSelectedIndex(0);
                    i = this.jtHistorico.getRowCount() - 1;
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                i++;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBTGuardar = new JButton();
        this.JTPFonoaudiologia = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jtpOrganosSentidos = new JTextPane();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.jtpExploracionOFA = new JTextPane();
        this.jPanel3 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.jtpProcesosMotBasicos = new JTextPane();
        this.jPanel4 = new JPanel();
        this.jScrollPane4 = new JScrollPane();
        this.jtpFonacion = new JTextPane();
        this.jPanel5 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.jtpExploracionFCS = new JTextPane();
        this.jPanel6 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.jtpExploracionDBA = new JTextPane();
        this.jPanel7 = new JPanel();
        this.jspHistorico = new JScrollPane();
        this.jtHistorico = new JTable();
        this.JBTNuevo = new JButton();
        this.lblRegistro = new JLabel();
        setName("Fonoaudiologia");
        setOpaque(false);
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFonoaudiologia.2
            public void actionPerformed(ActionEvent evt) {
                JPAFonoaudiologia.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JTPFonoaudiologia.setForeground(Color.red);
        this.JTPFonoaudiologia.setToolTipText("");
        this.JTPFonoaudiologia.setFont(new Font("Arial", 1, 14));
        this.jScrollPane1.setViewportView(this.jtpOrganosSentidos);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 646, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 464, -2).addContainerGap(-1, 32767)));
        this.JTPFonoaudiologia.addTab("Audición", this.jPanel1);
        this.jScrollPane2.setViewportView(this.jtpExploracionOFA);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 646, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Exploración OFA", this.jPanel2);
        this.jScrollPane3.setViewportView(this.jtpProcesosMotBasicos);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 646, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Procesos Motores Básicos", this.jPanel3);
        this.jScrollPane4.setViewportView(this.jtpFonacion);
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 646, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Lecto - Escritura", this.jPanel4);
        this.jScrollPane5.setViewportView(this.jtpExploracionFCS);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 646, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Exploración FCS", this.jPanel5);
        this.jScrollPane6.setViewportView(this.jtpExploracionDBA);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 646, 32767).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Exploración DBA", this.jPanel6);
        this.jtHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jtHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAFonoaudiologia.3
            public void mouseClicked(MouseEvent evt) {
                JPAFonoaudiologia.this.jtHistoricoMouseClicked(evt);
            }
        });
        this.jspHistorico.setViewportView(this.jtHistorico);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jspHistorico, -1, 670, 32767));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jspHistorico, -1, 326, 32767).addContainerGap()));
        this.JTPFonoaudiologia.addTab("Histórico", this.jPanel7);
        this.JTPFonoaudiologia.setSelectedComponent(this.jPanel1);
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTNuevo.setText("Limpiar");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAFonoaudiologia.4
            public void actionPerformed(ActionEvent evt) {
                JPAFonoaudiologia.this.JBTNuevoActionPerformed(evt);
            }
        });
        this.lblRegistro.setFont(new Font("Arial", 1, 18));
        this.lblRegistro.setForeground(Color.red);
        this.lblRegistro.setHorizontalAlignment(0);
        this.lblRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registro", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPFonoaudiologia, -2, 675, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTNuevo, -2, 206, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 201, -2).addGap(18, 18, 18).addComponent(this.lblRegistro, -2, 221, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFonoaudiologia, -2, 402, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTNuevo, -2, 65, -2).addComponent(this.JBTGuardar, -2, 65, -2)).addComponent(this.lblRegistro, -2, 65, -2)).addContainerGap(23, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtHistoricoMouseClicked(MouseEvent evt) {
        if (this.jtHistorico.getSelectedRow() != -1) {
            this.lblRegistro.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 0).toString());
            this.jtpOrganosSentidos.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 3).toString());
            this.jtpExploracionOFA.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 4).toString());
            this.jtpProcesosMotBasicos.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 5).toString());
            this.jtpFonacion.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 6).toString());
            this.jtpExploracionFCS.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 7).toString());
            this.jtpExploracionDBA.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 8).toString());
            this.JTPFonoaudiologia.setSelectedIndex(0);
        }
    }
}
