package Odontologia;

import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaCPCompleto.class */
public class JPOdontogramaCPCompleto extends JPanel {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JLabel JL1;
    private JLabel JL10;
    private JLabel JL100;
    private JLabel JL101;
    private JLabel JL102;
    private JLabel JL103;
    private JLabel JL104;
    private JLabel JL105;
    private JLabel JL106;
    private JLabel JL107;
    private JLabel JL108;
    private JLabel JL109;
    private JLabel JL11;
    private JLabel JL110;
    private JLabel JL111;
    private JLabel JL112;
    private JLabel JL113;
    private JLabel JL114;
    private JLabel JL115;
    private JLabel JL116;
    private JLabel JL117;
    private JLabel JL118;
    private JLabel JL119;
    private JLabel JL12;
    private JLabel JL120;
    private JLabel JL121;
    private JLabel JL122;
    private JLabel JL123;
    private JLabel JL124;
    private JLabel JL125;
    private JLabel JL126;
    private JLabel JL127;
    private JLabel JL128;
    private JLabel JL13;
    private JLabel JL14;
    private JLabel JL15;
    private JLabel JL16;
    private JLabel JL17;
    private JLabel JL18;
    private JLabel JL19;
    private JLabel JL2;
    private JLabel JL20;
    private JLabel JL21;
    private JLabel JL22;
    private JLabel JL23;
    private JLabel JL24;
    private JLabel JL25;
    private JLabel JL257;
    private JLabel JL258;
    private JLabel JL259;
    private JLabel JL26;
    private JLabel JL260;
    private JLabel JL261;
    private JLabel JL262;
    private JLabel JL263;
    private JLabel JL264;
    private JLabel JL265;
    private JLabel JL266;
    private JLabel JL267;
    private JLabel JL268;
    private JLabel JL269;
    private JLabel JL27;
    private JLabel JL270;
    private JLabel JL271;
    private JLabel JL272;
    private JLabel JL273;
    private JLabel JL274;
    private JLabel JL275;
    private JLabel JL276;
    private JLabel JL277;
    private JLabel JL278;
    private JLabel JL279;
    private JLabel JL28;
    private JLabel JL280;
    private JLabel JL281;
    private JLabel JL282;
    private JLabel JL283;
    private JLabel JL284;
    private JLabel JL285;
    private JLabel JL286;
    private JLabel JL287;
    private JLabel JL288;
    private JLabel JL289;
    private JLabel JL29;
    private JLabel JL290;
    private JLabel JL291;
    private JLabel JL292;
    private JLabel JL293;
    private JLabel JL294;
    private JLabel JL295;
    private JLabel JL296;
    private JLabel JL297;
    private JLabel JL298;
    private JLabel JL299;
    private JLabel JL3;
    private JLabel JL30;
    private JLabel JL300;
    private JLabel JL301;
    private JLabel JL302;
    private JLabel JL303;
    private JLabel JL304;
    private JLabel JL305;
    private JLabel JL306;
    private JLabel JL307;
    private JLabel JL308;
    private JLabel JL309;
    private JLabel JL31;
    private JLabel JL310;
    private JLabel JL311;
    private JLabel JL312;
    private JLabel JL313;
    private JLabel JL314;
    private JLabel JL315;
    private JLabel JL316;
    private JLabel JL317;
    private JLabel JL318;
    private JLabel JL319;
    private JLabel JL32;
    private JLabel JL320;
    private JLabel JL321;
    private JLabel JL322;
    private JLabel JL323;
    private JLabel JL324;
    private JLabel JL325;
    private JLabel JL326;
    private JLabel JL327;
    private JLabel JL328;
    private JLabel JL329;
    private JLabel JL33;
    private JLabel JL330;
    private JLabel JL331;
    private JLabel JL332;
    private JLabel JL333;
    private JLabel JL334;
    private JLabel JL335;
    private JLabel JL336;
    private JLabel JL34;
    private JLabel JL35;
    private JLabel JL36;
    private JLabel JL37;
    private JLabel JL38;
    private JLabel JL39;
    private JLabel JL4;
    private JLabel JL40;
    private JLabel JL41;
    private JLabel JL42;
    private JLabel JL43;
    private JLabel JL44;
    private JLabel JL45;
    private JLabel JL46;
    private JLabel JL47;
    private JLabel JL48;
    private JLabel JL49;
    private JLabel JL5;
    private JLabel JL50;
    private JLabel JL51;
    private JLabel JL52;
    private JLabel JL53;
    private JLabel JL54;
    private JLabel JL55;
    private JLabel JL56;
    private JLabel JL57;
    private JLabel JL58;
    private JLabel JL59;
    private JLabel JL6;
    private JLabel JL60;
    private JLabel JL61;
    private JLabel JL62;
    private JLabel JL63;
    private JLabel JL64;
    private JLabel JL65;
    private JLabel JL66;
    private JLabel JL67;
    private JLabel JL68;
    private JLabel JL69;
    private JLabel JL7;
    private JLabel JL70;
    private JLabel JL71;
    private JLabel JL72;
    private JLabel JL73;
    private JLabel JL74;
    private JLabel JL75;
    private JLabel JL76;
    private JLabel JL77;
    private JLabel JL78;
    private JLabel JL79;
    private JLabel JL8;
    private JLabel JL80;
    private JLabel JL81;
    private JLabel JL82;
    private JLabel JL83;
    private JLabel JL84;
    private JLabel JL85;
    private JLabel JL86;
    private JLabel JL87;
    private JLabel JL88;
    private JLabel JL89;
    private JLabel JL9;
    private JLabel JL90;
    private JLabel JL91;
    private JLabel JL92;
    private JLabel JL93;
    private JLabel JL94;
    private JLabel JL95;
    private JLabel JL96;
    private JLabel JL97;
    private JLabel JL98;
    private JLabel JL99;
    private JLabel JLDBlanco1;
    private JLabel JLDBlanco10;
    private JLabel JLDBlanco11;
    private JLabel JLDBlanco12;
    private JLabel JLDBlanco13;
    private JLabel JLDBlanco14;
    private JLabel JLDBlanco15;
    private JLabel JLDBlanco16;
    private JLabel JLDBlanco17;
    private JLabel JLDBlanco18;
    private JLabel JLDBlanco19;
    private JLabel JLDBlanco2;
    private JLabel JLDBlanco20;
    private JLabel JLDBlanco21;
    private JLabel JLDBlanco22;
    private JLabel JLDBlanco23;
    private JLabel JLDBlanco24;
    private JLabel JLDBlanco25;
    private JLabel JLDBlanco26;
    private JLabel JLDBlanco27;
    private JLabel JLDBlanco28;
    private JLabel JLDBlanco29;
    private JLabel JLDBlanco3;
    private JLabel JLDBlanco30;
    private JLabel JLDBlanco31;
    private JLabel JLDBlanco32;
    private JLabel JLDBlanco4;
    private JLabel JLDBlanco5;
    private JLabel JLDBlanco6;
    private JLabel JLDBlanco65;
    private JLabel JLDBlanco66;
    private JLabel JLDBlanco67;
    private JLabel JLDBlanco68;
    private JLabel JLDBlanco69;
    private JLabel JLDBlanco7;
    private JLabel JLDBlanco70;
    private JLabel JLDBlanco71;
    private JLabel JLDBlanco72;
    private JLabel JLDBlanco73;
    private JLabel JLDBlanco74;
    private JLabel JLDBlanco75;
    private JLabel JLDBlanco76;
    private JLabel JLDBlanco77;
    private JLabel JLDBlanco78;
    private JLabel JLDBlanco79;
    private JLabel JLDBlanco8;
    private JLabel JLDBlanco80;
    private JLabel JLDBlanco81;
    private JLabel JLDBlanco82;
    private JLabel JLDBlanco83;
    private JLabel JLDBlanco84;
    private JLabel JLDBlanco9;
    private JPanel JP1;
    private JPanel JP10;
    private JPanel JP11;
    private JPanel JP12;
    private JPanel JP13;
    private JPanel JP14;
    private JPanel JP15;
    private JPanel JP16;
    private JPanel JP17;
    private JPanel JP18;
    private JPanel JP19;
    private JPanel JP2;
    private JPanel JP20;
    private JPanel JP21;
    private JPanel JP22;
    private JPanel JP23;
    private JPanel JP24;
    private JPanel JP25;
    private JPanel JP26;
    private JPanel JP27;
    private JPanel JP28;
    private JPanel JP29;
    private JPanel JP3;
    private JPanel JP30;
    private JPanel JP31;
    private JPanel JP32;
    private JPanel JP4;
    private JPanel JP5;
    private JPanel JP6;
    private JPanel JP65;
    private JPanel JP66;
    private JPanel JP67;
    private JPanel JP68;
    private JPanel JP69;
    private JPanel JP7;
    private JPanel JP70;
    private JPanel JP71;
    private JPanel JP72;
    private JPanel JP73;
    private JPanel JP74;
    private JPanel JP75;
    private JPanel JP76;
    private JPanel JP77;
    private JPanel JP78;
    private JPanel JP79;
    private JPanel JP8;
    private JPanel JP80;
    private JPanel JP81;
    private JPanel JP82;
    private JPanel JP83;
    private JPanel JP84;
    private JPanel JP9;
    public JPanel JPImOdontograma;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel33;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel66;
    private JLabel jLabel67;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel7;
    private JLabel jLabel70;
    private JLabel jLabel71;
    private JLabel jLabel72;
    private JLabel jLabel73;
    private JLabel jLabel74;
    private JLabel jLabel75;
    private JLabel jLabel76;
    private JLabel jLabel77;
    private JLabel jLabel78;
    private JLabel jLabel79;
    private JLabel jLabel8;
    private JLabel jLabel80;
    private JLabel jLabel81;
    private JLabel jLabel82;
    private JLabel jLabel83;
    private JLabel jLabel84;
    private JLabel jLabel85;
    private JLabel jLabel9;

    public JPOdontogramaCPCompleto() {
        initComponents();
        System.out.println("----->Entró al panel de Control Placa<----");
    }

