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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:PyP/ValoracionLenguaje.class */
public class ValoracionLenguaje extends JPanel {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int puntajeAL = 0;
    private int edad;
    private String sql;
    private String IdAtencion;
    private String idPaciente;
    private clasePyP clasepyp;
    private JButton btnEscala;
    private JCheckBox jCheckBox63;
    private JCheckBox jCheckBox64;
    private JCheckBox jCheckBox65;
    private JCheckBox jCheckBox66;
    private JCheckBox jCheckBox67;
    private JCheckBox jCheckBox68;
    private JCheckBox jCheckBox69;
    private JCheckBox jCheckBox70;
    private JCheckBox jCheckBox71;
    private JCheckBox jCheckBox72;
    private JCheckBox jCheckBox73;
    private JCheckBox jCheckBox74;
    private JCheckBox jCheckBox75;
    private JCheckBox jCheckBox76;
    private JCheckBox jCheckBox77;
    private JCheckBox jCheckBox78;
    private JCheckBox jCheckBox79;
    private JCheckBox jCheckBox80;
    private JCheckBox jCheckBox81;
    private JCheckBox jCheckBox82;
    private JCheckBox jCheckBox83;
    private JCheckBox jCheckBox84;
    private JCheckBox jCheckBox85;
    private JCheckBox jCheckBox86;
    private JCheckBox jCheckBox87;
    private JCheckBox jCheckBox88;
    private JCheckBox jCheckBox89;
    private JCheckBox jCheckBox90;
    private JCheckBox jCheckBox91;
    private JCheckBox jCheckBox92;
    private JCheckBox jCheckBox93;
    private JLabel jLabel1;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel34;
    private JLabel jLabel35;
    private JLabel jLabel36;
    private JLabel jLabel37;
    private JPanel jPanel10;
    private JTabbedPane jTabbedPane1;
    private JLabel label1;
    private JLabel label2;
    private JPanel panelAL;
    private JTextField txtEscala;
    private JDateChooser txtFecha;
    private JTextField txtTotal;

