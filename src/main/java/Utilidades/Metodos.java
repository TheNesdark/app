package Utilidades;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import General.Persona;
import Historia.ANewJDialog;
import Historia.clasesHistoriaCE;
import Laboratorio.JIFPlanillaTrabajo;
import Odontologia.JPControlPlaca;
import Odontologia.JPOdontograma;
import Odontologia.JPOdontogramaCPCompleto;
import Odontologia.JPOdontogramaControlPlaca;
import Odontologia.JPOdontogramaDientes;
import Odontologia.JPOdontogramaInicial;
import Utilidades.Interceptores.InteceptorOrdenamientoMedico;
import Utilidades.Interceptores.InterceptorManager;
import co.com.genomaempresarial.signer.business.Signer;
import co.com.genomaempresarial.signer.dto.PdfRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi;
import com.genoma.plus.controller.general.JDHistoricoTrazabilidad;
import com.genoma.plus.controller.general.JD_EncuestaIngreso;
import com.genoma.plus.controller.general.JIFFActividadEconomica;
import com.genoma.plus.controller.historia.dto.OrdenamientoMedico;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.InfoRecepcion;
import com.genoma.plus.controller.laboratorio.dto.StickerPrintDto;
import com.genoma.plus.controller.laboratorio.dto.StickerSettingsDTO;
import com.genoma.plus.controller.laboratorio.dto.TrackingDomain;
import com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO;
import com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.trazabilidad.DetalleProcesoDTO;
import com.genoma.plus.dto.trazabilidad.TrazabilidadProcesoDTO;
import com.genoma.plus.jpa.entities.FirmaDigitalDTO;
import com.genoma.plus.jpa.entities.GModuloCorreo;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.projection.StikerProjection;
import com.genoma.plus.jpa.service.IFirmaDigitalDAO;
import com.genoma.plus.jpa.service.IGModuloCorreoService;
import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.DocumentException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.print.PrinterJob;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import jcifs.CIFSContext;
import jcifs.CIFSException;
import jcifs.config.PropertyConfiguration;
import jcifs.context.BaseContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbFile;
import lombok.Generated;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient4Engine;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Metodos.class */
public class Metodos {
    private ConsultasMySQL consultas;
    private GregorianCalendar fechaActual;
    private GregorianCalendar fechaActualPC;
    public SimpleDateFormat formatoAMD_Rips;
    public SimpleDateFormat formatoAMD_r202;
    public SimpleDateFormat formatoAMD;
    public SimpleDateFormat formatoTXT;
    public SimpleDateFormat formatoAMD1;
    public SimpleDateFormat formatoANO;
    public SimpleDateFormat formatoANO_MES;
    public SimpleDateFormat formatoMes;
    public SimpleDateFormat formatoDia;
    public SimpleDateFormat formatoMesAno;
    public SimpleDateFormat formatoMesAno1;
    public SimpleDateFormat formatoAMDG;
    public SimpleDateFormat formatoDMA;
    public SimpleDateFormat formatoDMA1;
    public SimpleDateFormat formatoAMDH24;
    public SimpleDateFormat formatoAMDH24_1;
    public SimpleDateFormat formatoDMAH24;
    public SimpleDateFormat formatoDMAH24_1;
    public SimpleDateFormat formatoDMAH24_Unida;
    public SimpleDateFormat formatoH24_Unida;
    public SimpleDateFormat formatoAMD_Unida;
    public SimpleDateFormat formatoAMD_Unida1;
    public SimpleDateFormat formatoAMDH12;
    public SimpleDateFormat formatoDMAH12;
    public SimpleDateFormat formatoH12;
    public SimpleDateFormat formatoH24;
    public SimpleDateFormat formatoH24A;
    public SimpleDateFormat formatoFecha;
    public DecimalFormat formatoMoneda;
    public DecimalFormat formatoMoneda1;
    public DecimalFormat formatoMonedaDosPosicionDecimal;
    public SimpleDateFormat formatoDMAH24_2;
    public SimpleDateFormat formatoISO8601;
    public DateTimeFormatter formatter;
    public DateTimeFormatter formatterFecha;
    private String xsql;
    private ConsultasMySQL xct;
    private Boolean fimarDoc;
    private Dimension dime;
    public DefaultTableModel modcombos;
    private String titulo;
    private String xAtencion;
    private JPOdontogramaDientes xJPOdontogramaDientes;
    private JPOdontogramaDientes xJPOdontogramaDientesDx;
    private JPOdontogramaDientes xJPOdontogramaDientesProc;
    private JPOdontogramaControlPlaca xJPOdontogramaControlPlaca;
    private JPOdontogramaCPCompleto xJPOdontogramaCPCompleto;
    private JPanel xPanel;
    public SXSSFWorkbook workbook;
    private Font headerFont;
    private Font contentFont;
    private Font titleFont;
    private Font numericFont;
    private CellStyle headerStyle;
    private CellStyle bodyRowStyle;
    private CellStyle titleStyle;
    private CellStyle numericStyle;
    private CellStyle dateFormat;
    private final IFirmaDigitalDAO firmaDigitalDAO;
    private final IGModuloCorreoService correoService;
    private ConsultasMySQL xconsultasbd;
    private final String EXPRESION_REGULAR_COREO = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    private GModuloCorreo moduloCorreo;
    private static String username = "root";
    private static String password = "GenomaPlus2@";

