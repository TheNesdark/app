package Historia;

import Utilidades.ConsultasPostgresSql;
import com.genoma.plus.controller.historia.JIF_Historia_Clinica_v2;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPHistoricoAtencionesVisionIPS.class */
public class JPHistoricoAtencionesVisionIPS extends JPanel {
    private JIF_Historia_Clinica_v2 HCV2;
    private Object[] data;
    private int idPaciente;
    private int anio;
    private boolean filtro;
    private JPanel JPIDFiltro;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistoricoA;
    private JTable JTHistoricoE;
    private JTextPane JTPHistoricoA;
    private JTabbedPane JTPMenu;
    private JYearChooser JYAno;
    private ConsultasPostgresSql consult = new ConsultasPostgresSql();
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Integer> idEvolucion = new ArrayList<>();
    private ArrayList<String> fecha = new ArrayList<>();
    private ArrayList<String> medico = new ArrayList<>();
    private int evolucionId = 0;
    private String idAttention = "";
    private String dateAtention = "";
    private String reasonConsultation = "";
    private String currentIllness = "";
    private String observation = "";
    private String presion = "";
    private String fC = "";
    private String fR = "";
    private String temperature = "";
    private String size = "";
    private String weight = "";
    private String IMC = "";
    private String specialist = "";
    private String speciality = "";
    private String recommendations = "";

