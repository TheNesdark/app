package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPSo_VisiometriaMineros.class */
public class JPSo_VisiometriaMineros extends JPanel {
    private JPSo_VisiometriaDistancias xJPSo_VisiometriaDistancias;
    private JPSo_VisiometriaDistancias xJPSo_VisiometriaIntermedia;
    private JPSo_VisiometriaDistancias xJPSo_VisiometriaCercana;
    private int xTriangulo;
    private int xCirculo1;
    private int xEstrella1;
    private int xCuadrado;
    private int xEstrella2;
    private int xCirculo2;
    private int xAO81;
    private int xAO45;
    private int xAO63;
    private int xAO27;
    private int xAO90;
    private int xAO18;
    private int xOD81;
    private int xOD45;
    private int xOD63;
    private int xOD27;
    private int xOD90;
    private int xOD18;
    private int xOI81;
    private int xOI45;
    private int xOI63;
    private int xOI27;
    private int xOI90;
    private int xOI18;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup JBG_FiltroCorreccion;
    private JCheckBox JCHCirculo;
    private JCheckBox JCHCirculo2;
    private JCheckBox JCHCuadrado;
    private JCheckBox JCHEstrella1;
    private JCheckBox JCHEstrella2;
    private JCheckBox JCHTriangulo;
    private JCheckBox JCH_ConCorrecion;
    private JCheckBox JCH_SinCorrecion;
    private JLabel JLClasAmbli;
    private JLabel JLClasForia;
    private JLabel JLClasProf;
    private JLabel JLClasVC_AO;
    private JLabel JLClasVC_OD;
    private JLabel JLClasVC_OI;
    private JPanel JPVCercana;
    private JPanel JPVIntermedia;
    private JPanel JPVLejana;
    private JPanel JPVisionColores;
    private JRadioButton JRBColor10;
    private JRadioButton JRBColor11;
    private JRadioButton JRBColor12;
    private JRadioButton JRBColor13;
    private JRadioButton JRBColor14;
    private JRadioButton JRBColor15;
    private JRadioButton JRBColor16;
    private JRadioButton JRBColor17;
    private JRadioButton JRBColor18;
    private JRadioButton JRBColor19;
    private JRadioButton JRBColor20;
    private JRadioButton JRBColor21;
    private JRadioButton JRBColor22;
    private JRadioButton JRBColor23;
    private JRadioButton JRBColor24;
    private JRadioButton JRBColor25;
    private JRadioButton JRBColor26;
    private JRadioButton JRBColor7;
    private JRadioButton JRBColor8;
    private JRadioButton JRBColor9;
    private JRadioButton JRBamb1;
    private JRadioButton JRBamb2;
    private JRadioButton JRBamb3;
    private JRadioButton JRBamb4;
    private JRadioButton JRBamb5;
    private JTable JTHistoricoDetalle;
    private ButtonGroup ambliopia;
    private ButtonGroup colores;
    private ButtonGroup foria;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox14;
    private JCheckBox jCheckBox15;
    private JCheckBox jCheckBox16;
    private JCheckBox jCheckBox17;
    private JCheckBox jCheckBox18;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox9;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTabbedPane jTabbedPane1;
    private ButtonGroup vision_prof;
    private int xVProf = 0;
    private int xAmbi = 0;
    private int xColoresAO = 0;
    private int xColoresOD = 0;
    private int xColoresOI = 0;
    private final int XVALUE_DEFAULT = -1;
    private String xidVisiometia = "";
    private Metodos xmt = new Metodos();
    ConsultasMySQL xct = new ConsultasMySQL();
    private long xatenciong = 0;

    public JPSo_VisiometriaMineros() {
        initComponents();
        mIniciaComponentes();
        mTraeVisiometriaActual();
    }

