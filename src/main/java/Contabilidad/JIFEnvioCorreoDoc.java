package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFEnvioCorreoDoc.class */
public class JIFEnvioCorreoDoc extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xsql;
    private String xobjetollamador;
    private JIFGenerarCetificadoA xjifgenerarc;
    private ButtonGroup JBGSeleccion;
    private JButton JBTEnviar;
    private JButton JBTImprimir;
    private JCheckBox JCHQuitarS;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIFEnvioCorreoDoc(JInternalFrame xjif) {
        initComponents();
        mRealizarCasting(xjif);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTEnviar = new JButton();
        this.JCHQuitarS = new JCheckBox();
        this.JBTImprimir = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("ENVIAR EMAIL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifenviaremail");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFEnvioCorreoDoc.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEnvioCorreoDoc.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.blue);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFEnvioCorreoDoc.2
            public void mouseClicked(MouseEvent evt) {
                JIFEnvioCorreoDoc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBTEnviar.setFont(new Font("Arial", 1, 14));
        this.JBTEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTEnviar.setText("Enviar Email");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEnvioCorreoDoc.3
            public void actionPerformed(ActionEvent evt) {
                JIFEnvioCorreoDoc.this.JBTEnviarActionPerformed(evt);
            }
        });
        this.JCHQuitarS.setFont(new Font("Arial", 1, 12));
        this.JCHQuitarS.setText("Quitar Selección");
        this.JCHQuitarS.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEnvioCorreoDoc.4
            public void actionPerformed(ActionEvent evt) {
                JIFEnvioCorreoDoc.this.JCHQuitarSActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 14));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.setToolTipText("");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEnvioCorreoDoc.5
            public void actionPerformed(ActionEvent evt) {
                JIFEnvioCorreoDoc.this.JBTImprimirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTEnviar, -2, 441, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTImprimir, -2, 267, -2).addGap(26, 26, 26).addComponent(this.JCHQuitarS).addGap(0, 0, 32767)).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 414, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTEnviar, -2, 43, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHQuitarS).addComponent(this.JBTImprimir, -2, 43, -2))).addGap(7, 7, 7)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de enviar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            mEnviarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 0 && evt.getClickCount() == 2) {
            new convertirNumerosLetras();
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "vLetra";
            mparametros[2][1] = this.xmetodos.mConvertirNumeroLetras(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).longValue() == 1) {
                if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "CC_Certificado_Retencion_Iva_HLM", mparametros);
                    return;
                } else {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "CC_Certificado_Retencion_Iva", mparametros);
                    return;
                }
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "CC_Certificado_Retencion_Iva_HLM", mparametros);
            } else {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "CC_Certificado_Retencion", mparametros);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHQuitarSActionPerformed(ActionEvent evt) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (!this.xmodelo.getValueAt(x, 3).toString().equals("")) {
                if (this.JCHQuitarS.isSelected()) {
                    this.xmodelo.setValueAt(false, x, 4);
                } else {
                    this.xmodelo.setValueAt(true, x, 4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("xjifgenerarcertificadoautomatico")) {
            this.xjifgenerarc = (JIFGenerarCetificadoA) frm;
            this.xobjetollamador = "xjifgenerarcertificadoautomatico";
        }
    }

    private void mEnviarDatos() {
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 4)) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 4).toString()).booleanValue()) {
                    String[][] mparametros = new String[2][2];
                    mparametros[0][0] = "IdC";
                    mparametros[0][1] = this.xmodelo.getValueAt(x, 0).toString();
                    mparametros[1][0] = "UsuarioS";
                    mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                    this.xmetodos.CrearPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion", mparametros);
                    new File(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion.pdf");
                    String str = this.xmetodos.getRutaRep() + "CC_Certificado_Retencion";
                    String adjunto = this.xmetodos.getRutaRep() + this.xmodelo.getValueAt(x, 0).toString() + ".pdf";
                    File f1 = new File(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion.pdf");
                    File f2 = new File(adjunto);
                    boolean renombrado = f1.renameTo(f2);
                    if (renombrado) {
                        String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                        String mensaje = "Anexo archivo con certificado de " + this.xjifgenerarc.JCBTipoImpuesto.getSelectedItem().toString() + " del periodo " + this.xjifgenerarc.JCBPeriodo.getSelectedItem().toString() + " - " + this.xjifgenerarc.JYCAno.getValue() + "\n\n\nDEPARTAMENTO DE CONTABILIDAD";
                        Email correo = new Email();
                        List<String> correoE = new ArrayList<>();
                        correoE.add(this.xmodelo.getValueAt(x, 3).toString());
                        correo.enviarAdjunto(correoE, mensaje, remite, "Envio certificado de " + this.xjifgenerarc.JCBTipoImpuesto.getSelectedItem().toString().toLowerCase(), "Certificado N°" + this.xmodelo.getValueAt(x, 0).toString() + ".pdf", f2.toString());
                        f2.delete();
                    } else {
                        this.xmetodos.mostrarMensaje("Hubo un error al renombrar el archivo PDF");
                    }
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar registros", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImprimir() {
        int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de imprinmir?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (y == 0) {
            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 4).toString()).booleanValue()) {
                    new convertirNumerosLetras();
                    String[][] mparametros = new String[5][2];
                    mparametros[0][0] = "IdC";
                    mparametros[0][1] = this.xmodelo.getValueAt(x, 0).toString();
                    mparametros[1][0] = "UsuarioS";
                    mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                    mparametros[2][0] = "vLetra";
                    mparametros[2][1] = this.xmetodos.mConvertirNumeroLetras(this.xmodelo.getValueAt(x, 6).toString());
                    mparametros[3][0] = "SUBREPORT_DIR";
                    mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                    mparametros[4][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                    if (Long.valueOf(this.xmodelo.getValueAt(x, 5).toString()).longValue() == 1) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion_Iva_HLM", mparametros, this.xmodelo.getValueAt(x, 2).toString());
                        } else {
                            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion_Iva", mparametros, this.xmodelo.getValueAt(x, 2).toString());
                        }
                    } else if (Principal.informacionIps.getEsFpz().intValue() == 1) {
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion_Iva_HLM", mparametros, this.xmodelo.getValueAt(x, 2).toString());
                    } else {
                        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Certificado_Retencion_Iva", mparametros, this.xmodelo.getValueAt(x, 2).toString());
                    }
                }
            }
        }
    }

    public void mAnular() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0 && this.xobjetollamador.equals("xjifgenerarcertificadoautomatico")) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 4).toString()).booleanValue()) {
                    this.xsql = "update cc_documentoc set Id_Certificado=0 where Id_Certificado='" + this.xmodelo.getValueAt(i, 0) + "'";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    this.xsql = "update cc_detalle_documentoc set Id_Certificado=0 where Id_Certificado='" + this.xmodelo.getValueAt(i, 0) + "'";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    this.xsql = "update cc_certificado_impuestos set Estado=0 where Id='" + this.xmodelo.getValueAt(i, 0) + "'";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                }
            }
            mCargarDatosTabla();
        }
    }

    public void mNuevo() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosImp() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "Tercero", "Email", "Enviar?", "Id_TipoI", "Valor"}) { // from class: Contabilidad.JIFEnvioCorreoDoc.6
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, true, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(320);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
    }

    private void mCargarDatosTabla() {
        try {
            if (this.xobjetollamador.equals("xjifgenerarcertificadoautomatico")) {
                this.xsql = "SELECT cc_certificado_impuestos.Id, DATE_FORMAT(cc_certificado_impuestos.FechaG,'%d-%m-%Y') AS FechaG, cc_terceros.RazonSocialCompleta NEmpresa, cc_terceros.Correo, cc_periodost.NPerido, cc_certificado_impuestos.Ano, cc_certificado_impuestos.Id_TipoImpuesto,SUM(round(cc_detalle_certificado_manual.VRetencion)) AS VRetencion FROM  cc_certificado_impuestos INNER JOIN cc_tipo_impuesto  ON (cc_certificado_impuestos.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_terceros  ON (cc_certificado_impuestos.Id_Tercero = cc_terceros.Id) INNER JOIN cc_periodost  ON (cc_certificado_impuestos.Id_PeriodoT = cc_periodost.Id) INNER JOIN `cc_detalle_certificado_manual` ON (cc_certificado_impuestos.Id = cc_detalle_certificado_manual.Id_Certificado) WHERE (cc_certificado_impuestos.Estado =1 AND cc_certificado_impuestos.Id_PeriodoT ='" + this.xjifgenerarc.xidperiodo[this.xjifgenerarc.JCBPeriodo.getSelectedIndex()][0] + "' AND cc_certificado_impuestos.Ano ='" + this.xjifgenerarc.JYCAno.getValue() + "' AND cc_certificado_impuestos.Id_TipoImpuesto ='" + this.xjifgenerarc.xidtipoimpuesto[this.xjifgenerarc.JCBTipoImpuesto.getSelectedIndex()] + "')  GROUP BY  cc_certificado_impuestos.Id ORDER BY cc_terceros.RazonSocialCompleta ASC, cc_certificado_impuestos.Id DESC";
            }
            mCrearModeloDatosImp();
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    if (xrs.getString(4).equals("")) {
                        this.xmodelo.setValueAt(false, n, 4);
                    } else {
                        this.xmodelo.setValueAt(true, n, 4);
                    }
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEnvioCorreoDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