    public JPHistoricoAtencionesVisionIPS(clasesHistoriaCE xclase) {
        this.idPaciente = 0;
        this.anio = 2023;
        initComponents();
        createDataModelEvolution();
        this.idPaciente = Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getNumeroHistoria());
        this.anio = this.JYAno.getYear();
        this.filtro = true;
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDFiltro = new JPanel();
        this.JYAno = new JYearChooser();
        this.JTPMenu = new JTabbedPane();
        this.JSPHistorico = new JScrollPane();
        this.JTHistoricoE = new JTable();
        this.JSPHistoricoA = new JScrollPane();
        this.JTPHistoricoA = new JTextPane();
        setAutoscrolls(true);
        setName("jphistoricoatencionesvisionips");
        this.JPIDFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.addFocusListener(new FocusAdapter() { // from class: Historia.JPHistoricoAtencionesVisionIPS.1
            public void focusLost(FocusEvent evt) {
                JPHistoricoAtencionesVisionIPS.this.JYAnoFocusLost(evt);
            }
        });
        this.JYAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPHistoricoAtencionesVisionIPS.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPHistoricoAtencionesVisionIPS.this.JYAnoPropertyChange(evt);
            }
        });
        GroupLayout JPIDFiltroLayout = new GroupLayout(this.JPIDFiltro);
        this.JPIDFiltro.setLayout(JPIDFiltroLayout);
        JPIDFiltroLayout.setHorizontalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JYAno, -2, 82, -2).addContainerGap(-1, 32767)));
        JPIDFiltroLayout.setVerticalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JYAno, -2, 50, -2).addGap(0, 27, 32767)));
        this.JTPMenu.setForeground(new Color(0, 103, 0));
        this.JTPMenu.setFont(new Font("Arial", 1, 14));
        this.JTHistoricoE.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoE.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistoricoE.setRowHeight(25);
        this.JTHistoricoE.setSelectionMode(2);
        this.JTHistoricoE.addMouseListener(new MouseAdapter() { // from class: Historia.JPHistoricoAtencionesVisionIPS.3
            public void mouseClicked(MouseEvent evt) {
                JPHistoricoAtencionesVisionIPS.this.JTHistoricoEMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistoricoE);
        this.JTPMenu.addTab("HISTORICO DE ATENCIONES", this.JSPHistorico);
        this.JTPHistoricoA.setEditable(false);
        this.JTPHistoricoA.setContentType("text/html");
        this.JTPHistoricoA.setFont(new Font("Arial", 1, 12));
        this.JTPHistoricoA.setCursor(new Cursor(0));
        this.JTPHistoricoA.setMaximumSize(new Dimension(0, 0));
        this.JTPHistoricoA.setMinimumSize(new Dimension(0, 0));
        this.JSPHistoricoA.setViewportView(this.JTPHistoricoA);
        this.JTPMenu.addTab("DETALLE", this.JSPHistoricoA);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPMenu, -1, 689, 32767).addComponent(this.JPIDFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenu, -1, 410, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoEMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.evolucionId = Integer.parseInt(this.JTHistoricoE.getValueAt(this.JTHistoricoE.getSelectedRow(), 0).toString());
            this.JTPMenu.setSelectedIndex(1);
            loadAttention();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYAnoPropertyChange(PropertyChangeEvent evt) {
        System.out.println("filas 2-> " + this.model.getRowCount());
        this.anio = this.JYAno.getYear();
        this.idEvolucion.clear();
        this.fecha.clear();
        this.medico.clear();
        consultEvolution();
    }

    private void consultEvolution() {
        String sql = "SELECT tevolucion.num_evo, tevolucion.fecha_evo, tmedico.nom_med \nFROM tevolucion \nINNER JOIN tpaciente ON tevolucion.cod_pacien = tpaciente.cod_pacien \nINNER JOIN tmedico ON tmedico.id_med = tevolucion.id_med \nWHERE tpaciente.id_pacien = '" + this.idPaciente + "'AND EXTRACT(YEAR FROM tevolucion.fecha_evo) = '" + this.anio + "';";
        System.out.println("consulta evolucion -> " + sql);
        try {
            ResultSet res = this.consult.traerRs(sql);
            while (res.next()) {
                int numEvo = res.getInt("num_evo");
                String fecha = res.getString("fecha_evo");
                String medico = res.getString("nom_med");
                this.idEvolucion.add(Integer.valueOf(numEvo));
                this.fecha.add(fecha);
                this.medico.add(medico);
            }
            this.idEvolucion = this.idEvolucion;
            this.fecha = this.fecha;
            this.medico = this.medico;
            loadTableEvolution();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void createDataModelEvolution() {
        this.model = new DefaultTableModel(new Object[0], new String[]{"Número de evolución", "Fecha evolución", "Medico"}) { // from class: Historia.JPHistoricoAtencionesVisionIPS.4
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoE.setModel(this.model);
        this.JTHistoricoE.doLayout();
        this.JTHistoricoE.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTHistoricoE.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTHistoricoE.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    private void loadTableEvolution() {
        createDataModelEvolution();
        for (int i = 0; i < this.idEvolucion.size(); i++) {
            Object[] row = {this.idEvolucion.get(i), this.fecha.get(i), this.medico.get(i)};
            this.model.addRow(row);
            this.JTHistoricoE.setModel(this.model);
        }
    }

    private void loadAttention() {
        String sql = "SELECT t2.num_evo AS idAtencion,\n\t\tt2.fecha_evo AS fechaAtencion,\n\t\tt2.mot_consulta AS motivoConsulta,\n\t\tt2.enf_actual AS enfermedadActual,\n\t\tt2.observacion AS observacion,\n\t\tt2.ta1 AS Presion, \n\t\tt2.fc1 AS FCardiaca, \n\t\tt2.fr1 AS FRespiratoria, \n\t\tt2.tempe1 AS Temperatura, \n\t\tt2.talla1 AS Talla, \n\t\tt2.peso1 AS Peso, \n\t\tt2.imc AS IMC,\n\t\tt.nom_med AS especialista,\n\t\tt3.nom_espe AS especialidad,\n\t\tt2.conducta AS recomendaciones\nFROM tevolucion t2 INNER JOIN tmedico t ON(t2.id_med=t.id_med)\nINNER JOIN tespecialidad t3 ON (t3.cod_espe=t.cod_espe)\nWHERE t2.cod_pacien = (SELECT te.cod_pacien from tevolucion te \n\t\t\t\t\t   INNER JOIN tpaciente tp on(te.cod_pacien=tp.cod_pacien) WHERE tp.id_pacien = '" + this.idPaciente + "' AND te.num_evo ='" + this.evolucionId + "')\nAND t2.num_evo  = '" + this.evolucionId + "'";
        System.out.println("consulta evolucion -> " + sql);
        try {
            ResultSet res = this.consult.traerRs(sql);
            if (res.next()) {
                this.idAttention = res.getString("idAtencion");
                this.dateAtention = res.getString("fechaAtencion");
                this.reasonConsultation = res.getString("motivoConsulta");
                this.currentIllness = res.getString("enfermedadActual");
                this.observation = res.getString("observacion");
                this.presion = res.getString("Presion");
                this.fC = res.getString("FCardiaca");
                this.fR = res.getString("FRespiratoria");
                this.temperature = res.getString("Temperatura");
                this.size = res.getString("Talla");
                this.weight = res.getString("Peso");
                this.IMC = res.getString("IMC");
                this.specialist = res.getString("especialista");
                this.speciality = res.getString("especialidad");
                this.recommendations = res.getString("recomendaciones");
                loadDataAttention();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDataAttention() {
        String signosVitales = "<font face='Arial' color='black' size=4>+----------------------+---------------+</font><br><font face='Arial' color='red' size=4>Signos vitales</font><br><font face='Arial' color='black' size=4>+----------------------+---------------+</font><br><font face='Arial' color='red' size=4> Presión: </font>" + this.presion + " <br><font face='Arial' color='red' size=4> Frecuencia cardiaca: </font>" + this.fC + " PPM<br><font face='Arial' color='red' size=4> Frecuencia respiratoria: </font>" + this.fR + " RPM<br><font face='Arial' color='red' size=4> Temperatura: </font>" + this.temperature + " °C<br><font face='Arial' color='red' size=4> Talla: </font>" + this.size + " m<br><font face='Arial' color='red' size=4> Peso:</font>" + this.weight + " Kg<br><font face='Arial' color='red' size=4> IMC: </font>" + this.IMC + " <br><font face='Arial' color='black' size=4>+----------------------+----------------+</font>";
        this.JTPHistoricoA.setText("<font face='Arial' color='red' size=4>Fecha de atención: </font>" + this.dateAtention + "<font face='Arial' color='red' size=4> Médico: </font>" + this.specialist + " - " + this.speciality + "<br>" + signosVitales + "<br><font face='Arial' color='red' size=4>Razón de la consulta: </font>" + this.reasonConsultation + "<br><br><font face='Arial' color='red' size=4>Enfermedad actual: </font>" + this.currentIllness + "<br><br><font face='Arial' color='red' size=4>Observaciones: </font>" + this.observation + "<br><br><font face='Arial' color='red' size=4>Recomendaciones: </font>" + this.recommendations);
    }
}
