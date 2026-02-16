package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import General.Anular;
import General.JDBiometrico;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.IngresoOrdenSalidaDAO;
import com.genoma.plus.dao.impl.facturacion.IngresoOrdenSalidaDAOImpl;
import com.genoma.plus.dto.facturacion.IngresoOrdenSalidaDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JPOrdenSalidaIngreso.class */
public class JPOrdenSalidaIngreso extends JPanel {
    private int xestado = 1;
    private Metodos xmetodo = new Metodos();
    private IngresoOrdenSalidaDAO xIngresoOrdenSalidaDAO;
    private Long xId_Ingreso;
    private JButton JBTHuella;
    public JDateChooser JDFecha;
    private JLabel JLB_PersonaRh;
    private JLabel JLNOrden;
    private JPanel JPDatos;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JFormattedTextField JTFFHora;

    public JPOrdenSalidaIngreso(Long xId_Ingreso) {
        initComponents();
        this.xId_Ingreso = xId_Ingreso;
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xIngresoOrdenSalidaDAO = (IngresoOrdenSalidaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ingresoOrdenSalidaDAO");
    }

    public void mNuevo() {
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActualPC());
        this.JLNOrden.setText("0");
        this.JTAObservacion.setText("");
        this.JLB_PersonaRh.setText("");
        mBuscaDatos();
    }

