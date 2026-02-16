package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.TipoConsentimientoDAO;
import com.genoma.plus.dao.impl.general.TipoConsentimientoDAOImpl;
import com.genoma.plus.dto.general.InfoCalidadReportes;
import com.genoma.plus.dto.general.TipoConcentimientoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoConsentimiento.class */
public class JIFTipoConsentimiento extends JInternalFrame {
    private String[] xidClasificacion;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private TipoConsentimientoDAO xTipoConsentimientoDAO;
    private InfoCalidadReportes calidadReportes;
    List<TipoConcentimientoDTO> concentimientoDTOs;
    private JCheckBox JCHEstado;
    private JCheckBox JCHRequiereFirma;
    private JDateChooser JD_CFFechaVigencia;
    private JPanel JPICalidad;
    private JPanel JPIInfo;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPEncabezado;
    private JScrollPane JSPNota;
    private JScrollPane JSPPiePagina;
    private JScrollPane JSP_CPiePagina;
    private JTextArea JTAEncabezado;
    private JTextArea JTANota;
    private JTextArea JTAPiePagina;
    private JTextArea JTA_CPiePagina;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTF_CCodigo;
    private JTextField JTF_CProceso;
    private JTextField JTF_CVersion;
    private JTabbedPane JTPMenu;
    private JTabbedPane JTP_InfoDatos;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();

