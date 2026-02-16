package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.ExamenFisicoCyD_DAO;
import com.genoma.plus.dao.impl.historia.ExamenFisicoCyD_DAOImpl;
import com.genoma.plus.dto.historia.ExamenFisicoCyD_DTO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasCyDImpresion.class */
public class JPGraficasCyDImpresion extends JPanel {
    private DefaultTableModel xmodelo;
    private List<ExamenFisicoCyD_DTO> lstExamenFisicoCyD;
    private ExamenFisicoCyD_DAO examenFisicoCyD_DAO;
    private long xidUsuarioPrograma;
    private Object[] xdato;
    private long idUsuarioA;
    private JPGraficasPyP_Res2465[] xJPGraficasPyP_Res2465;
    private List<Object[]> lstGraficas;
    private JPanel JPGrafica;
    private JScrollPane JSPGraficas1;
    private JScrollPane JSPHistorico;
    public JTable JTBHistorico;
    private String xedad = "";
    private int xEdadActual = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean okSS = false;

    public JPGraficasCyDImpresion(long idUsuarioA, long xidUsuarioPrograma) {
        initComponents();
        this.idUsuarioA = idUsuarioA;
        this.xidUsuarioPrograma = xidUsuarioPrograma;
        mConsultaFechaNacFormatoMes();
        this.examenFisicoCyD_DAO = (ExamenFisicoCyD_DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("examenFisicoCyD_DAO");
        mRenderGrafica();
    }

    private void mConsultaFechaNacFormatoMes() {
        String sql = "SELECT DATE_FORMAT(`FechaNac`,'%Y%m')AS FechaNac, FechaNac AS AnioNac FROM `persona` WHERE (`Id_persona` ='" + this.idUsuarioA + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xedad = xrs.getString(1);
                this.xEdadActual = Integer.valueOf(this.xmt.entregarEdadEnMeses(xrs.getString(2))).intValue();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPGraficas1 = new JScrollPane();
        this.JPGrafica = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        setName("GraficasCyD");
        this.JPGrafica.setMaximumSize(new Dimension(896, 590));
        this.JPGrafica.setMinimumSize(new Dimension(896, 590));
        GroupLayout JPGraficaLayout = new GroupLayout(this.JPGrafica);
        this.JPGrafica.setLayout(JPGraficaLayout);
        JPGraficaLayout.setHorizontalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 896, 32767));
        JPGraficaLayout.setVerticalGroup(JPGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 590, 32767));
        this.JSPGraficas1.setViewportView(this.JPGrafica);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPGraficas1, GroupLayout.Alignment.TRAILING, -1, 762, 32767).addComponent(this.JSPHistorico, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPGraficas1, -2, 188, -2).addGap(35, 35, 35).addComponent(this.JSPHistorico, -2, 185, -2).addGap(5, 5, 5)));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "FC(r/m)", "T(°C)", "Presión", "Edad(Mes)", "Talla(cm)", "Peso(Kg)", "IMC", "Per.Cefálico", "FR(r/m)", "Per.Brazo"}) { // from class: Historia.JPGraficasCyDImpresion.1
            Class[] types = {String.class, Double.class, Double.class, String.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTBHistorico.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(10).setPreferredWidth(50);
    }

    private void mBuscaHistorico() {
        this.lstExamenFisicoCyD = this.examenFisicoCyD_DAO.listaDetalleExamenFisico((int) this.xidUsuarioPrograma, this.xedad);
        mCrearModeloDatos();
        int n = 0;
        for (ExamenFisicoCyD_DTO examenFisicoCyD_DTO : this.lstExamenFisicoCyD) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(examenFisicoCyD_DTO.getFecha(), n, 0);
            this.xmodelo.setValueAt(examenFisicoCyD_DTO.getFc(), n, 1);
            this.xmodelo.setValueAt(examenFisicoCyD_DTO.getTemperatura(), n, 2);
            this.xmodelo.setValueAt(examenFisicoCyD_DTO.getPresion(), n, 3);
            this.xmodelo.setValueAt(Integer.valueOf(examenFisicoCyD_DTO.getEdad()), n, 4);
            this.xmodelo.setValueAt(Double.valueOf(examenFisicoCyD_DTO.getTalla()), n, 5);
            this.xmodelo.setValueAt(Double.valueOf(examenFisicoCyD_DTO.getPeso()), n, 6);
            this.xmodelo.setValueAt(Double.valueOf(examenFisicoCyD_DTO.getImc()), n, 7);
            this.xmodelo.setValueAt(Double.valueOf(examenFisicoCyD_DTO.getPerimetroCefalico()), n, 8);
            this.xmodelo.setValueAt(examenFisicoCyD_DTO.getFr(), n, 9);
            this.xmodelo.setValueAt(Double.valueOf(examenFisicoCyD_DTO.getPerimetroBrazo()), n, 10);
            n++;
        }
    }

    private void mRenderGrafica() {
        this.lstGraficas = this.examenFisicoCyD_DAO.listaGraficasGuardadas_IdUsuarioPrograma(this.xidUsuarioPrograma);
        int cantidadGraficas = this.lstGraficas.size();
        if (cantidadGraficas > 0) {
            this.xJPGraficasPyP_Res2465 = new JPGraficasPyP_Res2465[cantidadGraficas];
        }
        for (int i = 0; i < cantidadGraficas; i++) {
            this.xJPGraficasPyP_Res2465[i] = new JPGraficasPyP_Res2465();
            this.xJPGraficasPyP_Res2465[i].setVisible(true);
            this.xJPGraficasPyP_Res2465[i].setBounds(i * 50, 1, 896, 630);
            this.JPGrafica.add(this.xJPGraficasPyP_Res2465[i]);
            this.JPGrafica.repaint();
            this.JPGrafica.revalidate();
        }
    }

    public void mGeneraGrafico_ScreenShot() {
        mBuscaHistorico();
        int n = 0;
        for (int j = 0; j < this.lstGraficas.size(); j++) {
            Imagen Grafica = new Imagen(this.lstGraficas.get(j)[1].toString(), this.lstGraficas.get(j)[2].toString(), Integer.valueOf(this.lstGraficas.get(j)[3].toString()).intValue(), Integer.valueOf(this.lstGraficas.get(j)[4].toString()).intValue(), Integer.valueOf(this.lstGraficas.get(j)[0].toString()).intValue(), this.xJPGraficasPyP_Res2465[n].JPGraficaImage1, 0L, 24L, this.lstGraficas.get(j)[5].toString());
            this.xJPGraficasPyP_Res2465[n].JLTitulo.setText(this.lstGraficas.get(j)[1].toString());
            this.xJPGraficasPyP_Res2465[n].JPGraficaImage1.add(Grafica);
            this.xJPGraficasPyP_Res2465[n].JPGraficaImage1.repaint();
            try {
                this.xmt.saveScreenShot(this.xJPGraficasPyP_Res2465[n], this.lstGraficas.get(j)[2].toString() + ".png", "GraficasCyD");
            } catch (Exception ex) {
                Logger.getLogger(JPGraficasCyDImpresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            n++;
        }
        setOkSS(true);
    }

    private void mGuardarGraficaRuta(Component xpanel, long xidGrafica) {
        try {
            xpanel.revalidate();
            xpanel.repaint();
            this.xmt.saveScreenShot(xpanel, "panelGracficasCyD" + xidGrafica + ".png", "GraficasCyD");
        } catch (Exception ex) {
            Logger.getLogger(JPGraficasCyDImpresion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasCyDImpresion$Imagen.class */
    public class Imagen extends JPanel {
        private int[][] xCoordenada;
        private ConsultasMySQL xct = new ConsultasMySQL();
        private JPGraficasPyP xJPGraficasPyP;
        private String xImagen;
        private String xtitulo;
        private int x;
        private int y;
        private int xTipoGrafica;
        private long xRangoX;
        private long xRangoY;
        private String folder;
        private JPanel xpanel;

        public Imagen(String xTitulo, String xImagen, int x, int y, int xTipoGrafica, JPanel xPanel, long xRangoX, long xRangoY, String sexo) {
            this.x = 0;
            this.y = 0;
            this.xTipoGrafica = 0;
            this.xRangoX = 0L;
            this.xRangoY = 0L;
            setBounds(0, 0, 896, 570);
            this.xImagen = xImagen;
            if (sexo.equals("M")) {
                this.folder = "Niños";
            } else {
                this.folder = "Niñas";
            }
            this.x = x;
            this.y = y;
            this.xTipoGrafica = xTipoGrafica;
            this.xtitulo = xTitulo;
            this.xRangoX = xRangoX;
            this.xRangoY = xRangoY;
            this.xpanel = xPanel;
        }

        public void paint(Graphics grafico) {
            Graphics2D g2 = (Graphics2D) grafico;
            Dimension height = getSize();
            ImageIcon Img = new ImageIcon(getClass().getResource("/Imagenes/GraficasCyD/" + this.folder + "/" + this.xImagen + ".PNG"));
            grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, (ImageObserver) null);
            if (JPGraficasCyDImpresion.this.JTBHistorico.getRowCount() > -1) {
                int xData = 0;
                int x = 0;
                int y = 0;
                this.xCoordenada = new int[JPGraficasCyDImpresion.this.JTBHistorico.getRowCount()][2];
                for (int j = 0; j < JPGraficasCyDImpresion.this.JTBHistorico.getRowCount(); j++) {
                    String sql = " SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))) AS CM_en_PX  , ('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf))))) AS CM_en_Px_Graf  , ((('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.x).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))+ValorPXinf) AS Coordenada_X  FROM `p_tabla_referencia` WHERE (`Eje` ='x'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.x).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.x).toString()) + "'<`RangoSUp` );";
                    ResultSet xrs = this.xct.traerRs(sql);
                    try {
                        if (xrs.next()) {
                            xrs.last();
                            xrs.beforeFirst();
                            while (xrs.next()) {
                                this.xCoordenada[x][0] = xrs.getInt("Coordenada_X");
                                x++;
                                xData = 1;
                            }
                        }
                        xrs.close();
                        this.xct.cerrarConexionBd();
                    } catch (SQLException ex) {
                        Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                    if (xData == 1) {
                        String sql2 = "SELECT `RangoInf` , `RangoSUp`  , `ValorPXinf` , `ValorPXSup`  ,(RangoSUp-RangoInf) AS CantidadNo  ,(ValorPXSup-ValorPXinf)*(-1) AS CantPX  ,ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))*(-1) AS CM_en_PX  , ('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf) AS Diferencia  , (('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))*(-1) AS CM_en_Px_Graf  , (ValorPXinf+(('" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.y).toString()) + "'-RangoInf)*(ROUND(((ValorPXSup-ValorPXinf)/(RangoSUp-RangoInf)))))) AS Coordenada_Y  FROM `p_tabla_referencia` WHERE (`Eje` ='y'  AND `IdTipoGrafica` ='" + this.xTipoGrafica + "'  AND '" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.y).toString()) + "'>=`RangoInf`  AND '" + Double.valueOf(JPGraficasCyDImpresion.this.JTBHistorico.getValueAt(j, this.y).toString()) + "'<`RangoSUp`);";
                        ResultSet xrs2 = this.xct.traerRs(sql2);
                        try {
                            if (xrs2.next()) {
                                xrs2.beforeFirst();
                                while (xrs2.next()) {
                                    this.xCoordenada[y][1] = xrs2.getInt("Coordenada_Y");
                                    y++;
                                    xData = 0;
                                }
                            }
                            xrs2.close();
                            this.xct.cerrarConexionBd();
                        } catch (SQLException ex2) {
                            Logger.getLogger(JPGraficasPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                        }
                    }
                }
            }
            for (int i = 0; i < this.xCoordenada.length; i++) {
                try {
                    if (i != 0) {
                        grafico.setColor(Color.red);
                        if (this.xCoordenada[i][0] > 0 && this.xCoordenada[i][1] > 0) {
                            g2.setStroke(new BasicStroke(4.0f));
                            g2.draw(new Line2D.Double(this.xCoordenada[i - 1][0], this.xCoordenada[i - 1][1], this.xCoordenada[i][0], this.xCoordenada[i][1]));
                        }
                    }
                    if (this.xCoordenada[i][0] != 0 && this.xCoordenada[i][1] != 0) {
                        dibuja_coordenada(g2, this.xCoordenada[i][0], this.xCoordenada[i][1]);
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
            g2.setStroke(new BasicStroke(9.5f));
            g2.fill(new Ellipse2D.Double(x, y - 8.0d, 13.0d, 13.0d));
        }
    }

    public JPGraficasPyP_Res2465[] getxJPGraficasPyP_Res2465() {
        return this.xJPGraficasPyP_Res2465;
    }

    public boolean isOkSS() {
        return this.okSS;
    }

    public void setOkSS(boolean okSS) {
        this.okSS = okSS;
    }
}
