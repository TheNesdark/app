package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IDatosGeneracionRips;
import com.genoma.plus.jpa.service.IDatosGeneracionRipsCovidService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGeneracionRipsCovid.class */
public class JIFGeneracionRipsCovid extends JInternalFrame {
    private String[][] xidempresa;
    private String[] xid_factura;
    private String xsql;
    private String sql;
    private File xfile;
    private Vector xvector;
    private String xcodigo;
    private JButton JBTGenerar;
    private JPanel JPIDatosT;
    private JPanel JPI_TIpExtencion;
    private JRadioButton JRB_Dat;
    private JRadioButton JRB_Zip;
    private ButtonGroup JRGFiltro;
    private JTextField JTFRuta;
    private JDateChooser txtFechaFin;
    private JDateChooser txtFechaIni;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipo = 0;
    private int xIncluir_Dx = 0;
    private int xAgrupado = 0;
    private boolean xlleno = false;
    private String idNumeroFactura = "''";
    private String idConvenio = "''";
    private String extencion = ".DAT";
    private final IDatosGeneracionRipsCovidService generacionRipsCovidService = (IDatosGeneracionRipsCovidService) Principal.contexto.getBean(IDatosGeneracionRipsCovidService.class);

    @Generated
    public void setXmt(Metodos xmt) {
        this.xmt = xmt;
    }

    @Generated
    public void setXct(ConsultasMySQL xct) {
        this.xct = xct;
    }

    @Generated
    public void setXidempresa(String[][] xidempresa) {
        this.xidempresa = xidempresa;
    }

    @Generated
    public void setXid_factura(String[] xid_factura) {
        this.xid_factura = xid_factura;
    }

    @Generated
    public void setXsql(String xsql) {
        this.xsql = xsql;
    }

    @Generated
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Generated
    public void setXtipo(int xtipo) {
        this.xtipo = xtipo;
    }

    @Generated
    public void setXIncluir_Dx(int xIncluir_Dx) {
        this.xIncluir_Dx = xIncluir_Dx;
    }

    @Generated
    public void setXAgrupado(int xAgrupado) {
        this.xAgrupado = xAgrupado;
    }

    @Generated
    public void setXlleno(boolean xlleno) {
        this.xlleno = xlleno;
    }

    @Generated
    public void setXfile(File xfile) {
        this.xfile = xfile;
    }

    @Generated
    public void setXvector(Vector xvector) {
        this.xvector = xvector;
    }

    @Generated
    public void setXcodigo(String xcodigo) {
        this.xcodigo = xcodigo;
    }

    @Generated
    public void setIdNumeroFactura(String idNumeroFactura) {
        this.idNumeroFactura = idNumeroFactura;
    }

    @Generated
    public void setIdConvenio(String idConvenio) {
        this.idConvenio = idConvenio;
    }

    @Generated
    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    @Generated
    public void setJBTGenerar(JButton JBTGenerar) {
        this.JBTGenerar = JBTGenerar;
    }

    @Generated
    public void setJPIDatosT(JPanel JPIDatosT) {
        this.JPIDatosT = JPIDatosT;
    }

    @Generated
    public void setJPI_TIpExtencion(JPanel JPI_TIpExtencion) {
        this.JPI_TIpExtencion = JPI_TIpExtencion;
    }

    @Generated
    public void setJRB_Dat(JRadioButton JRB_Dat) {
        this.JRB_Dat = JRB_Dat;
    }

    @Generated
    public void setJRB_Zip(JRadioButton JRB_Zip) {
        this.JRB_Zip = JRB_Zip;
    }

