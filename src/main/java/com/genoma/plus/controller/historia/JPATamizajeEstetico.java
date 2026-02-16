package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.TamizajeEsteticoDAO;
import com.genoma.plus.dao.impl.historia.TamizajeEsteticoDAOImpl;
import com.genoma.plus.dto.historia.TamizajeEsteticoDTO;
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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPATamizajeEstetico.class */
public class JPATamizajeEstetico extends JPanel {
    private TamizajeEsteticoDAO xTamizajeEsteticoDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private final clasesHistoriaCE xClaseHC;
    private JButton JBTGuardar;
    private JButton JBTNuevo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JCheckBox jchCelulitis;
    private JCheckBox jchEstado;
    private JCheckBox jchEstria;
    private JCheckBox jchFlacidez;
    private JSpinner jspAbdomenA;
    private JSpinner jspAbdomenB;
    private JSpinner jspAbdomenM;
    private JSpinner jspBrazoD;
    private JSpinner jspBrazoI;
    private JSpinner jspCadera;
    private JSpinner jspCintura;
    private JSpinner jspGluteoD;
    private JSpinner jspGluteoI;
    private JSpinner jspMusloD;
    private JSpinner jspMusloI;
    private JSpinner jspTorax;
    private JTable jtHistorico;
    private JTextArea jtaObservacion;
    private JLabel lblRegistro;
    private Metodos xmt = new Metodos();
    private final TamizajeEsteticoDTO xTamizajeEsteticoDTO = new TamizajeEsteticoDTO();
    private int xEstado = 1;
    private int xEstrias = 0;
    private int xCelulitis = 0;
    private int xFlacidez = 0;

    public JPATamizajeEstetico(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mNuevo();
    }

