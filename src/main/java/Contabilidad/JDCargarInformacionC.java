package Contabilidad;

import Utilidades.ConsultasMySQL;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JDCargarInformacionC.class */
public class JDCargarInformacionC extends JDialog {
    private File xfile;
    private ConsultasMySQL xconsultas;
    private JIFDocContable xjifdocontable;
    private String xobjetollamador;
    private Object[] xdato;
    private JButton JBTCerrar;
    private JButton JBTImportar;
    private JPanel JPIDatos;
    private JTextField JTFRuta;

    public JDCargarInformacionC(Frame parent, boolean modal, JIFDocContable xjif) {
        super(parent, modal);
        this.xconsultas = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjifdocontable = xjif;
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTImportar = new JButton();
        this.JBTCerrar = new JButton();
        setDefaultCloseOperation(2);
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE ARCHIVO A CARGAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JDCargarInformacionC.1
            public void mouseClicked(MouseEvent evt) {
                JDCargarInformacionC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTImportar.setFont(new Font("Arial", 1, 14));
        this.JBTImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTImportar.setText("Importar");
        this.JBTImportar.addActionListener(new ActionListener() { // from class: Contabilidad.JDCargarInformacionC.2
            public void actionPerformed(ActionEvent evt) {
                JDCargarInformacionC.this.JBTImportarActionPerformed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 14));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Contabilidad.JDCargarInformacionC.3
            public void actionPerformed(ActionEvent evt) {
                JDCargarInformacionC.this.JBTCerrarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 426, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JBTImportar, -2, 210, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 210, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTImportar, -2, 39, -2).addComponent(this.JBTCerrar, -2, 39, -2)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLS", new String[]{"xls"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            mImportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifsolicitudreembolso1")) {
            this.xjifdocontable = (JIFDocContable) frm;
            this.xobjetollamador = "jifsolicitudreembolso1";
        }
    }

    private void mImportar() {
        try {
            String archivo = this.JTFRuta.getText();
            Workbook workbook = Workbook.getWorkbook(new File(archivo));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            this.xconsultas.ejecutarSQL("delete from cc_tmp");
            this.xconsultas.cerrarConexionBd();
            if (rows > 2) {
                for (int x = 2; x < rows; x++) {
                    this.xjifdocontable.xmodelo.addRow(this.xdato);
                    this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(sheet.getCell(1, x).getContents()), x - 2, 0);
                    this.xjifdocontable.xmodelo.setValueAt(this.xconsultas.traerDato("SELECT Nbre  FROM cc_puc WHERE (Id ='" + sheet.getCell(1, x).getContents() + "')"), x - 2, 1);
                    this.xconsultas.cerrarConexionBd();
                    this.xjifdocontable.xmodelo.setValueAt(Long.valueOf(sheet.getCell(2, x).getContents()), x - 2, 2);
                    if (sheet.getCell(2, x).getContents().toString().equals("0")) {
                        if (this.xjifdocontable.xmodelo.getValueAt(x - 2, 1).equals("")) {
                            this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 3);
                            this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 4);
                        } else {
                            this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(sheet.getCell(3, x).getContents().toString().replaceAll(",", ".")), x - 2, 3);
                            this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 4);
                        }
                    } else if (this.xjifdocontable.xmodelo.getValueAt(x - 2, 1).equals("")) {
                        this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 3);
                        this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 4);
                    } else {
                        this.xjifdocontable.xmodelo.setValueAt(new Double(0.0d), x - 2, 3);
                        this.xjifdocontable.xmodelo.setValueAt(Double.valueOf(sheet.getCell(3, x).getContents().toString().replaceAll(",", ".")), x - 2, 4);
                    }
                    String sql = "SELECT `Id` , `RazonSocialCompleta`  FROM cc_terceros WHERE (TDCompleto2 ='" + sheet.getCell(0, x).getContents().trim() + "' or No_identificacion='" + sheet.getCell(0, x).getContents().trim() + "' )";
                    ResultSet rs = this.xconsultas.traerRs(sql);
                    if (rs.next()) {
                        rs.first();
                        this.xjifdocontable.xmodelo.setValueAt(rs.getString(1), x - 2, 6);
                        this.xjifdocontable.xmodelo.setValueAt(rs.getString(2), x - 2, 7);
                    } else {
                        this.xjifdocontable.xmodelo.setValueAt("", x - 2, 6);
                        this.xjifdocontable.xmodelo.setValueAt("", x - 2, 7);
                    }
                    rs.close();
                    this.xconsultas.cerrarConexionBd();
                    this.xjifdocontable.xmodelo.setValueAt(new Long(0L), x - 2, 8);
                    this.xjifdocontable.xmodelo.setValueAt(sheet.getCell(4, x).getContents().toString(), x - 2, 9);
                    this.xjifdocontable.xmodelo.setValueAt(new Long(0L), x - 2, 10);
                    this.xjifdocontable.xmodelo.setValueAt(new Long(0L), x - 2, 11);
                    this.xjifdocontable.xmodelo.setValueAt(sheet.getCell(5, x).getContents().toString(), x - 2, 12);
                    this.xjifdocontable.xmodelo.setValueAt(0, x - 2, 13);
                    this.xjifdocontable.xmodelo.setValueAt(0, x - 2, 5);
                    this.xjifdocontable.xmodelo.setValueAt(false, x - 2, 14);
                    if (x % 500 == 0) {
                        Thread.sleep(1000L);
                    }
                }
                this.xjifdocontable.mSumarValores();
            } else {
                JOptionPane.showMessageDialog(this, "El Documento No Cumple Los Requerimientos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            workbook.close();
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        } catch (BiffException ex2) {
            ex2.printStackTrace();
        } catch (IOException ex3) {
            ex3.printStackTrace();
        } catch (InterruptedException ex4) {
            ex4.printStackTrace();
        } catch (SQLException ex5) {
            ex5.printStackTrace();
        }
    }
}
