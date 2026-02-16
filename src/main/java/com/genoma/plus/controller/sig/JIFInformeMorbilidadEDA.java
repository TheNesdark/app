package com.genoma.plus.controller.sig;

import Acceso.Principal;
import Historia.Sivigila;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.sig.InformeMorbilidadEDADAOImpl1;
import com.genoma.plus.dao.sig.InformeMorbilidadEDADAO1;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformeMorbilidadEDA.class */
public class JIFInformeMorbilidadEDA extends JInternalFrame {
    private DefaultTableModel xmodeloH;
    private DefaultTableModel xmodeloM;
    private DefaultTableModel xmodeloMo;
    private InformeMorbilidadEDADAO1 xInformeMorbilidadEDA_DAO;
    private Object[] xDato;
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    static ResultSet xrs;
    private WorkerSQL xWorkerSQL;
    File directorio;
    private Sivigila xSivigila;
    private JButton JBTExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JDateChooser JDFFechaNotificacion;
    private JScrollPane JSPHospitalizacion;
    private JScrollPane JSPMorbilidad;
    private JScrollPane JSPMuerte;
    private JSpinner JSPSemana;
    private JTextField JTFRuta;
    private JTable JTHospitalizacion;
    private JTable JTMorbilidad;
    private JTable JTMuerte;
    private JYearChooser JYAno;
    private JPanel jPanel1;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();
    private int[] PosX = {272, 316, 363, 407, 453, 500, 545};

