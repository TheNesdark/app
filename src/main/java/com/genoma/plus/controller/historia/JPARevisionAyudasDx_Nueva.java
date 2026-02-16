package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.ResultadoAyudasDiagnosticasDAO;
import com.genoma.plus.dao.impl.historia.ResultadoAyudasDiagnosticasDAOImpl;
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
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPARevisionAyudasDx_Nueva.class */
public class JPARevisionAyudasDx_Nueva extends JPanel {
    private String xnombre;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private clasesHistoriaCE xclase;
    private String[] idTipoDocumento;
    private ResultadoAyudasDiagnosticasDAO ayudasDiagnosticasDAO;
    private JButton JBTGuardarTemporal;
    private JComboBox JCBTipoDocumento;
    private JPanel JPIRevisionExa;
    private JScrollPane JSPInterpretacion;
    private JScrollPane JSPRevisionExa;
    private JTable JTBRevisionExa;
    private JTextPane JTPInterpretacion;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean estadoCombo = false;

    public JPARevisionAyudasDx_Nueva(clasesHistoriaCE xclase, String xnombre) {
        initComponents();
        springStart();
        this.xclase = xclase;
        this.xnombre = xnombre;
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIRevisionExa = new JPanel();
        this.JSPRevisionExa = new JScrollPane();
        this.JTBRevisionExa = new JTable();
        this.JBTGuardarTemporal = new JButton();
        this.JSPInterpretacion = new JScrollPane();
        this.JTPInterpretacion = new JTextPane();
        this.JCBTipoDocumento = new JComboBox();
        setName("jpayudasdx_nueva");
        setPreferredSize(new Dimension(801, 469));
        this.JSPRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBRevisionExa.setFont(new Font("Arial", 1, 12));
        this.JTBRevisionExa.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRevisionExa.setRowHeight(25);
        this.JTBRevisionExa.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRevisionExa.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRevisionExa.setSelectionMode(0);
        this.JTBRevisionExa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPARevisionAyudasDx_Nueva.1
            public void mouseClicked(MouseEvent evt) {
                JPARevisionAyudasDx_Nueva.this.JTBRevisionExaMouseClicked(evt);
            }
        });
        this.JSPRevisionExa.setViewportView(this.JTBRevisionExa);
        this.JBTGuardarTemporal.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarTemporal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardarTemporal.setText("Guardar");
        this.JBTGuardarTemporal.setEnabled(false);
        this.JBTGuardarTemporal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPARevisionAyudasDx_Nueva.2
            public void actionPerformed(ActionEvent evt) {
                JPARevisionAyudasDx_Nueva.this.JBTGuardarTemporalActionPerformed(evt);
            }
        });
        this.JBTGuardarTemporal.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPARevisionAyudasDx_Nueva.3
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDx_Nueva.this.JBTGuardarTemporalKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INTERPRETACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPInterpretacion.setEditable(false);
        this.JTPInterpretacion.setFont(new Font("Arial", 1, 12));
        this.JTPInterpretacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPARevisionAyudasDx_Nueva.4
            public void keyPressed(KeyEvent evt) {
                JPARevisionAyudasDx_Nueva.this.JTPInterpretacionKeyPressed(evt);
            }
        });
        this.JSPInterpretacion.setViewportView(this.JTPInterpretacion);
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPARevisionAyudasDx_Nueva.5
            public void itemStateChanged(ItemEvent evt) {
                JPARevisionAyudasDx_Nueva.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        GroupLayout JPIRevisionExaLayout = new GroupLayout(this.JPIRevisionExa);
        this.JPIRevisionExa.setLayout(JPIRevisionExaLayout);
        JPIRevisionExaLayout.setHorizontalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPRevisionExa, GroupLayout.Alignment.TRAILING, -1, 777, 32767).addComponent(this.JBTGuardarTemporal, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPInterpretacion).addGroup(JPIRevisionExaLayout.createSequentialGroup().addComponent(this.JCBTipoDocumento, -2, 292, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIRevisionExaLayout.setVerticalGroup(JPIRevisionExaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIRevisionExaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoDocumento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRevisionExa, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPInterpretacion, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGuardarTemporal, -2, 57, -2).addContainerGap(59, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIRevisionExa, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPInterpretacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPInterpretacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRevisionExaMouseClicked(MouseEvent evt) {
        if (this.JTBRevisionExa.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 4).toString().equals("No Revisado")) {
                this.JTPInterpretacion.setText((String) null);
                this.JTPInterpretacion.setEditable(true);
                this.JBTGuardarTemporal.setEnabled(true);
            } else {
                this.JTPInterpretacion.setText(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 3).toString());
                this.JTPInterpretacion.setEditable(false);
                this.JBTGuardarTemporal.setEnabled(false);
            }
            int ver = JOptionPane.showInternalConfirmDialog(this, "Desea ver presentacion preliminar del examen", "VISTA PRELIMINAR", 1, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            if (ver == 0) {
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    this.xmetodo.mostrarPdf(this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
                } else {
                    this.xmetodo.mostrarPdf(this.xmetodo.mRutaSoporte("JPEscaneoDocumentosEnf") + "\\" + this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 5).toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
        if (this.estadoCombo && this.JCBTipoDocumento.getSelectedIndex() != -1) {
            cargarResultadoExamen();
        }
    }

    private void nuevo() {
        this.JSPRevisionExa.setBorder(BorderFactory.createTitledBorder((Border) null, "REVISIÓN DE " + this.xnombre.toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        crearTablaExamen();
        LlenarCombo();
    }

    public void mGrabarBd() {
        if (this.JTBRevisionExa.getSelectedRow() != -1) {
            if (!this.JTPInterpretacion.getText().isEmpty()) {
                this.ayudasDiagnosticasDAO.update(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()), this.JTPInterpretacion.getText(), this.xmodelo.getValueAt(this.JTBRevisionExa.getSelectedRow(), 0).toString());
                crearTablaExamen();
                cargarResultadoExamen();
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La interpretacion no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTBRevisionExa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un examen a revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTBRevisionExa.requestFocus();
    }

    private void springStart() {
        this.ayudasDiagnosticasDAO = (ResultadoAyudasDiagnosticasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("resultadoAyudasDiagnosticasDAOImpl");
    }

    private void LlenarCombo() {
        this.estadoCombo = false;
        this.JCBTipoDocumento.removeAllItems();
        List<Object[]> listTipoDocumento = this.ayudasDiagnosticasDAO.listadoTipoAyudasDiagnosticasFiltradaPorUsuario(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        if (!listTipoDocumento.isEmpty()) {
            this.idTipoDocumento = new String[listTipoDocumento.size()];
            for (int i = 0; i < listTipoDocumento.size(); i++) {
                this.idTipoDocumento[i] = listTipoDocumento.get(i)[0].toString();
                this.JCBTipoDocumento.addItem(listTipoDocumento.get(i)[1]);
            }
            this.JCBTipoDocumento.setSelectedIndex(-1);
        }
        this.estadoCombo = true;
    }

    private void crearTablaExamen() {
        this.xmodelo = new DefaultTableModel();
        this.xmodelo.addColumn("Id");
        this.xmodelo.addColumn("Fecha");
        this.xmodelo.addColumn("Profesional");
        this.xmodelo.addColumn("Interpretación");
        this.xmodelo.addColumn("Estado");
        this.xmodelo.addColumn("");
        this.JTBRevisionExa.setModel(this.xmodelo);
        this.JTBRevisionExa.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBRevisionExa.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBRevisionExa.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBRevisionExa.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBRevisionExa.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBRevisionExa.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void cargarResultadoExamen() {
        System.out.println("Entrooo");
        List<Object[]> listadoExamenes = this.ayudasDiagnosticasDAO.listadoAyudasDiagnosticasFiltradaPorUsuario(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), this.idTipoDocumento[this.JCBTipoDocumento.getSelectedIndex()]);
        if (!listadoExamenes.isEmpty()) {
            for (int i = 0; i < listadoExamenes.size(); i++) {
                System.out.println("Entrooo");
                this.xmodelo.addRow(this.xdato);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[0], i, 0);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[1], i, 1);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[2], i, 2);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[6], i, 4);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[4], i, 3);
                this.JTBRevisionExa.setValueAt(listadoExamenes.get(i)[5], i, 5);
            }
        }
    }
}
