package GestionDoc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.gestiondoc.AtencionesManualesDAO;
import com.genoma.plus.dao.impl.gestiondoc.AtencionManualesDAOImpl;
import com.genoma.plus.dto.gestiondoc.AtencionesManualesDTO;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFCargarSoporteLoteGD.class */
public class JIFCargarSoporteLoteGD extends JInternalFrame {
    private File xfile;
    private AtencionesManualesDAO xAtencionesManualesDAO;
    private ButtonGroup JBGOpciones;
    private JLabel JLBNArchivos;
    private JPanel JPIDatos;
    private JRadioButton JRBConcepto;
    private JRadioButton JRBHistoriaCIdAtencion;
    private JRadioButton JRBLecturas;
    private JRadioButton JRBLecturas3;
    private JRadioButton JRBPAuditivo;
    private JRadioButton JRBPDF_Imagenes;
    private JRadioButton JRBPRespiratorio;
    private JRadioButton JRBPruebaAyD;
    private JRadioButton JRBRx;
    private JTextField JTFRuta;
    boolean xguardado = false;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xsql = "";
    JFileChooser xfilec = null;

    public JIFCargarSoporteLoteGD() {
        initComponents();
        mIniciar_Ruta();
        springStart();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFRuta = new JTextField();
        this.JLBNArchivos = new JLabel();
        this.JRBRx = new JRadioButton();
        this.JRBLecturas = new JRadioButton();
        this.JRBConcepto = new JRadioButton();
        this.JRBPruebaAyD = new JRadioButton();
        this.JRBLecturas3 = new JRadioButton();
        this.JRBPRespiratorio = new JRadioButton();
        this.JRBPAuditivo = new JRadioButton();
        this.JRBPDF_Imagenes = new JRadioButton();
        this.JRBHistoriaCIdAtencion = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR SOPORTE POR LOTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcargarsoportelotegd");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.1
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JLBNArchivos.setFont(new Font("Arial", 1, 18));
        this.JLBNArchivos.setForeground(new Color(0, 102, 51));
        this.JLBNArchivos.setHorizontalAlignment(0);
        this.JBGOpciones.add(this.JRBRx);
        this.JRBRx.setFont(new Font("Arial", 1, 12));
        this.JRBRx.setSelected(true);
        this.JRBRx.setText("Rx");
        this.JRBRx.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.2
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBRxMouseClicked(evt);
            }
        });
        this.JRBRx.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.3
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBRxActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBLecturas);
        this.JRBLecturas.setFont(new Font("Arial", 1, 12));
        this.JRBLecturas.setText("Lecturas");
        this.JRBLecturas.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.4
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBLecturasMouseClicked(evt);
            }
        });
        this.JBGOpciones.add(this.JRBConcepto);
        this.JRBConcepto.setFont(new Font("Arial", 1, 12));
        this.JRBConcepto.setText("Conceptos So");
        this.JBGOpciones.add(this.JRBPruebaAyD);
        this.JRBPruebaAyD.setFont(new Font("Arial", 1, 12));
        this.JRBPruebaAyD.setText("Prueba AyD");
        this.JRBPruebaAyD.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.5
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPruebaAyDMouseClicked(evt);
            }
        });
        this.JRBPruebaAyD.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.6
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPruebaAyDActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBLecturas3);
        this.JRBLecturas3.setFont(new Font("Arial", 1, 12));
        this.JRBLecturas3.setText("Test Fatiga");
        this.JRBLecturas3.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.7
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBLecturas3MouseClicked(evt);
            }
        });
        this.JRBLecturas3.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.8
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBLecturas3ActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBPRespiratorio);
        this.JRBPRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JRBPRespiratorio.setText("Test Protector Respiratorio");
        this.JRBPRespiratorio.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.9
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPRespiratorioMouseClicked(evt);
            }
        });
        this.JRBPRespiratorio.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.10
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPRespiratorioActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBPAuditivo);
        this.JRBPAuditivo.setFont(new Font("Arial", 1, 12));
        this.JRBPAuditivo.setText("Test Auditivo");
        this.JRBPAuditivo.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.11
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPAuditivoMouseClicked(evt);
            }
        });
        this.JRBPAuditivo.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.12
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPAuditivoActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBPDF_Imagenes);
        this.JRBPDF_Imagenes.setFont(new Font("Arial", 1, 12));
        this.JRBPDF_Imagenes.setText("Crear Pdf Imagenes");
        this.JRBPDF_Imagenes.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.13
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBPDF_ImagenesActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBHistoriaCIdAtencion);
        this.JRBHistoriaCIdAtencion.setFont(new Font("Arial", 1, 12));
        this.JRBHistoriaCIdAtencion.setText("Historia_IdAtencion");
        this.JRBHistoriaCIdAtencion.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCargarSoporteLoteGD.14
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBHistoriaCIdAtencionMouseClicked(evt);
            }
        });
        this.JRBHistoriaCIdAtencion.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCargarSoporteLoteGD.15
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporteLoteGD.this.JRBHistoriaCIdAtencionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNArchivos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFRuta).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBRx).addGap(18, 18, 18).addComponent(this.JRBLecturas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConcepto).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPruebaAyD)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBPRespiratorio).addGap(32, 32, 32).addComponent(this.JRBPAuditivo))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBPDF_Imagenes).addGap(0, 0, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBLecturas3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBHistoriaCIdAtencion).addGap(32, 32, 32))))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRx).addComponent(this.JRBLecturas).addComponent(this.JRBConcepto).addComponent(this.JRBPruebaAyD).addComponent(this.JRBLecturas3).addComponent(this.JRBHistoriaCIdAtencion)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPRespiratorio).addComponent(this.JRBPAuditivo).addComponent(this.JRBPDF_Imagenes)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRuta, -2, 56, -2).addGap(18, 18, 18).addComponent(this.JLBNArchivos, -2, 46, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        pack();
    }

    private void springStart() {
        this.xAtencionesManualesDAO = (AtencionManualesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("AtencionesManualesDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.xct.traerDato("SELECT DevuelveMes('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')");
            this.xct.cerrarConexionBd();
            this.xfilec.setFileSelectionMode(1);
            int xv = this.xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = this.xfilec.getSelectedFile();
                String xprevio = this.xfile.getAbsolutePath() + this.xmt.getBarra();
                this.JTFRuta.setText(xprevio);
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
    public void JRBPRespiratorioActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLecturas3ActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPAuditivoActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPDF_ImagenesActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRxActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRxMouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPAuditivoMouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPRespiratorioMouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLecturasMouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPruebaAyDActionPerformed(ActionEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPruebaAyDMouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLecturas3MouseClicked(MouseEvent evt) {
        mIniciar_Ruta();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHistoriaCIdAtencionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBHistoriaCIdAtencionActionPerformed(ActionEvent evt) {
    }

    public void mGrabar() {
        String[] ficheros = this.xfile.list();
        if (ficheros != null) {
            if (!this.JTFRuta.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    boolean xestadog = false;
                    for (int x = 0; x <= ficheros.length - 1; x++) {
                        if (this.JRBRx.isSelected()) {
                            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                this.xsql = "update h_radiologia set Url_Estudio='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "\\\\DICOMDIR' WHERE (`Url_Estudio` ='' AND `Id` ='" + ficheros[x] + "') ";
                            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
                                if (!ficheros[x].contains(".") && isNumeric(ficheros[x])) {
                                    this.xsql = "update h_radiologia set Url_Estudio='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "' WHERE (`Url_Estudio` ='' AND `Id` ='" + ficheros[x] + "') ";
                                }
                            } else {
                                this.xsql = "update h_radiologia set Url_Estudio='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "\\\\VOL1\\\\DICOMDIR' WHERE (`Url_Estudio` ='' AND `Id` ='" + ficheros[x] + "') ";
                            }
                            if (!this.xsql.isEmpty()) {
                                this.xct.ejecutarSQL(this.xsql);
                                this.xsql = "";
                            }
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBConcepto.isSelected()) {
                            this.xsql = "update h_so_concepto_laboral set Url_Soporte='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "' WHERE (`Url_Soporte` =''AND `Id` ='" + ficheros[x].substring(0, ficheros[x].length() - 4) + "') ";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBPruebaAyD.isSelected()) {
                            this.xsql = "update h_so_alcohol_drogas set Url_Soporte='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "' WHERE (`Url_Soporte` =''AND `Id` ='" + ficheros[x].substring(0, ficheros[x].length() - 4) + "') ";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBPRespiratorio.isSelected()) {
                            this.xsql = "update h_so_test_prespiratorio set UrlSoporte='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "' WHERE (`UrlSoporte` =''AND `Id` ='" + ficheros[x].substring(0, ficheros[x].length() - 4) + "') ";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBPAuditivo.isSelected()) {
                            this.xsql = "update h_so_test_auditivo set UrlSoporte='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "' WHERE (`UrlSoporte` =''AND `Id` ='" + ficheros[x].substring(0, ficheros[x].length() - 4) + "') ";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBPDF_Imagenes.isSelected()) {
                            mCrear_Pdf();
                        } else if (this.JRBHistoriaCIdAtencion.isSelected()) {
                            List<Object[]> listvalidacion = this.xAtencionesManualesDAO.validacion(ficheros[x].substring(0, ficheros[x].length() - 4));
                            if (listvalidacion.size() > 0) {
                                AtencionesManualesDTO ixAM = new AtencionesManualesDTO();
                                ixAM.setIdUsuario(Long.valueOf(Long.parseLong(listvalidacion.get(0)[0].toString())));
                                ixAM.setFechaAtencion(listvalidacion.get(0)[1].toString());
                                ixAM.setIdTipoDoc(1);
                                ixAM.setIdEspecialidad(Long.valueOf(Long.parseLong(listvalidacion.get(0)[3].toString())));
                                ixAM.setIdProfesional(Long.valueOf(Long.parseLong(listvalidacion.get(0)[2].toString())));
                                ixAM.setUrl(this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x]);
                                ixAM.setEstado(true);
                                ixAM.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                                this.xAtencionesManualesDAO.mCreate(ixAM);
                            }
                        }
                        xestadog = true;
                    }
                    if (xestadog) {
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
    }

    public void mNuevo() {
        this.JTFRuta.setText("");
        this.JLBNArchivos.setText("");
    }

    public void grabar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String[] ficheros = this.xfile.list();
                ConsultasMySQL xmt = new ConsultasMySQL();
                Metodos mt = new Metodos();
                if (this.JRBRx.isSelected()) {
                    if (ficheros != null) {
                        for (int x = 0; x <= ficheros.length - 1; x++) {
                            String xid = ficheros[x].substring(0, ficheros[x].length() - 4);
                            String sql = "update d_descuento set url='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x] + "', Fecha_CargueS='" + mt.formatoAMDH24.format(mt.getFechaActual()) + "', Usuario_CargueS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + xid + "'";
                            xmt.ejecutarSQL(sql);
                            xmt.cerrarConexionBd();
                        }
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    return;
                }
                if (this.JRBRx.isSelected()) {
                    if (ficheros != null) {
                        for (int x2 = 0; x2 <= ficheros.length - 1; x2++) {
                            String xid2 = ficheros[x2].substring(0, ficheros[x2].length() - 4);
                            String sql2 = "update h_ordenes set UrlSoporte='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x2] + "' where Id='" + xid2 + "'";
                            xmt.ejecutarSQL(sql2);
                            xmt.cerrarConexionBd();
                        }
                        JOptionPane.showInternalMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    return;
                }
                if (this.JRBRx.isSelected() && ficheros != null) {
                    for (int x3 = 0; x3 <= ficheros.length - 1; x3++) {
                        String xid3 = ficheros[x3].substring(0, ficheros[x3].length() - 4);
                        String sql3 = "update h_ordenes set UrlGuiaEnvio='" + this.JTFRuta.getText().replace("\\", "\\\\") + "" + ficheros[x3] + "' where Id='" + xid3 + "'";
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

    private void mIniciar_Ruta() {
        this.xfilec = null;
        String xmes = this.xct.traerDato("SELECT DevuelveMes('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "')");
        this.xct.cerrarConexionBd();
        if (this.JRBRx.isSelected()) {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_Rx"));
                return;
            } else {
                this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_Rx") + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + this.xmt.getBarra() + xmes);
                return;
            }
        }
        if (this.JRBLecturas.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_Lecturas"));
            return;
        }
        if (this.JRBConcepto.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_ConceptoSO") + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + this.xmt.getBarra() + xmes);
            return;
        }
        if (this.JRBPruebaAyD.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_PruebaAyD") + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + this.xmt.getBarra() + xmes);
            return;
        }
        if (this.JRBPRespiratorio.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_PRespiratoria") + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + this.xmt.getBarra() + xmes);
            return;
        }
        if (this.JRBPDF_Imagenes.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_PDFImagen"));
        } else if (this.JRBPAuditivo.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.mRutaSoporte("JIFCargarSoporteLoteG_TestAuditivo") + this.xmt.formatoANO.format(this.xmt.getFechaActual()) + this.xmt.getBarra() + xmes);
        } else if (this.JRBHistoriaCIdAtencion.isSelected()) {
            this.xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
        }
    }

    private void mCrear_Pdf() {
        try {
            Document mipdf = new Document();
            PdfWriter.getInstance(mipdf, new FileOutputStream(new File("F:/tablas.pdf")));
            mipdf.open();
            mipdf.addTitle("Tablas con itext");
            mipdf.addAuthor("jc mouse");
            mipdf.addSubject("ocio");
            mipdf.addKeywords("jc mouse");
            mipdf.add(Tabla_compleja());
            mipdf.close();
        } catch (DocumentException e) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public PdfPTable Tabla_compleja() {
        PdfPTable mitablacompleja = new PdfPTable(6);
        try {
            String[] ficheros = this.xfile.list();
            for (int x = 0; x <= ficheros.length - 1; x++) {
                if (ficheros[x].substring(ficheros[x].length() - 3, ficheros[x].length()).equals("jpg")) {
                    Image imagen = Image.getInstance(this.JTFRuta.getText() + "" + ficheros[x]);
                    PdfPCell celda = new PdfPCell(imagen);
                    celda.setColspan(2);
                    mitablacompleja.addCell(celda);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (BadElementException e) {
            Logger.getLogger(JIFCargarSoporteLoteGD.class.getName()).log(Level.SEVERE, (String) null, e);
        }
        return mitablacompleja;
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
