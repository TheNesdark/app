package PyP;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.PyP_EAD_DAO;
import com.genoma.plus.dao.impl.historia.PyP_EAD_DAOImpl;
import com.genoma.plus.dto.historia.EADRangoColoresDTO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JPEAD_PuntuacionGrafica.class */
public class JPEAD_PuntuacionGrafica extends JPanel {
    private PyP_EAD_DAO xPyP_EAD_DAO;
    private List<EADRangoColoresDTO> listRC;
    private int rango;
    private int[] posiciones;
    private int[] puntuacionTipicaYDirecta;
    private Metodos metodos = new Metodos();
    private JLabel JLRango;
    private JTable JTGraficoPuntuacion;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;

    public JPEAD_PuntuacionGrafica(int rango, int[] puntuacionTipicaYDirecta) {
        initComponents();
        springStart();
        this.rango = rango;
        this.puntuacionTipicaYDirecta = puntuacionTipicaYDirecta;
        this.listRC = this.xPyP_EAD_DAO.getRangoColores(rango);
        iniciaComponentes();
        this.JTGraficoPuntuacion.setDefaultRenderer(Object.class, new RenderTable(this.posiciones));
    }

    private void springStart() {
        this.xPyP_EAD_DAO = (PyP_EAD_DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("pypEAD_DAO");
    }

    private void iniciaComponentes() {
        this.JTGraficoPuntuacion.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTGraficoPuntuacion.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTGraficoPuntuacion.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JLRango.setText("" + this.rango);
        for (int i = 3; i < this.JTGraficoPuntuacion.getColumnCount(); i++) {
            this.JTGraficoPuntuacion.getColumnModel().getColumn(i).setPreferredWidth(35);
        }
        List<EADRangoColoresDTO> listMG = (List) this.listRC.stream().filter(x -> {
            return "MG".equals(x.getCodigoArea());
        }).collect(Collectors.toList());
        List<EADRangoColoresDTO> listMF = (List) this.listRC.stream().filter(x2 -> {
            return "MF".equals(x2.getCodigoArea());
        }).collect(Collectors.toList());
        List<EADRangoColoresDTO> listAL = (List) this.listRC.stream().filter(x3 -> {
            return "AL".equals(x3.getCodigoArea());
        }).collect(Collectors.toList());
        List<EADRangoColoresDTO> listPS = (List) this.listRC.stream().filter(x4 -> {
            return "PS".equals(x4.getCodigoArea());
        }).collect(Collectors.toList());
        this.posiciones = new int[8];
        this.posiciones[0] = finaRojo(listMG, "R");
        this.posiciones[1] = finaRojo(listMF, "R");
        this.posiciones[2] = finaRojo(listAL, "R");
        this.posiciones[3] = finaRojo(listPS, "R");
        this.posiciones[4] = finaRojo(listMG, "A");
        this.posiciones[5] = finaRojo(listMF, "A");
        this.posiciones[6] = finaRojo(listAL, "A");
        this.posiciones[7] = finaRojo(listPS, "A");
        establecerPuntaje(this.puntuacionTipicaYDirecta[0], 0);
        establecerPuntaje(this.puntuacionTipicaYDirecta[1], 1);
        establecerPuntaje(this.puntuacionTipicaYDirecta[2], 2);
        establecerPuntaje(this.puntuacionTipicaYDirecta[3], 3);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[0]), 0, 2);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[1]), 1, 2);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[2]), 2, 2);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[3]), 3, 2);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[4]), 0, 1);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[5]), 1, 1);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[6]), 2, 1);
        this.JTGraficoPuntuacion.setValueAt(Integer.valueOf(this.puntuacionTipicaYDirecta[7]), 3, 1);
        System.out.println("PT MG " + this.puntuacionTipicaYDirecta[0] + " MF " + this.puntuacionTipicaYDirecta[1] + " AL " + this.puntuacionTipicaYDirecta[2] + " PS " + this.puntuacionTipicaYDirecta[3]);
    }

    private void establecerPuntaje(int puntaje, int fila) {
        for (int x = 0; x < this.JTGraficoPuntuacion.getColumnCount(); x++) {
            if (x > 2 && !this.JTGraficoPuntuacion.getColumnName(x).equals("-")) {
                if (Integer.parseInt(this.JTGraficoPuntuacion.getColumnName(x)) == puntaje) {
                    this.JTGraficoPuntuacion.setValueAt("X", fila, x);
                }
            } else if (puntaje > 0 && puntaje < 16) {
                this.JTGraficoPuntuacion.setValueAt("X", fila, 4);
            } else if (puntaje > 61 && puntaje < 100) {
                this.JTGraficoPuntuacion.setValueAt("X", fila, 52);
            }
        }
    }

    public void GenerarFoto() {
        this.jScrollPane1.repaint();
        try {
            this.metodos.saveScreenShot(this.jScrollPane1, "EAD", "JPAEscalaAbreviadaDeDesarrollo");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    private int finaRojo(List<EADRangoColoresDTO> listaGenerica, String color) {
        int posicion = 0;
        int x = 0;
        while (true) {
            if (x >= listaGenerica.size()) {
                break;
            }
            if (!listaGenerica.get(x).getColor().equals(color)) {
                x++;
            } else {
                posicion = listaGenerica.get(x).getRangoFinal();
                break;
            }
        }
        return posicion;
    }

    private void renderTabla(List<EADRangoColoresDTO> list, int i) {
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.JLRango = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.JTGraficoPuntuacion = new JTable();
        setBackground(Color.white);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Rango");
        this.jLabel1.setBorder(BorderFactory.createEtchedBorder());
        this.JLRango.setFont(new Font("Arial", 1, 36));
        this.JLRango.setHorizontalAlignment(0);
        this.JLRango.setText("12");
        this.JLRango.setToolTipText("");
        this.JLRango.setBorder(BorderFactory.createEtchedBorder());
        this.JTGraficoPuntuacion.setModel(new DefaultTableModel(new Object[]{new Object[]{"MG", new Integer(0), new Integer(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, new Object[]{"MF", new Integer(0), new Integer(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, new Object[]{"AL", new Integer(0), new Integer(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, new Object[]{"PS", new Integer(0), new Integer(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}}, new String[]{"Área", "PD", "PT", "0", "-", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "-", "100"}) { // from class: PyP.JPEAD_PuntuacionGrafica.1
            Class[] types = {String.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.JTGraficoPuntuacion.setAutoResizeMode(0);
        this.JTGraficoPuntuacion.setFocusable(false);
        this.JTGraficoPuntuacion.setRowSelectionAllowed(false);
        this.jScrollPane1.setViewportView(this.JTGraficoPuntuacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 65, -2).addComponent(this.JLRango, -2, 65, -2)).addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 727, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 0, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addGap(2, 2, 2).addComponent(this.JLRango, -2, 94, -2)));
    }

    /* JADX INFO: loaded from: GenomaP.jar:PyP/JPEAD_PuntuacionGrafica$RenderTable.class */
    public class RenderTable extends DefaultTableCellRenderer {
        int finRojoArea1;
        int finRojoArea2;
        int finRojoArea3;
        int finRojoArea4;
        int finAmarilloArea1;
        int finAmarilloArea2;
        int finAmarilloArea3;
        int finAmarilloArea4;

        public RenderTable(int[] arregloDePosiciones) {
            this.finRojoArea1 = 0;
            this.finRojoArea2 = 0;
            this.finRojoArea3 = 0;
            this.finRojoArea4 = 0;
            this.finAmarilloArea1 = 0;
            this.finAmarilloArea2 = 0;
            this.finAmarilloArea3 = 0;
            this.finAmarilloArea4 = 0;
            this.finRojoArea1 = arregloDePosiciones[0];
            this.finRojoArea2 = arregloDePosiciones[1];
            this.finRojoArea3 = arregloDePosiciones[2];
            this.finRojoArea4 = arregloDePosiciones[3];
            this.finAmarilloArea1 = arregloDePosiciones[4];
            this.finAmarilloArea2 = arregloDePosiciones[5];
            this.finAmarilloArea3 = arregloDePosiciones[6];
            this.finAmarilloArea4 = arregloDePosiciones[7];
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            setEnabled(table == null || table.isEnabled());
            setBackground(Color.WHITE);
            table.setForeground(Color.black);
            setHorizontalAlignment(2);
            if (column > 2 && !table.getColumnName(column).equals("-")) {
                if ((Integer.parseInt(table.getColumnName(column)) > this.finAmarilloArea1 && row == 0) || ((Integer.parseInt(table.getColumnName(column)) > this.finAmarilloArea2 && row == 1) || ((Integer.parseInt(table.getColumnName(column)) > this.finAmarilloArea3 && row == 2) || (Integer.parseInt(table.getColumnName(column)) > this.finAmarilloArea4 && row == 3)))) {
                    setBackground(new Color(0, 166, 80));
                    setHorizontalAlignment(0);
                }
            } else if (table.getColumnName(column).equals("-") && column > 19) {
                setBackground(new Color(0, 166, 80));
                setHorizontalAlignment(0);
            }
            if (column > 2 && !table.getColumnName(column).equals("-") && ((Integer.parseInt(table.getColumnName(column)) > this.finRojoArea1 && Integer.parseInt(table.getColumnName(column)) <= this.finAmarilloArea1 && row == 0) || ((Integer.parseInt(table.getColumnName(column)) > this.finRojoArea2 && Integer.parseInt(table.getColumnName(column)) <= this.finAmarilloArea2 && row == 1) || ((Integer.parseInt(table.getColumnName(column)) > this.finRojoArea3 && Integer.parseInt(table.getColumnName(column)) <= this.finAmarilloArea3 && row == 2) || (Integer.parseInt(table.getColumnName(column)) > this.finRojoArea4 && Integer.parseInt(table.getColumnName(column)) <= this.finAmarilloArea4 && row == 3))))) {
                setBackground(new Color(255, 242, 0));
                setHorizontalAlignment(0);
            }
            if (column > 2 && !table.getColumnName(column).equals("-")) {
                if ((Integer.parseInt(table.getColumnName(column)) <= this.finRojoArea1 && row == 0) || ((Integer.parseInt(table.getColumnName(column)) <= this.finRojoArea2 && row == 1) || ((Integer.parseInt(table.getColumnName(column)) <= this.finRojoArea3 && row == 2) || (Integer.parseInt(table.getColumnName(column)) <= this.finRojoArea4 && row == 3)))) {
                    setBackground(new Color(237, 28, 36));
                    setHorizontalAlignment(0);
                }
            } else if (table.getColumnName(column).equals("-") && column < 19) {
                setBackground(new Color(237, 28, 36));
                setHorizontalAlignment(0);
            }
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            return this;
        }
    }
}
