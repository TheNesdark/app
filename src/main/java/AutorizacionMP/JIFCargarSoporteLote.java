package AutorizacionMP;

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

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFCargarSoporteLote.class */
public class JIFCargarSoporteLote extends JInternalFrame {
    private File xfile;
    boolean xguardado = false;
    private int xestado = 0;
    private Metodos xmetodos = new Metodos();
    private ButtonGroup JBGOpciones;
    private JLabel JLBNArchivos;
    private JPanel JPIDatos;
    private JRadioButton JRBEnviada;
    private JRadioButton JRBGuias;
    private JRadioButton JRBNoEnviada;
    private JTextField JTFRuta;

    public JIFCargarSoporteLote() {
        initComponents();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFRuta = new JTextField();
        this.JLBNArchivos = new JLabel();
        this.JRBEnviada = new JRadioButton();
        this.JRBNoEnviada = new JRadioButton();
        this.JRBGuias = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR SOPORTE POR LOTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcargarsoportelote");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFCargarSoporteLote.1
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLote.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JLBNArchivos.setFont(new Font("Arial", 1, 18));
        this.JLBNArchivos.setForeground(new Color(0, 102, 51));
        this.JLBNArchivos.setHorizontalAlignment(0);
        this.JBGOpciones.add(this.JRBEnviada);
        this.JRBEnviada.setFont(new Font("Arial", 1, 12));
        this.JRBEnviada.setSelected(true);
        this.JRBEnviada.setText("Descuentos");
        this.JRBEnviada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarSoporteLote.2
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLote.this.JRBEnviadaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBNoEnviada);
        this.JRBNoEnviada.setFont(new Font("Arial", 1, 12));
        this.JRBNoEnviada.setText("Formulas");
        this.JRBNoEnviada.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarSoporteLote.3
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLote.this.JRBNoEnviadaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBGuias);
        this.JRBGuias.setFont(new Font("Arial", 1, 12));
        this.JRBGuias.setText("Guías");
        this.JRBGuias.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarSoporteLote.4
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLote.this.JRBGuiasActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBEnviada).addGap(18, 18, 18).addComponent(this.JRBNoEnviada).addGap(10, 10, 10).addComponent(this.JRBGuias)).addComponent(this.JTFRuta, -2, 384, -2).addComponent(this.JLBNArchivos, GroupLayout.Alignment.TRAILING, -1, 393, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEnviada).addComponent(this.JRBNoEnviada).addComponent(this.JRBGuias)).addGap(9, 9, 9).addComponent(this.JTFRuta, -2, -1, -2).addGap(27, 27, 27).addComponent(this.JLBNArchivos, -2, 42, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatos, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = null;
            if (this.xestado == 0) {
                xfilec = new JFileChooser("S:\\Descuentos MP\\");
            } else if (this.xestado == 1) {
                xfilec = new JFileChooser("S:\\FormulasEscaneadas\\");
            } else if (this.xestado == 2) {
                xfilec = new JFileChooser("S:\\enviomedicamentos\\");
            }
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                String xprevio = this.xfile.getAbsolutePath() + "\\";
                this.JTFRuta.setText(this.xmetodos.mTraerUrlBD(xprevio));
                String[] ficheros = this.xfile.list();
                if (ficheros == null) {
                    this.JLBNArchivos.setText("Archivos Encontrados : 0");
                } else {
                    this.JLBNArchivos.setText("Archivos Encontrados : " + String.valueOf(ficheros.length));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEnviadaActionPerformed(ActionEvent evt) {
        this.xestado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoEnviadaActionPerformed(ActionEvent evt) {
        this.xestado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGuiasActionPerformed(ActionEvent evt) {
        this.xestado = 2;
    }

    public void grabar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String[] ficheros = this.xfile.list();
                ConsultasMySQL xmt = new ConsultasMySQL();
                Metodos mt = new Metodos();
                if (this.xestado == 0) {
                    if (ficheros != null) {
                        for (int x = 0; x <= ficheros.length - 1; x++) {
                            String xid = ficheros[x].substring(0, ficheros[x].length() - 4);
                            String sql = "update d_descuento set url='" + this.JTFRuta.getText() + "" + ficheros[x] + "', Fecha_CargueS='" + mt.formatoAMDH24.format(mt.getFechaActual()) + "', Usuario_CargueS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + xid + "'";
                            xmt.ejecutarSQL(sql);
                            xmt.cerrarConexionBd();
                        }
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
                    JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
