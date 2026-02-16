package Acceso;

import com.genoma.plus.dao.general.InformacionIpsDAO;
import com.genoma.plus.dao.impl.general.InformacionIpsDAOImpl;
import com.genoma.plus.dto.general.InformacionIpsDTO;
import com.genoma.plus.utils.DecrypterLicensed;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/inicio.class */
public class inicio extends JFrame {
    Thread hilo;
    private int xvar;
    private static Login login;
    private static List<InformacionIpsDTO> informacionIpsDTO;
    private InformacionIpsDAO informacionIpsDAO;
    public static AnnotationConfigApplicationContext contexto;
    private static final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jlbVersion;
    final Object objeto = new Object();
    int min = 0;
    int max = 500;
    private String[][] xempresas = new String[64][6];
    boolean xvalor = false;
    private long xid_empresa = 0;

    public inicio() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        mNombre_Empresa();
        mValidarLicencia();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jlbVersion = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel2 = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("G@noma Soft");
        setCursor(new Cursor(0));
        setEnabled(false);
        setFocusable(false);
        setMinimumSize(new Dimension(244, 218));
        setName("inicio");
        setUndecorated(true);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Logo_GenomaEmpresarial.png")));
        this.jlbVersion.setFont(new Font("Arial", 1, 14));
        this.jlbVersion.setForeground(new Color(0, 0, 204));
        this.jlbVersion.setHorizontalAlignment(0);
        this.jlbVersion.setText("v6.0.8  2024/04/04");
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(102, 0, 102));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("NIT :  901781805-0");
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Loadin_Pequeno.gif")));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, -1, -1, 32767).addComponent(this.jlbVersion, -1, -1, 32767).addComponent(this.jLabel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addGap(6, 6, 6).addComponent(this.jlbVersion).addContainerGap()));
        setSize(new Dimension(244, 218));
        setLocationRelativeTo(null);
    }

    private void springStart() {
        this.informacionIpsDAO = (InformacionIpsDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informacionIpsDAOImpl");
    }

    private void mValidarLicencia() {
        try {
            informacionIpsDTO = this.informacionIpsDAO.informacionIps();
            String datosComparacion = informacionIpsDTO.get(0).getIdTipoIdentificacion() + informacionIpsDTO.get(0).getIdentificacion();
            DecrypterLicensed decrypterLicensed = DecrypterLicensed.getInstances(informacionIpsDTO.get(0).getLlaveLicencia());
            String identificacion = decrypterLicensed.Decrypt(informacionIpsDTO.get(0).getNumeroLicencia());
            if (identificacion.equals(datosComparacion)) {
                this.xvalor = true;
                atomicBoolean.set(true);
                informacionIpsDTO.get(0).setVersion(this.jlbVersion.getText());
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public static void cargar() {
        login = new Login(null, true, informacionIpsDTO);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public static void main(String[] args) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() { // from class: Acceso.inicio.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                inicio ini = null;
                try {
                    ini = new inicio();
                    ini.setVisible(true);
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                if (inicio.atomicBoolean.get()) {
                    inicio.cargar();
                    ini.dispose();
                    timer.cancel();
                } else {
                    JOptionPane.showMessageDialog((Component) null, "No tiene autorización para la ejecución de este programa;\nComuníquese a info@genomaempresarial.com.co", "VALIDACIÓN DE LICENCIA", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    timer.cancel();
                }
            }
        }, 0L, 1000L);
    }

    private void mNombre_Empresa() {
        this.xempresas[0][0] = "FUNDACIÓN PANZENÚ";
        this.xempresas[0][1] = "8";
        this.xempresas[1][0] = "IPS SU SALUD INTEGRAL CIA LTDA";
        this.xempresas[1][1] = "215";
        this.xempresas[2][0] = "BIENESTAR ACTIVA IPS";
        this.xempresas[2][1] = "4";
        this.xempresas[3][0] = "CLINICA REGIONAL DEL SAN JORGE I.P.S S.A.S";
        this.xempresas[3][1] = "1897";
        this.xempresas[4][0] = "DOOFTA S.A.S";
        this.xempresas[4][1] = "0";
        this.xempresas[5][0] = "U.T. BIOMED VIDA";
        this.xempresas[5][1] = "0";
        this.xempresas[6][0] = "LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.";
        this.xempresas[6][1] = "0";
        this.xempresas[7][0] = "Dra. ANA MARIA TORRALVO SEGURA";
        this.xempresas[7][1] = "0";
        this.xempresas[8][0] = "LABORATORIO CLÍNICO LABVY S.A.S";
        this.xempresas[8][1] = "1609";
        this.xempresas[9][0] = "DAIRO OSORIO GUETTE";
        this.xempresas[9][1] = "0";
        this.xempresas[10][0] = "HOSPITAL LA CRUZ - CLINICA PAJONAL LTDA";
        this.xempresas[10][1] = "0";
        this.xempresas[11][0] = "ELKIN AICARDO CORDOBA JULIO";
        this.xempresas[11][1] = "0";
        this.xempresas[12][0] = "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.";
        this.xempresas[12][1] = "1";
        this.xempresas[13][0] = "GENOMA EMPESARIAL CONSULTORES SAS";
        this.xempresas[13][1] = "1";
        this.xempresas[14][0] = "CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.";
        this.xempresas[14][1] = "78";
        this.xempresas[15][0] = "EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO";
        this.xempresas[15][1] = "1";
        this.xempresas[16][0] = "Dr. RAFAEL EDUARDO RUIZ DURANGO";
        this.xempresas[16][1] = "1";
        this.xempresas[17][0] = "Dr. JUAN FERNANDO MUÑOZ RESTREPO";
        this.xempresas[17][1] = "211";
        this.xempresas[18][0] = "Dra. MIRYAM DEL PILAR MANOTAS CAMARGO";
        this.xempresas[18][1] = "212";
        this.xempresas[19][0] = "I.P.S CENTRO DE TERAPIAS INTEGRALES PATRICIA MEJIA CACERES S.A.S.";
        this.xempresas[19][1] = "213";
        this.xempresas[20][0] = "EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO";
        this.xempresas[20][1] = "288";
        this.xempresas[21][0] = "EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO";
        this.xempresas[21][1] = "1";
        this.xempresas[22][0] = "UNIDAD RENAL DEL SAN JORGE ISMAEL ORTEGA GUERRA";
        this.xempresas[22][1] = "1";
        this.xempresas[23][0] = "ASC EN SALUD TOTAL SAS";
        this.xempresas[23][1] = "3";
        this.xempresas[24][0] = "CAMBIA TU VIDA IPS SAS";
        this.xempresas[24][1] = "3";
        this.xempresas[25][0] = "E.S.E CAMU BUENAVISTA";
        this.xempresas[25][1] = "1";
        this.xempresas[26][0] = "IPS SU SALUD INTEGRAL S.A.S";
        this.xempresas[26][1] = "215";
        this.xempresas[27][0] = "RADIOLOGOS ASOCIADOS DE CORDOBA S.A.S.";
        this.xempresas[27][1] = "1";
        this.xempresas[28][0] = "BIOMED VIDA IPS S.A.S";
        this.xempresas[28][1] = "0";
        this.xempresas[29][0] = "SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.";
        this.xempresas[29][1] = "1";
        this.xempresas[30][0] = "EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA";
        this.xempresas[30][1] = "1";
        this.xempresas[31][0] = "MINEROS S.A";
        this.xempresas[31][1] = "1";
        this.xempresas[32][0] = "NEGOCIOS AGROFORESTALES S.A.S";
        this.xempresas[32][1] = "2";
        this.xempresas[33][0] = "OPERADORA MINERA S.A.S";
        this.xempresas[33][1] = "3";
        this.xempresas[34][0] = "FUNDACION MINERO S.A.S";
        this.xempresas[34][1] = "4";
        this.xempresas[35][0] = "CLINICA PAJONAL S.A.S";
        this.xempresas[35][1] = "1662";
        this.xempresas[35][2] = "15-03-2018";
        this.xempresas[36][0] = "IPS ETNIA VITAL LTDA";
        this.xempresas[36][1] = "1";
        this.xempresas[36][2] = "26-03-2018";
        this.xempresas[37][0] = "SALUD A SU HOGAR IPS S.A.S.";
        this.xempresas[37][1] = "1";
        this.xempresas[37][2] = "09-04-2018";
        this.xempresas[38][0] = "INSTITUTO COLOMBIANO DE NEUROCIENCIAS APLICADAS S.A.S.";
        this.xempresas[38][1] = "1";
        this.xempresas[38][2] = "03-05-2018";
        this.xempresas[39][0] = "ESE HOSPITAL LOCAL DE PUERTO LIBERTADOR";
        this.xempresas[39][1] = "288";
        this.xempresas[39][2] = "16-05-2018";
        this.xempresas[40][0] = "APS SALUD EN CASA IPS S.A.S";
        this.xempresas[40][1] = "288";
        this.xempresas[40][2] = "16-05-2018";
        this.xempresas[41][0] = "ORTODONCIA Y ESTETICA DENTAL SONRIE SAS";
        this.xempresas[41][1] = "1";
        this.xempresas[41][2] = "16-05-2018";
        this.xempresas[42][0] = "IPS TERAPIAS Y ESTETICA INTEGRAL SAS";
        this.xempresas[42][1] = "1";
        this.xempresas[42][2] = "26-05-2018";
        this.xempresas[43][0] = "UNION TEMPORAL ASISTENCIA MEDICA INTEGRAL EN SALUD";
        this.xempresas[43][1] = "1";
        this.xempresas[43][2] = "12-07-2018";
        this.xempresas[44][0] = "IPS ESPERANZAS DE VIDA SAS";
        this.xempresas[44][1] = "1";
        this.xempresas[44][2] = "10-08-2018";
        this.xempresas[45][0] = "MINEROS ALUVIAL S.A.S";
        this.xempresas[45][1] = "6";
        this.xempresas[45][2] = "23-10-2018";
        this.xempresas[46][0] = "UNIDAD MEDICA DEL CAS S.A.S";
        this.xempresas[46][1] = "1";
        this.xempresas[46][2] = "13-12-2018";
        this.xempresas[47][0] = "E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO";
        this.xempresas[47][1] = "2";
        this.xempresas[48][0] = "MEDICAL EHM IPS S.A.S";
        this.xempresas[48][1] = "1";
        this.xempresas[49][0] = "SERVICIOS MEDICOS SAN IGNACIO SAS";
        this.xempresas[49][1] = "2";
        this.xempresas[50][0] = "HOSPITAL SAN VICENTE DE PAUL";
        this.xempresas[50][1] = "2";
        this.xempresas[51][0] = "HOSPITAL NUESTRA SEÑORA DEL CARMEN";
        this.xempresas[51][1] = "2";
        this.xempresas[52][0] = "E.S.E. HOSPITAL SAN JUAN DE DIOS";
        this.xempresas[52][1] = "2";
        this.xempresas[53][0] = "E.S.E. HOSPITAL SAN VICENTE DE PAUL";
        this.xempresas[53][1] = "2";
        this.xempresas[54][0] = "ESE HOSPITAL LA MISERICORDIA";
        this.xempresas[54][1] = "1";
        this.xempresas[55][0] = "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA";
        this.xempresas[55][1] = "1";
        this.xempresas[56][0] = "JORGE IVAN  VALENCIA  RIVERA";
        this.xempresas[56][1] = "3";
        this.xempresas[57][0] = "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE";
        this.xempresas[57][1] = "1";
        this.xempresas[58][0] = "CLINICA SAN FRANCISCO S.A.";
        this.xempresas[58][1] = "1";
        this.xempresas[59][0] = "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH";
        this.xempresas[59][1] = "1";
        this.xempresas[60][0] = "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA";
        this.xempresas[60][1] = "2";
        this.xempresas[61][0] = "HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.";
        this.xempresas[61][1] = "1";
        this.xempresas[62][0] = "UNION TEMPORAL CLINICA LAURELES";
        this.xempresas[62][1] = "1";
        this.xempresas[63][0] = "EMPRESA SOCIAL DEL ESTADO CAMU CHIMA";
        this.xempresas[63][1] = "1";
        this.xempresas[63][0] = "I.P.S RIO SALUD S.A.S";
        this.xempresas[63][1] = "1";
    }
}
