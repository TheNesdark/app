package com.genoma.plus.controller.enfermeria;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.HSeguimientoPosparto;
import com.genoma.plus.jpa.projection.HSeguimientoPospartoProjection;
import com.genoma.plus.jpa.service.HSeguimientoPospartoService;
import com.genoma.plus.jpa.service.IGPersonaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JPI_SeguimientoPosparto.class */
public class JPI_SeguimientoPosparto extends JPanel {
    private DefaultTableModel xModelo_Historico;
    private Object[] datos;
    private List<HSeguimientoPospartoProjection> listaRegistroSeguimientos;
    private String idIngreso;
    private String idAtencion;
    private Long idPersona;
    public JComboBox JCBClasificacion;
    public JComboBox JCBPerfusion;
    public JComboBox JCBSensorio;
    public JComboBox JCBTonoUterino;
    private JDateChooser JDFecha;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPIPresion;
    private JScrollPane JSP_Historico;
    private JTable JTB_Historico;
    private JFormattedTextField JTFFPresionDiastolica;
    private JFormattedTextField JTFFPresionSistolica;
    private JFormattedTextField JTFFPulso;
    private JFormattedTextField JTFFVolumen;
    private JFormattedTextField JTFF_Hora;
    private JPanel jPanel2;
    private final HSeguimientoPospartoService Historico = (HSeguimientoPospartoService) Principal.contexto.getBean(HSeguimientoPospartoService.class);
    private Metodos xmt = new Metodos();
    private final HSeguimientoPospartoService hSeguimientoService = (HSeguimientoPospartoService) Principal.contexto.getBean(HSeguimientoPospartoService.class);
    private final IGPersonaService gPersonaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
    Metodos metodos = new Metodos();
    private String destino = "Observación";

    public JPI_SeguimientoPosparto(String idAtencion) {
        this.idIngreso = "0";
        this.idAtencion = "0";
        initComponents();
        this.idIngreso = this.idIngreso;
        this.idAtencion = idAtencion;
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        this.JDFecha.setDate(this.metodos.getFechaActual());
        mCrearModeloHistorico();
        cargarHistorico();
    }

