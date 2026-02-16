package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* JADX INFO: loaded from: GenomaP.jar:PyP/MotricidadGruesa.class */
public class MotricidadGruesa extends JPanel {
    private int edad;
    private String sql;
    private String idPaciente;
    private String IdAtencion;
    private JButton btnEscala;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox14;
    private JCheckBox jCheckBox15;
    private JCheckBox jCheckBox16;
    private JCheckBox jCheckBox17;
    private JCheckBox jCheckBox18;
    private JCheckBox jCheckBox19;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox20;
    private JCheckBox jCheckBox21;
    private JCheckBox jCheckBox22;
    private JCheckBox jCheckBox23;
    private JCheckBox jCheckBox24;
    private JCheckBox jCheckBox25;
    private JCheckBox jCheckBox26;
    private JCheckBox jCheckBox27;
    private JCheckBox jCheckBox28;
    private JCheckBox jCheckBox29;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox30;
    private JCheckBox jCheckBox31;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox9;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel4;
    private JLabel label;
    private JLabel label1;
    private JTabbedPane panel;
    private JPanel panelMG;
    private JTextField txtEscala;
    private JDateChooser txtFecha;
    private JTextField txtTotal;
    private int puntajeMG = 0;
    private int tipoGrabado = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public MotricidadGruesa(clasePyP clase, String paciente, String Edad, String atencion) {
        initComponents();
        this.idPaciente = paciente;
        this.edad = Integer.parseInt(Edad.substring(0, 2).trim());
        this.IdAtencion = atencion;
        navegar(4);
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, MGBajaIni, MGBajaFin, MGMediaIni, MGMediaFin, MGMedioAltoIni, MGMedioAltoFin, MGAltaIni FROM baseserver.p_param_crec_desarrollo";
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
                            if (rs.getMetaData().getColumnName(col).equals("MGBajaIni") || rs.getMetaData().getColumnName(col).equals("MGBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (rs.getMetaData().getColumnName(col).equals("MGMediaIni") || rs.getMetaData().getColumnName(col).equals("MGMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (rs.getMetaData().getColumnName(col).equals("MGMedioAltoIni") || rs.getMetaData().getColumnName(col).equals("MGMedioAltoFin")) {
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
            this.metodos.mostrarMensaje("Por favor evalue la Motricidad Gruesa");
            return;
        }
        this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Motora ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Valoración Motora Gruesa Grabada");
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
        navegar(4);
    }

    public void navegar(int op) {
        if (op == 1) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Motora FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion ASC";
        } else if (op == 2) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Motora FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion <'" + this.IdAtencion + "') ORDER BY IdAtencion DESC";
        } else if (op == 3) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Motora FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "' AND IdAtencion >'" + this.IdAtencion + "') ORDER BY IdAtencion ASC";
        } else if (op == 4) {
            this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Motora FROM p_atencioninfantilprescolar WHERE (IdPersona ='" + this.idPaciente + "') ORDER BY IdAtencion DESC";
        }
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            rs.next();
            if (rs.getRow() > 0) {
                this.txtFecha.setDate(rs.getDate(3));
                puntuacionMG(rs.getInt(4) - 1);
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
        Principal.txtFecha.setText(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
        this.tipoGrabado = 0;
    }

    private void puntuacionMG(int p) {
        this.puntajeMG = 0;
        for (int i = 0; i < this.panelMG.getComponentCount(); i++) {
            if (this.panelMG.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelMG.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajeMG++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajeMG));
        calcularEscala();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.panel = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.panelMG = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        this.jCheckBox11 = new JCheckBox();
        this.jCheckBox12 = new JCheckBox();
        this.jCheckBox13 = new JCheckBox();
        this.jCheckBox14 = new JCheckBox();
        this.jCheckBox15 = new JCheckBox();
        this.jCheckBox16 = new JCheckBox();
        this.jCheckBox17 = new JCheckBox();
        this.jCheckBox18 = new JCheckBox();
        this.jCheckBox19 = new JCheckBox();
        this.jCheckBox20 = new JCheckBox();
        this.jCheckBox21 = new JCheckBox();
        this.jCheckBox22 = new JCheckBox();
        this.jCheckBox23 = new JCheckBox();
        this.jCheckBox24 = new JCheckBox();
        this.jCheckBox25 = new JCheckBox();
        this.jCheckBox26 = new JCheckBox();
        this.jCheckBox27 = new JCheckBox();
        this.jCheckBox28 = new JCheckBox();
        this.jCheckBox29 = new JCheckBox();
        this.jCheckBox30 = new JCheckBox();
        this.jCheckBox31 = new JCheckBox();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.label = new JLabel();
        this.txtTotal = new JTextField();
        this.label1 = new JLabel();
        this.txtEscala = new JTextField();
        this.btnEscala = new JButton();
        this.txtFecha = new JDateChooser();
        setMaximumSize(new Dimension(1082, 496));
        setMinimumSize(new Dimension(1082, 496));
        setName("MotricidadGruesa");
        setLayout(null);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORACIÓN DEL DESARROLLO POR CONDUCTA");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(0, 0, 850, 30);
        this.panel.setForeground(new Color(0, 102, 102));
        this.panel.setFont(new Font("Arial", 1, 14));
        this.panel.setName("MotricidadGruesa");
        this.panel.setOpaque(true);
        this.jPanel4.setLayout((LayoutManager) null);
        this.jLabel2.setBackground(new Color(0, 51, 153));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 255, 255));
        this.jLabel2.setHorizontalAlignment(2);
        this.jLabel2.setText("EDAD EN MESES    CONCEPTO                                                 CONCEPTO                                                  EDAD EN MESES");
        this.jLabel2.setOpaque(true);
        this.jPanel4.add(this.jLabel2);
        this.jLabel2.setBounds(10, 10, 780, 20);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 153));
        this.jLabel3.setText("< 1");
        this.jPanel4.add(this.jLabel3);
        this.jLabel3.setBounds(10, 40, 50, 15);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 102, 102));
        this.jLabel4.setText("1 a 3");
        this.jPanel4.add(this.jLabel4);
        this.jLabel4.setBounds(10, 60, 50, 15);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("4 a 6");
        this.jPanel4.add(this.jLabel5);
        this.jLabel5.setBounds(10, 130, 50, 15);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 102, 102));
        this.jLabel6.setText("7 a 9");
        this.jPanel4.add(this.jLabel6);
        this.jLabel6.setBounds(10, 200, 50, 15);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 153));
        this.jLabel7.setText("10 a 12");
        this.jPanel4.add(this.jLabel7);
        this.jLabel7.setBounds(10, 280, 50, 15);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 102, 102));
        this.jLabel8.setText("13 a 18");
        this.jPanel4.add(this.jLabel8);
        this.jLabel8.setBounds(10, 340, 50, 15);
        this.panelMG.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelMG.setLayout((LayoutManager) null);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(0, 0, 153));
        this.jCheckBox1.setText("Patea Vigorosamente");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.1
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox1);
        this.jCheckBox1.setBounds(10, 0, 230, 23);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(new Color(0, 102, 102));
        this.jCheckBox2.setText("Levanta la cabeza en prona");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.2
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox2ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox2);
        this.jCheckBox2.setBounds(10, 20, 270, 23);
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(new Color(0, 102, 102));
        this.jCheckBox3.setText("Levanta la cabeza y pecho en prona");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.3
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox3ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox3);
        this.jCheckBox3.setBounds(10, 40, 280, 23);
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(new Color(0, 102, 102));
        this.jCheckBox4.setText("Sostiene la cabeza al levantarlo de los brazos");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.4
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox4ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox4);
        this.jCheckBox4.setBounds(10, 60, 330, 23);
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(new Color(0, 0, 153));
        this.jCheckBox5.setText("Control de cabeza sentado");
        this.jCheckBox5.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.5
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox5ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox5);
        this.jCheckBox5.setBounds(10, 90, 240, 23);
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(new Color(0, 0, 153));
        this.jCheckBox6.setText("Se voltea de un lado a otro");
        this.jCheckBox6.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.6
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox6ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox6);
        this.jCheckBox6.setBounds(10, 110, 210, 23);
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(new Color(0, 0, 153));
        this.jCheckBox7.setText("Intenta sentarse solo");
        this.jCheckBox7.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.7
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox7ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox7);
        this.jCheckBox7.setBounds(10, 130, 230, 23);
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(new Color(0, 102, 102));
        this.jCheckBox8.setText("Se sostiene sentado con ayuda");
        this.jCheckBox8.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.8
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox8ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox8);
        this.jCheckBox8.setBounds(10, 160, 260, 23);
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(new Color(0, 102, 102));
        this.jCheckBox9.setText("Se arrastra en posición prona");
        this.jCheckBox9.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.9
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox9ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox9);
        this.jCheckBox9.setBounds(10, 180, 240, 23);
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(new Color(0, 102, 102));
        this.jCheckBox10.setText("Se sienta por si solo");
        this.jCheckBox10.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.10
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox10ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox10);
        this.jCheckBox10.setBounds(10, 200, 190, 23);
        this.jCheckBox11.setFont(new Font("Arial", 1, 12));
        this.jCheckBox11.setForeground(new Color(0, 0, 153));
        this.jCheckBox11.setText("Gatea bien");
        this.jCheckBox11.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.11
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox11ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox11);
        this.jCheckBox11.setBounds(10, 230, 110, 23);
        this.jCheckBox12.setFont(new Font("Arial", 1, 12));
        this.jCheckBox12.setForeground(new Color(0, 0, 153));
        this.jCheckBox12.setText("Se agarra y sostiene de pie");
        this.jCheckBox12.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.12
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox12ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox12);
        this.jCheckBox12.setBounds(10, 250, 200, 23);
        this.jCheckBox13.setFont(new Font("Arial", 1, 12));
        this.jCheckBox13.setForeground(new Color(0, 0, 153));
        this.jCheckBox13.setText("Se para solo");
        this.jCheckBox13.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.13
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox13ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox13);
        this.jCheckBox13.setBounds(10, 270, 160, 23);
        this.jCheckBox14.setFont(new Font("Arial", 1, 12));
        this.jCheckBox14.setForeground(new Color(0, 102, 102));
        this.jCheckBox14.setText("Da pasito solo");
        this.jCheckBox14.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.14
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox14ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox14);
        this.jCheckBox14.setBounds(10, 300, 140, 23);
        this.jCheckBox15.setFont(new Font("Arial", 1, 12));
        this.jCheckBox15.setForeground(new Color(0, 102, 102));
        this.jCheckBox15.setText("Camina solo bien");
        this.jCheckBox15.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.15
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox15ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox15);
        this.jCheckBox15.setBounds(10, 320, 170, 23);
        this.jCheckBox16.setFont(new Font("Arial", 1, 12));
        this.jCheckBox16.setForeground(new Color(0, 102, 102));
        this.jCheckBox16.setText("Corre");
        this.jCheckBox16.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.16
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox16ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox16);
        this.jCheckBox16.setBounds(10, 340, 110, 23);
        this.jCheckBox17.setFont(new Font("Arial", 1, 12));
        this.jCheckBox17.setForeground(new Color(0, 0, 153));
        this.jCheckBox17.setText("Patea la pelota");
        this.jCheckBox17.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.17
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox17ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox17);
        this.jCheckBox17.setBounds(350, 20, 130, 23);
        this.jCheckBox18.setFont(new Font("Arial", 1, 12));
        this.jCheckBox18.setForeground(new Color(0, 0, 153));
        this.jCheckBox18.setText("Lanza la pelota con las manos");
        this.jCheckBox18.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.18
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox18ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox18);
        this.jCheckBox18.setBounds(350, 40, 220, 23);
        this.jCheckBox19.setFont(new Font("Arial", 1, 12));
        this.jCheckBox19.setForeground(new Color(0, 0, 153));
        this.jCheckBox19.setText("Salta en los 2 pies");
        this.jCheckBox19.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.19
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox19ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox19);
        this.jCheckBox19.setBounds(350, 60, 180, 23);
        this.jCheckBox20.setFont(new Font("Arial", 1, 12));
        this.jCheckBox20.setForeground(new Color(0, 102, 102));
        this.jCheckBox20.setText("Se empina en ambos pies");
        this.jCheckBox20.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.20
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox20ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox20);
        this.jCheckBox20.setBounds(350, 90, 230, 23);
        this.jCheckBox21.setFont(new Font("Arial", 1, 12));
        this.jCheckBox21.setForeground(new Color(0, 102, 102));
        this.jCheckBox21.setText("Se levanta sin usar las manos");
        this.jCheckBox21.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.21
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox21ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox21);
        this.jCheckBox21.setBounds(350, 110, 240, 23);
        this.jCheckBox22.setFont(new Font("Arial", 1, 12));
        this.jCheckBox22.setForeground(new Color(0, 102, 102));
        this.jCheckBox22.setText("Camina hacia atrás");
        this.jCheckBox22.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.22
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox22ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox22);
        this.jCheckBox22.setBounds(350, 130, 180, 23);
        this.jCheckBox23.setFont(new Font("Arial", 1, 12));
        this.jCheckBox23.setForeground(new Color(0, 0, 153));
        this.jCheckBox23.setText("Camina en punta de pies");
        this.jCheckBox23.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.23
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox23ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox23);
        this.jCheckBox23.setBounds(350, 160, 180, 23);
        this.jCheckBox24.setFont(new Font("Arial", 1, 12));
        this.jCheckBox24.setForeground(new Color(0, 0, 153));
        this.jCheckBox24.setText("Se para en un solo pie");
        this.jCheckBox24.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.24
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox24ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox24);
        this.jCheckBox24.setBounds(350, 180, 220, 23);
        this.jCheckBox25.setFont(new Font("Arial", 1, 12));
        this.jCheckBox25.setForeground(new Color(0, 0, 153));
        this.jCheckBox25.setText("Lanza y agrarra la pelota");
        this.jCheckBox25.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.25
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox25ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox25);
        this.jCheckBox25.setBounds(350, 200, 230, 23);
        this.jCheckBox26.setFont(new Font("Arial", 1, 12));
        this.jCheckBox26.setForeground(new Color(0, 102, 102));
        this.jCheckBox26.setText("Camina en línea recta");
        this.jCheckBox26.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.26
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox26ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox26);
        this.jCheckBox26.setBounds(350, 230, 230, 23);
        this.jCheckBox27.setFont(new Font("Arial", 1, 12));
        this.jCheckBox27.setForeground(new Color(0, 102, 102));
        this.jCheckBox27.setText("Tres o mas pasos en un pie");
        this.jCheckBox27.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.27
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox27ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox27);
        this.jCheckBox27.setBounds(350, 250, 250, 23);
        this.jCheckBox28.setFont(new Font("Arial", 1, 12));
        this.jCheckBox28.setForeground(new Color(0, 102, 102));
        this.jCheckBox28.setText("Hace rebotar y agarra la pelota");
        this.jCheckBox28.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.28
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox28ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox28);
        this.jCheckBox28.setBounds(350, 270, 230, 23);
        this.jCheckBox29.setFont(new Font("Arial", 1, 12));
        this.jCheckBox29.setForeground(new Color(0, 0, 153));
        this.jCheckBox29.setText("Salta a pies juntillas cuerda a 25 cms");
        this.jCheckBox29.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.29
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox29ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox29);
        this.jCheckBox29.setBounds(350, 300, 260, 23);
        this.jCheckBox30.setFont(new Font("Arial", 1, 12));
        this.jCheckBox30.setForeground(new Color(0, 0, 153));
        this.jCheckBox30.setText("Hace \"Caballitos\" alternando los pies");
        this.jCheckBox30.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.30
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox30ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox30);
        this.jCheckBox30.setBounds(350, 320, 260, 23);
        this.jCheckBox31.setFont(new Font("Arial", 1, 12));
        this.jCheckBox31.setForeground(new Color(0, 0, 153));
        this.jCheckBox31.setText("Salta desde 60 cms de altura");
        this.jCheckBox31.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.31
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.jCheckBox31ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox31);
        this.jCheckBox31.setBounds(350, 340, 220, 23);
        this.jPanel4.add(this.panelMG);
        this.panelMG.setBounds(60, 40, 620, 370);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 153));
        this.jLabel9.setText("19 a 24");
        this.jLabel9.setFocusable(false);
        this.jPanel4.add(this.jLabel9);
        this.jLabel9.setBounds(690, 60, 50, 15);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 102, 102));
        this.jLabel10.setText("25 a 36");
        this.jPanel4.add(this.jLabel10);
        this.jLabel10.setBounds(690, 130, 50, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 153));
        this.jLabel11.setText("37 a 48");
        this.jPanel4.add(this.jLabel11);
        this.jLabel11.setBounds(690, 200, 50, 15);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 102, 102));
        this.jLabel12.setText("49 a 60");
        this.jPanel4.add(this.jLabel12);
        this.jLabel12.setBounds(690, 270, 50, 15);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 153));
        this.jLabel13.setText("61 a 72");
        this.jPanel4.add(this.jLabel13);
        this.jLabel13.setBounds(690, 340, 50, 15);
        this.panel.addTab("Motricidad Gruesa", this.jPanel4);
        add(this.panel);
        this.panel.setBounds(10, 40, 820, 450);
        this.label.setBackground(new Color(0, 51, 153));
        this.label.setFont(new Font("Arial", 1, 18));
        this.label.setForeground(new Color(255, 255, 204));
        this.label.setHorizontalAlignment(2);
        this.label.setText("Sumatoria Total");
        this.label.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label.setOpaque(true);
        add(this.label);
        this.label.setBounds(190, 510, 160, 30);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Tahoma", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(350, 510, 160, 30);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 204));
        this.label1.setHorizontalAlignment(2);
        this.label1.setText("Escala");
        this.label1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label1.setOpaque(true);
        this.label1.addAncestorListener(new AncestorListener() { // from class: PyP.MotricidadGruesa.32
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                MotricidadGruesa.this.label1AncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        add(this.label1);
        this.label1.setBounds(510, 510, 160, 30);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(670, 510, 160, 30);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 153));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.MotricidadGruesa.33
            public void actionPerformed(ActionEvent evt) {
                MotricidadGruesa.this.btnEscalaActionPerformed(evt);
            }
        });
        add(this.btnEscala);
        this.btnEscala.setBounds(10, 565, 820, 40);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        add(this.txtFecha);
        this.txtFecha.setBounds(10, 500, 170, 60);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox2ActionPerformed(ActionEvent evt) {
        puntuacionMG(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox3ActionPerformed(ActionEvent evt) {
        puntuacionMG(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox4ActionPerformed(ActionEvent evt) {
        puntuacionMG(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox5ActionPerformed(ActionEvent evt) {
        puntuacionMG(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox6ActionPerformed(ActionEvent evt) {
        puntuacionMG(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox7ActionPerformed(ActionEvent evt) {
        puntuacionMG(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox8ActionPerformed(ActionEvent evt) {
        puntuacionMG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox9ActionPerformed(ActionEvent evt) {
        puntuacionMG(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox10ActionPerformed(ActionEvent evt) {
        puntuacionMG(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox11ActionPerformed(ActionEvent evt) {
        puntuacionMG(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox12ActionPerformed(ActionEvent evt) {
        puntuacionMG(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox13ActionPerformed(ActionEvent evt) {
        puntuacionMG(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox14ActionPerformed(ActionEvent evt) {
        puntuacionMG(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox15ActionPerformed(ActionEvent evt) {
        puntuacionMG(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox16ActionPerformed(ActionEvent evt) {
        puntuacionMG(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox17ActionPerformed(ActionEvent evt) {
        puntuacionMG(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox18ActionPerformed(ActionEvent evt) {
        puntuacionMG(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox19ActionPerformed(ActionEvent evt) {
        puntuacionMG(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox20ActionPerformed(ActionEvent evt) {
        puntuacionMG(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox21ActionPerformed(ActionEvent evt) {
        puntuacionMG(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox22ActionPerformed(ActionEvent evt) {
        puntuacionMG(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox23ActionPerformed(ActionEvent evt) {
        puntuacionMG(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox24ActionPerformed(ActionEvent evt) {
        puntuacionMG(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox25ActionPerformed(ActionEvent evt) {
        puntuacionMG(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox26ActionPerformed(ActionEvent evt) {
        puntuacionMG(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox27ActionPerformed(ActionEvent evt) {
        puntuacionMG(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox28ActionPerformed(ActionEvent evt) {
        puntuacionMG(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox29ActionPerformed(ActionEvent evt) {
        puntuacionMG(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox30ActionPerformed(ActionEvent evt) {
        puntuacionMG(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox31ActionPerformed(ActionEvent evt) {
        puntuacionMG(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        puntuacionMG(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void label1AncestorAdded(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
    }
}
