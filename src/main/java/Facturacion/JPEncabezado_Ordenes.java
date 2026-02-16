package Facturacion;

import Citas.CitaNP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JPEncabezado_Ordenes.class */
public class JPEncabezado_Ordenes extends JPanel {
    public String[][] xidservicio;
    public String[] xidespecialidad;
    public String[] xidprofesional;
    public String[] xidcentrocosto;
    private String xsql;
    private JIFLiqServicios xliq;
    private CitaNP xCitaNP;
    private String xIdServicio;
    private String xIdTipoServicio;
    private String xIdClaseProcedimiento;
    public List<GServicioGrupoEntity> listGrupoEntitys;
    public List<GServicioRipsEntity> ListripsEntitys;
    public JComboBox JCBCentroCosto;
    public JComboBox JCBEspecialidad;
    public JComboBox JCBProfesional;
    public JComboBox JCBTipoServicio;
    private JScrollPane JPSObservacion;
    public JTextArea JTAObservacion;
    public JFormattedTextField txtNoPrescripcionMiPres;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xLlamamdor = 0;

    public JPEncabezado_Ordenes(JInternalFrame xliq) {
        initComponents();
        mCasting(xliq);
        mNuevo();
        this.JCBEspecialidad.requestFocus();
    }

    private void initComponents() {
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoServicio = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JPSObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.txtNoPrescripcionMiPres = new JFormattedTextField();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JPEncabezado_Ordenes.1
            public void itemStateChanged(ItemEvent evt) {
                JPEncabezado_Ordenes.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBTipoServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Servicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoServicio.addItemListener(new ItemListener() { // from class: Facturacion.JPEncabezado_Ordenes.2
            public void itemStateChanged(ItemEvent evt) {
                JPEncabezado_Ordenes.this.JCBTipoServicioItemStateChanged(evt);
            }
        });
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPSObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JPSObservacion.setViewportView(this.JTAObservacion);
        this.txtNoPrescripcionMiPres.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Prescripción Mipres", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPrescripcionMiPres.setFont(new Font("Arial", 1, 12));
        this.txtNoPrescripcionMiPres.addFocusListener(new FocusAdapter() { // from class: Facturacion.JPEncabezado_Ordenes.3
            public void focusLost(FocusEvent evt) {
                JPEncabezado_Ordenes.this.txtNoPrescripcionMiPresFocusLost(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addActionListener(new ActionListener() { // from class: Facturacion.JPEncabezado_Ordenes.4
            public void actionPerformed(ActionEvent evt) {
                JPEncabezado_Ordenes.this.txtNoPrescripcionMiPresActionPerformed(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addKeyListener(new KeyAdapter() { // from class: Facturacion.JPEncabezado_Ordenes.5
            public void keyPressed(KeyEvent evt) {
                JPEncabezado_Ordenes.this.txtNoPrescripcionMiPresKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPSObservacion).addGroup(layout.createSequentialGroup().addComponent(this.JCBTipoServicio, -2, 295, -2).addGap(18, 18, 18).addComponent(this.JCBCentroCosto, -2, 267, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoPrescripcionMiPres, -2, 159, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JCBEspecialidad, 0, 321, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, -2, 415, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCBProfesional, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoServicio, -2, 50, -2).addComponent(this.JCBCentroCosto, -2, 50, -2).addComponent(this.txtNoPrescripcionMiPres, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPSObservacion, -1, 145, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xsql = "SELECT `Id_Persona` , `NProfesional` FROM `profesional1` WHERE (`IdEspecialidad` ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY `NProfesional` ASC ";
            this.xidprofesional = this.xct.llenarCombo(this.xsql, this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoServicioItemStateChanged(ItemEvent evt) {
        if (this.JCBTipoServicio.getSelectedIndex() != -1 && this.xlleno) {
            setxIdServicio(this.xidservicio[this.JCBTipoServicio.getSelectedIndex()][0].toString());
            setxIdTipoServicio(this.xidservicio[this.JCBTipoServicio.getSelectedIndex()][2].toString());
            setxIdClaseProcedimiento(this.xidservicio[this.JCBTipoServicio.getSelectedIndex()][3].toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresKeyPressed(KeyEvent evt) {
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBProfesional.removeAllItems();
        this.JCBTipoServicio.removeAllItems();
        if (this.xLlamamdor == 1) {
            this.xsql = "SELECT `f_tiposervicio`.`Id`  , `f_tiposervicio`.`Nbre` , `f_servicioempresaconv`.`Porcentaje_Descuento`  , `f_servicioempresaconv`.`NCopias`, f_tipoprocedimiento.Id_tipoclaseproc  FROM `f_servicioempresaconv`  INNER JOIN  `f_tiposervicio`   ON (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)  INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) INNER JOIN  `f_tipoprocedimiento`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)  WHERE (`f_servicioempresaconv`.`Id_EmpresaConvenio` ='" + this.xliq.getXidempresa() + "'  AND `f_servicioempresaconv`.`Estado` =0  AND f_tipoprocedimiento.Id_tipoclaseproc IN(2,3,4) AND f_tiposervicio.Estado =0)  GROUP BY `f_tiposervicio`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC ";
        } else if (this.xLlamamdor == 2) {
            this.xsql = "SELECT `f_tiposervicio`.`Id`  , `f_tiposervicio`.`Nbre` , `f_servicioempresaconv`.`Porcentaje_Descuento`  , `f_servicioempresaconv`.`NCopias`, f_tipoprocedimiento.Id_tipoclaseproc  FROM `f_servicioempresaconv`  INNER JOIN  `f_tiposervicio`   ON (`f_servicioempresaconv`.`Id_TipoServicio` = `f_tiposervicio`.`Id`)  INNER JOIN  `f_tiposervtipoproced`  ON (`f_tiposervtipoproced`.`Idtiposervicio` = `f_tiposervicio`.`Id`) INNER JOIN  `f_tipoprocedimiento`  ON (`f_tiposervtipoproced`.`Idtipoprocedimiento` = `f_tipoprocedimiento`.`Id`)  WHERE (`f_servicioempresaconv`.`Id_EmpresaConvenio` ='" + this.xCitaNP.frmIngreso.listConvenio.get(this.xCitaNP.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "'  AND `f_servicioempresaconv`.`Estado` =0  AND f_tipoprocedimiento.Id_tipoclaseproc IN(2,3,4) AND f_tiposervicio.Estado =0)  GROUP BY `f_tiposervicio`.`Id` ORDER BY `f_tiposervicio`.`Nbre` ASC ";
        }
        this.xidservicio = this.xct.llenarComboyLista(this.xsql, this.xidservicio, this.JCBTipoServicio, 5);
        this.JCBTipoServicio.setSelectedIndex(-1);
        this.JCBEspecialidad.removeAllItems();
        this.xsql = "SELECT `g_especialidad`.`Id`  , `g_especialidad`.`Nbre` FROM `g_profesionalespecial` INNER JOIN  `g_especialidad`  ON (`g_profesionalespecial`.`Id_Especialidad` = `g_especialidad`.`Id`) INNER JOIN  `g_profesional`   ON (`g_profesionalespecial`.`Id_Profesional` = `g_profesional`.`Id_Persona`) WHERE (`g_profesionalespecial`.`Estado` =0 AND `g_especialidad`.`G_Ordenes`=1) GROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ";
        this.xidespecialidad = this.xct.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xsql = "SELECT Id, Nbre as Centro_Costo FROM f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC";
        this.xidcentrocosto = this.xct.llenarCombo(this.xsql, this.xidcentrocosto, this.JCBCentroCosto);
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.xlleno = true;
        this.xct.cerrarConexionBd();
        this.JTAObservacion.setText("");
    }

    public void mCasting(JInternalFrame xGenerico) {
        if (xGenerico.getName().equals("jifLiqServicios")) {
            this.xliq = (JIFLiqServicios) xGenerico;
            this.xLlamamdor = 1;
        } else if (xGenerico.getName().equals("CitaNP")) {
            this.xCitaNP = (CitaNP) xGenerico;
            System.err.println("ente anexo xita");
            this.xLlamamdor = 2;
        }
    }

    public boolean mValidar_Componentes() {
        boolean xestado = false;
        if (this.JCBProfesional.getSelectedIndex() != -1) {
            if (this.JCBTipoServicio.getSelectedIndex() != -1) {
                if (this.JCBCentroCosto.getSelectedIndex() != -1) {
                    xestado = true;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un centro de costo", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBCentroCosto.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoServicio.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProfesional.requestFocus();
        }
        return xestado;
    }

    public String getxIdServicio() {
        return this.xIdServicio;
    }

    public void setxIdServicio(String xIdServicio) {
        this.xIdServicio = xIdServicio;
    }

    public String getxIdTipoServicio() {
        return this.xIdTipoServicio;
    }

    public void setxIdTipoServicio(String xIdTipoServicio) {
        this.xIdTipoServicio = xIdTipoServicio;
    }

    public String getxIdClaseProcedimiento() {
        return this.xIdClaseProcedimiento;
    }

    public void setxIdClaseProcedimiento(String xIdClaseProcedimiento) {
        this.xIdClaseProcedimiento = xIdClaseProcedimiento;
    }
}
