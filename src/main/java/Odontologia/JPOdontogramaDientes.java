package Odontologia;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaDientes.class */
public class JPOdontogramaDientes extends JPanel {
    private JPOdontograma jpodontograma;
    private JPOdontogramaInicial jpodontogramaInicial;
    private JPControlPlaca jpcontrolPlaca;
    private JPOdontogramaClinico jpodontogramaClinico;
    private String nombre = "";
    public JLabel Amarillo;
    public JLabel JLAbajo1_11;
    public JLabel JLAbajo1_12;
    public JLabel JLAbajo1_13;
    public JLabel JLAbajo1_14;
    public JLabel JLAbajo1_15;
    public JLabel JLAbajo1_16;
    public JLabel JLAbajo1_17;
    public JLabel JLAbajo1_18;
    public JLabel JLAbajo1_21;
    public JLabel JLAbajo1_22;
    public JLabel JLAbajo1_23;
    public JLabel JLAbajo1_24;
    public JLabel JLAbajo1_25;
    public JLabel JLAbajo1_26;
    public JLabel JLAbajo1_27;
    public JLabel JLAbajo1_28;
    public JLabel JLAbajo1_31;
    public JLabel JLAbajo1_32;
    public JLabel JLAbajo1_33;
    public JLabel JLAbajo1_34;
    public JLabel JLAbajo1_35;
    public JLabel JLAbajo1_36;
    public JLabel JLAbajo1_37;
    public JLabel JLAbajo1_38;
    public JLabel JLAbajo1_41;
    public JLabel JLAbajo1_42;
    public JLabel JLAbajo1_43;
    public JLabel JLAbajo1_44;
    public JLabel JLAbajo1_45;
    public JLabel JLAbajo1_46;
    public JLabel JLAbajo1_47;
    public JLabel JLAbajo1_48;
    public JLabel JLAbajo1_51;
    public JLabel JLAbajo1_52;
    public JLabel JLAbajo1_53;
    public JLabel JLAbajo1_54;
    public JLabel JLAbajo1_55;
    public JLabel JLAbajo1_61;
    public JLabel JLAbajo1_62;
    public JLabel JLAbajo1_63;
    public JLabel JLAbajo1_64;
    public JLabel JLAbajo1_65;
    public JLabel JLAbajo1_71;
    public JLabel JLAbajo1_72;
    public JLabel JLAbajo1_73;
    public JLabel JLAbajo1_74;
    public JLabel JLAbajo1_75;
    public JLabel JLAbajo1_81;
    public JLabel JLAbajo1_82;
    public JLabel JLAbajo1_83;
    public JLabel JLAbajo1_84;
    public JLabel JLAbajo1_85;
    public JLabel JLAbajo2_11;
    public JLabel JLAbajo2_12;
    public JLabel JLAbajo2_13;
    public JLabel JLAbajo2_14;
    public JLabel JLAbajo2_15;
    public JLabel JLAbajo2_16;
    public JLabel JLAbajo2_17;
    public JLabel JLAbajo2_18;
    public JLabel JLAbajo2_21;
    public JLabel JLAbajo2_22;
    public JLabel JLAbajo2_23;
    public JLabel JLAbajo2_24;
    public JLabel JLAbajo2_25;
    public JLabel JLAbajo2_26;
    public JLabel JLAbajo2_27;
    public JLabel JLAbajo2_28;
    public JLabel JLAbajo2_31;
    public JLabel JLAbajo2_32;
    public JLabel JLAbajo2_33;
    public JLabel JLAbajo2_34;
    public JLabel JLAbajo2_35;
    public JLabel JLAbajo2_36;
    public JLabel JLAbajo2_37;
    public JLabel JLAbajo2_38;
    public JLabel JLAbajo2_41;
    public JLabel JLAbajo2_42;
    public JLabel JLAbajo2_43;
    public JLabel JLAbajo2_44;
    public JLabel JLAbajo2_45;
    public JLabel JLAbajo2_46;
    public JLabel JLAbajo2_47;
    public JLabel JLAbajo2_48;
    public JLabel JLAbajo2_51;
    public JLabel JLAbajo2_52;
    public JLabel JLAbajo2_53;
    public JLabel JLAbajo2_54;
    public JLabel JLAbajo2_55;
    public JLabel JLAbajo2_61;
    public JLabel JLAbajo2_62;
    public JLabel JLAbajo2_63;
    public JLabel JLAbajo2_64;
    public JLabel JLAbajo2_65;
    public JLabel JLAbajo2_71;
    public JLabel JLAbajo2_72;
    public JLabel JLAbajo2_73;
    public JLabel JLAbajo2_74;
    public JLabel JLAbajo2_75;
    public JLabel JLAbajo2_81;
    public JLabel JLAbajo2_82;
    public JLabel JLAbajo2_83;
    public JLabel JLAbajo2_84;
    public JLabel JLAbajo2_85;
    public JLabel JLArriba1_11;
    public JLabel JLArriba1_12;
    public JLabel JLArriba1_13;
    public JLabel JLArriba1_14;
    public JLabel JLArriba1_15;
    public JLabel JLArriba1_16;
    public JLabel JLArriba1_17;
    public JLabel JLArriba1_18;
    public JLabel JLArriba1_21;
    public JLabel JLArriba1_22;
    public JLabel JLArriba1_23;
    public JLabel JLArriba1_24;
    public JLabel JLArriba1_25;
    public JLabel JLArriba1_26;
    public JLabel JLArriba1_27;
    public JLabel JLArriba1_28;
    public JLabel JLArriba1_31;
    public JLabel JLArriba1_32;
    public JLabel JLArriba1_33;
    public JLabel JLArriba1_34;
    public JLabel JLArriba1_35;
    public JLabel JLArriba1_36;
    public JLabel JLArriba1_37;
    public JLabel JLArriba1_38;
    public JLabel JLArriba1_41;
    public JLabel JLArriba1_42;
    public JLabel JLArriba1_43;
    public JLabel JLArriba1_44;
    public JLabel JLArriba1_45;
    public JLabel JLArriba1_46;
    public JLabel JLArriba1_47;
    public JLabel JLArriba1_48;
    public JLabel JLArriba1_51;
    public JLabel JLArriba1_52;
    public JLabel JLArriba1_53;
    public JLabel JLArriba1_54;
    public JLabel JLArriba1_55;
    public JLabel JLArriba1_61;
    public JLabel JLArriba1_62;
    public JLabel JLArriba1_63;
    public JLabel JLArriba1_64;
    public JLabel JLArriba1_65;
    public JLabel JLArriba1_71;
    public JLabel JLArriba1_72;
    public JLabel JLArriba1_73;
    public JLabel JLArriba1_74;
    public JLabel JLArriba1_75;
    public JLabel JLArriba1_81;
    public JLabel JLArriba1_82;
    public JLabel JLArriba1_83;
    public JLabel JLArriba1_84;
    public JLabel JLArriba1_85;
    public JLabel JLArriba2_11;
    public JLabel JLArriba2_12;
    public JLabel JLArriba2_13;
    public JLabel JLArriba2_14;
    public JLabel JLArriba2_15;
    public JLabel JLArriba2_16;
    public JLabel JLArriba2_17;
    public JLabel JLArriba2_18;
    public JLabel JLArriba2_21;
    public JLabel JLArriba2_22;
    public JLabel JLArriba2_23;
    public JLabel JLArriba2_24;
    public JLabel JLArriba2_25;
    public JLabel JLArriba2_26;
    public JLabel JLArriba2_27;
    public JLabel JLArriba2_28;
    public JLabel JLArriba2_31;
    public JLabel JLArriba2_32;
    public JLabel JLArriba2_33;
    public JLabel JLArriba2_34;
    public JLabel JLArriba2_35;
    public JLabel JLArriba2_36;
    public JLabel JLArriba2_37;
    public JLabel JLArriba2_38;
    public JLabel JLArriba2_41;
    public JLabel JLArriba2_42;
    public JLabel JLArriba2_43;
    public JLabel JLArriba2_44;
    public JLabel JLArriba2_45;
    public JLabel JLArriba2_46;
    public JLabel JLArriba2_47;
    public JLabel JLArriba2_48;
    public JLabel JLArriba2_51;
    public JLabel JLArriba2_52;
    public JLabel JLArriba2_53;
    public JLabel JLArriba2_54;
    public JLabel JLArriba2_55;
    public JLabel JLArriba2_61;
    public JLabel JLArriba2_62;
    public JLabel JLArriba2_63;
    public JLabel JLArriba2_64;
    public JLabel JLArriba2_65;
    public JLabel JLArriba2_71;
    public JLabel JLArriba2_72;
    public JLabel JLArriba2_73;
    public JLabel JLArriba2_74;
    public JLabel JLArriba2_75;
    public JLabel JLArriba2_81;
    public JLabel JLArriba2_82;
    public JLabel JLArriba2_83;
    public JLabel JLArriba2_84;
    public JLabel JLArriba2_85;
    public JLabel JLCentro11;
    public JLabel JLCentro12;
    public JLabel JLCentro13;
    public JLabel JLCentro14;
    public JLabel JLCentro15;
    public JLabel JLCentro16;
    public JLabel JLCentro17;
    public JLabel JLCentro18;
    public JLabel JLCentro21;
    public JLabel JLCentro22;
    public JLabel JLCentro23;
    public JLabel JLCentro24;
    public JLabel JLCentro25;
    public JLabel JLCentro26;
    public JLabel JLCentro27;
    public JLabel JLCentro28;
    public JLabel JLCentro31;
    public JLabel JLCentro32;
    public JLabel JLCentro33;
    public JLabel JLCentro34;
    public JLabel JLCentro35;
    public JLabel JLCentro36;
    public JLabel JLCentro37;
    public JLabel JLCentro38;
    public JLabel JLCentro41;
    public JLabel JLCentro42;
    public JLabel JLCentro43;
    public JLabel JLCentro44;
    public JLabel JLCentro45;
    public JLabel JLCentro46;
    public JLabel JLCentro47;
    public JLabel JLCentro48;
    public JLabel JLCentro51;
    public JLabel JLCentro52;
    public JLabel JLCentro53;
    public JLabel JLCentro54;
    public JLabel JLCentro55;
    public JLabel JLCentro61;
    public JLabel JLCentro62;
    public JLabel JLCentro63;
    public JLabel JLCentro64;
    public JLabel JLCentro65;
    public JLabel JLCentro71;
    public JLabel JLCentro72;
    public JLabel JLCentro73;
    public JLabel JLCentro74;
    public JLabel JLCentro75;
    public JLabel JLCentro81;
    public JLabel JLCentro82;
    public JLabel JLCentro83;
    public JLabel JLCentro84;
    public JLabel JLCentro85;
    public JLabel JLCompleto11;
    public JLabel JLCompleto12;
    public JLabel JLCompleto13;
    public JLabel JLCompleto14;
    public JLabel JLCompleto15;
    public JLabel JLCompleto16;
    public JLabel JLCompleto17;
    public JLabel JLCompleto18;
    public JLabel JLCompleto21;
    public JLabel JLCompleto22;
    public JLabel JLCompleto23;
    public JLabel JLCompleto24;
    public JLabel JLCompleto25;
    public JLabel JLCompleto26;
    public JLabel JLCompleto27;
    public JLabel JLCompleto28;
    public JLabel JLCompleto31;
    public JLabel JLCompleto32;
    public JLabel JLCompleto33;
    public JLabel JLCompleto34;
    public JLabel JLCompleto35;
    public JLabel JLCompleto36;
    public JLabel JLCompleto37;
    public JLabel JLCompleto38;
    public JLabel JLCompleto41;
    public JLabel JLCompleto42;
    public JLabel JLCompleto43;
    public JLabel JLCompleto44;
    public JLabel JLCompleto45;
    public JLabel JLCompleto46;
    public JLabel JLCompleto47;
    public JLabel JLCompleto48;
    public JLabel JLCompleto51;
    public JLabel JLCompleto52;
    public JLabel JLCompleto53;
    public JLabel JLCompleto54;
    public JLabel JLCompleto55;
    public JLabel JLCompleto61;
    public JLabel JLCompleto62;
    public JLabel JLCompleto63;
    public JLabel JLCompleto64;
    public JLabel JLCompleto65;
    public JLabel JLCompleto71;
    public JLabel JLCompleto72;
    public JLabel JLCompleto73;
    public JLabel JLCompleto74;
    public JLabel JLCompleto75;
    public JLabel JLCompleto81;
    public JLabel JLCompleto82;
    public JLabel JLCompleto83;
    public JLabel JLCompleto84;
    public JLabel JLCompleto85;
    public JLabel JLDerecha11;
    public JLabel JLDerecha12;
    public JLabel JLDerecha13;
    public JLabel JLDerecha14;
    public JLabel JLDerecha15;
    public JLabel JLDerecha16;
    public JLabel JLDerecha17;
    public JLabel JLDerecha18;
    public JLabel JLDerecha21;
    public JLabel JLDerecha22;
    public JLabel JLDerecha23;
    public JLabel JLDerecha24;
    public JLabel JLDerecha25;
    public JLabel JLDerecha26;
    public JLabel JLDerecha27;
    public JLabel JLDerecha28;
    public JLabel JLDerecha31;
    public JLabel JLDerecha32;
    public JLabel JLDerecha33;
    public JLabel JLDerecha34;
    public JLabel JLDerecha35;
    public JLabel JLDerecha36;
    public JLabel JLDerecha37;
    public JLabel JLDerecha38;
    public JLabel JLDerecha41;
    public JLabel JLDerecha42;
    public JLabel JLDerecha43;
    public JLabel JLDerecha44;
    public JLabel JLDerecha45;
    public JLabel JLDerecha46;
    public JLabel JLDerecha47;
    public JLabel JLDerecha48;
    public JLabel JLDerecha51;
    public JLabel JLDerecha52;
    public JLabel JLDerecha53;
    public JLabel JLDerecha54;
    public JLabel JLDerecha55;
    public JLabel JLDerecha61;
    public JLabel JLDerecha62;
    public JLabel JLDerecha63;
    public JLabel JLDerecha64;
    public JLabel JLDerecha65;
    public JLabel JLDerecha71;
    public JLabel JLDerecha72;
    public JLabel JLDerecha73;
    public JLabel JLDerecha74;
    public JLabel JLDerecha75;
    public JLabel JLDerecha81;
    public JLabel JLDerecha82;
    public JLabel JLDerecha83;
    public JLabel JLDerecha84;
    public JLabel JLDerecha85;
    public JLabel JLDienteBlanco11;
    public JLabel JLDienteBlanco12;
    public JLabel JLDienteBlanco13;
    public JLabel JLDienteBlanco14;
    public JLabel JLDienteBlanco15;
    public JLabel JLDienteBlanco16;
    public JLabel JLDienteBlanco17;
    public JLabel JLDienteBlanco18;
    public JLabel JLDienteBlanco21;
    public JLabel JLDienteBlanco22;
    public JLabel JLDienteBlanco23;
    public JLabel JLDienteBlanco24;
    public JLabel JLDienteBlanco25;
    public JLabel JLDienteBlanco26;
    public JLabel JLDienteBlanco27;
    public JLabel JLDienteBlanco28;
    public JLabel JLDienteBlanco31;
    public JLabel JLDienteBlanco32;
    public JLabel JLDienteBlanco33;
    public JLabel JLDienteBlanco34;
    public JLabel JLDienteBlanco35;
    public JLabel JLDienteBlanco36;
    public JLabel JLDienteBlanco37;
    public JLabel JLDienteBlanco38;
    public JLabel JLDienteBlanco41;
    public JLabel JLDienteBlanco42;
    public JLabel JLDienteBlanco43;
    public JLabel JLDienteBlanco44;
    public JLabel JLDienteBlanco45;
    public JLabel JLDienteBlanco46;
    public JLabel JLDienteBlanco47;
    public JLabel JLDienteBlanco48;
    public JLabel JLDienteBlanco51;
    public JLabel JLDienteBlanco52;
    public JLabel JLDienteBlanco53;
    public JLabel JLDienteBlanco54;
    public JLabel JLDienteBlanco55;
    public JLabel JLDienteBlanco61;
    public JLabel JLDienteBlanco62;
    public JLabel JLDienteBlanco63;
    public JLabel JLDienteBlanco64;
    public JLabel JLDienteBlanco65;
    public JLabel JLDienteBlanco70;
    public JLabel JLDienteBlanco72;
    public JLabel JLDienteBlanco73;
    public JLabel JLDienteBlanco74;
    public JLabel JLDienteBlanco75;
    public JLabel JLDienteBlanco81;
    public JLabel JLDienteBlanco82;
    public JLabel JLDienteBlanco83;
    public JLabel JLDienteBlanco84;
    public JLabel JLDienteBlanco85;
    public JLabel JLIzquierda11;
    public JLabel JLIzquierda12;
    public JLabel JLIzquierda13;
    public JLabel JLIzquierda14;
    public JLabel JLIzquierda15;
    public JLabel JLIzquierda16;
    public JLabel JLIzquierda17;
    public JLabel JLIzquierda18;
    public JLabel JLIzquierda21;
    public JLabel JLIzquierda22;
    public JLabel JLIzquierda23;
    public JLabel JLIzquierda24;
    public JLabel JLIzquierda25;
    public JLabel JLIzquierda26;
    public JLabel JLIzquierda27;
    public JLabel JLIzquierda28;
    public JLabel JLIzquierda31;
    public JLabel JLIzquierda32;
    public JLabel JLIzquierda33;
    public JLabel JLIzquierda34;
    public JLabel JLIzquierda35;
    public JLabel JLIzquierda36;
    public JLabel JLIzquierda37;
    public JLabel JLIzquierda38;
    public JLabel JLIzquierda41;
    public JLabel JLIzquierda42;
    public JLabel JLIzquierda43;
    public JLabel JLIzquierda44;
    public JLabel JLIzquierda45;
    public JLabel JLIzquierda46;
    public JLabel JLIzquierda47;
    public JLabel JLIzquierda48;
    public JLabel JLIzquierda51;
    public JLabel JLIzquierda52;
    public JLabel JLIzquierda53;
    public JLabel JLIzquierda54;
    public JLabel JLIzquierda55;
    public JLabel JLIzquierda61;
    public JLabel JLIzquierda62;
    public JLabel JLIzquierda63;
    public JLabel JLIzquierda64;
    public JLabel JLIzquierda65;
    public JLabel JLIzquierda71;
    public JLabel JLIzquierda72;
    public JLabel JLIzquierda73;
    public JLabel JLIzquierda74;
    public JLabel JLIzquierda75;
    public JLabel JLIzquierda81;
    public JLabel JLIzquierda82;
    public JLabel JLIzquierda83;
    public JLabel JLIzquierda84;
    public JLabel JLIzquierda85;
    public JPanel JP11;
    public JPanel JP12;
    public JPanel JP13;
    public JPanel JP14;
    public JPanel JP15;
    public JPanel JP16;
    public JPanel JP17;
    public JPanel JP18;
    public JPanel JP21;
    public JPanel JP22;
    public JPanel JP23;
    public JPanel JP24;
    public JPanel JP25;
    public JPanel JP26;
    public JPanel JP27;
    public JPanel JP28;
    public JPanel JP31;
    public JPanel JP32;
    public JPanel JP33;
    public JPanel JP34;
    public JPanel JP35;
    public JPanel JP36;
    public JPanel JP37;
    public JPanel JP38;
    public JPanel JP41;
    public JPanel JP42;
    public JPanel JP43;
    public JPanel JP44;
    public JPanel JP45;
    public JPanel JP46;
    public JPanel JP47;
    public JPanel JP48;
    public JPanel JP51;
    public JPanel JP52;
    public JPanel JP53;
    public JPanel JP54;
    public JPanel JP55;
    public JPanel JP61;
    public JPanel JP62;
    public JPanel JP63;
    public JPanel JP64;
    public JPanel JP65;
    public JPanel JP71;
    public JPanel JP72;
    public JPanel JP73;
    public JPanel JP74;
    public JPanel JP75;
    public JPanel JP81;
    public JPanel JP82;
    public JPanel JP83;
    public JPanel JP84;
    public JPanel JP85;
    public JLabel L11;
    public JLabel L12;
    public JLabel L13;
    public JLabel L14;
    public JLabel L15;
    public JLabel L16;
    public JLabel L17;
    public JLabel L18;
    public JLabel L21;
    public JLabel L22;
    public JLabel L23;
    public JLabel L24;
    public JLabel L25;
    public JLabel L26;
    public JLabel L27;
    public JLabel L28;
    public JLabel L31;
    public JLabel L32;
    public JLabel L33;
    public JLabel L34;
    public JLabel L35;
    public JLabel L36;
    public JLabel L37;
    public JLabel L38;
    public JLabel L41;
    public JLabel L42;
    public JLabel L43;
    public JLabel L44;
    public JLabel L45;
    public JLabel L46;
    public JLabel L47;
    public JLabel L48;
    public JLabel L51;
    public JLabel L52;
    public JLabel L53;
    public JLabel L54;
    public JLabel L55;
    public JLabel L61;
    public JLabel L62;
    public JLabel L63;
    public JLabel L64;
    public JLabel L65;
    public JLabel L71;
    public JLabel L72;
    public JLabel L73;
    public JLabel L74;
    public JLabel L75;
    public JLabel L81;
    public JLabel L82;
    public JLabel L83;
    public JLabel L84;
    public JLabel L85;
    public JLabel Rojo;
    public JLabel Verde;

    public JPOdontogramaDientes(JPanel jpanelanel) {
        initComponents();
        realizarCasting(jpanelanel);
    }

    public JPOdontogramaDientes() {
        initComponents();
    }

    private void realizarCasting(JPanel jpanel) {
        if (jpanel.getName().equals("jifOdontogramaG")) {
            this.jpodontograma = (JPOdontograma) jpanel;
            this.nombre = jpanel.getName();
        } else if (jpanel.getName().equals("jifOdontogramaI")) {
            this.jpodontogramaInicial = (JPOdontogramaInicial) jpanel;
            this.nombre = jpanel.getName();
        } else if (jpanel.getName().equals("jifControlPlaca")) {
            this.jpcontrolPlaca = (JPControlPlaca) jpanel;
            this.nombre = jpanel.getName();
        }
        if (jpanel.getName().equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico = (JPOdontogramaClinico) jpanel;
            this.nombre = jpanel.getName();
        }
    }

