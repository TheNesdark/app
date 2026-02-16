package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIF_Cierre_Inventario.class */
public class JIF_Cierre_Inventario extends JInternalFrame {
    public DefaultTableModel xmodelo;
    private String[][] xId_Bodega;
    private String xsql;
    private ButtonGroup JBG_Conteo;
    private JComboBox JCB_Bodega;
    private JLabel JLB_Fecha;
    private JLabel JLB_NUmero;
    private JPanel JPI_Conteos;
    private JPanel JPI_Datos;
    private JPanel JPI_Historico;
    private JRadioButton JRB_CDos;
    private JRadioButton JRB_CUno;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIF_Cierre_Inventario() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.JBG_Conteo = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPI_Datos = new JPanel();
        this.JCB_Bodega = new JComboBox();
        this.JLB_Fecha = new JLabel();
        this.JLB_NUmero = new JLabel();
        this.JPI_Conteos = new JPanel();
        this.JRB_CUno = new JRadioButton();
        this.JRB_CDos = new JRadioButton();
        this.JPI_Historico = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("CIERRE DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCB_Bodega.setFont(new Font("Arial", 1, 12));
        this.JCB_Bodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCB_Bodega.addItemListener(new ItemListener() { // from class: Inventarios.JIF_Cierre_Inventario.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_Cierre_Inventario.this.JCB_BodegaItemStateChanged(evt);
            }
        });
        this.JLB_Fecha.setFont(new Font("Arial", 1, 18));
        this.JLB_Fecha.setHorizontalAlignment(0);
        this.JLB_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_NUmero.setFont(new Font("Arial", 1, 18));
        this.JLB_NUmero.setHorizontalAlignment(0);
        this.JLB_NUmero.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPI_Conteos.setBorder(BorderFactory.createTitledBorder((Border) null, "Conteos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Conteo.add(this.JRB_CUno);
        this.JRB_CUno.setFont(new Font("Arial", 1, 12));
        this.JRB_CUno.setSelected(true);
        this.JRB_CUno.setText("Uno");
        this.JBG_Conteo.add(this.JRB_CDos);
        this.JRB_CDos.setFont(new Font("Arial", 1, 12));
        this.JRB_CDos.setText("Dos");
        GroupLayout JPI_ConteosLayout = new GroupLayout(this.JPI_Conteos);
        this.JPI_Conteos.setLayout(JPI_ConteosLayout);
        JPI_ConteosLayout.setHorizontalGroup(JPI_ConteosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConteosLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_CUno).addGap(26, 26, 26).addComponent(this.JRB_CDos).addContainerGap(29, 32767)));
        JPI_ConteosLayout.setVerticalGroup(JPI_ConteosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConteosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ConteosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_CUno).addComponent(this.JRB_CDos)).addContainerGap(-1, 32767)));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JPI_Conteos, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JCB_Bodega, -2, 356, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 62, 32767).addComponent(this.JLB_Fecha, -2, 139, -2).addGap(44, 44, 44).addComponent(this.JLB_NUmero, -2, 139, -2))).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCB_Bodega, -1, 50, 32767).addComponent(this.JLB_Fecha, -1, -1, 32767).addComponent(this.JLB_NUmero, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_Conteos, -2, -1, -2).addContainerGap(70, 32767)));
        this.JTPDatos.addTab("CIERRE", this.JPI_Datos);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 760, 32767));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 204, 32767));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPDatos, -2, 235, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_BodegaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCB_Bodega.getSelectedIndex() > -1) {
            this.JLB_Fecha.setText(this.xId_Bodega[this.JCB_Bodega.getSelectedIndex()][2]);
            this.JLB_NUmero.setText(this.xId_Bodega[this.JCB_Bodega.getSelectedIndex()][1]);
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCB_Bodega.removeAllItems();
        this.xsql = "SELECT `i_bodegas`.`Id` , `i_bodegas`.`Nbre` , `i_inventario`.`Id` , date_format(`i_inventario`.`Fecha_Inventario`,'%d-%m-%Y') as Fecha  FROM  `i_inventario` INNER JOIN `i_bodegas`  ON (`i_inventario`.`Id_Bodega` = `i_bodegas`.`Id`) WHERE (`i_inventario`.`Estado` =1 AND `i_inventario`.`Fecha_Cierre` IS NULL) ";
        this.xId_Bodega = this.xct.llenarComboyLista(this.xsql, this.xId_Bodega, this.JCB_Bodega, 4);
        this.JCB_Bodega.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mGrabar() {
    }
}