    public JIFInformeMorbilidadEDA() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xInformeMorbilidadEDA_DAO = (InformeMorbilidadEDADAOImpl1) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informeMorbilidadEDADAO");
    }

    public void mNuevo() {
        this.directorio = new File(this.xmt.mRutaSoporte("JIFInformeMorbilidadIra"));
        this.JDFFechaNotificacion.setDate(this.xmt.getFechaActual());
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JSPSemana.setValue(1);
        this.JYAno.setValue(Integer.valueOf(this.xmt.formatoANO.format(this.xmt.getFechaActual())).intValue());
        mModeloHospitalizacion();
        mModeloMuerte();
        mModeloMorbilidad();
    }

    public void mBuscar() {
        mBuscaDatos();
    }

    public void mImprimir() {
        if (this.JTHospitalizacion.getRowCount() != 0 && this.JTMuerte.getRowCount() != 0 && this.JTMorbilidad.getRowCount() != 0) {
            try {
                this.xSivigila = new Sivigila();
                this.xSivigila.mGenerarSivigila("MORBILIDAD POR EDA");
                reader = new PdfReader(this.directorio + this.xmt.getBarra() + "MORBILIDAD POR EDA.pdf");
                stamper = new PdfStamper(reader, new FileOutputStream(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "MORBILIDAD POR EDA.pdf"));
                bf = BaseFont.createFont("Helvetica", "Cp1252", false);
                over = stamper.getOverContent(1);
                over.beginText();
                over.setFontAndSize(bf, 10.0f);
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo(), 2, 38, 634);
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo().substring(2, 5), 3, 86, 634);
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo().substring(5, 10), 5, 163, 634);
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo().substring(10, 12), 2, 271, 634);
                over.setTextMatrix(320.0f, 625.0f);
                over.showText(Principal.informacionIps.getNombreIps());
                mllenarCasillas(this.xmt.formatoAMD_Unida1.format(this.JDFFechaNotificacion.getDate()), 2, 38, 580);
                mllenarCasillas(this.xmt.formatoAMD_Unida1.format(this.JDFFechaNotificacion.getDate()).substring(2, 4), 2, 81, 580);
                mllenarCasillas(this.xmt.formatoAMD_Unida1.format(this.JDFFechaNotificacion.getDate()).substring(4, 8), 4, 126, 580);
                if (this.JSPSemana.getValue().toString().length() == 1) {
                    mllenarCasillas("0" + this.JSPSemana.getValue().toString(), 2, 298, 580);
                } else {
                    mllenarCasillas(this.JSPSemana.getValue().toString(), 2, 298, 580);
                }
                mllenarCasillas(String.valueOf(this.JYAno.getValue()), 4, 466, 580);
                over.setTextMatrix(38.0f, 545.0f);
                over.showText(Principal.informacionIps.getNombreDepartamentoIps().toUpperCase() + " - " + Principal.informacionIps.getNombreMunicipioIps().toUpperCase());
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo(), 2, 453, 549);
                mllenarCasillas(Principal.informacionIps.getCodigoOrganismo().substring(2, 5), 3, 503, 549);
                for (int i = 0; i < 7; i++) {
                    over.setTextMatrix(this.PosX[i], 467.0f);
                    if (this.JTHospitalizacion.getValueAt(0, i + 1) != null) {
                        over.showText(this.JTHospitalizacion.getValueAt(0, i + 1).toString());
                    }
                }
                for (int i2 = 0; i2 < 7; i2++) {
                    over.setTextMatrix(this.PosX[i2], 445.0f);
                    if (this.JTHospitalizacion.getValueAt(1, i2 + 1) != null) {
                        over.showText(this.JTHospitalizacion.getValueAt(1, i2 + 1).toString());
                    }
                }
                for (int i3 = 0; i3 < 7; i3++) {
                    over.setTextMatrix(this.PosX[i3], 358.0f);
                    if (this.JTMuerte.getValueAt(0, i3 + 1) != null) {
                        over.showText(this.JTMuerte.getValueAt(0, i3 + 1).toString());
                    }
                }
                for (int i4 = 0; i4 < 7; i4++) {
                    over.setTextMatrix(this.PosX[i4], 336.0f);
                    if (this.JTMuerte.getValueAt(1, i4 + 1) != null) {
                        over.showText(this.JTMuerte.getValueAt(1, i4 + 1).toString());
                    }
                }
                for (int i5 = 0; i5 < 7; i5++) {
                    over.setTextMatrix(this.PosX[i5], 302.0f);
                    if (this.JTMorbilidad.getValueAt(0, i5 + 1) != null) {
                        over.showText(this.JTMorbilidad.getValueAt(0, i5 + 1).toString());
                    }
                }
                for (int i6 = 0; i6 < 7; i6++) {
                    over.setTextMatrix(this.PosX[i6], 280.0f);
                    if (this.JTMorbilidad.getValueAt(1, i6 + 1) != null) {
                        over.showText(this.JTMorbilidad.getValueAt(1, i6 + 1).toString());
                    }
                }
                over.setTextMatrix(27.0f, 203.0f);
                over.showText(Principal.usuarioSistemaDTO.getNombreUsuario());
                over.setTextMatrix(357.0f, 203.0f);
                over.showText(Principal.usuarioSistemaDTO.getNombreCargoUsuario());
                over.setTextMatrix(27.0f, 157.0f);
                over.showText(Principal.informacionIps.getTelefonoIps());
                over.setTextMatrix(357.0f, 157.0f);
                over.showText(Principal.usuarioSistemaDTO.getCorreoUsuario());
                over.endText();
                stamper.close();
                this.xmt.mostrarPdf(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra() + "MORBILIDAD POR EDA.pdf");
                this.xmt.mEliminarArchivo(new File(this.directorio + this.xmt.getBarra() + "MORBILIDAD POR EDA.pdf"));
                return;
            } catch (DocumentException e) {
                Logger.getLogger(JIFInformeMorbilidadEDA.class.getName()).log(Level.SEVERE, (String) null, e);
                return;
            } catch (IOException ex) {
                Logger.getLogger(JIFInformeMorbilidadEDA.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Tablas Sin Registros", "VERFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloHospitalizacion() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Servicio", "<1", "1", "2 a 4", "5 a 19", "20 a 39", "40 a 59", ">=60"}) { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHospitalizacion.setModel(this.xmodeloH);
        this.JTHospitalizacion.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTHospitalizacion.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTHospitalizacion.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloMuerte() {
        this.xmodeloM = new DefaultTableModel(new Object[0], new String[]{"Servicio", "<1", "1", "2 a 4", "5 a 19", "20 a 39", "40 a 59", ">=60"}) { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMuerte.setModel(this.xmodeloM);
        this.JTMuerte.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTMuerte.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTMuerte.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloMorbilidad() {
        this.xmodeloMo = new DefaultTableModel(new Object[0], new String[]{"Servicio", "<1", "1", "2 a 4", "5 a 19", "20 a 39", "40 a 59", ">=60"}) { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMorbilidad.setModel(this.xmodeloMo);
        this.JTMorbilidad.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTMorbilidad.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTMorbilidad.getColumnModel().getColumn(7).setPreferredWidth(100);
    }

    public void mBuscaDatos() {
        mModeloHospitalizacion();
        mModeloMuerte();
        mModeloMorbilidad();
        List<Object[]> listH1 = this.xInformeMorbilidadEDA_DAO.ListHospitalizacion1(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        List<Object[]> listH2 = this.xInformeMorbilidadEDA_DAO.ListHospitalizacion2(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        List<Object[]> listM1 = this.xInformeMorbilidadEDA_DAO.ListMuertes1(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        List<Object[]> listM2 = this.xInformeMorbilidadEDA_DAO.ListMuertes2(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        List<Object[]> listMo1 = this.xInformeMorbilidadEDA_DAO.ListMorbilidad1(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        List<Object[]> listMo2 = this.xInformeMorbilidadEDA_DAO.ListMOrbilidad2(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        this.xmodeloH.addRow(this.xDato);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.xmodeloH.setValueAt("Total hospitalizaciones por EDA A00-A09", 0, 0);
        } else {
            this.xmodeloH.setValueAt("Total hospitalizaciones por EDA K591", 0, 0);
        }
        for (int x = 0; x < listH1.size(); x++) {
            llenarCeldaTabla(listH1.get(x)[1].toString(), listH1.get(x)[0].toString(), this.xmodeloH, 0);
        }
        this.xmodeloH.addRow(this.xDato);
        this.xmodeloH.setValueAt("Todas las causas de hospitalización", 1, 0);
        for (int x2 = 0; x2 < listH2.size(); x2++) {
            llenarCeldaTabla(listH2.get(x2)[1].toString(), listH2.get(x2)[0].toString(), this.xmodeloH, 1);
        }
        this.xmodeloM.addRow(this.xDato);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.xmodeloM.setValueAt("Total muertes por EDA A00-A09", 0, 0);
        } else {
            this.xmodeloM.setValueAt("Total muertes por EDA K591", 0, 0);
        }
        for (int x3 = 0; x3 < listM1.size(); x3++) {
            llenarCeldaTabla(listM1.get(x3)[1].toString(), listM1.get(x3)[0].toString(), this.xmodeloM, 0);
        }
        this.xmodeloM.addRow(this.xDato);
        this.xmodeloM.setValueAt("Todas las causas de muerte", 1, 0);
        for (int x4 = 0; x4 < listM2.size(); x4++) {
            llenarCeldaTabla(listM2.get(x4)[1].toString(), listM2.get(x4)[0].toString(), this.xmodeloM, 1);
        }
        this.xmodeloMo.addRow(this.xDato);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.xmodeloMo.setValueAt("Total EDA consulta externa y urgencias A00-A09", 0, 0);
        } else {
            this.xmodeloMo.setValueAt("Total EDA consulta externa y urgencias K591", 0, 0);
        }
        for (int x5 = 0; x5 < listMo1.size(); x5++) {
            llenarCeldaTabla(listMo1.get(x5)[1].toString(), listMo1.get(x5)[0].toString(), this.xmodeloMo, 0);
        }
        this.xmodeloMo.addRow(this.xDato);
        this.xmodeloMo.setValueAt("Total consultas externas y urgencias", 1, 0);
        for (int x6 = 0; x6 < listMo2.size(); x6++) {
            llenarCeldaTabla(listMo2.get(x6)[1].toString(), listMo2.get(x6)[0].toString(), this.xmodeloMo, 1);
        }
    }

    private void llenarCeldaTabla(String ValColumna, String Resultado, DefaultTableModel modelo, int PosFila) {
        switch (ValColumna) {
            case "<1":
                modelo.setValueAt(Resultado, PosFila, 1);
                break;
            case "1":
                modelo.setValueAt(Resultado, PosFila, 2);
                break;
            case "2 a 4":
                modelo.setValueAt(Resultado, PosFila, 3);
                break;
            case "5 a 19":
                modelo.setValueAt(Resultado, PosFila, 4);
                break;
            case "20 a 39":
                modelo.setValueAt(Resultado, PosFila, 5);
                break;
            case "40 a 59":
                modelo.setValueAt(Resultado, PosFila, 6);
                break;
            case ">=60":
                modelo.setValueAt(Resultado, PosFila, 7);
                break;
        }
    }

    private static void mllenarCasillas(String xtexto, int cont, int x, int y) {
        int sum = x;
        for (int i = 0; i < cont; i++) {
            over.setTextMatrix(sum, y);
            over.showText(xtexto.substring(i, 1 + i));
            sum += 20;
        }
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JYAno = new JYearChooser();
        this.JSPSemana = new JSpinner();
        this.JDFFechaNotificacion = new JDateChooser();
        this.JSPHospitalizacion = new JScrollPane();
        this.JTHospitalizacion = new JTable();
        this.JSPMuerte = new JScrollPane();
        this.JTMuerte = new JTable();
        this.JSPMorbilidad = new JScrollPane();
        this.JTMorbilidad = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE MORBILIDAD DE EDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformemorbilidadeda");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION GENERAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFInformeMorbilidadEDA.this.JYAnoPropertyChange(evt);
            }
        });
        this.JSPSemana.setFont(new Font("Arial", 1, 12));
        this.JSPSemana.setModel(new SpinnerNumberModel(1, 1, 52, 1));
        this.JSPSemana.setBorder(BorderFactory.createTitledBorder((Border) null, "Semana", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaNotificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Notificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaNotificacion.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaNotificacion.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JDFFechaNotificacion, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 288, 32767).addComponent(this.JSPSemana, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JYAno, -2, 71, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JYAno, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaNotificacion, -2, 50, -2).addComponent(this.JSPSemana, -2, 50, -2)).addGap(0, 0, 32767)));
        this.JSPHospitalizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "HOSPITALIZACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JTHospitalizacion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHospitalizacion.setSelectionBackground(Color.white);
        this.JTHospitalizacion.setSelectionForeground(Color.red);
        this.JSPHospitalizacion.setViewportView(this.JTHospitalizacion);
        this.JSPMuerte.setBorder(BorderFactory.createTitledBorder((Border) null, "MUERTES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTMuerte.setFont(new Font("Arial", 1, 12));
        this.JTMuerte.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTMuerte.setSelectionBackground(Color.white);
        this.JTMuerte.setSelectionForeground(Color.red);
        this.JSPMuerte.setViewportView(this.JTMuerte);
        this.JSPMorbilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "MORBILIDAD POR IRA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTMorbilidad.setFont(new Font("Arial", 1, 12));
        this.JTMorbilidad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTMorbilidad.setSelectionBackground(Color.white);
        this.JTMorbilidad.setSelectionForeground(Color.red);
        this.JSPMorbilidad.setViewportView(this.JTMorbilidad);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformeMorbilidadEDA.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformeMorbilidadEDA.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformeMorbilidadEDA.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 434, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 154, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JDFFechaI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 129, -2)).addComponent(this.JSPHospitalizacion, -2, 595, -2).addComponent(this.JSPMuerte, -2, 595, -2))).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPMorbilidad, -2, 595, -2).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaF, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHospitalizacion, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMuerte, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMorbilidad, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 53, 32767)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
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
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                JTable[] parametros = {this.JTHospitalizacion, this.JTMuerte, this.JTMorbilidad};
                String[] xtitulo = {"HOSPITALIZACION", "MUERTES", "MORBILIDAD POR EDA"};
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato_Unificada_Modelos(parametros, this.JTFRuta.getText(), xtitulo);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }
}
