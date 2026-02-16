package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.genoma.plus.dao.contabilidad.InformesContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.InformesContabilidadDAOImpl;
import com.genoma.plus.dto.contabilidad.ConsultarCCobroDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JIFConsultarCuentaCobro.class */
public class JIFConsultarCuentaCobro extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private InformesContabilidadDAO xInformesContabilidadDAO;
    private Object[] xDato;
    private JButton JBTGenerar;
    private JCheckBox JCHSeleccionar;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNDocumento;
    private JTextField JTFRuta;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();

    public JIFConsultarCuentaCobro() {
        initComponents();
        springStart();
        mBuscaDatos(0);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void springStart() {
        this.xInformesContabilidadDAO = (InformesContabilidadDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesContabilidadDAO");
    }

    public void mAnular() {
        if (this.JTDetalle.getRowCount() > 0) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 9)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "Consultar Cuenta de Cobro", 6);
                    frm.setLocationRelativeTo(this);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe haber al menos un registro seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No hay ningun registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mAnularC(String xid, String xmotivo) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                Principal.xclase.mAnularDocumentoContable(this.xmodelo.getValueAt(x, 0).toString(), xid, xmotivo);
                Principal.xclase.mActualizarSalidasSiAnulaDocContable(this.xmodelo.getValueAt(x, 0).toString());
                Principal.xclase.mAnularDocumentoPresupuesto(this.xmodelo.getValueAt(x, 0).toString(), xid, xmotivo);
                Principal.xclase.mActualizarFacturaEvento(this.xmodelo.getValueAt(x, 0).toString(), null, false, 0);
                Principal.xclase.mActualizarEstadoSReembolso(this.xmodelo.getValueAt(x, 0).toString(), Double.valueOf(this.xmodelo.getValueAt(x, 10).toString()));
                Principal.xclase.mActualizarFacRadicadas(this.xmodelo.getValueAt(x, 0).toString());
                Principal.xclase.mActualizarActivos(this.xmodelo.getValueAt(x, 0).toString());
                Principal.xclase.mActualizarCierres(this.xmodelo.getValueAt(x, 0).toString());
                Principal.xclase.mAnulado_RadicacionFactura(this.xmodelo.getValueAt(x, 0).toString());
            }
        }
        mBuscar();
    }

    public void mBuscar() {
        if (!this.JTFNDocumento.getText().isEmpty()) {
            mBuscaDatos(1);
        } else {
            mBuscaDatos(0);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo Documento", "Tercero", "Estado", "Nº Consecutivo", "Periodo", "Nº Factura", "Nº Cuenta Cobro", "Selecciona?", "V/Total"}) { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class, Boolean.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    private void mBuscaDatos(int opc) {
        mModelo();
        List<ConsultarCCobroDTO> list = this.xInformesContabilidadDAO.list(opc, this.JTFNDocumento.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdDocumentoc(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getTercero(), x, 3);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            this.xmodelo.setValueAt(list.get(x).getConsecutivo(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getPeriodo(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getNfactura(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getCCobro(), x, 8);
            this.xmodelo.setValueAt(false, x, 9);
            this.xmodelo.setValueAt(list.get(x).getTotal(), x, 10);
        }
    }

    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFNDocumento = new JTextField();
        this.JCHSeleccionar = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTGenerar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CUENTA DE COBRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultarcuentacobro");
        this.JTFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFNDocumento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.2
            public void keyPressed(KeyEvent evt) {
                JIFConsultarCuentaCobro.this.JTFNDocumentoKeyPressed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todo");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaCobro.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentaCobro.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\\\Genoma\\\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.5
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarCuentaCobro.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGenerar.setText("Exportar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JIFConsultarCuentaCobro.6
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarCuentaCobro.this.JBTGenerarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFNDocumento, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHSeleccionar)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 652, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 248, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNDocumento, -1, 59, 32767).addComponent(this.JCHSeleccionar, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 318, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGenerar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addGap(8, 8, 8)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDocumentoKeyPressed(KeyEvent evt) {
        if (!this.JTFNDocumento.getText().isEmpty()) {
            mBuscaDatos(1);
        } else {
            mBuscaDatos(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mSeleccionar(true);
        } else {
            mSeleccionar(false);
        }
    }

    private void mSeleccionar(boolean xestado) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(Boolean.valueOf(xestado), x, 9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
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
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }
}