    private void mTraeVisiometriaActual() {
        String sql = "SELECT h_so_visiometria_m.id, vptriangulo1, vpcirculo2,h_so_visiometria_m.correccion,\nvpestrella3, vpcuadrado4, vpestrella5, vpcirculo6, vpclasificacion, amb_valor, amb_clasificacion, \nforia_valor, foria_clasificacion, vc_ao_81, vc_ao_45, vc_ao_63, vc_ao_27, vc_ao_90, vc_ao_18, \nvc_ao_clasificacion, vc_od_81, vc_od_45, vc_od_63, vc_od_27, vc_od_90, vc_od_18, vc_od_clasificacion, \nvc_oi_81, vc_oi_45, vc_oi_63, vc_oi_27, vc_oi_90, vc_oi_18, vc_oi_clasificacion, vl_ao_linea, \nvl_ao_optotipos, vl_ao_nivel_av, vl_ao_clasificacion, vl_ao_optotipos_selected, vl_od_linea, \nvl_od_optotipos, vl_od_nivel_av, vl_od_clasificacion, vl_od_optotipos_selected, vl_oi_linea, \nvl_oi_optotipos, vl_oi_nivel_av, vl_oi_clasificacion, vl_oi_optotipos_selected, vi_ao_linea, \nvi_ao_optotipos, vi_ao_nivel_av, vi_ao_clasificacion, vi_ao_optotipos_selected, vi_od_linea, \nvi_od_optotipos, vi_od_nivel_av, vi_od_clasificacion, vi_od_optotipos_selected, vi_oi_linea, \nvi_oi_optotipos, vi_oi_nivel_av, vi_oi_clasificacion, vi_oi_optotipos_selected, vce_ao_linea, \nvce_ao_optotipos, vce_ao_nivel_av, vce_ao_clasificacion, vce_ao_optotipos_selected, vce_od_linea, \nvce_od_optotipos, vce_od_nivel_av, vce_od_clasificacion, vce_od_optotipos_selected, vce_oi_linea, \nvce_oi_optotipos, vce_oi_nivel_av, vce_oi_clasificacion, vce_oi_optotipos_selected,\n`h_atencion`.`TipoGuardado`\nFROM h_so_visiometria_m\nINNER JOIN `h_atencion` ON (`h_so_visiometria_m`.`idatencion` = `h_atencion`.`Id`)\nWHERE h_so_visiometria_m.estado=1 and h_so_visiometria_m.idatencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xidVisiometia = xrs.getString("id");
                if (xrs.getBoolean("correccion")) {
                    this.JCH_ConCorrecion.setSelected(true);
                } else {
                    this.JCH_SinCorrecion.setSelected(true);
                }
                this.JCHTriangulo.setSelected(xrs.getBoolean("vptriangulo1"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vptriangulo1"));
                this.xTriangulo = xrs.getInt("vptriangulo1");
                this.JCHCirculo.setSelected(xrs.getBoolean("vpcirculo2"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vpcirculo2"));
                this.xCirculo1 = xrs.getInt("vpcirculo2");
                this.JCHEstrella1.setSelected(xrs.getBoolean("vpestrella3"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vpestrella3"));
                this.xEstrella1 = xrs.getInt("vpestrella3");
                this.JCHCuadrado.setSelected(xrs.getBoolean("vpcuadrado4"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vpcuadrado4"));
                this.xCuadrado = xrs.getInt("vpcuadrado4");
                this.JCHEstrella2.setSelected(xrs.getBoolean("vpestrella5"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vpestrella5"));
                this.xEstrella2 = xrs.getInt("vpestrella5");
                this.JCHCirculo2.setSelected(xrs.getBoolean("vpcirculo6"));
                mCalculaVisionProfundaAtencionActual(xrs.getBoolean("vpcirculo6"));
                this.xCirculo2 = xrs.getInt("vpcirculo6");
                this.JLClasProf.setText(xrs.getString("vpclasificacion"));
                setValueRadioButton(this.ambliopia, xrs.getString("amb_valor"));
                this.JLClasAmbli.setText(xrs.getString("amb_clasificacion"));
                setValueRadioButton(this.foria, xrs.getString("foria_valor"));
                this.JLClasForia.setText(xrs.getString("foria_clasificacion"));
                setSelectCheckBoxAO(xrs.getInt("vc_ao_81"), this.jCheckBox1);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_81"));
                this.xAO81 = xrs.getInt("vc_ao_81");
                setSelectCheckBoxAO(xrs.getInt("vc_ao_45"), this.jCheckBox2);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_45"));
                this.xAO45 = xrs.getInt("vc_ao_45");
                setSelectCheckBoxAO(xrs.getInt("vc_ao_63"), this.jCheckBox3);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_63"));
                this.xAO63 = xrs.getInt("vc_ao_63");
                setSelectCheckBoxAO(xrs.getInt("vc_ao_27"), this.jCheckBox4);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_27"));
                this.xAO27 = xrs.getInt("vc_ao_27");
                setSelectCheckBoxAO(xrs.getInt("vc_ao_90"), this.jCheckBox5);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_90"));
                this.xAO90 = xrs.getInt("vc_ao_90");
                setSelectCheckBoxAO(xrs.getInt("vc_ao_18"), this.jCheckBox6);
                mCalculaVisionColoresAOAtencionActual(xrs.getInt("vc_ao_18"));
                this.xAO18 = xrs.getInt("vc_ao_18");
                this.JLClasVC_AO.setText(xrs.getString("vc_ao_clasificacion"));
                setSelectCheckBoxAO(xrs.getInt("vc_od_81"), this.jCheckBox7);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_81"));
                this.xOD81 = xrs.getInt("vc_od_81");
                setSelectCheckBoxAO(xrs.getInt("vc_od_45"), this.jCheckBox8);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_45"));
                this.xOD45 = xrs.getInt("vc_od_45");
                setSelectCheckBoxAO(xrs.getInt("vc_od_63"), this.jCheckBox9);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_63"));
                this.xOD63 = xrs.getInt("vc_od_63");
                setSelectCheckBoxAO(xrs.getInt("vc_od_27"), this.jCheckBox10);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_27"));
                this.xOD27 = xrs.getInt("vc_od_27");
                setSelectCheckBoxAO(xrs.getInt("vc_od_90"), this.jCheckBox11);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_90"));
                this.xOD90 = xrs.getInt("vc_od_90");
                setSelectCheckBoxAO(xrs.getInt("vc_od_18"), this.jCheckBox12);
                mCalculaVisionColoresODAtencionActual(xrs.getInt("vc_od_18"));
                this.xOD18 = xrs.getInt("vc_od_18");
                this.JLClasVC_OD.setText(xrs.getString("vc_od_clasificacion"));
                setSelectCheckBoxAO(xrs.getInt("vc_oi_81"), this.jCheckBox13);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_81"));
                this.xOI81 = xrs.getInt("vc_oi_81");
                setSelectCheckBoxAO(xrs.getInt("vc_oi_45"), this.jCheckBox14);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_45"));
                this.xOI45 = xrs.getInt("vc_oi_45");
                setSelectCheckBoxAO(xrs.getInt("vc_oi_63"), this.jCheckBox15);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_63"));
                this.xOI63 = xrs.getInt("vc_oi_63");
                setSelectCheckBoxAO(xrs.getInt("vc_oi_27"), this.jCheckBox16);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_27"));
                this.xOI27 = xrs.getInt("vc_oi_27");
                setSelectCheckBoxAO(xrs.getInt("vc_oi_90"), this.jCheckBox17);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_90"));
                this.xOI90 = xrs.getInt("vc_oi_90");
                setSelectCheckBoxAO(xrs.getInt("vc_oi_18"), this.jCheckBox18);
                mCalculaVisionColoresOIAtencionActual(xrs.getInt("vc_oi_18"));
                this.xOI18 = xrs.getInt("vc_oi_18");
                this.JLClasVC_OI.setText(xrs.getString("vc_oi_clasificacion"));
                this.xJPSo_VisiometriaDistancias.JLLineaAO.setText(xrs.getString("vl_ao_linea"));
                this.xJPSo_VisiometriaDistancias.JLOptotipoAO.setText(xrs.getString("vl_ao_optotipos"));
                this.xJPSo_VisiometriaDistancias.JLNivelAO.setText(xrs.getString("vl_ao_nivel_av"));
                this.xJPSo_VisiometriaDistancias.JCBClaAO.setSelectedItem(xrs.getString("vl_ao_clasificacion"));
                this.xJPSo_VisiometriaDistancias.JLLineaOD.setText(xrs.getString("vl_od_linea"));
                this.xJPSo_VisiometriaDistancias.JLOptotiposOD.setText(xrs.getString("vl_od_optotipos"));
                this.xJPSo_VisiometriaDistancias.JLNivelOD.setText(xrs.getString("vl_od_nivel_av"));
                this.xJPSo_VisiometriaDistancias.JCBClaOD.setSelectedItem(xrs.getString("vl_od_clasificacion"));
                this.xJPSo_VisiometriaDistancias.JLLineaOI.setText(xrs.getString("vl_oi_linea"));
                this.xJPSo_VisiometriaDistancias.JLOptotiposOI.setText(xrs.getString("vl_oi_optotipos"));
                this.xJPSo_VisiometriaDistancias.JLNivelOI.setText(xrs.getString("vl_oi_nivel_av"));
                this.xJPSo_VisiometriaDistancias.JCBClaOI.setSelectedItem(xrs.getString("vl_oi_clasificacion"));
                mLlenaVector("L", xrs.getString("vl_ao_optotipos_selected"), "AO", xrs.getString("vl_ao_linea"));
                mLlenaVector("L", xrs.getString("vl_od_optotipos_selected"), "OD", xrs.getString("vl_od_linea"));
                mLlenaVector("L", xrs.getString("vl_oi_optotipos_selected"), "OI", xrs.getString("vl_oi_linea"));
                this.xJPSo_VisiometriaIntermedia.JLLineaAO.setText(xrs.getString("vi_ao_linea"));
                this.xJPSo_VisiometriaIntermedia.JLOptotipoAO.setText(xrs.getString("vi_ao_optotipos"));
                this.xJPSo_VisiometriaIntermedia.JLNivelAO.setText(xrs.getString("vi_ao_nivel_av"));
                this.xJPSo_VisiometriaIntermedia.JCBClaAO.setSelectedItem(xrs.getString("vi_ao_clasificacion"));
                this.xJPSo_VisiometriaIntermedia.JLLineaOD.setText(xrs.getString("vi_od_linea"));
                this.xJPSo_VisiometriaIntermedia.JLOptotiposOD.setText(xrs.getString("vi_od_optotipos"));
                this.xJPSo_VisiometriaIntermedia.JLNivelOD.setText(xrs.getString("vi_od_nivel_av"));
                this.xJPSo_VisiometriaIntermedia.JCBClaOD.setSelectedItem(xrs.getString("vi_od_clasificacion"));
                this.xJPSo_VisiometriaIntermedia.JLLineaOI.setText(xrs.getString("vi_oi_linea"));
                this.xJPSo_VisiometriaIntermedia.JLOptotiposOI.setText(xrs.getString("vi_oi_optotipos"));
                this.xJPSo_VisiometriaIntermedia.JLNivelOI.setText(xrs.getString("vi_oi_nivel_av"));
                this.xJPSo_VisiometriaIntermedia.JCBClaOI.setSelectedItem(xrs.getString("vi_oi_clasificacion"));
                mLlenaVector("I", xrs.getString("vi_ao_optotipos_selected"), "AO", xrs.getString("vi_ao_linea"));
                mLlenaVector("I", xrs.getString("vi_od_optotipos_selected"), "OD", xrs.getString("vi_od_linea"));
                mLlenaVector("I", xrs.getString("vi_oi_optotipos_selected"), "OI", xrs.getString("vi_oi_linea"));
                this.xJPSo_VisiometriaCercana.JLLineaAO.setText(xrs.getString("vce_ao_linea"));
                this.xJPSo_VisiometriaCercana.JLOptotipoAO.setText(xrs.getString("vce_ao_optotipos"));
                this.xJPSo_VisiometriaCercana.JLNivelAO.setText(xrs.getString("vce_ao_nivel_av"));
                this.xJPSo_VisiometriaCercana.JCBClaAO.setSelectedItem(xrs.getString("vce_ao_clasificacion"));
                this.xJPSo_VisiometriaCercana.JLLineaOD.setText(xrs.getString("vce_od_linea"));
                this.xJPSo_VisiometriaCercana.JLOptotiposOD.setText(xrs.getString("vce_od_optotipos"));
                this.xJPSo_VisiometriaCercana.JLNivelOD.setText(xrs.getString("vce_od_nivel_av"));
                this.xJPSo_VisiometriaCercana.JCBClaOD.setSelectedItem(xrs.getString("vce_od_clasificacion"));
                this.xJPSo_VisiometriaCercana.JLLineaOI.setText(xrs.getString("vce_oi_linea"));
                this.xJPSo_VisiometriaCercana.JLOptotiposOI.setText(xrs.getString("vce_oi_optotipos"));
                this.xJPSo_VisiometriaCercana.JLNivelOI.setText(xrs.getString("vce_oi_nivel_av"));
                this.xJPSo_VisiometriaCercana.JCBClaOI.setSelectedItem(xrs.getString("vce_oi_clasificacion"));
                mLlenaVector("C", xrs.getString("vce_ao_optotipos_selected"), "AO", xrs.getString("vce_ao_linea"));
                mLlenaVector("C", xrs.getString("vce_od_optotipos_selected"), "OD", xrs.getString("vce_od_linea"));
                mLlenaVector("C", xrs.getString("vce_oi_optotipos_selected"), "OI", xrs.getString("vce_oi_linea"));
                this.xatenciong = Long.parseLong(xrs.getString("TipoGuardado"));
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenaVector(String tipovision, String cadena, String ojos, String linea) {
        if (tipovision.equals("L")) {
            if (ojos.equals("AO")) {
                for (int n = 0; n < cadena.length(); n++) {
                    char c = cadena.charAt(n);
                    if (c != ' ') {
                        this.xJPSo_VisiometriaDistancias.AO.add(String.valueOf(c));
                        for (int x = 0; x < this.xJPSo_VisiometriaDistancias.JPAO.getComponentCount(); x++) {
                            if (this.xJPSo_VisiometriaDistancias.JPAO.getComponent(x).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch = this.xJPSo_VisiometriaDistancias.JPAO.getComponent(x);
                                if (xch.getName().equals("AO" + linea) && xch.getText().equals(String.valueOf(c))) {
                                    xch.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OD")) {
                for (int n2 = 0; n2 < cadena.length(); n2++) {
                    char c2 = cadena.charAt(n2);
                    if (c2 != ' ') {
                        this.xJPSo_VisiometriaDistancias.OD.add(String.valueOf(c2));
                        for (int x2 = 0; x2 < this.xJPSo_VisiometriaDistancias.JPOD.getComponentCount(); x2++) {
                            if (this.xJPSo_VisiometriaDistancias.JPOD.getComponent(x2).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch2 = this.xJPSo_VisiometriaDistancias.JPOD.getComponent(x2);
                                if (xch2.getName().equals("OD" + linea) && xch2.getText().equals(String.valueOf(c2))) {
                                    xch2.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OI")) {
                for (int n3 = 0; n3 < cadena.length(); n3++) {
                    char c3 = cadena.charAt(n3);
                    if (c3 != ' ') {
                        this.xJPSo_VisiometriaDistancias.OI.add(String.valueOf(c3));
                        for (int x3 = 0; x3 < this.xJPSo_VisiometriaDistancias.JPOI.getComponentCount(); x3++) {
                            if (this.xJPSo_VisiometriaDistancias.JPOI.getComponent(x3).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch3 = this.xJPSo_VisiometriaDistancias.JPOI.getComponent(x3);
                                if (xch3.getName().equals("OI" + linea) && xch3.getText().equals(String.valueOf(c3))) {
                                    xch3.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        if (tipovision.equals("I")) {
            if (ojos.equals("AO")) {
                for (int n4 = 0; n4 < cadena.length(); n4++) {
                    char c4 = cadena.charAt(n4);
                    if (c4 != ' ') {
                        this.xJPSo_VisiometriaIntermedia.AO.add(String.valueOf(c4));
                        for (int x4 = 0; x4 < this.xJPSo_VisiometriaIntermedia.JPAO.getComponentCount(); x4++) {
                            if (this.xJPSo_VisiometriaIntermedia.JPAO.getComponent(x4).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch4 = this.xJPSo_VisiometriaIntermedia.JPAO.getComponent(x4);
                                if (xch4.getName().equals("AO" + linea) && xch4.getText().equals(String.valueOf(c4))) {
                                    xch4.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OD")) {
                for (int n5 = 0; n5 < cadena.length(); n5++) {
                    char c5 = cadena.charAt(n5);
                    if (c5 != ' ') {
                        this.xJPSo_VisiometriaIntermedia.OD.add(String.valueOf(c5));
                        for (int x5 = 0; x5 < this.xJPSo_VisiometriaIntermedia.JPOD.getComponentCount(); x5++) {
                            if (this.xJPSo_VisiometriaIntermedia.JPOD.getComponent(x5).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch5 = this.xJPSo_VisiometriaIntermedia.JPOD.getComponent(x5);
                                if (xch5.getName().equals("OD" + linea) && xch5.getText().equals(String.valueOf(c5))) {
                                    xch5.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OI")) {
                for (int n6 = 0; n6 < cadena.length(); n6++) {
                    char c6 = cadena.charAt(n6);
                    if (c6 != ' ') {
                        this.xJPSo_VisiometriaIntermedia.OI.add(String.valueOf(c6));
                        for (int x6 = 0; x6 < this.xJPSo_VisiometriaIntermedia.JPOI.getComponentCount(); x6++) {
                            if (this.xJPSo_VisiometriaIntermedia.JPOI.getComponent(x6).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch6 = this.xJPSo_VisiometriaIntermedia.JPOI.getComponent(x6);
                                if (xch6.getName().equals("OI" + linea) && xch6.getText().equals(String.valueOf(c6))) {
                                    xch6.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            return;
        }
        if (tipovision.equals("C")) {
            if (ojos.equals("AO")) {
                for (int n7 = 0; n7 < cadena.length(); n7++) {
                    char c7 = cadena.charAt(n7);
                    if (c7 != ' ') {
                        this.xJPSo_VisiometriaCercana.AO.add(String.valueOf(c7));
                        for (int x7 = 0; x7 < this.xJPSo_VisiometriaCercana.JPAO.getComponentCount(); x7++) {
                            if (this.xJPSo_VisiometriaCercana.JPAO.getComponent(x7).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch7 = this.xJPSo_VisiometriaCercana.JPAO.getComponent(x7);
                                if (xch7.getName().equals("AO" + linea) && xch7.getText().equals(String.valueOf(c7))) {
                                    xch7.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OD")) {
                for (int n8 = 0; n8 < cadena.length(); n8++) {
                    char c8 = cadena.charAt(n8);
                    if (c8 != ' ') {
                        this.xJPSo_VisiometriaCercana.OD.add(String.valueOf(c8));
                        for (int x8 = 0; x8 < this.xJPSo_VisiometriaCercana.JPOD.getComponentCount(); x8++) {
                            if (this.xJPSo_VisiometriaCercana.JPOD.getComponent(x8).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch8 = this.xJPSo_VisiometriaCercana.JPOD.getComponent(x8);
                                if (xch8.getName().equals("OD" + linea) && xch8.getText().equals(String.valueOf(c8))) {
                                    xch8.setSelected(true);
                                }
                            }
                        }
                    }
                }
                return;
            }
            if (ojos.equals("OI")) {
                for (int n9 = 0; n9 < cadena.length(); n9++) {
                    char c9 = cadena.charAt(n9);
                    if (c9 != ' ') {
                        this.xJPSo_VisiometriaCercana.OI.add(String.valueOf(c9));
                        for (int x9 = 0; x9 < this.xJPSo_VisiometriaCercana.JPOI.getComponentCount(); x9++) {
                            if (this.xJPSo_VisiometriaCercana.JPOI.getComponent(x9).getClass().getName().equals("javax.swing.JCheckBox")) {
                                JCheckBox xch9 = this.xJPSo_VisiometriaCercana.JPOI.getComponent(x9);
                                if (xch9.getName().equals("OI" + linea) && xch9.getText().equals(String.valueOf(c9))) {
                                    xch9.setSelected(true);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void setSelectCheckBoxAO(int value, JCheckBox xCheck) {
        if (value == -1 || value == 0) {
            xCheck.setSelected(false);
        } else {
            xCheck.setSelected(true);
        }
    }

    private void mIniciaComponentes() {
        this.xAO81 = -1;
        this.xAO45 = -1;
        this.xAO63 = -1;
        this.xAO27 = -1;
        this.xAO90 = -1;
        this.xAO18 = -1;
        this.xOD81 = -1;
        this.xOD45 = -1;
        this.xOD63 = -1;
        this.xOD27 = -1;
        this.xOD90 = -1;
        this.xOD18 = -1;
        this.xOI81 = -1;
        this.xOI45 = -1;
        this.xOI63 = -1;
        this.xOI27 = -1;
        this.xOI90 = -1;
        this.xOI18 = -1;
        if (this.xJPSo_VisiometriaDistancias == null) {
            this.xJPSo_VisiometriaDistancias = new JPSo_VisiometriaDistancias();
        }
        if (this.xJPSo_VisiometriaIntermedia == null) {
            this.xJPSo_VisiometriaIntermedia = new JPSo_VisiometriaDistancias();
        }
        if (this.xJPSo_VisiometriaCercana == null) {
            this.xJPSo_VisiometriaCercana = new JPSo_VisiometriaDistancias();
        }
        this.xJPSo_VisiometriaDistancias.setVisible(true);
        this.xJPSo_VisiometriaDistancias.setBounds(8, 15, 822, 396);
        this.xJPSo_VisiometriaDistancias.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión Lejana", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPVLejana.add(this.xJPSo_VisiometriaDistancias);
        this.xJPSo_VisiometriaIntermedia.setVisible(true);
        this.xJPSo_VisiometriaIntermedia.setBounds(8, 15, 822, 396);
        this.xJPSo_VisiometriaIntermedia.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión Intermedia", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPVIntermedia.add(this.xJPSo_VisiometriaIntermedia);
        this.xJPSo_VisiometriaCercana.setVisible(true);
        this.xJPSo_VisiometriaCercana.setBounds(8, 15, 822, 396);
        this.xJPSo_VisiometriaCercana.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión Cercana", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPVCercana.add(this.xJPSo_VisiometriaCercana);
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v313, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.vision_prof = new ButtonGroup();
        this.ambliopia = new ButtonGroup();
        this.colores = new ButtonGroup();
        this.foria = new ButtonGroup();
        this.JBG_FiltroCorreccion = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JLClasProf = new JLabel();
        this.jLabel8 = new JLabel();
        this.JCHTriangulo = new JCheckBox();
        this.JCHCirculo = new JCheckBox();
        this.JCHEstrella1 = new JCheckBox();
        this.JCHCuadrado = new JCheckBox();
        this.JCHEstrella2 = new JCheckBox();
        this.JCHCirculo2 = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.JRBamb1 = new JRadioButton();
        this.JRBamb2 = new JRadioButton();
        this.JRBamb3 = new JRadioButton();
        this.JRBamb4 = new JRadioButton();
        this.JRBamb5 = new JRadioButton();
        this.JLClasAmbli = new JLabel();
        this.jPanel5 = new JPanel();
        this.JRBColor7 = new JRadioButton();
        this.JRBColor8 = new JRadioButton();
        this.JRBColor9 = new JRadioButton();
        this.JRBColor10 = new JRadioButton();
        this.JRBColor11 = new JRadioButton();
        this.JRBColor12 = new JRadioButton();
        this.JRBColor13 = new JRadioButton();
        this.JRBColor14 = new JRadioButton();
        this.JRBColor15 = new JRadioButton();
        this.JRBColor16 = new JRadioButton();
        this.JRBColor17 = new JRadioButton();
        this.JRBColor18 = new JRadioButton();
        this.JRBColor19 = new JRadioButton();
        this.JRBColor20 = new JRadioButton();
        this.JRBColor21 = new JRadioButton();
        this.JRBColor22 = new JRadioButton();
        this.JRBColor23 = new JRadioButton();
        this.JRBColor24 = new JRadioButton();
        this.JRBColor25 = new JRadioButton();
        this.JRBColor26 = new JRadioButton();
        this.JLClasForia = new JLabel();
        this.JPVisionColores = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.JLClasVC_AO = new JLabel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jLabel1 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jCheckBox7 = new JCheckBox();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        this.jCheckBox11 = new JCheckBox();
        this.jCheckBox12 = new JCheckBox();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.jLabel16 = new JLabel();
        this.jCheckBox13 = new JCheckBox();
        this.jLabel17 = new JLabel();
        this.jCheckBox14 = new JCheckBox();
        this.jLabel18 = new JLabel();
        this.jCheckBox15 = new JCheckBox();
        this.jLabel19 = new JLabel();
        this.jCheckBox16 = new JCheckBox();
        this.jLabel20 = new JLabel();
        this.jCheckBox17 = new JCheckBox();
        this.jLabel21 = new JLabel();
        this.jCheckBox18 = new JCheckBox();
        this.jLabel22 = new JLabel();
        this.jSeparator2 = new JSeparator();
        this.JLClasVC_OD = new JLabel();
        this.JLClasVC_OI = new JLabel();
        this.JCH_SinCorrecion = new JCheckBox();
        this.JCH_ConCorrecion = new JCheckBox();
        this.JPVLejana = new JPanel();
        this.JPVIntermedia = new JPanel();
        this.JPVCercana = new JPanel();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTHistoricoDetalle = new JTable();
        setName("xjpVisiometriaM");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión profundidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JLClasProf.setFont(new Font("Arial", 1, 14));
        this.JLClasProf.setForeground(Color.red);
        this.JLClasProf.setHorizontalAlignment(0);
        this.JLClasProf.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jLabel8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/visiometria-vision-profundidad.PNG")));
        this.JCHTriangulo.setFont(new Font("Arial", 1, 12));
        this.JCHTriangulo.setForeground(Color.blue);
        this.JCHTriangulo.setText("1");
        this.JCHTriangulo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.1
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHTrianguloActionPerformed(evt);
            }
        });
        this.JCHCirculo.setFont(new Font("Arial", 1, 12));
        this.JCHCirculo.setForeground(Color.blue);
        this.JCHCirculo.setText("2");
        this.JCHCirculo.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.2
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHCirculoActionPerformed(evt);
            }
        });
        this.JCHEstrella1.setFont(new Font("Arial", 1, 12));
        this.JCHEstrella1.setForeground(Color.blue);
        this.JCHEstrella1.setText("3");
        this.JCHEstrella1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.3
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHEstrella1ActionPerformed(evt);
            }
        });
        this.JCHCuadrado.setFont(new Font("Arial", 1, 12));
        this.JCHCuadrado.setForeground(Color.blue);
        this.JCHCuadrado.setText("4");
        this.JCHCuadrado.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.4
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHCuadradoActionPerformed(evt);
            }
        });
        this.JCHEstrella2.setFont(new Font("Arial", 1, 12));
        this.JCHEstrella2.setForeground(Color.blue);
        this.JCHEstrella2.setText("5");
        this.JCHEstrella2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.5
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHEstrella2ActionPerformed(evt);
            }
        });
        this.JCHCirculo2.setFont(new Font("Arial", 1, 12));
        this.JCHCirculo2.setForeground(Color.blue);
        this.JCHCirculo2.setText("6");
        this.JCHCirculo2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.6
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JCHCirculo2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.JCHTriangulo).addGap(53, 53, 53).addComponent(this.JCHCirculo).addGap(37, 37, 37).addComponent(this.JCHEstrella1).addGap(28, 28, 28).addComponent(this.JCHCuadrado).addGap(33, 33, 33).addComponent(this.JCHEstrella2).addGap(32, 32, 32).addComponent(this.JCHCirculo2)).addComponent(this.jLabel8)).addGap(25, 25, 25).addComponent(this.JLClasProf, -2, 214, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHTriangulo).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCirculo).addComponent(this.JCHEstrella1).addComponent(this.JCHCuadrado).addComponent(this.JCHEstrella2).addComponent(this.JCHCirculo2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8, -2, 63, -2).addComponent(this.JLClasProf, -2, 60, -2)).addContainerGap(-1, 32767)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Ambliopia", 0, 0, new Font("Arial", 1, 12), new Color(1, 102, 0)));
        this.ambliopia.add(this.JRBamb1);
        this.JRBamb1.setFont(new Font("Arial", 1, 12));
        this.JRBamb1.setForeground(Color.blue);
        this.JRBamb1.setText("2");
        this.JRBamb1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.7
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JRBamb1ActionPerformed(evt);
            }
        });
        this.ambliopia.add(this.JRBamb2);
        this.JRBamb2.setFont(new Font("Arial", 1, 12));
        this.JRBamb2.setForeground(Color.blue);
        this.JRBamb2.setText("3");
        this.JRBamb2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.8
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JRBamb2ActionPerformed(evt);
            }
        });
        this.ambliopia.add(this.JRBamb3);
        this.JRBamb3.setFont(new Font("Arial", 1, 18));
        this.JRBamb3.setForeground(Color.red);
        this.JRBamb3.setText("4");
        this.JRBamb3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.9
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JRBamb3ActionPerformed(evt);
            }
        });
        this.ambliopia.add(this.JRBamb4);
        this.JRBamb4.setFont(new Font("Arial", 1, 12));
        this.JRBamb4.setForeground(Color.blue);
        this.JRBamb4.setText("5");
        this.JRBamb4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.10
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JRBamb4ActionPerformed(evt);
            }
        });
        this.ambliopia.add(this.JRBamb5);
        this.JRBamb5.setFont(new Font("Arial", 1, 12));
        this.JRBamb5.setForeground(Color.blue);
        this.JRBamb5.setText("6");
        this.JRBamb5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.11
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.JRBamb5ActionPerformed(evt);
            }
        });
        this.JLClasAmbli.setFont(new Font("Arial", 1, 14));
        this.JLClasAmbli.setForeground(Color.red);
        this.JLClasAmbli.setHorizontalAlignment(0);
        this.JLClasAmbli.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.JRBamb1).addGap(18, 18, 18).addComponent(this.JRBamb2).addGap(18, 18, 18).addComponent(this.JRBamb3).addGap(18, 18, 18).addComponent(this.JRBamb4).addGap(18, 18, 18).addComponent(this.JRBamb5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLClasAmbli, -2, 214, -2).addGap(83, 83, 83)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBamb1).addComponent(this.JRBamb2).addComponent(this.JRBamb3).addComponent(this.JRBamb4).addComponent(this.JRBamb5)).addGap(0, 0, 32767)).addComponent(this.JLClasAmbli, -1, 53, 32767)).addGap(5, 5, 5)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "Forias", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.foria.add(this.JRBColor7);
        this.JRBColor7.setFont(new Font("Arial", 1, 12));
        this.JRBColor7.setForeground(Color.blue);
        this.JRBColor7.setText("A");
        this.JRBColor7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.12
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor8);
        this.JRBColor8.setFont(new Font("Arial", 1, 12));
        this.JRBColor8.setForeground(Color.blue);
        this.JRBColor8.setText("B");
        this.JRBColor8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.13
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor9);
        this.JRBColor9.setFont(new Font("Arial", 1, 12));
        this.JRBColor9.setForeground(Color.blue);
        this.JRBColor9.setText("C");
        this.JRBColor9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.14
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor10);
        this.JRBColor10.setFont(new Font("Arial", 1, 12));
        this.JRBColor10.setForeground(Color.blue);
        this.JRBColor10.setText("D");
        this.JRBColor10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.15
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor11);
        this.JRBColor11.setFont(new Font("Arial", 1, 12));
        this.JRBColor11.setForeground(Color.blue);
        this.JRBColor11.setText("E");
        this.JRBColor11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.16
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.JRBColor12.setBackground(new Color(255, 255, 255));
        this.foria.add(this.JRBColor12);
        this.JRBColor12.setFont(new Font("Arial", 1, 14));
        this.JRBColor12.setForeground(Color.red);
        this.JRBColor12.setText("F");
        this.JRBColor12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.17
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetNormalForia(evt);
            }
        });
        this.JRBColor13.setBackground(new Color(255, 255, 255));
        this.foria.add(this.JRBColor13);
        this.JRBColor13.setFont(new Font("Arial", 1, 14));
        this.JRBColor13.setForeground(Color.red);
        this.JRBColor13.setText("G");
        this.JRBColor13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.18
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetNormalForia(evt);
            }
        });
        this.JRBColor14.setBackground(new Color(255, 255, 255));
        this.foria.add(this.JRBColor14);
        this.JRBColor14.setFont(new Font("Arial", 1, 14));
        this.JRBColor14.setForeground(Color.red);
        this.JRBColor14.setText("H");
        this.JRBColor14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.19
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetNormalForia(evt);
            }
        });
        this.JRBColor15.setBackground(new Color(255, 255, 255));
        this.foria.add(this.JRBColor15);
        this.JRBColor15.setFont(new Font("Arial", 1, 14));
        this.JRBColor15.setForeground(Color.red);
        this.JRBColor15.setText("I");
        this.JRBColor15.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.20
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetNormalForia(evt);
            }
        });
        this.JRBColor16.setBackground(new Color(255, 255, 255));
        this.foria.add(this.JRBColor16);
        this.JRBColor16.setFont(new Font("Arial", 1, 14));
        this.JRBColor16.setForeground(Color.red);
        this.JRBColor16.setText("J");
        this.JRBColor16.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.21
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetNormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor17);
        this.JRBColor17.setFont(new Font("Arial", 1, 12));
        this.JRBColor17.setForeground(Color.blue);
        this.JRBColor17.setText("K");
        this.JRBColor17.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.22
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor18);
        this.JRBColor18.setFont(new Font("Arial", 1, 12));
        this.JRBColor18.setForeground(Color.blue);
        this.JRBColor18.setText("L");
        this.JRBColor18.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.23
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor19);
        this.JRBColor19.setFont(new Font("Arial", 1, 12));
        this.JRBColor19.setForeground(Color.blue);
        this.JRBColor19.setText("M");
        this.JRBColor19.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.24
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor20);
        this.JRBColor20.setFont(new Font("Arial", 1, 12));
        this.JRBColor20.setForeground(Color.blue);
        this.JRBColor20.setText("N");
        this.JRBColor20.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.25
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor21);
        this.JRBColor21.setFont(new Font("Arial", 1, 12));
        this.JRBColor21.setForeground(Color.blue);
        this.JRBColor21.setText("O");
        this.JRBColor21.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.26
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor22);
        this.JRBColor22.setFont(new Font("Arial", 1, 12));
        this.JRBColor22.setForeground(Color.blue);
        this.JRBColor22.setText("P");
        this.JRBColor22.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.27
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor23);
        this.JRBColor23.setFont(new Font("Arial", 1, 12));
        this.JRBColor23.setForeground(Color.blue);
        this.JRBColor23.setText("Q");
        this.JRBColor23.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.28
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor24);
        this.JRBColor24.setFont(new Font("Arial", 1, 12));
        this.JRBColor24.setForeground(Color.blue);
        this.JRBColor24.setText("R");
        this.JRBColor24.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.29
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor25);
        this.JRBColor25.setFont(new Font("Arial", 1, 12));
        this.JRBColor25.setForeground(Color.blue);
        this.JRBColor25.setText("S");
        this.JRBColor25.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.30
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.foria.add(this.JRBColor26);
        this.JRBColor26.setFont(new Font("Arial", 1, 12));
        this.JRBColor26.setForeground(Color.blue);
        this.JRBColor26.setText("T");
        this.JRBColor26.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.31
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.actionEventSetAnormalForia(evt);
            }
        });
        this.JLClasForia.setFont(new Font("Arial", 1, 14));
        this.JLClasForia.setForeground(Color.red);
        this.JLClasForia.setHorizontalAlignment(0);
        this.JLClasForia.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLClasForia, -1, -1, 32767).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JRBColor7).addGap(0, 0, 0).addComponent(this.JRBColor8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor13))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor14).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor15).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor16).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor17).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor19).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor20).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor22).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor23).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor24).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor25).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBColor26).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBColor7).addComponent(this.JRBColor8).addComponent(this.JRBColor9).addComponent(this.JRBColor10).addComponent(this.JRBColor11).addComponent(this.JRBColor12).addComponent(this.JRBColor13).addComponent(this.JRBColor14).addComponent(this.JRBColor15).addComponent(this.JRBColor16).addComponent(this.JRBColor17).addComponent(this.JRBColor18).addComponent(this.JRBColor19).addComponent(this.JRBColor20).addComponent(this.JRBColor21).addComponent(this.JRBColor22).addComponent(this.JRBColor23).addComponent(this.JRBColor24).addComponent(this.JRBColor25).addComponent(this.JRBColor26)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLClasForia, -1, 48, 32767).addContainerGap()));
        this.JPVisionColores.setBorder(BorderFactory.createTitledBorder((Border) null, "Visión colores", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setText("81");
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setText("45");
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setText("63");
        this.jLabel5.setFont(new Font("Arial", 1, 14));
        this.jLabel5.setText("27");
        this.jLabel6.setFont(new Font("Arial", 1, 14));
        this.jLabel6.setText("90");
        this.jLabel7.setFont(new Font("Arial", 1, 14));
        this.jLabel7.setText("18");
        this.JLClasVC_AO.setFont(new Font("Arial", 1, 14));
        this.JLClasVC_AO.setForeground(Color.red);
        this.JLClasVC_AO.setHorizontalAlignment(0);
        this.JLClasVC_AO.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLClasVC_AO.setName("");
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(Color.blue);
        this.jCheckBox1.setText("1");
        this.jCheckBox1.setName("AO1");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.32
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(Color.blue);
        this.jCheckBox2.setText("2");
        this.jCheckBox2.setName("AO2");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.33
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox2ActionPerformed(evt);
            }
        });
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(Color.blue);
        this.jCheckBox3.setText("3");
        this.jCheckBox3.setName("AO3");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.34
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox3ActionPerformed(evt);
            }
        });
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(Color.blue);
        this.jCheckBox4.setText("4");
        this.jCheckBox4.setName("AO4");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.35
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox4ActionPerformed(evt);
            }
        });
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(Color.blue);
        this.jCheckBox5.setText("5");
        this.jCheckBox5.setName("AO5");
        this.jCheckBox5.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.36
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox5ActionPerformed(evt);
            }
        });
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(Color.blue);
        this.jCheckBox6.setText("6");
        this.jCheckBox6.setName("AO6");
        this.jCheckBox6.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.37
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox6ActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 18));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setText("AO");
        this.jLabel9.setFont(new Font("Arial", 1, 18));
        this.jLabel9.setForeground(Color.red);
        this.jLabel9.setText("OD");
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(Color.blue);
        this.jCheckBox7.setText("1");
        this.jCheckBox7.setName("OD1");
        this.jCheckBox7.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.38
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox7ActionPerformed(evt);
            }
        });
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(Color.blue);
        this.jCheckBox8.setText("2");
        this.jCheckBox8.setName("OD2");
        this.jCheckBox8.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.39
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox8ActionPerformed(evt);
            }
        });
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(Color.blue);
        this.jCheckBox9.setText("3");
        this.jCheckBox9.setName("OD3");
        this.jCheckBox9.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.40
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox9ActionPerformed(evt);
            }
        });
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(Color.blue);
        this.jCheckBox10.setText("4");
        this.jCheckBox10.setName("OD4");
        this.jCheckBox10.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.41
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox10ActionPerformed(evt);
            }
        });
        this.jCheckBox11.setFont(new Font("Arial", 1, 12));
        this.jCheckBox11.setForeground(Color.blue);
        this.jCheckBox11.setText("5");
        this.jCheckBox11.setName("OD5");
        this.jCheckBox11.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.42
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox11ActionPerformed(evt);
            }
        });
        this.jCheckBox12.setFont(new Font("Arial", 1, 12));
        this.jCheckBox12.setForeground(Color.blue);
        this.jCheckBox12.setText("6");
        this.jCheckBox12.setName("OD6");
        this.jCheckBox12.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.43
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox12ActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 14));
        this.jLabel10.setText("18");
        this.jLabel11.setFont(new Font("Arial", 1, 14));
        this.jLabel11.setText("90");
        this.jLabel12.setFont(new Font("Arial", 1, 14));
        this.jLabel12.setText("27");
        this.jLabel13.setFont(new Font("Arial", 1, 14));
        this.jLabel13.setText("63");
        this.jLabel14.setFont(new Font("Arial", 1, 14));
        this.jLabel14.setText("45");
        this.jLabel15.setFont(new Font("Arial", 1, 14));
        this.jLabel15.setText("81");
        this.jLabel16.setFont(new Font("Arial", 1, 18));
        this.jLabel16.setForeground(Color.red);
        this.jLabel16.setText("OI");
        this.jCheckBox13.setFont(new Font("Arial", 1, 12));
        this.jCheckBox13.setForeground(Color.blue);
        this.jCheckBox13.setText("1");
        this.jCheckBox13.setName("OI1");
        this.jCheckBox13.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.44
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox13ActionPerformed(evt);
            }
        });
        this.jLabel17.setFont(new Font("Arial", 1, 14));
        this.jLabel17.setText("81");
        this.jCheckBox14.setFont(new Font("Arial", 1, 12));
        this.jCheckBox14.setForeground(Color.blue);
        this.jCheckBox14.setText("2");
        this.jCheckBox14.setName("OI2");
        this.jCheckBox14.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.45
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox14ActionPerformed(evt);
            }
        });
        this.jLabel18.setFont(new Font("Arial", 1, 14));
        this.jLabel18.setText("45");
        this.jCheckBox15.setFont(new Font("Arial", 1, 12));
        this.jCheckBox15.setForeground(Color.blue);
        this.jCheckBox15.setText("3");
        this.jCheckBox15.setName("OI3");
        this.jCheckBox15.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.46
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox15ActionPerformed(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 14));
        this.jLabel19.setText("63");
        this.jCheckBox16.setFont(new Font("Arial", 1, 12));
        this.jCheckBox16.setForeground(Color.blue);
        this.jCheckBox16.setText("4");
        this.jCheckBox16.setName("OI4");
        this.jCheckBox16.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.47
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox16ActionPerformed(evt);
            }
        });
        this.jLabel20.setFont(new Font("Arial", 1, 14));
        this.jLabel20.setText("27");
        this.jCheckBox17.setFont(new Font("Arial", 1, 12));
        this.jCheckBox17.setForeground(Color.blue);
        this.jCheckBox17.setText("5");
        this.jCheckBox17.setName("OI5");
        this.jCheckBox17.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.48
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox17ActionPerformed(evt);
            }
        });
        this.jLabel21.setFont(new Font("Arial", 1, 14));
        this.jLabel21.setText("90");
        this.jCheckBox18.setFont(new Font("Arial", 1, 12));
        this.jCheckBox18.setForeground(Color.blue);
        this.jCheckBox18.setText("6");
        this.jCheckBox18.setName("OI6");
        this.jCheckBox18.addActionListener(new ActionListener() { // from class: Historia.JPSo_VisiometriaMineros.49
            public void actionPerformed(ActionEvent evt) {
                JPSo_VisiometriaMineros.this.jCheckBox18ActionPerformed(evt);
            }
        });
        this.jLabel22.setFont(new Font("Arial", 1, 14));
        this.jLabel22.setText("18");
        this.JLClasVC_OD.setFont(new Font("Arial", 1, 14));
        this.JLClasVC_OD.setForeground(Color.red);
        this.JLClasVC_OD.setHorizontalAlignment(0);
        this.JLClasVC_OD.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLClasVC_OD.setName("");
        this.JLClasVC_OI.setFont(new Font("Arial", 1, 14));
        this.JLClasVC_OI.setForeground(Color.red);
        this.JLClasVC_OI.setHorizontalAlignment(0);
        this.JLClasVC_OI.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JLClasVC_OI.setName("");
        GroupLayout JPVisionColoresLayout = new GroupLayout(this.JPVisionColores);
        this.JPVisionColores.setLayout(JPVisionColoresLayout);
        JPVisionColoresLayout.setHorizontalGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(28, 28, 28).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSeparator2, -2, 651, -2).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jLabel16).addGap(18, 18, 18).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jLabel17)).addComponent(this.jCheckBox13)).addGap(30, 30, 30).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jLabel18).addGap(48, 48, 48).addComponent(this.jLabel19)).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jCheckBox14).addGap(30, 30, 30).addComponent(this.jCheckBox15))).addGap(30, 30, 30).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jLabel20).addGap(45, 45, 45).addComponent(this.jLabel21)).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jCheckBox16).addGap(30, 30, 30).addComponent(this.jCheckBox17))).addGap(30, 30, 30).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel22).addComponent(this.jCheckBox18)).addGap(41, 41, 41).addComponent(this.JLClasVC_OI, -2, 214, -2)).addComponent(this.jSeparator1, -2, 651, -2).addGroup(JPVisionColoresLayout.createSequentialGroup().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jLabel1).addGap(10, 10, 10).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jLabel2).addGap(45, 45, 45).addComponent(this.jLabel3).addGap(45, 45, 45).addComponent(this.jLabel4).addGap(45, 45, 45).addComponent(this.jLabel5).addGap(45, 45, 45).addComponent(this.jLabel6).addGap(48, 48, 48).addComponent(this.jLabel7)).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jCheckBox1).addGap(30, 30, 30).addComponent(this.jCheckBox2).addGap(30, 30, 30).addComponent(this.jCheckBox3).addGap(30, 30, 30).addComponent(this.jCheckBox4).addGap(30, 30, 30).addComponent(this.jCheckBox5).addGap(30, 30, 30).addComponent(this.jCheckBox6)))).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jLabel9).addGap(10, 10, 10).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jLabel15).addGap(45, 45, 45).addComponent(this.jLabel14).addGap(45, 45, 45).addComponent(this.jLabel13).addGap(45, 45, 45).addComponent(this.jLabel12).addGap(45, 45, 45).addComponent(this.jLabel11).addGap(48, 48, 48).addComponent(this.jLabel10)).addGroup(JPVisionColoresLayout.createSequentialGroup().addComponent(this.jCheckBox7).addGap(30, 30, 30).addComponent(this.jCheckBox8).addGap(30, 30, 30).addComponent(this.jCheckBox9).addGap(30, 30, 30).addComponent(this.jCheckBox10).addGap(30, 30, 30).addComponent(this.jCheckBox11).addGap(30, 30, 30).addComponent(this.jCheckBox12))))).addGap(38, 38, 38).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLClasVC_AO, -2, 214, -2).addComponent(this.JLClasVC_OD, -2, 214, -2)))).addContainerGap(228, 32767)));
        JPVisionColoresLayout.setVerticalGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addContainerGap().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4).addComponent(this.jCheckBox5).addComponent(this.jCheckBox6)).addGap(5, 5, 5).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7))).addComponent(this.jLabel1, -2, 40, -2))).addComponent(this.JLClasVC_AO, -2, 49, -2)).addGap(3, 3, 3).addComponent(this.jSeparator1, -2, -1, -2).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox7).addComponent(this.jCheckBox8).addComponent(this.jCheckBox9).addComponent(this.jCheckBox10).addComponent(this.jCheckBox11).addComponent(this.jCheckBox12)).addGap(5, 5, 5).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.jLabel14).addComponent(this.jLabel13).addComponent(this.jLabel12).addComponent(this.jLabel11).addComponent(this.jLabel10))).addComponent(this.jLabel9, -2, 40, -2)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, JPVisionColoresLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLClasVC_OD, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.jSeparator2, -2, -1, -2).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVisionColoresLayout.createSequentialGroup().addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox13).addComponent(this.jCheckBox14).addComponent(this.jCheckBox15).addComponent(this.jCheckBox16).addComponent(this.jCheckBox17).addComponent(this.jCheckBox18)).addGap(5, 5, 5).addGroup(JPVisionColoresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel17).addComponent(this.jLabel18).addComponent(this.jLabel19).addComponent(this.jLabel20).addComponent(this.jLabel21).addComponent(this.jLabel22))).addComponent(this.jLabel16, -2, 40, -2))).addGroup(JPVisionColoresLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLClasVC_OI, -2, 49, -2))).addContainerGap(-1, 32767)));
        this.JBG_FiltroCorreccion.add(this.JCH_SinCorrecion);
        this.JCH_SinCorrecion.setFont(new Font("Arial", 1, 12));
        this.JCH_SinCorrecion.setSelected(true);
        this.JCH_SinCorrecion.setText("Sin Correción");
        this.JBG_FiltroCorreccion.add(this.JCH_ConCorrecion);
        this.JCH_ConCorrecion.setFont(new Font("Arial", 1, 12));
        this.JCH_ConCorrecion.setText("Con Correción");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.JPVisionColores, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCH_SinCorrecion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_ConCorrecion).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_SinCorrecion).addComponent(this.JCH_ConCorrecion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addComponent(this.jPanel1, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPVisionColores, -2, 209, -2).addContainerGap()));
        this.jTabbedPane1.addTab("PARTE 1", this.jPanel2);
        GroupLayout JPVLejanaLayout = new GroupLayout(this.JPVLejana);
        this.JPVLejana.setLayout(JPVLejanaLayout);
        JPVLejanaLayout.setHorizontalGroup(JPVLejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 956, 32767));
        JPVLejanaLayout.setVerticalGroup(JPVLejanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 577, 32767));
        this.jTabbedPane1.addTab("VISIÓN LEJANA", this.JPVLejana);
        GroupLayout JPVIntermediaLayout = new GroupLayout(this.JPVIntermedia);
        this.JPVIntermedia.setLayout(JPVIntermediaLayout);
        JPVIntermediaLayout.setHorizontalGroup(JPVIntermediaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 956, 32767));
        JPVIntermediaLayout.setVerticalGroup(JPVIntermediaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 577, 32767));
        this.jTabbedPane1.addTab("VISIÓN INTERMEDIA", this.JPVIntermedia);
        GroupLayout JPVCercanaLayout = new GroupLayout(this.JPVCercana);
        this.JPVCercana.setLayout(JPVCercanaLayout);
        JPVCercanaLayout.setHorizontalGroup(JPVCercanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 956, 32767));
        JPVCercanaLayout.setVerticalGroup(JPVCercanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 577, 32767));
        this.jTabbedPane1.addTab("VISIÓN CERCANA", this.JPVCercana);
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistoricoDetalle.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoDetalle.setSelectionForeground(Color.red);
        this.JTHistoricoDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPSo_VisiometriaMineros.50
            public void mouseClicked(MouseEvent evt) {
                JPSo_VisiometriaMineros.this.JTHistoricoDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTHistoricoDetalle);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 944, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 281, -2).addContainerGap(285, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel3);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBamb1ActionPerformed(ActionEvent evt) {
        this.xAmbi = 2;
        this.JLClasAmbli.setText("ANORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBamb2ActionPerformed(ActionEvent evt) {
        this.xAmbi = 3;
        this.JLClasAmbli.setText("ANORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBamb3ActionPerformed(ActionEvent evt) {
        this.xAmbi = 4;
        this.JLClasAmbli.setText("NORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBamb4ActionPerformed(ActionEvent evt) {
        this.xAmbi = 5;
        this.JLClasAmbli.setText("ANORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBamb5ActionPerformed(ActionEvent evt) {
        this.xAmbi = 6;
        this.JLClasAmbli.setText("ANORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTrianguloActionPerformed(ActionEvent evt) {
        if (this.JCHTriangulo.isSelected()) {
            this.xTriangulo = 1;
        } else {
            this.xTriangulo = 0;
        }
        mCalculaVisionProfunda(this.JCHTriangulo.isSelected());
    }

    private void mCalculaVisionColoresAO(boolean xvalor) {
        if (xvalor) {
            this.xColoresAO++;
        } else {
            this.xColoresAO--;
        }
        if (this.xColoresAO == 6) {
            this.JLClasVC_AO.setText("NORMAL");
        } else if (this.xColoresAO >= 1 && this.xColoresAO <= 5) {
            this.JLClasVC_AO.setText("ANORMAL");
        } else {
            this.JLClasVC_AO.setText("");
        }
    }

    private void mCalculaVisionColoresAOAtencionActual(int xvalor) {
        if (xvalor == 1) {
            this.xColoresAO++;
        }
    }

    private void mCalculaVisionColoresODAtencionActual(int xvalor) {
        if (xvalor == 1) {
            this.xColoresOD++;
        }
    }

    private void mCalculaVisionColoresOIAtencionActual(int xvalor) {
        if (xvalor == 1) {
            this.xColoresOI++;
        }
    }

    private void mCalculaVisionProfundaOD(boolean xvalor) {
        if (xvalor) {
            this.xColoresOD++;
        } else {
            this.xColoresOD--;
        }
        if (this.xColoresOD == 6) {
            this.JLClasVC_OD.setText("NORMAL");
        } else if (this.xColoresOD >= 1 && this.xColoresOD <= 5) {
            this.JLClasVC_OD.setText("ANORMAL");
        } else {
            this.JLClasVC_OD.setText("");
        }
    }

    private void mCalculaVisionProfundaOI(boolean xvalor) {
        if (xvalor) {
            this.xColoresOI++;
        } else {
            this.xColoresOI--;
        }
        if (this.xColoresOI == 6) {
            this.JLClasVC_OI.setText("NORMAL");
        } else if (this.xColoresOI >= 1 && this.xColoresOI <= 5) {
            this.JLClasVC_OI.setText("ANORMAL");
        } else {
            this.JLClasVC_OI.setText("");
        }
    }

    private void mCalculaVisionProfunda(boolean xvalor) {
        if (xvalor) {
            this.xVProf++;
        } else {
            this.xVProf--;
        }
        if (this.xVProf >= 4) {
            this.JLClasProf.setText("NORMAL");
        } else {
            this.JLClasProf.setText("ANORMAL");
        }
    }

    private void mCalculaVisionProfundaAtencionActual(boolean xvalor) {
        if (xvalor) {
            this.xVProf++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCirculoActionPerformed(ActionEvent evt) {
        if (this.JCHCirculo.isSelected()) {
            this.xCirculo1 = 1;
        } else {
            this.xCirculo1 = 0;
        }
        mCalculaVisionProfunda(this.JCHCirculo.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstrella1ActionPerformed(ActionEvent evt) {
        if (this.JCHEstrella1.isSelected()) {
            this.xEstrella1 = 1;
        } else {
            this.xEstrella1 = 0;
        }
        mCalculaVisionProfunda(this.JCHEstrella1.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCuadradoActionPerformed(ActionEvent evt) {
        if (this.JCHCuadrado.isSelected()) {
            this.xCuadrado = 1;
        } else {
            this.xCuadrado = 0;
        }
        mCalculaVisionProfunda(this.JCHCuadrado.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstrella2ActionPerformed(ActionEvent evt) {
        if (this.JCHEstrella2.isSelected()) {
            this.xEstrella2 = 1;
        } else {
            this.xEstrella2 = 0;
        }
        mCalculaVisionProfunda(this.JCHEstrella2.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCirculo2ActionPerformed(ActionEvent evt) {
        if (this.JCHCirculo2.isSelected()) {
            this.xCirculo2 = 1;
        } else {
            this.xCirculo2 = 0;
        }
        mCalculaVisionProfunda(this.JCHCirculo2.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox1.isSelected()) {
            this.xAO81 = 1;
        } else {
            this.xAO81 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox1.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox2ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox2.isSelected()) {
            this.xAO45 = 1;
        } else {
            this.xAO45 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox2.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox3ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox3.isSelected()) {
            this.xAO63 = 1;
        } else {
            this.xAO63 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox3.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox4ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox4.isSelected()) {
            this.xAO27 = 1;
        } else {
            this.xAO27 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox4.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox5ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox5.isSelected()) {
            this.xAO90 = 1;
        } else {
            this.xAO90 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox5.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox6ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox6.isSelected()) {
            this.xAO18 = 1;
        } else {
            this.xAO18 = 0;
        }
        mCalculaVisionColoresAO(this.jCheckBox6.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox7ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox7.isSelected()) {
            this.xOD81 = 1;
        } else {
            this.xOD81 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox7.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox8ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox8.isSelected()) {
            this.xOD45 = 1;
        } else {
            this.xOD45 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox8.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox9ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox9.isSelected()) {
            this.xOD63 = 1;
        } else {
            this.xOD63 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox9.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox10ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox10.isSelected()) {
            this.xOD27 = 1;
        } else {
            this.xOD27 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox10.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox11ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox11.isSelected()) {
            this.xOD90 = 1;
        } else {
            this.xOD90 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox11.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox12ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox12.isSelected()) {
            this.xOD18 = 1;
        } else {
            this.xOD18 = 0;
        }
        mCalculaVisionProfundaOD(this.jCheckBox12.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox13ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox13.isSelected()) {
            this.xOI81 = 1;
        } else {
            this.xOI81 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox13.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox14ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox14.isSelected()) {
            this.xOI45 = 1;
        } else {
            this.xOI45 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox14.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox15ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox15.isSelected()) {
            this.xOI63 = 1;
        } else {
            this.xOI63 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox15.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox16ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox16.isSelected()) {
            this.xOI27 = 1;
        } else {
            this.xOI27 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox16.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox17ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox17.isSelected()) {
            this.xOI90 = 1;
        } else {
            this.xOI90 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox17.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox18ActionPerformed(ActionEvent evt) {
        if (this.jCheckBox18.isSelected()) {
            this.xOI18 = 1;
        } else {
            this.xOI18 = 0;
        }
        mCalculaVisionProfundaOI(this.jCheckBox18.isSelected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionEventSetAnormalForia(ActionEvent evt) {
        this.JLClasForia.setText("ANORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actionEventSetNormalForia(ActionEvent evt) {
        this.JLClasForia.setText("NORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mImprimir(this.xmodelo.getValueAt(this.JTHistoricoDetalle.getSelectedRow(), 3).toString());
        }
    }

    private String mOptotiposSelected(ArrayList<String> xList) {
        StringBuilder cadena = new StringBuilder();
        for (int i = 0; i < xList.size(); i++) {
            cadena.append(xList.get(i)).append(" ");
        }
        String optotipos = cadena.toString();
        return optotipos;
    }

    private void mImprimir(String xidVisiometria) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdVisiometria";
        mparametros[0][1] = String.valueOf(xidVisiometria);
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_So_Visiometria_Mineros", mparametros);
    }

    public void mGuardar() {
        String mensaje;
        int correccion;
        String sql;
        if (this.xatenciong == 0) {
            if (!this.xidVisiometia.equals("")) {
                mensaje = "Esta seguro de actualizar?";
            } else {
                mensaje = "Esta seguro de grabar?";
            }
            if (!this.JLClasProf.getText().isEmpty()) {
                if (!this.JLClasAmbli.getText().isEmpty()) {
                    if (!this.JLClasForia.getText().isEmpty()) {
                        int n = JOptionPane.showConfirmDialog(this, mensaje, "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            mVerificaSeleccionVisionColores();
                            if (this.JCH_ConCorrecion.isSelected()) {
                                correccion = 1;
                            } else {
                                correccion = 0;
                            }
                            if (!this.xidVisiometia.equals("")) {
                                sql = " UPDATE h_so_visiometria_m SET \n vptriangulo1='" + this.xTriangulo + "', correccion='" + correccion + "', vpcirculo2='" + this.xCirculo1 + "', vpestrella3='" + this.xEstrella1 + "',  vpcuadrado4='" + this.xCuadrado + "', vpestrella5='" + this.xEstrella2 + "', vpcirculo6='" + this.xCirculo2 + "', vpclasificacion='" + this.JLClasProf.getText() + "', amb_valor='" + getValueRadioButton(this.ambliopia) + "', amb_clasificacion='" + this.JLClasAmbli.getText() + "', foria_valor='" + getValueRadioButton(this.foria) + "', foria_clasificacion='" + this.JLClasForia.getText() + "', vc_ao_81='" + this.xAO81 + "', vc_ao_45='" + this.xAO45 + "', vc_ao_63='" + this.xAO63 + "', vc_ao_27='" + this.xAO27 + "', vc_ao_90='" + this.xAO90 + "', vc_ao_18='" + this.xAO18 + "', vc_ao_clasificacion='" + this.JLClasVC_AO.getText() + "', vc_od_81='" + this.xOD81 + "', vc_od_45='" + this.xOD45 + "', vc_od_63='" + this.xOD63 + "', vc_od_27='" + this.xOD27 + "',  vc_od_90='" + this.xOD90 + "', vc_od_18='" + this.xOD18 + "', vc_od_clasificacion='" + this.JLClasVC_OD.getText() + "', vc_oi_81='" + this.xOI81 + "', vc_oi_45='" + this.xOI45 + "', vc_oi_63='" + this.xOI63 + "', vc_oi_27='" + this.xOI27 + "', vc_oi_90='" + this.xOI90 + "', vc_oi_18='" + this.xOI18 + "', vc_oi_clasificacion='" + this.JLClasVC_OI.getText() + "',  vl_ao_linea='" + this.xJPSo_VisiometriaDistancias.JLLineaAO.getText() + "', vl_ao_optotipos='" + this.xJPSo_VisiometriaDistancias.JLOptotipoAO.getText() + "', vl_ao_nivel_av='" + this.xJPSo_VisiometriaDistancias.JLNivelAO.getText() + "', vl_ao_clasificacion='" + this.xJPSo_VisiometriaDistancias.JCBClaAO.getSelectedItem().toString() + "', vl_ao_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.AO) + "',  vl_od_linea='" + this.xJPSo_VisiometriaDistancias.JLLineaOD.getText() + "' , vl_od_optotipos='" + this.xJPSo_VisiometriaDistancias.JLOptotiposOD.getText() + "', vl_od_nivel_av='" + this.xJPSo_VisiometriaDistancias.JLNivelOD.getText() + "', vl_od_clasificacion='" + this.xJPSo_VisiometriaDistancias.JCBClaOD.getSelectedItem().toString() + "', vl_od_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.OD) + "',  vl_oi_linea='" + this.xJPSo_VisiometriaDistancias.JLLineaOI.getText() + "', vl_oi_optotipos='" + this.xJPSo_VisiometriaDistancias.JLOptotiposOI.getText() + "', vl_oi_nivel_av='" + this.xJPSo_VisiometriaDistancias.JLNivelOI.getText() + "', vl_oi_clasificacion='" + this.xJPSo_VisiometriaDistancias.JCBClaOI.getSelectedItem().toString() + "', vl_oi_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.OI) + "',  vi_ao_linea='" + this.xJPSo_VisiometriaIntermedia.JLLineaAO.getText() + "', vi_ao_optotipos='" + this.xJPSo_VisiometriaIntermedia.JLOptotipoAO.getText() + "', vi_ao_nivel_av='" + this.xJPSo_VisiometriaIntermedia.JLNivelAO.getText() + "', vi_ao_clasificacion='" + this.xJPSo_VisiometriaIntermedia.JCBClaAO.getSelectedItem().toString() + "', vi_ao_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.AO) + "',  vi_od_linea='" + this.xJPSo_VisiometriaIntermedia.JLLineaOD.getText() + "', vi_od_optotipos='" + this.xJPSo_VisiometriaIntermedia.JLOptotiposOD.getText() + "', vi_od_nivel_av='" + this.xJPSo_VisiometriaIntermedia.JLNivelOD.getText() + "', vi_od_clasificacion='" + this.xJPSo_VisiometriaIntermedia.JCBClaOD.getSelectedItem().toString() + "', vi_od_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.OD) + "',  vi_oi_linea='" + this.xJPSo_VisiometriaIntermedia.JLLineaOI.getText() + "', vi_oi_optotipos='" + this.xJPSo_VisiometriaIntermedia.JLOptotiposOI.getText() + "', vi_oi_nivel_av='" + this.xJPSo_VisiometriaIntermedia.JLNivelOI.getText() + "', vi_oi_clasificacion='" + this.xJPSo_VisiometriaIntermedia.JCBClaOI.getSelectedItem().toString() + "', vi_oi_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.OI) + "',  vce_ao_linea='" + this.xJPSo_VisiometriaCercana.JLLineaAO.getText() + "', vce_ao_optotipos='" + this.xJPSo_VisiometriaCercana.JLOptotipoAO.getText() + "', vce_ao_nivel_av='" + this.xJPSo_VisiometriaCercana.JLNivelAO.getText() + "', vce_ao_clasificacion='" + this.xJPSo_VisiometriaCercana.JCBClaAO.getSelectedItem().toString() + "', vce_ao_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.AO) + "',  vce_od_linea='" + this.xJPSo_VisiometriaCercana.JLLineaOD.getText() + "' , vce_od_optotipos='" + this.xJPSo_VisiometriaCercana.JLOptotiposOD.getText() + "', vce_od_nivel_av='" + this.xJPSo_VisiometriaCercana.JLNivelOD.getText() + "', vce_od_clasificacion='" + this.xJPSo_VisiometriaCercana.JCBClaOD.getSelectedItem().toString() + "', vce_od_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.OD) + "',  vce_oi_linea='" + this.xJPSo_VisiometriaCercana.JLLineaOI.getText() + "', vce_oi_optotipos='" + this.xJPSo_VisiometriaCercana.JLOptotiposOI.getText() + "', vce_oi_nivel_av='" + this.xJPSo_VisiometriaCercana.JLNivelOI.getText() + "', vce_oi_clasificacion='" + this.xJPSo_VisiometriaCercana.JCBClaOI.getSelectedItem().toString() + "', vce_oi_optotipos_selected='" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.OI) + "', usuarios='" + Principal.usuarioSistemaDTO.getLogin() + "'WHERE idAtencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' ;";
                                this.xct.ejecutarSQL(sql);
                            } else {
                                sql = "INSERT INTO  h_so_visiometria_m  \n (idatencion, idusuario, idprofesional, idespecialidad, fechar, correccion, vptriangulo1, vpcirculo2, vpestrella3,  vpcuadrado4, vpestrella5, vpcirculo6, vpclasificacion, amb_valor, amb_clasificacion, foria_valor, foria_clasificacion, vc_ao_81, vc_ao_45, vc_ao_63, vc_ao_27, vc_ao_90, vc_ao_18, vc_ao_clasificacion, vc_od_81, vc_od_45, vc_od_63, vc_od_27,  vc_od_90, vc_od_18, vc_od_clasificacion, vc_oi_81, vc_oi_45, vc_oi_63, vc_oi_27, vc_oi_90, vc_oi_18, vc_oi_clasificacion,  vl_ao_linea, vl_ao_optotipos, vl_ao_nivel_av, vl_ao_clasificacion, vl_ao_optotipos_selected,  vl_od_linea, vl_od_optotipos, vl_od_nivel_av, vl_od_clasificacion, vl_od_optotipos_selected,  vl_oi_linea, vl_oi_optotipos, vl_oi_nivel_av, vl_oi_clasificacion, vl_oi_optotipos_selected,  vi_ao_linea, vi_ao_optotipos, vi_ao_nivel_av, vi_ao_clasificacion, vi_ao_optotipos_selected,  vi_od_linea, vi_od_optotipos, vi_od_nivel_av, vi_od_clasificacion, vi_od_optotipos_selected,  vi_oi_linea, vi_oi_optotipos, vi_oi_nivel_av, vi_oi_clasificacion, vi_oi_optotipos_selected,  vce_ao_linea, vce_ao_optotipos, vce_ao_nivel_av, vce_ao_clasificacion, vce_ao_optotipos_selected,  vce_od_linea, vce_od_optotipos, vce_od_nivel_av, vce_od_clasificacion, vce_od_optotipos_selected,  vce_oi_linea, vce_oi_optotipos, vce_oi_nivel_av, vce_oi_clasificacion, vce_oi_optotipos_selected, usuarios)\n VALUES('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + correccion + "','" + this.xTriangulo + "','" + this.xCirculo1 + "','" + this.xEstrella1 + "' ,'" + this.xCuadrado + "','" + this.xEstrella2 + "','" + this.xCirculo2 + "','" + this.JLClasProf.getText() + "','" + getValueRadioButton(this.ambliopia) + "','" + this.JLClasAmbli.getText() + "','" + getValueRadioButton(this.foria) + "','" + this.JLClasForia.getText() + "' ,'" + this.xAO81 + "','" + this.xAO45 + "','" + this.xAO63 + "','" + this.xAO27 + "','" + this.xAO90 + "','" + this.xAO18 + "','" + this.JLClasVC_AO.getText() + "','" + this.xOD81 + "','" + this.xOD45 + "','" + this.xOD63 + "','" + this.xOD27 + "' ,'" + this.xOD90 + "','" + this.xOD18 + "','" + this.JLClasVC_OD.getText() + "','" + this.xOI81 + "','" + this.xOI45 + "','" + this.xOI63 + "','" + this.xOI27 + "','" + this.xOI90 + "','" + this.xOI18 + "','" + this.JLClasVC_OI.getText() + "' ,'" + this.xJPSo_VisiometriaDistancias.JLLineaAO.getText() + "' ,'" + this.xJPSo_VisiometriaDistancias.JLOptotipoAO.getText() + "','" + this.xJPSo_VisiometriaDistancias.JLNivelAO.getText() + "','" + this.xJPSo_VisiometriaDistancias.JCBClaAO.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.AO) + "' ,'" + this.xJPSo_VisiometriaDistancias.JLLineaOD.getText() + "' ,'" + this.xJPSo_VisiometriaDistancias.JLOptotiposOD.getText() + "','" + this.xJPSo_VisiometriaDistancias.JLNivelOD.getText() + "','" + this.xJPSo_VisiometriaDistancias.JCBClaOD.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.OD) + "' ,'" + this.xJPSo_VisiometriaDistancias.JLLineaOI.getText() + "' ,'" + this.xJPSo_VisiometriaDistancias.JLOptotiposOI.getText() + "','" + this.xJPSo_VisiometriaDistancias.JLNivelOI.getText() + "','" + this.xJPSo_VisiometriaDistancias.JCBClaOI.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaDistancias.OI) + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLLineaAO.getText() + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLOptotipoAO.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JLNivelAO.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JCBClaAO.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.AO) + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLLineaOD.getText() + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLOptotiposOD.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JLNivelOD.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JCBClaOD.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.OD) + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLLineaOI.getText() + "' ,'" + this.xJPSo_VisiometriaIntermedia.JLOptotiposOI.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JLNivelOI.getText() + "','" + this.xJPSo_VisiometriaIntermedia.JCBClaOI.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaIntermedia.OI) + "' ,'" + this.xJPSo_VisiometriaCercana.JLLineaAO.getText() + "' ,'" + this.xJPSo_VisiometriaCercana.JLOptotipoAO.getText() + "','" + this.xJPSo_VisiometriaCercana.JLNivelAO.getText() + "','" + this.xJPSo_VisiometriaCercana.JCBClaAO.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.AO) + "' ,'" + this.xJPSo_VisiometriaCercana.JLLineaOD.getText() + "' ,'" + this.xJPSo_VisiometriaCercana.JLOptotiposOD.getText() + "','" + this.xJPSo_VisiometriaCercana.JLNivelOD.getText() + "','" + this.xJPSo_VisiometriaCercana.JCBClaOD.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.OD) + "' ,'" + this.xJPSo_VisiometriaCercana.JLLineaOI.getText() + "' ,'" + this.xJPSo_VisiometriaCercana.JLOptotiposOI.getText() + "','" + this.xJPSo_VisiometriaCercana.JLNivelOI.getText() + "','" + this.xJPSo_VisiometriaCercana.JCBClaOI.getSelectedItem().toString() + "','" + mOptotiposSelected(this.xJPSo_VisiometriaCercana.OI) + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                this.xidVisiometia = this.xct.ejecutarSQLId(sql);
                            }
                            System.out.println("consultaa -> " + sql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosTablaHistorico();
                            mImprimir(this.xmodelo.getValueAt(0, 3).toString());
                            guardarReporte();
                            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe hacer el Test Forias", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe hacer el Test Ambliopia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe hacer el Test visión de profundidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Esta historia clinica ya se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public String getValueRadioButton(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    public void setValueRadioButton(ButtonGroup buttonGroup, String value) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.getText().equals(value)) {
                button.setSelected(true);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "IdVisio"}) { // from class: Historia.JPSo_VisiometriaMineros.51
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoDetalle.setModel(this.xmodelo);
        this.JTHistoricoDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistoricoDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTHistoricoDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTHistoricoDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTHistoricoDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTHistoricoDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "select h_so_visiometria_m.idatencion, h_so_visiometria_m.fechar\n,profesional1.NProfesional, h_so_visiometria_m.id \nfrom h_so_visiometria_m \ninner join profesional1 on (h_so_visiometria_m.idprofesional=profesional1.Id_Persona)\nwhere h_so_visiometria_m.idusuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\nand h_so_visiometria_m.estado=1 order by h_so_visiometria_m.fechar DESC";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPSo_VisiometriaMineros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificaSeleccionVisionColores() {
        if (this.JLClasVC_AO.getText().isEmpty()) {
            getClass();
            this.xAO81 = -1;
            getClass();
            this.xAO45 = -1;
            getClass();
            this.xAO63 = -1;
            getClass();
            this.xAO27 = -1;
            getClass();
            this.xAO90 = -1;
            getClass();
            this.xAO18 = -1;
        } else {
            this.xAO81 = this.jCheckBox1.isSelected() ? 1 : 0;
            this.xAO45 = this.jCheckBox2.isSelected() ? 1 : 0;
            this.xAO63 = this.jCheckBox3.isSelected() ? 1 : 0;
            this.xAO27 = this.jCheckBox4.isSelected() ? 1 : 0;
            this.xAO90 = this.jCheckBox5.isSelected() ? 1 : 0;
            this.xAO18 = this.jCheckBox6.isSelected() ? 1 : 0;
        }
        if (this.JLClasVC_OD.getText().isEmpty()) {
            getClass();
            this.xOD81 = -1;
            getClass();
            this.xOD45 = -1;
            getClass();
            this.xOD63 = -1;
            getClass();
            this.xOD27 = -1;
            getClass();
            this.xOD90 = -1;
            getClass();
            this.xOD18 = -1;
        } else {
            this.xOD81 = this.jCheckBox7.isSelected() ? 1 : 0;
            this.xOD45 = this.jCheckBox8.isSelected() ? 1 : 0;
            this.xOD63 = this.jCheckBox9.isSelected() ? 1 : 0;
            this.xOD27 = this.jCheckBox10.isSelected() ? 1 : 0;
            this.xOD90 = this.jCheckBox11.isSelected() ? 1 : 0;
            this.xOD18 = this.jCheckBox12.isSelected() ? 1 : 0;
        }
        if (this.JLClasVC_OI.getText().isEmpty()) {
            getClass();
            this.xOI81 = -1;
            getClass();
            this.xOI45 = -1;
            getClass();
            this.xOI63 = -1;
            getClass();
            this.xOI27 = -1;
            getClass();
            this.xOI90 = -1;
            getClass();
            this.xOI18 = -1;
            return;
        }
        this.xOI81 = this.jCheckBox13.isSelected() ? 1 : 0;
        this.xOI45 = this.jCheckBox14.isSelected() ? 1 : 0;
        this.xOI63 = this.jCheckBox15.isSelected() ? 1 : 0;
        this.xOI27 = this.jCheckBox16.isSelected() ? 1 : 0;
        this.xOI90 = this.jCheckBox17.isSelected() ? 1 : 0;
        this.xOI18 = this.jCheckBox18.isSelected() ? 1 : 0;
    }

    private void guardarReporte() {
        try {
            File archivoOrigen = new File("Reportes/H_So_Visiometria_Mineros.pdf");
            File archivoDestino = new File("Reportes/Reportes Visio/" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "_H_So_Visiometria_Mineros.pdf");
            Files.copy(archivoOrigen.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            if (archivoDestino.exists()) {
                JOptionPane.showMessageDialog(this, "Registro asegurado con exito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } else {
                System.out.println("El archivo duplicado no existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
