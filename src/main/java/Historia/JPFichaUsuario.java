package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPFichaUsuario.class */
public class JPFichaUsuario extends JPanel {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xId_Ingreso;
    private JPanel JPIDatosIngreso;
    private JPanel JPIDatosOcupacionales;
    private JPanel JPIDatosU;
    private JTextField JTFEstaCivil;
    private JTextField JTFFechaI;
    private JTextField JTFHoraI;
    private JTextField JTFIAcompanante;
    private JTextField JTFIAntiguedad;
    private JTextField JTFIArl;
    private JTextField JTFICargo;
    private JTextField JTFIClaseSE;
    private JTextField JTFIEmpresaFac;
    private JTextField JTFIEps;
    private JTextField JTFIFechaIngreso;
    private JTextField JTFIGrupo;
    private JTextField JTFILateralidad;
    private JTextField JTFINivelEstudio;
    private JTextField JTFINoHijos;
    private JTextField JTFIOcupacion;
    private JTextField JTFIParentesco;
    private JTextField JTFISEG;
    private JTextField JTFISupervisor;
    private JTextField JTFITelefono;
    private JTextField JTFITelefono1;
    private JTextField JTFIUnidadNegocio;
    private JTextField JTFRegimen;
    private JTextField JTFUNDireccion;
    private JTextField JTFUNEdad;
    private JTextField JTFUNEmail;
    private JTextField JTFUNFechaNac;
    private JTextField JTFUNGSanguineo;
    private JTextField JTFUNHc;
    private JTextField JTFUNMunicipioBarrio;
    private JTextField JTFUNSexo;
    private JTextField JTFUNTd;
    private JTextField JTFUNTelefono;
    private JTextField JTFUNUsuario;
    private JTabbedPane JTPDatos;

    public JPFichaUsuario(String xId_Ingreso) {
        initComponents();
        this.xId_Ingreso = xId_Ingreso;
        mCargarDatos();
        if (!Principal.informacionIps.getIdentificacion().equals("900304530")) {
            mCargarDatosOcupacionales();
        }
    }

