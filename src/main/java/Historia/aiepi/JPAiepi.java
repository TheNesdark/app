package Historia.aiepi;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.javaswingcomponents.accordion.JSCAccordion;
import com.javaswingcomponents.accordion.TabOrientation;
import com.javaswingcomponents.accordion.listener.AccordionEvent;
import com.javaswingcomponents.accordion.listener.AccordionEventType;
import com.javaswingcomponents.accordion.listener.AccordionListener;
import com.javaswingcomponents.accordion.plaf.AccordionUI;
import com.javaswingcomponents.accordion.plaf.basic.BasicVerticalTabRenderer;
import com.javaswingcomponents.accordion.plaf.steel.SteelAccordionUI;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi.class */
public class JPAiepi extends JPanel {
    static JFrame frame;
    private JPAiepi01 xPanel;
    private JPAiepi02 xPanel2;
    private JPAiepi03 xPanel3;
    private JPAiepi04 xPanel4;
    private JPAiepi05 xPanel5;
    private JPAiepi06 xPanel6;
    private JPAiepi07 xPanel7;
    private JPAiepi08 xPanel8;
    private JPAiepi09 xPanel9;
    private JPAiepi10 xPanel10;
    private JPAiepi11 xPanel11;
    private JPAiepi12 xPanel12;
    private JPAiepi13 xPanel13;
    private JPAiepi14 xPanel14;
    private JPanel JPEncuesta;
    private JScrollPane JSPCuestionario;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xidEvaluacion = "";

    public JPAiepi() {
        initComponents();
        frame = new JFrame();
        Container panel = frame.getContentPane();
        panel.add(this.JSPCuestionario, "Center");
        JSCAccordion accordion = new JSCAccordion();
        howToAddTabs(accordion);
        howToListenForChanges(accordion);
        howToChangeTabOrientation(accordion);
        howToChangeTheLookAndFeel(accordion);
        howToCustomizeALookAndFeel(accordion);
        setLayout(new GridLayout(1, 1, 30, 30));
        add(accordion);
    }

