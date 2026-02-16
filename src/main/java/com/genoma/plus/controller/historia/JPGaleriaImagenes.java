package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import Utilidades.WebCam;
import com.genoma.plus.dao.historia.AtencionImagenesDAO;
import com.genoma.plus.dao.impl.historia.AtencionImagenesDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.historia.AtencionImagenesDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPGaleriaImagenes.class */
public class JPGaleriaImagenes extends JPanel {
    private DefaultTableModel xmodelo;
    private AtencionImagenesDAO xAtencionImagenesDAO;
    private clasesHistoriaCE xclase;
    private Object[] xDato;
    private String[] xidClasificacion;
    private String[] xidClasificacion1;
    private File xfile;
    private File directorio;
    public static ArrayList<ImageIcon> fotos = new ArrayList<>();
    WebCam pnlCamara;
    private ImageIcon nofoto;
    private JButton CMD_NEXT;
    private JButton CMD_PREVIEW;
    private JLabel FOTO_A;
    private JLabel FOTO_B;
    private JLabel FOTO_C;
    private JLabel FOTO_D;
    private JLabel FOTO_GRANDE;
    private JButton JBTCaptura;
    private JButton JBTCargar;
    private JComboBox JCBClasificacion;
    private JComboBox JCBClasificacion1;
    private JCheckBox JCHClasificar;
    private JCheckBox JCHEstado;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFecha;
    private JLabel JLBNRespuesta;
    private JLabel JLFotografia;
    private JPanel JPCamara;
    private JPanel JPGaleria;
    private JPanel JPHistorico;
    private JPanel JPICamara;
    private JPanel JPIFoto;
    private JRadioButton JRBAno;
    private JRadioButton JRBTodos;
    private JSpinner JSAno;
    private JScrollPane JSPComentario;
    private JScrollPane JSPHistorico;
    private JTextArea JTAComentario;
    private JTabbedPane JTBCamara;
    private JTextField JTFRuta;
    private JTable JTHistorico;
    private JTabbedPane JTPMenu;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private int xEstado = 0;
    private int xfiltro = 0;
    private Metodos xmetodo = new Metodos();
    private int a = 0;
    private int b = 1;
    private int c = 2;
    private int d = 3;

    public JPGaleriaImagenes(clasesHistoriaCE xclase) {
        this.pnlCamara = null;
        initComponents();
        springStart();
        this.xclase = xclase;
        this.nofoto = new ImageIcon(getClass().getResource("/Imagenes/nofoto.gif"));
        this.pnlCamara = new WebCam(640, 480);
        this.pnlCamara.setSize(694, 550);
        this.JPICamara.add(this.pnlCamara);
        if (this.pnlCamara.webcam == null) {
            this.JBTCaptura.setEnabled(false);
            this.pnlCamara.discovery.stop();
        }
        mNuevo();
    }

    private void springStart() {
        this.xAtencionImagenesDAO = (AtencionImagenesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("atencionImagenesDAO");
    }

    public void mNuevo() {
        this.directorio = new File(this.xmetodo.mRutaSoporte("JPGaleriaImagenes"));
        this.JSAno.setValue(Integer.valueOf(this.xmetodo.formatoANO.format(this.xmetodo.getFechaActual())));
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JLBNRespuesta.setText("0");
        this.JCBClasificacion.removeAllItems();
        List<GCGenericoDTO> list1 = this.xAtencionImagenesDAO.listClasificacion();
        this.xidClasificacion = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidClasificacion[x] = String.valueOf(list1.get(x).getId());
            this.JCBClasificacion.addItem(list1.get(x).getNombre());
        }
        this.JCBClasificacion.setSelectedIndex(-1);
        this.JTAComentario.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JTFRuta.setText("");
        this.JLFotografia.setIcon((Icon) null);
        this.a = 0;
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.FOTO_A.setText("");
        this.FOTO_B.setText("");
        this.FOTO_C.setText("");
        this.FOTO_D.setText("");
        this.FOTO_GRANDE.setText("");
        this.FOTO_A.setIcon(getPreview(0));
        this.FOTO_B.setIcon(getPreview(1));
        this.FOTO_C.setIcon(getPreview(2));
        this.FOTO_D.setIcon(getPreview(3));
        mCargarDatosTabla();
    }

