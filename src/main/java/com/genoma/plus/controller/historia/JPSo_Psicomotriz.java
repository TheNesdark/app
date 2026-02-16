package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.PsicomotrizDAO;
import com.genoma.plus.dao.impl.historia.PsicomotrizDAOImpl;
import com.genoma.plus.dto.historia.PsicomotrizDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPSo_Psicomotriz.class */
public class JPSo_Psicomotriz extends JPanel {
    private PsicomotrizDAO xPsicomotrizDAO;
    private clasesHistoriaCE xclase;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private String[] xidResultado;
    private JComboBox JCBResultado;
    private JCheckBox JCHAprobado;
    public JDateChooser JDFecha;
    private JFormattedTextField JFTFACP1;
    private JFormattedTextField JFTFACP2;
    private JFormattedTextField JFTFACP3;
    private JFormattedTextField JFTFCM1;
    private JFormattedTextField JFTFCM2;
    private JFormattedTextField JFTFRF1;
    private JFormattedTextField JFTFRM1;
    private JFormattedTextField JFTFRM2;
    private JFormattedTextField JFTFRM3;
    private JFormattedTextField JFTFVA1;
    private JLabel JLNo;
    private JPanel JPDatos;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObserE;
    private JTextArea JTAObservacion;
    private JTable JTHistorico;
    private JTabbedPane JTPGeneral;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private int xAprobado = 0;
    private Metodos xmetodo = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xIdAtencion = "";

    public JPSo_Psicomotriz(clasesHistoriaCE xclase) {
        initComponents();
        springStart();
        this.xclase = xclase;
        mNuevo();
    }

    private void springStart() {
        this.xPsicomotrizDAO = (PsicomotrizDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("psicomotrizDAO");
    }

    public void mNuevo() {
        this.xIdAtencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JCBResultado.removeAllItems();
        this.xidResultado = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `h_so_resultado` WHERE (`Estado` =1 AND TipoExamen=7) ORDER BY `Nbre` ASC;", this.xidResultado, this.JCBResultado);
        this.JCBResultado.setSelectedIndex(-1);
        this.JFTFACP1.setValue(0);
        this.JFTFACP2.setValue(0);
        this.JFTFACP3.setValue(0);
        this.JFTFRM1.setValue(0);
        this.JFTFRM2.setValue(0);
        this.JFTFRM3.setValue(0);
        this.JFTFRF1.setValue(0);
        this.JFTFCM1.setValue(0);
        this.JFTFCM2.setValue(0);
        this.JFTFVA1.setValue(0);
        mCargarDatosTabla();
        mVerificarAtencion(this.xIdAtencion);
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xIdAtencion;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        System.out.println("" + this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra());
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_So_Encabezado_Psicomotriz", mparametros);
    }

    private void mVerificarAtencion(String xidAtencion) {
        for (int x = 0; x < this.JTHistorico.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 1).toString().equals(xidAtencion)) {
                this.JTHistorico.changeSelection(x, 0, false, false);
                JTHistoricoMouseClicked(null);
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
        }
    }

