package PyP;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFGestionBD.class */
public class JIFGestionBD extends JInternalFrame {
    private JComboBox JCBEps;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    public JDateChooser txtFechaF;
    public JDateChooser txtFechaI;

    public JIFGestionBD() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFRuta = new JTextField();
        this.txtFechaI = new JDateChooser();
        this.txtFechaF = new JDateChooser();
        this.JCBEps = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTIÓN DE BASES DE DATOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: PyP.JIFGestionBD.1
            public void mouseClicked(MouseEvent evt) {
                JIFGestionBD.this.JTFRutaMouseClicked(evt);
            }
        });
        this.txtFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaI.setDateFormatString("dd/MM/yyyy");
        this.txtFechaI.setFont(new Font("Arial", 1, 12));
        this.txtFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaF.setDateFormatString("dd/MM/yyyy");
        this.txtFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBEps.setFont(new Font("Arial", 1, 12));
        this.JCBEps.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 551, -2).addGap(0, 236, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFechaI, -2, 120, -2).addGap(18, 18, 18).addComponent(this.txtFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBEps, 0, -1, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtFechaI, -2, 50, -2).addComponent(this.txtFechaF, -2, 50, -2)).addComponent(this.JCBEps, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -1, 50, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(340, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
    }
}