    public ValoracionLenguaje(clasePyP clase, String paciente, String Edad, String atencion) {
        initComponents();
        this.clasepyp = clase;
        this.idPaciente = paciente;
        this.edad = Integer.parseInt(Edad.substring(0, 2).trim());
        this.IdAtencion = atencion;
        navegar(4);
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, ALBajaIni, ALBajaFin, ALMediaIni, ALMediaFin, ALMediaAltaIni, ALMediaAltaFin, ALAltaIni FROM baseserver.p_param_crec_desarrollo";
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
                            if (rs.getMetaData().getColumnName(col).equals("ALBajaIni") || rs.getMetaData().getColumnName(col).equals("ALBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (rs.getMetaData().getColumnName(col).equals("ALMediaIni") || rs.getMetaData().getColumnName(col).equals("ALMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (rs.getMetaData().getColumnName(col).equals("ALMediaAltaIni") || rs.getMetaData().getColumnName(col).equals("ALMediaAltaFin")) {
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

    private void puntuacionAL(int p) {
        this.puntajeAL = 0;
        for (int i = 0; i < this.panelAL.getComponentCount(); i++) {
            if (this.panelAL.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelAL.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajeAL++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajeAL));
        calcularEscala();
    }

    private int getEdad() {
        return this.edad;
    }

    public void grabar() {
        if (Integer.parseInt(this.txtTotal.getText()) < 1) {
            this.metodos.mostrarMensaje("Por favor evalue la Adición Lenguaje");
            return;
        }
        this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', Lenguaje ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.metodos.mostrarMensaje("Valoración del Lenguaje Modificada");
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        navegar(4);
        this.consultas.cerrarConexionBd();
    }

    public void navegar(int op) {
        if (op == 1) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Lenguaje FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion ASC";
        } else if (op == 2) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Lenguaje FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion <'" + this.IdAtencion + "') ORDER BY IdAtencion DESC";
        } else if (op == 3) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Lenguaje FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion >'" + this.IdAtencion + "') ORDER BY IdAtencion ASC";
        } else if (op == 4) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Lenguaje FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion DESC";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.txtFecha.setDate(rs.getDate(3));
                puntuacionAL(rs.getInt(4) - 1);
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
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel10 = new JPanel();
        this.panelAL = new JPanel();
        this.jCheckBox63 = new JCheckBox();
        this.jCheckBox64 = new JCheckBox();
        this.jCheckBox65 = new JCheckBox();
        this.jCheckBox66 = new JCheckBox();
        this.jCheckBox67 = new JCheckBox();
        this.jCheckBox68 = new JCheckBox();
        this.jCheckBox69 = new JCheckBox();
        this.jCheckBox70 = new JCheckBox();
        this.jCheckBox71 = new JCheckBox();
        this.jCheckBox72 = new JCheckBox();
        this.jCheckBox73 = new JCheckBox();
        this.jCheckBox74 = new JCheckBox();
        this.jCheckBox75 = new JCheckBox();
        this.jCheckBox76 = new JCheckBox();
        this.jCheckBox77 = new JCheckBox();
        this.jCheckBox78 = new JCheckBox();
        this.jCheckBox79 = new JCheckBox();
        this.jCheckBox80 = new JCheckBox();
        this.jCheckBox81 = new JCheckBox();
        this.jCheckBox82 = new JCheckBox();
        this.jCheckBox83 = new JCheckBox();
        this.jCheckBox84 = new JCheckBox();
        this.jCheckBox85 = new JCheckBox();
        this.jCheckBox86 = new JCheckBox();
        this.jCheckBox87 = new JCheckBox();
        this.jCheckBox88 = new JCheckBox();
        this.jCheckBox89 = new JCheckBox();
        this.jCheckBox90 = new JCheckBox();
        this.jCheckBox91 = new JCheckBox();
        this.jCheckBox92 = new JCheckBox();
        this.jCheckBox93 = new JCheckBox();
        this.jLabel26 = new JLabel();
        this.jLabel27 = new JLabel();
        this.jLabel28 = new JLabel();
        this.jLabel29 = new JLabel();
        this.jLabel30 = new JLabel();
        this.jLabel31 = new JLabel();
        this.jLabel32 = new JLabel();
        this.jLabel33 = new JLabel();
        this.jLabel34 = new JLabel();
        this.jLabel35 = new JLabel();
        this.jLabel36 = new JLabel();
        this.jLabel37 = new JLabel();
        this.label2 = new JLabel();
        this.txtEscala = new JTextField();
        this.label1 = new JLabel();
        this.txtTotal = new JTextField();
        this.btnEscala = new JButton();
        this.txtFecha = new JDateChooser();
        setName("ValoracionLenguaje");
        setLayout(null);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORACIÓN DEL DESARROLLO POR CONDUCTAS");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(0, 0, 820, 30);
        this.jTabbedPane1.setForeground(new Color(0, 102, 102));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.panelAL.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelAL.setLayout((LayoutManager) null);
        this.jCheckBox63.setFont(new Font("Arial", 1, 12));
        this.jCheckBox63.setForeground(new Color(0, 0, 153));
        this.jCheckBox63.setText("Se sobresalta con ruido");
        this.jCheckBox63.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.1
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox63ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox63);
        this.jCheckBox63.setBounds(10, 0, 250, 23);
        this.jCheckBox64.setFont(new Font("Arial", 1, 12));
        this.jCheckBox64.setForeground(new Color(0, 102, 102));
        this.jCheckBox64.setText("Busca sonido con la mirada");
        this.jCheckBox64.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.2
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox64ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox64);
        this.jCheckBox64.setBounds(10, 30, 250, 23);
        this.jCheckBox65.setFont(new Font("Arial", 1, 12));
        this.jCheckBox65.setForeground(new Color(0, 102, 102));
        this.jCheckBox65.setText("Dos sonidos guturales diferentes");
        this.jCheckBox65.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.3
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox65ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox65);
        this.jCheckBox65.setBounds(10, 50, 250, 23);
        this.jCheckBox66.setFont(new Font("Arial", 1, 12));
        this.jCheckBox66.setForeground(new Color(0, 102, 102));
        this.jCheckBox66.setText("Balbucea con las personas");
        this.jCheckBox66.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.4
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox66ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox66);
        this.jCheckBox66.setBounds(10, 70, 250, 23);
        this.jCheckBox67.setFont(new Font("Arial", 1, 12));
        this.jCheckBox67.setForeground(new Color(0, 0, 153));
        this.jCheckBox67.setText("4 o mas sonidos diferentes");
        this.jCheckBox67.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.5
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox67ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox67);
        this.jCheckBox67.setBounds(10, 110, 250, 23);
        this.jCheckBox68.setFont(new Font("Arial", 1, 12));
        this.jCheckBox68.setForeground(new Color(0, 0, 153));
        this.jCheckBox68.setText("Rie a carcajadas");
        this.jCheckBox68.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.6
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox68ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox68);
        this.jCheckBox68.setBounds(10, 130, 250, 23);
        this.jCheckBox69.setFont(new Font("Arial", 1, 12));
        this.jCheckBox69.setForeground(new Color(0, 0, 153));
        this.jCheckBox69.setText("Reacciona cuando se le llama");
        this.jCheckBox69.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.7
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox69ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox69);
        this.jCheckBox69.setBounds(10, 150, 250, 23);
        this.jCheckBox70.setFont(new Font("Arial", 1, 12));
        this.jCheckBox70.setForeground(new Color(0, 102, 102));
        this.jCheckBox70.setText("Pronuncia 3 o mas sílabas");
        this.jCheckBox70.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.8
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox70ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox70);
        this.jCheckBox70.setBounds(10, 180, 250, 23);
        this.jCheckBox71.setFont(new Font("Arial", 1, 12));
        this.jCheckBox71.setForeground(new Color(0, 102, 102));
        this.jCheckBox71.setText("Hace sonar la campanilla");
        this.jCheckBox71.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.9
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox71ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox71);
        this.jCheckBox71.setBounds(10, 200, 250, 23);
        this.jCheckBox72.setFont(new Font("Arial", 1, 12));
        this.jCheckBox72.setForeground(new Color(0, 102, 102));
        this.jCheckBox72.setText("Una palabra clara");
        this.jCheckBox72.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.10
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox72ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox72);
        this.jCheckBox72.setBounds(10, 220, 250, 23);
        this.jCheckBox73.setFont(new Font("Arial", 1, 12));
        this.jCheckBox73.setForeground(new Color(0, 0, 153));
        this.jCheckBox73.setText("Niega con la cabeza");
        this.jCheckBox73.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.11
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox73ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox73);
        this.jCheckBox73.setBounds(10, 260, 250, 23);
        this.jCheckBox74.setFont(new Font("Arial", 1, 12));
        this.jCheckBox74.setForeground(new Color(0, 0, 153));
        this.jCheckBox74.setText("Llama a la madre o acompañante");
        this.jCheckBox74.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.12
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox74ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox74);
        this.jCheckBox74.setBounds(10, 280, 250, 23);
        this.jCheckBox75.setFont(new Font("Arial", 1, 12));
        this.jCheckBox75.setForeground(new Color(0, 0, 153));
        this.jCheckBox75.setText("Entiende orden sencilla");
        this.jCheckBox75.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.13
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox75ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox75);
        this.jCheckBox75.setBounds(10, 300, 250, 23);
        this.jCheckBox76.setFont(new Font("Arial", 1, 12));
        this.jCheckBox76.setForeground(new Color(0, 102, 102));
        this.jCheckBox76.setText("Reconoce 3 objetos");
        this.jCheckBox76.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.14
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox76ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox76);
        this.jCheckBox76.setBounds(10, 330, 250, 23);
        this.jCheckBox77.setFont(new Font("Arial", 1, 12));
        this.jCheckBox77.setForeground(new Color(0, 102, 102));
        this.jCheckBox77.setText("Cambian 2 palabras");
        this.jCheckBox77.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.15
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox77ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox77);
        this.jCheckBox77.setBounds(10, 350, 250, 23);
        this.jCheckBox78.setFont(new Font("Arial", 1, 12));
        this.jCheckBox78.setForeground(new Color(0, 102, 102));
        this.jCheckBox78.setText("Reconoce 6 objetos");
        this.jCheckBox78.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.16
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox78ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox78);
        this.jCheckBox78.setBounds(10, 370, 250, 23);
        this.jCheckBox79.setFont(new Font("Arial", 1, 12));
        this.jCheckBox79.setForeground(new Color(0, 0, 153));
        this.jCheckBox79.setText("Nombra 5 objetos");
        this.jCheckBox79.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.17
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox79ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox79);
        this.jCheckBox79.setBounds(270, 30, 210, 23);
        this.jCheckBox80.setFont(new Font("Arial", 1, 12));
        this.jCheckBox80.setForeground(new Color(0, 0, 153));
        this.jCheckBox80.setText("Usa frases de 3 palabras");
        this.jCheckBox80.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.18
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox80ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox80);
        this.jCheckBox80.setBounds(270, 50, 210, 23);
        this.jCheckBox81.setFont(new Font("Arial", 1, 12));
        this.jCheckBox81.setForeground(new Color(0, 0, 153));
        this.jCheckBox81.setText("Mas de 2o palabras claras");
        this.jCheckBox81.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.19
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox81ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox81);
        this.jCheckBox81.setBounds(270, 70, 210, 23);
        this.jCheckBox82.setFont(new Font("Arial", 1, 12));
        this.jCheckBox82.setForeground(new Color(0, 102, 102));
        this.jCheckBox82.setText("Dice su nombre completo");
        this.jCheckBox82.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.20
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox82ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox82);
        this.jCheckBox82.setBounds(270, 110, 210, 23);
        this.jCheckBox83.setFont(new Font("Arial", 1, 12));
        this.jCheckBox83.setForeground(new Color(0, 102, 102));
        this.jCheckBox83.setText("Conoce: alto-abajo, grande-pequeño");
        this.jCheckBox83.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.21
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox83ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox83);
        this.jCheckBox83.setBounds(270, 130, 260, 23);
        this.jCheckBox84.setFont(new Font("Arial", 1, 12));
        this.jCheckBox84.setForeground(new Color(0, 102, 102));
        this.jCheckBox84.setText("Usa oraciones completas");
        this.jCheckBox84.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.22
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox84ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox84);
        this.jCheckBox84.setBounds(270, 150, 210, 23);
        this.jCheckBox85.setFont(new Font("Arial", 1, 12));
        this.jCheckBox85.setForeground(new Color(0, 0, 153));
        this.jCheckBox85.setText("Define por uso 5 objetos");
        this.jCheckBox85.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.23
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox85ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox85);
        this.jCheckBox85.setBounds(270, 180, 210, 23);
        this.jCheckBox86.setFont(new Font("Arial", 1, 12));
        this.jCheckBox86.setForeground(new Color(0, 0, 153));
        this.jCheckBox86.setText("Repite 3 digitos");
        this.jCheckBox86.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.24
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox86ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox86);
        this.jCheckBox86.setBounds(270, 200, 210, 23);
        this.jCheckBox87.setFont(new Font("Arial", 1, 12));
        this.jCheckBox87.setForeground(new Color(0, 0, 153));
        this.jCheckBox87.setText("Describe bien el dibujo");
        this.jCheckBox87.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.25
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox87ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox87);
        this.jCheckBox87.setBounds(270, 220, 210, 23);
        this.jCheckBox88.setFont(new Font("Arial", 1, 12));
        this.jCheckBox88.setForeground(new Color(0, 102, 102));
        this.jCheckBox88.setText("Cuenta dedos de las manos");
        this.jCheckBox88.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.26
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox88ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox88);
        this.jCheckBox88.setBounds(270, 260, 270, 23);
        this.jCheckBox89.setFont(new Font("Arial", 1, 12));
        this.jCheckBox89.setForeground(new Color(0, 102, 102));
        this.jCheckBox89.setText("Distingue: adelante-atras, arriba-abajo");
        this.jCheckBox89.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.27
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox89ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox89);
        this.jCheckBox89.setBounds(270, 280, 290, 23);
        this.jCheckBox90.setFont(new Font("Arial", 1, 12));
        this.jCheckBox90.setForeground(new Color(0, 102, 102));
        this.jCheckBox90.setText("Nombre 4-5 colores");
        this.jCheckBox90.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.28
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox90ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox90);
        this.jCheckBox90.setBounds(270, 300, 210, 23);
        this.jCheckBox91.setFont(new Font("Arial", 1, 12));
        this.jCheckBox91.setForeground(new Color(0, 0, 153));
        this.jCheckBox91.setText("Expresa opiniones");
        this.jCheckBox91.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.29
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox91ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox91);
        this.jCheckBox91.setBounds(270, 330, 210, 23);
        this.jCheckBox92.setFont(new Font("Arial", 1, 12));
        this.jCheckBox92.setForeground(new Color(0, 0, 153));
        this.jCheckBox92.setText("Conoce izquierda y derecha");
        this.jCheckBox92.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.30
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox92ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox92);
        this.jCheckBox92.setBounds(270, 350, 260, 23);
        this.jCheckBox93.setFont(new Font("Arial", 1, 12));
        this.jCheckBox93.setForeground(new Color(0, 0, 153));
        this.jCheckBox93.setText("Conoce días de la semana");
        this.jCheckBox93.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.31
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.jCheckBox93ActionPerformed(evt);
            }
        });
        this.panelAL.add(this.jCheckBox93);
        this.jCheckBox93.setBounds(270, 370, 210, 23);
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(new Color(0, 0, 153));
        this.jLabel26.setHorizontalAlignment(0);
        this.jLabel26.setText("< 1");
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setForeground(new Color(0, 102, 102));
        this.jLabel27.setHorizontalAlignment(0);
        this.jLabel27.setText("1 a 3");
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setForeground(new Color(0, 0, 153));
        this.jLabel28.setHorizontalAlignment(0);
        this.jLabel28.setText("4 a 6");
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setForeground(new Color(0, 102, 102));
        this.jLabel29.setHorizontalAlignment(0);
        this.jLabel29.setText("7 a 9");
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setForeground(new Color(0, 0, 153));
        this.jLabel30.setHorizontalAlignment(0);
        this.jLabel30.setText("10 a 12");
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setForeground(new Color(0, 102, 102));
        this.jLabel31.setHorizontalAlignment(0);
        this.jLabel31.setText("13 a 18");
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setForeground(new Color(0, 0, 153));
        this.jLabel32.setHorizontalAlignment(0);
        this.jLabel32.setText("19 a 24");
        this.jLabel32.setFocusable(false);
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setForeground(new Color(0, 102, 102));
        this.jLabel33.setHorizontalAlignment(0);
        this.jLabel33.setText("25 a 36");
        this.jLabel34.setFont(new Font("Arial", 1, 12));
        this.jLabel34.setForeground(new Color(0, 0, 153));
        this.jLabel34.setHorizontalAlignment(0);
        this.jLabel34.setText("37 a 48");
        this.jLabel35.setFont(new Font("Arial", 1, 12));
        this.jLabel35.setForeground(new Color(0, 102, 102));
        this.jLabel35.setHorizontalAlignment(0);
        this.jLabel35.setText("49 a 60");
        this.jLabel36.setFont(new Font("Arial", 1, 12));
        this.jLabel36.setForeground(new Color(0, 0, 153));
        this.jLabel36.setHorizontalAlignment(0);
        this.jLabel36.setText("61 a 72");
        this.jLabel37.setBackground(new Color(0, 51, 153));
        this.jLabel37.setFont(new Font("Arial", 1, 12));
        this.jLabel37.setForeground(new Color(0, 255, 255));
        this.jLabel37.setHorizontalAlignment(2);
        this.jLabel37.setText("EDAD EN MESES   CONCEPTO                                                                   CONCEPTO                                                             EDAD EN MESES");
        this.jLabel37.setOpaque(true);
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap(23, 32767).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel37, -2, 720, -2).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel31, -2, 50, -2).addComponent(this.jLabel30, -2, 50, -2).addComponent(this.jLabel29, -2, 50, -2).addComponent(this.jLabel28, -2, 50, -2).addComponent(this.jLabel27, -2, 50, -2).addComponent(this.jLabel26, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.panelAL, -2, 567, -2).addGap(18, 18, 18).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel36, -2, 50, -2).addComponent(this.jLabel35, -2, 50, -2).addComponent(this.jLabel34, -2, 50, -2).addComponent(this.jLabel33, -2, 50, -2).addComponent(this.jLabel32, -2, 50, -2)))).addGap(50, 50, 50)));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel37, -2, 20, -2).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jLabel26).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel27).addGap(65, 65, 65).addComponent(this.jLabel28).addGap(53, 53, 53).addComponent(this.jLabel29).addGap(69, 69, 69).addComponent(this.jLabel30).addGap(54, 54, 54).addComponent(this.jLabel31)).addGroup(jPanel10Layout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.jLabel32).addGap(62, 62, 62).addComponent(this.jLabel33).addGap(56, 56, 56).addComponent(this.jLabel34).addGap(66, 66, 66).addComponent(this.jLabel35).addGap(62, 62, 62).addComponent(this.jLabel36)).addGroup(jPanel10Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panelAL, -2, 403, -2))).addGap(49, 49, 49)));
        this.jTabbedPane1.addTab("Adición Lenguaje", this.jPanel10);
        add(this.jTabbedPane1);
        this.jTabbedPane1.setBounds(10, 50, 798, 470);
        this.label2.setBackground(new Color(0, 51, 153));
        this.label2.setFont(new Font("Arial", 1, 18));
        this.label2.setForeground(new Color(255, 255, 255));
        this.label2.setHorizontalAlignment(0);
        this.label2.setText("Sumatoria Total");
        this.label2.setOpaque(true);
        add(this.label2);
        this.label2.setBounds(190, 530, 160, 32);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(650, 530, 160, 32);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 204));
        this.label1.setHorizontalAlignment(2);
        this.label1.setText("Escala");
        this.label1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label1.setOpaque(true);
        add(this.label1);
        this.label1.setBounds(510, 530, 140, 32);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Arial", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder((Border) null);
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(350, 530, 160, 32);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 153));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.ValoracionLenguaje.32
            public void actionPerformed(ActionEvent evt) {
                ValoracionLenguaje.this.btnEscalaActionPerformed(evt);
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
    public void jCheckBox65ActionPerformed(ActionEvent evt) {
        puntuacionAL(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox64ActionPerformed(ActionEvent evt) {
        puntuacionAL(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox66ActionPerformed(ActionEvent evt) {
        puntuacionAL(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox67ActionPerformed(ActionEvent evt) {
        puntuacionAL(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox68ActionPerformed(ActionEvent evt) {
        puntuacionAL(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox69ActionPerformed(ActionEvent evt) {
        puntuacionAL(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox70ActionPerformed(ActionEvent evt) {
        puntuacionAL(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox71ActionPerformed(ActionEvent evt) {
        puntuacionAL(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox72ActionPerformed(ActionEvent evt) {
        puntuacionAL(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox73ActionPerformed(ActionEvent evt) {
        puntuacionAL(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox74ActionPerformed(ActionEvent evt) {
        puntuacionAL(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox75ActionPerformed(ActionEvent evt) {
        puntuacionAL(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox76ActionPerformed(ActionEvent evt) {
        puntuacionAL(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox77ActionPerformed(ActionEvent evt) {
        puntuacionAL(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox78ActionPerformed(ActionEvent evt) {
        puntuacionAL(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox79ActionPerformed(ActionEvent evt) {
        puntuacionAL(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox80ActionPerformed(ActionEvent evt) {
        puntuacionAL(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox81ActionPerformed(ActionEvent evt) {
        puntuacionAL(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox82ActionPerformed(ActionEvent evt) {
        puntuacionAL(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox83ActionPerformed(ActionEvent evt) {
        puntuacionAL(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox84ActionPerformed(ActionEvent evt) {
        puntuacionAL(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox85ActionPerformed(ActionEvent evt) {
        puntuacionAL(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox86ActionPerformed(ActionEvent evt) {
        puntuacionAL(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox87ActionPerformed(ActionEvent evt) {
        puntuacionAL(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox88ActionPerformed(ActionEvent evt) {
        puntuacionAL(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox89ActionPerformed(ActionEvent evt) {
        puntuacionAL(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox90ActionPerformed(ActionEvent evt) {
        puntuacionAL(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox91ActionPerformed(ActionEvent evt) {
        puntuacionAL(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox92ActionPerformed(ActionEvent evt) {
        puntuacionAL(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox93ActionPerformed(ActionEvent evt) {
        puntuacionAL(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox63ActionPerformed(ActionEvent evt) {
        puntuacionAL(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
    }
}
