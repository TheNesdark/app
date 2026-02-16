package Enfermeria;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JDBuscarInsumo.class */
public class JDBuscarInsumo extends JDialog {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelodetallet;
    private DefaultTableModel xmodeloH;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private Object[] xdato;
    private String xsql;
    private int xfila;
    private int xtipoim;
    public JButton JBTAdicionar;
    public JButton JBTGrabar;
    public JButton JBTSalir;
    private JLabel JLBNRegistro;
    private JPanel JPITDatosM;
    private JScrollPane JSPDatosDetMedicamentos;
    private JScrollPane JSPDatosMedicamentos;
    private JTable JTDatosDetMedicamentos;
    private JTable JTDatosMedicamentos;
    private JTextField JTFNombre;

    public JDBuscarInsumo(Frame parent, boolean modal, String xid) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xfila = 0;
        this.xtipoim = -1;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        this.JLBNRegistro.setText(xid);
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPITDatosM = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPDatosMedicamentos = new JScrollPane();
        this.JTDatosMedicamentos = new JTable();
        this.JBTAdicionar = new JButton();
        this.JSPDatosDetMedicamentos = new JScrollPane();
        this.JTDatosDetMedicamentos = new JTable();
        this.JBTSalir = new JButton();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("ADICIONAR INSUMO O DISPOSITIVO MÉDICO");
        this.JPITDatosM.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL MEDICAMENTO O DISPOSITIVO MÉDICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Medicamento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.1
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JTFNombreKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JDBuscarInsumo.this.JTFNombreKeyTyped(evt);
            }
        });
        this.JSPDatosMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDatosMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosMedicamentos.setCursor(new Cursor(0));
        this.JTDatosMedicamentos.setRowHeight(25);
        this.JTDatosMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosMedicamentos.setSelectionForeground(Color.red);
        this.JTDatosMedicamentos.setSelectionMode(0);
        this.JTDatosMedicamentos.addFocusListener(new FocusAdapter() { // from class: Enfermeria.JDBuscarInsumo.2
            public void focusLost(FocusEvent evt) {
                JDBuscarInsumo.this.JTDatosMedicamentosFocusLost(evt);
            }
        });
        this.JTDatosMedicamentos.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.3
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JTDatosMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosMedicamentos.setViewportView(this.JTDatosMedicamentos);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Enfermeria.JDBuscarInsumo.4
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInsumo.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTAdicionar.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.5
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JBTAdicionarKeyPressed(evt);
            }
        });
        GroupLayout JPITDatosMLayout = new GroupLayout(this.JPITDatosM);
        this.JPITDatosM.setLayout(JPITDatosMLayout);
        JPITDatosMLayout.setHorizontalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap().addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDatosMedicamentos).addComponent(this.JBTAdicionar, -1, -1, 32767)).addContainerGap()).addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 649, -2).addContainerGap(17, 32767))));
        JPITDatosMLayout.setVerticalGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addGap(70, 70, 70).addComponent(this.JSPDatosMedicamentos, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, -1, 32767).addGap(80, 80, 80)).addGroup(JPITDatosMLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosMLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTFNombre, -2, 50, -2).addGap(217, 217, 217))));
        this.JSPDatosDetMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosDetMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosDetMedicamentos.setRowHeight(25);
        this.JTDatosDetMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosDetMedicamentos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDatosDetMedicamentos.setSelectionMode(0);
        this.JTDatosDetMedicamentos.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.6
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JTDatosDetMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setViewportView(this.JTDatosDetMedicamentos);
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Enfermeria.JDBuscarInsumo.7
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInsumo.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBTSalir.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.8
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JBTSalirKeyPressed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Enfermeria.JDBuscarInsumo.9
            public void actionPerformed(ActionEvent evt) {
                JDBuscarInsumo.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTGrabar.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JDBuscarInsumo.10
            public void keyPressed(KeyEvent evt) {
                JDBuscarInsumo.this.JBTGrabarKeyPressed(evt);
            }
        });
        this.JLBNRegistro.setBackground(new Color(255, 255, 255));
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(Color.red);
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPITDatosM, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDatosDetMedicamentos, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JLBNRegistro, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabar, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 280, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPITDatosM, -2, 227, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosDetMedicamentos, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLBNRegistro, -2, 50, -2)).addComponent(this.JBTGrabar, -1, -1, 32767).addComponent(this.JBTSalir, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyTyped(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            mLLenartabla();
        } else {
            mCrearTablaMedicamentos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosFocusLost(FocusEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            mVerificarFVencimientoInvima();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosMedicamentosKeyPressed(KeyEvent evt) {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1 && evt.getKeyCode() == 9) {
            this.JTDatosMedicamentos.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDatosDetMedicamentos.getRowCount() != 0 && this.JTDatosDetMedicamentos.getSelectedRow() != -1) {
            this.xmodelodetallet.removeRow(this.JTDatosDetMedicamentos.getSelectedRow());
            this.xfila--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirKeyPressed(KeyEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarKeyPressed(KeyEvent evt) {
    }

    private void mGrabar() {
        if (this.JTDatosDetMedicamentos.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                for (int y = 0; y < this.JTDatosDetMedicamentos.getRowCount(); y++) {
                    this.xsql = "insert into `h_ordenes_unidosis_detalle`(`Id_Ordenes` , `Id_Suministro` , `Cantidad` )values('" + this.JLBNRegistro.getText() + "','" + this.xmodelodetallet.getValueAt(y, 0) + "','" + this.xmodelodetallet.getValueAt(y, 2) + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    dispose();
                }
            }
        }
    }

    private void mVerificarFVencimientoInvima() {
        if (Integer.valueOf(this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 8).toString()).intValue() == 0) {
            JOptionPane.showMessageDialog(this, "Medicamento con fecha: " + this.xmodelo.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 9).toString() + " de invima vencido.\nFavor revisar", "VERIFICACIÓN DE VENCIMIENTO INVIMA", 2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaMedicamentos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdPactivo", "Nombre Pricipio Activo", "IdProducto", "Producto", "Presentación", "Cantidad", "Valor", "", "Vencido", "FechaV", "CInventario", "Tipo", "CPedir"}) { // from class: Enfermeria.JDBuscarInsumo.11
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Integer.class, String.class, Boolean.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosMedicamentos.setModel(this.xmodelo);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDatosMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDatosMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDatosMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDatosMedicamentos.getColumnModel().getColumn(12).setPreferredWidth(30);
    }

    private void mLLenartabla() {
        try {
            mCrearTablaMedicamentos();
            this.xsql = "SELECT i_principioactivo.Id AS IdPrincipioActivo, i_principioactivo.Nbre AS NPrincipioActivo,i_suministro.Id AS IdSuministro, i_suministro.Nbre AS NSuministro, i_concentracion.Nbre AS NConcentracion ,i_presentacionfarmaceutica.Nbre AS NPresentacionF, i_presentacioncomercial.Nbre AS NPresentacionC, IF((SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente))>0, (SUM(i_suministroxlotexbodega.Cantidad)- SUM(i_suministroxlotexbodega.CPendiente)), 0)  AS Cantidad, ROUND(AVG(i_suministroxbodega.Costo)) AS Costo, i_presentacionfarmaceutica.EsAmpolla, IF((i_suministro.FechaVInvima<=NOW()),0,1) AS VFinvima, DATE_FORMAT(i_suministro.FechaVInvima,'%d-%m-%Y') AS FV, i_suministroxbodega.CInventario, i_suministro.`IdTipoProducto`  FROM  `i_suministro` INNER JOIN `i_principioactivo`  ON (`i_suministro`.`IdPrincipioActivo` = `i_principioactivo`.`Id`) INNER JOIN `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN `i_presentacionfarmaceutica`  ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`) INNER JOIN `i_laboratorio`   ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) INNER JOIN `i_concentracion`  ON (`i_suministro`.`IdConcentracion` = `i_concentracion`.`Id`) INNER JOIN `i_suministroxbodega`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN `i_suministroxlotexbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) INNER JOIN `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) WHERE (i_bodegas.EsUrg=1  AND i_principioactivo.Nbre<>'-' AND i_suministro.Nbre like '%" + this.JTFNombre.getText().toUpperCase() + "%')  GROUP BY IdSuministro ORDER BY i_principioactivo.Nbre, i_presentacionfarmaceutica.Nbre, i_suministroxbodega.Costo, IdSuministro, i_suministro.Nbre  ";
            ResultSet rss = this.xct.traerRs(this.xsql);
            if (rss.next()) {
                rss.beforeFirst();
                int x = 0;
                while (rss.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rss.getString(1), x, 0);
                    this.xmodelo.setValueAt(rss.getString(2), x, 1);
                    this.xmodelo.setValueAt(rss.getString(3), x, 2);
                    this.xmodelo.setValueAt(rss.getString(4) + " " + rss.getString(5), x, 3);
                    this.xmodelo.setValueAt(rss.getString(7), x, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(rss.getInt(8)), x, 5);
                    this.xmodelo.setValueAt(Long.valueOf(rss.getLong(9)), x, 6);
                    this.xmodelo.setValueAt(Long.valueOf(rss.getLong(11)), x, 8);
                    this.xmodelo.setValueAt(rss.getString(12), x, 9);
                    this.xmodelo.setValueAt(rss.getString(10), x, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(rss.getBoolean(13)), x, 10);
                    this.xmodelo.setValueAt(Long.valueOf(rss.getLong(14)), x, 11);
                    this.xmodelo.setValueAt(new Integer(1), x, 12);
                    x++;
                }
            }
            rss.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDBuscarInsumo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleMedicamentos() {
        this.xmodelodetallet = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "Cantidad"}) { // from class: Enfermeria.JDBuscarInsumo.12
            Class[] types = {Integer.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosDetMedicamentos.setModel(this.xmodelodetallet);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void mNuevo() {
        mCrearTablaMedicamentos();
        mCrearTablaDetalleMedicamentos();
    }

    private void mAdicionar() {
        if (this.JTDatosMedicamentos.getSelectedRow() != -1) {
            this.xmodelodetallet.addRow(this.xdato);
            this.xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 2), this.xfila, 0);
            this.xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 3), this.xfila, 1);
            this.xmodelodetallet.setValueAt(this.JTDatosMedicamentos.getValueAt(this.JTDatosMedicamentos.getSelectedRow(), 12), this.xfila, 2);
            this.xfila++;
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDatosMedicamentos.requestFocus();
    }
}
