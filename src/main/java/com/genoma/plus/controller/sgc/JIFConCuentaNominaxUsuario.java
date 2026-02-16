package com.genoma.plus.controller.sgc;

import com.genoma.plus.dao.impl.sgc.InformesSgcDAOImpl;
import com.genoma.plus.dao.sgc.InformesSgcDAO;
import com.genoma.plus.dto.sgc.ConNominaxUsuarioDTO;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFConCuentaNominaxUsuario.class */
public class JIFConCuentaNominaxUsuario extends JInternalFrame {
    private InformesSgcDAO xInformesSgcDAO;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private boolean xLleno;
    private boolean xLleno1;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;

    public JIFConCuentaNominaxUsuario() {
        initComponents();
        springStart();
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xInformesSgcDAO = (InformesSgcDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesSgcDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "FechaD", "Id_PersonaDescuento", "NoHistoria", "Codigo1Sap", "NUsuarios", "VDescontado", "Valor", "Debe", "RLaboral"}) { // from class: com.genoma.plus.controller.sgc.JIFConCuentaNominaxUsuario.1
            Class[] types = {Long.class, String.class, Integer.class, String.class, Double.class, String.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        mModelo();
        List<ConNominaxUsuarioDTO> list = this.xInformesSgcDAO.list();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getFechaD(), x, 1);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId_PersonaDescuento()), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNoHistoria(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getCodigo1Sap(), x, 4);
            this.xmodelo.setValueAt(list.get(x).getNUsuarios(), x, 5);
            this.xmodelo.setValueAt(list.get(x).getVDescontado(), x, 6);
            this.xmodelo.setValueAt(list.get(x).getValor(), x, 7);
            this.xmodelo.setValueAt(list.get(x).getDebe(), x, 8);
            this.xmodelo.setValueAt(list.get(x).getRLaboral(), x, 9);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLOLIDADO DE CUENTA NOMINA POR USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("Consolidado de Cuenta Nomina por Usuario");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 818, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 369, 32767).addContainerGap()));
        pack();
    }
}
