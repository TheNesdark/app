package com.genoma.plus.controller.facturacion;

import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.IngresoDocumentoDAO;
import com.genoma.plus.dao.impl.facturacion.IngresoDocumentoDAOImpl;
import com.genoma.plus.dto.facturacion.IngresoDocumentoDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPIngresoDocumento.class */
public class JPIngresoDocumento extends JPanel {
    private File xfile;
    private File directorio;
    private String[] xid_documento;
    private int xestado = 1;
    private int xguardar = 0;
    private Metodos xmetodo = new Metodos();
    private DefaultTableModel xmodelo;
    private IngresoDocumentoDAO xIngresoDocumentoDAO;
    private Object[] xDato;
    private Long xId_Ingreso;
    public String ruta;
    public int doc;
    public boolean tablaLlena;
    private JComboBox JCBDocumento;
    private JCheckBox JCHEstado;
    private JPanel JPDatos;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    public JButton btnGrabar;
    private JScrollPane jScrollPane1;

    public JPIngresoDocumento(Long xId_Ingreso) {
        initComponents();
        this.xId_Ingreso = xId_Ingreso;
        springStart();
        this.ruta = "";
        this.doc = -1;
        this.tablaLlena = false;
        mNuevo();
    }

    private void springStart() {
        this.xIngresoDocumentoDAO = (IngresoDocumentoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ingresoDocumentoDAO");
    }

    public void mNuevo() {
        this.directorio = new File(this.xmetodo.mRutaSoporte("JPIngresoDocumento"));
        this.JCBDocumento.removeAllItems();
        List<GCGenericoDTO> list1 = this.xIngresoDocumentoDAO.mTipoDocumento();
        this.xid_documento = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xid_documento[x] = String.valueOf(list1.get(x).getId());
            this.JCBDocumento.addItem(list1.get(x).getNombre());
        }
        this.JCBDocumento.setSelectedIndex(-1);
        this.JTFRuta.setText((String) null);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.xguardar = 0;
        mBuscaDatos();
    }

    public void mGrabar() {
        try {
            if (this.xId_Ingreso.longValue() != 0) {
                if (this.JCBDocumento.getSelectedIndex() != -1) {
                    if (!this.JTFRuta.getText().isEmpty()) {
                        int n = JOptionPane.showOptionDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), (Object[]) null, (Object) null);
                        if (n == 0) {
                            IngresoDocumentoDTO e = new IngresoDocumentoDTO();
                            if (this.xguardar == 0) {
                                File directorio = new File(this.xmetodo.mRutaSoporte("JPIngresoDocumento"));
                                System.out.println("ingreso-> " + this.xId_Ingreso);
                                e.setIdIngreso(this.xId_Ingreso);
                                e.setIdTipoDoc(this.xid_documento[this.JCBDocumento.getSelectedIndex()]);
                                e.setEstado(this.xestado);
                                String xidDoc = this.xIngresoDocumentoDAO.create_return_id(e);
                                String adjunto = xidDoc + "_" + this.xId_Ingreso + "_" + this.JCBDocumento.getSelectedItem() + ".pdf";
                                e.setRuta(this.xmetodo.mTraerUrlBD(adjunto));
                                e.setId(Integer.valueOf(xidDoc).intValue());
                                this.xIngresoDocumentoDAO.mUpdateRuta(e);
                                File f1 = new File(this.JTFRuta.getText());
                                File f2 = new File(adjunto);
                                f1.renameTo(f2);
                                f2.renameTo(new File(directorio + this.xmetodo.getBarra(), f2.getName()));
                                System.err.println(directorio + this.xmetodo.getBarra() + f2.getName());
                                if (this.xmetodo.mExisteArchivo(directorio + f2.getName())) {
                                    e.setId(Integer.valueOf(xidDoc).intValue());
                                    this.xIngresoDocumentoDAO.mDelete(e);
                                    JOptionPane.showMessageDialog(this, "Se a generado un error al momento de cargar el archivo, favor volver a intentarlo ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                                } else {
                                    mNuevo();
                                }
                                this.xmetodo.getInterceptor(this.xId_Ingreso, "ALMACENA TIPO DOCUMENTO " + this.JCBDocumento.getSelectedItem(), "Se almacena documento escaneado como soporte", false);
                            } else {
                                e.setEstado(this.xestado);
                                e.setId(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue());
                                this.xIngresoDocumentoDAO.mUpdate(e);
                                mNuevo();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "La Ruta de guardado no puede estar vacia ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                        this.JTFRuta.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe cargar un Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    this.JCBDocumento.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe cargar un Ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            }
        } catch (Exception e2) {
            System.out.println(">>>>errorr<<<<");
            e2.printStackTrace();
        }
        if (this.JTDetalle.getRowCount() > 0) {
            this.tablaLlena = true;
        } else {
            this.tablaLlena = false;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Documento", "Archivo", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mCrearModeloDatos();
        List<IngresoDocumentoDTO> list = this.xIngresoDocumentoDAO.mListar(this.xId_Ingreso);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getIdTipoDoc(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getRuta(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JCBDocumento = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.btnGrabar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("xjpingresodocumento");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDocumento.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.2
            public void itemStateChanged(ItemEvent evt) {
                JPIngresoDocumento.this.JCBDocumentoItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.3
            public void mouseClicked(MouseEvent evt) {
                JPIngresoDocumento.this.JTFRutaMouseClicked(evt);
            }

            public void mouseExited(MouseEvent evt) {
                JPIngresoDocumento.this.JTFRutaMouseExited(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.4
            public void actionPerformed(ActionEvent evt) {
                JPIngresoDocumento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnGrabar.setText("Adicionar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.5
            public void actionPerformed(ActionEvent evt) {
                JPIngresoDocumento.this.btnGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDocumento, -2, 219, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 394, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnGrabar, -1, -1, 32767).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDocumento, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JCHEstado).addComponent(this.btnGrabar, -2, 50, -2)).addContainerGap(8, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JPIngresoDocumento.6
            public void mouseClicked(MouseEvent evt) {
                JPIngresoDocumento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1).addComponent(this.JPDatos, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 180, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmetodo.getDirectorioExportacion());
            FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", new String[]{"pdf"});
            xfilec.setFileFilter(filter);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBDocumento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFRuta.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
            this.xguardar = 1;
            if (evt.getClickCount() == 2) {
                String rutaa = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString();
                this.xmetodo.getFilePdfPath(this.directorio.getPath(), rutaa, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDocumentoItemStateChanged(ItemEvent evt) {
        this.doc = this.JCBDocumento.getSelectedIndex();
        System.out.println("documento ->" + this.doc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseExited(MouseEvent evt) {
        this.ruta = this.JTFRuta.getText();
        System.out.println("ruta -> " + this.ruta);
    }
}
