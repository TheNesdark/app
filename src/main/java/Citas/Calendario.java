package Citas;

import Cirugia.JIF_Programacion_Cx;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JADX INFO: loaded from: GenomaP.jar:Citas/Calendario.class */
public class Calendario extends JPanel {
    private int ultimoDia;
    public JButton boton;
    private String[] lisDiasFestivos;
    private String nbreMes;
    private String xAno;
    private String xMes;
    private String xDia;
    private String sql;
    private ResultSet rs;
    private String xNombre;
    private JButton btn1;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton btn17;
    private JButton btn18;
    private JButton btn19;
    private JButton btn2;
    private JButton btn20;
    private JButton btn21;
    private JButton btn22;
    private JButton btn23;
    private JButton btn24;
    private JButton btn25;
    private JButton btn26;
    private JButton btn27;
    private JButton btn28;
    private JButton btn29;
    private JButton btn3;
    private JButton btn30;
    private JButton btn31;
    private JButton btn32;
    private JButton btn33;
    private JButton btn34;
    private JButton btn35;
    private JButton btn36;
    private JButton btn37;
    private JButton btn38;
    private JButton btn39;
    private JButton btn4;
    private JButton btn40;
    private JButton btn41;
    private JButton btn42;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    public JComboBox cboMes;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JPanel jPanel4;
    public JPanel panelDias;
    public JSpinner txtAno;
    private GregorianCalendar fecha = new GregorianCalendar();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private int filaListaDiasConCita = 0;
    public String[][] listaDiasConCita = new String[1000][7];
    private CitasGral frmCita = null;
    private CitaTerapia frmCitaT = null;
    private CitasInterEspecial frmCitaIC = null;
    private JIF_Programacion_Cx xJif_PCx = null;

    public Calendario(JInternalFrame frm) {
        initComponents();
        casting(frm);
        cargarDiasFestivos();
        iniciar();
    }

    public GregorianCalendar getFecha() {
        return this.fecha;
    }

    public String getDia() {
        if (this.xDia.length() == 1) {
            this.xDia = "0" + this.xDia;
        }
        return this.xDia;
    }

    public String getMes() {
        if (this.xMes.length() == 1) {
            this.xMes = "0" + this.xMes;
        }
        return this.xMes;
    }

    public String getAno() {
        return this.xAno;
    }

    public int getTieneCita(String xfecha) {
        int tiene = 0;
        for (int f = 0; f < this.listaDiasConCita.length && this.listaDiasConCita[f][0] != null; f++) {
            if (this.listaDiasConCita[f][0].equals(xfecha)) {
                tiene = 1;
            }
        }
        return tiene;
    }

    private String getUltimoDiaMes() {
        double r = (Integer.parseInt(getAno()) / 4) * 4;
        if (getMes().equals("00")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("01")) {
            if (r == Integer.parseInt(getAno())) {
                this.ultimoDia = 29;
            } else {
                this.ultimoDia = 28;
            }
        } else if (getMes().equals("02")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("03")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("04")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("05")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("06") || getMes().equals("07")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("08")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("09")) {
            this.ultimoDia = 31;
        } else if (getMes().equals("10")) {
            this.ultimoDia = 30;
        } else if (getMes().equals("11")) {
            this.ultimoDia = 31;
        }
        return String.valueOf(this.ultimoDia);
    }

