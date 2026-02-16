package RecursosHumanos;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.InformacionIpsDAO;
import com.genoma.plus.dao.impl.general.InformacionIpsDAOImpl;
import com.genoma.plus.dao.impl.rrhh.ImplementacionReporteRecursoHumanoDAOImpl;
import com.genoma.plus.dao.rrhh.ImplementacionReportesRecusoHumanoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:RecursosHumanos/JIFConsultarPlanillaNomina.class */
public class JIFConsultarPlanillaNomina extends JInternalFrame {
    private String xsql;
    private Object[] xdatos;
    private String[] xId_Nomina;
    private String[] xId_Clasificacion;
    private String[] xId_UnidadF;
    private ImplementacionReportesRecusoHumanoDAO implementacionReportesRecusoHumanoDAO;
    private InformacionIpsDAO informacionIpsDAO;
    private JComboBox JCBNomina;
    private JComboBox JCBUnidadFuncional;
    private JCheckBox JCHNomina;
    private JCheckBox JCHOtros;
    private JPanel JPIDatos;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFConsultarPlanillaNomina() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBNomina = new JComboBox();
        this.JCBUnidadFuncional = new JComboBox();
        this.JCHOtros = new JCheckBox();
        this.JCHNomina = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES DE PLANILLAS DE NOMINA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_consultarplanillanomina");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBNomina.setFont(new Font("Arial", 1, 12));
        this.JCBNomina.setBorder(BorderFactory.createTitledBorder((Border) null, "Nomina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNomina.addItemListener(new ItemListener() { // from class: RecursosHumanos.JIFConsultarPlanillaNomina.1
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarPlanillaNomina.this.JCBNominaItemStateChanged(evt);
            }
        });
        this.JCBUnidadFuncional.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadFuncional.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHOtros.setFont(new Font("Arial", 1, 12));
        this.JCHOtros.setText("Otros conceptos");
        this.JCHOtros.addActionListener(new ActionListener() { // from class: RecursosHumanos.JIFConsultarPlanillaNomina.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarPlanillaNomina.this.JCHOtrosActionPerformed(evt);
            }
        });
        this.JCHNomina.setFont(new Font("Arial", 1, 12));
        this.JCHNomina.setSelected(true);
        this.JCHNomina.setText("Nomina");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBNomina, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUnidadFuncional, -2, 376, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(98, 98, 98).addComponent(this.JCHOtros))).addContainerGap(44, 32767)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JCHNomina).addContainerGap(519, 32767))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNomina, -2, 50, -2).addComponent(this.JCBUnidadFuncional, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, 32767).addComponent(this.JCHOtros).addContainerGap()).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap(89, 32767).addComponent(this.JCHNomina).addContainerGap())));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNominaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBNomina.getSelectedIndex() != -1) {
            this.xlleno1 = false;
            this.JCBUnidadFuncional.removeAllItems();
            this.xsql = "SELECT`rh_tipo_clasificacion`.`Id`, `rh_unidad_funcional`.`NUnificacion`FROM`rh_nomina_liquidacion_detalle`INNER JOIN `rh_nomina_liquidacion` ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)INNER JOIN `rh_nomina_periodo` ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)INNER JOIN `rh_tipo_persona_cargon` ON (`rh_nomina_liquidacion_detalle`.`Id_PersonaC` = `rh_tipo_persona_cargon`.`Id`)INNER JOIN `rh_tipo_clasificacion` ON (`rh_tipo_persona_cargon`.`Id_Clasificacion` = `rh_tipo_clasificacion`.`Id`)INNER JOIN `rh_unidadf_cargo` ON (`rh_tipo_persona_cargon`.`Id_unidadf_cargo` = `rh_unidadf_cargo`.`Id`)INNER JOIN `rh_unidad_funcional` ON (`rh_unidadf_cargo`.`Id_UnidadF` = `rh_unidad_funcional`.`Id`)WHERE (`rh_nomina_liquidacion`.`Id` ='" + this.xId_Nomina[this.JCBNomina.getSelectedIndex()] + "'AND `rh_nomina_liquidacion`.`Estado` ='1')GROUP BY `rh_unidad_funcional`.`NUnificacion`ORDER BY `rh_unidad_funcional`.`NUnificacion` ASC;";
            this.xId_UnidadF = this.xct.llenarCombo(this.xsql, this.xId_UnidadF, this.JCBUnidadFuncional);
            this.JCBUnidadFuncional.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHOtrosActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBUnidadFuncional.removeAllItems();
        this.JCBNomina.removeAllItems();
        this.xsql = "SELECT    `rh_nomina_liquidacion`.`Id`    , CONCAT(`rh_nomina_liquidacion`.`Id`,'_',`rh_nomina_periodo`.`Nbre` ,'_', `rh_nomina_liquidacion`.`Ano`) AS `Nomina`FROM    `rh_nomina_liquidacion_detalle`    INNER JOIN `rh_nomina_liquidacion`         ON (`rh_nomina_liquidacion_detalle`.`Id_Liquidacion` = `rh_nomina_liquidacion`.`Id`)    INNER JOIN `rh_nomina_periodo`         ON (`rh_nomina_liquidacion`.`Id_Periodo` = `rh_nomina_periodo`.`Id`)WHERE (`rh_nomina_liquidacion`.`Estado` =1)GROUP BY `rh_nomina_liquidacion`.`Id`ORDER BY `rh_nomina_liquidacion`.`FechaR` DESC";
        this.xId_Nomina = this.xct.llenarCombo(this.xsql, this.xId_Nomina, this.JCBNomina);
        this.JCBNomina.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.implementacionReportesRecusoHumanoDAO = (ImplementacionReporteRecursoHumanoDAOImpl) classPathXmlApplicationContext.getBean("implementacionReporteRecursoHumanoDAOImpl");
        this.informacionIpsDAO = (InformacionIpsDAOImpl) classPathXmlApplicationContext.getBean("informacionIpsDAOImpl");
    }

    public void mImprimir() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Id_Nomina";
        parametros[1][1] = this.xId_Nomina[this.JCBNomina.getSelectedIndex()];
        parametros[2][0] = "Id_Clasificacion";
        parametros[2][1] = this.JCBUnidadFuncional.getSelectedItem().toString();
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JCHNomina.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "N_Liquidacion_F2", parametros);
        }
        if (this.JCHOtros.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "N_Liquidacion_F3", parametros);
        }
    }
}