    public void mGuardar() {
        File f1;
        if (this.JCBClasificacion.getSelectedIndex() != -1) {
            if (this.JLFotografia.getIcon() != null) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    AtencionImagenesDTO e = new AtencionImagenesDTO();
                    if (this.JLBNRespuesta.getText().equals("0")) {
                        this.directorio = new File(this.xmetodo.mRutaSoporte("JPGaleriaImagenes"));
                        e.setIdAtencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                        e.setIdClasificacion(this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()]);
                        e.setFechaR(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
                        e.setComentario(this.JTAComentario.getText());
                        e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
                        e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                        e.setEstado(this.xEstado);
                        String xidDoc = this.xAtencionImagenesDAO.create_return_id_Detalle(e);
                        this.JLBNRespuesta.setText(xidDoc);
                        String adjunto = xidDoc + "_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "_" + this.JCBClasificacion.getSelectedItem() + ".jpg";
                        e.setUrlImagen(this.xmetodo.mTraerUrlBD(adjunto));
                        e.setId(Integer.valueOf(xidDoc).intValue());
                        this.xAtencionImagenesDAO.mUpdateURLDetalle(e);
                        if (this.JTFRuta.getText().isEmpty()) {
                            f1 = new File("Foto.jpg");
                        } else {
                            f1 = new File(this.JTFRuta.getText());
                        }
                        File f2 = new File(adjunto);
                        f1.renameTo(f2);
                        f2.renameTo(new File(this.directorio, f2.getName()));
                    } else {
                        e.setIdClasificacion(this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()]);
                        e.setComentario(this.JTAComentario.getText());
                        e.setEstado(this.xEstado);
                        e.setId(this.xEstado);
                        e.setId(Long.valueOf(this.JLBNRespuesta.getText()).longValue());
                        this.xAtencionImagenesDAO.update(e);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe Realizar Primero Una Captura De La Camara", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este Seguimiento se encuentra Anulado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "No. Atencion", "Clasificacion", "Comentario", "Imagen", "Profesional", "Especialidad", "Estado", "Seleccionar?", "DXP", "Diagnostico Principal"}) { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.1
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false, false};

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
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(11).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        int xvalidar = 0;
        List<AtencionImagenesDTO> list = null;
        if (this.JCHClasificar.isSelected()) {
            if (this.JCBClasificacion1.getSelectedIndex() != -1) {
                list = this.xAtencionImagenesDAO.list(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(this.JSAno.getValue()), this.xidClasificacion1[this.JCBClasificacion1.getSelectedIndex()], this.xfiltro);
                xvalidar = 1;
            }
        } else {
            list = this.xAtencionImagenesDAO.list(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(this.JSAno.getValue()), "", this.xfiltro);
            xvalidar = 1;
        }
        mCrearTabla();
        if (xvalidar == 1) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
                this.xmodelo.setValueAt(list.get(x).getFechaR(), x, 1);
                this.xmodelo.setValueAt(Long.valueOf(list.get(x).getIdAtencion()), x, 2);
                this.xmodelo.setValueAt(list.get(x).getIdClasificacion(), x, 3);
                this.xmodelo.setValueAt(list.get(x).getComentario(), x, 4);
                this.xmodelo.setValueAt(list.get(x).getUrlImagen(), x, 5);
                this.xmodelo.setValueAt(list.get(x).getIdProfesional(), x, 6);
                this.xmodelo.setValueAt(list.get(x).getIdEspecialidad(), x, 7);
                if (list.get(x).getEstado() == 1) {
                    this.xmodelo.setValueAt(true, x, 8);
                } else {
                    this.xmodelo.setValueAt(false, x, 8);
                }
                this.xmodelo.setValueAt(false, x, 9);
                this.xmodelo.setValueAt(list.get(x).getCodigoDx(), x, 10);
                this.xmodelo.setValueAt(list.get(x).getNDiagnostico(), x, 11);
            }
        }
    }

    public Icon getPreview(int num) {
        if ((num >= 0) & (num < fotos.size())) {
            Image mini = fotos.get(num).getImage().getScaledInstance(100, 100, 16);
            return new ImageIcon(mini);
        }
        Image mini2 = this.nofoto.getImage().getScaledInstance(100, 100, 16);
        return new ImageIcon(mini2);
    }

    public Icon getFoto(int num, Dimension d) {
        if (!(num >= 0) || !(num < fotos.size())) {
            Image mini = this.nofoto.getImage().getScaledInstance(400, 400, 16);
            return new ImageIcon(mini);
        }
        if (fotos.get(num).getIconWidth() > d.getWidth() && fotos.get(num).getIconHeight() > d.getHeight()) {
            float v = getValor(fotos.get(num).getIconWidth(), d.width);
            float v1 = getValor(fotos.get(num).getIconHeight(), d.height);
            return Disminuir(fotos.get(num), v, v1);
        }
        if (fotos.get(num).getIconWidth() > d.getWidth()) {
            float v2 = getValor(fotos.get(num).getIconWidth(), d.width);
            return Disminuir(fotos.get(num), v2);
        }
        if (fotos.get(num).getIconHeight() > d.getHeight()) {
            float v3 = getValor(fotos.get(num).getIconHeight(), d.height);
            return Disminuir(fotos.get(num), v3);
        }
        return fotos.get(num);
    }

    private ImageIcon Disminuir(ImageIcon i, float v) {
        int valEscalaX = (int) (i.getIconWidth() * v);
        int valEscalaY = (int) (i.getIconHeight() * v);
        Image mini = i.getImage().getScaledInstance(valEscalaX, valEscalaY, 16);
        return new ImageIcon(mini);
    }

    private ImageIcon Disminuir(ImageIcon i, float v, float v1) {
        int valEscalaX = (int) (i.getIconWidth() * v);
        int valEscalaY = (int) (i.getIconHeight() * v1);
        Image mini = i.getImage().getScaledInstance(valEscalaX, valEscalaY, 16);
        return new ImageIcon(mini);
    }

    private float getValor(int a, int b) {
        return Math.abs((a / new Float(b).floatValue()) - 2.0f);
    }

    public void mSalir() {
        this.pnlCamara.discovery.stop();
        if (this.pnlCamara.webcam != null) {
            this.pnlCamara.webcam.close();
        }
    }

    private void mMarcarSeleccion(boolean estado) {
        if (this.JTHistorico.getRowCount() > 0) {
            for (int i = 0; i < this.JTHistorico.getRowCount(); i++) {
                this.xmodelo.setValueAt(Boolean.valueOf(estado), i, 9);
            }
        }
    }

    private void mLlenarInformacion(String ruta) {
        for (int i = 0; i < this.JTHistorico.getRowCount(); i++) {
            if (ruta.equals(this.directorio + "\\" + this.xmodelo.getValueAt(i, 5).toString())) {
                this.JLBNRespuesta.setText(this.xmodelo.getValueAt(i, 0).toString());
                this.JDFecha.setDate(Date.valueOf(this.xmodelo.getValueAt(i, 1).toString()));
                this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(i, 3).toString());
                this.JTAComentario.setText(this.xmodelo.getValueAt(i, 4).toString());
                mCaptura(this.directorio + "\\" + this.xmodelo.getValueAt(i, 5).toString());
                this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue());
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 8).toString()).booleanValue()) {
                    this.xEstado = 1;
                } else {
                    this.xEstado = 0;
                }
            }
        }
    }

    private void mCargarGaleria() {
        if (this.JTHistorico.getRowCount() > 0) {
            fotos.clear();
            for (int i = 0; i < this.JTHistorico.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(i, 9).toString()).booleanValue()) {
                    fotos.add(new ImageIcon(this.directorio + "\\" + this.xmodelo.getValueAt(i, 5).toString()));
                }
            }
            this.a = 0;
            this.b = 1;
            this.c = 2;
            this.d = 3;
            this.FOTO_A.setIcon(getPreview(0));
            this.FOTO_B.setIcon(getPreview(1));
            this.FOTO_C.setIcon(getPreview(2));
            this.FOTO_D.setIcon(getPreview(3));
        }
    }

    private void mCaptura(String xcaptura) {
        ImageIcon fot = new ImageIcon(xcaptura);
        this.JLFotografia.setIcon(new ImageIcon(fot.getImage().getScaledInstance(320, 240, 1)));
        JLabel jLabel = this.JLFotografia;
        JLabel jLabel2 = this.JLFotografia;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.JLFotografia;
        JLabel jLabel4 = this.JLFotografia;
        jLabel3.setVerticalAlignment(0);
        this.JLFotografia.repaint();
    }

    /* JADX WARN: Type inference failed for: r3v109, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JTPMenu = new JTabbedPane();
        this.JPCamara = new JPanel();
        this.JTBCamara = new JTabbedPane();
        this.JPICamara = new JPanel();
        this.JPIFoto = new JPanel();
        this.JLFotografia = new JLabel();
        this.JDFecha = new JDateChooser();
        this.JCBClasificacion = new JComboBox();
        this.JLBNRespuesta = new JLabel();
        this.JSPComentario = new JScrollPane();
        this.JTAComentario = new JTextArea();
        this.JCHEstado = new JCheckBox();
        this.JTFRuta = new JTextField();
        this.JBTCargar = new JButton();
        this.JBTCaptura = new JButton();
        this.JPGaleria = new JPanel();
        this.jPanel1 = new JPanel();
        this.FOTO_GRANDE = new JLabel();
        this.jPanel3 = new JPanel();
        this.CMD_PREVIEW = new JButton();
        this.jPanel2 = new JPanel();
        this.FOTO_A = new JLabel();
        this.jPanel4 = new JPanel();
        this.FOTO_B = new JLabel();
        this.jPanel5 = new JPanel();
        this.FOTO_C = new JLabel();
        this.jPanel6 = new JPanel();
        this.FOTO_D = new JLabel();
        this.CMD_NEXT = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.JCHSeleccionar = new JCheckBox();
        this.JSAno = new JSpinner();
        this.JCBClasificacion1 = new JComboBox();
        this.jPanel7 = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBAno = new JRadioButton();
        this.JCHClasificar = new JCheckBox();
        setName("xjpgaleriaimagenes");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.2
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPGaleriaImagenes.this.formAncestorRemoved(evt);
            }
        });
        this.JTPMenu.setForeground(Color.red);
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTBCamara.setForeground(new Color(0, 103, 0));
        this.JTBCamara.setFont(new Font("Arial", 1, 14));
        GroupLayout JPICamaraLayout = new GroupLayout(this.JPICamara);
        this.JPICamara.setLayout(JPICamaraLayout);
        JPICamaraLayout.setHorizontalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 713, 32767));
        JPICamaraLayout.setVerticalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 534, 32767));
        this.JTBCamara.addTab("CAMARA", this.JPICamara);
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.3
            public void itemStateChanged(ItemEvent evt) {
                JPGaleriaImagenes.this.JCBClasificacionItemStateChanged(evt);
            }
        });
        this.JLBNRespuesta.setFont(new Font("Arial", 1, 18));
        this.JLBNRespuesta.setHorizontalAlignment(0);
        this.JLBNRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "Comentario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAComentario.setColumns(20);
        this.JTAComentario.setFont(new Font("Arial", 1, 12));
        this.JTAComentario.setRows(5);
        this.JSPComentario.setViewportView(this.JTAComentario);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.4
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de Imagen a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.5
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.6
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTCargar.setFont(new Font("Arial", 1, 12));
        this.JBTCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTCargar.setText("Cargar");
        this.JBTCargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.7
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JBTCargarActionPerformed(evt);
            }
        });
        GroupLayout JPIFotoLayout = new GroupLayout(this.JPIFoto);
        this.JPIFoto.setLayout(JPIFotoLayout);
        JPIFotoLayout.setHorizontalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFotografia, GroupLayout.Alignment.TRAILING, -1, 713, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIFotoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFotoLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNRespuesta, -2, 119, -2)).addComponent(this.JSPComentario).addGroup(GroupLayout.Alignment.TRAILING, JPIFotoLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 469, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCargar, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        JPIFotoLayout.setVerticalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFotoLayout.createSequentialGroup().addComponent(this.JLFotografia, -1, 308, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFecha, -2, 56, -2).addComponent(this.JCBClasificacion, -2, 50, -2).addComponent(this.JLBNRespuesta, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPComentario, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFotoLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(0, 0, 32767)).addComponent(this.JTFRuta).addComponent(this.JBTCargar, -1, -1, 32767)).addContainerGap()));
        this.JTBCamara.addTab("FOTOGRAFIA", this.JPIFoto);
        this.JBTCaptura.setFont(new Font("Arial", 1, 12));
        this.JBTCaptura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/camara.png")));
        this.JBTCaptura.setText("Capturar");
        this.JBTCaptura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.8
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JBTCapturaActionPerformed(evt);
            }
        });
        GroupLayout JPCamaraLayout = new GroupLayout(this.JPCamara);
        this.JPCamara.setLayout(JPCamaraLayout);
        JPCamaraLayout.setHorizontalGroup(JPCamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCamaraLayout.createSequentialGroup().addContainerGap().addGroup(JPCamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBCamara).addComponent(this.JBTCaptura, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPCamaraLayout.setVerticalGroup(JPCamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCamaraLayout.createSequentialGroup().addContainerGap().addComponent(this.JTBCamara, -2, 565, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCaptura).addContainerGap()));
        this.JTPMenu.addTab("CAMARA", this.JPCamara);
        this.jPanel1.setBackground(new Color(255, 255, 255));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel1.setPreferredSize(new Dimension(600, 500));
        this.jPanel1.setLayout(new CardLayout());
        this.FOTO_GRANDE.setText("foto");
        this.FOTO_GRANDE.setPreferredSize(new Dimension(560, 460));
        this.jPanel1.add(this.FOTO_GRANDE, "card2");
        this.jPanel3.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel3.setLayout(new GridBagLayout());
        this.CMD_PREVIEW.setText("<");
        this.CMD_PREVIEW.setPreferredSize(new Dimension(44, 120));
        this.CMD_PREVIEW.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.9
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.CMD_PREVIEWActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.CMD_PREVIEW, new GridBagConstraints());
        this.jPanel2.setBackground(new Color(255, 255, 255));
        this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel2.setPreferredSize(new Dimension(120, 120));
        this.jPanel2.setLayout(new GridBagLayout());
        this.FOTO_A.setText("foto");
        this.FOTO_A.setPreferredSize(new Dimension(100, 100));
        this.FOTO_A.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.10
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.FOTO_AMouseClicked(evt);
            }
        });
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = 18;
        this.jPanel2.add(this.FOTO_A, gridBagConstraints);
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 1;
        gridBagConstraints2.gridy = 0;
        gridBagConstraints2.anchor = 18;
        gridBagConstraints2.insets = new Insets(5, 5, 5, 5);
        this.jPanel3.add(this.jPanel2, gridBagConstraints2);
        this.jPanel4.setBackground(new Color(255, 255, 255));
        this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel4.setPreferredSize(new Dimension(120, 120));
        this.jPanel4.setLayout(new GridBagLayout());
        this.FOTO_B.setText("foto");
        this.FOTO_B.setPreferredSize(new Dimension(100, 100));
        this.FOTO_B.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.11
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.FOTO_BMouseClicked(evt);
            }
        });
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 0;
        gridBagConstraints3.gridy = 0;
        gridBagConstraints3.anchor = 18;
        this.jPanel4.add(this.FOTO_B, gridBagConstraints3);
        GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
        gridBagConstraints4.gridx = 2;
        gridBagConstraints4.gridy = 0;
        gridBagConstraints4.anchor = 18;
        gridBagConstraints4.insets = new Insets(5, 5, 5, 5);
        this.jPanel3.add(this.jPanel4, gridBagConstraints4);
        this.jPanel5.setBackground(new Color(255, 255, 255));
        this.jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel5.setPreferredSize(new Dimension(120, 120));
        this.jPanel5.setLayout(new GridBagLayout());
        this.FOTO_C.setText("foto");
        this.FOTO_C.setPreferredSize(new Dimension(100, 100));
        this.FOTO_C.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.12
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.FOTO_CMouseClicked(evt);
            }
        });
        GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
        gridBagConstraints5.gridx = 0;
        gridBagConstraints5.gridy = 0;
        gridBagConstraints5.anchor = 18;
        this.jPanel5.add(this.FOTO_C, gridBagConstraints5);
        GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
        gridBagConstraints6.gridx = 3;
        gridBagConstraints6.gridy = 0;
        gridBagConstraints6.anchor = 18;
        gridBagConstraints6.insets = new Insets(5, 5, 5, 5);
        this.jPanel3.add(this.jPanel5, gridBagConstraints6);
        this.jPanel6.setBackground(new Color(255, 255, 255));
        this.jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        this.jPanel6.setPreferredSize(new Dimension(120, 120));
        this.jPanel6.setLayout(new GridBagLayout());
        this.FOTO_D.setText("foto");
        this.FOTO_D.setPreferredSize(new Dimension(100, 100));
        this.FOTO_D.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.13
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.FOTO_DMouseClicked(evt);
            }
        });
        GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
        gridBagConstraints7.gridx = 0;
        gridBagConstraints7.gridy = 0;
        gridBagConstraints7.anchor = 18;
        this.jPanel6.add(this.FOTO_D, gridBagConstraints7);
        GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
        gridBagConstraints8.gridx = 4;
        gridBagConstraints8.gridy = 0;
        gridBagConstraints8.anchor = 18;
        gridBagConstraints8.insets = new Insets(5, 5, 5, 5);
        this.jPanel3.add(this.jPanel6, gridBagConstraints8);
        this.CMD_NEXT.setText(">");
        this.CMD_NEXT.setPreferredSize(new Dimension(44, 120));
        this.CMD_NEXT.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.14
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.CMD_NEXTActionPerformed(evt);
            }
        });
        GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
        gridBagConstraints9.gridx = 5;
        gridBagConstraints9.gridy = 0;
        gridBagConstraints9.anchor = 18;
        gridBagConstraints9.insets = new Insets(5, 0, 5, 5);
        this.jPanel3.add(this.CMD_NEXT, gridBagConstraints9);
        GroupLayout JPGaleriaLayout = new GroupLayout(this.JPGaleria);
        this.JPGaleria.setLayout(JPGaleriaLayout);
        JPGaleriaLayout.setHorizontalGroup(JPGaleriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGaleriaLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPGaleriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, 708, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        JPGaleriaLayout.setVerticalGroup(JPGaleriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGaleriaLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, 479, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap()));
        this.JTPMenu.addTab("GALERIA", this.JPGaleria);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.15
            public void mouseClicked(MouseEvent evt) {
                JPGaleriaImagenes.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JTHistorico.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGaleriaImagenes.this.JTHistoricoPropertyChange(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todos?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.17
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JSAno.setFont(new Font("Arial", 1, 12));
        this.JSAno.setToolTipText("");
        this.JSAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSAno.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.18
            public void stateChanged(ChangeEvent evt) {
                JPGaleriaImagenes.this.JSAnoStateChanged(evt);
            }
        });
        this.JSAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.19
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPGaleriaImagenes.this.JSAnoPropertyChange(evt);
            }
        });
        this.JCBClasificacion1.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion1.setEnabled(false);
        this.JCBClasificacion1.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.20
            public void itemStateChanged(ItemEvent evt) {
                JPGaleriaImagenes.this.JCBClasificacion1ItemStateChanged(evt);
            }
        });
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.buttonGroup1.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.21
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JRBTodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBAno);
        this.JRBAno.setFont(new Font("Arial", 1, 12));
        this.JRBAno.setText("Año");
        this.JRBAno.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.22
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JRBAnoActionPerformed(evt);
            }
        });
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBTodos).addGap(10, 10, 10).addComponent(this.JRBAno).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBAno)));
        this.JCHClasificar.setFont(new Font("Arial", 1, 12));
        this.JCHClasificar.setText("Clasificar?");
        this.JCHClasificar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPGaleriaImagenes.23
            public void actionPerformed(ActionEvent evt) {
                JPGaleriaImagenes.this.JCHClasificarActionPerformed(evt);
            }
        });
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorico).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JSAno, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion1, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHClasificar).addGap(30, 30, 30).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar))).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel7, -2, -1, -2).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSAno, -2, 50, -2).addComponent(this.JCBClasificacion1, -2, 50, -2))).addComponent(this.JCHSeleccionar, GroupLayout.Alignment.TRAILING).addComponent(this.JCHClasificar, GroupLayout.Alignment.TRAILING)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorico, -2, 552, -2).addGap(67, 67, 67)));
        this.JTPMenu.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMenu, -1, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPMenu, -2, 668, -2).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMD_PREVIEWActionPerformed(ActionEvent evt) {
        if (this.a >= 1) {
            this.a--;
            this.b--;
            this.c--;
            this.d--;
            this.FOTO_A.setIcon(getPreview(this.a));
            this.FOTO_B.setIcon(getPreview(this.b));
            this.FOTO_C.setIcon(getPreview(this.c));
            this.FOTO_D.setIcon(getPreview(this.d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FOTO_AMouseClicked(MouseEvent evt) {
        this.FOTO_GRANDE.setIcon(getFoto(this.a, this.FOTO_GRANDE.getSize()));
        JLabel jLabel = this.FOTO_GRANDE;
        JLabel jLabel2 = this.FOTO_GRANDE;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.FOTO_GRANDE;
        JLabel jLabel4 = this.FOTO_GRANDE;
        jLabel3.setVerticalAlignment(0);
        if (fotos.size() > 0 && this.a < fotos.size()) {
            mLlenarInformacion(fotos.get(this.a).getDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FOTO_BMouseClicked(MouseEvent evt) {
        this.FOTO_GRANDE.setIcon(getFoto(this.b, this.FOTO_GRANDE.getSize()));
        JLabel jLabel = this.FOTO_GRANDE;
        JLabel jLabel2 = this.FOTO_GRANDE;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.FOTO_GRANDE;
        JLabel jLabel4 = this.FOTO_GRANDE;
        jLabel3.setVerticalAlignment(0);
        if (fotos.size() > 0 && this.b < fotos.size()) {
            mLlenarInformacion(fotos.get(this.b).getDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FOTO_CMouseClicked(MouseEvent evt) {
        this.FOTO_GRANDE.setIcon(getFoto(this.c, this.FOTO_GRANDE.getSize()));
        JLabel jLabel = this.FOTO_GRANDE;
        JLabel jLabel2 = this.FOTO_GRANDE;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.FOTO_GRANDE;
        JLabel jLabel4 = this.FOTO_GRANDE;
        jLabel3.setVerticalAlignment(0);
        if (fotos.size() > 0 && this.c < fotos.size()) {
            mLlenarInformacion(fotos.get(this.c).getDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FOTO_DMouseClicked(MouseEvent evt) {
        this.FOTO_GRANDE.setIcon(getFoto(this.d, this.FOTO_GRANDE.getSize()));
        JLabel jLabel = this.FOTO_GRANDE;
        JLabel jLabel2 = this.FOTO_GRANDE;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.FOTO_GRANDE;
        JLabel jLabel4 = this.FOTO_GRANDE;
        jLabel3.setVerticalAlignment(0);
        if (fotos.size() > 0 && this.d < fotos.size()) {
            mLlenarInformacion(fotos.get(this.d).getDescription());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CMD_NEXTActionPerformed(ActionEvent evt) {
        if (this.d < fotos.size() - 1) {
            this.a++;
            this.b++;
            this.c++;
            this.d++;
            this.FOTO_A.setIcon(getPreview(this.a));
            this.FOTO_B.setIcon(getPreview(this.b));
            this.FOTO_C.setIcon(getPreview(this.c));
            this.FOTO_D.setIcon(getPreview(this.d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCapturaActionPerformed(ActionEvent evt) {
        this.pnlCamara.CapturaFoto();
        mCaptura("Foto.jpg");
        this.JTFRuta.setText("");
        this.JTBCamara.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoPropertyChange(PropertyChangeEvent evt) {
        mCargarGaleria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mSalir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            mMarcarSeleccion(true);
        } else {
            mMarcarSeleccion(false);
        }
        mCargarGaleria();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSAnoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSAnoStateChanged(ChangeEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBClasificacion1ItemStateChanged(ItemEvent evt) {
        if (this.JCHClasificar.isSelected() && this.JCBClasificacion1.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHClasificarActionPerformed(ActionEvent evt) {
        if (this.JCHClasificar.isSelected()) {
            this.JCBClasificacion1.setEnabled(true);
            this.JCBClasificacion1.removeAllItems();
            List<GCGenericoDTO> list2 = this.xAtencionImagenesDAO.listClasificacionFiltrado(String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()), String.valueOf(this.JSAno.getValue()), this.xfiltro);
            this.xidClasificacion1 = new String[list2.size()];
            for (int x = 0; x < list2.size(); x++) {
                this.xidClasificacion1[x] = String.valueOf(list2.get(x).getId());
                this.JCBClasificacion1.addItem(list2.get(x).getNombre());
            }
            this.JCBClasificacion1.setSelectedIndex(-1);
            return;
        }
        this.JCBClasificacion1.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xfiltro = 0;
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnoActionPerformed(ActionEvent evt) {
        this.xfiltro = 1;
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\Genoma\\");
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & BMP", new String[]{"jpg", "png", "bmp"});
            xfilec.setFileFilter(filtroImagen);
            xfilec.setFileSelectionMode(0);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty() && this.JTFRuta.getText().contains(".")) {
            mCaptura(this.JTFRuta.getText());
        }
    }
}
