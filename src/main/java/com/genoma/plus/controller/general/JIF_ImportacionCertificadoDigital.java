package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.FirmaDigitalDTO;
import com.genoma.plus.jpa.service.IFirmaDigitalDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIF_ImportacionCertificadoDigital.class */
public class JIF_ImportacionCertificadoDigital extends JInternalFrame {
    private File rutaArchivo;
    private DefaultTableModel modeloDatos;
    private Long id;
    private JCheckBox JCH_Estado;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPI_DatosEncabezado;
    private JPanel JPI_Validez;
    private JPasswordField JPW_Contrasena;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos metodos = new Metodos();
    private final IFirmaDigitalDAO firmaDigitalDAO = (IFirmaDigitalDAO) Principal.contexto.getBean(IFirmaDigitalDAO.class);

    @Generated
    public void setRutaArchivo(File rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setModeloDatos(DefaultTableModel modeloDatos) {
        this.modeloDatos = modeloDatos;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setJCH_Estado(JCheckBox JCH_Estado) {
        this.JCH_Estado = JCH_Estado;
    }

    @Generated
    public void setJDFFechaF(JDateChooser JDFFechaF) {
        this.JDFFechaF = JDFFechaF;
    }

    @Generated
    public void setJDFFechaI(JDateChooser JDFFechaI) {
        this.JDFFechaI = JDFFechaI;
    }

    @Generated
    public void setJPI_DatosEncabezado(JPanel JPI_DatosEncabezado) {
        this.JPI_DatosEncabezado = JPI_DatosEncabezado;
    }

    @Generated
    public void setJPI_Validez(JPanel JPI_Validez) {
        this.JPI_Validez = JPI_Validez;
    }

    @Generated
    public void setJPW_Contrasena(JPasswordField JPW_Contrasena) {
        this.JPW_Contrasena = JPW_Contrasena;
    }

    @Generated
    public void setJSPDetalle(JScrollPane JSPDetalle) {
        this.JSPDetalle = JSPDetalle;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public File getRutaArchivo() {
        return this.rutaArchivo;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public DefaultTableModel getModeloDatos() {
        return this.modeloDatos;
    }

    @Generated
    public IFirmaDigitalDAO getFirmaDigitalDAO() {
        return this.firmaDigitalDAO;
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    public JIF_ImportacionCertificadoDigital() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_DatosEncabezado = new JPanel();
        this.JTFRuta = new JTextField();
        this.JPW_Contrasena = new JPasswordField();
        this.JPI_Validez = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JCH_Estado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPORTACIÓN DE CERTIFICADO DIGITAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_importar_cetificado");
        this.JPI_DatosEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo (Firma digital)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIF_ImportacionCertificadoDigital.1
            public void mouseClicked(MouseEvent evt) {
                JIF_ImportacionCertificadoDigital.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPW_Contrasena.setFont(new Font("Arial", 1, 12));
        this.JPW_Contrasena.setBorder(BorderFactory.createTitledBorder((Border) null, "Contraseña", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Validez.setBorder(BorderFactory.createTitledBorder((Border) null, "VALIDEZ", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_ValidezLayout = new GroupLayout(this.JPI_Validez);
        this.JPI_Validez.setLayout(JPI_ValidezLayout);
        JPI_ValidezLayout.setHorizontalGroup(JPI_ValidezLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ValidezLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 144, -2).addGap(18, 18, 18).addComponent(this.JDFFechaF, -2, 144, -2).addContainerGap(-1, 32767)));
        JPI_ValidezLayout.setVerticalGroup(JPI_ValidezLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ValidezLayout.createSequentialGroup().addGroup(JPI_ValidezLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addContainerGap(8, 32767)));
        this.JCH_Estado.setFont(new Font("Arial", 1, 12));
        this.JCH_Estado.setSelected(true);
        this.JCH_Estado.setText("Estado");
        GroupLayout JPI_DatosEncabezadoLayout = new GroupLayout(this.JPI_DatosEncabezado);
        this.JPI_DatosEncabezado.setLayout(JPI_DatosEncabezadoLayout);
        JPI_DatosEncabezadoLayout.setHorizontalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 321, -2).addGap(29, 29, 29).addComponent(this.JPW_Contrasena, -2, 176, -2)).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addComponent(this.JPI_Validez, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Estado))).addContainerGap(-1, 32767)));
        JPI_DatosEncabezadoLayout.setVerticalGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JPW_Contrasena, -2, 50, -2)).addGroup(JPI_DatosEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addGap(78, 78, 78).addComponent(this.JCH_Estado)).addGroup(JPI_DatosEncabezadoLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Validez, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(2);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIF_ImportacionCertificadoDigital.2
            public void mouseClicked(MouseEvent evt) {
                JIF_ImportacionCertificadoDigital.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_DatosEncabezado, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatosEncabezado, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JSPDetalle, -1, 203, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("Pfx &  P12", new String[]{"pfx", "p12"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                setRutaArchivo(xfilec.getSelectedFile());
                System.out.println(getRutaArchivo().getAbsolutePath());
                this.JTFRuta.setText(getRutaArchivo().getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getSelectedRow() != -1) {
            setId(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
        }
    }

    public void nuevo() {
        setId(null);
        this.JTFRuta.setText("");
        this.JPW_Contrasena.setText("");
        this.JDFFechaI.setDate(getMetodos().getFechaActual());
        this.JDFFechaF.setDate(getMetodos().getFechaActual());
        this.JCH_Estado.setSelected(true);
        cargarDetalle();
    }

    public void crearTablaDetalle() {
        this.modeloDatos = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Certificado", "Contrasena", "Fecha Inicio", "Fecha Fin", "Estado"}) { // from class: com.genoma.plus.controller.general.JIF_ImportacionCertificadoDigital.3
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modeloDatos);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    private void cargarDetalle() {
        crearTablaDetalle();
        List<FirmaDigitalDTO> listFirma = getFirmaDigitalDAO().listadoFirmaDigitalSinFiltro();
        if (listFirma.size() > 0) {
            for (FirmaDigitalDTO i : listFirma) {
                Object[] fila = {i.getId(), i.getCetificado(), i.getContrasena(), i.getFechaInicio(), i.getFechaFin(), i.getEstado()};
                getModeloDatos().addRow(fila);
            }
        }
    }

    public void grabar() {
        if (getRutaArchivo() != null) {
            if (this.JPW_Contrasena.isValid() && this.JPW_Contrasena.getPassword().length > 1) {
                try {
                    byte[] fileContent = Files.readAllBytes(getRutaArchivo().toPath());
                    FirmaDigitalDTO e = FirmaDigitalDTO.builder().cetificado(Base64.getEncoder().encodeToString(fileContent)).contrasena(Base64.getEncoder().encodeToString(new String(this.JPW_Contrasena.getPassword()).getBytes())).fechaInicio(this.JDFFechaI.getDate()).fechaFin(this.JDFFechaF.getDate()).estado(Boolean.valueOf(this.JCH_Estado.isSelected())).id(this.id).fecha(this.metodos.getFechaActualLocalTime()).build();
                    getFirmaDigitalDAO().grabar(e);
                    cargarDetalle();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIF_ImportacionCertificadoDigital.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Contrasena no valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JPW_Contrasena.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe archivo valido selecccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    @Generated
    public JCheckBox getJCH_Estado() {
        return this.JCH_Estado;
    }

    @Generated
    public JDateChooser getJDFFechaF() {
        return this.JDFFechaF;
    }

    @Generated
    public JDateChooser getJDFFechaI() {
        return this.JDFFechaI;
    }

    @Generated
    public JPanel getJPI_DatosEncabezado() {
        return this.JPI_DatosEncabezado;
    }

    @Generated
    public JPanel getJPI_Validez() {
        return this.JPI_Validez;
    }

    @Generated
    public JPasswordField getJPW_Contrasena() {
        return this.JPW_Contrasena;
    }

    @Generated
    public JScrollPane getJSPDetalle() {
        return this.JSPDetalle;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }
}
