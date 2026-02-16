package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.ClasificacionEularDAO;
import com.genoma.plus.dao.impl.historia.ClasificacionEularDAOImpl;
import com.genoma.plus.dto.historia.ClasificacionEularDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAClasificacionEular.class */
public class JPAClasificacionEular extends JPanel {
    private final clasesHistoriaCE xClaseHC;
    public DefaultTableModel xmodelo;
    private Object[] xDato;
    private ClasificacionEularDAO xClasificacionEularDAO;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTabbedPane JTPClasificacionEular;
    private ButtonGroup bgArticular;
    private ButtonGroup bgDuracion;
    private ButtonGroup bgReactante;
    private ButtonGroup bgSerologia;
    private JButton btnCalcular;
    private JPanel jpAfectacionArticular;
    private JPanel jpClasificacionEular;
    private JPanel jpDuracion;
    private JPanel jpHistorico;
    private JPanel jpReactanteFaseAguda;
    private JPanel jpSerologia;
    private JRadioButton jrbArticulacion_1;
    private JRadioButton jrbArticulacion_2;
    private JRadioButton jrbArticulacion_3;
    private JRadioButton jrbArticulacion_4;
    private JRadioButton jrbArticulacion_5;
    private JRadioButton jrbDuracion_1;
    private JRadioButton jrbDuracion_2;
    private JRadioButton jrbReactantes_1;
    private JRadioButton jrbReactantes_2;
    private JRadioButton jrbSerologia_1;
    private JRadioButton jrbSerologia_2;
    private JRadioButton jrbSerologia_3;
    private JLabel lblClasificacion;
    private JLabel lblIdAtencion;
    private JLabel lblResultado;
    private String xOpc1 = "";
    private String xOpc2 = "";
    private String xOpc3 = "";
    private String xOpc4 = "";
    private int xSuma = 0;
    private final ClasificacionEularDTO xClasificacionEularDTO = new ClasificacionEularDTO();
    private Metodos xmt = new Metodos();

