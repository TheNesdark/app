package Cirugia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Cirugia/JIF_IProgramacion.class */
public class JIF_IProgramacion extends JInternalFrame {
    private String xsql;
    private String xnombre;
    private String[] xsala;
    private String[][] parametros;
    private JComboBox JCBSalaCirugia;
    private JCheckBox JCHEstado;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    private JPanel jPanel1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private int xestado = 0;
    private boolean xlleno = false;

    public JIF_IProgramacion(String xnombre, String xtitulo) {
        initComponents();
        setTitle(xtitulo.toUpperCase());
        setName(xnombre);
        this.xnombre = xnombre;
        mNuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCHEstado = new JCheckBox();
        this.JCBSalaCirugia = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROGRAMACION CIRUGIAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "GENERADOR DE AGENDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd//MM/yyyy");
        this.JDFechaI.setName("txtFecha");
        this.JDFechaI.addMouseListener(new MouseAdapter() { // from class: Cirugia.JIF_IProgramacion.1
            public void mouseClicked(MouseEvent evt) {
                JIF_IProgramacion.this.JDFechaIMouseClicked(evt);
            }
        });
        this.JDFechaI.addFocusListener(new FocusAdapter() { // from class: Cirugia.JIF_IProgramacion.2
            public void focusGained(FocusEvent evt) {
                JIF_IProgramacion.this.JDFechaIFocusGained(evt);
            }
        });
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Cirugia.JIF_IProgramacion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_IProgramacion.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd//MM/yyyy");
        this.JDFechaF.setName("txtFecha");
        this.JDFechaF.addMouseListener(new MouseAdapter() { // from class: Cirugia.JIF_IProgramacion.4
            public void mouseClicked(MouseEvent evt) {
                JIF_IProgramacion.this.JDFechaFMouseClicked(evt);
            }
        });
        this.JDFechaF.addFocusListener(new FocusAdapter() { // from class: Cirugia.JIF_IProgramacion.5
            public void focusGained(FocusEvent evt) {
                JIF_IProgramacion.this.JDFechaFFocusGained(evt);
            }
        });
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Cirugia.JIF_IProgramacion.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_IProgramacion.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Todas las salas?");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Cirugia.JIF_IProgramacion.7
            public void actionPerformed(ActionEvent evt) {
                JIF_IProgramacion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBSalaCirugia.setFont(new Font("Arial", 1, 12));
        this.JCBSalaCirugia.setBorder(BorderFactory.createTitledBorder((Border) null, "Sala de Cirugia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSalaCirugia.addItemListener(new ItemListener() { // from class: Cirugia.JIF_IProgramacion.8
            public void itemStateChanged(ItemEvent evt) {
                JIF_IProgramacion.this.JCBSalaCirugiaItemStateChanged(evt);
            }
        });
        this.JCBSalaCirugia.addActionListener(new ActionListener() { // from class: Cirugia.JIF_IProgramacion.9
            public void actionPerformed(ActionEvent evt) {
                JIF_IProgramacion.this.JCBSalaCirugiaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSalaCirugia, 0, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 149, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCHEstado, -2, 47, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSalaCirugia, -2, 50, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSalaCirugiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSalaCirugiaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFMouseClicked(MouseEvent evt) {
    }

    private void mLLenarCombo() {
        this.xlleno = false;
        this.JCBSalaCirugia.removeAllItems();
        String sala = "SELECT `q_salacirugias`.`Id`, `q_salacirugias`.`Nbre` FROM `q_agendacx` INNER JOIN `q_salacirugias` ON (`q_agendacx`.`Id_SalaCirugia` = `q_salacirugias`.`Id`)WHERE (`q_agendacx`.`FechaCx` >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `q_agendacx`.`FechaCx` <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY `q_salacirugias`.`Id`, `q_salacirugias`.`Nbre`ORDER BY `q_salacirugias`.`Nbre` ASC;";
        System.out.println("programcion : " + sala);
        this.xsala = this.xconsulta.llenarCombo(sala, this.xsala, this.JCBSalaCirugia);
        this.JCBSalaCirugia.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCHEstado.setSelected(false);
        mLLenarCombo();
    }

    public void mImprimir() {
        if (this.xestado != 1) {
            if (this.JCBSalaCirugia.getSelectedIndex() != -1) {
                this.parametros = new String[5][2];
                this.parametros[0][0] = "FechaI";
                this.parametros[0][1] = this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate());
                this.parametros[1][0] = "FechaF";
                this.parametros[1][1] = this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate());
                this.parametros[2][0] = "Sala";
                this.parametros[2][1] = this.xsala[this.JCBSalaCirugia.getSelectedIndex()];
                this.parametros[3][0] = "SUBREPORT_DIR";
                this.parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
                this.parametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "AgendaCX", this.parametros);
                return;
            }
            return;
        }
        this.parametros = new String[4][2];
        this.parametros[0][0] = "FechaI";
        this.parametros[0][1] = this.xmetodos.formatoAMD1.format(this.JDFechaI.getDate());
        this.parametros[1][0] = "FechaF";
        this.parametros[1][1] = this.xmetodos.formatoAMD1.format(this.JDFechaF.getDate());
        this.parametros[2][0] = "SUBREPORT_DIR";
        this.parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        this.parametros[3][0] = "SUBREPORTFIRMA_DIR";
        this.parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "AgendaCX_General", this.parametros);
    }
}
