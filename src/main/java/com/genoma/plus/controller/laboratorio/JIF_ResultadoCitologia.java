package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import PyP.clasePyP;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.InfoCitologiaDTO;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIF_ResultadoCitologia.class */
public class JIF_ResultadoCitologia extends JInternalFrame {
    private Metodos metodos;
    private DefaultTableModel modeloDato;
    private String filtro;
    private List<InfoCitologiaDTO> infoCitologiaDTOs;
    private ButtonGroup JBG_Forma;
    private JButton JBTCarguesA1;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLB_NRegistros;
    private JPanel JPIFiltro;
    private JPanel JPI_Filtro;
    private JPanel JPI_UDatos2;
    private JRadioButton JRBConResultado;
    private JRadioButton JRBSinResultado;
    private JRadioButton JRBTodos;
    private JScrollPane JSP_Detalle;
    private JTabbedPane JTB_DatosU;
    private JTable JTB_Detalle;
    private JTextField JTFBuscar;
    private JTextField JTFRuta;
    private JCheckBox jCCalidad;

    public JIF_ResultadoCitologia() {
        initComponents();
        this.metodos = new Metodos();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Forma = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPIFiltro = new JPanel();
        this.JRBTodos = new JRadioButton();
        this.JRBConResultado = new JRadioButton();
        this.JRBSinResultado = new JRadioButton();
        this.JLB_NRegistros = new JLabel();
        this.jCCalidad = new JCheckBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JTB_DatosU = new JTabbedPane();
        this.JPI_UDatos2 = new JPanel();
        this.JBTCarguesA1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JTFBuscar = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("PLANILLA DE REPORTES DE CITOLOGIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifPlanillaCitologia");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Forma.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.1
            public void actionPerformed(ActionEvent evt) {
                JIF_ResultadoCitologia.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRBConResultado);
        this.JRBConResultado.setFont(new Font("Arial", 1, 12));
        this.JRBConResultado.setText("Con Resultado");
        this.JRBConResultado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.2
            public void actionPerformed(ActionEvent evt) {
                JIF_ResultadoCitologia.this.JRBConResultadoActionPerformed(evt);
            }
        });
        this.JBG_Forma.add(this.JRBSinResultado);
        this.JRBSinResultado.setFont(new Font("Arial", 1, 12));
        this.JRBSinResultado.setSelected(true);
        this.JRBSinResultado.setText("Sin resultado");
        this.JRBSinResultado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.3
            public void actionPerformed(ActionEvent evt) {
                JIF_ResultadoCitologia.this.JRBSinResultadoActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodos, -1, 70, 32767).addGap(18, 18, 18).addComponent(this.JRBSinResultado).addGap(18, 18, 18).addComponent(this.JRBConResultado).addContainerGap()));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBSinResultado).addComponent(this.JRBConResultado)).addGap(0, 0, 32767)));
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistros.setForeground(Color.red);
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCCalidad.setFont(new Font("Arial", 1, 13));
        this.jCCalidad.setForeground(new Color(255, 0, 0));
        this.jCCalidad.setText("Control de calidad");
        this.jCCalidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.4
            public void actionPerformed(ActionEvent evt) {
                JIF_ResultadoCitologia.this.jCCalidadActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JDFechaI, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 130, -2).addGap(47, 47, 47).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCCalidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistros, -2, 113, -2).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(19, 19, 19).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_NRegistros, -2, 53, -2).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)))).addContainerGap(14, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_FiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jCCalidad).addGap(29, 29, 29)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setRowHeight(30);
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.5
            public void mouseClicked(MouseEvent evt) {
                JIF_ResultadoCitologia.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JTB_DatosU.setForeground(new Color(0, 103, 0));
        this.JTB_DatosU.setFont(new Font("Arial", 1, 14));
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.6
            public void actionPerformed(ActionEvent evt) {
                JIF_ResultadoCitologia.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.7
            public void mouseClicked(MouseEvent evt) {
                JIF_ResultadoCitologia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por usuario / número recepcion / documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.8
            public void keyPressed(KeyEvent evt) {
                JIF_ResultadoCitologia.this.JTFBuscarKeyPressed(evt);
            }
        });
        GroupLayout JPI_UDatos2Layout = new GroupLayout(this.JPI_UDatos2);
        this.JPI_UDatos2.setLayout(JPI_UDatos2Layout);
        JPI_UDatos2Layout.setHorizontalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UDatos2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFBuscar, -2, 460, -2).addGap(18, 18, 18).addComponent(this.JTFRuta, -2, 460, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCarguesA1, -2, 171, -2).addContainerGap(192, 32767)));
        JPI_UDatos2Layout.setVerticalGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UDatos2Layout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UDatos2Layout.createSequentialGroup().addComponent(this.JBTCarguesA1, -1, -1, 32767).addContainerGap()).addGroup(JPI_UDatos2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JTFBuscar, -1, 54, 32767)))));
        this.JTFBuscar.getAccessibleContext().setAccessibleName("Buscar por usuario / número recepcion/ documento");
        this.JTB_DatosU.addTab("UTILIDADES", this.JPI_UDatos2);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTB_DatosU).addComponent(this.JSP_Detalle).addComponent(this.JPI_Filtro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -1, 541, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_DatosU, -2, 107, -2).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        if (this.JTB_Detalle.getRowCount() != -1) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTB_Detalle, this.JTFRuta.getText(), getTitle());
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.filtro = "0,1";
        buscar();
        this.JTFBuscar.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinResultadoActionPerformed(ActionEvent evt) {
        this.filtro = "0";
        buscar();
        this.JTFBuscar.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConResultadoActionPerformed(ActionEvent evt) {
        this.filtro = "1";
        buscar();
        this.JTFBuscar.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            cargarResultado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCCalidadActionPerformed(ActionEvent evt) {
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBuscarKeyPressed(KeyEvent evt) {
        buscar();
    }

    public void buscar() {
        String fullUrl;
        try {
            this.infoCitologiaDTOs = new ArrayList();
            if (!this.JTFBuscar.getText().isEmpty()) {
                RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("38", "CitologiaByNombreDocumentRecepcion");
                new MetodosGenericos();
                String parametros = this.JTFBuscar.getText();
                fullUrl = microserviciosDomain.getUrlRecurso() + "/" + parametros;
            } else {
                RecursosMicroserviciosDomain microserviciosDomain2 = this.metodos.getParametrosEncriptados("38", "findAllinfoCitologia");
                MetodosGenericos<String> metodosGenericos = new MetodosGenericos<>();
                String parametros2 = this.metodos.formatoAMD1.format(this.JDFechaI.getDate()) + "_" + this.metodos.formatoAMD1.format(this.JDFechaF.getDate()) + "_" + this.filtro + "_" + (this.jCCalidad.isSelected() ? 1 : 0) + "_" + Principal.sedeUsuarioSeleccionadaDTO.getId();
                fullUrl = microserviciosDomain2.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(parametros2);
            }
            Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
            Throwable th = null;
            try {
                try {
                    crearModeloDato();
                    this.metodos.mEstablecerTextEditor(this.JTB_Detalle, 8);
                    int statusCode = response.getStatus();
                    if (statusCode == 200) {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        this.infoCitologiaDTOs = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<InfoCitologiaDTO>>() { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.9
                        });
                        System.out.println("Entrooo " + this.infoCitologiaDTOs.size());
                        Object[] dato = null;
                        this.infoCitologiaDTOs.forEach(e -> {
                            this.modeloDato.addRow(dato);
                            this.modeloDato.setValueAt(e.getConsecutivo(), this.JTB_Detalle.getRowCount() - 1, 0);
                            this.modeloDato.setValueAt(e.getFechaIngreso().format(this.metodos.formatterFecha), this.JTB_Detalle.getRowCount() - 1, 1);
                            this.modeloDato.setValueAt(e.getNumeroDocumento(), this.JTB_Detalle.getRowCount() - 1, 2);
                            this.modeloDato.setValueAt(e.getNombreUsuario(), this.JTB_Detalle.getRowCount() - 1, 3);
                            this.modeloDato.setValueAt(e.getFechaNacimiento(), this.JTB_Detalle.getRowCount() - 1, 4);
                            this.modeloDato.setValueAt(e.getEdad(), this.JTB_Detalle.getRowCount() - 1, 5);
                            this.modeloDato.setValueAt(e.getSexo(), this.JTB_Detalle.getRowCount() - 1, 6);
                            this.modeloDato.setValueAt(e.getEmpresaConvenio(), this.JTB_Detalle.getRowCount() - 1, 7);
                            this.modeloDato.setValueAt(e.getNombreProcedimiento(), this.JTB_Detalle.getRowCount() - 1, 8);
                            this.modeloDato.setValueAt(Boolean.valueOf(e.isEstadoResultado()), this.JTB_Detalle.getRowCount() - 1, 9);
                            this.modeloDato.setValueAt(e.getControlCalidad(), this.JTB_Detalle.getRowCount() - 1, 10);
                            this.modeloDato.setValueAt(e.getIdProfesionalValida(), this.JTB_Detalle.getRowCount() - 1, 11);
                            this.JTB_Detalle.setDefaultRenderer(Object.class, new MiRender());
                        });
                        this.JLB_NRegistros.setText("" + this.JTB_Detalle.getRowCount());
                    }
                    if (response != null) {
                        if (0 != 0) {
                            try {
                                response.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            response.close();
                        }
                    }
                    this.metodos.getResteasyClient().close();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (JsonProcessingException e2) {
            Logger.getLogger(JIFvalidacionAdministrativa.class.getName()).log(Level.SEVERE, (String) null, e2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDato() {
        this.modeloDato = new DefaultTableModel(new Object[0], new String[]{"codigo", "Fecha", "No. Documento", "Nombre Usuario", "Fecha Nacimiento", "edad", "sexo", "Empresa Convenio", "Nombre Procedimiento", "Estado Resultado", "Control Calidad", "idProfesionalValida"}) { // from class: com.genoma.plus.controller.laboratorio.JIF_ResultadoCitologia.10
            Class[] types = {String.class, LocalDate.class, String.class, String.class, LocalDate.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Detalle.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.setModel(this.modeloDato);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(8).setPreferredWidth(400);
        this.JTB_Detalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTB_Detalle.getColumnModel().getColumn(11).setPreferredWidth(100);
    }

    public void nuevo() {
        this.filtro = "0";
        this.infoCitologiaDTOs = new ArrayList();
        this.JRBSinResultado.setSelected(true);
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.JLB_NRegistros.setText("");
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        crearModeloDato();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIF_ResultadoCitologia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean cerrada = Boolean.valueOf(table.getValueAt(row, 9).toString());
            Boolean calidad = Boolean.valueOf(table.getValueAt(row, 10).toString());
            Long idEspecista = Long.valueOf(table.getValueAt(row, 11).toString());
            if (calidad.booleanValue() && idEspecista.longValue() == 0) {
                cell.setBackground(new Color(255, 255, 204));
                cell.setForeground(Color.BLACK);
            } else if (cerrada.booleanValue()) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void cargarResultado() {
        if (this.JTB_Detalle.getSelectedRow() != -1) {
            try {
                String[] documento = this.infoCitologiaDTOs.get(this.JTB_Detalle.getSelectedRow()).getNumeroDocumento().split("-");
                Principal.clasepyp = new clasePyP(Principal.claselab.frmPrincipal);
                Principal.clasepyp.setXidrecepcion(this.infoCitologiaDTOs.get(this.JTB_Detalle.getSelectedRow()).getIdRecepcion().longValue());
                Principal.clasepyp.setXid_tipof(this.infoCitologiaDTOs.get(this.JTB_Detalle.getSelectedRow()).getIdIngreso().longValue());
                Principal.clasepyp.setXid_ingreso(this.infoCitologiaDTOs.get(this.JTB_Detalle.getSelectedRow()).getIdIngreso().longValue());
                Principal.clasepyp.cargarPantalla("Toma", 38);
                Principal.clasepyp.frmToma.frmPersona.txtHistoria.setText(documento[1]);
                Principal.clasepyp.frmToma.frmPersona.buscar(2);
                Principal.clasepyp.frmToma.mCargarDatosToma();
                Principal.clasepyp.frmToma.mBuscarResultadoCitologia(Principal.txtNo.getText());
                Principal.clasepyp.frmToma.JTPDatosP.setSelectedIndex(1);
                Principal.clasepyp.frmToma.setSelected(true);
                setVisible(false);
            } catch (PropertyVetoException e) {
                Logger.getLogger(JIF_ResultadoCitologia.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
