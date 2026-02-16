package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import General.Anular;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SC_EventoAdversoDAOImpl;
import com.genoma.plus.dao.sgc.SC_EventoAdversoDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SC_EventoAdversoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JPEventoAdverso.class */
public class JPEventoAdverso extends JPanel {
    private SC_EventoAdversoDAO xSC_EventoAdversoDAO;
    private int xmodulo;
    private String[] xIdRiesgo;
    private String[] xidTipoProceso;
    private Boolean xEsmodal;
    private String xidIngreso;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private boolean xLleno;
    private boolean xLleno1;
    private JButton JBT_Acciones;
    private JButton JBT_Acciones1;
    private JComboBox JCBTipoProceso;
    private JComboBox JCBTipoRiesgoE;
    private JCheckBox JCHAccPrevent;
    private JCheckBox JCHEsPanorama;
    private JCheckBox JCHEstado;
    public JDateChooser JDFFechaE;
    private JPanel JPHistorico;
    private JPanel JPInformacion;
    private JScrollPane JSPAccion;
    private JScrollPane JSPDLesiones;
    private JScrollPane JSPDescripcion1;
    private JScrollPane JSPDescripcion2;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextPane JTPAccion;
    private JTextPane JTPDLesiones;
    private JTabbedPane JTPDatos;
    private JTextPane JTPDescripcion2;
    private JTextPane JTPDescripcionE;
    public JFormattedTextField txtHora;
    private Metodos xmt = new Metodos();
    private int xAccPrevent = 0;
    private int xEsPanorama = 0;
    private int xEstado = 1;
    private int xguardar = 0;
    private int xidPersona = 0;
    private String xidEventoA = "0";

    public JPEventoAdverso(Boolean xEsmodal, String xidIngreso, int xmodulo) {
        initComponents();
        springStart();
        this.xEsmodal = xEsmodal;
        this.xidIngreso = xidIngreso;
        this.xmodulo = xmodulo;
        mNuevo();
    }

    private void springStart() {
        this.xSC_EventoAdversoDAO = (SC_EventoAdversoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sCEventoAdversoDAO");
    }

    public void mNuevo() {
        this.JDFFechaE.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.JTPDescripcionE.setText("");
        this.JTPDLesiones.setText("");
        this.JTPAccion.setText("");
        this.JCHAccPrevent.setSelected(false);
        this.xAccPrevent = 0;
        this.JCHEsPanorama.setSelected(false);
        this.xEsPanorama = 0;
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.xguardar = 0;
        this.xidPersona = Integer.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().toString()).intValue();
        mLLenaCombo();
        mCargarDatosTabla();
    }

    private void mLLenaCombo() {
        this.xLleno = false;
        this.JCBTipoProceso.removeAllItems();
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
    }

