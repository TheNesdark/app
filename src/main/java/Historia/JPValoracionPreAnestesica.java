package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPValoracionPreAnestesica.class */
public class JPValoracionPreAnestesica extends JPanel {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JPanel JPIExamen;
    private JTabbedPane JTPDatos;

    public JPValoracionPreAnestesica() {
        initComponents();
    }

    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIExamen = new JPanel();
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIExamenLayout = new GroupLayout(this.JPIExamen);
        this.JPIExamen.setLayout(JPIExamenLayout);
        JPIExamenLayout.setHorizontalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, 32767));
        JPIExamenLayout.setVerticalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 633, 32767));
        this.JTPDatos.addTab("EXÀMEN FÌSICO Y ANTECEDENTES", this.JPIExamen);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }
}
