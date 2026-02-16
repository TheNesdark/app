package Historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.GlasgowDAO;
import com.genoma.plus.dao.impl.historia.GlasgowDAOImpl;
import com.genoma.plus.dto.historia.GlasgowAntencionDTO;
import com.genoma.plus.dto.historia.GlasgowAtencionDetalleDTO;
import com.genoma.plus.dto.historia.GlasgowItemsDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGlasgow.class */
public class JPGlasgow extends JPanel {
    private GlasgowDAO xGlasgowDAO;
    private List<GlasgowItemsDTO> lisItems;
    private int itemOcular;
    private int itemVerbal;
    private int itemMotora;
    private Metodos xmt = new Metodos();
    private DefaultTableModel xModelo;
    private Object[] xdatos;
    private JLabel JLClasificacion;
    private JLabel JLPuntajeFinal;
    private JLabel JLPuntajeMot;
    private JLabel JLPuntajeOcu;
    private JLabel JLPuntajeVer;
    private JPanel JPMot;
    private JPanel JPOcular;
    private JPanel JPVerbal;
    private JTextArea JTAMot;
    private JTextArea JTAObservacion;
    private JTextArea JTAOcu;
    private JTextArea JTAVer;
    private JToggleButton JTBMot1;
    private JToggleButton JTBMot2;
    private JToggleButton JTBMot3;
    private JToggleButton JTBMot4;
    private JToggleButton JTBMot5;
    private JToggleButton JTBMot6;
    private JToggleButton JTBOcular1;
    private JToggleButton JTBOcular2;
    private JToggleButton JTBOcular3;
    private JToggleButton JTBOcular4;
    private JToggleButton JTBVerbal1;
    private JToggleButton JTBVerbal2;
    private JToggleButton JTBVerbal3;
    private JToggleButton JTBVerbal4;
    private JToggleButton JTBVerbal5;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JTabbedPane jTabbedPane1;
    private ButtonGroup motora;
    private ButtonGroup ocular;
    private ButtonGroup verbal;

    public JPGlasgow() {
        initComponents();
        springStart();
        getListaItems();
        mBuscaHistorico();
    }

