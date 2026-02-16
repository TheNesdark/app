package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.ImpresionDocumentosHC;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO;
import com.genoma.plus.dao.historia.HNotasClinicaDAO;
import com.genoma.plus.dao.historia.HOrdenInterconsultaDAO;
import com.genoma.plus.dao.historia.HSignosVitalesDAO;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl;
import com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl;
import com.genoma.plus.dao.impl.historia.HOrdenInterconsultaDAOImpl;
import com.genoma.plus.dao.impl.historia.HSignosVitalesDAOImpl;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dto.historia.HNotasClinicasDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_NotasProcedimientosMenores.class */
public class JPA_NotasProcedimientosMenores extends JPanel {
    private DefaultTableModel xmodelo;
    private HistoriaDAO xHistoriaDAO;
    private PatologiaCie10DAO xPatologiaCie10DAO;
    private HNotasClinicaDAO xHNotasClinicaDAO;
    private HSignosVitalesDAO xHSignosVitalesDAO;
    private HNotaClinicaDiagnosticoDAO xHNotaClinicaDiagnosticoDAO;
    private HOrdenInterconsultaDAO xHOrdenInterconsultaDAO;
    private String[][] xIdTipoNota;
    private String[] xIdEspecialidadInterc;
    private String xsql;
    private JInternalFrame xjif;
    private long xId_Atencion;
    private long xIdIngreso;
    private String xTipoAtencion;
    private String xId_AtencionEsp;
    private String xFiltro;
    private Object[] xdatos;
    private JButton JBTGuardarTemp;
    private JComboBox JCBTipoNota;
    private JDateChooser JDCFecha;
    private JPanel JPI_Historico;
    private JPanel JPI_Nota;
    private JScrollPane JSPDetalleNotas;
    private JScrollPane JSPNotas;
    private JScrollPane JSP_Complicacion;
    private JScrollPane JSP_Observacion;
    private JScrollPane JSP_ProcedimentoR;
    private JTable JTBDetalle;
    private JFormattedTextField JTFFHora;
    public JTextField JTFNNota;
    private JTabbedPane JTPDatos;
    public JTextPane JTPNota;
    private JTextPane JTP_Complicacion;
    private JTextPane JTP_Observacion;
    private JTextPane JTP_ProcedimentoR;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private long xCerrarFac = 0;

