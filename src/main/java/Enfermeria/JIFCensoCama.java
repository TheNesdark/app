package Enfermeria;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JIFCensoCama.class */
public class JIFCensoCama extends JInternalFrame {
    public JPI_CensoCama xJPI_CensoCama;
    private JPanel JPArea;

    public JIFCensoCama(String xNombre) {
        initComponents();
        setName(xNombre);
        if (this.xJPI_CensoCama == null) {
            this.xJPI_CensoCama = new JPI_CensoCama();
        }
        this.xJPI_CensoCama.setVisible(true);
        this.xJPI_CensoCama.setBounds(5, 5, 846, 431);
        this.JPArea.add(this.xJPI_CensoCama);
    }

    public void mNuevo() {
        this.xJPI_CensoCama.mNuevo();
    }

    public void mGrabar() {
    }

    public void mBuscar() {
    }

    public void mAnular() {
    }

    public void mImprimir() {
        this.xJPI_CensoCama.mImprimir();
    }

    private void initComponents() {
        this.JPArea = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("CENSO DE CAMAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcensocama");
        this.JPArea.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        GroupLayout JPAreaLayout = new GroupLayout(this.JPArea);
        this.JPArea.setLayout(JPAreaLayout);
        JPAreaLayout.setHorizontalGroup(JPAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 856, 32767));
        JPAreaLayout.setVerticalGroup(JPAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 447, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPArea, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPArea, -1, -1, 32767).addContainerGap()));
        pack();
    }
}