    public void mGrabar() {
        if (!mvalidarAtencion(this.xIdAtencion)) {
            if (this.JLNo.getText().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    PsicomotrizDTO xpsicomotriz = new PsicomotrizDTO();
                    xpsicomotriz.setIdAtencion(Long.valueOf(this.xIdAtencion).longValue());
                    xpsicomotriz.setFechaA(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
                    xpsicomotriz.setAcp1(Double.valueOf(this.JFTFACP1.getValue().toString()).doubleValue());
                    xpsicomotriz.setAcp2(Double.valueOf(this.JFTFACP2.getValue().toString()).doubleValue());
                    xpsicomotriz.setAcp3(Double.valueOf(this.JFTFACP3.getValue().toString()).doubleValue());
                    xpsicomotriz.setRm1(Double.valueOf(this.JFTFRM1.getValue().toString()).doubleValue());
                    xpsicomotriz.setRm2(Double.valueOf(this.JFTFRM2.getValue().toString()).doubleValue());
                    xpsicomotriz.setRm3(Double.valueOf(this.JFTFRM3.getValue().toString()).doubleValue());
                    xpsicomotriz.setRf1(Double.valueOf(this.JFTFRF1.getValue().toString()).doubleValue());
                    xpsicomotriz.setCm1(Double.valueOf(this.JFTFCM1.getValue().toString()).doubleValue());
                    xpsicomotriz.setCm2(Double.valueOf(this.JFTFCM2.getValue().toString()).doubleValue());
                    xpsicomotriz.setVa1(Double.valueOf(this.JFTFVA1.getValue().toString()).doubleValue());
                    xpsicomotriz.setAprobado(this.xAprobado);
                    xpsicomotriz.setObservacion(this.JTAObservacion.getText());
                    xpsicomotriz.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    xpsicomotriz.setIdEspecialidad(String.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad()));
                    xpsicomotriz.setResultado(this.JCBResultado.getSelectedItem().toString());
                    this.JLNo.setText(this.xPsicomotrizDAO.create_return_id(xpsicomotriz));
                    this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    this.xclase.mCambiarEstadoOrdenProcedimiento(2);
                }
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este registro ya se encuentra grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe un registro grabado con esta atencion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private boolean mvalidarAtencion(String xidAtencion) {
        boolean existe = false;
        int x = 0;
        while (true) {
            if (x >= this.JTHistorico.getRowCount()) {
                break;
            }
            if (!this.xmodelo.getValueAt(x, 1).toString().equals(xidAtencion)) {
                x++;
            } else {
                existe = true;
                break;
            }
        }
        return existe;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "No. Atencion", "Fecha", "ACP1", "ACP2", "ACP3", "RM1", "RM2", "RM3", "RF1", "CM1", "CM2", "VA1", "Aprobado", "Observacion", "Profesional", "Especialidad", "Resultado"}) { // from class: com.genoma.plus.controller.historia.JPSo_Psicomotriz.1
            Class[] types = {Long.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(16).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(17).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        List<PsicomotrizDTO> list = this.xPsicomotrizDAO.listPsicomotriz(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getIdAtencion()), x, 1);
            this.xmodelo.setValueAt(list.get(x).getFechaA(), x, 2);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getAcp1()), x, 3);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getAcp2()), x, 4);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getAcp3()), x, 5);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getRm1()), x, 6);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getRm2()), x, 7);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getRm3()), x, 8);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getRf1()), x, 9);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getCm1()), x, 10);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getCm2()), x, 11);
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getVa1()), x, 12);
            if (list.get(x).getAprobado() == 1) {
                this.xmodelo.setValueAt(true, x, 13);
            } else {
                this.xmodelo.setValueAt(false, x, 13);
            }
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 14);
            this.xmodelo.setValueAt(list.get(x).getIdProfesional(), x, 15);
            this.xmodelo.setValueAt(list.get(x).getIdEspecialidad(), x, 16);
            this.xmodelo.setValueAt(list.get(x).getResultado(), x, 17);
        }
    }

    /* JADX WARN: Type inference failed for: r3v162, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPGeneral = new JTabbedPane();
        this.JPDatos = new JPanel();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JFTFCM2 = new JFormattedTextField();
        this.JFTFCM1 = new JFormattedTextField();
        this.jPanel3 = new JPanel();
        this.jLabel7 = new JLabel();
        this.JFTFVA1 = new JFormattedTextField();
        this.JLNo = new JLabel();
        this.JDFecha = new JDateChooser();
        this.jPanel4 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JFTFRM2 = new JFormattedTextField();
        this.JFTFRM1 = new JFormattedTextField();
        this.JFTFRM3 = new JFormattedTextField();
        this.JCHAprobado = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.JFTFACP2 = new JFormattedTextField();
        this.JFTFACP1 = new JFormattedTextField();
        this.JFTFACP3 = new JFormattedTextField();
        this.jPanel5 = new JPanel();
        this.jLabel8 = new JLabel();
        this.JFTFRF1 = new JFormattedTextField();
        this.JCBResultado = new JComboBox();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("xjpsopsicomotriz");
        this.JTPGeneral.setForeground(new Color(0, 103, 0));
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacion);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "COORDINACIÓN BIMANUAL - MOTRICIDAD FINA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Tiempo Total de error (T.T.E)");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("No. de Errores");
        this.JFTFCM2.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFCM2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFCM2.setHorizontalAlignment(0);
        this.JFTFCM2.setFont(new Font("Arial", 1, 12));
        this.JFTFCM1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFCM1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFCM1.setHorizontalAlignment(0);
        this.JFTFCM1.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 286, 32767).addComponent(this.jLabel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFCM1, GroupLayout.Alignment.TRAILING, -2, 88, -2).addComponent(this.JFTFCM2, GroupLayout.Alignment.TRAILING, -2, 88, -2)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 50, -2).addComponent(this.JFTFCM1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3, -2, 50, -2).addComponent(this.JFTFCM2, -2, 50, -2)).addGap(10, 10, 10)));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "VELOCIDAD DE ANTICIPACIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel3.setFont(new Font("Arial", 1, 14));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("Tiempo Medio de Desviación (T.M.D)");
        this.JFTFVA1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFVA1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFVA1.setHorizontalAlignment(0);
        this.JFTFVA1.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7, -1, 288, 32767).addGap(10, 10, 10).addComponent(this.JFTFVA1, -2, 88, -2).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7, -2, 50, -2).addComponent(this.JFTFVA1, -2, 50, -2)).addGap(10, 10, 10)));
        this.JLNo.setFont(new Font("Arial", 1, 12));
        this.JLNo.setForeground(Color.red);
        this.JLNo.setHorizontalAlignment(0);
        this.JLNo.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPSo_Psicomotriz.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPSo_Psicomotriz.this.JDFechaPropertyChange(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "REACCIONES MÚLTIPLES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel4.setFont(new Font("Arial", 1, 14));
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setHorizontalAlignment(0);
        this.jLabel10.setText("Tiempo Medio de Reacción de Respuesta (T.M.R.R)");
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("Tiempo Medio de Reacción en el Acierto (T.M.R.A)");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setHorizontalAlignment(0);
        this.jLabel12.setText("No. de Errores");
        this.JFTFRM2.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFRM2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFRM2.setHorizontalAlignment(0);
        this.JFTFRM2.setFont(new Font("Arial", 1, 12));
        this.JFTFRM1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFRM1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFRM1.setHorizontalAlignment(0);
        this.JFTFRM1.setFont(new Font("Arial", 1, 12));
        this.JFTFRM3.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFRM3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFRM3.setHorizontalAlignment(0);
        this.JFTFRM3.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12, -1, -1, 32767).addComponent(this.jLabel10, -1, -1, 32767).addComponent(this.jLabel11, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFRM1, GroupLayout.Alignment.TRAILING, -2, 88, -2).addComponent(this.JFTFRM2, GroupLayout.Alignment.TRAILING, -2, 88, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFRM3, -2, 88, -2))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10, -2, 50, -2).addComponent(this.JFTFRM1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11, -2, 50, -2).addComponent(this.JFTFRM2, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12, -2, 50, -2).addComponent(this.JFTFRM3, -2, 50, -2)).addGap(10, 10, 10)));
        this.JCHAprobado.setFont(new Font("Arial", 1, 12));
        this.JCHAprobado.setText("Aprobado?");
        this.JCHAprobado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Psicomotriz.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_Psicomotriz.this.JCHAprobadoActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "ATENCIÓN CONCENTRADA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel2.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("Tiempo Medio de Reacción de Respuesta (T.M.R.R)");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("Tiempo Medio de Reacción en el Acierto (T.M.R.A)");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setHorizontalAlignment(0);
        this.jLabel6.setText("No. de Errores");
        this.JFTFACP2.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFACP2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFACP2.setHorizontalAlignment(0);
        this.JFTFACP2.setFont(new Font("Arial", 1, 12));
        this.JFTFACP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFACP1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFACP1.setHorizontalAlignment(0);
        this.JFTFACP1.setFont(new Font("Arial", 1, 12));
        this.JFTFACP1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPSo_Psicomotriz.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_Psicomotriz.this.JFTFACP1ActionPerformed(evt);
            }
        });
        this.JFTFACP3.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFACP3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFACP3.setHorizontalAlignment(0);
        this.JFTFACP3.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6, -1, -1, 32767).addComponent(this.jLabel4, -1, -1, 32767).addComponent(this.jLabel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFACP1, GroupLayout.Alignment.TRAILING, -2, 88, -2).addComponent(this.JFTFACP2, GroupLayout.Alignment.TRAILING, -2, 88, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFACP3, -2, 88, -2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4, -2, 50, -2).addComponent(this.JFTFACP1, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5, -2, 50, -2).addComponent(this.JFTFACP2, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6, -2, 50, -2).addComponent(this.JFTFACP3, -2, 50, -2)).addGap(10, 10, 10)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "REACCIÓN AL FRENADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel5.setFont(new Font("Arial", 1, 14));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("Tiempo Promedio de Reacción (T.P.R)");
        this.JFTFRF1.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFRF1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        this.JFTFRF1.setHorizontalAlignment(0);
        this.JFTFRF1.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jLabel8, -1, 286, 32767).addGap(10, 10, 10).addComponent(this.JFTFRF1, -2, 88, -2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8, -2, 50, -2).addComponent(this.JFTFRF1, -2, 50, -2)).addGap(10, 10, 10)));
        this.JCBResultado.setFont(new Font("Arial", 1, 12));
        this.JCBResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObserE).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, -2, -1, -2).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBResultado, 0, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel5, -2, -1, -2))).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel4, -2, -1, -2)).addGroup(JPDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAprobado)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLNo, -2, 121, -2)).addGroup(JPDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2))))).addGap(10, 10, 10)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, 50, -2).addComponent(this.JLNo, -2, 50, -2).addComponent(this.JCBResultado, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.jPanel4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JCHAprobado, -2, 29, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObserE, -2, 66, -2).addGap(10, 10, 10)));
        this.JTPGeneral.addTab("INFORMACION", this.JPDatos);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPSo_Psicomotriz.5
            public void mouseClicked(MouseEvent evt) {
                JPSo_Psicomotriz.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTPGeneral.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPGeneral, -2, 615, -2).addGap(0, 0, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAprobadoActionPerformed(ActionEvent evt) {
        if (this.JCHAprobado.isSelected()) {
            this.xAprobado = 1;
        } else {
            this.xAprobado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1) {
            this.JLNo.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString());
            this.xIdAtencion = this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString();
            this.JDFecha.setDate(Date.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 2).toString()));
            this.JFTFACP1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 3).toString()));
            this.JFTFACP2.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 4).toString()));
            this.JFTFACP3.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 5).toString()));
            this.JFTFRM1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 6).toString()));
            this.JFTFRM2.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString()));
            this.JFTFRM3.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 8).toString()));
            this.JFTFRF1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 9).toString()));
            this.JFTFCM1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 10).toString()));
            this.JFTFCM2.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 11).toString()));
            this.JFTFVA1.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 12).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 13).toString()).booleanValue()) {
                this.JCHAprobado.setSelected(true);
                this.xAprobado = 1;
            } else {
                this.JCHAprobado.setSelected(false);
                this.xAprobado = 0;
            }
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 14).toString());
            this.JCBResultado.setSelectedItem(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 17).toString());
            this.JTPGeneral.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFACP1ActionPerformed(ActionEvent evt) {
    }
}
