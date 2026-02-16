package General;

import Historia.JIFConsultarExamenesxUsuario;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:General/JDRxImagen.class */
public class JDRxImagen extends JDialog {
    private DefaultTableModel xmodelo;
    private Metodos xmt;
    private Object[] xdatos;
    private JButton JBT_Salir;
    private JScrollPane JSPHistorico;
    private JTable JTHistorico;

    public JDRxImagen(Frame parent, boolean modal, File[] files) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("RADIOLOGIAS");
        mCargarDatosTabla(files);
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBT_Salir = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setDefaultCloseOperation(2);
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: General.JDRxImagen.1
            public void actionPerformed(ActionEvent evt) {
                JDRxImagen.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: General.JDRxImagen.2
            public void mouseClicked(MouseEvent evt) {
                JDRxImagen.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Salir, -1, -1, 32767).addComponent(this.JSPHistorico, GroupLayout.Alignment.TRAILING, -1, 554, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 292, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Salir, -2, 50, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            try {
                Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.xmt.mTraerUrlBD(this.xmodelo.getValueAt(this.JTHistorico.getSelectedRow(), 1).toString()));
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarExamenesxUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: General.JDRxImagen.3
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setMaxWidth(0);
    }

    private void mCargarDatosTabla(File[] File) {
        String[] xencabezado = {"Nombre", "Ruta"};
        mCrearModeloDatos(xencabezado);
        for (int x = 0; x < File.length; x++) {
            if (File[x].getAbsoluteFile().toString().endsWith("Dicom")) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(File[x].getName(), x, 0);
                this.xmodelo.setValueAt(File[x].getAbsoluteFile(), x, 1);
            }
        }
    }
}
