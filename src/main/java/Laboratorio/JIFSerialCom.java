package Laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyVetoException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFSerialCom.class */
public class JIFSerialCom extends JInternalFrame {
    static int mascara;
    static String seleccionPuerto;
    StringBuilder output = new StringBuilder();
    List<String> lista = new ArrayList();
    static String[] puertosActuales;
    static String[][] xequipos;
    private static LaboratorioDAO xImplLabotaorio;
    private ButtonGroup JBGEquipos;
    private static JComboBox<String> JCBEquipos;
    public static JButton conectarBtn;
    static SerialPort puerto = null;
    public static Vector xvector = new Vector();
    public static Vector listID = new Vector();
    private static Metodos xmetodos = new Metodos();
    static StringBuilder message = new StringBuilder();
    static StringBuilder bytemessage = new StringBuilder();
    public static int cont = 0;
    public static int NRegistro = 0;
    public static int flag = 0;
    public static int rateBaund = 9600;
    public static int dataBit = 8;
    public static int stopBit = 1;
    public static int parity = 0;
    public static long xNoFrame = 0;
    public static String Fecha = "";
    public static String ID = "";
    public static String Hora = "";
    public static String Resultado = "";
    public static String Abreviatura = "";
    public static String TipoMuestra = "";
    public static String NMuestra = "";
    public static String Unidad = "";
    public static String Max = "";
    public static String Min = "";
    public static String EnviOrden = "";
    public static String Save = "";
    public static boolean xenviando = false;