    private void howToAddTabs(JSCAccordion accordion) {
        JPanel transparentPanel = new JPanel();
        transparentPanel.setOpaque(false);
        transparentPanel.setBackground(Color.GRAY);
        try {
            ResultSet xrs = this.xct.traerRs("SELECT Id, `Nbre` FROM `p_aiepi_preguntas_generales` WHERE (`Estado` =1 AND TipoAiepi=1) ORDER BY `Orden` ASC");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    switch (xrs.getInt("Id")) {
                        case 1:
                            this.xPanel = new JPAiepi01(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel);
                            break;
                        case 2:
                            this.xPanel2 = new JPAiepi02(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel2);
                            break;
                        case 3:
                            this.xPanel3 = new JPAiepi03(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel3);
                            break;
                        case 4:
                            this.xPanel4 = new JPAiepi04(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel4);
                            break;
                        case 5:
                            this.xPanel5 = new JPAiepi05(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel5);
                            break;
                        case 6:
                            this.xPanel6 = new JPAiepi06(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel6);
                            break;
                        case 7:
                            this.xPanel7 = new JPAiepi07(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel7);
                            break;
                        case 9:
                            this.xPanel9 = new JPAiepi09(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel9);
                            break;
                        case 10:
                            this.xPanel10 = new JPAiepi10(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel10);
                            break;
                        case 11:
                            this.xPanel11 = new JPAiepi11(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel11);
                            break;
                        case 12:
                            this.xPanel12 = new JPAiepi12(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel12);
                            break;
                        case 13:
                            this.xPanel13 = new JPAiepi13(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel13);
                            break;
                        case 14:
                            this.xPanel14 = new JPAiepi14(xrs.getInt("Id"));
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel14);
                            break;
                        case 15:
                            this.xPanel8 = new JPAiepi08();
                            accordion.addTab(xrs.getString("Nbre"), this.xPanel8);
                            break;
                    }
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void howToListenForChanges(JSCAccordion accordion) {
        accordion.addAccordionListener(new AccordionListener() { // from class: Historia.aiepi.JPAiepi.1
            /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0021. Please report as an issue. */
            public void accordionChanged(AccordionEvent accordionEvent) {
                accordionEvent.getTabText();
                accordionEvent.getTabIndex();
                accordionEvent.getContents();
                accordionEvent.getSource();
                switch (AnonymousClass2.$SwitchMap$com$javaswingcomponents$accordion$listener$AccordionEventType[accordionEvent.getEventType().ordinal()]) {
                }
            }
        });
    }

    /* JADX INFO: renamed from: Historia.aiepi.JPAiepi$2, reason: invalid class name */
    /* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi$2.class */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$javaswingcomponents$accordion$listener$AccordionEventType = new int[AccordionEventType.values().length];

        static {
            try {
                $SwitchMap$com$javaswingcomponents$accordion$listener$AccordionEventType[AccordionEventType.TAB_ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$javaswingcomponents$accordion$listener$AccordionEventType[AccordionEventType.TAB_REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$javaswingcomponents$accordion$listener$AccordionEventType[AccordionEventType.TAB_SELECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private void howToChangeTabOrientation(JSCAccordion accordion) {
        accordion.setTabOrientation(TabOrientation.VERTICAL);
    }

    private void howToChangeTheLookAndFeel(JSCAccordion accordion) {
        AccordionUI newUI = SteelAccordionUI.createUI(accordion);
        accordion.setUI(newUI);
    }

    private void howToCustomizeALookAndFeel(JSCAccordion accordion) {
        SteelAccordionUI ui = accordion.getUI();
        ui.setHorizontalBackgroundPadding(15);
        BasicVerticalTabRenderer tabRenderer = new BasicVerticalTabRenderer(accordion);
        tabRenderer.setFontColor(Color.RED);
        accordion.setHorizontalAccordionTabRenderer(tabRenderer);
        accordion.getBackgroundPainter();
        accordion.getBackgroundPainter();
        accordion.setDrawShadow(true);
        accordion.setAutoAdvance(false);
        accordion.setTabHeight(20);
    }

    public void mGuardar() {
        if (!mValidaExamen()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = " INSERT INTO  `p_aiepi_encabezado` ( `FechaR`, `IdAtencion`, `IdUsuario`, `IdProfesional`, `IdEspecialista`, `UsuarioS`)  VALUES ( '" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xidEvaluacion = this.xct.ejecutarSQLId(sql);
                this.xPanel.mGuardar(this.xidEvaluacion);
                this.xPanel2.mGuardar(this.xidEvaluacion);
                this.xPanel3.mGuardar(this.xidEvaluacion);
                this.xPanel4.mGuardar(this.xidEvaluacion);
                this.xPanel5.mGuardar(this.xidEvaluacion);
                this.xPanel6.mGuardar(this.xidEvaluacion);
                this.xPanel7.mGuardar(this.xidEvaluacion);
                this.xPanel9.mGuardar(this.xidEvaluacion);
                this.xPanel10.mGuardar(this.xidEvaluacion);
                this.xPanel11.mGuardar(this.xidEvaluacion);
                this.xPanel8.mBuscarResultados();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe una evaluación en esta atención", "ERROR", 0);
    }

    private boolean mValidaExamen() {
        boolean xExiste = false;
        String sql = "SELECT `FechaR`,`IdAtencion`,`IdUsuario` FROM `p_aiepi_encabezado` WHERE (IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private void initComponents() {
        this.JSPCuestionario = new JScrollPane();
        this.JPEncuesta = new JPanel();
        setName("xAIEPI");
        GroupLayout JPEncuestaLayout = new GroupLayout(this.JPEncuesta);
        this.JPEncuesta.setLayout(JPEncuestaLayout);
        JPEncuestaLayout.setHorizontalGroup(JPEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 620, 32767));
        JPEncuestaLayout.setVerticalGroup(JPEncuestaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 593, 32767));
        this.JSPCuestionario.setViewportView(this.JPEncuesta);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPCuestionario).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPCuestionario, -2, 566, -2).addContainerGap(40, 32767)));
    }
}