    public JIFTipoConsentimiento() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoConsentimientoDAO = (TipoConsentimientoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoConsentimientoDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFNombre.setText("");
        this.JTAEncabezado.setText("");
        this.JTANota.setText("");
        this.JTAPiePagina.setText("");
        this.JTF_CProceso.setText("");
        this.JTF_CVersion.setText("");
        this.JTF_CCodigo.setText("");
        this.JD_CFFechaVigencia.setDate(this.xmt.getFechaActual());
        this.JTA_CPiePagina.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mCargarDatosTabla();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.calidadReportes = InfoCalidadReportes.builder().build();
                this.calidadReportes.setNombreProceso(this.JTF_CProceso.getText());
                this.calidadReportes.setPiePagina(this.JTA_CPiePagina.getText());
                this.calidadReportes.setVersion(this.JTF_CVersion.getText());
                this.calidadReportes.setCodigo(this.JTF_CCodigo.getText());
                this.calidadReportes.setVigencia(this.xmt.formatoAMD.format(this.JD_CFFechaVigencia.getDate()));
                TipoConcentimientoDTO e = new TipoConcentimientoDTO();
                e.setInfoCalidadReportes(this.calidadReportes);
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText());
                    e.setEncabezado(this.JTAEncabezado.getText());
                    e.setNota(this.JTANota.getText());
                    e.setPiePagina(this.JTAPiePagina.getText());
                    e.setEstado(this.xEstado);
                    e.setRequiereFirma(Boolean.valueOf(this.JCHRequiereFirma.isSelected()));
                    this.xTipoConsentimientoDAO.mCreatetipoConcentimiento(e);
                } else {
                    e.setNombre(this.JTFNombre.getText());
                    e.setEncabezado(this.JTAEncabezado.getText());
                    e.setNota(this.JTANota.getText());
                    e.setPiePagina(this.JTAPiePagina.getText());
                    e.setEstado(this.xEstado);
                    e.setId(Long.parseLong(Principal.txtNo.getText()));
                    e.setRequiereFirma(Boolean.valueOf(this.JCHRequiereFirma.isSelected()));
                    this.xTipoConsentimientoDAO.mUpdatetipoConcentimiento(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Encabezado", "Nota", "Pie de Pagina", "Estado", "Requiere Firma"}) { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.concentimientoDTOs = new ArrayList();
        this.concentimientoDTOs = this.xTipoConsentimientoDAO.listTipoConcentimiento();
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        for (int x = 0; x < this.concentimientoDTOs.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(this.concentimientoDTOs.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(this.concentimientoDTOs.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(this.concentimientoDTOs.get(x).getEncabezado(), x, 2);
            this.xmodelo.setValueAt(this.concentimientoDTOs.get(x).getNota(), x, 3);
            this.xmodelo.setValueAt(this.concentimientoDTOs.get(x).getPiePagina(), x, 4);
            this.xmodelo.setValueAt(this.concentimientoDTOs.get(x).getRequiereFirma(), x, 6);
            if (this.concentimientoDTOs.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v81, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPMenu = new JTabbedPane();
        this.JPInformacion = new JPanel();
        this.JTP_InfoDatos = new JTabbedPane();
        this.JPIInfo = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPEncabezado = new JScrollPane();
        this.JTAEncabezado = new JTextArea();
        this.JSPNota = new JScrollPane();
        this.JTANota = new JTextArea();
        this.JSPPiePagina = new JScrollPane();
        this.JTAPiePagina = new JTextArea();
        this.JCHEstado = new JCheckBox();
        this.JPICalidad = new JPanel();
        this.JTF_CProceso = new JTextField();
        this.JTF_CCodigo = new JTextField();
        this.JTF_CVersion = new JTextField();
        this.JD_CFFechaVigencia = new JDateChooser();
        this.JSP_CPiePagina = new JScrollPane();
        this.JTA_CPiePagina = new JTextArea();
        this.JCHRequiereFirma = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CONSENTIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipoconcentimiento");
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTP_InfoDatos.setForeground(new Color(0, 103, 0));
        this.JTP_InfoDatos.setFont(new Font("Arial", 1, 14));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setPreferredSize((Dimension) null);
        this.JSPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAEncabezado.setColumns(20);
        this.JTAEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTAEncabezado.setRows(5);
        this.JTAEncabezado.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.2
            public void keyPressed(KeyEvent evt) {
                JIFTipoConsentimiento.this.JTAEncabezadoKeyPressed(evt);
            }
        });
        this.JSPEncabezado.setViewportView(this.JTAEncabezado);
        this.JSPNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTANota.setColumns(20);
        this.JTANota.setFont(new Font("Arial", 1, 12));
        this.JTANota.setRows(5);
        this.JTANota.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.3
            public void keyPressed(KeyEvent evt) {
                JIFTipoConsentimiento.this.JTANotaKeyPressed(evt);
            }
        });
        this.JSPNota.setViewportView(this.JTANota);
        this.JSPPiePagina.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Pagina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAPiePagina.setColumns(20);
        this.JTAPiePagina.setFont(new Font("Arial", 1, 12));
        this.JTAPiePagina.setRows(5);
        this.JTAPiePagina.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.4
            public void keyPressed(KeyEvent evt) {
                JIFTipoConsentimiento.this.JTAPiePaginaKeyPressed(evt);
            }
        });
        this.JSPPiePagina.setViewportView(this.JTAPiePagina);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.setPreferredSize((Dimension) null);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.5
            public void actionPerformed(ActionEvent evt) {
                JIFTipoConsentimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIInfoLayout = new GroupLayout(this.JPIInfo);
        this.JPIInfo.setLayout(JPIInfoLayout);
        JPIInfoLayout.setHorizontalGroup(JPIInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInfoLayout.createSequentialGroup().addComponent(this.JTFNombre, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado, -2, -1, -2)).addComponent(this.JSPEncabezado, -1, 626, 32767).addComponent(this.JSPNota, -1, 626, 32767).addComponent(this.JSPPiePagina, -2, 0, 32767));
        JPIInfoLayout.setVerticalGroup(JPIInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIInfoLayout.createSequentialGroup().addContainerGap().addGroup(JPIInfoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, 51, -2).addGroup(JPIInfoLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHEstado, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEncabezado, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNota, -1, 134, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPiePagina, -2, -1, -2).addContainerGap()));
        this.JTP_InfoDatos.addTab("INFORMACIÓN", this.JPIInfo);
        this.JTF_CProceso.setFont(new Font("Arial", 1, 12));
        this.JTF_CProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CProceso.setPreferredSize((Dimension) null);
        this.JTF_CCodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_CCodigo.setActionCommand("<Not Set>");
        this.JTF_CCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CCodigo.setPreferredSize((Dimension) null);
        this.JTF_CVersion.setFont(new Font("Arial", 1, 12));
        this.JTF_CVersion.setActionCommand("<Not Set>");
        this.JTF_CVersion.setBorder(BorderFactory.createTitledBorder((Border) null, "Versión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_CVersion.setPreferredSize((Dimension) null);
        this.JD_CFFechaVigencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Vigencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JD_CFFechaVigencia.setDateFormatString("dd/MM/yyyy");
        this.JD_CFFechaVigencia.setFont(new Font("Arial", 1, 12));
        this.JD_CFFechaVigencia.setMaxSelectableDate(new Date(253370786462000L));
        this.JSP_CPiePagina.setBorder(BorderFactory.createTitledBorder((Border) null, "Pie de Pagina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTA_CPiePagina.setColumns(20);
        this.JTA_CPiePagina.setFont(new Font("Arial", 1, 12));
        this.JTA_CPiePagina.setRows(5);
        this.JSP_CPiePagina.setViewportView(this.JTA_CPiePagina);
        this.JCHRequiereFirma.setFont(new Font("Arial", 1, 12));
        this.JCHRequiereFirma.setSelected(true);
        this.JCHRequiereFirma.setText("Requiere visualizacioón de firma?");
        GroupLayout JPICalidadLayout = new GroupLayout(this.JPICalidad);
        this.JPICalidad.setLayout(JPICalidadLayout);
        JPICalidadLayout.setHorizontalGroup(JPICalidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICalidadLayout.createSequentialGroup().addContainerGap().addGroup(JPICalidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTF_CProceso, -1, -1, 32767).addGroup(JPICalidadLayout.createSequentialGroup().addComponent(this.JTF_CCodigo, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JTF_CVersion, -2, 195, -2).addGap(18, 18, 18).addComponent(this.JD_CFFechaVigencia, -2, 173, -2)).addComponent(this.JSP_CPiePagina, -1, 614, 32767).addGroup(JPICalidadLayout.createSequentialGroup().addComponent(this.JCHRequiereFirma, -2, 257, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPICalidadLayout.setVerticalGroup(JPICalidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICalidadLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTF_CProceso, -2, 51, -2).addGap(19, 19, 19).addGroup(JPICalidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JD_CFFechaVigencia, -2, 50, -2).addGroup(JPICalidadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_CVersion, -2, 51, -2).addComponent(this.JTF_CCodigo, -2, 51, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_CPiePagina, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHRequiereFirma).addContainerGap(137, 32767)));
        this.JTP_InfoDatos.addTab("CALIDAD", this.JPICalidad);
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTP_InfoDatos, -2, 626, -2).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTP_InfoDatos, -2, 442, -2).addContainerGap(-1, 32767)));
        this.JTPMenu.addTab("DATOS", this.JPInformacion);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoConsentimiento.6
            public void mouseClicked(MouseEvent evt) {
                JIFTipoConsentimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPMenu.addTab("HISTORICO", this.JSPDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMenu).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMenu, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAEncabezadoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTANotaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAPiePaginaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            try {
                Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                this.JTAEncabezado.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.JTANota.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.JTAPiePagina.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
                this.JCHRequiereFirma.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
                if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString())) {
                    this.xEstado = 1;
                    this.JCHEstado.setSelected(true);
                } else {
                    this.xEstado = 0;
                    this.JCHEstado.setSelected(false);
                }
                if (this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes() != null) {
                    this.JTF_CProceso.setText(this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes().getNombreProceso());
                    this.JTF_CVersion.setText(this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes().getVersion());
                    this.JTF_CCodigo.setText(this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes().getCodigo());
                    this.JD_CFFechaVigencia.setDate(this.xmt.formatoAMD.parse(this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes().getVigencia()));
                    this.JTA_CPiePagina.setText(this.concentimientoDTOs.get(this.JTDetalle.getSelectedRow()).getInfoCalidadReportes().getPiePagina());
                }
                this.JTPMenu.setSelectedIndex(0);
            } catch (ParseException ex) {
                Logger.getLogger(JIFTipoConsentimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