    private void initComponents() {
        this.JPImOdontograma = new JPanel();
        this.JP1 = new JPanel();
        this.JL4 = new JLabel();
        this.JL3 = new JLabel();
        this.JL2 = new JLabel();
        this.JL1 = new JLabel();
        this.JLDBlanco1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JP2 = new JPanel();
        this.JL5 = new JLabel();
        this.JL6 = new JLabel();
        this.JL7 = new JLabel();
        this.JL8 = new JLabel();
        this.JLDBlanco2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JP3 = new JPanel();
        this.JL9 = new JLabel();
        this.JL10 = new JLabel();
        this.JL11 = new JLabel();
        this.JL12 = new JLabel();
        this.JLDBlanco3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JP4 = new JPanel();
        this.JL13 = new JLabel();
        this.JL14 = new JLabel();
        this.JL15 = new JLabel();
        this.JL16 = new JLabel();
        this.JLDBlanco4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JP5 = new JPanel();
        this.JL17 = new JLabel();
        this.JL18 = new JLabel();
        this.JL19 = new JLabel();
        this.JL20 = new JLabel();
        this.JLDBlanco5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.JP6 = new JPanel();
        this.JL21 = new JLabel();
        this.JL22 = new JLabel();
        this.JL23 = new JLabel();
        this.JL24 = new JLabel();
        this.JLDBlanco6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.JP7 = new JPanel();
        this.JL25 = new JLabel();
        this.JL26 = new JLabel();
        this.JL27 = new JLabel();
        this.JL28 = new JLabel();
        this.JLDBlanco7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.JP8 = new JPanel();
        this.JL29 = new JLabel();
        this.JL30 = new JLabel();
        this.JL31 = new JLabel();
        this.JL32 = new JLabel();
        this.JLDBlanco8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.JP9 = new JPanel();
        this.JL33 = new JLabel();
        this.JL34 = new JLabel();
        this.JL35 = new JLabel();
        this.JL36 = new JLabel();
        this.JLDBlanco9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.JP10 = new JPanel();
        this.JL37 = new JLabel();
        this.JL38 = new JLabel();
        this.JL39 = new JLabel();
        this.JL40 = new JLabel();
        this.JLDBlanco10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.JP11 = new JPanel();
        this.JL41 = new JLabel();
        this.JL42 = new JLabel();
        this.JL43 = new JLabel();
        this.JL44 = new JLabel();
        this.JLDBlanco11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JP12 = new JPanel();
        this.JL45 = new JLabel();
        this.JL46 = new JLabel();
        this.JL47 = new JLabel();
        this.JL48 = new JLabel();
        this.JLDBlanco12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.JP13 = new JPanel();
        this.JL49 = new JLabel();
        this.JL50 = new JLabel();
        this.JL51 = new JLabel();
        this.JL52 = new JLabel();
        this.JLDBlanco13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.JP14 = new JPanel();
        this.JL53 = new JLabel();
        this.JL54 = new JLabel();
        this.JL55 = new JLabel();
        this.JL56 = new JLabel();
        this.JLDBlanco14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.JP15 = new JPanel();
        this.JL57 = new JLabel();
        this.JL58 = new JLabel();
        this.JL59 = new JLabel();
        this.JL60 = new JLabel();
        this.JLDBlanco15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.JP16 = new JPanel();
        this.JL61 = new JLabel();
        this.JL62 = new JLabel();
        this.JL63 = new JLabel();
        this.JL64 = new JLabel();
        this.JLDBlanco16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel18 = new JLabel();
        this.JP17 = new JPanel();
        this.JL65 = new JLabel();
        this.JL66 = new JLabel();
        this.JL67 = new JLabel();
        this.JL68 = new JLabel();
        this.JLDBlanco17 = new JLabel();
        this.jLabel19 = new JLabel();
        this.JP18 = new JPanel();
        this.JL69 = new JLabel();
        this.JL70 = new JLabel();
        this.JL71 = new JLabel();
        this.JL72 = new JLabel();
        this.JLDBlanco18 = new JLabel();
        this.jLabel20 = new JLabel();
        this.JP19 = new JPanel();
        this.JL73 = new JLabel();
        this.JL74 = new JLabel();
        this.JL75 = new JLabel();
        this.JL76 = new JLabel();
        this.JLDBlanco19 = new JLabel();
        this.jLabel21 = new JLabel();
        this.JP20 = new JPanel();
        this.JL77 = new JLabel();
        this.JL78 = new JLabel();
        this.JL79 = new JLabel();
        this.JL80 = new JLabel();
        this.JLDBlanco20 = new JLabel();
        this.jLabel22 = new JLabel();
        this.JP21 = new JPanel();
        this.JL81 = new JLabel();
        this.JL82 = new JLabel();
        this.JL83 = new JLabel();
        this.JL84 = new JLabel();
        this.JLDBlanco21 = new JLabel();
        this.jLabel23 = new JLabel();
        this.JP22 = new JPanel();
        this.JL85 = new JLabel();
        this.JL86 = new JLabel();
        this.JL87 = new JLabel();
        this.JL88 = new JLabel();
        this.JLDBlanco22 = new JLabel();
        this.jLabel24 = new JLabel();
        this.JP23 = new JPanel();
        this.JL89 = new JLabel();
        this.JL90 = new JLabel();
        this.JL91 = new JLabel();
        this.JL92 = new JLabel();
        this.JLDBlanco23 = new JLabel();
        this.jLabel25 = new JLabel();
        this.JP24 = new JPanel();
        this.JL93 = new JLabel();
        this.JL94 = new JLabel();
        this.JL95 = new JLabel();
        this.JL96 = new JLabel();
        this.JLDBlanco24 = new JLabel();
        this.jLabel26 = new JLabel();
        this.JP25 = new JPanel();
        this.JL97 = new JLabel();
        this.JL98 = new JLabel();
        this.JL99 = new JLabel();
        this.JL100 = new JLabel();
        this.JLDBlanco25 = new JLabel();
        this.jLabel27 = new JLabel();
        this.JP26 = new JPanel();
        this.JL101 = new JLabel();
        this.JL102 = new JLabel();
        this.JL103 = new JLabel();
        this.JL104 = new JLabel();
        this.JLDBlanco26 = new JLabel();
        this.jLabel28 = new JLabel();
        this.JP27 = new JPanel();
        this.JL105 = new JLabel();
        this.JL106 = new JLabel();
        this.JL107 = new JLabel();
        this.JL108 = new JLabel();
        this.JLDBlanco27 = new JLabel();
        this.jLabel29 = new JLabel();
        this.JP28 = new JPanel();
        this.JL109 = new JLabel();
        this.JL110 = new JLabel();
        this.JL111 = new JLabel();
        this.JL112 = new JLabel();
        this.JLDBlanco28 = new JLabel();
        this.jLabel30 = new JLabel();
        this.JP29 = new JPanel();
        this.JL113 = new JLabel();
        this.JL114 = new JLabel();
        this.JL115 = new JLabel();
        this.JL116 = new JLabel();
        this.JLDBlanco29 = new JLabel();
        this.jLabel31 = new JLabel();
        this.JP30 = new JPanel();
        this.JL117 = new JLabel();
        this.JL118 = new JLabel();
        this.JL119 = new JLabel();
        this.JL120 = new JLabel();
        this.JLDBlanco30 = new JLabel();
        this.jLabel32 = new JLabel();
        this.JP31 = new JPanel();
        this.JL121 = new JLabel();
        this.JL122 = new JLabel();
        this.JL123 = new JLabel();
        this.JL124 = new JLabel();
        this.JLDBlanco31 = new JLabel();
        this.jLabel33 = new JLabel();
        this.JP32 = new JPanel();
        this.JL125 = new JLabel();
        this.JL126 = new JLabel();
        this.JL127 = new JLabel();
        this.JL128 = new JLabel();
        this.JLDBlanco32 = new JLabel();
        this.jLabel66 = new JLabel();
        this.JP66 = new JPanel();
        this.JL261 = new JLabel();
        this.JL262 = new JLabel();
        this.JL263 = new JLabel();
        this.JL264 = new JLabel();
        this.JLDBlanco66 = new JLabel();
        this.jLabel67 = new JLabel();
        this.JP67 = new JPanel();
        this.JL265 = new JLabel();
        this.JL266 = new JLabel();
        this.JL267 = new JLabel();
        this.JL268 = new JLabel();
        this.JLDBlanco67 = new JLabel();
        this.jLabel68 = new JLabel();
        this.JP68 = new JPanel();
        this.JL269 = new JLabel();
        this.JL270 = new JLabel();
        this.JL271 = new JLabel();
        this.JL272 = new JLabel();
        this.JLDBlanco68 = new JLabel();
        this.jLabel69 = new JLabel();
        this.JP69 = new JPanel();
        this.JL273 = new JLabel();
        this.JL274 = new JLabel();
        this.JL275 = new JLabel();
        this.JL276 = new JLabel();
        this.JLDBlanco69 = new JLabel();
        this.jLabel70 = new JLabel();
        this.JP65 = new JPanel();
        this.JL257 = new JLabel();
        this.JL258 = new JLabel();
        this.JL259 = new JLabel();
        this.JL260 = new JLabel();
        this.JLDBlanco65 = new JLabel();
        this.JP70 = new JPanel();
        this.JL277 = new JLabel();
        this.JL278 = new JLabel();
        this.JL279 = new JLabel();
        this.JL280 = new JLabel();
        this.JLDBlanco70 = new JLabel();
        this.jLabel71 = new JLabel();
        this.JP71 = new JPanel();
        this.JL281 = new JLabel();
        this.JL282 = new JLabel();
        this.JL283 = new JLabel();
        this.JL284 = new JLabel();
        this.JLDBlanco71 = new JLabel();
        this.jLabel72 = new JLabel();
        this.JP72 = new JPanel();
        this.JL285 = new JLabel();
        this.JL286 = new JLabel();
        this.JL287 = new JLabel();
        this.JL288 = new JLabel();
        this.JLDBlanco72 = new JLabel();
        this.jLabel73 = new JLabel();
        this.JP73 = new JPanel();
        this.JL289 = new JLabel();
        this.JL290 = new JLabel();
        this.JL291 = new JLabel();
        this.JL292 = new JLabel();
        this.JLDBlanco73 = new JLabel();
        this.jLabel74 = new JLabel();
        this.JP74 = new JPanel();
        this.JL293 = new JLabel();
        this.JL294 = new JLabel();
        this.JL295 = new JLabel();
        this.JL296 = new JLabel();
        this.JLDBlanco74 = new JLabel();
        this.jLabel75 = new JLabel();
        this.JP75 = new JPanel();
        this.JL297 = new JLabel();
        this.JL298 = new JLabel();
        this.JL299 = new JLabel();
        this.JL300 = new JLabel();
        this.JLDBlanco75 = new JLabel();
        this.JP76 = new JPanel();
        this.JL301 = new JLabel();
        this.JL302 = new JLabel();
        this.JL303 = new JLabel();
        this.JL304 = new JLabel();
        this.JLDBlanco76 = new JLabel();
        this.JP77 = new JPanel();
        this.JL305 = new JLabel();
        this.JL306 = new JLabel();
        this.JL307 = new JLabel();
        this.JL308 = new JLabel();
        this.JLDBlanco77 = new JLabel();
        this.jLabel76 = new JLabel();
        this.jLabel77 = new JLabel();
        this.jLabel78 = new JLabel();
        this.jLabel79 = new JLabel();
        this.JP78 = new JPanel();
        this.JL309 = new JLabel();
        this.JL310 = new JLabel();
        this.JL311 = new JLabel();
        this.JL312 = new JLabel();
        this.JLDBlanco78 = new JLabel();
        this.JP79 = new JPanel();
        this.JL313 = new JLabel();
        this.JL314 = new JLabel();
        this.JL315 = new JLabel();
        this.JL316 = new JLabel();
        this.JLDBlanco79 = new JLabel();
        this.JP80 = new JPanel();
        this.JL317 = new JLabel();
        this.JL318 = new JLabel();
        this.JL319 = new JLabel();
        this.JL320 = new JLabel();
        this.JLDBlanco80 = new JLabel();
        this.jLabel80 = new JLabel();
        this.JP81 = new JPanel();
        this.JL321 = new JLabel();
        this.JL322 = new JLabel();
        this.JL323 = new JLabel();
        this.JL324 = new JLabel();
        this.JLDBlanco81 = new JLabel();
        this.jLabel81 = new JLabel();
        this.jLabel82 = new JLabel();
        this.jLabel83 = new JLabel();
        this.JP82 = new JPanel();
        this.JL325 = new JLabel();
        this.JL326 = new JLabel();
        this.JL327 = new JLabel();
        this.JL328 = new JLabel();
        this.JLDBlanco82 = new JLabel();
        this.JP83 = new JPanel();
        this.JL329 = new JLabel();
        this.JL330 = new JLabel();
        this.JL331 = new JLabel();
        this.JL332 = new JLabel();
        this.JLDBlanco83 = new JLabel();
        this.JP84 = new JPanel();
        this.JL333 = new JLabel();
        this.JL334 = new JLabel();
        this.JL335 = new JLabel();
        this.JL336 = new JLabel();
        this.JLDBlanco84 = new JLabel();
        this.jLabel84 = new JLabel();
        this.jLabel85 = new JLabel();
        this.JPImOdontograma.setBackground(new Color(255, 255, 255));
        this.JP1.setMaximumSize(new Dimension(41, 45));
        this.JP1.setMinimumSize(new Dimension(41, 45));
        this.JP1.setName("18");
        this.JP1.setOpaque(false);
        this.JP1.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP1MouseClicked(evt);
            }
        });
        this.JP1.setLayout((LayoutManager) null);
        this.JL4.setMaximumSize(new Dimension(41, 45));
        this.JL4.setMinimumSize(new Dimension(41, 45));
        this.JL4.setName("4");
        this.JL4.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL4);
        this.JL4.setBounds(0, 0, 41, 45);
        this.JL3.setMaximumSize(new Dimension(41, 45));
        this.JL3.setMinimumSize(new Dimension(41, 45));
        this.JL3.setName("3");
        this.JL3.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL3);
        this.JL3.setBounds(0, 0, 41, 45);
        this.JL2.setMaximumSize(new Dimension(41, 45));
        this.JL2.setMinimumSize(new Dimension(41, 45));
        this.JL2.setName("2");
        this.JL2.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL2);
        this.JL2.setBounds(0, 0, 41, 45);
        this.JL1.setMaximumSize(new Dimension(41, 45));
        this.JL1.setMinimumSize(new Dimension(41, 45));
        this.JL1.setName("1");
        this.JL1.setPreferredSize(new Dimension(41, 45));
        this.JP1.add(this.JL1);
        this.JL1.setBounds(0, 0, 41, 45);
        this.JLDBlanco1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco1.setName("0");
        this.JP1.add(this.JLDBlanco1);
        this.JLDBlanco1.setBounds(0, 0, 41, 45);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("18");
        this.JP2.setMaximumSize(new Dimension(41, 45));
        this.JP2.setMinimumSize(new Dimension(41, 45));
        this.JP2.setName("17");
        this.JP2.setOpaque(false);
        this.JP2.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.2
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP2MouseClicked(evt);
            }
        });
        this.JP2.setLayout((LayoutManager) null);
        this.JL5.setMaximumSize(new Dimension(41, 45));
        this.JL5.setMinimumSize(new Dimension(41, 45));
        this.JL5.setName("4");
        this.JL5.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL5);
        this.JL5.setBounds(0, 0, 41, 45);
        this.JL6.setMaximumSize(new Dimension(41, 45));
        this.JL6.setMinimumSize(new Dimension(41, 45));
        this.JL6.setName("3");
        this.JL6.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL6);
        this.JL6.setBounds(0, 0, 41, 45);
        this.JL7.setMaximumSize(new Dimension(41, 45));
        this.JL7.setMinimumSize(new Dimension(41, 45));
        this.JL7.setName("2");
        this.JL7.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL7);
        this.JL7.setBounds(0, 0, 41, 45);
        this.JL8.setMaximumSize(new Dimension(41, 45));
        this.JL8.setMinimumSize(new Dimension(41, 45));
        this.JL8.setName("1");
        this.JL8.setPreferredSize(new Dimension(41, 45));
        this.JP2.add(this.JL8);
        this.JL8.setBounds(0, 0, 41, 45);
        this.JLDBlanco2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco2.setName("0");
        this.JP2.add(this.JLDBlanco2);
        this.JLDBlanco2.setBounds(0, 0, 41, 45);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("17");
        this.JP3.setMaximumSize(new Dimension(41, 45));
        this.JP3.setMinimumSize(new Dimension(41, 45));
        this.JP3.setName("16");
        this.JP3.setOpaque(false);
        this.JP3.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.3
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP3MouseClicked(evt);
            }
        });
        this.JP3.setLayout((LayoutManager) null);
        this.JL9.setMaximumSize(new Dimension(41, 45));
        this.JL9.setMinimumSize(new Dimension(41, 45));
        this.JL9.setName("4");
        this.JL9.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL9);
        this.JL9.setBounds(0, 0, 41, 45);
        this.JL10.setMaximumSize(new Dimension(41, 45));
        this.JL10.setMinimumSize(new Dimension(41, 45));
        this.JL10.setName("3");
        this.JL10.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL10);
        this.JL10.setBounds(0, 0, 41, 45);
        this.JL11.setMaximumSize(new Dimension(41, 45));
        this.JL11.setMinimumSize(new Dimension(41, 45));
        this.JL11.setName("2");
        this.JL11.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL11);
        this.JL11.setBounds(0, 0, 41, 45);
        this.JL12.setMaximumSize(new Dimension(41, 45));
        this.JL12.setMinimumSize(new Dimension(41, 45));
        this.JL12.setName("1");
        this.JL12.setPreferredSize(new Dimension(41, 45));
        this.JP3.add(this.JL12);
        this.JL12.setBounds(0, 0, 41, 45);
        this.JLDBlanco3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco3.setName("0");
        this.JP3.add(this.JLDBlanco3);
        this.JLDBlanco3.setBounds(0, 0, 41, 45);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("16");
        this.JP4.setMaximumSize(new Dimension(41, 45));
        this.JP4.setMinimumSize(new Dimension(41, 45));
        this.JP4.setName("15");
        this.JP4.setOpaque(false);
        this.JP4.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.4
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP4MouseClicked(evt);
            }
        });
        this.JP4.setLayout((LayoutManager) null);
        this.JL13.setMaximumSize(new Dimension(41, 45));
        this.JL13.setMinimumSize(new Dimension(41, 45));
        this.JL13.setName("4");
        this.JL13.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL13);
        this.JL13.setBounds(0, 0, 41, 45);
        this.JL14.setMaximumSize(new Dimension(41, 45));
        this.JL14.setMinimumSize(new Dimension(41, 45));
        this.JL14.setName("3");
        this.JL14.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL14);
        this.JL14.setBounds(0, 0, 41, 45);
        this.JL15.setMaximumSize(new Dimension(41, 45));
        this.JL15.setMinimumSize(new Dimension(41, 45));
        this.JL15.setName("2");
        this.JL15.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL15);
        this.JL15.setBounds(0, 0, 41, 45);
        this.JL16.setMaximumSize(new Dimension(41, 45));
        this.JL16.setMinimumSize(new Dimension(41, 45));
        this.JL16.setName("1");
        this.JL16.setPreferredSize(new Dimension(41, 45));
        this.JP4.add(this.JL16);
        this.JL16.setBounds(0, 0, 41, 45);
        this.JLDBlanco4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco4.setName("0");
        this.JP4.add(this.JLDBlanco4);
        this.JLDBlanco4.setBounds(0, 0, 41, 45);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("15");
        this.JP5.setMaximumSize(new Dimension(41, 45));
        this.JP5.setMinimumSize(new Dimension(41, 45));
        this.JP5.setName("14");
        this.JP5.setOpaque(false);
        this.JP5.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.5
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP5MouseClicked(evt);
            }
        });
        this.JP5.setLayout((LayoutManager) null);
        this.JL17.setMaximumSize(new Dimension(41, 45));
        this.JL17.setMinimumSize(new Dimension(41, 45));
        this.JL17.setName("4");
        this.JL17.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL17);
        this.JL17.setBounds(0, 0, 41, 45);
        this.JL18.setMaximumSize(new Dimension(41, 45));
        this.JL18.setMinimumSize(new Dimension(41, 45));
        this.JL18.setName("3");
        this.JL18.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL18);
        this.JL18.setBounds(0, 0, 41, 45);
        this.JL19.setMaximumSize(new Dimension(41, 45));
        this.JL19.setMinimumSize(new Dimension(41, 45));
        this.JL19.setName("2");
        this.JL19.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL19);
        this.JL19.setBounds(0, 0, 41, 45);
        this.JL20.setMaximumSize(new Dimension(41, 45));
        this.JL20.setMinimumSize(new Dimension(41, 45));
        this.JL20.setName("1");
        this.JL20.setPreferredSize(new Dimension(41, 45));
        this.JP5.add(this.JL20);
        this.JL20.setBounds(0, 0, 41, 45);
        this.JLDBlanco5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco5.setName("0");
        this.JP5.add(this.JLDBlanco5);
        this.JLDBlanco5.setBounds(0, 0, 41, 45);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setHorizontalAlignment(0);
        this.jLabel6.setText("14");
        this.JP6.setMaximumSize(new Dimension(41, 45));
        this.JP6.setMinimumSize(new Dimension(41, 45));
        this.JP6.setName("13");
        this.JP6.setOpaque(false);
        this.JP6.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.6
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP6MouseClicked(evt);
            }
        });
        this.JP6.setLayout((LayoutManager) null);
        this.JL21.setMaximumSize(new Dimension(41, 45));
        this.JL21.setMinimumSize(new Dimension(41, 45));
        this.JL21.setName("4");
        this.JL21.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL21);
        this.JL21.setBounds(0, 0, 41, 45);
        this.JL22.setMaximumSize(new Dimension(41, 45));
        this.JL22.setMinimumSize(new Dimension(41, 45));
        this.JL22.setName("3");
        this.JL22.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL22);
        this.JL22.setBounds(0, 0, 41, 45);
        this.JL23.setMaximumSize(new Dimension(41, 45));
        this.JL23.setMinimumSize(new Dimension(41, 45));
        this.JL23.setName("2");
        this.JL23.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL23);
        this.JL23.setBounds(0, 0, 41, 45);
        this.JL24.setMaximumSize(new Dimension(41, 45));
        this.JL24.setMinimumSize(new Dimension(41, 45));
        this.JL24.setName("1");
        this.JL24.setPreferredSize(new Dimension(41, 45));
        this.JP6.add(this.JL24);
        this.JL24.setBounds(0, 0, 41, 45);
        this.JLDBlanco6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco6.setName("0");
        this.JP6.add(this.JLDBlanco6);
        this.JLDBlanco6.setBounds(0, 0, 41, 45);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setHorizontalAlignment(0);
        this.jLabel7.setText("13");
        this.JP7.setMaximumSize(new Dimension(41, 45));
        this.JP7.setMinimumSize(new Dimension(41, 45));
        this.JP7.setName("12");
        this.JP7.setOpaque(false);
        this.JP7.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.7
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP7MouseClicked(evt);
            }
        });
        this.JP7.setLayout((LayoutManager) null);
        this.JL25.setMaximumSize(new Dimension(41, 45));
        this.JL25.setMinimumSize(new Dimension(41, 45));
        this.JL25.setName("4");
        this.JL25.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL25);
        this.JL25.setBounds(0, 0, 41, 45);
        this.JL26.setMaximumSize(new Dimension(41, 45));
        this.JL26.setMinimumSize(new Dimension(41, 45));
        this.JL26.setName("3");
        this.JL26.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL26);
        this.JL26.setBounds(0, 0, 41, 45);
        this.JL27.setMaximumSize(new Dimension(41, 45));
        this.JL27.setMinimumSize(new Dimension(41, 45));
        this.JL27.setName("2");
        this.JL27.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL27);
        this.JL27.setBounds(0, 0, 41, 45);
        this.JL28.setMaximumSize(new Dimension(41, 45));
        this.JL28.setMinimumSize(new Dimension(41, 45));
        this.JL28.setName("1");
        this.JL28.setPreferredSize(new Dimension(41, 45));
        this.JP7.add(this.JL28);
        this.JL28.setBounds(0, 0, 41, 45);
        this.JLDBlanco7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco7.setName("0");
        this.JP7.add(this.JLDBlanco7);
        this.JLDBlanco7.setBounds(0, 0, 41, 45);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("12");
        this.JP8.setMaximumSize(new Dimension(41, 45));
        this.JP8.setMinimumSize(new Dimension(41, 45));
        this.JP8.setName("11");
        this.JP8.setOpaque(false);
        this.JP8.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.8
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP8MouseClicked(evt);
            }
        });
        this.JP8.setLayout((LayoutManager) null);
        this.JL29.setMaximumSize(new Dimension(41, 45));
        this.JL29.setMinimumSize(new Dimension(41, 45));
        this.JL29.setName("4");
        this.JL29.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL29);
        this.JL29.setBounds(0, 0, 41, 45);
        this.JL30.setMaximumSize(new Dimension(41, 45));
        this.JL30.setMinimumSize(new Dimension(41, 45));
        this.JL30.setName("3");
        this.JL30.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL30);
        this.JL30.setBounds(0, 0, 41, 45);
        this.JL31.setMaximumSize(new Dimension(41, 45));
        this.JL31.setMinimumSize(new Dimension(41, 45));
        this.JL31.setName("2");
        this.JL31.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL31);
        this.JL31.setBounds(0, 0, 41, 45);
        this.JL32.setMaximumSize(new Dimension(41, 45));
        this.JL32.setMinimumSize(new Dimension(41, 45));
        this.JL32.setName("1");
        this.JL32.setPreferredSize(new Dimension(41, 45));
        this.JP8.add(this.JL32);
        this.JL32.setBounds(0, 0, 41, 45);
        this.JLDBlanco8.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco8.setName("0");
        this.JP8.add(this.JLDBlanco8);
        this.JLDBlanco8.setBounds(0, 0, 41, 45);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setHorizontalAlignment(0);
        this.jLabel9.setText("11");
        this.JP9.setMaximumSize(new Dimension(41, 45));
        this.JP9.setMinimumSize(new Dimension(41, 45));
        this.JP9.setName("21");
        this.JP9.setOpaque(false);
        this.JP9.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.9
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP9MouseClicked(evt);
            }
        });
        this.JP9.setLayout((LayoutManager) null);
        this.JL33.setMaximumSize(new Dimension(41, 45));
        this.JL33.setMinimumSize(new Dimension(41, 45));
        this.JL33.setName("4");
        this.JL33.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL33);
        this.JL33.setBounds(0, 0, 41, 45);
        this.JL34.setMaximumSize(new Dimension(41, 45));
        this.JL34.setMinimumSize(new Dimension(41, 45));
        this.JL34.setName("3");
        this.JL34.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL34);
        this.JL34.setBounds(0, 0, 41, 45);
        this.JL35.setMaximumSize(new Dimension(41, 45));
        this.JL35.setMinimumSize(new Dimension(41, 45));
        this.JL35.setName("2");
        this.JL35.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL35);
        this.JL35.setBounds(0, 0, 41, 45);
        this.JL36.setMaximumSize(new Dimension(41, 45));
        this.JL36.setMinimumSize(new Dimension(41, 45));
        this.JL36.setName("1");
        this.JL36.setPreferredSize(new Dimension(41, 45));
        this.JP9.add(this.JL36);
        this.JL36.setBounds(0, 0, 41, 45);
        this.JLDBlanco9.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco9.setName("0");
        this.JP9.add(this.JLDBlanco9);
        this.JLDBlanco9.setBounds(0, 0, 41, 45);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setHorizontalAlignment(0);
        this.jLabel10.setText("21");
        this.JP10.setMaximumSize(new Dimension(41, 45));
        this.JP10.setMinimumSize(new Dimension(41, 45));
        this.JP10.setName("22");
        this.JP10.setOpaque(false);
        this.JP10.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.10
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP10MouseClicked(evt);
            }
        });
        this.JP10.setLayout((LayoutManager) null);
        this.JL37.setMaximumSize(new Dimension(41, 45));
        this.JL37.setMinimumSize(new Dimension(41, 45));
        this.JL37.setName("4");
        this.JL37.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL37);
        this.JL37.setBounds(0, 0, 41, 45);
        this.JL38.setMaximumSize(new Dimension(41, 45));
        this.JL38.setMinimumSize(new Dimension(41, 45));
        this.JL38.setName("3");
        this.JL38.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL38);
        this.JL38.setBounds(0, 0, 41, 45);
        this.JL39.setMaximumSize(new Dimension(41, 45));
        this.JL39.setMinimumSize(new Dimension(41, 45));
        this.JL39.setName("2");
        this.JL39.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL39);
        this.JL39.setBounds(0, 0, 41, 45);
        this.JL40.setMaximumSize(new Dimension(41, 45));
        this.JL40.setMinimumSize(new Dimension(41, 45));
        this.JL40.setName("1");
        this.JL40.setPreferredSize(new Dimension(41, 45));
        this.JP10.add(this.JL40);
        this.JL40.setBounds(0, 0, 41, 45);
        this.JLDBlanco10.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco10.setName("0");
        this.JP10.add(this.JLDBlanco10);
        this.JLDBlanco10.setBounds(0, 0, 41, 45);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setHorizontalAlignment(0);
        this.jLabel11.setText("22");
        this.JP11.setMaximumSize(new Dimension(41, 45));
        this.JP11.setMinimumSize(new Dimension(41, 45));
        this.JP11.setName("23");
        this.JP11.setOpaque(false);
        this.JP11.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.11
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP11MouseClicked(evt);
            }
        });
        this.JP11.setLayout((LayoutManager) null);
        this.JL41.setMaximumSize(new Dimension(41, 45));
        this.JL41.setMinimumSize(new Dimension(41, 45));
        this.JL41.setName("4");
        this.JL41.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL41);
        this.JL41.setBounds(0, 0, 41, 45);
        this.JL42.setMaximumSize(new Dimension(41, 45));
        this.JL42.setMinimumSize(new Dimension(41, 45));
        this.JL42.setName("3");
        this.JL42.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL42);
        this.JL42.setBounds(0, 0, 41, 45);
        this.JL43.setMaximumSize(new Dimension(41, 45));
        this.JL43.setMinimumSize(new Dimension(41, 45));
        this.JL43.setName("2");
        this.JL43.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL43);
        this.JL43.setBounds(0, 0, 41, 45);
        this.JL44.setMaximumSize(new Dimension(41, 45));
        this.JL44.setMinimumSize(new Dimension(41, 45));
        this.JL44.setName("1");
        this.JL44.setPreferredSize(new Dimension(41, 45));
        this.JP11.add(this.JL44);
        this.JL44.setBounds(0, 0, 41, 45);
        this.JLDBlanco11.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco11.setName("0");
        this.JP11.add(this.JLDBlanco11);
        this.JLDBlanco11.setBounds(0, 0, 41, 45);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setHorizontalAlignment(0);
        this.jLabel12.setText("23");
        this.JP12.setMaximumSize(new Dimension(41, 45));
        this.JP12.setMinimumSize(new Dimension(41, 45));
        this.JP12.setName("24");
        this.JP12.setOpaque(false);
        this.JP12.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.12
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP12MouseClicked(evt);
            }
        });
        this.JP12.setLayout((LayoutManager) null);
        this.JL45.setMaximumSize(new Dimension(41, 45));
        this.JL45.setMinimumSize(new Dimension(41, 45));
        this.JL45.setName("4");
        this.JL45.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL45);
        this.JL45.setBounds(0, 0, 41, 45);
        this.JL46.setMaximumSize(new Dimension(41, 45));
        this.JL46.setMinimumSize(new Dimension(41, 45));
        this.JL46.setName("3");
        this.JL46.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL46);
        this.JL46.setBounds(0, 0, 41, 45);
        this.JL47.setMaximumSize(new Dimension(41, 45));
        this.JL47.setMinimumSize(new Dimension(41, 45));
        this.JL47.setName("2");
        this.JL47.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL47);
        this.JL47.setBounds(0, 0, 41, 45);
        this.JL48.setMaximumSize(new Dimension(41, 45));
        this.JL48.setMinimumSize(new Dimension(41, 45));
        this.JL48.setName("1");
        this.JL48.setPreferredSize(new Dimension(41, 45));
        this.JP12.add(this.JL48);
        this.JL48.setBounds(0, 0, 41, 45);
        this.JLDBlanco12.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco12.setName("0");
        this.JP12.add(this.JLDBlanco12);
        this.JLDBlanco12.setBounds(0, 0, 41, 45);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setHorizontalAlignment(0);
        this.jLabel13.setText("24");
        this.JP13.setMaximumSize(new Dimension(41, 45));
        this.JP13.setMinimumSize(new Dimension(41, 45));
        this.JP13.setName("25");
        this.JP13.setOpaque(false);
        this.JP13.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.13
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP13MouseClicked(evt);
            }
        });
        this.JP13.setLayout((LayoutManager) null);
        this.JL49.setMaximumSize(new Dimension(41, 45));
        this.JL49.setMinimumSize(new Dimension(41, 45));
        this.JL49.setName("4");
        this.JL49.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL49);
        this.JL49.setBounds(0, 0, 41, 45);
        this.JL50.setMaximumSize(new Dimension(41, 45));
        this.JL50.setMinimumSize(new Dimension(41, 45));
        this.JL50.setName("3");
        this.JL50.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL50);
        this.JL50.setBounds(0, 0, 41, 45);
        this.JL51.setMaximumSize(new Dimension(41, 45));
        this.JL51.setMinimumSize(new Dimension(41, 45));
        this.JL51.setName("2");
        this.JL51.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL51);
        this.JL51.setBounds(0, 0, 41, 45);
        this.JL52.setMaximumSize(new Dimension(41, 45));
        this.JL52.setMinimumSize(new Dimension(41, 45));
        this.JL52.setName("1");
        this.JL52.setPreferredSize(new Dimension(41, 45));
        this.JP13.add(this.JL52);
        this.JL52.setBounds(0, 0, 41, 45);
        this.JLDBlanco13.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco13.setName("0");
        this.JP13.add(this.JLDBlanco13);
        this.JLDBlanco13.setBounds(0, 0, 41, 45);
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setHorizontalAlignment(0);
        this.jLabel14.setText("25");
        this.JP14.setMaximumSize(new Dimension(41, 45));
        this.JP14.setMinimumSize(new Dimension(41, 45));
        this.JP14.setName("26");
        this.JP14.setOpaque(false);
        this.JP14.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.14
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP14MouseClicked(evt);
            }
        });
        this.JP14.setLayout((LayoutManager) null);
        this.JL53.setMaximumSize(new Dimension(41, 45));
        this.JL53.setMinimumSize(new Dimension(41, 45));
        this.JL53.setName("4");
        this.JL53.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL53);
        this.JL53.setBounds(0, 0, 41, 45);
        this.JL54.setMaximumSize(new Dimension(41, 45));
        this.JL54.setMinimumSize(new Dimension(41, 45));
        this.JL54.setName("3");
        this.JL54.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL54);
        this.JL54.setBounds(0, 0, 41, 45);
        this.JL55.setMaximumSize(new Dimension(41, 45));
        this.JL55.setMinimumSize(new Dimension(41, 45));
        this.JL55.setName("2");
        this.JL55.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL55);
        this.JL55.setBounds(0, 0, 41, 45);
        this.JL56.setMaximumSize(new Dimension(41, 45));
        this.JL56.setMinimumSize(new Dimension(41, 45));
        this.JL56.setName("1");
        this.JL56.setPreferredSize(new Dimension(41, 45));
        this.JP14.add(this.JL56);
        this.JL56.setBounds(0, 0, 41, 45);
        this.JLDBlanco14.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco14.setName("0");
        this.JP14.add(this.JLDBlanco14);
        this.JLDBlanco14.setBounds(0, 0, 41, 45);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setHorizontalAlignment(0);
        this.jLabel15.setText("26");
        this.JP15.setMaximumSize(new Dimension(41, 45));
        this.JP15.setMinimumSize(new Dimension(41, 45));
        this.JP15.setName("27");
        this.JP15.setOpaque(false);
        this.JP15.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.15
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP15MouseClicked(evt);
            }
        });
        this.JP15.setLayout((LayoutManager) null);
        this.JL57.setMaximumSize(new Dimension(41, 45));
        this.JL57.setMinimumSize(new Dimension(41, 45));
        this.JL57.setName("4");
        this.JL57.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL57);
        this.JL57.setBounds(0, 0, 41, 45);
        this.JL58.setMaximumSize(new Dimension(41, 45));
        this.JL58.setMinimumSize(new Dimension(41, 45));
        this.JL58.setName("3");
        this.JL58.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL58);
        this.JL58.setBounds(0, 0, 41, 45);
        this.JL59.setMaximumSize(new Dimension(41, 45));
        this.JL59.setMinimumSize(new Dimension(41, 45));
        this.JL59.setName("2");
        this.JL59.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL59);
        this.JL59.setBounds(0, 0, 41, 45);
        this.JL60.setMaximumSize(new Dimension(41, 45));
        this.JL60.setMinimumSize(new Dimension(41, 45));
        this.JL60.setName("1");
        this.JL60.setPreferredSize(new Dimension(41, 45));
        this.JP15.add(this.JL60);
        this.JL60.setBounds(0, 0, 41, 45);
        this.JLDBlanco15.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco15.setName("0");
        this.JP15.add(this.JLDBlanco15);
        this.JLDBlanco15.setBounds(0, 0, 41, 45);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setHorizontalAlignment(0);
        this.jLabel16.setText("27");
        this.JP16.setMaximumSize(new Dimension(41, 45));
        this.JP16.setMinimumSize(new Dimension(41, 45));
        this.JP16.setName("28");
        this.JP16.setOpaque(false);
        this.JP16.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.16
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP16MouseClicked(evt);
            }
        });
        this.JP16.setLayout((LayoutManager) null);
        this.JL61.setMaximumSize(new Dimension(41, 45));
        this.JL61.setMinimumSize(new Dimension(41, 45));
        this.JL61.setName("4");
        this.JL61.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL61);
        this.JL61.setBounds(0, 0, 41, 45);
        this.JL62.setMaximumSize(new Dimension(41, 45));
        this.JL62.setMinimumSize(new Dimension(41, 45));
        this.JL62.setName("3");
        this.JL62.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL62);
        this.JL62.setBounds(0, 0, 41, 45);
        this.JL63.setMaximumSize(new Dimension(41, 45));
        this.JL63.setMinimumSize(new Dimension(41, 45));
        this.JL63.setName("2");
        this.JL63.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL63);
        this.JL63.setBounds(0, 0, 41, 45);
        this.JL64.setMaximumSize(new Dimension(41, 45));
        this.JL64.setMinimumSize(new Dimension(41, 45));
        this.JL64.setName("1");
        this.JL64.setPreferredSize(new Dimension(41, 45));
        this.JP16.add(this.JL64);
        this.JL64.setBounds(0, 0, 41, 45);
        this.JLDBlanco16.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco16.setName("0");
        this.JP16.add(this.JLDBlanco16);
        this.JLDBlanco16.setBounds(0, 0, 41, 45);
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setHorizontalAlignment(0);
        this.jLabel17.setText("28");
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setHorizontalAlignment(0);
        this.jLabel18.setText("38");
        this.JP17.setMaximumSize(new Dimension(41, 45));
        this.JP17.setMinimumSize(new Dimension(41, 45));
        this.JP17.setName("38");
        this.JP17.setOpaque(false);
        this.JP17.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.17
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP17MouseClicked(evt);
            }
        });
        this.JP17.setLayout((LayoutManager) null);
        this.JL65.setMaximumSize(new Dimension(41, 45));
        this.JL65.setMinimumSize(new Dimension(41, 45));
        this.JL65.setName("4");
        this.JL65.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL65);
        this.JL65.setBounds(0, 0, 41, 45);
        this.JL66.setMaximumSize(new Dimension(41, 45));
        this.JL66.setMinimumSize(new Dimension(41, 45));
        this.JL66.setName("3");
        this.JL66.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL66);
        this.JL66.setBounds(0, 0, 41, 45);
        this.JL67.setMaximumSize(new Dimension(41, 45));
        this.JL67.setMinimumSize(new Dimension(41, 45));
        this.JL67.setName("2");
        this.JL67.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL67);
        this.JL67.setBounds(0, 0, 41, 45);
        this.JL68.setMaximumSize(new Dimension(41, 45));
        this.JL68.setMinimumSize(new Dimension(41, 45));
        this.JL68.setName("1");
        this.JL68.setPreferredSize(new Dimension(41, 45));
        this.JP17.add(this.JL68);
        this.JL68.setBounds(0, 0, 41, 45);
        this.JLDBlanco17.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco17.setName("0");
        this.JP17.add(this.JLDBlanco17);
        this.JLDBlanco17.setBounds(0, 0, 41, 45);
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setHorizontalAlignment(0);
        this.jLabel19.setText("37");
        this.JP18.setMaximumSize(new Dimension(41, 45));
        this.JP18.setMinimumSize(new Dimension(41, 45));
        this.JP18.setName("37");
        this.JP18.setOpaque(false);
        this.JP18.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.18
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP18MouseClicked(evt);
            }
        });
        this.JP18.setLayout((LayoutManager) null);
        this.JL69.setMaximumSize(new Dimension(41, 45));
        this.JL69.setMinimumSize(new Dimension(41, 45));
        this.JL69.setName("4");
        this.JL69.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL69);
        this.JL69.setBounds(0, 0, 41, 45);
        this.JL70.setMaximumSize(new Dimension(41, 45));
        this.JL70.setMinimumSize(new Dimension(41, 45));
        this.JL70.setName("3");
        this.JL70.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL70);
        this.JL70.setBounds(0, 0, 41, 45);
        this.JL71.setMaximumSize(new Dimension(41, 45));
        this.JL71.setMinimumSize(new Dimension(41, 45));
        this.JL71.setName("2");
        this.JL71.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL71);
        this.JL71.setBounds(0, 0, 41, 45);
        this.JL72.setMaximumSize(new Dimension(41, 45));
        this.JL72.setMinimumSize(new Dimension(41, 45));
        this.JL72.setName("1");
        this.JL72.setPreferredSize(new Dimension(41, 45));
        this.JP18.add(this.JL72);
        this.JL72.setBounds(0, 0, 41, 45);
        this.JLDBlanco18.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco18.setName("0");
        this.JP18.add(this.JLDBlanco18);
        this.JLDBlanco18.setBounds(0, 0, 41, 45);
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setHorizontalAlignment(0);
        this.jLabel20.setText("36");
        this.JP19.setMaximumSize(new Dimension(41, 45));
        this.JP19.setMinimumSize(new Dimension(41, 45));
        this.JP19.setName("36");
        this.JP19.setOpaque(false);
        this.JP19.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.19
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP19MouseClicked(evt);
            }
        });
        this.JP19.setLayout((LayoutManager) null);
        this.JL73.setMaximumSize(new Dimension(41, 45));
        this.JL73.setMinimumSize(new Dimension(41, 45));
        this.JL73.setName("4");
        this.JL73.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL73);
        this.JL73.setBounds(0, 0, 41, 45);
        this.JL74.setMaximumSize(new Dimension(41, 45));
        this.JL74.setMinimumSize(new Dimension(41, 45));
        this.JL74.setName("3");
        this.JL74.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL74);
        this.JL74.setBounds(0, 0, 41, 45);
        this.JL75.setMaximumSize(new Dimension(41, 45));
        this.JL75.setMinimumSize(new Dimension(41, 45));
        this.JL75.setName("2");
        this.JL75.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL75);
        this.JL75.setBounds(0, 0, 41, 45);
        this.JL76.setMaximumSize(new Dimension(41, 45));
        this.JL76.setMinimumSize(new Dimension(41, 45));
        this.JL76.setName("1");
        this.JL76.setPreferredSize(new Dimension(41, 45));
        this.JP19.add(this.JL76);
        this.JL76.setBounds(0, 0, 41, 45);
        this.JLDBlanco19.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco19.setName("0");
        this.JP19.add(this.JLDBlanco19);
        this.JLDBlanco19.setBounds(0, 0, 41, 45);
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setHorizontalAlignment(0);
        this.jLabel21.setText("35");
        this.JP20.setMaximumSize(new Dimension(41, 45));
        this.JP20.setMinimumSize(new Dimension(41, 45));
        this.JP20.setName("35");
        this.JP20.setOpaque(false);
        this.JP20.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.20
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP20MouseClicked(evt);
            }
        });
        this.JP20.setLayout((LayoutManager) null);
        this.JL77.setMaximumSize(new Dimension(41, 45));
        this.JL77.setMinimumSize(new Dimension(41, 45));
        this.JL77.setName("4");
        this.JL77.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL77);
        this.JL77.setBounds(0, 0, 41, 45);
        this.JL78.setMaximumSize(new Dimension(41, 45));
        this.JL78.setMinimumSize(new Dimension(41, 45));
        this.JL78.setName("3");
        this.JL78.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL78);
        this.JL78.setBounds(0, 0, 41, 45);
        this.JL79.setMaximumSize(new Dimension(41, 45));
        this.JL79.setMinimumSize(new Dimension(41, 45));
        this.JL79.setName("2");
        this.JL79.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL79);
        this.JL79.setBounds(0, 0, 41, 45);
        this.JL80.setMaximumSize(new Dimension(41, 45));
        this.JL80.setMinimumSize(new Dimension(41, 45));
        this.JL80.setName("1");
        this.JL80.setPreferredSize(new Dimension(41, 45));
        this.JP20.add(this.JL80);
        this.JL80.setBounds(0, 0, 41, 45);
        this.JLDBlanco20.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco20.setName("0");
        this.JP20.add(this.JLDBlanco20);
        this.JLDBlanco20.setBounds(0, 0, 41, 45);
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setHorizontalAlignment(0);
        this.jLabel22.setText("34");
        this.JP21.setMaximumSize(new Dimension(41, 45));
        this.JP21.setMinimumSize(new Dimension(41, 45));
        this.JP21.setName("34");
        this.JP21.setOpaque(false);
        this.JP21.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.21
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP21MouseClicked(evt);
            }
        });
        this.JP21.setLayout((LayoutManager) null);
        this.JL81.setMaximumSize(new Dimension(41, 45));
        this.JL81.setMinimumSize(new Dimension(41, 45));
        this.JL81.setName("4");
        this.JL81.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL81);
        this.JL81.setBounds(0, 0, 41, 45);
        this.JL82.setMaximumSize(new Dimension(41, 45));
        this.JL82.setMinimumSize(new Dimension(41, 45));
        this.JL82.setName("3");
        this.JL82.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL82);
        this.JL82.setBounds(0, 0, 41, 45);
        this.JL83.setMaximumSize(new Dimension(41, 45));
        this.JL83.setMinimumSize(new Dimension(41, 45));
        this.JL83.setName("2");
        this.JL83.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL83);
        this.JL83.setBounds(0, 0, 41, 45);
        this.JL84.setMaximumSize(new Dimension(41, 45));
        this.JL84.setMinimumSize(new Dimension(41, 45));
        this.JL84.setName("1");
        this.JL84.setPreferredSize(new Dimension(41, 45));
        this.JP21.add(this.JL84);
        this.JL84.setBounds(0, 0, 41, 45);
        this.JLDBlanco21.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco21.setName("0");
        this.JP21.add(this.JLDBlanco21);
        this.JLDBlanco21.setBounds(0, 0, 41, 45);
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setHorizontalAlignment(0);
        this.jLabel23.setText("33");
        this.JP22.setMaximumSize(new Dimension(41, 45));
        this.JP22.setMinimumSize(new Dimension(41, 45));
        this.JP22.setName("33");
        this.JP22.setOpaque(false);
        this.JP22.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.22
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP22MouseClicked(evt);
            }
        });
        this.JP22.setLayout((LayoutManager) null);
        this.JL85.setMaximumSize(new Dimension(41, 45));
        this.JL85.setMinimumSize(new Dimension(41, 45));
        this.JL85.setName("4");
        this.JL85.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL85);
        this.JL85.setBounds(0, 0, 41, 45);
        this.JL86.setMaximumSize(new Dimension(41, 45));
        this.JL86.setMinimumSize(new Dimension(41, 45));
        this.JL86.setName("3");
        this.JL86.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL86);
        this.JL86.setBounds(0, 0, 41, 45);
        this.JL87.setMaximumSize(new Dimension(41, 45));
        this.JL87.setMinimumSize(new Dimension(41, 45));
        this.JL87.setName("2");
        this.JL87.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL87);
        this.JL87.setBounds(0, 0, 41, 45);
        this.JL88.setMaximumSize(new Dimension(41, 45));
        this.JL88.setMinimumSize(new Dimension(41, 45));
        this.JL88.setName("1");
        this.JL88.setPreferredSize(new Dimension(41, 45));
        this.JP22.add(this.JL88);
        this.JL88.setBounds(0, 0, 41, 45);
        this.JLDBlanco22.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco22.setName("0");
        this.JP22.add(this.JLDBlanco22);
        this.JLDBlanco22.setBounds(0, 0, 41, 45);
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setHorizontalAlignment(0);
        this.jLabel24.setText("32");
        this.JP23.setMaximumSize(new Dimension(41, 45));
        this.JP23.setMinimumSize(new Dimension(41, 45));
        this.JP23.setName("32");
        this.JP23.setOpaque(false);
        this.JP23.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.23
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP23MouseClicked(evt);
            }
        });
        this.JP23.setLayout((LayoutManager) null);
        this.JL89.setMaximumSize(new Dimension(41, 45));
        this.JL89.setMinimumSize(new Dimension(41, 45));
        this.JL89.setName("4");
        this.JL89.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL89);
        this.JL89.setBounds(0, 0, 41, 45);
        this.JL90.setMaximumSize(new Dimension(41, 45));
        this.JL90.setMinimumSize(new Dimension(41, 45));
        this.JL90.setName("3");
        this.JL90.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL90);
        this.JL90.setBounds(0, 0, 41, 45);
        this.JL91.setMaximumSize(new Dimension(41, 45));
        this.JL91.setMinimumSize(new Dimension(41, 45));
        this.JL91.setName("2");
        this.JL91.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL91);
        this.JL91.setBounds(0, 0, 41, 45);
        this.JL92.setMaximumSize(new Dimension(41, 45));
        this.JL92.setMinimumSize(new Dimension(41, 45));
        this.JL92.setName("1");
        this.JL92.setPreferredSize(new Dimension(41, 45));
        this.JP23.add(this.JL92);
        this.JL92.setBounds(0, 0, 41, 45);
        this.JLDBlanco23.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco23.setName("0");
        this.JP23.add(this.JLDBlanco23);
        this.JLDBlanco23.setBounds(0, 0, 41, 45);
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setHorizontalAlignment(0);
        this.jLabel25.setText("31");
        this.JP24.setMaximumSize(new Dimension(41, 45));
        this.JP24.setMinimumSize(new Dimension(41, 45));
        this.JP24.setName("31");
        this.JP24.setOpaque(false);
        this.JP24.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.24
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP24MouseClicked(evt);
            }
        });
        this.JP24.setLayout((LayoutManager) null);
        this.JL93.setMaximumSize(new Dimension(41, 45));
        this.JL93.setMinimumSize(new Dimension(41, 45));
        this.JL93.setName("4");
        this.JL93.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL93);
        this.JL93.setBounds(0, 0, 41, 45);
        this.JL94.setMaximumSize(new Dimension(41, 45));
        this.JL94.setMinimumSize(new Dimension(41, 45));
        this.JL94.setName("3");
        this.JL94.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL94);
        this.JL94.setBounds(0, 0, 41, 45);
        this.JL95.setMaximumSize(new Dimension(41, 45));
        this.JL95.setMinimumSize(new Dimension(41, 45));
        this.JL95.setName("2");
        this.JL95.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL95);
        this.JL95.setBounds(0, 0, 41, 45);
        this.JL96.setMaximumSize(new Dimension(41, 45));
        this.JL96.setMinimumSize(new Dimension(41, 45));
        this.JL96.setName("1");
        this.JL96.setPreferredSize(new Dimension(41, 45));
        this.JP24.add(this.JL96);
        this.JL96.setBounds(0, 0, 41, 45);
        this.JLDBlanco24.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco24.setName("0");
        this.JP24.add(this.JLDBlanco24);
        this.JLDBlanco24.setBounds(0, 0, 41, 45);
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setHorizontalAlignment(0);
        this.jLabel26.setText("41");
        this.JP25.setMaximumSize(new Dimension(41, 45));
        this.JP25.setMinimumSize(new Dimension(41, 45));
        this.JP25.setName("41");
        this.JP25.setOpaque(false);
        this.JP25.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.25
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP25MouseClicked(evt);
            }
        });
        this.JP25.setLayout((LayoutManager) null);
        this.JL97.setMaximumSize(new Dimension(41, 45));
        this.JL97.setMinimumSize(new Dimension(41, 45));
        this.JL97.setName("4");
        this.JL97.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL97);
        this.JL97.setBounds(0, 0, 41, 45);
        this.JL98.setMaximumSize(new Dimension(41, 45));
        this.JL98.setMinimumSize(new Dimension(41, 45));
        this.JL98.setName("3");
        this.JL98.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL98);
        this.JL98.setBounds(0, 0, 41, 45);
        this.JL99.setMaximumSize(new Dimension(41, 45));
        this.JL99.setMinimumSize(new Dimension(41, 45));
        this.JL99.setName("2");
        this.JL99.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL99);
        this.JL99.setBounds(0, 0, 41, 45);
        this.JL100.setMaximumSize(new Dimension(41, 45));
        this.JL100.setMinimumSize(new Dimension(41, 45));
        this.JL100.setName("1");
        this.JL100.setPreferredSize(new Dimension(41, 45));
        this.JP25.add(this.JL100);
        this.JL100.setBounds(0, 0, 41, 45);
        this.JLDBlanco25.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco25.setName("0");
        this.JP25.add(this.JLDBlanco25);
        this.JLDBlanco25.setBounds(0, 0, 41, 45);
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setHorizontalAlignment(0);
        this.jLabel27.setText("42");
        this.JP26.setMaximumSize(new Dimension(41, 45));
        this.JP26.setMinimumSize(new Dimension(41, 45));
        this.JP26.setName("42");
        this.JP26.setOpaque(false);
        this.JP26.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.26
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP26MouseClicked(evt);
            }
        });
        this.JP26.setLayout((LayoutManager) null);
        this.JL101.setMaximumSize(new Dimension(41, 45));
        this.JL101.setMinimumSize(new Dimension(41, 45));
        this.JL101.setName("4");
        this.JL101.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL101);
        this.JL101.setBounds(0, 0, 41, 45);
        this.JL102.setMaximumSize(new Dimension(41, 45));
        this.JL102.setMinimumSize(new Dimension(41, 45));
        this.JL102.setName("3");
        this.JL102.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL102);
        this.JL102.setBounds(0, 0, 41, 45);
        this.JL103.setMaximumSize(new Dimension(41, 45));
        this.JL103.setMinimumSize(new Dimension(41, 45));
        this.JL103.setName("2");
        this.JL103.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL103);
        this.JL103.setBounds(0, 0, 41, 45);
        this.JL104.setMaximumSize(new Dimension(41, 45));
        this.JL104.setMinimumSize(new Dimension(41, 45));
        this.JL104.setName("1");
        this.JL104.setPreferredSize(new Dimension(41, 45));
        this.JP26.add(this.JL104);
        this.JL104.setBounds(0, 0, 41, 45);
        this.JLDBlanco26.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco26.setName("0");
        this.JP26.add(this.JLDBlanco26);
        this.JLDBlanco26.setBounds(0, 0, 41, 45);
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setHorizontalAlignment(0);
        this.jLabel28.setText("43");
        this.JP27.setMaximumSize(new Dimension(41, 45));
        this.JP27.setMinimumSize(new Dimension(41, 45));
        this.JP27.setName("43");
        this.JP27.setOpaque(false);
        this.JP27.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.27
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP27MouseClicked(evt);
            }
        });
        this.JP27.setLayout((LayoutManager) null);
        this.JL105.setMaximumSize(new Dimension(41, 45));
        this.JL105.setMinimumSize(new Dimension(41, 45));
        this.JL105.setName("4");
        this.JL105.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL105);
        this.JL105.setBounds(0, 0, 41, 45);
        this.JL106.setMaximumSize(new Dimension(41, 45));
        this.JL106.setMinimumSize(new Dimension(41, 45));
        this.JL106.setName("3");
        this.JL106.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL106);
        this.JL106.setBounds(0, 0, 41, 45);
        this.JL107.setMaximumSize(new Dimension(41, 45));
        this.JL107.setMinimumSize(new Dimension(41, 45));
        this.JL107.setName("2");
        this.JL107.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL107);
        this.JL107.setBounds(0, 0, 41, 45);
        this.JL108.setMaximumSize(new Dimension(41, 45));
        this.JL108.setMinimumSize(new Dimension(41, 45));
        this.JL108.setName("1");
        this.JL108.setPreferredSize(new Dimension(41, 45));
        this.JP27.add(this.JL108);
        this.JL108.setBounds(0, 0, 41, 45);
        this.JLDBlanco27.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco27.setName("0");
        this.JP27.add(this.JLDBlanco27);
        this.JLDBlanco27.setBounds(0, 0, 41, 45);
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setHorizontalAlignment(0);
        this.jLabel29.setText("44");
        this.JP28.setMaximumSize(new Dimension(41, 45));
        this.JP28.setMinimumSize(new Dimension(41, 45));
        this.JP28.setName("44");
        this.JP28.setOpaque(false);
        this.JP28.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.28
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP28MouseClicked(evt);
            }
        });
        this.JP28.setLayout((LayoutManager) null);
        this.JL109.setMaximumSize(new Dimension(41, 45));
        this.JL109.setMinimumSize(new Dimension(41, 45));
        this.JL109.setName("4");
        this.JL109.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL109);
        this.JL109.setBounds(0, 0, 41, 45);
        this.JL110.setMaximumSize(new Dimension(41, 45));
        this.JL110.setMinimumSize(new Dimension(41, 45));
        this.JL110.setName("3");
        this.JL110.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL110);
        this.JL110.setBounds(0, 0, 41, 45);
        this.JL111.setMaximumSize(new Dimension(41, 45));
        this.JL111.setMinimumSize(new Dimension(41, 45));
        this.JL111.setName("2");
        this.JL111.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL111);
        this.JL111.setBounds(0, 0, 41, 45);
        this.JL112.setMaximumSize(new Dimension(41, 45));
        this.JL112.setMinimumSize(new Dimension(41, 45));
        this.JL112.setName("1");
        this.JL112.setPreferredSize(new Dimension(41, 45));
        this.JP28.add(this.JL112);
        this.JL112.setBounds(0, 0, 41, 45);
        this.JLDBlanco28.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco28.setName("0");
        this.JP28.add(this.JLDBlanco28);
        this.JLDBlanco28.setBounds(0, 0, 41, 45);
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setHorizontalAlignment(0);
        this.jLabel30.setText("45");
        this.JP29.setMaximumSize(new Dimension(41, 45));
        this.JP29.setMinimumSize(new Dimension(41, 45));
        this.JP29.setName("45");
        this.JP29.setOpaque(false);
        this.JP29.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.29
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP29MouseClicked(evt);
            }
        });
        this.JP29.setLayout((LayoutManager) null);
        this.JL113.setMaximumSize(new Dimension(41, 45));
        this.JL113.setMinimumSize(new Dimension(41, 45));
        this.JL113.setName("4");
        this.JL113.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL113);
        this.JL113.setBounds(0, 0, 41, 45);
        this.JL114.setMaximumSize(new Dimension(41, 45));
        this.JL114.setMinimumSize(new Dimension(41, 45));
        this.JL114.setName("3");
        this.JL114.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL114);
        this.JL114.setBounds(0, 0, 41, 45);
        this.JL115.setMaximumSize(new Dimension(41, 45));
        this.JL115.setMinimumSize(new Dimension(41, 45));
        this.JL115.setName("2");
        this.JL115.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL115);
        this.JL115.setBounds(0, 0, 41, 45);
        this.JL116.setMaximumSize(new Dimension(41, 45));
        this.JL116.setMinimumSize(new Dimension(41, 45));
        this.JL116.setName("1");
        this.JL116.setPreferredSize(new Dimension(41, 45));
        this.JP29.add(this.JL116);
        this.JL116.setBounds(0, 0, 41, 45);
        this.JLDBlanco29.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco29.setName("0");
        this.JP29.add(this.JLDBlanco29);
        this.JLDBlanco29.setBounds(0, 0, 41, 45);
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setHorizontalAlignment(0);
        this.jLabel31.setText("46");
        this.JP30.setMaximumSize(new Dimension(41, 45));
        this.JP30.setMinimumSize(new Dimension(41, 45));
        this.JP30.setName("46");
        this.JP30.setOpaque(false);
        this.JP30.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.30
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP30MouseClicked(evt);
            }
        });
        this.JP30.setLayout((LayoutManager) null);
        this.JL117.setMaximumSize(new Dimension(41, 45));
        this.JL117.setMinimumSize(new Dimension(41, 45));
        this.JL117.setName("4");
        this.JL117.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL117);
        this.JL117.setBounds(0, 0, 41, 45);
        this.JL118.setMaximumSize(new Dimension(41, 45));
        this.JL118.setMinimumSize(new Dimension(41, 45));
        this.JL118.setName("3");
        this.JL118.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL118);
        this.JL118.setBounds(0, 0, 41, 45);
        this.JL119.setMaximumSize(new Dimension(41, 45));
        this.JL119.setMinimumSize(new Dimension(41, 45));
        this.JL119.setName("2");
        this.JL119.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL119);
        this.JL119.setBounds(0, 0, 41, 45);
        this.JL120.setMaximumSize(new Dimension(41, 45));
        this.JL120.setMinimumSize(new Dimension(41, 45));
        this.JL120.setName("1");
        this.JL120.setPreferredSize(new Dimension(41, 45));
        this.JP30.add(this.JL120);
        this.JL120.setBounds(0, 0, 41, 45);
        this.JLDBlanco30.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco30.setName("0");
        this.JP30.add(this.JLDBlanco30);
        this.JLDBlanco30.setBounds(0, 0, 41, 45);
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setHorizontalAlignment(0);
        this.jLabel32.setText("47");
        this.JP31.setMaximumSize(new Dimension(41, 45));
        this.JP31.setMinimumSize(new Dimension(41, 45));
        this.JP31.setName("47");
        this.JP31.setOpaque(false);
        this.JP31.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.31
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP31MouseClicked(evt);
            }
        });
        this.JP31.setLayout((LayoutManager) null);
        this.JL121.setMaximumSize(new Dimension(41, 45));
        this.JL121.setMinimumSize(new Dimension(41, 45));
        this.JL121.setName("4");
        this.JL121.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL121);
        this.JL121.setBounds(0, 0, 41, 45);
        this.JL122.setMaximumSize(new Dimension(41, 45));
        this.JL122.setMinimumSize(new Dimension(41, 45));
        this.JL122.setName("3");
        this.JL122.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL122);
        this.JL122.setBounds(0, 0, 41, 45);
        this.JL123.setMaximumSize(new Dimension(41, 45));
        this.JL123.setMinimumSize(new Dimension(41, 45));
        this.JL123.setName("2");
        this.JL123.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL123);
        this.JL123.setBounds(0, 0, 41, 45);
        this.JL124.setMaximumSize(new Dimension(41, 45));
        this.JL124.setMinimumSize(new Dimension(41, 45));
        this.JL124.setName("1");
        this.JL124.setPreferredSize(new Dimension(41, 45));
        this.JP31.add(this.JL124);
        this.JL124.setBounds(0, 0, 41, 45);
        this.JLDBlanco31.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco31.setName("0");
        this.JP31.add(this.JLDBlanco31);
        this.JLDBlanco31.setBounds(0, 0, 41, 45);
        this.jLabel33.setFont(new Font("Arial", 1, 12));
        this.jLabel33.setHorizontalAlignment(0);
        this.jLabel33.setText("48");
        this.JP32.setMaximumSize(new Dimension(41, 45));
        this.JP32.setMinimumSize(new Dimension(41, 45));
        this.JP32.setName("48");
        this.JP32.setOpaque(false);
        this.JP32.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.32
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP32MouseClicked(evt);
            }
        });
        this.JP32.setLayout((LayoutManager) null);
        this.JL125.setMaximumSize(new Dimension(41, 45));
        this.JL125.setMinimumSize(new Dimension(41, 45));
        this.JL125.setName("4");
        this.JL125.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL125);
        this.JL125.setBounds(0, 0, 41, 45);
        this.JL126.setMaximumSize(new Dimension(41, 45));
        this.JL126.setMinimumSize(new Dimension(41, 45));
        this.JL126.setName("3");
        this.JL126.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL126);
        this.JL126.setBounds(0, 0, 41, 45);
        this.JL127.setMaximumSize(new Dimension(41, 45));
        this.JL127.setMinimumSize(new Dimension(41, 45));
        this.JL127.setName("2");
        this.JL127.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL127);
        this.JL127.setBounds(0, 0, 41, 45);
        this.JL128.setMaximumSize(new Dimension(41, 45));
        this.JL128.setMinimumSize(new Dimension(41, 45));
        this.JL128.setName("1");
        this.JL128.setPreferredSize(new Dimension(41, 45));
        this.JP32.add(this.JL128);
        this.JL128.setBounds(0, 0, 41, 45);
        this.JLDBlanco32.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco32.setName("0");
        this.JP32.add(this.JLDBlanco32);
        this.JLDBlanco32.setBounds(0, 0, 41, 45);
        this.jLabel66.setFont(new Font("Arial", 1, 12));
        this.jLabel66.setForeground(new Color(255, 51, 0));
        this.jLabel66.setHorizontalAlignment(0);
        this.jLabel66.setText("55");
        this.JP66.setMaximumSize(new Dimension(41, 45));
        this.JP66.setMinimumSize(new Dimension(41, 45));
        this.JP66.setName("55");
        this.JP66.setOpaque(false);
        this.JP66.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.33
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP66MouseClicked(evt);
            }
        });
        this.JP66.setLayout((LayoutManager) null);
        this.JL261.setMaximumSize(new Dimension(41, 45));
        this.JL261.setMinimumSize(new Dimension(41, 45));
        this.JL261.setName("4");
        this.JL261.setPreferredSize(new Dimension(41, 45));
        this.JP66.add(this.JL261);
        this.JL261.setBounds(0, 0, 41, 45);
        this.JL262.setMaximumSize(new Dimension(41, 45));
        this.JL262.setMinimumSize(new Dimension(41, 45));
        this.JL262.setName("3");
        this.JL262.setPreferredSize(new Dimension(41, 45));
        this.JP66.add(this.JL262);
        this.JL262.setBounds(0, 0, 41, 45);
        this.JL263.setMaximumSize(new Dimension(41, 45));
        this.JL263.setMinimumSize(new Dimension(41, 45));
        this.JL263.setName("2");
        this.JL263.setPreferredSize(new Dimension(41, 45));
        this.JP66.add(this.JL263);
        this.JL263.setBounds(0, 0, 41, 45);
        this.JL264.setMaximumSize(new Dimension(41, 45));
        this.JL264.setMinimumSize(new Dimension(41, 45));
        this.JL264.setName("1");
        this.JL264.setPreferredSize(new Dimension(41, 45));
        this.JP66.add(this.JL264);
        this.JL264.setBounds(0, 0, 41, 45);
        this.JLDBlanco66.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco66.setName("0");
        this.JP66.add(this.JLDBlanco66);
        this.JLDBlanco66.setBounds(0, 0, 41, 45);
        this.jLabel67.setFont(new Font("Arial", 1, 12));
        this.jLabel67.setForeground(new Color(255, 51, 0));
        this.jLabel67.setHorizontalAlignment(0);
        this.jLabel67.setText("54");
        this.JP67.setMaximumSize(new Dimension(41, 45));
        this.JP67.setMinimumSize(new Dimension(41, 45));
        this.JP67.setName("54");
        this.JP67.setOpaque(false);
        this.JP67.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.34
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP67MouseClicked(evt);
            }
        });
        this.JP67.setLayout((LayoutManager) null);
        this.JL265.setMaximumSize(new Dimension(41, 45));
        this.JL265.setMinimumSize(new Dimension(41, 45));
        this.JL265.setName("4");
        this.JL265.setPreferredSize(new Dimension(41, 45));
        this.JP67.add(this.JL265);
        this.JL265.setBounds(0, 0, 41, 45);
        this.JL266.setMaximumSize(new Dimension(41, 45));
        this.JL266.setMinimumSize(new Dimension(41, 45));
        this.JL266.setName("3");
        this.JL266.setPreferredSize(new Dimension(41, 45));
        this.JP67.add(this.JL266);
        this.JL266.setBounds(0, 0, 41, 45);
        this.JL267.setMaximumSize(new Dimension(41, 45));
        this.JL267.setMinimumSize(new Dimension(41, 45));
        this.JL267.setName("2");
        this.JL267.setPreferredSize(new Dimension(41, 45));
        this.JP67.add(this.JL267);
        this.JL267.setBounds(0, 0, 41, 45);
        this.JL268.setMaximumSize(new Dimension(41, 45));
        this.JL268.setMinimumSize(new Dimension(41, 45));
        this.JL268.setName("1");
        this.JL268.setPreferredSize(new Dimension(41, 45));
        this.JP67.add(this.JL268);
        this.JL268.setBounds(0, 0, 41, 45);
        this.JLDBlanco67.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco67.setName("0");
        this.JP67.add(this.JLDBlanco67);
        this.JLDBlanco67.setBounds(0, 0, 41, 45);
        this.jLabel68.setFont(new Font("Arial", 1, 12));
        this.jLabel68.setForeground(new Color(255, 51, 0));
        this.jLabel68.setHorizontalAlignment(0);
        this.jLabel68.setText("53");
        this.JP68.setMaximumSize(new Dimension(41, 45));
        this.JP68.setMinimumSize(new Dimension(41, 45));
        this.JP68.setName("53");
        this.JP68.setOpaque(false);
        this.JP68.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.35
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP68MouseClicked(evt);
            }
        });
        this.JP68.setLayout((LayoutManager) null);
        this.JL269.setMaximumSize(new Dimension(41, 45));
        this.JL269.setMinimumSize(new Dimension(41, 45));
        this.JL269.setName("4");
        this.JL269.setPreferredSize(new Dimension(41, 45));
        this.JP68.add(this.JL269);
        this.JL269.setBounds(0, 0, 41, 45);
        this.JL270.setMaximumSize(new Dimension(41, 45));
        this.JL270.setMinimumSize(new Dimension(41, 45));
        this.JL270.setName("3");
        this.JL270.setPreferredSize(new Dimension(41, 45));
        this.JP68.add(this.JL270);
        this.JL270.setBounds(0, 0, 41, 45);
        this.JL271.setMaximumSize(new Dimension(41, 45));
        this.JL271.setMinimumSize(new Dimension(41, 45));
        this.JL271.setName("2");
        this.JL271.setPreferredSize(new Dimension(41, 45));
        this.JP68.add(this.JL271);
        this.JL271.setBounds(0, 0, 41, 45);
        this.JL272.setMaximumSize(new Dimension(41, 45));
        this.JL272.setMinimumSize(new Dimension(41, 45));
        this.JL272.setName("1");
        this.JL272.setPreferredSize(new Dimension(41, 45));
        this.JP68.add(this.JL272);
        this.JL272.setBounds(0, 0, 41, 45);
        this.JLDBlanco68.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco68.setName("0");
        this.JP68.add(this.JLDBlanco68);
        this.JLDBlanco68.setBounds(0, 0, 41, 45);
        this.jLabel69.setFont(new Font("Arial", 1, 12));
        this.jLabel69.setForeground(new Color(255, 51, 0));
        this.jLabel69.setHorizontalAlignment(0);
        this.jLabel69.setText("52");
        this.JP69.setMaximumSize(new Dimension(41, 45));
        this.JP69.setMinimumSize(new Dimension(41, 45));
        this.JP69.setName("52");
        this.JP69.setOpaque(false);
        this.JP69.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.36
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP69MouseClicked(evt);
            }
        });
        this.JP69.setLayout((LayoutManager) null);
        this.JL273.setMaximumSize(new Dimension(41, 45));
        this.JL273.setMinimumSize(new Dimension(41, 45));
        this.JL273.setName("4");
        this.JL273.setPreferredSize(new Dimension(41, 45));
        this.JP69.add(this.JL273);
        this.JL273.setBounds(0, 0, 41, 45);
        this.JL274.setMaximumSize(new Dimension(41, 45));
        this.JL274.setMinimumSize(new Dimension(41, 45));
        this.JL274.setName("3");
        this.JL274.setPreferredSize(new Dimension(41, 45));
        this.JP69.add(this.JL274);
        this.JL274.setBounds(0, 0, 41, 45);
        this.JL275.setMaximumSize(new Dimension(41, 45));
        this.JL275.setMinimumSize(new Dimension(41, 45));
        this.JL275.setName("2");
        this.JL275.setPreferredSize(new Dimension(41, 45));
        this.JP69.add(this.JL275);
        this.JL275.setBounds(0, 0, 41, 45);
        this.JL276.setMaximumSize(new Dimension(41, 45));
        this.JL276.setMinimumSize(new Dimension(41, 45));
        this.JL276.setName("1");
        this.JL276.setPreferredSize(new Dimension(41, 45));
        this.JP69.add(this.JL276);
        this.JL276.setBounds(0, 0, 41, 45);
        this.JLDBlanco69.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco69.setName("0");
        this.JP69.add(this.JLDBlanco69);
        this.JLDBlanco69.setBounds(0, 0, 41, 45);
        this.jLabel70.setFont(new Font("Arial", 1, 12));
        this.jLabel70.setForeground(new Color(255, 51, 0));
        this.jLabel70.setHorizontalAlignment(0);
        this.jLabel70.setText("51");
        this.JP65.setMaximumSize(new Dimension(41, 45));
        this.JP65.setMinimumSize(new Dimension(41, 45));
        this.JP65.setName("51");
        this.JP65.setOpaque(false);
        this.JP65.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.37
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP65MouseClicked(evt);
            }
        });
        this.JP65.setLayout((LayoutManager) null);
        this.JL257.setMaximumSize(new Dimension(41, 45));
        this.JL257.setMinimumSize(new Dimension(41, 45));
        this.JL257.setName("4");
        this.JL257.setPreferredSize(new Dimension(41, 45));
        this.JP65.add(this.JL257);
        this.JL257.setBounds(0, 0, 41, 45);
        this.JL258.setMaximumSize(new Dimension(41, 45));
        this.JL258.setMinimumSize(new Dimension(41, 45));
        this.JL258.setName("3");
        this.JL258.setPreferredSize(new Dimension(41, 45));
        this.JP65.add(this.JL258);
        this.JL258.setBounds(0, 0, 41, 45);
        this.JL259.setMaximumSize(new Dimension(41, 45));
        this.JL259.setMinimumSize(new Dimension(41, 45));
        this.JL259.setName("2");
        this.JL259.setPreferredSize(new Dimension(41, 45));
        this.JP65.add(this.JL259);
        this.JL259.setBounds(0, 0, 41, 45);
        this.JL260.setMaximumSize(new Dimension(41, 45));
        this.JL260.setMinimumSize(new Dimension(41, 45));
        this.JL260.setName("1");
        this.JL260.setPreferredSize(new Dimension(41, 45));
        this.JP65.add(this.JL260);
        this.JL260.setBounds(0, 0, 41, 45);
        this.JLDBlanco65.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco65.setName("0");
        this.JP65.add(this.JLDBlanco65);
        this.JLDBlanco65.setBounds(0, 0, 41, 45);
        this.JP70.setMaximumSize(new Dimension(41, 45));
        this.JP70.setMinimumSize(new Dimension(41, 45));
        this.JP70.setName("65");
        this.JP70.setOpaque(false);
        this.JP70.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.38
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP70MouseClicked(evt);
            }
        });
        this.JP70.setLayout((LayoutManager) null);
        this.JL277.setMaximumSize(new Dimension(41, 45));
        this.JL277.setMinimumSize(new Dimension(41, 45));
        this.JL277.setName("4");
        this.JL277.setPreferredSize(new Dimension(41, 45));
        this.JP70.add(this.JL277);
        this.JL277.setBounds(0, 0, 41, 45);
        this.JL278.setMaximumSize(new Dimension(41, 45));
        this.JL278.setMinimumSize(new Dimension(41, 45));
        this.JL278.setName("3");
        this.JL278.setPreferredSize(new Dimension(41, 45));
        this.JP70.add(this.JL278);
        this.JL278.setBounds(0, 0, 41, 45);
        this.JL279.setMaximumSize(new Dimension(41, 45));
        this.JL279.setMinimumSize(new Dimension(41, 45));
        this.JL279.setName("2");
        this.JL279.setPreferredSize(new Dimension(41, 45));
        this.JP70.add(this.JL279);
        this.JL279.setBounds(0, 0, 41, 45);
        this.JL280.setMaximumSize(new Dimension(41, 45));
        this.JL280.setMinimumSize(new Dimension(41, 45));
        this.JL280.setName("1");
        this.JL280.setPreferredSize(new Dimension(41, 45));
        this.JP70.add(this.JL280);
        this.JL280.setBounds(0, 0, 41, 45);
        this.JLDBlanco70.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco70.setName("0");
        this.JP70.add(this.JLDBlanco70);
        this.JLDBlanco70.setBounds(0, 0, 41, 45);
        this.jLabel71.setFont(new Font("Arial", 1, 12));
        this.jLabel71.setForeground(new Color(255, 51, 0));
        this.jLabel71.setHorizontalAlignment(0);
        this.jLabel71.setText("65");
        this.JP71.setMaximumSize(new Dimension(41, 45));
        this.JP71.setMinimumSize(new Dimension(41, 45));
        this.JP71.setName("64");
        this.JP71.setOpaque(false);
        this.JP71.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.39
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP71MouseClicked(evt);
            }
        });
        this.JP71.setLayout((LayoutManager) null);
        this.JL281.setMaximumSize(new Dimension(41, 45));
        this.JL281.setMinimumSize(new Dimension(41, 45));
        this.JL281.setName("4");
        this.JL281.setPreferredSize(new Dimension(41, 45));
        this.JP71.add(this.JL281);
        this.JL281.setBounds(0, 0, 41, 45);
        this.JL282.setMaximumSize(new Dimension(41, 45));
        this.JL282.setMinimumSize(new Dimension(41, 45));
        this.JL282.setName("3");
        this.JL282.setPreferredSize(new Dimension(41, 45));
        this.JP71.add(this.JL282);
        this.JL282.setBounds(0, 0, 41, 45);
        this.JL283.setMaximumSize(new Dimension(41, 45));
        this.JL283.setMinimumSize(new Dimension(41, 45));
        this.JL283.setName("2");
        this.JL283.setPreferredSize(new Dimension(41, 45));
        this.JP71.add(this.JL283);
        this.JL283.setBounds(0, 0, 41, 45);
        this.JL284.setMaximumSize(new Dimension(41, 45));
        this.JL284.setMinimumSize(new Dimension(41, 45));
        this.JL284.setName("1");
        this.JL284.setPreferredSize(new Dimension(41, 45));
        this.JP71.add(this.JL284);
        this.JL284.setBounds(0, 0, 41, 45);
        this.JLDBlanco71.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco71.setName("0");
        this.JP71.add(this.JLDBlanco71);
        this.JLDBlanco71.setBounds(0, 0, 41, 45);
        this.jLabel72.setFont(new Font("Arial", 1, 12));
        this.jLabel72.setForeground(new Color(255, 51, 0));
        this.jLabel72.setHorizontalAlignment(0);
        this.jLabel72.setText("64");
        this.JP72.setMaximumSize(new Dimension(41, 45));
        this.JP72.setMinimumSize(new Dimension(41, 45));
        this.JP72.setName("63");
        this.JP72.setOpaque(false);
        this.JP72.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.40
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP72MouseClicked(evt);
            }
        });
        this.JP72.setLayout((LayoutManager) null);
        this.JL285.setMaximumSize(new Dimension(41, 45));
        this.JL285.setMinimumSize(new Dimension(41, 45));
        this.JL285.setName("4");
        this.JL285.setPreferredSize(new Dimension(41, 45));
        this.JP72.add(this.JL285);
        this.JL285.setBounds(0, 0, 41, 45);
        this.JL286.setMaximumSize(new Dimension(41, 45));
        this.JL286.setMinimumSize(new Dimension(41, 45));
        this.JL286.setName("3");
        this.JL286.setPreferredSize(new Dimension(41, 45));
        this.JP72.add(this.JL286);
        this.JL286.setBounds(0, 0, 41, 45);
        this.JL287.setMaximumSize(new Dimension(41, 45));
        this.JL287.setMinimumSize(new Dimension(41, 45));
        this.JL287.setName("2");
        this.JL287.setPreferredSize(new Dimension(41, 45));
        this.JP72.add(this.JL287);
        this.JL287.setBounds(0, 0, 41, 45);
        this.JL288.setMaximumSize(new Dimension(41, 45));
        this.JL288.setMinimumSize(new Dimension(41, 45));
        this.JL288.setName("1");
        this.JL288.setPreferredSize(new Dimension(41, 45));
        this.JP72.add(this.JL288);
        this.JL288.setBounds(0, 0, 41, 45);
        this.JLDBlanco72.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco72.setName("0");
        this.JP72.add(this.JLDBlanco72);
        this.JLDBlanco72.setBounds(0, 0, 41, 45);
        this.jLabel73.setFont(new Font("Arial", 1, 12));
        this.jLabel73.setForeground(new Color(255, 51, 0));
        this.jLabel73.setHorizontalAlignment(0);
        this.jLabel73.setText("63");
        this.JP73.setMaximumSize(new Dimension(41, 45));
        this.JP73.setMinimumSize(new Dimension(41, 45));
        this.JP73.setName("62");
        this.JP73.setOpaque(false);
        this.JP73.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.41
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP73MouseClicked(evt);
            }
        });
        this.JP73.setLayout((LayoutManager) null);
        this.JL289.setMaximumSize(new Dimension(41, 45));
        this.JL289.setMinimumSize(new Dimension(41, 45));
        this.JL289.setName("4");
        this.JL289.setPreferredSize(new Dimension(41, 45));
        this.JP73.add(this.JL289);
        this.JL289.setBounds(0, 0, 41, 45);
        this.JL290.setMaximumSize(new Dimension(41, 45));
        this.JL290.setMinimumSize(new Dimension(41, 45));
        this.JL290.setName("3");
        this.JL290.setPreferredSize(new Dimension(41, 45));
        this.JP73.add(this.JL290);
        this.JL290.setBounds(0, 0, 41, 45);
        this.JL291.setMaximumSize(new Dimension(41, 45));
        this.JL291.setMinimumSize(new Dimension(41, 45));
        this.JL291.setName("2");
        this.JL291.setPreferredSize(new Dimension(41, 45));
        this.JP73.add(this.JL291);
        this.JL291.setBounds(0, 0, 41, 45);
        this.JL292.setMaximumSize(new Dimension(41, 45));
        this.JL292.setMinimumSize(new Dimension(41, 45));
        this.JL292.setName("1");
        this.JL292.setPreferredSize(new Dimension(41, 45));
        this.JP73.add(this.JL292);
        this.JL292.setBounds(0, 0, 41, 45);
        this.JLDBlanco73.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco73.setName("0");
        this.JP73.add(this.JLDBlanco73);
        this.JLDBlanco73.setBounds(0, 0, 41, 45);
        this.jLabel74.setFont(new Font("Arial", 1, 12));
        this.jLabel74.setForeground(new Color(255, 51, 0));
        this.jLabel74.setHorizontalAlignment(0);
        this.jLabel74.setText("62");
        this.JP74.setMaximumSize(new Dimension(41, 45));
        this.JP74.setMinimumSize(new Dimension(41, 45));
        this.JP74.setName("61");
        this.JP74.setOpaque(false);
        this.JP74.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.42
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP74MouseClicked(evt);
            }
        });
        this.JP74.setLayout((LayoutManager) null);
        this.JL293.setMaximumSize(new Dimension(41, 45));
        this.JL293.setMinimumSize(new Dimension(41, 45));
        this.JL293.setName("4");
        this.JL293.setPreferredSize(new Dimension(41, 45));
        this.JP74.add(this.JL293);
        this.JL293.setBounds(0, 0, 41, 45);
        this.JL294.setMaximumSize(new Dimension(41, 45));
        this.JL294.setMinimumSize(new Dimension(41, 45));
        this.JL294.setName("3");
        this.JL294.setPreferredSize(new Dimension(41, 45));
        this.JP74.add(this.JL294);
        this.JL294.setBounds(0, 0, 41, 45);
        this.JL295.setMaximumSize(new Dimension(41, 45));
        this.JL295.setMinimumSize(new Dimension(41, 45));
        this.JL295.setName("2");
        this.JL295.setPreferredSize(new Dimension(41, 45));
        this.JP74.add(this.JL295);
        this.JL295.setBounds(0, 0, 41, 45);
        this.JL296.setMaximumSize(new Dimension(41, 45));
        this.JL296.setMinimumSize(new Dimension(41, 45));
        this.JL296.setName("1");
        this.JL296.setPreferredSize(new Dimension(41, 45));
        this.JP74.add(this.JL296);
        this.JL296.setBounds(0, 0, 41, 45);
        this.JLDBlanco74.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco74.setName("0");
        this.JP74.add(this.JLDBlanco74);
        this.JLDBlanco74.setBounds(0, 0, 41, 45);
        this.jLabel75.setFont(new Font("Arial", 1, 12));
        this.jLabel75.setForeground(new Color(255, 51, 0));
        this.jLabel75.setHorizontalAlignment(0);
        this.jLabel75.setText("61");
        this.JP75.setMaximumSize(new Dimension(41, 45));
        this.JP75.setMinimumSize(new Dimension(41, 45));
        this.JP75.setName("81");
        this.JP75.setOpaque(false);
        this.JP75.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.43
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP75MouseClicked(evt);
            }
        });
        this.JP75.setLayout((LayoutManager) null);
        this.JL297.setMaximumSize(new Dimension(41, 45));
        this.JL297.setMinimumSize(new Dimension(41, 45));
        this.JL297.setName("4");
        this.JL297.setPreferredSize(new Dimension(41, 45));
        this.JP75.add(this.JL297);
        this.JL297.setBounds(0, 0, 41, 45);
        this.JL298.setMaximumSize(new Dimension(41, 45));
        this.JL298.setMinimumSize(new Dimension(41, 45));
        this.JL298.setName("3");
        this.JL298.setPreferredSize(new Dimension(41, 45));
        this.JP75.add(this.JL298);
        this.JL298.setBounds(0, 0, 41, 45);
        this.JL299.setMaximumSize(new Dimension(41, 45));
        this.JL299.setMinimumSize(new Dimension(41, 45));
        this.JL299.setName("2");
        this.JL299.setPreferredSize(new Dimension(41, 45));
        this.JP75.add(this.JL299);
        this.JL299.setBounds(0, 0, 41, 45);
        this.JL300.setMaximumSize(new Dimension(41, 45));
        this.JL300.setMinimumSize(new Dimension(41, 45));
        this.JL300.setName("1");
        this.JL300.setPreferredSize(new Dimension(41, 45));
        this.JP75.add(this.JL300);
        this.JL300.setBounds(0, 0, 41, 45);
        this.JLDBlanco75.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco75.setName("0");
        this.JP75.add(this.JLDBlanco75);
        this.JLDBlanco75.setBounds(0, 0, 41, 45);
        this.JP76.setMaximumSize(new Dimension(41, 45));
        this.JP76.setMinimumSize(new Dimension(41, 45));
        this.JP76.setName("82");
        this.JP76.setOpaque(false);
        this.JP76.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.44
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP76MouseClicked(evt);
            }
        });
        this.JP76.setLayout((LayoutManager) null);
        this.JL301.setMaximumSize(new Dimension(41, 45));
        this.JL301.setMinimumSize(new Dimension(41, 45));
        this.JL301.setName("4");
        this.JL301.setPreferredSize(new Dimension(41, 45));
        this.JP76.add(this.JL301);
        this.JL301.setBounds(0, 0, 41, 45);
        this.JL302.setMaximumSize(new Dimension(41, 45));
        this.JL302.setMinimumSize(new Dimension(41, 45));
        this.JL302.setName("3");
        this.JL302.setPreferredSize(new Dimension(41, 45));
        this.JP76.add(this.JL302);
        this.JL302.setBounds(0, 0, 41, 45);
        this.JL303.setMaximumSize(new Dimension(41, 45));
        this.JL303.setMinimumSize(new Dimension(41, 45));
        this.JL303.setName("2");
        this.JL303.setPreferredSize(new Dimension(41, 45));
        this.JP76.add(this.JL303);
        this.JL303.setBounds(0, 0, 41, 45);
        this.JL304.setMaximumSize(new Dimension(41, 45));
        this.JL304.setMinimumSize(new Dimension(41, 45));
        this.JL304.setName("1");
        this.JL304.setPreferredSize(new Dimension(41, 45));
        this.JP76.add(this.JL304);
        this.JL304.setBounds(0, 0, 41, 45);
        this.JLDBlanco76.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco76.setName("0");
        this.JP76.add(this.JLDBlanco76);
        this.JLDBlanco76.setBounds(0, 0, 41, 45);
        this.JP77.setMaximumSize(new Dimension(41, 45));
        this.JP77.setMinimumSize(new Dimension(41, 45));
        this.JP77.setName("83");
        this.JP77.setOpaque(false);
        this.JP77.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.45
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP77MouseClicked(evt);
            }
        });
        this.JP77.setLayout((LayoutManager) null);
        this.JL305.setMaximumSize(new Dimension(41, 45));
        this.JL305.setMinimumSize(new Dimension(41, 45));
        this.JL305.setName("4");
        this.JL305.setPreferredSize(new Dimension(41, 45));
        this.JP77.add(this.JL305);
        this.JL305.setBounds(0, 0, 41, 45);
        this.JL306.setMaximumSize(new Dimension(41, 45));
        this.JL306.setMinimumSize(new Dimension(41, 45));
        this.JL306.setName("3");
        this.JL306.setPreferredSize(new Dimension(41, 45));
        this.JP77.add(this.JL306);
        this.JL306.setBounds(0, 0, 41, 45);
        this.JL307.setMaximumSize(new Dimension(41, 45));
        this.JL307.setMinimumSize(new Dimension(41, 45));
        this.JL307.setName("2");
        this.JL307.setPreferredSize(new Dimension(41, 45));
        this.JP77.add(this.JL307);
        this.JL307.setBounds(0, 0, 41, 45);
        this.JL308.setMaximumSize(new Dimension(41, 45));
        this.JL308.setMinimumSize(new Dimension(41, 45));
        this.JL308.setName("1");
        this.JL308.setPreferredSize(new Dimension(41, 45));
        this.JP77.add(this.JL308);
        this.JL308.setBounds(0, 0, 41, 45);
        this.JLDBlanco77.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco77.setName("0");
        this.JP77.add(this.JLDBlanco77);
        this.JLDBlanco77.setBounds(0, 0, 41, 45);
        this.jLabel76.setFont(new Font("Arial", 1, 12));
        this.jLabel76.setForeground(new Color(255, 51, 0));
        this.jLabel76.setHorizontalAlignment(0);
        this.jLabel76.setText("71");
        this.jLabel77.setFont(new Font("Arial", 1, 12));
        this.jLabel77.setForeground(new Color(255, 51, 0));
        this.jLabel77.setHorizontalAlignment(0);
        this.jLabel77.setText("74");
        this.jLabel78.setFont(new Font("Arial", 1, 12));
        this.jLabel78.setForeground(new Color(255, 51, 0));
        this.jLabel78.setHorizontalAlignment(0);
        this.jLabel78.setText("73");
        this.jLabel79.setFont(new Font("Arial", 1, 12));
        this.jLabel79.setForeground(new Color(255, 51, 0));
        this.jLabel79.setHorizontalAlignment(0);
        this.jLabel79.setText("83");
        this.JP78.setMaximumSize(new Dimension(41, 45));
        this.JP78.setMinimumSize(new Dimension(41, 45));
        this.JP78.setName("75");
        this.JP78.setOpaque(false);
        this.JP78.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.46
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP78MouseClicked(evt);
            }
        });
        this.JP78.setLayout((LayoutManager) null);
        this.JL309.setMaximumSize(new Dimension(41, 45));
        this.JL309.setMinimumSize(new Dimension(41, 45));
        this.JL309.setName("4");
        this.JL309.setPreferredSize(new Dimension(41, 45));
        this.JP78.add(this.JL309);
        this.JL309.setBounds(0, 0, 41, 45);
        this.JL310.setMaximumSize(new Dimension(41, 45));
        this.JL310.setMinimumSize(new Dimension(41, 45));
        this.JL310.setName("3");
        this.JL310.setPreferredSize(new Dimension(41, 45));
        this.JP78.add(this.JL310);
        this.JL310.setBounds(0, 0, 41, 45);
        this.JL311.setMaximumSize(new Dimension(41, 45));
        this.JL311.setMinimumSize(new Dimension(41, 45));
        this.JL311.setName("2");
        this.JL311.setPreferredSize(new Dimension(41, 45));
        this.JP78.add(this.JL311);
        this.JL311.setBounds(0, 0, 41, 45);
        this.JL312.setMaximumSize(new Dimension(41, 45));
        this.JL312.setMinimumSize(new Dimension(41, 45));
        this.JL312.setName("1");
        this.JL312.setPreferredSize(new Dimension(41, 45));
        this.JP78.add(this.JL312);
        this.JL312.setBounds(0, 0, 41, 45);
        this.JLDBlanco78.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco78.setName("0");
        this.JP78.add(this.JLDBlanco78);
        this.JLDBlanco78.setBounds(0, 0, 41, 45);
        this.JP79.setMaximumSize(new Dimension(41, 45));
        this.JP79.setMinimumSize(new Dimension(41, 45));
        this.JP79.setName("74");
        this.JP79.setOpaque(false);
        this.JP79.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.47
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP79MouseClicked(evt);
            }
        });
        this.JP79.setLayout((LayoutManager) null);
        this.JL313.setMaximumSize(new Dimension(41, 45));
        this.JL313.setMinimumSize(new Dimension(41, 45));
        this.JL313.setName("4");
        this.JL313.setPreferredSize(new Dimension(41, 45));
        this.JP79.add(this.JL313);
        this.JL313.setBounds(0, 0, 41, 45);
        this.JL314.setMaximumSize(new Dimension(41, 45));
        this.JL314.setMinimumSize(new Dimension(41, 45));
        this.JL314.setName("3");
        this.JL314.setPreferredSize(new Dimension(41, 45));
        this.JP79.add(this.JL314);
        this.JL314.setBounds(0, 0, 41, 45);
        this.JL315.setMaximumSize(new Dimension(41, 45));
        this.JL315.setMinimumSize(new Dimension(41, 45));
        this.JL315.setName("2");
        this.JL315.setPreferredSize(new Dimension(41, 45));
        this.JP79.add(this.JL315);
        this.JL315.setBounds(0, 0, 41, 45);
        this.JL316.setMaximumSize(new Dimension(41, 45));
        this.JL316.setMinimumSize(new Dimension(41, 45));
        this.JL316.setName("1");
        this.JL316.setPreferredSize(new Dimension(41, 45));
        this.JP79.add(this.JL316);
        this.JL316.setBounds(0, 0, 41, 45);
        this.JLDBlanco79.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco79.setName("0");
        this.JP79.add(this.JLDBlanco79);
        this.JLDBlanco79.setBounds(0, 0, 41, 45);
        this.JP80.setMaximumSize(new Dimension(41, 45));
        this.JP80.setMinimumSize(new Dimension(41, 45));
        this.JP80.setName("72");
        this.JP80.setOpaque(false);
        this.JP80.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.48
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP80MouseClicked(evt);
            }
        });
        this.JP80.setLayout((LayoutManager) null);
        this.JL317.setMaximumSize(new Dimension(41, 45));
        this.JL317.setMinimumSize(new Dimension(41, 45));
        this.JL317.setName("4");
        this.JL317.setPreferredSize(new Dimension(41, 45));
        this.JP80.add(this.JL317);
        this.JL317.setBounds(0, 0, 41, 45);
        this.JL318.setMaximumSize(new Dimension(41, 45));
        this.JL318.setMinimumSize(new Dimension(41, 45));
        this.JL318.setName("3");
        this.JL318.setPreferredSize(new Dimension(41, 45));
        this.JP80.add(this.JL318);
        this.JL318.setBounds(0, 0, 41, 45);
        this.JL319.setMaximumSize(new Dimension(41, 45));
        this.JL319.setMinimumSize(new Dimension(41, 45));
        this.JL319.setName("2");
        this.JL319.setPreferredSize(new Dimension(41, 45));
        this.JP80.add(this.JL319);
        this.JL319.setBounds(0, 0, 41, 45);
        this.JL320.setMaximumSize(new Dimension(41, 45));
        this.JL320.setMinimumSize(new Dimension(41, 45));
        this.JL320.setName("1");
        this.JL320.setPreferredSize(new Dimension(41, 45));
        this.JP80.add(this.JL320);
        this.JL320.setBounds(0, 0, 41, 45);
        this.JLDBlanco80.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco80.setName("0");
        this.JP80.add(this.JLDBlanco80);
        this.JLDBlanco80.setBounds(0, 0, 41, 45);
        this.jLabel80.setFont(new Font("Arial", 1, 12));
        this.jLabel80.setForeground(new Color(255, 51, 0));
        this.jLabel80.setHorizontalAlignment(0);
        this.jLabel80.setText("75");
        this.JP81.setMaximumSize(new Dimension(41, 45));
        this.JP81.setMinimumSize(new Dimension(41, 45));
        this.JP81.setName("73");
        this.JP81.setOpaque(false);
        this.JP81.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.49
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP81MouseClicked(evt);
            }
        });
        this.JP81.setLayout((LayoutManager) null);
        this.JL321.setMaximumSize(new Dimension(41, 45));
        this.JL321.setMinimumSize(new Dimension(41, 45));
        this.JL321.setName("4");
        this.JL321.setPreferredSize(new Dimension(41, 45));
        this.JP81.add(this.JL321);
        this.JL321.setBounds(0, 0, 41, 45);
        this.JL322.setMaximumSize(new Dimension(41, 45));
        this.JL322.setMinimumSize(new Dimension(41, 45));
        this.JL322.setName("3");
        this.JL322.setPreferredSize(new Dimension(41, 45));
        this.JP81.add(this.JL322);
        this.JL322.setBounds(0, 0, 41, 45);
        this.JL323.setMaximumSize(new Dimension(41, 45));
        this.JL323.setMinimumSize(new Dimension(41, 45));
        this.JL323.setName("2");
        this.JL323.setPreferredSize(new Dimension(41, 45));
        this.JP81.add(this.JL323);
        this.JL323.setBounds(0, 0, 41, 45);
        this.JL324.setMaximumSize(new Dimension(41, 45));
        this.JL324.setMinimumSize(new Dimension(41, 45));
        this.JL324.setName("1");
        this.JL324.setPreferredSize(new Dimension(41, 45));
        this.JP81.add(this.JL324);
        this.JL324.setBounds(0, 0, 41, 45);
        this.JLDBlanco81.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco81.setName("0");
        this.JP81.add(this.JLDBlanco81);
        this.JLDBlanco81.setBounds(0, 0, 41, 45);
        this.jLabel81.setFont(new Font("Arial", 1, 12));
        this.jLabel81.setForeground(new Color(255, 51, 0));
        this.jLabel81.setHorizontalAlignment(0);
        this.jLabel81.setText("84");
        this.jLabel82.setFont(new Font("Arial", 1, 12));
        this.jLabel82.setForeground(new Color(255, 51, 0));
        this.jLabel82.setHorizontalAlignment(0);
        this.jLabel82.setText("85");
        this.jLabel83.setFont(new Font("Arial", 1, 12));
        this.jLabel83.setForeground(new Color(255, 51, 0));
        this.jLabel83.setHorizontalAlignment(0);
        this.jLabel83.setText("81");
        this.JP82.setMaximumSize(new Dimension(41, 45));
        this.JP82.setMinimumSize(new Dimension(41, 45));
        this.JP82.setName("85");
        this.JP82.setOpaque(false);
        this.JP82.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.50
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP82MouseClicked(evt);
            }
        });
        this.JP82.setLayout((LayoutManager) null);
        this.JL325.setMaximumSize(new Dimension(41, 45));
        this.JL325.setMinimumSize(new Dimension(41, 45));
        this.JL325.setName("4");
        this.JL325.setPreferredSize(new Dimension(41, 45));
        this.JP82.add(this.JL325);
        this.JL325.setBounds(0, 0, 41, 45);
        this.JL326.setMaximumSize(new Dimension(41, 45));
        this.JL326.setMinimumSize(new Dimension(41, 45));
        this.JL326.setName("3");
        this.JL326.setPreferredSize(new Dimension(41, 45));
        this.JP82.add(this.JL326);
        this.JL326.setBounds(0, 0, 41, 45);
        this.JL327.setMaximumSize(new Dimension(41, 45));
        this.JL327.setMinimumSize(new Dimension(41, 45));
        this.JL327.setName("2");
        this.JL327.setPreferredSize(new Dimension(41, 45));
        this.JP82.add(this.JL327);
        this.JL327.setBounds(0, 0, 41, 45);
        this.JL328.setMaximumSize(new Dimension(41, 45));
        this.JL328.setMinimumSize(new Dimension(41, 45));
        this.JL328.setName("1");
        this.JL328.setPreferredSize(new Dimension(41, 45));
        this.JP82.add(this.JL328);
        this.JL328.setBounds(0, 0, 41, 45);
        this.JLDBlanco82.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco82.setName("0");
        this.JP82.add(this.JLDBlanco82);
        this.JLDBlanco82.setBounds(0, 0, 41, 45);
        this.JP83.setMaximumSize(new Dimension(41, 45));
        this.JP83.setMinimumSize(new Dimension(41, 45));
        this.JP83.setName("84");
        this.JP83.setOpaque(false);
        this.JP83.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.51
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP83MouseClicked(evt);
            }
        });
        this.JP83.setLayout((LayoutManager) null);
        this.JL329.setMaximumSize(new Dimension(41, 45));
        this.JL329.setMinimumSize(new Dimension(41, 45));
        this.JL329.setName("4");
        this.JL329.setPreferredSize(new Dimension(41, 45));
        this.JP83.add(this.JL329);
        this.JL329.setBounds(0, 0, 41, 45);
        this.JL330.setMaximumSize(new Dimension(41, 45));
        this.JL330.setMinimumSize(new Dimension(41, 45));
        this.JL330.setName("3");
        this.JL330.setPreferredSize(new Dimension(41, 45));
        this.JP83.add(this.JL330);
        this.JL330.setBounds(0, 0, 41, 45);
        this.JL331.setMaximumSize(new Dimension(41, 45));
        this.JL331.setMinimumSize(new Dimension(41, 45));
        this.JL331.setName("2");
        this.JL331.setPreferredSize(new Dimension(41, 45));
        this.JP83.add(this.JL331);
        this.JL331.setBounds(0, 0, 41, 45);
        this.JL332.setMaximumSize(new Dimension(41, 45));
        this.JL332.setMinimumSize(new Dimension(41, 45));
        this.JL332.setName("1");
        this.JL332.setPreferredSize(new Dimension(41, 45));
        this.JP83.add(this.JL332);
        this.JL332.setBounds(0, 0, 41, 45);
        this.JLDBlanco83.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco83.setName("0");
        this.JP83.add(this.JLDBlanco83);
        this.JLDBlanco83.setBounds(0, 0, 41, 45);
        this.JP84.setMaximumSize(new Dimension(41, 45));
        this.JP84.setMinimumSize(new Dimension(41, 45));
        this.JP84.setName("71");
        this.JP84.setOpaque(false);
        this.JP84.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaCPCompleto.52
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaCPCompleto.this.JP84MouseClicked(evt);
            }
        });
        this.JP84.setLayout((LayoutManager) null);
        this.JL333.setMaximumSize(new Dimension(41, 45));
        this.JL333.setMinimumSize(new Dimension(41, 45));
        this.JL333.setName("4");
        this.JL333.setPreferredSize(new Dimension(41, 45));
        this.JP84.add(this.JL333);
        this.JL333.setBounds(0, 0, 41, 45);
        this.JL334.setMaximumSize(new Dimension(41, 45));
        this.JL334.setMinimumSize(new Dimension(41, 45));
        this.JL334.setName("3");
        this.JL334.setPreferredSize(new Dimension(41, 45));
        this.JP84.add(this.JL334);
        this.JL334.setBounds(0, 0, 41, 45);
        this.JL335.setMaximumSize(new Dimension(41, 45));
        this.JL335.setMinimumSize(new Dimension(41, 45));
        this.JL335.setName("2");
        this.JL335.setPreferredSize(new Dimension(41, 45));
        this.JP84.add(this.JL335);
        this.JL335.setBounds(0, 0, 41, 45);
        this.JL336.setMaximumSize(new Dimension(41, 45));
        this.JL336.setMinimumSize(new Dimension(41, 45));
        this.JL336.setName("1");
        this.JL336.setPreferredSize(new Dimension(41, 45));
        this.JP84.add(this.JL336);
        this.JL336.setBounds(0, 0, 41, 45);
        this.JLDBlanco84.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ControlPlaca/diente_blancoCP.png")));
        this.JLDBlanco84.setName("0");
        this.JP84.add(this.JLDBlanco84);
        this.JLDBlanco84.setBounds(0, 0, 41, 45);
        this.jLabel84.setFont(new Font("Arial", 1, 12));
        this.jLabel84.setForeground(new Color(255, 51, 0));
        this.jLabel84.setHorizontalAlignment(0);
        this.jLabel84.setText("82");
        this.jLabel85.setFont(new Font("Arial", 1, 12));
        this.jLabel85.setForeground(new Color(255, 51, 0));
        this.jLabel85.setHorizontalAlignment(0);
        this.jLabel85.setText("72");
        GroupLayout JPImOdontogramaLayout = new GroupLayout(this.JPImOdontograma);
        this.JPImOdontograma.setLayout(JPImOdontogramaLayout);
        JPImOdontogramaLayout.setHorizontalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel33, -2, 41, -2).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.jLabel32, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(240, 240, 240).addComponent(this.jLabel27, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(200, 200, 200).addComponent(this.jLabel28, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(120, 120, 120).addComponent(this.jLabel30, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(280, 280, 280).addComponent(this.jLabel26, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel31, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.jLabel29, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(320, 320, 320).addComponent(this.jLabel25, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(360, 360, 360).addComponent(this.jLabel24, -2, 41, -2))).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.jLabel22, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.jLabel21, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(200, 200, 200).addComponent(this.jLabel18, -2, 41, -2)).addComponent(this.jLabel23, -2, 41, -2).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(120, 120, 120).addComponent(this.jLabel20, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.jLabel19, -2, 41, -2)))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(320, 320, 320).addComponent(this.JP24, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JP31, -2, 41, -2)).addComponent(this.JP32, -2, 41, -2).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.JP28, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(360, 360, 360).addComponent(this.JP23, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(240, 240, 240).addComponent(this.JP26, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(280, 280, 280).addComponent(this.JP25, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.JP30, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(120, 120, 120).addComponent(this.JP29, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(200, 200, 200).addComponent(this.JP27, -2, 41, -2))).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(200, 200, 200).addComponent(this.JP17, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(120, 120, 120).addComponent(this.JP19, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(this.JP21, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.JP18, -2, 41, -2)).addComponent(this.JP22, -2, 41, -2).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(80, 80, 80).addComponent(this.JP20, -2, 41, -2)))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(84, 84, 84).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel66, -2, 41, -2).addComponent(this.JP66, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.JP67, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP68, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP69, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP65, -2, 42, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel67, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel68, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel69, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel70, -2, 41, -2))).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel75, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel74, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel73, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel72, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel71, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JP74, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP73, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP72, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP71, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP70, -2, 42, -2)))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel82, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel81, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel79, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel84, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel83, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JP82, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP83, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP77, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP76, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP75, -2, 42, -2))).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel76, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel85, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel78, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel77, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel80, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JP84, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP80, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP81, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP79, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP78, -2, 42, -2)))))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JP1, -1, -1, 32767).addComponent(this.jLabel2, -1, 41, 32767)).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel3, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel4, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel5, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel6, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel7, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel8, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel9, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel10, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel11, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel12, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel13, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel14, -2, 41, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPImOdontogramaLayout.createSequentialGroup().addComponent(this.JP2, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP3, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP4, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP5, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP6, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP7, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP8, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP9, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP10, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP11, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP12, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP13, -2, 41, -2))).addGap(0, 0, 0).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.JP14, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP15, -2, 41, -2).addGap(0, 0, 0).addComponent(this.JP16, -2, 41, -2)).addGroup(JPImOdontogramaLayout.createSequentialGroup().addComponent(this.jLabel15, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel16, -2, 41, -2).addGap(0, 0, 0).addComponent(this.jLabel17, -2, 41, -2))))).addContainerGap(25, 32767)));
        JPImOdontogramaLayout.setVerticalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jLabel7).addComponent(this.jLabel8).addComponent(this.jLabel9).addComponent(this.jLabel10).addComponent(this.jLabel11).addComponent(this.jLabel12).addComponent(this.jLabel13).addComponent(this.jLabel14).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel16).addComponent(this.jLabel17).addComponent(this.jLabel15))).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP1, -1, 45, 32767).addComponent(this.JP2, -1, -1, 32767).addComponent(this.JP3, -1, -1, 32767).addComponent(this.JP4, -1, -1, 32767).addComponent(this.JP5, -1, -1, 32767).addComponent(this.JP6, -1, -1, 32767).addComponent(this.JP7, -1, -1, 32767).addComponent(this.JP8, -1, -1, 32767).addComponent(this.JP9, -1, -1, 32767).addComponent(this.JP10, -1, -1, 32767).addComponent(this.JP11, -1, -1, 32767).addComponent(this.JP12, -1, -1, 32767).addComponent(this.JP13, -1, -1, 32767).addComponent(this.JP14, -1, -1, 32767).addComponent(this.JP15, -1, -1, 32767).addComponent(this.JP16, -1, -1, 32767)).addGap(5, 5, 5).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel67).addComponent(this.jLabel66)).addComponent(this.jLabel68).addComponent(this.jLabel69).addComponent(this.jLabel70)).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP66, -1, -1, 32767).addComponent(this.JP67, -1, -1, 32767).addComponent(this.JP68, -1, -1, 32767).addComponent(this.JP69, -1, -1, 32767).addComponent(this.JP65, -2, 45, -2))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel75).addComponent(this.jLabel74).addComponent(this.jLabel73).addComponent(this.jLabel72).addComponent(this.jLabel71)).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP74, -1, -1, 32767).addComponent(this.JP73, -1, -1, 32767).addComponent(this.JP72, -1, -1, 32767).addComponent(this.JP71, -1, -1, 32767).addComponent(this.JP70, -2, 45, -2)))).addGap(3, 3, 3).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel82).addComponent(this.jLabel81).addComponent(this.jLabel79).addComponent(this.jLabel84).addComponent(this.jLabel83)).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP82, -1, -1, 32767).addComponent(this.JP83, -1, -1, 32767).addComponent(this.JP77, -1, -1, 32767).addComponent(this.JP76, -1, -1, 32767).addComponent(this.JP75, -2, 45, -2))).addGroup(JPImOdontogramaLayout.createSequentialGroup().addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel76).addComponent(this.jLabel85).addComponent(this.jLabel78).addComponent(this.jLabel77).addComponent(this.jLabel80)).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JP84, -1, -1, 32767).addComponent(this.JP80, -1, -1, 32767).addComponent(this.JP81, -1, -1, 32767).addComponent(this.JP79, -1, -1, 32767).addComponent(this.JP78, -2, 45, -2)))).addGap(5, 5, 5).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel33).addComponent(this.jLabel32).addComponent(this.jLabel27).addComponent(this.jLabel28).addComponent(this.jLabel30).addComponent(this.jLabel26).addComponent(this.jLabel31).addComponent(this.jLabel29).addComponent(this.jLabel25).addComponent(this.jLabel24).addComponent(this.jLabel22).addComponent(this.jLabel21).addComponent(this.jLabel18).addComponent(this.jLabel23).addComponent(this.jLabel20).addComponent(this.jLabel19)).addGap(1, 1, 1).addGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP24, -2, 45, -2).addComponent(this.JP31, -2, 45, -2).addComponent(this.JP32, -2, 45, -2).addComponent(this.JP28, -2, 45, -2).addComponent(this.JP23, -2, 45, -2).addComponent(this.JP26, -2, 45, -2).addComponent(this.JP25, -2, 45, -2).addComponent(this.JP30, -2, 45, -2).addComponent(this.JP29, -2, 45, -2).addComponent(this.JP27, -2, 45, -2).addComponent(this.JP17, -2, 45, -2).addComponent(this.JP19, -2, 45, -2).addComponent(this.JP21, -2, 45, -2).addComponent(this.JP18, -2, 45, -2).addComponent(this.JP22, -2, 45, -2).addComponent(this.JP20, -2, 45, -2)).addContainerGap(22, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 691, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontograma, GroupLayout.Alignment.TRAILING, -1, -1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 282, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontograma, -1, -1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP84MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP83MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP82MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP81MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP80MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP79MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP78MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP77MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP76MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP75MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP74MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP73MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP72MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP71MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP70MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP65MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP69MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP68MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP67MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP66MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP32MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP31MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP30MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP29MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP28MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP27MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP26MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP25MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP24MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP23MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP22MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP21MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP20MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP19MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP18MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP17MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP16MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP15MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP14MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP13MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP12MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP11MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP10MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP9MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP8MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP7MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP6MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP5MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP4MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP1MouseClicked(MouseEvent evt) {
    }
}
