package com.genoma.plus.controller.sgc;

import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dao.sgc.SC_EventoAdversoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_ConsultarPanoramaEventoDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFConsultarPanoramaEventoAdverso.class */
public class JIFConsultarPanoramaEventoAdverso extends JInternalFrame {
    private InformesSgcDAO xInformesSgcDAO;
    private SC_EventoAdversoDAO xSC_EventoAdversoDAO;
    private Metodos xmt = new Metodos();
    private String[] xIdRiesgo;
    private String[] xidTipoProceso;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private boolean xLleno;
    private boolean xLleno1;
    private JButton JBTExportar;
    private JComboBox JCBTipoProceso;
    private JComboBox JCBTipoRiesgoE;
    private JCheckBox JCHFiltro;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JIFConsultarPanoramaEventoAdverso() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xInformesSgcDAO = (InformesSgcDAOImpl) classPathXmlApplicationContext.getBean("informesSgcDAO");
        this.xSC_EventoAdversoDAO = (SC_EventoAdversoDAOImpl) classPathXmlApplicationContext.getBean("sCEventoAdversoDAO");
    }

    public void mBuscar() {
        if (!this.JCHFiltro.isSelected()) {
            if (this.JCBTipoProceso.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        if (this.JCBTipoProceso.getSelectedIndex() != -1) {
            if (this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
                mCargarDatosTabla();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mImprimir() {
        int n = JOptionPane.showConfirmDialog(this, "Desea Visualizar el Panorama", "Consultar", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (!this.JCHFiltro.isSelected()) {
                if (this.JCBTipoProceso.getSelectedIndex() != -1) {
                    String[][] parametros = new String[3][2];
                    parametros[0][0] = "IdTipoProceso";
                    parametros[0][1] = this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()];
                    parametros[1][0] = "SUBREPORT_DIR";
                    parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros[2][0] = "SUBREPORTFIRMA_DIR";
                    parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Sgc_Panorama_Eventos_Proceso", parametros);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            if (this.JCBTipoProceso.getSelectedIndex() != -1) {
                if (this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
                    String[][] parametros2 = new String[4][2];
                    parametros2[0][0] = "IdTipoProceso";
                    parametros2[1][0] = "IdTipoEvento";
                    parametros2[0][1] = this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()];
                    parametros2[1][1] = this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()];
                    parametros2[2][0] = "SUBREPORT_DIR";
                    parametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    parametros2[3][0] = "SUBREPORTFIRMA_DIR";
                    parametros2[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Sgc_Panorama_Eventos", parametros2);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    public void mNuevo() {
        this.xLleno = false;
        this.JCBTipoProceso.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        List<GCGenericoDTO> list1 = this.xSC_EventoAdversoDAO.listaTProceso();
        this.xidTipoProceso = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTipoProceso[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoProceso.addItem(list1.get(x).getNombre());
        }
        this.JCBTipoProceso.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoProceso.setSelectedIndex(-1);
        this.xLleno = true;
        this.JCBTipoRiesgoE.removeAllItems();
        mModelo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Proceso", "Riesgo", "Evento", "Consecuencias", "Accion Inmediata", "Accion Correctiva"}) { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        List<SGC_ConsultarPanoramaEventoDTO> list;
        mModelo();
        if (!this.JCHFiltro.isSelected()) {
            list = this.xInformesSgcDAO.listPanoramaProceso(this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()]);
        } else {
            list = this.xInformesSgcDAO.listPanoramaEvento(this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()], this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()]);
        }
        for (int x = 0; x < list.size(); x++) {
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 5);
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getNProceso(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNRiesgo(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNEvento(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNConsecuencias(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getNAccionInmediata(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getNAccionCorrectiva(), x, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPInformacion = new JPanel();
        this.JCBTipoProceso = new JComboBox();
        this.JCBTipoRiesgoE = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR PANORAMA DE EVENTOS ADVERSOS");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarpanoramaeventos");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.2
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACÍON", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProceso.setPreferredSize((Dimension) null);
        this.JCBTipoProceso.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.4
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JCBTipoProcesoItemStateChanged(evt);
            }
        });
        this.JCBTipoRiesgoE.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRiesgoE.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Evento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRiesgoE.setEnabled(false);
        this.JCBTipoRiesgoE.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.5
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JCBTipoRiesgoEItemStateChanged(evt);
            }
        });
        this.JCBTipoRiesgoE.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JCBTipoRiesgoEActionPerformed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtrar?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFConsultarPanoramaEventoAdverso.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPanoramaEventoAdverso.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoProceso, 0, -1, 32767).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JCBTipoRiesgoE, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro))).addGap(10, 10, 10)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCBTipoProceso, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoRiesgoE, -2, -1, -2).addComponent(this.JCHFiltro)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 992, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 171, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 309, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoProcesoItemStateChanged(ItemEvent evt) {
        boolean z = this.JCBTipoProceso.getSelectedIndex() != -1;
        this.xLleno = z;
        if (z) {
            this.xLleno1 = false;
            this.JCBTipoRiesgoE.removeAllItems();
            List<GCGenericoDTO> list1 = this.xSC_EventoAdversoDAO.listaTRiesgo(this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()]);
            this.xIdRiesgo = new String[list1.size()];
            for (int x = 0; x < list1.size(); x++) {
                this.xIdRiesgo[x] = String.valueOf(list1.get(x).getId());
                this.JCBTipoRiesgoE.addItem(list1.get(x).getNombre());
            }
            this.JCBTipoRiesgoE.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            this.JCBTipoRiesgoE.setSelectedIndex(-1);
            this.xLleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoRiesgoEItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoRiesgoEActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCBTipoRiesgoE.setEnabled(true);
        } else {
            this.JCBTipoRiesgoE.setEnabled(false);
        }
        this.JCBTipoRiesgoE.setSelectedIndex(-1);
    }
}
