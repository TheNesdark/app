package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPrenatalImpresion.class */
public class JPGraficasPrenatalImpresion extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private long idUsuarioPrograma;
    private long idUsuarioA;
    private Imagen Grafica;
    private Grafica2 GraficaPM;
    private Grafica2 GraficaPresion;
    private Grafica2 GraficaIMC;
    private JPanel JPGraficaIMC;
    private JPanel JPGrafico;
    private JPanel JPGraficoPM;
    private JPanel JPGraficoPresion;
    private JScrollPane JSPHistorico;
    public JTable JTBHistorico;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPGraficasPrenatalImpresion(long idUsuarioA, long xidUsuarioPrograma) {
        initComponents();
        this.idUsuarioPrograma = xidUsuarioPrograma;
        this.idUsuarioA = idUsuarioA;
        mBuscaHistorico();
        mIniciaPaneles();
    }

    public JPGraficasPrenatalImpresion() {
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JPGrafico = new JPanel();
        this.jPanel2 = new JPanel();
        this.JPGraficoPM = new JPanel();
        this.jPanel4 = new JPanel();
        this.JPGraficoPresion = new JPanel();
        this.jPanel3 = new JPanel();
        this.JPGraficaIMC = new JPanel();
        setOpaque(false);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        GroupLayout JPGraficoLayout = new GroupLayout(this.JPGrafico);
        this.JPGrafico.setLayout(JPGraficoLayout);
        JPGraficoLayout.setHorizontalGroup(JPGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 518, 32767));
        JPGraficoLayout.setVerticalGroup(JPGraficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 495, 32767));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGrafico, -2, -1, -2).addContainerGap(155, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPGrafico, -1, -1, 32767));
        this.jTabbedPane1.addTab("ALTURA UTERINA", this.jPanel1);
        this.JPGraficoPM.setPreferredSize(new Dimension(608, 456));
        GroupLayout JPGraficoPMLayout = new GroupLayout(this.JPGraficoPM);
        this.JPGraficoPM.setLayout(JPGraficoPMLayout);
        JPGraficoPMLayout.setHorizontalGroup(JPGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 410, 32767));
        JPGraficoPMLayout.setVerticalGroup(JPGraficoPMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 378, 32767));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficoPM, -2, 410, -2).addContainerGap(263, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPGraficoPM, -2, 378, -2).addGap(0, 117, 32767)));
        this.jTabbedPane1.addTab("PESO MATERNO", this.jPanel2);
        GroupLayout JPGraficoPresionLayout = new GroupLayout(this.JPGraficoPresion);
        this.JPGraficoPresion.setLayout(JPGraficoPresionLayout);
        JPGraficoPresionLayout.setHorizontalGroup(JPGraficoPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 458, 32767));
        JPGraficoPresionLayout.setVerticalGroup(JPGraficoPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 495, 32767));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficoPresion, -2, -1, -2).addContainerGap(215, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPGraficoPresion, -1, -1, 32767));
        this.jTabbedPane1.addTab("PRESION ARTERIAL", this.jPanel4);
        this.JPGraficaIMC.setOpaque(false);
        GroupLayout JPGraficaIMCLayout = new GroupLayout(this.JPGraficaIMC);
        this.JPGraficaIMC.setLayout(JPGraficaIMCLayout);
        JPGraficaIMCLayout.setHorizontalGroup(JPGraficaIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 661, 32767));
        JPGraficaIMCLayout.setVerticalGroup(JPGraficaIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 495, 32767));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JPGraficaIMC, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPGraficaIMC, -1, -1, 32767));
        this.jTabbedPane1.addTab("IMC EDAD G", this.jPanel3);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorico, -1, 734, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 690, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -2, 137, -2)));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("PRESION ARTERIAL");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"SGestación", "Alt. Uterina", "FC(cm)", "FR(r/m)", "T(°C)", "PS2", "PSistólica", "PDiastólica", "Talla", "Peso", "IMC", "AumentoPeso"}) { // from class: Historia.JPGraficasPrenatalImpresion.1
            Class[] types = {Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(15);
        this.JTBHistorico.getColumnModel().getColumn(11).setPreferredWidth(15);
    }

    private void mIniciaPaneles() {
        this.Grafica = null;
        this.Grafica = new Imagen(this);
        this.JPGrafico.add(this.Grafica);
        this.JPGrafico.repaint();
        this.GraficaPM = null;
        this.GraficaPM = new Grafica2(this, 0, 11, 24, 410, 371, "curva_peso_materno", 1);
        this.JPGraficoPM.add(this.GraficaPM);
        this.JPGraficoPM.repaint();
        this.GraficaPresion = null;
        this.GraficaPresion = new Grafica2(this, 0, 7, 25, 450, 450, "curva_presion_arterial", 1);
        this.JPGraficoPresion.add(this.GraficaPresion);
        this.JPGraficoPresion.repaint();
        this.GraficaIMC = null;
        this.GraficaIMC = new Grafica2(this, 0, 10, 51, 680, 479, "grafico-IMC-EdadGestacional-2465_New", 1);
        this.JPGraficaIMC.add(this.GraficaIMC);
        this.JPGraficaIMC.repaint();
    }

    public void GenerarScreeshot() {
        try {
            this.JPGrafico.repaint();
            this.xmetodo.saveScreenShot(this.JPGrafico, "AlturaUterina.png", "jpaexamenfisicoprenatal");
            this.JPGraficoPM.repaint();
            this.xmetodo.saveScreenShot(this.JPGraficoPM, "PesoMaterno.png", "jpaexamenfisicoprenatal");
            this.JPGraficaIMC.repaint();
            this.xmetodo.saveScreenShot(this.JPGraficaIMC, "ImcEdadGestacional.png", "jpaexamenfisicoprenatal");
            this.JPGraficoPresion.repaint();
            this.xmetodo.saveScreenShot(this.JPGraficoPresion, "PresionArterialD.png", "jpaexamenfisicoprenatal");
        } catch (Exception e) {
        }
    }

    private void mBuscaHistorico() {
        String sql = "SELECT h_examenfisico.`SGestacion`  , h_examenfisico.`AlturaUterina`  , h_examenfisico.`FCardiaca` , \nh_examenfisico.`FRespiratoria` , h_examenfisico.`Temperatura` , h_examenfisico.`Ps2`  , h_examenfisico.`TArtSentadoS` , \nh_examenfisico.`TArtSentadoD` , h_examenfisico.`Talla` , h_examenfisico.`Peso`  ,\nh_examenfisico.`IMC`, \nEF_UxP.Peso AS VO ,  \nIF(ROUND((h_examenfisico.`Peso`- EF_UxP.Peso),2)<0,'0.00',ROUND((h_examenfisico.`Peso`- EF_UxP.Peso),2))  AS Diferencia  \nFROM `h_examenfisico`\nINNER JOIN \n(SELECT g_usuarioxprograma.`Id`, h_examenfisico.`Peso`, h_examenfisico.`Id_Usuario_Programa`  \nFROM `h_examenfisico` \nINNER JOIN `g_usuarioxprograma` ON (`h_examenfisico`.`Id_Usuario_Programa` = `g_usuarioxprograma`.`Id`)  \nWHERE (h_examenfisico.`Id_Usuario_Programa` ='" + this.idUsuarioPrograma + "') \t\nORDER BY h_examenfisico.`SGestacion` ASC LIMIT 1) EF_UxP ON (h_examenfisico.`Id_Usuario_Programa`=EF_UxP.Id)\nWHERE (h_examenfisico.`Id_Usuario_Programa` ='" + this.idUsuarioPrograma + "')";
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 11);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPrenatalImpresion$Imagen.class */
    public class Imagen extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPGraficasPrenatalImpresion xJPAExamenFisicoPrenatal;

        public Imagen(JPGraficasPrenatalImpresion xJPAExamenFisicoPrenatalimpre) {
            setSize(516, 456);
            this.xJPAExamenFisicoPrenatal = xJPAExamenFisicoPrenatalimpre;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/Grafica_Altura_Uterina.png"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount() > -1) {
                int x = 0;
                int y = 0;
                this.xCoordenada = new int[this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount()][2];
                for (int j = 0; j < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j++) {
                    String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` =1  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 0).toString()) + "'<`RangoSUp` );";
                    ResultSet xrs = this.xct.traerRs(sql);
                    try {
                        if (xrs.next()) {
                            xrs.last();
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                x++;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` =1  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, 1).toString()) + "'<`RangoSUp`);";
                    ResultSet xrs2 = this.xct.traerRs(sql2);
                    try {
                        if (xrs2.next()) {
                            xrs2.beforeFirst();
                            while (xrs2.next()) {
                                this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                y++;
                            }
                        }
                        xrs2.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex2) {
                        Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                    }
                }
            }
            for (int i = 0; i < this.xCoordenada.length; i++) {
                try {
                    if (i != 0) {
                        grafico.setColor(Color.red);
                        g2.setStroke(new BasicStroke(2.0f));
                        g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                    }
                    dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(7.5f));
            g2.draw(new Line2D.Double(x, y, x, y));
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPrenatalImpresion$Grafica2.class */
    public class Grafica2 extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPGraficasPrenatalImpresion xJPAExamenFisicoPrenatal;
        private int x;
        private int y;
        private int xTipoGrafica;
        private int xCondicion;
        private String xImg;

        public Grafica2(JPGraficasPrenatalImpresion xJPAExamenFisicoPrenatal, int x, int y, int xTipoGrafica, int xWidth, int xHeigth, String xImg, int xCondicion) {
            setSize(xWidth, xHeigth);
            this.xJPAExamenFisicoPrenatal = xJPAExamenFisicoPrenatal;
            this.x = x;
            this.y = y;
            this.xTipoGrafica = xTipoGrafica;
            this.xImg = xImg;
            this.xCondicion = xCondicion;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/" + this.xImg + ".jpg"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount() > -1) {
                int x = 0;
                int y = 0;
                int xValoRango = 0;
                int xRangoFinal = 0;
                if (this.xCondicion == 0) {
                    this.xCoordenada = new int[this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount()][2];
                } else {
                    int xValor = 1;
                    for (int j = 0; j < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j++) {
                        if (this.xTipoGrafica == 24) {
                            xValoRango = 0;
                            xRangoFinal = 40;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 0 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 40) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        } else if (this.xTipoGrafica == 25) {
                            xValoRango = 24;
                            xRangoFinal = 41;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 24 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 41) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        } else if (this.xTipoGrafica == 51) {
                            xValoRango = 10;
                            xRangoFinal = 40;
                            if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) >= 10 && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j, this.x).toString()) <= 40) {
                                this.xCoordenada = new int[xValor][2];
                                xValor++;
                            }
                        }
                    }
                }
                for (int j2 = 0; j2 < this.xJPAExamenFisicoPrenatal.JTBHistorico.getRowCount(); j2++) {
                    if (this.xCondicion == 0) {
                        String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'<`RangoSUp` );";
                        ResultSet xrs = this.xct.traerRs(sql);
                        try {
                            if (xrs.next()) {
                                xrs.last();
                                xrs.beforeFirst();
                                while (xrs.next()) {
                                    this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                    x++;
                                }
                            }
                            xrs.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex) {
                            Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                        }
                        String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'<`RangoSUp`);";
                        ResultSet xrs2 = this.xct.traerRs(sql2);
                        try {
                            if (xrs2.next()) {
                                xrs2.beforeFirst();
                                while (xrs2.next()) {
                                    this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                    y++;
                                }
                            }
                            xrs2.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex2) {
                            Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    } else if (Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) >= xValoRango && Double.parseDouble(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) <= xRangoFinal) {
                        String sql3 = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.x).toString()) + "'<`RangoSUp` );";
                        ResultSet xrs3 = this.xct.traerRs(sql3);
                        try {
                            if (xrs3.next()) {
                                xrs3.last();
                                xrs3.beforeFirst();
                                while (xrs3.next()) {
                                    this.xCoordenada[x][0] = xrs3.getInt("Coordenada_X");
                                    x++;
                                }
                            }
                            xrs3.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex3) {
                            Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                        }
                        String sql4 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(this.xJPAExamenFisicoPrenatal.JTBHistorico.getValueAt(j2, this.y).toString()) + "'<`RangoSUp`);";
                        ResultSet xrs22 = this.xct.traerRs(sql4);
                        try {
                            if (xrs22.next()) {
                                xrs22.beforeFirst();
                                while (xrs22.next()) {
                                    this.xCoordenada[y][1] = xrs22.getInt("Coordenada_Y");
                                    y++;
                                }
                            }
                            xrs22.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex4) {
                            Logger.getLogger(JPAExamenFisicoPrenatal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                        }
                    }
                }
                try {
                    if (this.xCoordenada != null) {
                        for (int i = 0; i < this.xCoordenada.length; i++) {
                            if (i != 0) {
                                grafico.setColor(Color.red);
                                g2.setStroke(new BasicStroke(2.0f));
                                g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                            }
                            dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            setOpaque(false);
            super.paintComponent(grafico);
        }

        private void dibuja_coordenada(Graphics2D g2, double x, double y) {
            NumberFormat mf = NumberFormat.getInstance();
            mf.setMaximumFractionDigits(2);
            g2.setColor(new Color(0, 0, 255));
            g2.setStroke(new BasicStroke(7.5f));
            g2.draw(new Line2D.Double(x, y, x, y));
        }
    }

    private void mGuardarGrafica(JPanel xpanel, long xidGrafica) {
        if (!this.xmetodo.mVerificaExistenciaGrafica(xidGrafica)) {
            String sqlIs = "INSERT INTO  `p_usuario_grafica` (`IdUsuario`, `IdUsuarioPrograma`, `IdGrafica`, `Ruta`, `UsuarioS`) VALUES('" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()) + "','" + String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()) + "','" + xidGrafica + "','" + xidGrafica + ".jpg','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            ConsultasMySQL xctI = new ConsultasMySQL();
            xctI.ejecutarSQL(sqlIs);
            xctI.cerrarConexionBd();
        }
    }
}