    public void setFecha(String ano, String mes, String dia) {
        this.fecha.set(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
    }

    public void setDia(String dia) {
        if (dia.length() != 1) {
            this.xDia = dia;
        } else {
            this.xDia = "0" + dia;
        }
    }

    public void setMes(String mes) {
        if (mes.length() != 1) {
            this.xMes = mes;
        } else {
            this.xMes = "0" + mes;
        }
    }

    public void setAno(String ano) {
        this.xAno = ano;
    }

    private void setColocarEtiquetaDia() {
    }

    public void setMarcarBoton(String dia, String ruta) {
        for (int b = 0; b < this.panelDias.getComponentCount(); b++) {
            this.boton = this.panelDias.getComponent(b);
            if (this.boton.getText() != null && Integer.parseInt(this.boton.getText()) == Integer.parseInt(dia)) {
                this.boton.setFont(new Font("Arial", 0, 12));
                this.boton.setForeground(new Color(0, 0, 102));
                this.boton.setIcon(new ImageIcon(getClass().getResource(ruta)));
                return;
            }
        }
    }

    public void setClickBoton(String dia) {
        for (int b = 0; b < this.panelDias.getComponentCount(); b++) {
            this.boton = this.panelDias.getComponent(b);
            if (this.boton.getText() != null && Integer.parseInt(this.boton.getText()) == Integer.parseInt(dia)) {
                this.boton.doClick();
                return;
            }
        }
    }

    private void buscarCita(JButton xBoton) {
        if (xBoton.getIcon() == null) {
            this.metodos.mostrarMensaje("Lo siento, No hay Programación de Citas para esa fecha.\nDia : " + xBoton.getText() + "\nMes : " + this.cboMes.getSelectedItem() + "\nAño : " + this.txtAno.getValue());
            return;
        }
        this.metodos.limpiarDatosPrincipal();
        this.xDia = xBoton.getText();
        setFecha(getAno(), getMes(), this.xDia);
        for (int i = 0; i < this.panelDias.getComponentCount(); i++) {
            this.boton = this.panelDias.getComponent(i);
            this.boton.setBackground(new Color(236, 233, 216));
        }
        this.boton = xBoton;
        this.boton.setBackground(new Color(0, 102, 102));
        colocarEtiquetaFecha();
        if (this.frmCita != null) {
            this.frmCita.cargarHorarioGrid();
        } else if (this.frmCitaT != null) {
            this.frmCitaT.cargarHorarioGrid();
        } else if (this.xJif_PCx != null) {
            this.xJif_PCx.mCargarHorarioGrid();
        }
    }

    private void cargarDiasFestivos() {
        try {
            this.sql = "SELECT FechaFestivo FROM g_diafestivo where Estado=1 ORDER BY FechaFestivo Asc";
            this.rs = this.consultas.traerRs(this.sql);
            this.rs.last();
            this.lisDiasFestivos = new String[this.rs.getRow()];
            int i = 0;
            this.rs.beforeFirst();
            while (this.rs.next()) {
                this.lisDiasFestivos[i] = this.rs.getString(1);
                i++;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void casting(JInternalFrame frm) {
        this.xNombre = frm.getName();
        if (frm.getName().equals("Citas")) {
            this.frmCita = (CitasGral) frm;
            return;
        }
        if (frm.getName().equals("CitaTerapia")) {
            this.frmCitaT = (CitaTerapia) frm;
        } else if (frm.getName().equals("CitaInterconsulta")) {
            this.frmCitaIC = (CitasInterEspecial) frm;
        } else if (frm.getName().equals("xjig_programacion_cx")) {
            this.xJif_PCx = (JIF_Programacion_Cx) frm;
        }
    }

    public void colocarEtiquetaFecha() {
        if (this.frmCita != null) {
            this.frmCita.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, this.metodos.formatoFecha.format(this.fecha.getTime()).toUpperCase(), 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        }
    }

    private void iniciar() {
        int mes = Integer.parseInt(this.metodos.formatoAMD.format(this.metodos.getFechaActual()).toString().substring(6, 7)) - 1;
        setAno(this.metodos.formatoAMD.format(this.metodos.getFechaActual()).toString().substring(0, 4));
        setMes(String.valueOf(mes));
        setDia(this.metodos.formatoAMD.format(this.metodos.getFechaActual()).toString().substring(8, 10));
        if (getMes().equals("00")) {
            this.nbreMes = "Enero";
        } else if (getMes().equals("01")) {
            this.nbreMes = "Febrero";
        } else if (getMes().equals("02")) {
            this.nbreMes = "Marzo";
        } else if (getMes().equals("03")) {
            this.nbreMes = "Abril";
        } else if (getMes().equals("04")) {
            this.nbreMes = "Mayo";
        } else if (getMes().equals("05")) {
            this.nbreMes = "Junio";
        } else if (getMes().equals("06")) {
            this.nbreMes = "Julio";
        } else if (getMes().equals("07")) {
            this.nbreMes = "Agosto";
        } else if (getMes().equals("08")) {
            this.nbreMes = "Septiembre";
        } else if (getMes().equals("09")) {
            this.nbreMes = "Octubre";
        } else if (getMes().equals("10")) {
            this.nbreMes = "Noviembre";
        } else if (getMes().equals("11")) {
            this.nbreMes = "Diciembre";
        }
        setFecha(getAno(), getMes(), getDia());
        this.cboMes.setSelectedItem(mTraerMes());
        this.txtAno.setValue(Integer.valueOf(this.metodos.formatoANO.format(this.metodos.getFechaActual())));
    }

    private String mTraerMes() {
        String mes = "";
        String.valueOf(this.metodos.getFechaActual());
        try {
            ResultSet xrs = this.consultas.traerRs("SELECT CONCAT(UCASE(MID(LOWER(DevuelveMes(NOW())),1,1)),MID(LOWER(DevuelveMes(NOW())),2,LENGTH(DevuelveMes(NOW())))) AS NFecha");
            if (xrs.next()) {
                xrs.first();
                mes = xrs.getString(1);
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return mes;
    }

    public void limpiarListaDiasConCita() {
        for (int i = 0; i < 1000; i++) {
            this.listaDiasConCita[i][0] = null;
            this.listaDiasConCita[i][1] = null;
            this.listaDiasConCita[i][2] = null;
            this.listaDiasConCita[i][3] = null;
            this.listaDiasConCita[i][4] = null;
            this.listaDiasConCita[i][5] = null;
            this.listaDiasConCita[i][6] = null;
        }
    }

    public void montarAgendaGeneral(String idProfesional, String idEspecial) {
        String ymes = String.valueOf(Integer.parseInt(getMes()) + 1);
        if (ymes.length() == 1) {
            ymes = "0" + ymes;
        }
        if (this.xNombre.equals("xjig_programacion_cx")) {
            this.sql = "SELECT `q_confsalacirugias`.`Fecha_Conf` , `q_confsalacirugias`.`DiaSemana`  , `q_confsalacirugias`.`HoraInicial` , `q_confsalacirugias`.`HoraFinal` , `q_salacirugias`.`Nbre` , 0 AS `Cupo` FROM `q_confsalacirugias` INNER JOIN  `q_salacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) WHERE (`q_salacirugias`.`Nbre` ='" + idProfesional + "' and `q_confsalacirugias`.`Fecha_Conf` <='" + getAno() + "/" + ymes + "/" + getUltimoDiaMes() + "' AND TipoAgenda = 1 ) ";
        } else {
            this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.DiaSemana, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Cupo FROM c_confcitas INNER JOIN c_consultorio ON (c_confcitas.Id_Consultorio = c_consultorio.Id) WHERE (c_confcitas.Id_Profesional ='" + idProfesional + "' AND c_confcitas.Id_Especialidad ='" + idEspecial + "' AND c_confcitas.Fecha_ConfCitas <='" + getAno() + "/" + ymes + "/" + getUltimoDiaMes() + "' AND TipoAgenda = 1 AND c_confcitas.Estado = 0 ) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.DiaSemana ASC, c_confcitas.HoraInicial ASC";
        }
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.filaListaDiasConCita = 0;
            int fila = 1;
            while (this.rs.next()) {
                for (int f = this.rs.getInt(2); f <= 42; f += 7) {
                    if (f >= Integer.parseInt(this.rs.getString(1).substring(8, 10)) || (f <= Integer.parseInt(this.rs.getString(1).substring(8, 10)) && Integer.parseInt(ymes) > Integer.parseInt(this.rs.getString(1).substring(5, 7)) && Integer.parseInt(getAno()) >= Integer.parseInt(this.rs.getString(1).substring(0, 4)))) {
                        if (this.filaListaDiasConCita > 1000) {
                            break;
                        }
                        this.boton = this.panelDias.getComponent(f);
                        if (this.panelDias.getComponent(f).isEnabled() && !this.boton.getForeground().equals(new Color(204, 0, 0))) {
                            setMarcarBoton(this.boton.getText(), "/Imagenes/Cita.png");
                            this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                            if (this.xNombre.equals("xjig_programacion_cx")) {
                                this.listaDiasConCita[this.filaListaDiasConCita][1] = "";
                                this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                                this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                                this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                                this.listaDiasConCita[this.filaListaDiasConCita][5] = "1";
                                this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(6);
                            } else {
                                this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(3);
                                this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(4);
                                this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(5);
                                this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(6);
                                this.listaDiasConCita[this.filaListaDiasConCita][5] = "1";
                                this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                            }
                            this.filaListaDiasConCita = fila;
                            fila++;
                        }
                    }
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public void montarAgendaEspecial(String idProfesional, String idEspecial) {
        if (this.xNombre.equals("xjig_programacion_cx")) {
            this.sql = "SELECT `q_confsalacirugias`.`Fecha_Conf` , `q_confsalacirugias`.`DiaSemana`  , `q_confsalacirugias`.`HoraInicial` , `q_confsalacirugias`.`HoraFinal` , `q_salacirugias`.`Nbre` , 0 AS `Cupo` FROM `q_confsalacirugias` INNER JOIN  `q_salacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) WHERE (`q_salacirugias`.`Nbre` ='" + idProfesional + "' and MONTH(`q_confsalacirugias`.`Fecha_Conf`) ='" + (Integer.parseInt(getMes()) + 1) + "' and YEAR(`q_confsalacirugias`.`Fecha_Conf`) ='" + getAno() + "' AND TipoAgenda = 2 ) ";
        } else {
            this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Id_Profesional, c_confcitas.Cupo FROM baseserver.c_consultorio INNER JOIN baseserver.c_confcitas ON (c_consultorio.Id = c_confcitas.Id_Consultorio) WHERE (MONTH(c_confcitas.Fecha_ConfCitas) ='" + (Integer.parseInt(getMes()) + 1) + "' AND YEAR(c_confcitas.Fecha_ConfCitas) ='" + getAno() + "' AND c_confcitas.TipoAgenda =2 AND c_confcitas.Id_Profesional ='" + idProfesional + "' AND c_confcitas.Id_Especialidad ='" + idEspecial + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.HoraInicial ASC";
        }
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.listaDiasConCita[this.filaListaDiasConCita][0] = this.rs.getString(1).substring(8, 10);
                if (this.xNombre.equals("xjig_programacion_cx")) {
                    this.listaDiasConCita[this.filaListaDiasConCita][1] = "";
                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "2";
                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(6);
                } else {
                    this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(2);
                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "2";
                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                }
                setMarcarBoton(this.rs.getString(1).substring(8, 10), "/Imagenes/CitaEspecial.png");
                this.filaListaDiasConCita++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorE(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void montarAgendaExcepcion(String idProfesional, String idEspecial) {
        if (this.xNombre.equals("xjig_programacion_cx")) {
            this.sql = "SELECT `q_confsalacirugias`.`Fecha_Conf` , `q_confsalacirugias`.`DiaSemana`  , `q_confsalacirugias`.`HoraInicial` , `q_confsalacirugias`.`HoraFinal` , `q_salacirugias`.`Nbre` , 0 AS `Cupo` FROM `q_confsalacirugias` INNER JOIN  `q_salacirugias`  ON (`q_confsalacirugias`.`Id_SalaCirugia` = `q_salacirugias`.`Id`) WHERE (`q_salacirugias`.`Nbre` ='" + idProfesional + "' and MONTH(`q_confsalacirugias`.`Fecha_Conf`) ='" + (Integer.parseInt(getMes()) + 1) + "' and YEAR(`q_confsalacirugias`.`Fecha_Conf`) ='" + getAno() + "' AND TipoAgenda = 3 ) ";
        } else {
            this.sql = "SELECT c_confcitas.Fecha_ConfCitas, c_confcitas.Id_Consultorio, c_confcitas.HoraInicial, c_confcitas.HoraFinal, c_consultorio.Nbre, c_confcitas.Id_Profesional, c_confcitas.Cupo FROM baseserver.c_consultorio INNER JOIN baseserver.c_confcitas ON (c_consultorio.Id = c_confcitas.Id_Consultorio) WHERE (MONTH(c_confcitas.Fecha_ConfCitas) ='" + (Integer.parseInt(getMes()) + 1) + "' AND YEAR(c_confcitas.Fecha_ConfCitas) ='" + getAno() + "' AND c_confcitas.TipoAgenda =3 AND c_confcitas.Id_Profesional ='" + idProfesional + "' AND c_confcitas.Id_Especialidad ='" + idEspecial + "' AND c_confcitas.Estado = 0) ORDER BY c_confcitas.Fecha_ConfCitas ASC, c_confcitas.HoraInicial ASC";
        }
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            if (this.rs.getRow() > 0) {
                this.rs.beforeFirst();
                while (this.rs.next()) {
                    int u = Integer.parseInt(this.rs.getString(1).substring(8, 10)) - 1;
                    while (true) {
                        if (u < 42) {
                            this.boton = this.panelDias.getComponent(u);
                            if (this.boton.getText() == null || Integer.parseInt(this.boton.getText()) != Integer.parseInt(this.rs.getString(1).substring(8, 10)) || !this.boton.isEnabled()) {
                                u++;
                            } else {
                                setMarcarBoton(this.rs.getString(1).substring(8, 10), "/Imagenes/CitaExcepcion.png");
                                this.listaDiasConCita[this.filaListaDiasConCita][0] = this.boton.getText();
                                if (this.xNombre.equals("xjig_programacion_cx")) {
                                    this.listaDiasConCita[this.filaListaDiasConCita][1] = "";
                                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "3";
                                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(6);
                                } else {
                                    this.listaDiasConCita[this.filaListaDiasConCita][1] = this.rs.getString(2);
                                    this.listaDiasConCita[this.filaListaDiasConCita][2] = this.rs.getString(3);
                                    this.listaDiasConCita[this.filaListaDiasConCita][3] = this.rs.getString(4);
                                    this.listaDiasConCita[this.filaListaDiasConCita][4] = this.rs.getString(5);
                                    this.listaDiasConCita[this.filaListaDiasConCita][5] = "3";
                                    this.listaDiasConCita[this.filaListaDiasConCita][6] = this.rs.getString(7);
                                }
                                this.filaListaDiasConCita++;
                            }
                        }
                    }
                }
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public void refrescar() {
        String xdia = "01";
        setAno(this.txtAno.getValue().toString());
        setMes(String.valueOf(this.cboMes.getSelectedIndex()));
        setFecha(getAno(), getMes(), xdia);
        getUltimoDiaMes();
        int xColumna = this.fecha.get(7) - 1;
        setColocarEtiquetaDia();
        for (int i = 0; i < this.panelDias.getComponentCount(); i++) {
            this.boton = this.panelDias.getComponent(i);
            this.boton.setText((String) null);
            this.boton.setIcon((Icon) null);
            this.boton.setEnabled(false);
            this.boton.setForeground(new Color(0, 0, 102));
            this.boton.setFont(new Font("Arial", 0, 12));
        }
        for (int i2 = xColumna; i2 < this.panelDias.getComponentCount(); i2++) {
            this.boton = this.panelDias.getComponent(i2);
            this.boton.setText(String.valueOf(xdia));
            this.boton.setEnabled(true);
            String xmes = String.valueOf(Integer.parseInt(getMes()) + 1);
            if (xmes.length() == 1) {
                xmes = "0" + xmes;
            }
            String fecBoton = getAno() + "-" + xmes + "-" + xdia;
            for (int df = 0; df < this.lisDiasFestivos.length; df++) {
                if (this.lisDiasFestivos[df].equals(fecBoton)) {
                    this.boton.setForeground(new Color(204, 0, 0));
                    this.boton.setFont(new Font("Arial", 1, 12));
                }
            }
            xdia = String.valueOf(Integer.parseInt(xdia) + 1);
            if (xdia.length() == 1) {
                xdia = "0" + xdia;
            }
            if (Integer.parseInt(xdia) > this.ultimoDia) {
                return;
            }
        }
    }

    private void refrescarDias() {
        if (this.frmCita != null) {
            if (this.frmCita.listaProfesional[this.frmCita.filaArbol][0] != null) {
                this.frmCita.crearGrid();
                this.frmCita.cargarAgenda();
                return;
            } else {
                refrescar();
                return;
            }
        }
        if (this.frmCitaT != null && this.frmCitaT.filaArbol > 0) {
            if (this.frmCitaT.listaProfesional[this.frmCitaT.filaArbol][0] != null) {
                this.frmCitaT.crearGrid();
                this.frmCitaT.cargarAgenda();
                return;
            } else {
                refrescar();
                return;
            }
        }
        if (this.xJif_PCx != null && this.xJif_PCx.xlleno) {
            refrescar();
            return;
        }
        if (this.frmCitaIC != null && this.frmCitaIC.cboProfesional.getSelectedIndex() != -1) {
            if (this.frmCitaIC.cboProfesional.getSelectedIndex() != -1) {
                this.frmCitaIC.crearGrid();
                this.frmCitaIC.cargarAgenda();
            } else {
                refrescar();
            }
        }
    }

    private void initComponents() {
        this.cboMes = new JComboBox();
        this.txtAno = new JSpinner();
        this.jPanel4 = new JPanel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.panelDias = new JPanel();
        this.btn1 = new JButton();
        this.btn2 = new JButton();
        this.btn3 = new JButton();
        this.btn4 = new JButton();
        this.btn5 = new JButton();
        this.btn6 = new JButton();
        this.btn7 = new JButton();
        this.btn8 = new JButton();
        this.btn9 = new JButton();
        this.btn10 = new JButton();
        this.btn11 = new JButton();
        this.btn12 = new JButton();
        this.btn13 = new JButton();
        this.btn14 = new JButton();
        this.btn15 = new JButton();
        this.btn16 = new JButton();
        this.btn17 = new JButton();
        this.btn18 = new JButton();
        this.btn19 = new JButton();
        this.btn20 = new JButton();
        this.btn21 = new JButton();
        this.btn22 = new JButton();
        this.btn23 = new JButton();
        this.btn24 = new JButton();
        this.btn25 = new JButton();
        this.btn26 = new JButton();
        this.btn27 = new JButton();
        this.btn28 = new JButton();
        this.btn29 = new JButton();
        this.btn30 = new JButton();
        this.btn31 = new JButton();
        this.btn32 = new JButton();
        this.btn33 = new JButton();
        this.btn34 = new JButton();
        this.btn35 = new JButton();
        this.btn36 = new JButton();
        this.btn37 = new JButton();
        this.btn38 = new JButton();
        this.btn39 = new JButton();
        this.btn40 = new JButton();
        this.btn41 = new JButton();
        this.btn42 = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "CALENDARIO DE PROGRAMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setMaximumSize(new Dimension(312, 285));
        setMinimumSize(new Dimension(312, 285));
        setName("Calendario");
        this.cboMes.setFont(new Font("Arial", 1, 12));
        this.cboMes.setModel(new DefaultComboBoxModel(new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
        JComboBox jComboBox = this.cboMes;
        Calendar.getInstance();
        jComboBox.setSelectedIndex(2);
        this.cboMes.addItemListener(new ItemListener() { // from class: Citas.Calendario.1
            public void itemStateChanged(ItemEvent evt) {
                Calendario.this.cboMesItemStateChanged(evt);
            }
        });
        this.txtAno.setFont(new Font("Arial", 1, 12));
        this.txtAno.setValue(2010);
        this.txtAno.addChangeListener(new ChangeListener() { // from class: Citas.Calendario.2
            public void stateChanged(ChangeEvent evt) {
                Calendario.this.txtAnoStateChanged(evt);
            }
        });
        this.jPanel4.setBackground(new Color(0, 0, 153));
        this.jPanel4.setBorder(BorderFactory.createBevelBorder(0, Color.white, Color.white, (Color) null, (Color) null));
        this.jPanel4.setLayout((LayoutManager) null);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(255, 255, 255));
        this.jLabel10.setText("Lun");
        this.jPanel4.add(this.jLabel10);
        this.jLabel10.setBounds(60, 0, 21, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(255, 255, 255));
        this.jLabel11.setText("Mar");
        this.jPanel4.add(this.jLabel11);
        this.jLabel11.setBounds(100, 0, 30, 15);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(255, 255, 255));
        this.jLabel12.setText("Mie");
        this.jPanel4.add(this.jLabel12);
        this.jLabel12.setBounds(140, 0, 30, 15);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(255, 255, 255));
        this.jLabel13.setText("Vie");
        this.jPanel4.add(this.jLabel13);
        this.jLabel13.setBounds(220, 0, 30, 15);
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(255, 255, 255));
        this.jLabel14.setText("Jue");
        this.jPanel4.add(this.jLabel14);
        this.jLabel14.setBounds(180, 0, 30, 15);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(204, 0, 0));
        this.jLabel15.setText("Dom");
        this.jPanel4.add(this.jLabel15);
        this.jLabel15.setBounds(10, 0, 30, 15);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(255, 255, 255));
        this.jLabel16.setText("Sab");
        this.jPanel4.add(this.jLabel16);
        this.jLabel16.setBounds(250, 0, 30, 15);
        this.panelDias.setBorder(BorderFactory.createBevelBorder(0));
        this.panelDias.setName("panelDias");
        this.panelDias.setPreferredSize(new Dimension(100, 100));
        this.panelDias.setLayout((LayoutManager) null);
        this.btn1.setFont(new Font("Arial", 1, 12));
        this.btn1.setForeground(new Color(204, 0, 0));
        this.btn1.setText("1");
        this.btn1.setBorder((Border) null);
        this.btn1.setHorizontalTextPosition(4);
        this.btn1.setIconTextGap(1);
        this.btn1.setName("btn1");
        this.btn1.addActionListener(new ActionListener() { // from class: Citas.Calendario.3
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn1ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn1);
        this.btn1.setBounds(10, 10, 40, 25);
        this.btn2.setFont(new Font("Arial", 1, 12));
        this.btn2.setForeground(new Color(0, 0, 102));
        this.btn2.setText("2");
        this.btn2.setBorder((Border) null);
        this.btn2.setHorizontalTextPosition(4);
        this.btn2.setIconTextGap(1);
        this.btn2.setName("btn2");
        this.btn2.addActionListener(new ActionListener() { // from class: Citas.Calendario.4
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn2ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn2);
        this.btn2.setBounds(50, 10, 40, 25);
        this.btn3.setFont(new Font("Arial", 1, 12));
        this.btn3.setForeground(new Color(0, 0, 102));
        this.btn3.setText("3");
        this.btn3.setBorder((Border) null);
        this.btn3.setHorizontalTextPosition(4);
        this.btn3.setIconTextGap(1);
        this.btn3.setName("btn3");
        this.btn3.addActionListener(new ActionListener() { // from class: Citas.Calendario.5
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn3ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn3);
        this.btn3.setBounds(90, 10, 40, 25);
        this.btn4.setFont(new Font("Arial", 1, 12));
        this.btn4.setForeground(new Color(0, 0, 102));
        this.btn4.setText("4");
        this.btn4.setBorder((Border) null);
        this.btn4.setHorizontalTextPosition(4);
        this.btn4.setIconTextGap(1);
        this.btn4.setName("btn4");
        this.btn4.addActionListener(new ActionListener() { // from class: Citas.Calendario.6
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn4ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn4);
        this.btn4.setBounds(130, 10, 40, 25);
        this.btn5.setFont(new Font("Arial", 1, 12));
        this.btn5.setText("5");
        this.btn5.setBorder((Border) null);
        this.btn5.setHorizontalTextPosition(4);
        this.btn5.setIconTextGap(1);
        this.btn5.setName("btn5");
        this.btn5.addActionListener(new ActionListener() { // from class: Citas.Calendario.7
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn5ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn5);
        this.btn5.setBounds(170, 10, 40, 25);
        this.btn6.setFont(new Font("Arial", 1, 12));
        this.btn6.setForeground(new Color(0, 0, 102));
        this.btn6.setText("6");
        this.btn6.setBorder((Border) null);
        this.btn6.setHorizontalTextPosition(4);
        this.btn6.setIconTextGap(1);
        this.btn6.setName("btn6");
        this.btn6.addActionListener(new ActionListener() { // from class: Citas.Calendario.8
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn6ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn6);
        this.btn6.setBounds(210, 10, 40, 25);
        this.btn7.setFont(new Font("Arial", 1, 12));
        this.btn7.setForeground(new Color(0, 0, 102));
        this.btn7.setText("7");
        this.btn7.setBorder((Border) null);
        this.btn7.setHorizontalTextPosition(4);
        this.btn7.setIconTextGap(1);
        this.btn7.setName("btn7");
        this.btn7.addActionListener(new ActionListener() { // from class: Citas.Calendario.9
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn7ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn7);
        this.btn7.setBounds(250, 10, 35, 25);
        this.btn8.setFont(new Font("Arial", 1, 12));
        this.btn8.setForeground(new Color(204, 0, 0));
        this.btn8.setText("8");
        this.btn8.setBorder((Border) null);
        this.btn8.setHorizontalTextPosition(4);
        this.btn8.setIconTextGap(1);
        this.btn8.setName("btn8");
        this.btn8.addActionListener(new ActionListener() { // from class: Citas.Calendario.10
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn8ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn8);
        this.btn8.setBounds(10, 40, 40, 25);
        this.btn9.setFont(new Font("Arial", 1, 12));
        this.btn9.setForeground(new Color(0, 0, 102));
        this.btn9.setText("9");
        this.btn9.setBorder((Border) null);
        this.btn9.setHorizontalTextPosition(4);
        this.btn9.setIconTextGap(1);
        this.btn9.setName("btn9");
        this.btn9.addActionListener(new ActionListener() { // from class: Citas.Calendario.11
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn9ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn9);
        this.btn9.setBounds(50, 40, 40, 25);
        this.btn10.setFont(new Font("Arial", 1, 12));
        this.btn10.setForeground(new Color(0, 0, 102));
        this.btn10.setText("10");
        this.btn10.setBorder((Border) null);
        this.btn10.setHorizontalTextPosition(4);
        this.btn10.setIconTextGap(1);
        this.btn10.setName("btn10");
        this.btn10.addActionListener(new ActionListener() { // from class: Citas.Calendario.12
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn10ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn10);
        this.btn10.setBounds(90, 40, 40, 25);
        this.btn11.setFont(new Font("Arial", 1, 12));
        this.btn11.setForeground(new Color(0, 0, 102));
        this.btn11.setText("11");
        this.btn11.setBorder((Border) null);
        this.btn11.setHorizontalTextPosition(4);
        this.btn11.setIconTextGap(1);
        this.btn11.setName("btn11");
        this.btn11.addActionListener(new ActionListener() { // from class: Citas.Calendario.13
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn11ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn11);
        this.btn11.setBounds(130, 40, 40, 25);
        this.btn12.setFont(new Font("Arial", 1, 12));
        this.btn12.setForeground(new Color(0, 0, 102));
        this.btn12.setText("12");
        this.btn12.setBorder((Border) null);
        this.btn12.setHorizontalTextPosition(4);
        this.btn12.setIconTextGap(1);
        this.btn12.setName("btn12");
        this.btn12.addActionListener(new ActionListener() { // from class: Citas.Calendario.14
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn12ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn12);
        this.btn12.setBounds(170, 40, 40, 25);
        this.btn13.setFont(new Font("Arial", 1, 12));
        this.btn13.setForeground(new Color(0, 0, 102));
        this.btn13.setText("13");
        this.btn13.setBorder((Border) null);
        this.btn13.setHorizontalTextPosition(4);
        this.btn13.setIconTextGap(1);
        this.btn13.setName("btn13");
        this.btn13.addActionListener(new ActionListener() { // from class: Citas.Calendario.15
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn13ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn13);
        this.btn13.setBounds(210, 40, 40, 25);
        this.btn14.setFont(new Font("Arial", 1, 12));
        this.btn14.setForeground(new Color(0, 0, 102));
        this.btn14.setText("14");
        this.btn14.setBorder((Border) null);
        this.btn14.setHorizontalTextPosition(4);
        this.btn14.setIconTextGap(1);
        this.btn14.setName("btn14");
        this.btn14.addActionListener(new ActionListener() { // from class: Citas.Calendario.16
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn14ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn14);
        this.btn14.setBounds(250, 40, 35, 25);
        this.btn15.setFont(new Font("Arial", 1, 12));
        this.btn15.setForeground(new Color(204, 0, 0));
        this.btn15.setText("15");
        this.btn15.setBorder((Border) null);
        this.btn15.setHorizontalTextPosition(4);
        this.btn15.setIconTextGap(1);
        this.btn15.setName("btn15");
        this.btn15.addActionListener(new ActionListener() { // from class: Citas.Calendario.17
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn15ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn15);
        this.btn15.setBounds(10, 70, 40, 25);
        this.btn16.setFont(new Font("Arial", 1, 12));
        this.btn16.setForeground(new Color(0, 0, 102));
        this.btn16.setText("16");
        this.btn16.setBorder((Border) null);
        this.btn16.setHorizontalTextPosition(4);
        this.btn16.setIconTextGap(1);
        this.btn16.setName("btn16");
        this.btn16.addActionListener(new ActionListener() { // from class: Citas.Calendario.18
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn16ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn16);
        this.btn16.setBounds(50, 70, 40, 25);
        this.btn17.setFont(new Font("Arial", 1, 12));
        this.btn17.setForeground(new Color(0, 0, 102));
        this.btn17.setText("17");
        this.btn17.setBorder((Border) null);
        this.btn17.setHorizontalTextPosition(4);
        this.btn17.setIconTextGap(1);
        this.btn17.setName("btn17");
        this.btn17.addActionListener(new ActionListener() { // from class: Citas.Calendario.19
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn17ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn17);
        this.btn17.setBounds(90, 70, 40, 25);
        this.btn18.setFont(new Font("Arial", 1, 12));
        this.btn18.setForeground(new Color(0, 0, 102));
        this.btn18.setText("18");
        this.btn18.setBorder((Border) null);
        this.btn18.setHorizontalTextPosition(4);
        this.btn18.setIconTextGap(1);
        this.btn18.setName("btn18");
        this.btn18.addItemListener(new ItemListener() { // from class: Citas.Calendario.20
            public void itemStateChanged(ItemEvent evt) {
                Calendario.this.btn18ItemStateChanged(evt);
            }
        });
        this.btn18.addActionListener(new ActionListener() { // from class: Citas.Calendario.21
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn18ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn18);
        this.btn18.setBounds(130, 70, 40, 25);
        this.btn19.setFont(new Font("Arial", 1, 12));
        this.btn19.setForeground(new Color(0, 0, 102));
        this.btn19.setText("19");
        this.btn19.setBorder((Border) null);
        this.btn19.setHorizontalTextPosition(4);
        this.btn19.setIconTextGap(1);
        this.btn19.setName("btn19");
        this.btn19.addActionListener(new ActionListener() { // from class: Citas.Calendario.22
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn19ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn19);
        this.btn19.setBounds(170, 70, 40, 25);
        this.btn20.setFont(new Font("Arial", 1, 12));
        this.btn20.setForeground(new Color(0, 0, 102));
        this.btn20.setText("20");
        this.btn20.setBorder((Border) null);
        this.btn20.setHorizontalTextPosition(4);
        this.btn20.setIconTextGap(1);
        this.btn20.setName("btn20");
        this.btn20.addActionListener(new ActionListener() { // from class: Citas.Calendario.23
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn20ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn20);
        this.btn20.setBounds(210, 70, 40, 25);
        this.btn21.setFont(new Font("Arial", 1, 12));
        this.btn21.setForeground(new Color(0, 0, 102));
        this.btn21.setText("21");
        this.btn21.setBorder((Border) null);
        this.btn21.setHorizontalTextPosition(4);
        this.btn21.setIconTextGap(1);
        this.btn21.setName("btn21");
        this.btn21.addActionListener(new ActionListener() { // from class: Citas.Calendario.24
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn21ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn21);
        this.btn21.setBounds(250, 70, 35, 25);
        this.btn22.setFont(new Font("Arial", 1, 12));
        this.btn22.setForeground(new Color(204, 0, 0));
        this.btn22.setText("22");
        this.btn22.setBorder((Border) null);
        this.btn22.setHorizontalTextPosition(4);
        this.btn22.setIconTextGap(1);
        this.btn22.setName("btn22");
        this.btn22.addActionListener(new ActionListener() { // from class: Citas.Calendario.25
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn22ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn22);
        this.btn22.setBounds(10, 100, 40, 25);
        this.btn23.setFont(new Font("Arial", 1, 12));
        this.btn23.setForeground(new Color(0, 0, 102));
        this.btn23.setText("23");
        this.btn23.setBorder((Border) null);
        this.btn23.setHorizontalTextPosition(4);
        this.btn23.setIconTextGap(1);
        this.btn23.setName("btn23");
        this.btn23.addActionListener(new ActionListener() { // from class: Citas.Calendario.26
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn23ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn23);
        this.btn23.setBounds(50, 100, 40, 25);
        this.btn24.setFont(new Font("Arial", 1, 12));
        this.btn24.setForeground(new Color(0, 0, 102));
        this.btn24.setText("24");
        this.btn24.setBorder((Border) null);
        this.btn24.setHorizontalTextPosition(4);
        this.btn24.setIconTextGap(1);
        this.btn24.setName("btn24");
        this.btn24.addActionListener(new ActionListener() { // from class: Citas.Calendario.27
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn24ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn24);
        this.btn24.setBounds(90, 100, 40, 25);
        this.btn25.setFont(new Font("Arial", 1, 12));
        this.btn25.setForeground(new Color(0, 0, 102));
        this.btn25.setText("25");
        this.btn25.setBorder((Border) null);
        this.btn25.setHorizontalTextPosition(4);
        this.btn25.setIconTextGap(1);
        this.btn25.setName("btn25");
        this.btn25.addActionListener(new ActionListener() { // from class: Citas.Calendario.28
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn25ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn25);
        this.btn25.setBounds(130, 100, 40, 25);
        this.btn26.setFont(new Font("Arial", 1, 12));
        this.btn26.setForeground(new Color(0, 0, 102));
        this.btn26.setText("26");
        this.btn26.setBorder((Border) null);
        this.btn26.setHorizontalTextPosition(4);
        this.btn26.setIconTextGap(1);
        this.btn26.setName("btn26");
        this.btn26.addActionListener(new ActionListener() { // from class: Citas.Calendario.29
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn26ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn26);
        this.btn26.setBounds(170, 100, 40, 25);
        this.btn27.setFont(new Font("Arial", 1, 12));
        this.btn27.setForeground(new Color(0, 0, 102));
        this.btn27.setText("27");
        this.btn27.setBorder((Border) null);
        this.btn27.setHorizontalTextPosition(4);
        this.btn27.setIconTextGap(1);
        this.btn27.setName("btn27");
        this.btn27.addActionListener(new ActionListener() { // from class: Citas.Calendario.30
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn27ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn27);
        this.btn27.setBounds(210, 100, 40, 25);
        this.btn28.setFont(new Font("Arial", 1, 12));
        this.btn28.setForeground(new Color(0, 0, 102));
        this.btn28.setText("28");
        this.btn28.setBorder((Border) null);
        this.btn28.setHorizontalTextPosition(4);
        this.btn28.setIconTextGap(1);
        this.btn28.setName("btn28");
        this.btn28.addActionListener(new ActionListener() { // from class: Citas.Calendario.31
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn28ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn28);
        this.btn28.setBounds(250, 100, 35, 25);
        this.btn29.setFont(new Font("Arial", 1, 12));
        this.btn29.setForeground(new Color(204, 0, 0));
        this.btn29.setText("29");
        this.btn29.setBorder((Border) null);
        this.btn29.setHorizontalTextPosition(4);
        this.btn29.setIconTextGap(1);
        this.btn29.setName("btn29");
        this.btn29.addActionListener(new ActionListener() { // from class: Citas.Calendario.32
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn29ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn29);
        this.btn29.setBounds(10, 130, 40, 25);
        this.btn30.setFont(new Font("Arial", 1, 12));
        this.btn30.setForeground(new Color(0, 0, 102));
        this.btn30.setText("30");
        this.btn30.setBorder((Border) null);
        this.btn30.setHorizontalTextPosition(4);
        this.btn30.setIconTextGap(1);
        this.btn30.setName("btn30");
        this.btn30.addActionListener(new ActionListener() { // from class: Citas.Calendario.33
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn30ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn30);
        this.btn30.setBounds(50, 130, 40, 25);
        this.btn31.setFont(new Font("Arial", 1, 12));
        this.btn31.setForeground(new Color(0, 0, 102));
        this.btn31.setText("31");
        this.btn31.setBorder((Border) null);
        this.btn31.setHorizontalTextPosition(4);
        this.btn31.setIconTextGap(1);
        this.btn31.setName("btn31");
        this.btn31.addActionListener(new ActionListener() { // from class: Citas.Calendario.34
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn31ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn31);
        this.btn31.setBounds(90, 130, 40, 25);
        this.btn32.setFont(new Font("Arial", 1, 12));
        this.btn32.setForeground(new Color(0, 0, 102));
        this.btn32.setText("32");
        this.btn32.setBorder((Border) null);
        this.btn32.setHorizontalTextPosition(4);
        this.btn32.setIconTextGap(1);
        this.btn32.setName("btn32");
        this.btn32.addActionListener(new ActionListener() { // from class: Citas.Calendario.35
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn32ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn32);
        this.btn32.setBounds(130, 130, 40, 25);
        this.btn33.setFont(new Font("Arial", 1, 12));
        this.btn33.setForeground(new Color(0, 0, 102));
        this.btn33.setText("33");
        this.btn33.setBorder((Border) null);
        this.btn33.setHorizontalTextPosition(4);
        this.btn33.setIconTextGap(1);
        this.btn33.setName("btn33");
        this.btn33.addActionListener(new ActionListener() { // from class: Citas.Calendario.36
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn33ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn33);
        this.btn33.setBounds(170, 130, 40, 25);
        this.btn34.setFont(new Font("Arial", 1, 12));
        this.btn34.setForeground(new Color(0, 0, 102));
        this.btn34.setText("34");
        this.btn34.setBorder((Border) null);
        this.btn34.setHorizontalTextPosition(4);
        this.btn34.setIconTextGap(1);
        this.btn34.setName("btn34");
        this.btn34.addActionListener(new ActionListener() { // from class: Citas.Calendario.37
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn34ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn34);
        this.btn34.setBounds(210, 130, 40, 25);
        this.btn35.setFont(new Font("Arial", 1, 12));
        this.btn35.setForeground(new Color(0, 0, 102));
        this.btn35.setText("35");
        this.btn35.setBorder((Border) null);
        this.btn35.setHorizontalTextPosition(4);
        this.btn35.setIconTextGap(1);
        this.btn35.setName("btn35");
        this.btn35.addActionListener(new ActionListener() { // from class: Citas.Calendario.38
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn35ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn35);
        this.btn35.setBounds(250, 130, 35, 25);
        this.btn36.setFont(new Font("Arial", 1, 12));
        this.btn36.setForeground(new Color(204, 0, 0));
        this.btn36.setText("36");
        this.btn36.setBorder((Border) null);
        this.btn36.setHorizontalTextPosition(4);
        this.btn36.setIconTextGap(1);
        this.btn36.setName("btn36");
        this.btn36.addActionListener(new ActionListener() { // from class: Citas.Calendario.39
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn36ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn36);
        this.btn36.setBounds(10, 160, 40, 25);
        this.btn37.setFont(new Font("Arial", 1, 12));
        this.btn37.setForeground(new Color(0, 0, 102));
        this.btn37.setText("37");
        this.btn37.setBorder((Border) null);
        this.btn37.setHorizontalTextPosition(4);
        this.btn37.setIconTextGap(1);
        this.btn37.setName("btn37");
        this.btn37.addActionListener(new ActionListener() { // from class: Citas.Calendario.40
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn37ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn37);
        this.btn37.setBounds(50, 160, 40, 25);
        this.btn38.setFont(new Font("Arial", 1, 12));
        this.btn38.setForeground(new Color(0, 0, 102));
        this.btn38.setText("38");
        this.btn38.setBorder((Border) null);
        this.btn38.setHorizontalTextPosition(4);
        this.btn38.setIconTextGap(1);
        this.btn38.setName("btn38");
        this.btn38.addActionListener(new ActionListener() { // from class: Citas.Calendario.41
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn38ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn38);
        this.btn38.setBounds(90, 160, 40, 25);
        this.btn39.setFont(new Font("Arial", 1, 12));
        this.btn39.setForeground(new Color(0, 0, 102));
        this.btn39.setText("39");
        this.btn39.setBorder((Border) null);
        this.btn39.setHorizontalTextPosition(4);
        this.btn39.setIconTextGap(1);
        this.btn39.setName("btn39");
        this.btn39.addActionListener(new ActionListener() { // from class: Citas.Calendario.42
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn39ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn39);
        this.btn39.setBounds(130, 160, 40, 25);
        this.btn40.setFont(new Font("Arial", 1, 12));
        this.btn40.setForeground(new Color(0, 0, 102));
        this.btn40.setText("40");
        this.btn40.setBorder((Border) null);
        this.btn40.setHorizontalTextPosition(4);
        this.btn40.setIconTextGap(1);
        this.btn40.setName("btn40");
        this.btn40.addActionListener(new ActionListener() { // from class: Citas.Calendario.43
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn40ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn40);
        this.btn40.setBounds(170, 160, 40, 25);
        this.btn41.setFont(new Font("Arial", 1, 12));
        this.btn41.setForeground(new Color(0, 0, 102));
        this.btn41.setText("41");
        this.btn41.setBorder((Border) null);
        this.btn41.setHorizontalTextPosition(4);
        this.btn41.setIconTextGap(1);
        this.btn41.setName("btn41");
        this.btn41.addActionListener(new ActionListener() { // from class: Citas.Calendario.44
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn41ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn41);
        this.btn41.setBounds(210, 160, 40, 25);
        this.btn42.setFont(new Font("Arial", 1, 12));
        this.btn42.setForeground(new Color(0, 0, 102));
        this.btn42.setText("42");
        this.btn42.setBorder((Border) null);
        this.btn42.setHorizontalTextPosition(4);
        this.btn42.setIconTextGap(1);
        this.btn42.setName("btn42");
        this.btn42.addActionListener(new ActionListener() { // from class: Citas.Calendario.45
            public void actionPerformed(ActionEvent evt) {
                Calendario.this.btn42ActionPerformed(evt);
            }
        });
        this.panelDias.add(this.btn42);
        this.btn42.setBounds(250, 160, 35, 25);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelDias, -2, 290, -2).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.cboMes, -2, 160, -2).addGap(20, 20, 20).addComponent(this.txtAno, -2, 100, -2)).addComponent(this.jPanel4, -2, 280, -2)))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboMes, -2, 25, -2).addComponent(this.txtAno, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, 20, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.panelDias, -2, 190, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtAnoStateChanged(ChangeEvent evt) {
        refrescarDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn1ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn2ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn3ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn4ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn5ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn6ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn7ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn8ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn9ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn10ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn11ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn12ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn13ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn14ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn15ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn16ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn17ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn18ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn19ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn20ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn21ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn22ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn23ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn24ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn25ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn26ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn27ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn28ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn29ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn30ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn31ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn32ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn33ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn34ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn35ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn35);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn36ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn37ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn37);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn38ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn38);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn39ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn39);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn40ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn41ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn41);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn42ActionPerformed(ActionEvent evt) {
        buscarCita(this.btn42);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMesItemStateChanged(ItemEvent evt) {
        refrescarDias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btn18ItemStateChanged(ItemEvent evt) {
    }
}
