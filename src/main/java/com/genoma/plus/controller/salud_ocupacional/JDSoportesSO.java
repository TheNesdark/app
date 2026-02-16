package com.genoma.plus.controller.salud_ocupacional;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.RevisionExamenSoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.RevisionExamenSoDAO;
import com.genoma.plus.dto.salud_ocupacional.RevisionExamenSoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JDSoportesSO.class */
public class JDSoportesSO extends JDialog {
    private Metodos xmt;
    File xfile;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private RevisionExamenSoDAO xRevisionExamenSoDAO;
    private String idRecepcion;
    private Long idOrdern;
    private Long idProcedimiento;
    private int fila;
    private JButton JBGrabar;
    private JButton JBSalir;
    private JButton JBTAdicionar;
    private JPanel JPCargue;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JDSoportesSO(Frame parent, boolean modal, Long idOrdern, Long idProcedimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.fila = 0;
        initComponents();
        setTitle("IMPORTAR RESULTADOS SALUD OCUPACIONAL");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idOrdern = idOrdern;
        this.idProcedimiento = idProcedimiento;
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRevisionExamenSoDAO = (RevisionExamenSoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("revisionExamenSoDAO");
    }

    private void mNuevo() {
        this.JTFRuta.setText("");
        mCrearModeloTabla();
    }

    public void mAdicionar() {
        if (this.xmt.mExisteArchivo(this.JTFRuta.getText())) {
            if (this.JTFRuta.getText().endsWith(".pdf")) {
                if (!this.xmt.mVerificarDatosDoblesTabla(this.JTDetalle, 0, this.JTFRuta.getText())) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(this.JTFRuta.getText(), this.fila, 0);
                    this.fila++;
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe la ruta de este archivo en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Archivo no valido, solo se admiten PDF", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ruta de archivo no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
        this.JTFRuta.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Soportes"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.1
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPCargue = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTAdicionar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBSalir = new JButton();
        this.JBGrabar = new JButton();
        setDefaultCloseOperation(2);
        this.JPCargue.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.2
            public void mouseClicked(MouseEvent evt) {
                JDSoportesSO.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.3
            public void actionPerformed(ActionEvent evt) {
                JDSoportesSO.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.4
            public void actionPerformed(ActionEvent evt) {
                JDSoportesSO.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPCargueLayout = new GroupLayout(this.JPCargue);
        this.JPCargue.setLayout(JPCargueLayout);
        JPCargueLayout.setHorizontalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 473, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 156, -2).addContainerGap()));
        JPCargueLayout.setVerticalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTAdicionar, -2, 50, -2)).addGap(15, 15, 15)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "SOPORTES", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.5
            public void mouseClicked(MouseEvent evt) {
                JDSoportesSO.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.6
            public void keyPressed(KeyEvent evt) {
                JDSoportesSO.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.7
            public void actionPerformed(ActionEvent evt) {
                JDSoportesSO.this.JBSalirActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JDSoportesSO.8
            public void actionPerformed(ActionEvent evt) {
                JDSoportesSO.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPCargue, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 328, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -1, -1, 32767))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPCargue, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBSalir, -1, -1, 32767).addComponent(this.JBGrabar, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.mRutaSoporte("JDSoportesSO"));
            xfilec.setFileFilter(new FileNameExtensionFilter("PDF", new String[]{"pdf"}));
            xfilec.setFileSelectionMode(0);
            int xv = xfilec.showOpenDialog(this);
            this.xfile = null;
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        byte[] fileContent;
        if (this.JTDetalle.getRowCount() != 0) {
            List<String> listaRutas = new ArrayList<>();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                listaRutas.add(this.xmodelo.getValueAt(i, 0).toString());
            }
            try {
                String archivoFucionado = this.xmt.unirPDF(listaRutas, this.xmt.getRutaRep(), "SO_Soporte");
                if (this.xmt.mExisteArchivo(archivoFucionado) && (fileContent = Files.readAllBytes(Paths.get(archivoFucionado, new String[0]))) != null) {
                    RevisionExamenSoDTO e = new RevisionExamenSoDTO();
                    e.setIdOrdenes(this.idOrdern);
                    e.setIdProcedimiento(this.idProcedimiento);
                    e.setSoporte(fileContent);
                    this.xRevisionExamenSoDAO.cargarArchivosDeResultados(e);
                    this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText()));
                    JOptionPane.showMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/ok29x27.png"))));
                    dispose();
                }
            } catch (IOException ex) {
                Logger.getLogger(JDSoportesSO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            this.fila--;
        }
    }
}
