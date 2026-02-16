package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:PyP/CACervixCorreo.class */
public class CACervixCorreo extends JInternalFrame {
    private String sql;
    private clasePyP clasepyp;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JLabel lblProgreso;
    private JTextField txtCorreo;
    private JCalendar txtFechaFinal;
    private JCalendar txtFechaInicio;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String ultimaCit = "";
    private String resultado = "";

    public CACervixCorreo(clasePyP clase) {
        initComponents();
        this.clasepyp = clase;
        this.lblProgreso.setVisible(false);
    }

    private void buscarAnterior(String idPersona) {
        String[] strArr = new String[2];
        String[] result = this.clasepyp.getCitologiaAnterior(idPersona, Principal.txtNo.getText());
        this.ultimaCit = result[0];
        this.resultado = result[1];
    }

    private void enviarCorreo() {
        if (this.metodos.getPregunta("Esta seguro de Enviar las tomas por Correo?") == 0 && validarDatos() == 1) {
            this.lblProgreso.setVisible(true);
            boolean enviado = true;
            new File("C:/Genoma/reportes/P_EnvioCitologia.pdf");
            this.sql = "SELECT p_citologia.Id, p_citologia.Id_Persona, w_profesional.NProfesional, w_profesional.Especialidad, p_citologia.FechaToma, p_citologia.FechaToma FROM p_citologia INNER JOIN baseserver.w_profesional ON (p_citologia.Id_Profesional = w_profesional.Id_Persona) WHERE (p_citologia.FechaToma >='" + this.metodos.formatoAMD.format(this.txtFechaInicio.getDate()) + "' AND p_citologia.FechaToma <='" + this.metodos.formatoAMD.format(this.txtFechaFinal.getDate()) + "') GROUP BY p_citologia.Id";
            ResultSet rs = this.consultas.traerRs(this.sql);
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        String fecha = (this.metodos.formatoDMA.format((Date) rs.getDate("FechaToma")).toString().substring(0, 2) + this.metodos.formatoDMA.format((Date) rs.getDate("FechaToma")).toString().substring(3, 5)) + this.metodos.formatoDMA.format((Date) rs.getDate("FechaToma")).toString().substring(6, 10);
                        buscarAnterior(rs.getString("Id_Persona"));
                        String[][] parametros = new String[8][2];
                        parametros[0][0] = "Id";
                        parametros[0][1] = rs.getString("Id");
                        parametros[1][0] = "profesional";
                        parametros[1][1] = rs.getString("NProfesional");
                        parametros[2][0] = "cargo";
                        parametros[2][1] = rs.getString("Especialidad");
                        parametros[3][0] = "fechaUlt";
                        parametros[3][1] = this.ultimaCit;
                        parametros[4][0] = "resultado";
                        parametros[4][1] = this.resultado;
                        parametros[5][0] = "ruta";
                        parametros[5][1] = this.metodos.getRutaRep();
                        parametros[6][0] = "SUBREPORT_DIR";
                        parametros[6][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                        parametros[7][0] = "SUBREPORTFIRMA_DIR";
                        parametros[7][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                        String adjunto = this.metodos.getRutaRep() + "P_EnvioCitologia";
                        this.metodos.CrearPDF(adjunto, parametros);
                        String adjunto2 = "C:/Genoma/reportes/" + fecha + "_" + rs.getString("Id_Persona") + ".pdf";
                        File f1 = new File("C:/Genoma/reportes/P_EnvioCitologia.pdf");
                        File f2 = new File(adjunto2);
                        boolean renombrado = f1.renameTo(f2);
                        if (renombrado) {
                            String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                            String mensaje = "Hola anexo archivo de la toma de citologías realizada el " + this.metodos.formatoDMA.format(this.txtFechaInicio.getDate());
                            Email correo = new Email();
                            List<String> correoE = new ArrayList<>();
                            correoE.add(this.txtCorreo.getText());
                            correo.enviarAdjunto(correoE, mensaje, remite, "Envio de Nuestras del " + this.metodos.formatoDMA.format(this.txtFechaInicio.getDate()) + " para Citologías ", fecha + "_" + rs.getString("Id_Persona") + ".pdf", f2.toString());
                            f2.delete();
                            enviado = true;
                        } else {
                            enviado = false;
                            this.metodos.mostrarMensaje("Hubo un error al renombrar el archivo PDF");
                        }
                    }
                    rs.close();
                    this.consultas.cerrarConexionBd();
                    this.lblProgreso.setVisible(false);
                    if (enviado) {
                        this.metodos.mostrarMensaje("Se enviaron los Correos exitosamente");
                    }
                }
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
            }
        }
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtCorreo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite la Dirección de Correo donde se enviarán las tomas realizadas");
            this.txtCorreo.requestFocus();
        } else {
            int encontrado = 0;
            int f = 0;
            while (true) {
                if (f >= this.txtCorreo.getText().length()) {
                    break;
                }
                if (!this.txtCorreo.getText().substring(f, f + 1).equals("@")) {
                    f++;
                } else {
                    encontrado = 1;
                    break;
                }
            }
            if (encontrado == 0) {
                this.metodos.mostrarMensaje("Por favor coloque el simbolo de arroba @ a la dirección de Correo donde se enviarán las tomas realizadas");
                this.txtCorreo.requestFocus();
            } else {
                retorno = 1;
            }
        }
        return retorno;
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.txtFechaInicio = new JCalendar();
        this.txtFechaFinal = new JCalendar();
        this.jLabel4 = new JLabel();
        this.txtCorreo = new JTextField();
        this.jLabel5 = new JLabel();
        this.jButton1 = new JButton();
        this.lblProgreso = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("PROGRAMA DE CA DE CERVIX");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(937, 443));
        setName("CACervixCorreo");
        setPreferredSize(new Dimension(937, 443));
        this.jLabel1.setBackground(new Color(0, 0, 102));
        this.jLabel1.setFont(new Font("Arial", 1, 16));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("ENVIO DE TOMA DE CITOLOGIAS");
        this.jLabel1.setOpaque(true);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Rango de Fechas", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel1.setFont(new Font("Tahoma", 1, 12));
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 0, 102));
        this.jLabel2.setText("Fecha de Inicio");
        this.jLabel2.setOpaque(true);
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setForeground(new Color(0, 0, 102));
        this.jLabel3.setText("Fecha Final");
        this.jLabel3.setOpaque(true);
        this.txtFechaInicio.setFont(new Font("Arial", 1, 12));
        this.txtFechaInicio.setWeekOfYearVisible(false);
        this.txtFechaFinal.setFont(new Font("Arial", 1, 12));
        this.txtFechaFinal.setWeekOfYearVisible(false);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaInicio, -2, 304, -2).addComponent(this.jLabel2, -2, 162, -2)).addGap(27, 27, 27).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaFinal, -2, 286, -2).addComponent(this.jLabel3, -2, 140, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaFinal, -1, 206, 32767).addComponent(this.txtFechaInicio, -1, 206, 32767)).addContainerGap()));
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setForeground(new Color(0, 0, 153));
        this.jLabel4.setText("Dirección de Correo de Destino");
        this.txtCorreo.setFont(new Font("Arial", 1, 14));
        this.txtCorreo.setText("laboratorio@fundacionpanzenu.org.co");
        this.jLabel5.setFont(new Font("Tahoma", 1, 18));
        this.jLabel5.setForeground(new Color(0, 0, 204));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo.jpg")));
        this.jLabel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel5.setHorizontalTextPosition(0);
        this.jLabel5.setVerticalTextPosition(3);
        this.jLabel5.addMouseListener(new MouseAdapter() { // from class: PyP.CACervixCorreo.1
            public void mouseClicked(MouseEvent evt) {
                CACervixCorreo.this.jLabel5MouseClicked(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setForeground(new Color(0, 0, 102));
        this.jButton1.setText("Enviar Correo");
        this.jButton1.addActionListener(new ActionListener() { // from class: PyP.CACervixCorreo.2
            public void actionPerformed(ActionEvent evt) {
                CACervixCorreo.this.jButton1ActionPerformed(evt);
            }
        });
        this.lblProgreso.setFont(new Font("Arial", 1, 14));
        this.lblProgreso.setForeground(new Color(0, 0, 153));
        this.lblProgreso.setHorizontalAlignment(0);
        this.lblProgreso.setText("Envio de Correos en Progreso, Por Favor Espere...");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.lblProgreso, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.jLabel5, -1, -1, 32767))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.txtCorreo))).addContainerGap(15, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 28, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCorreo, -2, 35, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblProgreso).addContainerGap(34, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jLabel5MouseClicked(MouseEvent evt) {
        enviarCorreo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        enviarCorreo();
    }
}