    public boolean isInteger(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/enfermeria/JPI_SeguimientoPosparto$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell;
            cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String nvalidacion = table.getValueAt(row, 14).toString();
            switch (nvalidacion) {
                case "COMPENSADA":
                    cell.setBackground(new Color(247, 247, 247));
                    cell.setForeground(Color.BLACK);
                    break;
                case "LEVE":
                    cell.setBackground(new Color(0, 166, 145));
                    cell.setForeground(Color.BLACK);
                    break;
                case "MODERADO":
                    cell.setBackground(new Color(233, 207, 99));
                    cell.setForeground(Color.BLACK);
                    break;
                case "SEVERO":
                    cell.setBackground(new Color(243, 98, 67));
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setBackground(new Color(247, 247, 247));
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }

    public void cargarHistorico() {
        mCrearModeloHistorico();
        this.listaRegistroSeguimientos = this.Historico.ListarHistorico(Integer.valueOf(this.idAtencion));
        System.out.println("entra al metodo" + this.listaRegistroSeguimientos.size());
        if (this.listaRegistroSeguimientos != null && !this.listaRegistroSeguimientos.isEmpty()) {
            this.xmt.mEstablecerTextEditor(this.JTB_Historico, 2);
            this.listaRegistroSeguimientos.forEach(detalle -> {
                this.xModelo_Historico.addRow(this.datos);
                this.JTB_Historico.setValueAt(detalle.getId(), this.JTB_Historico.getRowCount() - 1, 0);
                this.JTB_Historico.setValueAt(detalle.getIdAtencion(), this.JTB_Historico.getRowCount() - 1, 1);
                this.JTB_Historico.setValueAt(detalle.getFecha(), this.JTB_Historico.getRowCount() - 1, 2);
                this.JTB_Historico.setValueAt(detalle.getHora(), this.JTB_Historico.getRowCount() - 1, 3);
                this.JTB_Historico.setValueAt(detalle.getVolumen(), this.JTB_Historico.getRowCount() - 1, 4);
                this.JTB_Historico.setValueAt(detalle.getSensorio(), this.JTB_Historico.getRowCount() - 1, 5);
                this.JTB_Historico.setValueAt(detalle.getPerfusion(), this.JTB_Historico.getRowCount() - 1, 6);
                this.JTB_Historico.setValueAt(detalle.getPulso(), this.JTB_Historico.getRowCount() - 1, 7);
                this.JTB_Historico.setValueAt(detalle.getPresionSistolica(), this.JTB_Historico.getRowCount() - 1, 8);
                this.JTB_Historico.setValueAt(detalle.getPresionDiastolica(), this.JTB_Historico.getRowCount() - 1, 9);
                this.JTB_Historico.setValueAt(detalle.getTonoUterino(), this.JTB_Historico.getRowCount() - 1, 10);
                this.JTB_Historico.setValueAt(detalle.getNProfesional(), this.JTB_Historico.getRowCount() - 1, 11);
                this.JTB_Historico.setValueAt(detalle.getEspecialidad(), this.JTB_Historico.getRowCount() - 1, 12);
                this.JTB_Historico.setValueAt(detalle.getEstado(), this.JTB_Historico.getRowCount() - 1, 13);
                this.JTB_Historico.setValueAt(detalle.getGradoDeChoque(), this.JTB_Historico.getRowCount() - 1, 14);
                this.JTB_Historico.setValueAt(detalle.getFechaRegistro(), this.JTB_Historico.getRowCount() - 1, 15);
                this.JTB_Historico.setValueAt(detalle.getIdPersona(), this.JTB_Historico.getRowCount() - 1, 16);
            });
        }
        this.JTB_Historico.setDefaultRenderer(Object.class, new MiRender());
    }

    private void sugerirGradoCoche() {
        if (isDouble(this.JTFFVolumen.getText().toString()) && isInteger(this.JTFFPresionSistolica.getText().toString()) && isInteger(this.JTFFPresionDiastolica.getText().toString()) && isInteger(this.JTFFPulso.getText().toString())) {
            double volumen = Double.valueOf(this.JTFFVolumen.getText().toString()).doubleValue();
            Integer pulso = Integer.valueOf(this.JTFFPulso.getText().toString());
            Integer presionSistolica = Integer.valueOf(this.JTFFPresionSistolica.getText().toString());
            Integer.valueOf(this.JTFFPresionDiastolica.getText().toString());
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                if (volumen >= 500.0d && volumen <= 1000.0d) {
                    this.JCBClasificacion.setSelectedIndex(1);
                    return;
                }
                if (volumen >= 1001.0d && volumen <= 1500.0d) {
                    this.JCBClasificacion.setSelectedIndex(2);
                    return;
                }
                if (volumen >= 1501.0d && volumen <= 2000.0d) {
                    this.JCBClasificacion.setSelectedIndex(3);
                    return;
                } else if (volumen >= 2001.0d && volumen <= 3000.0d) {
                    this.JCBClasificacion.setSelectedIndex(4);
                    return;
                } else {
                    this.JCBClasificacion.setSelectedIndex(-1);
                    return;
                }
            }
            if (volumen >= 500.0d && volumen <= 1000.0d && "SIN CAMBIOS".equals(this.JCBSensorio.getSelectedItem().toString()) && "NORMAL".equals(this.JCBPerfusion.getSelectedItem().toString()) && pulso.intValue() >= 60 && pulso.intValue() <= 90 && presionSistolica.intValue() <= 80) {
                this.JCBClasificacion.setSelectedIndex(1);
                return;
            }
            if (volumen >= 1001.0d && volumen <= 1500.0d && "NORMAL O AGITADA".equals(this.JCBSensorio.getSelectedItem().toString()) && "PALIDEZ FRIALDAD".equals(this.JCBPerfusion.getSelectedItem().toString()) && pulso.intValue() >= 91 && pulso.intValue() <= 100 && presionSistolica.intValue() >= 81 && presionSistolica.intValue() <= 90) {
                this.JCBClasificacion.setSelectedIndex(2);
                return;
            }
            if (volumen >= 1501.0d && volumen <= 2000.0d && "AGITADA".equals(this.JCBSensorio.getSelectedItem().toString()) && "PALIDA SUDOROSA".equals(this.JCBPerfusion.getSelectedItem().toString()) && pulso.intValue() >= 101 && pulso.intValue() <= 120 && presionSistolica.intValue() >= 81 && presionSistolica.intValue() <= 90) {
                this.JCBClasificacion.setSelectedIndex(3);
                return;
            }
            if (volumen >= 2001.0d && volumen <= 3000.0d && "LETÁRGICA".equals(this.JCBSensorio.getSelectedItem().toString()) && "LLENADO CAPILAR".equals(this.JCBPerfusion.getSelectedItem().toString()) && pulso.intValue() > 120 && presionSistolica.intValue() >= 81 && presionSistolica.intValue() <= 90) {
                this.JCBClasificacion.setSelectedIndex(4);
            } else {
                this.JCBClasificacion.setSelectedIndex(-1);
            }
        }
    }

