package com.genoma.plus.controller.citas;

import Acceso.Principal;
import com.genoma.plus.dao.citas.CitasDAO;
import com.genoma.plus.dao.impl.citas.CitasDAOImpl;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/citas/JDConsultarIngreso.class */
public class JDConsultarIngreso extends JDialog {
    private DefaultTableModel xModelo;
    private Object[] xDato;
    private CitasDAO xCitasDAO;
    private int xFiltro;
    private String xIdUsuario;
    private String xForma;
    private String xIdEspecialidad;
    private ButtonGroup JBG_Filtro;
    private JButton JBT_Buscar;
    private JButton JBT_Salir;
    private JPanel JPI_DatolFiltro;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_Ano;
    private JRadioButton JRB_Filtro;
    private JScrollPane JSP_Datos;
    private JTable JTB_DatosH;
    private JYearChooser JYC_Anno;

    public JDConsultarIngreso(Frame parent, boolean modal, String xIdUsuario, String xForma, String xIdEspecialidad) {
        super(parent, modal);
        this.xFiltro = 1;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        springStart();
        this.xIdUsuario = xIdUsuario;
        this.xIdEspecialidad = xIdEspecialidad;
        this.xForma = xForma;
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_DatolFiltro = new JPanel();
        this.JPI_Filtro = new JPanel();
        this.JRB_Filtro = new JRadioButton();
        this.JRB_Ano = new JRadioButton();
        this.JYC_Anno = new JYearChooser();
        this.JSP_Datos = new JScrollPane();
        this.JTB_DatosH = new JTable();
        this.JBT_Buscar = new JButton();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CONSULTAR INGRESOS");
        this.JPI_DatolFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA CONSULTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRB_Filtro);
        this.JRB_Filtro.setFont(new Font("Arial", 1, 12));
        this.JRB_Filtro.setText("Todos");
        this.JRB_Filtro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.1
            public void actionPerformed(ActionEvent evt) {
                JDConsultarIngreso.this.JRB_FiltroActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Ano);
        this.JRB_Ano.setFont(new Font("Arial", 1, 12));
        this.JRB_Ano.setSelected(true);
        this.JRB_Ano.setText("Año");
        this.JRB_Ano.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.2
            public void actionPerformed(ActionEvent evt) {
                JDConsultarIngreso.this.JRB_AnoActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Filtro).addGap(18, 18, 18).addComponent(this.JRB_Ano).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Filtro).addComponent(this.JRB_Ano))));
        this.JYC_Anno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12)));
        this.JYC_Anno.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_DatolFiltroLayout = new GroupLayout(this.JPI_DatolFiltro);
        this.JPI_DatolFiltro.setLayout(JPI_DatolFiltroLayout);
        JPI_DatolFiltroLayout.setHorizontalGroup(JPI_DatolFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatolFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JYC_Anno, -2, 76, -2).addContainerGap(-1, 32767)));
        JPI_DatolFiltroLayout.setVerticalGroup(JPI_DatolFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatolFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatolFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JYC_Anno, -1, -1, 32767)).addContainerGap(-1, 32767)));
        this.JSP_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTB_DatosH.setFont(new Font("Arial", 1, 12));
        this.JTB_DatosH.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_DatosH.setRowHeight(25);
        this.JTB_DatosH.setSelectionMode(0);
        this.JTB_DatosH.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.3
            public void mouseClicked(MouseEvent evt) {
                JDConsultarIngreso.this.JTB_DatosHMouseClicked(evt);
            }
        });
        this.JSP_Datos.setViewportView(this.JTB_DatosH);
        this.JBT_Buscar.setFont(new Font("Arial", 1, 12));
        this.JBT_Buscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBT_Buscar.setText("Buscar");
        this.JBT_Buscar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.4
            public void actionPerformed(ActionEvent evt) {
                JDConsultarIngreso.this.JBT_BuscarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.5
            public void actionPerformed(ActionEvent evt) {
                JDConsultarIngreso.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DatolFiltro, -1, -1, 32767).addComponent(this.JSP_Datos).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Buscar, -2, 248, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 259, 32767).addComponent(this.JBT_Salir, -2, 248, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DatolFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Datos, -2, 215, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Salir, -1, 57, 32767).addComponent(this.JBT_Buscar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FiltroActionPerformed(ActionEvent evt) {
        this.xFiltro = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AnoActionPerformed(ActionEvent evt) {
        this.xFiltro = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_BuscarActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DatosHMouseClicked(MouseEvent evt) {
        if (this.JTB_DatosH.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.xForma.equals("CTerapias")) {
                Principal.clasescita.frmCitaTerapia.setxIdIngreso(this.JTB_DatosH.getValueAt(this.JTB_DatosH.getSelectedRow(), 0).toString());
                Principal.clasescita.frmCitaTerapia.JTFFNorden.setText(this.JTB_DatosH.getValueAt(this.JTB_DatosH.getSelectedRow(), 0).toString());
            } else if (this.xForma.equals("CCitas")) {
                Principal.clasescita.frmCita.setIdIngreso(this.JTB_DatosH.getValueAt(this.JTB_DatosH.getSelectedRow(), 0).toString());
                Principal.clasescita.frmCita.JTFTratamientoO.setText(this.JTB_DatosH.getValueAt(this.JTB_DatosH.getSelectedRow(), 0).toString());
            }
            dispose();
        }
    }

    private void mCargarDatosTabla() {
        mCrearTabla();
        List<Object[]> list = this.xCitasDAO.consultarIngreso(this.xFiltro, this.xIdUsuario, String.valueOf(this.JYC_Anno.getValue()), this.xIdEspecialidad);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x)[0], x, 0);
            this.xModelo.setValueAt(list.get(x)[1], x, 1);
            this.xModelo.setValueAt(list.get(x)[2], x, 2);
            this.xModelo.setValueAt(list.get(x)[3], x, 3);
            this.xModelo.setValueAt(list.get(x)[4], x, 4);
            this.xModelo.setValueAt(list.get(x)[5], x, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Especialidad", "Profesional", "Empresa Convenio", "NClaseCita"}) { // from class: com.genoma.plus.controller.citas.JDConsultarIngreso.6
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTB_DatosH;
        JTable jTable2 = this.JTB_DatosH;
        jTable.setAutoResizeMode(0);
        this.JTB_DatosH.doLayout();
        this.JTB_DatosH.setModel(this.xModelo);
        this.JTB_DatosH.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_DatosH.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTB_DatosH.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTB_DatosH.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTB_DatosH.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTB_DatosH.getColumnModel().getColumn(5).setPreferredWidth(200);
    }

    private void springStart() {
        this.xCitasDAO = (CitasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("citasDAO");
    }
}