    public JPAClasificacionEular(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xClasificacionEularDAO = (ClasificacionEularDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("xClasificacionEular");
    }

    public String getValueRadioButton(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getName();
            }
        }
        return null;
    }

    private void mCalculaTotal() {
        if (!this.xOpc1.equals("") && !this.xOpc2.equals("") && !this.xOpc3.equals("") && !this.xOpc4.equals("")) {
            this.xSuma = Integer.valueOf(this.xOpc1).intValue() + Integer.valueOf(this.xOpc2).intValue() + Integer.valueOf(this.xOpc3).intValue() + Integer.valueOf(this.xOpc4).intValue();
            this.lblResultado.setText(this.xSuma + "");
            if (this.xSuma >= 6) {
                this.lblClasificacion.setText("Artitris Reumatoide: SI");
            } else {
                this.lblClasificacion.setText("Artitris Reumatoide: NO");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Profesional", "Especialidad", "Fecha_Registro", "Articulación", "Serología", "Reactante", "Duración", "Resultado", "Clasificación"}) { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.1
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        ClasificacionEularDAO clasificacionEularDAO = this.xClasificacionEularDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<ClasificacionEularDTO> list = clasificacionEularDAO.listClasificacionEular(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mCrearModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getIdAtencion()), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdProfesional(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getIdEspecialidad(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getFechaRegistro(), x, 4);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getArticulacion()), x, 5);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getSerologia()), x, 6);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getReactante()), x, 7);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getDuracion()), x, 8);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getResultado()), x, 9);
            this.xmodelo.setValueAt(list.get(x).getClasificacion(), x, 10);
        }
    }

    public void mGrabar() {
        if (!mVerificar(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())) {
            if (!this.xOpc1.equals("") && !this.xOpc2.equals("") && !this.xOpc3.equals("") && !this.xOpc4.equals("")) {
                if (JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    this.xClasificacionEularDTO.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                    this.xClasificacionEularDTO.setIdUsuario(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()).intValue());
                    this.xClasificacionEularDTO.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    this.xClasificacionEularDTO.setIdEspecialidad(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
                    this.xClasificacionEularDTO.setFechaRegistro(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                    this.xClasificacionEularDTO.setArticulacion(Integer.valueOf(this.xOpc1).intValue());
                    this.xClasificacionEularDTO.setSerologia(Integer.valueOf(this.xOpc2).intValue());
                    this.xClasificacionEularDTO.setReactante(Integer.valueOf(this.xOpc3).intValue());
                    this.xClasificacionEularDTO.setDuracion(Integer.valueOf(this.xOpc4).intValue());
                    this.xClasificacionEularDTO.setResultado(this.xSuma);
                    this.xClasificacionEularDTO.setClasificacion(this.lblClasificacion.getText());
                    this.xClasificacionEularDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.xClasificacionEularDAO.mCreate(this.xClasificacionEularDTO);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el test completo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe un Test en ésta atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mNuevo() {
        this.bgArticular.clearSelection();
        this.bgDuracion.clearSelection();
        this.bgReactante.clearSelection();
        this.bgSerologia.clearSelection();
        this.lblResultado.setText("");
        this.lblClasificacion.setText("");
        this.xOpc1 = "";
        this.xOpc2 = "";
        this.xOpc3 = "";
        this.xOpc4 = "";
    }

    /* JADX WARN: Type inference failed for: r3v134, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.bgSerologia = new ButtonGroup();
        this.bgDuracion = new ButtonGroup();
        this.bgArticular = new ButtonGroup();
        this.bgReactante = new ButtonGroup();
        this.JTPClasificacionEular = new JTabbedPane();
        this.jpClasificacionEular = new JPanel();
        this.jpAfectacionArticular = new JPanel();
        this.jrbArticulacion_1 = new JRadioButton();
        this.jrbArticulacion_3 = new JRadioButton();
        this.jrbArticulacion_2 = new JRadioButton();
        this.jrbArticulacion_4 = new JRadioButton();
        this.jrbArticulacion_5 = new JRadioButton();
        this.jpSerologia = new JPanel();
        this.jrbSerologia_1 = new JRadioButton();
        this.jrbSerologia_2 = new JRadioButton();
        this.jrbSerologia_3 = new JRadioButton();
        this.jpReactanteFaseAguda = new JPanel();
        this.jrbReactantes_1 = new JRadioButton();
        this.jrbReactantes_2 = new JRadioButton();
        this.jpDuracion = new JPanel();
        this.jrbDuracion_1 = new JRadioButton();
        this.jrbDuracion_2 = new JRadioButton();
        this.btnCalcular = new JButton();
        this.lblResultado = new JLabel();
        this.lblIdAtencion = new JLabel();
        this.lblClasificacion = new JLabel();
        this.jpHistorico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("xjtpClasificacionEular");
        this.JTPClasificacionEular.setForeground(new Color(0, 102, 0));
        this.JTPClasificacionEular.setFont(new Font("Arial", 1, 14));
        this.JTPClasificacionEular.setName("");
        this.jpAfectacionArticular.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "AFECTACIÓN ARTICULAR", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.bgArticular.add(this.jrbArticulacion_1);
        this.jrbArticulacion_1.setFont(new Font("Arial", 1, 12));
        this.jrbArticulacion_1.setText("1 Articulación Grande Afectada");
        this.jrbArticulacion_1.setName("0");
        this.jrbArticulacion_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.2
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbArticulacion_1ActionPerformed(evt);
            }
        });
        this.bgArticular.add(this.jrbArticulacion_3);
        this.jrbArticulacion_3.setFont(new Font("Arial", 1, 12));
        this.jrbArticulacion_3.setText("1 - 3 Articulaciones Pequeñas Afectadas");
        this.jrbArticulacion_3.setName("2");
        this.jrbArticulacion_3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.3
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbArticulacion_3ActionPerformed(evt);
            }
        });
        this.bgArticular.add(this.jrbArticulacion_2);
        this.jrbArticulacion_2.setFont(new Font("Arial", 1, 12));
        this.jrbArticulacion_2.setText("2 - 10 Articulaciones Grandes Afectadas");
        this.jrbArticulacion_2.setName("1");
        this.jrbArticulacion_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.4
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbArticulacion_2ActionPerformed(evt);
            }
        });
        this.bgArticular.add(this.jrbArticulacion_4);
        this.jrbArticulacion_4.setFont(new Font("Arial", 1, 12));
        this.jrbArticulacion_4.setText("4 - 10 Articulaciones Pequeñas Afectadas");
        this.jrbArticulacion_4.setName("3");
        this.jrbArticulacion_4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.5
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbArticulacion_4ActionPerformed(evt);
            }
        });
        this.bgArticular.add(this.jrbArticulacion_5);
        this.jrbArticulacion_5.setFont(new Font("Arial", 1, 12));
        this.jrbArticulacion_5.setText("> 10 Articulaciones Pequeñas Afectadas");
        this.jrbArticulacion_5.setName("5");
        this.jrbArticulacion_5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.6
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbArticulacion_5ActionPerformed(evt);
            }
        });
        GroupLayout jpAfectacionArticularLayout = new GroupLayout(this.jpAfectacionArticular);
        this.jpAfectacionArticular.setLayout(jpAfectacionArticularLayout);
        jpAfectacionArticularLayout.setHorizontalGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpAfectacionArticularLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbArticulacion_5, -2, 280, -2).addComponent(this.jrbArticulacion_3, -2, 280, -2).addComponent(this.jrbArticulacion_1, -2, 280, -2)).addGap(40, 40, 40).addGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbArticulacion_2, -2, 280, -2).addComponent(this.jrbArticulacion_4, -2, 280, -2)).addContainerGap(-1, 32767)));
        jpAfectacionArticularLayout.setVerticalGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpAfectacionArticularLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbArticulacion_1).addComponent(this.jrbArticulacion_2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpAfectacionArticularLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbArticulacion_3).addComponent(this.jrbArticulacion_4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbArticulacion_5)));
        this.jpSerologia.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "SEROLOGÍA", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.bgSerologia.add(this.jrbSerologia_1);
        this.jrbSerologia_1.setFont(new Font("Arial", 1, 12));
        this.jrbSerologia_1.setText("FR y ACPA Negativos");
        this.jrbSerologia_1.setName("0");
        this.jrbSerologia_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.7
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbSerologia_1ActionPerformed(evt);
            }
        });
        this.bgSerologia.add(this.jrbSerologia_2);
        this.jrbSerologia_2.setFont(new Font("Arial", 1, 12));
        this.jrbSerologia_2.setText("FR y/o ACPA Positivos Bajos (<3 VN)");
        this.jrbSerologia_2.setName("2");
        this.jrbSerologia_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.8
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbSerologia_2ActionPerformed(evt);
            }
        });
        this.bgSerologia.add(this.jrbSerologia_3);
        this.jrbSerologia_3.setFont(new Font("Arial", 1, 12));
        this.jrbSerologia_3.setText("FR y/o ACPA Positivos Altos (>3 VN)");
        this.jrbSerologia_3.setName("3");
        this.jrbSerologia_3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.9
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbSerologia_3ActionPerformed(evt);
            }
        });
        GroupLayout jpSerologiaLayout = new GroupLayout(this.jpSerologia);
        this.jpSerologia.setLayout(jpSerologiaLayout);
        jpSerologiaLayout.setHorizontalGroup(jpSerologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpSerologiaLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(jpSerologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbSerologia_3, -2, 280, -2).addGroup(jpSerologiaLayout.createSequentialGroup().addComponent(this.jrbSerologia_1, -2, 280, -2).addGap(46, 46, 46).addComponent(this.jrbSerologia_2, -2, 280, -2))).addContainerGap(-1, 32767)));
        jpSerologiaLayout.setVerticalGroup(jpSerologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpSerologiaLayout.createSequentialGroup().addGroup(jpSerologiaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbSerologia_2).addComponent(this.jrbSerologia_1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jrbSerologia_3).addContainerGap(-1, 32767)));
        this.jpReactanteFaseAguda.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "REACTANTES FASE AGUDA", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.bgReactante.add(this.jrbReactantes_1);
        this.jrbReactantes_1.setFont(new Font("Arial", 1, 12));
        this.jrbReactantes_1.setText("VSG y PCR Normales");
        this.jrbReactantes_1.setName("0");
        this.jrbReactantes_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.10
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbReactantes_1ActionPerformed(evt);
            }
        });
        this.bgReactante.add(this.jrbReactantes_2);
        this.jrbReactantes_2.setFont(new Font("Arial", 1, 12));
        this.jrbReactantes_2.setText("VSG y/o PCR Elevadas");
        this.jrbReactantes_2.setName("1");
        this.jrbReactantes_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.11
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbReactantes_2ActionPerformed(evt);
            }
        });
        GroupLayout jpReactanteFaseAgudaLayout = new GroupLayout(this.jpReactanteFaseAguda);
        this.jpReactanteFaseAguda.setLayout(jpReactanteFaseAgudaLayout);
        jpReactanteFaseAgudaLayout.setHorizontalGroup(jpReactanteFaseAgudaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpReactanteFaseAgudaLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jrbReactantes_1, -2, 280, -2).addGap(46, 46, 46).addComponent(this.jrbReactantes_2, -2, 280, -2).addContainerGap(23, 32767)));
        jpReactanteFaseAgudaLayout.setVerticalGroup(jpReactanteFaseAgudaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpReactanteFaseAgudaLayout.createSequentialGroup().addGroup(jpReactanteFaseAgudaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbReactantes_1).addComponent(this.jrbReactantes_2)).addGap(10, 10, 10)));
        this.jpDuracion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DURACIÓN", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.bgDuracion.add(this.jrbDuracion_1);
        this.jrbDuracion_1.setFont(new Font("Arial", 1, 12));
        this.jrbDuracion_1.setText("< 6 Semanas");
        this.jrbDuracion_1.setName("0");
        this.jrbDuracion_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.12
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbDuracion_1ActionPerformed(evt);
            }
        });
        this.bgDuracion.add(this.jrbDuracion_2);
        this.jrbDuracion_2.setFont(new Font("Arial", 1, 12));
        this.jrbDuracion_2.setText(">=  6 Semanas");
        this.jrbDuracion_2.setName("1");
        this.jrbDuracion_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.13
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.jrbDuracion_2ActionPerformed(evt);
            }
        });
        GroupLayout jpDuracionLayout = new GroupLayout(this.jpDuracion);
        this.jpDuracion.setLayout(jpDuracionLayout);
        jpDuracionLayout.setHorizontalGroup(jpDuracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpDuracionLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.jrbDuracion_1, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jrbDuracion_2, -2, 280, -2).addGap(21, 21, 21)));
        jpDuracionLayout.setVerticalGroup(jpDuracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpDuracionLayout.createSequentialGroup().addContainerGap().addGroup(jpDuracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jrbDuracion_1).addComponent(this.jrbDuracion_2)).addGap(10, 10, 10)));
        this.btnCalcular.setFont(new Font("Arial", 1, 12));
        this.btnCalcular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Calcular.png")));
        this.btnCalcular.setText("Calcular");
        this.btnCalcular.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.14
            public void actionPerformed(ActionEvent evt) {
                JPAClasificacionEular.this.btnCalcularActionPerformed(evt);
            }
        });
        this.lblResultado.setFont(new Font("Arial", 1, 18));
        this.lblResultado.setForeground(Color.red);
        this.lblResultado.setHorizontalAlignment(0);
        this.lblResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.lblIdAtencion.setFont(new Font("Arial", 1, 14));
        this.lblIdAtencion.setForeground(Color.red);
        this.lblIdAtencion.setHorizontalAlignment(0);
        this.lblIdAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.lblClasificacion.setFont(new Font("Arial", 1, 18));
        this.lblClasificacion.setForeground(Color.red);
        this.lblClasificacion.setHorizontalAlignment(0);
        this.lblClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout jpClasificacionEularLayout = new GroupLayout(this.jpClasificacionEular);
        this.jpClasificacionEular.setLayout(jpClasificacionEularLayout);
        jpClasificacionEularLayout.setHorizontalGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpClasificacionEularLayout.createSequentialGroup().addGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpClasificacionEularLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jpDuracion, -1, -1, 32767).addComponent(this.jpReactanteFaseAguda, -1, -1, 32767).addComponent(this.jpSerologia, -1, -1, 32767).addComponent(this.jpAfectacionArticular, -1, -1, 32767))).addGroup(jpClasificacionEularLayout.createSequentialGroup().addContainerGap().addGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpClasificacionEularLayout.createSequentialGroup().addComponent(this.lblResultado, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblClasificacion, -1, -1, 32767)).addGroup(jpClasificacionEularLayout.createSequentialGroup().addComponent(this.btnCalcular, -2, 516, -2).addGap(18, 18, 18).addComponent(this.lblIdAtencion, -2, 120, -2))))).addContainerGap(-1, 32767)));
        jpClasificacionEularLayout.setVerticalGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpClasificacionEularLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jpAfectacionArticular, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpSerologia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpReactanteFaseAguda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpDuracion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnCalcular, -1, -1, 32767).addComponent(this.lblIdAtencion, -1, -1, 32767)).addGap(10, 10, 10).addGroup(jpClasificacionEularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblResultado, -2, 132, -2).addComponent(this.lblClasificacion, -2, 132, -2)).addGap(24, 24, 24)));
        this.JTPClasificacionEular.addTab("CLASIFICACIÓN ACR EULAR", this.jpClasificacionEular);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setColumnSelectionAllowed(true);
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAClasificacionEular.15
            public void mouseClicked(MouseEvent evt) {
                JPAClasificacionEular.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout jpHistoricoLayout = new GroupLayout(this.jpHistorico);
        this.jpHistorico.setLayout(jpHistoricoLayout);
        jpHistoricoLayout.setHorizontalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -2, 648, -2).addContainerGap(19, 32767)));
        jpHistoricoLayout.setVerticalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 598, 32767).addContainerGap()));
        this.JTPClasificacionEular.addTab("HISTÓRICO", this.jpHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTPClasificacionEular, -2, 684, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPClasificacionEular, -2, 655, -2).addGap(0, 13, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbArticulacion_3ActionPerformed(ActionEvent evt) {
        this.xOpc1 = getValueRadioButton(this.bgArticular);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbArticulacion_2ActionPerformed(ActionEvent evt) {
        this.xOpc1 = getValueRadioButton(this.bgArticular);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbArticulacion_4ActionPerformed(ActionEvent evt) {
        this.xOpc1 = getValueRadioButton(this.bgArticular);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbArticulacion_5ActionPerformed(ActionEvent evt) {
        this.xOpc1 = getValueRadioButton(this.bgArticular);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbSerologia_1ActionPerformed(ActionEvent evt) {
        this.xOpc2 = getValueRadioButton(this.bgSerologia);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbSerologia_2ActionPerformed(ActionEvent evt) {
        this.xOpc2 = getValueRadioButton(this.bgSerologia);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbSerologia_3ActionPerformed(ActionEvent evt) {
        this.xOpc2 = getValueRadioButton(this.bgSerologia);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbReactantes_1ActionPerformed(ActionEvent evt) {
        this.xOpc3 = getValueRadioButton(this.bgReactante);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbArticulacion_1ActionPerformed(ActionEvent evt) {
        this.xOpc1 = getValueRadioButton(this.bgArticular);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbReactantes_2ActionPerformed(ActionEvent evt) {
        this.xOpc3 = getValueRadioButton(this.bgReactante);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbDuracion_1ActionPerformed(ActionEvent evt) {
        this.xOpc4 = getValueRadioButton(this.bgDuracion);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbDuracion_2ActionPerformed(ActionEvent evt) {
        this.xOpc4 = getValueRadioButton(this.bgDuracion);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCalcularActionPerformed(ActionEvent evt) {
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            this.lblIdAtencion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(0)) {
                this.jrbArticulacion_1.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(1)) {
                this.jrbArticulacion_2.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(2)) {
                this.jrbArticulacion_3.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(3)) {
                this.jrbArticulacion_4.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(5)) {
                this.jrbArticulacion_5.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(0)) {
                this.jrbSerologia_1.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(2)) {
                this.jrbSerologia_2.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(3)) {
                this.jrbSerologia_3.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(0)) {
                this.jrbReactantes_1.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(1)) {
                this.jrbReactantes_2.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(0) || this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(1)) {
                this.jrbDuracion_1.setSelected(true);
            }
            this.lblResultado.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString());
            this.lblClasificacion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString());
            this.JTPClasificacionEular.setSelectedIndex(0);
        }
    }

    private boolean mVerificar(String xIdAtencion) {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTBDetalle.getRowCount()) {
                break;
            }
            if (!this.JTBDetalle.getValueAt(i, 1).toString().equals(xIdAtencion)) {
                i++;
            } else {
                xExiste = true;
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                break;
            }
        }
        return xExiste;
    }
}
