package Utilidades;

import Acceso.Principal;
import General.Persona;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.flexdock.plaf.PlafManager;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.jvnet.substance.SubstanceLookAndFeel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Metodos1.class */
public class Metodos1 {
    private GregorianCalendar fechaActual;
    public DefaultTableModel modcombos;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public SimpleDateFormat formatoAMD = new SimpleDateFormat("yyyy/MM/dd");
    public SimpleDateFormat formatoAMDG = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat formatoDMA = new SimpleDateFormat("dd/MM/yyyy");
    public SimpleDateFormat formatoAMDH24 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public SimpleDateFormat formatoDMAH24 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public SimpleDateFormat formatoAMDH12 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
    public SimpleDateFormat formatoDMAH12 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    public SimpleDateFormat formatoH12 = new SimpleDateFormat("hh:mm:ss a");
    public SimpleDateFormat formatoH24 = new SimpleDateFormat("HH:mm:ss");
    public SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMMMMMMMM dd 'de' yyyy");
    private Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
    private String nbreArchivo = null;
    private String titulo = "G@noma Plus";

    public void abrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Program Files\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe D:\\Leeme.pdf");
        } catch (IOException ex) {
            this.consultas.mostrarErrorIO(ex);
        }
    }

    public void cargarDecoracion() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            PlafManager.setPreferredTheme("substance");
            Principal.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.MistAquaSkin");
        } catch (Exception e) {
        }
    }

    public String cargarRuta(String ruta) {
        JFileChooser barchivo = new JFileChooser(ruta);
        int returnVal = barchivo.showOpenDialog((Component) null);
        if (returnVal == 0) {
            return barchivo.getSelectedFile().toString();
        }
        return "";
    }

    public String cargarRuta(String ruta, JPanel panel) {
        JFileChooser barchivo = new JFileChooser(ruta);
        int returnVal = barchivo.showOpenDialog(panel);
        if (returnVal == 0) {
            return barchivo.getSelectedFile().toString();
        }
        return "";
    }

    public void escogerItemCboPorDefecto(JTableComboBox cbo) {
        if (cbo.getPopupTable().getRowCount() == 1) {
            cbo.setSelectedIndex(0);
        }
    }

    public Boolean encontrado(DefaultTableModel mod, int col, int col1, String buscar) {
        Boolean enc = false;
        int f = 1;
        while (true) {
            if (f < mod.getRowCount()) {
                if (mod.getValueAt(f - 1, col1) == null || !mod.getValueAt(f - 1, col).toString().equals(buscar)) {
                    f++;
                } else {
                    enc = true;
                    break;
                }
            } else {
                break;
            }
        }
        return enc;
    }

    public Date getFechaActual() {
        this.fechaActual = new GregorianCalendar();
        return this.fechaActual.getTime();
    }

    public Date getPasarTextoaFechaAAAAMMDD(String texto) {
        GregorianCalendar fecha = new GregorianCalendar();
        new Date();
        String dia = texto.substring(8, 10);
        String mes = texto.substring(5, 7);
        String ano = texto.substring(0, 4);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
        Date fecha1 = fecha.getTime();
        return fecha1;
    }

    public Date getPasarTextoAFechaDDMMAAAA(String texto) {
        GregorianCalendar fecha = new GregorianCalendar();
        new Date();
        String dia = texto.substring(0, 2);
        String mes = texto.substring(3, 5);
        String ano = texto.substring(6, 10);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
        Date fecha1 = fecha.getTime();
        return fecha1;
    }

    public int getPregunta(String msg) {
        return JOptionPane.showConfirmDialog((Component) null, msg, this.titulo, 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public int getPregunta2(String msg, Object[] botones, String btnDefecto) {
        return JOptionPane.showOptionDialog((Component) null, msg, this.titulo, 0, 3, (Icon) null, botones, btnDefecto);
    }

    public String getSO() {
        return System.getProperties().getProperty("user.dir");
    }

    public String getBarra() {
        String ruta = System.getProperty("os.name").substring(0, 3).equals("Win") ? "\\" : "/";
        return ruta;
    }

    public String getRutaRep(String modulo) {
        return getSO() + getBarra() + "reportes" + getBarra() + modulo + getBarra();
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

    public void verificarCantRegCbos(JTableComboBox cbo) {
        if (cbo.getPopupTable().getRowCount() <= 2) {
            cbo.setShowTableHeaders(false);
        } else {
            cbo.setShowTableHeaders(true);
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

    public int pasarBooleanInt(Boolean valor) {
        int vble = 0;
        if (valor.booleanValue()) {
            vble = 1;
        }
        return vble;
    }

    public Boolean pasarIntBoolean(int valor) {
        Boolean vble = false;
        if (valor == 1) {
            vble = true;
        }
        return vble;
    }

    public String pasarHora12a24(String hora) {
        String horaDevolver;
        int horas = Integer.parseInt(hora.substring(0, 2));
        if (hora.length() > 9) {
            if (hora.substring(9, 10).equals("M") && horas == 12) {
                horas = 12;
            } else if (hora.substring(9, 11).equals("PM") && horas != 12) {
                horas += 12;
            } else if (hora.substring(9, 11).equals("PM") && horas == 12) {
                horas = 12;
            } else if (hora.substring(9, 11).equals("AM") && horas == 12) {
                horas = 0;
            }
            String hora2 = horas < 10 ? "0" + horas : String.valueOf(horas);
            horaDevolver = hora2 + ":" + hora.substring(3, 9);
        } else {
            if (hora.substring(6, 7).equals("M") && horas == 12) {
                horas = 12;
            } else if (hora.substring(6, 8).equals("PM") && horas != 12) {
                horas += 12;
            } else if (hora.substring(6, 8).equals("PM") && horas == 12) {
                horas = 12;
            } else if (hora.substring(6, 8).equals("AM") && horas == 12) {
                horas = 0;
            }
            String hora22 = horas < 10 ? "0" + horas : String.valueOf(horas);
            horaDevolver = hora22 + ":" + hora.substring(3, 6);
        }
        return horaDevolver;
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

    public void mostrarPdf(String ruta) {
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                Runtime.getRuntime().exec("C:\\Program Files\\Adobe\\Reader 9.0\\Reader\\AcroRd32.exe " + ruta);
            } else {
                mostrarMensaje("No se encontro el Archivo PDF para Abrir");
            }
        } catch (IOException ex) {
            this.consultas.mostrarErrorIO(ex);
        }
    }

    public void convertirPDF() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "user", "pass");
            JasperReport report = JasperCompileManager.compileReport("C:\\report.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, (Map) null, conn);
            JasperExportManager.exportReportToPdfFile(print, "C:\\trabajo\\reporte1.pdf");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        } catch (JRException e) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    public String CrearPDF(String[][] parametros) {
        this.nbreArchivo = cargarRuta("C:\\GPlus\\Aptitudes\\Prueba");
        if (this.nbreArchivo != null && !this.nbreArchivo.isEmpty()) {
            Connection con = this.consultas.establecerConexionBd();
            Map parametro = new HashMap();
            for (int i = 0; i < parametros.length; i++) {
                try {
                    parametro.put(parametros[i][0], parametros[i][1]);
                } catch (Exception j) {
                    this.consultas.mostrarErrorE(j);
                }
            }
            String str = this.nbreArchivo + ".jrxml";
            JasperReport reporte = JasperCompileManager.compileReport("C:\\GPlus\\Reportes\\SO\\AptitudMedica.jrxml");
            JasperPrint print = JasperFillManager.fillReport(reporte, (Map) null, con);
            JasperExportManager.exportReportToPdfFile(print, "C:\\GPlus\\Aptitudes\\Prueba.pdf");
            this.consultas.cerrarConexionBd();
        }
        return null;
    }

    public String restarFechas(String ini, String fin) {
        GregorianCalendar hoy = new GregorianCalendar();
        hoy.set(Integer.parseInt(fin.substring(0, 4)), Integer.parseInt(fin.substring(5, 7)), Integer.parseInt(fin.substring(8, 10)));
        String dato = fin.substring(0, 4) + "/" + fin.substring(5, 7) + "/" + fin.substring(8, 10);
        new DecimalFormat("#0");
        int y1 = Integer.parseInt(ini.substring(0, 4));
        int m1 = Integer.parseInt(ini.substring(5, 7));
        int d1 = Integer.parseInt(ini.substring(8, 10));
        int y2 = Integer.parseInt(dato.substring(0, 4));
        int m2 = Integer.parseInt(dato.substring(5, 7));
        int d2 = Integer.parseInt(dato.substring(8, 10));
        int dias = ((y2 - y1) * 360) + ((m2 - m1) * 30) + (d2 - d1);
        return String.valueOf(dias);
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

    public String pasarFechaHora12a24(String FechaHora) {
        String Fecha = FechaHora.substring(0, 10);
        String Hora = FechaHora.substring(11);
        return Fecha + " " + pasarHora12a24(Hora);
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

    public String getEdadEnMeses(String fecha) {
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
            lista[0][0] = String.valueOf(Integer.parseInt(diasm));
            lista[0][1] = " Meses";
            lista[0][2] = "2";
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
                        pathname = "C:\\Pymesoft\\reportes\\tmp.pdf";
                    } else {
                        pathname = "C:\\Pymesoft\\reportes\\tmp.bmp";
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

    public void recorrerDirectorio() {
        File dir = new File("z:\\reportes");
        String[] ficheros = dir.list();
        if (ficheros == null) {
            System.out.println("No hay ficheros en el directorio especificado");
            return;
        }
        for (String str : ficheros) {
            System.out.println(str);
        }
    }

    public void getRecuperarMostrarBlob(String sq) {
        try {
            recuperarBlob(sq, 0);
            mostrarPdf("C:\\Pymesoft\\tmp\\atmp.pdf");
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    public void PresentacionImpresora(String nbreArchivo, String[][] parametros) {
        this.consultas.establecerConexionBd();
        Map parametro = new HashMap();
        try {
            String str = "C:\\Pymesoft\\reportes\\" + nbreArchivo;
            for (int i = 0; i < parametros.length; i++) {
                parametro.put(parametros[i][0], parametros[i][1]);
            }
            this.consultas.cerrarConexionBd();
        } catch (Exception e) {
        }
    }

    public int generarTXT(ResultSet rs, int columnas) {
        int contador = 0;
        try {
            this.nbreArchivo = cargarRuta("C://GPlus//Plano//") + ".txt";
            FileWriter fw = new FileWriter(this.nbreArchivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salida = new PrintWriter(bw);
            while (rs.next()) {
                contador++;
                for (int i = 1; i <= columnas; i++) {
                    if (i == columnas) {
                        salida.print(rs.getString(i));
                        if (!rs.isLast()) {
                            salida.println();
                        }
                    } else {
                        salida.print(rs.getString(i) + ",");
                    }
                }
            }
            salida.close();
            rs.close();
        } catch (IOException ex) {
            this.consultas.mostrarErrorIO(ex);
        } catch (SQLException ex2) {
            this.consultas.mostrarErrorSQL(ex2);
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
}