    public JIFSerialCom() {
        try {
            initComponents();
            springStart();
            listarPuertos();
            mllenarCombo(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ex) {
            logExepciones(ex);
        }
    }

    private void springStart() {
        xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void mllenarCombo(String pc) {
        JCBEquipos.removeAllItems();
        System.out.println(pc);
        List<Object[]> list1 = xImplLabotaorio.listaEquiposxPC(pc);
        if (!list1.isEmpty()) {
            xequipos = new String[list1.size()][2];
            for (int x = 0; x < list1.size(); x++) {
                xequipos[x][0] = String.valueOf(list1.get(x)[0]);
                xequipos[x][1] = String.valueOf(list1.get(x)[1]);
                JCBEquipos.addItem(list1.get(x)[0].toString());
            }
            if (list1.size() <= 1) {
                if (list1.size() == 1) {
                    conectarBtnActionPerformed(null);
                    return;
                }
                return;
            }
            JCBEquipos.setSelectedIndex(-1);
            return;
        }
        JOptionPane.showMessageDialog(this, "Este PC no posee alguna maquina de laboratorio parametrizada", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void mFiltrarMaquinas() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            JCBEquipos.addItem("");
            JCBEquipos.addItem("DIRUI H-800");
            JCBEquipos.addItem("CB400I");
            JCBEquipos.addItem("DIRUI FUS-200");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
            JCBEquipos.addItem("MEK-6410J");
            JCBEquipos.addItem("HA-22 TOUCH");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            JCBEquipos.addItem("HA-8380V");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S")) {
            JCBEquipos.addItem("HA-22 TOUCH");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            JCBEquipos.addItem("");
            JCBEquipos.addItem("ARCHITECT I1000SR");
            JCBEquipos.addItem("STA SATELLITE");
            JCBEquipos.addItem("LIAISON");
            JCBEquipos.addItem("DYNEX DS2");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            JCBEquipos.addItem("");
            JCBEquipos.addItem("COBAS E411");
            JCBEquipos.addItem("COBAS C311");
            JCBEquipos.addItem("SYMEX XP-300");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO LABVY S.A.S")) {
            JCBEquipos.addItem("");
            JCBEquipos.addItem("LABPRO");
            JCBEquipos.addItem("DIRUI H-100");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
            JCBEquipos.addItem("WL COUNTER 19");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL")) {
            JCBEquipos.addItem("ABACUS 380");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            JCBEquipos.addItem("SYSMEX KX-21N");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("HOSPITAL NUESTRA SEÑORA DEL CARMEN")) {
            JCBEquipos.addItem("ABACUS 380");
            JCBEquipos.addItem("ABACUS JUNIOR");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS")) {
            JCBEquipos.addItem("ABACUS 380");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL")) {
            JCBEquipos.addItem("UNICEL DXI ACCESS 2");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS")) {
            JCBEquipos.addItem("UNICEL DXI ACCESS 2");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            JCBEquipos.addItem("UNICEL DXH 800");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            JCBEquipos.addItem("URIT 3010");
            JCBEquipos.addItem("URIT PKL 125");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE")) {
            JCBEquipos.addItem("ABACUS 380");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            JCBEquipos.addItem("UNICEL DXH 800");
            JCBEquipos.addItem("UNICEL DXI ACCESS 2");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
            JCBEquipos.addItem("AU480");
            JCBEquipos.addItem("ACL ELITE PRO");
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
            JCBEquipos.addItem("ABACUS 380");
            JCBEquipos.addItem("AUTION ELEVEN 4020");
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFSerialCom$EntradaSerial.class */
    static class EntradaSerial implements SerialPortEventListener {
        int n = 0;

        EntradaSerial() {
        }

        public void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR() && event.getEventValue() > 0) {
                try {
                    byte[] buffer = JIFSerialCom.puerto.readBytes();
                    for (byte b : buffer) {
                        if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("MEK-6410J")) {
                            JIFSerialCom.isMEK_6410J(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("HA-22 TOUCH")) {
                            JIFSerialCom.isHA_22_TOUCH(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DIRUI H-800")) {
                            JIFSerialCom.isH800UrineAnalyzer(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("CB400I")) {
                            JIFSerialCom.isCB400i(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("ARCHITECT I1000SR")) {
                            JIFSerialCom.isArchitecti1000(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("COBAS E411")) {
                            JIFSerialCom.isCobasE411(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("COBAS C311")) {
                            JIFSerialCom.isCobasC311(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("SYMEX XP-300")) {
                            JIFSerialCom.isSysmeXP(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("STA SATELLITE")) {
                            JIFSerialCom.isStaSatellite(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("LIAISON")) {
                            JIFSerialCom.isLiaison(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("HA-8380V")) {
                            JIFSerialCom.isHA_8380V(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DYNEX DS2")) {
                            JIFSerialCom.isDS2(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("LABPRO")) {
                            JIFSerialCom.isLabPro(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DIRUI H-100")) {
                            JIFSerialCom.isDiruiH100(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("SELECTRA PRO XS")) {
                            JIFSerialCom.isSelectraProXs(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("WL COUNTER 19")) {
                            JIFSerialCom.isWLCounter19(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DIRUI FUS-200")) {
                            JIFSerialCom.isDiruiFUS200(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("ABACUS 380")) {
                            JIFSerialCom.isAbacus380(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("AUTION ELEVEN 4020")) {
                            JIFSerialCom.isAutionEleven4020(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("SYSMEX KX-21N")) {
                            JIFSerialCom.isSysmexkx_21N(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("ABACUS JUNIOR")) {
                            JIFSerialCom.isAbacusJunior(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXI ACCESS 2")) {
                            JIFSerialCom.isUnicelDXIAccess2(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXH 800")) {
                            JIFSerialCom.isUnicelDXH800(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("URIT 3010")) {
                            JIFSerialCom.isUrit3010(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("URIT PKL 125")) {
                            JIFSerialCom.isUritPkl125(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("ACL ELITE PRO")) {
                            JIFSerialCom.isACLElitePRO(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("AU480")) {
                            JIFSerialCom.isAU480(b);
                        } else if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DIRUI H-500")) {
                            JIFSerialCom.isDiruiH500(b);
                        }
                    }
                } catch (SerialPortException ex) {
                    System.out.println(ex);
                    System.out.println("serialEvent");
                }
            }
            if (!event.isRXFLAG() && !JIFSerialCom.xenviando) {
                if (!JIFSerialCom.JCBEquipos.getSelectedItem().equals("CB400I")) {
                    if (!JIFSerialCom.JCBEquipos.getSelectedItem().equals("ARCHITECT I1000SR") && !JIFSerialCom.JCBEquipos.getSelectedItem().equals("COBAS E411")) {
                        if (!JIFSerialCom.JCBEquipos.getSelectedItem().equals("COBAS C311")) {
                            if (!JIFSerialCom.JCBEquipos.getSelectedItem().equals("SYMEX XP-300")) {
                                if (!JIFSerialCom.JCBEquipos.getSelectedItem().equals("ABACUS JUNIOR")) {
                                    if (JIFSerialCom.JCBEquipos.getSelectedItem().equals("DYNEX DS2") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("LIAISON") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("HA-8380V") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("STA SATELLITE") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("SELECTRA PRO XS") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("DIRUI FUS-200") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXI ACCESS 2") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXH 800") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("URIT PKL 125") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("ACL ELITE PRO") || JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXH 800")) {
                                        try {
                                            Thread.sleep(200L);
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("STA SATELLITE")) {
                                                JIFSerialCom.mConsultarProtocolosV2(JIFSerialCom.ID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("LIAISON")) {
                                                JIFSerialCom.mConsultarProtocolosV3(JIFSerialCom.listID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.listID.size() > 0 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("DYNEX DS2")) {
                                                JIFSerialCom.mConsultarProtocolosV4(JIFSerialCom.listID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.listID.size() > 0 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXI ACCESS 2")) {
                                                JIFSerialCom.mConsultarProtocolosV5(JIFSerialCom.listID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.listID.size() > 0 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("URIT PKL 125")) {
                                                JIFSerialCom.mConsultarProtocolosV5(JIFSerialCom.listID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.listID.size() > 0 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("UNICEL DXH 800")) {
                                                JIFSerialCom.mConsultarProtocolosV7(JIFSerialCom.listID);
                                            }
                                            if (JIFSerialCom.flag == 2 && JIFSerialCom.listID.size() > 0 && JIFSerialCom.JCBEquipos.getSelectedItem().equals("ACL ELITE PRO")) {
                                                JIFSerialCom.mConsultarProtocolosV8(JIFSerialCom.listID);
                                            }
                                            JIFSerialCom.mEnvioPuertoSerial(String.valueOf((char) 6));
                                            return;
                                        } catch (InterruptedException ex2) {
                                            JIFSerialCom.logExepciones(ex2);
                                            return;
                                        }
                                    }
                                    return;
                                }
                                try {
                                    Thread.sleep(200L);
                                    if (!JIFSerialCom.Save.isEmpty()) {
                                        JIFSerialCom.mEnvioPuertoSerial(JIFSerialCom.Save);
                                    }
                                    return;
                                } catch (InterruptedException ex3) {
                                    JIFSerialCom.logExepciones(ex3);
                                    return;
                                }
                            }
                            try {
                                JIFSerialCom.message.setLength(0);
                                JIFSerialCom.bytemessage.setLength(0);
                                JIFSerialCom.mEnvioPuertoSerial("\u0006");
                                Thread.sleep(300L);
                                return;
                            } catch (InterruptedException ex4) {
                                JIFSerialCom.logExepciones(ex4);
                                return;
                            }
                        }
                        try {
                            JIFSerialCom.message.setLength(0);
                            JIFSerialCom.bytemessage.setLength(0);
                            JIFSerialCom.mEnvioPuertoSerial("\u0006");
                            Thread.sleep(600L);
                            return;
                        } catch (InterruptedException ex5) {
                            JIFSerialCom.logExepciones(ex5);
                            return;
                        }
                    }
                    try {
                        JIFSerialCom.message.setLength(0);
                        JIFSerialCom.bytemessage.setLength(0);
                        JIFSerialCom.mEnvioPuertoSerial(String.valueOf((char) 6));
                        Thread.sleep(200L);
                        return;
                    } catch (InterruptedException ex6) {
                        JIFSerialCom.logExepciones(ex6);
                        return;
                    }
                }
                try {
                    JIFSerialCom.message.setLength(0);
                    JIFSerialCom.bytemessage.setLength(0);
                    JIFSerialCom.mEnvioPuertoSerial("\u0002R\u0004");
                    Thread.sleep(3000L);
                } catch (InterruptedException ex7) {
                    JIFSerialCom.logExepciones(ex7);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isMEK_6410J(byte b) {
        if ((b == 13 || b == 10 || b == 9) && message.length() > 0) {
            cont++;
            String toProcess = message.toString().replace("\u0002", "");
            if (cont == 1) {
                Fecha = toProcess.substring(toProcess.length() - 8, toProcess.length());
            } else if (cont == 2) {
                ID = toProcess;
            } else {
                Resultado = toProcess;
                mGrabar(Fecha, ID.trim(), ObtenerProtocolo(cont, "MEK-6410J"), mRemplazar(Resultado.trim()));
                if (cont % 5 == 0) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException ex) {
                        logExepciones(ex);
                    }
                }
            }
            if (cont == 20) {
                Fecha = "";
                ID = "";
                cont = 0;
                NRegistro++;
                System.out.println("Registro No. " + NRegistro);
            }
            message.setLength(0);
            return;
        }
        message.append((char) b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isHA_22_TOUCH(byte b) {
        if (b == 44 && message.length() > 0) {
            cont++;
            String toProcess = message.toString();
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (cont == 2) {
                ID = toProcess;
                System.out.println("No. :" + ID);
            } else if (cont == 3) {
                Fecha = toProcess;
            } else if (cont == 4) {
                Hora = toProcess;
                System.out.println("Fecha: " + Fecha + " " + Hora);
            } else if (cont > 11 && cont < 72) {
                if (cont % 3 == 1) {
                    Resultado = toProcess;
                    mGrabar(Fecha + " " + Hora, ID.trim(), Abreviatura, Resultado);
                    if (cont % 5 == 0) {
                        try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException ex) {
                            logExepciones(ex);
                        }
                    }
                }
                Abreviatura = toProcess;
            }
            if (toProcess.equals("R") || toProcess.equals("TRANSFER FINISHR")) {
                Fecha = "";
                Hora = "";
                ID = "";
                cont = 1;
                NRegistro++;
                System.out.println("Registro No. " + NRegistro);
            }
            message.setLength(0);
            return;
        }
        message.append((char) b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isH800UrineAnalyzer(byte b) {
        if (b == 10 && message.length() > 0) {
            cont++;
            String toProcess = message.toString();
            String[] parts = message.toString().trim().split("\\s+");
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            int i = 0;
            int length = parts.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String texto = parts[i2];
                if (!texto.equals("\u001c") && parts.length >= 2) {
                    if (cont == 2) {
                        Fecha = parts[0];
                        Hora = parts[1];
                        break;
                    }
                    if (cont == 4) {
                        ID = parts[1];
                        break;
                    }
                    if (cont > 5) {
                        if (!parts[0].isEmpty() && !parts[1].isEmpty()) {
                            Abreviatura = parts[0].replace("*", "");
                            Resultado = parts[1];
                            if (Resultado.contains("Neg")) {
                                Resultado = Resultado.replace("Neg", "Negativo");
                            } else if (Resultado.contains("Pos")) {
                                Resultado = Resultado.replace("Pos", "Positivo");
                            } else if (Resultado.contains("+-")) {
                                Resultado = Resultado.replace("+-", "Negativo");
                            }
                            TipoMuestra = "SUERO";
                            if (!ID.isEmpty() && ID.matches("^([0-9])*$") && !Resultado.contains("Strip")) {
                                mGrabar(Fecha + " " + Hora + ":00", ID.trim(), Abreviatura, Resultado);
                            }
                        }
                    } else {
                        i++;
                    }
                }
                i2++;
            }
            if (toProcess.contains("\u0002") || toProcess.contains("ONLINE")) {
                Fecha = "";
                Hora = "";
                ID = "";
                cont = 1;
                NRegistro++;
            }
            message.setLength(0);
            return;
        }
        message.append((char) b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isCB400i(byte b) {
        if ((b == 2 || b == 4 || b == 6 || b == 33) && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(bytemessage.toString().replace("\u0002", ""));
            if (toProcess.contains("\u0006") && !EnviOrden.isEmpty()) {
                mEnvioPuertoSerial(EnviOrden);
                EnviOrden = "";
                flag = 1;
            }
            if (toProcess.length() >= 15 && !toProcess.contains("\u0002N")) {
                NMuestra = "";
                if (toProcess.substring(0, 16).contains(".")) {
                    ID = toProcess.substring(0, 16).split("\\.")[0];
                    TipoMuestra = "ORINA";
                } else if (toProcess.substring(0, 16).contains("-")) {
                    String[] pvalor = toProcess.substring(0, 16).split("\\-");
                    ID = pvalor[0];
                    NMuestra = pvalor[1];
                } else {
                    ID = toProcess.substring(0, 16);
                }
                if (toProcess.substring(17, 18).equals("S")) {
                    TipoMuestra = "SUERO";
                } else {
                    TipoMuestra = "ORINA";
                }
                System.out.println(ID);
                System.out.println(TipoMuestra);
                cont = (toProcess.length() - 24) / 11;
                System.out.println(toProcess.length());
                System.out.println(cont);
                int sum = 0;
                for (int i = 0; i < cont; i++) {
                    Abreviatura = toProcess.substring(21 + sum, 25 + sum);
                    if (toProcess.substring(25 + sum, 32 + sum).contains(".")) {
                        String[] pvalor2 = toProcess.substring(25 + sum, 32 + sum).split("\\.");
                        if (pvalor2[1].length() >= 2) {
                            Resultado = pvalor2[0] + "." + pvalor2[1].substring(0, 2);
                        } else if (pvalor2[1].length() < 2) {
                            Resultado = pvalor2[0] + "." + pvalor2[1].substring(0, 1);
                        }
                    } else {
                        Resultado = toProcess.substring(25 + sum, 32 + sum);
                    }
                    sum += 11;
                    Fecha = xmetodos.formatoAMDH24_1.format(xmetodos.getFechaActual());
                    System.out.println(Abreviatura.trim());
                    System.out.println(Resultado);
                    if (ID.replace("\u0002", "").replaceFirst("^0*", "").trim().matches("^([0-9])*$")) {
                        mGrabar(Fecha, ID.replace("\u0002", "").trim(), Abreviatura.trim(), Resultado);
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " - ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isArchitecti1000(byte b) {
        if ((b == 13 || b == 10 || b == 9) && message.length() > 0) {
            String toProcess = message.toString();
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("O")) {
                        NMuestra = "";
                        if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        System.out.println(ID);
                    } else if (!parts[0].contains("R")) {
                        i++;
                    } else {
                        String[] Subpart = parts[2].split("\\^");
                        if (Subpart[10].equals("F")) {
                            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                                TipoMuestra = "Serum";
                            } else {
                                TipoMuestra = "SUERO";
                            }
                            Abreviatura = Subpart[3];
                            if (parts[3].contains(".")) {
                                String[] pvalor2 = parts[3].split("\\.");
                                if (pvalor2[1].length() >= 2) {
                                    Resultado = pvalor2[0] + "." + pvalor2[1].substring(0, 2);
                                } else if (pvalor2[1].length() < 2) {
                                    Resultado = pvalor2[0] + "." + pvalor2[1].substring(0, 1);
                                }
                            } else {
                                Resultado = parts[3];
                            }
                            Fecha = parts[12];
                            if (ID.matches("^([0-9])*$")) {
                                mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                            }
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isCobasE411(byte b) {
        if ((b == 13 || b == 10 || b == 9) && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|") || toProcess.substring(0, 1) == "R") {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("O")) {
                        ID = parts[2];
                        System.out.println(ID);
                        break;
                    } else if (!parts[0].contains("R")) {
                        i++;
                    } else {
                        String[] Subpart = parts[2].split("\\^");
                        TipoMuestra = "SUERO";
                        Abreviatura = Subpart[3];
                        Resultado = parts[3];
                        Fecha = parts[12];
                        if (ID.matches("^([0-9])*$")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isCobasC311(byte b) {
        if ((b == 13 || b == 2 || b == 23) && message.length() > 0) {
            if (!Save.isEmpty()) {
                cont++;
            }
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|") || "R".equals(toProcess.substring(0, 1))) {
                String[] parts = message.toString().trim().split("\\|");
                if (parts[0].contains("O")) {
                    ID = parts[2].trim();
                    Fecha = parts[22];
                    System.out.println(Fecha);
                }
                if (parts[0].contains("R") || "R".equals(toProcess.substring(0, 1))) {
                    if (toProcess.contains("P1")) {
                        String[] Subpart = parts[2].split("\\^");
                        TipoMuestra = "SUERO";
                        Abreviatura = Subpart[3].replace("/", "");
                        Resultado = parts[3];
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        Save = "";
                        cont = 0;
                    } else {
                        Save = toProcess;
                    }
                }
                System.out.println("cont: " + cont);
                if (!Save.isEmpty() && cont == 2) {
                    Save += toProcess.substring(2);
                    System.out.println("CONCATENADO :" + Save);
                    String[] partsave = Save.toString().trim().split("\\|");
                    String[] Subpart2 = partsave[2].split("\\^");
                    TipoMuestra = "SUERO";
                    Abreviatura = Subpart2[3].replace("/", "");
                    Resultado = partsave[3];
                    System.out.println(Abreviatura);
                    System.out.println(Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Save = "";
                    cont = 0;
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isSysmeXP(byte b) {
        if ((b == 13 || b == 10 || b == 9) && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("O")) {
                        String[] Subpart = parts[3].split("\\^");
                        ID = Subpart[2].trim();
                        System.out.println(ID);
                        break;
                    } else if (!parts[0].contains("R")) {
                        i++;
                    } else {
                        String[] Subpart2 = parts[2].split("\\^");
                        TipoMuestra = "SANGRE";
                        Abreviatura = Subpart2[4];
                        Resultado = parts[3].trim();
                        Fecha = parts[12];
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        System.out.println(Fecha);
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        break;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isStaSatellite(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            Metodos metodos = xmetodos;
            Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        String[] SubID = parts[2].split("\\^");
                        ID = SubID[1].trim();
                        System.out.println(ID);
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O")) {
                        NMuestra = "";
                        if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        System.out.println(ID);
                    } else if (parts[0].contains("R")) {
                        String[] Subpart = parts[2].split("\\^");
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            TipoMuestra = "Serum";
                        } else {
                            TipoMuestra = "SUERO";
                        }
                        Abreviatura = Subpart[3];
                        Resultado = parts[3];
                        if (ID.matches("^([0-9])*$")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isLiaison(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        listID.add(parts[2]);
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O")) {
                        NMuestra = "";
                        if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        System.out.println(ID);
                    } else if (parts[0].contains("R")) {
                        String[] Subpart = parts[2].split("\\^");
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            TipoMuestra = "Serum";
                        } else {
                            TipoMuestra = "SUERO";
                        }
                        if (Subpart.length != 0) {
                            Abreviatura = Subpart[3];
                        }
                        if (Abreviatura.equals("T4")) {
                            Unidad = "ng/dL";
                        } else {
                            Unidad = parts[4];
                        }
                        Resultado = parts[3];
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        System.out.println(Unidad);
                        System.out.println(Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty()) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isHA_8380V(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("O")) {
                        String[] SubID = parts[2].split("\\^");
                        ID = SubID[0].replace("-", "");
                        break;
                    }
                    if (!parts[0].contains("R") || Long.valueOf(parts[1]).longValue() > 10) {
                        i++;
                    } else {
                        String[] Subpart = parts[2].split("\\^");
                        Abreviatura = Subpart[3];
                        if (parts[3].contains("^")) {
                            String[] SubValor = parts[3].split("\\^");
                            Resultado = SubValor[2];
                        } else {
                            Resultado = parts[3];
                        }
                        if (parts[4].contains("^")) {
                            String[] SubRef = parts[4].split("\\^");
                            Unidad = SubRef[2];
                        } else {
                            Unidad = parts[4];
                        }
                        TipoMuestra = "SANGRE";
                        if (ID.matches("^([0-9])*$") && !Resultado.contains("--") && !Abreviatura.equals("TimeBottom")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isDS2(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (cont == 1) {
                if (!Save.contains("L|1|N")) {
                    toProcess = Save.substring(0, Save.length() - 3) + message.substring(3, message.length()).replace("\u0002", "");
                }
                Save = "";
                cont = 0;
            } else if (toProcess.contains("\u0017")) {
                cont++;
                Save = toProcess;
                toProcess = toProcess.replace("|", "");
            }
            if (toProcess.contains("|")) {
                String[] parts = toProcess.trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H") && parts.length == 14) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("Q") && parts.length == 13) {
                        System.out.println("Entro");
                        listID.add(parts[2]);
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O") && parts.length == 7) {
                        NMuestra = "";
                        if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        System.out.println(ID);
                    } else if (parts[0].contains("R") && parts.length == 14) {
                        String[] Subpart = parts[2].split("\\^");
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            TipoMuestra = "Serum";
                        } else {
                            TipoMuestra = "SUERO";
                        }
                        Abreviatura = Subpart[3];
                        Resultado = parts[3];
                        Unidad = "";
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        System.out.println(Unidad);
                        System.out.println(Fecha);
                        if (ID.matches("^([0-9])*$")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L") || parts.length != 3) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isLabPro(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString().replaceAll("\u0002", "").replaceAll("\u0003", "");
            System.out.println("RECIBO: " + toProcess);
            if (toProcess != null && toProcess.contains(",")) {
                String[] parts = message.toString().replace("\"", "").trim().split("\\,");
                if (parts[0].contains("B")) {
                    Fecha = parts[9];
                    ID = parts[2];
                }
                if (parts[0].contains("C")) {
                    TipoMuestra = "SUERO";
                    Abreviatura = "Commentario";
                    Resultado = parts[4];
                    if (ID.matches("^([0-9])*$")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    }
                }
                if (parts[0].contains("R")) {
                    TipoMuestra = "SUERO";
                    Abreviatura = "Aislamiento";
                    Resultado = parts[12];
                    if (ID.matches("^([0-9])*$")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    }
                }
                if (parts[0].contains("M")) {
                    TipoMuestra = "SUERO";
                    Abreviatura = parts[2];
                    if (!parts[8].isEmpty()) {
                        Resultado = parts[4] + " " + parts[8];
                    } else {
                        Resultado = parts[4] + " " + parts[7];
                    }
                    System.out.println("Abreviatura: " + Abreviatura);
                    System.out.println("Resultado: " + Resultado);
                    System.out.println("Unidad: " + Unidad);
                    System.out.println("Fecha: " + Fecha);
                    if (ID.matches("^([0-9])*$")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isDiruiH100(byte b) {
        if (b == 10 && message.length() > 0) {
            cont++;
            String toProcess = message.toString();
            System.out.println(toProcess);
            String[] parts = message.toString().trim().split("\\s+");
            int i = 0;
            int length = parts.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String texto = parts[i2];
                if (!texto.equals("\u001c")) {
                    if (cont == 2) {
                        Fecha = parts[0].replace("Date:", "");
                        Hora = parts[1];
                        System.out.println("Fecha y Hora: " + Fecha + " " + Hora);
                        break;
                    }
                    if (cont == 4) {
                        if (parts[0].contains(".")) {
                            String[] SubID = parts[0].split("\\.");
                            ID = SubID[0].replace("ID:", "").replace("-", "");
                        } else {
                            ID = parts[0].replace("ID:", "");
                        }
                        System.out.println("ID: " + ID);
                    } else if (cont >= 5) {
                        if (!parts[0].isEmpty() && !parts[1].isEmpty()) {
                            Abreviatura = parts[0].replace("*", "");
                            if (parts[1].equals("<") || parts[1].equals(">")) {
                                Resultado = parts[1] + parts[2];
                            } else {
                                Resultado = parts[1];
                            }
                            TipoMuestra = "ORINA";
                            System.out.println("Abreviatura: " + Abreviatura);
                            System.out.println("Resultado: " + Resultado);
                            if (!Resultado.equals("Strip") && !Abreviatura.equals("RT")) {
                                mGrabar(Fecha + " " + Hora + ":00", ID.trim(), Abreviatura, Resultado);
                            }
                        }
                    } else {
                        i++;
                    }
                }
                i2++;
            }
            if (toProcess.contains("\u0002")) {
                Fecha = "";
                Hora = "";
                ID = "";
                cont = 1;
                NRegistro++;
                System.out.println("Registro No. " + NRegistro);
            }
            message.setLength(0);
            return;
        }
        message.append((char) b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isSelectraProXs(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString().replaceAll("\u0002", "").replaceAll("\u0003", "").replaceAll("\u0006", "");
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("O")) {
                        NMuestra = "";
                        if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        System.out.println(ID);
                    } else if (parts[0].contains("R")) {
                        String[] Subpart = parts[2].split("\\^");
                        TipoMuestra = "SUERO";
                        if (Subpart.length != 0) {
                            Abreviatura = Subpart[3];
                        }
                        Resultado = parts[3];
                        Unidad = parts[4];
                        Fecha = parts[12];
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        System.out.println(Unidad);
                        System.out.println(Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty()) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isWLCounter19(byte b) {
        if (message.length() == 2465) {
            String toProcess = message.toString().replaceAll("\u0016", "").replaceAll("\u0002", "").replaceAll("\u0012", "");
            System.out.println("Mesage------>" + toProcess);
            if (toProcess.substring(0, 1).equals("A")) {
                ID = toProcess.substring(11, 21).replaceFirst("^0*", "").replace("-", "");
                System.out.println("IdOrden: " + ID);
                Fecha = toProcess.substring(26, 30) + "-" + toProcess.substring(22, 24) + "-" + toProcess.substring(24, 26) + " " + toProcess.substring(30, 32) + ":" + toProcess.substring(32, 34) + ":00";
                System.out.println("Fecha: " + Fecha);
                if (ID.matches("^([0-9])*$")) {
                    Abreviatura = "WBC";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(34, 38)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Lymph#";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(38, 42)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Mid#";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(42, 46)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Gran#";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(46, 50)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Lymph%";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(50, 53)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Mid%";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(53, 56)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "Gran%";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(56, 59)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "RBC";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(59, 62)).doubleValue() / 100.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "HGB";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(62, 65)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "MCHC";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(65, 69)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "MCV";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(69, 73)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "MCH";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(73, 77)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "RDW-CV";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(77, 80)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "HCT";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(80, 83)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "PLT";
                    Resultado = Long.valueOf(toProcess.substring(83, 87)).toString();
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "MPV";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(87, 90)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "PDW";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(90, 93)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "PCT";
                    Resultado = "0." + toProcess.substring(93, 96);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                    Abreviatura = "RDW-SD";
                    Resultado = String.valueOf(Double.valueOf(toProcess.substring(96, 100)).doubleValue() / 10.0d);
                    System.out.println(Abreviatura + ": " + Resultado);
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append((int) b).append(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isDiruiFUS200(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        listID.add(parts[2]);
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("P")) {
                        NMuestra = "";
                        if (parts[3].contains(".")) {
                            ID = parts[3].split("\\.")[0];
                        } else if (parts[3].contains("-")) {
                            String[] pvalor = parts[3].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[3];
                        }
                        System.out.println(ID);
                    } else if (parts[0].contains("R")) {
                        Abreviatura = parts[2];
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            TipoMuestra = "Serum";
                        } else {
                            TipoMuestra = "SUERO";
                        }
                        if (parts[3].contains("^")) {
                            String[] Subpart = parts[3].split("\\^");
                            Resultado = Subpart[2];
                        } else {
                            Resultado = parts[3];
                        }
                        System.out.println(Abreviatura);
                        System.out.println(Resultado);
                        System.out.println(Unidad);
                        System.out.println(Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.equals("NEGATIVO") && !Resultado.equals("Negativo")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isAbacus380(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString().trim();
            System.out.println(toProcess);
            Metodos metodos = xmetodos;
            Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            cont++;
            if (cont == 11) {
                String[] Subpart = toProcess.trim().split("\t");
                if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                    if (Subpart[1].trim().matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                        String[] Subpart1 = Subpart[1].trim().split("[-a-zA-Z]+");
                        ID = Subpart1[0];
                        if (Subpart1.length == 2 && Subpart1[1].matches("^([0-9])*$")) {
                            NMuestra = Subpart1[1];
                        }
                    } else {
                        ID = Subpart[1];
                    }
                    TipoMuestra = "WBL";
                } else {
                    if (Subpart[1].trim().contains(".")) {
                        ID = Subpart[1].trim().split("\\.")[0];
                    } else if (Subpart[1].trim().contains("-")) {
                        String[] pvalor = Subpart[1].trim().split("\\-");
                        ID = pvalor[0];
                        NMuestra = pvalor[1];
                    } else {
                        ID = Subpart[1];
                    }
                    TipoMuestra = "SANGRE";
                }
            } else if (cont == 19) {
                Fecha = toProcess.split("\t")[1];
            } else if (cont == 20) {
                Fecha += toProcess.split("\t")[1];
                System.err.println("----->" + Fecha);
            } else if (cont >= 22 && cont <= 43) {
                if (toProcess.contains("\t")) {
                    String[] Subpart2 = toProcess.split("\t");
                    Abreviatura = Subpart2[0];
                    Resultado = Subpart2[2];
                }
                if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error")) {
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                }
            } else if (cont == 62) {
                Fecha = "";
                Hora = "";
                ID = "";
                cont = 0;
                NRegistro++;
                System.out.println("Registro No. " + NRegistro);
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isAutionEleven4020(byte b) {
        if ((b == 23 || b == 3) && message.length() > 0) {
            String toProcess = message.toString();
            cont++;
            if (!toProcess.startsWith("\u0002") && toProcess.contains("\u0002")) {
                toProcess = toProcess.substring(toProcess.indexOf("\u0002"), toProcess.length());
                Metodos metodos = xmetodos;
                Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            } else {
                Metodos metodos2 = xmetodos;
                Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            }
            if (cont == 1) {
                if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                    if (toProcess.substring(19, 32).trim().contains("L")) {
                        TipoMuestra = "Liquid";
                    } else {
                        TipoMuestra = "Urine";
                    }
                    if (toProcess.substring(19, 32).trim().matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                        String[] Subpart = toProcess.substring(19, 32).trim().split("[-a-zA-Z]+");
                        ID = Subpart[0];
                        if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                            NMuestra = Subpart[1];
                        }
                    } else {
                        ID = toProcess.substring(19, 32).trim();
                    }
                } else if (toProcess.substring(19, 32).trim().contains(".")) {
                    ID = toProcess.substring(19, 32).trim().split("\\.")[0];
                } else if (toProcess.substring(19, 32).trim().contains("-")) {
                    String[] pvalor = toProcess.substring(19, 32).trim().split("\\-");
                    ID = pvalor[0];
                    NMuestra = pvalor[1];
                } else {
                    ID = toProcess.substring(19, 32).trim();
                }
                Fecha = toProcess.substring(33, 37) + toProcess.substring(38, 40) + toProcess.substring(41, 43) + toProcess.substring(44, 46) + toProcess.substring(47, 49) + "00";
                System.out.println("IdMuestra: " + ID);
                System.out.println("Fecha: " + Fecha);
            }
            if (cont == 2) {
                int sum = 0;
                for (int i = 0; i < 6; i++) {
                    Abreviatura = toProcess.substring(0 + sum, 4 + sum).trim();
                    if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                        Resultado = toProcess.substring(8 + sum, 13 + sum).trim();
                        if (Resultado.isEmpty()) {
                            Resultado = toProcess.substring(14 + sum, 19 + sum).trim();
                        }
                    } else {
                        Resultado = toProcess.substring(8 + sum, 20 + sum).trim();
                    }
                    if ("NORMA".equals(Resultado)) {
                        Resultado = "NORMAL";
                    }
                    Unidad = toProcess.substring(20 + sum, 25 + sum).trim();
                    System.out.println("Abreviatura: " + Abreviatura);
                    System.out.println("Resultado: " + Resultado);
                    System.out.println("Unidad: " + Unidad);
                    sum += 25;
                    if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                    }
                    Abreviatura = "";
                    Resultado = "";
                    Unidad = "";
                }
            }
            if (cont == 3) {
                int sum2 = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    Abreviatura = toProcess.substring(0 + sum2, 4 + sum2).trim();
                    Resultado = toProcess.substring(8 + sum2, 13 + sum2).trim();
                    if (Resultado.isEmpty()) {
                        Resultado = toProcess.substring(14 + sum2, 19 + sum2).trim();
                        if ("NORMA".equals(Resultado)) {
                            Resultado = "NORMAL";
                        }
                    }
                    Unidad = toProcess.substring(20 + sum2, 25 + sum2).trim();
                    System.out.println("Abreviatura: " + Abreviatura);
                    System.out.println("Resultado: " + Resultado);
                    System.out.println("Unidad: " + Unidad);
                    sum2 += 25;
                    if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                    }
                    Abreviatura = "";
                    Resultado = "";
                    Unidad = "";
                }
            }
            if (cont == 4) {
                Abreviatura = "COLOR";
                Resultado = toProcess.substring(0, 40).trim();
                if (null != Resultado) {
                    switch (Resultado) {
                        case "COLORLESS":
                            Resultado = "INCOLORA";
                            break;
                        case "DARK BLUE":
                            Resultado = "AZUL OSCURO";
                            break;
                        case "LIGHT YELLOW":
                            Resultado = "AMARILLO CLARO";
                            break;
                        case "LIGHT VIOLET":
                            Resultado = "VIOLETA LIGERA";
                            break;
                        case "YELLOW":
                            Resultado = "AMARILLO";
                            break;
                        case "VIOLET":
                            Resultado = "VIOLETA";
                            break;
                        case "DARK YELLOW":
                            Resultado = "AMARILLO OSCURO";
                            break;
                        case "DARK VIOLET":
                            Resultado = "VIOLETA OSCURO";
                            break;
                        case "LIGHT ORANGE":
                            Resultado = "NARANJA CLARO";
                            break;
                        case "LIGHT RED":
                            Resultado = "LUZ ROJA";
                            break;
                        case "ORANGE":
                            Resultado = "NARANJA";
                            break;
                        case "RED":
                            Resultado = "ROJO";
                            break;
                        case "DARK ORANGE":
                            Resultado = "NARANJA OSCURO";
                            break;
                        case "DARK RED":
                            Resultado = "ROJO OSCURO";
                            break;
                        case "LIGHT GREEN":
                            Resultado = "VERDE CLARO";
                            break;
                        case "LIGHT BROWN":
                            Resultado = "MARRÓN CLARO";
                            break;
                        case "GREEN":
                            Resultado = "VERDE";
                            break;
                        case "BROWN":
                            Resultado = "MARRÓN";
                            break;
                        case "DARK GREEN":
                            Resultado = "VERDE OSCURO";
                            break;
                        case "DARK BROWN":
                            Resultado = "MARRÓN OSCURO";
                            break;
                        case "LIGHT BLUE":
                            Resultado = "AZUL CLARO";
                            break;
                        case "OTHER":
                            Resultado = "OTRO";
                            break;
                        case "BLUE":
                            Resultado = "AZUL";
                            break;
                    }
                }
                System.out.println("Abreviatura: " + Abreviatura);
                System.out.println("Resultado: " + Resultado);
                System.out.println("Unidad: " + Unidad);
                if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error")) {
                    mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                }
                Abreviatura = "";
                Resultado = "";
                Unidad = "";
                cont = 0;
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isSysmexkx_21N(byte b) {
        if (message.length() == 130) {
            String toProcess = message.toString();
            System.out.println("Mesage------>" + toProcess.replaceAll("\u0016", "").replaceAll("\u0002", "").replaceAll("\u0012", ""));
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append((int) b).append(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isAbacusJunior(byte b) {
        if (b == 10 && message.length() > 0) {
            String toProcess = message.toString().trim();
            System.out.println(toProcess);
            if (cont == 0) {
                Save = "\u0006";
            }
            cont++;
            if (cont == 1) {
                Save = "\u0006\u001a" + toProcess.substring(0, 1);
            } else if (cont == 2) {
                Fecha = toProcess.split("\t")[1];
            } else if (cont == 3) {
                Fecha += toProcess.split("\t")[1];
                System.out.println("Fecha: " + Fecha);
            } else if (cont == 4) {
                ID = toProcess.split("\t")[1];
                System.out.println("ID: " + ID);
            } else if (cont >= 20 && cont <= 39) {
                TipoMuestra = "SANGRE";
                if (toProcess.contains("\t")) {
                    String[] Subpart = toProcess.split("\t");
                    Abreviatura = Subpart[0];
                    Resultado = Subpart[1].trim();
                    System.out.println("Abreviatura: " + Abreviatura);
                    System.out.println("Resultado: " + Resultado);
                    if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error")) {
                        mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                    }
                }
                if (cont == 39) {
                    mEnvioPuertoSerial(Save);
                    Fecha = "";
                    Hora = "";
                    ID = "";
                    cont = 0;
                    NRegistro++;
                    mEnvioPuertoSerial("\u0006 D");
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isUnicelDXIAccess2(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            Metodos metodos = xmetodos;
            Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess.replace("\r", ""), JCBEquipos.getSelectedItem().toString(), 0);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        Fecha = parts[13];
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        System.out.println("Recepcion: " + parts[2].replace("^", ""));
                        listID.add(parts[2].replace("^", ""));
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O")) {
                        NMuestra = "";
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            if (parts[2].matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                                String[] Subpart = parts[2].split("[-a-zA-Z]+");
                                ID = Subpart[0];
                                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart[1];
                                }
                            } else {
                                ID = parts[2];
                            }
                        } else if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] pvalor = parts[2].split("\\-");
                            ID = pvalor[0];
                            NMuestra = pvalor[1];
                        } else {
                            ID = parts[2];
                        }
                        TipoMuestra = parts[15];
                        System.out.println("Tipo de Muestra: " + TipoMuestra);
                    } else if (parts[0].contains("R")) {
                        if (parts[2].contains("^")) {
                            Abreviatura = parts[2].split("\\^")[3];
                        } else {
                            Abreviatura = parts[2];
                        }
                        if (parts[3].contains("^")) {
                            Resultado = parts[3].split("\\^")[0];
                        } else {
                            Resultado = parts[3];
                        }
                        Unidad = parts[4];
                        System.out.println("IdMuestra: " + ID);
                        System.out.println("No. Trazabilidad: " + NMuestra);
                        System.out.println("Abreviatura: " + Abreviatura);
                        System.out.println("Resultado: " + Resultado);
                        System.out.println("Unidad: " + Unidad);
                        System.out.println("TipoMuestra: " + TipoMuestra);
                        System.out.println("Fecha: " + Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.equals("NEGATIVO") && !Resultado.equals("Negativo") && NMuestra.length() <= 2) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isUnicelDXH800(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            Metodos metodos = xmetodos;
            Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        System.out.println("Recepcion: " + parts[2].replace("^", ""));
                        listID.add(parts[2].replace("!", ""));
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O")) {
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            if (parts[2].matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                                String[] Subpart = parts[2].split("[-a-zA-Z]+");
                                ID = Subpart[0];
                                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart[1];
                                }
                            } else {
                                ID = parts[2];
                            }
                            TipoMuestra = "WBL";
                        } else {
                            if (parts[2].contains("!")) {
                                ID = parts[2].split("\\!")[0];
                            } else if (parts[2].contains("-")) {
                                String[] Subpart2 = parts[2].split("\\-");
                                ID = Subpart2[0];
                                if (Subpart2.length == 2 && Subpart2[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart2[1];
                                }
                            } else {
                                ID = parts[2];
                            }
                            TipoMuestra = "SANGRE";
                        }
                    } else if (parts[0].contains("R")) {
                        Abreviatura = parts[2].split("\\!")[3];
                        Resultado = parts[3].split("\\!")[0];
                        if (parts[6].contains("to")) {
                            String[] Subpart3 = parts[6].split("to");
                            Min = Subpart3[0].trim();
                            Max = Subpart3[1].trim();
                        } else {
                            Min = "";
                            Max = "";
                        }
                        Fecha = parts[13];
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.equals("NEGATIVO") && !Resultado.equals("Negativo") && !Resultado.equals("=====") && NMuestra.length() <= 2) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else {
                        NMuestra = "";
                        if (flag == 1) {
                            flag = 2;
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isUrit3010(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("MSH") || parts[0].contains("PID")) {
                        break;
                    }
                    if (parts[0].contains("OBR")) {
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            if (parts[3].matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                                String[] Subpart = parts[3].split("[-a-zA-Z]+");
                                ID = Subpart[0].replaceFirst("^0+(?!$)", "");
                                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart[1];
                                }
                            } else {
                                ID = parts[3].replaceFirst("^0+(?!$)", "");
                            }
                            TipoMuestra = "WBL";
                        } else {
                            if (parts[3].contains("!")) {
                                ID = parts[3].split("\\!")[0].replaceFirst("^0+(?!$)", "");
                            } else if (parts[3].contains("-")) {
                                String[] Subpart2 = parts[3].split("\\-");
                                ID = Subpart2[0].replaceFirst("^0+(?!$)", "");
                                if (Subpart2.length == 2 && Subpart2[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart2[1];
                                }
                            } else {
                                ID = parts[3].replaceFirst("^0+(?!$)", "");
                            }
                            TipoMuestra = "SANGRE";
                        }
                        Fecha = parts[7];
                    } else if (!parts[0].contains("OBX") || !parts[2].contains("NM")) {
                        i++;
                    } else {
                        Abreviatura = parts[3];
                        Resultado = parts[5];
                        if (parts[7].contains("-")) {
                            String[] Subpart3 = parts[7].split("\\-");
                            Min = Subpart3[0].trim();
                            Max = Subpart3[1].trim();
                        } else {
                            Min = "";
                            Max = "";
                        }
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.equals("NEGATIVO") && !Resultado.equals("Negativo") && !Resultado.equals("=====")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append((int) b).append(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isUritPkl125(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        System.out.println("Recepcion: " + parts[2].replace("^", ""));
                        listID.add(parts[2].replace("^", ""));
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("P")) {
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            if (parts[3].matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                                String[] Subpart = parts[3].split("[-a-zA-Z]+");
                                ID = Subpart[0];
                                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart[1];
                                }
                            } else {
                                ID = parts[3];
                            }
                        } else if (parts[3].contains(".")) {
                            ID = parts[3].split("\\.")[0];
                        } else if (parts[3].contains("-")) {
                            String[] Subpart2 = parts[3].split("\\-");
                            ID = Subpart2[0];
                            if (Subpart2.length == 2 && Subpart2[1].matches("^([0-9])*$")) {
                                NMuestra = Subpart2[1];
                            }
                        } else {
                            ID = parts[3];
                        }
                    } else if (parts[0].contains("O")) {
                        if (!parts[7].isEmpty()) {
                            Fecha = parts[7];
                            if (parts[6].equals("S")) {
                                TipoMuestra = "Serum";
                            } else if (parts[6].equals("U")) {
                                TipoMuestra = "Urine";
                            } else {
                                TipoMuestra = "WBL";
                            }
                        } else {
                            Fecha = parts[6];
                            if (parts[5].equals("S")) {
                                TipoMuestra = "Serum";
                            } else if (parts[5].equals("U")) {
                                TipoMuestra = "Urine";
                            } else {
                                TipoMuestra = "WBL";
                            }
                        }
                    } else if (parts[0].contains("R")) {
                        String[] Subpart3 = parts[2].split("\\^");
                        if (!Subpart3[1].isEmpty()) {
                            Abreviatura = Subpart3[1];
                        } else {
                            Abreviatura = Subpart3[3];
                        }
                        Resultado = parts[3];
                        Unidad = parts[4];
                        if (parts[5].contains("^")) {
                            String[] Subpart4 = parts[5].split("\\^");
                            Min = Subpart4[0].trim();
                            Max = Subpart4[1].trim();
                        } else {
                            Min = "";
                            Max = "";
                        }
                        System.out.println("No. Recepcion: " + ID);
                        System.out.println("Tipo de Muestra: " + TipoMuestra);
                        System.out.println("Examen: " + Abreviatura);
                        System.out.println("Resultado: " + Resultado);
                        System.out.println("Unidad: " + Unidad);
                        System.out.println("Min: " + Min);
                        System.out.println("Max: " + Max);
                        System.out.println("Fecha: " + Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.equals("NEGATIVO") && !Resultado.equals("Negativo") && !Resultado.equals("=====")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else {
                        ID = "";
                        NMuestra = "";
                        if (flag == 1) {
                            flag = 2;
                        }
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isACLElitePRO(byte b) {
        if (b == 13 && message.length() > 0) {
            String toProcess = message.toString();
            System.out.println(toProcess);
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (toProcess.contains("|")) {
                String[] parts = message.toString().trim().split("\\|");
                int length = parts.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = parts[i];
                    if (parts[0].contains("H")) {
                        break;
                    }
                    if (parts[0].contains("Q")) {
                        System.out.println("Recepcion: " + parts[2].replace("^", ""));
                        listID.add(parts[2].replace("^", ""));
                        flag = 1;
                        break;
                    }
                    if (parts[0].contains("O")) {
                        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            if (parts[2].matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                                String[] Subpart = parts[2].split("[-a-zA-Z]+");
                                ID = Subpart[0];
                                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                                    NMuestra = Subpart[1];
                                }
                            } else {
                                ID = parts[2];
                            }
                        } else if (parts[2].contains(".")) {
                            ID = parts[2].split("\\.")[0];
                        } else if (parts[2].contains("-")) {
                            String[] Subpart2 = parts[2].split("\\-");
                            ID = Subpart2[0];
                            if (Subpart2.length == 2 && Subpart2[1].matches("^([0-9])*$")) {
                                NMuestra = Subpart2[1];
                            }
                        } else {
                            ID = parts[2];
                        }
                    } else if (parts[0].contains("R")) {
                        Abreviatura = parts[2].split("\\^")[3];
                        Resultado = parts[3];
                        Unidad = parts[4];
                        Fecha = parts[12];
                        TipoMuestra = "Serum";
                        System.out.println("No. Recepcion: " + ID);
                        System.out.println("Tipo de Muestra: " + TipoMuestra);
                        System.out.println("Examen: " + Abreviatura);
                        System.out.println("Resultado: " + Resultado);
                        System.out.println("Unidad: " + Unidad);
                        System.out.println("Min: " + Min);
                        System.out.println("Max: " + Max);
                        System.out.println("Fecha: " + Fecha);
                        if (ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.isEmpty() && !Resultado.contains("Err.")) {
                            mGrabar(Fecha, ID, Abreviatura.trim(), Resultado);
                        }
                    } else if (!parts[0].contains("L")) {
                        i++;
                    } else if (flag == 1) {
                        flag = 2;
                    }
                }
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append(((int) b) + " ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isAU480(byte b) {
        int A1;
        int A2;
        int B1;
        int B2;
        if (b == 3 && message.length() > 0) {
            String toProcess = message.toString().replace("\u0002", "").replace("\u0006", "").replace("\u0015", "");
            System.out.println(toProcess);
            Metodos metodos = xmetodos;
            Metodos.Registros("Analizador " + JCBEquipos.getSelectedItem().toString() + " envia a LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            if (toProcess.length() < 3) {
                if (toProcess.contains("RE") && flag == 3) {
                    flag = 0;
                }
            } else if (toProcess.length() > 10) {
                if ("R ".equals(toProcess.substring(0, 2)) || "RH".equals(toProcess.substring(0, 2))) {
                    listID.add(toProcess.substring(13, 39).trim());
                    EnviOrden = "\u0002S" + toProcess.substring(1, toProcess.length()) + "    E";
                    mConsultarProtocolosV6(listID);
                    flag = 2;
                } else if (toProcess.length() > 40) {
                    condicionOrdenStiker(toProcess.substring(13, 39));
                    cont = (toProcess.length() - 51) / 9;
                    System.out.println("Tamano: " + toProcess.length());
                    System.out.println("Calculo Dinamico: " + cont);
                    Fecha = xmetodos.formatoAMDH24_1.format(xmetodos.getFechaActual());
                    if (toProcess.substring(13, 39).trim().endsWith("P")) {
                        TipoMuestra = "Plasma";
                    } else if ("U".equals(toProcess.substring(8, 9))) {
                        TipoMuestra = "Urine";
                    } else if ("W".equals(toProcess.substring(8, 9))) {
                        TipoMuestra = "WBL";
                    } else if ("X".equals(toProcess.substring(8, 9))) {
                        TipoMuestra = "Liquid";
                    } else {
                        TipoMuestra = "Serum";
                    }
                    System.out.println("Tipo de Muestra: " + TipoMuestra);
                    int sum = 0;
                    if (toProcess.substring(13, 39).trim().equals(Save) || "DH".equals(toProcess.substring(0, 2))) {
                        A1 = 44;
                        A2 = 47;
                        B1 = 47;
                        B2 = 53;
                    } else {
                        A1 = 50;
                        A2 = 53;
                        B1 = 53;
                        B2 = 59;
                    }
                    for (int i = 0; i < cont; i++) {
                        try {
                            Abreviatura = toProcess.substring(A1 + sum, A2 + sum).trim();
                            Resultado = toProcess.substring(B1 + sum, B2 + sum).trim();
                            System.out.println("Abreviatura: " + Abreviatura);
                            System.out.println("Resultado: " + Resultado);
                            System.out.println("Unidad: " + Unidad);
                            sum += 11;
                            if (!ID.isEmpty() && ID.matches("^([0-9])*$") && !Abreviatura.isEmpty() && !Resultado.equals("error") && !Resultado.isEmpty()) {
                                mGrabar(Fecha, ID, Abreviatura.trim(), Resultado.trim());
                            }
                            Abreviatura = "";
                            Resultado = "";
                            Unidad = "";
                        } catch (StringIndexOutOfBoundsException e) {
                        }
                    }
                }
                Save = toProcess.substring(13, 39).trim();
                ID = "";
                NMuestra = "";
            }
            message.setLength(0);
            bytemessage.setLength(0);
            return;
        }
        message.append((char) b);
        bytemessage.append((int) b).append(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void isDiruiH500(byte b) {
        if (b == 10 && message.length() > 0) {
            cont++;
            String toProcess = message.toString();
            String[] parts = message.toString().trim().split("\\s+");
            Metodos metodos = xmetodos;
            Metodos.Registros(JCBEquipos.getSelectedItem().toString() + " ---> LIS: " + toProcess, JCBEquipos.getSelectedItem().toString(), 0);
            int i = 0;
            int length = parts.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                String texto = parts[i2];
                if (!texto.contains("\u001c")) {
                    if (cont == 2) {
                        Fecha = parts[0].replace("Date:", "");
                        Hora = parts[1];
                        break;
                    }
                    if (cont == 4) {
                        ID = parts[0].replace("ID:", "").replaceAll("-", "");
                        System.out.println("ID: :" + ID);
                        break;
                    }
                    if (cont > 5) {
                        if (parts.length >= 2 && !parts[0].isEmpty() && !parts[1].isEmpty()) {
                            Abreviatura = parts[0].replace("*", "");
                            Resultado = parts[1];
                            if (Resultado.contains("Neg")) {
                                Resultado = Resultado.replace("Neg", "Negativo");
                            } else if (Resultado.contains("Pos")) {
                                Resultado = Resultado.replace("Pos", "Positivo");
                            } else if (Resultado.contains("+-")) {
                                Resultado = Resultado.replace("+-", "Trazas");
                            } else if (Resultado.contains("1+")) {
                                Resultado = Resultado.replace("1+", "+");
                            } else if (Resultado.contains("2+")) {
                                Resultado = Resultado.replace("2+", "++");
                            } else if (Resultado.contains("3+")) {
                                Resultado = Resultado.replace("3+", "+++");
                            } else if (Resultado.contains("4+")) {
                                Resultado = Resultado.replace("4+", "++++");
                            }
                            TipoMuestra = "ORINA";
                            if (!ID.isEmpty() && ID.matches("^([0-9])*$") && !Resultado.contains("Strip")) {
                                mGrabar(Fecha + " " + Hora + ":00", ID.trim(), Abreviatura, Resultado);
                            }
                        }
                    } else {
                        i++;
                    }
                }
                i2++;
            }
            if (toProcess.contains("\u0002") || toProcess.contains("ONLINE")) {
                Fecha = "";
                Hora = "";
                ID = "";
                cont = 1;
                NRegistro++;
            }
            message.setLength(0);
            return;
        }
        message.append((char) b);
    }

    private static void condicionOrdenStiker(String Orden) {
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
            if (Orden.trim().matches("^([\\d]+)([-a-zA-Z]+)([\\d]+)*$")) {
                String[] Subpart = Orden.trim().split("[-a-zA-Z]+");
                ID = Subpart[0];
                if (Subpart.length == 2 && Subpart[1].matches("^([0-9])*$")) {
                    NMuestra = Subpart[1].trim();
                }
            } else {
                ID = Orden.trim();
            }
        } else if (Orden.trim().contains(".")) {
            ID = Orden.trim().split("\\.")[0];
        } else if (Orden.trim().contains("-")) {
            String[] pvalor = Orden.trim().split("\\-");
            ID = pvalor[0];
            NMuestra = pvalor[1].trim();
        } else {
            ID = Orden.trim();
        }
        System.out.println("Recepcion: " + ID);
        System.out.println("Orden: " + NMuestra);
    }

    private static boolean isFloat(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void mGrabar(String fecha, String idRecepcion, String Abreviatura2, String Resultado2) {
        if (JCBEquipos.getSelectedItem().equals("MEK-6410J")) {
            TipoMuestra = "SANGRE";
            if (Abreviatura2.equals("WBC")) {
                double valor = Math.ceil(Double.valueOf(Resultado2).doubleValue() * Math.pow(10.0d, 3.0d));
                Resultado2 = String.valueOf(valor).replace(".0", "");
            } else if (Abreviatura2.equals("RBC")) {
                double valor2 = Math.ceil(Double.valueOf(Resultado2).doubleValue() * Math.pow(10.0d, 6.0d));
                Resultado2 = String.valueOf(valor2).replace(".0", "");
            } else if (Abreviatura2.equals("PLT")) {
                double valor3 = Math.ceil(Double.valueOf(Resultado2).doubleValue() * Math.pow(10.0d, 3.0d));
                Resultado2 = String.valueOf(valor3).replace(".0", "");
            }
            Abreviatura = Abreviatura2;
            if (mValidarExamen().booleanValue()) {
                if (!Resultado2.isEmpty() && !Resultado2.equals("") && !Resultado2.equals("\n")) {
                    xImplLabotaorio.addResultadoInterfaz(idRecepcion.trim(), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2.trim(), Unidad, Min, Max, "20" + fecha.replace("\\", "-"), TipoMuestra, 1);
                }
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2.trim(), "20" + fecha.replace("\\", "-"), idRecepcion.trim(), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("HA-22 TOUCH")) {
            TipoMuestra = "SANGRE";
            if (Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                if (Abreviatura2.equals("WBC")) {
                    double valor4 = Math.ceil(Double.valueOf(Resultado2.trim().replace("H", "")).doubleValue() * Math.pow(10.0d, 3.0d));
                    Resultado2 = String.valueOf(valor4).replace(".0", "");
                } else if (Abreviatura2.equals("RBC")) {
                    double valor5 = Math.ceil(Double.valueOf(Resultado2.trim()).doubleValue() * Math.pow(10.0d, 6.0d));
                    Resultado2 = String.valueOf(valor5).replace(".0", "");
                } else if (Abreviatura2.equals("PLT")) {
                    double valor6 = Math.ceil(Double.valueOf(Resultado2.trim()).doubleValue() * Math.pow(10.0d, 3.0d));
                    Resultado2 = String.valueOf(valor6).replace(".0", "");
                }
            }
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion.trim(), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2.trim(), Unidad, Min, Max, fecha, TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2.trim(), fecha, idRecepcion.trim(), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("DIRUI H-800")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion.trim(), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2.trim(), Unidad, Min, Max, fecha, TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2.trim(), fecha, idRecepcion.trim(), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("CB400I")) {
            if (Abreviatura2.equals("GLUL") || Abreviatura2.equals("COLL") || Abreviatura2.equals("TGL") || Abreviatura2.equals("URE") || Abreviatura2.equals("BI") || Abreviatura2.equals("HDLP")) {
                double valor7 = Math.round(Double.valueOf(Resultado2).doubleValue());
                String[] Subpart = String.valueOf(valor7).split("\\.");
                Resultado2 = Subpart[0];
            }
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion.replaceFirst("^0*", ""), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, fecha, TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, fecha, idRecepcion.replaceFirst("^0*", ""), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("ARCHITECT I1000SR")) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") && isFloat(Resultado2)) {
                Resultado2 = String.format("%.2f", Float.valueOf(Float.parseFloat(Resultado2)));
            }
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("COBAS E411")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("COBAS C311")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("SYMEX XP-300")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("STA SATELLITE")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("LIAISON")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("HA-8380V")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("LABPRO")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha + "000000"), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha + "000000"), idRecepcion.replaceFirst("^0*", ""), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("DYNEX DS2")) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") && isFloat(Resultado2)) {
                Resultado2 = String.format("%.2f", Float.valueOf(Float.parseFloat(Resultado2)));
            }
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("DIRUI H-100")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, fecha, TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, fecha, idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("WL COUNTER 19")) {
            TipoMuestra = "SANGRE";
            Abreviatura = Abreviatura2;
            if (mValidarExamen().booleanValue()) {
                if (!Resultado2.isEmpty() && !Resultado2.equals("") && !Resultado2.equals("\n")) {
                    xImplLabotaorio.addResultadoInterfaz(idRecepcion.trim(), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2.trim(), Unidad, Min, Max, fecha, TipoMuestra, 1);
                }
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2.trim(), fecha, idRecepcion.trim(), TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("DIRUI FUS-200")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("ABACUS 380")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("AUTION ELEVEN 4020")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("ABACUS JUNIOR")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("UNICEL DXI ACCESS 2")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("UNICEL DXH 800")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("URIT 3010")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("URIT PKL 125")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFechaV2(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFechaV2(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("ACL ELITE PRO")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, getFormatoFecha(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, getFormatoFecha(fecha), idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("AU480")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion, JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2, Unidad, Min, Max, fecha, TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2, fecha, idRecepcion, TipoMuestra, NMuestra, Abreviatura2);
            }
        } else if (JCBEquipos.getSelectedItem().equals("DIRUI H-500")) {
            if (mValidarExamen().booleanValue()) {
                xImplLabotaorio.addResultadoInterfaz(idRecepcion.trim(), JCBEquipos.getSelectedItem().toString(), NMuestra, Abreviatura2, Resultado2.trim(), Unidad, Min, Max, getFormatoFechaV3(fecha), TipoMuestra, 1);
            } else {
                xImplLabotaorio.mUpdateResultadoInterfaz(Resultado2.trim(), getFormatoFechaV3(fecha), idRecepcion.trim(), TipoMuestra, NMuestra, Abreviatura2);
            }
        }
        Unidad = "";
    }

    private static Boolean mValidarExamen() {
        Boolean validacion;
        List<Object[]> list = xImplLabotaorio.listExistenciaResultadoInterfaz(ID.trim(), NMuestra, Abreviatura.trim(), TipoMuestra.trim(), Unidad);
        if (!list.isEmpty() && list.size() != -1) {
            validacion = false;
        } else {
            validacion = true;
        }
        return validacion;
    }

    private static String getFormatoFecha(String concatenado) {
        String segundo;
        String ano = concatenado.substring(0, 4);
        String mes = concatenado.substring(4, 6);
        String dia = concatenado.substring(6, 8);
        String hora = concatenado.substring(8, 10);
        String minuto = concatenado.substring(10, 12);
        if (concatenado.length() == 14) {
            segundo = concatenado.substring(12, 14);
        } else {
            segundo = "00";
        }
        return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
    }

    private static String getFormatoFechaV2(String concatenado) {
        String segundo;
        String ano = concatenado.substring(0, 4);
        String dia = concatenado.substring(4, 6);
        String mes = concatenado.substring(6, 8);
        String hora = concatenado.substring(8, 10);
        String minuto = concatenado.substring(10, 12);
        if (concatenado.length() == 14) {
            segundo = concatenado.substring(12, 14);
        } else {
            segundo = "00";
        }
        return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
    }

    private static String getFormatoFechaV3(String concatenado) {
        String segundo;
        String dia = concatenado.substring(0, 2);
        String mes = concatenado.substring(3, 5);
        String ano = concatenado.substring(6, 10);
        String hora = concatenado.substring(11, 13);
        String minuto = concatenado.substring(14, 16);
        if (concatenado.length() == 19) {
            segundo = concatenado.substring(17, 19);
        } else {
            segundo = "00";
        }
        return ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + segundo;
    }

    private static String mRemplazar(String resultado) {
        String NResultado = resultado.replaceAll("(H|L|!|F1|F2|F3|F4|F5)", "");
        return NResultado;
    }

    public static String ObtenerProtocolo(int pos, String Analizador) {
        String Protocolo = null;
        if (Analizador.equals(Integer.valueOf(pos))) {
            switch (pos) {
                case 1:
                    Protocolo = "Fecha";
                    break;
                case 2:
                    Protocolo = "ID";
                    break;
                case 3:
                    Protocolo = "WBC";
                    break;
                case 4:
                    Protocolo = "LY%";
                    break;
                case 5:
                    Protocolo = "MO%";
                    break;
                case 6:
                    Protocolo = "GR%";
                    break;
                case 7:
                    Protocolo = "LY";
                    break;
                case 8:
                    Protocolo = "MO";
                    break;
                case 9:
                    Protocolo = "GR";
                    break;
                case 10:
                    Protocolo = "RBC";
                    break;
                case 11:
                    Protocolo = "HGB";
                    break;
                case 12:
                    Protocolo = "HCT";
                    break;
                case 13:
                    Protocolo = "MCV";
                    break;
                case 14:
                    Protocolo = "MCH";
                    break;
                case 15:
                    Protocolo = "MCHC";
                    break;
                case 16:
                    Protocolo = "RDW";
                    break;
                case 17:
                    Protocolo = "PLT";
                    break;
                case 18:
                    Protocolo = "PCT";
                    break;
                case 19:
                    Protocolo = "MPV";
                    break;
                case 20:
                    Protocolo = "PDW";
                    break;
            }
        } else if (Analizador.equals("WL COUNTER 19")) {
            switch (pos) {
                case 14:
                    Protocolo = "WBC";
                    break;
                case 15:
                    Protocolo = "Lymph#";
                    break;
                case 16:
                    Protocolo = "Mid#";
                    break;
                case 17:
                    Protocolo = "Gran#";
                    break;
                case 18:
                    Protocolo = "Lymph%";
                    break;
                case 19:
                    Protocolo = "Mid%";
                    break;
                case 20:
                    Protocolo = "Gran%";
                    break;
                case 21:
                    Protocolo = "RBC";
                    break;
                case 22:
                    Protocolo = "HGB";
                    break;
                case 23:
                    Protocolo = "MCHC";
                    break;
                case 24:
                    Protocolo = "MCV";
                    break;
                case 25:
                    Protocolo = "MCH";
                    break;
                case 26:
                    Protocolo = "RDW-CV";
                    break;
                case 27:
                    Protocolo = "HCT";
                    break;
                case 28:
                    Protocolo = "PLT";
                    break;
                case 29:
                    Protocolo = "MPV";
                    break;
                case 30:
                    Protocolo = "PDW";
                    break;
                case 31:
                    Protocolo = "PCT";
                    break;
                case 32:
                    Protocolo = "RDW-SD";
                    break;
            }
        }
        return Protocolo;
    }

    public static void iniciarComunicacion() {
        try {
            seleccionPuerto = xequipos[JCBEquipos.getSelectedIndex()][1];
            System.out.println("Conexion Inicializada en puerto " + seleccionPuerto + "\n");
            Metodos metodos = xmetodos;
            Metodos.Registros("Conexion Inicializada en puerto " + seleccionPuerto + "\n", JCBEquipos.getSelectedItem().toString(), 0);
            puerto = new SerialPort(seleccionPuerto);
            puerto.openPort();
            puerto.setParams(rateBaund, dataBit, stopBit, parity);
            mascara = 1;
            puerto.setEventsMask(mascara);
            puerto.addEventListener(new EntradaSerial());
            if (JCBEquipos.getSelectedItem().equals("CB400I")) {
                mEnvioPuertoSerial("\u0002\u0004");
            }
        } catch (SerialPortException ex) {
            JOptionPane.showMessageDialog((Component) null, "Se produjo un error al momento de conectar al puerto de esta Maquina de Laboratorio", "VERIFICAR", 0);
            logExepciones(ex);
        }
    }

    public static void mEnvioPuertoSerial(String xmensaje) {
        try {
            puerto.writeString(xmensaje);
            Metodos metodos = xmetodos;
            Metodos.Registros("LIS envia a Analizador " + JCBEquipos.getSelectedItem().toString() + ": " + xmensaje.replaceAll("\r", ""), JCBEquipos.getSelectedItem().toString(), 0);
            System.out.println(" SE ENVIA: " + xmensaje);
        } catch (SerialPortException ex) {
            logExepciones(ex);
        }
    }

    public static Boolean mVerificarConexionPuerto() {
        boolean validacion = false;
        if (puerto != null && puerto.isOpened()) {
            validacion = true;
        }
        return Boolean.valueOf(validacion);
    }

    public static void cerrarPuerto() {
        for (int i = 0; i < xvector.size(); i++) {
            try {
                System.out.println(xvector.size());
                System.out.println(xvector.get(i));
            } catch (SerialPortException ex) {
                logExepciones(ex);
                return;
            }
        }
        puerto.closePort();
        puerto = null;
        Metodos metodos = xmetodos;
        Metodos.Registros("Se Cerro Exitosamente La Comunicacion", JCBEquipos.getSelectedItem().toString(), 0);
    }

    public static void listarPuertos() {
        puertosActuales = SerialPortList.getPortNames();
        if (puertosActuales.length == 0) {
            conectarBtn.setEnabled(false);
            System.out.println("No existen lista de Puertos serie disponibles en el sistema");
        }
        System.out.println("----> " + puertosActuales[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV2(String idRecepcion) {
        String test = "";
        xNoFrame = 0L;
        mEnvioPuertoSerial("\u0005");
        String fecha = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
        String msg = "H|\\^&|||99^2.00|||||||P|1.00|" + fecha;
        mVerificarCaracteres(msg);
        List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), idRecepcion);
        if (list.size() > 0) {
            mVerificarCaracteres("P|1|||^^^^");
            for (int x = 0; x < list.size(); x++) {
                test = test + "^^^" + list.get(x)[1].toString() + "\\";
            }
        }
        if (!test.isEmpty()) {
            String msg2 = "O|1|" + idRecepcion + "||" + test.substring(0, test.length() - 1) + "|R";
            mVerificarCaracteres(msg2);
        }
        mVerificarCaracteres("L|1|N");
        mEnvioPuertoSerial("\u0004");
        flag = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV3(Vector listaidRecepcion) {
        long xc1 = 1;
        xNoFrame = 0L;
        mEnvioPuertoSerial("\u0005");
        String fecha = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
        String msg = "H|\\^&|||Genoma|||||||P||" + fecha;
        mVerificarCaracteres(msg);
        for (int i = 0; i < listaidRecepcion.size(); i++) {
            List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
            if (list.size() > 0) {
                String msg2 = "P|" + xc1 + "|||||||U||||||||||||||||||";
                mVerificarCaracteres(msg2);
                long xc2 = 1;
                for (int x = 0; x < list.size(); x++) {
                    String msg3 = "O|" + xc2 + "|" + listaidRecepcion.get(i) + "||^^^" + list.get(x)[1].toString() + "|R";
                    mVerificarCaracteres(msg3);
                    xc2++;
                }
                xc1++;
            }
        }
        mVerificarCaracteres("L|1|N");
        mEnvioPuertoSerial("\u0004");
        flag = 0;
        listID.removeAllElements();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV4(Vector listaidRecepcion) {
        long xc1 = 1;
        xNoFrame = 0L;
        mEnvioPuertoSerial("\u0005");
        String fecha = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
        String msg = "H|\\^&|||GENOMA||||||||1|" + fecha + "|";
        mVerificarCaracteres(msg);
        for (int i = 0; i < listaidRecepcion.size(); i++) {
            List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
            if (list.size() > 0) {
                String msg2 = "\rP|" + xc1 + "|" + list.get(0)[3].toString() + "|" + listaidRecepcion.get(i) + "||" + list.get(0)[4].toString() + "^" + list.get(0)[5].toString() + "||" + list.get(0)[6].toString() + "||||||||||||||||||";
                mVerificarCaracteres(msg2);
                long xc2 = 1;
                for (int x = 0; x < list.size(); x++) {
                    String fecha2 = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
                    String msg3 = "\rO|" + xc2 + "|" + listaidRecepcion.get(i) + "||^^^" + list.get(x)[1].toString() + "|R|" + fecha2;
                    mVerificarCaracteres(msg3);
                    xc2++;
                }
                xc1++;
            }
        }
        mVerificarCaracteres("\rL|1|N");
        mEnvioPuertoSerial("\u0004");
        flag = 0;
        listID.removeAllElements();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV5(Vector listaidRecepcion) {
        try {
            long xc1 = 1;
            xNoFrame = 0L;
            mEnvioPuertoSerial("\u0005");
            Thread.sleep(3000L);
            String fecha = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
            String msg = "H|\\^&|||LIS|||||||P|1|" + fecha + "\r";
            mVerificarCaracteres(msg);
            for (int i = 0; i < listaidRecepcion.size(); i++) {
                List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
                if (list.size() > 0) {
                    String msg2 = "P|" + xc1 + "|" + list.get(0)[3].toString() + "|||" + list.get(0)[5].toString() + "^" + list.get(0)[4].toString() + "^^^^||" + list.get(0)[6].toString() + "|" + list.get(0)[7].toString() + "||\r";
                    mVerificarCaracteres(msg2);
                    long xc2 = 1;
                    for (int x = 0; x < list.size(); x++) {
                        xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
                        String msg3 = "O|" + xc2 + "|" + listaidRecepcion.get(i) + "||^^^" + list.get(x)[1].toString() + "|R||||||A||||Serum\r";
                        mVerificarCaracteres(msg3);
                        xc2++;
                    }
                    xc1++;
                }
            }
            mVerificarCaracteres("L|1|F\r");
            mEnvioPuertoSerial("\u0004");
            flag = 0;
            listID.removeAllElements();
        } catch (InterruptedException ex) {
            logExepciones(ex);
        }
    }

    private static void mConsultarProtocolosV6(Vector listaidRecepcion) {
        String msg = "";
        for (int i = 0; i < listaidRecepcion.size(); i++) {
            List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
            if (list.size() > 0) {
                for (int x = 0; x < list.size(); x++) {
                    msg = msg + list.get(x)[1].toString() + "0";
                }
                StringBuilder sb = new StringBuilder(EnviOrden);
                if ("Serum".equals(list.get(0)[2].toString()) || "Plasma".equals(list.get(0)[2].toString())) {
                    sb.setCharAt(9, ' ');
                } else if ("Urine".equals(list.get(0)[2].toString())) {
                    sb.setCharAt(9, 'U');
                } else if ("WBL".equals(list.get(0)[2].toString())) {
                    sb.setCharAt(9, 'W');
                } else {
                    sb.setCharAt(9, 'X');
                }
                mEnvioPuertoSerial(sb.toString() + "0     " + msg + "\u0003");
            }
        }
        listID.removeAllElements();
        EnviOrden = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV7(Vector listaidRecepcion) {
        try {
            long xc1 = 1;
            xNoFrame = 0L;
            mEnvioPuertoSerial("\u0005");
            Thread.sleep(3000L);
            xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
            mVerificarCaracteres("H|\\!~|||LISHOST|||||||P|1|\r");
            for (int i = 0; i < listaidRecepcion.size(); i++) {
                List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
                if (list.size() > 0) {
                    String msg = "P|" + xc1 + "||" + list.get(0)[3].toString() + "||" + String.format("%-20s", list.get(0)[5].toString().trim()).substring(0, 19).replace((char) 209, 'N') + "!" + String.format("%-20s", list.get(0)[4].toString().trim()).substring(0, 19).replace((char) 209, 'N') + "!||" + list.get(0)[6].toString() + "|" + list.get(0)[7].toString() + "|||||||||||||||||\r";
                    mVerificarCaracteres(msg);
                    HashSet hs = new HashSet();
                    for (int x = 0; x < list.size(); x++) {
                        hs.add(list.get(x)[8].toString());
                    }
                    ArrayList listUnicos = new ArrayList();
                    listUnicos.addAll(hs);
                    if (listUnicos.size() == 1) {
                        String msg2 = "O|1|" + listaidRecepcion.get(i) + "||!!!" + listUnicos.get(0) + "|R||||||N||||Whole blood\r";
                        mVerificarCaracteres(msg2);
                        long j = 1 + 1;
                    } else if (listUnicos.size() > 1) {
                        if (listUnicos.contains("RETIC")) {
                            String msg3 = "O|1|" + listaidRecepcion.get(i) + "||!!!CDR|R||||||N||||Whole blood\r";
                            mVerificarCaracteres(msg3);
                            long j2 = 1 + 1;
                        } else {
                            String msg4 = "O|1|" + listaidRecepcion.get(i) + "||!!!CD|R||||||N||||Whole blood\r";
                            mVerificarCaracteres(msg4);
                            long j3 = 1 + 1;
                        }
                    }
                    xc1++;
                }
            }
            mVerificarCaracteres("L|1|F\r");
            mEnvioPuertoSerial("\u0004");
            flag = 0;
            listID.removeAllElements();
        } catch (InterruptedException ex) {
            logExepciones(ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mConsultarProtocolosV8(Vector listaidRecepcion) {
        try {
            long xc1 = 1;
            xNoFrame = 0L;
            mEnvioPuertoSerial("\u0005");
            Thread.sleep(3000L);
            String fecha = xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual());
            String msg = "H|\\^&||||||||ACL9000-01||P|1|" + fecha;
            mVerificarCaracteres(msg);
            for (int i = 0; i < listaidRecepcion.size(); i++) {
                List<Object[]> list = xImplLabotaorio.listConsultaInterfaz(JCBEquipos.getSelectedItem().toString(), xmetodos.formatoANO_MES.format(Long.valueOf(xmetodos.getObtenerMesAnterior())), xmetodos.formatoANO_MES.format(xmetodos.getFechaActual()), listaidRecepcion.get(i).toString());
                if (list.size() > 0) {
                    String msg2 = "P|" + xc1 + "||" + list.get(0)[3].toString() + "||" + list.get(0)[5].toString() + "^" + list.get(0)[4].toString() + "^^^||" + list.get(0)[6].toString() + "|" + list.get(0)[7].toString() + "|||||||||||||||||||||||||||";
                    mVerificarCaracteres(msg2);
                    long xc2 = 1;
                    HashSet hs = new HashSet();
                    for (int x = 0; x < list.size(); x++) {
                        hs.add(list.get(x)[1].toString());
                    }
                    ArrayList listUnicos = new ArrayList();
                    listUnicos.addAll(hs);
                    for (int x2 = 0; x2 < listUnicos.size(); x2++) {
                        String msg3 = "O|" + xc2 + "|" + listaidRecepcion.get(i) + "||^^^" + listUnicos.get(x2).toString() + "|||||||||||^|||||||||||O||||||";
                        mVerificarCaracteres(msg3);
                        xc2++;
                    }
                    xc1++;
                }
            }
            mVerificarCaracteres("L|1|N");
            mEnvioPuertoSerial("\u0004");
            flag = 0;
            listID.removeAllElements();
        } catch (InterruptedException ex) {
            logExepciones(ex);
        }
    }

    private static void mVerificarCaracteres(String msg) {
        if (msg.length() > 240) {
            xNoFrame = NoFrame(xNoFrame).longValue();
            xNoFrame++;
            String msgAux = msg.substring(240, msg.length());
            String msg2 = msg.substring(0, 240);
            mEnvioPuertoSerial("\u0002" + xNoFrame + msg2 + "\u0017" + mCalcularNVASTM(xNoFrame + msg2) + "\r\n");
            System.out.println("\u0002" + xNoFrame + msg2.replace("\r", "\n") + "\u0017" + mCalcularNVASTM(xNoFrame + msg2) + "\n");
            xNoFrame = NoFrame(xNoFrame).longValue();
            xNoFrame++;
            mEnvioPuertoSerial("\u0002" + xNoFrame + msgAux + "\r\u0003" + mCalcularNVASTM(xNoFrame + msgAux) + "\r\n");
            System.out.println("\u0002" + xNoFrame + msgAux.replace("\r", "\n") + "\u0017" + mCalcularNVASTM(xNoFrame + msgAux) + "\n");
            return;
        }
        xNoFrame = NoFrame(xNoFrame).longValue();
        xNoFrame++;
        mEnvioPuertoSerial("\u0002" + xNoFrame + msg + "\r\u0003" + mCalcularNVASTM(xNoFrame + msg) + "\r\n");
        System.out.println("\u0002" + xNoFrame + msg.replace("\r", "\n") + "\u0003" + mCalcularNVASTM(xNoFrame + msg) + "\n");
    }

    private static void mConsultarProtocolos(String idRecepcion) {
        mEnvioPuertoSerial("\u0005");
        String msg = ((("1H|\\^&|||GENOMA||||||||1|" + xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual()) + "|\r") + "P|1||" + idRecepcion + "||\r") + "O|1|" + idRecepcion + "||^^^241|R|" + xmetodos.formatoDMAH24_Unida.format(xmetodos.getFechaActual()) + "\r") + "L|1|N";
        mEnvioPuertoSerial("\u0002" + msg + "\r\u0003" + mCalcularNVASTM(msg) + "\r\n");
        System.out.println("\u0002" + msg.replace("\r", "\n") + "\u0003" + mCalcularNVASTM(msg) + "\n");
        mEnvioPuertoSerial("\u0004");
        flag = 0;
    }

    private static Long NoFrame(long xnumero) {
        long xcont = xnumero;
        if (xcont == 7) {
            xcont = -1;
        }
        return Long.valueOf(xcont);
    }

    private static String mCalcularNVASTM(String xCadena) {
        int sum = 0;
        for (int i = 0; i < xCadena.length(); i++) {
            sum += xCadena.charAt(i);
        }
        String checksum = Integer.toHexString((sum + 16) % 256).toUpperCase();
        if (checksum.length() == 1) {
            checksum = "0" + checksum;
        }
        return checksum;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logExepciones(Exception ex) {
        String mensaje = "\nA Ocurrió un error Debido a esto, el proceso que se estaba realizando termino abruptamente.\nLocalización : " + ex.getLocalizedMessage() + "\nMensaje : " + ex.getMessage() + "\nCausa : " + ex.getCause() + "\n";
        Metodos metodos = xmetodos;
        Metodos.Registros(mensaje, JCBEquipos.getSelectedItem().toString(), 1);
    }

    private static void cargarConfiguracionMaquina(String maquina) {
        List<Object[]> list = xImplLabotaorio.listConfiguracionMaquina(maquina);
        if (!list.isEmpty()) {
            rateBaund = Integer.valueOf(list.get(0)[0].toString()).intValue();
            dataBit = Integer.valueOf(list.get(0)[1].toString()).intValue();
            stopBit = Integer.valueOf(list.get(0)[2].toString()).intValue();
            parity = Integer.valueOf(list.get(0)[3].toString()).intValue();
            System.out.println("RateBaund: " + rateBaund);
            System.out.println("DataBit: " + dataBit);
            System.out.println("StopBit: " + stopBit);
            System.out.println("Parity: " + parity);
            Metodos metodos = xmetodos;
            Metodos.Registros("RateBaund: " + rateBaund, JCBEquipos.getSelectedItem().toString(), 0);
            Metodos metodos2 = xmetodos;
            Metodos.Registros("DataBit: " + dataBit, JCBEquipos.getSelectedItem().toString(), 0);
            Metodos metodos3 = xmetodos;
            Metodos.Registros("StopBit: " + stopBit, JCBEquipos.getSelectedItem().toString(), 0);
            Metodos metodos4 = xmetodos;
            Metodos.Registros("Parity: " + parity, JCBEquipos.getSelectedItem().toString(), 0);
        }
    }

    private void initComponents() {
        this.JBGEquipos = new ButtonGroup();
        conectarBtn = new JButton();
        JCBEquipos = new JComboBox<>();
        setClosable(true);
        setIconifiable(true);
        setTitle("COMUNICACION SERIAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifserialcom");
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFSerialCom.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSerialCom.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        conectarBtn.setFont(new Font("Arial", 1, 12));
        conectarBtn.setText("Conectar");
        conectarBtn.addActionListener(new ActionListener() { // from class: Laboratorio.JIFSerialCom.2
            public void actionPerformed(ActionEvent evt) {
                JIFSerialCom.this.conectarBtnActionPerformed(evt);
            }
        });
        JCBEquipos.setFont(new Font("Arial", 1, 12));
        JCBEquipos.setBorder(BorderFactory.createTitledBorder((Border) null, "Equipos de Laboratorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        JCBEquipos.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFSerialCom.3
            public void focusLost(FocusEvent evt) {
                JIFSerialCom.this.JCBEquiposFocusLost(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(15, 32767).addComponent(JCBEquipos, -2, 259, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(conectarBtn).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(JCBEquipos, -2, 50, -2).addComponent(conectarBtn, -2, 50, -2)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void conectarBtnActionPerformed(ActionEvent evt) {
        switch (conectarBtn.getText()) {
            case "Conectar":
                try {
                    if (JCBEquipos.getSelectedIndex() != -1) {
                        cargarConfiguracionMaquina(JCBEquipos.getSelectedItem().toString());
                        conectarBtn.setText("Desconectar");
                        message.setLength(0);
                        bytemessage.setLength(0);
                        setIcon(true);
                        JCBEquipos.setEnabled(false);
                        iniciarComunicacion();
                        break;
                    }
                    break;
                } catch (PropertyVetoException ex) {
                    logExepciones(ex);
                    return;
                }
                break;
            case "Desconectar":
                if (JCBEquipos.getSelectedIndex() != -1) {
                    conectarBtn.setText("Conectar");
                    JCBEquipos.setEnabled(true);
                    cerrarPuerto();
                    Save = "";
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (puerto != null) {
            cerrarPuerto();
            claseLab.xJIFSerialCom = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEquiposFocusLost(FocusEvent evt) {
    }
}
