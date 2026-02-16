package AutorizacionMP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFCargarSoporte.class */
public class JIFCargarSoporte extends JInternalFrame {
    private File xfile;
    boolean xguardado = false;
    private JPanel JPIDatos;
    private JFormattedTextField JTFFNDescuento;
    private JTextField JTFFNPersonaAplica;
    private JTextField JTFRuta;

    public JIFCargarSoporte() {
        initComponents();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFFNDescuento = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JTFFNPersonaAplica = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CARGAR DESCUENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jpicargardescuento");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDescuento.setHorizontalAlignment(4);
        this.JTFFNDescuento.setFont(new Font("Arial", 1, 12));
        this.JTFFNDescuento.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarSoporte.1
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporte.this.JTFFNDescuentoActionPerformed(evt);
            }
        });
        this.JTFFNDescuento.addFocusListener(new FocusAdapter() { // from class: AutorizacionMP.JIFCargarSoporte.2
            public void focusLost(FocusEvent evt) {
                JIFCargarSoporte.this.JTFFNDescuentoFocusLost(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo a Cargar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFCargarSoporte.3
            public void mouseClicked(MouseEvent evt) {
                JIFCargarSoporte.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFCargarSoporte.4
            public void actionPerformed(ActionEvent evt) {
                JIFCargarSoporte.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JTFFNPersonaAplica.setFont(new Font("Arial", 1, 12));
        this.JTFFNPersonaAplica.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que Aplica el Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFNDescuento, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNPersonaAplica, -1, 519, 32767)).addComponent(this.JTFRuta, -1, 642, 32767)).addGap(19, 19, 19)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFNPersonaAplica, -1, 63, 32767).addComponent(this.JTFFNDescuento, -2, 63, -2)).addGap(18, 18, 18).addComponent(this.JTFRuta, -2, 61, -2).addGap(14, 14, 14)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDescuentoActionPerformed(ActionEvent evt) {
        mBuscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNDescuentoFocusLost(FocusEvent evt) {
        mBuscarPersona();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    private void mBuscarPersona() {
        if (!this.JTFFNDescuento.getText().isEmpty()) {
            try {
                String sql = "SELECT persona.NUsuario FROM baseserver.d_descuento INNER JOIN baseserver.h_atencion  ON (d_descuento.Id_HAtencion = h_atencion.Id)  INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.persona  ON (ingreso.Id_Usuario = persona.Id_persona)WHERE (d_descuento.Id ='" + this.JTFFNDescuento.getText() + "') ";
                ConsultasMySQL xt1 = new ConsultasMySQL();
                ResultSet xrs = xt1.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFFNPersonaAplica.setText(xrs.getString(1));
                }
                xrs.close();
                xt1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCargarSoporte.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private boolean mValidarCampos() {
        if (!this.JTFFNDescuento.getText().isEmpty()) {
            if (!this.JTFFNPersonaAplica.getText().isEmpty()) {
                if (!this.JTFRuta.getText().isEmpty()) {
                    return true;
                }
                JOptionPane.showInternalMessageDialog(this, "La ruta del archivo no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFRuta.requestFocus();
            } else {
                JOptionPane.showInternalMessageDialog(this, "El Nombre no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTFFNPersonaAplica.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El N° de descuento no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFNDescuento.requestFocus();
        }
        return false;
    }

    private void mGrabarBlob() {
        if (mValidarCampos() && !this.xguardado) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    Metodos xmt = new Metodos();
                    int l = (int) this.xfile.length();
                    PreparedStatement pSt = xt2.establecerConexionBd().prepareStatement("UPDATE  d_descuento SET Soporte=?,  Fecha_CargueS=?, Usuario_CargueS=? where Id = '" + this.JTFFNDescuento.getText() + "'");
                    InputStream is = new BufferedInputStream(new FileInputStream(this.xfile));
                    pSt.setBinaryStream(1, is, l);
                    pSt.setString(2, xmt.formatoAMDH24.format(xmt.getFechaActual()));
                    pSt.setString(3, Principal.usuarioSistemaDTO.getLogin());
                    pSt.execute();
                    JOptionPane.showMessageDialog(this, "Se guardo con exito", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.xguardado = true;
                    pSt.close();
                    xt2.cerrarConexionBd();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JIFCargarSoporte.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFCargarSoporte.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    public void grabar() {
        mGrabarBlob();
    }

    public void nuevo() {
        this.JTFFNDescuento.setText((String) null);
        this.xfile = null;
        this.JTFFNPersonaAplica.setText((String) null);
        this.JTFRuta.setText((String) null);
        this.JTFFNDescuento.requestFocus();
        this.xguardado = false;
    }
}
