package com.genoma.plus.controller.pyp;

import Laboratorio.Render;
import PyP.clasePyP;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.pyp.AgendaVacunacionDAOImpl;
import com.genoma.plus.dao.pyp.AgendaVacunacionDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_AgendaVacunacion.class */
public class JIF_AgendaVacunacion extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private AgendaVacunacionDAO xAgendaVacunacionDAO;
    private Object[] xDato;
    private HiloVacunacion hilo;
    private clasePyP xClasePyp;
    private ButtonGroup JBG_Filtro;
    public JDateChooser JDCFecha;
    private JLabel JLBNRegistro;
    private JPanel JPIFiltro;
    private JPanel JPI_Filtro;
    private JRadioButton JRBAtendidas;
    private JRadioButton JRBPorAtender;
    private JRadioButton JRBTodas;
    private JScrollPane JSPAgenda;
    public JTable JTAgendaP;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xFiltro = "0,1";

    public JIF_AgendaVacunacion(clasePyP clase) {
        initComponents();
        this.xClasePyp = clase;
        springStart();
        mNuevo();
        this.hilo = new HiloVacunacion();
        this.hilo.start();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_Filtro = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JPIFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBPorAtender = new JRadioButton();
        this.JRBAtendidas = new JRadioButton();
        this.JLBNRegistro = new JLabel();
        this.JSPAgenda = new JScrollPane();
        this.JTAgendaP = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA DE VACUNACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIF_AgendaVacunacion.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIF_AgendaVacunacion.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_AgendaVacunacion.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR : ", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBG_Filtro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(new Color(0, 0, 255));
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.3
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaVacunacion.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JRBPorAtender.setBackground(Color.cyan);
        this.JBG_Filtro.add(this.JRBPorAtender);
        this.JRBPorAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtender.setForeground(new Color(0, 0, 255));
        this.JRBPorAtender.setSelected(true);
        this.JRBPorAtender.setText("Por Atender");
        this.JRBPorAtender.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.4
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaVacunacion.this.JRBPorAtenderActionPerformed(evt);
            }
        });
        this.JRBAtendidas.setBackground(Color.magenta);
        this.JBG_Filtro.add(this.JRBAtendidas);
        this.JRBAtendidas.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidas.setForeground(new Color(0, 0, 255));
        this.JRBAtendidas.setText("Atendidas");
        this.JRBAtendidas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.5
            public void actionPerformed(ActionEvent evt) {
                JIF_AgendaVacunacion.this.JRBAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAtendidas).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBPorAtender).addComponent(this.JRBAtendidas)).addContainerGap(-1, 32767)));
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Registro", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JDCFecha, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 493, 32767).addComponent(this.JLBNRegistro, -2, 170, -2).addContainerGap()));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNRegistro, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, -2, -1, -2)).addComponent(this.JDCFecha, -2, 50, -2)).addContainerGap(20, 32767)));
        this.JSPAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTAgendaP.setFont(new Font("Arial", 1, 12));
        this.JTAgendaP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTAgendaP.setRowHeight(39);
        this.JTAgendaP.setSelectionBackground(new Color(255, 255, 255));
        this.JTAgendaP.setSelectionForeground(new Color(255, 0, 0));
        this.JTAgendaP.setSelectionMode(0);
        this.JTAgendaP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.6
            public void mouseClicked(MouseEvent evt) {
                JIF_AgendaVacunacion.this.JTAgendaPMouseClicked(evt);
            }
        });
        this.JSPAgenda.setViewportView(this.JTAgendaP);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSPAgenda)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAgenda, -1, 453, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.xFiltro = "0,1";
        mCargarDatosTablaAgenda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderActionPerformed(ActionEvent evt) {
        this.xFiltro = "0";
        mCargarDatosTablaAgenda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasActionPerformed(ActionEvent evt) {
        this.xFiltro = "1";
        mCargarDatosTablaAgenda();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCargarDatosTablaAgenda();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        this.hilo.setXvalor(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        this.hilo.setXvalor(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAgendaPMouseClicked(MouseEvent evt) {
        if (this.JTAgendaP.getRowCount() != -1 && this.JTAgendaP.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xClasePyp.cargarPantalla("Vacunacion", this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 0).toString(), true, Long.valueOf(this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 10).toString()), Long.valueOf(this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 11).toString()), Long.valueOf(this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 10).toString()), this.JTAgendaP.getValueAt(this.JTAgendaP.getSelectedRow(), 13).toString());
            this.hilo.setXvalor(false);
            setVisible(false);
        }
    }

    private void springStart() {
        this.xAgendaVacunacionDAO = (AgendaVacunacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("agendaVacunacionDAO");
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.xFiltro = "0,1";
        mCargarDatosTablaAgenda();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void mCrearTablaAgenda() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° HC", "Documento", "NUsuario", "Edad", "Sexo", "NConvenio", "Vacunas Facturadas", "CEspecial", "Estado", "CE", "IdOrdenFac", "IdIngreso", "Idprofesional", "Vacunador"}) { // from class: com.genoma.plus.controller.pyp.JIF_AgendaVacunacion.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, JLabel.class, String.class, Integer.class, Long.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTAgendaP;
        JTable jTable2 = this.JTAgendaP;
        jTable.setAutoResizeMode(0);
        this.JTAgendaP.doLayout();
        this.JTAgendaP.setModel(this.xmodelo);
        this.JTAgendaP.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTAgendaP.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTAgendaP.getColumnModel().getColumn(6).setPreferredWidth(400);
        this.JTAgendaP.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTAgendaP.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTAgendaP.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTAgendaP.getColumnModel().getColumn(13).setPreferredWidth(300);
    }

    public void mCargarDatosTablaAgenda() {
        mCrearTablaAgenda();
        List<Object[]> list1 = this.xAgendaVacunacionDAO.listadoAgenda(this.xmt.formatoAMD.format(this.JDCFecha.getDate()), this.xFiltro);
        long xnfila = 0;
        if (list1.size() >= 1) {
            this.xmt.mEstablecerTextEditor(this.JTAgendaP, 6);
            for (int x = 0; x < list1.size(); x++) {
                this.xmodelo.addRow(this.xDato);
                this.xmodelo.setValueAt(list1.get(x)[0], x, 0);
                this.xmodelo.setValueAt(list1.get(x)[1], x, 1);
                this.xmodelo.setValueAt(list1.get(x)[2], x, 2);
                this.xmodelo.setValueAt(list1.get(x)[3], x, 3);
                this.xmodelo.setValueAt(list1.get(x)[4], x, 4);
                this.xmodelo.setValueAt(list1.get(x)[5], x, 5);
                this.xmodelo.setValueAt(list1.get(x)[6], x, 6);
                this.xmodelo.setValueAt(list1.get(x)[7], x, 9);
                if (Integer.valueOf(list1.get(x)[7].toString()).intValue() == 1) {
                    this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Discapasitaods.png"))), x, 7);
                } else if (Integer.valueOf(list1.get(x)[7].toString()).intValue() == 2) {
                    this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Embarazada.png"))), x, 7);
                } else if (Integer.valueOf(list1.get(x)[7].toString()).intValue() == 3) {
                    this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/Atencion Ancianos.png"))), x, 7);
                } else if (Integer.valueOf(list1.get(x)[7].toString()).intValue() == 4) {
                    this.xmodelo.setValueAt(new JLabel(new ImageIcon(getClass().getResource("/Imagenes/AtpNiños.png"))), x, 7);
                } else {
                    this.xmodelo.setValueAt(new JLabel(""), x, 7);
                }
                this.xmodelo.setValueAt(list1.get(x)[8], x, 8);
                this.xmodelo.setValueAt(list1.get(x)[9], x, 10);
                this.xmodelo.setValueAt(list1.get(x)[10], x, 11);
                this.xmodelo.setValueAt(list1.get(x)[11], x, 12);
                this.xmodelo.setValueAt(list1.get(x)[12], x, 13);
                this.JTAgendaP.setDefaultRenderer(JLabel.class, new Render(Integer.valueOf(list1.get(x)[7].toString()).intValue(), 9));
                this.JTAgendaP.setDefaultRenderer(Object.class, new MiRender());
                xnfila++;
            }
        }
        this.JLBNRegistro.setText(String.valueOf(xnfila));
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_AgendaVacunacion$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) != null) {
                String estado = table.getValueAt(row, 8).toString();
                if (estado.equals("POR ATENDER")) {
                    cell.setBackground(Color.CYAN);
                    cell.setForeground(Color.BLACK);
                } else {
                    cell.setBackground(Color.MAGENTA);
                    cell.setForeground(Color.BLACK);
                }
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/pyp/JIF_AgendaVacunacion$HiloVacunacion.class */
    private class HiloVacunacion extends Thread {
        public boolean xvalor;

        private HiloVacunacion() {
            this.xvalor = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.xvalor) {
                JIF_AgendaVacunacion.this.mCargarDatosTablaAgenda();
                try {
                    Thread.sleep(20000L);
                    System.out.println("Desperto");
                } catch (InterruptedException e) {
                    System.out.println("Ocurrio un error en el hilo");
                }
            }
        }

        public boolean isXvalor() {
            return this.xvalor;
        }

        public void setXvalor(boolean xvalor) {
            this.xvalor = xvalor;
        }
    }
}
