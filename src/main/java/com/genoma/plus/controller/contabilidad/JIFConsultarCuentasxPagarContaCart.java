package com.genoma.plus.controller.contabilidad;

import Historia.JDPatologia;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.InformesContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.InformesContabilidadDAOImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFConsultarCuentasxPagarContaCart.class */
public class JIFConsultarCuentasxPagarContaCart extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private InformesContabilidadDAO xInformesContabilidadDAO;
    private Object[] xDato;
    private String[] xidTercero;
    private JButton JBBuscaTercero;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JCheckBox JCHEstado;
    private JDateChooser JDFFechaC;
    public JLabel JLTercero;
    private JPanel JPI_Forma;
    private JRadioButton JRB_360;
    private JRadioButton JRB_720;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JFormattedTextField JTFFCuentaP;
    private JFormattedTextField JTFFTotalSaldo;
    private JTextField JTFRuta;
    private JTabbedPane JTPDetalle;
    private Metodos xmt = new Metodos();
    private int xlleno = 0;

    public JIFConsultarCuentasxPagarContaCart() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformesContabilidadDAO = (InformesContabilidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesContabilidadDAO");
    }

    public void mBuscar() {
        if (this.JCHEstado.isSelected()) {
            if (!this.JLTercero.getText().isEmpty()) {
                if (this.JRB_360.isSelected()) {
                    mBuscaDatos();
                    mBuscaDatosConsolidado();
                    return;
                } else {
                    mBuscaDatos_Ampliada();
                    mBuscaDatosConsolidado_Ampliada();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe cargar un Tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (this.JRB_360.isSelected()) {
            mBuscaDatos();
            mBuscaDatosConsolidado();
        } else {
            mBuscaDatos_Ampliada();
            mBuscaDatosConsolidado_Ampliada();
        }
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mModelo();
        mModeloConsolidado();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No. Documento", "Tercero", "Fecha", "No. Factura", "Codigo", "Cuenta", "V/Factura", "V/Pagado", "V/Credito", "V/Debito", "Saldo", "No. Dias Cartera", "30 Dias", "60 Dias", "90 Dias", "180 Dias", "360 Dias", "361 Dias"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo_Ampliada() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No. Documento", "Tercero", "Fecha", "No. Factura", "Codigo", "Cuenta", "V/Factura", "V/Pagado", "V/Credito", "V/Debito", "Saldo", "No. Dias Cartera", "30 Dias", "60 Dias", "90 Dias", "180 Dias", "360 Dias", "720 Dias", "721 Dias"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.2
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(150);
    }

    private void mBuscaDatos() {
        List<Object[]> list;
        double saldo = 0.0d;
        mModelo();
        if (this.JCHEstado.isSelected()) {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCart(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 1);
        } else {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCart(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 0);
        }
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo.setValueAt(list.get(x)[13], x, 13);
            this.xmodelo.setValueAt(list.get(x)[14], x, 14);
            this.xmodelo.setValueAt(list.get(x)[15], x, 15);
            this.xmodelo.setValueAt(list.get(x)[16], x, 16);
            this.xmodelo.setValueAt(list.get(x)[17], x, 17);
            this.xmodelo.setValueAt(list.get(x)[18], x, 18);
            saldo += Double.valueOf(this.xmodelo.getValueAt(x, 11).toString()).doubleValue();
            this.JTFFTotalSaldo.setValue(Double.valueOf(saldo));
        }
    }

    private void mBuscaDatos_Ampliada() {
        List<Object[]> list;
        double saldo = 0.0d;
        mModelo_Ampliada();
        if (this.JCHEstado.isSelected()) {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCart_Ampliado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 1);
        } else {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCart_Ampliado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 0);
        }
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo.setValueAt(list.get(x)[13], x, 13);
            this.xmodelo.setValueAt(list.get(x)[14], x, 14);
            this.xmodelo.setValueAt(list.get(x)[15], x, 15);
            this.xmodelo.setValueAt(list.get(x)[16], x, 16);
            this.xmodelo.setValueAt(list.get(x)[17], x, 17);
            this.xmodelo.setValueAt(list.get(x)[18], x, 18);
            this.xmodelo.setValueAt(list.get(x)[19], x, 19);
            saldo += Double.valueOf(this.xmodelo.getValueAt(x, 11).toString()).doubleValue();
            this.JTFFTotalSaldo.setValue(Double.valueOf(saldo));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloConsolidado() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Documento", "Tercero", "V/Factura", "V/Pagado", "V/Credito", "V/Debito", "Saldo", "No. Dias Cartera", "30 Dias", "60 Dias", "90 Dias", "180 Dias", "360 Dias", "361 Dias"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.3
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloConsolidado_Ampliada() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"No. Documento", "Tercero", "V/Factura", "V/Pagado", "V/Credito", "V/Debito", "Saldo", "No. Dias Cartera", "30 Dias", "60 Dias", "90 Dias", "180 Dias", "360 Dias", "720 Dias", "721 Dias"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.4
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle1;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(9).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(11).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(13).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(14).setPreferredWidth(150);
    }

    private void mBuscaDatosConsolidado() {
        List<Object[]> list;
        mModeloConsolidado();
        if (this.JCHEstado.isSelected()) {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCartConsolidado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 1);
        } else {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCartConsolidado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 0);
        }
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo1.addRow(this.xDato);
            this.xmodelo1.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo1.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo1.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo1.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo1.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo1.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo1.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo1.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo1.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo1.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo1.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo1.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo1.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo1.setValueAt(list.get(x)[13], x, 13);
        }
    }

    private void mBuscaDatosConsolidado_Ampliada() {
        List<Object[]> list;
        mModeloConsolidado_Ampliada();
        if (this.JCHEstado.isSelected()) {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCartConsolidado_Ampliado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 1);
        } else {
            list = this.xInformesContabilidadDAO.listCuentasxPagarContaCartConsolidado_Ampliado(this.xmt.formatoAMD1.format(this.JDFFechaC.getDate()), this.JTFFCuentaP.getText(), this.JLTercero.getText(), 0);
        }
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo1.addRow(this.xDato);
            this.xmodelo1.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo1.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo1.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo1.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo1.setValueAt(list.get(x)[4], x, 4);
            this.xmodelo1.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo1.setValueAt(list.get(x)[6], x, 6);
            this.xmodelo1.setValueAt(list.get(x)[7], x, 7);
            this.xmodelo1.setValueAt(list.get(x)[8], x, 8);
            this.xmodelo1.setValueAt(list.get(x)[9], x, 9);
            this.xmodelo1.setValueAt(list.get(x)[10], x, 10);
            this.xmodelo1.setValueAt(list.get(x)[11], x, 11);
            this.xmodelo1.setValueAt(list.get(x)[12], x, 12);
            this.xmodelo1.setValueAt(list.get(x)[13], x, 13);
            this.xmodelo1.setValueAt(list.get(x)[14], x, 14);
        }
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JDFFechaC = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFFTotalSaldo = new JFormattedTextField();
        this.JBBuscaTercero = new JButton();
        this.JCHEstado = new JCheckBox();
        this.JLTercero = new JLabel();
        this.JTFFCuentaP = new JFormattedTextField();
        this.JPI_Forma = new JPanel();
        this.JRB_360 = new JRadioButton();
        this.JRB_720 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CUENTAS POR PAGAR ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarcuentasxpagarcontacart");
        this.JTPDetalle.setForeground(Color.red);
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("DETALLE", this.JSPDetalle);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTPDetalle.addTab("CONSOLIDADO", this.JSPDetalle1);
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentasxPagarContaCart.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxPagarContaCart.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFFTotalSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldo.setHorizontalAlignment(4);
        this.JTFFTotalSaldo.setFont(new Font("Arial", 1, 12));
        this.JBBuscaTercero.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBBuscaTercero.setToolTipText("Buscar Tercero");
        this.JBBuscaTercero.setEnabled(false);
        this.JBBuscaTercero.setName("xRadicacion");
        this.JBBuscaTercero.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxPagarContaCart.this.JBBuscaTerceroActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Filtro");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.8
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxPagarContaCart.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JLTercero.setFont(new Font("Arial", 1, 12));
        this.JLTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLTercero.setEnabled(false);
        this.JTFFCuentaP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuentaP.setFont(new Font("Arial", 1, 12));
        this.JTFFCuentaP.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart.9
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentasxPagarContaCart.this.JTFFCuentaPActionPerformed(evt);
            }
        });
        this.JPI_Forma.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JRB_360);
        this.JRB_360.setFont(new Font("Arial", 1, 12));
        this.JRB_360.setSelected(true);
        this.JRB_360.setText("360");
        this.JBG_Filtro.add(this.JRB_720);
        this.JRB_720.setFont(new Font("Arial", 1, 12));
        this.JRB_720.setText("720");
        GroupLayout JPI_FormaLayout = new GroupLayout(this.JPI_Forma);
        this.JPI_Forma.setLayout(JPI_FormaLayout);
        JPI_FormaLayout.setHorizontalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_360).addGap(18, 18, 18).addComponent(this.JRB_720).addContainerGap(-1, 32767)));
        JPI_FormaLayout.setVerticalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_360).addComponent(this.JRB_720)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDetalle).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCuentaP, -2, 127, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTercero, -2, 637, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscaTercero, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPI_Forma, -2, -1, -2).addGap(100, 100, 100).addComponent(this.JTFRuta, -2, 486, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalSaldo, -2, 140, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLTercero, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JCHEstado).addComponent(this.JTFFCuentaP, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JBBuscaTercero, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTPDetalle, -2, 517, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFFTotalSaldo, -2, 50, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPI_Forma, GroupLayout.Alignment.LEADING, -2, 50, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -1, 50, 32767))).addContainerGap()));
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
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTPDetalle.getSelectedIndex() == 0) {
                if (this.JTDetalle.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    return;
                }
            }
            if (this.JTDetalle1.getRowCount() > -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), getTitle());
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscaTerceroActionPerformed(ActionEvent evt) {
        JDPatologia x = new JDPatologia(null, true, this);
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.JLTercero.setEnabled(true);
            this.JBBuscaTercero.setEnabled(true);
        } else {
            this.JLTercero.setEnabled(false);
            this.JBBuscaTercero.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCuentaPActionPerformed(ActionEvent evt) {
    }
}
