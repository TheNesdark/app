package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.CertificadoSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.CertificadoSoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.salud_ocupacional.CertificadoSoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JPCertificadoSO.class */
public class JPCertificadoSO extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private CertificadoSoDAO xCertificadoSoDAO;
    private clasesHistoriaCE xclase;
    private String[] xidTipoCertificado;
    private String[] xidTipoConcepto;
    private JComboBox JCBConcepto;
    private JComboBox JCBTipoCertificado;
    private JPanel JPDatos;
    private JPanel JPHistorico;
    private JScrollPane JSDetalle;
    private JScrollPane JSPInterpretacion;
    private JTextArea JTAInterpretacion;
    private JTable JTDetalle;
    private JTabbedPane JTPVista;
    private Metodos xmt = new Metodos();
    private Boolean xlleno = false;

    public JPCertificadoSO(clasesHistoriaCE xclase) {
        initComponents();
        springStart();
        this.xclase = xclase;
        mNuevo();
    }

    private void springStart() {
        this.xCertificadoSoDAO = (CertificadoSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("certificadoSoDAO");
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBTipoCertificado.removeAllItems();
        List<GCGenericoDTO> list1 = this.xCertificadoSoDAO.listaComboTipoCertificados();
        this.xidTipoCertificado = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTipoCertificado[x] = String.valueOf(list1.get(x).getId());
            this.JCBTipoCertificado.addItem(list1.get(x).getNombre());
        }
        this.JCBTipoCertificado.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoCertificado.setSelectedIndex(-1);
        this.JCBConcepto.removeAllItems();
        this.JTAInterpretacion.setText("");
        mCargarDatosTabla();
        this.xlleno = true;
    }

    public void mGrabar() {
        if (this.JCBTipoCertificado.getSelectedIndex() != -1) {
            if (this.JCBConcepto.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    CertificadoSoDTO e = new CertificadoSoDTO();
                    e.setIdAtencion(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                    e.setIdTipoCertificado(this.xidTipoCertificado[this.JCBTipoCertificado.getSelectedIndex()]);
                    e.setIdTipoConcepto(this.xidTipoConcepto[this.JCBConcepto.getSelectedIndex()]);
                    e.setObservacion(this.JTAInterpretacion.getText());
                    this.xCertificadoSoDAO.createRevisionExamen(e);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    String xsql = "update h_atencion set TipoGuardado=1 where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    xct.ejecutarSQL(xsql);
                    xct.cerrarConexionBd();
                    this.xclase.mCambiarEstadoCita();
                }
                mNuevo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Certificado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTipoCertificado.requestFocus();
    }

    public void mImprimir() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[3][0] = "nbreUsuario";
            mparametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Certificados", mparametros);
            } else if (Principal.informacionIps.getIdentificacion().equals("812002613")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Certificados", mparametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_H_Certificados", mparametros);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Certificado", "Concepto", "Observacion"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO.1
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(400);
    }

    private void mCargarDatosTabla() {
        List<CertificadoSoDTO> list = this.xCertificadoSoDAO.listCertificado(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
        mCrearTabla();
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
                this.xmodelo.setValueAt(list.get(x).getIdTipoCertificado(), x, 1);
                this.xmodelo.setValueAt(list.get(x).getIdTipoConcepto(), x, 2);
                this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 3);
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPVista = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JSPInterpretacion = new JScrollPane();
        this.JTAInterpretacion = new JTextArea();
        this.JCBConcepto = new JComboBox();
        this.JCBTipoCertificado = new JComboBox();
        this.JPHistorico = new JPanel();
        this.JSDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("xjpcertificadoso");
        this.JTPVista.setForeground(Color.red);
        this.JTPVista.setFont(new Font("Arial", 1, 14));
        this.JTPVista.setName("jifCeritficadosMedicos");
        this.JTAInterpretacion.setColumns(1);
        this.JTAInterpretacion.setFont(new Font("Arial", 1, 12));
        this.JTAInterpretacion.setLineWrap(true);
        this.JTAInterpretacion.setRows(1);
        this.JTAInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPInterpretacion.setViewportView(this.JTAInterpretacion);
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoCertificado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCertificado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Certificado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoCertificado.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO.2
            public void itemStateChanged(ItemEvent evt) {
                JPCertificadoSO.this.JCBTipoCertificadoItemStateChanged(evt);
            }
        });
        this.JCBTipoCertificado.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPCertificadoSO.this.JCBTipoCertificadoPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPInterpretacion).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBTipoCertificado, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConcepto, 0, 331, 32767))).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoCertificado, -2, -1, -2).addComponent(this.JCBConcepto, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPInterpretacion, -1, 265, 32767).addContainerGap()));
        this.JTPVista.addTab("DATOS", this.JPDatos);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JPCertificadoSO.4
            public void mouseClicked(MouseEvent evt) {
                JPCertificadoSO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle, GroupLayout.Alignment.TRAILING, -1, 663, 32767));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSDetalle, GroupLayout.Alignment.TRAILING, -1, 341, 32767));
        this.JTPVista.addTab("HISTORICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPVista));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPVista));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCertificadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBTipoCertificado.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBConcepto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTAInterpretacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCertificadoItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoCertificado.getSelectedIndex() != -1 && this.xlleno.booleanValue()) {
            this.JCBConcepto.removeAllItems();
            List<GCGenericoDTO> list1 = this.xCertificadoSoDAO.listaComboTipoConcepto(this.xidTipoCertificado[this.JCBTipoCertificado.getSelectedIndex()]);
            this.xidTipoConcepto = new String[list1.size()];
            for (int x = 0; x < list1.size(); x++) {
                this.xidTipoConcepto[x] = String.valueOf(list1.get(x).getId());
                this.JCBConcepto.addItem(list1.get(x).getNombre());
                System.out.println("Consulta " + list1.get(x).getId());
                System.out.println("" + list1.get(x).getNombre());
            }
            this.JCBConcepto.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            this.JCBConcepto.setSelectedIndex(-1);
        }
    }
}
