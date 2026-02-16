package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.AntecedenteReumatologicoDAO;
import com.genoma.plus.dao.impl.historia.AntecedenteReumatologicoDAOImpl;
import com.genoma.plus.dto.historia.AntecedenteReumatologicoDTO;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAAntecedenteReumatologia.class */
public class JPAAntecedenteReumatologia extends JPanel {
    private AntecedenteReumatologicoDAO xAntecedenteReumatologicoDAO;
    private final AntecedenteReumatologicoDTO xAntecedenteReumatologicoDTO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private final clasesHistoriaCE xClaseHC;
    private int xHta = 0;
    private int xDm = 0;
    private int xEcv = 0;
    private int xErc = 0;
    private int xOsteo = 0;
    private int xSs = 0;
    private int xEstado = 1;
    private Metodos xmetodo = new Metodos();
    private String[] xIdEspecialidad;
    private String[] xIdProfesional;
    private JButton JBTNuevo;
    private JPanel jPanel1;
    private JButton jbtnGuardar;
    private JCheckBox jchDm;
    private JCheckBox jchEcv;
    private JCheckBox jchErc;
    private JCheckBox jchHta;
    private JCheckBox jchOsteo;
    private JCheckBox jchSs;
    public JDateChooser jdchFecha;
    private JScrollPane jspHistorico;
    private JTable jtHistorico;
    private JYearChooser jychFDiagnostico;
    private JYearChooser jychFInicio;
    private JYearChooser jychFTratamiento;
    private JLabel lblRegistro;

    public JPAAntecedenteReumatologia(clasesHistoriaCE xClaseHC) {
        initComponents();
        this.xAntecedenteReumatologicoDTO = new AntecedenteReumatologicoDTO();
        springStart();
        this.xClaseHC = xClaseHC;
        mNuevo();
    }

