package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFPreguntaDominio.class */
public class JIFPreguntaDominio extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private String[] xidgenerico;
    private JCheckBox JCHEstado;
    private JPanel JPFormaA;
    private JPanel JPFormaB;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFFormaA;
    private JFormattedTextField JTFFFormaB;
    private JFormattedTextField JTFFR12I;
    private JFormattedTextField JTFFR12I1;
    private JFormattedTextField JTFFR1I;
    private JFormattedTextField JTFFR1I1;
    private JFormattedTextField JTFFR1S;
    private JFormattedTextField JTFFR1S1;
    private JFormattedTextField JTFFR2S;
    private JFormattedTextField JTFFR2S1;
    private JFormattedTextField JTFFR3I;
    private JFormattedTextField JTFFR3I1;
    private JFormattedTextField JTFFR3S;
    private JFormattedTextField JTFFR3S1;
    private JFormattedTextField JTFFR4I;
    private JFormattedTextField JTFFR4I1;
    private JFormattedTextField JTFFR4S;
    private JFormattedTextField JTFFR4S1;
    private JFormattedTextField JTFFR5I;
    private JFormattedTextField JTFFR5I1;
    private JFormattedTextField JTFFR5S;
    private JFormattedTextField JTFFR5S1;
    private JTextField JTFNombre;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private boolean xestadog = false;

    public JIFPreguntaDominio() {
        initComponents();
        mCargarDatosTabla();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v191, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JPFormaA = new JPanel();
        this.JTFFR1I = new JFormattedTextField();
        this.JTFFR1S = new JFormattedTextField();
        this.JTFFR12I = new JFormattedTextField();
        this.JTFFR2S = new JFormattedTextField();
        this.JTFFR3I = new JFormattedTextField();
        this.JTFFR3S = new JFormattedTextField();
        this.JTFFR4I = new JFormattedTextField();
        this.JTFFR4S = new JFormattedTextField();
        this.JTFFR5I = new JFormattedTextField();
        this.JTFFR5S = new JFormattedTextField();
        this.JTFFFormaA = new JFormattedTextField();
        this.JPFormaB = new JPanel();
        this.JTFFR1I1 = new JFormattedTextField();
        this.JTFFR1S1 = new JFormattedTextField();
        this.JTFFR12I1 = new JFormattedTextField();
        this.JTFFR2S1 = new JFormattedTextField();
        this.JTFFR3I1 = new JFormattedTextField();
        this.JTFFR3S1 = new JFormattedTextField();
        this.JTFFR4I1 = new JFormattedTextField();
        this.JTFFR4S1 = new JFormattedTextField();
        this.JTFFR5I1 = new JFormattedTextField();
        this.JTFFR5S1 = new JFormattedTextField();
        this.JTFFFormaB = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE PREGUNTA x DOMINIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpreguntaxdominio");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ParametrizacionN.JIFPreguntaDominio.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFPreguntaDominio.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("Digite el nombre del municipio");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPreguntaDominio.2
            public void actionPerformed(ActionEvent evt) {
                JIFPreguntaDominio.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JPFormaA.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA A", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFR1I.setBorder(BorderFactory.createTitledBorder((Border) null, "R1I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR1I.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR1I.setHorizontalAlignment(4);
        this.JTFFR1I.setFont(new Font("Arial", 1, 12));
        this.JTFFR1I.setValue(new Integer(0));
        this.JTFFR1S.setBorder(BorderFactory.createTitledBorder((Border) null, "R1S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR1S.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR1S.setHorizontalAlignment(4);
        this.JTFFR1S.setFont(new Font("Arial", 1, 12));
        this.JTFFR1S.setValue(new Integer(0));
        this.JTFFR12I.setBorder(BorderFactory.createTitledBorder((Border) null, "R2I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR12I.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR12I.setHorizontalAlignment(4);
        this.JTFFR12I.setFont(new Font("Arial", 1, 12));
        this.JTFFR12I.setValue(new Integer(0));
        this.JTFFR2S.setBorder(BorderFactory.createTitledBorder((Border) null, "R2S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR2S.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR2S.setHorizontalAlignment(4);
        this.JTFFR2S.setFont(new Font("Arial", 1, 12));
        this.JTFFR2S.setValue(new Integer(0));
        this.JTFFR3I.setBorder(BorderFactory.createTitledBorder((Border) null, "R3I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR3I.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR3I.setHorizontalAlignment(4);
        this.JTFFR3I.setFont(new Font("Arial", 1, 12));
        this.JTFFR3I.setValue(new Integer(0));
        this.JTFFR3S.setBorder(BorderFactory.createTitledBorder((Border) null, "R3S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR3S.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR3S.setHorizontalAlignment(4);
        this.JTFFR3S.setFont(new Font("Arial", 1, 12));
        this.JTFFR3S.setValue(new Integer(0));
        this.JTFFR4I.setBorder(BorderFactory.createTitledBorder((Border) null, "R4I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR4I.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR4I.setHorizontalAlignment(4);
        this.JTFFR4I.setFont(new Font("Arial", 1, 12));
        this.JTFFR4I.setValue(new Integer(0));
        this.JTFFR4S.setBorder(BorderFactory.createTitledBorder((Border) null, "R4S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR4S.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR4S.setHorizontalAlignment(4);
        this.JTFFR4S.setFont(new Font("Arial", 1, 12));
        this.JTFFR4S.setValue(new Integer(0));
        this.JTFFR5I.setBorder(BorderFactory.createTitledBorder((Border) null, "R5I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR5I.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR5I.setHorizontalAlignment(4);
        this.JTFFR5I.setFont(new Font("Arial", 1, 12));
        this.JTFFR5I.setValue(new Integer(0));
        this.JTFFR5S.setBorder(BorderFactory.createTitledBorder((Border) null, "R5S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR5S.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR5S.setHorizontalAlignment(4);
        this.JTFFR5S.setFont(new Font("Arial", 1, 12));
        this.JTFFR5S.setValue(new Integer(0));
        this.JTFFFormaA.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma A", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFormaA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFFormaA.setHorizontalAlignment(4);
        this.JTFFFormaA.setFont(new Font("Arial", 1, 12));
        this.JTFFFormaA.setValue(new Integer(0));
        GroupLayout JPFormaALayout = new GroupLayout(this.JPFormaA);
        this.JPFormaA.setLayout(JPFormaALayout);
        JPFormaALayout.setHorizontalGroup(JPFormaALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormaALayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFFormaA, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFR1I, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR1S, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR12I, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR2S, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR3I, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR3S, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR4I, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR4S, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR5I, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR5S, -2, 65, -2).addContainerGap(-1, 32767)));
        JPFormaALayout.setVerticalGroup(JPFormaALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFormaALayout.createSequentialGroup().addGroup(JPFormaALayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormaALayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFR1I, -2, -1, -2).addComponent(this.JTFFR1S, -2, -1, -2).addComponent(this.JTFFR12I, -2, -1, -2).addComponent(this.JTFFR2S, -2, -1, -2).addComponent(this.JTFFR3I, -2, -1, -2).addComponent(this.JTFFR3S, -2, -1, -2).addComponent(this.JTFFR4I, -2, -1, -2).addComponent(this.JTFFR4S, -2, -1, -2).addComponent(this.JTFFR5I, -2, -1, -2).addComponent(this.JTFFR5S, -2, -1, -2)).addComponent(this.JTFFFormaA, -2, -1, -2)).addGap(5, 5, 5)));
        this.JPFormaB.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA B", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFR1I1.setBorder(BorderFactory.createTitledBorder((Border) null, "R1I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR1I1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR1I1.setHorizontalAlignment(4);
        this.JTFFR1I1.setFont(new Font("Arial", 1, 12));
        this.JTFFR1I1.setValue(new Integer(0));
        this.JTFFR1S1.setBorder(BorderFactory.createTitledBorder((Border) null, "R1S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR1S1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR1S1.setHorizontalAlignment(4);
        this.JTFFR1S1.setFont(new Font("Arial", 1, 12));
        this.JTFFR1S1.setValue(new Integer(0));
        this.JTFFR12I1.setBorder(BorderFactory.createTitledBorder((Border) null, "R2I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR12I1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR12I1.setHorizontalAlignment(4);
        this.JTFFR12I1.setFont(new Font("Arial", 1, 12));
        this.JTFFR12I1.setValue(new Integer(0));
        this.JTFFR2S1.setBorder(BorderFactory.createTitledBorder((Border) null, "R2S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR2S1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR2S1.setHorizontalAlignment(4);
        this.JTFFR2S1.setFont(new Font("Arial", 1, 12));
        this.JTFFR2S1.setValue(new Integer(0));
        this.JTFFR3I1.setBorder(BorderFactory.createTitledBorder((Border) null, "R3I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR3I1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR3I1.setHorizontalAlignment(4);
        this.JTFFR3I1.setFont(new Font("Arial", 1, 12));
        this.JTFFR3I1.setValue(new Integer(0));
        this.JTFFR3S1.setBorder(BorderFactory.createTitledBorder((Border) null, "R3S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR3S1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR3S1.setHorizontalAlignment(4);
        this.JTFFR3S1.setFont(new Font("Arial", 1, 12));
        this.JTFFR3S1.setValue(new Integer(0));
        this.JTFFR4I1.setBorder(BorderFactory.createTitledBorder((Border) null, "R4I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR4I1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR4I1.setHorizontalAlignment(4);
        this.JTFFR4I1.setFont(new Font("Arial", 1, 12));
        this.JTFFR4I1.setValue(new Integer(0));
        this.JTFFR4S1.setBorder(BorderFactory.createTitledBorder((Border) null, "R4S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR4S1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR4S1.setHorizontalAlignment(4);
        this.JTFFR4S1.setFont(new Font("Arial", 1, 12));
        this.JTFFR4S1.setValue(new Integer(0));
        this.JTFFR5I1.setBorder(BorderFactory.createTitledBorder((Border) null, "R5I", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR5I1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR5I1.setHorizontalAlignment(4);
        this.JTFFR5I1.setFont(new Font("Arial", 1, 12));
        this.JTFFR5I1.setValue(new Integer(0));
        this.JTFFR5S1.setBorder(BorderFactory.createTitledBorder((Border) null, "R5S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFR5S1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFR5S1.setHorizontalAlignment(4);
        this.JTFFR5S1.setFont(new Font("Arial", 1, 12));
        this.JTFFR5S1.setValue(new Integer(0));
        this.JTFFFormaB.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma B", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFFormaB.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.0"))));
        this.JTFFFormaB.setHorizontalAlignment(4);
        this.JTFFFormaB.setFont(new Font("Arial", 1, 12));
        this.JTFFFormaB.setValue(new Integer(0));
        GroupLayout JPFormaBLayout = new GroupLayout(this.JPFormaB);
        this.JPFormaB.setLayout(JPFormaBLayout);
        JPFormaBLayout.setHorizontalGroup(JPFormaBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormaBLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFFFormaB, -2, 94, -2).addGap(18, 18, 18).addComponent(this.JTFFR1I1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR1S1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR12I1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR2S1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR3I1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR3S1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR4I1, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR4S1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR5I1, -2, 65, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFR5S1, -2, 65, -2).addContainerGap(153, 32767)));
        JPFormaBLayout.setVerticalGroup(JPFormaBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFormaBLayout.createSequentialGroup().addGroup(JPFormaBLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFR1I1, -2, -1, -2).addComponent(this.JTFFR1S1, -2, -1, -2).addComponent(this.JTFFR12I1, -2, -1, -2).addComponent(this.JTFFR2S1, -2, -1, -2).addComponent(this.JTFFR3I1, -2, -1, -2).addComponent(this.JTFFR3S1, -2, -1, -2).addComponent(this.JTFFR4I1, -2, -1, -2).addComponent(this.JTFFR4S1, -2, -1, -2).addComponent(this.JTFFR5I1, -2, -1, -2).addComponent(this.JTFFR5S1, -2, -1, -2).addComponent(this.JTFFFormaB, -2, -1, -2)).addGap(5, 5, 5)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFormaA, -1, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 769, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(0, 0, 32767)))).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPFormaB, -1, -1, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2).addComponent(this.JCHEstado)).addGap(5, 5, 5).addComponent(this.JPFormaA, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPFormaB, -2, -1, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPreguntaDominio.3
            public void mouseClicked(MouseEvent evt) {
                JIFPreguntaDominio.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 257, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFFFormaA.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2));
            this.JTFFFormaB.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3));
            this.JTFFR1I.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4));
            this.JTFFR1S.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5));
            this.JTFFR12I.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6));
            this.JTFFR2S.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7));
            this.JTFFR3I.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8));
            this.JTFFR3S.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9));
            this.JTFFR4I.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10));
            this.JTFFR4S.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11));
            this.JTFFR5I.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 12));
            this.JTFFR5S.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13));
            this.JTFFR1I1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14));
            this.JTFFR1S1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15));
            this.JTFFR12I1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16));
            this.JTFFR2S1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 17));
            this.JTFFR3I1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 18));
            this.JTFFR3S1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 19));
            this.JTFFR4I1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 20));
            this.JTFFR4S1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 21));
            this.JTFFR5I1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 22));
            this.JTFFR5S1.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 23));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString()).booleanValue());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 24).toString()).booleanValue()) {
                this.xestado = 1;
            } else {
                this.xestado = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFFFormaA.setValue(0);
        this.JTFFFormaB.setValue(0);
        this.JTFFR1I.setValue(0);
        this.JTFFR1S.setValue(0);
        this.JTFFR12I.setValue(0);
        this.JTFFR2S.setValue(0);
        this.JTFFR3I.setValue(0);
        this.JTFFR3S.setValue(0);
        this.JTFFR4I.setValue(0);
        this.JTFFR4S.setValue(0);
        this.JTFFR5I.setValue(0);
        this.JTFFR5S.setValue(0);
        this.JCHEstado.setSelected(true);
        this.xestado = 1;
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    String sql = "insert into so_tipo_pregunta_dominio (`Nbre` , `FFormaA`  , `FFormaB`  , `FA_R1I` , `FA_R1S`  , `FA_R2I` , `FA_R2S`  , `FA_R3I` , `FA_R3S` , `FA_R4I`  , `FA_R4S` , `FA_R5I` , `FA_R5S` , `Estado`, UsuarioS) values('" + this.JTFNombre.getText() + "','" + this.JTFFFormaA.getValue() + "','" + this.JTFFFormaB.getValue() + "','" + this.JTFFR1I.getValue() + "','" + this.JTFFR1S.getValue() + "','" + this.JTFFR12I.getValue() + "','" + this.JTFFR2S.getValue() + "','" + this.JTFFR3I.getValue() + "','" + this.JTFFR3S.getValue() + "','" + this.JTFFR4I.getValue() + "','" + this.JTFFR4S.getValue() + "','" + this.JTFFR5I.getValue() + "','" + this.JTFFR5S.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                } else {
                    String sql2 = "UPDATE so_tipo_pregunta_dominio SET Nbre='" + this.JTFNombre.getText() + "' ,FFormaA='" + this.JTFFFormaA.getValue() + "',FFormaB='" + this.JTFFFormaB.getValue() + "',FA_R1I='" + this.JTFFR1I.getValue() + "' ,FA_R1S='" + this.JTFFR2S.getValue() + "' ,FA_R2I='" + this.JTFFR12I.getValue() + "',FA_R2S='" + this.JTFFR2S.getValue() + "',FA_R3I='" + this.JTFFR3I.getValue() + "',FA_R3S='" + this.JTFFR3S.getValue() + "',FA_R4I='" + this.JTFFR4I.getValue() + "',FA_R4S='" + this.JTFFR4S.getValue() + "',FA_R5I='" + this.JTFFR5I.getValue() + "',FA_R5S='" + this.JTFFR5S.getValue() + "',Estado='" + this.xestado + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id='" + Principal.txtNo.getText() + "'";
                    this.xconsulta.ejecutarSQL(sql2);
                    this.xconsulta.cerrarConexionBd();
                }
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFPreguntaDominio.4
            Class[] types = {Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(3);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(5);
    }

    private void mCargarDatosTabla() {
        try {
            String[] xencabezado = {"Id", "Nombre", "FormaA", "FormaB", "A_R1I", "A_R1S", "A_R2I", "A_R2S", "A_R3I", "A_R3S", "A_R4I", "A_R4S", "A_R5I", "A_R5S", "B_R1I", "B_R1S", "B_R2I", "B_R2S", "B_R3I", "B_R3S", "B_R4I", "B_R4S", "B_R5I", "B_R5S", "Estado"};
            mCrearModeloDatos(xencabezado);
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id` , `Nbre` , `FFormaA`  , `FFormaB` , `FA_R1I`, FA_R1S  , FA_R2I , `FA_R2S`  , `FA_R3I` , `FA_R3S`  , `FA_R4I`  , `FA_R4S` , `FA_R5I` , `FA_R5S` ,  `FB_R1I`, FB_R1S  , FB_R2I , `FB_R2S`  , `FB_R3I` , `FB_R3S`  , `FB_R4I`  , `FB_R4S` , `FB_R5I` , `FB_R5S` ,`Estado` FROM `so_tipo_pregunta_dominio`");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(16)), n, 15);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(17)), n, 16);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(18)), n, 17);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(19)), n, 18);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(20)), n, 19);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(21)), n, 20);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(22)), n, 21);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(23)), n, 22);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(24)), n, 23);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(25)), n, 24);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenericoCh.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
