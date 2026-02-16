package GestionDoc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIFCopiaDocumentosG.class */
public class JIFCopiaDocumentosG extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidbodega;
    private String xsql;
    private File xfile;
    private File xfile1;
    private String xnombre;
    private ButtonGroup Filtros;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JRadioButton JCHCargar;
    private JCheckBox JCHRemitido;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBCargados;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTextField JTFRutaD;
    private JTextField JTFRutaO;
    private JButton jButton1;
    private JLabel jLabel1;

    public JIFCopiaDocumentosG(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.Filtros = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jButton1 = new JButton();
        this.JTFRutaO = new JTextField();
        this.JTFRutaD = new JTextField();
        this.JCHRemitido = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCHCargar = new JRadioButton();
        this.JRBCargados = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TRANSFERENCIA DE DOCUMENTOS HC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("xjiftranferenciadoc");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: GestionDoc.JIFCopiaDocumentosG.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFCopiaDocumentosG.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton1.setText("Actualizar");
        this.jButton1.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCopiaDocumentosG.2
            public void actionPerformed(ActionEvent evt) {
                JIFCopiaDocumentosG.this.jButton1ActionPerformed(evt);
            }
        });
        this.JTFRutaO.setFont(new Font("Arial", 1, 12));
        this.JTFRutaO.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio Origen)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaO.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCopiaDocumentosG.3
            public void mouseClicked(MouseEvent evt) {
                JIFCopiaDocumentosG.this.JTFRutaOMouseClicked(evt);
            }
        });
        this.JTFRutaD.setFont(new Font("Arial", 1, 12));
        this.JTFRutaD.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio Destino)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaD.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCopiaDocumentosG.4
            public void mouseClicked(MouseEvent evt) {
                JIFCopiaDocumentosG.this.JTFRutaDMouseClicked(evt);
            }
        });
        this.JCHRemitido.setFont(new Font("Arial", 1, 12));
        this.JCHRemitido.setText("Remitido");
        this.JCHRemitido.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCopiaDocumentosG.5
            public void actionPerformed(ActionEvent evt) {
                JIFCopiaDocumentosG.this.JCHRemitidoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRutaO, -2, 230, -2).addGap(10, 10, 10).addComponent(this.JTFRutaD, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHRemitido).addGap(18, 18, 18).addComponent(this.jButton1, -2, 132, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRutaD, -1, 49, 32767).addComponent(this.JCHRemitido)).addComponent(this.JTFRutaO)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -1, 54, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addGap(0, 0, 32767))).addGap(0, 0, 32767))).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCopiaDocumentosG.6
            public void mouseClicked(MouseEvent evt) {
                JIFCopiaDocumentosG.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.Filtros.add(this.JCHCargar);
        this.JCHCargar.setFont(new Font("Arial", 1, 12));
        this.JCHCargar.setSelected(true);
        this.JCHCargar.setText("Resultados x Cargar");
        this.JCHCargar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCopiaDocumentosG.7
            public void actionPerformed(ActionEvent evt) {
                JIFCopiaDocumentosG.this.JCHCargarActionPerformed(evt);
            }
        });
        this.Filtros.add(this.JRBCargados);
        this.JRBCargados.setFont(new Font("Arial", 1, 12));
        this.JRBCargados.setText("Resultados Cargados");
        this.Filtros.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.jLabel1.setFont(new Font("Arial", 1, 18));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("0");
        this.jLabel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: GestionDoc.JIFCopiaDocumentosG.8
            public void mouseClicked(MouseEvent evt) {
                JIFCopiaDocumentosG.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.setToolTipText("Exportar Información");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: GestionDoc.JIFCopiaDocumentosG.9
            public void actionPerformed(ActionEvent evt) {
                JIFCopiaDocumentosG.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHCargar).addGap(18, 18, 18).addComponent(this.JRBCargados).addGap(10, 10, 10).addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 340, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 106, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel1, -2, 128, -2).addGap(0, 0, 32767)).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 416, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCargar).addComponent(this.JRBCargados).addComponent(this.JRBTodos).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel1)))).addContainerGap(24, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (!this.JTFRutaO.getText().isEmpty()) {
            mActualizarDatosTabla();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ruta de origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRutaO.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaOMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRutaO.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaDMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\GestionDocumental\\Laboratorio\\Especializados\\" + this.xmt.formatoANO.format(this.JDFechaI.getDate()));
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile1 = xfilec.getSelectedFile();
                this.JTFRutaD.setText(this.xfile1.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 5) {
            int x = JOptionPane.showInternalConfirmDialog(this, "desea visualizar el archivo?", "VISUALIZAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mostrarPdf(this.JTFRutaO.getText() + "\\" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRemitidoActionPerformed(ActionEvent evt) {
        try {
            if (this.JCHRemitido.isSelected()) {
                String sql = "SELECT `f_ordenes`.`FechaOrden` , `persona`.`NoDocumento`, `persona`.`NUsuario`, `g_procedimiento`.`Nbre` AS procedimiento FROM `f_itemordenesproced` INNER JOIN `baseserver`.`g_procedimiento` ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`)INNER JOIN `f_ordenes` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN `baseserver`.`ingreso` ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)INNER JOIN `baseserver`.`persona` ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`) WHERE (`f_ordenes`.`FechaOrden` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'AND `f_ordenes`.`FechaOrden` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `f_ordenes`.`EstadoRecep` =2 AND `g_procedimiento`.`EsRemitido` =0 AND f_ordenes.`Estado`=0) ORDER BY `f_ordenes`.`FechaOrden` DESC, `persona`.`NUsuario` ASC, `g_procedimiento`.`Nbre` ASC";
                mCrearModeloDatos();
                ResultSet xrs = this.xconsulta.traerRs(sql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                        this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                        this.xmodelo.setValueAt(false, n, 4);
                        this.xmodelo.setValueAt("", n, 5);
                        this.xmodelo.setValueAt(0, n, 6);
                        this.xmodelo.setValueAt(0, n, 7);
                        this.xmodelo.setValueAt(false, n, 8);
                        n++;
                    }
                }
                xrs.close();
                this.xconsulta.cerrarConexionBd();
            } else {
                mCrearModeloDatos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFCopiaDocumentosG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCargarActionPerformed(ActionEvent evt) {
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
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    public void mBuscar() {
        mCargarDatosTabla();
    }

    private void mCopiar() {
        try {
            String[] ficheros = this.xfile.list();
            File archivo = null;
            for (int x = 0; x <= ficheros.length - 1; x++) {
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (this.xmodelo.getValueAt(y, 5).toString().equals(archivo.getName())) {
                        String cad = ficheros[x];
                        archivo = new File(this.xfile.getAbsolutePath() + "\\" + cad.substring(0, cad.length()));
                        File archivoEntrada = new File(this.JTFRutaO.getText() + "\\" + archivo.getName());
                        File archivoSalida = new File(this.JTFRutaD.getText() + "\\" + archivo.getName());
                        mCopiarArchivos(archivoEntrada, archivoSalida);
                        if (archivoEntrada.delete()) {
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(JIFCopiaDocumentosG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarDatosTabla() {
        String[] ficheros = this.xfile.list();
        if (ficheros != null) {
            for (int x = 0; x <= ficheros.length - 1; x++) {
                String cad = ficheros[x];
                File archivo = new File(this.xfile.getAbsolutePath() + "\\" + cad.substring(0, cad.length()));
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (this.xmodelo.getValueAt(y, 6).toString().equals(cad.substring(0, cad.length() - 4))) {
                        this.xmodelo.setValueAt(archivo.getName(), y, 5);
                        this.xmodelo.setValueAt(true, y, 8);
                    }
                }
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "Id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "h_so_relacion_examenes", parametros);
            this.xconsulta.cerrarConexionBd();
        }
    }

    public void mGrabar() {
        if (this.JCHCargar.isSelected()) {
            if (!this.JTFRutaO.getText().isEmpty()) {
                if (!this.JTFRutaD.getText().isEmpty()) {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 8)) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 8).toString()).booleanValue()) {
                                    this.xsql = "update l_detallerecepcion set NArchivo = '" + this.xmt.mTraerUrlBD(this.JTFRutaD.getText() + "\\" + this.xmodelo.getValueAt(y, 5).toString()) + "', FechaResultado='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',Resultado=1 , ValidadoLab=1 where Id_Recepcion ='" + this.xmodelo.getValueAt(y, 6).toString() + "' and Id_Procedim='" + this.xmodelo.getValueAt(y, 7).toString() + "'";
                                    this.xconsulta.ejecutarSQL(this.xsql);
                                    this.xconsulta.cerrarConexionBd();
                                }
                            }
                            mCopiar();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "No existen registros seleccionados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Ruta de destino no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFRutaD.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Ruta de origen no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRutaO.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar Resultados x Cargar en el Filtro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCHCargar.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "No. Documento", "Usuario", "Procedimiento", "Resultado?", "Ruta Archivo", "N° Recepción", "IdProcedimiento", "Cargar", "Tiempo estimado entrega", "Fecha Probable entrega", "Dias restantes", "Fecha cargue resultado"}) { // from class: GestionDoc.JIFCopiaDocumentosG.10
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class, Long.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, true, false, false, false, true, true, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(65);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(230);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(95);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(95);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(95);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(95);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(95);
    }

    private void mCargarDatosTabla() {
        try {
            if (this.JCHCargar.isSelected()) {
                this.xsql = "SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') AS Fecha, persona.NoDocumento, persona.NUsuario, g_procedimiento.Nbre, l_detallerecepcion.Resultado, l_detallerecepcion.NArchivo, l_recepcion.Id, l_detallerecepcion.Id_Procedim, g_procedimiento.`NDiasR` AS DiasEstimadosResultado, DATE_FORMAT(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),'%d-%m%-%Y') AS FecProbableEntr,\nCASE WHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())<=0 THEN\n\t0\nWHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())>0 THEN\n\tDATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())\nWHEN l_detallerecepcion.Resultado=1 THEN \n\t0\nEND DiasRestantes,\nl_detallerecepcion.`FechaResultado` AS FechaCargue FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (l_detallerecepcion.Resultado =0 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.Estado =0 AND g_procedimiento.EsRemitido=1) ORDER BY l_recepcion.FechaRecep ASC, persona.NUsuario ASC, g_procedimiento.Nbre ASC ";
            } else if (this.JRBCargados.isSelected()) {
                this.xsql = "SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') AS Fecha, persona.NoDocumento, persona.NUsuario, g_procedimiento.Nbre, l_detallerecepcion.Resultado, l_detallerecepcion.NArchivo, l_recepcion.Id, l_detallerecepcion.Id_Procedim, g_procedimiento.`NDiasR` AS DiasEstimadosResultado, DATE_FORMAT(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),'%d-%m%-%Y') AS FecProbableEntr,\nCASE WHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())<=0 THEN\n\t0\nWHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())>0 THEN\n\tDATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())\nWHEN l_detallerecepcion.Resultado=1 THEN \n\t0\nEND DiasRestantes,\nl_detallerecepcion.`FechaResultado` AS FechaCargue FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (l_detallerecepcion.Resultado =1 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.Estado =0 AND g_procedimiento.EsRemitido=1) ORDER BY DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') ASC, persona.NUsuario ASC, g_procedimiento.Nbre ASC ";
            } else {
                this.xsql = "SELECT DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') AS Fecha, persona.NoDocumento, persona.NUsuario, g_procedimiento.Nbre, l_detallerecepcion.Resultado, l_detallerecepcion.NArchivo, l_recepcion.Id, l_detallerecepcion.Id_Procedim, g_procedimiento.`NDiasR` AS DiasEstimadosResultado, DATE_FORMAT(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),'%d-%m%-%Y') AS FecProbableEntr,\nCASE WHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())<=0 THEN\n\t0\nWHEN DATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())>0 THEN\n\tDATEDIFF(DATE_ADD(l_recepcion.FechaRecep, INTERVAL g_procedimiento.`NDiasR` DAY),NOW())\nWHEN l_detallerecepcion.Resultado=1 THEN \n\t0\nEND DiasRestantes,\nl_detallerecepcion.`FechaResultado` AS FechaCargue FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) WHERE (DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.Estado =0 AND g_procedimiento.EsRemitido=1) ORDER BY DATE_FORMAT(l_recepcion.FechaRecep,'%d-%m-%Y') ASC, persona.NUsuario ASC, g_procedimiento.Nbre ASC ";
            }
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(this.xsql);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(false, n, 8);
                    this.xmodelo.setValueAt(xrs.getString("DiasEstimadosResultado"), n, 9);
                    this.xmodelo.setValueAt(xrs.getString("FecProbableEntr"), n, 10);
                    this.xmodelo.setValueAt(xrs.getString("DiasRestantes"), n, 11);
                    this.xmodelo.setValueAt(xrs.getString("FechaCargue"), n, 12);
                    n++;
                }
                this.jLabel1.setText("" + n);
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCopiaDocumentosG.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCopiarArchivos(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0L, source.size());
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
        } catch (Throwable th) {
            if (source != null) {
                source.close();
            }
            if (destination != null) {
                destination.close();
            }
            throw th;
        }
    }
}
