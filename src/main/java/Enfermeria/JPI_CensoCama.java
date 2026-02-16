package Enfermeria;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPI_CensoCama.class */
public class JPI_CensoCama extends JPanel {
    private String xsql;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xIdUnidad;
    private JButton JBTExportar;
    private JComboBox JCB_UnidadC;
    private JCheckBox JCHFiltro;
    public JDateChooser JDCFechaI;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_ConSeguimiento;
    private JScrollPane JSPDHistorico;
    private JTable JTDHistorico;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xidatencion = "0";
    private boolean xlleno = false;

    public JPI_CensoCama() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCHFiltro.setSelected(false);
        this.JDCFechaI.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mLlenarCombo();
        mCargarTabla();
        this.xlleno = true;
    }

    public void mImprimir() {
        String[][] mparametros = new String[2][2];
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_CensoCama", mparametros);
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel() { // from class: Enfermeria.JPI_CensoCama.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class, Integer.class, String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("Unidad");
        this.xmodelo.addColumn("Cama");
        this.xmodelo.addColumn("FIngreso");
        this.xmodelo.addColumn("N° Historia");
        this.xmodelo.addColumn("NUsuario");
        this.xmodelo.addColumn("Sexo");
        this.xmodelo.addColumn("Edad");
        this.xmodelo.addColumn("Entidad");
        this.xmodelo.addColumn("N° Días");
        this.xmodelo.addColumn("Disponible");
        this.xmodelo.addColumn("codigoDx");
        this.xmodelo.addColumn("Nombre Diagnostico");
        this.xmodelo.addColumn("Horas");
        this.xmodelo.addColumn("Patologia Evolucion");
        this.xmodelo.addColumn("Esepcialidad Interconsulta");
        this.xmodelo.addColumn("Ambito");
        JTable jTable = this.JTDHistorico;
        JTable jTable2 = this.JTDHistorico;
        jTable.setAutoResizeMode(0);
        this.JTDHistorico.doLayout();
        this.JTDHistorico.setModel(this.xmodelo);
        this.JTDHistorico.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDHistorico.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(11).setPreferredWidth(400);
        this.JTDHistorico.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDHistorico.getColumnModel().getColumn(13).setPreferredWidth(400);
        this.JTDHistorico.getColumnModel().getColumn(14).setPreferredWidth(400);
        this.JTDHistorico.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void mLlenarCombo() {
        this.JCB_UnidadC.removeAllItems();
        this.xsql = "with maestra as (\n\tselect  fu2.Id idUnidad, fu2.Nbre nombreUnidad, fc2.Id idCama, fc2.Nbre nombreCama, fc2.Disponible disponible\n\tfrom f_unidadcama fu2 \n\tinner join f_camas fc2 on (fc2.Id_UnidadCamas=fu2.Id)\n\torder by nombreUnidad asc , nombreCama asc\n),\nusuarios as (\n\tSELECT fc.Id idCama ,concat (gp.Apellido1,' ', gp.Apellido2,' ',gp.Nombre1,' ',gp.Nombre2 ) usuario, i.FechaIngreso as fechaIngreso\n\t,concat(gp.Id_TipoIdentificacion,' ',gp.NoDocumento) documento, gp.Id_Sexo sexo\n\t, CONCAT(`Devuelve_Edad_2F`(gp.`FechaNac`,i.`FechaIngreso`), ' ', `Devuelve_Tipo_Edad_2F`(gp.`FechaNac`,i.`FechaIngreso`) ) AS edad\n\t, fe.Nbre nombreConvenio\n\t, TIMESTAMPDIFF(DAY, i.FechaIngreso, now()) dias\n\t, hoht.Id idTraslado\n\t, hea.Id idEgreso\n\tFROM \n\th_orden_hospitalizacion hoh \n\tinner join h_orden_hospitalizacion_traslado hoht on (hoh.Id=hoht.IdOrdenHosp)\n\tinner join h_atencion ha on (ha.Id=hoh.Id_Atencion)\n\tinner join ingreso i on (i.Id=ha.Id_Ingreso)\n\tinner join g_persona gp on (gp.Id=i.Id_Usuario)\n\tinner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\n\tleft join h_egreso_atencion hea on (hea.Id_Ingreso=i.Id) and (i.Id_TipoAtencion=hea.Id_Tipo)\n\tinner join f_camas fc on (fc.Id=hoht.Id_CamaOrigen)\n\tinner join f_unidadcama fu on (fu.Id=fc.Id_UnidadCamas)\n\twhere hoht.Fecha_Egreso is null and hoht.Estado=1 \n\torder by fu.Nbre,  fc.Nbre \n)\nselect m.idUnidad, m.nombreUnidad\nfrom maestra m \nleft join usuarios u on (u.idCama=m.idCama)\ngroup by  m.idUnidad \norder by m.nombreUnidad asc";
        this.xIdUnidad = this.xct.llenarCombo(this.xsql, this.xIdUnidad, this.JCB_UnidadC);
        this.JCB_UnidadC.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCB_UnidadC.setEnabled(false);
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarTabla() {
        try {
            mCrearTabla();
            this.xsql = "with maestra as (\n\tselect  fu2.Id idUnidad, fu2.Nbre nombreUnidad, fc2.Id idCama, fc2.Nbre nombreCama, fc2.Disponible disponible, gt.Id_TipoAmbito ambito\n\tfrom f_unidadcama fu2 \n\tinner join f_camas fc2 on (fc2.Id_UnidadCamas=fu2.Id)\n inner join g_tipoatencion gt on (gt.Id=fu2.IdTipoAtencion)\n\torder by nombreUnidad asc , nombreCama asc\n),\nusuarios as (\n\tSELECT fc.Id idCama ,concat (gp.Apellido1,' ', gp.Apellido2,' ',gp.Nombre1,' ',gp.Nombre2 ) usuario,\n\tconcat(i.FechaIngreso, ' ', i.HoraIngreso) as fechaIngreso\n\t,concat(gp.Id_TipoIdentificacion,' ',gp.NoDocumento) documento, gp.Id_Sexo sexo\n\t, CONCAT(`Devuelve_Edad_2F`(gp.`FechaNac`,i.`FechaIngreso`), ' ', `Devuelve_Tipo_Edad_2F`(gp.`FechaNac`,i.`FechaIngreso`) ) AS edad\n\t, fe.Nbre nombreConvenio\n\t, TIMESTAMPDIFF(DAY, i.FechaIngreso, '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + "') dias\n\t, hoht.Id idTraslado\n\t, hea.Id idEgreso, gp1.Id codigoDx\n\t, gp1.Nbre patologia\n\t,  TIMESTAMPDIFF(HOUR, concat(i.FechaIngreso, ' ', i.HoraIngreso), '" + this.xmt.formatoAMD1.format(this.JDCFechaI.getDate()) + " " + this.xmt.formatoH24.format(this.xmt.getFechaActual()) + "') hora\n\t, ha.id idAtencion\n\tFROM \n\th_orden_hospitalizacion hoh \n\tinner join h_orden_hospitalizacion_traslado hoht on (hoh.Id=hoht.IdOrdenHosp)\n\tinner join h_atencion ha on (ha.Id=hoh.Id_Atencion)\n\tinner join ingreso i on (i.Id=ha.Id_Ingreso)\n\tinner join g_persona gp on (gp.Id=i.Id_Usuario)\n\tinner join f_empresacontxconvenio fe on (fe.Id=i.Id_EmpresaContxConv)\n\tinner join g_patologia gp1 on (gp1.Id=ha.Codigo_Dxp)\n\tleft join h_egreso_atencion hea on (hea.Id_Ingreso=i.Id) and (i.Id_TipoAtencion=hea.Id_Tipo)\n\tinner join f_camas fc on (fc.Id=hoht.Id_CamaOrigen)\n\tinner join f_unidadcama fu on (fu.Id=fc.Id_UnidadCamas)\n\twhere hoht.Fecha_Egreso is null and hoht.Estado=1\n\torder by fu.Nbre,  fc.Nbre \n), \ndiagnoticoNotas as (\n\tSELECT \n    hn.Id_Atencion AS idAtencion,\n    hn.Id AS idNota,\n    MAX(hn.FechaNota) AS ultimaFechaNota,\n    GROUP_CONCAT(DISTINCT concat(gp.Id,'_',gp.Nbre) ORDER BY gp.Nbre SEPARATOR ', ') AS patologias\n\tFROM h_notasclinicas hn\n\tINNER JOIN h_notaclinica_diagnostico hnd ON hnd.Id_NClinica = hn.Id\n\tINNER JOIN g_patologia gp ON gp.Id = hnd.Id_Patologia\n\tINNER JOIN (\n\t    -- Subconsulta para obtener la última nota por atención\n\t    SELECT Id_Atencion, MAX(FechaNota) AS maxFecha\n\t    FROM h_notasclinicas\n\t    GROUP BY Id_Atencion\n\t) ult ON ult.Id_Atencion = hn.Id_Atencion AND ult.maxFecha = hn.FechaNota\n\tGROUP BY hn.Id_Atencion, hn.Id\n),\ninterconsultas as (\n\tSELECT\n\tGROUP_CONCAT(DISTINCT g_especialidad.Nbre ORDER BY g_especialidad.Nbre SEPARATOR '-' ) especialidad, h_notasclinicas.Id_Atencion idAtencion\nFROM\n\th_notasclinicas\nINNER JOIN h_ordenes_interconsultas ON\n\t(h_ordenes_interconsultas.Id_Nota = h_notasclinicas.Id)\nINNER JOIN g_especialidad ON\n\t(h_ordenes_interconsultas.Id_Especialidad = g_especialidad.Id)\nWHERE\n\t(h_notasclinicas.Estado = 1\n\tand g_especialidad.Id not in(3)\n\t)\nGROUP BY\n\th_notasclinicas.Id_Atencion\n)\nselect m.nombreUnidad, m.nombreCama, \nifnull(u.fechaIngreso, '') fechaIngreso,\nifnull(u.documento, '') documento,\nifnull(u.usuario, '') usuario,\nifnull(u.sexo, '')sexo,\nifnull(u.edad, '') edad , \nifnull(u.nombreConvenio, '') nombreConvenio,\nifnull(u.dias,'') numeroDias, \nifnull(u.codigoDx, '') codigoDx ,\nifnull(u.patologia, '') nombrePatologia,\nm.disponible,\nifnull(u.hora, 0) hora,  \nifnull(d.patologias , '') patologiaEvolucion,\nifnull(i.especialidad, '') interconsultas, m.ambito\nfrom maestra m \nleft join usuarios u on (u.idCama=m.idCama)\nleft join diagnoticoNotas d on (d.idAtencion=u.idAtencion )\nleft join interconsultas i on (i.idAtencion =u.idAtencion )";
            if (this.JCHFiltro.isSelected()) {
                this.xsql += " where m.idUnidad='" + this.xIdUnidad[this.JCB_UnidadC.getSelectedIndex()] + "'";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int x = 0;
                    this.xmt.mEstablecerTextEditor(this.JTDHistorico, 4);
                    this.xmt.mEstablecerTextEditor(this.JTDHistorico, 7);
                    this.xmt.mEstablecerTextEditor(this.JTDHistorico, 11);
                    while (xrs.next()) {
                        this.xmodelo.addRow(this.xdato);
                        this.xmodelo.setValueAt(xrs.getString("nombreUnidad"), x, 0);
                        this.xmodelo.setValueAt(xrs.getString("nombreCama"), x, 1);
                        this.xmodelo.setValueAt(xrs.getString("fechaIngreso"), x, 2);
                        this.xmodelo.setValueAt(xrs.getString("documento"), x, 3);
                        this.xmodelo.setValueAt(xrs.getString("usuario"), x, 4);
                        this.xmodelo.setValueAt(xrs.getString("sexo"), x, 5);
                        this.xmodelo.setValueAt(xrs.getString("edad"), x, 6);
                        this.xmodelo.setValueAt(xrs.getString("nombreConvenio"), x, 7);
                        this.xmodelo.setValueAt(xrs.getString("numeroDias"), x, 8);
                        this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean("disponible")), x, 9);
                        this.xmodelo.setValueAt(xrs.getString("codigoDx"), x, 10);
                        this.xmodelo.setValueAt(xrs.getString("nombrePatologia"), x, 11);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("hora")), x, 12);
                        this.xmodelo.setValueAt(xrs.getString("patologiaEvolucion"), x, 13);
                        this.xmodelo.setValueAt(xrs.getString("interconsultas"), x, 14);
                        this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("ambito")), x, 15);
                        this.JTDHistorico.setDefaultRenderer(Object.class, new MiRender());
                        x++;
                    }
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                this.xct.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPI_CensoCama.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPI_CensoCama$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.parseInt(table.getValueAt(row, 15).toString()) == 3) {
                if (Integer.parseInt(table.getValueAt(row, 12).toString()) >= 6) {
                    cell.setBackground(new Color(255, 255, 204));
                } else {
                    cell.setBackground(Color.WHITE);
                }
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Filtro = new JPanel();
        this.JCB_UnidadC = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JDCFechaI = new JDateChooser();
        this.JSPDHistorico = new JScrollPane();
        this.JTDHistorico = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JRB_ConSeguimiento = new JRadioButton();
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCB_UnidadC.setFont(new Font("Arial", 1, 12));
        this.JCB_UnidadC.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_UnidadC.addItemListener(new ItemListener() { // from class: Enfermeria.JPI_CensoCama.2
            public void itemStateChanged(ItemEvent evt) {
                JPI_CensoCama.this.JCB_UnidadCItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Enfermeria.JPI_CensoCama.3
            public void actionPerformed(ActionEvent evt) {
                JPI_CensoCama.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaI, -2, 129, -2).addGap(18, 18, 18).addComponent(this.JCB_UnidadC, -2, 346, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltro).addGap(93, 93, 93)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_UnidadC, -2, 50, -2).addComponent(this.JCHFiltro)).addComponent(this.JDCFechaI, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
        this.JSPDHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDHistorico.setViewportView(this.JTDHistorico);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Enfermeria.JPI_CensoCama.4
            public void mouseClicked(MouseEvent evt) {
                JPI_CensoCama.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Enfermeria.JPI_CensoCama.5
            public void actionPerformed(ActionEvent evt) {
                JPI_CensoCama.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JRB_ConSeguimiento.setBackground(new Color(255, 255, 204));
        this.JRB_ConSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JRB_ConSeguimiento.setSelected(true);
        this.JRB_ConSeguimiento.setText(">=6 horas ingreso");
        this.JRB_ConSeguimiento.setEnabled(false);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSPDHistorico, -1, 826, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 476, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -1, 206, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_ConSeguimiento).addGap(4, 4, 4))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDHistorico, -1, 277, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addComponent(this.JRB_ConSeguimiento)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.JCB_UnidadC.setEnabled(true);
        } else {
            this.JCB_UnidadC.setEnabled(false);
            mCargarTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_UnidadCItemStateChanged(ItemEvent evt) {
        boolean z = this.JCB_UnidadC.getSelectedIndex() != -1 && this.JCHFiltro.isSelected();
        this.xlleno = z;
        if (z) {
            mCargarTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDHistorico.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDHistorico, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), "CENSO DE CAMAS");
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }
}
