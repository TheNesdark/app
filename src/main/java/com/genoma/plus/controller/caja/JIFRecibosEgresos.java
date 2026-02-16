package com.genoma.plus.controller.caja;

import Acceso.Principal;
import Caja.claseCaja;
import Contabilidad.JDGFacturaInternaNew;
import General.Anular;
import General.JDBiometrico;
import Historia.JDPatologia;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.caja.ReciboEgresosDAO;
import com.genoma.plus.dao.impl.caja.ReciboEgresosDAOImpl;
import com.genoma.plus.dto.caja.ReciboEgresosDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.jpa.entities.FacturaEquivalenteDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/caja/JIFRecibosEgresos.class */
public class JIFRecibosEgresos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private ReciboEgresosDAO xReciboEgresosDAO;
    private Object[] xDato;
    private String[] xidTercero;
    private String[] xidConcepto;
    private Metodos xmetodos = new Metodos();
    private claseCaja classCaja;
    private JButton JBBuscaTercero;
    private JButton JBTAdicionar;
    private JButton JBTGenerarDocumentoSoporte;
    private JButton JBTHuella;
    private JComboBox JCBConcepto;
    public JComboBox JCBTercero;
    private JDateChooser JDFecha;
    private JFormattedTextField JFTFTotal;
    private JFormattedTextField JFTFValor;
    private JLabel JLEstado;
    private JPanel JPI_InformacionRecibo;
    private JPanel JPI_Utilidades;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTabbedPane JTB_Utilidades;
    private JTable JTDetalle;
    private JTextField JTF_NumeroFactura;
    private JTextField JTF_NumeroRecibo;
    private JTextField JTF_NumeroRelacion;
    private JPanel jPanel1;

    public JIFRecibosEgresos(claseCaja xclaseCaja) {
        initComponents();
        this.classCaja = xclaseCaja;
        setTitle("RECIBO DE EGRESOS DE LA CAJA: " + Principal.clasecaja.getNbreCaja().toUpperCase());
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xReciboEgresosDAO = (ReciboEgresosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("reciboEgresosDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTF_NumeroFactura.setText("");
        this.JTF_NumeroRecibo.setText("");
        this.JTF_NumeroRelacion.setText("");
        this.JDFecha.setDate(this.xmetodos.getFechaActual());
        this.JTAObservacion.setText("");
        this.JFTFValor.setValue(0);
        this.JFTFTotal.setValue(0);
        this.JLEstado.setText("");
        mLlenarCombos();
        mCrearModeloTabla();
    }

    public void anular() {
        if (this.JTF_NumeroRelacion.getText().equals("0")) {
            Anular frm = new Anular(null, true, "Caja Egreso", 12);
            frm.setLocationRelativeTo(this);
            frm.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Recibo con cierre No. " + this.JTF_NumeroRelacion.getText() + " activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anularRecibo(String motivo, String observacion) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xReciboEgresosDAO.anularRecibo(this.JTF_NumeroRecibo.getText(), motivo, observacion, Principal.usuarioSistemaDTO.getIdPersonaCargo());
        }
    }

    private void mLlenarCombos() {
        this.JCBTercero.removeAllItems();
        List<GCGenericoDTO> list1 = this.xReciboEgresosDAO.listaTerceros();
        this.xidTercero = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidTercero[x] = String.valueOf(list1.get(x).getId());
            this.JCBTercero.addItem(list1.get(x).getNombre());
        }
        this.JCBTercero.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConcepto.removeAllItems();
        List<GCGenericoDTO> list2 = this.xReciboEgresosDAO.listaConceptos(this.classCaja.getIdCaja());
        this.xidConcepto = new String[list2.size()];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xidConcepto[x2] = String.valueOf(list2.get(x2).getId());
            this.JCBConcepto.addItem(list2.get(x2).getNombre());
        }
        this.JCBConcepto.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBConcepto.setSelectedIndex(-1);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!Principal.txtNo.getText().isEmpty()) {
                this.JFTFTotal.getValue().toString();
                System.out.println("Valor Recibo: " + BigDecimal.valueOf(Double.valueOf(this.JFTFTotal.getValue().toString()).doubleValue()));
                String[][] mparametros = new String[4][2];
                mparametros[0][0] = "idRecibo";
                mparametros[0][1] = Principal.txtNo.getText();
                mparametros[1][0] = "VrLetras";
                mparametros[1][1] = this.xmetodos.mConvertirNumeroLetras(this.JFTFTotal.getText());
                mparametros[2][0] = "SUBREPORT_DIR";
                mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "ReciboEgreso", mparametros);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar un recibo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mBuscar() {
        JDBuscarReciboEgreso dialog = new JDBuscarReciboEgreso(null, true, this);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    public void mGuardar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.JTDetalle.getRowCount() > 0) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        ReciboEgresosDTO e = new ReciboEgresosDTO();
                        if (Principal.txtNo.getText().equals("")) {
                            e.setFecha(this.xmetodos.formatoAMD.format(this.JDFecha.getDate()) + " " + this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()));
                            e.setIdCaja(String.valueOf(this.classCaja.getIdCaja()));
                            e.setIdTercero(this.xidTercero[this.JCBTercero.getSelectedIndex()]);
                            e.setObservacion(this.JTAObservacion.getText());
                            e.setNumeroFactura(this.JTF_NumeroFactura.getText());
                            e.setEstado(0);
                            String xidRecibo = this.xReciboEgresosDAO.create_return_id(e);
                            Principal.txtNo.setText(xidRecibo);
                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                e.setIdRecibo(Long.valueOf(xidRecibo));
                                e.setIdConcepto(Long.valueOf(this.xmodelo.getValueAt(y, 0).toString()));
                                e.setValor(Double.valueOf(this.xmodelo.getValueAt(y, 2).toString()));
                                this.xReciboEgresosDAO.createDetalleRecibo(e);
                            }
                        }
                        mImprimir();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este registro ya esta guardado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBTercero.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdConcepto", "Concepto", "Valor"}) { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.1
            Class[] types = {Long.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void mCargarRecibos(String xid) {
        mCrearModeloTabla();
        List<ReciboEgresosDTO> list = this.xReciboEgresosDAO.listaReciboEgresos(xid);
        if (list.size() > 0) {
            Principal.txtNo.setText(String.valueOf(list.get(0).getIdRecibo()));
            this.JTF_NumeroRecibo.setText(String.valueOf(list.get(0).getIdRecibo()));
            this.JTF_NumeroRelacion.setText(String.valueOf(list.get(0).getIdCierre()));
            this.JDFecha.setDate(Date.valueOf(list.get(0).getFecha()));
            this.JCBTercero.setSelectedItem(list.get(0).getIdTercero());
            this.JTAObservacion.setText(list.get(0).getObservacion());
            this.JTF_NumeroFactura.setText(list.get(0).getNumeroFactura());
            if (list.get(0).getEstado() == 1) {
                this.JLEstado.setText("ANULADO");
            } else if (list.get(0).getEstado() == 1 && list.get(0).getIdCierre().longValue() == 0) {
                this.JLEstado.setText("ACTIVO");
            } else if (list.get(0).getEstado() == 1 && list.get(0).getIdCierre().longValue() != 0) {
                this.JLEstado.setText("CERRADO");
            }
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list.get(x).getIdConcepto(), x, 0);
                this.xmodelo.setValueAt(list.get(x).getNConcepto(), x, 1);
                this.xmodelo.setValueAt(list.get(x).getValor(), x, 2);
            }
        }
        mTotalizar();
    }

    private void mTotalizar() {
        Double xvalor = Double.valueOf(0.0d);
        if (this.JTDetalle.getRowCount() != 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                xvalor = Double.valueOf(xvalor.doubleValue() + Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue());
                this.JFTFTotal.setValue(xvalor);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTF_NumeroFactura = new JTextField();
        this.JBBuscaTercero = new JButton();
        this.JCBConcepto = new JComboBox();
        this.JFTFValor = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTB_Utilidades = new JTabbedPane();
        this.JPI_InformacionRecibo = new JPanel();
        this.JTF_NumeroRecibo = new JTextField();
        this.JTF_NumeroRelacion = new JTextField();
        this.JBTHuella = new JButton();
        this.JLEstado = new JLabel();
        this.JFTFTotal = new JFormattedTextField();
        this.JPI_Utilidades = new JPanel();
        this.JBTGenerarDocumentoSoporte = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECIBOS DE EGRESOS");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifrecibosegresos");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL MOVIMIENTO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTF_NumeroFactura.setFont(new Font("Arial", 1, 12));
        this.JTF_NumeroFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura/Orden", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_NumeroFactura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.2
            public void focusLost(FocusEvent evt) {
                JIFRecibosEgresos.this.JTF_NumeroFacturaFocusLost(evt);
            }
        });
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.3
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, -2, 408, -2).addGap(4, 4, 4).addComponent(this.JBBuscaTercero, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NumeroFactura))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, 50, -2).addComponent(this.JTF_NumeroFactura, GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBBuscaTercero, -2, 50, -2).addComponent(this.JCBTercero, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 76, -2).addGap(10, 10, 10)));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.4
            public void itemStateChanged(ItemEvent evt) {
                JIFRecibosEgresos.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.JFTFValor.setHorizontalAlignment(4);
        this.JFTFValor.setText("0");
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JFTFValor.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.5
            public void focusGained(FocusEvent evt) {
                JIFRecibosEgresos.this.JFTFValorFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JIFRecibosEgresos.this.JFTFValorFocusLost(evt);
            }
        });
        this.JFTFValor.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.6
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JFTFValorActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.7
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.8
            public void keyPressed(KeyEvent evt) {
                JIFRecibosEgresos.this.JBTAdicionarKeyPressed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.9
            public void keyPressed(KeyEvent evt) {
                JIFRecibosEgresos.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTB_Utilidades.setForeground(new Color(0, 103, 0));
        this.JTB_Utilidades.setFont(new Font("Arial", 1, 14));
        this.JTF_NumeroRecibo.setFont(new Font("Arial", 1, 14));
        this.JTF_NumeroRecibo.setHorizontalAlignment(0);
        this.JTF_NumeroRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recibo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_NumeroRelacion.setFont(new Font("Arial", 1, 14));
        this.JTF_NumeroRelacion.setHorizontalAlignment(0);
        this.JTF_NumeroRelacion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Cierre", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.10
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.JLEstado.setFont(new Font("Arial", 1, 12));
        this.JLEstado.setForeground(Color.red);
        this.JLEstado.setHorizontalAlignment(0);
        this.JLEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFTotal.setEditable(false);
        this.JFTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFTotal.setHorizontalAlignment(4);
        this.JFTFTotal.setFont(new Font("Arial", 1, 12));
        this.JFTFTotal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.11
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JFTFTotalActionPerformed(evt);
            }
        });
        GroupLayout JPI_InformacionReciboLayout = new GroupLayout(this.JPI_InformacionRecibo);
        this.JPI_InformacionRecibo.setLayout(JPI_InformacionReciboLayout);
        JPI_InformacionReciboLayout.setHorizontalGroup(JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReciboLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JTF_NumeroRecibo, -1, 148, 32767).addGap(18, 18, 18).addComponent(this.JTF_NumeroRelacion, -1, 149, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHuella, -2, 50, -2).addGap(45, 45, 45).addComponent(this.JLEstado, -2, 137, -2).addGap(18, 18, 18).addComponent(this.JFTFTotal, -2, 155, -2).addGap(18, 18, 18)));
        JPI_InformacionReciboLayout.setVerticalGroup(JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReciboLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLEstado, -1, -1, 32767).addGroup(JPI_InformacionReciboLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NumeroRecibo, -2, 50, -2).addComponent(this.JTF_NumeroRelacion, -2, 50, -2))).addComponent(this.JBTHuella, -2, 50, -2)).addComponent(this.JFTFTotal, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap(23, 32767)));
        this.JTB_Utilidades.addTab("INFORMACIÓN RECIBO", this.JPI_InformacionRecibo);
        this.JBTGenerarDocumentoSoporte.setFont(new Font("Arial", 1, 12));
        this.JBTGenerarDocumentoSoporte.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerarDocumentoSoporte.setText("<html><P ALIGN=center>Generar Documento Soporte");
        this.JBTGenerarDocumentoSoporte.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.caja.JIFRecibosEgresos.12
            public void actionPerformed(ActionEvent evt) {
                JIFRecibosEgresos.this.JBTGenerarDocumentoSoporteActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JBTGenerarDocumentoSoporte, -2, 193, -2).addContainerGap(552, 32767)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createSequentialGroup().addContainerGap(15, 32767).addComponent(this.JBTGenerarDocumentoSoporte, -2, 50, -2).addGap(14, 14, 14)));
        this.JTB_Utilidades.addTab("UTILIDADES", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JCBConcepto, -2, 418, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 163, -2)))).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTB_Utilidades))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConcepto, -2, 50, -2).addComponent(this.JFTFValor, -2, 50, -2)).addComponent(this.JBTAdicionar, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 264, -2).addGap(18, 18, 18).addComponent(this.JTB_Utilidades, -2, 125, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() != 0.0d) {
            if (!this.xmetodos.mVerificarDatosDoblesTabla(this.JTDetalle, 1, this.JCBConcepto.getSelectedItem().toString())) {
                System.out.println(this.JTDetalle.getRowCount());
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(Long.valueOf(this.xidConcepto[this.JCBConcepto.getSelectedIndex()]), this.JTDetalle.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem(), this.JTDetalle.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(Double.valueOf(this.JFTFValor.getValue().toString()), this.JTDetalle.getRowCount() - 1, 2);
                mTotalizar();
                this.JCBConcepto.setSelectedIndex(-1);
                this.JFTFValor.setValue(0);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este concepto ya se encuentra registrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El valor debe ser mayor a 0", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JFTFValor.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && Principal.txtNo.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar este registro?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                mTotalizar();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setLocationRelativeTo(this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "xjifrecibosegresos", Principal.txtNo.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un registro del Historico", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarDocumentoSoporteActionPerformed(ActionEvent evt) {
        if (!this.JTF_NumeroRecibo.getText().isEmpty()) {
            System.out.println("el id de la empresa es " + Long.valueOf(this.xidTercero[this.JCBTercero.getSelectedIndex()]));
            FacturaEquivalenteDTO facturaEquivalenteDTO = new FacturaEquivalenteDTO();
            facturaEquivalenteDTO.setFechaFactura(this.JDFecha.getDate());
            facturaEquivalenteDTO.setNumeroFactura(this.JTF_NumeroFactura.getText());
            facturaEquivalenteDTO.setIdRadicacion(new Long(0L));
            facturaEquivalenteDTO.setIdEmpresa(Long.valueOf(this.xidTercero[this.JCBTercero.getSelectedIndex()]));
            facturaEquivalenteDTO.setConcepto(this.JTDetalle.getValueAt(0, 1).toString());
            facturaEquivalenteDTO.setValorUnitario(Double.valueOf(this.JFTFTotal.getValue().toString()));
            JDGFacturaInternaNew e = new JDGFacturaInternaNew(null, true, Integer.valueOf(this.xidTercero[this.JCBTercero.getSelectedIndex()]), facturaEquivalenteDTO);
            e.setLocationRelativeTo(this);
            e.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_NumeroFacturaFocusLost(FocusEvent evt) {
        if (this.JTF_NumeroRecibo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (!this.JTF_NumeroFactura.getText().isEmpty()) {
                    Integer id = this.xReciboEgresosDAO.validarNumeroFactura(Long.valueOf(this.xidTercero[this.JCBTercero.getSelectedIndex()]), this.JTF_NumeroFactura.getText());
                    if (id.intValue() == 1) {
                        JOptionPane.showInternalMessageDialog(this, "Numero factura u orden ya se encuentra registrada;\nen otro recibo favor revisar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JTF_NumeroFactura.setText("");
                        this.JTF_NumeroFactura.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Numero factura no puede estar en blanco", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBTercero.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFTotalActionPerformed(ActionEvent evt) {
    }
}
