package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFCargarSoporteLoteC.class */
public class JIFCargarSoporteLoteC extends JInternalFrame {
    private File xfile;
    boolean xguardado = false;
    private int xestado = 0;
    private Metodos xmetodos = new Metodos();
    private ButtonGroup JBGOpciones;
    private JLabel JLBNArchivos;
    private JPanel JPIDatos;
    private JRadioButton JRBContratos;
    private JRadioButton JRBFacturas;
    private JRadioButton JRBOtros;
    private JTextField JTFRuta;

    public JIFCargarSoporteLoteC() {
        initComponents();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFRuta = new JTextField();
        this.JLBNArchivos = new JLabel();
        this.JRBFacturas = new JRadioButton();
        this.JRBContratos = new JRadioButton();
        this.JRBOtros = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR SOPORTE POR LOTE");
        setFont(new Font("Arial", 0, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcargarsoportelote1");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFCargarSoporteLoteC.1
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JLBNArchivos.setFont(new Font("Arial", 1, 18));
        this.JLBNArchivos.setForeground(new Color(0, 102, 51));
        this.JLBNArchivos.setHorizontalAlignment(0);
        this.JBGOpciones.add(this.JRBFacturas);
        this.JRBFacturas.setFont(new Font("Arial", 1, 12));
        this.JRBFacturas.setSelected(true);
        this.JRBFacturas.setText("Facturas");
        this.JRBFacturas.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCargarSoporteLoteC.2
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteC.this.JRBFacturasActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBContratos);
        this.JRBContratos.setFont(new Font("Arial", 1, 12));
        this.JRBContratos.setText("Contratos");
        this.JRBContratos.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCargarSoporteLoteC.3
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteC.this.JRBContratosActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBOtros);
        this.JRBOtros.setFont(new Font("Arial", 1, 12));
        this.JRBOtros.setText("Otros");
        this.JRBOtros.addActionListener(new ActionListener() { // from class: Contabilidad.JIFCargarSoporteLoteC.4
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteC.this.JRBOtrosActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBFacturas).addGap(18, 18, 18).addComponent(this.JRBContratos).addGap(10, 10, 10).addComponent(this.JRBOtros)).addComponent(this.JTFRuta, -2, 384, -2).addComponent(this.JLBNArchivos, GroupLayout.Alignment.TRAILING, -1, 393, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFacturas).addComponent(this.JRBContratos).addComponent(this.JRBOtros)).addGap(9, 9, 9).addComponent(this.JTFRuta, -2, -1, -2).addGap(27, 27, 27).addComponent(this.JLBNArchivos, -2, 42, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            SimpleDateFormat xfa = new SimpleDateFormat("yyyy");
            JFileChooser xfilec = null;
            if (this.xestado == 0) {
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                    xfilec = new JFileChooser("P:\\Soportes Facturas\\" + xfa.format(this.xmetodos.getFechaActual()));
                } else if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                    xfilec = new JFileChooser("U:\\DOCUMENTOS CONTABLES\\");
                } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    xfilec = new JFileChooser("S:\\Contabilidad\\Facturas\\" + xfa.format(this.xmetodos.getFechaActual()));
                } else {
                    xfilec = new JFileChooser(this.xmetodos.mRutaSoporte("jifcargarsoportelote1"));
                }
            } else if (this.xestado == 1 || this.xestado == 2) {
                xfilec = new JFileChooser("S:\\Contabilidad\\");
            }
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                String xprevio = this.xfile.getAbsolutePath() + this.xmetodos.getBarra();
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(xprevio));
                String[] ficheros = this.xfile.list();
                if (ficheros == null) {
                    this.JLBNArchivos.setText("Archivos Encontrados : 0");
                } else {
                    this.JLBNArchivos.setText("Archivos Encontrados : " + String.valueOf(ficheros.length - 1));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFacturasActionPerformed(ActionEvent evt) {
        this.xestado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBContratosActionPerformed(ActionEvent evt) {
        this.xestado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtrosActionPerformed(ActionEvent evt) {
        this.xestado = 2;
    }

    public void mGrabar() {
        String xid;
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String[] ficheros = this.xfile.list();
                ConsultasMySQL xmt = new ConsultasMySQL();
                new Metodos();
                if (this.xestado == 0) {
                    if (ficheros != null) {
                        xmt.ejecutarSQL("UPDATE `cc_radicacion`, `cc_documentoc` SET cc_radicacion.`Id_Documento`=cc_documentoc.`Id`  WHERE (cc_documentoc.`Id_Radicacion`=cc_radicacion.`Id` AND (cc_radicacion.`Id_Documento`=0  OR cc_radicacion.`Id_Documento` is null)) ");
                        xmt.cerrarConexionBd();
                        for (int x = 0; x <= ficheros.length - 1; x++) {
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                                xid = ficheros[x].substring(1, ficheros[x].length() - 4);
                            } else {
                                xid = ficheros[x].substring(0, ficheros[x].length() - 4);
                            }
                            String sql = null;
                            if (this.xestado == 0) {
                                sql = "update cc_radicacion set UrlFactura='" + this.JTFRuta.getText() + "" + ficheros[x] + "' where Id_Documento='" + xid + "' and  Id_Documento<>0";
                            }
                            xmt.ejecutarSQL(sql);
                            xmt.cerrarConexionBd();
                        }
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    return;
                }
                if (this.xestado == 1) {
                    if (ficheros != null) {
                        for (int x2 = 0; x2 <= ficheros.length - 1; x2++) {
                            String xid2 = ficheros[x2].substring(0, ficheros[x2].length() - 4);
                            String sql2 = "update h_ordenes set UrlSoporte='" + this.JTFRuta.getText() + "" + ficheros[x2] + "' where Id='" + xid2 + "'";
                            xmt.ejecutarSQL(sql2);
                            xmt.cerrarConexionBd();
                        }
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    return;
                }
                if (this.xestado == 2 && ficheros != null) {
                    for (int x3 = 0; x3 <= ficheros.length - 1; x3++) {
                        String xid3 = ficheros[x3].substring(0, ficheros[x3].length() - 4);
                        String sql3 = "update h_ordenes set UrlGuiaEnvio='" + this.JTFRuta.getText() + "" + ficheros[x3] + "' where Id='" + xid3 + "'";
                        xmt.ejecutarSQL(sql3);
                        xmt.cerrarConexionBd();
                    }
                    JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un directorio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    public void nuevo() {
        this.JTFRuta.setText((String) null);
        this.JLBNArchivos.setText((String) null);
    }
}
