package Laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFImportacionHL7Infinity.class */
public class JIFImportacionHL7Infinity extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private LaboratorioDAO xImplLabotaorio;
    private String[][] xValores;
    private WorkerSQL xWorkerSQL;
    private JButton JBTEscuchar;
    private JButton JBTGrabar;
    private JButton JBTValdiar;
    private JFormattedTextField JFTFContador;
    private JTable JTBDatosImp;
    private JScrollPane jScrollPane2;
    private String xOrden = "";
    private Metodos xmt = new Metodos();
    public int nlineas = 0;
    public int nArchivos = 0;
    public int nfila = 0;
    JFileChooser xfilec = null;

    public JIFImportacionHL7Infinity() {
        initComponents();
        springStart();
        mCreaModelo();
    }

    private void mCargarArchivos() {
        mCreaModelo();
        this.xfilec = new JFileChooser("c:\\");
        this.xfilec.setFileSelectionMode(1);
        int xv = this.xfilec.showOpenDialog(this);
        this.nfila = 0;
        if (xv == 0) {
            this.xWorkerSQL = new WorkerSQL("Procesando informacion", this);
            this.xWorkerSQL.execute();
        }
    }

    public void mLeerArchivos() {
        try {
            File[] ficheros = this.xfilec.getSelectedFile().listFiles();
            this.nArchivos = 0;
            for (int f = 0; f < ficheros.length; f++) {
                System.out.println(ficheros[f].getName());
                if (ficheros[f].getAbsolutePath().endsWith("RES")) {
                    this.nArchivos++;
                    this.xfile = ficheros[f].getCanonicalFile();
                    BufferedReader bf = new BufferedReader(new FileReader(this.xfile.getAbsolutePath()));
                    String linea = bf.readLine();
                    Vector xvector = new Vector();
                    int nlineas = 0;
                    while (linea != null) {
                        xvector.add(linea + "\n");
                        linea = bf.readLine();
                        nlineas++;
                    }
                    for (int x = 0; x < xvector.size(); x++) {
                        mSepararCadena(xvector.get(x).toString());
                    }
                    bf.close();
                }
            }
            this.JFTFContador.setValue(Integer.valueOf(this.JTBDatosImp.getRowCount()));
        } catch (IOException ex) {
            Logger.getLogger(JIFImportacionHL7Infinity.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        System.out.println(this.nArchivos);
    }

    private void mSepararCadena(String xtexto) {
        System.out.println("xtexto-->" + xtexto);
        String[] parts = xtexto.split("\\|");
        int i = 0;
        for (String texto : parts) {
            System.out.println(" i--> " + i + " str--> " + texto);
            if (xtexto.substring(0, 1).equals("P") && i == 2) {
                this.xOrden = parts[i];
                System.out.println("Orden: " + this.xOrden);
                return;
            }
            if (xtexto.substring(0, 1).equals("R")) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(parts[2], this.nfila, 2);
                if (!parts[3].equals(parts[4]) && parts[4].isEmpty()) {
                    this.xmodelo.setValueAt(parts[3], this.nfila, 3);
                } else {
                    this.xmodelo.setValueAt(parts[4], this.nfila, 3);
                }
                this.xmodelo.setValueAt(parts[5], this.nfila, 4);
                this.xmodelo.setValueAt(parts[6], this.nfila, 5);
                this.xmodelo.setValueAt(parts[7], this.nfila, 6);
                if (!parts[9].isEmpty()) {
                    if (parts[9].contains("^")) {
                        String[] pvalor = parts[9].split("\\^");
                        this.xmodelo.setValueAt(pvalor[0], this.nfila, 7);
                        this.xmodelo.setValueAt(pvalor[1], this.nfila, 8);
                    } else {
                        this.xmodelo.setValueAt("0", this.nfila, 7);
                        this.xmodelo.setValueAt(parts[9], this.nfila, 8);
                    }
                } else {
                    this.xmodelo.setValueAt(parts[9], this.nfila, 7);
                    this.xmodelo.setValueAt(parts[9], this.nfila, 8);
                }
                this.xmodelo.setValueAt(parts[13], this.nfila, 12);
                this.xmodelo.setValueAt(this.xOrden, this.nfila, 13);
                this.xmodelo.setValueAt(this.xfile.getName(), this.nfila, 14);
                this.xmodelo.setValueAt(false, this.nfila, 15);
                this.xmodelo.setValueAt("", this.nfila, 16);
                this.xmodelo.setValueAt(false, this.nfila, 17);
                this.xmodelo.setValueAt(0, this.nfila, 18);
                this.nfila++;
                return;
            }
            i++;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"1", "Nº Resultado", "Id", "Cups", "V/Resultado", "Medida", "Nombre Procedimiento", "V/min", "V/max", "10", "11", "UsuarioS", "Fecha", "Nº Orden", "Nombre Archivo", "Alterado", "Id_Pr", "R?", "Id_OrdenFac"}) { // from class: Laboratorio.JIFImportacionHL7Infinity.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosImp.setModel(this.xmodelo);
        JTable jTable = this.JTBDatosImp;
        JTable jTable2 = this.JTBDatosImp;
        jTable.setAutoResizeMode(0);
        this.JTBDatosImp.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(6).setPreferredWidth(230);
        this.JTBDatosImp.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTBDatosImp.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTBDatosImp.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDatosImp.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTBDatosImp.getColumnModel().getColumn(18).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane2 = new JScrollPane();
        this.JTBDatosImp = new JTable();
        this.JBTEscuchar = new JButton();
        this.JBTValdiar = new JButton();
        this.JBTGrabar = new JButton();
        this.JFTFContador = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPORTACIÓN RESULTADOS HL7 - INFINITY ROCHE DIAGNOSTICS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS A IMPORTAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDatosImp.setFont(new Font("Arial", 1, 12));
        this.JTBDatosImp.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDatosImp.setAutoResizeMode(0);
        this.JTBDatosImp.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosImp.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTBDatosImp);
        this.JBTEscuchar.setFont(new Font("Arial", 1, 12));
        this.JBTEscuchar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.JBTEscuchar.setText("Cargar Archivo");
        this.JBTEscuchar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionHL7Infinity.2
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionHL7Infinity.this.JBTEscucharActionPerformed(evt);
            }
        });
        this.JBTValdiar.setFont(new Font("Arial", 1, 12));
        this.JBTValdiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTValdiar.setText("Validar");
        this.JBTValdiar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionHL7Infinity.3
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionHL7Infinity.this.JBTValdiarActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFImportacionHL7Infinity.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionHL7Infinity.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JFTFContador.setEditable(false);
        this.JFTFContador.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFContador.setForeground(Color.blue);
        this.JFTFContador.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFContador.setHorizontalAlignment(0);
        this.JFTFContador.setText("0");
        this.JFTFContador.setFont(new Font("Arial", 1, 12));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 1011, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBTEscuchar, -2, 235, -2).addGap(48, 48, 48).addComponent(this.JBTValdiar, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTGrabar, -2, 238, -2).addGap(35, 35, 35).addComponent(this.JFTFContador, -2, 136, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 376, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTEscuchar, -2, 55, -2).addComponent(this.JBTValdiar, -2, 55, -2).addComponent(this.JBTGrabar, -2, 55, -2).addComponent(this.JFTFContador, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEscucharActionPerformed(ActionEvent evt) {
        mCargarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValdiarActionPerformed(ActionEvent evt) {
        if (this.JTBDatosImp.getRowCount() >= 0) {
            try {
                mValidarIdProtocolo();
            } catch (InterruptedException ex) {
                Logger.getLogger(JIFImportacionHL7Infinity.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void mValidarIdProtocolo() throws InterruptedException {
        int x = 0;
        while (x < this.JTBDatosImp.getRowCount()) {
            List<Object[]> list = this.xImplLabotaorio.devuelveIdProtocoloProcedimiento_Infinity(this.xmodelo.getValueAt(x, 3).toString(), this.xmodelo.getValueAt(x, 2).toString());
            List<Object[]> idlist = this.xImplLabotaorio.consultarNOrdenFacturacion_IdRecepcion(this.xmodelo.getValueAt(x, 13).toString());
            System.out.println("" + this.xmodelo.getValueAt(x, 2).toString());
            System.out.println("" + this.xmodelo.getValueAt(x, 3).toString());
            if (this.xmodelo.getValueAt(x, 7).toString().isEmpty() || this.xmodelo.getValueAt(x, 8).toString().isEmpty() || this.xmodelo.getValueAt(x, 4).toString().equals("*000")) {
                this.xmodelo.setValueAt(false, x, 15);
            } else if (Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue() <= Double.valueOf(this.xmodelo.getValueAt(x, 7).toString()).doubleValue() || Double.valueOf(this.xmodelo.getValueAt(x, 4).toString()).doubleValue() >= Double.valueOf(this.xmodelo.getValueAt(x, 8).toString()).doubleValue()) {
                this.xmodelo.setValueAt(true, x, 15);
            }
            if (list.size() > 0) {
                this.xmodelo.setValueAt(list.get(0)[0], x, 16);
            } else {
                this.xmodelo.setValueAt(0, x, 16);
            }
            if (idlist.size() > 0) {
                this.xmodelo.setValueAt(idlist.get(0)[0], x, 18);
            }
            List<Object[]> idlistR = this.xImplLabotaorio.consultarResultadoProtoolo(this.xmodelo.getValueAt(x, 13).toString(), Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()));
            if (idlistR.size() > 0) {
                this.xmodelo.setValueAt(true, x, 17);
            }
            if (x % 100 == 0) {
                Thread.sleep(5000L);
            }
            x++;
        }
    }

    private void mGrabar() {
        for (int x = 0; x < this.JTBDatosImp.getRowCount(); x++) {
            System.out.println("POS: " + x + ", R?: " + Boolean.valueOf(this.xmodelo.getValueAt(x, 17).toString()) + ", Id_Pr: " + Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()) + ", Nº Orden: " + this.xmodelo.getValueAt(x, 13).toString());
            if (!Boolean.valueOf(this.xmodelo.getValueAt(x, 17).toString()).booleanValue() && Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()).longValue() != 0 && !this.xmodelo.getValueAt(x, 13).toString().isEmpty()) {
                System.out.println("POS " + x);
                int xalterado = 0;
                if (Boolean.valueOf(this.xmodelo.getValueAt(x, 15).toString()).booleanValue()) {
                    xalterado = 1;
                }
                Long idResultado = this.xImplLabotaorio.addResultado(this.xmodelo.getValueAt(x, 13).toString(), this.xmodelo.getValueAt(x, 12).toString().substring(0, 4) + "-" + this.xmodelo.getValueAt(x, 12).toString().substring(4, 6) + "-" + this.xmodelo.getValueAt(x, 12).toString().substring(6, 8), "", Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), "0", "");
                this.xImplLabotaorio.addResultadoDetalle(idResultado, this.xmodelo.getValueAt(x, 12).toString().substring(0, 4) + "-" + this.xmodelo.getValueAt(x, 12).toString().substring(4, 6) + "-" + this.xmodelo.getValueAt(x, 12).toString().substring(6, 8) + " " + this.xmodelo.getValueAt(x, 12).toString().substring(8, 10) + ":" + this.xmodelo.getValueAt(x, 12).toString().substring(10, 12) + ":" + this.xmodelo.getValueAt(x, 12).toString().substring(12, 14), Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()), Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()), this.xmodelo.getValueAt(x, 4).toString(), this.xmodelo.getValueAt(x, 4).toString(), "", this.xmodelo.getValueAt(x, 7).toString(), this.xmodelo.getValueAt(x, 8).toString(), "", Integer.valueOf(xalterado), 1, 1, "", "");
                this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(xalterado), 1, Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()), Long.valueOf(this.xmodelo.getValueAt(x, 13).toString()), 0, 1);
                this.xImplLabotaorio.updateDetalleResultadoHistorio(idResultado, Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()));
                this.xImplLabotaorio.updateIdResultadoComentario(Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()), Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()), idResultado);
                this.xImplLabotaorio.updateIdResultadoOrdenFacturacion(idResultado, Long.valueOf(this.xmodelo.getValueAt(x, 18).toString()), Long.valueOf(this.xmodelo.getValueAt(x, 3).toString()));
                List<Object[]> idlistR = this.xImplLabotaorio.consultarResultadoProtoolo(this.xmodelo.getValueAt(x, 13).toString(), Long.valueOf(this.xmodelo.getValueAt(x, 16).toString()));
                if (idlistR.size() > 0) {
                    this.xmodelo.setValueAt(true, x, 17);
                }
            }
        }
    }
}
