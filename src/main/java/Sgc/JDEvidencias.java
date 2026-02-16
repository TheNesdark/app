package Sgc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JDEvidencias.class */
public class JDEvidencias extends JDialog {
    private File xfile;
    private JInternalFrame xjif;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private JIFFicha5w1H xjifficha;
    private JDateChooser JDFecha;
    private JPanel JPIDatos;
    private JScrollPane JSPDescripcion;
    private JScrollPane JSPDetalle;
    private JTextPane JTADescripcion;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JButton jButton1;

    public JDEvidencias(Frame parent, boolean modal, JInternalFrame xjif) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        initComponents();
        this.xjif = xjif;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mRealizarCasting();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JSPDescripcion = new JScrollPane();
        this.JTADescripcion = new JTextPane();
        this.JTFRuta = new JTextField();
        this.jButton1 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setDefaultCloseOperation(2);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcion.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion.setViewportView(this.JTADescripcion);
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JDEvidencias.1
            public void mouseClicked(MouseEvent evt) {
                JDEvidencias.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("Grabar");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDescripcion, -2, 454, -2))).addGap(18, 18, 18).addComponent(this.jButton1, -1, -1, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, -2, -1, -2).addComponent(this.JSPDescripcion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.JTFRuta, -2, -1, -2)).addComponent(this.jButton1, -1, 109, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(Color.red);
        this.JTBDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -2, 745, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 272, -2).addContainerGap(12, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("S:\\GestionDocumental\\DocumentosHC");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Descripción", "Url"}) { // from class: Sgc.JDEvidencias.2
            Class[] types = {Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mNuevo() {
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JTADescripcion.setText("");
        this.JTFRuta.setText("");
        mCrearTabla();
    }

    private void mRealizarCasting() {
        if (this.xjif.getName().equals("xjifficha5w1h")) {
            this.xjifficha = (JIFFicha5w1H) this.xjif;
        }
    }
}
