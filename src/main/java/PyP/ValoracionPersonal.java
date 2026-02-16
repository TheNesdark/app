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

/* JADX INFO: loaded from: GenomaP.jar:PyP/ValoracionPersonal.class */
public class ValoracionPersonal extends JPanel {
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int puntajePS = 0;
    private int edad;
    private String sql;
    private String IdAtencion;
    private String idPaciente;
    private clasePyP clasepyp;
    private JButton btnEscala;
    private JCheckBox jCheckBox100;
    private JCheckBox jCheckBox101;
    private JCheckBox jCheckBox102;
    private JCheckBox jCheckBox103;
    private JCheckBox jCheckBox104;
    private JCheckBox jCheckBox105;
    private JCheckBox jCheckBox106;
    private JCheckBox jCheckBox107;
    private JCheckBox jCheckBox108;
    private JCheckBox jCheckBox109;
    private JCheckBox jCheckBox110;
    private JCheckBox jCheckBox111;
    private JCheckBox jCheckBox112;
    private JCheckBox jCheckBox113;
    private JCheckBox jCheckBox114;
    private JCheckBox jCheckBox115;
    private JCheckBox jCheckBox116;
    private JCheckBox jCheckBox117;
    private JCheckBox jCheckBox118;
    private JCheckBox jCheckBox119;
    private JCheckBox jCheckBox120;
    private JCheckBox jCheckBox121;
    private JCheckBox jCheckBox122;
    private JCheckBox jCheckBox123;
    private JCheckBox jCheckBox124;
    private JCheckBox jCheckBox94;
    private JCheckBox jCheckBox95;
    private JCheckBox jCheckBox96;
    private JCheckBox jCheckBox97;
    private JCheckBox jCheckBox98;
    private JCheckBox jCheckBox99;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JLabel jLabel40;
    private JLabel jLabel41;
    private JLabel jLabel42;
    private JLabel jLabel43;
    private JLabel jLabel44;
    private JLabel jLabel45;
    private JLabel jLabel46;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JPanel jPanel3;
    private JTabbedPane jTabbedPane1;
    private JLabel label1;
    private JLabel label3;
    private JPanel panelPS;
    private JTextField txtEscala;
    private JDateChooser txtFecha;
    private JTextField txtTotal;