    public void mGrabar() {
        System.out.println("Principal.usuarioSistemaDTO.getIdPersonaCargo() -> " + Principal.usuarioSistemaDTO.getIdPersonaCargo());
        if (this.JLNOrden.getText().equals("0")) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    IngresoOrdenSalidaDTO e = new IngresoOrdenSalidaDTO();
                    e.setIdIngreso(this.xId_Ingreso);
                    e.setFechaS(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
                    e.setHoraS(this.xmetodo.formatoH24.format(this.JTFFHora.getValue()));
                    e.setObservacion(this.JTAObservacion.getText());
                    e.setIdUsuarioRH(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                    this.xIngresoOrdenSalidaDAO.create_return_id(e);
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar una observacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTAObservacion.requestFocus();
            return;
        }
        IngresoOrdenSalidaDTO e2 = new IngresoOrdenSalidaDTO();
        e2.setId(Long.valueOf(this.JLNOrden.getText()));
        e2.setIdIngreso(this.xId_Ingreso);
        e2.setFechaS(this.xmetodo.formatoAMD1.format(this.JDFecha.getDate()));
        e2.setHoraS(this.xmetodo.formatoH24.format(this.JTFFHora.getValue()));
        e2.setObservacion(this.JTAObservacion.getText());
        e2.setIdUsuarioRH(Principal.usuarioSistemaDTO.getIdPersonaCargo());
        this.xIngresoOrdenSalidaDAO.actualizar(e2);
        mNuevo();
    }

    public void mImprimir() {
        System.out.println("" + this.xId_Ingreso);
        String[][] parametros = new String[4][2];
        parametros[0][0] = "idatencion1";
        parametros[0][1] = String.valueOf(this.xId_Ingreso);
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        parametros[3][0] = "nbreUsuario";
        parametros[3][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "H_Orden_Salida_Ingreso", parametros);
    }

    private void mBuscaDatos() {
        System.out.println("xId_Ingreso -> " + this.xId_Ingreso);
        List<IngresoOrdenSalidaDTO> list = this.xIngresoOrdenSalidaDAO.mListarOrdenSalida(this.xId_Ingreso);
        if (list.size() > 0) {
            this.JLNOrden.setText(list.get(0).getId().toString());
            this.JDFecha.setDate(Date.valueOf(list.get(0).getFechaS()));
            this.JTFFHora.setText(list.get(0).getHoraS());
            this.JTAObservacion.setText(list.get(0).getObservacion());
            System.out.println("Principal.usuarioSistemaDTO.getIdPersonaCargo() -> " + Principal.usuarioSistemaDTO.getIdPersonaCargo());
            System.out.println("list.get(0).getIdUsuarioRH().toString() .> " + list.get(0).getIdUsuarioRH().toString());
            if (list.get(0).getIdUsuarioRH().toString() != null || !list.get(0).getIdUsuarioRH().toString().isEmpty()) {
                String sql = "SELECT\nCONCAT(`g_persona`.`Nombre1`, ' ',`g_persona`.`Nombre2`,' ',`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`) AS nombre \nFROM\n    `baseserver`.`ingreso_orden_salida`\n    INNER JOIN `baseserver`.`rh_tipo_persona_cargon` \n        ON (`ingreso_orden_salida`.`IdUsuarioRH` = `rh_tipo_persona_cargon`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` \n        ON (`rh_tipo_persona_cargon`.`Id_Persona` = `g_persona`.`Id`)\n        where ingreso_orden_salida.`IdUsuarioRH` = " + list.get(0).getIdUsuarioRH().toString() + "\nGROUP BY g_persona.`Id`";
                System.out.println("usuario ->  " + sql);
                ConsultasMySQL xct = new ConsultasMySQL();
                ResultSet rs = xct.traerRs(sql);
                try {
                    if (rs.next()) {
                        System.out.println("rs -> " + rs.getString("nombre"));
                        String usuario = rs.getString("nombre");
                        this.JLB_PersonaRh.setText(usuario);
                    }
                    rs.close();
                    xct.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    xct.mostrarErrorSQL(ex);
                    return;
                }
            }
            this.JLB_PersonaRh.setText(Principal.usuarioSistemaDTO.getNombreUsuario());
            return;
        }
        this.JLB_PersonaRh.setText(Principal.usuarioSistemaDTO.getNombreUsuario() + " - " + Principal.usuarioSistemaDTO.getNombreCargoUsuario());
    }

    private void consultarLiquidacion() {
        IngresoOrdenSalidaDTO salida = this.xIngresoOrdenSalidaDAO.consultarEstadoLiquidacion(this.xId_Ingreso.longValue());
        this.xestado = salida.getEstado();
    }

    public void anular() {
        if (!this.JLNOrden.getText().equals("0")) {
            consultarLiquidacion();
            if (this.xestado == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "ORDEN_SALIDA", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            if (this.xestado == 1) {
                JOptionPane.showInternalMessageDialog(this, "N° Orden/Factura se encuentra armada y lista para presentarse", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            } else {
                if (this.xestado == 2) {
                    JOptionPane.showInternalMessageDialog(this, "N° Orden/Factura ya presentada;\nNo se puede anular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "No hay orden de salida para este ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void anular(String detalle) {
        IngresoOrdenSalidaDTO ordenSalida = new IngresoOrdenSalidaDTO();
        ordenSalida.setEstado(0);
        ordenSalida.setDetalleAnulacion(detalle);
        ordenSalida.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getLogin());
        ordenSalida.setFechaAnulacion(this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()));
        ordenSalida.setId(Long.valueOf(this.JLNOrden.getText()));
        this.xIngresoOrdenSalidaDAO.anular(ordenSalida);
    }

    private void initComponents() {
        this.JPDatos = new JPanel();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTFFHora = new JFormattedTextField();
        this.JBTHuella = new JButton();
        this.JLNOrden = new JLabel();
        this.JDFecha = new JDateChooser();
        this.JLB_PersonaRh = new JLabel();
        setName("xjpordensalidaingreso");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "ORDEN DE SALIDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setFont(new Font("Tahoma", 1, 12));
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JPOrdenSalidaIngreso.1
            public void actionPerformed(ActionEvent evt) {
                JPOrdenSalidaIngreso.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.JLNOrden.setFont(new Font("Arial", 1, 14));
        this.JLNOrden.setForeground(Color.blue);
        this.JLNOrden.setHorizontalAlignment(0);
        this.JLNOrden.setText("0");
        this.JLNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JLB_PersonaRh.setFont(new Font("Arial", 1, 12));
        this.JLB_PersonaRh.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario Sistemas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JDFecha, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 187, 32767).addComponent(this.JLNOrden, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHuella, -2, 50, -2)).addComponent(this.JSPObservacion)).addGap(10, 10, 10)).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JLB_PersonaRh, -1, -1, 32767).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JBTHuella, -2, 50, -2).addComponent(this.JLNOrden, -2, 50, -2).addComponent(this.JDFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_PersonaRh, -2, 50, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -1, -1, 32767).addGap(10, 10, 10)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        if (!this.JLNOrden.getText().equals("0")) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), this.JLNOrden.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe grabar una orden de salida para acceder a esta funcion", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }
}