    public void mAnular() {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                new HSeguimientoPosparto();
                HSeguimientoPosparto hSeguimientoPosparto = this.Historico.buscarPorId(Long.valueOf(this.JTB_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString()));
                if (hSeguimientoPosparto != null) {
                    hSeguimientoPosparto.setEstado(false);
                    this.Historico.grabar(hSeguimientoPosparto);
                }
            }
        }
        cargarHistorico();
    }

    public void mGrabar() {
        HSeguimientoPosparto hSeguimientoPosparto = new HSeguimientoPosparto();
        if (this.JCBClasificacion.getSelectedIndex() > 0) {
            if (isDouble(this.JTFFVolumen.getText()) && this.JCBSensorio.getSelectedIndex() > -1 && this.JCBPerfusion.getSelectedIndex() > -1 && isInteger(this.JTFFPulso.getText()) && this.JCBTonoUterino.getSelectedIndex() > -1 && isInteger(this.JTFFPresionSistolica.getText()) && isInteger(this.JTFFPresionDiastolica.getText())) {
                int x = JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    hSeguimientoPosparto.setIdAtencion(Integer.valueOf(this.idAtencion));
                    hSeguimientoPosparto.setFecha(this.JDFecha.getDate());
                    hSeguimientoPosparto.setHora(Time.valueOf(this.JTFF_Hora.getText()));
                    hSeguimientoPosparto.setVolumen(Double.valueOf(this.JTFFVolumen.getText()));
                    hSeguimientoPosparto.setSensorio(this.JCBSensorio.getSelectedItem().toString());
                    hSeguimientoPosparto.setPerfusion(this.JCBPerfusion.getSelectedItem().toString());
                    hSeguimientoPosparto.setPulso(Integer.valueOf(this.JTFFPulso.getText()));
                    hSeguimientoPosparto.setEstado(true);
                    hSeguimientoPosparto.setPresionSistolica(Integer.valueOf(this.JTFFPresionSistolica.getText()));
                    hSeguimientoPosparto.setPresionDiastolica(Integer.valueOf(this.JTFFPresionDiastolica.getText()));
                    hSeguimientoPosparto.setTonoUterino(this.JCBTonoUterino.getSelectedItem().toString());
                    hSeguimientoPosparto.setIdEspecialidad(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString()));
                    hSeguimientoPosparto.setIdProfesional(Integer.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString()));
                    hSeguimientoPosparto.setGradoDeChoque(this.JCBClasificacion.getSelectedItem().toString());
                    this.hSeguimientoService.grabar(hSeguimientoPosparto);
                    Limpiar();
                    cargarHistorico();
                }
            }
        } else {
            JOptionPane.showInternalConfirmDialog(Principal.claseenfer.xjifhc_uhh, "Verifique los datos, no se han llenado todos los campos.", "ERROR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
        this.JTFF_Hora.setValue(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xModelo_Historico = new DefaultTableModel(new Object[0], new String[]{"id", "idAtencion", "fecha", "hora", "volumen", "sensorio", "perfusion", "pulso", "presionSistolica", "presionDiastolica", "tonoUterino", "idProfesional", "idEspecialidad", "estado", "gradoDeChoque", "fechaRegistro", "idPersona"}) { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.1
            Class[] types = {Long.class, Integer.class, String.class, String.class, Double.class, String.class, String.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class, Integer.class, Boolean.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_Historico;
        JTable jTable2 = this.JTB_Historico;
        jTable.setAutoResizeMode(0);
        this.JTB_Historico.doLayout();
        this.JTB_Historico.setModel(this.xModelo_Historico);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTB_Historico.getColumnModel().getColumn(6).setPreferredWidth(130);
        this.JTB_Historico.getColumnModel().getColumn(7).setPreferredWidth(70);
        this.JTB_Historico.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTB_Historico.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(10).setPreferredWidth(190);
        this.JTB_Historico.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTB_Historico.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTB_Historico.getColumnModel().getColumn(16).setMaxWidth(0);
    }

    public void Imprimir() {
        if (this.JTB_Historico.getRowCount() > 0) {
            imprimirPantalla();
        }
    }

    private void imprimirPantalla() {
        new GPersona();
        GPersona persona = this.gPersonaService.datosPersona(Long.valueOf(this.JTB_Historico.getValueAt(0, 16).toString()));
        this.listaRegistroSeguimientos = this.Historico.ListarHistorico(Integer.valueOf(this.idAtencion));
        if (this.JTB_Historico.getRowCount() > 0) {
            try {
                ClaseImpresionInformes informes = new ClaseImpresionInformes();
                System.out.println(persona.getClass().getFields());
                System.out.println(this.listaRegistroSeguimientos.size());
                System.out.println(persona.getNombre1());
                System.out.println(this.JTB_Historico.getValueAt(0, 16).toString());
                informes.imprimirRegistroSeguimientosPosparto(this.listaRegistroSeguimientos, persona);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void Limpiar() {
        this.JTFFVolumen.setText("");
        this.JCBSensorio.setSelectedIndex(-1);
        this.JCBPerfusion.setSelectedIndex(-1);
        this.JCBTonoUterino.setSelectedIndex(-1);
        this.JTFFPulso.setValue(0);
        this.JTFFPresionSistolica.setText("0");
        this.JTFFPresionDiastolica.setText("0");
        this.JCBClasificacion.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v106, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JTFF_Hora = new JFormattedTextField();
        this.JTFFVolumen = new JFormattedTextField();
        this.JCBSensorio = new JComboBox();
        this.JCBPerfusion = new JComboBox();
        this.JTFFPulso = new JFormattedTextField();
        this.JCBTonoUterino = new JComboBox();
        this.JPIPresion = new JPanel();
        this.JTFFPresionSistolica = new JFormattedTextField();
        this.JTFFPresionDiastolica = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JCBClasificacion = new JComboBox();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        setMaximumSize(new Dimension(791, 265));
        setMinimumSize(new Dimension(0, 0));
        setName("xjpseguimientoposparto");
        this.jPanel2.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.setPreferredSize(new Dimension(125, 50));
        this.JTFF_Hora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora (HH:mm:ss)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFF_Hora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFF_Hora.setHorizontalAlignment(4);
        this.JTFF_Hora.setFont(new Font("Arial", 1, 12));
        this.JTFF_Hora.setPreferredSize(new Dimension(64, 50));
        this.JTFF_Hora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.2
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JTFF_HoraFocusLost(evt);
            }
        });
        this.JTFF_Hora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.3
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JTFF_HoraActionPerformed(evt);
            }
        });
        this.JTFF_Hora.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPI_SeguimientoPosparto.this.JTFF_HoraPropertyChange(evt);
            }
        });
        this.JTFFVolumen.setBorder(BorderFactory.createTitledBorder((Border) null, "Volumen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVolumen.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFVolumen.setHorizontalAlignment(4);
        this.JTFFVolumen.setFont(new Font("Arial", 1, 12));
        this.JTFFVolumen.setName("fechanaciemiento");
        this.JTFFVolumen.setPreferredSize(new Dimension(64, 50));
        this.JTFFVolumen.setValue(new Integer(0));
        this.JTFFVolumen.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.5
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFVolumenFocusLost(evt);
            }
        });
        this.JTFFVolumen.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.6
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFVolumenActionPerformed(evt);
            }
        });
        this.JTFFVolumen.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.7
            public void keyPressed(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFVolumenKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFVolumenKeyTyped(evt);
            }
        });
        this.JCBSensorio.setFont(new Font("Arial", 1, 12));
        this.JCBSensorio.setModel(new DefaultComboBoxModel(new String[]{"SIN CAMBIOS", "NORMAL O AGITADA", "AGITADA", "LETÁRGICA"}));
        this.JCBSensorio.setSelectedIndex(-1);
        this.JCBSensorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Sensorio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSensorio.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.8
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JCBSensorioFocusLost(evt);
            }
        });
        this.JCBSensorio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.9
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JCBSensorioActionPerformed(evt);
            }
        });
        this.JCBPerfusion.setFont(new Font("Arial", 1, 12));
        this.JCBPerfusion.setModel(new DefaultComboBoxModel(new String[]{"NORMAL", "PALIDEZ FRIALDAD", "PALIDA SUDOROSA", "LLENADO CAPILAR"}));
        this.JCBPerfusion.setSelectedIndex(-1);
        this.JCBPerfusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Perfusión", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBPerfusion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.10
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JCBPerfusionFocusLost(evt);
            }
        });
        this.JCBPerfusion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.11
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JCBPerfusionActionPerformed(evt);
            }
        });
        this.JTFFPulso.setBorder(BorderFactory.createTitledBorder((Border) null, "Pulso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPulso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPulso.setHorizontalAlignment(4);
        this.JTFFPulso.setFont(new Font("Arial", 1, 12));
        this.JTFFPulso.setName("fechanaciemiento");
        this.JTFFPulso.setValue(new Integer(0));
        this.JTFFPulso.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.12
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPulsoFocusLost(evt);
            }
        });
        this.JTFFPulso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.13
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPulsoActionPerformed(evt);
            }
        });
        this.JTFFPulso.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.14
            public void keyTyped(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPulsoKeyTyped(evt);
            }
        });
        this.JCBTonoUterino.setFont(new Font("Arial", 1, 12));
        this.JCBTonoUterino.setModel(new DefaultComboBoxModel(new String[]{"FIRME", "RELAJADO"}));
        this.JCBTonoUterino.setSelectedIndex(-1);
        this.JCBTonoUterino.setBorder(BorderFactory.createTitledBorder((Border) null, "Tono Uterino", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTonoUterino.setName("");
        this.JCBTonoUterino.setPreferredSize(new Dimension(155, 50));
        this.JCBTonoUterino.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.15
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JCBTonoUterinoFocusLost(evt);
            }
        });
        this.JCBTonoUterino.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.16
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JCBTonoUterinoActionPerformed(evt);
            }
        });
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFPresionSistolica.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPresionSistolica.setHorizontalAlignment(4);
        this.JTFFPresionSistolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPresionSistolica.setName("fechanaciemiento");
        this.JTFFPresionSistolica.setValue(new Integer(0));
        this.JTFFPresionSistolica.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.17
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionSistolicaFocusLost(evt);
            }
        });
        this.JTFFPresionSistolica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.18
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionSistolicaActionPerformed(evt);
            }
        });
        this.JTFFPresionSistolica.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.19
            public void keyTyped(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionSistolicaKeyTyped(evt);
            }
        });
        this.JTFFPresionDiastolica.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPresionDiastolica.setHorizontalAlignment(4);
        this.JTFFPresionDiastolica.setFont(new Font("Arial", 1, 12));
        this.JTFFPresionDiastolica.setName("fechanaciemiento");
        this.JTFFPresionDiastolica.setValue(new Integer(0));
        this.JTFFPresionDiastolica.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.20
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionDiastolicaFocusLost(evt);
            }
        });
        this.JTFFPresionDiastolica.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.21
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionDiastolicaActionPerformed(evt);
            }
        });
        this.JTFFPresionDiastolica.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.22
            public void keyTyped(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTFFPresionDiastolicaKeyTyped(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JLBPSentado1, -2, 130, -2).addContainerGap(-1, 32767)).addGroup(JPIPresionLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JTFFPresionSistolica, -2, 45, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBPBSentado, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPresionDiastolica, -2, 45, -2).addGap(9, 9, 9)));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPresionDiastolica, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPresionSistolica, -2, 25, -2)).addGap(18, 18, 18).addComponent(this.JLBPSentado1).addContainerGap()));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setModel(new DefaultComboBoxModel(new String[]{"-", "COMPENSADA", "LEVE", "MODERADO", "SEVERO"}));
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBClasificacion.setName("");
        this.JCBClasificacion.setPreferredSize(new Dimension(155, 50));
        this.JCBClasificacion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.23
            public void focusLost(FocusEvent evt) {
                JPI_SeguimientoPosparto.this.JCBClasificacionFocusLost(evt);
            }
        });
        this.JCBClasificacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.24
            public void actionPerformed(ActionEvent evt) {
                JPI_SeguimientoPosparto.this.JCBClasificacionActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 137, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_Hora, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVolumen, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSensorio, -2, 217, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBPerfusion, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPulso, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTonoUterino, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, -2, 137, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIPresion, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIPresion, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.JTFFVolumen, -1, -1, 32767).addComponent(this.JCBSensorio, -2, 50, -2)).addComponent(this.JTFF_Hora, -2, -1, -2).addComponent(this.JDFecha, -2, -1, -2)).addGap(0, 12, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPulso, -2, 50, -2).addComponent(this.JCBPerfusion, -2, 50, -2).addComponent(this.JCBTonoUterino, -2, -1, -2).addComponent(this.JCBClasificacion, -2, -1, -2)))).addGap(16, 16, 16)));
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSP_Historico.setName("JSP_Historico");
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.enfermeria.JPI_SeguimientoPosparto.25
            public void keyPressed(KeyEvent evt) {
                JPI_SeguimientoPosparto.this.JTB_HistoricoKeyPressed(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSP_Historico).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Historico, -2, 220, -2).addContainerGap(-1, 32767)));
        getAccessibleContext().setAccessibleName("jpiSeguimientoPosparto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionDiastolicaActionPerformed(ActionEvent evt) {
        this.JTFFPresionDiastolica.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionDiastolicaFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionSistolicaActionPerformed(ActionEvent evt) {
        this.JTFFPresionSistolica.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionSistolicaFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTonoUterinoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSensorioActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPulsoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPulsoFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVolumenActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVolumenFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_HoraFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPerfusionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVolumenKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBSensorio.setFocusable(true);
            sugerirGradoCoche();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVolumenKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && c != '\b' && c != '.') {
            evt.consume();
        }
        if (c == '.' && this.JTFFVolumen.getText().contains(".")) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPulsoKeyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && caracter != '\b') {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionSistolicaKeyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && caracter != '\b') {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPresionDiastolicaKeyTyped(KeyEvent evt) {
        char caracter = evt.getKeyChar();
        if ((caracter < '0' || caracter > '9') && caracter != '\b') {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSensorioFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPerfusionFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTonoUterinoFocusLost(FocusEvent evt) {
        sugerirGradoCoche();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacionFocusLost(FocusEvent evt) {
    }
}
