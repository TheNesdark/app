package com.genoma.plus.controller.laboratorio;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFImportacionResultadosExternos.class */
public class JIFImportacionResultadosExternos extends JInternalFrame {
    private Metodos xmt = new Metodos();
    File xfile;
    public DefaultTableModel xmodeloValidos;
    public DefaultTableModel xmodeloInvalidos;
    private Object[] xdato;
    private LaboratorioDAO xLaboratorioDAO;
    private JButton JBGrabar;
    private JPanel JPCargue;
    private JScrollPane JSPArchivosInvalidos;
    private JScrollPane JSPArchivosValidos;
    private JTable JTArchivosInvalidos;
    private JTable JTArchivosValidos;
    private JTextField JTFRuta;

    public JIFImportacionResultadosExternos() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xLaboratorioDAO = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void mNuevo() {
        mCrearModeloValidos();
        mCrearModeloInValidos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloValidos() {
        this.xmodeloValidos = new DefaultTableModel(new Object[0], new String[]{"Archivo", "Ruta", "IdRecepcion", "idProcedimientos"}) { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos.1
            Class[] types = {String.class, String.class, Long.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTArchivosValidos.setModel(this.xmodeloValidos);
        this.JTArchivosValidos.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTArchivosValidos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTArchivosValidos.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloInValidos() {
        this.xmodeloInvalidos = new DefaultTableModel(new Object[0], new String[]{"Archivo"}) { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos.2
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTArchivosInvalidos.setModel(this.xmodeloInvalidos);
        this.JTArchivosInvalidos.getColumnModel().getColumn(0).setPreferredWidth(300);
    }

    public void listarFicherosPorCarpeta(File carpeta) {
        mNuevo();
        int filaValidos = 0;
        int filaInvalidos = 0;
        for (File ficheroEntrada : carpeta.listFiles()) {
            if (ficheroEntrada.getName().endsWith(".pdf") && ficheroEntrada.getName().replace(".pdf", "").matches("^(([\\d-]+)([\\d])|,)*$")) {
                this.xmodeloValidos.addRow(this.xdato);
                this.xmodeloValidos.setValueAt(ficheroEntrada.getName(), filaValidos, 0);
                this.xmodeloValidos.setValueAt(ficheroEntrada.getAbsolutePath(), filaValidos, 1);
                this.xmodeloValidos.setValueAt(mRecortarTexto(ficheroEntrada.getName().replace(".pdf", ""), 0), filaValidos, 2);
                this.xmodeloValidos.setValueAt(mRecortarTexto(ficheroEntrada.getName().replace(".pdf", ""), 1), filaValidos, 3);
                filaValidos++;
            } else if (!ficheroEntrada.isDirectory()) {
                this.xmodeloInvalidos.addRow(this.xdato);
                this.xmodeloInvalidos.setValueAt(ficheroEntrada.getName(), filaInvalidos, 0);
                filaInvalidos++;
            }
        }
    }

    private String mRecortarTexto(String texto, int posicion) {
        String[] Subpart = texto.split("\\-");
        return Subpart[posicion];
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPCargue = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBGrabar = new JButton();
        this.JSPArchivosValidos = new JScrollPane();
        this.JTArchivosValidos = new JTable();
        this.JSPArchivosInvalidos = new JScrollPane();
        this.JTArchivosInvalidos = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPORTACION DE RESULTADOS EXTERNOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPCargue.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Carpeta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos.3
            public void mouseClicked(MouseEvent evt) {
                JIFImportacionResultadosExternos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos.4
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionResultadosExternos.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Subir Achivos");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionResultadosExternos.5
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionResultadosExternos.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPCargueLayout = new GroupLayout(this.JPCargue);
        this.JPCargue.setLayout(JPCargueLayout);
        JPCargueLayout.setHorizontalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 548, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 160, -2).addContainerGap()));
        JPCargueLayout.setVerticalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2)).addGap(10, 10, 10)));
        this.JSPArchivosValidos.setBorder(BorderFactory.createTitledBorder((Border) null, "ARCHIVOS VALIDOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTArchivosValidos.setFont(new Font("Arial", 1, 12));
        this.JTArchivosValidos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTArchivosValidos.setSelectionBackground(Color.white);
        this.JTArchivosValidos.setSelectionForeground(Color.red);
        this.JSPArchivosValidos.setViewportView(this.JTArchivosValidos);
        this.JSPArchivosInvalidos.setBorder(BorderFactory.createTitledBorder((Border) null, "ARCHIVOS INVALIDOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTArchivosInvalidos.setFont(new Font("Arial", 1, 12));
        this.JTArchivosInvalidos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTArchivosInvalidos.setSelectionBackground(Color.white);
        this.JTArchivosInvalidos.setSelectionForeground(Color.red);
        this.JSPArchivosInvalidos.setViewportView(this.JTArchivosInvalidos);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPCargue, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JSPArchivosValidos, -2, 366, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPArchivosInvalidos, -2, 366, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPCargue, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPArchivosInvalidos, -1, -1, -2).addComponent(this.JSPArchivosValidos, -1, -1, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            this.xfile = null;
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
                listarFicherosPorCarpeta(this.xfile);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        String rutaCarpeta = this.xmt.mRutaSoporte("JDCarguePDFResultadosExternos");
        if (!rutaCarpeta.isEmpty()) {
            if (this.JTArchivosValidos.getRowCount() > 0) {
                if (this.xmt.mExisteArchivo(rutaCarpeta)) {
                    File directorio = new File(rutaCarpeta);
                    for (int i = 0; i < this.JTArchivosValidos.getRowCount(); i++) {
                        String[] Subpart = this.JTArchivosValidos.getValueAt(i, 3).toString().split("\\,");
                        for (String str : Subpart) {
                            String adjunto = this.JTArchivosValidos.getValueAt(i, 2).toString() + "_" + this.JTArchivosValidos.getValueAt(i, 3).toString().replace(",", "_") + ".pdf";
                            File f1 = new File(this.JTArchivosValidos.getValueAt(i, 1).toString());
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            boolean semovio = f2.renameTo(new File(directorio, f2.getName()));
                            if (semovio) {
                                this.xLaboratorioDAO.cargarArchivosDeResultadosExternos(Long.valueOf(this.JTArchivosValidos.getValueAt(i, 2).toString()), Long.valueOf(str), adjunto);
                            }
                        }
                        this.xmt.mEliminarArchivo(new File(this.JTArchivosValidos.getValueAt(i, 1).toString()));
                    }
                    listarFicherosPorCarpeta(this.xfile);
                    return;
                }
                JOptionPane.showMessageDialog(this, "No se Encuentro la carpeta compartida: " + rutaCarpeta, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No hay registro de archivos validos por subir", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Funcion Deshabilitada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
