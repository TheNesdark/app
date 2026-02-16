package com.genoma.plus.controller.laboratorio;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
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
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDCarguePDFResultadosExternos.class */
public class JDCarguePDFResultadosExternos extends JDialog {
    private Metodos xmt;
    File xfile;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private LaboratorioDAO xLaboratorioDAO;
    private String idRecepcion;
    private JButton JBGrabar;
    private JButton JBNuevo;
    private JButton JBSalir;
    private JPanel JPCargue;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;

    public JDCarguePDFResultadosExternos(Frame parent, boolean modal, String idRecepcion) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        setTitle("IMPORTAR RESULTADOS EXTERNOS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idRecepcion = idRecepcion;
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xLaboratorioDAO = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void mNuevo() {
        this.JTFRuta.setText("");
        mCargadatos();
    }

    public void mCargadatos() {
        mCrearModeloTabla();
        List<Object[]> ListaConsultas = this.xLaboratorioDAO.listaProcedimientosRecepcion(this.idRecepcion);
        for (int x = 0; x < ListaConsultas.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
            for (int j = 0; j < 4; j++) {
                this.xmodelo.setValueAt(ListaConsultas.get(x)[j], x, j);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"CUP", "Procedimiento", "Seleccionar", "Remision"}) { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.1
            Class[] types = {String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPCargue = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBGrabar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBNuevo = new JButton();
        this.JBSalir = new JButton();
        setDefaultCloseOperation(2);
        this.JPCargue.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.2
            public void mouseClicked(MouseEvent evt) {
                JDCarguePDFResultadosExternos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.3
            public void actionPerformed(ActionEvent evt) {
                JDCarguePDFResultadosExternos.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Subir Achivos");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.4
            public void actionPerformed(ActionEvent evt) {
                JDCarguePDFResultadosExternos.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPCargueLayout = new GroupLayout(this.JPCargue);
        this.JPCargue.setLayout(JPCargueLayout);
        JPCargueLayout.setHorizontalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 548, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 160, -2).addContainerGap()));
        JPCargueLayout.setVerticalGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCargueLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPCargueLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBNuevo.setFont(new Font("Arial", 1, 12));
        this.JBNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBNuevo.setText("Nuevo");
        this.JBNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.5
            public void actionPerformed(ActionEvent evt) {
                JDCarguePDFResultadosExternos.this.JBNuevoActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos.6
            public void actionPerformed(ActionEvent evt) {
                JDCarguePDFResultadosExternos.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPCargue, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBNuevo, -2, 367, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -1, -1, 32767))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPCargue, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBSalir, -1, 50, 32767).addComponent(this.JBNuevo, -1, 50, 32767)).addContainerGap(20, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
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
        String rutaCarpeta = this.xmt.mRutaSoporte("JDCarguePDFResultadosExternos");
        if (!rutaCarpeta.isEmpty()) {
            if (this.JTFRuta.getText().endsWith(".pdf")) {
                if (this.JTDetalle.getRowCount() > 0) {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 2)) {
                        if (this.xmt.mExisteArchivo(rutaCarpeta)) {
                            String procedimientos = "";
                            File directorio = new File(rutaCarpeta);
                            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 2).toString()).booleanValue()) {
                                    procedimientos = procedimientos + this.JTDetalle.getValueAt(i, 0).toString() + "_";
                                }
                            }
                            String adjunto = this.idRecepcion + "_" + procedimientos.substring(0, procedimientos.length() - 1) + ".pdf";
                            File f1 = new File(this.JTFRuta.getText());
                            File f2 = new File(adjunto);
                            f1.renameTo(f2);
                            boolean semovio = f2.renameTo(new File(directorio, f2.getName()));
                            if (semovio) {
                                for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                    if (Boolean.valueOf(this.JTDetalle.getValueAt(i2, 2).toString()).booleanValue()) {
                                        this.xLaboratorioDAO.cargarArchivosDeResultadosExternos(Long.valueOf(this.idRecepcion), Long.valueOf(this.JTDetalle.getValueAt(i2, 0).toString()), adjunto);
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Proceso finalizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/ok29x27.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "No se Encuentro la carpeta compartida: " + rutaCarpeta, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "No hay registros en la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Archivo no valido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Funcion Deshabilitada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