    private void mCargarDatos() {
        try {
            String sql = "SELECT \ngu.`NoHistoria`\n, CONCAT(`gp`.`Id_TipoIdentificacion`,'-', `gp`.`NoDocumento`) AS `TD`\n, CONCAT(gp.Apellido1, ' ', gp.Apellido2, ' ', gp.Nombre1, ' ', gp.Nombre2) `NUsuario`\n, gp.Id_Sexo  `IdSexo`\n, DATE_FORMAT(`gp`.`FechaNac`,'%d-%m-%Y') AS `FechaNac`\n, CalculaTiempo_AMD_2Fechas(gp.FechaNac,ingreso.FechaIngreso) AS `Edad`\n, CONCAT(`gm`.Nbre,' - ', `gb`.`Nbre`) AS `MunBarr` \n, `gp`.`Direccion`\n, `gp`.`Telefono`\n, gp.Correo  \n, UCASE(`g_parentesco`.`Nbre`) AS `NParentesco`\n, UCASE(`g_nivelestudio`.`Nbre`) AS `NEstudio`\n, IF(f_empresacontxconvenio.Nbre <>'', f_empresacontxconvenio.Nbre, '')`EPS` \n, IF(hsdo.cargo <>'', hsdo.cargo , `g_ocupacion`.`Nbre`) cargo\n, `ingreso`.`NAcompanante`\n, `ingreso`.`TelefonoAcomp`\n, `ingreso`.`NPersonaResp`\n, `ingreso`.`TelefonoPResp`\n, cc_terceros.RazonSocialCompleta AS `NEmpresa`\n, CONCAT(gp.GrupoSangre ,' ', gp.Rh) GrupoSanguineo \n, `ingreso`.`FechaIngreso` \n, `ingreso`.`HoraIngreso`    \n, g_estadocivil.Nbre  estadoCivil\n, gp.Movil  `Celular`, ingreso.ClaseSE , ingreso.NoHijos , ingreso.SO_Lateralidad , gt.Nbre  regimen \nFROM `ingreso` \nINNER JOIN  g_persona gp  ON (`ingreso`.`Id_Usuario` = `gp`.`Id`)\nINNER JOIN g_municipio gm ON (gm.Id=gp.Id_Municipio)\nINNER JOIN g_barrio gb ON (gb.Id=gp.Id_Barrio)\nINNER JOIN  `g_estadocivil` ON (gp.Id_EstadoCivil =g_estadocivil.`Id`) \nINNER JOIN `g_ocupacion`  ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)\nINNER JOIN  `g_parentesco`  ON (`ingreso`.`Id_Parentesco` = `g_parentesco`.`Id`) \nINNER JOIN  `g_nivelestudio`  ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`) \nINNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) \nINNER JOIN  cc_terceros  ON (`g_empresacont`.`Id_empresa` = cc_terceros.`Id`) \ninner join g_tipoafiliado gt on (gt.Id =ingreso.idTipoAfiliacion )\nLEFT JOIN h_atencion ha ON (ha.Id_Ingreso=ingreso.Id)\nLEFT JOIN h_so_datos_ocupacionales hsdo  ON (hsdo.Id_Atencion=ha.Id) \nINNER JOIN g_usuario gu ON (gu.`Id_persona`=gp.`Id`)\nWHERE (`ingreso`.`Id` ='" + this.xId_Ingreso + "')";
            System.out.println(sql);
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTFUNHc.setText(xrs.getString(1));
                        this.JTFUNTd.setText(xrs.getString(2));
                        this.JTFUNUsuario.setText(xrs.getString(3));
                        this.JTFUNSexo.setText(xrs.getString(4));
                        this.JTFUNFechaNac.setText(xrs.getString(5));
                        this.JTFUNEdad.setText(xrs.getString(6));
                        this.JTFUNMunicipioBarrio.setText(xrs.getString(7));
                        this.JTFUNDireccion.setText(xrs.getString(8));
                        this.JTFUNTelefono.setText(xrs.getString(9));
                        this.JTFUNTelefono.setText(xrs.getString(9));
                        this.JTFUNEmail.setText(xrs.getString(10));
                        this.JTFIParentesco.setText(xrs.getString(11));
                        this.JTFINivelEstudio.setText(xrs.getString(12));
                        this.JTFIEmpresaFac.setText(xrs.getString(13));
                        this.JTFIOcupacion.setText(xrs.getString(14));
                        this.JTFIAcompanante.setText(xrs.getString(15));
                        this.JTFITelefono.setText(xrs.getString(16));
                        this.JTFITelefono1.setText(xrs.getString("Celular"));
                        this.JTFIEps.setText(xrs.getString(19));
                        this.JTFUNGSanguineo.setText(xrs.getString(20));
                        this.JTFFechaI.setText(xrs.getString(21));
                        this.JTFHoraI.setText(xrs.getString(22));
                        this.JTFEstaCivil.setText(xrs.getString(23));
                        this.JTFINoHijos.setText(xrs.getString("NoHijos"));
                        this.JTFIClaseSE.setText(xrs.getString("ClaseSE"));
                        this.JTFILateralidad.setText(xrs.getString("SO_Lateralidad"));
                        this.JTFRegimen.setText(xrs.getString("regimen"));
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPFichaUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosOcupacionales() {
        try {
            String sql = "SELECT `g_cargos`.`Nbre` AS cargo, `persona`.`NUsuario` AS supervisor, `so_tipo_segmento`.`Nbre` AS segmento , cc_terceros.RazonSocialCompleta AS arl, `so_tipo_grupo`.`Nbre` AS grupo, `g_usuario`.`NHijo`, `g_usuario`.`CSEconomica`, IF(`g_usuario`.`FechaIngreso` IS NULL, '', `g_usuario`.`FechaIngreso`)AS FechaIngreso, g_so_lateralidad.Nbre, `CalculaTiempo_AMD`(g_usuario.`FechaIngreso`) AS FechaIngreso, ingreso.SO_UNegocio  FROM `g_usuario` INNER JOIN `persona` ON (`g_usuario`.`Id_Supervisor` = `persona`.`Id_persona`) INNER JOIN `g_cargos` ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)INNER JOIN `so_tipo_segmento` ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) INNER JOIN `so_tipo_grupo`  ON (`g_usuario`.`Id_TipoGrupo` = `so_tipo_grupo`.`Id`) INNER JOIN cc_terceros ON (`g_usuario`.`Id_Arl` = cc_terceros.`Id`) INNER JOIN `g_so_lateralidad`  ON (`g_usuario`.`Id_Lateralidad` = `g_so_lateralidad`.`Id`)  INNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) WHERE (`ingreso`.`Id` ='" + this.xId_Ingreso + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTFICargo.setText(xrs.getString(1));
                        this.JTFISupervisor.setText(xrs.getString(2));
                        this.JTFISEG.setText(xrs.getString(3));
                        this.JTFIArl.setText(xrs.getString(4));
                        this.JTFIGrupo.setText(xrs.getString(5));
                        this.JTFINoHijos.setText(xrs.getString(6));
                        this.JTFIClaseSE.setText(xrs.getString(7));
                        this.JTFIFechaIngreso.setText(xrs.getString(8));
                        this.JTFILateralidad.setText(xrs.getString(9));
                        this.JTFIAntiguedad.setText(xrs.getString(10));
                        this.JTFIUnidadNegocio.setText(xrs.getString(11));
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPFichaUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void initComponents() {
        this.JPIDatosU = new JPanel();
        this.JTFUNHc = new JTextField();
        this.JTFUNTd = new JTextField();
        this.JTFUNUsuario = new JTextField();
        this.JTFUNSexo = new JTextField();
        this.JTFUNFechaNac = new JTextField();
        this.JTFUNEdad = new JTextField();
        this.JTFUNMunicipioBarrio = new JTextField();
        this.JTFUNDireccion = new JTextField();
        this.JTFUNTelefono = new JTextField();
        this.JTFUNEmail = new JTextField();
        this.JTFUNGSanguineo = new JTextField();
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosIngreso = new JPanel();
        this.JTFIParentesco = new JTextField();
        this.JTFINivelEstudio = new JTextField();
        this.JTFIEps = new JTextField();
        this.JTFIOcupacion = new JTextField();
        this.JTFIAcompanante = new JTextField();
        this.JTFITelefono = new JTextField();
        this.JTFIEmpresaFac = new JTextField();
        this.JTFFechaI = new JTextField();
        this.JTFHoraI = new JTextField();
        this.JTFEstaCivil = new JTextField();
        this.JTFITelefono1 = new JTextField();
        this.JTFILateralidad = new JTextField();
        this.JTFINoHijos = new JTextField();
        this.JTFIClaseSE = new JTextField();
        this.JTFRegimen = new JTextField();
        this.JPIDatosOcupacionales = new JPanel();
        this.JTFICargo = new JTextField();
        this.JTFISupervisor = new JTextField();
        this.JTFISEG = new JTextField();
        this.JTFIArl = new JTextField();
        this.JTFIGrupo = new JTextField();
        this.JTFIFechaIngreso = new JTextField();
        this.JTFIAntiguedad = new JTextField();
        this.JTFIUnidadNegocio = new JTextField();
        setName("jpfichadusuario");
        this.JPIDatosU.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFUNHc.setEditable(false);
        this.JTFUNHc.setFont(new Font("Arial", 1, 12));
        this.JTFUNHc.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNTd.setEditable(false);
        this.JTFUNTd.setFont(new Font("Arial", 1, 12));
        this.JTFUNTd.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNUsuario.setEditable(false);
        this.JTFUNUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUNUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNSexo.setEditable(false);
        this.JTFUNSexo.setFont(new Font("Arial", 1, 12));
        this.JTFUNSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNFechaNac.setEditable(false);
        this.JTFUNFechaNac.setFont(new Font("Arial", 1, 12));
        this.JTFUNFechaNac.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nacimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNEdad.setEditable(false);
        this.JTFUNEdad.setFont(new Font("Arial", 1, 12));
        this.JTFUNEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNMunicipioBarrio.setEditable(false);
        this.JTFUNMunicipioBarrio.setFont(new Font("Arial", 1, 12));
        this.JTFUNMunicipioBarrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio - Barrio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNDireccion.setEditable(false);
        this.JTFUNDireccion.setFont(new Font("Arial", 1, 12));
        this.JTFUNDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNTelefono.setEditable(false);
        this.JTFUNTelefono.setFont(new Font("Arial", 1, 12));
        this.JTFUNTelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNEmail.setEditable(false);
        this.JTFUNEmail.setFont(new Font("Arial", 1, 12));
        this.JTFUNEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Eléctronico", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUNGSanguineo.setEditable(false);
        this.JTFUNGSanguineo.setFont(new Font("Arial", 1, 12));
        this.JTFUNGSanguineo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Rh", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosULayout = new GroupLayout(this.JPIDatosU);
        this.JPIDatosU.setLayout(JPIDatosULayout);
        JPIDatosULayout.setHorizontalGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosULayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosULayout.createSequentialGroup().addComponent(this.JTFUNHc, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFUNTd, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JTFUNUsuario)).addGroup(JPIDatosULayout.createSequentialGroup().addComponent(this.JTFUNDireccion, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFUNTelefono, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFUNEmail)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosULayout.createSequentialGroup().addComponent(this.JTFUNGSanguineo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFUNSexo, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFUNFechaNac, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JTFUNEdad).addGap(18, 18, 18).addComponent(this.JTFUNMunicipioBarrio, -2, 278, -2))).addContainerGap()));
        JPIDatosULayout.setVerticalGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosULayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUNHc, -2, 50, -2).addComponent(this.JTFUNTd, -2, 50, -2).addComponent(this.JTFUNUsuario, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUNFechaNac, -2, 50, -2).addComponent(this.JTFUNSexo, -2, 50, -2).addComponent(this.JTFUNEdad, -2, 50, -2).addComponent(this.JTFUNMunicipioBarrio, -2, 50, -2).addComponent(this.JTFUNGSanguineo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosULayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUNDireccion, -2, 50, -2).addComponent(this.JTFUNTelefono, -2, 50, -2).addComponent(this.JTFUNEmail, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFIParentesco.setEditable(false);
        this.JTFIParentesco.setFont(new Font("Arial", 1, 12));
        this.JTFIParentesco.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFINivelEstudio.setEditable(false);
        this.JTFINivelEstudio.setFont(new Font("Arial", 1, 12));
        this.JTFINivelEstudio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel Estudio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIEps.setEditable(false);
        this.JTFIEps.setFont(new Font("Arial", 1, 12));
        this.JTFIEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Eps", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIOcupacion.setEditable(false);
        this.JTFIOcupacion.setFont(new Font("Arial", 1, 12));
        this.JTFIOcupacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ocupación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIAcompanante.setEditable(false);
        this.JTFIAcompanante.setFont(new Font("Arial", 1, 12));
        this.JTFIAcompanante.setBorder(BorderFactory.createTitledBorder((Border) null, "Acompañante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFITelefono.setEditable(false);
        this.JTFITelefono.setFont(new Font("Arial", 1, 12));
        this.JTFITelefono.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIEmpresaFac.setEditable(false);
        this.JTFIEmpresaFac.setFont(new Font("Arial", 1, 12));
        this.JTFIEmpresaFac.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa a quien se le facturo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaI.setEditable(false);
        this.JTFFechaI.setFont(new Font("Arial", 1, 12));
        this.JTFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHoraI.setEditable(false);
        this.JTFHoraI.setFont(new Font("Arial", 1, 12));
        this.JTFHoraI.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEstaCivil.setEditable(false);
        this.JTFEstaCivil.setFont(new Font("Arial", 1, 12));
        this.JTFEstaCivil.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Civil", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFITelefono1.setEditable(false);
        this.JTFITelefono1.setFont(new Font("Arial", 1, 12));
        this.JTFITelefono1.setBorder(BorderFactory.createTitledBorder((Border) null, "Celular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFILateralidad.setEditable(false);
        this.JTFILateralidad.setFont(new Font("Arial", 1, 12));
        this.JTFILateralidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Lateralidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFINoHijos.setEditable(false);
        this.JTFINoHijos.setFont(new Font("Arial", 1, 12));
        this.JTFINoHijos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIClaseSE.setEditable(false);
        this.JTFIClaseSE.setFont(new Font("Arial", 1, 12));
        this.JTFIClaseSE.setToolTipText("Clase SocioEconómica");
        this.JTFIClaseSE.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase SE", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRegimen.setEditable(false);
        this.JTFRegimen.setFont(new Font("Arial", 1, 12));
        this.JTFRegimen.setBorder(BorderFactory.createTitledBorder((Border) null, "Régimen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosIngresoLayout = new GroupLayout(this.JPIDatosIngreso);
        this.JPIDatosIngreso.setLayout(JPIDatosIngresoLayout);
        JPIDatosIngresoLayout.setHorizontalGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.JTFIParentesco, -2, 208, -2).addGap(18, 18, 18).addComponent(this.JTFINivelEstudio, -2, 263, -2).addGap(18, 18, 18).addComponent(this.JTFIEps, -1, 194, 32767)).addComponent(this.JTFIOcupacion).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.JTFIAcompanante, -2, 293, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFITelefono).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFITelefono1, -2, 160, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.JTFHoraI, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFEstaCivil).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFILateralidad, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFINoHijos, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFIClaseSE, -2, 72, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.JTFIEmpresaFac, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRegimen).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaI, -2, 129, -2))).addContainerGap()));
        JPIDatosIngresoLayout.setVerticalGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFIParentesco, -2, 50, -2).addComponent(this.JTFINivelEstudio, -2, 50, -2).addComponent(this.JTFIEps, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFIOcupacion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFIAcompanante, -2, 50, -2).addComponent(this.JTFITelefono, -2, 50, -2).addComponent(this.JTFITelefono1, -2, 50, -2)).addGap(12, 12, 12).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFechaI, -2, 50, -2).addComponent(this.JTFIEmpresaFac, -2, 50, -2).addComponent(this.JTFRegimen, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFINoHijos, -2, 50, -2).addComponent(this.JTFIClaseSE, -2, 50, -2).addComponent(this.JTFILateralidad, -2, 50, -2).addComponent(this.JTFEstaCivil, -2, 50, -2).addComponent(this.JTFHoraI, -2, 50, -2)).addContainerGap()));
        this.JTPDatos.addTab("DATOS DE INGRESO", this.JPIDatosIngreso);
        this.JPIDatosOcupacionales.setBorder(BorderFactory.createTitledBorder(""));
        this.JTFICargo.setEditable(false);
        this.JTFICargo.setFont(new Font("Arial", 1, 12));
        this.JTFICargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFISupervisor.setEditable(false);
        this.JTFISupervisor.setFont(new Font("Arial", 1, 12));
        this.JTFISupervisor.setBorder(BorderFactory.createTitledBorder((Border) null, "Supervisor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFISEG.setEditable(false);
        this.JTFISEG.setFont(new Font("Arial", 1, 12));
        this.JTFISEG.setToolTipText("");
        this.JTFISEG.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG (Grupo Similar de Exposicion)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIArl.setEditable(false);
        this.JTFIArl.setFont(new Font("Arial", 1, 12));
        this.JTFIArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIGrupo.setEditable(false);
        this.JTFIGrupo.setFont(new Font("Arial", 1, 12));
        this.JTFIGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIFechaIngreso.setEditable(false);
        this.JTFIFechaIngreso.setFont(new Font("Arial", 1, 12));
        this.JTFIFechaIngreso.setToolTipText("");
        this.JTFIFechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIAntiguedad.setEditable(false);
        this.JTFIAntiguedad.setFont(new Font("Arial", 1, 12));
        this.JTFIAntiguedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Antiguedad Laboral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIUnidadNegocio.setEditable(false);
        this.JTFIUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JTFIUnidadNegocio.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Negocio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosOcupacionalesLayout = new GroupLayout(this.JPIDatosOcupacionales);
        this.JPIDatosOcupacionales.setLayout(JPIDatosOcupacionalesLayout);
        JPIDatosOcupacionalesLayout.setHorizontalGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addGap(0, 353, 32767).addComponent(this.JTFIFechaIngreso, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFIAntiguedad, -2, 227, -2)).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFIArl).addComponent(this.JTFICargo, -1, 229, 32767)).addGap(18, 18, 18).addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addComponent(this.JTFISupervisor, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFISEG)).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addComponent(this.JTFIGrupo, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFIUnidadNegocio))))).addGap(10, 10, 10)));
        JPIDatosOcupacionalesLayout.setVerticalGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosOcupacionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFICargo, -2, 50, -2).addComponent(this.JTFISupervisor, -2, 50, -2).addComponent(this.JTFISEG, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFIArl, -2, 50, -2).addComponent(this.JTFIGrupo, -2, 50, -2).addComponent(this.JTFIUnidadNegocio, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDatosOcupacionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFIFechaIngreso, -2, 50, -2).addComponent(this.JTFIAntiguedad, -2, 50, -2)).addContainerGap(126, 32767)));
        this.JTPDatos.addTab("DATOS OCUPACIONALES", this.JPIDatosOcupacionales);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosU, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosU, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos).addContainerGap()));
    }
}
