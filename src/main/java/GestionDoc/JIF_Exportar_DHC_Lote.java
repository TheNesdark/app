package GestionDoc;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/* JADX INFO: loaded from: GenomaP.jar:GestionDoc/JIF_Exportar_DHC_Lote.class */
public class JIF_Exportar_DHC_Lote extends JInternalFrame {
    private File xfile;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JPanel JPI_Filtro1;
    private JTabbedPane JTB_Datos;
    private JPanel jPanel1;

    public JIF_Exportar_DHC_Lote() {
        initComponents();
    }

    private void initComponents() {
        this.JTB_Datos = new JTabbedPane();
        this.JPI_Filtro1 = new JPanel();
        this.jPanel1 = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("UTILIDAD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifutilidades");
        this.JTB_Datos.setForeground(new Color(0, 103, 0));
        this.JTB_Datos.setFont(new Font("Arial", 1, 14));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 763, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        GroupLayout JPI_Filtro1Layout = new GroupLayout(this.JPI_Filtro1);
        this.JPI_Filtro1.setLayout(JPI_Filtro1Layout);
        JPI_Filtro1Layout.setHorizontalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        JPI_Filtro1Layout.setVerticalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(307, 32767)));
        this.JTB_Datos.addTab("DETALLE", this.JPI_Filtro1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos).addContainerGap()));
        pack();
    }
}