    public void mGrabar() {
        int n;
        if (!this.txtHora.getText().isEmpty()) {
            if (this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
                if (!this.JTPDescripcionE.getText().isEmpty()) {
                    if (!this.JTPDLesiones.getText().isEmpty()) {
                        if (!this.JTPAccion.getText().isEmpty()) {
                            Boolean bool = true;
                            this.xEsmodal = bool;
                            if (bool.booleanValue()) {
                                n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            } else {
                                n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            }
                            if (n == 0) {
                                if (this.xguardar == 0) {
                                    this.xidEventoA = null;
                                    SC_EventoAdversoDTO e = new SC_EventoAdversoDTO();
                                    e.setFecha(this.xmt.formatoAMD.format(this.JDFFechaE.getDate()));
                                    e.setHora(this.xmt.formatoH24.format(this.txtHora.getValue()));
                                    e.setIdIngreso(Integer.valueOf(this.xidIngreso).intValue());
                                    e.setIdTProceso(this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()]);
                                    e.setPersonaR(this.xidPersona);
                                    e.setIdTRiesgoE(this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()]);
                                    e.setDescripcion(this.JTPDescripcionE.getText());
                                    e.setEstaI(this.xEsPanorama);
                                    e.setTAPreventiva(this.xAccPrevent);
                                    e.setDetalleLesion(this.JTPDLesiones.getText());
                                    e.setAccionT(this.JTPAccion.getText());
                                    e.setEstado(this.xEstado);
                                    this.xidEventoA = this.xSC_EventoAdversoDAO.create_return_id(e);
                                    this.xmt.mEnvioCorreoElectronico("Se ha generado un posible evento adverso, identificado con el Nº " + this.xidEventoA + " \nfavor entrar a Genoma Plus y revisar.\nFecha: " + this.xmt.formatoAMD.format(this.JDFFechaE.getDate()) + " Hora: " + this.xmt.formatoH24.format(this.txtHora.getValue()) + "\n\nTipo de proceso: " + this.JCBTipoProceso.getSelectedItem() + "\n\nTipo de evento: " + this.JCBTipoRiesgoE.getSelectedItem() + "\n\nDescripcion del evento: " + this.JTPDescripcionE.getText() + "\n\nDetalles de Lesiones/daños/Impactos: " + this.JTPDLesiones.getText() + "\n\nAccion Inmediata o Correctivos Tomados: " + this.JTPAccion.getText() + "\n\n\nReporta: " + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.usuarioSistemaDTO.getNombreCargoUsuario(), Principal.informacionIps.getEmailSistemaCalidad(), "SEGURIDAD CLINICA - REPORTE DE CASO Nº " + this.xidEventoA, Principal.usuarioSistemaDTO.getLogin());
                                } else if (Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue() == this.xidPersona || Principal.informacionGeneralPrincipalDTO.getEsModificable().intValue() == 1) {
                                    SC_EventoAdversoDTO e2 = new SC_EventoAdversoDTO();
                                    e2.setFecha(this.xmt.formatoAMD.format(this.JDFFechaE.getDate()));
                                    e2.setHora(this.xmt.formatoH24.format(this.txtHora.getValue()));
                                    e2.setIdIngreso(Integer.valueOf(this.xidIngreso).intValue());
                                    e2.setIdTProceso(this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()]);
                                    e2.setPersonaR(this.xidPersona);
                                    e2.setIdTRiesgoE(this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()]);
                                    e2.setDescripcion(this.JTPDescripcionE.getText());
                                    e2.setEstaI(this.xEsPanorama);
                                    e2.setTAPreventiva(this.xAccPrevent);
                                    e2.setDetalleLesion(this.JTPDLesiones.getText());
                                    e2.setAccionT(this.JTPAccion.getText());
                                    e2.setEstado(this.xEstado);
                                    e2.setId(Integer.valueOf(this.xidEventoA).intValue());
                                    this.xSC_EventoAdversoDAO.update(e2);
                                } else {
                                    Boolean bool2 = true;
                                    this.xEsmodal = bool2;
                                    if (bool2.booleanValue()) {
                                        JOptionPane.showMessageDialog(this, "Solo la persona que reporta el evento puede modificar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Solo la persona que reporta el evento puede modificar el registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    }
                                    this.JTPAccion.requestFocus();
                                }
                                mNuevo();
                                return;
                            }
                            return;
                        }
                        Boolean bool3 = true;
                        this.xEsmodal = bool3;
                        if (bool3.booleanValue()) {
                            JOptionPane.showMessageDialog(this, "Debe digitar una acciòn inmediata o correctiva", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe digitar una acciòn inmediata o correctiva", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        }
                        this.JTPAccion.requestFocus();
                        return;
                    }
                    Boolean bool4 = true;
                    this.xEsmodal = bool4;
                    if (bool4.booleanValue()) {
                        JOptionPane.showMessageDialog(this, "Debe digitar los detalles de las lesiones", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe digitar los detalles de las lesiones", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    }
                    this.JTPDLesiones.requestFocus();
                    return;
                }
                Boolean bool5 = true;
                this.xEsmodal = bool5;
                if (bool5.booleanValue()) {
                    JOptionPane.showMessageDialog(this, "Debe digitar una descripciòn", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe digitar una descripciòn", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                }
                this.JTPDescripcionE.requestFocus();
                return;
            }
            Boolean bool6 = true;
            this.xEsmodal = bool6;
            if (bool6.booleanValue()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
            this.JCBTipoRiesgoE.requestFocus();
            return;
        }
        Boolean bool7 = true;
        this.xEsmodal = bool7;
        if (bool7.booleanValue()) {
            JOptionPane.showMessageDialog(this, "Debe digitar una hora", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar una hora", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
        this.txtHora.requestFocus();
    }

    public void mImprimir() {
        if (!"0".equals(this.xidEventoA) && !this.xidEventoA.isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.xidEventoA;
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "EventoAdverso", parametros);
            return;
        }
        Boolean bool = true;
        this.xEsmodal = bool;
        if (bool.booleanValue()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    public void mAnular() {
        int x;
        if (this.JTDetalle.getSelectedRow() != -1) {
            Boolean bool = true;
            this.xEsmodal = bool;
            if (bool.booleanValue()) {
                x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            } else {
                x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
            if (x == 0) {
                Anular frm = new Anular(null, true, "xjpeventoadverso", this.xmodulo);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular(String xid, String xdetalle) {
        SC_EventoAdversoDTO e = new SC_EventoAdversoDTO();
        e.setIdAnulado(Integer.valueOf(xid).intValue());
        e.setMotivoAnulacion(xdetalle);
        e.setFechaAnulacion(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        e.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        e.setId(Integer.valueOf(this.xidEventoA).intValue());
        this.xSC_EventoAdversoDAO.delete(e);
        mNuevo();
    }

    private void mCargar_NotasP() {
        if (this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
            JDAccionesPredefinidas dialog = new JDAccionesPredefinidas(null, true, this.JTPAccion, 0, this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()]);
            dialog.setLocationRelativeTo(this.JTPDatos);
            dialog.setVisible(true);
        } else {
            Boolean bool = true;
            this.xEsmodal = bool;
            if (bool.booleanValue()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
            this.JCBTipoRiesgoE.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Tipo Proceso", "Id_PersonaR", "Riesgo Evento", "Descripcion", "EsPanorama?", "EsAccionP?", "DLesiones", "AccionesT", "Activo"}) { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.1
            Class[] types = {Long.class, String.class, String.class, String.class, Integer.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<SC_EventoAdversoDTO> list = this.xSC_EventoAdversoDAO.list(this.xidIngreso);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFecha(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getHora(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getIdTProceso(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPersonaR()), x, 4);
            this.xmodelo.setValueAt(list.get(x).getIdTRiesgoE(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getDescripcion(), x, 6);
            if (list.get(x).getEstaI() == 1) {
                this.xmodelo.setValueAt(true, x, 7);
            } else {
                this.xmodelo.setValueAt(false, x, 7);
            }
            if (list.get(x).getTAPreventiva() == 1) {
                this.xmodelo.setValueAt(true, x, 8);
            } else {
                this.xmodelo.setValueAt(false, x, 8);
            }
            this.xmodelo.setValueAt(list.get(x).getDetalleLesion(), x, 9);
            this.xmodelo.setValueAt(list.get(x).getAccionT(), x, 10);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 11);
            } else {
                this.xmodelo.setValueAt(false, x, 11);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v77, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDescripcion2 = new JScrollPane();
        this.JTPDescripcion2 = new JTextPane();
        this.JTPDatos = new JTabbedPane();
        this.JPInformacion = new JPanel();
        this.txtHora = new JFormattedTextField();
        this.JDFFechaE = new JDateChooser();
        this.JCHEsPanorama = new JCheckBox();
        this.JCHAccPrevent = new JCheckBox();
        this.JSPDLesiones = new JScrollPane();
        this.JTPDLesiones = new JTextPane();
        this.JSPDescripcion1 = new JScrollPane();
        this.JTPDescripcionE = new JTextPane();
        this.JCHEstado = new JCheckBox();
        this.JCBTipoRiesgoE = new JComboBox();
        this.JBT_Acciones = new JButton();
        this.JSPAccion = new JScrollPane();
        this.JTPAccion = new JTextPane();
        this.JCBTipoProceso = new JComboBox();
        this.JBT_Acciones1 = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTPDescripcion2.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDescripcion2.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion2.setViewportView(this.JTPDescripcion2);
        setName("xjpeventoadverso");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.2
            public void keyPressed(KeyEvent evt) {
                JPEventoAdverso.this.txtHoraKeyPressed(evt);
            }
        });
        this.JDFFechaE.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaE.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaE.setFont(new Font("Arial", 1, 12));
        this.JCHEsPanorama.setFont(new Font("Arial", 1, 12));
        this.JCHEsPanorama.setText("EsPanorama?");
        this.JCHEsPanorama.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.3
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JCHEsPanoramaActionPerformed(evt);
            }
        });
        this.JCHAccPrevent.setFont(new Font("Arial", 1, 12));
        this.JCHAccPrevent.setText("Accion Preventiva?");
        this.JCHAccPrevent.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.4
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JCHAccPreventActionPerformed(evt);
            }
        });
        this.JSPDLesiones.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalles de Lesiones/daños/Impactos: (Naturaleza y extensión de lesiones / daños / impactos)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDLesiones.setBorder(BorderFactory.createTitledBorder((Border) null, "", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDLesiones.setFont(new Font("Arial", 1, 12));
        this.JTPDLesiones.setPreferredSize((Dimension) null);
        this.JSPDLesiones.setViewportView(this.JTPDLesiones);
        this.JSPDescripcion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripciòn del evento:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDescripcionE.setBorder(BorderFactory.createTitledBorder((Border) null, "", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDescripcionE.setFont(new Font("Arial", 1, 12));
        this.JTPDescripcionE.setPreferredSize((Dimension) null);
        this.JSPDescripcion1.setViewportView(this.JTPDescripcionE);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Activo");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.5
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTipoRiesgoE.setFont(new Font("Arial", 1, 12));
        this.JCBTipoRiesgoE.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Evento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoRiesgoE.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.6
            public void itemStateChanged(ItemEvent evt) {
                JPEventoAdverso.this.JCBTipoRiesgoEItemStateChanged(evt);
            }
        });
        this.JCBTipoRiesgoE.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.7
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JCBTipoRiesgoEActionPerformed(evt);
            }
        });
        this.JBT_Acciones.setFont(new Font("Arial", 1, 12));
        this.JBT_Acciones.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_Acciones.setText("Acciones Predefinidas");
        this.JBT_Acciones.setPreferredSize((Dimension) null);
        this.JBT_Acciones.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.8
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JBT_AccionesActionPerformed(evt);
            }
        });
        this.JBT_Acciones.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.9
            public void keyPressed(KeyEvent evt) {
                JPEventoAdverso.this.JBT_AccionesKeyPressed(evt);
            }
        });
        this.JSPAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Acciòn Inmediata o Correctivos Tomados:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPAccion.setFont(new Font("Arial", 1, 12));
        this.JTPAccion.setPreferredSize((Dimension) null);
        this.JSPAccion.setViewportView(this.JTPAccion);
        this.JCBTipoProceso.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Proceso", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoProceso.setPreferredSize((Dimension) null);
        this.JCBTipoProceso.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.10
            public void itemStateChanged(ItemEvent evt) {
                JPEventoAdverso.this.JCBTipoProcesoItemStateChanged(evt);
            }
        });
        this.JBT_Acciones1.setFont(new Font("Arial", 1, 12));
        this.JBT_Acciones1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBT_Acciones1.setToolTipText("Visualizar Panorama");
        this.JBT_Acciones1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.11
            public void actionPerformed(ActionEvent evt) {
                JPEventoAdverso.this.JBT_Acciones1ActionPerformed(evt);
            }
        });
        this.JBT_Acciones1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.12
            public void keyPressed(KeyEvent evt) {
                JPEventoAdverso.this.JBT_Acciones1KeyPressed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoRiesgoE, 0, -1, 32767).addComponent(this.JSPAccion).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addComponent(this.JBT_Acciones, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Acciones1, -2, 62, -2).addGap(61, 61, 61).addComponent(this.JCHEsPanorama).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAccPrevent).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addComponent(this.JSPDLesiones).addComponent(this.JSPDescripcion1, GroupLayout.Alignment.TRAILING).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JDFFechaE, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHora, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoProceso, 0, -1, 32767))).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGap(17, 17, 17).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtHora, -2, -1, -2).addComponent(this.JCBTipoProceso, -2, -1, -2)).addComponent(this.JDFFechaE, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoRiesgoE, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JSPDescripcion1, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDLesiones, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAccion, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsPanorama).addComponent(this.JCHAccPrevent).addComponent(this.JCHEstado)).addComponent(this.JBT_Acciones1).addComponent(this.JBT_Acciones, -2, -1, -2)).addGap(26, 26, 26)));
        this.JTPDatos.addTab("DATOS", this.JPInformacion);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JPEventoAdverso.13
            public void mouseClicked(MouseEvent evt) {
                JPEventoAdverso.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 687, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 365, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÒRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -1, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 423, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAccPreventActionPerformed(ActionEvent evt) {
        if (this.JCHAccPrevent.isSelected()) {
            this.xAccPrevent = 1;
        } else {
            this.xAccPrevent = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsPanoramaActionPerformed(ActionEvent evt) {
        if (this.JCHEsPanorama.isSelected()) {
            this.xEsPanorama = 1;
        } else {
            this.xEsPanorama = 0;
        }
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
    public void JCBTipoRiesgoEItemStateChanged(ItemEvent evt) {
        if (this.xLleno1 && this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
            List<SC_EventoAdversoDTO> list = this.xSC_EventoAdversoDAO.listaCheck(this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()]);
            if (list.size() != 0) {
                if (list.get(0).getEstaI() == 1) {
                    this.xEsPanorama = 1;
                    this.JCHEsPanorama.setSelected(true);
                } else {
                    this.xEsPanorama = 0;
                    this.JCHEsPanorama.setSelected(false);
                }
                if (list.get(0).getTAPreventiva() == 1) {
                    this.xAccPrevent = 1;
                    this.JCHAccPrevent.setSelected(true);
                } else {
                    this.xAccPrevent = 0;
                    this.JCHAccPrevent.setSelected(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AccionesActionPerformed(ActionEvent evt) {
        mCargar_NotasP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AccionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargar_NotasP();
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xidEventoA = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            this.JDFFechaE.setDate(Date.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            this.txtHora.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBTipoProceso.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.xidPersona = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).intValue();
            this.JCBTipoRiesgoE.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTPDescripcionE.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JCHEsPanorama.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHEsPanorama.isSelected()) {
                this.xEsPanorama = 1;
            } else {
                this.xEsPanorama = 0;
            }
            this.JCHAccPrevent.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            if (this.JCHAccPrevent.isSelected()) {
                this.xAccPrevent = 1;
            } else {
                this.xAccPrevent = 0;
            }
            this.JTPDLesiones.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JTPAccion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            this.xguardar = 1;
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoRiesgoEActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Acciones1ActionPerformed(ActionEvent evt) {
        if (this.JCBTipoProceso.getSelectedIndex() != -1) {
            if (this.JCBTipoRiesgoE.getSelectedIndex() != -1) {
                Object[] botones = {"Proceso", "Evento", "Cerrar"};
                String[][] parametros = new String[4][2];
                parametros[0][0] = "IdTipoProceso";
                parametros[1][0] = "IdTipoEvento";
                parametros[0][1] = this.xidTipoProceso[this.JCBTipoProceso.getSelectedIndex()];
                parametros[1][1] = this.xIdRiesgo[this.JCBTipoRiesgoE.getSelectedIndex()];
                parametros[2][0] = "SUBREPORT_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[3][0] = "SUBREPORTFIRMA_DIR";
                parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                int n = JOptionPane.showOptionDialog(this, "Desea Visualizar el Panorama por:", "Consultar", 0, 3, (Icon) null, botones, "Cerrar");
                if (n == 0) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Sgc_Panorama_Eventos_Proceso", parametros);
                    return;
                } else {
                    if (n == 1) {
                        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Sgc_Panorama_Eventos", parametros);
                        return;
                    }
                    return;
                }
            }
            Boolean bool = true;
            this.xEsmodal = bool;
            if (bool.booleanValue()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Evento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
        }
        Boolean bool2 = true;
        this.xEsmodal = bool2;
        if (bool2.booleanValue()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Tipo de Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Acciones1KeyPressed(KeyEvent evt) {
    }
}
