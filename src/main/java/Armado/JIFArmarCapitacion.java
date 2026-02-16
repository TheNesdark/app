package Armado;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFArmarCapitacion.class */
public class JIFArmarCapitacion extends JInternalFrame {
    private String[] xidempresa;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xllenoc;
    private ButtonGroup JBGSeleccion;
    private JComboBox JCBEmpresa;
    private JComboBox JCBEmpresa1;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaFin1;
    public JDateChooser JDCFechaInicio;
    public JDateChooser JDCFechaInicio1;
    private JPanel JPIDatoP;
    private JPanel JPIDatoP1;
    private JInternalFrame jInternalFrame1;

    public JIFArmarCapitacion() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.jInternalFrame1 = new JInternalFrame();
        this.JPIDatoP1 = new JPanel();
        this.JDCFechaInicio1 = new JDateChooser();
        this.JDCFechaFin1 = new JDateChooser();
        this.JCBEmpresa1 = new JComboBox();
        setClosable(true);
        setTitle("ARMADO ORDENES DE SERVICIO - CAPITACIÓN GLOBAL");
        setFocusCycleRoot(false);
        setFocusable(false);
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifarmadocapitacion");
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addFocusListener(new FocusAdapter() { // from class: Armado.JIFArmarCapitacion.1
            public void focusLost(FocusEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicioFocusLost(evt);
            }
        });
        this.JDCFechaInicio.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmarCapitacion.2
            public void mouseClicked(MouseEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicioMouseClicked(evt);
            }
        });
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmarCapitacion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmarCapitacion.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmarCapitacion.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 547, -2).addContainerGap()));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2)).addComponent(this.JCBEmpresa, -2, 51, -2)).addContainerGap(36, 32767)));
        this.jInternalFrame1.setClosable(true);
        this.jInternalFrame1.setTitle("ARMADO ORDENES DE SERVICIO - CAPITACIÓN GLOBAL");
        this.jInternalFrame1.setFocusCycleRoot(false);
        this.jInternalFrame1.setFocusable(false);
        this.jInternalFrame1.setFont(new Font("Arial", 1, 14));
        this.jInternalFrame1.setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jInternalFrame1.setName("jifarmadocapitacion");
        this.jInternalFrame1.setRequestFocusEnabled(false);
        this.jInternalFrame1.setVerifyInputWhenFocusTarget(false);
        this.JPIDatoP1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JDCFechaInicio1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio1.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio1.addFocusListener(new FocusAdapter() { // from class: Armado.JIFArmarCapitacion.5
            public void focusLost(FocusEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicio1FocusLost(evt);
            }
        });
        this.JDCFechaInicio1.addMouseListener(new MouseAdapter() { // from class: Armado.JIFArmarCapitacion.6
            public void mouseClicked(MouseEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicio1MouseClicked(evt);
            }
        });
        this.JDCFechaInicio1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmarCapitacion.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmarCapitacion.this.JDCFechaInicio1PropertyChange(evt);
            }
        });
        this.JDCFechaFin1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin1.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin1.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin1.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFArmarCapitacion.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFArmarCapitacion.this.JDCFechaFin1PropertyChange(evt);
            }
        });
        this.JCBEmpresa1.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa1.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatoP1Layout = new GroupLayout(this.JPIDatoP1);
        this.JPIDatoP1.setLayout(JPIDatoP1Layout);
        JPIDatoP1Layout.setHorizontalGroup(JPIDatoP1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoP1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio1, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDCFechaFin1, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa1, -2, 547, -2).addContainerGap()));
        JPIDatoP1Layout.setVerticalGroup(JPIDatoP1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoP1Layout.createSequentialGroup().addGroup(JPIDatoP1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoP1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio1, -2, 61, -2).addComponent(this.JDCFechaFin1, -2, 61, -2)).addComponent(this.JCBEmpresa1, -2, 51, -2)).addContainerGap(36, 32767)));
        GroupLayout jInternalFrame1Layout = new GroupLayout(this.jInternalFrame1.getContentPane());
        this.jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jInternalFrame1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatoP1, -2, -1, -2).addGap(0, 0, 32767))));
        jInternalFrame1Layout.setVerticalGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(jInternalFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jInternalFrame1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatoP1, -2, -1, -2).addGap(0, 0, 32767))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 839, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatoP, -2, -1, -2).addGap(0, 0, 32767))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jInternalFrame1, -2, 0, -2).addGap(0, 0, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 145, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPIDatoP, -2, -1, -2).addGap(0, 0, 32767))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jInternalFrame1, -2, 0, -2).addGap(0, 0, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xllenoc) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicio1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicio1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicio1PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFin1PropertyChange(PropertyChangeEvent evt) {
    }

    public void mNuevo() {
        this.xllenoc = false;
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        this.xllenoc = true;
    }

    private void mLLenarCEmpresa() {
        this.JCBEmpresa.removeAllItems();
        String xsql = "SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM  f_factura_capita  INNER JOIN  f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN  ingreso  ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN  `f_empresacontxconvenio`  ON (f_empresacontxconvenio.`Id`= ingreso.`Id_EmpresaContxConv`) \nWHERE (f_factura_capita.Fecha_FacturaCapita>= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Estado =0 AND f_factura_capita.Estado=0 AND f_factura_capita.EstaArmada =0 AND f_empresacontxconvenio.`EsCapitado`=1) \nGROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC ";
        this.xidempresa = this.xct.llenarCombo(xsql, this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            mActualizarEstadoOrden();
            JOptionPane.showInternalMessageDialog(this, "Actualización de estado realizado!!!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mActualizarEstadoOrden() {
        String sql = "UPDATE    f_factura_capita,       (SELECT  f_factura_capita.No_FacturaCapita  FROM  f_factura_capita INNER JOIN  f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN  ingreso  ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN  g_usuario  ON (g_usuario.Id_persona  = ingreso.Id_Usuario)    WHERE (ingreso.Id_EmpresaContxConv='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'  AND f_factura_capita.Fecha_FacturaCapita>= '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "'AND f_factura_capita.Fecha_FacturaCapita <= '" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "' AND f_liquidacion.Estado =0 and f_factura_capita.Estado=0 AND f_factura_capita.EstaArmada =0)  ORDER BY f_factura_capita.Fecha_FacturaCapita ASC ) cb SET f_factura_capita.`EstaArmada`=1 WHERE cb.No_FacturaCapita=f_factura_capita.`No_FacturaCapita` ";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        mLLenarCEmpresa();
    }
}