    private void springStart() {
        this.xTamizajeEsteticoDAO = (TamizajeEsteticoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tamizajeEsteticoDAO");
    }

    private void mNuevo() {
        this.jspBrazoD.setValue(0);
        this.jspBrazoI.setValue(0);
        this.jspGluteoD.setValue(0);
        this.jspGluteoD.setValue(0);
        this.jspMusloD.setValue(0);
        this.jspMusloI.setValue(0);
        this.jspAbdomenA.setValue(0);
        this.jspAbdomenM.setValue(0);
        this.jspAbdomenB.setValue(0);
        this.jspTorax.setValue(0);
        this.jspCadera.setValue(0);
        this.jspCintura.setValue(0);
        this.jchEstria.setSelected(false);
        this.jchCelulitis.setSelected(false);
        this.jchFlacidez.setSelected(false);
        this.jchEstado.setSelected(true);
        this.xEstrias = 0;
        this.xCelulitis = 0;
        this.xFlacidez = 0;
        this.xEstado = 1;
        this.lblRegistro.setText("");
        this.jtaObservacion.setText("");
        mCargarDatosTabla();
    }

    private void mGrabar() {
        if (JOptionPane.showConfirmDialog((Component) null, "Seguro que desea grabar", "Grabar Información Tamizaje Estético @GenomaPlus", 1, 3, new ImageIcon("src/Imagenes/Question2.png")) == 0) {
            if (this.lblRegistro.getText().equals("")) {
                this.xTamizajeEsteticoDTO.setXId_Atencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xTamizajeEsteticoDTO.setXBrazoD(Double.valueOf(this.jspBrazoD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXBrazoI(Double.valueOf(this.jspBrazoI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXGluteoD(Double.valueOf(this.jspGluteoD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXGluteoI(Double.valueOf(this.jspGluteoI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXMusloD(Double.valueOf(this.jspMusloD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXMusloI(Double.valueOf(this.jspMusloI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXTorax(Double.valueOf(this.jspTorax.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXCintura(Double.valueOf(this.jspCintura.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXCadera(Double.valueOf(this.jspCadera.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenA(Double.valueOf(this.jspAbdomenA.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenM(Double.valueOf(this.jspAbdomenM.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenB(Double.valueOf(this.jspAbdomenB.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXEstrias(this.xEstrias);
                this.xTamizajeEsteticoDTO.setXCelulitis(this.xCelulitis);
                this.xTamizajeEsteticoDTO.setXFlacidez(this.xFlacidez);
                this.xTamizajeEsteticoDTO.setXObservacion(this.jtaObservacion.getText());
                this.xTamizajeEsteticoDTO.setXEstado(this.xEstado);
                this.xTamizajeEsteticoDTO.setXUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                String xIdTamiEst = this.xTamizajeEsteticoDAO.mCreate(this.xTamizajeEsteticoDTO);
                this.lblRegistro.setText(xIdTamiEst);
            } else {
                this.xTamizajeEsteticoDTO.setXId(Integer.parseInt(this.lblRegistro.getText()));
                this.xTamizajeEsteticoDTO.setXId_Atencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                this.xTamizajeEsteticoDTO.setXBrazoD(Double.valueOf(this.jspBrazoD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXBrazoI(Double.valueOf(this.jspBrazoI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXGluteoD(Double.valueOf(this.jspGluteoD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXGluteoI(Double.valueOf(this.jspGluteoI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXMusloD(Double.valueOf(this.jspMusloD.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXMusloI(Double.valueOf(this.jspMusloI.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXTorax(Double.valueOf(this.jspTorax.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXCintura(Double.valueOf(this.jspCintura.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXCadera(Double.valueOf(this.jspCadera.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenA(Double.valueOf(this.jspAbdomenA.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenM(Double.valueOf(this.jspAbdomenM.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXAbdomenB(Double.valueOf(this.jspAbdomenB.getValue().toString()).doubleValue());
                this.xTamizajeEsteticoDTO.setXEstrias(this.xEstrias);
                this.xTamizajeEsteticoDTO.setXCelulitis(this.xCelulitis);
                this.xTamizajeEsteticoDTO.setXFlacidez(this.xFlacidez);
                this.xTamizajeEsteticoDTO.setXObservacion(this.jtaObservacion.getText());
                this.xTamizajeEsteticoDTO.setXEstado(this.xEstado);
                this.xTamizajeEsteticoDTO.setXUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.xTamizajeEsteticoDAO.mUpdate(this.xTamizajeEsteticoDTO);
            }
            mCargarDatosTabla();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_Atención", "BrazoD", "BrazoI", "GluteoD", "GluteoI", "PiernaD", "PiernaI", "Torax", "Cintura", "Cadeta", "AbdomenA", "AbdomenM", "AbdomenB", "Estrias?", "Celulitis?", "Flacidez?", "Observación", "Estado"}) { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.jtHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(9).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(10).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(11).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(12).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(13).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(14).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(15).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(16).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(17).setPreferredWidth(20);
        this.jtHistorico.getColumnModel().getColumn(18).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        TamizajeEsteticoDAO tamizajeEsteticoDAO = this.xTamizajeEsteticoDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<TamizajeEsteticoDTO> list = tamizajeEsteticoDAO.listTamizajeEstetico(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXId()), x, 0);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getXId_Atencion()), x, 1);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXBrazoD()), x, 2);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXBrazoI()), x, 3);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXGluteoD()), x, 4);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXGluteoI()), x, 5);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXMusloD()), x, 6);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXMusloI()), x, 7);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXTorax()), x, 8);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXCintura()), x, 9);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXCadera()), x, 10);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXAbdomenA()), x, 11);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXAbdomenM()), x, 12);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getXAbdomenB()), x, 13);
            if (list.get(x).getXEstrias() == 1) {
                this.xmodelo.setValueAt(true, x, 14);
            } else {
                this.xmodelo.setValueAt(false, x, 14);
            }
            if (list.get(x).getXCelulitis() == 1) {
                this.xmodelo.setValueAt(true, x, 15);
            } else {
                this.xmodelo.setValueAt(false, x, 15);
            }
            if (list.get(x).getXFlacidez() == 1) {
                this.xmodelo.setValueAt(true, x, 16);
            } else {
                this.xmodelo.setValueAt(false, x, 16);
            }
            this.xmodelo.setValueAt(list.get(x).getXObservacion(), x, 17);
            if (list.get(x).getXEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 18);
            } else {
                this.xmodelo.setValueAt(false, x, 18);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v98, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jspAbdomenA = new JSpinner();
        this.jspAbdomenM = new JSpinner();
        this.jspAbdomenB = new JSpinner();
        this.jScrollPane1 = new JScrollPane();
        this.jtaObservacion = new JTextArea();
        this.jchEstria = new JCheckBox();
        this.jchCelulitis = new JCheckBox();
        this.jchFlacidez = new JCheckBox();
        this.jchEstado = new JCheckBox();
        this.jspBrazoD = new JSpinner();
        this.jspBrazoI = new JSpinner();
        this.jspGluteoD = new JSpinner();
        this.jspGluteoI = new JSpinner();
        this.jspMusloD = new JSpinner();
        this.jspMusloI = new JSpinner();
        this.jspTorax = new JSpinner();
        this.jspCintura = new JSpinner();
        this.jspCadera = new JSpinner();
        this.jScrollPane2 = new JScrollPane();
        this.jtHistorico = new JTable();
        this.JBTNuevo = new JButton();
        this.JBTGuardar = new JButton();
        this.lblRegistro = new JLabel();
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Derecha");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Izquierda");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Brazo");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Pierna");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Gluteos");
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Abdomen", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspAbdomenA.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(-1.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspAbdomenA.setBorder(BorderFactory.createTitledBorder((Border) null, "Alto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspAbdomenM.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(-1.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspAbdomenM.setBorder(BorderFactory.createTitledBorder((Border) null, "Medio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspAbdomenB.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(-1.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspAbdomenB.setBorder(BorderFactory.createTitledBorder((Border) null, "Bajo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jspAbdomenA, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jspAbdomenM, -2, 100, -2).addGap(18, 18, 18).addComponent(this.jspAbdomenB, -2, 100, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jspAbdomenA, -2, 40, -2).addComponent(this.jspAbdomenM, -2, 40, -2).addComponent(this.jspAbdomenB, -2, 40, -2)).addContainerGap()));
        this.jtaObservacion.setColumns(20);
        this.jtaObservacion.setRows(5);
        this.jtaObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.jtaObservacion);
        this.jchEstria.setFont(new Font("Arial", 1, 12));
        this.jchEstria.setText("Estrias");
        this.jchEstria.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.2
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.jchEstriaActionPerformed(evt);
            }
        });
        this.jchCelulitis.setFont(new Font("Arial", 1, 12));
        this.jchCelulitis.setText("Celulitis");
        this.jchCelulitis.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.3
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.jchCelulitisActionPerformed(evt);
            }
        });
        this.jchFlacidez.setFont(new Font("Arial", 1, 12));
        this.jchFlacidez.setText("Flacidez");
        this.jchFlacidez.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.4
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.jchFlacidezActionPerformed(evt);
            }
        });
        this.jchEstado.setFont(new Font("Arial", 1, 12));
        this.jchEstado.setForeground(Color.blue);
        this.jchEstado.setSelected(true);
        this.jchEstado.setText("Estado");
        this.jchEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.5
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.jchEstadoActionPerformed(evt);
            }
        });
        this.jspBrazoD.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspBrazoD.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspBrazoI.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspBrazoI.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspGluteoD.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspGluteoD.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspGluteoI.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspGluteoI.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspMusloD.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspMusloD.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspMusloI.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspMusloI.setBorder(BorderFactory.createTitledBorder((Border) null, "cm", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspTorax.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspTorax.setBorder(BorderFactory.createTitledBorder((Border) null, "Torax", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspCintura.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspCintura.setBorder(BorderFactory.createTitledBorder((Border) null, "Cintura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jspCadera.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), Double.valueOf(0.0d), (Comparable) null, Double.valueOf(0.1d)));
        this.jspCadera.setBorder(BorderFactory.createTitledBorder((Border) null, "Cadera", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel4, -2, 45, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING, -2, 45, -2).addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING, -2, 45, -2)))).addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(40, 40, 40).addComponent(this.jLabel2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jspMusloD, GroupLayout.Alignment.LEADING, -2, 70, -2).addComponent(this.jspBrazoD, GroupLayout.Alignment.LEADING, -2, 70, -2).addComponent(this.jspGluteoD, GroupLayout.Alignment.LEADING, -2, 70, -2)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jspBrazoI, -2, 70, -2).addComponent(this.jspGluteoI, -2, 70, -2).addComponent(this.jspMusloI, -2, 70, -2)))).addGap(1, 1, 1).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jspTorax, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jspCintura, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jspCadera, -2, 100, -2)).addComponent(this.jPanel2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jchCelulitis).addComponent(this.jchEstria).addComponent(this.jchFlacidez).addComponent(this.jchEstado)).addContainerGap(172, 32767)).addComponent(this.jScrollPane1));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jspMusloD, -2, 40, -2).addComponent(this.jspMusloI, -2, 40, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jspBrazoD, -2, 40, -2).addComponent(this.jspBrazoI, -2, 40, -2)).addGap(13, 13, 13).addComponent(this.jLabel5)).addGroup(jPanel1Layout.createSequentialGroup().addGap(45, 45, 45).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jspGluteoD, -2, 40, -2).addComponent(this.jspGluteoI, -2, 40, -2)))).addGap(30, 30, 30).addComponent(this.jLabel4))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jspCintura, -2, 40, -2).addComponent(this.jspTorax, -2, 40, -2).addComponent(this.jspCadera, -2, 40, -2))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jchEstria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jchCelulitis).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jchFlacidez).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jchEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.jScrollPane1, -2, 65, -2).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jtHistorico.setAutoCreateRowSorter(true);
        this.jtHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jtHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.6
            public void mouseClicked(MouseEvent evt) {
                JPATamizajeEstetico.this.jtHistoricoMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.jtHistorico);
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTNuevo.setText("Limpiar");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.7
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.JBTNuevoActionPerformed(evt);
            }
        });
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPATamizajeEstetico.8
            public void actionPerformed(ActionEvent evt) {
                JPATamizajeEstetico.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.lblRegistro.setFont(new Font("Arial", 1, 18));
        this.lblRegistro.setForeground(Color.red);
        this.lblRegistro.setHorizontalAlignment(0);
        this.lblRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registro", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblRegistro, -2, 158, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTNuevo, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 290, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING)).addGap(0, 0, 32767)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblRegistro, -2, 49, -2).addGap(13, 13, 13)).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGuardar, -2, 50, -2).addComponent(this.JBTNuevo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.jScrollPane2, -2, 239, -2).addGap(25, 25, 25)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchFlacidezActionPerformed(ActionEvent evt) {
        if (this.jchFlacidez.isSelected()) {
            this.xFlacidez = 1;
        } else {
            this.xFlacidez = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchEstadoActionPerformed(ActionEvent evt) {
        if (this.jchEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchEstriaActionPerformed(ActionEvent evt) {
        if (this.jchEstria.isSelected()) {
            this.xEstrias = 1;
        } else {
            this.xEstrias = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jchCelulitisActionPerformed(ActionEvent evt) {
        if (this.jchCelulitis.isSelected()) {
            this.xCelulitis = 1;
        } else {
            this.xCelulitis = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtHistoricoMouseClicked(MouseEvent evt) {
        if (this.jtHistorico.getSelectedRow() != -1) {
            this.lblRegistro.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 0).toString());
            this.jspBrazoD.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 2).toString()));
            this.jspBrazoI.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 3).toString()));
            this.jspGluteoD.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 4).toString()));
            this.jspGluteoI.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 5).toString()));
            this.jspMusloD.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 6).toString()));
            this.jspMusloI.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 7).toString()));
            this.jspTorax.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 8).toString()));
            this.jspCintura.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 9).toString()));
            this.jspCadera.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 10).toString()));
            this.jspAbdomenA.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 11).toString()));
            this.jspAbdomenM.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 12).toString()));
            this.jspAbdomenB.setValue(Double.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 13).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 14).toString()).booleanValue()) {
                this.jchEstria.setSelected(true);
                this.xEstrias = 1;
            } else {
                this.jchEstria.setSelected(false);
                this.xEstrias = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 15).toString()).booleanValue()) {
                this.jchCelulitis.setSelected(true);
                this.xCelulitis = 1;
            } else {
                this.jchCelulitis.setSelected(false);
                this.xCelulitis = 0;
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 16).toString()).booleanValue()) {
                this.jchFlacidez.setSelected(true);
                this.xFlacidez = 1;
            } else {
                this.jchFlacidez.setSelected(false);
                this.xFlacidez = 0;
            }
            this.jtaObservacion.setText(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 17).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.jtHistorico.getSelectedRow(), 18).toString()).booleanValue()) {
                this.jchEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.jchEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
    }
}