    private void springStart() {
        this.xAntecedenteReumatologicoDAO = (AntecedenteReumatologicoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("antecedenteReumatologicoDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_Atención", "Fecha_Atencion", "FechaR", "FInicio", "FDx", "FTratamiento", "HTA", "DM", "ECV", "ERC", "OSTEO", "SS", "Especialidad", "Profesional", "Estado"}) { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.jtHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.jtHistorico.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.jtHistorico.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.jtHistorico.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.jtHistorico.getColumnModel().getColumn(13).setPreferredWidth(60);
        this.jtHistorico.getColumnModel().getColumn(14).setPreferredWidth(60);
        this.jtHistorico.getColumnModel().getColumn(15).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        AntecedenteReumatologicoDAO antecedenteReumatologicoDAO = this.xAntecedenteReumatologicoDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<AntecedenteReumatologicoDTO> list = antecedenteReumatologicoDAO.listAnteReumatologico(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXId()), x, 0);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXId_Atencion()), x, 1);
            this.xmodelo.setValueAt(list.get(x).getXFechaAtencion(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getXFechaR(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getXFInicio()), x, 4);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getXFDiagnostico()), x, 5);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getXFTratamiento()), x, 6);
            if (list.get(x).getXHta() == 1) {
                this.xmodelo.setValueAt(true, x, 7);
            } else {
                this.xmodelo.setValueAt(false, x, 7);
            }
            if (list.get(x).getXDm() == 1) {
                this.xmodelo.setValueAt(true, x, 8);
            } else {
                this.xmodelo.setValueAt(false, x, 8);
            }
            if (list.get(x).getXEcv() == 1) {
                this.xmodelo.setValueAt(true, x, 9);
            } else {
                this.xmodelo.setValueAt(false, x, 9);
            }
            if (list.get(x).getXErc() == 1) {
                this.xmodelo.setValueAt(true, x, 10);
            } else {
                this.xmodelo.setValueAt(false, x, 10);
            }
            if (list.get(x).getXOsteo() == 1) {
                this.xmodelo.setValueAt(true, x, 11);
            } else {
                this.xmodelo.setValueAt(false, x, 11);
            }
            if (list.get(x).getXSs() == 1) {
                this.xmodelo.setValueAt(true, x, 12);
            } else {
                this.xmodelo.setValueAt(false, x, 12);
            }
            this.xmodelo.setValueAt(list.get(x).getXId_Especialidad(), x, 13);
            this.xmodelo.setValueAt(list.get(x).getXId_Profesional(), x, 14);
            if (list.get(x).getXEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 15);
            } else {
                this.xmodelo.setValueAt(false, x, 15);
            }
        }
    }

    public void mGrabar() {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar", "Grabar Información Antecedentes Reumatología @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
            if (this.lblRegistro.getText().equals("")) {
                this.xAntecedenteReumatologicoDTO.setXId_Atencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xAntecedenteReumatologicoDTO.setXId_Usuario(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue());
                this.xAntecedenteReumatologicoDTO.setXFechaR(this.xmetodo.formatoAMD1.format(this.jdchFecha.getDate()));
                this.xAntecedenteReumatologicoDTO.setXFInicio(this.jychFInicio.getYear());
                this.xAntecedenteReumatologicoDTO.setXFDiagnostico(this.jychFDiagnostico.getYear());
                this.xAntecedenteReumatologicoDTO.setXFTratamiento(this.jychFTratamiento.getYear());
                this.xAntecedenteReumatologicoDTO.setXHta(this.xHta);
                this.xAntecedenteReumatologicoDTO.setXDm(this.xDm);
                this.xAntecedenteReumatologicoDTO.setXEcv(this.xEcv);
                this.xAntecedenteReumatologicoDTO.setXErc(this.xErc);
                this.xAntecedenteReumatologicoDTO.setXOsteo(this.xOsteo);
                this.xAntecedenteReumatologicoDTO.setXSs(this.xSs);
                this.xAntecedenteReumatologicoDTO.setXId_Especialidad(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
                this.xAntecedenteReumatologicoDTO.setXId_Profesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                this.xAntecedenteReumatologicoDTO.setXEstado(this.xEstado);
                String xIdFono = this.xAntecedenteReumatologicoDAO.mCreate(this.xAntecedenteReumatologicoDTO);
                this.lblRegistro.setText(xIdFono);
            } else {
                this.xAntecedenteReumatologicoDTO.setXId(Integer.parseInt(this.lblRegistro.getText()));
                this.xAntecedenteReumatologicoDTO.setXEstado(this.xEstado);
                this.xAntecedenteReumatologicoDAO.mUpdate(this.xAntecedenteReumatologicoDTO);
            }
        }
        mCargarDatosTabla();
    }

    private void mCargarComboEspecialidad() {
    }

    private void mNuevo() {
        this.jdchFecha.setDate(this.xmetodo.getFechaActual());
        this.jychFInicio.setYear(2017);
        this.jychFDiagnostico.setYear(2017);
        this.jychFTratamiento.setYear(2017);
        this.jchDm.setSelected(false);
        this.jchEcv.setSelected(false);
        this.jchErc.setSelected(false);
        this.jchOsteo.setSelected(false);
        this.jchSs.setSelected(false);
        this.jchHta.setSelected(false);
        this.xEstado = 1;
        this.xHta = 0;
        this.xDm = 0;
        this.xEcv = 0;
        this.xErc = 0;
        this.xOsteo = 0;
        this.xSs = 0;
        this.lblRegistro.setText("");
        mCargarComboEspecialidad();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jdchFecha = new JDateChooser();
        this.jchHta = new JCheckBox();
        this.jchDm = new JCheckBox();
        this.jchEcv = new JCheckBox();
        this.jchErc = new JCheckBox();
        this.jchOsteo = new JCheckBox();
        this.jchSs = new JCheckBox();
        this.jychFInicio = new JYearChooser();
        this.jychFDiagnostico = new JYearChooser();
        this.jychFTratamiento = new JYearChooser();
        this.jbtnGuardar = new JButton();
        this.lblRegistro = new JLabel();
        this.JBTNuevo = new JButton();
        this.jspHistorico = new JScrollPane();
        this.jtHistorico = new JTable();
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "ANTECEDENTES REUMATOLOGICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jdchFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jdchFecha.setToolTipText("Fecha que inició la enfermedad");
        this.jdchFecha.setDateFormatString("dd/MM/yyyy");
        this.jdchFecha.setFont(new Font("Arial", 1, 12));
        this.jdchFecha.setMaxSelectableDate(new Date(253370786463000L));
        this.jdchFecha.setName("cboMenarquia");
        this.jchHta.setFont(new Font("Arial", 1, 12));
        this.jchHta.setForeground(Color.blue);
        this.jchHta.setText("HTA");
        this.jchHta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.2
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchHtaActionPerformed(evt);
            }
        });
        this.jchDm.setFont(new Font("Arial", 1, 12));
        this.jchDm.setForeground(Color.blue);
        this.jchDm.setText("DM");
        this.jchDm.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchDmActionPerformed(evt);
            }
        });
        this.jchEcv.setFont(new Font("Arial", 1, 12));
        this.jchEcv.setForeground(Color.blue);
        this.jchEcv.setText("ECV");
        this.jchEcv.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.4
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchEcvActionPerformed(evt);
            }
        });
        this.jchErc.setFont(new Font("Arial", 1, 12));
        this.jchErc.setForeground(Color.blue);
        this.jchErc.setText("ERC");
        this.jchErc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.5
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchErcActionPerformed(evt);
            }
        });
        this.jchOsteo.setFont(new Font("Arial", 1, 12));
        this.jchOsteo.setForeground(Color.blue);
        this.jchOsteo.setText("OSTEOPORÓSIS");
        this.jchOsteo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.6
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchOsteoActionPerformed(evt);
            }
        });
        this.jchSs.setFont(new Font("Arial", 1, 12));
        this.jchSs.setForeground(Color.blue);
        this.jchSs.setText("SINDROME DE SJOGREN");
        this.jchSs.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.7
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jchSsActionPerformed(evt);
            }
        });
        this.jychFInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Año Inicio Sintomas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jychFInicio.setToolTipText("Año en que inicio la enfermdad");
        this.jychFDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Año Diagnóstico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jychFDiagnostico.setToolTipText("Año diagnóstico de la enfermedad");
        this.jychFTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Año Tratamiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jychFTratamiento.setToolTipText("Año en tratamiento de la enfermedad");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jdchFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jychFInicio, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jychFDiagnostico, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jychFTratamiento, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 70, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jchHta).addComponent(this.jchDm)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jchEcv).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jchOsteo)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jchErc).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jchSs, -2, 177, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jdchFecha, -2, 50, -2).addComponent(this.jychFDiagnostico, -2, 50, -2).addComponent(this.jychFTratamiento, -2, 50, -2).addComponent(this.jychFInicio, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jchHta).addComponent(this.jchEcv).addComponent(this.jchOsteo)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jchDm).addComponent(this.jchErc).addComponent(this.jchSs)))).addGap(10, 10, 10)));
        this.jbtnGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jbtnGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.jbtnGuardarActionPerformed(evt);
            }
        });
        this.lblRegistro.setFont(new Font("Arial", 1, 18));
        this.lblRegistro.setForeground(Color.red);
        this.lblRegistro.setHorizontalAlignment(0);
        this.lblRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registro", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTNuevo.setText("Limpiar");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteReumatologia.this.JBTNuevoActionPerformed(evt);
            }
        });
        this.jspHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jtHistorico.setAutoCreateRowSorter(true);
        this.jtHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jtHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAAntecedenteReumatologia.10
            public void mouseClicked(MouseEvent evt) {
                JPAAntecedenteReumatologia.this.jtHistoricoMouseClicked(evt);
            }
        });
        this.jspHistorico.setViewportView(this.jtHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jspHistorico).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.lblRegistro, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTNuevo, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jbtnGuardar, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTNuevo, -2, 58, -2).addComponent(this.lblRegistro, -2, 58, -2).addComponent(this.jbtnGuardar, -2, 58, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jspHistorico, -1, 314, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchHtaActionPerformed(ActionEvent evt) {
        if (this.jchHta.isSelected()) {
            this.xHta = 1;
        } else {
            this.xHta = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jbtnGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchDmActionPerformed(ActionEvent evt) {
        if (this.jchDm.isSelected()) {
            this.xDm = 1;
        } else {
            this.xDm = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchEcvActionPerformed(ActionEvent evt) {
        if (this.jchEcv.isSelected()) {
            this.xEcv = 1;
        } else {
            this.xEcv = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchErcActionPerformed(ActionEvent evt) {
        if (this.jchErc.isSelected()) {
            this.xErc = 1;
        } else {
            this.xErc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchOsteoActionPerformed(ActionEvent evt) {
        if (this.jchOsteo.isSelected()) {
            this.xOsteo = 1;
        } else {
            this.xOsteo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtHistoricoMouseClicked(MouseEvent evt) {
        if (this.jtHistorico.getSelectedRow() != -1) {
            this.lblRegistro.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 0).toString());
            this.jdchFecha.setDateFormatString(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 3).toString());
            this.jychFInicio.setYear(Integer.parseInt(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 4).toString()));
            this.jychFDiagnostico.setYear(Integer.parseInt(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 5).toString()));
            this.jychFTratamiento.setYear(Integer.parseInt(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 6).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 7).toString()).booleanValue()) {
                this.jchHta.setSelected(true);
                this.xHta = 1;
            } else {
                this.jchHta.setSelected(false);
                this.xHta = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 8).toString()).booleanValue()) {
                this.jchDm.setSelected(true);
                this.xDm = 1;
            } else {
                this.jchDm.setSelected(false);
                this.xDm = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 9).toString()).booleanValue()) {
                this.jchEcv.setSelected(true);
                this.xEcv = 1;
            } else {
                this.jchEcv.setSelected(false);
                this.xEcv = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 10).toString()).booleanValue()) {
                this.jchErc.setSelected(true);
                this.xErc = 1;
            } else {
                this.jchErc.setSelected(false);
                this.xErc = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 11).toString()).booleanValue()) {
                this.jchOsteo.setSelected(true);
                this.xOsteo = 1;
            } else {
                this.jchOsteo.setSelected(false);
                this.xOsteo = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 12).toString()).booleanValue()) {
                this.jchSs.setSelected(true);
                this.xSs = 1;
            } else {
                this.jchSs.setSelected(false);
                this.xSs = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchSsActionPerformed(ActionEvent evt) {
        if (this.jchSs.isSelected()) {
            this.xSs = 1;
        } else {
            this.xSs = 0;
        }
    }
}