    private void initComponents() {
        this.JP18 = new JPanel();
        this.JLArriba1_18 = new JLabel();
        this.JLArriba2_18 = new JLabel();
        this.JLCentro18 = new JLabel();
        this.JLDerecha18 = new JLabel();
        this.JLIzquierda18 = new JLabel();
        this.JLAbajo1_18 = new JLabel();
        this.JLAbajo2_18 = new JLabel();
        this.JLCompleto18 = new JLabel();
        this.JLDienteBlanco18 = new JLabel();
        this.JP17 = new JPanel();
        this.JLArriba1_17 = new JLabel();
        this.JLArriba2_17 = new JLabel();
        this.JLCentro17 = new JLabel();
        this.JLDerecha17 = new JLabel();
        this.JLIzquierda17 = new JLabel();
        this.JLAbajo1_17 = new JLabel();
        this.JLAbajo2_17 = new JLabel();
        this.JLCompleto17 = new JLabel();
        this.JLDienteBlanco17 = new JLabel();
        this.JP16 = new JPanel();
        this.JLArriba1_16 = new JLabel();
        this.JLArriba2_16 = new JLabel();
        this.JLCentro16 = new JLabel();
        this.JLDerecha16 = new JLabel();
        this.JLIzquierda16 = new JLabel();
        this.JLAbajo1_16 = new JLabel();
        this.JLAbajo2_16 = new JLabel();
        this.JLCompleto16 = new JLabel();
        this.JLDienteBlanco16 = new JLabel();
        this.JP15 = new JPanel();
        this.JLArriba1_15 = new JLabel();
        this.JLArriba2_15 = new JLabel();
        this.JLCentro15 = new JLabel();
        this.JLDerecha15 = new JLabel();
        this.JLIzquierda15 = new JLabel();
        this.JLAbajo1_15 = new JLabel();
        this.JLAbajo2_15 = new JLabel();
        this.JLCompleto15 = new JLabel();
        this.JLDienteBlanco15 = new JLabel();
        this.JP14 = new JPanel();
        this.JLArriba1_14 = new JLabel();
        this.JLArriba2_14 = new JLabel();
        this.JLCentro14 = new JLabel();
        this.JLDerecha14 = new JLabel();
        this.JLIzquierda14 = new JLabel();
        this.JLAbajo1_14 = new JLabel();
        this.JLAbajo2_14 = new JLabel();
        this.JLCompleto14 = new JLabel();
        this.JLDienteBlanco14 = new JLabel();
        this.JP13 = new JPanel();
        this.JLArriba1_13 = new JLabel();
        this.JLArriba2_13 = new JLabel();
        this.JLCentro13 = new JLabel();
        this.JLDerecha13 = new JLabel();
        this.JLIzquierda13 = new JLabel();
        this.JLAbajo1_13 = new JLabel();
        this.JLAbajo2_13 = new JLabel();
        this.JLCompleto13 = new JLabel();
        this.JLDienteBlanco13 = new JLabel();
        this.JP12 = new JPanel();
        this.JLArriba1_12 = new JLabel();
        this.JLArriba2_12 = new JLabel();
        this.JLCentro12 = new JLabel();
        this.JLDerecha12 = new JLabel();
        this.JLIzquierda12 = new JLabel();
        this.JLAbajo1_12 = new JLabel();
        this.JLAbajo2_12 = new JLabel();
        this.JLCompleto12 = new JLabel();
        this.JLDienteBlanco12 = new JLabel();
        this.JP11 = new JPanel();
        this.JLArriba1_11 = new JLabel();
        this.JLArriba2_11 = new JLabel();
        this.JLCentro11 = new JLabel();
        this.JLDerecha11 = new JLabel();
        this.JLIzquierda11 = new JLabel();
        this.JLAbajo1_11 = new JLabel();
        this.JLAbajo2_11 = new JLabel();
        this.JLCompleto11 = new JLabel();
        this.JLDienteBlanco11 = new JLabel();
        this.JP21 = new JPanel();
        this.JLArriba1_21 = new JLabel();
        this.JLArriba2_21 = new JLabel();
        this.JLCentro21 = new JLabel();
        this.JLDerecha21 = new JLabel();
        this.JLIzquierda21 = new JLabel();
        this.JLAbajo1_21 = new JLabel();
        this.JLAbajo2_21 = new JLabel();
        this.JLCompleto21 = new JLabel();
        this.JLDienteBlanco21 = new JLabel();
        this.JP22 = new JPanel();
        this.JLArriba1_22 = new JLabel();
        this.JLArriba2_22 = new JLabel();
        this.JLCentro22 = new JLabel();
        this.JLDerecha22 = new JLabel();
        this.JLIzquierda22 = new JLabel();
        this.JLAbajo1_22 = new JLabel();
        this.JLAbajo2_22 = new JLabel();
        this.JLCompleto22 = new JLabel();
        this.JLDienteBlanco22 = new JLabel();
        this.JP23 = new JPanel();
        this.JLArriba1_23 = new JLabel();
        this.JLArriba2_23 = new JLabel();
        this.JLCentro23 = new JLabel();
        this.JLDerecha23 = new JLabel();
        this.JLIzquierda23 = new JLabel();
        this.JLAbajo1_23 = new JLabel();
        this.JLAbajo2_23 = new JLabel();
        this.JLCompleto23 = new JLabel();
        this.JLDienteBlanco23 = new JLabel();
        this.JP24 = new JPanel();
        this.JLArriba1_24 = new JLabel();
        this.JLArriba2_24 = new JLabel();
        this.JLCentro24 = new JLabel();
        this.JLDerecha24 = new JLabel();
        this.JLIzquierda24 = new JLabel();
        this.JLAbajo1_24 = new JLabel();
        this.JLAbajo2_24 = new JLabel();
        this.JLCompleto24 = new JLabel();
        this.JLDienteBlanco24 = new JLabel();
        this.JP25 = new JPanel();
        this.JLArriba1_25 = new JLabel();
        this.JLArriba2_25 = new JLabel();
        this.JLCentro25 = new JLabel();
        this.JLDerecha25 = new JLabel();
        this.JLIzquierda25 = new JLabel();
        this.JLAbajo1_25 = new JLabel();
        this.JLAbajo2_25 = new JLabel();
        this.JLCompleto25 = new JLabel();
        this.JLDienteBlanco25 = new JLabel();
        this.JP26 = new JPanel();
        this.JLArriba1_26 = new JLabel();
        this.JLArriba2_26 = new JLabel();
        this.JLCentro26 = new JLabel();
        this.JLDerecha26 = new JLabel();
        this.JLIzquierda26 = new JLabel();
        this.JLAbajo1_26 = new JLabel();
        this.JLAbajo2_26 = new JLabel();
        this.JLCompleto26 = new JLabel();
        this.JLDienteBlanco26 = new JLabel();
        this.JP27 = new JPanel();
        this.JLArriba1_27 = new JLabel();
        this.JLArriba2_27 = new JLabel();
        this.JLCentro27 = new JLabel();
        this.JLDerecha27 = new JLabel();
        this.JLIzquierda27 = new JLabel();
        this.JLAbajo1_27 = new JLabel();
        this.JLAbajo2_27 = new JLabel();
        this.JLCompleto27 = new JLabel();
        this.JLDienteBlanco27 = new JLabel();
        this.JP28 = new JPanel();
        this.JLArriba1_28 = new JLabel();
        this.JLArriba2_28 = new JLabel();
        this.JLCentro28 = new JLabel();
        this.JLDerecha28 = new JLabel();
        this.JLIzquierda28 = new JLabel();
        this.JLAbajo1_28 = new JLabel();
        this.JLAbajo2_28 = new JLabel();
        this.JLCompleto28 = new JLabel();
        this.JLDienteBlanco28 = new JLabel();
        this.JP51 = new JPanel();
        this.JLArriba1_51 = new JLabel();
        this.JLArriba2_51 = new JLabel();
        this.JLCentro51 = new JLabel();
        this.JLDerecha51 = new JLabel();
        this.JLIzquierda51 = new JLabel();
        this.JLAbajo1_51 = new JLabel();
        this.JLAbajo2_51 = new JLabel();
        this.JLCompleto51 = new JLabel();
        this.JLDienteBlanco51 = new JLabel();
        this.JP52 = new JPanel();
        this.JLArriba1_52 = new JLabel();
        this.JLArriba2_52 = new JLabel();
        this.JLCentro52 = new JLabel();
        this.JLDerecha52 = new JLabel();
        this.JLIzquierda52 = new JLabel();
        this.JLAbajo1_52 = new JLabel();
        this.JLAbajo2_52 = new JLabel();
        this.JLCompleto52 = new JLabel();
        this.JLDienteBlanco52 = new JLabel();
        this.JP53 = new JPanel();
        this.JLArriba1_53 = new JLabel();
        this.JLArriba2_53 = new JLabel();
        this.JLCentro53 = new JLabel();
        this.JLDerecha53 = new JLabel();
        this.JLIzquierda53 = new JLabel();
        this.JLAbajo1_53 = new JLabel();
        this.JLAbajo2_53 = new JLabel();
        this.JLCompleto53 = new JLabel();
        this.JLDienteBlanco53 = new JLabel();
        this.JP54 = new JPanel();
        this.JLArriba1_54 = new JLabel();
        this.JLArriba2_54 = new JLabel();
        this.JLCentro54 = new JLabel();
        this.JLDerecha54 = new JLabel();
        this.JLIzquierda54 = new JLabel();
        this.JLAbajo1_54 = new JLabel();
        this.JLAbajo2_54 = new JLabel();
        this.JLCompleto54 = new JLabel();
        this.JLDienteBlanco54 = new JLabel();
        this.JP55 = new JPanel();
        this.JLArriba1_55 = new JLabel();
        this.JLArriba2_55 = new JLabel();
        this.JLCentro55 = new JLabel();
        this.JLDerecha55 = new JLabel();
        this.JLIzquierda55 = new JLabel();
        this.JLAbajo1_55 = new JLabel();
        this.JLAbajo2_55 = new JLabel();
        this.JLCompleto55 = new JLabel();
        this.JLDienteBlanco55 = new JLabel();
        this.JP61 = new JPanel();
        this.JLArriba1_61 = new JLabel();
        this.JLArriba2_61 = new JLabel();
        this.JLCentro61 = new JLabel();
        this.JLDerecha61 = new JLabel();
        this.JLIzquierda61 = new JLabel();
        this.JLAbajo1_61 = new JLabel();
        this.JLAbajo2_61 = new JLabel();
        this.JLCompleto61 = new JLabel();
        this.JLDienteBlanco61 = new JLabel();
        this.JP62 = new JPanel();
        this.JLArriba1_62 = new JLabel();
        this.JLArriba2_62 = new JLabel();
        this.JLCentro62 = new JLabel();
        this.JLDerecha62 = new JLabel();
        this.JLIzquierda62 = new JLabel();
        this.JLAbajo1_62 = new JLabel();
        this.JLAbajo2_62 = new JLabel();
        this.JLCompleto62 = new JLabel();
        this.JLDienteBlanco62 = new JLabel();
        this.JP63 = new JPanel();
        this.JLArriba1_63 = new JLabel();
        this.JLArriba2_63 = new JLabel();
        this.JLCentro63 = new JLabel();
        this.JLDerecha63 = new JLabel();
        this.JLIzquierda63 = new JLabel();
        this.JLAbajo1_63 = new JLabel();
        this.JLAbajo2_63 = new JLabel();
        this.JLCompleto63 = new JLabel();
        this.JLDienteBlanco63 = new JLabel();
        this.JP64 = new JPanel();
        this.JLArriba1_64 = new JLabel();
        this.JLArriba2_64 = new JLabel();
        this.JLCentro64 = new JLabel();
        this.JLDerecha64 = new JLabel();
        this.JLIzquierda64 = new JLabel();
        this.JLAbajo1_64 = new JLabel();
        this.JLAbajo2_64 = new JLabel();
        this.JLCompleto64 = new JLabel();
        this.JLDienteBlanco64 = new JLabel();
        this.JP65 = new JPanel();
        this.JLArriba1_65 = new JLabel();
        this.JLArriba2_65 = new JLabel();
        this.JLCentro65 = new JLabel();
        this.JLDerecha65 = new JLabel();
        this.JLIzquierda65 = new JLabel();
        this.JLAbajo1_65 = new JLabel();
        this.JLAbajo2_65 = new JLabel();
        this.JLCompleto65 = new JLabel();
        this.JLDienteBlanco65 = new JLabel();
        this.JP75 = new JPanel();
        this.JLArriba1_75 = new JLabel();
        this.JLArriba2_75 = new JLabel();
        this.JLCentro75 = new JLabel();
        this.JLDerecha75 = new JLabel();
        this.JLIzquierda75 = new JLabel();
        this.JLAbajo1_75 = new JLabel();
        this.JLAbajo2_75 = new JLabel();
        this.JLCompleto75 = new JLabel();
        this.JLDienteBlanco75 = new JLabel();
        this.JP74 = new JPanel();
        this.JLArriba1_74 = new JLabel();
        this.JLArriba2_74 = new JLabel();
        this.JLCentro74 = new JLabel();
        this.JLDerecha74 = new JLabel();
        this.JLIzquierda74 = new JLabel();
        this.JLAbajo1_74 = new JLabel();
        this.JLAbajo2_74 = new JLabel();
        this.JLCompleto74 = new JLabel();
        this.JLDienteBlanco74 = new JLabel();
        this.JP73 = new JPanel();
        this.JLArriba1_73 = new JLabel();
        this.JLArriba2_73 = new JLabel();
        this.JLCentro73 = new JLabel();
        this.JLDerecha73 = new JLabel();
        this.JLIzquierda73 = new JLabel();
        this.JLAbajo1_73 = new JLabel();
        this.JLAbajo2_73 = new JLabel();
        this.JLCompleto73 = new JLabel();
        this.JLDienteBlanco73 = new JLabel();
        this.JP72 = new JPanel();
        this.JLArriba1_72 = new JLabel();
        this.JLArriba2_72 = new JLabel();
        this.JLCentro72 = new JLabel();
        this.JLDerecha72 = new JLabel();
        this.JLIzquierda72 = new JLabel();
        this.JLAbajo1_72 = new JLabel();
        this.JLAbajo2_72 = new JLabel();
        this.JLCompleto72 = new JLabel();
        this.JLDienteBlanco72 = new JLabel();
        this.JP71 = new JPanel();
        this.JLArriba1_71 = new JLabel();
        this.JLArriba2_71 = new JLabel();
        this.JLCentro71 = new JLabel();
        this.JLDerecha71 = new JLabel();
        this.JLIzquierda71 = new JLabel();
        this.JLAbajo1_71 = new JLabel();
        this.JLAbajo2_71 = new JLabel();
        this.JLCompleto71 = new JLabel();
        this.JLDienteBlanco70 = new JLabel();
        this.JP85 = new JPanel();
        this.JLArriba1_85 = new JLabel();
        this.JLArriba2_85 = new JLabel();
        this.JLCentro85 = new JLabel();
        this.JLDerecha85 = new JLabel();
        this.JLIzquierda85 = new JLabel();
        this.JLAbajo1_85 = new JLabel();
        this.JLAbajo2_85 = new JLabel();
        this.JLCompleto85 = new JLabel();
        this.JLDienteBlanco85 = new JLabel();
        this.JP84 = new JPanel();
        this.JLArriba1_84 = new JLabel();
        this.JLArriba2_84 = new JLabel();
        this.JLCentro84 = new JLabel();
        this.JLDerecha84 = new JLabel();
        this.JLIzquierda84 = new JLabel();
        this.JLAbajo1_84 = new JLabel();
        this.JLAbajo2_84 = new JLabel();
        this.JLCompleto84 = new JLabel();
        this.JLDienteBlanco84 = new JLabel();
        this.JP83 = new JPanel();
        this.JLArriba1_83 = new JLabel();
        this.JLArriba2_83 = new JLabel();
        this.JLCentro83 = new JLabel();
        this.JLDerecha83 = new JLabel();
        this.JLIzquierda83 = new JLabel();
        this.JLAbajo1_83 = new JLabel();
        this.JLAbajo2_83 = new JLabel();
        this.JLCompleto83 = new JLabel();
        this.JLDienteBlanco83 = new JLabel();
        this.JP82 = new JPanel();
        this.JLArriba1_82 = new JLabel();
        this.JLArriba2_82 = new JLabel();
        this.JLCentro82 = new JLabel();
        this.JLDerecha82 = new JLabel();
        this.JLIzquierda82 = new JLabel();
        this.JLAbajo1_82 = new JLabel();
        this.JLAbajo2_82 = new JLabel();
        this.JLCompleto82 = new JLabel();
        this.JLDienteBlanco82 = new JLabel();
        this.JP81 = new JPanel();
        this.JLArriba1_81 = new JLabel();
        this.JLArriba2_81 = new JLabel();
        this.JLCentro81 = new JLabel();
        this.JLDerecha81 = new JLabel();
        this.JLIzquierda81 = new JLabel();
        this.JLAbajo1_81 = new JLabel();
        this.JLAbajo2_81 = new JLabel();
        this.JLCompleto81 = new JLabel();
        this.JLDienteBlanco81 = new JLabel();
        this.JP48 = new JPanel();
        this.JLArriba1_48 = new JLabel();
        this.JLArriba2_48 = new JLabel();
        this.JLCentro48 = new JLabel();
        this.JLDerecha48 = new JLabel();
        this.JLIzquierda48 = new JLabel();
        this.JLAbajo1_48 = new JLabel();
        this.JLAbajo2_48 = new JLabel();
        this.JLCompleto48 = new JLabel();
        this.JLDienteBlanco48 = new JLabel();
        this.JP47 = new JPanel();
        this.JLArriba1_47 = new JLabel();
        this.JLArriba2_47 = new JLabel();
        this.JLCentro47 = new JLabel();
        this.JLDerecha47 = new JLabel();
        this.JLIzquierda47 = new JLabel();
        this.JLAbajo1_47 = new JLabel();
        this.JLAbajo2_47 = new JLabel();
        this.JLCompleto47 = new JLabel();
        this.JLDienteBlanco47 = new JLabel();
        this.JP46 = new JPanel();
        this.JLArriba1_46 = new JLabel();
        this.JLArriba2_46 = new JLabel();
        this.JLCentro46 = new JLabel();
        this.JLDerecha46 = new JLabel();
        this.JLIzquierda46 = new JLabel();
        this.JLAbajo1_46 = new JLabel();
        this.JLAbajo2_46 = new JLabel();
        this.JLCompleto46 = new JLabel();
        this.JLDienteBlanco46 = new JLabel();
        this.JP45 = new JPanel();
        this.JLArriba1_45 = new JLabel();
        this.JLArriba2_45 = new JLabel();
        this.JLCentro45 = new JLabel();
        this.JLDerecha45 = new JLabel();
        this.JLIzquierda45 = new JLabel();
        this.JLAbajo1_45 = new JLabel();
        this.JLAbajo2_45 = new JLabel();
        this.JLCompleto45 = new JLabel();
        this.JLDienteBlanco45 = new JLabel();
        this.JP44 = new JPanel();
        this.JLArriba1_44 = new JLabel();
        this.JLArriba2_44 = new JLabel();
        this.JLCentro44 = new JLabel();
        this.JLDerecha44 = new JLabel();
        this.JLIzquierda44 = new JLabel();
        this.JLAbajo1_44 = new JLabel();
        this.JLAbajo2_44 = new JLabel();
        this.JLCompleto44 = new JLabel();
        this.JLDienteBlanco44 = new JLabel();
        this.JP43 = new JPanel();
        this.JLArriba1_43 = new JLabel();
        this.JLArriba2_43 = new JLabel();
        this.JLCentro43 = new JLabel();
        this.JLDerecha43 = new JLabel();
        this.JLIzquierda43 = new JLabel();
        this.JLAbajo1_43 = new JLabel();
        this.JLAbajo2_43 = new JLabel();
        this.JLCompleto43 = new JLabel();
        this.JLDienteBlanco43 = new JLabel();
        this.JP42 = new JPanel();
        this.JLArriba1_42 = new JLabel();
        this.JLArriba2_42 = new JLabel();
        this.JLCentro42 = new JLabel();
        this.JLDerecha42 = new JLabel();
        this.JLIzquierda42 = new JLabel();
        this.JLAbajo1_42 = new JLabel();
        this.JLAbajo2_42 = new JLabel();
        this.JLCompleto42 = new JLabel();
        this.JLDienteBlanco42 = new JLabel();
        this.JP41 = new JPanel();
        this.JLArriba1_41 = new JLabel();
        this.JLArriba2_41 = new JLabel();
        this.JLCentro41 = new JLabel();
        this.JLDerecha41 = new JLabel();
        this.JLIzquierda41 = new JLabel();
        this.JLAbajo1_41 = new JLabel();
        this.JLAbajo2_41 = new JLabel();
        this.JLCompleto41 = new JLabel();
        this.JLDienteBlanco41 = new JLabel();
        this.JP31 = new JPanel();
        this.JLArriba1_31 = new JLabel();
        this.JLArriba2_31 = new JLabel();
        this.JLCentro31 = new JLabel();
        this.JLDerecha31 = new JLabel();
        this.JLIzquierda31 = new JLabel();
        this.JLAbajo1_31 = new JLabel();
        this.JLAbajo2_31 = new JLabel();
        this.JLCompleto31 = new JLabel();
        this.JLDienteBlanco31 = new JLabel();
        this.JP32 = new JPanel();
        this.JLArriba1_32 = new JLabel();
        this.JLArriba2_32 = new JLabel();
        this.JLCentro32 = new JLabel();
        this.JLDerecha32 = new JLabel();
        this.JLIzquierda32 = new JLabel();
        this.JLAbajo1_32 = new JLabel();
        this.JLAbajo2_32 = new JLabel();
        this.JLCompleto32 = new JLabel();
        this.JLDienteBlanco32 = new JLabel();
        this.JP33 = new JPanel();
        this.JLArriba1_33 = new JLabel();
        this.JLArriba2_33 = new JLabel();
        this.JLCentro33 = new JLabel();
        this.JLDerecha33 = new JLabel();
        this.JLIzquierda33 = new JLabel();
        this.JLAbajo1_33 = new JLabel();
        this.JLAbajo2_33 = new JLabel();
        this.JLCompleto33 = new JLabel();
        this.JLDienteBlanco33 = new JLabel();
        this.JP34 = new JPanel();
        this.JLArriba1_34 = new JLabel();
        this.JLArriba2_34 = new JLabel();
        this.JLCentro34 = new JLabel();
        this.JLDerecha34 = new JLabel();
        this.JLIzquierda34 = new JLabel();
        this.JLAbajo1_34 = new JLabel();
        this.JLAbajo2_34 = new JLabel();
        this.JLCompleto34 = new JLabel();
        this.JLDienteBlanco34 = new JLabel();
        this.JP35 = new JPanel();
        this.JLArriba1_35 = new JLabel();
        this.JLArriba2_35 = new JLabel();
        this.JLCentro35 = new JLabel();
        this.JLDerecha35 = new JLabel();
        this.JLIzquierda35 = new JLabel();
        this.JLAbajo1_35 = new JLabel();
        this.JLAbajo2_35 = new JLabel();
        this.JLCompleto35 = new JLabel();
        this.JLDienteBlanco35 = new JLabel();
        this.JP36 = new JPanel();
        this.JLArriba1_36 = new JLabel();
        this.JLArriba2_36 = new JLabel();
        this.JLCentro36 = new JLabel();
        this.JLDerecha36 = new JLabel();
        this.JLIzquierda36 = new JLabel();
        this.JLAbajo1_36 = new JLabel();
        this.JLAbajo2_36 = new JLabel();
        this.JLCompleto36 = new JLabel();
        this.JLDienteBlanco36 = new JLabel();
        this.JP37 = new JPanel();
        this.JLArriba1_37 = new JLabel();
        this.JLArriba2_37 = new JLabel();
        this.JLCentro37 = new JLabel();
        this.JLDerecha37 = new JLabel();
        this.JLIzquierda37 = new JLabel();
        this.JLAbajo1_37 = new JLabel();
        this.JLAbajo2_37 = new JLabel();
        this.JLCompleto37 = new JLabel();
        this.JLDienteBlanco37 = new JLabel();
        this.JP38 = new JPanel();
        this.JLArriba1_38 = new JLabel();
        this.JLArriba2_38 = new JLabel();
        this.JLCentro38 = new JLabel();
        this.JLDerecha38 = new JLabel();
        this.JLIzquierda38 = new JLabel();
        this.JLAbajo1_38 = new JLabel();
        this.JLAbajo2_38 = new JLabel();
        this.JLCompleto38 = new JLabel();
        this.JLDienteBlanco38 = new JLabel();
        this.L18 = new JLabel();
        this.L17 = new JLabel();
        this.L16 = new JLabel();
        this.L15 = new JLabel();
        this.L14 = new JLabel();
        this.L13 = new JLabel();
        this.L12 = new JLabel();
        this.L11 = new JLabel();
        this.L21 = new JLabel();
        this.L22 = new JLabel();
        this.L23 = new JLabel();
        this.L24 = new JLabel();
        this.L25 = new JLabel();
        this.L26 = new JLabel();
        this.L27 = new JLabel();
        this.L28 = new JLabel();
        this.L55 = new JLabel();
        this.L54 = new JLabel();
        this.L53 = new JLabel();
        this.L52 = new JLabel();
        this.L51 = new JLabel();
        this.L61 = new JLabel();
        this.L62 = new JLabel();
        this.L63 = new JLabel();
        this.L64 = new JLabel();
        this.L65 = new JLabel();
        this.L85 = new JLabel();
        this.L84 = new JLabel();
        this.L83 = new JLabel();
        this.L82 = new JLabel();
        this.L81 = new JLabel();
        this.L71 = new JLabel();
        this.L72 = new JLabel();
        this.L73 = new JLabel();
        this.L74 = new JLabel();
        this.L75 = new JLabel();
        this.L48 = new JLabel();
        this.L47 = new JLabel();
        this.L46 = new JLabel();
        this.L45 = new JLabel();
        this.L44 = new JLabel();
        this.L43 = new JLabel();
        this.L42 = new JLabel();
        this.L41 = new JLabel();
        this.L31 = new JLabel();
        this.L32 = new JLabel();
        this.L33 = new JLabel();
        this.L34 = new JLabel();
        this.L35 = new JLabel();
        this.L36 = new JLabel();
        this.L37 = new JLabel();
        this.L38 = new JLabel();
        this.Verde = new JLabel();
        this.Amarillo = new JLabel();
        this.Rojo = new JLabel();
        setBackground(new Color(255, 255, 255));
        setPreferredSize(new Dimension(699, 340));
        this.JP18.setBorder(BorderFactory.createEtchedBorder());
        this.JP18.setMaximumSize(new Dimension(41, 65));
        this.JP18.setMinimumSize(new Dimension(41, 65));
        this.JP18.setName("18");
        this.JP18.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP18MouseClicked(evt);
            }
        });
        this.JP18.setLayout((LayoutManager) null);
        this.JLArriba1_18.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_18.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_18.setName("1");
        this.JLArriba1_18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLArriba1_18);
        this.JLArriba1_18.setBounds(0, 0, 40, 65);
        this.JLArriba2_18.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_18.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_18.setName("2");
        this.JLArriba2_18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLArriba2_18);
        this.JLArriba2_18.setBounds(0, 0, 40, 65);
        this.JLCentro18.setMaximumSize(new Dimension(41, 65));
        this.JLCentro18.setMinimumSize(new Dimension(41, 65));
        this.JLCentro18.setName("4");
        this.JLCentro18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLCentro18);
        this.JLCentro18.setBounds(0, 0, 40, 65);
        this.JLDerecha18.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha18.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha18.setName("3");
        this.JLDerecha18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLDerecha18);
        this.JLDerecha18.setBounds(0, 0, 40, 65);
        this.JLIzquierda18.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda18.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda18.setName("5");
        this.JLIzquierda18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLIzquierda18);
        this.JLIzquierda18.setBounds(0, 0, 40, 65);
        this.JLAbajo1_18.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_18.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_18.setName("7");
        this.JLAbajo1_18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLAbajo1_18);
        this.JLAbajo1_18.setBounds(0, 0, 40, 65);
        this.JLAbajo2_18.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_18.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_18.setName("6");
        this.JLAbajo2_18.setPreferredSize(new Dimension(41, 65));
        this.JP18.add(this.JLAbajo2_18);
        this.JLAbajo2_18.setBounds(0, 0, 40, 65);
        this.JLCompleto18.setName("8");
        this.JP18.add(this.JLCompleto18);
        this.JLCompleto18.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco18.setName("0");
        this.JP18.add(this.JLDienteBlanco18);
        this.JLDienteBlanco18.setBounds(0, 0, 40, 65);
        this.JP17.setBorder(BorderFactory.createEtchedBorder());
        this.JP17.setMaximumSize(new Dimension(41, 65));
        this.JP17.setMinimumSize(new Dimension(41, 65));
        this.JP17.setName("17");
        this.JP17.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.2
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP17MouseClicked(evt);
            }
        });
        this.JP17.setLayout((LayoutManager) null);
        this.JLArriba1_17.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_17.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_17.setName("1");
        this.JLArriba1_17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLArriba1_17);
        this.JLArriba1_17.setBounds(0, 0, 40, 65);
        this.JLArriba2_17.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_17.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_17.setName("2");
        this.JLArriba2_17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLArriba2_17);
        this.JLArriba2_17.setBounds(0, 0, 40, 65);
        this.JLCentro17.setMaximumSize(new Dimension(41, 65));
        this.JLCentro17.setMinimumSize(new Dimension(41, 65));
        this.JLCentro17.setName("4");
        this.JLCentro17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLCentro17);
        this.JLCentro17.setBounds(0, 0, 40, 65);
        this.JLDerecha17.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha17.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha17.setName("3");
        this.JLDerecha17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLDerecha17);
        this.JLDerecha17.setBounds(0, 0, 40, 65);
        this.JLIzquierda17.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda17.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda17.setName("5");
        this.JLIzquierda17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLIzquierda17);
        this.JLIzquierda17.setBounds(0, 0, 40, 65);
        this.JLAbajo1_17.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_17.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_17.setName("7");
        this.JLAbajo1_17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLAbajo1_17);
        this.JLAbajo1_17.setBounds(0, 0, 40, 65);
        this.JLAbajo2_17.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_17.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_17.setName("6");
        this.JLAbajo2_17.setPreferredSize(new Dimension(41, 65));
        this.JP17.add(this.JLAbajo2_17);
        this.JLAbajo2_17.setBounds(0, 0, 40, 65);
        this.JLCompleto17.setName("8");
        this.JP17.add(this.JLCompleto17);
        this.JLCompleto17.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco17.setName("0");
        this.JP17.add(this.JLDienteBlanco17);
        this.JLDienteBlanco17.setBounds(0, 0, 40, 65);
        this.JP16.setBorder(BorderFactory.createEtchedBorder());
        this.JP16.setMaximumSize(new Dimension(41, 65));
        this.JP16.setMinimumSize(new Dimension(41, 65));
        this.JP16.setName("16");
        this.JP16.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.3
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP16MouseClicked(evt);
            }
        });
        this.JP16.setLayout((LayoutManager) null);
        this.JLArriba1_16.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_16.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_16.setName("1");
        this.JLArriba1_16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLArriba1_16);
        this.JLArriba1_16.setBounds(0, 0, 40, 65);
        this.JLArriba2_16.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_16.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_16.setName("2");
        this.JLArriba2_16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLArriba2_16);
        this.JLArriba2_16.setBounds(0, 0, 40, 65);
        this.JLCentro16.setMaximumSize(new Dimension(41, 65));
        this.JLCentro16.setMinimumSize(new Dimension(41, 65));
        this.JLCentro16.setName("4");
        this.JLCentro16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLCentro16);
        this.JLCentro16.setBounds(0, 0, 40, 65);
        this.JLDerecha16.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha16.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha16.setName("3");
        this.JLDerecha16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLDerecha16);
        this.JLDerecha16.setBounds(0, 0, 40, 65);
        this.JLIzquierda16.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda16.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda16.setName("5");
        this.JLIzquierda16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLIzquierda16);
        this.JLIzquierda16.setBounds(0, 0, 40, 65);
        this.JLAbajo1_16.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_16.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_16.setName("7");
        this.JLAbajo1_16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLAbajo1_16);
        this.JLAbajo1_16.setBounds(0, 0, 40, 65);
        this.JLAbajo2_16.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_16.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_16.setName("6");
        this.JLAbajo2_16.setPreferredSize(new Dimension(41, 65));
        this.JP16.add(this.JLAbajo2_16);
        this.JLAbajo2_16.setBounds(0, 0, 40, 65);
        this.JLCompleto16.setName("8");
        this.JP16.add(this.JLCompleto16);
        this.JLCompleto16.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco16.setName("0");
        this.JP16.add(this.JLDienteBlanco16);
        this.JLDienteBlanco16.setBounds(0, 0, 40, 65);
        this.JP15.setBorder(BorderFactory.createEtchedBorder());
        this.JP15.setMaximumSize(new Dimension(41, 65));
        this.JP15.setMinimumSize(new Dimension(41, 65));
        this.JP15.setName("15");
        this.JP15.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.4
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP15MouseClicked(evt);
            }
        });
        this.JP15.setLayout((LayoutManager) null);
        this.JLArriba1_15.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_15.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_15.setName("1");
        this.JLArriba1_15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLArriba1_15);
        this.JLArriba1_15.setBounds(0, 0, 40, 65);
        this.JLArriba2_15.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_15.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_15.setName("2");
        this.JLArriba2_15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLArriba2_15);
        this.JLArriba2_15.setBounds(0, 0, 40, 65);
        this.JLCentro15.setMaximumSize(new Dimension(41, 65));
        this.JLCentro15.setMinimumSize(new Dimension(41, 65));
        this.JLCentro15.setName("4");
        this.JLCentro15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLCentro15);
        this.JLCentro15.setBounds(0, 0, 40, 65);
        this.JLDerecha15.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha15.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha15.setName("3");
        this.JLDerecha15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLDerecha15);
        this.JLDerecha15.setBounds(0, 0, 40, 65);
        this.JLIzquierda15.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda15.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda15.setName("5");
        this.JLIzquierda15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLIzquierda15);
        this.JLIzquierda15.setBounds(0, 0, 40, 65);
        this.JLAbajo1_15.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_15.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_15.setName("7");
        this.JLAbajo1_15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLAbajo1_15);
        this.JLAbajo1_15.setBounds(0, 0, 40, 65);
        this.JLAbajo2_15.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_15.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_15.setName("6");
        this.JLAbajo2_15.setPreferredSize(new Dimension(41, 65));
        this.JP15.add(this.JLAbajo2_15);
        this.JLAbajo2_15.setBounds(0, 0, 40, 65);
        this.JLCompleto15.setName("8");
        this.JP15.add(this.JLCompleto15);
        this.JLCompleto15.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco15.setName("0");
        this.JP15.add(this.JLDienteBlanco15);
        this.JLDienteBlanco15.setBounds(0, 0, 40, 65);
        this.JP14.setBorder(BorderFactory.createEtchedBorder());
        this.JP14.setMaximumSize(new Dimension(41, 65));
        this.JP14.setMinimumSize(new Dimension(41, 65));
        this.JP14.setName("14");
        this.JP14.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.5
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP14MouseClicked(evt);
            }
        });
        this.JP14.setLayout((LayoutManager) null);
        this.JLArriba1_14.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_14.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_14.setName("1");
        this.JLArriba1_14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLArriba1_14);
        this.JLArriba1_14.setBounds(0, 0, 40, 65);
        this.JLArriba2_14.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_14.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_14.setName("2");
        this.JLArriba2_14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLArriba2_14);
        this.JLArriba2_14.setBounds(0, 0, 40, 65);
        this.JLCentro14.setMaximumSize(new Dimension(41, 65));
        this.JLCentro14.setMinimumSize(new Dimension(41, 65));
        this.JLCentro14.setName("4");
        this.JLCentro14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLCentro14);
        this.JLCentro14.setBounds(0, 0, 40, 65);
        this.JLDerecha14.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha14.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha14.setName("3");
        this.JLDerecha14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLDerecha14);
        this.JLDerecha14.setBounds(0, 0, 40, 65);
        this.JLIzquierda14.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda14.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda14.setName("5");
        this.JLIzquierda14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLIzquierda14);
        this.JLIzquierda14.setBounds(0, 0, 40, 65);
        this.JLAbajo1_14.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_14.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_14.setName("7");
        this.JLAbajo1_14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLAbajo1_14);
        this.JLAbajo1_14.setBounds(0, 0, 40, 65);
        this.JLAbajo2_14.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_14.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_14.setName("6");
        this.JLAbajo2_14.setPreferredSize(new Dimension(41, 65));
        this.JP14.add(this.JLAbajo2_14);
        this.JLAbajo2_14.setBounds(0, 0, 40, 65);
        this.JLCompleto14.setName("8");
        this.JP14.add(this.JLCompleto14);
        this.JLCompleto14.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco14.setName("0");
        this.JP14.add(this.JLDienteBlanco14);
        this.JLDienteBlanco14.setBounds(0, 0, 40, 65);
        this.JP13.setBorder(BorderFactory.createEtchedBorder());
        this.JP13.setMaximumSize(new Dimension(41, 65));
        this.JP13.setMinimumSize(new Dimension(41, 65));
        this.JP13.setName("13");
        this.JP13.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.6
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP13MouseClicked(evt);
            }
        });
        this.JP13.setLayout((LayoutManager) null);
        this.JLArriba1_13.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_13.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_13.setName("1");
        this.JLArriba1_13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLArriba1_13);
        this.JLArriba1_13.setBounds(0, 0, 40, 65);
        this.JLArriba2_13.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_13.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_13.setName("2");
        this.JLArriba2_13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLArriba2_13);
        this.JLArriba2_13.setBounds(0, 0, 40, 65);
        this.JLCentro13.setMaximumSize(new Dimension(41, 65));
        this.JLCentro13.setMinimumSize(new Dimension(41, 65));
        this.JLCentro13.setName("4");
        this.JLCentro13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLCentro13);
        this.JLCentro13.setBounds(0, 0, 40, 65);
        this.JLDerecha13.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha13.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha13.setName("3");
        this.JLDerecha13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLDerecha13);
        this.JLDerecha13.setBounds(0, 0, 40, 65);
        this.JLIzquierda13.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda13.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda13.setName("5");
        this.JLIzquierda13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLIzquierda13);
        this.JLIzquierda13.setBounds(0, 0, 40, 65);
        this.JLAbajo1_13.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_13.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_13.setName("7");
        this.JLAbajo1_13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLAbajo1_13);
        this.JLAbajo1_13.setBounds(0, 0, 40, 65);
        this.JLAbajo2_13.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_13.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_13.setName("6");
        this.JLAbajo2_13.setPreferredSize(new Dimension(41, 65));
        this.JP13.add(this.JLAbajo2_13);
        this.JLAbajo2_13.setBounds(0, 0, 40, 65);
        this.JLCompleto13.setName("8");
        this.JP13.add(this.JLCompleto13);
        this.JLCompleto13.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco13.setName("0");
        this.JP13.add(this.JLDienteBlanco13);
        this.JLDienteBlanco13.setBounds(0, 0, 40, 65);
        this.JP12.setBorder(BorderFactory.createEtchedBorder());
        this.JP12.setMaximumSize(new Dimension(41, 65));
        this.JP12.setMinimumSize(new Dimension(41, 65));
        this.JP12.setName("12");
        this.JP12.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.7
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP12MouseClicked(evt);
            }
        });
        this.JP12.setLayout((LayoutManager) null);
        this.JLArriba1_12.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_12.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_12.setName("1");
        this.JLArriba1_12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLArriba1_12);
        this.JLArriba1_12.setBounds(0, 0, 40, 65);
        this.JLArriba2_12.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_12.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_12.setName("2");
        this.JLArriba2_12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLArriba2_12);
        this.JLArriba2_12.setBounds(0, 0, 40, 65);
        this.JLCentro12.setMaximumSize(new Dimension(41, 65));
        this.JLCentro12.setMinimumSize(new Dimension(41, 65));
        this.JLCentro12.setName("4");
        this.JLCentro12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLCentro12);
        this.JLCentro12.setBounds(0, 0, 40, 65);
        this.JLDerecha12.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha12.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha12.setName("3");
        this.JLDerecha12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLDerecha12);
        this.JLDerecha12.setBounds(0, 0, 40, 65);
        this.JLIzquierda12.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda12.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda12.setName("5");
        this.JLIzquierda12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLIzquierda12);
        this.JLIzquierda12.setBounds(0, 0, 40, 65);
        this.JLAbajo1_12.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_12.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_12.setName("7");
        this.JLAbajo1_12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLAbajo1_12);
        this.JLAbajo1_12.setBounds(0, 0, 40, 65);
        this.JLAbajo2_12.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_12.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_12.setName("6");
        this.JLAbajo2_12.setPreferredSize(new Dimension(41, 65));
        this.JP12.add(this.JLAbajo2_12);
        this.JLAbajo2_12.setBounds(0, 0, 40, 65);
        this.JLCompleto12.setName("8");
        this.JP12.add(this.JLCompleto12);
        this.JLCompleto12.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco12.setName("0");
        this.JP12.add(this.JLDienteBlanco12);
        this.JLDienteBlanco12.setBounds(0, 0, 40, 65);
        this.JP11.setBorder(BorderFactory.createEtchedBorder());
        this.JP11.setMaximumSize(new Dimension(41, 65));
        this.JP11.setMinimumSize(new Dimension(41, 65));
        this.JP11.setName("11");
        this.JP11.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.8
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP11MouseClicked(evt);
            }
        });
        this.JP11.setLayout((LayoutManager) null);
        this.JLArriba1_11.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_11.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_11.setName("1");
        this.JLArriba1_11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLArriba1_11);
        this.JLArriba1_11.setBounds(0, 0, 40, 65);
        this.JLArriba2_11.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_11.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_11.setName("2");
        this.JLArriba2_11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLArriba2_11);
        this.JLArriba2_11.setBounds(0, 0, 40, 65);
        this.JLCentro11.setMaximumSize(new Dimension(41, 65));
        this.JLCentro11.setMinimumSize(new Dimension(41, 65));
        this.JLCentro11.setName("4");
        this.JLCentro11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLCentro11);
        this.JLCentro11.setBounds(0, 0, 40, 65);
        this.JLDerecha11.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha11.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha11.setName("3");
        this.JLDerecha11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLDerecha11);
        this.JLDerecha11.setBounds(0, 0, 40, 65);
        this.JLIzquierda11.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda11.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda11.setName("5");
        this.JLIzquierda11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLIzquierda11);
        this.JLIzquierda11.setBounds(0, 0, 40, 65);
        this.JLAbajo1_11.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_11.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_11.setName("7");
        this.JLAbajo1_11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLAbajo1_11);
        this.JLAbajo1_11.setBounds(0, 0, 40, 65);
        this.JLAbajo2_11.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_11.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_11.setName("6");
        this.JLAbajo2_11.setPreferredSize(new Dimension(41, 65));
        this.JP11.add(this.JLAbajo2_11);
        this.JLAbajo2_11.setBounds(0, 0, 40, 65);
        this.JLCompleto11.setName("8");
        this.JP11.add(this.JLCompleto11);
        this.JLCompleto11.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco11.setName("0");
        this.JP11.add(this.JLDienteBlanco11);
        this.JLDienteBlanco11.setBounds(0, 0, 40, 65);
        this.JP21.setBorder(BorderFactory.createEtchedBorder());
        this.JP21.setMaximumSize(new Dimension(41, 65));
        this.JP21.setMinimumSize(new Dimension(41, 65));
        this.JP21.setName("21");
        this.JP21.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.9
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP21MouseClicked(evt);
            }
        });
        this.JP21.setLayout((LayoutManager) null);
        this.JLArriba1_21.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_21.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_21.setName("1");
        this.JLArriba1_21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLArriba1_21);
        this.JLArriba1_21.setBounds(0, 0, 40, 65);
        this.JLArriba2_21.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_21.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_21.setName("2");
        this.JLArriba2_21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLArriba2_21);
        this.JLArriba2_21.setBounds(0, 0, 40, 65);
        this.JLCentro21.setMaximumSize(new Dimension(41, 65));
        this.JLCentro21.setMinimumSize(new Dimension(41, 65));
        this.JLCentro21.setName("4");
        this.JLCentro21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLCentro21);
        this.JLCentro21.setBounds(0, 0, 40, 65);
        this.JLDerecha21.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha21.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha21.setName("3");
        this.JLDerecha21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLDerecha21);
        this.JLDerecha21.setBounds(0, 0, 40, 65);
        this.JLIzquierda21.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda21.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda21.setName("5");
        this.JLIzquierda21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLIzquierda21);
        this.JLIzquierda21.setBounds(0, 0, 40, 65);
        this.JLAbajo1_21.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_21.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_21.setName("7");
        this.JLAbajo1_21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLAbajo1_21);
        this.JLAbajo1_21.setBounds(0, 0, 40, 65);
        this.JLAbajo2_21.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_21.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_21.setName("6");
        this.JLAbajo2_21.setPreferredSize(new Dimension(41, 65));
        this.JP21.add(this.JLAbajo2_21);
        this.JLAbajo2_21.setBounds(0, 0, 40, 65);
        this.JLCompleto21.setName("8");
        this.JP21.add(this.JLCompleto21);
        this.JLCompleto21.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco21.setName("0");
        this.JP21.add(this.JLDienteBlanco21);
        this.JLDienteBlanco21.setBounds(0, 0, 40, 65);
        this.JP22.setBorder(BorderFactory.createEtchedBorder());
        this.JP22.setMaximumSize(new Dimension(41, 65));
        this.JP22.setMinimumSize(new Dimension(41, 65));
        this.JP22.setName("22");
        this.JP22.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.10
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP22MouseClicked(evt);
            }
        });
        this.JP22.setLayout((LayoutManager) null);
        this.JLArriba1_22.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_22.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_22.setName("1");
        this.JLArriba1_22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLArriba1_22);
        this.JLArriba1_22.setBounds(0, 0, 40, 65);
        this.JLArriba2_22.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_22.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_22.setName("2");
        this.JLArriba2_22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLArriba2_22);
        this.JLArriba2_22.setBounds(0, 0, 40, 65);
        this.JLCentro22.setMaximumSize(new Dimension(41, 65));
        this.JLCentro22.setMinimumSize(new Dimension(41, 65));
        this.JLCentro22.setName("4");
        this.JLCentro22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLCentro22);
        this.JLCentro22.setBounds(0, 0, 40, 65);
        this.JLDerecha22.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha22.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha22.setName("3");
        this.JLDerecha22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLDerecha22);
        this.JLDerecha22.setBounds(0, 0, 40, 65);
        this.JLIzquierda22.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda22.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda22.setName("5");
        this.JLIzquierda22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLIzquierda22);
        this.JLIzquierda22.setBounds(0, 0, 40, 65);
        this.JLAbajo1_22.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_22.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_22.setName("7");
        this.JLAbajo1_22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLAbajo1_22);
        this.JLAbajo1_22.setBounds(0, 0, 40, 65);
        this.JLAbajo2_22.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_22.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_22.setName("6");
        this.JLAbajo2_22.setPreferredSize(new Dimension(41, 65));
        this.JP22.add(this.JLAbajo2_22);
        this.JLAbajo2_22.setBounds(0, 0, 40, 65);
        this.JLCompleto22.setName("8");
        this.JP22.add(this.JLCompleto22);
        this.JLCompleto22.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco22.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco22.setName("0");
        this.JP22.add(this.JLDienteBlanco22);
        this.JLDienteBlanco22.setBounds(0, 0, 40, 65);
        this.JP23.setBorder(BorderFactory.createEtchedBorder());
        this.JP23.setMaximumSize(new Dimension(41, 65));
        this.JP23.setMinimumSize(new Dimension(41, 65));
        this.JP23.setName("23");
        this.JP23.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.11
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP23MouseClicked(evt);
            }
        });
        this.JP23.setLayout((LayoutManager) null);
        this.JLArriba1_23.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_23.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_23.setName("1");
        this.JLArriba1_23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLArriba1_23);
        this.JLArriba1_23.setBounds(0, 0, 40, 65);
        this.JLArriba2_23.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_23.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_23.setName("2");
        this.JLArriba2_23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLArriba2_23);
        this.JLArriba2_23.setBounds(0, 0, 40, 65);
        this.JLCentro23.setMaximumSize(new Dimension(41, 65));
        this.JLCentro23.setMinimumSize(new Dimension(41, 65));
        this.JLCentro23.setName("4");
        this.JLCentro23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLCentro23);
        this.JLCentro23.setBounds(0, 0, 40, 65);
        this.JLDerecha23.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha23.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha23.setName("3");
        this.JLDerecha23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLDerecha23);
        this.JLDerecha23.setBounds(0, 0, 40, 65);
        this.JLIzquierda23.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda23.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda23.setName("5");
        this.JLIzquierda23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLIzquierda23);
        this.JLIzquierda23.setBounds(0, 0, 40, 65);
        this.JLAbajo1_23.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_23.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_23.setName("7");
        this.JLAbajo1_23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLAbajo1_23);
        this.JLAbajo1_23.setBounds(0, 0, 40, 65);
        this.JLAbajo2_23.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_23.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_23.setName("6");
        this.JLAbajo2_23.setPreferredSize(new Dimension(41, 65));
        this.JP23.add(this.JLAbajo2_23);
        this.JLAbajo2_23.setBounds(0, 0, 40, 65);
        this.JLCompleto23.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLCompleto23.setName("8");
        this.JP23.add(this.JLCompleto23);
        this.JLCompleto23.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco23.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco23.setName("0");
        this.JP23.add(this.JLDienteBlanco23);
        this.JLDienteBlanco23.setBounds(0, 0, 40, 65);
        this.JP24.setBorder(BorderFactory.createEtchedBorder());
        this.JP24.setMaximumSize(new Dimension(41, 65));
        this.JP24.setMinimumSize(new Dimension(41, 65));
        this.JP24.setName("24");
        this.JP24.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.12
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP24MouseClicked(evt);
            }
        });
        this.JP24.setLayout((LayoutManager) null);
        this.JLArriba1_24.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_24.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_24.setName("1");
        this.JLArriba1_24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLArriba1_24);
        this.JLArriba1_24.setBounds(0, 0, 40, 65);
        this.JLArriba2_24.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_24.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_24.setName("2");
        this.JLArriba2_24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLArriba2_24);
        this.JLArriba2_24.setBounds(0, 0, 40, 65);
        this.JLCentro24.setMaximumSize(new Dimension(41, 65));
        this.JLCentro24.setMinimumSize(new Dimension(41, 65));
        this.JLCentro24.setName("4");
        this.JLCentro24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLCentro24);
        this.JLCentro24.setBounds(0, 0, 40, 65);
        this.JLDerecha24.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha24.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha24.setName("3");
        this.JLDerecha24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLDerecha24);
        this.JLDerecha24.setBounds(0, 0, 40, 65);
        this.JLIzquierda24.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda24.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda24.setName("5");
        this.JLIzquierda24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLIzquierda24);
        this.JLIzquierda24.setBounds(0, 0, 40, 65);
        this.JLAbajo1_24.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_24.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_24.setName("7");
        this.JLAbajo1_24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLAbajo1_24);
        this.JLAbajo1_24.setBounds(0, 0, 40, 65);
        this.JLAbajo2_24.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_24.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_24.setName("6");
        this.JLAbajo2_24.setPreferredSize(new Dimension(41, 65));
        this.JP24.add(this.JLAbajo2_24);
        this.JLAbajo2_24.setBounds(0, 0, 40, 65);
        this.JLCompleto24.setName("8");
        this.JP24.add(this.JLCompleto24);
        this.JLCompleto24.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco24.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco24.setName("0");
        this.JP24.add(this.JLDienteBlanco24);
        this.JLDienteBlanco24.setBounds(0, 0, 40, 65);
        this.JP25.setBorder(BorderFactory.createEtchedBorder());
        this.JP25.setMaximumSize(new Dimension(41, 65));
        this.JP25.setMinimumSize(new Dimension(41, 65));
        this.JP25.setName("25");
        this.JP25.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.13
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP25MouseClicked(evt);
            }
        });
        this.JP25.setLayout((LayoutManager) null);
        this.JLArriba1_25.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_25.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_25.setName("1");
        this.JLArriba1_25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLArriba1_25);
        this.JLArriba1_25.setBounds(0, 0, 40, 65);
        this.JLArriba2_25.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_25.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_25.setName("2");
        this.JLArriba2_25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLArriba2_25);
        this.JLArriba2_25.setBounds(0, 0, 40, 65);
        this.JLCentro25.setMaximumSize(new Dimension(41, 65));
        this.JLCentro25.setMinimumSize(new Dimension(41, 65));
        this.JLCentro25.setName("4");
        this.JLCentro25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLCentro25);
        this.JLCentro25.setBounds(0, 0, 40, 65);
        this.JLDerecha25.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha25.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha25.setName("3");
        this.JLDerecha25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLDerecha25);
        this.JLDerecha25.setBounds(0, 0, 40, 65);
        this.JLIzquierda25.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda25.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda25.setName("5");
        this.JLIzquierda25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLIzquierda25);
        this.JLIzquierda25.setBounds(0, 0, 40, 65);
        this.JLAbajo1_25.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_25.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_25.setName("7");
        this.JLAbajo1_25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLAbajo1_25);
        this.JLAbajo1_25.setBounds(0, 0, 40, 65);
        this.JLAbajo2_25.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_25.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_25.setName("6");
        this.JLAbajo2_25.setPreferredSize(new Dimension(41, 65));
        this.JP25.add(this.JLAbajo2_25);
        this.JLAbajo2_25.setBounds(0, 0, 40, 65);
        this.JLCompleto25.setName("8");
        this.JP25.add(this.JLCompleto25);
        this.JLCompleto25.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco25.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco25.setName("0");
        this.JP25.add(this.JLDienteBlanco25);
        this.JLDienteBlanco25.setBounds(0, 0, 40, 65);
        this.JP26.setBorder(BorderFactory.createEtchedBorder());
        this.JP26.setMaximumSize(new Dimension(41, 65));
        this.JP26.setMinimumSize(new Dimension(41, 65));
        this.JP26.setName("26");
        this.JP26.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.14
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP26MouseClicked(evt);
            }
        });
        this.JP26.setLayout((LayoutManager) null);
        this.JLArriba1_26.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_26.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_26.setName("1");
        this.JLArriba1_26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLArriba1_26);
        this.JLArriba1_26.setBounds(0, 0, 40, 65);
        this.JLArriba2_26.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_26.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_26.setName("2");
        this.JLArriba2_26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLArriba2_26);
        this.JLArriba2_26.setBounds(0, 0, 40, 65);
        this.JLCentro26.setMaximumSize(new Dimension(41, 65));
        this.JLCentro26.setMinimumSize(new Dimension(41, 65));
        this.JLCentro26.setName("4");
        this.JLCentro26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLCentro26);
        this.JLCentro26.setBounds(0, 0, 40, 65);
        this.JLDerecha26.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha26.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha26.setName("3");
        this.JLDerecha26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLDerecha26);
        this.JLDerecha26.setBounds(0, 0, 40, 65);
        this.JLIzquierda26.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda26.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda26.setName("5");
        this.JLIzquierda26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLIzquierda26);
        this.JLIzquierda26.setBounds(0, 0, 40, 65);
        this.JLAbajo1_26.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_26.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_26.setName("7");
        this.JLAbajo1_26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLAbajo1_26);
        this.JLAbajo1_26.setBounds(0, 0, 40, 65);
        this.JLAbajo2_26.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_26.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_26.setName("6");
        this.JLAbajo2_26.setPreferredSize(new Dimension(41, 65));
        this.JP26.add(this.JLAbajo2_26);
        this.JLAbajo2_26.setBounds(0, 0, 40, 65);
        this.JLCompleto26.setName("8");
        this.JP26.add(this.JLCompleto26);
        this.JLCompleto26.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco26.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco26.setName("0");
        this.JP26.add(this.JLDienteBlanco26);
        this.JLDienteBlanco26.setBounds(0, 0, 40, 65);
        this.JP27.setBorder(BorderFactory.createEtchedBorder());
        this.JP27.setMaximumSize(new Dimension(41, 65));
        this.JP27.setMinimumSize(new Dimension(41, 65));
        this.JP27.setName("27");
        this.JP27.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.15
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP27MouseClicked(evt);
            }
        });
        this.JP27.setLayout((LayoutManager) null);
        this.JLArriba1_27.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_27.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_27.setName("1");
        this.JLArriba1_27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLArriba1_27);
        this.JLArriba1_27.setBounds(0, 0, 40, 65);
        this.JLArriba2_27.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_27.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_27.setName("2");
        this.JLArriba2_27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLArriba2_27);
        this.JLArriba2_27.setBounds(0, 0, 40, 65);
        this.JLCentro27.setMaximumSize(new Dimension(41, 65));
        this.JLCentro27.setMinimumSize(new Dimension(41, 65));
        this.JLCentro27.setName("4");
        this.JLCentro27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLCentro27);
        this.JLCentro27.setBounds(0, 0, 40, 65);
        this.JLDerecha27.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha27.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha27.setName("3");
        this.JLDerecha27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLDerecha27);
        this.JLDerecha27.setBounds(0, 0, 40, 65);
        this.JLIzquierda27.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda27.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda27.setName("5");
        this.JLIzquierda27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLIzquierda27);
        this.JLIzquierda27.setBounds(0, 0, 40, 65);
        this.JLAbajo1_27.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_27.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_27.setName("7");
        this.JLAbajo1_27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLAbajo1_27);
        this.JLAbajo1_27.setBounds(0, 0, 40, 65);
        this.JLAbajo2_27.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_27.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_27.setName("6");
        this.JLAbajo2_27.setPreferredSize(new Dimension(41, 65));
        this.JP27.add(this.JLAbajo2_27);
        this.JLAbajo2_27.setBounds(0, 0, 40, 65);
        this.JLCompleto27.setName("8");
        this.JP27.add(this.JLCompleto27);
        this.JLCompleto27.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco27.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco27.setName("0");
        this.JP27.add(this.JLDienteBlanco27);
        this.JLDienteBlanco27.setBounds(0, 0, 40, 65);
        this.JP28.setBorder(BorderFactory.createEtchedBorder());
        this.JP28.setMaximumSize(new Dimension(41, 65));
        this.JP28.setMinimumSize(new Dimension(41, 65));
        this.JP28.setName("28");
        this.JP28.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.16
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP28MouseClicked(evt);
            }
        });
        this.JP28.setLayout((LayoutManager) null);
        this.JLArriba1_28.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_28.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_28.setName("1");
        this.JLArriba1_28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLArriba1_28);
        this.JLArriba1_28.setBounds(0, 0, 40, 65);
        this.JLArriba2_28.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_28.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_28.setName("2");
        this.JLArriba2_28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLArriba2_28);
        this.JLArriba2_28.setBounds(0, 0, 40, 65);
        this.JLCentro28.setMaximumSize(new Dimension(41, 65));
        this.JLCentro28.setMinimumSize(new Dimension(41, 65));
        this.JLCentro28.setName("4");
        this.JLCentro28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLCentro28);
        this.JLCentro28.setBounds(0, 0, 40, 65);
        this.JLDerecha28.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha28.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha28.setName("3");
        this.JLDerecha28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLDerecha28);
        this.JLDerecha28.setBounds(0, 0, 40, 65);
        this.JLIzquierda28.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda28.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda28.setName("5");
        this.JLIzquierda28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLIzquierda28);
        this.JLIzquierda28.setBounds(0, 0, 40, 65);
        this.JLAbajo1_28.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_28.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_28.setName("7");
        this.JLAbajo1_28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLAbajo1_28);
        this.JLAbajo1_28.setBounds(0, 0, 40, 65);
        this.JLAbajo2_28.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_28.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_28.setName("6");
        this.JLAbajo2_28.setPreferredSize(new Dimension(41, 65));
        this.JP28.add(this.JLAbajo2_28);
        this.JLAbajo2_28.setBounds(0, 0, 40, 65);
        this.JLCompleto28.setName("8");
        this.JP28.add(this.JLCompleto28);
        this.JLCompleto28.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco28.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco28.setName("0");
        this.JP28.add(this.JLDienteBlanco28);
        this.JLDienteBlanco28.setBounds(0, 0, 40, 65);
        this.JP51.setBorder(BorderFactory.createEtchedBorder());
        this.JP51.setMaximumSize(new Dimension(41, 65));
        this.JP51.setMinimumSize(new Dimension(41, 65));
        this.JP51.setName("51");
        this.JP51.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.17
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP51MouseClicked(evt);
            }
        });
        this.JP51.setLayout((LayoutManager) null);
        this.JLArriba1_51.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_51.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_51.setName("1");
        this.JLArriba1_51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLArriba1_51);
        this.JLArriba1_51.setBounds(0, 0, 40, 65);
        this.JLArriba2_51.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_51.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_51.setName("2");
        this.JLArriba2_51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLArriba2_51);
        this.JLArriba2_51.setBounds(0, 0, 40, 65);
        this.JLCentro51.setMaximumSize(new Dimension(41, 65));
        this.JLCentro51.setMinimumSize(new Dimension(41, 65));
        this.JLCentro51.setName("4");
        this.JLCentro51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLCentro51);
        this.JLCentro51.setBounds(0, 0, 40, 65);
        this.JLDerecha51.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha51.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha51.setName("3");
        this.JLDerecha51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLDerecha51);
        this.JLDerecha51.setBounds(0, 0, 40, 65);
        this.JLIzquierda51.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda51.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda51.setName("5");
        this.JLIzquierda51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLIzquierda51);
        this.JLIzquierda51.setBounds(0, 0, 40, 65);
        this.JLAbajo1_51.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_51.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_51.setName("7");
        this.JLAbajo1_51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLAbajo1_51);
        this.JLAbajo1_51.setBounds(0, 0, 40, 65);
        this.JLAbajo2_51.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_51.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_51.setName("6");
        this.JLAbajo2_51.setPreferredSize(new Dimension(41, 65));
        this.JP51.add(this.JLAbajo2_51);
        this.JLAbajo2_51.setBounds(0, 0, 40, 65);
        this.JLCompleto51.setName("8");
        this.JP51.add(this.JLCompleto51);
        this.JLCompleto51.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco51.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco51.setName("0");
        this.JP51.add(this.JLDienteBlanco51);
        this.JLDienteBlanco51.setBounds(0, 0, 40, 65);
        this.JP52.setBorder(BorderFactory.createEtchedBorder());
        this.JP52.setMaximumSize(new Dimension(41, 65));
        this.JP52.setMinimumSize(new Dimension(41, 65));
        this.JP52.setName("52");
        this.JP52.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.18
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP52MouseClicked(evt);
            }
        });
        this.JP52.setLayout((LayoutManager) null);
        this.JLArriba1_52.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_52.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_52.setName("1");
        this.JLArriba1_52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLArriba1_52);
        this.JLArriba1_52.setBounds(0, 0, 40, 65);
        this.JLArriba2_52.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_52.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_52.setName("2");
        this.JLArriba2_52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLArriba2_52);
        this.JLArriba2_52.setBounds(0, 0, 40, 65);
        this.JLCentro52.setMaximumSize(new Dimension(41, 65));
        this.JLCentro52.setMinimumSize(new Dimension(41, 65));
        this.JLCentro52.setName("4");
        this.JLCentro52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLCentro52);
        this.JLCentro52.setBounds(0, 0, 40, 65);
        this.JLDerecha52.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha52.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha52.setName("3");
        this.JLDerecha52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLDerecha52);
        this.JLDerecha52.setBounds(0, 0, 40, 65);
        this.JLIzquierda52.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda52.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda52.setName("5");
        this.JLIzquierda52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLIzquierda52);
        this.JLIzquierda52.setBounds(0, 0, 40, 65);
        this.JLAbajo1_52.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_52.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_52.setName("7");
        this.JLAbajo1_52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLAbajo1_52);
        this.JLAbajo1_52.setBounds(0, 0, 40, 65);
        this.JLAbajo2_52.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_52.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_52.setName("6");
        this.JLAbajo2_52.setPreferredSize(new Dimension(41, 65));
        this.JP52.add(this.JLAbajo2_52);
        this.JLAbajo2_52.setBounds(0, 0, 40, 65);
        this.JLCompleto52.setName("8");
        this.JP52.add(this.JLCompleto52);
        this.JLCompleto52.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco52.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco52.setName("0");
        this.JP52.add(this.JLDienteBlanco52);
        this.JLDienteBlanco52.setBounds(0, 0, 40, 65);
        this.JP53.setBorder(BorderFactory.createEtchedBorder());
        this.JP53.setMaximumSize(new Dimension(41, 65));
        this.JP53.setMinimumSize(new Dimension(41, 65));
        this.JP53.setName("53");
        this.JP53.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.19
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP53MouseClicked(evt);
            }
        });
        this.JP53.setLayout((LayoutManager) null);
        this.JLArriba1_53.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_53.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_53.setName("1");
        this.JLArriba1_53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLArriba1_53);
        this.JLArriba1_53.setBounds(0, 0, 40, 65);
        this.JLArriba2_53.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_53.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_53.setName("2");
        this.JLArriba2_53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLArriba2_53);
        this.JLArriba2_53.setBounds(0, 0, 40, 65);
        this.JLCentro53.setMaximumSize(new Dimension(41, 65));
        this.JLCentro53.setMinimumSize(new Dimension(41, 65));
        this.JLCentro53.setName("4");
        this.JLCentro53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLCentro53);
        this.JLCentro53.setBounds(0, 0, 40, 65);
        this.JLDerecha53.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha53.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha53.setName("3");
        this.JLDerecha53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLDerecha53);
        this.JLDerecha53.setBounds(0, 0, 40, 65);
        this.JLIzquierda53.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda53.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda53.setName("5");
        this.JLIzquierda53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLIzquierda53);
        this.JLIzquierda53.setBounds(0, 0, 40, 65);
        this.JLAbajo1_53.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_53.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_53.setName("7");
        this.JLAbajo1_53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLAbajo1_53);
        this.JLAbajo1_53.setBounds(0, 0, 40, 65);
        this.JLAbajo2_53.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_53.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_53.setName("6");
        this.JLAbajo2_53.setPreferredSize(new Dimension(41, 65));
        this.JP53.add(this.JLAbajo2_53);
        this.JLAbajo2_53.setBounds(0, 0, 40, 65);
        this.JLCompleto53.setName("8");
        this.JP53.add(this.JLCompleto53);
        this.JLCompleto53.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco53.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco53.setName("0");
        this.JP53.add(this.JLDienteBlanco53);
        this.JLDienteBlanco53.setBounds(0, 0, 40, 65);
        this.JP54.setBorder(BorderFactory.createEtchedBorder());
        this.JP54.setMaximumSize(new Dimension(41, 65));
        this.JP54.setMinimumSize(new Dimension(41, 65));
        this.JP54.setName("54");
        this.JP54.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.20
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP54MouseClicked(evt);
            }
        });
        this.JP54.setLayout((LayoutManager) null);
        this.JLArriba1_54.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_54.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_54.setName("1");
        this.JLArriba1_54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLArriba1_54);
        this.JLArriba1_54.setBounds(0, 0, 40, 65);
        this.JLArriba2_54.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_54.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_54.setName("2");
        this.JLArriba2_54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLArriba2_54);
        this.JLArriba2_54.setBounds(0, 0, 40, 65);
        this.JLCentro54.setMaximumSize(new Dimension(41, 65));
        this.JLCentro54.setMinimumSize(new Dimension(41, 65));
        this.JLCentro54.setName("4");
        this.JLCentro54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLCentro54);
        this.JLCentro54.setBounds(0, 0, 40, 65);
        this.JLDerecha54.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha54.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha54.setName("3");
        this.JLDerecha54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLDerecha54);
        this.JLDerecha54.setBounds(0, 0, 40, 65);
        this.JLIzquierda54.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda54.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda54.setName("5");
        this.JLIzquierda54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLIzquierda54);
        this.JLIzquierda54.setBounds(0, 0, 40, 65);
        this.JLAbajo1_54.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_54.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_54.setName("7");
        this.JLAbajo1_54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLAbajo1_54);
        this.JLAbajo1_54.setBounds(0, 0, 40, 65);
        this.JLAbajo2_54.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_54.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_54.setName("6");
        this.JLAbajo2_54.setPreferredSize(new Dimension(41, 65));
        this.JP54.add(this.JLAbajo2_54);
        this.JLAbajo2_54.setBounds(0, 0, 40, 65);
        this.JLCompleto54.setName("8");
        this.JP54.add(this.JLCompleto54);
        this.JLCompleto54.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco54.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco54.setName("0");
        this.JP54.add(this.JLDienteBlanco54);
        this.JLDienteBlanco54.setBounds(0, 0, 40, 65);
        this.JP55.setBorder(BorderFactory.createEtchedBorder());
        this.JP55.setMaximumSize(new Dimension(41, 65));
        this.JP55.setMinimumSize(new Dimension(41, 65));
        this.JP55.setName("55");
        this.JP55.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.21
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP55MouseClicked(evt);
            }
        });
        this.JP55.setLayout((LayoutManager) null);
        this.JLArriba1_55.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_55.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_55.setName("1");
        this.JLArriba1_55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLArriba1_55);
        this.JLArriba1_55.setBounds(0, 0, 40, 65);
        this.JLArriba2_55.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_55.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_55.setName("2");
        this.JLArriba2_55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLArriba2_55);
        this.JLArriba2_55.setBounds(0, 0, 40, 65);
        this.JLCentro55.setMaximumSize(new Dimension(41, 65));
        this.JLCentro55.setMinimumSize(new Dimension(41, 65));
        this.JLCentro55.setName("4");
        this.JLCentro55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLCentro55);
        this.JLCentro55.setBounds(0, 0, 40, 65);
        this.JLDerecha55.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha55.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha55.setName("3");
        this.JLDerecha55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLDerecha55);
        this.JLDerecha55.setBounds(0, 0, 40, 65);
        this.JLIzquierda55.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda55.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda55.setName("5");
        this.JLIzquierda55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLIzquierda55);
        this.JLIzquierda55.setBounds(0, 0, 40, 65);
        this.JLAbajo1_55.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_55.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_55.setName("7");
        this.JLAbajo1_55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLAbajo1_55);
        this.JLAbajo1_55.setBounds(0, 0, 40, 65);
        this.JLAbajo2_55.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_55.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_55.setName("6");
        this.JLAbajo2_55.setPreferredSize(new Dimension(41, 65));
        this.JP55.add(this.JLAbajo2_55);
        this.JLAbajo2_55.setBounds(0, 0, 40, 65);
        this.JLCompleto55.setName("8");
        this.JP55.add(this.JLCompleto55);
        this.JLCompleto55.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco55.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco55.setName("0");
        this.JP55.add(this.JLDienteBlanco55);
        this.JLDienteBlanco55.setBounds(0, 0, 40, 65);
        this.JP61.setBorder(BorderFactory.createEtchedBorder());
        this.JP61.setMaximumSize(new Dimension(41, 65));
        this.JP61.setMinimumSize(new Dimension(41, 65));
        this.JP61.setName("61");
        this.JP61.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.22
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP61MouseClicked(evt);
            }
        });
        this.JP61.setLayout((LayoutManager) null);
        this.JLArriba1_61.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_61.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_61.setName("1");
        this.JLArriba1_61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLArriba1_61);
        this.JLArriba1_61.setBounds(0, 0, 40, 65);
        this.JLArriba2_61.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_61.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_61.setName("2");
        this.JLArriba2_61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLArriba2_61);
        this.JLArriba2_61.setBounds(0, 0, 40, 65);
        this.JLCentro61.setMaximumSize(new Dimension(41, 65));
        this.JLCentro61.setMinimumSize(new Dimension(41, 65));
        this.JLCentro61.setName("4");
        this.JLCentro61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLCentro61);
        this.JLCentro61.setBounds(0, 0, 40, 65);
        this.JLDerecha61.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha61.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha61.setName("3");
        this.JLDerecha61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLDerecha61);
        this.JLDerecha61.setBounds(0, 0, 40, 65);
        this.JLIzquierda61.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda61.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda61.setName("5");
        this.JLIzquierda61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLIzquierda61);
        this.JLIzquierda61.setBounds(0, 0, 40, 65);
        this.JLAbajo1_61.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_61.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_61.setName("7");
        this.JLAbajo1_61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLAbajo1_61);
        this.JLAbajo1_61.setBounds(0, 0, 40, 65);
        this.JLAbajo2_61.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_61.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_61.setName("6");
        this.JLAbajo2_61.setPreferredSize(new Dimension(41, 65));
        this.JP61.add(this.JLAbajo2_61);
        this.JLAbajo2_61.setBounds(0, 0, 40, 65);
        this.JLCompleto61.setName("8");
        this.JP61.add(this.JLCompleto61);
        this.JLCompleto61.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco61.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco61.setName("0");
        this.JP61.add(this.JLDienteBlanco61);
        this.JLDienteBlanco61.setBounds(0, 0, 40, 65);
        this.JP62.setBorder(BorderFactory.createEtchedBorder());
        this.JP62.setMaximumSize(new Dimension(41, 65));
        this.JP62.setMinimumSize(new Dimension(41, 65));
        this.JP62.setName("62");
        this.JP62.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.23
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP62MouseClicked(evt);
            }
        });
        this.JP62.setLayout((LayoutManager) null);
        this.JLArriba1_62.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_62.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_62.setName("1");
        this.JLArriba1_62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLArriba1_62);
        this.JLArriba1_62.setBounds(0, 0, 40, 65);
        this.JLArriba2_62.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_62.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_62.setName("2");
        this.JLArriba2_62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLArriba2_62);
        this.JLArriba2_62.setBounds(0, 0, 40, 65);
        this.JLCentro62.setMaximumSize(new Dimension(41, 65));
        this.JLCentro62.setMinimumSize(new Dimension(41, 65));
        this.JLCentro62.setName("4");
        this.JLCentro62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLCentro62);
        this.JLCentro62.setBounds(0, 0, 40, 65);
        this.JLDerecha62.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha62.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha62.setName("3");
        this.JLDerecha62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLDerecha62);
        this.JLDerecha62.setBounds(0, 0, 40, 65);
        this.JLIzquierda62.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda62.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda62.setName("5");
        this.JLIzquierda62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLIzquierda62);
        this.JLIzquierda62.setBounds(0, 0, 40, 65);
        this.JLAbajo1_62.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_62.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_62.setName("7");
        this.JLAbajo1_62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLAbajo1_62);
        this.JLAbajo1_62.setBounds(0, 0, 40, 65);
        this.JLAbajo2_62.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_62.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_62.setName("6");
        this.JLAbajo2_62.setPreferredSize(new Dimension(41, 65));
        this.JP62.add(this.JLAbajo2_62);
        this.JLAbajo2_62.setBounds(0, 0, 40, 65);
        this.JLCompleto62.setName("8");
        this.JP62.add(this.JLCompleto62);
        this.JLCompleto62.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco62.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco62.setName("0");
        this.JP62.add(this.JLDienteBlanco62);
        this.JLDienteBlanco62.setBounds(0, 0, 40, 65);
        this.JP63.setBorder(BorderFactory.createEtchedBorder());
        this.JP63.setMaximumSize(new Dimension(41, 65));
        this.JP63.setMinimumSize(new Dimension(41, 65));
        this.JP63.setName("63");
        this.JP63.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.24
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP63MouseClicked(evt);
            }
        });
        this.JP63.setLayout((LayoutManager) null);
        this.JLArriba1_63.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_63.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_63.setName("1");
        this.JLArriba1_63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLArriba1_63);
        this.JLArriba1_63.setBounds(0, 0, 40, 65);
        this.JLArriba2_63.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_63.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_63.setName("2");
        this.JLArriba2_63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLArriba2_63);
        this.JLArriba2_63.setBounds(0, 0, 40, 65);
        this.JLCentro63.setMaximumSize(new Dimension(41, 65));
        this.JLCentro63.setMinimumSize(new Dimension(41, 65));
        this.JLCentro63.setName("4");
        this.JLCentro63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLCentro63);
        this.JLCentro63.setBounds(0, 0, 40, 65);
        this.JLDerecha63.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha63.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha63.setName("3");
        this.JLDerecha63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLDerecha63);
        this.JLDerecha63.setBounds(0, 0, 40, 65);
        this.JLIzquierda63.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda63.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda63.setName("5");
        this.JLIzquierda63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLIzquierda63);
        this.JLIzquierda63.setBounds(0, 0, 40, 65);
        this.JLAbajo1_63.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_63.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_63.setName("7");
        this.JLAbajo1_63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLAbajo1_63);
        this.JLAbajo1_63.setBounds(0, 0, 40, 65);
        this.JLAbajo2_63.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_63.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_63.setName("6");
        this.JLAbajo2_63.setPreferredSize(new Dimension(41, 65));
        this.JP63.add(this.JLAbajo2_63);
        this.JLAbajo2_63.setBounds(0, 0, 40, 65);
        this.JLCompleto63.setName("8");
        this.JP63.add(this.JLCompleto63);
        this.JLCompleto63.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco63.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco63.setName("0");
        this.JP63.add(this.JLDienteBlanco63);
        this.JLDienteBlanco63.setBounds(0, 0, 40, 65);
        this.JP64.setBorder(BorderFactory.createEtchedBorder());
        this.JP64.setMaximumSize(new Dimension(41, 65));
        this.JP64.setMinimumSize(new Dimension(41, 65));
        this.JP64.setName("64");
        this.JP64.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.25
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP64MouseClicked(evt);
            }
        });
        this.JP64.setLayout((LayoutManager) null);
        this.JLArriba1_64.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_64.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_64.setName("1");
        this.JLArriba1_64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLArriba1_64);
        this.JLArriba1_64.setBounds(0, 0, 40, 65);
        this.JLArriba2_64.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_64.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_64.setName("2");
        this.JLArriba2_64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLArriba2_64);
        this.JLArriba2_64.setBounds(0, 0, 40, 65);
        this.JLCentro64.setMaximumSize(new Dimension(41, 65));
        this.JLCentro64.setMinimumSize(new Dimension(41, 65));
        this.JLCentro64.setName("4");
        this.JLCentro64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLCentro64);
        this.JLCentro64.setBounds(0, 0, 40, 65);
        this.JLDerecha64.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha64.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha64.setName("3");
        this.JLDerecha64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLDerecha64);
        this.JLDerecha64.setBounds(0, 0, 40, 65);
        this.JLIzquierda64.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda64.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda64.setName("5");
        this.JLIzquierda64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLIzquierda64);
        this.JLIzquierda64.setBounds(0, 0, 40, 65);
        this.JLAbajo1_64.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_64.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_64.setName("7");
        this.JLAbajo1_64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLAbajo1_64);
        this.JLAbajo1_64.setBounds(0, 0, 40, 65);
        this.JLAbajo2_64.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_64.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_64.setName("6");
        this.JLAbajo2_64.setPreferredSize(new Dimension(41, 65));
        this.JP64.add(this.JLAbajo2_64);
        this.JLAbajo2_64.setBounds(0, 0, 40, 65);
        this.JLCompleto64.setName("8");
        this.JP64.add(this.JLCompleto64);
        this.JLCompleto64.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco64.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco64.setName("0");
        this.JP64.add(this.JLDienteBlanco64);
        this.JLDienteBlanco64.setBounds(0, 0, 40, 65);
        this.JP65.setBorder(BorderFactory.createEtchedBorder());
        this.JP65.setMaximumSize(new Dimension(41, 65));
        this.JP65.setMinimumSize(new Dimension(41, 65));
        this.JP65.setName("65");
        this.JP65.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.26
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP65MouseClicked(evt);
            }
        });
        this.JP65.setLayout((LayoutManager) null);
        this.JLArriba1_65.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_65.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_65.setName("1");
        this.JLArriba1_65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLArriba1_65);
        this.JLArriba1_65.setBounds(0, 0, 40, 65);
        this.JLArriba2_65.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_65.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_65.setName("2");
        this.JLArriba2_65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLArriba2_65);
        this.JLArriba2_65.setBounds(0, 0, 40, 65);
        this.JLCentro65.setMaximumSize(new Dimension(41, 65));
        this.JLCentro65.setMinimumSize(new Dimension(41, 65));
        this.JLCentro65.setName("4");
        this.JLCentro65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLCentro65);
        this.JLCentro65.setBounds(0, 0, 40, 65);
        this.JLDerecha65.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha65.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha65.setName("3");
        this.JLDerecha65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLDerecha65);
        this.JLDerecha65.setBounds(0, 0, 40, 65);
        this.JLIzquierda65.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda65.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda65.setName("5");
        this.JLIzquierda65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLIzquierda65);
        this.JLIzquierda65.setBounds(0, 0, 40, 65);
        this.JLAbajo1_65.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_65.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_65.setName("7");
        this.JLAbajo1_65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLAbajo1_65);
        this.JLAbajo1_65.setBounds(0, 0, 40, 65);
        this.JLAbajo2_65.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_65.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_65.setName("6");
        this.JLAbajo2_65.setPreferredSize(new Dimension(41, 65));
        this.JP65.add(this.JLAbajo2_65);
        this.JLAbajo2_65.setBounds(0, 0, 40, 65);
        this.JLCompleto65.setName("8");
        this.JP65.add(this.JLCompleto65);
        this.JLCompleto65.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco65.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco65.setName("0");
        this.JP65.add(this.JLDienteBlanco65);
        this.JLDienteBlanco65.setBounds(0, 0, 40, 65);
        this.JP75.setBorder(BorderFactory.createEtchedBorder());
        this.JP75.setMaximumSize(new Dimension(41, 65));
        this.JP75.setMinimumSize(new Dimension(41, 65));
        this.JP75.setName("75");
        this.JP75.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.27
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP75MouseClicked(evt);
            }
        });
        this.JP75.setLayout((LayoutManager) null);
        this.JLArriba1_75.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_75.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_75.setName("1");
        this.JLArriba1_75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLArriba1_75);
        this.JLArriba1_75.setBounds(0, 0, 40, 65);
        this.JLArriba2_75.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_75.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_75.setName("2");
        this.JLArriba2_75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLArriba2_75);
        this.JLArriba2_75.setBounds(0, 0, 40, 65);
        this.JLCentro75.setMaximumSize(new Dimension(41, 65));
        this.JLCentro75.setMinimumSize(new Dimension(41, 65));
        this.JLCentro75.setName("4");
        this.JLCentro75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLCentro75);
        this.JLCentro75.setBounds(0, 0, 40, 65);
        this.JLDerecha75.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha75.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha75.setName("3");
        this.JLDerecha75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLDerecha75);
        this.JLDerecha75.setBounds(0, 0, 40, 65);
        this.JLIzquierda75.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda75.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda75.setName("5");
        this.JLIzquierda75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLIzquierda75);
        this.JLIzquierda75.setBounds(0, 0, 40, 65);
        this.JLAbajo1_75.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_75.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_75.setName("7");
        this.JLAbajo1_75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLAbajo1_75);
        this.JLAbajo1_75.setBounds(0, 0, 40, 65);
        this.JLAbajo2_75.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_75.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_75.setName("6");
        this.JLAbajo2_75.setPreferredSize(new Dimension(41, 65));
        this.JP75.add(this.JLAbajo2_75);
        this.JLAbajo2_75.setBounds(0, 0, 40, 65);
        this.JLCompleto75.setName("8");
        this.JP75.add(this.JLCompleto75);
        this.JLCompleto75.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco75.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco75.setName("0");
        this.JP75.add(this.JLDienteBlanco75);
        this.JLDienteBlanco75.setBounds(0, 0, 40, 65);
        this.JP74.setBorder(BorderFactory.createEtchedBorder());
        this.JP74.setMaximumSize(new Dimension(41, 65));
        this.JP74.setMinimumSize(new Dimension(41, 65));
        this.JP74.setName("74");
        this.JP74.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.28
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP74MouseClicked(evt);
            }
        });
        this.JP74.setLayout((LayoutManager) null);
        this.JLArriba1_74.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_74.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_74.setName("1");
        this.JLArriba1_74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLArriba1_74);
        this.JLArriba1_74.setBounds(0, 0, 40, 65);
        this.JLArriba2_74.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_74.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_74.setName("2");
        this.JLArriba2_74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLArriba2_74);
        this.JLArriba2_74.setBounds(0, 0, 40, 65);
        this.JLCentro74.setMaximumSize(new Dimension(41, 65));
        this.JLCentro74.setMinimumSize(new Dimension(41, 65));
        this.JLCentro74.setName("4");
        this.JLCentro74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLCentro74);
        this.JLCentro74.setBounds(0, 0, 40, 65);
        this.JLDerecha74.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha74.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha74.setName("3");
        this.JLDerecha74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLDerecha74);
        this.JLDerecha74.setBounds(0, 0, 40, 65);
        this.JLIzquierda74.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda74.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda74.setName("5");
        this.JLIzquierda74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLIzquierda74);
        this.JLIzquierda74.setBounds(0, 0, 40, 65);
        this.JLAbajo1_74.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_74.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_74.setName("7");
        this.JLAbajo1_74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLAbajo1_74);
        this.JLAbajo1_74.setBounds(0, 0, 40, 65);
        this.JLAbajo2_74.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_74.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_74.setName("6");
        this.JLAbajo2_74.setPreferredSize(new Dimension(41, 65));
        this.JP74.add(this.JLAbajo2_74);
        this.JLAbajo2_74.setBounds(0, 0, 40, 65);
        this.JLCompleto74.setName("8");
        this.JP74.add(this.JLCompleto74);
        this.JLCompleto74.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco74.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco74.setName("0");
        this.JP74.add(this.JLDienteBlanco74);
        this.JLDienteBlanco74.setBounds(0, 0, 40, 65);
        this.JP73.setBorder(BorderFactory.createEtchedBorder());
        this.JP73.setMaximumSize(new Dimension(41, 65));
        this.JP73.setMinimumSize(new Dimension(41, 65));
        this.JP73.setName("73");
        this.JP73.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.29
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP73MouseClicked(evt);
            }
        });
        this.JP73.setLayout((LayoutManager) null);
        this.JLArriba1_73.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_73.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_73.setName("1");
        this.JLArriba1_73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLArriba1_73);
        this.JLArriba1_73.setBounds(0, 0, 40, 65);
        this.JLArriba2_73.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_73.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_73.setName("2");
        this.JLArriba2_73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLArriba2_73);
        this.JLArriba2_73.setBounds(0, 0, 40, 65);
        this.JLCentro73.setMaximumSize(new Dimension(41, 65));
        this.JLCentro73.setMinimumSize(new Dimension(41, 65));
        this.JLCentro73.setName("4");
        this.JLCentro73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLCentro73);
        this.JLCentro73.setBounds(0, 0, 40, 65);
        this.JLDerecha73.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha73.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha73.setName("3");
        this.JLDerecha73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLDerecha73);
        this.JLDerecha73.setBounds(0, 0, 40, 65);
        this.JLIzquierda73.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda73.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda73.setName("5");
        this.JLIzquierda73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLIzquierda73);
        this.JLIzquierda73.setBounds(0, 0, 40, 65);
        this.JLAbajo1_73.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_73.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_73.setName("7");
        this.JLAbajo1_73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLAbajo1_73);
        this.JLAbajo1_73.setBounds(0, 0, 40, 65);
        this.JLAbajo2_73.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_73.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_73.setName("6");
        this.JLAbajo2_73.setPreferredSize(new Dimension(41, 65));
        this.JP73.add(this.JLAbajo2_73);
        this.JLAbajo2_73.setBounds(0, 0, 40, 65);
        this.JLCompleto73.setName("8");
        this.JP73.add(this.JLCompleto73);
        this.JLCompleto73.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco73.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco73.setName("0");
        this.JP73.add(this.JLDienteBlanco73);
        this.JLDienteBlanco73.setBounds(0, 0, 40, 65);
        this.JP72.setBorder(BorderFactory.createEtchedBorder());
        this.JP72.setMaximumSize(new Dimension(41, 65));
        this.JP72.setMinimumSize(new Dimension(41, 65));
        this.JP72.setName("72");
        this.JP72.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.30
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP72MouseClicked(evt);
            }
        });
        this.JP72.setLayout((LayoutManager) null);
        this.JLArriba1_72.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_72.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_72.setName("1");
        this.JLArriba1_72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLArriba1_72);
        this.JLArriba1_72.setBounds(0, 0, 40, 65);
        this.JLArriba2_72.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_72.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_72.setName("2");
        this.JLArriba2_72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLArriba2_72);
        this.JLArriba2_72.setBounds(0, 0, 40, 65);
        this.JLCentro72.setMaximumSize(new Dimension(41, 65));
        this.JLCentro72.setMinimumSize(new Dimension(41, 65));
        this.JLCentro72.setName("4");
        this.JLCentro72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLCentro72);
        this.JLCentro72.setBounds(0, 0, 40, 65);
        this.JLDerecha72.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha72.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha72.setName("3");
        this.JLDerecha72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLDerecha72);
        this.JLDerecha72.setBounds(0, 0, 40, 65);
        this.JLIzquierda72.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda72.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda72.setName("5");
        this.JLIzquierda72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLIzquierda72);
        this.JLIzquierda72.setBounds(0, 0, 40, 65);
        this.JLAbajo1_72.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_72.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_72.setName("7");
        this.JLAbajo1_72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLAbajo1_72);
        this.JLAbajo1_72.setBounds(0, 0, 40, 65);
        this.JLAbajo2_72.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_72.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_72.setName("6");
        this.JLAbajo2_72.setPreferredSize(new Dimension(41, 65));
        this.JP72.add(this.JLAbajo2_72);
        this.JLAbajo2_72.setBounds(0, 0, 40, 65);
        this.JLCompleto72.setName("8");
        this.JP72.add(this.JLCompleto72);
        this.JLCompleto72.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco72.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco72.setName("0");
        this.JP72.add(this.JLDienteBlanco72);
        this.JLDienteBlanco72.setBounds(0, 0, 40, 65);
        this.JP71.setBorder(BorderFactory.createEtchedBorder());
        this.JP71.setMaximumSize(new Dimension(41, 65));
        this.JP71.setMinimumSize(new Dimension(41, 65));
        this.JP71.setName("71");
        this.JP71.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.31
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP71MouseClicked(evt);
            }
        });
        this.JP71.setLayout((LayoutManager) null);
        this.JLArriba1_71.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_71.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_71.setName("1");
        this.JLArriba1_71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLArriba1_71);
        this.JLArriba1_71.setBounds(0, 0, 40, 65);
        this.JLArriba2_71.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_71.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_71.setName("2");
        this.JLArriba2_71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLArriba2_71);
        this.JLArriba2_71.setBounds(0, 0, 40, 65);
        this.JLCentro71.setMaximumSize(new Dimension(41, 65));
        this.JLCentro71.setMinimumSize(new Dimension(41, 65));
        this.JLCentro71.setName("4");
        this.JLCentro71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLCentro71);
        this.JLCentro71.setBounds(0, 0, 40, 65);
        this.JLDerecha71.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha71.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha71.setName("3");
        this.JLDerecha71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLDerecha71);
        this.JLDerecha71.setBounds(0, 0, 40, 65);
        this.JLIzquierda71.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda71.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda71.setName("5");
        this.JLIzquierda71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLIzquierda71);
        this.JLIzquierda71.setBounds(0, 0, 40, 65);
        this.JLAbajo1_71.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_71.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_71.setName("7");
        this.JLAbajo1_71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLAbajo1_71);
        this.JLAbajo1_71.setBounds(0, 0, 40, 65);
        this.JLAbajo2_71.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_71.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_71.setName("6");
        this.JLAbajo2_71.setPreferredSize(new Dimension(41, 65));
        this.JP71.add(this.JLAbajo2_71);
        this.JLAbajo2_71.setBounds(0, 0, 40, 65);
        this.JLCompleto71.setName("8");
        this.JP71.add(this.JLCompleto71);
        this.JLCompleto71.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco70.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco70.setName("0");
        this.JP71.add(this.JLDienteBlanco70);
        this.JLDienteBlanco70.setBounds(0, 0, 40, 65);
        this.JP85.setBorder(BorderFactory.createEtchedBorder());
        this.JP85.setMaximumSize(new Dimension(41, 65));
        this.JP85.setMinimumSize(new Dimension(41, 65));
        this.JP85.setName("85");
        this.JP85.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.32
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP85MouseClicked(evt);
            }
        });
        this.JP85.setLayout((LayoutManager) null);
        this.JLArriba1_85.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_85.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_85.setName("1");
        this.JLArriba1_85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLArriba1_85);
        this.JLArriba1_85.setBounds(0, 0, 40, 65);
        this.JLArriba2_85.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_85.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_85.setName("2");
        this.JLArriba2_85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLArriba2_85);
        this.JLArriba2_85.setBounds(0, 0, 40, 65);
        this.JLCentro85.setMaximumSize(new Dimension(41, 65));
        this.JLCentro85.setMinimumSize(new Dimension(41, 65));
        this.JLCentro85.setName("4");
        this.JLCentro85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLCentro85);
        this.JLCentro85.setBounds(0, 0, 40, 65);
        this.JLDerecha85.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha85.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha85.setName("3");
        this.JLDerecha85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLDerecha85);
        this.JLDerecha85.setBounds(0, 0, 40, 65);
        this.JLIzquierda85.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda85.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda85.setName("5");
        this.JLIzquierda85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLIzquierda85);
        this.JLIzquierda85.setBounds(0, 0, 40, 65);
        this.JLAbajo1_85.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_85.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_85.setName("7");
        this.JLAbajo1_85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLAbajo1_85);
        this.JLAbajo1_85.setBounds(0, 0, 40, 65);
        this.JLAbajo2_85.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_85.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_85.setName("6");
        this.JLAbajo2_85.setPreferredSize(new Dimension(41, 65));
        this.JP85.add(this.JLAbajo2_85);
        this.JLAbajo2_85.setBounds(0, 0, 40, 65);
        this.JLCompleto85.setName("8");
        this.JP85.add(this.JLCompleto85);
        this.JLCompleto85.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco85.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco85.setName("0");
        this.JP85.add(this.JLDienteBlanco85);
        this.JLDienteBlanco85.setBounds(0, 0, 40, 65);
        this.JP84.setBorder(BorderFactory.createEtchedBorder());
        this.JP84.setMaximumSize(new Dimension(41, 65));
        this.JP84.setMinimumSize(new Dimension(41, 65));
        this.JP84.setName("84");
        this.JP84.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.33
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP84MouseClicked(evt);
            }
        });
        this.JP84.setLayout((LayoutManager) null);
        this.JLArriba1_84.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_84.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_84.setName("1");
        this.JLArriba1_84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLArriba1_84);
        this.JLArriba1_84.setBounds(0, 0, 40, 65);
        this.JLArriba2_84.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_84.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_84.setName("2");
        this.JLArriba2_84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLArriba2_84);
        this.JLArriba2_84.setBounds(0, 0, 40, 65);
        this.JLCentro84.setMaximumSize(new Dimension(41, 65));
        this.JLCentro84.setMinimumSize(new Dimension(41, 65));
        this.JLCentro84.setName("4");
        this.JLCentro84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLCentro84);
        this.JLCentro84.setBounds(0, 0, 40, 65);
        this.JLDerecha84.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha84.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha84.setName("3");
        this.JLDerecha84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLDerecha84);
        this.JLDerecha84.setBounds(0, 0, 40, 65);
        this.JLIzquierda84.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda84.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda84.setName("5");
        this.JLIzquierda84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLIzquierda84);
        this.JLIzquierda84.setBounds(0, 0, 40, 65);
        this.JLAbajo1_84.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_84.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_84.setName("7");
        this.JLAbajo1_84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLAbajo1_84);
        this.JLAbajo1_84.setBounds(0, 0, 40, 65);
        this.JLAbajo2_84.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_84.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_84.setName("6");
        this.JLAbajo2_84.setPreferredSize(new Dimension(41, 65));
        this.JP84.add(this.JLAbajo2_84);
        this.JLAbajo2_84.setBounds(0, 0, 40, 65);
        this.JLCompleto84.setName("8");
        this.JP84.add(this.JLCompleto84);
        this.JLCompleto84.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco84.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco84.setName("0");
        this.JP84.add(this.JLDienteBlanco84);
        this.JLDienteBlanco84.setBounds(0, 0, 40, 65);
        this.JP83.setBorder(BorderFactory.createEtchedBorder());
        this.JP83.setMaximumSize(new Dimension(41, 65));
        this.JP83.setMinimumSize(new Dimension(41, 65));
        this.JP83.setName("83");
        this.JP83.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.34
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP83MouseClicked(evt);
            }
        });
        this.JP83.setLayout((LayoutManager) null);
        this.JLArriba1_83.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_83.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_83.setName("1");
        this.JLArriba1_83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLArriba1_83);
        this.JLArriba1_83.setBounds(0, 0, 40, 65);
        this.JLArriba2_83.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_83.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_83.setName("2");
        this.JLArriba2_83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLArriba2_83);
        this.JLArriba2_83.setBounds(0, 0, 40, 65);
        this.JLCentro83.setMaximumSize(new Dimension(41, 65));
        this.JLCentro83.setMinimumSize(new Dimension(41, 65));
        this.JLCentro83.setName("4");
        this.JLCentro83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLCentro83);
        this.JLCentro83.setBounds(0, 0, 40, 65);
        this.JLDerecha83.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha83.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha83.setName("3");
        this.JLDerecha83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLDerecha83);
        this.JLDerecha83.setBounds(0, 0, 40, 65);
        this.JLIzquierda83.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda83.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda83.setName("5");
        this.JLIzquierda83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLIzquierda83);
        this.JLIzquierda83.setBounds(0, 0, 40, 65);
        this.JLAbajo1_83.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_83.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_83.setName("7");
        this.JLAbajo1_83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLAbajo1_83);
        this.JLAbajo1_83.setBounds(0, 0, 40, 65);
        this.JLAbajo2_83.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_83.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_83.setName("6");
        this.JLAbajo2_83.setPreferredSize(new Dimension(41, 65));
        this.JP83.add(this.JLAbajo2_83);
        this.JLAbajo2_83.setBounds(0, 0, 40, 65);
        this.JLCompleto83.setName("8");
        this.JP83.add(this.JLCompleto83);
        this.JLCompleto83.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco83.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco83.setName("0");
        this.JP83.add(this.JLDienteBlanco83);
        this.JLDienteBlanco83.setBounds(0, 0, 40, 65);
        this.JP82.setBorder(BorderFactory.createEtchedBorder());
        this.JP82.setMaximumSize(new Dimension(41, 65));
        this.JP82.setMinimumSize(new Dimension(41, 65));
        this.JP82.setName("82");
        this.JP82.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.35
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP82MouseClicked(evt);
            }
        });
        this.JP82.setLayout((LayoutManager) null);
        this.JLArriba1_82.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_82.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_82.setName("1");
        this.JLArriba1_82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLArriba1_82);
        this.JLArriba1_82.setBounds(0, 0, 40, 65);
        this.JLArriba2_82.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_82.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_82.setName("2");
        this.JLArriba2_82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLArriba2_82);
        this.JLArriba2_82.setBounds(0, 0, 40, 65);
        this.JLCentro82.setMaximumSize(new Dimension(41, 65));
        this.JLCentro82.setMinimumSize(new Dimension(41, 65));
        this.JLCentro82.setName("4");
        this.JLCentro82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLCentro82);
        this.JLCentro82.setBounds(0, 0, 40, 65);
        this.JLDerecha82.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha82.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha82.setName("3");
        this.JLDerecha82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLDerecha82);
        this.JLDerecha82.setBounds(0, 0, 40, 65);
        this.JLIzquierda82.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda82.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda82.setName("5");
        this.JLIzquierda82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLIzquierda82);
        this.JLIzquierda82.setBounds(0, 0, 40, 65);
        this.JLAbajo1_82.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_82.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_82.setName("7");
        this.JLAbajo1_82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLAbajo1_82);
        this.JLAbajo1_82.setBounds(0, 0, 40, 65);
        this.JLAbajo2_82.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_82.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_82.setName("6");
        this.JLAbajo2_82.setPreferredSize(new Dimension(41, 65));
        this.JP82.add(this.JLAbajo2_82);
        this.JLAbajo2_82.setBounds(0, 0, 40, 65);
        this.JLCompleto82.setName("8");
        this.JP82.add(this.JLCompleto82);
        this.JLCompleto82.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco82.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco82.setName("0");
        this.JP82.add(this.JLDienteBlanco82);
        this.JLDienteBlanco82.setBounds(0, 0, 40, 65);
        this.JP81.setBorder(BorderFactory.createEtchedBorder());
        this.JP81.setMaximumSize(new Dimension(41, 65));
        this.JP81.setMinimumSize(new Dimension(41, 65));
        this.JP81.setName("81");
        this.JP81.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.36
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP81MouseClicked(evt);
            }
        });
        this.JP81.setLayout((LayoutManager) null);
        this.JLArriba1_81.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_81.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_81.setName("1");
        this.JLArriba1_81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLArriba1_81);
        this.JLArriba1_81.setBounds(0, 0, 40, 65);
        this.JLArriba2_81.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_81.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_81.setName("2");
        this.JLArriba2_81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLArriba2_81);
        this.JLArriba2_81.setBounds(0, 0, 40, 65);
        this.JLCentro81.setMaximumSize(new Dimension(41, 65));
        this.JLCentro81.setMinimumSize(new Dimension(41, 65));
        this.JLCentro81.setName("4");
        this.JLCentro81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLCentro81);
        this.JLCentro81.setBounds(0, 0, 40, 65);
        this.JLDerecha81.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha81.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha81.setName("3");
        this.JLDerecha81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLDerecha81);
        this.JLDerecha81.setBounds(0, 0, 40, 65);
        this.JLIzquierda81.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda81.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda81.setName("5");
        this.JLIzquierda81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLIzquierda81);
        this.JLIzquierda81.setBounds(0, 0, 40, 65);
        this.JLAbajo1_81.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_81.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_81.setName("7");
        this.JLAbajo1_81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLAbajo1_81);
        this.JLAbajo1_81.setBounds(0, 0, 40, 65);
        this.JLAbajo2_81.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_81.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_81.setName("6");
        this.JLAbajo2_81.setPreferredSize(new Dimension(41, 65));
        this.JP81.add(this.JLAbajo2_81);
        this.JLAbajo2_81.setBounds(0, 0, 40, 65);
        this.JLCompleto81.setName("8");
        this.JP81.add(this.JLCompleto81);
        this.JLCompleto81.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco81.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco81.setName("0");
        this.JP81.add(this.JLDienteBlanco81);
        this.JLDienteBlanco81.setBounds(0, 0, 40, 65);
        this.JP48.setBorder(BorderFactory.createEtchedBorder());
        this.JP48.setMaximumSize(new Dimension(41, 65));
        this.JP48.setMinimumSize(new Dimension(41, 65));
        this.JP48.setName("48");
        this.JP48.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.37
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP48MouseClicked(evt);
            }
        });
        this.JP48.setLayout((LayoutManager) null);
        this.JLArriba1_48.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_48.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_48.setName("1");
        this.JLArriba1_48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLArriba1_48);
        this.JLArriba1_48.setBounds(0, 0, 40, 65);
        this.JLArriba2_48.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_48.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_48.setName("2");
        this.JLArriba2_48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLArriba2_48);
        this.JLArriba2_48.setBounds(0, 0, 40, 65);
        this.JLCentro48.setMaximumSize(new Dimension(41, 65));
        this.JLCentro48.setMinimumSize(new Dimension(41, 65));
        this.JLCentro48.setName("4");
        this.JLCentro48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLCentro48);
        this.JLCentro48.setBounds(0, 0, 40, 65);
        this.JLDerecha48.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha48.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha48.setName("3");
        this.JLDerecha48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLDerecha48);
        this.JLDerecha48.setBounds(0, 0, 40, 65);
        this.JLIzquierda48.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda48.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda48.setName("5");
        this.JLIzquierda48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLIzquierda48);
        this.JLIzquierda48.setBounds(0, 0, 40, 65);
        this.JLAbajo1_48.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_48.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_48.setName("7");
        this.JLAbajo1_48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLAbajo1_48);
        this.JLAbajo1_48.setBounds(0, 0, 40, 65);
        this.JLAbajo2_48.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_48.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_48.setName("6");
        this.JLAbajo2_48.setPreferredSize(new Dimension(41, 65));
        this.JP48.add(this.JLAbajo2_48);
        this.JLAbajo2_48.setBounds(0, 0, 40, 65);
        this.JLCompleto48.setName("8");
        this.JP48.add(this.JLCompleto48);
        this.JLCompleto48.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco48.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco48.setName("0");
        this.JP48.add(this.JLDienteBlanco48);
        this.JLDienteBlanco48.setBounds(0, 0, 40, 65);
        this.JP47.setBorder(BorderFactory.createEtchedBorder());
        this.JP47.setMaximumSize(new Dimension(41, 65));
        this.JP47.setMinimumSize(new Dimension(41, 65));
        this.JP47.setName("47");
        this.JP47.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.38
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP47MouseClicked(evt);
            }
        });
        this.JP47.setLayout((LayoutManager) null);
        this.JLArriba1_47.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_47.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_47.setName("1");
        this.JLArriba1_47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLArriba1_47);
        this.JLArriba1_47.setBounds(0, 0, 40, 65);
        this.JLArriba2_47.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_47.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_47.setName("2");
        this.JLArriba2_47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLArriba2_47);
        this.JLArriba2_47.setBounds(0, 0, 40, 65);
        this.JLCentro47.setMaximumSize(new Dimension(41, 65));
        this.JLCentro47.setMinimumSize(new Dimension(41, 65));
        this.JLCentro47.setName("4");
        this.JLCentro47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLCentro47);
        this.JLCentro47.setBounds(0, 0, 40, 65);
        this.JLDerecha47.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha47.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha47.setName("3");
        this.JLDerecha47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLDerecha47);
        this.JLDerecha47.setBounds(0, 0, 40, 65);
        this.JLIzquierda47.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda47.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda47.setName("5");
        this.JLIzquierda47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLIzquierda47);
        this.JLIzquierda47.setBounds(0, 0, 40, 65);
        this.JLAbajo1_47.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_47.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_47.setName("7");
        this.JLAbajo1_47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLAbajo1_47);
        this.JLAbajo1_47.setBounds(0, 0, 40, 65);
        this.JLAbajo2_47.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_47.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_47.setName("6");
        this.JLAbajo2_47.setPreferredSize(new Dimension(41, 65));
        this.JP47.add(this.JLAbajo2_47);
        this.JLAbajo2_47.setBounds(0, 0, 40, 65);
        this.JLCompleto47.setName("8");
        this.JP47.add(this.JLCompleto47);
        this.JLCompleto47.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco47.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco47.setName("0");
        this.JP47.add(this.JLDienteBlanco47);
        this.JLDienteBlanco47.setBounds(0, 0, 40, 65);
        this.JP46.setBorder(BorderFactory.createEtchedBorder());
        this.JP46.setMaximumSize(new Dimension(41, 65));
        this.JP46.setMinimumSize(new Dimension(41, 65));
        this.JP46.setName("46");
        this.JP46.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.39
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP46MouseClicked(evt);
            }
        });
        this.JP46.setLayout((LayoutManager) null);
        this.JLArriba1_46.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_46.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_46.setName("1");
        this.JLArriba1_46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLArriba1_46);
        this.JLArriba1_46.setBounds(0, 0, 40, 65);
        this.JLArriba2_46.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_46.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_46.setName("2");
        this.JLArriba2_46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLArriba2_46);
        this.JLArriba2_46.setBounds(0, 0, 40, 65);
        this.JLCentro46.setMaximumSize(new Dimension(41, 65));
        this.JLCentro46.setMinimumSize(new Dimension(41, 65));
        this.JLCentro46.setName("4");
        this.JLCentro46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLCentro46);
        this.JLCentro46.setBounds(0, 0, 40, 65);
        this.JLDerecha46.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha46.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha46.setName("3");
        this.JLDerecha46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLDerecha46);
        this.JLDerecha46.setBounds(0, 0, 40, 65);
        this.JLIzquierda46.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda46.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda46.setName("5");
        this.JLIzquierda46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLIzquierda46);
        this.JLIzquierda46.setBounds(0, 0, 40, 65);
        this.JLAbajo1_46.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_46.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_46.setName("7");
        this.JLAbajo1_46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLAbajo1_46);
        this.JLAbajo1_46.setBounds(0, 0, 40, 65);
        this.JLAbajo2_46.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_46.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_46.setName("6");
        this.JLAbajo2_46.setPreferredSize(new Dimension(41, 65));
        this.JP46.add(this.JLAbajo2_46);
        this.JLAbajo2_46.setBounds(0, 0, 40, 65);
        this.JLCompleto46.setName("8");
        this.JP46.add(this.JLCompleto46);
        this.JLCompleto46.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco46.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco46.setName("0");
        this.JP46.add(this.JLDienteBlanco46);
        this.JLDienteBlanco46.setBounds(0, 0, 40, 65);
        this.JP45.setBorder(BorderFactory.createEtchedBorder());
        this.JP45.setMaximumSize(new Dimension(41, 65));
        this.JP45.setMinimumSize(new Dimension(41, 65));
        this.JP45.setName("45");
        this.JP45.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.40
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP45MouseClicked(evt);
            }
        });
        this.JP45.setLayout((LayoutManager) null);
        this.JLArriba1_45.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_45.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_45.setName("1");
        this.JLArriba1_45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLArriba1_45);
        this.JLArriba1_45.setBounds(0, 0, 40, 65);
        this.JLArriba2_45.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_45.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_45.setName("2");
        this.JLArriba2_45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLArriba2_45);
        this.JLArriba2_45.setBounds(0, 0, 40, 65);
        this.JLCentro45.setMaximumSize(new Dimension(41, 65));
        this.JLCentro45.setMinimumSize(new Dimension(41, 65));
        this.JLCentro45.setName("4");
        this.JLCentro45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLCentro45);
        this.JLCentro45.setBounds(0, 0, 40, 65);
        this.JLDerecha45.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha45.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha45.setName("3");
        this.JLDerecha45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLDerecha45);
        this.JLDerecha45.setBounds(0, 0, 40, 65);
        this.JLIzquierda45.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda45.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda45.setName("5");
        this.JLIzquierda45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLIzquierda45);
        this.JLIzquierda45.setBounds(0, 0, 40, 65);
        this.JLAbajo1_45.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_45.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_45.setName("7");
        this.JLAbajo1_45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLAbajo1_45);
        this.JLAbajo1_45.setBounds(0, 0, 40, 65);
        this.JLAbajo2_45.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_45.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_45.setName("6");
        this.JLAbajo2_45.setPreferredSize(new Dimension(41, 65));
        this.JP45.add(this.JLAbajo2_45);
        this.JLAbajo2_45.setBounds(0, 0, 40, 65);
        this.JLCompleto45.setName("8");
        this.JP45.add(this.JLCompleto45);
        this.JLCompleto45.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco45.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco45.setName("0");
        this.JP45.add(this.JLDienteBlanco45);
        this.JLDienteBlanco45.setBounds(0, 0, 40, 65);
        this.JP44.setBorder(BorderFactory.createEtchedBorder());
        this.JP44.setMaximumSize(new Dimension(41, 65));
        this.JP44.setMinimumSize(new Dimension(41, 65));
        this.JP44.setName("44");
        this.JP44.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.41
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP44MouseClicked(evt);
            }
        });
        this.JP44.setLayout((LayoutManager) null);
        this.JLArriba1_44.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_44.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_44.setName("1");
        this.JLArriba1_44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLArriba1_44);
        this.JLArriba1_44.setBounds(0, 0, 40, 65);
        this.JLArriba2_44.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_44.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_44.setName("2");
        this.JLArriba2_44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLArriba2_44);
        this.JLArriba2_44.setBounds(0, 0, 40, 65);
        this.JLCentro44.setMaximumSize(new Dimension(41, 65));
        this.JLCentro44.setMinimumSize(new Dimension(41, 65));
        this.JLCentro44.setName("4");
        this.JLCentro44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLCentro44);
        this.JLCentro44.setBounds(0, 0, 40, 65);
        this.JLDerecha44.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha44.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha44.setName("3");
        this.JLDerecha44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLDerecha44);
        this.JLDerecha44.setBounds(0, 0, 40, 65);
        this.JLIzquierda44.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda44.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda44.setName("5");
        this.JLIzquierda44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLIzquierda44);
        this.JLIzquierda44.setBounds(0, 0, 40, 65);
        this.JLAbajo1_44.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_44.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_44.setName("7");
        this.JLAbajo1_44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLAbajo1_44);
        this.JLAbajo1_44.setBounds(0, 0, 40, 65);
        this.JLAbajo2_44.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_44.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_44.setName("6");
        this.JLAbajo2_44.setPreferredSize(new Dimension(41, 65));
        this.JP44.add(this.JLAbajo2_44);
        this.JLAbajo2_44.setBounds(0, 0, 40, 65);
        this.JLCompleto44.setName("8");
        this.JP44.add(this.JLCompleto44);
        this.JLCompleto44.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco44.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco44.setName("0");
        this.JP44.add(this.JLDienteBlanco44);
        this.JLDienteBlanco44.setBounds(0, 0, 40, 65);
        this.JP43.setBorder(BorderFactory.createEtchedBorder());
        this.JP43.setMaximumSize(new Dimension(41, 65));
        this.JP43.setMinimumSize(new Dimension(41, 65));
        this.JP43.setName("43");
        this.JP43.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.42
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP43MouseClicked(evt);
            }
        });
        this.JP43.setLayout((LayoutManager) null);
        this.JLArriba1_43.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_43.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_43.setName("1");
        this.JLArriba1_43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLArriba1_43);
        this.JLArriba1_43.setBounds(0, 0, 40, 65);
        this.JLArriba2_43.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_43.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_43.setName("2");
        this.JLArriba2_43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLArriba2_43);
        this.JLArriba2_43.setBounds(0, 0, 40, 65);
        this.JLCentro43.setMaximumSize(new Dimension(41, 65));
        this.JLCentro43.setMinimumSize(new Dimension(41, 65));
        this.JLCentro43.setName("4");
        this.JLCentro43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLCentro43);
        this.JLCentro43.setBounds(0, 0, 40, 65);
        this.JLDerecha43.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha43.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha43.setName("3");
        this.JLDerecha43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLDerecha43);
        this.JLDerecha43.setBounds(0, 0, 40, 65);
        this.JLIzquierda43.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda43.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda43.setName("5");
        this.JLIzquierda43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLIzquierda43);
        this.JLIzquierda43.setBounds(0, 0, 40, 65);
        this.JLAbajo1_43.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_43.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_43.setName("7");
        this.JLAbajo1_43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLAbajo1_43);
        this.JLAbajo1_43.setBounds(0, 0, 40, 65);
        this.JLAbajo2_43.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_43.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_43.setName("6");
        this.JLAbajo2_43.setPreferredSize(new Dimension(41, 65));
        this.JP43.add(this.JLAbajo2_43);
        this.JLAbajo2_43.setBounds(0, 0, 40, 65);
        this.JLCompleto43.setName("8");
        this.JP43.add(this.JLCompleto43);
        this.JLCompleto43.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco43.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco43.setName("0");
        this.JP43.add(this.JLDienteBlanco43);
        this.JLDienteBlanco43.setBounds(0, 0, 40, 65);
        this.JP42.setBorder(BorderFactory.createEtchedBorder());
        this.JP42.setMaximumSize(new Dimension(41, 65));
        this.JP42.setMinimumSize(new Dimension(41, 65));
        this.JP42.setName("42");
        this.JP42.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.43
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP42MouseClicked(evt);
            }
        });
        this.JP42.setLayout((LayoutManager) null);
        this.JLArriba1_42.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_42.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_42.setName("1");
        this.JLArriba1_42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLArriba1_42);
        this.JLArriba1_42.setBounds(0, 0, 40, 65);
        this.JLArriba2_42.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_42.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_42.setName("2");
        this.JLArriba2_42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLArriba2_42);
        this.JLArriba2_42.setBounds(0, 0, 40, 65);
        this.JLCentro42.setMaximumSize(new Dimension(41, 65));
        this.JLCentro42.setMinimumSize(new Dimension(41, 65));
        this.JLCentro42.setName("4");
        this.JLCentro42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLCentro42);
        this.JLCentro42.setBounds(0, 0, 40, 65);
        this.JLDerecha42.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha42.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha42.setName("3");
        this.JLDerecha42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLDerecha42);
        this.JLDerecha42.setBounds(0, 0, 40, 65);
        this.JLIzquierda42.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda42.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda42.setName("5");
        this.JLIzquierda42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLIzquierda42);
        this.JLIzquierda42.setBounds(0, 0, 40, 65);
        this.JLAbajo1_42.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_42.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_42.setName("7");
        this.JLAbajo1_42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLAbajo1_42);
        this.JLAbajo1_42.setBounds(0, 0, 40, 65);
        this.JLAbajo2_42.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_42.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_42.setName("6");
        this.JLAbajo2_42.setPreferredSize(new Dimension(41, 65));
        this.JP42.add(this.JLAbajo2_42);
        this.JLAbajo2_42.setBounds(0, 0, 40, 65);
        this.JLCompleto42.setName("8");
        this.JP42.add(this.JLCompleto42);
        this.JLCompleto42.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco42.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco42.setName("0");
        this.JP42.add(this.JLDienteBlanco42);
        this.JLDienteBlanco42.setBounds(0, 0, 40, 65);
        this.JP41.setBorder(BorderFactory.createEtchedBorder());
        this.JP41.setMaximumSize(new Dimension(41, 65));
        this.JP41.setMinimumSize(new Dimension(41, 65));
        this.JP41.setName("41");
        this.JP41.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.44
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP41MouseClicked(evt);
            }
        });
        this.JP41.setLayout((LayoutManager) null);
        this.JLArriba1_41.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_41.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_41.setName("1");
        this.JLArriba1_41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLArriba1_41);
        this.JLArriba1_41.setBounds(0, 0, 40, 65);
        this.JLArriba2_41.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_41.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_41.setName("2");
        this.JLArriba2_41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLArriba2_41);
        this.JLArriba2_41.setBounds(0, 0, 40, 65);
        this.JLCentro41.setMaximumSize(new Dimension(41, 65));
        this.JLCentro41.setMinimumSize(new Dimension(41, 65));
        this.JLCentro41.setName("4");
        this.JLCentro41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLCentro41);
        this.JLCentro41.setBounds(0, 0, 40, 65);
        this.JLDerecha41.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha41.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha41.setName("3");
        this.JLDerecha41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLDerecha41);
        this.JLDerecha41.setBounds(0, 0, 40, 65);
        this.JLIzquierda41.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda41.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda41.setName("5");
        this.JLIzquierda41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLIzquierda41);
        this.JLIzquierda41.setBounds(0, 0, 40, 65);
        this.JLAbajo1_41.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_41.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_41.setName("7");
        this.JLAbajo1_41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLAbajo1_41);
        this.JLAbajo1_41.setBounds(0, 0, 40, 65);
        this.JLAbajo2_41.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_41.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_41.setName("6");
        this.JLAbajo2_41.setPreferredSize(new Dimension(41, 65));
        this.JP41.add(this.JLAbajo2_41);
        this.JLAbajo2_41.setBounds(0, 0, 40, 65);
        this.JLCompleto41.setName("8");
        this.JP41.add(this.JLCompleto41);
        this.JLCompleto41.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco41.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco41.setName("0");
        this.JP41.add(this.JLDienteBlanco41);
        this.JLDienteBlanco41.setBounds(0, 0, 40, 65);
        this.JP31.setBorder(BorderFactory.createEtchedBorder());
        this.JP31.setMaximumSize(new Dimension(41, 65));
        this.JP31.setMinimumSize(new Dimension(41, 65));
        this.JP31.setName("31");
        this.JP31.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.45
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP31MouseClicked(evt);
            }
        });
        this.JP31.setLayout((LayoutManager) null);
        this.JLArriba1_31.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_31.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_31.setName("1");
        this.JLArriba1_31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLArriba1_31);
        this.JLArriba1_31.setBounds(0, 0, 40, 65);
        this.JLArriba2_31.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_31.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_31.setName("2");
        this.JLArriba2_31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLArriba2_31);
        this.JLArriba2_31.setBounds(0, 0, 40, 65);
        this.JLCentro31.setMaximumSize(new Dimension(41, 65));
        this.JLCentro31.setMinimumSize(new Dimension(41, 65));
        this.JLCentro31.setName("4");
        this.JLCentro31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLCentro31);
        this.JLCentro31.setBounds(0, 0, 40, 65);
        this.JLDerecha31.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha31.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha31.setName("3");
        this.JLDerecha31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLDerecha31);
        this.JLDerecha31.setBounds(0, 0, 40, 65);
        this.JLIzquierda31.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda31.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda31.setName("5");
        this.JLIzquierda31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLIzquierda31);
        this.JLIzquierda31.setBounds(0, 0, 40, 65);
        this.JLAbajo1_31.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_31.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_31.setName("7");
        this.JLAbajo1_31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLAbajo1_31);
        this.JLAbajo1_31.setBounds(0, 0, 40, 65);
        this.JLAbajo2_31.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_31.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_31.setName("6");
        this.JLAbajo2_31.setPreferredSize(new Dimension(41, 65));
        this.JP31.add(this.JLAbajo2_31);
        this.JLAbajo2_31.setBounds(0, 0, 40, 65);
        this.JLCompleto31.setName("8");
        this.JP31.add(this.JLCompleto31);
        this.JLCompleto31.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco31.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco31.setName("0");
        this.JP31.add(this.JLDienteBlanco31);
        this.JLDienteBlanco31.setBounds(0, 0, 40, 65);
        this.JP32.setBorder(BorderFactory.createEtchedBorder());
        this.JP32.setMaximumSize(new Dimension(41, 65));
        this.JP32.setMinimumSize(new Dimension(41, 65));
        this.JP32.setName("32");
        this.JP32.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.46
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP32MouseClicked(evt);
            }
        });
        this.JP32.setLayout((LayoutManager) null);
        this.JLArriba1_32.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_32.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_32.setName("1");
        this.JLArriba1_32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLArriba1_32);
        this.JLArriba1_32.setBounds(0, 0, 40, 65);
        this.JLArriba2_32.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_32.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_32.setName("2");
        this.JLArriba2_32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLArriba2_32);
        this.JLArriba2_32.setBounds(0, 0, 40, 65);
        this.JLCentro32.setMaximumSize(new Dimension(41, 65));
        this.JLCentro32.setMinimumSize(new Dimension(41, 65));
        this.JLCentro32.setName("4");
        this.JLCentro32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLCentro32);
        this.JLCentro32.setBounds(0, 0, 40, 65);
        this.JLDerecha32.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha32.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha32.setName("3");
        this.JLDerecha32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLDerecha32);
        this.JLDerecha32.setBounds(0, 0, 40, 65);
        this.JLIzquierda32.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda32.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda32.setName("5");
        this.JLIzquierda32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLIzquierda32);
        this.JLIzquierda32.setBounds(0, 0, 40, 65);
        this.JLAbajo1_32.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_32.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_32.setName("7");
        this.JLAbajo1_32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLAbajo1_32);
        this.JLAbajo1_32.setBounds(0, 0, 40, 65);
        this.JLAbajo2_32.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_32.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_32.setName("6");
        this.JLAbajo2_32.setPreferredSize(new Dimension(41, 65));
        this.JP32.add(this.JLAbajo2_32);
        this.JLAbajo2_32.setBounds(0, 0, 40, 65);
        this.JLCompleto32.setName("8");
        this.JP32.add(this.JLCompleto32);
        this.JLCompleto32.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco32.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco32.setName("0");
        this.JP32.add(this.JLDienteBlanco32);
        this.JLDienteBlanco32.setBounds(0, 0, 40, 65);
        this.JP33.setBorder(BorderFactory.createEtchedBorder());
        this.JP33.setMaximumSize(new Dimension(41, 65));
        this.JP33.setMinimumSize(new Dimension(41, 65));
        this.JP33.setName("33");
        this.JP33.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.47
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP33MouseClicked(evt);
            }
        });
        this.JP33.setLayout((LayoutManager) null);
        this.JLArriba1_33.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_33.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_33.setName("1");
        this.JLArriba1_33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLArriba1_33);
        this.JLArriba1_33.setBounds(0, 0, 40, 65);
        this.JLArriba2_33.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_33.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_33.setName("2");
        this.JLArriba2_33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLArriba2_33);
        this.JLArriba2_33.setBounds(0, 0, 40, 65);
        this.JLCentro33.setMaximumSize(new Dimension(41, 65));
        this.JLCentro33.setMinimumSize(new Dimension(41, 65));
        this.JLCentro33.setName("4");
        this.JLCentro33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLCentro33);
        this.JLCentro33.setBounds(0, 0, 40, 65);
        this.JLDerecha33.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha33.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha33.setName("3");
        this.JLDerecha33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLDerecha33);
        this.JLDerecha33.setBounds(0, 0, 40, 65);
        this.JLIzquierda33.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda33.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda33.setName("5");
        this.JLIzquierda33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLIzquierda33);
        this.JLIzquierda33.setBounds(0, 0, 40, 65);
        this.JLAbajo1_33.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_33.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_33.setName("7");
        this.JLAbajo1_33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLAbajo1_33);
        this.JLAbajo1_33.setBounds(0, 0, 40, 65);
        this.JLAbajo2_33.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_33.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_33.setName("6");
        this.JLAbajo2_33.setPreferredSize(new Dimension(41, 65));
        this.JP33.add(this.JLAbajo2_33);
        this.JLAbajo2_33.setBounds(0, 0, 40, 65);
        this.JLCompleto33.setName("8");
        this.JP33.add(this.JLCompleto33);
        this.JLCompleto33.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco33.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco33.setName("0");
        this.JP33.add(this.JLDienteBlanco33);
        this.JLDienteBlanco33.setBounds(0, 0, 40, 65);
        this.JP34.setBorder(BorderFactory.createEtchedBorder());
        this.JP34.setMaximumSize(new Dimension(41, 65));
        this.JP34.setMinimumSize(new Dimension(41, 65));
        this.JP34.setName("34");
        this.JP34.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.48
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP34MouseClicked(evt);
            }
        });
        this.JP34.setLayout((LayoutManager) null);
        this.JLArriba1_34.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_34.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_34.setName("1");
        this.JLArriba1_34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLArriba1_34);
        this.JLArriba1_34.setBounds(0, 0, 40, 65);
        this.JLArriba2_34.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_34.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_34.setName("2");
        this.JLArriba2_34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLArriba2_34);
        this.JLArriba2_34.setBounds(0, 0, 40, 65);
        this.JLCentro34.setMaximumSize(new Dimension(41, 65));
        this.JLCentro34.setMinimumSize(new Dimension(41, 65));
        this.JLCentro34.setName("4");
        this.JLCentro34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLCentro34);
        this.JLCentro34.setBounds(0, 0, 40, 65);
        this.JLDerecha34.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha34.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha34.setName("3");
        this.JLDerecha34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLDerecha34);
        this.JLDerecha34.setBounds(0, 0, 40, 65);
        this.JLIzquierda34.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda34.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda34.setName("5");
        this.JLIzquierda34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLIzquierda34);
        this.JLIzquierda34.setBounds(0, 0, 40, 65);
        this.JLAbajo1_34.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_34.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_34.setName("7");
        this.JLAbajo1_34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLAbajo1_34);
        this.JLAbajo1_34.setBounds(0, 0, 40, 65);
        this.JLAbajo2_34.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_34.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_34.setName("6");
        this.JLAbajo2_34.setPreferredSize(new Dimension(41, 65));
        this.JP34.add(this.JLAbajo2_34);
        this.JLAbajo2_34.setBounds(0, 0, 40, 65);
        this.JLCompleto34.setName("8");
        this.JP34.add(this.JLCompleto34);
        this.JLCompleto34.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco34.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco34.setName("0");
        this.JP34.add(this.JLDienteBlanco34);
        this.JLDienteBlanco34.setBounds(0, 0, 40, 65);
        this.JP35.setBorder(BorderFactory.createEtchedBorder());
        this.JP35.setMaximumSize(new Dimension(41, 65));
        this.JP35.setMinimumSize(new Dimension(41, 65));
        this.JP35.setName("35");
        this.JP35.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.49
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP35MouseClicked(evt);
            }
        });
        this.JP35.setLayout((LayoutManager) null);
        this.JLArriba1_35.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_35.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_35.setName("1");
        this.JLArriba1_35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLArriba1_35);
        this.JLArriba1_35.setBounds(0, 0, 40, 65);
        this.JLArriba2_35.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_35.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_35.setName("2");
        this.JLArriba2_35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLArriba2_35);
        this.JLArriba2_35.setBounds(0, 0, 40, 65);
        this.JLCentro35.setMaximumSize(new Dimension(41, 65));
        this.JLCentro35.setMinimumSize(new Dimension(41, 65));
        this.JLCentro35.setName("4");
        this.JLCentro35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLCentro35);
        this.JLCentro35.setBounds(0, 0, 40, 65);
        this.JLDerecha35.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha35.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha35.setName("3");
        this.JLDerecha35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLDerecha35);
        this.JLDerecha35.setBounds(0, 0, 40, 65);
        this.JLIzquierda35.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda35.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda35.setName("5");
        this.JLIzquierda35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLIzquierda35);
        this.JLIzquierda35.setBounds(0, 0, 40, 65);
        this.JLAbajo1_35.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_35.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_35.setName("7");
        this.JLAbajo1_35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLAbajo1_35);
        this.JLAbajo1_35.setBounds(0, 0, 40, 65);
        this.JLAbajo2_35.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_35.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_35.setName("6");
        this.JLAbajo2_35.setPreferredSize(new Dimension(41, 65));
        this.JP35.add(this.JLAbajo2_35);
        this.JLAbajo2_35.setBounds(0, 0, 40, 65);
        this.JLCompleto35.setName("8");
        this.JP35.add(this.JLCompleto35);
        this.JLCompleto35.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco35.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco35.setName("0");
        this.JP35.add(this.JLDienteBlanco35);
        this.JLDienteBlanco35.setBounds(0, 0, 40, 65);
        this.JP36.setBorder(BorderFactory.createEtchedBorder());
        this.JP36.setMaximumSize(new Dimension(41, 65));
        this.JP36.setMinimumSize(new Dimension(41, 65));
        this.JP36.setName("36");
        this.JP36.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.50
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP36MouseClicked(evt);
            }
        });
        this.JP36.setLayout((LayoutManager) null);
        this.JLArriba1_36.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_36.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_36.setName("1");
        this.JLArriba1_36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLArriba1_36);
        this.JLArriba1_36.setBounds(0, 0, 40, 65);
        this.JLArriba2_36.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_36.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_36.setName("2");
        this.JLArriba2_36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLArriba2_36);
        this.JLArriba2_36.setBounds(0, 0, 40, 65);
        this.JLCentro36.setMaximumSize(new Dimension(41, 65));
        this.JLCentro36.setMinimumSize(new Dimension(41, 65));
        this.JLCentro36.setName("4");
        this.JLCentro36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLCentro36);
        this.JLCentro36.setBounds(0, 0, 40, 65);
        this.JLDerecha36.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha36.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha36.setName("3");
        this.JLDerecha36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLDerecha36);
        this.JLDerecha36.setBounds(0, 0, 40, 65);
        this.JLIzquierda36.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda36.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda36.setName("5");
        this.JLIzquierda36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLIzquierda36);
        this.JLIzquierda36.setBounds(0, 0, 40, 65);
        this.JLAbajo1_36.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_36.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_36.setName("7");
        this.JLAbajo1_36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLAbajo1_36);
        this.JLAbajo1_36.setBounds(0, 0, 40, 65);
        this.JLAbajo2_36.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_36.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_36.setName("6");
        this.JLAbajo2_36.setPreferredSize(new Dimension(41, 65));
        this.JP36.add(this.JLAbajo2_36);
        this.JLAbajo2_36.setBounds(0, 0, 40, 65);
        this.JLCompleto36.setName("8");
        this.JP36.add(this.JLCompleto36);
        this.JLCompleto36.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco36.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco36.setName("0");
        this.JP36.add(this.JLDienteBlanco36);
        this.JLDienteBlanco36.setBounds(0, 0, 40, 65);
        this.JP37.setBorder(BorderFactory.createEtchedBorder());
        this.JP37.setMaximumSize(new Dimension(41, 65));
        this.JP37.setMinimumSize(new Dimension(41, 65));
        this.JP37.setName("37");
        this.JP37.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.51
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP37MouseClicked(evt);
            }
        });
        this.JP37.setLayout((LayoutManager) null);
        this.JLArriba1_37.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_37.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_37.setName("1");
        this.JLArriba1_37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLArriba1_37);
        this.JLArriba1_37.setBounds(0, 0, 40, 65);
        this.JLArriba2_37.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_37.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_37.setName("2");
        this.JLArriba2_37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLArriba2_37);
        this.JLArriba2_37.setBounds(0, 0, 40, 65);
        this.JLCentro37.setMaximumSize(new Dimension(41, 65));
        this.JLCentro37.setMinimumSize(new Dimension(41, 65));
        this.JLCentro37.setName("4");
        this.JLCentro37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLCentro37);
        this.JLCentro37.setBounds(0, 0, 40, 65);
        this.JLDerecha37.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha37.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha37.setName("3");
        this.JLDerecha37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLDerecha37);
        this.JLDerecha37.setBounds(0, 0, 40, 65);
        this.JLIzquierda37.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda37.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda37.setName("5");
        this.JLIzquierda37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLIzquierda37);
        this.JLIzquierda37.setBounds(0, 0, 40, 65);
        this.JLAbajo1_37.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_37.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_37.setName("7");
        this.JLAbajo1_37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLAbajo1_37);
        this.JLAbajo1_37.setBounds(0, 0, 40, 65);
        this.JLAbajo2_37.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_37.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_37.setName("6");
        this.JLAbajo2_37.setPreferredSize(new Dimension(41, 65));
        this.JP37.add(this.JLAbajo2_37);
        this.JLAbajo2_37.setBounds(0, 0, 40, 65);
        this.JLCompleto37.setName("8");
        this.JP37.add(this.JLCompleto37);
        this.JLCompleto37.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco37.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco37.setName("0");
        this.JP37.add(this.JLDienteBlanco37);
        this.JLDienteBlanco37.setBounds(0, 0, 40, 65);
        this.JP38.setBorder(BorderFactory.createEtchedBorder());
        this.JP38.setMaximumSize(new Dimension(41, 65));
        this.JP38.setMinimumSize(new Dimension(41, 65));
        this.JP38.setName("38");
        this.JP38.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.52
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.JP38MouseClicked(evt);
            }
        });
        this.JP38.setLayout((LayoutManager) null);
        this.JLArriba1_38.setMaximumSize(new Dimension(41, 65));
        this.JLArriba1_38.setMinimumSize(new Dimension(41, 65));
        this.JLArriba1_38.setName("1");
        this.JLArriba1_38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLArriba1_38);
        this.JLArriba1_38.setBounds(0, 0, 40, 65);
        this.JLArriba2_38.setMaximumSize(new Dimension(41, 65));
        this.JLArriba2_38.setMinimumSize(new Dimension(41, 65));
        this.JLArriba2_38.setName("2");
        this.JLArriba2_38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLArriba2_38);
        this.JLArriba2_38.setBounds(0, 0, 40, 65);
        this.JLCentro38.setMaximumSize(new Dimension(41, 65));
        this.JLCentro38.setMinimumSize(new Dimension(41, 65));
        this.JLCentro38.setName("4");
        this.JLCentro38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLCentro38);
        this.JLCentro38.setBounds(0, 0, 40, 65);
        this.JLDerecha38.setMaximumSize(new Dimension(41, 65));
        this.JLDerecha38.setMinimumSize(new Dimension(41, 65));
        this.JLDerecha38.setName("3");
        this.JLDerecha38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLDerecha38);
        this.JLDerecha38.setBounds(0, 0, 40, 65);
        this.JLIzquierda38.setMaximumSize(new Dimension(41, 65));
        this.JLIzquierda38.setMinimumSize(new Dimension(41, 65));
        this.JLIzquierda38.setName("5");
        this.JLIzquierda38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLIzquierda38);
        this.JLIzquierda38.setBounds(0, 0, 40, 65);
        this.JLAbajo1_38.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo1_38.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo1_38.setName("7");
        this.JLAbajo1_38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLAbajo1_38);
        this.JLAbajo1_38.setBounds(0, 0, 40, 65);
        this.JLAbajo2_38.setMaximumSize(new Dimension(41, 65));
        this.JLAbajo2_38.setMinimumSize(new Dimension(41, 65));
        this.JLAbajo2_38.setName("6");
        this.JLAbajo2_38.setPreferredSize(new Dimension(41, 65));
        this.JP38.add(this.JLAbajo2_38);
        this.JLAbajo2_38.setBounds(0, 0, 40, 65);
        this.JLCompleto38.setName("8");
        this.JP38.add(this.JLCompleto38);
        this.JLCompleto38.setBounds(0, 0, 40, 65);
        this.JLDienteBlanco38.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Odontograma/DienteBlanco.png")));
        this.JLDienteBlanco38.setName("0");
        this.JP38.add(this.JLDienteBlanco38);
        this.JLDienteBlanco38.setBounds(0, 0, 40, 65);
        this.L18.setBackground(new Color(255, 255, 255));
        this.L18.setFont(new Font("Arial", 1, 12));
        this.L18.setForeground(new Color(255, 0, 0));
        this.L18.setHorizontalAlignment(0);
        this.L18.setText("18");
        this.L18.setName("18");
        this.L18.setOpaque(true);
        this.L18.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.53
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L18MouseClicked(evt);
            }
        });
        this.L17.setBackground(new Color(255, 255, 255));
        this.L17.setFont(new Font("Arial", 1, 12));
        this.L17.setForeground(new Color(255, 0, 0));
        this.L17.setHorizontalAlignment(0);
        this.L17.setText("17");
        this.L17.setName("17");
        this.L17.setOpaque(true);
        this.L17.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.54
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L17MouseClicked(evt);
            }
        });
        this.L16.setBackground(new Color(255, 255, 255));
        this.L16.setFont(new Font("Arial", 1, 12));
        this.L16.setForeground(new Color(255, 0, 0));
        this.L16.setHorizontalAlignment(0);
        this.L16.setText("16");
        this.L16.setOpaque(true);
        this.L16.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.55
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L16MouseClicked(evt);
            }
        });
        this.L15.setBackground(new Color(255, 255, 255));
        this.L15.setFont(new Font("Arial", 1, 12));
        this.L15.setForeground(new Color(255, 0, 0));
        this.L15.setHorizontalAlignment(0);
        this.L15.setText("15");
        this.L15.setOpaque(true);
        this.L15.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.56
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L15MouseClicked(evt);
            }
        });
        this.L14.setBackground(new Color(255, 255, 255));
        this.L14.setFont(new Font("Arial", 1, 12));
        this.L14.setForeground(new Color(255, 0, 0));
        this.L14.setHorizontalAlignment(0);
        this.L14.setText("14");
        this.L14.setOpaque(true);
        this.L14.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.57
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L14MouseClicked(evt);
            }
        });
        this.L13.setBackground(new Color(255, 255, 255));
        this.L13.setFont(new Font("Arial", 1, 12));
        this.L13.setForeground(new Color(255, 0, 0));
        this.L13.setHorizontalAlignment(0);
        this.L13.setText("13");
        this.L13.setOpaque(true);
        this.L13.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.58
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L13MouseClicked(evt);
            }
        });
        this.L12.setBackground(new Color(255, 255, 255));
        this.L12.setFont(new Font("Arial", 1, 12));
        this.L12.setForeground(new Color(255, 0, 0));
        this.L12.setHorizontalAlignment(0);
        this.L12.setText("12");
        this.L12.setOpaque(true);
        this.L12.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.59
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L12MouseClicked(evt);
            }
        });
        this.L11.setBackground(new Color(255, 255, 255));
        this.L11.setFont(new Font("Arial", 1, 12));
        this.L11.setForeground(new Color(255, 0, 0));
        this.L11.setHorizontalAlignment(0);
        this.L11.setText("11");
        this.L11.setOpaque(true);
        this.L11.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.60
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L11MouseClicked(evt);
            }
        });
        this.L21.setBackground(new Color(255, 255, 255));
        this.L21.setFont(new Font("Arial", 1, 12));
        this.L21.setForeground(new Color(255, 0, 0));
        this.L21.setHorizontalAlignment(0);
        this.L21.setText("21");
        this.L21.setOpaque(true);
        this.L21.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.61
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L21MouseClicked(evt);
            }
        });
        this.L22.setBackground(new Color(255, 255, 255));
        this.L22.setFont(new Font("Arial", 1, 12));
        this.L22.setForeground(new Color(255, 0, 0));
        this.L22.setHorizontalAlignment(0);
        this.L22.setText("22");
        this.L22.setOpaque(true);
        this.L22.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.62
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L22MouseClicked(evt);
            }
        });
        this.L23.setBackground(new Color(255, 255, 255));
        this.L23.setFont(new Font("Arial", 1, 12));
        this.L23.setForeground(new Color(255, 0, 0));
        this.L23.setHorizontalAlignment(0);
        this.L23.setText("23");
        this.L23.setOpaque(true);
        this.L23.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.63
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L23MouseClicked(evt);
            }
        });
        this.L24.setBackground(new Color(255, 255, 255));
        this.L24.setFont(new Font("Arial", 1, 12));
        this.L24.setForeground(new Color(255, 0, 0));
        this.L24.setHorizontalAlignment(0);
        this.L24.setText("24");
        this.L24.setOpaque(true);
        this.L24.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.64
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L24MouseClicked(evt);
            }
        });
        this.L25.setBackground(new Color(255, 255, 255));
        this.L25.setFont(new Font("Arial", 1, 12));
        this.L25.setForeground(new Color(255, 0, 0));
        this.L25.setHorizontalAlignment(0);
        this.L25.setText("25");
        this.L25.setOpaque(true);
        this.L25.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.65
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L25MouseClicked(evt);
            }
        });
        this.L26.setBackground(new Color(255, 255, 255));
        this.L26.setFont(new Font("Arial", 1, 12));
        this.L26.setForeground(new Color(255, 0, 0));
        this.L26.setHorizontalAlignment(0);
        this.L26.setText("26");
        this.L26.setOpaque(true);
        this.L26.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.66
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L26MouseClicked(evt);
            }
        });
        this.L27.setBackground(new Color(255, 255, 255));
        this.L27.setFont(new Font("Arial", 1, 12));
        this.L27.setForeground(new Color(255, 0, 0));
        this.L27.setHorizontalAlignment(0);
        this.L27.setText("27");
        this.L27.setOpaque(true);
        this.L27.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.67
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L27MouseClicked(evt);
            }
        });
        this.L28.setBackground(new Color(255, 255, 255));
        this.L28.setFont(new Font("Arial", 1, 12));
        this.L28.setForeground(new Color(255, 0, 0));
        this.L28.setHorizontalAlignment(0);
        this.L28.setText("28");
        this.L28.setOpaque(true);
        this.L28.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.68
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L28MouseClicked(evt);
            }
        });
        this.L55.setBackground(new Color(255, 255, 255));
        this.L55.setFont(new Font("Arial", 1, 12));
        this.L55.setForeground(new Color(255, 0, 0));
        this.L55.setHorizontalAlignment(0);
        this.L55.setText("55");
        this.L55.setOpaque(true);
        this.L55.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.69
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L55MouseClicked(evt);
            }
        });
        this.L54.setBackground(new Color(255, 255, 255));
        this.L54.setFont(new Font("Arial", 1, 12));
        this.L54.setForeground(new Color(255, 0, 0));
        this.L54.setHorizontalAlignment(0);
        this.L54.setText("54");
        this.L54.setOpaque(true);
        this.L54.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.70
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L54MouseClicked(evt);
            }
        });
        this.L53.setBackground(new Color(255, 255, 255));
        this.L53.setFont(new Font("Arial", 1, 12));
        this.L53.setForeground(new Color(255, 0, 0));
        this.L53.setHorizontalAlignment(0);
        this.L53.setText("53");
        this.L53.setOpaque(true);
        this.L53.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.71
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L53MouseClicked(evt);
            }
        });
        this.L52.setBackground(new Color(255, 255, 255));
        this.L52.setFont(new Font("Arial", 1, 12));
        this.L52.setForeground(new Color(255, 0, 0));
        this.L52.setHorizontalAlignment(0);
        this.L52.setText("52");
        this.L52.setOpaque(true);
        this.L52.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.72
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L52MouseClicked(evt);
            }
        });
        this.L51.setBackground(new Color(255, 255, 255));
        this.L51.setFont(new Font("Arial", 1, 12));
        this.L51.setForeground(new Color(255, 0, 0));
        this.L51.setHorizontalAlignment(0);
        this.L51.setText("51");
        this.L51.setOpaque(true);
        this.L51.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.73
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L51MouseClicked(evt);
            }
        });
        this.L61.setBackground(new Color(255, 255, 255));
        this.L61.setFont(new Font("Arial", 1, 12));
        this.L61.setForeground(new Color(255, 0, 0));
        this.L61.setHorizontalAlignment(0);
        this.L61.setText("61");
        this.L61.setOpaque(true);
        this.L61.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.74
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L61MouseClicked(evt);
            }
        });
        this.L62.setBackground(new Color(255, 255, 255));
        this.L62.setFont(new Font("Arial", 1, 12));
        this.L62.setForeground(new Color(255, 0, 0));
        this.L62.setHorizontalAlignment(0);
        this.L62.setText("62");
        this.L62.setOpaque(true);
        this.L62.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.75
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L62MouseClicked(evt);
            }
        });
        this.L63.setBackground(new Color(255, 255, 255));
        this.L63.setFont(new Font("Arial", 1, 12));
        this.L63.setForeground(new Color(255, 0, 0));
        this.L63.setHorizontalAlignment(0);
        this.L63.setText("63");
        this.L63.setOpaque(true);
        this.L63.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.76
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L63MouseClicked(evt);
            }
        });
        this.L64.setBackground(new Color(255, 255, 255));
        this.L64.setFont(new Font("Arial", 1, 12));
        this.L64.setForeground(new Color(255, 0, 0));
        this.L64.setHorizontalAlignment(0);
        this.L64.setText("64");
        this.L64.setOpaque(true);
        this.L64.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.77
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L64MouseClicked(evt);
            }
        });
        this.L65.setBackground(new Color(255, 255, 255));
        this.L65.setFont(new Font("Arial", 1, 12));
        this.L65.setForeground(new Color(255, 0, 0));
        this.L65.setHorizontalAlignment(0);
        this.L65.setText("65");
        this.L65.setOpaque(true);
        this.L65.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.78
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L65MouseClicked(evt);
            }
        });
        this.L85.setBackground(new Color(255, 255, 255));
        this.L85.setFont(new Font("Arial", 1, 12));
        this.L85.setForeground(new Color(255, 0, 0));
        this.L85.setHorizontalAlignment(0);
        this.L85.setText("85");
        this.L85.setOpaque(true);
        this.L85.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.79
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L85MouseClicked(evt);
            }
        });
        this.L84.setBackground(new Color(255, 255, 255));
        this.L84.setFont(new Font("Arial", 1, 12));
        this.L84.setForeground(new Color(255, 0, 0));
        this.L84.setHorizontalAlignment(0);
        this.L84.setText("84");
        this.L84.setOpaque(true);
        this.L84.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.80
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L84MouseClicked(evt);
            }
        });
        this.L83.setBackground(new Color(255, 255, 255));
        this.L83.setFont(new Font("Arial", 1, 12));
        this.L83.setForeground(new Color(255, 0, 0));
        this.L83.setHorizontalAlignment(0);
        this.L83.setText("83");
        this.L83.setOpaque(true);
        this.L83.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.81
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L83MouseClicked(evt);
            }
        });
        this.L82.setBackground(new Color(255, 255, 255));
        this.L82.setFont(new Font("Arial", 1, 12));
        this.L82.setForeground(new Color(255, 0, 0));
        this.L82.setHorizontalAlignment(0);
        this.L82.setText("82");
        this.L82.setOpaque(true);
        this.L82.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.82
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L82MouseClicked(evt);
            }
        });
        this.L81.setBackground(new Color(255, 255, 255));
        this.L81.setFont(new Font("Arial", 1, 12));
        this.L81.setForeground(new Color(255, 0, 0));
        this.L81.setHorizontalAlignment(0);
        this.L81.setText("81");
        this.L81.setOpaque(true);
        this.L81.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.83
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L81MouseClicked(evt);
            }
        });
        this.L71.setBackground(new Color(255, 255, 255));
        this.L71.setFont(new Font("Arial", 1, 12));
        this.L71.setForeground(new Color(255, 0, 0));
        this.L71.setHorizontalAlignment(0);
        this.L71.setText("71");
        this.L71.setOpaque(true);
        this.L71.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.84
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L71MouseClicked(evt);
            }
        });
        this.L72.setBackground(new Color(255, 255, 255));
        this.L72.setFont(new Font("Arial", 1, 12));
        this.L72.setForeground(new Color(255, 0, 0));
        this.L72.setHorizontalAlignment(0);
        this.L72.setText("72");
        this.L72.setOpaque(true);
        this.L72.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.85
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L72MouseClicked(evt);
            }
        });
        this.L73.setBackground(new Color(255, 255, 255));
        this.L73.setFont(new Font("Arial", 1, 12));
        this.L73.setForeground(new Color(255, 0, 0));
        this.L73.setHorizontalAlignment(0);
        this.L73.setText("73");
        this.L73.setOpaque(true);
        this.L73.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.86
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L73MouseClicked(evt);
            }
        });
        this.L74.setBackground(new Color(255, 255, 255));
        this.L74.setFont(new Font("Arial", 1, 12));
        this.L74.setForeground(new Color(255, 0, 0));
        this.L74.setHorizontalAlignment(0);
        this.L74.setText("74");
        this.L74.setOpaque(true);
        this.L74.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.87
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L74MouseClicked(evt);
            }
        });
        this.L75.setBackground(new Color(255, 255, 255));
        this.L75.setFont(new Font("Arial", 1, 12));
        this.L75.setForeground(new Color(255, 0, 0));
        this.L75.setHorizontalAlignment(0);
        this.L75.setText("75");
        this.L75.setOpaque(true);
        this.L75.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.88
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L75MouseClicked(evt);
            }
        });
        this.L48.setBackground(new Color(255, 255, 255));
        this.L48.setFont(new Font("Arial", 1, 12));
        this.L48.setForeground(new Color(255, 0, 0));
        this.L48.setHorizontalAlignment(0);
        this.L48.setText("48");
        this.L48.setOpaque(true);
        this.L48.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.89
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L48MouseClicked(evt);
            }
        });
        this.L47.setBackground(new Color(255, 255, 255));
        this.L47.setFont(new Font("Arial", 1, 12));
        this.L47.setForeground(new Color(255, 0, 0));
        this.L47.setHorizontalAlignment(0);
        this.L47.setText("47");
        this.L47.setOpaque(true);
        this.L47.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.90
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L47MouseClicked(evt);
            }
        });
        this.L46.setBackground(new Color(255, 255, 255));
        this.L46.setFont(new Font("Arial", 1, 12));
        this.L46.setForeground(new Color(255, 0, 0));
        this.L46.setHorizontalAlignment(0);
        this.L46.setText("46");
        this.L46.setOpaque(true);
        this.L46.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.91
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L46MouseClicked(evt);
            }
        });
        this.L45.setBackground(new Color(255, 255, 255));
        this.L45.setFont(new Font("Arial", 1, 12));
        this.L45.setForeground(new Color(255, 0, 0));
        this.L45.setHorizontalAlignment(0);
        this.L45.setText("45");
        this.L45.setOpaque(true);
        this.L45.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.92
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L45MouseClicked(evt);
            }
        });
        this.L44.setBackground(new Color(255, 255, 255));
        this.L44.setFont(new Font("Arial", 1, 12));
        this.L44.setForeground(new Color(255, 0, 0));
        this.L44.setHorizontalAlignment(0);
        this.L44.setText("44");
        this.L44.setOpaque(true);
        this.L44.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.93
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L44MouseClicked(evt);
            }
        });
        this.L43.setBackground(new Color(255, 255, 255));
        this.L43.setFont(new Font("Arial", 1, 12));
        this.L43.setForeground(new Color(255, 0, 0));
        this.L43.setHorizontalAlignment(0);
        this.L43.setText("43");
        this.L43.setOpaque(true);
        this.L43.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.94
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L43MouseClicked(evt);
            }
        });
        this.L42.setBackground(new Color(255, 255, 255));
        this.L42.setFont(new Font("Arial", 1, 12));
        this.L42.setForeground(new Color(255, 0, 0));
        this.L42.setHorizontalAlignment(0);
        this.L42.setText("42");
        this.L42.setOpaque(true);
        this.L42.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.95
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L42MouseClicked(evt);
            }
        });
        this.L41.setBackground(new Color(255, 255, 255));
        this.L41.setFont(new Font("Arial", 1, 12));
        this.L41.setForeground(new Color(255, 0, 0));
        this.L41.setHorizontalAlignment(0);
        this.L41.setText("41");
        this.L41.setOpaque(true);
        this.L41.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.96
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L41MouseClicked(evt);
            }
        });
        this.L31.setBackground(new Color(255, 255, 255));
        this.L31.setFont(new Font("Arial", 1, 12));
        this.L31.setForeground(new Color(255, 0, 0));
        this.L31.setHorizontalAlignment(0);
        this.L31.setText("31");
        this.L31.setOpaque(true);
        this.L31.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.97
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L31MouseClicked(evt);
            }
        });
        this.L32.setBackground(new Color(255, 255, 255));
        this.L32.setFont(new Font("Arial", 1, 12));
        this.L32.setForeground(new Color(255, 0, 0));
        this.L32.setHorizontalAlignment(0);
        this.L32.setText("32");
        this.L32.setOpaque(true);
        this.L32.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.98
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L32MouseClicked(evt);
            }
        });
        this.L33.setBackground(new Color(255, 255, 255));
        this.L33.setFont(new Font("Arial", 1, 12));
        this.L33.setForeground(new Color(255, 0, 0));
        this.L33.setHorizontalAlignment(0);
        this.L33.setText("33");
        this.L33.setOpaque(true);
        this.L33.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.99
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L33MouseClicked(evt);
            }
        });
        this.L34.setBackground(new Color(255, 255, 255));
        this.L34.setFont(new Font("Arial", 1, 12));
        this.L34.setForeground(new Color(255, 0, 0));
        this.L34.setHorizontalAlignment(0);
        this.L34.setText("34");
        this.L34.setOpaque(true);
        this.L34.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.100
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L34MouseClicked(evt);
            }
        });
        this.L35.setBackground(new Color(255, 255, 255));
        this.L35.setFont(new Font("Arial", 1, 12));
        this.L35.setForeground(new Color(255, 0, 0));
        this.L35.setHorizontalAlignment(0);
        this.L35.setText("35");
        this.L35.setOpaque(true);
        this.L35.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.101
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L35MouseClicked(evt);
            }
        });
        this.L36.setBackground(new Color(255, 255, 255));
        this.L36.setFont(new Font("Arial", 1, 12));
        this.L36.setForeground(new Color(255, 0, 0));
        this.L36.setHorizontalAlignment(0);
        this.L36.setText("36");
        this.L36.setOpaque(true);
        this.L36.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.102
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L36MouseClicked(evt);
            }
        });
        this.L37.setBackground(new Color(255, 255, 255));
        this.L37.setFont(new Font("Arial", 1, 12));
        this.L37.setForeground(new Color(255, 0, 0));
        this.L37.setHorizontalAlignment(0);
        this.L37.setText("37");
        this.L37.setOpaque(true);
        this.L37.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.103
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L37MouseClicked(evt);
            }
        });
        this.L38.setBackground(new Color(255, 255, 255));
        this.L38.setFont(new Font("Arial", 1, 12));
        this.L38.setForeground(new Color(255, 0, 0));
        this.L38.setHorizontalAlignment(0);
        this.L38.setText("38");
        this.L38.setOpaque(true);
        this.L38.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaDientes.104
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaDientes.this.L38MouseClicked(evt);
            }
        });
        this.Verde.setBackground(new Color(0, 175, 8));
        this.Verde.setForeground(new Color(255, 255, 255));
        this.Verde.setText("Con DX");
        this.Verde.setOpaque(true);
        this.Amarillo.setBackground(new Color(249, 220, 32));
        this.Amarillo.setText("Falta DX");
        this.Amarillo.setOpaque(true);
        this.Rojo.setBackground(Color.red);
        this.Rojo.setForeground(new Color(255, 255, 255));
        this.Rojo.setText("Sin DX");
        this.Rojo.setOpaque(true);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.L18, -1, 41, 32767).addComponent(this.JP18, -1, -1, 32767)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.L17, -1, 41, 32767).addComponent(this.JP17, -1, -1, 32767)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP16, -1, -1, 32767).addComponent(this.L16, -1, 41, 32767)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.L85, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L84, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JP85, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP84, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP83, -2, 41, -2).addComponent(this.L83, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP82, -2, 41, -2).addComponent(this.L82, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP81, -2, 41, -2).addComponent(this.L81, -2, 41, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP71, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP72, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L71, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L72, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP73, -2, 41, -2).addComponent(this.L73, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP74, -2, 41, -2).addComponent(this.L74, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP75, -2, 41, -2).addComponent(this.L75, -2, 41, -2))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP55, -2, 41, -2).addComponent(this.L55, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.L54, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L53, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JP54, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP53, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP52, -2, 41, -2).addComponent(this.L52, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP51, -2, 41, -2).addComponent(this.L51, -2, 41, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP61, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP62, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L61, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L62, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP63, -2, 41, -2).addComponent(this.L63, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP64, -2, 41, -2).addComponent(this.L64, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP65, -2, 41, -2).addComponent(this.L65, -2, 41, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.Rojo, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.Amarillo, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.Verde, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP15, -2, 41, -2).addComponent(this.L15, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.L14, -2, 41, -2).addGap(0, 0, 0).addComponent(this.L13, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JP14, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP13, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP12, -2, 41, -2).addComponent(this.L12, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP11, -2, 41, -2).addComponent(this.L11, -2, 41, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP21, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP22, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L21, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L22, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP23, -2, 41, -2).addComponent(this.L23, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP24, -2, 41, -2).addComponent(this.L24, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP25, -2, 41, -2).addComponent(this.L25, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP26, -2, 41, -2).addComponent(this.L26, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP27, -2, 41, -2).addComponent(this.L27, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP28, -2, 41, -2).addComponent(this.L28, GroupLayout.Alignment.TRAILING, -2, 41, -2)))))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP48, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP47, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L48, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L47, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP46, -2, 41, -2).addComponent(this.L46, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP45, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP44, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L45, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L44, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP43, -2, 41, -2).addComponent(this.L43, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP42, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP41, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L42, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L41, -2, 41, -2))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP31, -2, 41, -2).addComponent(this.L31, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP32, -2, 41, -2).addComponent(this.L32, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JP33, -2, 41, -2).addGap(1, 1, 1).addComponent(this.JP34, -2, 41, -2)).addGroup(layout.createSequentialGroup().addComponent(this.L33, -2, 41, -2).addGap(1, 1, 1).addComponent(this.L34, -2, 41, -2))).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP35, -2, 41, -2).addComponent(this.L35, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP36, -2, 41, -2).addComponent(this.L36, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JP37, -2, 41, -2).addComponent(this.L37, -2, 41, -2)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP38, -2, 41, -2).addComponent(this.L38, -2, 41, -2)))).addContainerGap(25, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.L18).addComponent(this.L17).addComponent(this.L16).addComponent(this.L15).addComponent(this.L14).addComponent(this.L13).addComponent(this.L12).addComponent(this.L11).addComponent(this.L21).addComponent(this.L22).addComponent(this.L23).addComponent(this.L24).addComponent(this.L25).addComponent(this.L26).addComponent(this.L27).addComponent(this.L28)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP28, -2, 65, -2).addComponent(this.JP27, -2, 65, -2).addComponent(this.JP26, -2, 65, -2).addComponent(this.JP25, -2, 65, -2).addComponent(this.JP24, -2, 65, -2).addComponent(this.JP23, -2, 65, -2).addComponent(this.JP22, -2, 65, -2).addComponent(this.JP21, -2, 65, -2).addComponent(this.JP11, -2, 65, -2).addComponent(this.JP12, -2, 65, -2).addComponent(this.JP13, -2, 65, -2).addComponent(this.JP14, -2, 65, -2).addComponent(this.JP15, -2, 65, -2).addComponent(this.JP16, -2, 65, -2).addComponent(this.JP17, -2, 65, -2).addComponent(this.JP18, -2, 65, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.L55).addComponent(this.L54).addComponent(this.L53).addComponent(this.L52).addComponent(this.L51).addComponent(this.L61).addComponent(this.L62).addComponent(this.L63).addComponent(this.L64).addComponent(this.L65)).addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP51, -2, 65, -2).addComponent(this.JP52, -2, 65, -2).addComponent(this.JP53, -2, 65, -2).addComponent(this.JP54, -2, 65, -2).addComponent(this.JP55, -2, 65, -2).addComponent(this.JP65, -2, 65, -2).addComponent(this.JP64, -2, 65, -2).addComponent(this.JP63, -2, 65, -2).addComponent(this.JP62, -2, 65, -2).addComponent(this.JP61, -2, 65, -2)).addGroup(layout.createSequentialGroup().addComponent(this.Verde).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Amarillo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Rojo))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.L85).addComponent(this.L84).addComponent(this.L83).addComponent(this.L82).addComponent(this.L81).addComponent(this.L71).addComponent(this.L72).addComponent(this.L73).addComponent(this.L74).addComponent(this.L75)).addGap(2, 2, 2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP81, -2, 65, -2).addComponent(this.JP82, -2, 65, -2).addComponent(this.JP83, -2, 65, -2).addComponent(this.JP84, -2, 65, -2).addComponent(this.JP85, -2, 65, -2).addComponent(this.JP75, -2, 65, -2).addComponent(this.JP74, -2, 65, -2).addComponent(this.JP73, -2, 65, -2).addComponent(this.JP72, -2, 65, -2).addComponent(this.JP71, -2, 65, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.L48).addComponent(this.L47).addComponent(this.L46).addComponent(this.L45).addComponent(this.L44).addComponent(this.L43).addComponent(this.L42).addComponent(this.L41).addComponent(this.L31).addComponent(this.L32).addComponent(this.L33).addComponent(this.L34).addComponent(this.L35).addComponent(this.L36).addComponent(this.L37).addComponent(this.L38)).addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP38, -2, 65, -2).addComponent(this.JP37, -2, 65, -2).addComponent(this.JP36, -2, 65, -2).addComponent(this.JP35, -2, 65, -2).addComponent(this.JP34, -2, 65, -2).addComponent(this.JP33, -2, 65, -2).addComponent(this.JP32, -2, 65, -2).addComponent(this.JP31, -2, 65, -2).addComponent(this.JP41, -2, 65, -2).addComponent(this.JP42, -2, 65, -2).addComponent(this.JP43, -2, 65, -2).addComponent(this.JP44, -2, 65, -2).addComponent(this.JP45, -2, 65, -2).addComponent(this.JP46, -2, 65, -2).addComponent(this.JP47, -2, 65, -2).addComponent(this.JP48, -2, 65, -2)).addGap(3, 3, 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP18MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP18);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP18);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP18);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP18, this.L18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP17MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP17);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP17);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP17);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP17, this.L17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP16MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP16);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP16);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP16);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP16, this.L16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP15MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP15);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP15);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP15);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP15, this.L15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP14MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP14);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP14);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP14);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP14, this.L14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP13MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP13);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP13);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP13);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP13, this.L13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP12MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP12);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP12);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP12);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP12, this.L12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP11MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP11);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP11);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP11);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP11, this.L11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP21MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP21);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP21);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP21);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP21, this.L21);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP22MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP22);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP22);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP22);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP22, this.L22);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP23MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP23);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP23);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP23);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP23, this.L23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP24MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP24);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP24);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP24);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP24, this.L24);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP25MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP25);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP25);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP25);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP25, this.L25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP26MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP26);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP26);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP26);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP26, this.L26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP27MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP27);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP27);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP27);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP27, this.L27);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP28MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP28);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP28);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP28);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP28, this.L28);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP51MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP51);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP51);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP51);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP51, this.L51);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP52MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP52);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP52);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP52);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP52, this.L52);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP53MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP53);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP53);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP53);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP53, this.L53);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP54MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP54);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP54);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP54);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP54, this.L54);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP55MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP55);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP55);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP55);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP55, this.L55);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP61MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP61);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP61);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP61);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP61, this.L61);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP62MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP62);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP62);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP62);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP62, this.L62);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP63MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP63);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP63);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP63);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP63, this.L63);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP64MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP64);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP64);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP64);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP64, this.L64);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP65MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP65);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP65);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP65);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP65, this.L65);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP75MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP75);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP75);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP75);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP75, this.L75);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP74MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP74);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP74);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP74);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP74, this.L74);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP73MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP73);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP73);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP73);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP73, this.L73);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP72MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP72);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP72);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP72);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP72, this.L72);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP71MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP71);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP71);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP71);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP71, this.L71);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP85MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP85);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP85);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP85);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP85, this.L85);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP84MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP84);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP84);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP84);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP84, this.L84);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP83MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP83);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP83);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP83);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP83, this.L83);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP82MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP82);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP82);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP82);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP82, this.L82);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP81MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP81);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP81);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP81);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP81, this.L81);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP48MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP48);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP48);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP48);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP48, this.L48);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP47MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP47);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP47);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP47);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP47, this.L47);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP46MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP46);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP46);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP46);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP46, this.L46);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP45MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP45);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP45);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP45);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP45, this.L45);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP44MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP44);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP44);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP44);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP44, this.L44);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP43MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP43);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP43);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP43);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP43, this.L43);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP42MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP42);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP42);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP42);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP42, this.L42);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP41MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP41);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP41);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP41);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP41, this.L41);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP31MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP31);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP31);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP31);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP31, this.L31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP32MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP32);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP32);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP32);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP32, this.L32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP33MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP33);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP33);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP33);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP33, this.L33);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP34MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP34);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP34);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP34);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP34, this.L34);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP35MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP35);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP35);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP35);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP35, this.L35);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP36MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP36);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP36);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP36);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP36, this.L36);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP37MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP37);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP37);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP37);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP37, this.L37);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP38MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaG")) {
            this.jpodontograma.asignarFigura(this.JP38);
            return;
        }
        if (this.nombre.equals("jifOdontogramaI")) {
            this.jpodontogramaInicial.asignarFigura(this.JP38);
        } else if (this.nombre.equals("jifControlPlaca")) {
            this.jpcontrolPlaca.mAsignarFigura(this.JP38);
        } else if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.asignarFigura(this.JP38, this.L38);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L18MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L18, this.JP18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L17MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L17, this.JP17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L16MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L16, this.JP16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L15MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L15, this.JP15);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L14MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L14, this.JP14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L13MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L13, this.JP13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L12MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L12, this.JP12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L11MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L11, this.JP11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L21MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L21, this.JP21);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L22MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L22, this.JP22);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L23MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L23, this.JP23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L24MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L24, this.JP24);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L25MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L25, this.JP25);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L26MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L26, this.JP26);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L27MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L27, this.JP27);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L28MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L28, this.JP28);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L55MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L55, this.JP55);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L54MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L54, this.JP54);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L53MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L53, this.JP53);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L52MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L52, this.JP52);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L51MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L51, this.JP51);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L61MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L61, this.JP61);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L62MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L62, this.JP62);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L63MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L63, this.JP63);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L64MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L64, this.JP64);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L65MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L65, this.JP65);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L85MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L85, this.JP85);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L84MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L84, this.JP84);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L83MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L83, this.JP83);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L82MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L82, this.JP82);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L81MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L81, this.JP81);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L71MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L71, this.JP71);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L72MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L72, this.JP72);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L73MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L73, this.JP73);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L74MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L74, this.JP74);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L75MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L75, this.JP75);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L48MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L48, this.JP48);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L47MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L47, this.JP47);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L46MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L46, this.JP46);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L45MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L45, this.JP45);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L44MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L44, this.JP44);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L43MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L43, this.JP43);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L42MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L42, this.JP42);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L41MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L41, this.JP41);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L31MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L31, this.JP31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L32MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L32, this.JP32);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L33MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L33, this.JP33);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L34MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L34, this.JP34);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L35MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L35, this.JP35);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L36MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L36, this.JP36);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L37MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L37, this.JP37);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L38MouseClicked(MouseEvent evt) {
        if (this.nombre.equals("jifOdontogramaClinico")) {
            this.jpodontogramaClinico.labelDiente(this.L38, this.JP38);
        }
    }
}