    public ValoracionPersonal(clasePyP clase, String paciente, String Edad, String atencion) {
        initComponents();
        this.clasepyp = clase;
        this.idPaciente = paciente;
        this.edad = Integer.parseInt(Edad.substring(0, 2).trim());
        this.IdAtencion = atencion;
        navegar(4);
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, PSBajaIni, PSBajaFin, PSMediaIni, PSMediaFin, PSMediaAltaIni, PSMediaAltaFin, PSAltaIni FROM baseserver.p_param_crec_desarrollo";
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
                            if (rs.getMetaData().getColumnName(col).equals("PSBajaIni") || rs.getMetaData().getColumnName(col).equals("PSBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (rs.getMetaData().getColumnName(col).equals("PSMediaIni") || rs.getMetaData().getColumnName(col).equals("PSMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (rs.getMetaData().getColumnName(col).equals("PSMediaAltaIni") || rs.getMetaData().getColumnName(col).equals("PSMediaAltaFin")) {
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
            this.metodos.mostrarMensaje("Por favor evalue Personal Social");
            return;
        }
        this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', PersonalSocial ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.metodos.mostrarMensaje("Valoración Personal Social Modificada");
        navegar(4);
        this.consultas.cerrarConexionBd();
    }

    public void navegar(int op) {
        if (op == 1) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, PersonalSocial FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion ASC";
        } else if (op == 2) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, PersonalSocial FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion <'" + this.IdAtencion + "') ORDER BY IdAtencion DESC";
        } else if (op == 3) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, PersonalSocial FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion >'" + this.IdAtencion + "') ORDER BY IdAtencion ASC";
        } else if (op == 4) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, PersonalSocial FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion DESC";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            if (rs.getRow() > 0) {
                this.txtFecha.setDate(rs.getDate(3));
                puntuacionPS(rs.getInt(4) - 1);
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

    private void puntuacionPS(int p) {
        this.puntajePS = 0;
        for (int i = 0; i < this.panelPS.getComponentCount(); i++) {
            if (this.panelPS.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelPS.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajePS++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajePS));
        calcularEscala();
    }

    private void initComponents() {
        this.jLabel2 = new JLabel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jLabel38 = new JLabel();
        this.jLabel39 = new JLabel();
        this.jLabel40 = new JLabel();
        this.jLabel41 = new JLabel();
        this.jLabel42 = new JLabel();
        this.jLabel43 = new JLabel();
        this.jLabel44 = new JLabel();
        this.panelPS = new JPanel();
        this.jCheckBox94 = new JCheckBox();
        this.jCheckBox95 = new JCheckBox();
        this.jCheckBox96 = new JCheckBox();
        this.jCheckBox97 = new JCheckBox();
        this.jCheckBox98 = new JCheckBox();
        this.jCheckBox99 = new JCheckBox();
        this.jCheckBox100 = new JCheckBox();
        this.jCheckBox101 = new JCheckBox();
        this.jCheckBox102 = new JCheckBox();
        this.jCheckBox103 = new JCheckBox();
        this.jCheckBox104 = new JCheckBox();
        this.jCheckBox105 = new JCheckBox();
        this.jCheckBox106 = new JCheckBox();
        this.jCheckBox107 = new JCheckBox();
        this.jCheckBox108 = new JCheckBox();
        this.jCheckBox109 = new JCheckBox();
        this.jCheckBox110 = new JCheckBox();
        this.jCheckBox111 = new JCheckBox();
        this.jCheckBox112 = new JCheckBox();
        this.jCheckBox113 = new JCheckBox();
        this.jCheckBox114 = new JCheckBox();
        this.jCheckBox115 = new JCheckBox();
        this.jCheckBox116 = new JCheckBox();
        this.jCheckBox117 = new JCheckBox();
        this.jCheckBox118 = new JCheckBox();
        this.jCheckBox119 = new JCheckBox();
        this.jCheckBox120 = new JCheckBox();
        this.jCheckBox121 = new JCheckBox();
        this.jCheckBox122 = new JCheckBox();
        this.jCheckBox123 = new JCheckBox();
        this.jCheckBox124 = new JCheckBox();
        this.jLabel1 = new JLabel();
        this.jLabel45 = new JLabel();
        this.jLabel46 = new JLabel();
        this.jLabel47 = new JLabel();
        this.jLabel48 = new JLabel();
        this.label3 = new JLabel();
        this.txtTotal = new JTextField();
        this.label1 = new JLabel();
        this.txtEscala = new JTextField();
        this.btnEscala = new JButton();
        this.txtFecha = new JDateChooser();
        setName("ValoracionPersonal");
        setLayout(null);
        this.jLabel2.setBackground(new Color(0, 0, 153));
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(204, 255, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("VALORACIÓN DEL DESARROLLO POR CONDUCTAS");
        this.jLabel2.setOpaque(true);
        add(this.jLabel2);
        this.jLabel2.setBounds(0, 0, 820, 30);
        this.jTabbedPane1.setForeground(new Color(0, 102, 102));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jLabel38.setBackground(new Color(0, 51, 153));
        this.jLabel38.setFont(new Font("Arial", 1, 12));
        this.jLabel38.setForeground(new Color(0, 255, 255));
        this.jLabel38.setHorizontalAlignment(2);
        this.jLabel38.setText("EDAD EN MESES   CONCEPTO                                                            CONCEPTO                                                                         EDAD EN MESES");
        this.jLabel38.setOpaque(true);
        this.jLabel39.setFont(new Font("Arial", 1, 12));
        this.jLabel39.setForeground(new Color(0, 0, 153));
        this.jLabel39.setText("< 1");
        this.jLabel40.setFont(new Font("Arial", 1, 12));
        this.jLabel40.setForeground(new Color(0, 102, 102));
        this.jLabel40.setText("1 a 3");
        this.jLabel41.setFont(new Font("Arial", 1, 12));
        this.jLabel41.setForeground(new Color(0, 0, 153));
        this.jLabel41.setText("4 a 6");
        this.jLabel42.setFont(new Font("Arial", 1, 12));
        this.jLabel42.setForeground(new Color(0, 102, 102));
        this.jLabel42.setText("7 a 9");
        this.jLabel43.setFont(new Font("Arial", 1, 12));
        this.jLabel43.setForeground(new Color(0, 0, 153));
        this.jLabel43.setText("10 a 12");
        this.jLabel44.setFont(new Font("Arial", 1, 12));
        this.jLabel44.setForeground(new Color(0, 102, 102));
        this.jLabel44.setText("13 a 18");
        this.panelPS.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelPS.setLayout((LayoutManager) null);
        this.jCheckBox94.setFont(new Font("Tahoma", 1, 11));
        this.jCheckBox94.setForeground(new Color(0, 0, 153));
        this.jCheckBox94.setText("Sigue movimiento del rostro");
        this.jCheckBox94.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.1
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox94ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox94);
        this.jCheckBox94.setBounds(10, 0, 220, 23);
        this.jCheckBox95.setFont(new Font("Arial", 1, 12));
        this.jCheckBox95.setForeground(new Color(0, 102, 102));
        this.jCheckBox95.setText("Reconoce a la madre");
        this.jCheckBox95.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.2
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox95ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox95);
        this.jCheckBox95.setBounds(10, 30, 180, 23);
        this.jCheckBox96.setFont(new Font("Arial", 1, 12));
        this.jCheckBox96.setForeground(new Color(0, 102, 102));
        this.jCheckBox96.setText("Sonrie al acariciarlo");
        this.jCheckBox96.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.3
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox96ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox96);
        this.jCheckBox96.setBounds(10, 50, 180, 23);
        this.jCheckBox97.setFont(new Font("Arial", 1, 12));
        this.jCheckBox97.setForeground(new Color(0, 102, 102));
        this.jCheckBox97.setText("Se voltea cuando se le habla");
        this.jCheckBox97.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.4
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox97ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox97);
        this.jCheckBox97.setBounds(10, 70, 220, 23);
        this.jCheckBox98.setFont(new Font("Arial", 1, 12));
        this.jCheckBox98.setForeground(new Color(0, 0, 153));
        this.jCheckBox98.setText("Coge mano del examinador");
        this.jCheckBox98.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.5
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox98ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox98);
        this.jCheckBox98.setBounds(10, 100, 210, 23);
        this.jCheckBox99.setFont(new Font("Arial", 1, 12));
        this.jCheckBox99.setForeground(new Color(0, 0, 153));
        this.jCheckBox99.setText("Acepta y coge juguete");
        this.jCheckBox99.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.6
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox99ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox99);
        this.jCheckBox99.setBounds(10, 120, 190, 23);
        this.jCheckBox100.setFont(new Font("Arial", 1, 12));
        this.jCheckBox100.setForeground(new Color(0, 0, 153));
        this.jCheckBox100.setText("Pone atención a la conversación");
        this.jCheckBox100.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.7
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox100ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox100);
        this.jCheckBox100.setBounds(10, 140, 240, 23);
        this.jCheckBox101.setFont(new Font("Arial", 1, 12));
        this.jCheckBox101.setForeground(new Color(0, 102, 102));
        this.jCheckBox101.setText("Ayuda a sostener taza para beber");
        this.jCheckBox101.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.8
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox101ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox101);
        this.jCheckBox101.setBounds(10, 170, 240, 23);
        this.jCheckBox102.setFont(new Font("Arial", 1, 12));
        this.jCheckBox102.setForeground(new Color(0, 102, 102));
        this.jCheckBox102.setText("Reacciona a imagen en el espejo");
        this.jCheckBox102.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.9
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox102ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox102);
        this.jCheckBox102.setBounds(10, 190, 240, 23);
        this.jCheckBox103.setFont(new Font("Arial", 1, 12));
        this.jCheckBox103.setForeground(new Color(0, 102, 102));
        this.jCheckBox103.setText("Imita aplausos");
        this.jCheckBox103.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.10
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox103ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox103);
        this.jCheckBox103.setBounds(10, 210, 150, 23);
        this.jCheckBox104.setFont(new Font("Arial", 1, 12));
        this.jCheckBox104.setForeground(new Color(0, 0, 153));
        this.jCheckBox104.setText("Entrega juguete al examinador");
        this.jCheckBox104.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.11
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox104ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox104);
        this.jCheckBox104.setBounds(10, 240, 230, 23);
        this.jCheckBox105.setFont(new Font("Arial", 1, 12));
        this.jCheckBox105.setForeground(new Color(0, 0, 153));
        this.jCheckBox105.setText("Pide un juguete u objeto");
        this.jCheckBox105.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.12
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox105ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox105);
        this.jCheckBox105.setBounds(10, 260, 200, 23);
        this.jCheckBox106.setFont(new Font("Arial", 1, 12));
        this.jCheckBox106.setForeground(new Color(0, 0, 153));
        this.jCheckBox106.setText("Bebe en taza solo");
        this.jCheckBox106.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.13
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox106ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox106);
        this.jCheckBox106.setBounds(10, 280, 170, 23);
        this.jCheckBox107.setFont(new Font("Arial", 1, 12));
        this.jCheckBox107.setForeground(new Color(0, 102, 102));
        this.jCheckBox107.setText("Señala una prenda de vestir");
        this.jCheckBox107.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.14
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox107ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox107);
        this.jCheckBox107.setBounds(10, 310, 220, 23);
        this.jCheckBox108.setFont(new Font("Arial", 1, 12));
        this.jCheckBox108.setForeground(new Color(0, 102, 102));
        this.jCheckBox108.setText("Señala 2 partes del cuerpo");
        this.jCheckBox108.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.15
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox108ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox108);
        this.jCheckBox108.setBounds(10, 330, 210, 23);
        this.jCheckBox109.setFont(new Font("Arial", 1, 12));
        this.jCheckBox109.setForeground(new Color(0, 102, 102));
        this.jCheckBox109.setText("Avisa higiene personal");
        this.jCheckBox109.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.16
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox109ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox109);
        this.jCheckBox109.setBounds(10, 350, 190, 23);
        this.jCheckBox110.setFont(new Font("Arial", 1, 12));
        this.jCheckBox110.setForeground(new Color(0, 0, 153));
        this.jCheckBox110.setText("Señala 5 partes del cuerpo");
        this.jCheckBox110.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.17
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox110ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox110);
        this.jCheckBox110.setBounds(250, 30, 230, 23);
        this.jCheckBox111.setFont(new Font("Arial", 1, 12));
        this.jCheckBox111.setForeground(new Color(0, 0, 153));
        this.jCheckBox111.setText("Trata de contar experiencias");
        this.jCheckBox111.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.18
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox111ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox111);
        this.jCheckBox111.setBounds(250, 50, 200, 23);
        this.jCheckBox112.setFont(new Font("Arial", 1, 12));
        this.jCheckBox112.setForeground(new Color(0, 0, 153));
        this.jCheckBox112.setText("Control diurno de orina");
        this.jCheckBox112.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.19
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox112ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox112);
        this.jCheckBox112.setBounds(250, 70, 170, 23);
        this.jCheckBox113.setFont(new Font("Arial", 1, 12));
        this.jCheckBox113.setForeground(new Color(0, 102, 102));
        this.jCheckBox113.setText("Diferencia niño-niña");
        this.jCheckBox113.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.20
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox113ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox113);
        this.jCheckBox113.setBounds(250, 100, 190, 23);
        this.jCheckBox114.setFont(new Font("Arial", 1, 12));
        this.jCheckBox114.setForeground(new Color(0, 102, 102));
        this.jCheckBox114.setText("Dice nombre papá y mamá");
        this.jCheckBox114.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.21
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox114ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox114);
        this.jCheckBox114.setBounds(250, 120, 190, 23);
        this.jCheckBox115.setFont(new Font("Arial", 1, 12));
        this.jCheckBox115.setForeground(new Color(0, 102, 102));
        this.jCheckBox115.setText("Se baña solo manos y cara");
        this.jCheckBox115.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.22
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox115ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox115);
        this.jCheckBox115.setBounds(250, 140, 190, 23);
        this.jCheckBox116.setFont(new Font("Arial", 1, 12));
        this.jCheckBox116.setForeground(new Color(0, 0, 153));
        this.jCheckBox116.setText("Puede vestirse solo");
        this.jCheckBox116.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.23
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox116ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox116);
        this.jCheckBox116.setBounds(250, 170, 200, 23);
        this.jCheckBox117.setFont(new Font("Arial", 1, 12));
        this.jCheckBox117.setForeground(new Color(0, 0, 153));
        this.jCheckBox117.setText("Comparte juego con otros niños");
        this.jCheckBox117.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.24
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox117ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox117);
        this.jCheckBox117.setBounds(250, 190, 220, 23);
        this.jCheckBox118.setFont(new Font("Arial", 1, 12));
        this.jCheckBox118.setForeground(new Color(0, 0, 153));
        this.jCheckBox118.setText("Tiene amigo especial");
        this.jCheckBox118.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.25
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox118ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox118);
        this.jCheckBox118.setBounds(250, 210, 200, 23);
        this.jCheckBox119.setFont(new Font("Arial", 1, 12));
        this.jCheckBox119.setForeground(new Color(0, 102, 102));
        this.jCheckBox119.setText("Puede vestirse y desvertirse solo");
        this.jCheckBox119.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.26
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox119ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox119);
        this.jCheckBox119.setBounds(250, 240, 230, 23);
        this.jCheckBox120.setFont(new Font("Arial", 1, 12));
        this.jCheckBox120.setForeground(new Color(0, 102, 102));
        this.jCheckBox120.setText("Sabe cuantos años tiene");
        this.jCheckBox120.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.27
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox120ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox120);
        this.jCheckBox120.setBounds(250, 260, 210, 23);
        this.jCheckBox121.setFont(new Font("Arial", 1, 12));
        this.jCheckBox121.setForeground(new Color(0, 102, 102));
        this.jCheckBox121.setText("Organiza juegos");
        this.jCheckBox121.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.28
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox121ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox121);
        this.jCheckBox121.setBounds(250, 280, 210, 23);
        this.jCheckBox122.setFont(new Font("Arial", 1, 12));
        this.jCheckBox122.setForeground(new Color(0, 0, 153));
        this.jCheckBox122.setText("Hace \"mandados\"");
        this.jCheckBox122.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.29
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox122ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox122);
        this.jCheckBox122.setBounds(250, 310, 270, 23);
        this.jCheckBox123.setFont(new Font("Arial", 1, 12));
        this.jCheckBox123.setForeground(new Color(0, 0, 153));
        this.jCheckBox123.setText("Conoce nombre vereda-barrio o pueblo de residencia");
        this.jCheckBox123.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.30
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox123ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox123);
        this.jCheckBox123.setBounds(250, 330, 350, 23);
        this.jCheckBox124.setFont(new Font("Arial", 1, 12));
        this.jCheckBox124.setForeground(new Color(0, 0, 153));
        this.jCheckBox124.setText("Comenta vida familiar");
        this.jCheckBox124.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.31
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.jCheckBox124ActionPerformed(evt);
            }
        });
        this.panelPS.add(this.jCheckBox124);
        this.jCheckBox124.setBounds(250, 350, 270, 23);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 153));
        this.jLabel1.setText("19 a 24");
        this.jLabel45.setFont(new Font("Arial", 1, 12));
        this.jLabel45.setForeground(new Color(0, 102, 102));
        this.jLabel45.setText("25 a 36");
        this.jLabel46.setFont(new Font("Arial", 1, 12));
        this.jLabel46.setForeground(new Color(0, 0, 153));
        this.jLabel46.setText("37 a 48");
        this.jLabel47.setFont(new Font("Arial", 1, 12));
        this.jLabel47.setForeground(new Color(0, 102, 102));
        this.jLabel47.setText("49 a 60");
        this.jLabel48.setFont(new Font("Arial", 1, 12));
        this.jLabel48.setForeground(new Color(0, 0, 153));
        this.jLabel48.setText("61 a 72");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(34, 34, 34).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel41, -2, 50, -2).addGap(2, 2, 2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel40, -2, 50, -2).addComponent(this.jLabel39, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel43, -2, 50, -2).addComponent(this.jLabel42, -2, 50, -2).addComponent(this.jLabel44, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.panelPS, -2, 602, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel48).addComponent(this.jLabel47).addComponent(this.jLabel46).addComponent(this.jLabel45).addComponent(this.jLabel1))).addComponent(this.jLabel38, -2, 720, -2)).addContainerGap(39, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel38, -2, 20, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel39).addGap(18, 18, 18).addComponent(this.jLabel40).addGap(54, 54, 54).addComponent(this.jLabel41).addGap(54, 54, 54).addComponent(this.jLabel42).addGap(54, 54, 54).addComponent(this.jLabel43).addGap(54, 54, 54).addComponent(this.jLabel44)).addGroup(jPanel3Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.jLabel1).addGap(57, 57, 57).addComponent(this.jLabel45).addGap(55, 55, 55).addComponent(this.jLabel46).addGap(59, 59, 59).addComponent(this.jLabel47).addGap(57, 57, 57).addComponent(this.jLabel48)).addGroup(jPanel3Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.panelPS, -2, 380, -2))).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("Personal Social", this.jPanel3);
        add(this.jTabbedPane1);
        this.jTabbedPane1.setBounds(10, 50, 798, 440);
        this.label3.setBackground(new Color(0, 51, 153));
        this.label3.setFont(new Font("Arial", 1, 18));
        this.label3.setForeground(new Color(255, 255, 255));
        this.label3.setHorizontalAlignment(0);
        this.label3.setText("Sumatoria Total");
        this.label3.setOpaque(true);
        add(this.label3);
        this.label3.setBounds(190, 500, 160, 32);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Arial", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder((Border) null);
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(350, 500, 160, 32);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 204));
        this.label1.setHorizontalAlignment(0);
        this.label1.setText("Escala");
        this.label1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label1.setOpaque(true);
        add(this.label1);
        this.label1.setBounds(510, 500, 140, 32);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(650, 500, 160, 32);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 153));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.ValoracionPersonal.32
            public void actionPerformed(ActionEvent evt) {
                ValoracionPersonal.this.btnEscalaActionPerformed(evt);
            }
        });
        add(this.btnEscala);
        this.btnEscala.setBounds(10, 560, 800, 35);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        add(this.txtFecha);
        this.txtFecha.setBounds(10, 490, 170, 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox124ActionPerformed(ActionEvent evt) {
        puntuacionPS(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox123ActionPerformed(ActionEvent evt) {
        puntuacionPS(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox122ActionPerformed(ActionEvent evt) {
        puntuacionPS(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox121ActionPerformed(ActionEvent evt) {
        puntuacionPS(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox120ActionPerformed(ActionEvent evt) {
        puntuacionPS(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox119ActionPerformed(ActionEvent evt) {
        puntuacionPS(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox118ActionPerformed(ActionEvent evt) {
        puntuacionPS(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox117ActionPerformed(ActionEvent evt) {
        puntuacionPS(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox116ActionPerformed(ActionEvent evt) {
        puntuacionPS(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox115ActionPerformed(ActionEvent evt) {
        puntuacionPS(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox114ActionPerformed(ActionEvent evt) {
        puntuacionPS(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox113ActionPerformed(ActionEvent evt) {
        puntuacionPS(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox112ActionPerformed(ActionEvent evt) {
        puntuacionPS(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox111ActionPerformed(ActionEvent evt) {
        puntuacionPS(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox110ActionPerformed(ActionEvent evt) {
        puntuacionPS(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox109ActionPerformed(ActionEvent evt) {
        puntuacionPS(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox108ActionPerformed(ActionEvent evt) {
        puntuacionPS(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox107ActionPerformed(ActionEvent evt) {
        puntuacionPS(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox106ActionPerformed(ActionEvent evt) {
        puntuacionPS(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox105ActionPerformed(ActionEvent evt) {
        puntuacionPS(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox104ActionPerformed(ActionEvent evt) {
        puntuacionPS(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox103ActionPerformed(ActionEvent evt) {
        puntuacionPS(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox102ActionPerformed(ActionEvent evt) {
        puntuacionPS(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox101ActionPerformed(ActionEvent evt) {
        puntuacionPS(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox100ActionPerformed(ActionEvent evt) {
        puntuacionPS(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox99ActionPerformed(ActionEvent evt) {
        puntuacionPS(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox98ActionPerformed(ActionEvent evt) {
        puntuacionPS(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox97ActionPerformed(ActionEvent evt) {
        puntuacionPS(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox96ActionPerformed(ActionEvent evt) {
        puntuacionPS(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox95ActionPerformed(ActionEvent evt) {
        puntuacionPS(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox94ActionPerformed(ActionEvent evt) {
        puntuacionPS(0);
    }
}