    @Generated
    public ConsultasMySQL getConsultas() {
        return this.consultas;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD_Rips() {
        return this.formatoAMD_Rips;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD_r202() {
        return this.formatoAMD_r202;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD() {
        return this.formatoAMD;
    }

    @Generated
    public SimpleDateFormat getFormatoTXT() {
        return this.formatoTXT;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD1() {
        return this.formatoAMD1;
    }

    @Generated
    public SimpleDateFormat getFormatoANO() {
        return this.formatoANO;
    }

    @Generated
    public SimpleDateFormat getFormatoANO_MES() {
        return this.formatoANO_MES;
    }

    @Generated
    public SimpleDateFormat getFormatoMes() {
        return this.formatoMes;
    }

    @Generated
    public SimpleDateFormat getFormatoDia() {
        return this.formatoDia;
    }

    @Generated
    public SimpleDateFormat getFormatoMesAno() {
        return this.formatoMesAno;
    }

    @Generated
    public SimpleDateFormat getFormatoMesAno1() {
        return this.formatoMesAno1;
    }

    @Generated
    public SimpleDateFormat getFormatoAMDG() {
        return this.formatoAMDG;
    }

    @Generated
    public SimpleDateFormat getFormatoDMA() {
        return this.formatoDMA;
    }

    @Generated
    public SimpleDateFormat getFormatoDMA1() {
        return this.formatoDMA1;
    }

    @Generated
    public SimpleDateFormat getFormatoAMDH24() {
        return this.formatoAMDH24;
    }

    @Generated
    public SimpleDateFormat getFormatoAMDH24_1() {
        return this.formatoAMDH24_1;
    }

    @Generated
    public SimpleDateFormat getFormatoDMAH24() {
        return this.formatoDMAH24;
    }

    @Generated
    public SimpleDateFormat getFormatoDMAH24_1() {
        return this.formatoDMAH24_1;
    }

    @Generated
    public SimpleDateFormat getFormatoDMAH24_Unida() {
        return this.formatoDMAH24_Unida;
    }

    @Generated
    public SimpleDateFormat getFormatoH24_Unida() {
        return this.formatoH24_Unida;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD_Unida() {
        return this.formatoAMD_Unida;
    }

    @Generated
    public SimpleDateFormat getFormatoAMD_Unida1() {
        return this.formatoAMD_Unida1;
    }

    @Generated
    public SimpleDateFormat getFormatoAMDH12() {
        return this.formatoAMDH12;
    }

    @Generated
    public SimpleDateFormat getFormatoDMAH12() {
        return this.formatoDMAH12;
    }

    @Generated
    public SimpleDateFormat getFormatoH12() {
        return this.formatoH12;
    }

    @Generated
    public SimpleDateFormat getFormatoH24() {
        return this.formatoH24;
    }

    @Generated
    public SimpleDateFormat getFormatoH24A() {
        return this.formatoH24A;
    }

    @Generated
    public SimpleDateFormat getFormatoFecha() {
        return this.formatoFecha;
    }

    @Generated
    public DecimalFormat getFormatoMoneda() {
        return this.formatoMoneda;
    }

    @Generated
    public DecimalFormat getFormatoMoneda1() {
        return this.formatoMoneda1;
    }

    @Generated
    public DecimalFormat getFormatoMonedaDosPosicionDecimal() {
        return this.formatoMonedaDosPosicionDecimal;
    }

    @Generated
    public SimpleDateFormat getFormatoDMAH24_2() {
        return this.formatoDMAH24_2;
    }

    @Generated
    public SimpleDateFormat getFormatoISO8601() {
        return this.formatoISO8601;
    }

    @Generated
    public DateTimeFormatter getFormatter() {
        return this.formatter;
    }

    @Generated
    public DateTimeFormatter getFormatterFecha() {
        return this.formatterFecha;
    }

    @Generated
    public String getXsql() {
        return this.xsql;
    }

    @Generated
    public ConsultasMySQL getXct() {
        return this.xct;
    }

    @Generated
    public Dimension getDime() {
        return this.dime;
    }

    @Generated
    public DefaultTableModel getModcombos() {
        return this.modcombos;
    }

    @Generated
    public String getTitulo() {
        return this.titulo;
    }

    @Generated
    public String getXAtencion() {
        return this.xAtencion;
    }

    @Generated
    public JPOdontogramaDientes getXJPOdontogramaDientes() {
        return this.xJPOdontogramaDientes;
    }

    @Generated
    public JPOdontogramaDientes getXJPOdontogramaDientesDx() {
        return this.xJPOdontogramaDientesDx;
    }

    @Generated
    public JPOdontogramaDientes getXJPOdontogramaDientesProc() {
        return this.xJPOdontogramaDientesProc;
    }

    @Generated
    public JPOdontogramaControlPlaca getXJPOdontogramaControlPlaca() {
        return this.xJPOdontogramaControlPlaca;
    }

    @Generated
    public JPOdontogramaCPCompleto getXJPOdontogramaCPCompleto() {
        return this.xJPOdontogramaCPCompleto;
    }

    @Generated
    public JPanel getXPanel() {
        return this.xPanel;
    }

    @Generated
    public SXSSFWorkbook getWorkbook() {
        return this.workbook;
    }

    @Generated
    public Font getHeaderFont() {
        return this.headerFont;
    }

    @Generated
    public Font getContentFont() {
        return this.contentFont;
    }

    @Generated
    public Font getTitleFont() {
        return this.titleFont;
    }

    @Generated
    public Font getNumericFont() {
        return this.numericFont;
    }

    @Generated
    public CellStyle getHeaderStyle() {
        return this.headerStyle;
    }

    @Generated
    public CellStyle getBodyRowStyle() {
        return this.bodyRowStyle;
    }

    @Generated
    public CellStyle getTitleStyle() {
        return this.titleStyle;
    }

    @Generated
    public CellStyle getNumericStyle() {
        return this.numericStyle;
    }

    @Generated
    public CellStyle getDateFormat() {
        return this.dateFormat;
    }

    @Generated
    public IFirmaDigitalDAO getFirmaDigitalDAO() {
        return this.firmaDigitalDAO;
    }

    @Generated
    public IGModuloCorreoService getCorreoService() {
        return this.correoService;
    }

    @Generated
    public ConsultasMySQL getXconsultasbd() {
        return this.xconsultasbd;
    }

    @Generated
    public String getEXPRESION_REGULAR_COREO() {
        getClass();
        return "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    }

    @Generated
    public GModuloCorreo getModuloCorreo() {
        return this.moduloCorreo;
    }

    public Metodos() {
        this.consultas = new ConsultasMySQL();
        this.formatoAMD_Rips = new SimpleDateFormat("ddMMyy");
        this.formatoAMD_r202 = new SimpleDateFormat("ddMMyyyy");
        this.formatoAMD = new SimpleDateFormat("yyyy/MM/dd");
        this.formatoTXT = new SimpleDateFormat("yyyy,MM,dd");
        this.formatoAMD1 = new SimpleDateFormat("yyyy-MM-dd");
        this.formatoANO = new SimpleDateFormat("yyyy");
        this.formatoANO_MES = new SimpleDateFormat("yyyy-MM");
        this.formatoMes = new SimpleDateFormat("MM");
        this.formatoDia = new SimpleDateFormat("dd");
        this.formatoMesAno = new SimpleDateFormat("MM-yyyy");
        this.formatoMesAno1 = new SimpleDateFormat("MMyyyy");
        this.formatoAMDG = new SimpleDateFormat("yyyy-MM-dd");
        this.formatoDMA = new SimpleDateFormat("dd/MM/yyyy");
        this.formatoDMA1 = new SimpleDateFormat("dd-MM-yyyy");
        this.formatoAMDH24 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.formatoAMDH24_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.formatoDMAH24 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.formatoDMAH24_1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.formatoDMAH24_Unida = new SimpleDateFormat("yyyyMMddHHmmss");
        this.formatoH24_Unida = new SimpleDateFormat("HHmm");
        this.formatoAMD_Unida = new SimpleDateFormat("yyyyMMdd");
        this.formatoAMD_Unida1 = new SimpleDateFormat("ddMMyyyy");
        this.formatoAMDH12 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
        this.formatoDMAH12 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        this.formatoH12 = new SimpleDateFormat("hh:mm:ss a");
        this.formatoH24 = new SimpleDateFormat("HH:mm:ss");
        this.formatoH24A = new SimpleDateFormat("HH:mm a");
        this.formatoFecha = new SimpleDateFormat("MMMMMMMMMM dd 'de' yyyy");
        this.formatoMoneda = new DecimalFormat("#,##0");
        this.formatoMoneda1 = new DecimalFormat("###0");
        this.formatoMonedaDosPosicionDecimal = new DecimalFormat(" #,##0.00");
        this.formatoDMAH24_2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.formatoISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.formatterFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.xct = new ConsultasMySQL();
        this.fimarDoc = true;
        this.dime = Toolkit.getDefaultToolkit().getScreenSize();
        this.titulo = "G@noma Soft";
        this.xAtencion = "";
        this.firmaDigitalDAO = (IFirmaDigitalDAO) Principal.contexto.getBean(IFirmaDigitalDAO.class);
        this.correoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.xconsultasbd = new ConsultasMySQL();
        this.EXPRESION_REGULAR_COREO = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
    }

    public Metodos(boolean firma) {
        this.consultas = new ConsultasMySQL();
        this.formatoAMD_Rips = new SimpleDateFormat("ddMMyy");
        this.formatoAMD_r202 = new SimpleDateFormat("ddMMyyyy");
        this.formatoAMD = new SimpleDateFormat("yyyy/MM/dd");
        this.formatoTXT = new SimpleDateFormat("yyyy,MM,dd");
        this.formatoAMD1 = new SimpleDateFormat("yyyy-MM-dd");
        this.formatoANO = new SimpleDateFormat("yyyy");
        this.formatoANO_MES = new SimpleDateFormat("yyyy-MM");
        this.formatoMes = new SimpleDateFormat("MM");
        this.formatoDia = new SimpleDateFormat("dd");
        this.formatoMesAno = new SimpleDateFormat("MM-yyyy");
        this.formatoMesAno1 = new SimpleDateFormat("MMyyyy");
        this.formatoAMDG = new SimpleDateFormat("yyyy-MM-dd");
        this.formatoDMA = new SimpleDateFormat("dd/MM/yyyy");
        this.formatoDMA1 = new SimpleDateFormat("dd-MM-yyyy");
        this.formatoAMDH24 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        this.formatoAMDH24_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.formatoDMAH24 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.formatoDMAH24_1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.formatoDMAH24_Unida = new SimpleDateFormat("yyyyMMddHHmmss");
        this.formatoH24_Unida = new SimpleDateFormat("HHmm");
        this.formatoAMD_Unida = new SimpleDateFormat("yyyyMMdd");
        this.formatoAMD_Unida1 = new SimpleDateFormat("ddMMyyyy");
        this.formatoAMDH12 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
        this.formatoDMAH12 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
        this.formatoH12 = new SimpleDateFormat("hh:mm:ss a");
        this.formatoH24 = new SimpleDateFormat("HH:mm:ss");
        this.formatoH24A = new SimpleDateFormat("HH:mm a");
        this.formatoFecha = new SimpleDateFormat("MMMMMMMMMM dd 'de' yyyy");
        this.formatoMoneda = new DecimalFormat("#,##0");
        this.formatoMoneda1 = new DecimalFormat("###0");
        this.formatoMonedaDosPosicionDecimal = new DecimalFormat(" #,##0.00");
        this.formatoDMAH24_2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        this.formatoISO8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        this.formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.formatterFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.xct = new ConsultasMySQL();
        this.fimarDoc = true;
        this.dime = Toolkit.getDefaultToolkit().getScreenSize();
        this.titulo = "G@noma Soft";
        this.xAtencion = "";
        this.firmaDigitalDAO = (IFirmaDigitalDAO) Principal.contexto.getBean(IFirmaDigitalDAO.class);
        this.correoService = (IGModuloCorreoService) Principal.contexto.getBean(IGModuloCorreoService.class);
        this.xconsultasbd = new ConsultasMySQL();
        this.EXPRESION_REGULAR_COREO = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        this.fimarDoc = Boolean.valueOf(firma);
    }

    public void cargarDecoracion() {
    }

    public void mIniciarPanel(JPanel xpanel) {
        this.xPanel = xpanel;
    }

    public void valiacionCaracterComillaSimpleTextPane(KeyEvent evt, JTextPane cajaTexto) {
        if (evt.getKeyCode() == 222) {
            JOptionPane.showMessageDialog((Component) null, "Caracter no valido para este campo", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            cajaTexto.setText(cajaTexto.getText().substring(0, cajaTexto.getText().length() - 1));
            cajaTexto.requestFocus();
        }
    }

    public void valiacionCaracterComillaSimpleTextArea(KeyEvent evt, JTextArea cajaTexto) {
        if (evt.getKeyCode() == 222) {
            JOptionPane.showMessageDialog((Component) null, "Caracter no valido para este campo", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            cajaTexto.setText(cajaTexto.getText().substring(0, cajaTexto.getText().length() - 1));
            cajaTexto.requestFocus();
        }
    }

    public LocalDateTime formadFecha(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(fecha, formatter);
        System.out.println(date);
        return date;
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0096: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:20:0x0096 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x009a: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x009a */
    public void fechaorigen(String documento) {
        this.xsql = "SELECT * FROM ll_datos_basicos WHERE Documento='" + documento + "' AND Consultorio='" + Principal.consultorio + "' AND Original=1 ";
        System.out.println(this.xsql);
        try {
            try {
                ResultSet rs = this.xct.traerRs(this.xsql);
                Throwable th = null;
                if (rs.next()) {
                    actualizaFecha(formadFecha(this.formatoAMDH24_1.format(getFechaActual())), documento);
                } else {
                    System.out.println("no actualizo la fecha");
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void actualizaFecha(LocalDateTime fecha, String cc) {
        this.xsql = "UPDATE ll_datos_basicos set Fecha_R='" + fecha + "' WHERE Documento='" + cc + "' AND Consultorio='" + Principal.consultorio + "' AND Original=1";
        System.out.println(this.xsql);
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public String mCrearTercero_GEmpresa(String xIdPersona, String xTipoDOc, String xDocumento) {
        String xIdTercero = "";
        try {
            String sql = "SELECT  `Id` FROM `g_empresa`\nWHERE (`No_identificacion` ='" + xDocumento + "'   AND `Id_TipoIdentificacion` ='" + xTipoDOc + "')";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xIdTercero = xrs.getString("Id");
            } else {
                String sql2 = "INSERT INTO g_empresa (Id_TipoIdentificacion, No_identificacion, Dig_Verificacion, Id_Municipio, Direccion, Tel_Numero, Eps, Id_Persona, TipoPersona,Apellido1, Apellido2, Nombre1, Nombre2,Id_ClasificacionT, Fecha, UsuarioS) \nSELECT `g_persona`.`Id_TipoIdentificacion` , `g_persona`.`NoDocumento`  , ''  , `g_persona`.`Id_Municipio`  , `g_persona`.`Direccion` , `g_persona`.`Telefono` , 0 , `g_persona`.`Id` , 1 , `g_persona`.`Apellido1` , `g_persona`.`Apellido2` , `g_persona`.`Nombre1`  , `g_persona`.`Nombre2` , 1 , NOW(), '" + Principal.usuarioSistemaDTO.getLogin() + "'\nFROM `g_usuario`  INNER JOIN   `g_persona`   ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nWHERE (`g_persona`.`Id` ='" + xIdPersona + "')";
                ConsultasMySQL xct = new ConsultasMySQL();
                xIdTercero = xct.ejecutarSQLId(sql2);
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xIdTercero;
    }

    public void abrirEnlaceWeb(String enlace1) {
        try {
            Desktop enlace = Desktop.getDesktop();
            try {
                enlace.browse(new URI(enlace1));
            } catch (URISyntaxException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (IOException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void buscarPrimero(String documento) {
        this.xsql = "SELECT * FROM ll_datos_basicos WHERE Documento='" + documento + "' AND Consultorio ='" + Principal.consultorio + "'";
        try {
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    primerPaciente(documento);
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs.close();
                    }
                }
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void primerPaciente(String cc) {
        try {
            this.xsql = "UPDATE ll_datos_basicos set Estado=1 WHERE Documento='" + cc + "' AND Consultorio ='" + Principal.consultorio + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void primerPaciente2(String cc, String consultorio) {
        try {
            this.xsql = "UPDATE ll_datos_basicos set Estado=1 WHERE Documento='" + cc + "' AND Consultorio ='" + consultorio + "'";
            this.xct.ejecutarSQL(this.xsql);
        } catch (Exception ex) {
            Logger.getLogger(JIFPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public Date getFechaActual() {
        try {
            ResultSet xrs = this.consultas.getResultSet("SELECT DATE_FORMAT(NOW(),'%Y') AS anio, DATE_FORMAT(NOW(),'%m') AS mes, DATE_FORMAT(NOW(),'%d') AS dia, DATE_FORMAT(NOW(),'%H') AS hora, DATE_FORMAT(NOW(),'%i') AS minuto, DATE_FORMAT(NOW(),'%s') AS segundo");
            Throwable th = null;
            if (xrs != null) {
                try {
                    try {
                        if (xrs.next()) {
                            int anio = xrs.getInt("anio");
                            int mes = xrs.getInt("mes") - 1;
                            int dia = xrs.getInt("dia");
                            int hora = xrs.getInt("hora");
                            int minuto = xrs.getInt("minuto");
                            int segundo = xrs.getInt("segundo");
                            this.fechaActual = new GregorianCalendar(anio, mes, dia, hora, minuto, segundo);
                        }
                    } finally {
                    }
                } finally {
                }
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
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (this.fechaActual != null) {
            return this.fechaActual.getTime();
        }
        return new Date();
    }

    public LocalDateTime getFechaActualLocalTime() {
        String str = this.formatoAMDH24_1.format(getFechaActual());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        return dateTime;
    }

    public Date getFechaActualPC() {
        this.fechaActualPC = new GregorianCalendar();
        return this.fechaActualPC.getTime();
    }

    public void removeLineFromFile(String lineToRemove, File inFile) {
        try {
            if (!inFile.isFile()) {
                return;
            }
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(inFile.getAbsoluteFile()));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            while (true) {
                String line = br.readLine();
                if (line != null) {
                    break;
                } else if (!line.trim().equals(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            if (!inFile.delete()) {
                return;
            }
            if (!tempFile.renameTo(inFile)) {
            }
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ResteasyClient getResteasyClient() {
        ApacheHttpClient4Engine engine = null;
        try {
            CloseableHttpClient httpClient = SSLUtil.createHttpClientWithoutSSLVerification();
            engine = new ApacheHttpClient4Engine(httpClient);
        } catch (Exception ex) {
            Logger.getLogger(ProcesosValidacionRipsApi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        ResteasyClient client = new ResteasyClientBuilder().httpEngine(engine).build();
        return client;
    }

    public ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    public <T> T getDeserializeJson(String str, Class<T> cls) {
        try {
            return (T) new ObjectMapper().readValue(str, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al deserializar JSON: " + str, e);
        }
    }

    public RecursosMicroserviciosDomain getParametrosEncriptados(String idModulo, String nombre) {
        RecursosMicroserviciosDomain domain = RecursosMicroserviciosDomain.builder().build();
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            String json1 = idModulo + "_" + nombre;
            String parameter = Base64.getEncoder().encodeToString(json1.getBytes());
            String urlMicroservicio = (String) Optional.ofNullable(Principal.sedeUsuarioSeleccionadaDTO.getUrlMicroServicios()).filter(url -> {
                return !url.isEmpty();
            }).orElse(Principal.informacionIps.getUrlMicroServicios());
            String fullUrl = urlMicroservicio + "/list-recursos-microservicios/" + parameter;
            System.out.println("Url: " + fullUrl);
            try {
                Response response = getResteasyClient().target(fullUrl).request().get();
                if (response.getStatus() == 200) {
                    List<RecursosMicroserviciosDomain> listMicroServiciosModulo = parseResponse(response);
                    if (!listMicroServiciosModulo.isEmpty()) {
                        domain = listMicroServiciosModulo.get(0);
                        if (!domain.getEsUrlExterna().booleanValue()) {
                            domain.setUrlRecurso(urlMicroservicio + domain.getUrlRecurso());
                        }
                    }
                }
            } catch (ProcessingException e) {
                System.err.println("Error al llamar al servicio REST: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return domain;
    }

    private List<RecursosMicroserviciosDomain> parseResponse(Response response) {
        try {
            String responseJson = (String) response.readEntity(String.class);
            CustomPresenter presenter = (CustomPresenter) getMapper().readValue(responseJson, CustomPresenter.class);
            return (List) getMapper().readValue(getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<RecursosMicroserviciosDomain>>() { // from class: Utilidades.Metodos.1
            });
        } catch (JsonProcessingException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
            return Collections.emptyList();
        }
    }

    /* JADX WARN: Finally extract failed */
    public int getCalculaDias(String xfechaE, String xfechaI) {
        int xdias = 0;
        String sql = "SELECT DATEDIFF('" + xfechaE + "','" + xfechaI + "') AS dias ";
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    xdias = xrs.getInt("dias");
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
                xct.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdias;
    }

    public void mGenerarCodigoBarra_128_FImagen(String cod) {
        try {
            Barcode128 code128 = new Barcode128();
            code128.setCode(cod);
            code128.setCodeType(9);
            Image img = code128.createAwtImage(Color.BLACK, Color.WHITE);
            BufferedImage outImage = new BufferedImage(img.getWidth((ImageObserver) null), img.getHeight((ImageObserver) null), 1);
            outImage.getGraphics().drawImage(img, 0, 0, (ImageObserver) null);
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
            ImageIO.write(outImage, "jpeg", bytesOut);
            bytesOut.flush();
            byte[] jpgImageData = bytesOut.toByteArray();
            String path = getRutaRep() + "c:\\Genoma\\reporte.jpg";
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(jpgImageData);
            fos.flush();
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mEstablecerTextEditor(JTable xtabla, int xcolumna) {
        TableColumnModel cmodel = xtabla.getColumnModel();
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        if (cmodel.getColumn(xcolumna) != null) {
            cmodel.getColumn(xcolumna).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(xcolumna).setCellEditor(textEditor);
        }
    }

    public void mEstablecerTextEditor_nuevo(JTable xtabla, int xcolumna) {
        TableColumnModel cmodel = xtabla.getColumnModel();
        if (cmodel.getColumn(xcolumna) != null) {
            cmodel.getColumn(xcolumna).setCellRenderer(new TextAreaRenderer_nuevo());
            cmodel.getColumn(xcolumna).setCellEditor(new TextAreaEditor_nuevo());
        }
    }

    public Date getPasarTextoaFecha(String texto) {
        GregorianCalendar fechaG = new GregorianCalendar();
        int ano = Integer.parseInt(texto.substring(0, 4));
        int mes = Integer.parseInt(texto.substring(5, 7));
        int dia = Integer.parseInt(texto.substring(8, 10));
        fechaG.set(ano, mes - 1, dia);
        Date fechaD = new Date();
        fechaD.setTime(fechaG.getTime().getTime());
        return fechaD;
    }

    public Date getPasarTextoAFecha(String texto) {
        GregorianCalendar fecha = new GregorianCalendar();
        new Date();
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
        Date fecha1 = fecha.getTime();
        return fecha1;
    }

    public Date getPasarTextoAFechaHora(String texto) {
        GregorianCalendar fecha = new GregorianCalendar();
        new Date();
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        String hora = texto.substring(11, 13);
        String minuto = texto.substring(14, 16);
        String segundo = texto.substring(17, 19);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto), Integer.parseInt(segundo));
        Date fecha1 = fecha.getTime();
        return fecha1;
    }

    public void mExpandir_Arbol(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        mExpandAll(tree, new TreePath(root), expand);
    }

    public int getPregunta(String msg) {
        return JOptionPane.showConfirmDialog((Component) null, msg, this.titulo, 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public int getPregunta2(String msg, Object[] botones, String btnDefecto) {
        return JOptionPane.showOptionDialog((Component) null, msg, this.titulo, 0, 3, (Icon) null, botones, btnDefecto);
    }

    public String getDirectorioExportacion() {
        return System.getProperties().getProperty("user.dir") + getBarra();
    }

    public String getSO() {
        return System.getProperties().getProperty("user.dir");
    }

    public String getBarra() {
        String ruta;
        if (System.getProperty("os.name").substring(0, 3).equals("Win")) {
            ruta = "\\";
        } else {
            ruta = "/";
        }
        return ruta;
    }

    private static String getBarraEstatica() {
        String ruta;
        if (System.getProperty("os.name").substring(0, 3).equals("Win")) {
            ruta = "\\";
        } else {
            ruta = "/";
        }
        return ruta;
    }

    public String getRutaRep() {
        return getSO() + getBarra() + "Reportes" + getBarra();
    }

    public int getAltoPantalla() {
        return this.dime.height;
    }

    public int getAnchoPantalla() {
        return this.dime.width;
    }

    public int getValidarDatosPersona(Persona frmPersona) {
        int retorno = 0;
        if (frmPersona.cboTipoIdentificacion.getSelectedIndex() < 0 && frmPersona.txtIdentificacion.getText().isEmpty() && frmPersona.getApellido1().isEmpty() && frmPersona.getApellido2().isEmpty() && frmPersona.getNombre1().isEmpty() && frmPersona.getNombre2().isEmpty()) {
            mostrarMensaje("Por favor digite los Criterios de Busqueda");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public int getValidarDatosPersonaAguil(Persona frmPersona) {
        int retorno = 0;
        if (frmPersona.cboTipoIdentificacion.getSelectedIndex() < 0 && frmPersona.txtIdentificacion.getText().isEmpty() && frmPersona.getApellido1().isEmpty() && frmPersona.getApellido2().isEmpty() && frmPersona.getNombre1().isEmpty() && frmPersona.getNombre2().isEmpty()) {
            mostrarMensaje("Por favor digite los Criterios de Busqueda");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public void limpiarDatosPrincipal() {
        Principal.txtNo.setText("");
        Principal.txtEstado.setText("ACTIVA");
        Principal.txtFecha.setText(this.formatoDMA.format(getFechaActual()));
        marcarEstado(0);
    }

    public void limpiarControles(JPanel jpanel, boolean forma) {
        JFormattedTextField dato;
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            switch (jpanel.getComponent(i).getClass().toString()) {
                case "class javax.swing.JTextField":
                    jpanel.getComponent(i).setText("");
                    break;
                case "class javax.swing.JSpinner":
                    JSpinner dato2 = jpanel.getComponent(i);
                    if (dato2.getName() != null && dato2.getName().equals("NoHijos")) {
                        dato2.setValue(0);
                        break;
                    } else {
                        dato2.setValue(1);
                        break;
                    }
                    break;
                case "class javax.swing.JFormattedTextField":
                    dato = jpanel.getComponent(i);
                    switch (dato.getName()) {
                        case "hora":
                            dato.setValue(getFechaActual());
                            break;
                        case "autorizacion":
                            dato.setValue("");
                            break;
                        default:
                            dato.setValue(new Double(0.0d));
                            break;
                    }
                    break;
                case "class javax.swing.Label":
                    JLabel dato3 = jpanel.getComponent(i);
                    if (dato3.getName() != null && dato3.getName().equals("idIngreso")) {
                        dato3.setText("");
                        break;
                    } else {
                        break;
                    }
                    break;
                case "class com.toedter.calendar.JDateChooser":
                    jpanel.getComponent(i).setDate(getFechaActual());
                    break;
                case "class Utilidades.JTextFieldValidator":
                    jpanel.getComponent(i).setText("");
                    break;
                case "class javax.swing.JComboBox":
                    JComboBox dato4 = jpanel.getComponent(i);
                    if (dato4.getName().equals("servicio") || dato4.getName().equals("centroCosto") || dato4.getName().equals("tipoAtencion") || dato4.getName().equals("tipoEtnia") || dato4.getName().equals("tipoPoblacionEspecial") || dato4.getName().equals("tipoAfiliado")) {
                        if (dato4.getName().equals("tipoEtnia")) {
                            dato4.setSelectedIndex(2);
                        }
                        if (dato4.getName().equals("tipoPoblacionEspecial")) {
                            dato4.setSelectedIndex(22);
                        }
                        if (dato4.getName().equals("tipoAfiliado") || dato4.getName().equals("tipoSangre") || dato4.getName().equals("tipoAtencion") || dato4.getName().equals("forma_pago")) {
                            dato4.setSelectedIndex(0);
                        }
                        break;
                    } else {
                        dato4.setSelectedIndex(-1);
                        break;
                    }
                    break;
            }
        }
    }

    public void marcarEstado(int op) {
        if (op == 1) {
            Principal.txtEstado.setText("ANULADA");
            Principal.txtEstado.setForeground(new Color(204, 0, 0));
        } else {
            Principal.txtEstado.setText("ACTIVA");
            Principal.txtEstado.setForeground(new Color(102, 0, 102));
        }
    }

    public void mostrarErrorE(Exception error) {
        String msg = "Ocurrió el siguiente Error: " + error.getMessage() + "\nLocalización : " + error.getLocalizedMessage() + "\nCausa : " + error.getCause() + "\nClase : " + error.getClass();
        mostrarMensaje(msg);
    }

    public void mostrarMensaje(String m) {
        JOptionPane.showMessageDialog((Component) null, m, Principal.getTitulo(), 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mostrarMensajeError(String m) {
        JOptionPane.showMessageDialog((Component) null, m, Principal.getTitulo(), 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
    }

    public String pasarHora12a24(String hora) {
        String hora2;
        String horaDevolver;
        String hora22;
        int horas = Integer.parseInt(hora.substring(0, 2));
        if (hora.length() > 9) {
            if (hora.substring(9, 11).equals("PM") && horas != 12) {
                horas += 12;
            } else if (hora.substring(9, 11).equals("PM") && horas == 12) {
                horas = 12;
            } else if (hora.substring(9, 11).equals("AM") && horas == 12) {
                horas = 0;
            }
            if (horas < 10) {
                hora22 = "0" + horas;
            } else {
                hora22 = String.valueOf(horas);
            }
            horaDevolver = hora22 + ":" + hora.substring(3, 9);
        } else {
            if (hora.substring(6, 8).equals("PM") && horas != 12) {
                horas += 12;
            } else if (hora.substring(6, 8).equals("PM") && horas == 12) {
                horas = 12;
            } else if (hora.substring(6, 8).equals("AM") && horas == 12) {
                horas = 0;
            }
            if (horas < 10) {
                hora2 = "0" + horas;
            } else {
                hora2 = String.valueOf(horas);
            }
            horaDevolver = hora2 + ":" + hora.substring(3, 8);
        }
        return horaDevolver;
    }

    public void PresentacionPreliminar(String nbreArchivo, String[][] parametros) {
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            JasperPrint imprimir = JasperFillManager.fillReport(nbreArchivo, parametro, this.consultas.establecerConexionBd());
            JasperViewer vista = new JasperViewer(imprimir, false);
            vista.setVisible(true);
            this.consultas.cerrarConexionBd();
        } catch (Exception e) {
            this.consultas.mostrarErrorE(e);
        }
    }

    public void mostrarPdf(String rutaa) {
        try {
            File archivo = new File(rutaa);
            if (archivo.exists()) {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            }
        } catch (IOException ex) {
            this.consultas.mostrarErrorIO(ex);
        }
    }

    public void mostrarPdf(String rutaa, String nArchivo) {
        try {
            if (!rutaa.equals(getDirectorioExportacion() + "Reportes" + getBarra() + nArchivo)) {
                mEliminarArchivo(new File(getDirectorioExportacion() + "Reportes" + getBarra() + nArchivo));
            }
            File archivo = new File(rutaa);
            File f2 = new File(getDirectorioExportacion() + "Reportes" + getBarra() + nArchivo);
            boolean renombrado = archivo.renameTo(f2);
            if (renombrado && f2.exists()) {
                Desktop d = Desktop.getDesktop();
                d.open(f2);
            }
        } catch (IOException ex) {
            this.consultas.mostrarErrorIO(ex);
        }
    }

    public void exportarPdf(String narchivo, String nparametro, String vparametro) {
        try {
            String str = getRutaRep() + narchivo + ".jrxml";
            Map parametro = new HashMap();
            this.consultas.establecerConexionBd();
            parametro.put(nparametro, vparametro);
            mostrarPdf(getRutaRep() + narchivo + ".pdf");
        } catch (Exception j) {
            this.consultas.mostrarErrorE(j);
        }
    }

    public String sumarHoras24(String hora, String suma) {
        String minutos;
        DecimalFormat formato2Digito = new DecimalFormat("#0");
        String minutos2 = hora.substring(3, 5);
        String Hora = hora.substring(0, 2);
        int resultado = Integer.parseInt(minutos2) + Integer.parseInt(suma);
        if (resultado > 59) {
            Hora = String.valueOf(Integer.parseInt(Hora) + 1);
            minutos = String.valueOf(resultado - 60);
        } else {
            minutos = String.valueOf(formato2Digito.format(resultado));
        }
        if (Hora.length() == 1) {
            Hora = "0" + Hora;
        }
        if (minutos.length() == 1) {
            minutos = "0" + minutos;
        }
        return Hora + ":" + minutos;
    }

    public String mRetornar_HoraFinal(String xfechai, int xnminutos) {
        String xhoraf = this.consultas.traerDato("SELECT TIME(DATE_ADD('" + xfechai + "', INTERVAL " + xnminutos + " MINUTE))");
        this.consultas.cerrarConexionBd();
        return xhoraf;
    }

    public String validarTexto(String recibido, int tipo) {
        String textoDevolver = "";
        String abcedario = "";
        if (tipo == 1) {
            abcedario = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
        } else if (tipo == 2) {
            abcedario = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
        }
        for (int i = 0; i < recibido.length(); i++) {
            String letraA = recibido.substring(i, i + 1);
            int encontrado = 0;
            for (int n = 0; n < abcedario.length(); n++) {
                String letraB = abcedario.substring(n, n + 1);
                if (letraA.equals(letraB)) {
                    encontrado = 1;
                }
            }
            if (encontrado == 1) {
                textoDevolver = textoDevolver + letraA;
            }
        }
        if (!recibido.equals(textoDevolver)) {
            mostrarMensaje("Se encontraron caracteres no válidos para este campo.\nPor favor verifique que los datos resultantes sean los corrector");
        }
        return textoDevolver;
    }

    public void expandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        expandAll(tree, new TreePath(root), expand);
    }

    public void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    public Boolean getFimarDoc() {
        return this.fimarDoc;
    }

    public void setFimarDoc(Boolean fimarDocumento) {
        this.fimarDoc = fimarDocumento;
    }

    public String invertirFecha(String ver) {
        String ano = ver.substring(6, 10);
        String mes = ver.substring(3, 5);
        String dia = ver.substring(0, 2);
        return ano + "/" + mes + "/" + dia;
    }

    public String formatoHora12(String hora) {
        String horaDevolver;
        int horas = Integer.parseInt(hora.substring(0, 2));
        String horaDevolver2 = hora.substring(0, 2);
        if (horas < 12) {
            horaDevolver = horaDevolver2 + ":" + hora.substring(3, 5) + " AM";
        } else if (horas == 12) {
            horaDevolver = "12:" + hora.substring(3, 5) + "  M";
        } else {
            int horas2 = horas - 12;
            if (horas2 < 10) {
                horaDevolver = "0" + String.valueOf(horas2) + ":" + hora.substring(3, 5) + " PM";
            } else {
                horaDevolver = String.valueOf(horas2) + ":" + hora.substring(3, 5) + " PM";
            }
        }
        return horaDevolver;
    }

    public String formatoHora24(String hora) {
        String horaDevolver;
        int horas = Integer.parseInt(hora.substring(0, 2));
        String horaDevolver2 = hora.substring(0, 2);
        if (horas < 12) {
            horaDevolver = horaDevolver2 + ":" + hora.substring(3, 5) + " AM";
        } else if (horas == 12) {
            horaDevolver = "12:" + hora.substring(3, 5) + "  M";
        } else if (horas < 10) {
            horaDevolver = "0" + String.valueOf(horas) + ":" + hora.substring(3, 5) + " PM";
        } else {
            horaDevolver = String.valueOf(horas) + ":" + hora.substring(3, 5) + " PM";
        }
        return horaDevolver;
    }

    public String pasarFechaHora12a24(String FechaHora) {
        String Fecha = FechaHora.substring(0, 10);
        String Hora = FechaHora.substring(11);
        return Fecha + " " + pasarHora12a24(Hora);
    }

    public Date convertirLocalDateADate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public String sumarHoras(String hora, String suma) {
        String minutos;
        DecimalFormat formato2Digito = new DecimalFormat("#0");
        String minutos2 = hora.substring(3, 5);
        String Hora = hora.substring(0, 2);
        int resultado = Integer.parseInt(minutos2) + Integer.parseInt(suma);
        if (resultado > 59) {
            Hora = String.valueOf(Integer.parseInt(Hora) + 1);
            minutos = String.valueOf(resultado - 60);
            if (Integer.parseInt(Hora) > 12) {
                Hora = String.valueOf(Integer.parseInt(Hora) - 12);
                if (Hora.length() == 1) {
                    Hora = "0" + Hora;
                }
            }
        } else {
            minutos = String.valueOf(formato2Digito.format(resultado));
            if (minutos.length() == 1) {
                minutos = "0" + minutos;
            }
        }
        return Hora + ":" + minutos;
    }

    public String traerNombreCompleto(String sql) {
        String resultado = "";
        try {
            Statement s = this.consultas.establecerConexionBd().createStatement(1005, 1007);
            ResultSet rs = s.executeQuery(sql);
            rs.next();
            if (rs.getRow() > 0) {
                resultado = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return resultado;
    }

    public String entregarEdadEnMeses(String fecha) {
        SimpleDateFormat formatof = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar hoy = new GregorianCalendar();
        String dato = formatof.format(hoy.getTime());
        DecimalFormat dc = new DecimalFormat("#0");
        int y1 = Integer.parseInt(fecha.substring(0, 4));
        int m1 = Integer.parseInt(fecha.substring(5, 7));
        int d1 = Integer.parseInt(fecha.substring(8, 10));
        int y2 = Integer.parseInt(dato.substring(0, 4));
        int m2 = Integer.parseInt(dato.substring(5, 7));
        int d2 = Integer.parseInt(dato.substring(8, 10));
        int dias = ((y2 - y1) * 360) + ((m2 - m1) * 30) + (d2 - d1);
        double rs1 = (Double.valueOf(dias).doubleValue() / Double.valueOf(360.0d).doubleValue()) * 12.0d;
        String diasm = dc.format(rs1);
        int dias2 = Integer.parseInt(diasm);
        return String.valueOf(dias2);
    }

    public String edadEnMeses(String fechaNacimiento, String fechaAtencion) {
        int iIntValue;
        int mes;
        int dia;
        int iIntValue2;
        int mes2;
        int dia2;
        int diferenciaMeses;
        new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar fechaActual = new GregorianCalendar();
        if (fechaAtencion != null) {
            iIntValue = Integer.valueOf(fechaNacimiento.substring(0, 4)).intValue();
            mes = Integer.valueOf(fechaNacimiento.substring(5, 7)).intValue();
            dia = Integer.valueOf(fechaNacimiento.substring(8, 10)).intValue();
            iIntValue2 = Integer.valueOf(fechaAtencion.substring(0, 4)).intValue();
            mes2 = Integer.valueOf(fechaAtencion.substring(5, 7)).intValue();
            dia2 = Integer.valueOf(fechaAtencion.substring(8, 10)).intValue();
        } else {
            iIntValue = Integer.valueOf(fechaNacimiento.substring(0, 4)).intValue();
            mes = Integer.valueOf(fechaNacimiento.substring(5, 7)).intValue();
            dia = Integer.valueOf(fechaNacimiento.substring(8, 10)).intValue();
            iIntValue2 = fechaActual.get(1);
            mes2 = fechaActual.get(2) + 1;
            dia2 = fechaActual.get(5);
        }
        int converDiaAmes = (dia2 >= 20 ? mes2 + 1 : mes2) - (dia >= 20 ? mes + 1 : mes);
        if (iIntValue == iIntValue2) {
            diferenciaMeses = converDiaAmes;
        } else {
            diferenciaMeses = ((iIntValue2 - iIntValue) * 12) + converDiaAmes;
        }
        return String.valueOf(diferenciaMeses);
    }

    public String[][] getEdad(String xfecha) {
        String[][] lista = new String[1][3];
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar hoy = new GregorianCalendar();
        String dato = formatofecha.format(hoy.getTime());
        DecimalFormat dc = new DecimalFormat("#0");
        int y1 = Integer.parseInt(xfecha.substring(0, 4));
        int m1 = Integer.parseInt(xfecha.substring(5, 7));
        int d1 = Integer.parseInt(xfecha.substring(8, 10));
        int y2 = Integer.parseInt(dato.substring(0, 4));
        int m2 = Integer.parseInt(dato.substring(5, 7));
        int d2 = Integer.parseInt(dato.substring(8, 10));
        int dias = ((y2 - y1) * 365) + ((m2 - m1) * 30) + (d2 - d1);
        if (dias >= 365) {
            lista[0][0] = String.valueOf(dias / 365);
            lista[0][1] = " Años";
            lista[0][2] = "1";
        } else if (dias >= 30) {
            double rs1 = (Double.valueOf(dias).doubleValue() / Double.valueOf(365.0d).doubleValue()) * 12.0d;
            String diasm = dc.format(rs1);
            int dias2 = Integer.parseInt(diasm);
            if (dias2 == 12) {
                int i = dias2 / 365;
                lista[0][0] = String.valueOf(1);
                lista[0][1] = " Año";
                lista[0][2] = "1";
            } else {
                lista[0][0] = String.valueOf(dias2);
                lista[0][1] = " Meses";
                lista[0][2] = "2";
            }
        } else {
            if (dias < 1) {
                dias *= 30;
            }
            lista[0][0] = String.valueOf(dias);
            lista[0][1] = " Días";
            lista[0][2] = "3";
        }
        return lista;
    }

    public double redondear(double numero, int decimales) {
        return Math.round(numero * Math.pow(10.0d, decimales)) / Math.pow(10.0d, decimales);
    }

    public void recuperarBlob(String sql, int x) throws SQLException, IOException {
        String pathname;
        FileOutputStream fos = null;
        ResultSet rs = null;
        try {
            try {
                rs = this.consultas.traerRs(sql);
                if (rs.next()) {
                    if (x == 0) {
                        pathname = getRutaRep() + "tmp.pdf";
                    } else {
                        pathname = getRutaRep() + "tmp.bmp";
                    }
                    File file = new File(pathname);
                    fos = new FileOutputStream(file);
                    rs.getBytes(1);
                    Blob bin = rs.getBlob(1);
                    InputStream inStream = bin.getBinaryStream();
                    int size = (int) bin.length();
                    byte[] buffer = new byte[size];
                    while (true) {
                        int length = inStream.read(buffer);
                        if (length == -1) {
                            break;
                        } else {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                if (fos != null) {
                    fos.close();
                }
                if (rs != null) {
                    rs.close();
                }
                this.consultas.cerrarConexionBd();
            } catch (IOException ioe) {
                throw new IOException(ioe.getMessage());
            }
        } catch (Throwable th) {
            if (fos != null) {
                fos.close();
            }
            if (rs != null) {
                rs.close();
            }
            throw th;
        }
    }

    public String recuperarBlob(String sql, int x, String fileName, int formaVisualizacion, String ruta) throws SQLException, IOException {
        String pathname = null;
        Path rutaF = Paths.get(ruta, new String[0]);
        File archivo = rutaF.toFile();
        if (!archivo.exists()) {
            FileOutputStream fos = null;
            ResultSet rs = null;
            try {
                try {
                    rs = this.consultas.traerRs(sql);
                    if (rs.next()) {
                        if (x == 0) {
                            pathname = getRutaRep() + fileName + ".pdf";
                        } else {
                            pathname = getRutaRep() + fileName + ".bmp";
                        }
                        if (!rs.getString(1).equals("1")) {
                            File file = new File(pathname);
                            fos = new FileOutputStream(file);
                            rs.getBytes(1);
                            String bin = rs.getString(1);
                            bin.length();
                            byte[] buffer = Base64.getDecoder().decode(bin);
                            fos.write(buffer);
                            if (formaVisualizacion == 0) {
                                Desktop destop = Desktop.getDesktop();
                                destop.open(file);
                            }
                        }
                    }
                    if (fos != null) {
                        fos.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    this.consultas.cerrarConexionBd();
                    return pathname;
                } catch (IOException ioe) {
                    throw new IOException(ioe.getMessage());
                }
            } catch (Throwable th) {
                if (fos != null) {
                    fos.close();
                }
                if (rs != null) {
                    rs.close();
                }
                throw th;
            }
        }
        if (formaVisualizacion == 0) {
            mostrarPdf(ruta);
        }
        return ruta;
    }

    public void guardarBlob() throws SQLException {
        try {
            File archivo = new File("z:\\dos.png");
            int l = (int) archivo.length();
            PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("INSERT INTO timagen (imagen, id) VALUES (?, ?)");
            InputStream is = new BufferedInputStream(new FileInputStream(archivo));
            pSt.setBinaryStream(1, is, l);
            pSt.setInt(2, 1);
            pSt.execute();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void traerImagenGraficaPartograma(JPanel xPanel, long xidGrafica) {
        File file = new File(getDirectorioExportacion() + xidGrafica + ".jpg");
        try {
            ImageIO.write(createImage(xPanel), "jpg", file);
        } catch (IOException e) {
        }
    }

    public void traerImagenGraficas(JPanel xPanel, long xidGrafica) {
        File file = new File("C:\\Genoma\\" + xidGrafica + ".jpg");
        try {
            ImageIO.write(createImage(xPanel), "jpg", file);
        } catch (IOException e) {
        }
    }

    public void traerImagenGraficasPanel(JPanel xPanel, String nombre) {
        File file = new File("C:\\Genoma\\" + nombre + ".jpg");
        try {
            ImageIO.write(createImage(xPanel), "jpg", file);
        } catch (IOException e) {
        }
    }

    public void traerImagenGraficas_V2(JPanel xPanel, long xidGrafica) {
        File imageFile = new File(mRutaSoporte("GraficasCyD") + xidGrafica + ".jpg");
        try {
            ImageIO.write(createImage(xPanel), "jpg", imageFile);
        } catch (IOException e) {
        }
    }

    public boolean isValidarCorreoElectronicoExpresionRegular(String email) {
        boolean estado = false;
        Pattern pattern = Pattern.compile(Constantes.EMAILPARTTERN);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            estado = true;
        }
        return estado;
    }

    public void guardarGraficaBlobPartograma(long xidGrafica, String xCampo) throws SQLException {
        try {
            File archivo = new File(getDirectorioExportacion() + xidGrafica + ".jpg");
            int l = (int) archivo.length();
            PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("UPDATE `h_partograma`  SET " + xCampo + "=?   WHERE IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado='1'");
            InputStream is = new BufferedInputStream(new FileInputStream(archivo));
            pSt.setBinaryStream(1, is, l);
            pSt.execute();
            pSt.close();
            is.close();
            mEliminarArchivo(new File(getDirectorioExportacion() + xidGrafica + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void guardarGraficaBlob(long xidGrafica) throws SQLException {
        try {
            File archivo = new File("C:\\Genoma\\" + xidGrafica + ".jpg");
            int l = (int) archivo.length();
            if (mVerificaExistenciaGrafica(xidGrafica)) {
                PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("UPDATE `p_usuario_grafica`  SET `ImagenGrafica`=?, `UsuarioS`=?  WHERE IdUsuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND IdUsuarioPrograma='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' AND IdGrafica ='" + xidGrafica + "' ");
                InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                pSt.setBinaryStream(1, is, l);
                pSt.setString(2, Principal.usuarioSistemaDTO.getLogin());
                pSt.execute();
                pSt.close();
                is.close();
            } else {
                PreparedStatement pSt2 = this.consultas.establecerConexionBd().prepareStatement("INSERT INTO  `p_usuario_grafica` (`IdUsuario`, `IdUsuarioPrograma`, `IdGrafica`, `ImagenGrafica`, `UsuarioS`)  VALUES (?,?,?,?,?)");
                InputStream is2 = new BufferedInputStream(new FileInputStream(archivo));
                pSt2.setString(1, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido()));
                pSt2.setString(2, String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma()));
                pSt2.setLong(3, xidGrafica);
                pSt2.setBinaryStream(4, is2, l);
                pSt2.setString(5, Principal.usuarioSistemaDTO.getLogin());
                pSt2.execute();
                pSt2.close();
                is2.close();
            }
            mEliminarArchivo(new File("C:\\Genoma\\" + xidGrafica + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public boolean mVerificaExistenciaGrafica(long xidGrafica) {
        boolean xexiste = false;
        String sql = "SELECT `IdUsuario`,`IdUsuarioPrograma`,`IdGrafica` FROM  p_usuario_grafica WHERE (`IdUsuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `IdUsuarioPrograma`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "' AND `IdGrafica`='" + xidGrafica + "')";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    private boolean mVerificaExistenciaImgControlPlaca(long xidTto) {
        boolean xexiste = false;
        String sql = "SELECT IF(`ImgControlPlaca` IS NULL, '0','1') AS ImgControlPlaca FROM `o_hc_tratamiento`  WHERE Id='" + xidTto + "'";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xexiste = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xexiste;
    }

    public void guardarImagenBlobCP(long xidTto) throws SQLException {
        try {
            File archivo = new File("C:\\Genoma\\" + xidTto + ".jpg");
            int l = (int) archivo.length();
            if (mVerificaExistenciaImgControlPlaca(xidTto)) {
                PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("UPDATE `o_hc_tratamiento`  SET `ImgControlPlaca`=?, UsuarioS=?  WHERE Id ='" + xidTto + "' ");
                InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                pSt.setBinaryStream(1, is, l);
                pSt.setString(2, Principal.usuarioSistemaDTO.getLogin());
                pSt.execute();
                pSt.close();
                is.close();
            }
            mEliminarArchivo(new File("C:\\Genoma\\" + xidTto + ".jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void guardarImagenBlobFramingham(String id) throws SQLException {
        try {
            File framingham = new File("C:\\Genoma\\framingham.jpg");
            int d = (int) framingham.length();
            PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("UPDATE h_framigan SET imagenGrafica=? WHERE id='" + id + "'");
            InputStream is = new BufferedInputStream(new FileInputStream(framingham));
            pSt.setBinaryStream(1, is, d);
            pSt.execute();
            pSt.close();
            is.close();
            mEliminarArchivo(new File("C:\\Genoma\\framingham.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void guardarImagenBlobReumatologia(String idReumatologia) throws SQLException {
        try {
            File dolorsas = new File("C:\\Genoma\\dolorosas.jpg");
            File inflamadas = new File("C:\\Genoma\\inflamadas.jpg");
            int d = (int) dolorsas.length();
            int i = (int) inflamadas.length();
            PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement("UPDATE h_reumatologia_examen\nSET imgdolorosas=?, imginflamadas=?\nWHERE id='" + idReumatologia + "'");
            InputStream is = new BufferedInputStream(new FileInputStream(dolorsas));
            InputStream in = new BufferedInputStream(new FileInputStream(inflamadas));
            pSt.setBinaryStream(1, is, d);
            pSt.setBinaryStream(2, in, i);
            pSt.execute();
            pSt.close();
            is.close();
            in.close();
            mEliminarArchivo(new File("C:\\Genoma\\dolorosas.jpg"));
            mEliminarArchivo(new File("C:\\Genoma\\inflamadas.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void recorrerDirectorio() {
        File dir = new File("z:\\reportes");
        String[] ficheros = dir.list();
        if (ficheros != null) {
            for (String str : ficheros) {
            }
        }
    }

    public void getRecuperarMostrarBlob(String sq) {
        try {
            recuperarBlob(sq, 0);
            mostrarPdf("C:\\Genoma\\tmp\\atmp.pdf");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void PresentacionImpresora(String nbreArchivo, String[][] parametros) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception j) {
                j.printStackTrace();
                return;
            }
        }
        JasperPrint imprimir = JasperFillManager.fillReport(nbreArchivo, parametro, con);
        JasperPrintManager.printPages(imprimir, 0, imprimir.getPages().size() - 1, false);
        this.consultas.cerrarConexionBd();
    }

    public void impimirOrdenFormulaMedica(String orden, String tipo, String nota, String usuario, int tipoImpresion) {
        Metodos metodos = new Metodos();
        String[][] mparametros = new String[7][2];
        mparametros[0][0] = "norden";
        mparametros[0][1] = orden;
        mparametros[1][0] = "xp2";
        mparametros[1][1] = tipo;
        mparametros[2][0] = "ip";
        mparametros[2][1] = nota;
        mparametros[3][0] = "nusuarios";
        mparametros[3][1] = usuario;
        mparametros[4][0] = "ruta";
        mparametros[4][1] = metodos.getRutaRep();
        mparametros[5][0] = "SUBREPORT_DIR";
        mparametros[5][1] = getSO() + getBarra() + "Reportes" + getBarra();
        mparametros[6][0] = "SUBREPORTFIRMA_DIR";
        mparametros[6][1] = getSO() + getBarra() + "Firmas" + getBarra();
        if (tipoImpresion == 1) {
            metodos.PresentacionImpresora(metodos.getRutaRep() + "RFormulaGeneralMP.jasper", mparametros);
        } else {
            metodos.PresentacionPreliminar(metodos.getRutaRep() + "RFormulaGeneralMP.jasper", mparametros);
        }
    }

    public void mImprimirFormula(long idorden, int n) {
        try {
            SimpleDateFormat xfechar = new SimpleDateFormat("dd/MM/yyyy");
            String xnotasad = null;
            String tipo = "Farmacia";
            String sql = "SELECT Id_Atencion, Id, FechaOrden FROM  h_ordenes where Id='" + idorden + "'";
            ConsultasMySQL xmt = new ConsultasMySQL();
            ResultSet rsm = xmt.traerRs(sql);
            rsm.first();
            long xida = rsm.getLong(1);
            if (rsm.getRow() != 0) {
                String sql2 = "SELECT Id_Atencion, Id, FechaOrden FROM   h_ordenes where  Id_Atencion='" + xida + "' and Id>'" + idorden + "' order by Id";
                rsm = this.consultas.traerRs(sql2);
                rsm.next();
                if (rsm.getRow() != 0) {
                    xnotasad = "Orden N° : " + rsm.getInt(2) + "  - - - Fecha Proxima Entrega : " + xfechar.format((Date) rsm.getDate(3));
                }
                this.consultas.cerrarConexionBd();
            }
            rsm.close();
            xmt.cerrarConexionBd();
            String[][] mparametros = new String[6][2];
            for (int j = 0; j < n; j++) {
                mparametros[0][0] = "norden";
                mparametros[0][1] = String.valueOf(idorden);
                mparametros[1][0] = "xp2";
                mparametros[1][1] = tipo;
                mparametros[2][0] = "ip";
                mparametros[2][1] = xnotasad;
                mparametros[3][0] = "nusuarios";
                mparametros[3][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = getSO() + getBarra() + "Reportes" + getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = getSO() + getBarra() + "Firmas" + getBarra();
                PresentacionImpresora(getRutaRep() + "RFormulaGeneralMP.jasper", mparametros);
                tipo = "Usuario";
            }
        } catch (SQLException e) {
        }
    }

    public int generarTXT(String nbreArchivo, ResultSet rs, int columnas) {
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nbreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            while (rs.next()) {
                try {
                    contador++;
                    for (int i = 1; i <= columnas; i++) {
                        if (i == columnas) {
                            salArch.print(rs.getString(i));
                            if (!rs.isLast()) {
                                salArch.println();
                            }
                        } else {
                            salArch.print(rs.getString(i) + ",");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
            salArch.close();
            try {
                rs.close();
            } catch (SQLException ex2) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        } catch (IOException e) {
        }
        return contador;
    }

    public int generarTXT2(String nbreArchivo, ResultSet rs, ResultSet rs1, int columnas) {
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nbreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            while (rs.next()) {
                try {
                    contador++;
                    for (int i = 1; i <= columnas; i++) {
                        if (i == columnas) {
                            salArch.print(rs.getString(i));
                            if (!rs.isLast()) {
                                salArch.println();
                            }
                        } else {
                            salArch.print(rs.getString(i) + ",");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
            while (rs1.next()) {
                contador++;
                for (int k = 1; k <= columnas; k++) {
                    if (k == columnas) {
                        salArch.print(rs1.getString(k));
                        if (!rs1.isLast()) {
                            salArch.println();
                        }
                    } else {
                        salArch.print(rs1.getString(k) + ",");
                    }
                }
            }
            salArch.close();
            try {
                rs.close();
                rs1.close();
            } catch (SQLException ex2) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        } catch (IOException e) {
        }
        return contador;
    }

    public int mGenerarTXT2(String nbreArchivo, ResultSet rs, ResultSet rs1) {
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nbreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            if (rs.next()) {
                rs.last();
                contador = 0 + rs.getRow();
                rs.beforeFirst();
                while (rs.next()) {
                    salArch.write(rs.getString(1));
                    bw.newLine();
                }
            }
            if (rs1.next()) {
                rs1.last();
                contador += rs1.getRow();
                rs1.beforeFirst();
                while (rs1.next()) {
                    salArch.write(rs1.getString(1));
                    bw.newLine();
                }
            }
            salArch.close();
            rs.close();
            rs1.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return contador;
    }

    public int mGenerarTXT2(String nbreArchivo, ResultSet rs) {
        int contador = 0;
        try {
            FileWriter fw = new FileWriter(nbreArchivo + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            if (rs.next()) {
                rs.last();
                contador = 0 + rs.getRow();
                rs.beforeFirst();
                while (rs.next()) {
                    salArch.write(rs.getString(1));
                    bw.newLine();
                }
            }
            salArch.close();
            rs.close();
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        return contador;
    }

    private void GuardarPdfAudiometriaBienestarSalud(String archivoBase64, String idIngreso) {
        try {
            String sql = "INSERT INTO so_soporte_audiometria (idIngreso,archivo) VALUES ('" + idIngreso + "','" + archivoBase64 + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            xct.ejecutarSQLId(sql);
            xct.cerrarConexionBd();
        } catch (Exception e) {
            System.out.println("Ocurrio un error " + e);
        }
    }

    private void GuardarPdfHistoriaSoBienestarSalud(String archivoBase64, String idIngreso) {
        try {
            String sql = "INSERT INTO so_soporte_historia (idIngreso,archivo) VALUES ('" + idIngreso + "','" + archivoBase64 + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            xct.ejecutarSQLId(sql);
            xct.cerrarConexionBd();
        } catch (Exception e) {
        }
    }

    public void GenerarPdfOptometriaBienestar(String nbreArchivo, Object[][] parametros, String idIngreso, boolean guardarSoporte) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (Object[] parametro1 : parametros) {
                if (parametro1[0] != null) {
                    if (!RutaFirma.isEmpty() && parametro1[0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametro1[0], parametro1[1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            String archivo = encodeFileToBase64Binary(nbreArchivo + ".pdf");
            if (guardarSoporte) {
                GuardarPdfOptometriaBienestarSalud(archivo, idIngreso);
            }
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    private void GuardarPdfOptometriaBienestarSalud(String archivoBase64, String idIngreso) {
        try {
            String sql = "INSERT INTO so_soporte_optometria (idIngreso,archivo) VALUES ('" + idIngreso + "','" + archivoBase64 + "')";
            ConsultasMySQL xct = new ConsultasMySQL();
            xct.ejecutarSQLId(sql);
            xct.cerrarConexionBd();
        } catch (Exception e) {
        }
    }

    public void GenerarPDFAudimetriaBienestar(String nbreArchivo, Object[][] parametros, String idIngreso, boolean guardarSoporte) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (Object[] parametro1 : parametros) {
                if (parametro1[0] != null) {
                    if (!RutaFirma.isEmpty() && parametro1[0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametro1[0], parametro1[1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            String archivo = encodeFileToBase64Binary(nbreArchivo + ".pdf");
            if (guardarSoporte) {
                GuardarPdfAudiometriaBienestarSalud(archivo, idIngreso);
            }
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarPDFHistoriaSOBienestar(String nbreArchivo, Object[][] parametros, String idIngreso, boolean visualizar) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (Object[] parametro1 : parametros) {
                if (parametro1[0] != null) {
                    if (!RutaFirma.isEmpty() && parametro1[0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametro1[0], parametro1[1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            String archivo = encodeFileToBase64Binary(nbreArchivo + ".pdf");
            GuardarPdfHistoriaSoBienestarSalud(archivo, idIngreso);
            if (visualizar) {
                mostrarPdf(nbreArchivo + ".pdf");
            }
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarHistoriaClinicaBienestarPDF(String nbreArchivo, Object[][] parametros) {
        boolean ResubirSoporte;
        int sizeXrs = 0;
        String idIngresoCompare = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso());
        String Sqlx = "SELECT ssa.idIngreso \nFROM so_soporte_historia ssa \nWHERE ssa.idIngreso = '" + idIngresoCompare + "'";
        ResultSet xrs = this.xconsultasbd.traerRs(Sqlx);
        try {
            xrs.last();
            sizeXrs = xrs.getRow();
            xrs.beforeFirst();
            xrs.close();
        } catch (SQLException e) {
        }
        this.xconsultasbd.cerrarConexionBd();
        if (sizeXrs > 0) {
            ResubirSoporte = false;
        } else {
            ResubirSoporte = true;
        }
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (parametros[i][0] != null) {
                    if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametros[i][0], parametros[i][1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            String archivo = encodeFileToBase64Binary(nbreArchivo + ".pdf");
            if (ResubirSoporte) {
                GuardarPdfHistoriaSoBienestarSalud(archivo, idIngresoCompare);
            }
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarPDF(String nbreArchivo, Object[][] parametros) {
        if (nbreArchivo.equals(getRutaRep() + "Bienestar_H_HistoriaClinica_ConsultaExterna")) {
            GenerarHistoriaClinicaBienestarPDF(nbreArchivo, parametros);
            return;
        }
        if (nbreArchivo.equals(getRutaRep() + "H_Certificado_Ingreso") && Principal.informacionIps.getNombreIps().equals("CAMI S.A.S")) {
            String nbreArchivo2 = nbreArchivo + "_Cami";
            mEliminarArchivo(new File(nbreArchivo2 + "pdf"));
            Connection con = this.consultas.establecerConexionBd();
            Map parametro = new HashMap();
            try {
                String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
                for (int i = 0; i < parametros.length; i++) {
                    if (parametros[i][0] != null) {
                        if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                            parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                        } else {
                            parametro.put(parametros[i][0], parametros[i][1]);
                        }
                    }
                }
                String archivoreporte = nbreArchivo2 + ".jrxml";
                JasperReport report = JasperCompileManager.compileReport(archivoreporte);
                JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
                String narchivop = nbreArchivo2 + ".pdf";
                JasperExportManager.exportReportToPdfFile(print, narchivop);
                if (!nbreArchivo2.contains("m_stiker")) {
                    firmarDocumento(narchivop);
                }
                mostrarPdf(nbreArchivo2 + ".pdf");
            } catch (Exception j) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
            }
            this.consultas.cerrarConexionBd();
            return;
        }
        mEliminarArchivo(new File(nbreArchivo + "pdf"));
        Connection con2 = this.consultas.establecerConexionBd();
        Map parametro2 = new HashMap();
        try {
            String RutaFirma2 = mRutaSoporte("SUBREPORTFIRMA_DIR");
            System.out.println("parametros.length --- " + parametros.length);
            for (int i2 = 0; i2 < parametros.length; i2++) {
                if (parametros[i2][0] != null) {
                    if (!RutaFirma2.isEmpty() && parametros[i2][0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro2.put("SUBREPORTFIRMA_DIR", RutaFirma2);
                    } else {
                        parametro2.put(parametros[i2][0], parametros[i2][1]);
                    }
                }
            }
            String archivoreporte2 = nbreArchivo + ".jrxml";
            System.out.println("reporte -> " + nbreArchivo);
            JasperReport report2 = JasperCompileManager.compileReport(archivoreporte2);
            JasperPrint print2 = JasperFillManager.fillReport(report2, parametro2, con2);
            String narchivop2 = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print2, narchivop2);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop2);
            }
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (Exception j2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j2);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarPDF(String nbreArchivo, Map<String, Object> parametros, String nombreFinal) {
        mEliminarArchivo(new File(nbreArchivo + "pdf"));
        Connection con = this.consultas.establecerConexionBd();
        new HashMap();
        try {
            mRutaSoporte("SUBREPORTFIRMA_DIR");
            System.out.println("parametros.length --- " + parametros.size());
            String archivoreporte = nbreArchivo + ".jrxml";
            System.out.println("reporte -> " + nbreArchivo);
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            if (nombreFinal.isEmpty()) {
                mostrarPdf(nbreArchivo + ".pdf");
            } else {
                mostrarPdf(nbreArchivo + ".pdf", nombreFinal + ".pdf");
            }
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarPDFSinMotrarParaCitologia(String nbreArchivo, Map<String, Object> parametros) {
        mEliminarArchivo(new File(nbreArchivo + "pdf"));
        Connection con = this.consultas.establecerConexionBd();
        new HashMap();
        try {
            mRutaSoporte("SUBREPORTFIRMA_DIR");
            System.out.println("parametros.length --- " + parametros.size());
            String archivoreporte = nbreArchivo + ".jrxml";
            System.out.println("reporte -> " + nbreArchivo);
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public Map<String, Object> convertirObjetoAMap(Object obj) {
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    public void GenerarPDF1(String nbreArchivo, String[][] parametros) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        System.out.println("Utilidades.Metodos.GenerarPDF()_ ENTRO A GENERAR PDF:");
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception j) {
                j.printStackTrace();
                this.consultas.mostrarErrorE(j);
            }
        }
        parametro.put("SUBREPORT_DIR", getDirectorioExportacion() + "reportes" + getBarra());
        parametro.put("SUBREPORTFIRMA_DIR", getDirectorioExportacion() + "Firmas" + getBarra());
        String archivoreporte = nbreArchivo + ".jrxml";
        System.out.println(archivoreporte);
        JasperReport report = JasperCompileManager.compileReport(archivoreporte);
        JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
        String narchivop = nbreArchivo + ".pdf";
        JasperExportManager.exportReportToPdfFile(print, narchivop);
        mostrarPdf(nbreArchivo + ".pdf");
        this.consultas.cerrarConexionBd();
    }

    private void GuardarPdfBienestarSalud(String archivoBase64, String idIngreso) {
        try {
            String sql = "INSERT INTO so_soporte_concepto (idIngreso,archivo) VALUES ('" + idIngreso + "','" + archivoBase64 + "')";
            System.out.println(sql);
            ConsultasMySQL xct = new ConsultasMySQL();
            xct.ejecutarSQLId(sql);
            System.out.println("Se guardó correctamente el pdf -Concepto aptitud laboral bienestarsalud");
            xct.cerrarConexionBd();
        } catch (Exception e) {
            System.out.println("Ocurrio un error " + e);
        }
    }

    public void GenerarPdfBieneastarSalud(String nbreArchivo, Object[][] parametros, String idIngreso, boolean guardarSoporte) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (parametros[i][0] != null) {
                    if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametros[i][0], parametros[i][1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            if (!nbreArchivo.contains("m_stiker")) {
                firmarDocumento(narchivop);
            }
            String archivo = encodeFileToBase64Binary(nbreArchivo + ".pdf");
            if (guardarSoporte) {
                GuardarPdfBienestarSalud(archivo, idIngreso);
                System.out.println("Se subio el soporte del ingreso " + idIngreso + " a so_soporte_concepto");
            }
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void GenerarPDF(String nbreArchivo, Object[][] parametros, Boolean Visualizar) {
        mEliminarArchivo(new File(nbreArchivo + ".pdf"));
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (parametros[i][0] != null) {
                    if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                        parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                    } else {
                        parametro.put(parametros[i][0], parametros[i][1]);
                    }
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            System.out.println(narchivop);
            if (!print.getPages().isEmpty()) {
                JasperExportManager.exportReportToPdfFile(print, narchivop);
                if (!nbreArchivo.contains("m_stiker")) {
                    firmarDocumento(narchivop);
                }
                if (Visualizar.booleanValue()) {
                    mostrarPdf(nbreArchivo + ".pdf");
                }
            }
        } catch (Exception j) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) j);
        }
        this.consultas.cerrarConexionBd();
    }

    private void firmarDocumento(String rutaArchivo) throws IOException {
        if (Principal.informacionIps.getFirmadoElectronico().intValue() == 1 && getFimarDoc().booleanValue()) {
            try {
                File f = new File(rutaArchivo);
                byte[] bytes = FileUtils.readFileToByteArray(f);
                List<FirmaDigitalDTO> listFima = this.firmaDigitalDAO.listadoFirmaDigital();
                InetAddress localHost = InetAddress.getLocalHost();
                PdfRequest pdfRequest = PdfRequest.builder().certificateFile(listFima.get(0).getCetificado()).certificatePwd(new String(Base64.getDecoder().decode(listFima.get(0).getContrasena()), StandardCharsets.UTF_8)).comentario("Firma aplicada desde el software Genoma Plus").pdfToSign(Base64.getEncoder().encodeToString(bytes)).informacionAdicional("Equipo: " + localHost.getHostName() + "; Usuario: " + Principal.usuarioSistemaDTO.getNombreUsuario()).destinationPath(rutaArchivo).build();
                Signer.writerLocalSignerPdf(pdfRequest);
            } catch (DocumentException | KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException | CertificateException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public static String encodeFileToBase64Binary(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] encoded = Base64.getEncoder().encode(FileUtils.readFileToByteArray(file));
        return new String(encoded, StandardCharsets.US_ASCII);
    }

    public void GenerarPDFOracle(String nbreArchivo, Object[][] parametros) {
        try {
            ConexionBaseOracle baseOracle = new ConexionBaseOracle();
            Connection con = baseOracle.getConexion();
            Map parametro = new HashMap();
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            mostrarPdf(nbreArchivo + ".pdf");
        } catch (JRException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public void GenerarPDF(String nbreArchivo, Object[][] parametros, String xnnombre) {
        mEliminarArchivo(new File(getDirectorioExportacion() + "Reportes" + getBarra() + xnnombre + ".pdf"));
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        String archivoreporte = nbreArchivo + ".jasper";
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (Object[] parametro1 : parametros) {
                if (!RutaFirma.isEmpty() && parametro1[0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametro1[0], parametro1[1]);
                }
            }
            JasperReport report = (JasperReport) JRLoader.loadObject(new File(archivoreporte));
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            firmarDocumento(narchivop);
            mostrarPdf(nbreArchivo + ".pdf", xnnombre + ".pdf");
        } catch (Exception j) {
            this.consultas.mostrarErrorE(j);
        }
        this.consultas.cerrarConexionBd();
    }

    public <T> void GenerarPDF(String nbreArchivo, T ObjetoDto, String xnnombre, boolean abrirPDF) {
        mEliminarArchivo(new File(getDirectorioExportacion() + "Reportes" + getBarra() + xnnombre + ".pdf"));
        try {
            ObjectMapper mapper = new ObjectMapper();
            String archivoreporte = nbreArchivo + ".jasper";
            JasperReport report = (JasperReport) JRLoader.loadObject(new File(archivoreporte));
            Map<String, Object> parameters = (Map) mapper.readValue(mapper.writeValueAsString(ObjetoDto), new TypeReference<Map<String, Object>>() { // from class: Utilidades.Metodos.2
            });
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            firmarDocumento(narchivop);
            if (abrirPDF) {
                mostrarPdf(nbreArchivo + ".pdf", xnnombre + ".pdf");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (JRException ex2) {
            System.out.println(ex2);
        }
    }

    public void GenerarPDFSinMostrar(String nbreArchivo, String[][] parametros) {
        mEliminarArchivo(new File(nbreArchivo + ".pdf"));
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
        } catch (Exception j) {
            this.consultas.mostrarErrorE(j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void EnviarPDFGeneradoHC(String nReporte, String Reporte, String[][] parametros, Boolean generarPDF, boolean enviar, String correoUsuario, Integer idModulo) {
        this.moduloCorreo = this.correoService.getCorreoModuloPorIdModulo(Principal.informacionGeneralPrincipalDTO.getIdModulo());
        System.out.println("" + nReporte);
        System.out.println("" + Principal.informacionGeneralPrincipalDTO.getIdModulo());
        System.err.println("enviar" + enviar);
        if (enviar) {
            if (!correoUsuario.isEmpty()) {
                getClass();
                if (correoUsuario.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                    Email xenviar = new Email();
                    List<String> xdestino = new ArrayList<>();
                    if (generarPDF.booleanValue()) {
                        mEliminarArchivo(new File(Reporte + ".pdf"));
                        CrearPDF(Reporte, parametros, Reporte);
                    }
                    xdestino.add(correoUsuario);
                    if (mExisteArchivo(Reporte + ".pdf")) {
                        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                            xdestino.add("cmsa_so@fundacionpanzenu.org.co");
                            String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                            xenviar.enviarAdjunto(xdestino, "Ver adjunto", remite, "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf");
                            return;
                        }
                        if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 2 || Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 14 || Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 5) {
                            switch (Principal.informacionIps.getNombreIps()) {
                                case "CLINICA PAJONAL S.A.S":
                                    xenviar.enviarAdjuntoGenerico(xdestino, "<html><p>Estimado usuario.</p>\n<p><br></p>\n<p>Cordial saludo</p>\n<p><br></p>\n<p>A continuaci&oacute;n, enviamos <strong>registros cl&iacute;nicos&nbsp;</strong>de la atenci&oacute;n brindada en nuestra instituci&oacute;n. As&iacute; mismo <strong>enlace de encuesta de satisfacci&oacute;n</strong>.</p>\n<p><br></p>\n<p>Favor tener presente para la pr&oacute;xima consulta:</p>\n<p><br></p>\n<p>Si es usuario de:</p>\n<ul>\n    <li>COOSALUD EPS</li>\n    <li>SAVIA SALUD</li>\n    <li>P&Oacute;LIZA SURAMERICANA PREPAGADA</li>\n    <li>COOMEVA MEDICINA PREPAGADA</li>\n    <li>COLSANITAS MEDICINA PREPAGADA</li>\n    <li>COLMEDICA MEDICINA PREPAGADA</li>\n    <li>ALLIANZ PREPAGADA</li>\n    <li>ARL POSITIVA</li>\n    <li>ARL SURAMERICANA</li>\n    <li>ARL COLMENA</li>\n    <li>ARL BOLIVAR</li>\n</ul>\n<p><br></p>\n<p>Noosotros realizaremos la gesti&oacute;n de la autorizaci&oacute;n por usted y le enviaremos el recordatorio de su cita por este correo.</p>\n<p><br></p>\n<p>Si pertenece a otra EPS, debe solicitar a su entidad la <strong>autorizaci&oacute;n</strong> de servicios de salud en formato legible.</p>\n<p><br></p>\n<p>Observaci&oacute;n: Si el Especialista le orden&oacute; <strong>medicamentos de CONTROL ESPECIAL</strong>, debe acercarse a la Cl&iacute;nica Pajonal o autorizar a un familiar responsable, para que le entreguen recetario de control especial (tener en cuenta que el punto de dispensaci&oacute;n de medicamentos de su EPS exige RECETARIO ORIGINAL).</p>\n<p><br></p>\n<p>Cualquier inquietud, se puede comunicar a los correos electr&oacute;nicos relacionados a continuaci&oacute;n:</p>\n<p><br></p>\n<p><strong>Atenci&oacute;n al usuario:</strong> <a href=\"mailto:atencionalusuario@clinicapajonal.com\">atencionalusuario@clinicapajonal.com</a></p>\n<p><strong>Citas:</strong> <a href=\"mailto:citas@clinicapajonal.com\">citas@clinicapajonal.com</a></p>\n<p><strong>Solicitud de historias:</strong> <a href=\"mailto:archivoclinico@clinicapajonal.com\">archivoclinico@clinicapajonal.com</a></p>\n<p><br></p>\n<p>Link Encuesta de satisfacci&oacute;n <a href=\"%3Ca%20data-fr-linked=\">https://forms.gle/s4JKrD7cyeUqLnaW6</a>&quot;&gt;<a href=\"https://forms.gle/s4JKrD7cyeUqLnaW6\">https://forms.gle/s4JKrD7cyeUqLnaW6</a></p>\n<p><br></p>\n<p>Favor no responder este correo; es una respuesta autom&aacute;tica.</p>\n<p>Atentamente,</p>\n<p><br></p></html>", "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                                    break;
                                case "CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.":
                                case "UNION TEMPORAL CLINICA LAURELES":
                                    xenviar.enviarAdjuntoGenerico(xdestino, "<html> <div>Estimado usuario, cordial saludo</div>\n<div>&nbsp;</div>\n<div>A continuaci&oacute;n enviamos <strong>registros cl&iacute;nicos&nbsp;</strong>de la atenci&oacute;n brindada por nuestro profesional. As&iacute; mismo adjuntamos <strong>Recordatorio</strong> de pr&oacute;xima cita y <strong>enlace de encuesta de satisfacci&oacute;n</strong>.</div>\n<div>&nbsp;</div>\n<div>Favor tener presente que para la pr&oacute;xima consulta, debe solicitar a su EPS o Entidad convenio, <strong>nueva autorizaci&oacute;n</strong> de servicios de salud</div>\n<div>&nbsp;</div>\n<div>Observaci&oacute;n: Si el Especialista en Psiquiatr&iacute;a, orden&oacute; <strong>medicamentos de CONTROL ESPECIAL</strong>, debe acercarse a nuestra IPS o autorizar a familiar responsable, para que le entreguen recetario de control especial (tener en cuenta que los puntos de dispensaci&oacute;n de medicamentos de su EPS exige RECETARIO ORIGINAL).</div>\n<div>&nbsp;</div>\n<div>Cualquier inquietud, se puede comunicar a los tel&eacute;fonos y correo electr&oacute;nico relacionados a continuaci&oacute;n:</div>\n<div>- 3205408981</div>\n<div>- 3008464713</div>\n<div>- 3045987974</div>\n<div>- 7820559</div>\n<div>- 7818298</div>\n<div><a href=\"mailto:admisiones@clinicalaureles.com\" target=\"_blank\" rel=\"noopener\">&nbsp;admisiones@clinicalaureles.com</a></div>\n<div>.</div>\n<div>.</div>\n<div>.</div>\n<div>Si por alg&uacute;n motivo a&uacute;n no ha enviado autorizaci&oacute;n de la valoraci&oacute;n ya recibida, agradecemos enviar foto legible.</div>\n<div>&nbsp;</div>\n<div>&nbsp;</div>\n<div>Link Encuesta de Satisfacci&oacute;n</div>\n<div><a href=\"https://docs.google.com/forms/d/1o-TuuVKMU29KlScZUfAPHJnNYgryq7_BPj73724S57s/viewform\" target=\"_blank\" rel=\"noopener\">https://docs.google.com/forms/d/1o-TuuVKMU29KlScZUfAPHJnNYgryq7_BPj73724S57s/viewform</a>?<span style=\"color: #000000;\">&nbsp;</span></div>\n<div><span style=\"color: #000000;\">&nbsp;</span></div>\n<div><span style=\"color: #000000;\">Gracias por confiar en nuestros servicios de salud mental</span></div>\n<div><span style=\"color: #000000; font-family: tahoma, sans-serif;\">&nbsp;</span></div>\n<div>\n<p><span style=\"color: #000000;\"><span style=\"font-family: tahoma, sans-serif;\">Por favor&nbsp;no&nbsp;responder&nbsp;este correo; es una respuesta autom&aacute;tica</span>.</span></p>\n<p><span style=\"color: #000000;\">&nbsp;</span></p>\n<p><span style=\"color: #000000;\">Atentamente,</span></p>\n<p><strong><span style=\"color: #000000;\">&nbsp;</span></strong></p>\n<p><strong><span style=\"color: #000000;\">CLINICA LAURELES PSIQUIATRAS ASOCIADOS</span></strong></p>\n<p><strong><span style=\"color: #000000;\"><span style=\"color: #000000; font-family: Palatino, georgia, serif;\">Carrera 2 #21-19 Monter&iacute;a-C&oacute;rdoba</span></span></strong></p>\n<p><img src=\"https://drive.google.com/uc?id=10H5EJPMdzk8Rjdsn5eTzjzd3_1qJSjlf&amp;export=download\" /></p>\n</div> </html>", "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                                    JOptionPane.showMessageDialog((Component) null, "Se ha finalizado el proceso de envio por correo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    break;
                                case "MEDICAL HOMECARE S.A.S.":
                                    xenviar.enviarAdjuntoGenerico(xdestino, "", "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                                    JOptionPane.showMessageDialog((Component) null, "Se ha finalizado el proceso de envio por correo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    break;
                                default:
                                    xenviar.enviarAdjuntoGenerico(xdestino, "", "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                                    break;
                            }
                        }
                        if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 27 && this.moduloCorreo != null) {
                            xenviar.enviarAdjuntoGenerico(xdestino, "", "NOTIFICACION DE ENVIO DE " + nReporte.toUpperCase(), Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (correoUsuario.isEmpty()) {
                JOptionPane.showMessageDialog((Component) null, "Usuario no registra correo electrónico\nFavor revisar", "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            } else {
                JOptionPane.showMessageDialog((Component) null, "Correo electrónico no se pudo enviar, no cumple con características\nFavor revisar", "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            }
        }
    }

    public void EnviarPDFGeneradoGenerico(String nReporte, String Reporte, String[][] parametros, Boolean generarPDF, boolean enviar, String correoUsuario, String tituloEnvio) {
        if (enviar) {
            if (!correoUsuario.isEmpty() && correoUsuario.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
                Email xenviar = new Email();
                List<String> xdestino = new ArrayList<>();
                if (generarPDF.booleanValue()) {
                    mEliminarArchivo(new File(Reporte + ".pdf"));
                    CrearPDF(Reporte, parametros, Reporte);
                }
                if (mExisteArchivo(Reporte + ".pdf")) {
                    xdestino.add(correoUsuario);
                    xenviar.enviarAdjuntoGenerico(xdestino, "Ver adjunto", tituloEnvio, Reporte.replace(getRutaRep(), "") + ".pdf", Reporte + ".pdf", this.moduloCorreo);
                    return;
                }
                return;
            }
            if (correoUsuario.isEmpty()) {
                JOptionPane.showMessageDialog((Component) null, "Usuario no registra correo electrónico\nFavor revisar", "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            } else {
                JOptionPane.showMessageDialog((Component) null, "Correo electrónico no se pudo enviar, no cumple con características\nFavor revisar", "VERIFICACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            }
        }
    }

    public void GenerarEnviarPDF(String nbreArchivo, String[][] parametros, String xcorreod, String xcuerpo, String asunto) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        List<String> xcorreod1 = new ArrayList<>();
        xcorreod1.add(xcorreod);
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = nbreArchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
            File f2 = new File(narchivop);
            String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            Email correo = new Email();
            correo.enviarAdjunto(xcorreod1, xcuerpo, remite, asunto, narchivop, nbreArchivo + ".pdf");
            f2.delete();
        } catch (Exception j) {
            this.consultas.mostrarErrorE(j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void CrearPDF(String nbreArchivo, String[][] parametros) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception j) {
                this.consultas.mostrarErrorE(j);
            }
        }
        String archivoreporte = nbreArchivo + ".jrxml";
        JasperReport report = JasperCompileManager.compileReport(archivoreporte);
        JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
        String narchivop = nbreArchivo + ".pdf";
        JasperExportManager.exportReportToPdfFile(print, narchivop);
        this.consultas.cerrarConexionBd();
    }

    public String mTraerUrlBD(String xdato) {
        String str;
        StringBuffer xvt = new StringBuffer(xdato);
        String xn = "";
        for (int x = 0; x < xvt.length(); x++) {
            if (xvt.charAt(x) == '\\') {
                str = xn + xvt.charAt(x) + getBarra();
            } else {
                str = xn + xvt.charAt(x);
            }
            xn = str;
        }
        return xn;
    }

    public GregorianCalendar getConvertirStringDate(String xdate) {
        GregorianCalendar xhoys = new GregorianCalendar();
        int dia = Integer.valueOf(xdate.substring(0, 2)).intValue();
        int mes = Integer.valueOf(xdate.substring(3, 5)).intValue() - 1;
        int ano = Integer.valueOf(xdate.substring(6, 10)).intValue();
        xhoys.set(ano, mes, dia);
        return xhoys;
    }

    public boolean mVerificarDatosTablaTrue(JTable xjtabla, int xpos) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= xjtabla.getRowCount()) {
                    break;
                }
                if (!xjtabla.getValueAt(i, xpos).toString().equals("true")) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public boolean mVerificarDatosTablaTrue(JTable xjtabla, int xpos, String xdato) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= xjtabla.getRowCount()) {
                    break;
                }
                if (!xjtabla.getValueAt(i, xpos).toString().equals(xdato)) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mImprimir_Pendiente_Laboratorio(String xid) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xid;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = getSO() + getBarra() + "Reportes" + getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = getSO() + getBarra() + "Firmas" + getBarra();
        PresentacionPreliminar(getRutaRep() + "L_Pendiente_NR.jasper", mparametros);
    }

    public boolean mVerificarDatosDoblesTabla(JTable xjtabla, int xpos, String xvalor) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= xjtabla.getRowCount()) {
                    break;
                }
                if (!xjtabla.getValueAt(i, xpos).toString().equals(xvalor)) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public boolean mVerificarDatosLLeno(JTable xjtabla, int xpos) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            for (int i = 0; i < xjtabla.getRowCount(); i++) {
                if (xjtabla.getValueAt(i, xpos) == null || xjtabla.getValueAt(i, xpos).equals("")) {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public boolean mVerificarDatosLLeno(JTable xjtabla, int xpos, int xpos_xcheck) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i < xjtabla.getRowCount()) {
                    if (!Boolean.valueOf(xjtabla.getValueAt(i, xpos_xcheck).toString()).booleanValue() || !xjtabla.getValueAt(i, xpos).toString().equals("")) {
                        i++;
                    } else {
                        estado = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return estado;
    }

    public boolean mVerificarDatosLLenoCero(JTable xjtabla, int xpos) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            int i = 0;
            while (true) {
                if (i >= xjtabla.getRowCount()) {
                    break;
                }
                if (Integer.valueOf(xjtabla.getValueAt(i, xpos).toString()).intValue() != 0) {
                    i++;
                } else {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mEnvioCorreoElectronico(String xmensaje, String xcorreoe, String xtitulo, String xfrom) {
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            String xfrom1 = xfrom + "@fundacionpanzenu.org.co";
            Email em = new Email();
            em.Send(xfrom1, xmensaje, xcorreoe, xtitulo);
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            String xfrom12 = xfrom + "@hospitalmontelibano.gov.co";
            Email em2 = new Email();
            em2.Send(xfrom12, xmensaje, xcorreoe, xtitulo);
        } else if (!Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS")) {
            if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                String xfrom13 = xfrom + "calidadsoaips@gmail.com";
                Email em3 = new Email();
                em3.Send(xfrom13, xmensaje, xcorreoe, xtitulo);
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CL�?NICO LABVY S.A.S")) {
                Email em4 = new Email();
                em4.Send("lidercalidad.labvy@gmail.com", xmensaje, xcorreoe, xtitulo);
            }
        }
    }

    public void CrearPDF(String nbreArchivo, String[][] parametros, String xnarchivo) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            String archivoreporte = nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = xnarchivo + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
        } catch (Exception j) {
            this.consultas.mostrarErrorE(j);
        }
        this.consultas.cerrarConexionBd();
    }

    public void mGenerarPDF(String nbreArchivo, String[][] parametros, String narch, String ruta) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String RutaFirma = mRutaSoporte("SUBREPORTFIRMA_DIR");
            for (int i = 0; i < parametros.length; i++) {
                if (!RutaFirma.isEmpty() && parametros[i][0].equals("SUBREPORTFIRMA_DIR")) {
                    parametro.put("SUBREPORTFIRMA_DIR", RutaFirma);
                } else {
                    parametro.put(parametros[i][0], parametros[i][1]);
                }
            }
            String archivoreporte = getRutaRep() + nbreArchivo + ".jrxml";
            JasperReport report = JasperCompileManager.compileReport(archivoreporte);
            JasperPrint print = JasperFillManager.fillReport(report, parametro, con);
            String narchivop = ruta + getBarra() + narch + ".pdf";
            JasperExportManager.exportReportToPdfFile(print, narchivop);
        } catch (Exception e) {
        }
        this.consultas.cerrarConexionBd();
    }

    public static void mBorrarDirectorio(File directorio) {
        File[] ficheros = directorio.listFiles();
        for (int x = 0; x < ficheros.length; x++) {
            if (ficheros[x].isDirectory()) {
                mBorrarDirectorio(ficheros[x]);
            }
            ficheros[x].delete();
        }
    }

    public boolean mEliminarArchivo(File xarchivo) {
        boolean xestado = false;
        if (xarchivo.delete()) {
            xestado = true;
        }
        return xestado;
    }

    public static synchronized Date mRestarFechasDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(5, -dias);
        return new Date(cal.getTimeInMillis());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], java.lang.String[][]] */
    public String[][] mArreglosBimestres(String[][] lista, JComboBox comb) {
        String[][] r0 = {new String[]{"ENERO - FEBRERO", "-01-01", "-02-29"}, new String[]{"MARZO - ABRIL", "-03-01", "-04-30"}, new String[]{"MAYO - JUNIO", "-05-01", "-06-30"}, new String[]{"JULIO - AGOSTO", "-07-01", "-08-31"}, new String[]{"SEPTIEMBRE - OCTUBRE", "-09-01", "-10-31"}, new String[]{"NOVIEMBRE - DICIEMBBRE", "-11-01", "-12-31"}};
        Object[][] objArr = new String[r0.length][3];
        for (int x = 0; x < r0.length; x++) {
            objArr[x][0] = r0[x][0];
            objArr[x][1] = r0[x][1];
            objArr[x][2] = r0[x][2];
            comb.addItem(r0[x][0]);
        }
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], java.lang.String[][]] */
    public String[][] mArreglosPAnual(String[][] lista, JComboBox comb) {
        String[][] r0 = {new String[]{"ENERO - DICIEMBRE", "-01-01", "-12-31"}};
        Object[][] objArr = new String[r0.length][3];
        for (int x = 0; x < r0.length; x++) {
            objArr[x][0] = r0[x][0];
            objArr[x][1] = r0[x][1];
            objArr[x][2] = r0[x][2];
            comb.addItem(r0[x][0]);
        }
        return r0;
    }

    public PieDataset mCrearDatosGrafico(JTable xjtabla, int xpost, int xposv) {
        DefaultPieDataset result = new DefaultPieDataset();
        for (int x = 0; x < xjtabla.getRowCount(); x++) {
            result.setValue(xjtabla.getValueAt(x, xpost).toString(), Integer.valueOf(xjtabla.getValueAt(x, xposv).toString()));
        }
        return result;
    }

    public String getRutaRep(String modulo) {
        return getSO() + getBarra() + "reportes" + getBarra();
    }

    public void PresentacionPreliminar(String nbreArchivo, String[][] parametros, int presentar) {
        Connection con = this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        for (int i = 0; i < parametros.length; i++) {
            try {
                parametro.put(parametros[i][0], parametros[i][1]);
            } catch (Exception e) {
                this.consultas.mostrarErrorE(e);
                return;
            }
        }
        JasperPrint imprimir = JasperFillManager.fillReport(nbreArchivo, parametro, con);
        if (presentar == 1) {
            JasperViewer vista = new JasperViewer(imprimir, false);
            vista.setVisible(true);
        }
        this.consultas.cerrarConexionBd();
    }

    public Boolean mVerificarEstadoAnular(String sql) {
        boolean xestado = false;
        try {
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(1)) {
                    xestado = true;
                } else {
                    xestado = false;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(xestado);
    }

    public Boolean mBuscarDatosBD(String sql) {
        boolean xestado = false;
        try {
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xestado = true;
            } else {
                xestado = false;
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Boolean.valueOf(xestado);
    }

    public String mCompletarCadena(String xdato, int xpos, String xcaracter) {
        String xdato1 = "";
        try {
            ResultSet xrs = this.consultas.traerRs("SELECT LPAD('" + xdato + "'," + xpos + ",'" + xcaracter + "')");
            if (xrs.next()) {
                xrs.first();
                xdato1 = xrs.getString(1);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
            return xdato1;
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return xdato1;
        }
    }

    public static void mExpandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        mExpandAll(tree, new TreePath(root), expand);
    }

    private static void mExpandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                mExpandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    public void mGenerarGrafico(String xidAtencion) {
        try {
            this.xAtencion = xidAtencion;
            XYDataset xydataset = xyDataset();
            XYDataset xydataseti = xyDatasetI();
            JFreeChart jfreechart = ChartFactory.createXYLineChart("Oido Derecho", "", "Resultado", xydataset, PlotOrientation.VERTICAL, true, true, false);
            JFreeChart jfreecharti = ChartFactory.createXYLineChart("Oido Izquierdo", "", "Resultado", xydataseti, PlotOrientation.VERTICAL, true, true, false);
            XYPlot xyplot = jfreechart.getPlot();
            xyplot.setBackgroundPaint(Color.lightGray);
            xyplot.setDomainGridlinePaint(Color.BLACK);
            xyplot.setRangeGridlinePaint(Color.BLACK);
            xyplot.getRenderer().setSeriesPaint(0, Color.RED);
            xyplot.getDomainAxisLocation();
            xyplot.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxis = xyplot.getRangeAxis();
            rangeAxis.setInverted(true);
            xyplot.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
            xylineandshaperenderer.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(getRutaRep() + "OidoDer.jpg"), jfreechart, 450, 260);
            XYPlot xyploti = jfreecharti.getPlot();
            xyploti.setBackgroundPaint(Color.lightGray);
            xyploti.setDomainGridlinePaint(Color.BLACK);
            xyploti.setRangeGridlinePaint(Color.BLACK);
            xyploti.getRenderer().setSeriesPaint(0, Color.BLUE);
            xyploti.setDomainAxisLocation(AxisLocation.TOP_OR_LEFT);
            NumberAxis rangeAxisY = xyploti.getRangeAxis();
            rangeAxisY.setInverted(true);
            xyploti.getRangeAxis().setRange(0.0d, 125.0d);
            XYLineAndShapeRenderer xylineandshaperendereri = xyploti.getRenderer();
            xylineandshaperendereri.setBaseShapesVisible(true);
            ChartUtilities.saveChartAsJPEG(new File(getRutaRep() + "OidoIzq.jpg"), jfreecharti, 450, 260);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Derecho");
        String sql = "SELECT `D500` , `D1000` , `D2000` , `D3000` , `D4000` , `D6000` , `D8000`  FROM `h_so_audiometria` WHERE (`Id_Atencion` ='" + this.xAtencion + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        try {
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                series1.add(500.0d, xrs.getInt("D500"));
                series1.add(1000.0d, xrs.getInt("D1000"));
                series1.add(2000.0d, xrs.getInt("D2000"));
                series1.add(3000.0d, xrs.getInt("D3000"));
                series1.add(4000.0d, xrs.getInt("D4000"));
                series1.add(6000.0d, xrs.getInt("D6000"));
                series1.add(8000.0d, xrs.getInt("D8000"));
                xyseriescollection.addSeries(series1);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xyseriescollection;
    }

    private XYDataset xyDatasetI() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("Oido Izquierdo");
        String sql = "SELECT `I500` , `I1000` , `I2000` , `I3000` , `I4000` , `I6000` , `I8000` FROM `h_so_audiometria` WHERE (`Id_Atencion` ='" + this.xAtencion + "');";
        ConsultasMySQL xct = new ConsultasMySQL();
        try {
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                series1.add(500.0d, xrs.getInt("I500"));
                series1.add(1000.0d, xrs.getInt("I1000"));
                series1.add(2000.0d, xrs.getInt("I2000"));
                series1.add(3000.0d, xrs.getInt("I3000"));
                series1.add(4000.0d, xrs.getInt("I4000"));
                series1.add(6000.0d, xrs.getInt("I6000"));
                series1.add(8000.0d, xrs.getInt("I8000"));
                xyseriescollection.addSeries(series1);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xyseriescollection;
    }

    public void cargarPanelOdontogramaDientes(JPanel xpanel) {
        this.xJPOdontogramaDientes = new JPOdontogramaDientes();
        this.xJPOdontogramaDientes.setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA INICIAL", 2, 0, new java.awt.Font("Arial", 1, 14), Color.BLACK));
        this.xJPOdontogramaDientes.setVisible(false);
        this.xJPOdontogramaDientes.Verde.setVisible(false);
        this.xJPOdontogramaDientes.Amarillo.setVisible(false);
        this.xJPOdontogramaDientes.Rojo.setVisible(false);
        this.xJPOdontogramaDientes.setBounds(1, 1, 699, 400);
        xpanel.add(this.xJPOdontogramaDientes);
        this.xJPOdontogramaDientesDx = new JPOdontogramaDientes();
        this.xJPOdontogramaDientesDx.setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA DIAGNÓSTICOS", 2, 0, new java.awt.Font("Arial", 1, 14), Color.BLACK));
        this.xJPOdontogramaDientesDx.setVisible(false);
        this.xJPOdontogramaDientesDx.Verde.setVisible(false);
        this.xJPOdontogramaDientesDx.Amarillo.setVisible(false);
        this.xJPOdontogramaDientesDx.Rojo.setVisible(false);
        this.xJPOdontogramaDientesDx.setBounds(1, 1, 699, 400);
        xpanel.add(this.xJPOdontogramaDientesDx);
        this.xJPOdontogramaDientesProc = new JPOdontogramaDientes();
        this.xJPOdontogramaDientesProc.setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA PROCEDIMIENTOS", 2, 0, new java.awt.Font("Arial", 1, 14), Color.BLACK));
        this.xJPOdontogramaDientesProc.setVisible(false);
        this.xJPOdontogramaDientesProc.Verde.setVisible(false);
        this.xJPOdontogramaDientesProc.Amarillo.setVisible(false);
        this.xJPOdontogramaDientesProc.Rojo.setVisible(false);
        this.xJPOdontogramaDientesProc.setBounds(1, 1, 699, 400);
        xpanel.add(this.xJPOdontogramaDientesProc);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xJPOdontogramaControlPlaca = new JPOdontogramaControlPlaca();
            this.xJPOdontogramaControlPlaca.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTROL PLACA", 2, 0, new java.awt.Font("Arial", 1, 14), Color.BLACK));
            this.xJPOdontogramaControlPlaca.setVisible(false);
            this.xJPOdontogramaControlPlaca.setBounds(1, 1, 699, 400);
            xpanel.add(this.xJPOdontogramaControlPlaca);
            return;
        }
        this.xJPOdontogramaCPCompleto = new JPOdontogramaCPCompleto();
        this.xJPOdontogramaCPCompleto.setBorder(BorderFactory.createTitledBorder((Border) null, "CONTROL PLACA", 2, 0, new java.awt.Font("Arial", 1, 14), Color.BLACK));
        this.xJPOdontogramaCPCompleto.setVisible(false);
        this.xJPOdontogramaCPCompleto.setBounds(1, 1, 699, 400);
        xpanel.add(this.xJPOdontogramaCPCompleto);
    }

    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, 1);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    public BufferedImage getScreenShot(Component component) {
        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), 1);
        component.paint(image.getGraphics());
        return image;
    }

    public void saveScreenShot(Component component, String filename, String modulo) throws Exception {
        File file = new File(mRutaSoporte(modulo) + filename);
        BufferedImage image = getScreenShot(component);
        ImageIO.write(image, "png", file);
    }

    public void traerImagenOdontograma() {
        File file = new File(getDirectorioExportacion() + "Reportes" + getBarra() + "OdontogramaInicial.png");
        try {
            ImageIO.write(createImage(this.xJPOdontogramaDientes), "png", file);
        } catch (IOException e) {
        }
    }

    private void mLimpiarOdontograma(JPanel xpanel) {
        System.err.println("panel" + xpanel);
        for (int u = 0; u < xpanel.getComponentCount(); u++) {
            if (xpanel.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                JPanel xjp = xpanel.getComponent(u);
                for (int x = 0; x < xjp.getComponentCount(); x++) {
                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                        JLabel xch = xjp.getComponent(x);
                        if (!xch.getName().equals("0")) {
                            xch.setIcon((Icon) null);
                        }
                    }
                }
            }
        }
    }

    public void mTraerDatosDienteDxOdontInicial(String xidUsuario) {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicialdx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_odontograma_inicialdx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicialdx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicialdx`.`IdUsuario` ='" + xidUsuario + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            System.err.println("panel1" + this.xJPOdontogramaDientes);
            mLimpiarOdontograma(this.xJPOdontogramaDientes);
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.xJPOdontogramaDientes.getComponentCount(); u++) {
                        if (this.xJPOdontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.xJPOdontogramaDientes.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mTraerDatosDienteProcOdontInicial(String xidUsuario) {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_odontograma_inicial_proc`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_odontograma_inicial_proc` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_odontograma_inicial_proc`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_odontograma_inicial_proc`.`IdUsuario` ='" + xidUsuario + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.xJPOdontogramaDientes.getComponentCount(); u++) {
                        if (this.xJPOdontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.xJPOdontogramaDientes.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mTraerDatosDienteDxTratamiento(String xidTratamiento) {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_dx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + xidTratamiento + "' AND `o_odontograma_figuras`.`Sombra` =0 AND o_hc_tratamiento_dx.Estado=1)";
            mLimpiarOdontograma(this.xJPOdontogramaDientesDx);
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.xJPOdontogramaDientesDx.getComponentCount(); u++) {
                        if (this.xJPOdontogramaDientesDx.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.xJPOdontogramaDientesDx.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void traerImagenOdontogramaDx() {
        File file = new File(getDirectorioExportacion() + "Reportes" + getBarra() + "OdontogramaDx.png");
        try {
            ImageIO.write(createImage(this.xJPOdontogramaDientesDx), "png", file);
        } catch (IOException e) {
        }
    }

    public Date mCalcularFechaNac(String edad) {
        Date fecha = null;
        String sql = "SELECT DATE(DATE_ADD(NOW(), INTERVAL -" + edad + " YEAR))";
        ResultSet rs = this.consultas.traerRs(sql);
        while (rs.next()) {
            try {
                fecha = rs.getDate(1);
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        return fecha;
    }

    public Integer CalcularEdadAnos(String fechaNacimiento1) {
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimiento1);
        LocalDate fechaActual = LocalDate.now();
        Integer edad = Integer.valueOf(Period.between(fechaNacimiento, fechaActual).getYears());
        return edad;
    }

    public void mTraerDatosDienteProcTratamiento(String xidTratamiento) {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_procedimiento`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_tratamiento_procedimiento` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_procedimiento`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + xidTratamiento + "' AND `o_odontograma_figuras`.`Sombra` =0 AND o_hc_tratamiento_procedimiento.Estado=1)";
            mLimpiarOdontograma(this.xJPOdontogramaDientesProc);
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    for (int u = 0; u < this.xJPOdontogramaDientesProc.getComponentCount(); u++) {
                        if (this.xJPOdontogramaDientesProc.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel xjp = this.xJPOdontogramaDientesProc.getComponent(u);
                            if (xjp.getName().equals(xrs.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= xjp.getComponentCount()) {
                                        break;
                                    }
                                    if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel xch = xjp.getComponent(x);
                                        if (xch.getName().equals(xrs.getString(2))) {
                                            xch.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void traerImagenOdontogramaProc() {
        File file = new File(getDirectorioExportacion() + "Reportes" + getBarra() + "OdontogramaProc.png");
        try {
            ImageIO.write(createImage(this.xJPOdontogramaDientesProc), "png", file);
        } catch (IOException e) {
        }
    }

    public void mReproducir_Sonido(int NRepeticiones) {
        try {
            Clip sonido = AudioSystem.getClip();
            if (mExisteArchivo(getRutaRep() + "Alarma.wav")) {
                File a = new File(getRutaRep() + "Alarma.wav");
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.loop(NRepeticiones);
                Thread.sleep(3000L);
                sonido.close();
            }
        } catch (Exception e) {
        }
    }

    public void mReproducir_Mp3(String xruta) {
    }

    public void mTraerDatosDienteMarcadosControlPlaca(String xidTratamiento) {
        try {
            String sql = "SELECT  `o_controlp_diente_cara`.`NDiente` , `o_controlp_diente_cara`.`Lado`  , `o_controlp_tratamiento_detalle`.`Proceso` , `o_controlp_figuras`.`Ruta`  FROM `o_controlp_tratamiento_detalle` INNER JOIN `o_controlp_diente_cara`  ON (`o_controlp_tratamiento_detalle`.`IdDienteCara` = `o_controlp_diente_cara`.`Id`)  INNER JOIN  `o_controlp_figuras`   ON (`o_controlp_diente_cara`.`Lado` = `o_controlp_figuras`.`Lado`) INNER JOIN  `o_controlp_proceso`  ON (`o_controlp_tratamiento_detalle`.`Proceso` = `o_controlp_proceso`.`Nbre`) AND (`o_controlp_figuras`.`Id_cp_proceso` = `o_controlp_proceso`.`Id`) WHERE (`o_controlp_tratamiento_detalle`.`IdTratamiento` ='" + xidTratamiento + "')";
            ResultSet xrs = this.consultas.traerRs(sql);
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                mLimpiarOdontograma(this.xJPOdontogramaControlPlaca.JPImOdontogramaHistorico);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        for (int u = 0; u < this.xJPOdontogramaControlPlaca.JPImOdontogramaHistorico.getComponentCount(); u++) {
                            if (this.xJPOdontogramaControlPlaca.JPImOdontogramaHistorico.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                                JPanel xjp = this.xJPOdontogramaControlPlaca.JPImOdontogramaHistorico.getComponent(u);
                                if (xjp.getName().equals(xrs.getString(1))) {
                                    int x = 0;
                                    while (true) {
                                        if (x >= xjp.getComponentCount()) {
                                            break;
                                        }
                                        if (xjp.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                            JLabel xch = xjp.getComponent(x);
                                            if (xch.getName().equals(xrs.getString(2))) {
                                                xch.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                                break;
                                            }
                                        }
                                        x++;
                                    }
                                }
                            }
                        }
                        n++;
                    }
                }
            } else {
                mLimpiarOdontograma(this.xJPOdontogramaCPCompleto.JPImOdontograma);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n2 = 0;
                    while (xrs.next()) {
                        for (int u2 = 0; u2 < this.xJPOdontogramaCPCompleto.JPImOdontograma.getComponentCount(); u2++) {
                            if (this.xJPOdontogramaCPCompleto.JPImOdontograma.getComponent(u2).getClass().getName().equals("javax.swing.JPanel")) {
                                JPanel xjp2 = this.xJPOdontogramaCPCompleto.JPImOdontograma.getComponent(u2);
                                if (xjp2.getName().equals(xrs.getString(1))) {
                                    int x2 = 0;
                                    while (true) {
                                        if (x2 >= xjp2.getComponentCount()) {
                                            break;
                                        }
                                        if (xjp2.getComponent(x2).getClass().getName().equals("javax.swing.JLabel")) {
                                            JLabel xch2 = xjp2.getComponent(x2);
                                            if (xch2.getName().equals(xrs.getString(2))) {
                                                xch2.setIcon(new ImageIcon(getDirectorioExportacion() + xrs.getString(4).replace("\\", getBarra())));
                                                break;
                                            }
                                        }
                                        x2++;
                                    }
                                }
                            }
                        }
                        n2++;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPControlPlaca.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCrearVista(String xnombre, String sql) {
        String xsql = "DROP VIEW IF EXISTS " + xnombre + "";
        this.consultas.ejecutarSQL(xsql);
        this.consultas.cerrarConexionBd();
        String xsql2 = "CREATE    VIEW " + xnombre + "  AS " + sql;
        this.consultas.ejecutarSQL(xsql2);
        this.consultas.cerrarConexionBd();
    }

    public void mImprimePDFSinPreview(String xRuta) {
        Desktop desktop = Desktop.getDesktop();
        File fichero = new File(xRuta);
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                desktop.print(fichero);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void traerImagenOdontogramaControlPlaca() {
        File file = new File(getDirectorioExportacion() + "Reportes" + getBarra() + "OdontogramaControlP.png");
        try {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                ImageIO.write(createImage(this.xJPOdontogramaControlPlaca.JPImOdontogramaHistorico), "png", file);
            } else {
                ImageIO.write(createImage(this.xJPOdontogramaCPCompleto.JPImOdontograma), "png", file);
            }
        } catch (IOException e) {
        }
    }

    public boolean mComparar_Fecha_Hora(String xFecha1, String xFecha2) {
        boolean xresultado;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date fecha1 = sdf.parse(xFecha1.substring(0, xFecha1.length() - 3), new ParsePosition(0));
        Date fecha2 = sdf.parse(xFecha2.substring(0, xFecha1.length() - 3), new ParsePosition(0));
        if (fecha2.before(fecha1)) {
            xresultado = true;
        } else {
            xresultado = false;
        }
        return xresultado;
    }

    public void mEnableComponetes(Container c, boolean band) {
        Component[] components = c.getComponents();
        c.setEnabled(band);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);
            if (components[i] instanceof Container) {
                mEnableComponetes((Container) components[i], band);
            }
        }
    }

    private void clearForm(Object panel) {
        String nombre_clase = panel.getClass().getName();
        if (nombre_clase.equals("javax.swing.JPanel")) {
            clearPanel((JPanel) panel);
        } else if (nombre_clase.equals("javax.swing.JScrollPane")) {
            clearScrollPane((JScrollPane) panel);
        }
    }

    public void clearPanel(JPanel panel) {
        Component[] componentes = panel.getComponents();
        for (Component component : componentes) {
            clearComponent(component);
        }
    }

    private void clearScrollPane(JScrollPane panel) {
        Component[] componentes = panel.getViewport().getComponents();
        for (Component component : componentes) {
            clearComponent(component);
        }
    }

    private void clearComponent(Component comp) {
        String nombre_clase = comp.getClass().getName();
        if (nombre_clase.equals("javax.swing.JTextField")) {
            ((JTextField) comp).setText("");
            return;
        }
        if (nombre_clase.equals("javax.swing.JComboBox")) {
            ((JComboBox) comp).setSelectedIndex(0);
            return;
        }
        if (nombre_clase.equals("javax.swing.JTextArea")) {
            ((JTextArea) comp).setText("");
            return;
        }
        if (nombre_clase.equals("javax.swing.JPanel")) {
            clearPanel((JPanel) comp);
        } else if (nombre_clase.equals("javax.swing.JScrollPane")) {
            clearScrollPane((JScrollPane) comp);
        } else if (nombre_clase.equals("javax.swing.JCheckBox")) {
            ((JCheckBox) comp).setSelected(false);
        }
    }

    public boolean mValidarDx(String CIE10, String FechaNac, String Sexo) {
        boolean sw = false;
        String TipoEdadCIE10 = "0";
        String sql = "SELECT  Devuelve_Tipo_Edad_CIE10('" + FechaNac + "') AS edad";
        ResultSet rs = this.consultas.traerRs(sql);
        while (rs.next()) {
            try {
                TipoEdadCIE10 = rs.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        try {
            String sql2 = "SELECT IF(((Sexo='A' OR Sexo='" + Sexo + "') AND LimInf='0' AND LimSup='0'),1,\n               IF(Sexo='A' AND '" + TipoEdadCIE10 + "'>=LimInf AND '" + TipoEdadCIE10 + "'<=LimSup,1,\n   IF(Sexo='" + Sexo + "' AND '" + TipoEdadCIE10 + "'>=LimInf AND '" + TipoEdadCIE10 + "'<=LimSup,1,\n    IF(Sexo='" + Sexo + "' AND '" + TipoEdadCIE10 + "'>=LimInf AND '" + TipoEdadCIE10 + "'<=LimSup,1,0\n    )\n   )\n      )\n          ) AS DATO\n FROM `g_patologia` WHERE (`Id` ='" + CIE10 + "' and Estado=1  )";
            ResultSet rs2 = this.consultas.traerRs(sql2);
            while (rs2.next()) {
                if (rs2.getString(1).equals("1")) {
                    sw = true;
                }
            }
            rs2.close();
            this.consultas.cerrarConexionBd();
            return sw;
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            return sw;
        }
    }

    public void mConcatenar_PDF(List<InputStream> streamOfPDFFiles, OutputStream outputStream, boolean paginate) {
        Document document = new Document();
        try {
            try {
                List<PdfReader> readers = new ArrayList<>();
                int totalPages = 0;
                for (InputStream pdf : streamOfPDFFiles) {
                    PdfReader pdfReader = new PdfReader(pdf);
                    readers.add(pdfReader);
                    totalPages += pdfReader.getNumberOfPages();
                }
                PdfWriter writer = PdfWriter.getInstance(document, outputStream);
                document.open();
                PdfContentByte cb = writer.getDirectContent();
                int currentPageNumber = 0;
                int pageOfCurrentReaderPDF = 0;
                for (PdfReader pdfReader2 : readers) {
                    while (pageOfCurrentReaderPDF < pdfReader2.getNumberOfPages()) {
                        Rectangle rectangle = pdfReader2.getPageSizeWithRotation(1);
                        document.setPageSize(rectangle);
                        document.newPage();
                        pageOfCurrentReaderPDF++;
                        currentPageNumber++;
                        PdfImportedPage page = writer.getImportedPage(pdfReader2, pageOfCurrentReaderPDF);
                        switch (rectangle.getRotation()) {
                            case 0:
                                cb.addTemplate(page, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
                                break;
                            case 90:
                                cb.addTemplate(page, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, pdfReader2.getPageSizeWithRotation(1).getHeight());
                                break;
                            case 180:
                                cb.addTemplate(page, -1.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f);
                                break;
                            case 270:
                                cb.addTemplate(page, 0.0f, 1.0f, -1.0f, 0.0f, pdfReader2.getPageSizeWithRotation(1).getWidth(), 0.0f);
                                break;
                        }
                        if (paginate) {
                            cb.beginText();
                            cb.getPdfDocument().getPageSize();
                            cb.endText();
                        }
                    }
                    pageOfCurrentReaderPDF = 0;
                }
                outputStream.flush();
                document.close();
                outputStream.close();
                if (document.isOpen()) {
                    document.close();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (document.isOpen()) {
                    document.close();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException ioe2) {
                        ioe2.printStackTrace();
                    }
                }
            }
        } catch (Throwable th) {
            if (document.isOpen()) {
                document.close();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ioe3) {
                    ioe3.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    public void mImprimirCodZebraCentral(String nRecepcion, String nDato1, String nDato2, String abreviaturaP, String tipoMuestra, String fecha, String municipio) {
        try {
            List<String> impresora = new ArrayList<>();
            PrintServiceLookup.lookupDefaultPrintService();
            impresora.add("BARCODE");
            String zplDatos = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO215,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO215,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO215,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO215,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO415,210^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO215,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,40\n^FO215,175^FD" + nRecepcion.trim() + "^FS\n^XZ";
            if (!zplDatos.isEmpty()) {
                System.out.println(zplDatos);
                byte[] by = zplDatos.getBytes();
                SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                if (findPrintService(impresora) != null) {
                    DocPrintJob job = findPrintService(impresora).createPrintJob();
                    job.print(simpleDoc, (PrintRequestAttributeSet) null);
                }
            }
        } catch (PrintException e) {
        }
    }

    public void imprimirCodZebraCentralSImple(String codigo) {
        try {
            List<String> impresora = new ArrayList<>();
            PrintServiceLookup.lookupDefaultPrintService();
            System.out.println("SELECT x.nbre_impresora, x.nbre_pc, x.cod_zpl, x.query FROM l_config_sticker x where x.idModulo =4");
            ResultSet rs = this.consultas.traerRs("SELECT x.nbre_impresora, x.nbre_pc, x.cod_zpl, x.query FROM l_config_sticker x where x.idModulo =4");
            try {
                if (rs.next()) {
                    rs.first();
                    impresora.add(rs.getString("nbre_impresora"));
                    System.out.println("" + impresora.get(0));
                    String zplDatos = "^XA\n^LL100\n^PW1030\n^FO20,20^BY2,2,50\n^BCN,60,Y,N,N^FD" + codigo + "^FS\n^FO290,20^BCN,60,Y,N,N^FD" + codigo + "^FS\n^FO565,20^BCN,60,Y,N,N^FD" + codigo + "^FS\n^XZ";
                    if (!zplDatos.isEmpty()) {
                        System.out.println(zplDatos);
                        byte[] by = zplDatos.getBytes();
                        SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                        if (findPrintService(impresora) != null) {
                            DocPrintJob job = findPrintService(impresora).createPrintJob();
                            job.print(simpleDoc, (PrintRequestAttributeSet) null);
                        }
                    }
                }
                rs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } catch (PrintException e) {
        }
    }

    public void mImprimir_CodBarraZebraV2(StickerPrintDto stickerPrintDto) {
        if (stickerPrintDto == null) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "El objeto stickerPrintDto es nulo");
            return;
        }
        String printerName = stickerPrintDto.getNamePrinter();
        List<String> listCodesZPL = stickerPrintDto.getListCodesZPL();
        if (printerName == null || printerName.isEmpty()) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "El nombre de la impresora es nulo o vacío");
            return;
        }
        if (listCodesZPL == null || listCodesZPL.isEmpty()) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "La lista de códigos ZPL es nula o está vacía");
            return;
        }
        List<String> impresora = new ArrayList<>();
        impresora.add(printerName);
        PrintService printService = findPrintService(impresora);
        if (printService == null) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "No se encontró la impresora: " + printerName);
            return;
        }
        for (String zpl : listCodesZPL) {
            if (zpl == null || zpl.isEmpty()) {
                Logger.getLogger(Metodos.class.getName()).log(Level.WARNING, "Un código ZPL está vacío o nulo. Saltando...");
            } else {
                try {
                    Logger.getLogger(Metodos.class.getName()).log(Level.INFO, "Procesando código ZPL: " + zpl);
                    byte[] by = zpl.getBytes(StandardCharsets.UTF_8);
                    SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job = printService.createPrintJob();
                    if (job == null) {
                        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "El trabajo de impresión es nulo para la impresora: " + printerName);
                    } else {
                        job.print(simpleDoc, (PrintRequestAttributeSet) null);
                    }
                } catch (PrintException e) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error al imprimir: " + e.getMessage(), e);
                } catch (NullPointerException e2) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Referencia nula: " + e2.getMessage(), (Throwable) e2);
                } catch (Exception e3) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error inesperado al imprimir código ZPL: " + zpl, (Throwable) e3);
                }
            }
        }
    }

    public void mImpirmir_CodBarraZebra(String nRecepcion, String nDato1, String nDato2, String abreviaturaP, String tipoMuestra, String fecha, String municipio, StickerSettingsDTO settingsDTO) {
        String zplDatos;
        System.out.println(nRecepcion + "-----" + nDato1 + "-------" + nDato2 + "-------" + abreviaturaP + "------" + tipoMuestra + "-------" + fecha + "-----" + municipio);
        try {
            List<String> impresora = new ArrayList<>();
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                String zplDatos2 = "^XA\n^FX Second section with recipient address and permit information.\n^CFA,15\n^FO30,20^FD" + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO30,40^FD" + nDato2 + "^FS\n^FO30,60^FD" + fecha + "^FS\n^FO30,80^FD" + abreviaturaP + "^FS\n^FO30,100^FD" + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60\n^FO100,120^BC^FD" + nRecepcion + "^FS\n\n^XZ";
                System.out.println("ZPL datos -> " + zplDatos2);
                byte[] by = zplDatos2.getBytes();
                SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job = printService.createPrintJob();
                job.print(simpleDoc, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                impresora.add("ZDesigner ZD230-203dpi ZPL");
                if (InetAddress.getLocalHost().getHostName().equals("RECEPCION2") || InetAddress.getLocalHost().getHostName().equals("DESKTOP-6N8JF5Q")) {
                    byte[] by2 = ("^XA\n^FX Second section with recipient address and permit information.\n^CFA,15\n^FO20,25^ADN, 11, 7^FD" + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO20,45^ADN, 11, 7^FD" + nDato2 + "^FS\n^FO20,185^ADN, 11, 7^FD" + fecha + "^FS\n^FO170,185^ADN, 11, 7^FD" + municipio + "^FS\n^FO20,65^ADN, 11, 7^FD" + tipoMuestra + " " + abreviaturaP + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,65\n^FO50,95^BC^FD" + nRecepcion + "^FS\n^XZ").getBytes();
                    SimpleDoc simpleDoc2 = new SimpleDoc(by2, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job2 = findPrintService(impresora).createPrintJob();
                    job2.print(simpleDoc2, (PrintRequestAttributeSet) null);
                } else {
                    String zplDatos3 = "^XA\n^FX Second section with recipient address and permit information.\n^CFA,15\n^FO120,25^ADN, 11, 7^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO120,45^ADN, 11, 7^FD " + nDato2 + "^FS\n^FO120,185^ADN, 11, 7^FD " + fecha + "^FS\n^FO270,185^ADN, 11, 7^FD " + municipio + "^FS\n^FO120,65^ADN, 11, 7^FD " + tipoMuestra + " " + abreviaturaP + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,65\n^FO180,95^BC^FD" + nRecepcion + "^FS\n\n^XZ";
                    System.out.println(zplDatos3);
                    byte[] by3 = zplDatos3.getBytes();
                    SimpleDoc simpleDoc3 = new SimpleDoc(by3, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job3 = printService.createPrintJob();
                    job3.print(simpleDoc3, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                byte[] by4 = ("^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO80,20^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO80,40^ADN, 11, 7^FD " + nDato2 + "^FS\n^FO80,180^ADN, 11, 7^FD " + fecha + "^FS\n^FO80,60^ADN, 11, 7^FD " + abreviaturaP + "^FS\n^FO80,70^ADN, 11, 7^FD " + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO90,90^BC^FD" + nRecepcion + "^FS\n^CF0,40\n^FO300,170^FD" + nRecepcion + "^FS^XZ").getBytes();
                SimpleDoc simpleDoc4 = new SimpleDoc(by4, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job4 = printService.createPrintJob();
                job4.print(simpleDoc4, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                System.err.println("llego aqui valle del dot");
                impresora.add("ZDesigner ZD230-203dpi ZPL");
                String zplDatos4 = settingsDTO.getCodeZPL().replace(":nDato1", nDato1).replace(":nDato2", nDato2).replace(":fecha", fecha).replace(":abreviaturaP", abreviaturaP).replace(":tipoMuestra", tipoMuestra).replace(":nRecepcion", nRecepcion);
                if (!zplDatos4.isEmpty()) {
                    System.out.println(zplDatos4);
                    byte[] by5 = zplDatos4.getBytes();
                    SimpleDoc simpleDoc5 = new SimpleDoc(by5, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job5 = findPrintService(impresora).createPrintJob();
                    job5.print(simpleDoc5, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL SAN JUAN DE SAHAGUN") || Principal.informacionIps.getNombreIps().equals("UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("FUNDACION UNIONVIDA") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                try {
                    impresora.add(settingsDTO.getNamePrinter());
                    String zplDatos5 = settingsDTO.getCodeZPL().replace(":nDato1", nDato1).replace(":nDato2", nDato2).replace(":fecha", fecha).replace(":abreviaturaP", abreviaturaP).replace(":tipoMuestra", tipoMuestra).replace(":nRecepcion", nRecepcion);
                    System.out.println("ZPL datos -> " + zplDatos5);
                    byte[] by6 = zplDatos5.getBytes();
                    SimpleDoc simpleDoc6 = new SimpleDoc(by6, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job6 = findPrintService(impresora).createPrintJob();
                    job6.print(simpleDoc6, (PrintRequestAttributeSet) null);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            } else if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
                byte[] by7 = ("^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO190,20^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO190,40^ADN, 11, 7^FD " + nDato2 + "^FS^FS\n^FO190,200^ADN, 11, 7^FD " + fecha + "^FS\n^FO190,60^ADN, 11, 7^FD " + abreviaturaP + "^FS\n^FO190,75^ADN, 11, 7^FD " + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO250,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO485,185^FD" + nRecepcion + "^FS\n^XZ").getBytes();
                SimpleDoc simpleDoc7 = new SimpleDoc(by7, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job7 = printService.createPrintJob();
                job7.print(simpleDoc7, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                byte[] by8 = ("^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO40,20^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO40,40^ADN, 11, 7^FD " + nDato2 + "^FS^FS\n^FO40,200^ADN, 11, 7^FD " + fecha + "^FS\n^FO40,60^ADN, 11, 7^FD " + abreviaturaP + "^FS\n^FO40,75^ADN, 11, 7^FD " + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO40,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO190,185^FD" + nRecepcion + "^FS\n^XZ").getBytes();
                SimpleDoc simpleDoc8 = new SimpleDoc(by8, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job8 = printService.createPrintJob();
                job8.print(simpleDoc8, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                byte[] by9 = ("^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO260,20^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO260,40^ADN, 11, 7^FD " + nDato2 + "^FS^FS\n^FO260,200^ADN, 11, 7^FD " + fecha + "^FS\n^FO260,60^ADN, 11, 7^FD " + abreviaturaP + "^FS\n^FO260,75^ADN, 11, 7^FD " + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO260,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO485,185^FD" + nRecepcion + "^FS\n^XZ").getBytes();
                SimpleDoc simpleDoc9 = new SimpleDoc(by9, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job9 = printService.createPrintJob();
                job9.print(simpleDoc9, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                String zplDatos6 = "";
                try {
                    switch (InetAddress.getLocalHost().getHostName()) {
                        case "DESKTOP-00GUVT2":
                            impresora.add("ZDesigner GC420t (EPL)");
                            zplDatos6 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO220,20^FD" + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO220,40^ADN, 11, 7^FD" + nDato2 + "^FS^FS\n^FO220,185^ADN, 11, 7^FD" + fecha + "^FS\n^FO220,60^ADN, 11, 7^FD" + abreviaturaP + "^FS\n^FO220,75^ADN, 11, 7^FD" + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO220,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO408,176^FD" + nRecepcion + "^FS\n^XZ";
                            break;
                        case "DESKTOP-C5MS9KJ":
                            impresora.add("ZDesigner GC420t (EPL)");
                            zplDatos6 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO225,20^FD" + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO225,40^ADN, 11, 7^FD" + nDato2 + "^FS^FS\n^FO225,185^ADN, 11, 7^FD" + fecha + "^FS\n^FO225,60^ADN, 11, 7^FD" + abreviaturaP + "^FS\n^FO225,75^ADN, 11, 7^FD" + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO305,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO508,176^FD" + nRecepcion + "^FS\n^XZ";
                            break;
                        default:
                            impresora.add("ZDesigner GK420t");
                            zplDatos6 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO50,20^FD" + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO50,40^ADN, 11, 7^FD" + nDato2 + "^FS^FS\n^FO50,185^ADN, 11, 7^FD" + fecha + "^FS\n^FO50,60^ADN, 11, 7^FD" + abreviaturaP + "^FS\n^FO50,75^ADN, 11, 7^FD" + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO100,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO308,176^FD" + nRecepcion + "^FS\n^XZ";
                            break;
                    }
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                byte[] by10 = zplDatos6.getBytes();
                SimpleDoc simpleDoc10 = new SimpleDoc(by10, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job10 = findPrintService(impresora).createPrintJob();
                job10.print(simpleDoc10, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                String zplDatos7 = "";
                try {
                    if (InetAddress.getLocalHost().getHostName().equals("TOMADEMUESTRA") || InetAddress.getLocalHost().getHostName().equals("LABORATORIO")) {
                        impresora.add("ZDesigner ZD230-203dpi ZPL");
                        System.out.println("zplllll -> " + settingsDTO.getCodeZPL());
                        zplDatos7 = settingsDTO.getCodeZPL().replace(":nDato1", nDato1).replace(":nDato2", nDato2).replace(":fecha", fecha).replace(":abreviaturaP", abreviaturaP).replace(":tipoMuestra", tipoMuestra).replace(":nRecepcion", nRecepcion);
                        System.out.println("ZPL datos -> " + zplDatos7);
                    }
                } catch (UnknownHostException ex2) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
                if (!zplDatos7.isEmpty()) {
                    byte[] by11 = zplDatos7.getBytes();
                    SimpleDoc simpleDoc11 = new SimpleDoc(by11, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job11 = findPrintService(impresora).createPrintJob();
                    job11.print(simpleDoc11, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                impresora.add("BARCODE");
                if (nRecepcion.startsWith("0") || Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                    zplDatos = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO20,20^FD" + nDato1 + "^FS\n^FO20,40^AN, 15, 15^FD" + nDato2 + "^FS\n^FO20,52^AN, 15, 15^FD" + abreviaturaP + "^FS\n^FO20,65^AN, 15, 15^FD" + tipoMuestra + "^FS\n^FO20,170^AN, 20, 15^FD" + fecha + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY1,2,50,350\n^FO100,90^BCN,73,N^FD" + nRecepcion + "^FS\n^CF0,30\n^FO200,165^FD" + nRecepcion + "^FS\n^XZ";
                } else {
                    zplDatos = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO20,20^FD" + nDato1 + "^FS\n^FO20,40^AN, 15, 15^FD" + nDato2 + "^FS\n^FO20,52^AN, 15, 15^FD" + abreviaturaP + "^FS\n^FO20,65^AN, 15, 15^FD" + tipoMuestra + "^FS\n^FO20,170^AN, 20, 15^FD" + fecha + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO100,90^BCN,73,N^FD" + nRecepcion + "^FS\n^CF0,30\n^FO200,165^FD" + nRecepcion + "^FS\n^XZ";
                }
                if (!zplDatos.isEmpty()) {
                    System.out.println(zplDatos);
                    byte[] by12 = zplDatos.getBytes();
                    SimpleDoc simpleDoc12 = new SimpleDoc(by12, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job12 = findPrintService(impresora).createPrintJob();
                    job12.print(simpleDoc12, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                impresora.add("Zebra GK420t-ZPL");
                impresora.add("Zebra ZD420 (203 dpi) - ZPL");
                String zplDatos8 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO20,20^FD" + nDato1 + "^FS\n^FO20,40^AN, 15, 15^FD" + nDato2 + "^FS\n^FO20,52^AN, 15, 15^FD" + abreviaturaP + "^FS\n^FO20,65^AN, 15, 15^FD" + tipoMuestra + "^FS\n^FO20,130^AN, 20, 15^FD" + fecha + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO100,80^BCN,32,N^FD" + nRecepcion + "^FS\n^CF0,20\n^FO200,120^FD" + nRecepcion + "^FS\n^XZ";
                if (!zplDatos8.isEmpty()) {
                    System.out.println(zplDatos8);
                    byte[] by13 = zplDatos8.getBytes();
                    SimpleDoc simpleDoc13 = new SimpleDoc(by13, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job13 = findPrintService(impresora).createPrintJob();
                    job13.print(simpleDoc13, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                impresora.add("BARCODE");
                String zplDatos9 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO200,20^FD" + nDato1 + "^FS\n^FO200,40^AN, 15, 15^FD" + nDato2 + "^FS\n^FO200,60^AN, 15, 15^FD" + abreviaturaP + "^FS\n^FO200,75^AN, 15, 15^FD" + tipoMuestra + "^FS\n^FO200,200AN, 20, 15^FD" + fecha + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO200,100^BCN,62,N^FD" + nRecepcion + "^FS\n^CF0,30\n^FO425,185^FD" + nRecepcion + "^FS\n^XZ";
                if (!zplDatos9.isEmpty()) {
                    System.out.println(zplDatos9);
                    byte[] by14 = zplDatos9.getBytes();
                    SimpleDoc simpleDoc14 = new SimpleDoc(by14, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job14 = findPrintService(impresora).createPrintJob();
                    job14.print(simpleDoc14, (PrintRequestAttributeSet) null);
                }
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ")) {
                impresora.add("ZDesigner LP 2824 Plus (ZPL) (Copiar 1)");
                String zplDatos10 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO30,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO30,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO30,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO30,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO30,180^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO40,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,40\n^FO215,180^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos10.isEmpty()) {
                    System.out.println(zplDatos10);
                    byte[] by15 = zplDatos10.getBytes();
                    SimpleDoc simpleDoc15 = new SimpleDoc(by15, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        DocPrintJob job15 = findPrintService(impresora).createPrintJob();
                        job15.print(simpleDoc15, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                impresora.add("BARCODE");
                String zplDatos11 = settingsDTO.getCodeZPL().replace(":nDato1", nDato1).replace(":nDato2", nDato2).replace(":fecha", fecha).replace(":abreviaturaP", abreviaturaP).replace(":tipoMuestra", tipoMuestra).replace(":nRecepcion", nRecepcion);
                if (!zplDatos11.isEmpty()) {
                    System.out.println(zplDatos11);
                    byte[] by16 = zplDatos11.getBytes();
                    SimpleDoc simpleDoc16 = new SimpleDoc(by16, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        DocPrintJob job16 = findPrintService(impresora).createPrintJob();
                        job16.print(simpleDoc16, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
                impresora.add("ZDesigner ZD230-203dpi ZPL");
                String zplDatos12 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO20,45^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO20,65^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO20,85^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO20,105^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO20,200^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO20,125^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,40\n^FO182,200^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos12.isEmpty()) {
                    System.out.println(zplDatos12);
                    byte[] by17 = zplDatos12.getBytes();
                    SimpleDoc simpleDoc17 = new SimpleDoc(by17, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                        DocPrintJob job17 = findPrintService(impresora).createPrintJob();
                        job17.print(simpleDoc17, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA")) {
                impresora.add("ZDesigner GT800 (EPL)");
                String zplDatos13 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO200,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO200,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO200,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO200,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO200,180^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO250,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,30\n^FO370,170^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos13.isEmpty()) {
                    System.out.println(zplDatos13);
                    byte[] by18 = zplDatos13.getBytes();
                    SimpleDoc simpleDoc18 = new SimpleDoc(by18, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                        DocPrintJob job18 = findPrintService(impresora).createPrintJob();
                        job18.print(simpleDoc18, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                if (InetAddress.getLocalHost().getHostName().equals("DESKTOP-4Q0S9DB")) {
                    impresora.add("ZDesigner ZD230-203dpi ZPL");
                    String zplDatos14 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO250,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO250,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO250,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO250,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO250,180^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO250,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,30\n^FO420,170^FD" + nRecepcion.trim() + "^FS\n^XZ";
                    if (!zplDatos14.isEmpty()) {
                        System.out.println(zplDatos14);
                        byte[] by19 = zplDatos14.getBytes();
                        SimpleDoc simpleDoc19 = new SimpleDoc(by19, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                        if (findPrintService(impresora) != null) {
                            System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                            DocPrintJob job19 = findPrintService(impresora).createPrintJob();
                            job19.print(simpleDoc19, (PrintRequestAttributeSet) null);
                        }
                    }
                }
            } else if (Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) {
                impresora.add("Zebra GT800 (203 dpi) - EPL");
                String zplDatos15 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO20,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO20,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO20,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO20,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO20,180^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO25,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,30\n^FO200,170^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos15.isEmpty()) {
                    System.out.println(zplDatos15);
                    byte[] by20 = zplDatos15.getBytes();
                    SimpleDoc simpleDoc20 = new SimpleDoc(by20, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                        DocPrintJob job20 = findPrintService(impresora).createPrintJob();
                        job20.print(simpleDoc20, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE")) {
                byte[] by21 = ("^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO40,20^FD " + nDato1 + "^FS\n^CFA,10\n^CFA,10\n^FO40,40^ADN, 11, 7^FD " + nDato2 + "^FS^FS\n^FO40,200^ADN, 11, 7^FD " + fecha + "^FS\n^FO40,60^ADN, 11, 7^FD " + abreviaturaP + "^FS\n^FO40,75^ADN, 11, 7^FD " + tipoMuestra + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO40,100^BC^FD" + nRecepcion + "^FS\n^CF0,30\n^FO190,185^FD" + nRecepcion + "^FS\n^XZ").getBytes();
                SimpleDoc simpleDoc21 = new SimpleDoc(by21, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job21 = printService.createPrintJob();
                job21.print(simpleDoc21, (PrintRequestAttributeSet) null);
            } else if (Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS")) {
                impresora.add("BARCODE");
                String zplDatos16 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO250,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO250,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO250,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO250,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO250,180^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO250,105^BCN,62,N^FD" + nRecepcion.trim() + "^FS\n^CF0,30\n^FO420,170^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos16.isEmpty()) {
                    System.out.println(zplDatos16);
                    byte[] by22 = zplDatos16.getBytes();
                    SimpleDoc simpleDoc22 = new SimpleDoc(by22, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                        DocPrintJob job22 = findPrintService(impresora).createPrintJob();
                        job22.print(simpleDoc22, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL")) {
                impresora.add("ZDesigner ZD230-203dpi ZPL");
                String zplDatos17 = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,22\n^FO105,20^FD" + nDato1.trim() + "^FS\n^CF0,20\n^FO105,45^FD" + nDato2.trim() + "^FS\n^CF0,20\n^FO105,65^FD" + abreviaturaP.trim() + "^FS\n^CF0,20\n^FO105,85^FD" + tipoMuestra.trim() + "^FS\n^CF0,20\n^FO275,160^AN, 20, 15^FD" + fecha.trim() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO105,105^BCN,42,N^FD" + nRecepcion.trim() + "^FS\n^CF0,30\n^FO105,150^FD" + nRecepcion.trim() + "^FS\n^XZ";
                if (!zplDatos17.isEmpty()) {
                    System.out.println(zplDatos17);
                    byte[] by23 = zplDatos17.getBytes();
                    SimpleDoc simpleDoc23 = new SimpleDoc(by23, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    if (findPrintService(impresora) != null) {
                        System.out.println("Encontro Impresora: " + impresora.get(0).toString());
                        DocPrintJob job23 = findPrintService(impresora).createPrintJob();
                        job23.print(simpleDoc23, (PrintRequestAttributeSet) null);
                    }
                }
            } else if (Principal.informacionIps.getIdentificacion().equals("901613732")) {
                impresora.add(settingsDTO.getNamePrinter());
                String zplDatos18 = settingsDTO.getCodeZPL().replace(":nDato1", nDato1).replace(":nDato2", nDato2).replace(":fecha", fecha).replace(":abreviaturaP", abreviaturaP).replace(":tipoMuestra", tipoMuestra).replace(":nRecepcion", nRecepcion);
                System.out.println("ZPL datos -> " + zplDatos18);
                byte[] by24 = zplDatos18.getBytes();
                SimpleDoc simpleDoc24 = new SimpleDoc(by24, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                DocPrintJob job24 = findPrintService(impresora).createPrintJob();
                job24.print(simpleDoc24, (PrintRequestAttributeSet) null);
            }
        } catch (UnknownHostException ex3) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        } catch (PrintException e2) {
        }
    }

    public void mImpirmir_CodBarraZebra(List<StikerProjection> lista) throws PrintException {
        List<String> impresora = new ArrayList<>();
        PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
            impresora.add("ZDesigner ZD230-203dpi ZPL");
            lista.forEach(e -> {
                try {
                    String zplDatos = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO60,20^FD" + e.getPacienteNombre() + "^FS\n^FO60,40^AN, 15, 15^FD" + e.getPacienteInformacion() + "^FS\n^FO60,60^AN, 15, 15^FD" + e.getExamen() + "^FS\n^FO60,75^AN, 15, 15^FD" + e.getTipoMuestra() + "^FS\n^FO60,175^AN, 20, 13^FD" + e.getFechaRecepcion() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO60,100^BCN,62,N^FD" + e.getIdRecepcion() + "^FS\n^CF0,30\n^FO250,170^FD" + e.getIdRecepcion() + "^FS\n^XZ";
                    if (!zplDatos.isEmpty()) {
                        System.out.println(zplDatos);
                        byte[] by = zplDatos.getBytes();
                        SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                        if (findPrintService(impresora) != null) {
                            System.out.println("Encontro Impresora: " + ((String) impresora.get(0)).toString());
                            DocPrintJob job = findPrintService(impresora).createPrintJob();
                            job.print(simpleDoc, (PrintRequestAttributeSet) null);
                        }
                    }
                } catch (PrintException e) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            });
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            String zplDatos = "";
            impresora.add("Godex EZ120");
            for (int i = 0; i < lista.size(); i++) {
                if (Principal.sedeUsuarioSeleccionadaDTO.getNombre().equals("SEDE PRINCIPAL")) {
                    zplDatos = "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO40,20^FD" + lista.get(i).getPacienteNombre() + "^FS\n^FO40,40^AN, 11, 7^FD" + lista.get(i).getPacienteInformacion() + "^FS\n^FO40,60^AN, 11, 7^FD" + lista.get(i).getExamen() + "^FS\n^FO40,75^AN, 11, 7^FD" + lista.get(i).getTipoMuestra() + "^FS\n^FO40,200^AN, 11, 7^FD" + lista.get(i).getFechaRecepcion() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,60,350\n^FO40,100^BCN,32,N^FD" + lista.get(i).getIdRecepcion() + "^FS\n^CF0,30\n^FO190,185^FD" + lista.get(i).getIdRecepcion() + "^FS\n^XZ";
                    byte[] by = zplDatos.getBytes();
                    System.out.println(zplDatos);
                    SimpleDoc simpleDoc = new SimpleDoc(by, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                    DocPrintJob job = printService.createPrintJob();
                    job.print(simpleDoc, (PrintRequestAttributeSet) null);
                } else {
                    if ((i + 1) % 2 != 0) {
                        zplDatos = zplDatos + "^XA\n^FX Second section with recipient address and permit information.\n^CF0,20\n^FO30,20^FD" + lista.get(i).getPacienteNombre() + "^FS\n^FO30,40^FD" + lista.get(i).getPacienteInformacion() + "^FS\n^FO30,57^FD" + lista.get(i).getExamen() + "^FS\n^FO30,73^FD" + lista.get(i).getTipoMuestra() + "^FS\n^FO30,130^FD" + lista.get(i).getFechaRecepcion() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO30,90^BCN,32,N^FD" + lista.get(i).getIdRecepcion() + "^FS\n^CF0,20\n^FO220,125^FD" + lista.get(i).getIdRecepcion() + "^FS\n";
                    } else {
                        zplDatos = zplDatos + "^FO480,20^FD" + lista.get(i).getPacienteNombre() + "^FS\n^FO480,40^FD" + lista.get(i).getPacienteInformacion() + "^FS\n^FO480,57^FD" + lista.get(i).getExamen() + "^FS\n^FO480,73^FD" + lista.get(i).getTipoMuestra() + "^FS\n^FO480,130^FD" + lista.get(i).getFechaRecepcion() + "^FS\n^CFA,10\n^FX Third section with barcode.\n^BY2,2,50,350\n^FO480,90^BCN,32,N^FD" + lista.get(i).getIdRecepcion() + "^FS\n^CF0,20\n^FO670,130^FD" + lista.get(i).getIdRecepcion() + "^FS\n";
                    }
                    if (!zplDatos.isEmpty() && (i == lista.size() - 1 || (i + 1) % 2 == 0)) {
                        String zplDatos2 = zplDatos + "^XZ";
                        System.out.println(zplDatos2);
                        byte[] by2 = zplDatos2.getBytes();
                        SimpleDoc simpleDoc2 = new SimpleDoc(by2, DocFlavor.BYTE_ARRAY.AUTOSENSE, (DocAttributeSet) null);
                        DocPrintJob job2 = findPrintService(impresora).createPrintJob();
                        job2.print(simpleDoc2, (PrintRequestAttributeSet) null);
                        zplDatos = "";
                    }
                }
            }
        }
    }

    public static List<String> getPrinterServiceNameList() {
        PrintService[] services = PrinterJob.lookupPrintServices();
        List<String> list = new ArrayList<>();
        for (PrintService printService : services) {
            list.add(printService.getName());
        }
        return list;
    }

    public static PrintService findPrintService(List<String> printerNames) {
        if (printerNames == null || printerNames.isEmpty()) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "La lista de nombres de impresoras está vacía o es nula.");
            return null;
        }
        PrintService[] services = PrinterJob.lookupPrintServices();
        for (String printerName : printerNames) {
            if (printerName == null || printerName.isEmpty()) {
                Logger.getLogger(Metodos.class.getName()).log(Level.WARNING, "Nombre de impresora vacío o nulo en la lista. Saltando...");
            } else {
                for (PrintService service : services) {
                    if (service.getName().equalsIgnoreCase(printerName)) {
                        Logger.getLogger(Metodos.class.getName()).log(Level.INFO, "Impresora encontrada: " + service.getName());
                        return service;
                    }
                }
            }
        }
        Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "No se encontró ninguna impresora coincidente.");
        return null;
    }

    public long mGenerar_NFacturaDian(Long xId_Ips) {
        long xnumero = 0;
        try {
            String xsql = "SELECT  MAX(`f_factura_evento`.`No_FacturaEvento_M`)+1 AS nFactura FROM  `f_factura_evento` INNER JOIN  `f_liquidacion`   ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)   INNER JOIN  `f_empresacontxconvenio`    ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) WHERE (`f_empresacontxconvenio`.`Id_GIps` ='" + xId_Ips + "') GROUP BY `f_empresacontxconvenio`.`Id_GIps` ";
            ResultSet xrs = this.consultas.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                xnumero = xrs.getLong(1);
                ConsultasMySQL xct = new ConsultasMySQL();
                CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL Actualizar_NFactura_Dian(?,?)}");
                cs.setLong("nFactura", xnumero);
                cs.setLong("Id_Ips", xId_Ips.longValue());
                cs.execute();
                cs.close();
                xct.cerrarConexionBd();
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnumero;
    }

    public String mConsulta_PrefijoDian(String xId_Ips) {
        String xnumero = "";
        try {
            ResultSet xrs = this.consultas.traerRs("SELECT  `Prefijo`  FROM `g_ips` WHERE (`Id` ='" + xId_Ips + "')");
            if (xrs.next()) {
                xrs.first();
                xnumero = xrs.getString(1);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnumero;
    }

    public String OptionButtonSelected(ButtonGroup buttonGroup1) {
        String xValor = "0";
        Enumeration e = buttonGroup1.getElements();
        while (e.hasMoreElements()) {
            JRadioButton r = (JRadioButton) e.nextElement();
            if (r.isSelected()) {
                xValor = r.getName();
            }
        }
        return xValor;
    }

    public MaskFormatter mDevolver_Mascara_Hora() {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##:##:##");
        } catch (ParseException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return formatter;
    }

    public double mSemanaGestacion(String xFUM) {
        double xValor = 0.0d;
        String sql = "SELECT ROUND(DATEDIFF(NOW(),'" + xFUM + "')/7,1) AS SGestacion";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDouble("SGestacion");
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    public boolean mVerificaFecha_PeriodoPresupuesto(String xFecha) {
        boolean xExiste = false;
        String sql = "SELECT `Nbre`, `FechaI`, `FechaF`  FROM `pp_periodo` WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "' AND '" + xFecha + "'>=FechaI AND '" + xFecha + "'<=FechaF";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xExiste = true;
            } else {
                JOptionPane.showMessageDialog(Principal.xclasePresupuesto.frmPrincipal, "La Fecha " + xFecha + " no corresponde a una fecha del periodo " + Principal.xclasePresupuesto.frmPrincipal.JLBPeridoC.getText(), "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    public String mDevuelveAnnoPpt() {
        String xanno = "";
        String sql = "SELECT  date_format(`FechaI`,'%Y') anno, `FechaF`  FROM `pp_periodo` WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xanno = xrs.getString("anno");
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xanno;
    }

    public String mConvertirNumeroLetras(String xvalor) {
        new convertirNumerosLetras();
        return convertirNumerosLetras.convertirEurosEnLetras(xvalor, 0).toUpperCase();
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00ea: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:28:0x00ea */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00ef: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:30:0x00ef */
    public String mRutaSoporte(String xnombre) {
        String xRuta = "";
        try {
            try {
                ConsultasMySQL consultas1 = new ConsultasMySQL();
                String sql = "SELECT `Ubiacion`, UbicacionLinux FROM `p_s_rutas_soportes` WHERE (`Estado` =1 AND `NFormulario` ='" + xnombre + "')";
                ResultSet xrs = consultas1.traerRs(sql);
                Throwable th = null;
                if (xrs.next()) {
                    if (System.getProperties().getProperty("file.separator").equals("\\")) {
                        xRuta = xrs.getString(1);
                    } else if (xrs.getString(2).contains("%HOME%")) {
                        xRuta = xrs.getString(2).replaceAll("%HOME%", System.getProperty("user.home"));
                    } else if (xrs.getString(2).contains("%PWD%")) {
                        xRuta = xrs.getString(2).replaceAll("%PWD%", getSO());
                    } else {
                        xRuta = xrs.getString(2);
                    }
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
                consultas1.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (xRuta == null) {
            xRuta = "";
        }
        return xRuta;
    }

    public void mExportar_Datos_Tabla_Titulo_Formato(JTable xtabla, String xruta, String xTituloReporte) {
        try {
            this.workbook = new SXSSFWorkbook();
            inicializarFuentesyEstilos();
            Sheet sheet = this.workbook.createSheet("Detalle");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, xtabla.getColumnCount() - 1));
            Row fila = sheet.createRow(0);
            fila.setHeight((short) 600);
            Cell titlecell = fila.createCell(0);
            titlecell.setCellValue(xTituloReporte);
            titlecell.setCellStyle(this.titleStyle);
            CellStyle cellStyle = this.workbook.createCellStyle();
            for (int i = -1; i < xtabla.getRowCount(); i++) {
                Row fila2 = sheet.createRow(i + 2);
                for (int j = 0; j < xtabla.getColumnCount(); j++) {
                    if (i == -1) {
                        Cell contentCell = fila2.createCell(j);
                        contentCell.setCellStyle(this.headerStyle);
                        contentCell.setCellValue(String.valueOf(xtabla.getColumnName(j)));
                        int preferredWidth = xtabla.getColumnModel().getColumn(j).getPreferredWidth() * 50;
                        sheet.setColumnWidth(j, Math.min(preferredWidth, 65280));
                    } else {
                        Cell contentCell2 = fila2.createCell(j);
                        if (xtabla.getValueAt(i, j) == null) {
                            contentCell2.setCellValue("");
                            contentCell2.setCellStyle(this.bodyRowStyle);
                        } else {
                            switch (xtabla.getColumnClass(j).toString()) {
                                case "class java.lang.Long":
                                case "class java.lang.Integer":
                                    contentCell2.setCellValue(Long.valueOf(xtabla.getValueAt(i, j).toString()).longValue());
                                    contentCell2.setCellStyle(this.bodyRowStyle);
                                    break;
                                case "class java.lang.Double":
                                    this.numericStyle.setDataFormat(this.workbook.createDataFormat().getFormat("#,##0.00"));
                                    contentCell2.setCellValue(Double.valueOf(xtabla.getValueAt(i, j).toString()).doubleValue());
                                    contentCell2.setCellStyle(this.numericStyle);
                                    break;
                                case "class java.util.Date":
                                    CreationHelper createHelper = this.workbook.getCreationHelper();
                                    cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));
                                    contentCell2.setCellValue((Date) xtabla.getValueAt(i, j));
                                    contentCell2.setCellStyle(cellStyle);
                                    break;
                                default:
                                    contentCell2.setCellValue(xtabla.getValueAt(i, j).toString().trim());
                                    contentCell2.setCellStyle(this.bodyRowStyle);
                                    break;
                            }
                        }
                    }
                }
            }
            FileOutputStream fileOut = new FileOutputStream(xruta + ".xlsx");
            this.workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            mostrarPdf(xruta + ".xlsx");
        } catch (Exception e) {
            System.out.println("" + e);
            JOptionPane.showMessageDialog((Component) null, "Error al exportar : " + e);
        }
    }

    public Font createFont(short fontColor, short fontHeight, boolean fontBold) {
        Font font = this.workbook.createFont();
        font.setBold(fontBold);
        font.setColor(fontColor);
        font.setFontName("Arial");
        font.setFontHeightInPoints(fontHeight);
        return font;
    }

    public CellStyle createStyle(Font font, short cellAlign, short cellColor, short cellBorder, short cellBorderColor) {
        CellStyle style = this.workbook.createCellStyle();
        style.setFont(font);
        style.setAlignment(cellAlign);
        style.setFillForegroundColor(cellColor);
        style.setFillPattern((short) 1);
        style.setBorderTop(cellBorder);
        style.setBorderLeft(cellBorder);
        style.setBorderRight(cellBorder);
        style.setBorderBottom(cellBorder);
        style.setTopBorderColor(cellBorderColor);
        style.setLeftBorderColor(cellBorderColor);
        style.setRightBorderColor(cellBorderColor);
        style.setBottomBorderColor(cellBorderColor);
        style.setWrapText(true);
        return style;
    }

    public void inicializarFuentesyEstilos() {
        this.titleFont = createFont((short) 10, (short) 12, true);
        this.headerFont = createFont((short) 8, (short) 12, true);
        this.contentFont = createFont((short) 8, (short) 10, false);
        this.numericFont = createFont((short) 8, (short) 10, false);
        this.titleStyle = createStyle(this.titleFont, (short) 1, (short) 22, (short) 0, (short) 8);
        this.headerStyle = createStyle(this.headerFont, (short) 2, (short) 22, (short) 1, (short) 8);
        this.bodyRowStyle = createStyle(this.contentFont, (short) 0, (short) 9, (short) 1, (short) 63);
        this.numericStyle = createStyle(this.contentFont, (short) 0, (short) 9, (short) 1, (short) 63);
    }

    public void mExportar_Datos_Formato_Consulta(String xSql, String xruta, String xTituloReporte) throws FileNotFoundException {
        try {
            ResultSet rs = this.consultas.traerRs(xSql);
            ResultSetMetaData Datos = rs.getMetaData();
            this.workbook = new SXSSFWorkbook();
            inicializarFuentesyEstilos();
            Sheet sheet = this.workbook.createSheet("Detalle");
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, Datos.getColumnCount() - 1));
            Row fila = sheet.createRow(0);
            fila.setHeight((short) 600);
            Cell titlecell = fila.createCell(0);
            titlecell.setCellValue(xTituloReporte);
            titlecell.setCellStyle(this.titleStyle);
            Row fila2 = sheet.createRow(1);
            for (int i = 0; i < Datos.getColumnCount(); i++) {
                Cell contentCell = fila2.createCell(i);
                contentCell.setCellValue(Datos.getColumnName(i + 1));
                contentCell.setCellStyle(this.headerStyle);
                if (Datos.getColumnDisplaySize(i + 1) <= 300) {
                    sheet.setColumnWidth(i, (Datos.getColumnName(i + 1).length() * 300) + (Datos.getColumnDisplaySize(i + 1) * 100));
                } else {
                    sheet.setColumnWidth(i, (Datos.getColumnName(i + 1).length() * 300) + 20000);
                }
            }
            if (rs.next()) {
                rs.beforeFirst();
                int n = 0;
                while (rs.next()) {
                    Row fila3 = sheet.createRow(n + 2);
                    for (int i2 = 0; i2 < Datos.getColumnCount(); i2++) {
                        Cell contentCell2 = fila3.createCell(i2);
                        if (rs.getString(i2 + 1) == null) {
                            contentCell2.setCellValue("");
                        } else {
                            contentCell2.setCellValue(rs.getString(i2 + 1));
                        }
                        contentCell2.setCellStyle(this.bodyRowStyle);
                    }
                    n++;
                }
            }
            FileOutputStream fileOut = new FileOutputStream(xruta + ".xlsx");
            this.workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            mostrarPdf(xruta + ".xlsx");
        } catch (Exception e) {
            JOptionPane.showMessageDialog((Component) null, "Error al exportar la consulta: " + e);
        }
    }

    public void mExportar_Datos_Tabla_Titulo_Formato_Unificada_Modelos(JTable[] xtabla, String xruta, String[] xTituloReporte) {
        try {
            this.workbook = new SXSSFWorkbook();
            inicializarFuentesyEstilos();
            Sheet sheet = this.workbook.createSheet("Detalle");
            int pos = 0;
            for (int x = 0; x < xtabla.length; x++) {
                sheet.addMergedRegion(new CellRangeAddress(pos, pos, 0, xtabla[x].getColumnCount() - 1));
                Row fila = sheet.createRow((short) pos);
                fila.setHeight((short) 600);
                Cell titlecell = fila.createCell(0);
                titlecell.setCellValue(xTituloReporte[x]);
                titlecell.setCellStyle(this.titleStyle);
                for (int i = -1; i < xtabla[x].getRowCount(); i++) {
                    Row fila2 = sheet.createRow(pos + 1);
                    for (int j = 0; j < xtabla[x].getColumnCount(); j++) {
                        if (i == -1) {
                            Cell contentCell = fila2.createCell(j);
                            contentCell.setCellStyle(this.headerStyle);
                            contentCell.setCellValue(String.valueOf(xtabla[x].getColumnName(j)));
                            sheet.setColumnWidth(j, xtabla[x].getColumnModel().getColumn(j).getPreferredWidth() * 50);
                        } else {
                            Cell contentCell2 = fila2.createCell(j);
                            if (xtabla[x].getValueAt(i, j) == null) {
                                contentCell2.setCellValue("");
                                contentCell2.setCellStyle(this.bodyRowStyle);
                            } else if (xtabla[x].getColumnClass(j).toString().equals("class java.lang.Long") || xtabla[x].getColumnClass(j).toString().equals("class java.lang.Integer")) {
                                contentCell2.setCellValue(Integer.valueOf(xtabla[x].getValueAt(i, j).toString()).intValue());
                                contentCell2.setCellStyle(this.bodyRowStyle);
                            } else if (xtabla[x].getColumnClass(j).toString().equals("class java.lang.Double")) {
                                this.numericStyle.setDataFormat(this.workbook.createDataFormat().getFormat("#,##0.00"));
                                contentCell2.setCellValue(Double.valueOf(xtabla[x].getValueAt(i, j).toString()).doubleValue());
                                contentCell2.setCellStyle(this.numericStyle);
                            } else {
                                contentCell2.setCellValue(xtabla[x].getValueAt(i, j).toString().trim());
                                contentCell2.setCellStyle(this.bodyRowStyle);
                            }
                        }
                    }
                    pos++;
                }
                pos++;
            }
            FileOutputStream fileOut = new FileOutputStream(xruta + ".xlsx");
            this.workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            mostrarPdf(xruta + ".xlsx");
        } catch (Exception e) {
            JOptionPane.showMessageDialog((Component) null, "Error al exportar : " + e);
        }
    }

    public MaskFormatter mDevolver_Mascara(String xsql) {
        MaskFormatter formatter = null;
        try {
            ResultSet xrs = this.consultas.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                try {
                    formatter = new MaskFormatter(xrs.getString(1));
                } catch (ParseException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else {
                try {
                    formatter = new MaskFormatter("##");
                } catch (ParseException ex2) {
                    Logger.getLogger(JIFFActividadEconomica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex3) {
            Logger.getLogger(JIFFActividadEconomica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        }
        return formatter;
    }

    public boolean mExisteArchivo(String xruta) {
        boolean existe = false;
        File fichero = new File(xruta);
        if (fichero.exists()) {
            existe = true;
        }
        System.out.println("> Existe Archivo " + existe + ": " + xruta);
        return existe;
    }

    public long getObtenerMesAnterior() {
        Date fechant = null;
        ResultSet xrs = this.consultas.traerRs("SELECT DATE_ADD(NOW(), INTERVAL -1 MONTH) as FechAnt");
        try {
            if (xrs.next()) {
                xrs.first();
                fechant = xrs.getDate(1);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return fechant.getTime();
    }

    public void actualizarBlob(Object[] parametros, String Sql) {
        try {
            PreparedStatement pSt = this.consultas.establecerConexionBd().prepareStatement(Sql);
            for (int i = 0; i < parametros.length; i++) {
                if (parametros[i].toString().endsWith("PNG") || parametros[i].toString().endsWith("png") || parametros[i].toString().endsWith("JPG") || parametros[i].toString().endsWith("jpg") || parametros[i].toString().endsWith("JPEG") || parametros[i].toString().endsWith("jpeg") || parametros[i].toString().endsWith("BMP") || parametros[i].toString().endsWith("bmp")) {
                    File archivo = new File(parametros[i].toString());
                    int l = (int) archivo.length();
                    InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                    pSt.setBinaryStream(1 + i, is, l);
                } else {
                    pSt.setString(1 + i, parametros[i].toString());
                }
            }
            pSt.execute();
            this.consultas.cerrarConexionBd();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void cargarImagenEnLabel(String ruta, JLabel xjlabel, int xancho, int xalto) {
        ImageIcon firma = new ImageIcon(ruta);
        xjlabel.setIcon(new ImageIcon(firma.getImage().getScaledInstance(xancho, xalto, 1)));
        xjlabel.setHorizontalAlignment(0);
        xjlabel.setVerticalAlignment(0);
        xjlabel.repaint();
    }

    public void cargarImagenEnLabel(Blob imagen, JLabel xjlabel, int xancho, int xalto) {
        if (imagen != null) {
            try {
                ImageIcon firma = new ImageIcon(ImageIO.read(imagen.getBinaryStream()));
                xjlabel.setIcon(new ImageIcon(firma.getImage().getScaledInstance(xancho, xalto, 1)));
                xjlabel.setHorizontalAlignment(0);
                xjlabel.setVerticalAlignment(0);
                xjlabel.repaint();
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public String getEncryptedPassword(String password2) {
        return DigestUtils.sha512Hex(DigestUtils.sha256Hex(password2));
    }

    public void imprimirEscalaAbreviadaDeDesarrollo(String idAtencion, long idUsuario) {
        EscalaAbreviadadeDesarrolloDAO escala = (EscalaAbreviadadeDesarrolloDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("EscalaAbreviadadeDesarrolloDAO");
        List<Object[]> listaEncabezado = escala.listEncabezadoAnteriores(idAtencion, idUsuario);
        for (int x = 0; x < listaEncabezado.size(); x++) {
            List<Object[]> listaResultado = escala.listResuldatdo(((Integer) listaEncabezado.get(x)[0]).intValue());
            int[] puntuacionDirectasYTipicas = obtenerPuntuaciones(listaResultado);
            ANewJDialog visor = new ANewJDialog(null, true, ((Integer) listaEncabezado.get(x)[5]).intValue(), puntuacionDirectasYTipicas);
            visor.GenerarFoto(((Integer) listaEncabezado.get(x)[0]).intValue());
        }
    }

    private int[] obtenerPuntuaciones(List<Object[]> listaResultado) {
        int[] puntuaciones = new int[8];
        for (int x = 0; x < listaResultado.size(); x++) {
            puntuaciones[x] = ((Integer) listaResultado.get(x)[6]).intValue();
            puntuaciones[4 + x] = ((Integer) listaResultado.get(x)[5]).intValue();
        }
        return puntuaciones;
    }

    public int obtenerDiaSemana(String fecha) {
        int dia = 0;
        String sql = "SELECT DAYOFWEEK('" + fecha + "')";
        ResultSet xrs = this.consultas.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                dia = xrs.getInt(1) - 1;
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return dia;
    }

    public boolean esIPSMineros() {
        boolean esMineros = false;
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S")) {
            esMineros = true;
        }
        return esMineros;
    }

    public void AbrirArchivosblob(byte[] Archivo, String NombreArchivo, String Extencion, boolean mostrar) {
        if (Archivo != null) {
            try {
                InputStream pdf = new ByteArrayInputStream(Archivo);
                int peso = pdf.available();
                byte[] pdfb = new byte[peso];
                pdf.read(pdfb, 0, peso);
                OutputStream salida = new FileOutputStream(NombreArchivo + "." + Extencion);
                salida.write(pdfb);
                salida.close();
                if (mostrar) {
                    mostrarPdf(getDirectorioExportacion() + NombreArchivo + "." + Extencion);
                }
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void AbrirArchivosblob(Object Archivo, String NombreArchivo, String Extencion, boolean mostrar) {
        if (Archivo != null) {
            try {
                byte[] pdfbytes = (byte[]) Archivo;
                InputStream pdf = new ByteArrayInputStream(pdfbytes);
                int peso = pdf.available();
                byte[] pdfb = new byte[peso];
                pdf.read(pdfb, 0, peso);
                OutputStream salida = new FileOutputStream(NombreArchivo + "." + Extencion);
                salida.write(pdfb);
                salida.close();
                if (mostrar) {
                    mostrarPdf(getDirectorioExportacion() + NombreArchivo + "." + Extencion);
                }
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mResolucionDian(IResolucionFacturaElectronica resolucionDian) {
        try {
            if (resolucionDian.getConsecutivoFE().longValue() <= resolucionDian.getNumeroF().longValue()) {
                String date = this.formatoAMD1.format(getFechaActual());
                new Date();
                try {
                    Date fecha = this.formatoAMD1.parse(date);
                    if (fecha.after(resolucionDian.getFechaF())) {
                        JOptionPane.showMessageDialog((Component) null, "<html><h1 style=\"text-align:center; color:red;\">Esta resolución ya esta vencida..</h1><table style=\"border: 0px; padding: 5px;\"><tr><td> <h2>DESCRIPCIÓN: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getDescripcion() + "</h2> </td><td> <h2><b>PREFIJO: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getPrefijo() + "</h2> </td></tr><tr><td> <h2><b>FECHA INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getFechaI() + "</h2> </td><td> <h2><b>NÚMERO INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getNumeroI() + "</h2> </td></tr><tr><td> <h2><b>FECHA FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getFechaF() + "</h2> </td><td> <h2><b>NÚMERO FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getNumeroF() + "</h2> </td></tr></table></html>", "VERIFICAR", 2);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog((Component) null, "Error: " + e, "Error", 0);
                }
            } else {
                JOptionPane.showMessageDialog((Component) null, "<html><h1 style=\"text-align:center; color:red;\">El consecutivo sobrepaso el limite de la resolución vigente.</h1><table style=\"border: 0px; padding: 5px;\"><tr><td> <h2>DESCRIPCIÓN: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getDescripcion() + "</h2> </td><td> <h2><b>PREFIJO: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getPrefijo() + "</h2> </td></tr><tr><td> <h2><b>FECHA INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getFechaI() + "</h2> </td><td> <h2><b>NÚMERO INICIAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getNumeroI() + "</h2> </td></tr><tr><td> <h2><b>FECHA FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getFechaF() + "</h2> </td><td> <h2><b>NÚMERO FINAL: </h2> </td><td> <h2 style=\"color:Gray;\">" + resolucionDian.getNumeroF() + "</h2> </td></tr></table></html>", "VERIFICAR", 2);
            }
        } catch (Exception e2) {
        }
    }

    public static void Registros(String mensaje, String Analizador, int tipo) {
        Logger logger = Logger.getLogger("Analizadores");
        logger.setUseParentHandlers(false);
        try {
            DisenoLogEquipos formatter = new DisenoLogEquipos();
            ConsoleHandler handler = new ConsoleHandler();
            handler.setFormatter(formatter);
            FileHandler fh = new FileHandler(Analizador + ".log", true);
            logger.addHandler(fh);
            fh.setFormatter(formatter);
            if (tipo == 0) {
                logger.info(mensaje);
            } else if (tipo == 1) {
                logger.warning(mensaje);
            }
            fh.close();
        } catch (IOException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public void comprimirArchivosDirectorioZip(String directorio, String nombreArchivoZip) throws IOException {
        ZipOutputStream os = new ZipOutputStream(new FileOutputStream(nombreArchivoZip));
        Throwable th = null;
        try {
            try {
                File carpeta = new File(directorio);
                File[] archivos = carpeta.listFiles();
                if (archivos != null || archivos.length != 0) {
                    for (File archivo : archivos) {
                        ZipEntry entrada = new ZipEntry(archivo.getName());
                        os.putNextEntry(entrada);
                        FileInputStream fis = new FileInputStream(archivo.getPath());
                        Throwable th2 = null;
                        try {
                            try {
                                byte[] buffer = new byte[1024];
                                while (true) {
                                    int leido = fis.read(buffer);
                                    if (0 >= leido) {
                                        break;
                                    } else {
                                        os.write(buffer, 0, leido);
                                    }
                                }
                                if (fis != null) {
                                    if (0 != 0) {
                                        try {
                                            fis.close();
                                        } catch (Throwable th3) {
                                            th2.addSuppressed(th3);
                                        }
                                    } else {
                                        fis.close();
                                    }
                                }
                                os.closeEntry();
                            } catch (Throwable th4) {
                                th2 = th4;
                                throw th4;
                            }
                        } catch (Throwable th5) {
                            if (fis != null) {
                                if (th2 != null) {
                                    try {
                                        fis.close();
                                    } catch (Throwable th6) {
                                        th2.addSuppressed(th6);
                                    }
                                } else {
                                    fis.close();
                                }
                            }
                            throw th5;
                        }
                    }
                }
                if (os != null) {
                    if (0 != 0) {
                        try {
                            os.close();
                            return;
                        } catch (Throwable th7) {
                            th.addSuppressed(th7);
                            return;
                        }
                    }
                    os.close();
                }
            } catch (Throwable th8) {
                if (os != null) {
                    if (th != null) {
                        try {
                            os.close();
                        } catch (Throwable th9) {
                            th.addSuppressed(th9);
                        }
                    } else {
                        os.close();
                    }
                }
                throw th8;
            }
        } catch (Throwable th10) {
            th = th10;
            throw th10;
        }
    }

    public String copiarArchivos(String RutaArchivoOrigen, String RutaCarpaetaDestino, String Renombrar) {
        String rutaFinal = "";
        try {
            if (mExisteArchivo(RutaArchivoOrigen) && mExisteArchivo(RutaCarpaetaDestino)) {
                File f1 = new File(RutaArchivoOrigen);
                rutaFinal = Files.copy(Paths.get(f1.getAbsolutePath(), new String[0]), new File(RutaCarpaetaDestino + getBarra() + f1.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING).toString();
                if (!Renombrar.isEmpty()) {
                    new File(RutaCarpaetaDestino, f1.getName()).renameTo(new File(RutaCarpaetaDestino, Renombrar));
                    rutaFinal = new File(RutaCarpaetaDestino, Renombrar).toString();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return rutaFinal;
    }

    public String FileCopy(String RutaArchivoOrigen, String RutaCarpaetaDestino, String Renombrar) {
        FileChannel destChannel;
        String rutaFinal = "";
        if (mExisteArchivo(RutaArchivoOrigen) && mExisteArchivo(RutaCarpaetaDestino)) {
            try {
                File source = new File(RutaArchivoOrigen);
                FileChannel sourceChannel = new FileInputStream(RutaArchivoOrigen).getChannel();
                if (Renombrar.isEmpty()) {
                    destChannel = new FileOutputStream(RutaCarpaetaDestino + getBarra() + source.getName()).getChannel();
                    rutaFinal = RutaCarpaetaDestino + getBarra() + source.getName();
                } else {
                    destChannel = new FileOutputStream(RutaCarpaetaDestino + getBarra() + Renombrar).getChannel();
                    rutaFinal = RutaCarpaetaDestino + getBarra() + Renombrar;
                }
                destChannel.transferFrom(sourceChannel, 0L, sourceChannel.size());
                sourceChannel.close();
                destChannel.close();
            } catch (IOException e) {
                System.err.println(e);
                rutaFinal = "";
            }
        }
        return rutaFinal;
    }

    public Boolean mValidarSoloNumeros(KeyEvent evt, Component thiss, String texto, Integer digitos) {
        Boolean valido = true;
        if (evt.getKeyCode() != 8 && evt.getKeyCode() != 127 && evt.getKeyCode() != 10) {
            if (String.valueOf(evt.getKeyChar()).equals(" ") || String.valueOf(evt.getKeyChar()).toLowerCase().equals("f") || String.valueOf(evt.getKeyChar()).toLowerCase().equals("d") || texto.length() >= digitos.intValue()) {
                evt.consume();
                valido = false;
            } else if (!IsInteger(evt.getKeyChar() + "")) {
                evt.consume();
                valido = false;
                if (evt.getKeyCode() != 0) {
                    JOptionPane.showMessageDialog(thiss, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
        }
        return valido;
    }

    public Boolean mValidarSoloNumerosDouble(KeyEvent evt, Component thiss, String texto, Integer digitos) {
        Boolean valido = true;
        if (evt.getKeyCode() != 8 && evt.getKeyCode() != 127 && evt.getKeyCode() != 10) {
            if (String.valueOf(evt.getKeyChar()).equals(",")) {
                evt.setKeyChar('.');
            }
            if (String.valueOf(evt.getKeyChar()).equals(" ") || String.valueOf(evt.getKeyChar()).toLowerCase().equals("f") || String.valueOf(evt.getKeyChar()).toLowerCase().equals("d") || texto.length() >= digitos.intValue()) {
                evt.consume();
                valido = false;
            } else if (!IsDoouble(texto + evt.getKeyChar())) {
                evt.consume();
                valido = false;
                if (evt.getKeyCode() != 0) {
                    JOptionPane.showMessageDialog(thiss, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
        }
        return valido;
    }

    public static boolean IsInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean IsDoouble(String text) {
        Double.valueOf(0.0d);
        try {
            Double.valueOf(Double.parseDouble(text));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void cambiarEstadoValidadoItemHC(String nombreItem, Integer formaAplicacion, Boolean estado) {
        if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getFormaHistoria().intValue() == 1) {
                Principal.clasehistoriace.historia_Clinica_v2.consultarEstadoItems(nombreItem, formaAplicacion, estado);
            }
        } else if (Principal.clasehistoriace.historia_Clinica_v4 != null && clasesHistoriaCE.informacionAgendaMedicaDTO.getFormaHistoria().intValue() == 1) {
            Principal.clasehistoriace.historia_Clinica_v4.consultarEstadoItems(nombreItem, formaAplicacion, estado);
        }
    }

    public String generarNombreSoportesDigitalizados(String nombre, String separador) {
        String nombreCarpeta = "";
        String concatenado = "";
        int CountComilla = 0;
        for (int i = 0; i < nombre.length(); i++) {
            if (CountComilla == 1 && nombre.charAt(i) != '\'') {
                concatenado = concatenado + nombre.charAt(i);
            } else {
                switch (nombre.charAt(i)) {
                    case '#':
                        nombreCarpeta = nombreCarpeta + "[No Factura]" + separador;
                        break;
                    case '$':
                        nombreCarpeta = nombreCarpeta + "[DDMMAA]" + separador;
                        break;
                    case '%':
                    case '(':
                    case ')':
                    case '*':
                    case '+':
                    case ',':
                    case '-':
                    case '.':
                    case '/':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                    case 'B':
                    case 'D':
                    case 'F':
                    case 'G':
                    case 'H':
                    case 'J':
                    case 'K':
                    case 'L':
                    case 'M':
                    case 'O':
                    case 'Q':
                    case 'S':
                    case 'T':
                    case 'U':
                    case 'W':
                    case 'Y':
                    default:
                        nombreCarpeta = "ERROR" + separador;
                        break;
                    case '&':
                        nombreCarpeta = nombreCarpeta + "[DDMMAAHHMMSS]" + separador;
                        break;
                    case '\'':
                        CountComilla++;
                        if (CountComilla == 2) {
                            nombreCarpeta = nombreCarpeta + concatenado.replace("'", "") + separador;
                            concatenado = "";
                            CountComilla = 0;
                        }
                        break;
                    case 'A':
                        nombreCarpeta = nombreCarpeta + "[Atencion]" + separador;
                        break;
                    case 'C':
                        nombreCarpeta = nombreCarpeta + "[No Contrato]" + separador;
                        break;
                    case 'E':
                        nombreCarpeta = nombreCarpeta + "[Fecha Evento ECAT]" + separador;
                        break;
                    case 'I':
                        nombreCarpeta = nombreCarpeta + "[Ingreso]" + separador;
                        break;
                    case 'N':
                        nombreCarpeta = nombreCarpeta + "[NIT]" + separador;
                        break;
                    case 'P':
                        nombreCarpeta = nombreCarpeta + "[Prefijo]" + separador;
                        break;
                    case 'R':
                        nombreCarpeta = nombreCarpeta + "[Radicacion]" + separador;
                        break;
                    case 'V':
                        nombreCarpeta = nombreCarpeta + "[ValorFactura]" + separador;
                        break;
                    case 'X':
                        nombreCarpeta = nombreCarpeta + "[NIT IPS Genera]" + separador;
                        break;
                    case 'Z':
                        nombreCarpeta = nombreCarpeta + "[Prefijo+NoFactura]" + separador;
                        break;
                }
            }
        }
        if (!nombreCarpeta.isEmpty() && !separador.isEmpty()) {
            nombreCarpeta = nombreCarpeta.substring(0, nombreCarpeta.length() - 1);
        }
        return nombreCarpeta;
    }

    public String InsertarPrefijoSoportesDigitalizados(int pos, String texto) {
        String prefijo;
        switch (pos) {
            case 0:
                prefijo = "#";
                break;
            case 1:
                prefijo = "$";
                break;
            case 2:
                prefijo = "&";
                break;
            case 3:
                prefijo = "N";
                break;
            case 4:
                prefijo = "X";
                break;
            case 5:
                prefijo = "P";
                break;
            case 6:
                prefijo = "Z";
                break;
            case 7:
                prefijo = "C";
                break;
            case 8:
                prefijo = "R";
                break;
            case 9:
                prefijo = "I";
                break;
            case 10:
                prefijo = "A";
                break;
            case 11:
                prefijo = "V";
                break;
            case 12:
                prefijo = "E";
                break;
            case 13:
                prefijo = "'" + texto + "'";
                break;
            default:
                prefijo = "";
                break;
        }
        return prefijo;
    }

    public String unirPDF(List<String> listaRutas, String directorio, String nombre) throws IOException {
        String rutaFinal = directorio + nombre + ".pdf";
        PDFMergerUtility pdfmerger = new PDFMergerUtility();
        for (int i = 0; i < listaRutas.size(); i++) {
            pdfmerger.addSource(listaRutas.get(i));
        }
        pdfmerger.setDestinationFileName(rutaFinal);
        pdfmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        return rutaFinal;
    }

    public void unirPdf_Generico(String carpeta, String nombreFinal, List<InputStream> lista) {
        try {
            PDFMergerUtility pdfmerger = new PDFMergerUtility();
            pdfmerger.setDestinationFileName(carpeta + getBarra() + nombreFinal + ".pdf");
            pdfmerger.addSources(lista);
            pdfmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void unirPdf_Generico_Colcan(String carpeta, String nombreFinal, List<InputStream> lista) {
        try {
            PDFMergerUtility pdfmerger = new PDFMergerUtility();
            pdfmerger.setDestinationFileName(carpeta + getBarra() + nombreFinal);
            pdfmerger.addSources(lista);
            pdfmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String Base64Decode(String base64, String directorio, String nombre, String extension) {
        String ruta = directorio + nombre + "." + extension;
        File file = new File(directorio + nombre + "." + extension);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            Throwable th = null;
            try {
                try {
                    byte[] decoder = Base64.getDecoder().decode(base64);
                    fos.write(decoder);
                    if (fos != null) {
                        if (0 != 0) {
                            try {
                                fos.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            fos.close();
                        }
                    }
                    return ruta;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public StickerSettingsDTO getInfoSticker() {
        System.out.println("entro a getInfoSticker");
        StickerSettingsDTO settingsDTO = StickerSettingsDTO.builder().build();
        System.out.println("aplica -> " + Principal.informacionIps.getAplicaMicroservicios());
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
        }
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            System.out.println("aplica microservicios info sticker");
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                RecursosMicroserviciosDomain microserviciosDomain = getParametrosEncriptados("24", "Recepcion");
                System.out.println("target -> " + microserviciosDomain.getUrlRecurso().concat("/" + localHost.getHostName()).concat("/RecepcionAuto"));
                Response response = getResteasyClient().target(microserviciosDomain.getUrlRecurso().concat("/" + localHost.getHostName()).concat("/RecepcionAuto")).request().get();
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    new CustomPresenter();
                    CustomPresenter presenter = (CustomPresenter) getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                    settingsDTO = (StickerSettingsDTO) getMapper().readValue(getMapper().writeValueAsString(presenter.getData()), StickerSettingsDTO.class);
                    System.out.println("Datos -> " + settingsDTO.getCodeZPL());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return settingsDTO;
    }

    public StickerPrintDto getInfoStickerV2(String nombreFormulario, Map<String, Object> parameters) {
        System.out.println("entro a getInfoSticker");
        StickerPrintDto stickerPrintDto = StickerPrintDto.builder().build();
        System.out.println("aplica -> " + Principal.informacionIps.getAplicaMicroservicios());
        RestTemplate restTemplate = new RestTemplate();
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            System.out.println("aplica microservicios info sticker");
            try {
                InetAddress localHost = InetAddress.getLocalHost();
                RecursosMicroserviciosDomain microserviciosDomain = getParametrosEncriptados("24", "RecepcionV2");
                System.out.println("target -> " + microserviciosDomain.getUrlRecurso().concat("/" + localHost.getHostName()).concat("/" + nombreFormulario));
                CustomPresenter response = (CustomPresenter) restTemplate.postForObject(microserviciosDomain.getUrlRecurso().concat("/" + localHost.getHostName()).concat("/" + nombreFormulario), parameters, CustomPresenter.class, new Object[0]);
                int statusCode = response.getStatusCode().intValue();
                if (statusCode == 200) {
                    stickerPrintDto = (StickerPrintDto) getMapper().readValue(getMapper().writeValueAsString(response.getData()), StickerPrintDto.class);
                    System.out.println(stickerPrintDto.getNamePrinter());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stickerPrintDto;
    }

    public void getInterceptor(Long idIngreso, String accion, String motivo, Boolean alerta) {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            DetalleProcesoDTO detalleProcesoDTO = DetalleProcesoDTO.builder().accion(accion).motivo(motivo).idmodulo(Principal.informacionGeneralPrincipalDTO.getIdModulo()).alerta(alerta).cargo(Principal.usuarioSistemaDTO.getNombreCargoUsuario()).usuario(Principal.usuarioSistemaDTO.getNombreUsuario()).fechaHora(LocalDateTime.now()).build();
            InterceptorManager.interceptarAccion(idIngreso, detalleProcesoDTO);
        }
    }

    public void getGrabarOrdenamientoMedico(OrdenamientoMedico medico) {
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            if (!Principal.informacionIps.getIdentificacion().equals("812005644") || !Principal.informacionIps.getIdentificacion().equals("812004304")) {
                InteceptorOrdenamientoMedico.grabar(medico);
            }
        }
    }

    public List<String> dividirEnLineas(String texto, int maxLength) {
        List<String> lineas = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String[] palabras = texto.split("\\s+");
        for (String palabra : palabras) {
            if (sb.length() + palabra.length() + 1 > maxLength) {
                lineas.add(sb.toString());
                sb.setLength(0);
            }
            if (sb.length() > 0) {
                sb.append(" ");
                lineas.add(sb.toString());
            }
            sb.append(palabra);
        }
        return lineas;
    }

    public String numeroCerosIzquierda(Long numero, int longitudDeseada) {
        String numeroConCeros = String.format("%0" + longitudDeseada + "d", numero);
        return numeroConCeros;
    }

    public static boolean validacionTextfieldXArray(JTextField[][] textFields) {
        HashSet<String> uniqueValues = new HashSet<>();
        boolean hasDuplicates = false;
        for (JTextField[] fieldPair : textFields) {
            String code = fieldPair[0].getText().trim();
            String name = fieldPair[1].getText().trim();
            if (!code.isEmpty() && !name.isEmpty()) {
                String combined = code + " " + name;
                if (uniqueValues.contains(combined)) {
                    fieldPair[0].setText("");
                    fieldPair[1].setText("");
                    hasDuplicates = true;
                } else {
                    uniqueValues.add(combined);
                }
            }
        }
        return !hasDuplicates;
    }

    public Boolean getValidacionCorreo(String email) {
        Boolean estado = true;
        if (email.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
            estado = false;
        }
        return estado;
    }

    public Boolean getValidarFechaHoraNoMayor(String fechaHoraInicio, String fechaHoraFin) {
        System.out.println("" + fechaHoraInicio + " " + fechaHoraFin);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime fechaHora1 = LocalDateTime.parse(fechaHoraInicio, formatter);
        LocalDateTime fechaHora2 = LocalDateTime.parse(fechaHoraFin, formatter);
        if (!fechaHora1.isBefore(fechaHora2)) {
            System.out.println("Fecha y hora 1 no es menor que fecha y hora 2.");
            return true;
        }
        System.out.println("Fecha y hora 1 es menor que fecha y hora 2.");
        return false;
    }

    public void getBuscarTrazabilidad(Long idIngreso, JTextPane jTextPane, JButton button) {
        MetodosGenericos<Long> metodosGenericos = new MetodosGenericos<>();
        RecursosMicroserviciosDomain microserviciosDomain = getParametrosEncriptados("100", "findByIdIngresoTrazabilidad");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(idIngreso);
        Response response = getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                TrazabilidadProcesoDTO trazabilidadProcesoDTO = (TrazabilidadProcesoDTO) getMapper().readValue(getMapper().writeValueAsString(presenter.getData()), new TypeReference<TrazabilidadProcesoDTO>() { // from class: Utilidades.Metodos.3
                });
                if (trazabilidadProcesoDTO.getId() != null) {
                    trazabilidadProcesoDTO.getDetalleProcesos().forEach(e -> {
                        jTextPane.setText(jTextPane.getText().concat("Fecha y Hora: ").concat(e.getFechaHora().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\nACCIÓN: " + e.getAccion() + "\nMOTIVO: " + e.getMotivo() + "\nUSUARIO : " + e.getUsuario() + "\nCARGO:  " + e.getCargo() + "\n\n-------------------------------\n"));
                    });
                    if (trazabilidadProcesoDTO.getId() != null && trazabilidadProcesoDTO.getDetalleProcesos().stream().anyMatch(e2 -> {
                        return "CERRAR PREFACTURA".equals(e2.getAccion()) && e2.getIdmodulo().intValue() == 16;
                    }) && button != null) {
                        button.setEnabled(false);
                    }
                }
                response.close();
                getResteasyClient().close();
            } catch (JsonProcessingException e3) {
                Logger.getLogger(JDHistoricoTrazabilidad.class.getName()).log(Level.SEVERE, (String) null, e3);
            }
        }
    }

    public OrdenamientoMedico getFindByOrdanimientoMedicoIdAtencionIdOrdenHc(Long idAtencion, Long idOrdenHC) {
        RecursosMicroserviciosDomain microserviciosDomain = getParametrosEncriptados("100", "findByOrdenamientoIdAtencionIdOrdenHc");
        OrdenamientoMedico ordenamientoMedico = OrdenamientoMedico.builder().build();
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idAtencion + "/idOrdenHc/" + idOrdenHC;
        System.out.println("fullurlSql --- " + fullUrl);
        Response response = getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                ordenamientoMedico = (OrdenamientoMedico) getMapper().readValue(getMapper().writeValueAsString(presenter.getData()), new TypeReference<OrdenamientoMedico>() { // from class: Utilidades.Metodos.4
                });
            } catch (JsonProcessingException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        return ordenamientoMedico;
    }

    public Boolean getVerificarEstadoCerrado(JTable jTable, int columna) {
        Boolean estado = false;
        int numeroFilas = 0;
        for (int i = 0; i < jTable.getRowCount(); i++) {
            if (Boolean.parseBoolean(jTable.getValueAt(i, columna).toString())) {
                numeroFilas++;
            }
        }
        if (numeroFilas == jTable.getRowCount()) {
            estado = true;
        }
        return estado;
    }

    public static String adjustPathSeparator(String path) {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return path.replace("/", "\\");
        }
        return "smb:" + path.replace("\\", "/");
    }

    public static String getSystemSO() {
        return System.getProperty("os.name").toLowerCase();
    }

    public void abrirDocumentosAnkara() {
    }

    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0246: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r22 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('in' java.io.InputStream)]) A[TRY_LEAVE], block:B:52:0x0246 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x024b: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r23 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:54:0x024b */
    public String getFilePdfPath(String path, String pdfFileName, boolean isVisible) {
        String finalAddress = "";
        try {
            System.out.println(" path" + path);
            System.out.println(" pdfFileName" + pdfFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (getSystemSO().contains("win")) {
            if (mExisteArchivo(path + getBarra() + pdfFileName)) {
                if (isVisible) {
                    mostrarPdf(path + getBarra() + pdfFileName);
                }
                finalAddress = path + getBarra() + pdfFileName;
            } else {
                JOptionPane.showInternalMessageDialog((Component) null, "El archivo que trata de abrir no se encuentra en la siguiente ruta:\n\n" + path + getBarra() + pdfFileName, "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
            }
        } else {
            try {
                NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username, password);
                Properties prop = new Properties();
                prop.setProperty("jcifs.smb.client.disableSMB2", "false");
                CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
                String file = adjustPathSeparator(path.replaceAll("^smb:|[\\\\/]+$", "")) + getBarraEstatica() + pdfFileName;
                System.out.println(" Datos : " + file);
                SmbFile pdfFile = new SmbFile(file, context);
                File localFile = new File(System.getProperty("java.io.tmpdir"), pdfFileName);
                InputStream in = pdfFile.getInputStream();
                Throwable th = null;
                FileOutputStream out = new FileOutputStream(localFile);
                Throwable th2 = null;
                try {
                    try {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int bytesRead = in.read(buffer);
                            if (bytesRead == -1) {
                                break;
                            }
                            out.write(buffer, 0, bytesRead);
                            return finalAddress;
                        }
                        if (out != null) {
                            if (0 != 0) {
                                try {
                                    out.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                out.close();
                            }
                        }
                        if (in != null) {
                            if (0 != 0) {
                                try {
                                    in.close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                in.close();
                            }
                        }
                        if (localFile.exists()) {
                            if (isVisible) {
                                if (Desktop.isDesktopSupported()) {
                                    Desktop.getDesktop().open(localFile);
                                } else {
                                    System.out.println("La apertura de archivos no es compatible en este sistema.");
                                }
                            }
                            finalAddress = localFile.getAbsolutePath();
                        } else {
                            System.out.println("El archivo PDF no se descargó correctamente.");
                        }
                    } catch (Throwable th5) {
                        if (out != null) {
                            if (th2 != null) {
                                try {
                                    out.close();
                                } catch (Throwable th6) {
                                    th2.addSuppressed(th6);
                                }
                            } else {
                                out.close();
                            }
                        }
                        throw th5;
                    }
                } finally {
                }
            } finally {
            }
        }
        return finalAddress;
    }

    public static boolean existeCarpeta(String urlRuta) {
        try {
            if (getSystemSO().contains("win")) {
                Path pathCarpeta = Paths.get(urlRuta, new String[0]);
                System.out.println("carpeta -> " + pathCarpeta);
                if (Files.exists(pathCarpeta, new LinkOption[0])) {
                    return true;
                }
                return false;
            }
            NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username, password);
            Properties prop = new Properties();
            prop.setProperty("jcifs.smb.client.disableSMB2", "false");
            CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
            SmbFile carpeta = new SmbFile(urlRuta, context);
            return carpeta.exists() && carpeta.isDirectory();
        } catch (MalformedURLException | CIFSException e) {
            return false;
        }
    }

    /* JADX WARN: Finally extract failed */
    public static File buscarArchivo(String path, String username2, String password2, String prefijo, String extension) {
        try {
            NtlmPasswordAuthenticator auth = new NtlmPasswordAuthenticator(username2, password2);
            Properties prop = new Properties();
            prop.setProperty("jcifs.smb.client.disableSMB2", "false");
            CIFSContext context = new BaseContext(new PropertyConfiguration(prop)).withCredentials(auth);
            SmbFile carpeta = new SmbFile(path, context);
            if (carpeta.exists() && carpeta.isDirectory()) {
                for (SmbFile archivo : carpeta.listFiles()) {
                    if (archivo.isFile() && archivo.getName().startsWith(prefijo) && archivo.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                        File archivoLocal = new File(System.getProperty("java.io.tmpdir"), archivo.getName());
                        InputStream in = archivo.getInputStream();
                        Throwable th = null;
                        try {
                            FileOutputStream out = new FileOutputStream(archivoLocal);
                            Throwable th2 = null;
                            try {
                                try {
                                    byte[] buffer = new byte[1024];
                                    while (true) {
                                        int bytesRead = in.read(buffer);
                                        if (bytesRead == -1) {
                                            break;
                                        }
                                        out.write(buffer, 0, bytesRead);
                                    }
                                    if (out != null) {
                                        if (0 != 0) {
                                            try {
                                                out.close();
                                            } catch (Throwable th3) {
                                                th2.addSuppressed(th3);
                                            }
                                        } else {
                                            out.close();
                                        }
                                    }
                                    if (in != null) {
                                        if (0 != 0) {
                                            try {
                                                in.close();
                                            } catch (Throwable th4) {
                                                th.addSuppressed(th4);
                                            }
                                        } else {
                                            in.close();
                                        }
                                    }
                                    return archivoLocal;
                                } catch (Throwable th5) {
                                    if (out != null) {
                                        if (th2 != null) {
                                            try {
                                                out.close();
                                            } catch (Throwable th6) {
                                                th2.addSuppressed(th6);
                                            }
                                        } else {
                                            out.close();
                                        }
                                    }
                                    throw th5;
                                }
                            } catch (Throwable th7) {
                                th2 = th7;
                                throw th7;
                            }
                        } catch (Throwable th8) {
                            if (in != null) {
                                if (0 != 0) {
                                    try {
                                        in.close();
                                    } catch (Throwable th9) {
                                        th.addSuppressed(th9);
                                    }
                                } else {
                                    in.close();
                                }
                            }
                            throw th8;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDevuelveStringArchivoBase64(File archivo) {
        String cadenaBase64 = "";
        try {
            cadenaBase64 = encodeFileToBase64Binary(archivo.getAbsolutePath());
            return cadenaBase64;
        } catch (IOException ex) {
            Logger.getLogger(JD_EncuestaIngreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            return cadenaBase64;
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x00de: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:20:0x00de */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00e3: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x00e3 */
    public InfoRecepcion getInfoRecepcionId(Long idRecepcion) {
        Response response;
        Throwable th;
        InfoRecepcion infoRecepcion = InfoRecepcion.builder().build();
        try {
            try {
                RecursosMicroserviciosDomain microserviciosDomain = (RecursosMicroserviciosDomain) Optional.ofNullable(getParametrosEncriptados("24", "findByInfoRecepcionId")).orElseThrow(() -> {
                    return new IllegalStateException("No se pudo obtener la configuración del microservicio");
                });
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idRecepcion;
                Response response2 = getResteasyClient().target(fullUrl).request().get();
                Throwable th2 = null;
                int statusCode = response2.getStatus();
                if (statusCode == 200) {
                    String jsonResponse = (String) response2.readEntity(String.class);
                    CustomPresenter presenter = (CustomPresenter) getMapper().readValue(jsonResponse, CustomPresenter.class);
                    infoRecepcion = (InfoRecepcion) getMapper().convertValue(presenter.getData(), InfoRecepcion.class);
                } else {
                    Logger.getLogger(Metodos.class.getName()).log(Level.WARNING, "Error en la solicitud: Código {0}", Integer.valueOf(statusCode));
                }
                if (response2 != null) {
                    if (0 != 0) {
                        try {
                            response2.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    } else {
                        response2.close();
                    }
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error inesperado", (Throwable) ex);
            } catch (IllegalStateException ex2) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error en configuración del microservicio", (Throwable) ex2);
            } catch (JsonProcessingException e) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
            }
            return infoRecepcion;
        } catch (Throwable th4) {
            if (response != null) {
                if (th != null) {
                    try {
                        response.close();
                    } catch (Throwable th5) {
                        th.addSuppressed(th5);
                    }
                } else {
                    response.close();
                }
            }
            throw th4;
        }
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x00ff: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('response' javax.ws.rs.core.Response)]) A[TRY_LEAVE], block:B:20:0x00ff */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0104: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:22:0x0104 */
    public List<TrackingDomain> getListInfoTrackingIdRecepcion(Long idRecepcion) {
        List<TrackingDomain> trackingDomains = new ArrayList();
        try {
            try {
                RecursosMicroserviciosDomain microserviciosDomain = (RecursosMicroserviciosDomain) Optional.ofNullable(getParametrosEncriptados("24", "findByIdRececionTraking")).orElseThrow(() -> {
                    return new IllegalStateException("No se pudo obtener la configuración del microservicio");
                });
                String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + idRecepcion;
                System.out.println(" full " + fullUrl);
                Response response = getResteasyClient().target(fullUrl).request().get();
                Throwable th = null;
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    String jsonResponse = (String) response.readEntity(String.class);
                    CustomPresenter presenter = (CustomPresenter) getMapper().readValue(jsonResponse, CustomPresenter.class);
                    trackingDomains = (List) getMapper().convertValue(presenter.getData(), new TypeReference<List<TrackingDomain>>() { // from class: Utilidades.Metodos.5
                    });
                } else {
                    Logger.getLogger(Metodos.class.getName()).log(Level.WARNING, "Error en la solicitud: Código {0}", Integer.valueOf(statusCode));
                }
                if (response != null) {
                    if (0 != 0) {
                        try {
                            response.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        response.close();
                    }
                }
            } finally {
            }
        } catch (JsonProcessingException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error al procesar JSON", e);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error inesperado", (Throwable) ex);
        } catch (IllegalStateException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, "Error en configuración del microservicio", (Throwable) ex2);
        }
        return trackingDomains;
    }

    public void imprimirPDF(String rutaPDF) {
        try {
            File pdfFile = new File(rutaPDF);
            DocFlavor.INPUT_STREAM input_stream = DocFlavor.INPUT_STREAM.AUTOSENSE;
            HashPrintRequestAttributeSet hashPrintRequestAttributeSet = new HashPrintRequestAttributeSet();
            hashPrintRequestAttributeSet.add(MediaSizeName.ISO_A4);
            hashPrintRequestAttributeSet.add(OrientationRequested.PORTRAIT);
            hashPrintRequestAttributeSet.add(new Copies(1));
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            if (printService == null) {
                System.err.println("No se encontró una impresora predeterminada.");
                return;
            }
            DocPrintJob printJob = printService.createPrintJob();
            printJob.print(new SimpleDoc(new FileInputStream(pdfFile), input_stream, (DocAttributeSet) null), hashPrintRequestAttributeSet);
            System.out.println("PDF enviado a la impresora correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String removerAcentos(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}
