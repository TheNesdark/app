package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.impl.laboratorio.ResultadoInterfazDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.dao.laboratorio.ResultadosInterfazDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIF_ValidacionResultado_Interfaz.class */
public class JIF_ValidacionResultado_Interfaz extends JInternalFrame {
    private ResultadosInterfazDAO xResultadosDAO;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private LaboratorioDAO xImplLabotaorio;
    private WorkerSQL xWorkerSQL;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPI_Filtro;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIF_ValidacionResultado_Interfaz() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v19, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Filtro = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("VALIDACION MASIVA DE RESULTADOS  - INTERFACES");
        setName("xJIfValidacionResultadoInterfaz");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addGap(26, 26, 26).addComponent(this.JDFFechaF, -2, 121, -2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addContainerGap(19, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 1026, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 460, -2).addContainerGap(37, 32767)));
        pack();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xResultadosDAO = (ResultadoInterfazDAOImpl) classPathXmlApplicationContext.getBean("resultadosInterfazDAOImpl");
        this.xImplLabotaorio = (LaboratorioDAOImpl) classPathXmlApplicationContext.getBean("laboratorioDAOImpl");
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        mCreaModeloTabla();
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando Información...", this);
        this.xWorkerSQL.execute();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Documento", "Usuario", "Sexo", "IdProcedimiento", "NProcedimiento", "IdProtocolo", "NProtocolo", "FechaResultado", "Resultado", "V/Minimo", "V/Maximo", "Unidad", "Alterado?", "FechaC", "IdRecepcion"}) { // from class: com.genoma.plus.controller.laboratorio.JIF_ValidacionResultado_Interfaz.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
    }

    public void mCargarDatos() {
        List<Object[]> list = this.xResultadosDAO.listadoResultados(this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()));
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatos);
            for (int y = 0; y < this.JTDetalle.getColumnCount(); y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
        }
    }

    public void mGrabar() {
        int alterado;
        String string;
        if (this.JTDetalle.getRowCount() != -1) {
            int m = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (m == 0) {
                Long idResultado = null;
                String idRecepcion = "";
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(x, 12).toString()).booleanValue()) {
                        alterado = 1;
                    } else {
                        alterado = 0;
                    }
                    if (!idRecepcion.equals(this.JTDetalle.getValueAt(x, 14))) {
                        idResultado = this.xImplLabotaorio.addResultado(this.JTDetalle.getValueAt(x, 14).toString(), this.JTDetalle.getValueAt(x, 13).toString(), "", Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), "0", "");
                        this.xImplLabotaorio.addResultadoDetalle(idResultado, this.JTDetalle.getValueAt(x, 7).toString(), Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), Long.valueOf(this.JTDetalle.getValueAt(x, 3).toString()), Long.valueOf(this.JTDetalle.getValueAt(x, 5).toString()), "82", this.JTDetalle.getValueAt(x, 8).toString(), this.JTDetalle.getValueAt(x, 11).toString(), this.JTDetalle.getValueAt(x, 9).toString(), this.JTDetalle.getValueAt(x, 10).toString(), "", Integer.valueOf(alterado), 1, 1, "", "");
                        this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(alterado), 1, Long.valueOf(this.JTDetalle.getValueAt(x, 3).toString()), Long.valueOf(this.JTDetalle.getValueAt(x, 14).toString()), 1, 1);
                        string = this.JTDetalle.getValueAt(x, 14).toString();
                    } else {
                        this.xImplLabotaorio.addResultadoDetalle(idResultado, this.JTDetalle.getValueAt(x, 7).toString(), Long.valueOf(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()), Long.valueOf(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().longValue()), Long.valueOf(this.JTDetalle.getValueAt(x, 3).toString()), Long.valueOf(this.JTDetalle.getValueAt(x, 5).toString()), "82", this.JTDetalle.getValueAt(x, 8).toString(), this.JTDetalle.getValueAt(x, 11).toString(), this.JTDetalle.getValueAt(x, 9).toString(), this.JTDetalle.getValueAt(x, 10).toString(), "", Integer.valueOf(alterado), 1, 1, "", "");
                        this.xImplLabotaorio.updateDetalleRecepcion(Integer.valueOf(alterado), 1, Long.valueOf(this.JTDetalle.getValueAt(x, 3).toString()), Long.valueOf(this.JTDetalle.getValueAt(x, 14).toString()), 1, 1);
                        string = this.JTDetalle.getValueAt(x, 14).toString();
                    }
                    idRecepcion = string;
                }
                mCargarDatos();
            }
        }
    }
}