    public JPA_NotasProcedimientosMenores(JInternalFrame xjif, Long xId_Atencion, String xTipoAtencion, String xId_AtencionEsp, Long xIdIngreso, String xFiltro, String titulo) {
        this.xId_Atencion = 0L;
        this.xIdIngreso = 0L;
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, titulo, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        springStart();
        this.xjif = xjif;
        this.xIdIngreso = xIdIngreso.longValue();
        this.xId_Atencion = xId_Atencion.longValue();
        this.xTipoAtencion = xTipoAtencion;
        this.xId_AtencionEsp = xId_AtencionEsp;
        this.xFiltro = xFiltro;
        mNuevo();
    }

    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPI_Nota = new JPanel();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JBTGuardarTemp = new JButton();
        this.JTFNNota = new JTextField();
        this.JSP_ProcedimentoR = new JScrollPane();
        this.JTP_ProcedimentoR = new JTextPane();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JSP_Observacion = new JScrollPane();
        this.JTP_Observacion = new JTextPane();
        this.JSP_Complicacion = new JScrollPane();
        this.JTP_Complicacion = new JTextPane();
        this.JPI_Historico = new JPanel();
        this.JSPDetalleNotas = new JScrollPane();
        this.JTBDetalle = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TITULO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpi_notas_procedimientosmenores");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.setName("jpprocedimentosMenoresN");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.1
            public void focusLost(FocusEvent evt) {
                JPA_NotasProcedimientosMenores.this.JDCFechaFocusLost(evt);
            }
        });
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPA_NotasProcedimientosMenores.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora (HH:mm:ss)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.3
            public void focusLost(FocusEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTFFHoraFocusLost(evt);
            }
        });
        this.JTFFHora.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTFFHoraPropertyChange(evt);
            }
        });
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 137, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JCBTipoNota, -2, 434, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBTipoNota, -2, 50, -2)).addComponent(this.JDCFecha, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JBTGuardarTemp.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp.setText("Guardar");
        this.JBTGuardarTemp.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.5
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasProcedimientosMenores.this.JBTGuardarTempActionPerformed(evt);
            }
        });
        this.JTFNNota.setFont(new Font("Arial", 1, 24));
        this.JTFNNota.setHorizontalAlignment(0);
        this.JTFNNota.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_ProcedimentoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento Realizado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_ProcedimentoR.setFont(new Font("Arial", 1, 12));
        this.JTP_ProcedimentoR.setFont(new Font("Arial", 1, 12));
        this.JTP_ProcedimentoR.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.6
            public void keyPressed(KeyEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTP_ProcedimentoRKeyPressed(evt);
            }
        });
        this.JSP_ProcedimentoR.setViewportView(this.JTP_ProcedimentoR);
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JTPNota.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.7
            public void keyPressed(KeyEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTPNotaKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JSP_Observacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Observacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Observacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.8
            public void keyPressed(KeyEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTP_ObservacionKeyPressed(evt);
            }
        });
        this.JSP_Observacion.setViewportView(this.JTP_Observacion);
        this.JSP_Complicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Complicación", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_Complicacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Complicacion.setFont(new Font("Arial", 1, 12));
        this.JTP_Complicacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.9
            public void keyPressed(KeyEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTP_ComplicacionKeyPressed(evt);
            }
        });
        this.JSP_Complicacion.setViewportView(this.JTP_Complicacion);
        GroupLayout JPI_NotaLayout = new GroupLayout(this.JPI_Nota);
        this.JPI_Nota.setLayout(JPI_NotaLayout);
        JPI_NotaLayout.setHorizontalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSP_ProcedimentoR, GroupLayout.Alignment.TRAILING).addComponent(this.JSPNotas).addComponent(this.JSP_Observacion).addComponent(this.JSP_Complicacion, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NotaLayout.createSequentialGroup().addComponent(this.JBTGuardarTemp, -2, 333, -2).addGap(267, 267, 267).addComponent(this.JTFNNota))).addContainerGap()));
        JPI_NotaLayout.setVerticalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_ProcedimentoR, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNotas, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Observacion, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Complicacion, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNNota, -2, 50, -2).addComponent(this.JBTGuardarTemp, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("NOTA", this.JPI_Nota);
        this.JPI_Historico.setAutoscrolls(true);
        this.JPI_Historico.setName("xjphistoricoa");
        this.JSPDetalleNotas.setBorder((Border) null);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.10
            public void mouseClicked(MouseEvent evt) {
                JPA_NotasProcedimientosMenores.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleNotas.setViewportView(this.JTBDetalle);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 762, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(8, 32767).addComponent(this.JSPDetalleNotas, -2, 746, -2).addContainerGap(8, 32767))));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 549, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalleNotas, -2, 530, -2).addContainerGap(13, 32767))));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addGap(16, 16, 16)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatos, -2, 595, -2).addGap(0, 6, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            System.out.println(this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            System.out.println(this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ProcedimentoRKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTP_ProcedimentoR.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPNotaKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 9) {
            this.JTPNota.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this.xjif, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPNota.setText(this.JTPNota.getText().substring(0, this.JTPNota.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ObservacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTP_Observacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_ComplicacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTP_Complicacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getRowCount() != -1 && this.JTBDetalle.getSelectedRow() != -1) {
            this.JTFNNota.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.JDCFecha.setDate(this.xmt.getPasarTextoaFecha(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString()));
            this.JTFFHora.setValue(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 3));
            this.JCBTipoNota.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1));
            this.JTP_ProcedimentoR.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            this.JTPNota.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            this.JTP_Observacion.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString());
            this.JTP_Complicacion.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString());
            this.JTPDatos.setSelectedIndex(0);
        }
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        } else if (valor > 0 && valor > 90) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFNNota.setText("");
        this.JTPNota.setText("");
        mLLenarCombo();
        mCargarDatosHistorico();
        this.JTP_ProcedimentoR.setText("");
    }

    public void mImprimir() {
        if (!this.JTFNNota.getText().isEmpty() && this.JCBTipoNota.getSelectedIndex() != -1 && !this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][3].equals("")) {
            ImpresionDocumentosHC impresionDocumentos = new ImpresionDocumentosHC();
            impresionDocumentos.mImprimirNotasClinciasNuevasIdNota(this.JCBTipoNota.getSelectedItem().toString(), this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][4], String.valueOf(this.xId_Atencion), this.JTFNNota.getText());
        }
    }

    private void mLLenarCombo() {
        this.JCBTipoNota.removeAllItems();
        List<Object[]> listTipoNota = this.xHistoriaDAO.listadoTipoNotasporEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), this.xFiltro);
        if (!listTipoNota.isEmpty()) {
            this.xIdTipoNota = new String[listTipoNota.size()][6];
            for (int i = 0; i < listTipoNota.size(); i++) {
                this.xIdTipoNota[i][0] = String.valueOf(listTipoNota.get(i)[0]);
                this.xIdTipoNota[i][1] = String.valueOf(listTipoNota.get(i)[1]);
                this.xIdTipoNota[i][2] = String.valueOf(listTipoNota.get(i)[2]);
                this.xIdTipoNota[i][3] = String.valueOf(listTipoNota.get(i)[3]);
                this.xIdTipoNota[i][4] = String.valueOf(listTipoNota.get(i)[4]);
                this.xIdTipoNota[i][5] = String.valueOf(listTipoNota.get(i)[5]);
                this.JCBTipoNota.addItem(listTipoNota.get(i)[1]);
            }
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xPatologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.xHistoriaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.xHNotasClinicaDAO = (HNotaClinicaDAOImpl) classPathXmlApplicationContext.getBean("hNotaClinicaDAOImpl");
        this.xHSignosVitalesDAO = (HSignosVitalesDAOImpl) classPathXmlApplicationContext.getBean("hSignosVitalesDAOImpl");
        this.xHNotaClinicaDiagnosticoDAO = (HNotaClinicaDiagnosticoDAOImpl) classPathXmlApplicationContext.getBean("hNotaClinicaDiagnosticoDAOImpl");
        this.xHOrdenInterconsultaDAO = (HOrdenInterconsultaDAOImpl) classPathXmlApplicationContext.getBean("hOrdenInterconsultaDAOImpl");
    }

    private void mGrabar() {
        if (this.JCBTipoNota.getSelectedIndex() != -1) {
            if (!this.JTPNota.getText().isEmpty()) {
                if (!this.JTP_ProcedimentoR.getText().isEmpty()) {
                    mGrabarM();
                    mCargarDatosHistorico();
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "El campo estado general no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTP_ProcedimentoR.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "El campo evolucion no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNNota.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoNota.requestFocus();
    }

    private void mGrabarM() {
        HNotasClinicasDTO n = new HNotasClinicasDTO();
        n.setFechaNota(this.xmt.formatoAMD1.format(this.JDCFecha.getDate()));
        n.setHoraNota(this.JTFFHora.getText());
        n.setIdTipoNota(Integer.valueOf(this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][0]));
        n.setDescripcion(this.JTPNota.getText());
        n.setEstado(true);
        n.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        n.setIdAtencion(Long.valueOf(this.xId_Atencion));
        n.setIdEndodoncia(0);
        n.setIdEspecialidad(Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()));
        n.setIdOrdenF(0L);
        n.setIdProfesional(Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()));
        n.setIdTipoAtencion(Integer.valueOf(this.xTipoAtencion));
        n.setNCierre(false);
        n.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        n.setNombreProcedimiento(this.JTP_ProcedimentoR.getText());
        n.setComplicacionP(this.JTP_Complicacion.getText());
        n.setObservacionP(this.JTP_Observacion.getText());
        if (this.JTFNNota.getText().isEmpty()) {
            Long xIdNota = this.xHNotasClinicaDAO.mCrear(n);
            this.JTFNNota.setText("" + xIdNota);
        } else {
            n.setId(Long.valueOf(this.JTFNNota.getText()));
            this.xHNotasClinicaDAO.mActualizar(n);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Nota", "Fecha", "Hora", "Procedimiento", "Descripción", "Observación", "Complicación", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.historia.JPA_NotasProcedimientosMenores.11
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatosHistorico() {
        List<Object[]> list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, "");
        mCrearTabla();
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 4);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 5);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 6);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(list.get(x)[0], x, 0);
            this.xmodelo.setValueAt(list.get(x)[1], x, 1);
            this.xmodelo.setValueAt(list.get(x)[2], x, 2);
            this.xmodelo.setValueAt(list.get(x)[3], x, 3);
            this.xmodelo.setValueAt(list.get(x)[7], x, 4);
            this.xmodelo.setValueAt(list.get(x)[5], x, 5);
            this.xmodelo.setValueAt(list.get(x)[8], x, 6);
            this.xmodelo.setValueAt(list.get(x)[9], x, 7);
            this.xmodelo.setValueAt(list.get(x)[10], x, 8);
            this.xmodelo.setValueAt(list.get(x)[11], x, 9);
        }
    }
}