    @Generated
    public void setJRGFiltro(ButtonGroup JRGFiltro) {
        this.JRGFiltro = JRGFiltro;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setTxtFechaFin(JDateChooser txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    @Generated
    public void setTxtFechaIni(JDateChooser txtFechaIni) {
        this.txtFechaIni = txtFechaIni;
    }

    @Generated
    public Metodos getXmt() {
        return this.xmt;
    }

    @Generated
    public ConsultasMySQL getXct() {
        return this.xct;
    }

    @Generated
    public String[][] getXidempresa() {
        return this.xidempresa;
    }

    @Generated
    public String[] getXid_factura() {
        return this.xid_factura;
    }

    @Generated
    public String getXsql() {
        return this.xsql;
    }

    @Generated
    public String getSql() {
        return this.sql;
    }

    @Generated
    public int getXtipo() {
        return this.xtipo;
    }

    @Generated
    public int getXIncluir_Dx() {
        return this.xIncluir_Dx;
    }

    @Generated
    public int getXAgrupado() {
        return this.xAgrupado;
    }

    @Generated
    public boolean isXlleno() {
        return this.xlleno;
    }

    @Generated
    public File getXfile() {
        return this.xfile;
    }

    @Generated
    public Vector getXvector() {
        return this.xvector;
    }

    @Generated
    public String getXcodigo() {
        return this.xcodigo;
    }

    @Generated
    public String getIdNumeroFactura() {
        return this.idNumeroFactura;
    }

    @Generated
    public String getIdConvenio() {
        return this.idConvenio;
    }

    @Generated
    public String getExtencion() {
        return this.extencion;
    }

    @Generated
    public IDatosGeneracionRipsCovidService getGeneracionRipsCovidService() {
        return this.generacionRipsCovidService;
    }

    public JIFGeneracionRipsCovid() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JRGFiltro = new ButtonGroup();
        this.JBTGenerar = new JButton();
        this.JPIDatosT = new JPanel();
        this.txtFechaIni = new JDateChooser();
        this.txtFechaFin = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JPI_TIpExtencion = new JPanel();
        this.JRB_Dat = new JRadioButton();
        this.JRB_Zip = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN RIPS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgeneracionrips");
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGeneracionRipsCovid.1
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRipsCovid.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JPIDatosT.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaIni.setDateFormatString("dd/MM/yyyy");
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaFin.setDateFormatString("dd/MM/yyyy");
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGeneracionRipsCovid.2
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionRipsCovid.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPI_TIpExtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Extención", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JRGFiltro.add(this.JRB_Dat);
        this.JRB_Dat.setFont(new Font("Arial", 1, 12));
        this.JRB_Dat.setSelected(true);
        this.JRB_Dat.setText(".DAT");
        this.JRB_Dat.setAutoscrolls(true);
        this.JRB_Dat.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGeneracionRipsCovid.3
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRipsCovid.this.JRB_DatActionPerformed(evt);
            }
        });
        this.JRGFiltro.add(this.JRB_Zip);
        this.JRB_Zip.setFont(new Font("Arial", 1, 12));
        this.JRB_Zip.setText(".ZIP");
        this.JRB_Zip.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGeneracionRipsCovid.4
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionRipsCovid.this.JRB_ZipActionPerformed(evt);
            }
        });
        GroupLayout JPI_TIpExtencionLayout = new GroupLayout(this.JPI_TIpExtencion);
        this.JPI_TIpExtencion.setLayout(JPI_TIpExtencionLayout);
        JPI_TIpExtencionLayout.setHorizontalGroup(JPI_TIpExtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_TIpExtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Dat).addGap(29, 29, 29).addComponent(this.JRB_Zip).addContainerGap(32, 32767)));
        JPI_TIpExtencionLayout.setVerticalGroup(JPI_TIpExtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TIpExtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPI_TIpExtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Zip).addComponent(this.JRB_Dat)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosTLayout = new GroupLayout(this.JPIDatosT);
        this.JPIDatosT.setLayout(JPIDatosTLayout);
        JPIDatosTLayout.setHorizontalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -2, 522, -2).addGroup(JPIDatosTLayout.createSequentialGroup().addComponent(this.txtFechaIni, -2, 133, -2).addGap(18, 18, 18).addComponent(this.txtFechaFin, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPI_TIpExtencion, -2, -1, -2))).addContainerGap(17, 32767)));
        JPIDatosTLayout.setVerticalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFechaIni, -1, 50, 32767).addComponent(this.txtFechaFin, -1, -1, 32767))).addComponent(this.JPI_TIpExtencion, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosT, -1, -1, 32767).addComponent(this.JBTGenerar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosT, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 51, -2).addGap(18, 18, 18)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        this.xlleno = false;
        mGenerarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_DatActionPerformed(ActionEvent evt) {
        setExtencion(this.JRB_Dat.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ZipActionPerformed(ActionEvent evt) {
        setExtencion(this.JRB_Zip.getText());
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.txtFechaIni.setDate(this.xmt.getFechaActual());
        this.txtFechaFin.setDate(this.xmt.getFechaActual());
        this.txtFechaIni.requestFocus();
    }

    private void mGenerarArchivos() {
        this.xvector = new Vector();
        this.xsql = "";
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            try {
                this.generacionRipsCovidService.actualizarDiagnosticoIngreso(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
                mCrearArchivo_AF_Capitado();
                mCrearArchivo_AD_Capitado();
                mCrearArchivo_US_Capitado();
                mCrearArchivo_AC_Capitado();
                mCrearArchivo_AP_Capitado();
                mCrearArchivo_AM_Capitado();
                mCrearArchivo_AT_Capitado();
                mCrearArchivo_AU_Capitado();
                mCrearArchivo_AH_Capitado();
                mCrearArchivo_AN_Capitado();
                mCrearArchivoCT();
                this.xmt.comprimirArchivosDirectorioZip(this.JTFRuta.getText(), "RIP165COVI" + getXmt().formatoAMD_Unida.format(this.txtFechaFin.getDate()) + Principal.informacionIps.getIdTipoIdentificacion() + Principal.informacionIps.getIdentificacion() + getExtencion());
                JOptionPane.showInternalMessageDialog(this, "Archivos generados exitosamente!!!!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } catch (IOException ex) {
                Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCrearArchivoCT() {
        System.out.println(this.xvector.size());
        if (this.xvector.size() >= 1) {
            try {
                String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "CT" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
                this.xmt.mEliminarArchivo(new File(sFichero));
                boolean xdato = false;
                BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
                if (this.xvector.size() >= 0) {
                    for (int x = 0; x < this.xvector.size(); x++) {
                        bw.write(this.xvector.get(x).toString());
                        bw.newLine();
                    }
                    xdato = true;
                }
                bw.close();
                if (!xdato) {
                    this.xmt.mEliminarArchivo(new File(sFichero));
                }
            } catch (IOException ex) {
                Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCrearArchivo_AF_Capitado() {
        try {
            System.out.println("get : " + this.idConvenio);
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AF" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAF_Transaccion(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            System.out.println(" Rips AF : " + this.sql);
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AF" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AD_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AD" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAD_AgrupacionProcedimientos(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            boolean xdato = false;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista2 = this.generacionRipsCovidService.listaInformacionAD_AgrupacionProcedimientosQx(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista2.isEmpty()) {
                for (IDatosGeneracionRips next2 : lista2) {
                    bw.write(next2.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista3 = this.generacionRipsCovidService.listaInformacionAD_AgrupacionProcedimientosQxPaquete(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista3.isEmpty()) {
                for (IDatosGeneracionRips next3 : lista3) {
                    bw.write(next3.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista4 = this.generacionRipsCovidService.listaInformacionAD_AgrupacionMedicamento(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista4.isEmpty()) {
                for (IDatosGeneracionRips next4 : lista4) {
                    bw.write(next4.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AD" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_US_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "US" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionUS_Usuario(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",US" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AC_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AC" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAC_Consulta(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AC" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AU_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AU" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAU_Urgencias(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AU" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AN_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AN" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAN_Nacimientos(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AN" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AH_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AH" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            boolean xdato = false;
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAH_Hospitalizacion(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AH" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AP_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AP" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAP_Procedimiento(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista2 = this.generacionRipsCovidService.listaInformacionAP_ProcedimientoQx(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista2.isEmpty()) {
                for (IDatosGeneracionRips next2 : lista2) {
                    bw.write(next2.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista3 = this.generacionRipsCovidService.listaInformacionAP_ProcedimientoQxPaquetes(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista3.isEmpty()) {
                for (IDatosGeneracionRips next3 : lista3) {
                    bw.write(next3.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AP" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AM_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AM" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAM_Medicamentos(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AM" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearArchivo_AT_Capitado() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "AT" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            boolean xdato = false;
            List<IDatosGeneracionRips> lista = this.generacionRipsCovidService.listaInformacionAT_OtrosServiciosIsumos(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            int x = 0;
            if (!lista.isEmpty()) {
                for (IDatosGeneracionRips next : lista) {
                    bw.write(next.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            List<IDatosGeneracionRips> lista2 = this.generacionRipsCovidService.listaInformacionAT_OtrosServiciosProcedimientos(this.xmt.formatoAMD1.format(this.txtFechaIni.getDate()), this.xmt.formatoAMD1.format(this.txtFechaFin.getDate()));
            if (!lista2.isEmpty()) {
                for (IDatosGeneracionRips next2 : lista2) {
                    bw.write(next2.getLinea());
                    bw.newLine();
                    x++;
                }
                xdato = true;
            }
            bw.close();
            if (xdato) {
                this.xvector.addElement(this.xcodigo + "," + this.xmt.formatoDMA.format(this.xmt.getFechaActual()) + ",AT" + this.xmt.formatoAMD_Rips.format(this.txtFechaFin.getDate()) + "," + x);
            } else {
                this.xmt.mEliminarArchivo(new File(sFichero));
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionRipsCovid.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    @Generated
    public JButton getJBTGenerar() {
        return this.JBTGenerar;
    }

    @Generated
    public JPanel getJPIDatosT() {
        return this.JPIDatosT;
    }

    @Generated
    public JPanel getJPI_TIpExtencion() {
        return this.JPI_TIpExtencion;
    }

    @Generated
    public JRadioButton getJRB_Dat() {
        return this.JRB_Dat;
    }

    @Generated
    public JRadioButton getJRB_Zip() {
        return this.JRB_Zip;
    }

    @Generated
    public ButtonGroup getJRGFiltro() {
        return this.JRGFiltro;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JDateChooser getTxtFechaFin() {
        return this.txtFechaFin;
    }

    @Generated
    public JDateChooser getTxtFechaIni() {
        return this.txtFechaIni;
    }
}
