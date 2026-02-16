package Facturacion;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFConsultarInformesE.class */
public class JIFConsultarInformesE extends JInternalFrame {
    private String xobjetollamador;
    private String[] xidempresa;
    private int xid;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    public JComboBox JCBEmpresa;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatos;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIFConsultarInformesE(String xnombre, int xid) {
        initComponents();
        setName(xnombre);
        this.xid = xid;
        mNuevo();
    }

    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        this.JBTExportar = new JButton();
        this.JCBEmpresa = new JComboBox();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarinformacionf");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFConsultarInformesE.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInformesE.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFConsultarInformesE.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarInformesE.this.JDFFechaIPropertyChange(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Facturacion.JIFConsultarInformesE.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarInformesE.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFConsultarInformesE.4
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarInformesE.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -1, 690, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, 0, 432, 32767)).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 690, 32767)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEmpresa).addComponent(this.JDFFechaI, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFFechaF, GroupLayout.Alignment.LEADING, -2, 59, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -1, 58, 32767).addGap(12, 12, 12).addComponent(this.JBTExportar, -2, 42, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (!this.JTFRuta.getText().isEmpty()) {
                if (this.xid == 0) {
                    mExportar();
                    return;
                } else {
                    if (this.xid == 1) {
                        mExportar1();
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ruta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEmpresa.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarCombo();
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.xlleno = true;
    }

    private void mCargarCombo() {
        String xsql;
        this.JCBEmpresa.removeAllItems();
        if (this.xid == 0) {
            xsql = "SELECT\ningreso.Id_EmpresaContxConv,\nf_empresacontxconvenio.Nbre as Convenio\nFROM\n\tf_factura_capita\nINNER JOIN f_liquidacion ON\n\t(f_factura_capita.Id_Liquidacion = f_liquidacion.Id)\nINNER JOIN ingreso ON\n\t(ingreso.Id = f_liquidacion.Id_Ingreso)\nINNER JOIN persona ON\n\t(persona.Id_persona = ingreso.Id_Usuario)\nInner JOIN f_empresacontxconvenio on\n    (f_empresacontxconvenio.Id=ingreso.Id_EmpresaContxConv)\nWHERE\n\t(f_factura_capita.Fecha_FacturaCapita >= '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'\n\tAND f_factura_capita.Fecha_FacturaCapita <= '" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "'\n\tAND f_liquidacion.Estado = 0)\nGROUP BY\n\tConvenio\nORDER BY\n\tConvenio ASC";
        } else {
            xsql = "SELECT\n\tf_empresacontxconvenio.Id,\n\tf_empresacontxconvenio.Nbre as Convenio\nFROM\n\tf_factura_evento\nINNER JOIN f_cuentacobro ON\n\t(f_factura_evento.No_CuentaCobro = f_cuentacobro.NoCuenta)\nINNER JOIN f_empresacontxconvenio ON\n\t(f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_factura_capita ON\n\t(f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)\nINNER JOIN f_liquidacion ON\n\t(f_factura_capita.Id_Liquidacion = f_liquidacion.Id)\nINNER JOIN ingreso ON\n\t(f_liquidacion.Id_Ingreso = ingreso.Id)\nINNER JOIN f_subgrupo_empresa ON\n\t(f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)\nINNER JOIN f_subgruposervicio ON\n\t(f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio)\n\tAND (f_subgrupo_empresa.Id_Empresa = ingreso.Id_EmpresaContxConv)\nINNER JOIN f_gruposervicio ON\n\t(f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)\nINNER JOIN persona ON\n\t(ingreso.Id_Usuario = persona.Id_persona)\nWHERE\n\t(f_cuentacobro.Periodo_Fact >= '" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'\n\tAND f_cuentacobro.Periodo_Fact <= '" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "')\n\tAND f_factura_capita.Estado = 0\nGROUP BY\n\tConvenio\nORDER BY\n\tConvenio ASC;";
        }
        this.xidempresa = this.xconsultas.llenarCombo(xsql, this.xidempresa, this.JCBEmpresa);
        this.xconsultas.cerrarConexionBd();
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    private void mExportar() {
        String xsql = "SELECT persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NoHistoria, persona.NUsuario  FROM f_factura_capita INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso) INNER JOIN persona  ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (f_factura_capita.Fecha_FacturaCapita >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND f_factura_capita.Fecha_FacturaCapita <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND f_liquidacion.Estado =0 AND ingreso.Id_EmpresaContxConv ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "') GROUP BY persona.NoHistoria ORDER BY persona.NUsuario ASC ";
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xmt.mExportar_Datos_Formato_Consulta(xsql, this.JTFRuta.getText(), getTitle());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFConsultarInformesE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mExportar1() {
        String xsql = "SELECT f_cuentacobro.NoCuenta AS CuentaCobro, IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`) AS FacturaDian, f_cuentacobro.Periodo_Fact AS Periodo, f_empresacontxconvenio.Nbre AS Empresa, f_gruposervicio.Nbre AS GrupoFactura, f_subgruposervicio.Nbre AS SubgrupoFactura , f_cuentacobro.TotalServicio, f_cuentacobro.TotalCuotaM, f_cuentacobro.TotalCopago, f_cuentacobro.TotalDesc, f_cuentacobro.TotalNeto, f_factura_capita.No_FacturaCapita AS NoOrden, f_factura_capita.Fecha_FacturaCapita FechaOrden, persona.Id_TipoIdentificacion AS TipoIdentificacion  , persona.NoDocumento AS NoDocumento, persona.NUsuario AS Usuario, f_liquidacion.TotalServicio, f_liquidacion.CuotaModeradora, f_liquidacion.Copago, f_liquidacion.TotalEps  FROM  f_factura_evento INNER JOIN f_cuentacobro ON (f_factura_evento.No_CuentaCobro = f_cuentacobro.NoCuenta) INNER JOIN f_empresacontxconvenio ON (f_cuentacobro.IdEmpContxConv = f_empresacontxconvenio.Id)  INNER JOIN f_factura_capita  ON (f_factura_capita.No_FacturaEvento = f_factura_evento.No_FacturaEvento)  INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (f_liquidacion.Id_Ingreso = ingreso.Id)  INNER JOIN f_subgrupo_empresa ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)     INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo= f_subgruposervicio.Id_SubgrupoServicio) AND (f_subgrupo_empresa.Id_Empresa\t= ingreso.Id_EmpresaContxConv)     INNER JOIN f_gruposervicio ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  INNER JOIN persona  ON (ingreso.Id_Usuario = persona.Id_persona)   INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_cuentacobro.IdEmpContxConv='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND f_cuentacobro.Periodo_Fact >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND f_cuentacobro.Periodo_Fact <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') AND f_factura_capita.Estado=0 ORDER BY f_cuentacobro.NoCuenta ASC, f_gruposervicio.Nbre ASC, f_subgruposervicio.Nbre ASC";
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.xmt.mExportar_Datos_Formato_Consulta(xsql, this.JTFRuta.getText(), getTitle());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFConsultarInformesE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
