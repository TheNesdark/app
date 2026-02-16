package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import General.ImportFile_xlsx;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.repository.IGpersonaRepository;
import com.genoma.plus.jpa.service.IGPersonaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFImportacionCorreosPorUsuarios.class */
public class JIFImportacionCorreosPorUsuarios extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private final IGPersonaService iGPersonaService;
    private IGpersonaRepository iGpersonaRepository;
    private final GPersona Gpersona;
    private List<GPersona> listaGpersona;
    private File xfile;
    private ImportFile_xlsx modelKLJ;
    private JButton JBActualizar;
    private ButtonGroup JBGOpciones;
    private JButton JBTImportar;
    private JPanel JPIDatos;
    public JTable JTDetalle;
    private JScrollPane jScrollPane2;
    private boolean xestado = false;
    private JFileChooser FileChooser = new JFileChooser();
    private Vector columna = new Vector();
    private Vector filas = new Vector();

    public JIFImportacionCorreosPorUsuarios() {
        initComponents();
        this.iGPersonaService = (IGPersonaService) Principal.contexto.getBean(IGPersonaService.class);
        this.iGpersonaRepository = (IGpersonaRepository) Principal.contexto.getBean(IGpersonaRepository.class);
        this.Gpersona = new GPersona();
        this.listaGpersona = new ArrayList();
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JBTImportar = new JButton();
        this.JBActualizar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPORTAR CORREOS POR USUARIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifimportarcorreos");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION A IMPORTAR", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatos.setToolTipText("");
        this.JBTImportar.setFont(new Font("Arial", 1, 14));
        this.JBTImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTImportar.setText("Importar Archivo Excel");
        this.JBTImportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionCorreosPorUsuarios.1
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCorreosPorUsuarios.this.JBTImportarActionPerformed(evt);
            }
        });
        this.JBActualizar.setFont(new Font("Arial", 1, 12));
        this.JBActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBActualizar.setText("Actualizar");
        this.JBActualizar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionCorreosPorUsuarios.2
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionCorreosPorUsuarios.this.JBActualizarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(96, 96, 96).addComponent(this.JBTImportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBActualizar, -2, 208, -2).addGap(62, 62, 62)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTImportar, -1, 60, 32767).addComponent(this.JBActualizar, -2, 59, -2)).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFImportacionCorreosPorUsuarios.3
            public void mouseClicked(MouseEvent evt) {
                JIFImportacionCorreosPorUsuarios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 698, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 287, -2).addContainerGap(-1, 32767)));
        this.JPIDatos.getAccessibleContext().setAccessibleName("DATOS ");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImportarActionPerformed(ActionEvent evt) {
        mImportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBActualizarActionPerformed(ActionEvent evt) {
        Actualizar();
    }

    private void LimpiarFormulario() {
        DefaultTableModel model = this.JTDetalle.getModel();
        model.setRowCount(0);
    }

    public void CrearTabla(File file) throws IOException {
        try {
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            this.columna.clear();
            for (int i = 0; i < sheet.getColumns(); i++) {
                Cell cell1 = sheet.getCell(i, 0);
                this.columna.add(cell1.getContents());
            }
            this.filas.clear();
            for (int j = 1; j < sheet.getRows(); j++) {
                Vector d = new Vector();
                for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                    Cell cell = sheet.getCell(i2, j);
                    if (i2 == 3) {
                        try {
                            d.add(Double.valueOf(cell.getContents().replaceAll(",", ".")));
                        } catch (NumberFormatException e) {
                            d.add("");
                        }
                    } else {
                        d.add(cell.getContents());
                    }
                }
                d.add("\n");
                this.xmodelo.addRow(d);
            }
        } catch (BiffException e2) {
            e2.printStackTrace();
        }
    }

    private void mImportar() {
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        File file = this.FileChooser.getSelectedFile();
        if (!file.getName().endsWith("xlsx")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel con la extensión 'xlsx'...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        try {
            this.modelKLJ = new ImportFile_xlsx();
            this.modelKLJ.Importar(file, this.JTDetalle);
            CrearTabla(file);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, "Error al importar el archivo: " + ex.getMessage(), "Error", 0);
        }
    }

    private void Actualizar() {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            try {
                if (this.JTDetalle.getValueAt(i, 13).toString().isEmpty() || this.JTDetalle.getValueAt(i, 13).toString() == null || this.JTDetalle.getValueAt(i, 13).toString().equals("")) {
                    JOptionPane.showInternalMessageDialog(this, "Hay un campo de correo en blanco, por favor verifique", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    break;
                }
                String noDocumento = this.JTDetalle.getValueAt(i, 1).toString();
                String correo = this.JTDetalle.getValueAt(i, 13).toString();
                System.out.println(i + ". noDocumento: " + noDocumento + " correo: " + correo);
                Optional<GPersona> personaOpt = this.iGPersonaService.datosPersonaPorNoDocumento(noDocumento);
                if (personaOpt.isPresent()) {
                    GPersona persona = personaOpt.get();
                    if (!persona.getCorreo().equals(correo)) {
                        persona.setCorreo(correo);
                        this.iGPersonaService.grabarGPersona(persona);
                        System.out.println("graba -> " + i);
                    }
                }
                if (i == this.JTDetalle.getRowCount() - 1) {
                    LimpiarFormulario();
                    JOptionPane.showMessageDialog(this, "Actualización completada correctamente.", "Actualización Exitosa", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFImportacionCorreosPorUsuarios$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 3).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }
}
