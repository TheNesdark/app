package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:PyP/MotricidadFina.class */
public class MotricidadFina extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int puntajeMF = 0;
    private int edad;
    private String sql;
    private String IdAtencion;
    private String idPaciente;
    private clasePyP clasepyp;
    private JButton btnEscala;
    private JCheckBox jCheckBox32;
    private JCheckBox jCheckBox33;
    private JCheckBox jCheckBox34;
    private JCheckBox jCheckBox35;
    private JCheckBox jCheckBox36;
    private JCheckBox jCheckBox37;
    private JCheckBox jCheckBox38;
    private JCheckBox jCheckBox39;
    private JCheckBox jCheckBox40;
    private JCheckBox jCheckBox41;
    private JCheckBox jCheckBox42;
    private JCheckBox jCheckBox43;
    private JCheckBox jCheckBox44;
    private JCheckBox jCheckBox45;
    private JCheckBox jCheckBox46;
    private JCheckBox jCheckBox47;
    private JCheckBox jCheckBox48;
    private JCheckBox jCheckBox49;
    private JCheckBox jCheckBox50;
    private JCheckBox jCheckBox51;
    private JCheckBox jCheckBox52;
    private JCheckBox jCheckBox53;
    private JCheckBox jCheckBox54;
    private JCheckBox jCheckBox55;
    private JCheckBox jCheckBox56;
    private JCheckBox jCheckBox57;
    private JCheckBox jCheckBox58;
    private JCheckBox jCheckBox59;
    private JCheckBox jCheckBox60;
    private JCheckBox jCheckBox61;
    private JCheckBox jCheckBox62;
    private JLabel jLabel1;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JPanel jPanel5;
    private JLabel label1;
    private JLabel label2;
    private JTabbedPane panel;
    private JPanel panelMF;
    private JTextField txtEscala;
    private JDateChooser txtFecha;
    private JTextField txtTotal;

    public MotricidadFina(clasePyP clase, String paciente, String Edad, String atencion) {
        initComponents();
        this.clasepyp = clase;
        this.idPaciente = paciente;
        this.edad = Integer.parseInt(Edad.substring(0, 2));
        this.IdAtencion = atencion;
        navegar(4);
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, MFBajaIni, MFBajaFin, MFMediaIni, MFMediaFin, MFMedioAltoIni, MFMedioAltoFin, MFAltaIni FROM baseserver.p_param_crec_desarrollo";
        ResultSet rs = this.consultas.traerRs(this.sql);
        int i = 0;
        while (true) {
            try {
                if (!rs.next()) {
                    break;
                }
                if (getEdad() >= rs.getInt(2) && getEdad() <= rs.getInt(3)) {
                    for (int col = 4; col < 11; col++) {
                        if (Integer.parseInt(this.txtTotal.getText()) >= rs.getInt(col)) {
                            if (rs.getMetaData().getColumnName(col).equals("MFBajaIni") || rs.getMetaData().getColumnName(col).equals("MFBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (rs.getMetaData().getColumnName(col).equals("MFMediaIni") || rs.getMetaData().getColumnName(col).equals("MFMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (rs.getMetaData().getColumnName(col).equals("MFMedioAltoIni") || rs.getMetaData().getColumnName(col).equals("MFMedioAltoFin")) {
                                this.txtEscala.setForeground(new Color(0, 0, 204));
                                this.txtEscala.setText("Medio Alto");
                            } else {
                                this.txtEscala.setForeground(new Color(255, 255, 255));
                                this.txtEscala.setText("ALTO");
                            }
                        }
                    }
                } else {
                    i++;
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    private int getEdad() {
        return this.edad;
    }

    public void grabar() {
        if (Integer.parseInt(this.txtTotal.getText()) < 1) {
            this.metodos.mostrarMensaje("Por favor evalue la Motricidad Fina o Adaptativa");
            return;
        }
        this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "', Adaptativa ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.metodos.mostrarMensaje("Motricidad Fina Grabada");
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        navegar(4);
        this.consultas.cerrarConexionBd();
    }

    public void navegar(int op) {
        if (op == 1) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Adaptativa FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion ASC";
        } else if (op == 2) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Adaptativa FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion <'" + this.IdAtencion + "') ORDER BY IdAtencion DESC";
        } else if (op == 3) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Adaptativa FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion >'" + this.IdAtencion + "') ORDER BY IdAtencion ASC";
        } else if (op == 4) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Adaptativa FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion DESC";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            if (rs.getRow() > 0) {
                this.txtFecha.setDate(rs.getDate(3));
                puntuacionMF(rs.getInt(4) - 1);
                this.txtEscala.setText("");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void nuevo() {
        navegar(4);
        this.txtFecha.setDate(this.metodos.getFechaActual());
    }

    private void puntuacionMF(int p) {
        this.puntajeMF = 0;
        for (int i = 0; i < this.panelMF.getComponentCount(); i++) {
            if (this.panelMF.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelMF.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajeMF++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajeMF));
        calcularEscala();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.panel = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel24 = new JLabel();
        this.panelMF = new JPanel();
        this.jCheckBox32 = new JCheckBox();
        this.jCheckBox33 = new JCheckBox();
        this.jCheckBox34 = new JCheckBox();
        this.jCheckBox35 = new JCheckBox();
        this.jCheckBox36 = new JCheckBox();
        this.jCheckBox37 = new JCheckBox();
        this.jCheckBox38 = new JCheckBox();
        this.jCheckBox39 = new JCheckBox();
        this.jCheckBox40 = new JCheckBox();
        this.jCheckBox41 = new JCheckBox();
        this.jCheckBox42 = new JCheckBox();
        this.jCheckBox43 = new JCheckBox();
        this.jCheckBox44 = new JCheckBox();
        this.jCheckBox45 = new JCheckBox();
        this.jCheckBox46 = new JCheckBox();
        this.jCheckBox47 = new JCheckBox();
        this.jCheckBox48 = new JCheckBox();
        this.jCheckBox49 = new JCheckBox();
        this.jCheckBox50 = new JCheckBox();
        this.jCheckBox51 = new JCheckBox();
        this.jCheckBox52 = new JCheckBox();
        this.jCheckBox53 = new JCheckBox();
        this.jCheckBox54 = new JCheckBox();
        this.jCheckBox55 = new JCheckBox();
        this.jCheckBox56 = new JCheckBox();
        this.jCheckBox57 = new JCheckBox();
        this.jCheckBox58 = new JCheckBox();
        this.jCheckBox59 = new JCheckBox();
        this.jCheckBox60 = new JCheckBox();
        this.jCheckBox61 = new JCheckBox();
        this.jCheckBox62 = new JCheckBox();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel23 = new JLabel();
        this.jLabel25 = new JLabel();
        this.label1 = new JLabel();
        this.txtTotal = new JTextField();
        this.label2 = new JLabel();
        this.txtEscala = new JTextField();
        this.btnEscala = new JButton();
        this.txtFecha = new JDateChooser();
        setName("MotricidadFina");
        setLayout(null);
        this.jLabel1.setBackground(new Color(0, 51, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORACIÓN DEL DESARROLO POR CONDUCTAS");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(0, 0, 820, 30);
        this.panel.setForeground(new Color(0, 102, 102));
        this.panel.setFont(new Font("Arial", 1, 12));
        this.jPanel5.setLayout((LayoutManager) null);
        this.jLabel14.setBackground(new Color(0, 51, 153));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 255, 255));
        this.jLabel14.setHorizontalAlignment(2);
        this.jLabel14.setText("EDAD EN MESES   CONCEPTO                                                 CONCEPTO                                         EDAD EN MESES");
        this.jLabel14.setOpaque(true);
        this.jPanel5.add(this.jLabel14);
        this.jLabel14.setBounds(20, 10, 720, 20);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 153));
        this.jLabel15.setText("< 1");
        this.jPanel5.add(this.jLabel15);
        this.jLabel15.setBounds(10, 50, 50, 15);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 102, 102));
        this.jLabel16.setText("1 a 3");
        this.jPanel5.add(this.jLabel16);
        this.jLabel16.setBounds(10, 90, 50, 15);
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(new Color(0, 0, 153));
        this.jLabel17.setText("4 a 6");
        this.jPanel5.add(this.jLabel17);
        this.jLabel17.setBounds(10, 160, 50, 15);
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setForeground(new Color(0, 102, 102));
        this.jLabel20.setText("7 a 9");
        this.jPanel5.add(this.jLabel20);
        this.jLabel20.setBounds(10, 230, 50, 15);
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setForeground(new Color(0, 0, 153));
        this.jLabel22.setText("10 a 12");
        this.jPanel5.add(this.jLabel22);
        this.jLabel22.setBounds(10, 300, 50, 15);
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(new Color(0, 102, 102));
        this.jLabel24.setText("13 a 18");
        this.jPanel5.add(this.jLabel24);
        this.jLabel24.setBounds(10, 370, 50, 15);
        this.panelMF.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelMF.setLayout((LayoutManager) null);
        this.jCheckBox32.setFont(new Font("Arial", 1, 12));
        this.jCheckBox32.setForeground(new Color(0, 0, 153));
        this.jCheckBox32.setText("Sigue movimiento horizontal y vertical del objeto");
        this.jCheckBox32.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.1
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox32ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox32);
        this.jCheckBox32.setBounds(10, 10, 410, 23);
        this.jCheckBox33.setFont(new Font("Arial", 1, 12));
        this.jCheckBox33.setForeground(new Color(0, 102, 102));
        this.jCheckBox33.setText("Abre y mira sus manos");
        this.jCheckBox33.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.2
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox33ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox33);
        this.jCheckBox33.setBounds(10, 40, 190, 23);
        this.jCheckBox34.setFont(new Font("Arial", 1, 12));
        this.jCheckBox34.setForeground(new Color(0, 102, 102));
        this.jCheckBox34.setText("Sostiene objeto en la mano");
        this.jCheckBox34.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.3
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox34ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox34);
        this.jCheckBox34.setBounds(10, 60, 220, 20);
        this.jCheckBox35.setFont(new Font("Arial", 1, 12));
        this.jCheckBox35.setForeground(new Color(0, 102, 102));
        this.jCheckBox35.setText("Se lleva objeto a la boca");
        this.jCheckBox35.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.4
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox35ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox35);
        this.jCheckBox35.setBounds(10, 80, 270, 23);
        this.jCheckBox36.setFont(new Font("Arial", 1, 12));
        this.jCheckBox36.setForeground(new Color(0, 0, 153));
        this.jCheckBox36.setText("Agarra objeto voluntariamente");
        this.jCheckBox36.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.5
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox36ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox36);
        this.jCheckBox36.setBounds(10, 110, 270, 23);
        this.jCheckBox37.setFont(new Font("Arial", 1, 12));
        this.jCheckBox37.setForeground(new Color(0, 0, 153));
        this.jCheckBox37.setText("Sostiene un objeto en cada mano");
        this.jCheckBox37.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.6
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox37ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox37);
        this.jCheckBox37.setBounds(10, 130, 270, 23);
        this.jCheckBox38.setFont(new Font("Arial", 1, 12));
        this.jCheckBox38.setForeground(new Color(0, 0, 153));
        this.jCheckBox38.setText("Pasa objeto de una mano a otra");
        this.jCheckBox38.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.7
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox38ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox38);
        this.jCheckBox38.setBounds(10, 150, 270, 23);
        this.jCheckBox39.setFont(new Font("Arial", 1, 12));
        this.jCheckBox39.setForeground(new Color(0, 102, 102));
        this.jCheckBox39.setText("Manipula varios objetos a la vez");
        this.jCheckBox39.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.8
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox39ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox39);
        this.jCheckBox39.setBounds(10, 180, 270, 23);
        this.jCheckBox40.setFont(new Font("Arial", 1, 12));
        this.jCheckBox40.setForeground(new Color(0, 102, 102));
        this.jCheckBox40.setText("Agarra objeto pequeño con los dedos");
        this.jCheckBox40.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.9
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox40ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox40);
        this.jCheckBox40.setBounds(10, 200, 270, 23);
        this.jCheckBox41.setFont(new Font("Arial", 1, 12));
        this.jCheckBox41.setForeground(new Color(0, 102, 102));
        this.jCheckBox41.setText("Agarra cubo con pulgar e indice");
        this.jCheckBox41.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.10
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox41ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox41);
        this.jCheckBox41.setBounds(10, 220, 270, 23);
        this.jCheckBox42.setFont(new Font("Arial", 1, 12));
        this.jCheckBox42.setForeground(new Color(0, 0, 153));
        this.jCheckBox42.setText("Mete y saca objetos en caja");
        this.jCheckBox42.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.11
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox42ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox42);
        this.jCheckBox42.setBounds(10, 250, 270, 23);
        this.jCheckBox43.setFont(new Font("Arial", 1, 12));
        this.jCheckBox43.setForeground(new Color(0, 0, 153));
        this.jCheckBox43.setText("Agarra tercer objeto sin soltar otros");
        this.jCheckBox43.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.12
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox43ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox43);
        this.jCheckBox43.setBounds(10, 270, 270, 23);
        this.jCheckBox44.setFont(new Font("Arial", 1, 12));
        this.jCheckBox44.setForeground(new Color(0, 0, 153));
        this.jCheckBox44.setText("Busca objetos escondidos");
        this.jCheckBox44.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.13
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox44ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox44);
        this.jCheckBox44.setBounds(10, 290, 270, 23);
        this.jCheckBox45.setFont(new Font("Arial", 1, 12));
        this.jCheckBox45.setForeground(new Color(0, 102, 102));
        this.jCheckBox45.setText("Hace torre de tres cubos");
        this.jCheckBox45.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.14
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox45ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox45);
        this.jCheckBox45.setBounds(10, 320, 270, 23);
        this.jCheckBox46.setFont(new Font("Arial", 1, 12));
        this.jCheckBox46.setForeground(new Color(0, 102, 102));
        this.jCheckBox46.setText("Pasa hojas de un libro");
        this.jCheckBox46.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.15
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox46ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox46);
        this.jCheckBox46.setBounds(10, 340, 270, 23);
        this.jCheckBox47.setFont(new Font("Arial", 1, 12));
        this.jCheckBox47.setForeground(new Color(0, 102, 102));
        this.jCheckBox47.setText("Anticipa salida del objeto");
        this.jCheckBox47.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.16
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox47ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox47);
        this.jCheckBox47.setBounds(10, 360, 270, 23);
        this.jCheckBox48.setFont(new Font("Arial", 1, 12));
        this.jCheckBox48.setForeground(new Color(0, 0, 153));
        this.jCheckBox48.setText("Tapa bien la caja");
        this.jCheckBox48.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.17
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox48ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox48);
        this.jCheckBox48.setBounds(320, 40, 240, 23);
        this.jCheckBox49.setFont(new Font("Arial", 1, 12));
        this.jCheckBox49.setForeground(new Color(0, 0, 153));
        this.jCheckBox49.setText("Hace garabatos circulares");
        this.jCheckBox49.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.18
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox49ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox49);
        this.jCheckBox49.setBounds(320, 60, 260, 23);
        this.jCheckBox50.setFont(new Font("Arial", 1, 12));
        this.jCheckBox50.setForeground(new Color(0, 0, 153));
        this.jCheckBox50.setText("Hace torre de 5 o mas cubos");
        this.jCheckBox50.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.19
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox50ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox50);
        this.jCheckBox50.setBounds(320, 80, 260, 23);
        this.jCheckBox51.setFont(new Font("Arial", 1, 12));
        this.jCheckBox51.setForeground(new Color(0, 102, 102));
        this.jCheckBox51.setText("Ensarta 6 o mas cuentas");
        this.jCheckBox51.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.20
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox51ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox51);
        this.jCheckBox51.setBounds(320, 110, 210, 23);
        this.jCheckBox52.setFont(new Font("Arial", 1, 12));
        this.jCheckBox52.setForeground(new Color(0, 102, 102));
        this.jCheckBox52.setText("Copia línea horizontal y vertical");
        this.jCheckBox52.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.21
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox52ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox52);
        this.jCheckBox52.setBounds(320, 130, 220, 23);
        this.jCheckBox53.setFont(new Font("Arial", 1, 12));
        this.jCheckBox53.setForeground(new Color(0, 102, 102));
        this.jCheckBox53.setText("Separa objetos grandes y pequeños");
        this.jCheckBox53.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.22
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox53ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox53);
        this.jCheckBox53.setBounds(320, 150, 260, 23);
        this.jCheckBox54.setFont(new Font("Arial", 1, 12));
        this.jCheckBox54.setForeground(new Color(0, 0, 153));
        this.jCheckBox54.setText("Figura humana rudimentaria I");
        this.jCheckBox54.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.23
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox54ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox54);
        this.jCheckBox54.setBounds(320, 180, 210, 23);
        this.jCheckBox55.setFont(new Font("Arial", 1, 12));
        this.jCheckBox55.setForeground(new Color(0, 0, 153));
        this.jCheckBox55.setText("Corta papel con las tijeras");
        this.jCheckBox55.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.24
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox55ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox55);
        this.jCheckBox55.setBounds(320, 200, 220, 23);
        this.jCheckBox56.setFont(new Font("Arial", 1, 12));
        this.jCheckBox56.setForeground(new Color(0, 0, 153));
        this.jCheckBox56.setText("Copia cuadrado y círculo");
        this.jCheckBox56.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.25
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox56ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox56);
        this.jCheckBox56.setBounds(320, 220, 220, 23);
        this.jCheckBox57.setFont(new Font("Arial", 1, 12));
        this.jCheckBox57.setForeground(new Color(0, 102, 102));
        this.jCheckBox57.setText("Dibuja figura humana II");
        this.jCheckBox57.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.26
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox57ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox57);
        this.jCheckBox57.setBounds(320, 250, 220, 23);
        this.jCheckBox58.setFont(new Font("Arial", 1, 12));
        this.jCheckBox58.setForeground(new Color(0, 102, 102));
        this.jCheckBox58.setText("Agrupa por color y forma");
        this.jCheckBox58.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.27
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox58ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox58);
        this.jCheckBox58.setBounds(320, 270, 220, 23);
        this.jCheckBox59.setFont(new Font("Arial", 1, 12));
        this.jCheckBox59.setForeground(new Color(0, 102, 102));
        this.jCheckBox59.setText("Dibuja escalera (imita)");
        this.jCheckBox59.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.28
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox59ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox59);
        this.jCheckBox59.setBounds(320, 290, 230, 23);
        this.jCheckBox60.setFont(new Font("Arial", 1, 12));
        this.jCheckBox60.setForeground(new Color(0, 0, 153));
        this.jCheckBox60.setText("Agrupa por color, forma y tamaño");
        this.jCheckBox60.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.29
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox60ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox60);
        this.jCheckBox60.setBounds(320, 320, 250, 23);
        this.jCheckBox61.setFont(new Font("Arial", 1, 12));
        this.jCheckBox61.setForeground(new Color(0, 0, 153));
        this.jCheckBox61.setText("Recosntruye escalera de 10 cubos");
        this.jCheckBox61.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.30
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox61ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox61);
        this.jCheckBox61.setBounds(320, 340, 250, 23);
        this.jCheckBox62.setFont(new Font("Arial", 1, 12));
        this.jCheckBox62.setForeground(new Color(0, 0, 153));
        this.jCheckBox62.setText("Dibuja casa");
        this.jCheckBox62.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.31
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.jCheckBox62ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox62);
        this.jCheckBox62.setBounds(320, 360, 220, 23);
        this.jPanel5.add(this.panelMF);
        this.panelMF.setBounds(70, 40, 580, 380);
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(new Color(0, 0, 153));
        this.jLabel18.setText("19 a 24");
        this.jLabel18.setFocusable(false);
        this.jPanel5.add(this.jLabel18);
        this.jLabel18.setBounds(680, 80, 50, 15);
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setForeground(new Color(0, 102, 102));
        this.jLabel19.setText("25 a 36");
        this.jPanel5.add(this.jLabel19);
        this.jLabel19.setBounds(680, 150, 50, 15);
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setForeground(new Color(0, 0, 153));
        this.jLabel21.setText("37 a 48");
        this.jPanel5.add(this.jLabel21);
        this.jLabel21.setBounds(680, 230, 50, 15);
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(new Color(0, 102, 102));
        this.jLabel23.setText("49 a 60");
        this.jPanel5.add(this.jLabel23);
        this.jLabel23.setBounds(680, 290, 50, 15);
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(new Color(0, 0, 153));
        this.jLabel25.setText("61 a 72");
        this.jPanel5.add(this.jLabel25);
        this.jLabel25.setBounds(680, 360, 50, 15);
        this.panel.addTab("Motricidad Fina o Adaptativa", this.jPanel5);
        add(this.panel);
        this.panel.setBounds(10, 50, 798, 460);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 255));
        this.label1.setHorizontalAlignment(0);
        this.label1.setText("Sumatoria Total");
        this.label1.setOpaque(true);
        add(this.label1);
        this.label1.setBounds(190, 530, 180, 30);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Tahoma", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(370, 530, 140, 30);
        this.label2.setBackground(new Color(0, 51, 153));
        this.label2.setFont(new Font("Arial", 1, 18));
        this.label2.setForeground(new Color(255, 255, 204));
        this.label2.setHorizontalAlignment(2);
        this.label2.setText("Escala");
        this.label2.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label2.setOpaque(true);
        add(this.label2);
        this.label2.setBounds(510, 530, 120, 30);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(630, 530, 180, 30);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 204));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.MotricidadFina.32
            public void actionPerformed(ActionEvent evt) {
                MotricidadFina.this.btnEscalaActionPerformed(evt);
            }
        });
        add(this.btnEscala);
        this.btnEscala.setBounds(10, 590, 800, 35);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        add(this.txtFecha);
        this.txtFecha.setBounds(10, 520, 170, 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox32ActionPerformed(ActionEvent evt) {
        puntuacionMF(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox33ActionPerformed(ActionEvent evt) {
        puntuacionMF(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox34ActionPerformed(ActionEvent evt) {
        puntuacionMF(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox35ActionPerformed(ActionEvent evt) {
        puntuacionMF(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox36ActionPerformed(ActionEvent evt) {
        puntuacionMF(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox37ActionPerformed(ActionEvent evt) {
        puntuacionMF(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox38ActionPerformed(ActionEvent evt) {
        puntuacionMF(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox39ActionPerformed(ActionEvent evt) {
        puntuacionMF(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox40ActionPerformed(ActionEvent evt) {
        puntuacionMF(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox41ActionPerformed(ActionEvent evt) {
        puntuacionMF(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox42ActionPerformed(ActionEvent evt) {
        puntuacionMF(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox43ActionPerformed(ActionEvent evt) {
        puntuacionMF(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox44ActionPerformed(ActionEvent evt) {
        puntuacionMF(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox45ActionPerformed(ActionEvent evt) {
        puntuacionMF(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox46ActionPerformed(ActionEvent evt) {
        puntuacionMF(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox47ActionPerformed(ActionEvent evt) {
        puntuacionMF(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox48ActionPerformed(ActionEvent evt) {
        puntuacionMF(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox49ActionPerformed(ActionEvent evt) {
        puntuacionMF(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox50ActionPerformed(ActionEvent evt) {
        puntuacionMF(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox51ActionPerformed(ActionEvent evt) {
        puntuacionMF(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox52ActionPerformed(ActionEvent evt) {
        puntuacionMF(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox53ActionPerformed(ActionEvent evt) {
        puntuacionMF(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox54ActionPerformed(ActionEvent evt) {
        puntuacionMF(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox55ActionPerformed(ActionEvent evt) {
        puntuacionMF(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox56ActionPerformed(ActionEvent evt) {
        puntuacionMF(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox57ActionPerformed(ActionEvent evt) {
        puntuacionMF(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox58ActionPerformed(ActionEvent evt) {
        puntuacionMF(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox59ActionPerformed(ActionEvent evt) {
        puntuacionMF(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox60ActionPerformed(ActionEvent evt) {
        puntuacionMF(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox61ActionPerformed(ActionEvent evt) {
        puntuacionMF(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox62ActionPerformed(ActionEvent evt) {
        puntuacionMF(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
    }
}
