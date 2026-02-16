package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFRCSeguridadClinica.class */
public class JIFRCSeguridadClinica extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xnfila = -1;
    private int xnfila1 = -1;
    private int xnfila2 = -1;
    private int xesnc = 0;
    private int xaplicaencuesta = 1;
    private int xmodulo;
    private Object[] xdato;
    private JDateChooser JDFecha;
    private JPanel JPIDAnalisis;
    private JPanel JPIDReporte;
    private JPanel JPIDatosP;
    private JFormattedTextField JTFFHora;
    private JTabbedPane JTPDatosR;

    public JIFRCSeguridadClinica(int xmodulo, String xnombre) {
        this.xmodulo = 0;
        initComponents();
        setName(xnombre);
        this.xmodulo = xmodulo;
        mNuevo();
    }

    private void initComponents() {
        this.JTPDatosR = new JTabbedPane();
        this.JPIDReporte = new JPanel();
        this.JPIDatosP = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIDAnalisis = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setTitle("REPORTE DE CASOS DE SEGURIDAD CLÍNICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        addInternalFrameListener(new InternalFrameListener() { // from class: Sgc.JIFRCSeguridadClinica.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRCSeguridadClinica.this.formInternalFrameClosing(evt);
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
        this.JTPDatosR.setForeground(new Color(0, 103, 0));
        this.JTPDatosR.setFont(new Font("Arial", 1, 14));
        this.JPIDReporte.setFont(new Font("Arial", 1, 12));
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPIDatosP.setFont(new Font("Arial", 1, 12));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance(2))));
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 105, -2).addContainerGap(616, 32767)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFHora, -2, -1, -2).addComponent(this.JDFecha, -2, -1, -2)).addContainerGap(257, 32767)));
        GroupLayout JPIDReporteLayout = new GroupLayout(this.JPIDReporte);
        this.JPIDReporte.setLayout(JPIDReporteLayout);
        JPIDReporteLayout.setHorizontalGroup(JPIDReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDReporteLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addContainerGap()));
        JPIDReporteLayout.setVerticalGroup(JPIDReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDReporteLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addContainerGap(275, 32767)));
        this.JTPDatosR.addTab("REPORTE", this.JPIDReporte);
        this.JPIDAnalisis.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDAnalisisLayout = new GroupLayout(this.JPIDAnalisis);
        this.JPIDAnalisis.setLayout(JPIDAnalisisLayout);
        JPIDAnalisisLayout.setHorizontalGroup(JPIDAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 889, 32767));
        JPIDAnalisisLayout.setVerticalGroup(JPIDAnalisisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 624, 32767));
        this.JTPDatosR.addTab("ANÁLISIS", this.JPIDAnalisis);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosR).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosR, -2, 655, -2).addContainerGap(28, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        this.JDFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
    }
}
