package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFAutorizacionDoc.class */
public class JIFAutorizacionDoc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidtipodocumento;
    private String xsql;
    private int xtipoforma;
    private ButtonGroup JBGSeleccion;
    private JComboBox JCBTipoDoc;
    private JPanel JPIDatos;
    private JPanel JPITipoAutor;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFNDocumento;
    private JTextField JTFTercero;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xautorizado = 1;
    private int xnentradas = 0;

    public JIFAutorizacionDoc() {
        initComponents();
        this.xidtipodocumento = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_tipo_documentof WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodocumento, this.JCBTipoDoc);
        this.xconsulta.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBTipoDoc = new JComboBox();
        this.JTFFNDocumento = new JFormattedTextField();
        this.JTFTercero = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JPITipoAutor = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUTORIZACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifautorizaciondocn");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFAutorizacionDoc.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAutorizacionDoc.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoDoc.setFont(new Font("Arial", 0, 13));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Doc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDocumento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDocumento.setHorizontalAlignment(4);
        this.JTFFNDocumento.setFont(new Font("Arial", 1, 15));
        this.JTFFNDocumento.setValue(new Double(0.0d));
        this.JTFFNDocumento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAutorizacionDoc.2
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionDoc.this.JTFFNDocumentoActionPerformed(evt);
            }
        });
        this.JTFFNDocumento.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFAutorizacionDoc.3
            public void focusLost(FocusEvent evt) {
                JIFAutorizacionDoc.this.JTFFNDocumentoFocusLost(evt);
            }
        });
        this.JTFTercero.setFont(new Font("Arial", 1, 13));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoDoc, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNDocumento, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFTercero, -1, 469, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNDocumento, -2, 52, -2).addComponent(this.JTFTercero)).addComponent(this.JCBTipoDoc, -2, 53, -2)).addContainerGap(12, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFAutorizacionDoc.4
            public void mouseClicked(MouseEvent evt) {
                JIFAutorizacionDoc.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE AUTORIZACIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JPITipoAutor.setBorder(BorderFactory.createTitledBorder((Border) null, "Autorizado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSeleccion.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setSelected(true);
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAutorizacionDoc.5
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionDoc.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAutorizacionDoc.6
            public void actionPerformed(ActionEvent evt) {
                JIFAutorizacionDoc.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoAutorLayout = new GroupLayout(this.JPITipoAutor);
        this.JPITipoAutor.setLayout(JPITipoAutorLayout);
        JPITipoAutorLayout.setHorizontalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAutorLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(-1, 32767)));
        JPITipoAutorLayout.setVerticalGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPITipoAutorLayout.createSequentialGroup().addContainerGap(11, 32767).addGroup(JPITipoAutorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap()));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPITipoAutor, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -1, 732, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JSPObservacion, -1, 61, 32767)).addComponent(this.JPITipoAutor, -1, -1, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 902, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xautorizado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xautorizado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            if (this.xtipoforma == 0) {
                Object[] botones = {"Visualizar Orden", "Autorizar", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                        Object[] xbotones = {"Soporte Factura", "Factura Interna", "Orden Compra", "Entrada", "Documento Contable", "Cerrar"};
                        int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), xbotones, "Cerrar");
                        if (n2 != 0) {
                            if (n2 == 1) {
                                if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).equals("0")) {
                                    mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString(), "CC_Factura_Interna", "0");
                                    return;
                                }
                                return;
                            }
                            if (n2 == 2) {
                                if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).equals("0")) {
                                    mImprimirDoc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString(), "CC_OrdenCompra", "1");
                                    return;
                                }
                                return;
                            }
                            if (n2 == 3) {
                                String[][] parametros = new String[4][2];
                                parametros[0][0] = "numero";
                                parametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString();
                                parametros[1][0] = "nbreUsuario";
                                parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
                                parametros[2][0] = "SUBREPORT_DIR";
                                parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                                parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "I_EntradaAInventario", parametros);
                                return;
                            }
                            if (n2 == 4) {
                                mImprimir();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    mImprimir();
                    return;
                }
                if (n == 1) {
                    this.JTAObservacion.setEnabled(true);
                    this.JTAObservacion.requestFocus();
                    return;
                }
                return;
            }
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDocumentoActionPerformed(ActionEvent evt) {
        this.JTFFNDocumento.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDocumentoFocusLost(FocusEvent evt) {
        mBuscar();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.JTFFNDocumento.setValue((Object) null);
        this.JTFTercero.setText("");
        mCrearModeloDatos();
    }

    private void mImprimirDoc(String xid, String xnombrea, String xtipodoc) {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = xid;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "TipoDoc";
        mparametros[2][1] = xtipodoc;
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + xnombrea, mparametros);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[2][1] = this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()];
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
                return;
            }
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 7), mparametros);
            } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("5")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionNotaCredito", mparametros);
            } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("6")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenServicio", mparametros);
            }
        }
    }

    public void mGrabar() {
        String xdatosa;
        if (!Principal.txtNo.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                    this.xsql = "update cc_detalle_firma_ordenc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenC ='" + Principal.txtNo.getText() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    if (this.xautorizado == 1) {
                    }
                    mCargarDatosTabla(this.xsql);
                    mCambiarEstadoOrden();
                    return;
                }
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                    this.xsql = "update cc_detalle_firma_documentoc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenDc ='" + Principal.txtNo.getText() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    mCambiarEstadoOrdenDC();
                    return;
                }
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("5")) {
                    this.xsql = "update cc_detalle_firma_documentoc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenDc ='" + Principal.txtNo.getText() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    if (this.xautorizado == 1) {
                    }
                    mCambiarEstadoOrdenDC();
                    return;
                }
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("6")) {
                    this.xsql = "update cc_detalle_firma_ordenc set Autorizo='" + this.xautorizado + "', FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', Observacion='" + this.JTAObservacion.getText() + "' WHERE (Id_OrdenC ='" + Principal.txtNo.getText() + "' AND Id_UsuarioF ='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6) + "')";
                    this.xconsulta.ejecutarSQL(this.xsql);
                    this.xconsulta.cerrarConexionBd();
                    if (this.xautorizado == 1) {
                        xdatosa = "Se aprobó";
                    } else {
                        xdatosa = "No se aprobó";
                    }
                    this.xmetodos.mEnvioCorreoElectronico(xdatosa + " la orden de servicio N°" + Principal.txtNo.getText() + "\nde la unidad funcional: " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2), this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), "CONFIRMACIÓN DE AUTORIZACIÓN ORDEN DE SERVICIO", Principal.usuarioSistemaDTO.getLogin());
                    mCargarDatosTabla(this.xsql);
                    mCambiarEstadoOrden();
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Puc", "Cuenta", "Tipo", "V/Debito", "V/Credito", "Base", "IdRadicado", "Reporte"}) { // from class: Contabilidad.JIFAutorizacionDoc.7
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
    }

    public void mBuscar() {
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (!this.JTFFNDocumento.getText().isEmpty()) {
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                    this.xsql = "SELECT cc_documentoc.Id, Date_Format(cc_documentoc.FechaD,'%d-%m-%Y') as FechaD, cc_terceros.RazonSocialCompleta, cc_puc.Id, cc_puc.Nbre, IF(cc_detalle_documentoc.TipoCPuc=1,'C','D') AS Tipo, cc_detalle_documentoc.VDebito , cc_detalle_documentoc.VCredito, cc_detalle_documentoc.Base, cc_detalle_documentoc.Id_Radicacion, cc_tipo_documentoc.`NReporte`  FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN `cc_tipo_documentoc` ON (cc_tipo_documentoc.`Id` = cc_documentoc.`Id_TipoComprobante`) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) WHERE (cc_documentoc.Id ='" + this.JTFFNDocumento.getValue() + "' AND cc_documentoc.EstadoA =0) ";
                    ResultSet rs = this.xconsulta.traerRs(this.xsql);
                    try {
                        if (rs.next()) {
                            mCrearModeloDatos();
                            rs.first();
                            Principal.txtNo.setText(rs.getString(1));
                            Principal.txtFecha.setText(rs.getString(2));
                            this.JTFTercero.setText(rs.getString(3));
                            rs.beforeFirst();
                            int n = 0;
                            while (rs.next()) {
                                this.xmodelo.addRow(this.xdatos);
                                this.xmodelo.setValueAt(rs.getString(4), n, 0);
                                this.xmodelo.setValueAt(rs.getString(5), n, 1);
                                this.xmodelo.setValueAt(rs.getString(6), n, 2);
                                this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), n, 3);
                                this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), n, 4);
                                this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), n, 5);
                                this.xmodelo.setValueAt(Long.valueOf(rs.getLong(10)), n, 6);
                                this.xmodelo.setValueAt(rs.getString("NReporte"), n, 7);
                                n++;
                            }
                        }
                        rs.close();
                        this.xconsulta.cerrarConexionBd();
                        return;
                    } catch (SQLException ex) {
                        Logger.getLogger(JIFAutorizacionDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        return;
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "N° No pued ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFNDocumento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDoc.requestFocus();
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCambiarEstadoOrden() {
        try {
            this.xsql = "SELECT Autorizo FROM cc_detalle_firma_ordenc WHERE (Id_OrdenC ='" + Principal.txtNo.getText() + "' AND Autorizo =0) ";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xsql = "update cc_orden_compra set EstadoA=1 where Id='" + Principal.txtNo.getText() + "'";
                xct.ejecutarSQL(this.xsql);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCambiarEstadoOrdenDC() {
        try {
            this.xsql = "SELECT Autorizo FROM cc_detalle_firma_documentoc WHERE (Id_OrdenDc ='" + Principal.txtNo.getText() + "' AND Autorizo =0) ";
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            if (!xrs.next()) {
                ConsultasMySQL xct = new ConsultasMySQL();
                this.xsql = "update cc_documentoc set EstadoA=1 where Id='" + Principal.txtNo.getText() + "'";
                xct.ejecutarSQL(this.xsql);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAutorizacionDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