    private void springStart() {
        this.xGlasgowDAO = (GlasgowDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("glasgowDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloHistorico() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "PuntajeTotal", "Clasificación", "Observación", "Profesional"}) { // from class: Historia.JPGlasgow.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mBuscaHistorico() {
        mCreaModeloHistorico();
        List<Object[]> lista = this.xGlasgowDAO.getHistorico(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
        if (!lista.isEmpty()) {
            for (int x = 0; x < lista.size(); x++) {
                this.xModelo.addRow(this.xdatos);
                this.xModelo.setValueAt(lista.get(x)[0], x, 0);
                this.xModelo.setValueAt(lista.get(x)[1], x, 1);
                this.xModelo.setValueAt(lista.get(x)[2], x, 2);
                this.xModelo.setValueAt(lista.get(x)[3], x, 3);
                this.xModelo.setValueAt(lista.get(x)[4], x, 4);
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    private void getListaItems() {
        this.lisItems = this.xGlasgowDAO.getGlasgowItems();
    }

    /* JADX WARN: Type inference failed for: r3v178, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.ocular = new ButtonGroup();
        this.verbal = new ButtonGroup();
        this.motora = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JPOcular = new JPanel();
        this.JTBOcular1 = new JToggleButton();
        this.JTBOcular2 = new JToggleButton();
        this.JTBOcular3 = new JToggleButton();
        this.JTBOcular4 = new JToggleButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAOcu = new JTextArea();
        this.JLPuntajeOcu = new JLabel();
        this.JPVerbal = new JPanel();
        this.JTBVerbal1 = new JToggleButton();
        this.JTBVerbal2 = new JToggleButton();
        this.JTBVerbal3 = new JToggleButton();
        this.JTBVerbal4 = new JToggleButton();
        this.JTBVerbal5 = new JToggleButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAVer = new JTextArea();
        this.JLPuntajeVer = new JLabel();
        this.JPMot = new JPanel();
        this.JTBMot1 = new JToggleButton();
        this.JTBMot2 = new JToggleButton();
        this.JTBMot3 = new JToggleButton();
        this.JTBMot4 = new JToggleButton();
        this.JTBMot5 = new JToggleButton();
        this.JTBMot6 = new JToggleButton();
        this.jScrollPane4 = new JScrollPane();
        this.JTAMot = new JTextArea();
        this.JLPuntajeMot = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLPuntajeFinal = new JLabel();
        this.JLClasificacion = new JLabel();
        this.jPanel1 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.JTDetalle = new JTable();
        setName("glasgowHC");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPOcular.setBorder(BorderFactory.createTitledBorder((Border) null, "OCULAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.ocular.add(this.JTBOcular1);
        this.JTBOcular1.setFont(new Font("Arial", 1, 11));
        this.JTBOcular1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/ocular/ocu_p1.png")));
        this.JTBOcular1.setText("1. NO RESPONDEN");
        this.JTBOcular1.setBorderPainted(false);
        this.JTBOcular1.setContentAreaFilled(false);
        this.JTBOcular1.setCursor(new Cursor(0));
        this.JTBOcular1.setHorizontalTextPosition(0);
        this.JTBOcular1.setName("1");
        this.JTBOcular1.setVerticalTextPosition(1);
        this.JTBOcular1.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.2
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBOcular1ActionPerformed(evt);
            }
        });
        this.ocular.add(this.JTBOcular2);
        this.JTBOcular2.setFont(new Font("Arial", 1, 11));
        this.JTBOcular2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/ocular/ocu_p2.png")));
        this.JTBOcular2.setText("2. AL DOLOR");
        this.JTBOcular2.setBorderPainted(false);
        this.JTBOcular2.setContentAreaFilled(false);
        this.JTBOcular2.setHorizontalTextPosition(0);
        this.JTBOcular2.setName("2");
        this.JTBOcular2.setVerticalTextPosition(1);
        this.JTBOcular2.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.3
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBOcular2ActionPerformed(evt);
            }
        });
        this.ocular.add(this.JTBOcular3);
        this.JTBOcular3.setFont(new Font("Arial", 1, 11));
        this.JTBOcular3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/ocular/ocu_p3.png")));
        this.JTBOcular3.setText("3. AL HABLARLE");
        this.JTBOcular3.setBorderPainted(false);
        this.JTBOcular3.setContentAreaFilled(false);
        this.JTBOcular3.setHorizontalTextPosition(0);
        this.JTBOcular3.setName("3");
        this.JTBOcular3.setVerticalTextPosition(1);
        this.JTBOcular3.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.4
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBOcular3ActionPerformed(evt);
            }
        });
        this.ocular.add(this.JTBOcular4);
        this.JTBOcular4.setFont(new Font("Arial", 1, 11));
        this.JTBOcular4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/ocular/ocu_p4.png")));
        this.JTBOcular4.setText("4. ESPONTÁNEA");
        this.JTBOcular4.setBorderPainted(false);
        this.JTBOcular4.setContentAreaFilled(false);
        this.JTBOcular4.setHorizontalTextPosition(0);
        this.JTBOcular4.setName("4");
        this.JTBOcular4.setVerticalTextPosition(1);
        this.JTBOcular4.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.5
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBOcular4ActionPerformed(evt);
            }
        });
        this.JTAOcu.setEditable(false);
        this.JTAOcu.setColumns(1);
        this.JTAOcu.setFont(new Font("Arial", 1, 12));
        this.JTAOcu.setLineWrap(true);
        this.JTAOcu.setRows(1);
        this.JTAOcu.setTabSize(1);
        this.JTAOcu.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAOcu);
        this.JLPuntajeOcu.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeOcu.setHorizontalAlignment(0);
        this.JLPuntajeOcu.setText("0");
        this.JLPuntajeOcu.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPOcularLayout = new GroupLayout(this.JPOcular);
        this.JPOcular.setLayout(JPOcularLayout);
        JPOcularLayout.setHorizontalGroup(JPOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOcularLayout.createSequentialGroup().addGroup(JPOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOcularLayout.createSequentialGroup().addContainerGap().addComponent(this.JLPuntajeOcu, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 673, -2)).addGroup(JPOcularLayout.createSequentialGroup().addGap(132, 132, 132).addComponent(this.JTBOcular4).addGap(12, 12, 12).addComponent(this.JTBOcular3).addGap(12, 12, 12).addComponent(this.JTBOcular2).addGap(12, 12, 12).addComponent(this.JTBOcular1))).addContainerGap(-1, 32767)));
        JPOcularLayout.setVerticalGroup(JPOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOcularLayout.createSequentialGroup().addGroup(JPOcularLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTBOcular3, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBOcular2, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBOcular1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTBOcular4, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLPuntajeOcu, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 48, 32767)).addGap(3, 3, 3)));
        this.JPVerbal.setBorder(BorderFactory.createTitledBorder((Border) null, "VERBAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.verbal.add(this.JTBVerbal1);
        this.JTBVerbal1.setFont(new Font("Arial", 1, 11));
        this.JTBVerbal1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/verbal/ver_p1.png")));
        this.JTBVerbal1.setText("<html><p style=\"text-align:center\">1. NINGUNA RESPUESTA</p></html>");
        this.JTBVerbal1.setBorderPainted(false);
        this.JTBVerbal1.setContentAreaFilled(false);
        this.JTBVerbal1.setCursor(new Cursor(0));
        this.JTBVerbal1.setHorizontalTextPosition(0);
        this.JTBVerbal1.setName("1");
        this.JTBVerbal1.setVerticalTextPosition(1);
        this.JTBVerbal1.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.6
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBVerbal1ActionPerformed(evt);
            }
        });
        this.verbal.add(this.JTBVerbal2);
        this.JTBVerbal2.setFont(new Font("Arial", 1, 11));
        this.JTBVerbal2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/verbal/ver_p2.png")));
        this.JTBVerbal2.setText("<html><p style=\"text-align:center\">2. SONIDOS INCOMPRENSIBLES</p></html>");
        this.JTBVerbal2.setBorderPainted(false);
        this.JTBVerbal2.setContentAreaFilled(false);
        this.JTBVerbal2.setHorizontalTextPosition(0);
        this.JTBVerbal2.setName("2");
        this.JTBVerbal2.setVerticalTextPosition(1);
        this.JTBVerbal2.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.7
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBVerbal2ActionPerformed(evt);
            }
        });
        this.verbal.add(this.JTBVerbal3);
        this.JTBVerbal3.setFont(new Font("Arial", 1, 11));
        this.JTBVerbal3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/verbal/ver_p3.png")));
        this.JTBVerbal3.setText("<html><p style=\"text-align:center\">3. PALABRAS INAPROPIADAS</p></html>");
        this.JTBVerbal3.setBorderPainted(false);
        this.JTBVerbal3.setContentAreaFilled(false);
        this.JTBVerbal3.setHorizontalTextPosition(0);
        this.JTBVerbal3.setName("3");
        this.JTBVerbal3.setVerticalTextPosition(1);
        this.JTBVerbal3.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.8
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBVerbal3ActionPerformed(evt);
            }
        });
        this.verbal.add(this.JTBVerbal4);
        this.JTBVerbal4.setFont(new Font("Arial", 1, 11));
        this.JTBVerbal4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/verbal/ver_p4.png")));
        this.JTBVerbal4.setText("<html><p style=\"text-align:center\">4. DESORIENTADO Y HABLANDO</p></html>");
        this.JTBVerbal4.setBorderPainted(false);
        this.JTBVerbal4.setContentAreaFilled(false);
        this.JTBVerbal4.setHorizontalTextPosition(0);
        this.JTBVerbal4.setName("4");
        this.JTBVerbal4.setVerticalTextPosition(1);
        this.JTBVerbal4.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.9
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBVerbal4ActionPerformed(evt);
            }
        });
        this.verbal.add(this.JTBVerbal5);
        this.JTBVerbal5.setFont(new Font("Arial", 1, 11));
        this.JTBVerbal5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/verbal/ver_p5.png")));
        this.JTBVerbal5.setText("<html><p style=\"text-align:center\">5. ORIENTADO Y CONVERSANDO</p></html>");
        this.JTBVerbal5.setBorderPainted(false);
        this.JTBVerbal5.setContentAreaFilled(false);
        this.JTBVerbal5.setHorizontalTextPosition(0);
        this.JTBVerbal5.setName("5");
        this.JTBVerbal5.setVerticalTextPosition(1);
        this.JTBVerbal5.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.10
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBVerbal5ActionPerformed(evt);
            }
        });
        this.JTAVer.setEditable(false);
        this.JTAVer.setColumns(1);
        this.JTAVer.setFont(new Font("Arial", 1, 12));
        this.JTAVer.setLineWrap(true);
        this.JTAVer.setRows(1);
        this.JTAVer.setTabSize(1);
        this.JTAVer.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAVer);
        this.JLPuntajeVer.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeVer.setHorizontalAlignment(0);
        this.JLPuntajeVer.setText("0");
        this.JLPuntajeVer.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPVerbalLayout = new GroupLayout(this.JPVerbal);
        this.JPVerbal.setLayout(JPVerbalLayout);
        JPVerbalLayout.setHorizontalGroup(JPVerbalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVerbalLayout.createSequentialGroup().addGroup(JPVerbalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVerbalLayout.createSequentialGroup().addContainerGap().addComponent(this.JLPuntajeVer, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 673, -2)).addGroup(JPVerbalLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.JTBVerbal5, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBVerbal4, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBVerbal3, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBVerbal2, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBVerbal1, -2, 124, -2))).addContainerGap(-1, 32767)));
        JPVerbalLayout.setVerticalGroup(JPVerbalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPVerbalLayout.createSequentialGroup().addGroup(JPVerbalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTBVerbal2, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBVerbal3, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBVerbal4, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBVerbal5, GroupLayout.Alignment.LEADING).addComponent(this.JTBVerbal1, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPVerbalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLPuntajeVer, -1, -1, 32767).addComponent(this.jScrollPane2, -2, 48, -2))));
        this.JPMot.setBorder(BorderFactory.createTitledBorder((Border) null, "MOTORA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.motora.add(this.JTBMot1);
        this.JTBMot1.setFont(new Font("Arial", 1, 11));
        this.JTBMot1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp1.png")));
        this.JTBMot1.setText("<html><p style=\"text-align:center\">1. NINGUNA RESPUESTA</p></html>");
        this.JTBMot1.setBorderPainted(false);
        this.JTBMot1.setContentAreaFilled(false);
        this.JTBMot1.setCursor(new Cursor(0));
        this.JTBMot1.setHorizontalTextPosition(0);
        this.JTBMot1.setName("1");
        this.JTBMot1.setVerticalTextPosition(1);
        this.JTBMot1.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.11
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot1ActionPerformed(evt);
            }
        });
        this.motora.add(this.JTBMot2);
        this.JTBMot2.setFont(new Font("Arial", 1, 11));
        this.JTBMot2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp2.png")));
        this.JTBMot2.setText("<html><p style=\"text-align:center\">2. EXTENSIÓN ANORMAL</p></html>");
        this.JTBMot2.setBorderPainted(false);
        this.JTBMot2.setContentAreaFilled(false);
        this.JTBMot2.setHorizontalTextPosition(0);
        this.JTBMot2.setName("2");
        this.JTBMot2.setVerticalTextPosition(1);
        this.JTBMot2.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.12
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot2ActionPerformed(evt);
            }
        });
        this.motora.add(this.JTBMot3);
        this.JTBMot3.setFont(new Font("Arial", 1, 11));
        this.JTBMot3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp3.png")));
        this.JTBMot3.setText("<html><p style=\"text-align:center\">3. FLEXIÓN ANORMAL</p></html>");
        this.JTBMot3.setBorderPainted(false);
        this.JTBMot3.setContentAreaFilled(false);
        this.JTBMot3.setHorizontalTextPosition(0);
        this.JTBMot3.setName("3");
        this.JTBMot3.setVerticalTextPosition(1);
        this.JTBMot3.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.13
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot3ActionPerformed(evt);
            }
        });
        this.motora.add(this.JTBMot4);
        this.JTBMot4.setFont(new Font("Arial", 1, 11));
        this.JTBMot4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp4.png")));
        this.JTBMot4.setText("<html><p style=\"text-align:center\">4. RETIRADA Y FLEXIÓN</p></html>");
        this.JTBMot4.setBorderPainted(false);
        this.JTBMot4.setContentAreaFilled(false);
        this.JTBMot4.setHorizontalTextPosition(0);
        this.JTBMot4.setName("4");
        this.JTBMot4.setVerticalTextPosition(1);
        this.JTBMot4.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.14
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot4ActionPerformed(evt);
            }
        });
        this.motora.add(this.JTBMot5);
        this.JTBMot5.setFont(new Font("Arial", 1, 11));
        this.JTBMot5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp5.png")));
        this.JTBMot5.setText("<html><p style=\"text-align:center\">5. LOCALIZA EL DOLOR</p></html>");
        this.JTBMot5.setBorderPainted(false);
        this.JTBMot5.setContentAreaFilled(false);
        this.JTBMot5.setHorizontalTextPosition(0);
        this.JTBMot5.setName("5");
        this.JTBMot5.setVerticalTextPosition(1);
        this.JTBMot5.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.15
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot5ActionPerformed(evt);
            }
        });
        this.motora.add(this.JTBMot6);
        this.JTBMot6.setFont(new Font("Arial", 1, 11));
        this.JTBMot6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/EG/motora/motp6.png")));
        this.JTBMot6.setText("<html><p style=\"text-align:center\">6. OBEDECE ORDEN VERBAL</p></html>");
        this.JTBMot6.setBorderPainted(false);
        this.JTBMot6.setContentAreaFilled(false);
        this.JTBMot6.setHorizontalTextPosition(0);
        this.JTBMot6.setName("6");
        this.JTBMot6.setVerticalTextPosition(1);
        this.JTBMot6.addActionListener(new ActionListener() { // from class: Historia.JPGlasgow.16
            public void actionPerformed(ActionEvent evt) {
                JPGlasgow.this.JTBMot6ActionPerformed(evt);
            }
        });
        this.JTAMot.setEditable(false);
        this.JTAMot.setColumns(1);
        this.JTAMot.setFont(new Font("Arial", 1, 12));
        this.JTAMot.setLineWrap(true);
        this.JTAMot.setRows(1);
        this.JTAMot.setTabSize(1);
        this.JTAMot.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane4.setViewportView(this.JTAMot);
        this.JLPuntajeMot.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeMot.setHorizontalAlignment(0);
        this.JLPuntajeMot.setText("0");
        this.JLPuntajeMot.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPMotLayout = new GroupLayout(this.JPMot);
        this.JPMot.setLayout(JPMotLayout);
        JPMotLayout.setHorizontalGroup(JPMotLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMotLayout.createSequentialGroup().addGroup(JPMotLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMotLayout.createSequentialGroup().addContainerGap().addComponent(this.JLPuntajeMot, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 673, -2)).addGroup(JPMotLayout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.JTBMot6, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBMot5, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBMot4, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBMot3, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBMot2, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBMot1, -2, 108, -2))).addContainerGap(-1, 32767)));
        JPMotLayout.setVerticalGroup(JPMotLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMotLayout.createSequentialGroup().addGroup(JPMotLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTBMot2, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBMot3, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBMot4, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBMot5, GroupLayout.Alignment.LEADING, -2, 0, 32767).addComponent(this.JTBMot6, GroupLayout.Alignment.LEADING, -2, 120, -2).addComponent(this.JTBMot1, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPMotLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLPuntajeMot, -1, -1, 32767).addComponent(this.jScrollPane4, -2, 48, -2)).addContainerGap(-1, 32767)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTAObservacion);
        this.JLPuntajeFinal.setFont(new Font("Arial", 1, 18));
        this.JLPuntajeFinal.setForeground(new Color(0, 102, 0));
        this.JLPuntajeFinal.setHorizontalAlignment(0);
        this.JLPuntajeFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLClasificacion.setFont(new Font("Arial", 1, 18));
        this.JLClasificacion.setForeground(new Color(0, 102, 0));
        this.JLClasificacion.setHorizontalAlignment(0);
        this.JLClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPVerbal, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPOcular, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.JLPuntajeFinal, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLClasificacion, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 399, -2)).addComponent(this.JPMot, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPOcular, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPVerbal, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMot, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane3).addComponent(this.JLPuntajeFinal, -1, -1, 32767).addComponent(this.JLClasificacion, -2, 57, -2)).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("ESCALA DE GLASGOW", this.jPanel2);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane5.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 748, 32767).addGap(37, 37, 37)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5, -1, 227, 32767).addGap(438, 438, 438)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 812, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOcular1ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.ocular, 1, this.JLPuntajeOcu, this.JTAOcu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOcular2ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.ocular, 1, this.JLPuntajeOcu, this.JTAOcu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOcular3ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.ocular, 1, this.JLPuntajeOcu, this.JTAOcu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBOcular4ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.ocular, 1, this.JLPuntajeOcu, this.JTAOcu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerbal1ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.verbal, 2, this.JLPuntajeVer, this.JTAVer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerbal2ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.verbal, 2, this.JLPuntajeVer, this.JTAVer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerbal3ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.verbal, 2, this.JLPuntajeVer, this.JTAVer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerbal4ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.verbal, 2, this.JLPuntajeVer, this.JTAVer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBVerbal5ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.verbal, 2, this.JLPuntajeVer, this.JTAVer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot1ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot2ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot3ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot4ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot5ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBMot6ActionPerformed(ActionEvent evt) {
        getValueRadioButton(this.motora, 3, this.JLPuntajeMot, this.JTAMot);
    }

    public void getValueRadioButton(ButtonGroup buttonGroup, int grupo, JLabel label, JTextArea tArea) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                button.setContentAreaFilled(true);
                List<GlasgowItemsDTO> item = (List) this.lisItems.stream().filter(t -> {
                    return t.getId_grupoglasgow() == grupo && t.getPuntos() == Integer.valueOf(button.getName()).intValue();
                }).collect(Collectors.toList());
                label.setText("" + item.get(0).getPuntos());
                tArea.setText("" + item.get(0).getDescripcion());
                switch (grupo) {
                    case 1:
                        this.itemOcular = item.get(0).getId();
                        break;
                    case 2:
                        this.itemVerbal = item.get(0).getId();
                        break;
                    case 3:
                        this.itemMotora = item.get(0).getId();
                        break;
                }
                mCalculaPuntaje();
            } else {
                button.setContentAreaFilled(false);
            }
        }
    }

    private void mCalculaPuntaje() {
        if (!this.JLPuntajeOcu.getText().equals("0") && !this.JLPuntajeVer.getText().equals("0") && !this.JLPuntajeMot.getText().equals("0")) {
            int suma = Integer.valueOf(this.JLPuntajeOcu.getText()).intValue() + Integer.valueOf(this.JLPuntajeVer.getText()).intValue() + Integer.valueOf(this.JLPuntajeMot.getText()).intValue();
            this.JLPuntajeFinal.setText("" + suma);
            if (suma >= 3 && suma <= 8) {
                this.JLClasificacion.setText("GRAVE");
                return;
            }
            if (suma >= 9 && suma <= 12) {
                this.JLClasificacion.setText("MODERADO");
            } else if (suma >= 13 && suma <= 15) {
                this.JLClasificacion.setText("LEVE");
            }
        }
    }

    public void mGrabar() {
        if (!this.JLPuntajeOcu.getText().equals("0")) {
            if (!this.JLPuntajeVer.getText().equals("0")) {
                if (!this.JLPuntajeMot.getText().equals("0")) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        GlasgowAntencionDTO gatencion = new GlasgowAntencionDTO();
                        gatencion.setIdatencion(Integer.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()).intValue());
                        gatencion.setFechar(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                        gatencion.setIdusuarioa(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                        gatencion.setObservacion(this.JTAObservacion.getText());
                        gatencion.setIdprofesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                        gatencion.setIdespecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
                        gatencion.setClasificacion(this.JLClasificacion.getText());
                        gatencion.setPuntajetotal(Integer.valueOf(this.JLPuntajeFinal.getText()).intValue());
                        gatencion.setUsuarios(Principal.usuarioSistemaDTO.getLogin());
                        Long idga = this.xGlasgowDAO.guardaAntencion(gatencion);
                        for (int i = 1; i < 4; i++) {
                            GlasgowAtencionDetalleDTO detalle = new GlasgowAtencionDetalleDTO();
                            detalle.setId_glasgow_atencion(idga);
                            switch (i) {
                                case 1:
                                    detalle.setId_item_glasgow(this.itemOcular);
                                    detalle.setPuntaje(Integer.valueOf(this.JLPuntajeOcu.getText()).intValue());
                                    break;
                                case 2:
                                    detalle.setId_item_glasgow(this.itemVerbal);
                                    detalle.setPuntaje(Integer.valueOf(this.JLPuntajeVer.getText()).intValue());
                                    break;
                                case 3:
                                    detalle.setId_item_glasgow(this.itemMotora);
                                    detalle.setPuntaje(Integer.valueOf(this.JLPuntajeMot.getText()).intValue());
                                    break;
                            }
                            this.xGlasgowDAO.guardaDetalle(detalle);
                        }
                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        mBuscaHistorico();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opción en la sección Motora", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opción en la sección Verbal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una opción en la sección Ocular", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
