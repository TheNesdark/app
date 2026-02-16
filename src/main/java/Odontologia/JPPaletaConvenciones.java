package Odontologia;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPPaletaConvenciones.class */
public class JPPaletaConvenciones extends JPanel {
    public long completo;
    private JPOdontograma jpodontograma;
    private JPOdontogramaInicial jpodontogramaInicial;
    private JPOdontogramaClinico jpodontogramaClinico;
    private ButtonGroup BGPaleta;
    private JCheckBox JCHCompleto;
    private JPanel JPEspecial;
    private JToggleButton JTBAbrasion;
    private JToggleButton JTBAmalgamaB;
    private JToggleButton JTBAmalgamaD;
    private JToggleButton JTBAtricion;
    public JToggleButton JTBBorrador;
    private JToggleButton JTBCaries;
    private JToggleButton JTBCoronaBuena;
    private JToggleButton JTBCoronaDesadaptada;
    private JToggleButton JTBCoronaIndicada;
    private JToggleButton JTBDienteIncluido;
    private JToggleButton JTBDienteSano;
    private JToggleButton JTBDienteSemiIncluido;
    private JToggleButton JTBDxEspecial;
    private JToggleButton JTBEnErupcion;
    private JToggleButton JTBEndodonciaBuena;
    private JToggleButton JTBEndodonciaDesadaptada;
    private JToggleButton JTBEndodonciaIndicada;
    private JToggleButton JTBExtraccionClinica;
    private JToggleButton JTBExtraccionDPTrauma;
    private JToggleButton JTBExtraccionDiente;
    private JToggleButton JTBExtraccionIndicada;
    private JToggleButton JTBExtraccionZDesdentada;
    private JToggleButton JTBFractura;
    private JToggleButton JTBImplanteBueno;
    private JToggleButton JTBImplanteIndicado;
    private JToggleButton JTBIonomeroB;
    private JToggleButton JTBIonomeroD;
    private JToggleButton JTBIonomeroI;
    private JToggleButton JTBObturacionColPorcelana;
    private JToggleButton JTBObturacionIndMetalica;
    private JToggleButton JTBPerno;
    private JToggleButton JTBPernoDesadaptado;
    private JToggleButton JTBPernoIndicado;
    private JToggleButton JTBProcEspecial;
    private JToggleButton JTBProvisionalBueno;
    private JToggleButton JTBProvisionalIndicado;
    private JToggleButton JTBPuenteFCPDerecho;
    private JToggleButton JTBPuenteFCPDerechoP;
    private JToggleButton JTBPuenteFCPIzquierdo;
    private JToggleButton JTBPuenteFCPIzquierdoP;
    private JToggleButton JTBPuenteFCPontico;
    private JToggleButton JTBRecidiva;
    private JToggleButton JTBResinaB;
    private JToggleButton JTBResinaD;
    private JToggleButton JTBResinaI;
    private JToggleButton JTBRestoRadicular;
    private JToggleButton JTBRotacionMigracion;
    private JToggleButton JTBSellanteBueno;
    private JToggleButton JTBSellanteIndicado;
    private JToggleButton JTBSinErupcionar;
    public String procedimientoPaleta = null;
    public long filtroCombo = 0;
    private String nombre = "";

    public JPPaletaConvenciones(JPanel jpanel) {
        initComponents();
        mRealizarCasting(jpanel);
    }

    private void mRealizarCasting(JPanel jpanel) {
        if (jpanel.getName().equals("jifOdontogramaG")) {
            this.jpodontograma = (JPOdontograma) jpanel;
            this.nombre = jpanel.getName();
        } else if (jpanel.getName().equals("jifOdontogramaI")) {
            this.jpodontogramaInicial = (JPOdontogramaInicial) jpanel;
            this.nombre = jpanel.getName();
        } else if (jpanel.getName().equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico = (JPOdontogramaClinico) jpanel;
            this.nombre = jpanel.getName();
        }
    }

