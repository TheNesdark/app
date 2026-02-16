package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/aprobo_termino.class */
public class aprobo_termino extends JInternalFrame {
    private String[] xidarea;
    private String[] xidtipo;
    private String[] xidestado;
    public DefaultTableModel xmodelo;
    public String sql;
    public Object[] dato;
    public claseMantenimiento Cmantenimiento;
    Color xcolor;
    private JButton jButton1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane12;
    private JTextArea txtdes;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private ConsultasMySQL xconsulta2 = new ConsultasMySQL();
    private char xevaluacion = 'P';
    private Metodos Fecha = new Metodos();
    public boolean lleno = false;
    private Metodos xmetodo = new Metodos();

    public aprobo_termino() {
        initComponents();
        consultar();
    }

    private void consultar() {
        String cons = "SELECT     sis_cambios.Tipo , sis_cambios.Descripcion,  CONCAT( `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`)AS persona  FROM   baseserver.g_persona INNER JOIN baseserver.sis_cambios  ON (g_persona.Id = sis_cambios.Id_persona)WHERE (sis_cambios.Id = '" + Principal.txtNo.getText() + "')";
        ResultSet Rf = this.xconsulta.traerRs(cons);
        System.out.print(cons);
        try {
            if (Rf.next()) {
                Rf.first();
                this.txtdes.setText(Rf.getString(2));
                this.jLabel3.setText(Rf.getString(1));
                this.jLabel4.setText(Rf.getString(3));
            }
            Rf.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Seguimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void initComponents() {
        this.jScrollPane12 = new JScrollPane();
        this.txtdes = new JTextArea();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SOLO PERSONAL DE SISTEMAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.txtdes.setEditable(false);
        this.txtdes.setBackground(new Color(153, 153, 255));
        this.txtdes.setColumns(7);
        this.txtdes.setFont(new Font("Arial", 1, 12));
        this.txtdes.setForeground(new Color(255, 255, 255));
        this.txtdes.setRows(1);
        this.txtdes.setText(" ");
        this.txtdes.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion de la Solicitud", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane12.setViewportView(this.txtdes);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(0, 102, 51));
        this.jLabel1.setText("Tipo:");
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 51));
        this.jLabel2.setText("Quien la Solicita:");
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setText("Tipo:");
        this.jLabel4.setFont(new Font("Arial", 1, 14));
        this.jLabel4.setText("Quien la Solicita:");
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Modificar29x27.png")));
        this.jButton1.setText("CERRAR SOLICITUD");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.aprobo_termino.1
            public void actionPerformed(ActionEvent evt) {
                aprobo_termino.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, GroupLayout.Alignment.LEADING, -1, 671, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane12, -1, 671, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addGap(165, 165, 165).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4)))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane12, -2, 164, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4)).addGap(18, 18, 18).addComponent(this.jButton1, -2, 35, -2).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        aprobar();
    }

    public void aprobar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql3 = " UPDATE sis_cambios set Estado =3  WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sql3);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mandacorreo();
            }
        }
    }

    private void mandacorreo() {
        String correo = "SELECT g_persona.Correo FROM baseserver.g_persona INNER JOIN baseserver.sis_cambios ON (g_persona.Id = sis_cambios.Id_persona) WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        String mensaje = "La solicitud que usted paso a sistemas ya ha sido desarrollada \n\nDescripcion de la Solicitud:  " + this.txtdes.getText();
        Email em = new Email();
        em.Send("sistemas@fundacionpazenu.org.co", mensaje, datos, " RESPUESTA DE SOLICITUD A SISTEMAS ");
    }
}
