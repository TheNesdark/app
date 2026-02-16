package Armado;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFPItemRipsConsultas.class */
public class JIFPItemRipsConsultas extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JButton JBTCerrar;
    private JButton JBTImportar;
    public JDateChooser JDCFechaFin;
    public JDateChooser JDCFechaInicio;
    private JPanel jPanel1;

    public JIFPItemRipsConsultas() {
        initComponents();
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JBTCerrar = new JButton();
        this.JBTImportar = new JButton();
        setClosable(true);
        setTitle("IMPORTAR DX A RIPS DE CONSULTA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifitemripsconsultas");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JDCFechaInicio, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, 32767).addComponent(this.JDCFechaFin, -2, 140, -2).addGap(44, 44, 44)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFechaInicio, -2, 61, -2).addComponent(this.JDCFechaFin, -2, 61, -2)).addContainerGap(-1, 32767)));
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Armado.JIFPItemRipsConsultas.1
            public void actionPerformed(ActionEvent evt) {
                JIFPItemRipsConsultas.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTImportar.setFont(new Font("Arial", 1, 12));
        this.JBTImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBTImportar.setText("Importar");
        this.JBTImportar.addActionListener(new ActionListener() { // from class: Armado.JIFPItemRipsConsultas.2
            public void actionPerformed(ActionEvent evt) {
                JIFPItemRipsConsultas.this.JBTImportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTImportar, -2, 200, -2).addGap(18, 18, 18).addComponent(this.JBTCerrar, -2, 200, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar, -2, 45, -2).addComponent(this.JBTImportar, -2, 47, -2)).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImportarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Importar los datos", "CONFIRMAR", 0, 1);
        if (n == 0) {
            mCargarDatosPrg();
            mCargarDatosNP();
        }
    }

    private void mCargarDatosPrg() {
        String sql = "insert ignore into f_itemripsconsulta(Id_Ordenes, Id_Procedimiento, Id_TipoDx, Id_DxPrincipal, DxRelacional1, DxRelacional2, DxRelacional3, Fecha, UsuarioS) SELECT f_ordenes.Id, g_procedimiento.Id, h_atencion.Id_TipoDx, h_atencion.Codigo_Dxp, h_atencion.Codigo_DxR1, h_atencion.Codigo_DxR2, h_atencion.Codigo_DxR3, h_atencion.Fecha, h_atencion.UsuarioS FROM h_atencion INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE (g_procedimiento.Id_TipoProcRIPS =5 and ingreso.FechaIngreso>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "' and h_atencion.Codigo_Dxp <>'' and h_atencion.Codigo_Dxp <>'0000')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("INSERT IGNORE  INTO f_itemripsconsulta( Id_Ordenes , Id_Procedimiento , Id_TipoDx , Id_DxPrincipal , DxRelacional1 , DxRelacional2 , DxRelacional3) SELECT f_ordenes.Id  , f_itemordenesproced.Id_Procedimiento  , h_egreso_atencion.Id_Tipo , h_egreso_atencion.DxP , h_egreso_atencion.DxR1 , h_egreso_atencion.DxR2 , h_egreso_atencion.DxR3 FROM  f_ordenes  INNER JOIN  ingreso  ON (f_ordenes.Id_Ingreso = ingreso.Id)  INNER JOIN  f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN  g_procedimiento  ON (g_procedimiento.Id = f_itemordenesproced.Id_Procedimiento) INNER JOIN  h_egreso_atencion  ON (h_egreso_atencion.Id_Ingreso = ingreso.Id) AND (ingreso.Id_TipoAtencion=h_egreso_atencion.Id_Atencion) WHERE (g_procedimiento.Id_tipoprocedimiento=7 AND h_egreso_atencion.Estado=1) ");
        this.xct.cerrarConexionBd();
        String sql2 = "INSERT ignore INTO f_itemripsconsulta(   Id_Ordenes\n    , Id_Procedimiento\n    , Id_TipoDx\n    , Id_DxPrincipal)\nSELECT\n    f_itemordenesproced.Id_Ordenes\n    , f_itemordenesproced.Id_Procedimiento\n    , 3\n    , ingreso.DxIngreso   \nFROM\n    f_ordenes\n    INNER JOIN ingreso \n        ON (f_ordenes.Id_Ingreso = ingreso.Id)\n    INNER JOIN f_itemordenesproced \n        ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)\n    INNER JOIN g_procedimiento \n        ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN `g_patologia` ON (g_patologia.`Id` = ingreso.DxIngreso)\n    LEFT JOIN f_itemripsconsulta \n        ON (f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento) AND (f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes)\nWHERE (ingreso.DxIngreso <>''\n    AND f_itemripsconsulta.Id_Ordenes IS NULL\n    AND ingreso.DxIngreso <>'0000' \n    AND g_procedimiento.Id_TipoProcRIPS =5\n    AND ingreso.FechaIngreso >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\n    AND ingreso.FechaIngreso <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "');\n";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        String sql3 = " INSERT ignore  INTO f_itemripsconsulta(   Id_Ordenes\n    , Id_Procedimiento\n    , Id_TipoDx\n    , Id_DxPrincipal)\nSELECT\n    f_itemordenesproced.Id_Ordenes\n    , f_itemordenesproced.Id_Procedimiento\n    , 3\n    , ingreso.DxIngreso   \nFROM\n    f_ordenes\n        \n    INNER JOIN ingreso\n         \n        ON(f_ordenes.Id_Ingreso = ingreso.Id\n        )\n    INNER JOIN f_itemordenesproced\n         \n        ON(f_itemordenesproced.Id_Ordenes = f_ordenes.Id\n        )\n    INNER JOIN g_procedimiento\n         \n        ON(f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id\n        ) INNER JOIN `g_patologia` ON (g_patologia.`Id` = ingreso.DxIngreso) \n    LEFT JOIN f_itemripsconsulta\n         \n        ON(f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento\n        ) AND(f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes\n        )\nWHERE(ingreso.DxIngreso <>''\n    AND f_itemripsconsulta.Id_Ordenes\n         IS NULL\n    AND ingreso.DxIngreso <>'0000' \n    AND g_procedimiento.Id_TipoProcRIPS =5\n    AND ingreso.FechaIngreso >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' \n    AND ingreso.FechaIngreso<='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "') ";
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        String sql4 = "INSERT IGNORE INTO\n            f_itemripsconsulta(Id_Ordenes\n    , Id_Procedimiento\n    , Id_TipoDx\n    , Id_DxPrincipal,f_itemripsconsulta.DxRelacional1, f_itemripsconsulta.DxRelacional2, f_itemripsconsulta.DxRelacional3 )\nSELECT\n    f_itemordenesproced.Id_Ordenes\n    , f_itemordenesproced.Id_Procedimiento\n    , 1\n    , h_egreso_atencion.DxP,  h_egreso_atencion.DxR1,  h_egreso_atencion.DxR2,  h_egreso_atencion.DxR3\nFROM\n    f_ordenes\n    INNER JOIN ingreso \n        ON (f_ordenes.Id_Ingreso = ingreso.Id)\n    INNER JOIN f_itemordenesproced \n        ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)\n    INNER JOIN g_procedimiento \n        ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)\n    INNER JOIN h_egreso_atencion\n        ON (h_egreso_atencion.Id_Ingreso = ingreso.Id)        \n    LEFT JOIN f_itemripsconsulta \n        ON (f_itemripsconsulta.Id_Procedimiento = f_itemordenesproced.Id_Procedimiento) AND (f_itemripsconsulta.Id_Ordenes = f_itemordenesproced.Id_Ordenes)\nWHERE ( f_itemripsconsulta.Id_Ordenes IS NULL\n--    AND ingreso.DxIngreso <>'0000' \n  --  AND  ingreso.Id_TipoAtencion=3\n   -- AND g_procedimiento.Id_TipoProcRIPS =5\n    AND ingreso.FechaIngreso >='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "'\n    AND ingreso.FechaIngreso <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "')  ";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        String sql5 = " INSERT IGNORE INTO\n            f_itemripsconsulta(Id_Ordenes\n    , Id_Procedimiento\n    , Id_TipoDx\n    , Id_DxPrincipal,f_itemripsconsulta.DxRelacional1, f_itemripsconsulta.DxRelacional2, f_itemripsconsulta.DxRelacional3 )\n\n    select fi.Id_Ordenes, \n    fi.Id_Procedimiento,\n    ha.Id_TipoDx,\n    ha.Codigo_Dxp,\n    ha.Codigo_DxR1,\n    ha.Codigo_DxR2,\n    ha.Codigo_DxR3\n    from ingreso i\n    inner join f_ordenes fo on (fo.Id_Ingreso=i.Id)\n    INNER JOIN f_itemordenesproced fi  \n        ON (fi.Id_Ordenes = fo.Id)\n    INNER JOIN g_procedimiento gp\n        ON (fi.Id_Procedimiento = gp.Id)\n    inner join c_citas cc on (cc.Id_ingresoReal=i.Id)\n    inner join h_atencion ha on (ha.Id_Ingreso=cc.Id_ingreso)\n     LEFT JOIN f_itemripsconsulta fi2\n        ON (fi2.Id_Procedimiento = fi.Id_Procedimiento) AND (fi2.Id_Ordenes = fi.Id_Ordenes)\n    where i.FechaIngreso between '" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' and  '" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "'    and cc.Id_TratamientoO <>0 and  fi2.Id_Ordenes IS NULL";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
    }

    private void mCargarDatosNP() {
        try {
            String sql = "SELECT f_ordenes.Id, g_procedimiento.Id, h_atencion.Id_TipoDx, h_atencion.Codigo_Dxp, h_atencion.Codigo_DxR1, h_atencion.Codigo_DxR2, h_atencion.Codigo_DxR3, f_ordenes.Estado FROM baseserver.h_atencion INNER JOIN baseserver.ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.f_ordenes  ON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN baseserver.g_procedimiento  ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) WHERE g_procedimiento.Id_TipoProcRIPS =5 ingreso.FechaIngreso>='" + this.xmt.formatoDMA.format(this.JDCFechaInicio.getDate()) + "' AND ingreso.FechaIngreso<='" + this.xmt.formatoDMA.format(this.JDCFechaFin.getDate()) + "'";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                while (rs.next()) {
                    String sql2 = "SELECT Id_ordenes from baseserver.f_itemripsconsulta where Id_ordenes='" + rs.getLong(1) + "'";
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    ResultSet rs1 = xct1.traerRs(sql2);
                    if (!rs1.next()) {
                        String sql3 = "insert into baseserver.f_itemripsconsulta(Id_Ordenes, Id_Procedimiento, Id_TipoDx, Id_DxPrincipal, DxRelacional1, DxRelacional2, DxRelacional3, UsuarioS) values ('" + rs.getLong(1) + "','" + rs.getLong(2) + "','" + rs.getInt(3) + "','" + rs.getString(4) + "','" + rs.getString(5) + "','" + rs.getString(6) + "','" + rs.getString(7) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        xct1.ejecutarSQL(sql3);
                    }
                    rs1.close();
                    xct1.cerrarConexionBd();
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFPItemRipsConsultas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