    private void initComponents() {
        this.BGPaleta = new ButtonGroup();
        this.JTBCaries = new JToggleButton();
        this.JTBFractura = new JToggleButton();
        this.JTBRecidiva = new JToggleButton();
        this.JTBAmalgamaB = new JToggleButton();
        this.JTBAmalgamaD = new JToggleButton();
        this.JTBIonomeroB = new JToggleButton();
        this.JTBIonomeroD = new JToggleButton();
        this.JTBIonomeroI = new JToggleButton();
        this.JTBResinaB = new JToggleButton();
        this.JTBResinaD = new JToggleButton();
        this.JTBResinaI = new JToggleButton();
        this.JTBExtraccionClinica = new JToggleButton();
        this.JTBExtraccionZDesdentada = new JToggleButton();
        this.JTBExtraccionDPTrauma = new JToggleButton();
        this.JTBExtraccionDiente = new JToggleButton();
        this.JTBExtraccionIndicada = new JToggleButton();
        this.JTBSellanteBueno = new JToggleButton();
        this.JTBSellanteIndicado = new JToggleButton();
        this.JTBProvisionalBueno = new JToggleButton();
        this.JTBProvisionalIndicado = new JToggleButton();
        this.JTBImplanteBueno = new JToggleButton();
        this.JTBImplanteIndicado = new JToggleButton();
        this.JTBCoronaBuena = new JToggleButton();
        this.JTBCoronaIndicada = new JToggleButton();
        this.JTBCoronaDesadaptada = new JToggleButton();
        this.JTBPuenteFCPDerecho = new JToggleButton();
        this.JTBPuenteFCPDerechoP = new JToggleButton();
        this.JTBPuenteFCPontico = new JToggleButton();
        this.JTBPuenteFCPIzquierdoP = new JToggleButton();
        this.JTBPuenteFCPIzquierdo = new JToggleButton();
        this.JTBObturacionIndMetalica = new JToggleButton();
        this.JTBObturacionColPorcelana = new JToggleButton();
        this.JTBRotacionMigracion = new JToggleButton();
        this.JTBDienteSano = new JToggleButton();
        this.JTBDienteIncluido = new JToggleButton();
        this.JTBDienteSemiIncluido = new JToggleButton();
        this.JTBEndodonciaBuena = new JToggleButton();
        this.JTBEndodonciaIndicada = new JToggleButton();
        this.JTBEndodonciaDesadaptada = new JToggleButton();
        this.JTBPerno = new JToggleButton();
        this.JTBPernoDesadaptado = new JToggleButton();
        this.JTBPernoIndicado = new JToggleButton();
        this.JTBAbrasion = new JToggleButton();
        this.JTBRestoRadicular = new JToggleButton();
        this.JTBBorrador = new JToggleButton();
        this.JPEspecial = new JPanel();
        this.JTBDxEspecial = new JToggleButton();
        this.JTBProcEspecial = new JToggleButton();
        this.JCHCompleto = new JCheckBox();
        this.JTBSinErupcionar = new JToggleButton();
        this.JTBEnErupcion = new JToggleButton();
        this.JTBAtricion = new JToggleButton();
        setAutoscrolls(true);
        setMinimumSize(new Dimension(176, 674));
        setPreferredSize(new Dimension(176, 674));
        this.JTBCaries.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBCaries);
        this.JTBCaries.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Caries.png")));
        this.JTBCaries.setToolTipText("Caries");
        this.JTBCaries.setCursor(new Cursor(0));
        this.JTBCaries.setName("Caries");
        this.JTBCaries.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.1
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBCariesActionPerformed(evt);
            }
        });
        this.JTBFractura.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBFractura);
        this.JTBFractura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Fractura.png")));
        this.JTBFractura.setToolTipText("Fractura");
        this.JTBFractura.setName("Fractura");
        this.JTBFractura.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.2
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBFracturaActionPerformed(evt);
            }
        });
        this.JTBRecidiva.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBRecidiva);
        this.JTBRecidiva.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Recidiva.png")));
        this.JTBRecidiva.setToolTipText("Recidiva");
        this.JTBRecidiva.setName("Recidiva");
        this.JTBRecidiva.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.3
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBRecidivaActionPerformed(evt);
            }
        });
        this.JTBAmalgamaB.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBAmalgamaB);
        this.JTBAmalgamaB.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Amalgama - Buena.png")));
        this.JTBAmalgamaB.setToolTipText("Amalgama Buena");
        this.JTBAmalgamaB.setName("Amalgama Buena");
        this.JTBAmalgamaB.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.4
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBAmalgamaBActionPerformed(evt);
            }
        });
        this.JTBAmalgamaD.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBAmalgamaD);
        this.JTBAmalgamaD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Amalgama - Desadaptada.png")));
        this.JTBAmalgamaD.setToolTipText("Amalgama Desadaptada");
        this.JTBAmalgamaD.setName("Amalgama Desadaptada");
        this.JTBAmalgamaD.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.5
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBAmalgamaDActionPerformed(evt);
            }
        });
        this.JTBIonomeroB.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBIonomeroB);
        this.JTBIonomeroB.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Ionomero - Bueno.png")));
        this.JTBIonomeroB.setToolTipText("Ionomero Bueno");
        this.JTBIonomeroB.setName("Ionomero Bueno");
        this.JTBIonomeroB.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.6
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBIonomeroBActionPerformed(evt);
            }
        });
        this.JTBIonomeroD.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBIonomeroD);
        this.JTBIonomeroD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Ionomero - Desadaptado.png")));
        this.JTBIonomeroD.setToolTipText("Ionomero Desadaptado");
        this.JTBIonomeroD.setName("Ionomero Desadaptado");
        this.JTBIonomeroD.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.7
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBIonomeroDActionPerformed(evt);
            }
        });
        this.JTBIonomeroI.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBIonomeroI);
        this.JTBIonomeroI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Ionomero - Indicado.png")));
        this.JTBIonomeroI.setToolTipText("Ionomero Indicado");
        this.JTBIonomeroI.setName("Ionomero Indicado");
        this.JTBIonomeroI.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.8
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBIonomeroIActionPerformed(evt);
            }
        });
        this.JTBResinaB.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBResinaB);
        this.JTBResinaB.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Resina - Buena.png")));
        this.JTBResinaB.setToolTipText("Resina Buena");
        this.JTBResinaB.setName("Resina Buena");
        this.JTBResinaB.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.9
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBResinaBActionPerformed(evt);
            }
        });
        this.JTBResinaD.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBResinaD);
        this.JTBResinaD.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Resina – Desadaptada.png")));
        this.JTBResinaD.setToolTipText("Resina Desadaptada");
        this.JTBResinaD.setName("Resina Desadaptada");
        this.JTBResinaD.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.10
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBResinaDActionPerformed(evt);
            }
        });
        this.JTBResinaI.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBResinaI);
        this.JTBResinaI.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Resina - Indicada.png")));
        this.JTBResinaI.setToolTipText("Resina Indicada");
        this.JTBResinaI.setName("Resina Indicada");
        this.JTBResinaI.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.11
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBResinaIActionPerformed(evt);
            }
        });
        this.JTBExtraccionClinica.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBExtraccionClinica);
        this.JTBExtraccionClinica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Extracciones - Diente Ausente Clinicamente.png")));
        this.JTBExtraccionClinica.setToolTipText("Extracciones - Diente Ausente Clinicamente");
        this.JTBExtraccionClinica.setName("Extracciones - Diente Ausente Clinicamente");
        this.JTBExtraccionClinica.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.12
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBExtraccionClinicaActionPerformed(evt);
            }
        });
        this.JTBExtraccionZDesdentada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBExtraccionZDesdentada);
        this.JTBExtraccionZDesdentada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Extracciones - Zona Desdentada Remplazada.png")));
        this.JTBExtraccionZDesdentada.setToolTipText("Extracciones - Zona Desdentada Remplazada");
        this.JTBExtraccionZDesdentada.setName("Extracciones - Zona Desdentada Remplazada");
        this.JTBExtraccionZDesdentada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.13
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBExtraccionZDesdentadaActionPerformed(evt);
            }
        });
        this.JTBExtraccionDPTrauma.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBExtraccionDPTrauma);
        this.JTBExtraccionDPTrauma.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Extracciones - Diente Perdido por Trauma.png")));
        this.JTBExtraccionDPTrauma.setToolTipText("Extracciones - Diente Perdido por Trauma");
        this.JTBExtraccionDPTrauma.setName("Extracciones - Diente Perdido por Trauma");
        this.JTBExtraccionDPTrauma.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.14
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBExtraccionDPTraumaActionPerformed(evt);
            }
        });
        this.JTBExtraccionDiente.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBExtraccionDiente);
        this.JTBExtraccionDiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Extraccion de Diente.png")));
        this.JTBExtraccionDiente.setToolTipText("Extraccion de Diente");
        this.JTBExtraccionDiente.setName("Extraccion de Diente");
        this.JTBExtraccionDiente.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.15
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBExtraccionDienteActionPerformed(evt);
            }
        });
        this.JTBExtraccionIndicada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBExtraccionIndicada);
        this.JTBExtraccionIndicada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Extraccion Indicada.png")));
        this.JTBExtraccionIndicada.setToolTipText("Extraccion Indicada");
        this.JTBExtraccionIndicada.setName("Extraccion Indicada");
        this.JTBExtraccionIndicada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.16
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBExtraccionIndicadaActionPerformed(evt);
            }
        });
        this.JTBSellanteBueno.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBSellanteBueno);
        this.JTBSellanteBueno.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Sellante - Bueno.png")));
        this.JTBSellanteBueno.setToolTipText("Sellante Bueno");
        this.JTBSellanteBueno.setName("Sellante Bueno");
        this.JTBSellanteBueno.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.17
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBSellanteBuenoActionPerformed(evt);
            }
        });
        this.JTBSellanteIndicado.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBSellanteIndicado);
        this.JTBSellanteIndicado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Sellante - Indicado.png")));
        this.JTBSellanteIndicado.setToolTipText("Sellante - Indicado");
        this.JTBSellanteIndicado.setName("Sellante - Indicado");
        this.JTBSellanteIndicado.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.18
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBSellanteIndicadoActionPerformed(evt);
            }
        });
        this.JTBProvisionalBueno.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBProvisionalBueno);
        this.JTBProvisionalBueno.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Provisional - Bueno.png")));
        this.JTBProvisionalBueno.setToolTipText("Provisional Bueno");
        this.JTBProvisionalBueno.setName("Provisional Bueno");
        this.JTBProvisionalBueno.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.19
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBProvisionalBuenoActionPerformed(evt);
            }
        });
        this.JTBProvisionalIndicado.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBProvisionalIndicado);
        this.JTBProvisionalIndicado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Provisional - Indicado.png")));
        this.JTBProvisionalIndicado.setToolTipText("Provisional Indicado");
        this.JTBProvisionalIndicado.setName("Provisional Indicado");
        this.JTBProvisionalIndicado.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.20
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBProvisionalIndicadoActionPerformed(evt);
            }
        });
        this.JTBImplanteBueno.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBImplanteBueno);
        this.JTBImplanteBueno.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Impalte - Bueno.png")));
        this.JTBImplanteBueno.setToolTipText("Implante Bueno");
        this.JTBImplanteBueno.setName("Implante Bueno");
        this.JTBImplanteBueno.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.21
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBImplanteBuenoActionPerformed(evt);
            }
        });
        this.JTBImplanteIndicado.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBImplanteIndicado);
        this.JTBImplanteIndicado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Implante - Indicado.png")));
        this.JTBImplanteIndicado.setToolTipText("Implante Indicado");
        this.JTBImplanteIndicado.setName("Implante Indicado");
        this.JTBImplanteIndicado.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.22
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBImplanteIndicadoActionPerformed(evt);
            }
        });
        this.JTBCoronaBuena.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBCoronaBuena);
        this.JTBCoronaBuena.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Corona - Buena.png")));
        this.JTBCoronaBuena.setToolTipText("Corona Buena");
        this.JTBCoronaBuena.setName("Corona Buena");
        this.JTBCoronaBuena.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.23
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBCoronaBuenaActionPerformed(evt);
            }
        });
        this.JTBCoronaIndicada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBCoronaIndicada);
        this.JTBCoronaIndicada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Corona - Indicada.png")));
        this.JTBCoronaIndicada.setToolTipText("Corona Indicada");
        this.JTBCoronaIndicada.setName("Corona Indicada");
        this.JTBCoronaIndicada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.24
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBCoronaIndicadaActionPerformed(evt);
            }
        });
        this.JTBCoronaDesadaptada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBCoronaDesadaptada);
        this.JTBCoronaDesadaptada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Corona - Desadaptada.png")));
        this.JTBCoronaDesadaptada.setToolTipText("Corona Desadaptada");
        this.JTBCoronaDesadaptada.setName("Corona Desadaptada");
        this.JTBCoronaDesadaptada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.25
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBCoronaDesadaptadaActionPerformed(evt);
            }
        });
        this.JTBPuenteFCPDerecho.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPuenteFCPDerecho);
        this.JTBPuenteFCPDerecho.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Puente Fijo Colocado - Pilar Derecho.png")));
        this.JTBPuenteFCPDerecho.setToolTipText("Puente Fijo Colocado - Pilar Derecho");
        this.JTBPuenteFCPDerecho.setName("Puente Fijo Colocado - Pilar Derecho");
        this.JTBPuenteFCPDerecho.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.26
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPuenteFCPDerechoActionPerformed(evt);
            }
        });
        this.JTBPuenteFCPDerechoP.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPuenteFCPDerechoP);
        this.JTBPuenteFCPDerechoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Puente Fijo Colocado - Pilar Derecho con Pontico.png")));
        this.JTBPuenteFCPDerechoP.setToolTipText("Puente Fijo Colocado - Pilar Derecho con Pontico");
        this.JTBPuenteFCPDerechoP.setName("Puente Fijo Colocado - Pilar Derecho con Pontico");
        this.JTBPuenteFCPDerechoP.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.27
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPuenteFCPDerechoPActionPerformed(evt);
            }
        });
        this.JTBPuenteFCPontico.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPuenteFCPontico);
        this.JTBPuenteFCPontico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Puente Fijo Colocado - Pontico.png")));
        this.JTBPuenteFCPontico.setToolTipText("Puente Fijo Colocado - Pontico");
        this.JTBPuenteFCPontico.setName("Puente Fijo Colocado - Pontico");
        this.JTBPuenteFCPontico.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.28
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPuenteFCPonticoActionPerformed(evt);
            }
        });
        this.JTBPuenteFCPIzquierdoP.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPuenteFCPIzquierdoP);
        this.JTBPuenteFCPIzquierdoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Puente Fijo Colocado - Pilar Izquierdo con Pontico.png")));
        this.JTBPuenteFCPIzquierdoP.setToolTipText("Puente Fijo Colocado - Pilar Izquierdo con Pontico");
        this.JTBPuenteFCPIzquierdoP.setName("Puente Fijo Colocado - Pilar Izquierdo con Pontico");
        this.JTBPuenteFCPIzquierdoP.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.29
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPuenteFCPIzquierdoPActionPerformed(evt);
            }
        });
        this.JTBPuenteFCPIzquierdo.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPuenteFCPIzquierdo);
        this.JTBPuenteFCPIzquierdo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Puente Fijo Colocado - Pilar Izquierdo.png")));
        this.JTBPuenteFCPIzquierdo.setToolTipText("Puente Fijo Colocado - Pilar Izquierdo.");
        this.JTBPuenteFCPIzquierdo.setName("Puente Fijo Colocado - Pilar Izquierdo");
        this.JTBPuenteFCPIzquierdo.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.30
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPuenteFCPIzquierdoActionPerformed(evt);
            }
        });
        this.JTBObturacionIndMetalica.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBObturacionIndMetalica);
        this.JTBObturacionIndMetalica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Obturacion Colocada - Metalica.png")));
        this.JTBObturacionIndMetalica.setToolTipText("Obturacion Colocada - Metalica");
        this.JTBObturacionIndMetalica.setName("Obturacion Colocada - Metalica");
        this.JTBObturacionIndMetalica.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.31
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBObturacionIndMetalicaActionPerformed(evt);
            }
        });
        this.JTBObturacionColPorcelana.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBObturacionColPorcelana);
        this.JTBObturacionColPorcelana.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Obturacion Colocada - En Porcelana.png")));
        this.JTBObturacionColPorcelana.setToolTipText("Obturacion Colocada - En Porcelana");
        this.JTBObturacionColPorcelana.setName("Obturacion Colocada - En Porcelana");
        this.JTBObturacionColPorcelana.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.32
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBObturacionColPorcelanaActionPerformed(evt);
            }
        });
        this.JTBRotacionMigracion.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBRotacionMigracion);
        this.JTBRotacionMigracion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Rotaciones y Migraciones.png")));
        this.JTBRotacionMigracion.setToolTipText("Rotaciones y Migraciones");
        this.JTBRotacionMigracion.setName("Rotaciones y Migraciones");
        this.JTBRotacionMigracion.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.33
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBRotacionMigracionActionPerformed(evt);
            }
        });
        this.JTBDienteSano.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBDienteSano);
        this.JTBDienteSano.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Diente - Sano.png")));
        this.JTBDienteSano.setToolTipText("Diente - Sano");
        this.JTBDienteSano.setName("Diente - Sano");
        this.JTBDienteSano.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.34
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBDienteSanoActionPerformed(evt);
            }
        });
        this.JTBDienteIncluido.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBDienteIncluido);
        this.JTBDienteIncluido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Diente - Incluido.png")));
        this.JTBDienteIncluido.setToolTipText("Diente - Incluido");
        this.JTBDienteIncluido.setName("Diente - Incluido");
        this.JTBDienteIncluido.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.35
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBDienteIncluidoActionPerformed(evt);
            }
        });
        this.JTBDienteSemiIncluido.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBDienteSemiIncluido);
        this.JTBDienteSemiIncluido.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Diente - Semi-Incluido.png")));
        this.JTBDienteSemiIncluido.setToolTipText("Diente - Semi-Incluido");
        this.JTBDienteSemiIncluido.setName("Diente - Semi-Incluido");
        this.JTBDienteSemiIncluido.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.36
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBDienteSemiIncluidoActionPerformed(evt);
            }
        });
        this.JTBEndodonciaBuena.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBEndodonciaBuena);
        this.JTBEndodonciaBuena.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Endodoncia - Buena.png")));
        this.JTBEndodonciaBuena.setToolTipText("Endodoncia - Buena");
        this.JTBEndodonciaBuena.setName("Endodoncia - Buena");
        this.JTBEndodonciaBuena.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.37
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBEndodonciaBuenaActionPerformed(evt);
            }
        });
        this.JTBEndodonciaIndicada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBEndodonciaIndicada);
        this.JTBEndodonciaIndicada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Endodoncia - Indicada.png")));
        this.JTBEndodonciaIndicada.setToolTipText("Endodoncia - Indicada");
        this.JTBEndodonciaIndicada.setName("Endodoncia - Indicada");
        this.JTBEndodonciaIndicada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.38
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBEndodonciaIndicadaActionPerformed(evt);
            }
        });
        this.JTBEndodonciaDesadaptada.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBEndodonciaDesadaptada);
        this.JTBEndodonciaDesadaptada.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Endodoncia Desadaptada.png")));
        this.JTBEndodonciaDesadaptada.setToolTipText("Endodoncia Desadaptada");
        this.JTBEndodonciaDesadaptada.setName("Endodoncia Desadaptada");
        this.JTBEndodonciaDesadaptada.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.39
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBEndodonciaDesadaptadaActionPerformed(evt);
            }
        });
        this.JTBPerno.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPerno);
        this.JTBPerno.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Perno.png")));
        this.JTBPerno.setToolTipText("Perno");
        this.JTBPerno.setName("Perno");
        this.JTBPerno.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.40
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPernoActionPerformed(evt);
            }
        });
        this.JTBPernoDesadaptado.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPernoDesadaptado);
        this.JTBPernoDesadaptado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/PernoDesadaptado.png")));
        this.JTBPernoDesadaptado.setToolTipText("Perno Desadaptado");
        this.JTBPernoDesadaptado.setName("Perno Desadaptado");
        this.JTBPernoDesadaptado.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.41
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPernoDesadaptadoActionPerformed(evt);
            }
        });
        this.JTBPernoIndicado.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBPernoIndicado);
        this.JTBPernoIndicado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Perno Indicado.png")));
        this.JTBPernoIndicado.setToolTipText("Perno Indicado");
        this.JTBPernoIndicado.setName("Perno Indicado");
        this.JTBPernoIndicado.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.42
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBPernoIndicadoActionPerformed(evt);
            }
        });
        this.JTBAbrasion.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBAbrasion);
        this.JTBAbrasion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Abrasion.png")));
        this.JTBAbrasion.setToolTipText("Abrasion");
        this.JTBAbrasion.setName("Abrasion");
        this.JTBAbrasion.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.43
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBAbrasionActionPerformed(evt);
            }
        });
        this.JTBRestoRadicular.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBRestoRadicular);
        this.JTBRestoRadicular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Resto Radicular.png")));
        this.JTBRestoRadicular.setToolTipText("Resto Radicular");
        this.JTBRestoRadicular.setName("Resto Radicular");
        this.JTBRestoRadicular.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.44
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBRestoRadicularActionPerformed(evt);
            }
        });
        this.JTBBorrador.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBBorrador);
        this.JTBBorrador.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Borrador.png")));
        this.JTBBorrador.setToolTipText("Borrador (Quitar elemento)");
        this.JTBBorrador.setName("Borrador");
        this.JTBBorrador.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.45
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBBorradorActionPerformed(evt);
            }
        });
        this.JPEspecial.setBorder(BorderFactory.createTitledBorder((Border) null, "Especial", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JTBDxEspecial.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBDxEspecial);
        this.JTBDxEspecial.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Dx_Especial.png")));
        this.JTBDxEspecial.setToolTipText("Dianósticos Especiales");
        this.JTBDxEspecial.setName("Dx Especial");
        this.JTBDxEspecial.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.46
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBDxEspecialActionPerformed(evt);
            }
        });
        this.JTBProcEspecial.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBProcEspecial);
        this.JTBProcEspecial.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Pro_Especial.png")));
        this.JTBProcEspecial.setToolTipText("Procedimiento Especial");
        this.JTBProcEspecial.setName("Procedimiento Especial");
        this.JTBProcEspecial.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.47
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBProcEspecialActionPerformed(evt);
            }
        });
        this.JCHCompleto.setFont(new Font("Tahoma", 1, 11));
        this.JCHCompleto.setText("Completo?");
        this.JCHCompleto.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.48
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JCHCompletoActionPerformed(evt);
            }
        });
        GroupLayout JPEspecialLayout = new GroupLayout(this.JPEspecial);
        this.JPEspecial.setLayout(JPEspecialLayout);
        JPEspecialLayout.setHorizontalGroup(JPEspecialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEspecialLayout.createSequentialGroup().addComponent(this.JTBDxEspecial, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBProcEspecial, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHCompleto)));
        JPEspecialLayout.setVerticalGroup(JPEspecialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEspecialLayout.createSequentialGroup().addGroup(JPEspecialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBProcEspecial).addComponent(this.JTBDxEspecial).addComponent(this.JCHCompleto)).addContainerGap(39, 32767)));
        this.JTBSinErupcionar.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBSinErupcionar);
        this.JTBSinErupcionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Sin Erupcionar.png")));
        this.JTBSinErupcionar.setToolTipText("Sin erupcionar");
        this.JTBSinErupcionar.setMaximumSize(new Dimension(33, 52));
        this.JTBSinErupcionar.setMinimumSize(new Dimension(33, 52));
        this.JTBSinErupcionar.setName("Sin Erupcionar");
        this.JTBSinErupcionar.setPreferredSize(new Dimension(33, 52));
        this.JTBSinErupcionar.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.49
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBSinErupcionarActionPerformed(evt);
            }
        });
        this.JTBEnErupcion.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBEnErupcion);
        this.JTBEnErupcion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/En Erupción.png")));
        this.JTBEnErupcion.setToolTipText("En Erupción");
        this.JTBEnErupcion.setMaximumSize(new Dimension(33, 52));
        this.JTBEnErupcion.setMinimumSize(new Dimension(33, 52));
        this.JTBEnErupcion.setName("En erupcion");
        this.JTBEnErupcion.setPreferredSize(new Dimension(33, 52));
        this.JTBEnErupcion.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.50
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBEnErupcionActionPerformed(evt);
            }
        });
        this.JTBAtricion.setBackground(new Color(255, 204, 204));
        this.BGPaleta.add(this.JTBAtricion);
        this.JTBAtricion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/Convenciones/Atricion.png")));
        this.JTBAtricion.setToolTipText("Atricion");
        this.JTBAtricion.setMaximumSize(new Dimension(33, 52));
        this.JTBAtricion.setMinimumSize(new Dimension(33, 52));
        this.JTBAtricion.setName("Atricion");
        this.JTBAtricion.setPreferredSize(new Dimension(33, 52));
        this.JTBAtricion.addActionListener(new ActionListener() { // from class: Odontologia.JPPaletaConvenciones.51
            public void actionPerformed(ActionEvent evt) {
                JPPaletaConvenciones.this.JTBAtricionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTBResinaI, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBExtraccionClinica, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBExtraccionZDesdentada, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBExtraccionDPTrauma, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBExtraccionDiente, -2, 32, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTBExtraccionIndicada, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBSellanteBueno, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBSellanteIndicado, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBProvisionalBueno, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBProvisionalIndicado, -2, 32, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTBImplanteBueno, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBImplanteIndicado, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBCoronaBuena, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBCoronaIndicada, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBCoronaDesadaptada, -2, 32, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTBPuenteFCPDerecho, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBPuenteFCPDerechoP, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBPuenteFCPontico, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBPuenteFCPIzquierdoP, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBPuenteFCPIzquierdo, -2, 32, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTBObturacionIndMetalica, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBObturacionColPorcelana, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBRotacionMigracion, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBDienteSano, -2, 32, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTBDienteSemiIncluido, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBEndodonciaBuena, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBEndodonciaIndicada, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBEndodonciaDesadaptada, -2, 32, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBSinErupcionar, -2, 0, 32767).addComponent(this.JTBPernoDesadaptado, -2, 32, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBPernoIndicado, -2, 32, -2).addComponent(this.JTBEnErupcion, -2, 0, 32767)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBAbrasion, -2, 32, -2).addComponent(this.JTBAtricion, -2, 0, 32767)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBRestoRadicular, -2, 32, -2).addComponent(this.JTBBorrador, -2, 32, -2)))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBPerno, -2, 32, -2).addComponent(this.JTBDienteIncluido, -2, 32, -2))).addComponent(this.JPEspecial, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTBIonomeroB, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBIonomeroD, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBIonomeroI, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBResinaB, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBResinaD, -2, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTBCaries, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBFractura, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBRecidiva, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBAmalgamaB, -2, 32, -2).addGap(1, 1, 1).addComponent(this.JTBAmalgamaD, -2, 32, -2)))).addGap(21, 21, 21)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBFractura, -1, -1, 32767).addComponent(this.JTBRecidiva, -1, -1, 32767).addComponent(this.JTBAmalgamaB, -1, -1, 32767).addComponent(this.JTBAmalgamaD, -1, -1, 32767).addComponent(this.JTBCaries, -1, -1, 32767)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBIonomeroB).addComponent(this.JTBIonomeroD).addComponent(this.JTBResinaB).addComponent(this.JTBResinaD)).addComponent(this.JTBIonomeroI)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBResinaI).addComponent(this.JTBExtraccionClinica).addComponent(this.JTBExtraccionZDesdentada).addComponent(this.JTBExtraccionDPTrauma).addComponent(this.JTBExtraccionDiente)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBExtraccionIndicada).addComponent(this.JTBSellanteBueno).addComponent(this.JTBSellanteIndicado).addComponent(this.JTBProvisionalBueno).addComponent(this.JTBProvisionalIndicado)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBImplanteBueno).addComponent(this.JTBImplanteIndicado).addComponent(this.JTBCoronaBuena).addComponent(this.JTBCoronaIndicada).addComponent(this.JTBCoronaDesadaptada)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBPuenteFCPDerecho).addComponent(this.JTBPuenteFCPDerechoP).addComponent(this.JTBPuenteFCPontico).addComponent(this.JTBPuenteFCPIzquierdoP).addComponent(this.JTBPuenteFCPIzquierdo)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBObturacionIndMetalica).addComponent(this.JTBObturacionColPorcelana).addComponent(this.JTBRotacionMigracion).addComponent(this.JTBDienteSano).addComponent(this.JTBDienteIncluido)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBDienteSemiIncluido).addComponent(this.JTBEndodonciaBuena).addComponent(this.JTBEndodonciaIndicada).addComponent(this.JTBEndodonciaDesadaptada).addComponent(this.JTBPerno)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBPernoDesadaptado, -1, -1, 32767).addComponent(this.JTBPernoIndicado, -1, -1, 32767).addComponent(this.JTBAbrasion, -1, -1, 32767).addComponent(this.JTBRestoRadicular, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTBSinErupcionar, -2, 52, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBAtricion, -2, 52, -2).addComponent(this.JTBEnErupcion, -2, 52, -2).addComponent(this.JTBBorrador, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPEspecial, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRecidivaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRecidiva.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRecidiva.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRecidiva.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBIonomeroIActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroI.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroI.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroI.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionZDesdentadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionZDesdentada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionZDesdentada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionZDesdentada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSellanteIndicadoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBCoronaBuenaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaBuena.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaBuena.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaBuena.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteFCPonticoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPontico.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPontico.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPontico.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBCoronaDesadaptadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRotacionMigracionActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRotacionMigracion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRotacionMigracion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRotacionMigracion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBEndodonciaIndicadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAbrasionActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAbrasion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAbrasion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAbrasion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBFracturaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBFractura.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBFractura.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBFractura.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBCariesActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCaries.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCaries.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCaries.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAmalgamaBActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaB.getName();
                this.completo = 0L;
                this.jpodontograma.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaB.getName();
                this.completo = 0L;
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaB.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAmalgamaDActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAmalgamaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBIonomeroBActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroB.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroB.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroB.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBIonomeroDActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroD.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroD.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBIonomeroD.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResinaBActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaB.getName();
                this.completo = 0L;
                this.jpodontograma.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaB.getName();
                this.completo = 0L;
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaB.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResinaDActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaD.getName();
                this.completo = 0L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResinaIActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaI.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaI.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBResinaI.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionClinicaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionClinica.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionClinica.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionClinica.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionDPTraumaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDPTrauma.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDPTrauma.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDPTrauma.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionDienteActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDiente.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaComboProcedimientos();
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        } else if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDiente.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionDiente.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExtraccionIndicadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBExtraccionIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 0L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSellanteBuenoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteBueno.getName();
                this.completo = 1L;
                this.jpodontograma.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteBueno.getName();
                this.completo = 1L;
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSellanteBueno.getName();
                this.completo = 1L;
                this.jpodontogramaClinico.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBProvisionalBuenoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBProvisionalIndicadoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProvisionalIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBImplanteBuenoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteBueno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBImplanteIndicadoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBImplanteIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBCoronaIndicadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBCoronaIndicada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteFCPDerechoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerecho.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerecho.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerecho.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBObturacionColPorcelanaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionColPorcelana.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionColPorcelana.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionColPorcelana.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDienteSanoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSano.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSano.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSano.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDienteIncluidoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDienteSemiIncluidoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSemiIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSemiIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDienteSemiIncluido.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBEndodonciaBuenaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaBuena.getName();
                this.completo = 1L;
                this.jpodontograma.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaBuena.getName();
                this.completo = 1L;
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaBuena.getName();
                this.completo = 1L;
                this.jpodontogramaClinico.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBEndodonciaDesadaptadaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEndodonciaDesadaptada.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPernoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPerno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPerno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPerno.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPernoDesadaptadoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoDesadaptado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoDesadaptado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoDesadaptado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPernoIndicadoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPernoIndicado.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRestoRadicularActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRestoRadicular.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRestoRadicular.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBRestoRadicular.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteFCPDerechoPActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerechoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerechoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPDerechoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteFCPIzquierdoPActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdoP.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPuenteFCPIzquierdoActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdo.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdo.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBPuenteFCPIzquierdo.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBObturacionIndMetalicaActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionIndMetalica.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionIndMetalica.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBObturacionIndMetalica.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBBorradorActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.controlFigura = 0L;
        } else if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.controlFigura = 0L;
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.controlFigura = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDxEspecialActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDxEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDxEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBDxEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBProcEspecialActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProcEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                this.jpodontograma.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProcEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBProcEspecial.getName();
                if (this.JCHCompleto.isSelected()) {
                    this.completo = 1L;
                } else {
                    this.completo = 0L;
                }
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaComboProcedimientos();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCompletoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSinErupcionarActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSinErupcionar.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSinErupcionar.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBSinErupcionar.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBEnErupcionActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEnErupcion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEnErupcion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBEnErupcion.getName();
                this.completo = 1L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBAtricionActionPerformed(ActionEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            if (this.jpodontograma.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAtricion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontograma.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontograma, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            if (this.jpodontogramaInicial.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAtricion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaInicial, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.nombre.equals("jifOdontogramaClinico")) {
            if (this.jpodontogramaClinico.controlFigura == 0) {
                this.procedimientoPaleta = this.JTBAtricion.getName();
                this.completo = 0L;
                this.filtroCombo = 1L;
                this.jpodontogramaClinico.llenaCombo();
                return;
            }
            JOptionPane.showInternalMessageDialog(this.jpodontogramaClinico, "Debe agregar el Diagnóstico ó borrar la figura marcada para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mIniciarComponentes() {
    }
}
