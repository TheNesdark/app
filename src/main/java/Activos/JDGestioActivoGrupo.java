package Activos;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcUnidadFuncional;
import com.genoma.plus.jpa.entities.RhActivoContable;
import com.genoma.plus.jpa.entities.RhActivos;
import com.genoma.plus.jpa.entities.RhTipoCategoria;
import com.genoma.plus.jpa.entities.RhTipoPoliticas;
import com.genoma.plus.jpa.entities.RhTipoUbicacion;
import com.genoma.plus.jpa.service.ICcUnidadFuncionalService;
import com.genoma.plus.jpa.service.IRhActivoContableService;
import com.genoma.plus.jpa.service.IRhTipoCategoriaService;
import com.genoma.plus.jpa.service.IRhTipoPoliticasService;
import com.genoma.plus.jpa.service.IRhTipoUbicacionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* JADX INFO: loaded from: GenomaP.jar:Activos/JDGestioActivoGrupo.class */
public class JDGestioActivoGrupo extends JDialog {
    private int xforma;
    private Metodos xmt;
    private final RhActivos rhActivos;
    private RhActivoContable rhActivoContable;
    private final IRhTipoCategoriaService iRhTipoCategoriaService;
    private final ICcUnidadFuncionalService iCcUnidadFuncionalService;
    private final IRhTipoUbicacionService iRhTipoUbicacionService;
    private final IRhTipoPoliticasService iRhTipoPoliticasService;
    private final IRhActivoContableService iRhActivoContableService;
    private List<RhTipoUbicacion> listaTipoUbicaciones;
    private List<RhTipoCategoria> listaTipoCategorias;
    private List<RhTipoPoliticas> listaTipoPoliticas;
    private List<CcUnidadFuncional> listaUnidadFuncional;
    private ButtonGroup JBGForma;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    public JComboBox JCBCategoria;
    private JComboBox JCBPolitica;
    public JComboBox JCBUbicacion;
    public JComboBox JCBUnidadF;
    private JCheckBox JCHActivo;
    private JDateChooser JDFFechaC;
    private JLabel JLBId;
    private JPanel JPICuentasD;
    private JPanel JPICuentasDep;
    private JPanel JPICuentasMovi;
    private JPanel JPIDAdicionales;
    private JPanel JPIDatos;
    private JPanel JPIFDepreciacion;
    private JRadioButton JRBAno;
    private JRadioButton JRBDia;
    private JRadioButton JRBMes;
    private JSpinner JSPVUtil;
    private JTextField JTFD_Credito;
    private JTextField JTFD_Debito;
    private JFormattedTextField JTFFNRadicacion;
    private JFormattedTextField JTFFSaldo;
    private JFormattedTextField JTFFVCompra;
    private JFormattedTextField JTFFVDepreciacion;
    private JFormattedTextField JTFFVInicial;
    private JTextField JTFM_Credito;
    private JTextField JTFM_Debito;
    private JTextField JTFNombre;
    private JTabbedPane JTPDatos;

    public JDGestioActivoGrupo(Frame parent, boolean modal, RhActivos rhActivos) {
        super(parent, modal);
        this.xforma = 1;
        this.xmt = new Metodos();
        this.iRhTipoCategoriaService = (IRhTipoCategoriaService) Principal.contexto.getBean(IRhTipoCategoriaService.class);
        this.iCcUnidadFuncionalService = (ICcUnidadFuncionalService) Principal.contexto.getBean(ICcUnidadFuncionalService.class);
        this.iRhTipoUbicacionService = (IRhTipoUbicacionService) Principal.contexto.getBean(IRhTipoUbicacionService.class);
        this.iRhTipoPoliticasService = (IRhTipoPoliticasService) Principal.contexto.getBean(IRhTipoPoliticasService.class);
        this.iRhActivoContableService = (IRhActivoContableService) Principal.contexto.getBean(IRhActivoContableService.class);
        initComponents();
        this.rhActivos = rhActivos;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mBuscarDatos();
    }

    private void initComponents() {
        this.JBGForma = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBPolitica = new JComboBox();
        this.JTFFNRadicacion = new JFormattedTextField();
        this.JDFFechaC = new JDateChooser();
        this.JTFFVCompra = new JFormattedTextField();
        this.JSPVUtil = new JSpinner();
        this.JTFFVDepreciacion = new JFormattedTextField();
        this.JPIFDepreciacion = new JPanel();
        this.JRBAno = new JRadioButton();
        this.JRBMes = new JRadioButton();
        this.JRBDia = new JRadioButton();
        this.JCHActivo = new JCheckBox();
        this.JTFFSaldo = new JFormattedTextField();
        this.JTFFVInicial = new JFormattedTextField();
        this.JTPDatos = new JTabbedPane();
        this.JPIDAdicionales = new JPanel();
        this.JCBCategoria = new JComboBox();
        this.JCBUbicacion = new JComboBox();
        this.JCBUnidadF = new JComboBox();
        this.JPICuentasD = new JPanel();
        this.JPICuentasMovi = new JPanel();
        this.JTFM_Debito = new JTextField();
        this.JTFM_Credito = new JTextField();
        this.JPICuentasDep = new JPanel();
        this.JTFD_Debito = new JTextField();
        this.JTFD_Credito = new JTextField();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        this.JLBId = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("AGRUPACION DEL ACTIVO");
        setName("xjfgestiongrupo");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL ACTIVO O GRUPO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPolitica.setFont(new Font("Arial", 1, 12));
        this.JCBPolitica.setBorder(BorderFactory.createTitledBorder((Border) null, "Politica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPolitica.addItemListener(new ItemListener() { // from class: Activos.JDGestioActivoGrupo.1
            public void itemStateChanged(ItemEvent evt) {
                JDGestioActivoGrupo.this.JCBPoliticaItemStateChanged(evt);
            }
        });
        this.JTFFNRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Radicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRadicacion.setHorizontalAlignment(4);
        this.JTFFNRadicacion.setFont(new Font("Arial", 1, 12));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Compra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTFFVCompra.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Compra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVCompra.setHorizontalAlignment(4);
        this.JTFFVCompra.setFont(new Font("Arial", 1, 12));
        this.JTFFVCompra.addFocusListener(new FocusAdapter() { // from class: Activos.JDGestioActivoGrupo.2
            public void focusLost(FocusEvent evt) {
                JDGestioActivoGrupo.this.JTFFVCompraFocusLost(evt);
            }
        });
        this.JSPVUtil.setFont(new Font("Arial", 1, 12));
        this.JSPVUtil.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPVUtil.setToolTipText("Vida Útil");
        this.JSPVUtil.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Útil", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPVUtil.addChangeListener(new ChangeListener() { // from class: Activos.JDGestioActivoGrupo.3
            public void stateChanged(ChangeEvent evt) {
                JDGestioActivoGrupo.this.JSPVUtilStateChanged(evt);
            }
        });
        this.JTFFVDepreciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Depreciación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVDepreciacion.setHorizontalAlignment(4);
        this.JTFFVDepreciacion.setFont(new Font("Arial", 1, 12));
        this.JPIFDepreciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Depreciación", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGForma.add(this.JRBAno);
        this.JRBAno.setFont(new Font("Arial", 1, 12));
        this.JRBAno.setSelected(true);
        this.JRBAno.setText("Año");
        this.JRBAno.addActionListener(new ActionListener() { // from class: Activos.JDGestioActivoGrupo.4
            public void actionPerformed(ActionEvent evt) {
                JDGestioActivoGrupo.this.JRBAnoActionPerformed(evt);
            }
        });
        this.JBGForma.add(this.JRBMes);
        this.JRBMes.setFont(new Font("Arial", 1, 12));
        this.JRBMes.setText("Mes");
        this.JRBMes.addActionListener(new ActionListener() { // from class: Activos.JDGestioActivoGrupo.5
            public void actionPerformed(ActionEvent evt) {
                JDGestioActivoGrupo.this.JRBMesActionPerformed(evt);
            }
        });
        this.JBGForma.add(this.JRBDia);
        this.JRBDia.setFont(new Font("Arial", 1, 12));
        this.JRBDia.setText("Día");
        this.JRBDia.addActionListener(new ActionListener() { // from class: Activos.JDGestioActivoGrupo.6
            public void actionPerformed(ActionEvent evt) {
                JDGestioActivoGrupo.this.JRBDiaActionPerformed(evt);
            }
        });
        GroupLayout JPIFDepreciacionLayout = new GroupLayout(this.JPIFDepreciacion);
        this.JPIFDepreciacion.setLayout(JPIFDepreciacionLayout);
        JPIFDepreciacionLayout.setHorizontalGroup(JPIFDepreciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDepreciacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBAno).addGap(18, 18, 18).addComponent(this.JRBMes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JRBDia).addContainerGap()));
        JPIFDepreciacionLayout.setVerticalGroup(JPIFDepreciacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFDepreciacionLayout.createSequentialGroup().addGroup(JPIFDepreciacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAno).addComponent(this.JRBMes).addComponent(this.JRBDia)).addContainerGap(-1, 32767)));
        this.JCHActivo.setFont(new Font("Arial", 1, 12));
        this.JCHActivo.setText("Activo?");
        this.JCHActivo.setToolTipText("Es activo contable");
        this.JTFFSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFSaldo.setHorizontalAlignment(4);
        this.JTFFSaldo.setFont(new Font("Arial", 1, 12));
        this.JTFFVInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVInicial.setHorizontalAlignment(4);
        this.JTFFVInicial.setToolTipText("Valor Inicial de Depreciación");
        this.JTFFVInicial.setFont(new Font("Arial", 1, 12));
        this.JTFFVInicial.addFocusListener(new FocusAdapter() { // from class: Activos.JDGestioActivoGrupo.7
            public void focusLost(FocusEvent evt) {
                JDGestioActivoGrupo.this.JTFFVInicialFocusLost(evt);
            }
        });
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCBCategoria.setFont(new Font("Arial", 1, 12));
        this.JCBCategoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Categoría", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUbicacion.setFont(new Font("Arial", 1, 12));
        this.JCBUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDAdicionalesLayout = new GroupLayout(this.JPIDAdicionales);
        this.JPIDAdicionales.setLayout(JPIDAdicionalesLayout);
        JPIDAdicionalesLayout.setHorizontalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 748, 32767).addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBUnidadF, 0, -1, 32767).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addComponent(this.JCBCategoria, -2, 337, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUbicacion, 0, -1, 32767))).addContainerGap())));
        JPIDAdicionalesLayout.setVerticalGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 133, 32767).addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDAdicionalesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCategoria).addComponent(this.JCBUbicacion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBUnidadF, -2, 50, -2).addContainerGap(-1, 32767))));
        this.JTPDatos.addTab("DATOS ADICIONALES", this.JPIDAdicionales);
        this.JPICuentasMovi.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Puc Depreciación", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFM_Debito.setFont(new Font("Arial", 1, 12));
        this.JTFM_Debito.setToolTipText("");
        this.JTFM_Debito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFM_Credito.setFont(new Font("Arial", 1, 12));
        this.JTFM_Credito.setToolTipText("");
        this.JTFM_Credito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasMoviLayout = new GroupLayout(this.JPICuentasMovi);
        this.JPICuentasMovi.setLayout(JPICuentasMoviLayout);
        JPICuentasMoviLayout.setHorizontalGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasMoviLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFM_Debito, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFM_Credito, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasMoviLayout.setVerticalGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasMoviLayout.createSequentialGroup().addGroup(JPICuentasMoviLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFM_Debito, -2, -1, -2).addComponent(this.JTFM_Credito, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JPICuentasDep.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuentas Puc para de Baja", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFD_Debito.setFont(new Font("Arial", 1, 12));
        this.JTFD_Debito.setToolTipText("");
        this.JTFD_Debito.setBorder(BorderFactory.createTitledBorder((Border) null, "Débito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFD_Credito.setFont(new Font("Arial", 1, 12));
        this.JTFD_Credito.setToolTipText("");
        this.JTFD_Credito.setBorder(BorderFactory.createTitledBorder((Border) null, "Crédito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPICuentasDepLayout = new GroupLayout(this.JPICuentasDep);
        this.JPICuentasDep.setLayout(JPICuentasDepLayout);
        JPICuentasDepLayout.setHorizontalGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDepLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFD_Debito, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFD_Credito, -2, 105, -2).addContainerGap(-1, 32767)));
        JPICuentasDepLayout.setVerticalGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDepLayout.createSequentialGroup().addGroup(JPICuentasDepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFD_Debito, -2, -1, -2).addComponent(this.JTFD_Credito, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPICuentasDLayout = new GroupLayout(this.JPICuentasD);
        this.JPICuentasD.setLayout(JPICuentasDLayout);
        JPICuentasDLayout.setHorizontalGroup(JPICuentasDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDLayout.createSequentialGroup().addContainerGap().addComponent(this.JPICuentasMovi, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPICuentasDep, -2, -1, -2).addContainerGap(224, 32767)));
        JPICuentasDLayout.setVerticalGroup(JPICuentasDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICuentasDLayout.createSequentialGroup().addContainerGap().addGroup(JPICuentasDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPICuentasDep, -2, -1, -2).addComponent(this.JPICuentasMovi, -2, -1, -2)).addContainerGap(46, 32767)));
        this.JTPDatos.addTab("CUENTAS PUC PARA DEPRECIACIÓN Y BAJA", this.JPICuentasD);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHActivo)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JCBPolitica, -2, 292, -2).addGap(15, 15, 15).addComponent(this.JTFFNRadicacion, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFVCompra, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPVUtil, -2, 61, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addComponent(this.JPIFDepreciacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVDepreciacion, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JTFFSaldo, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFVInicial, -2, 136, -2).addGap(110, 110, 110))).addGap(0, 0, 32767)).addComponent(this.JTPDatos)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCHActivo)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFVCompra, -2, 50, -2).addComponent(this.JSPVUtil, -2, 50, -2)).addComponent(this.JCBPolitica, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNRadicacion, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, 50, 32767))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFVDepreciacion, GroupLayout.Alignment.LEADING).addComponent(this.JTFFSaldo, GroupLayout.Alignment.LEADING).addComponent(this.JTFFVInicial, GroupLayout.Alignment.LEADING).addComponent(this.JPIFDepreciacion, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -2, -1, -2).addContainerGap(7, 32767)));
        this.JCBPolitica.getAccessibleContext().setAccessibleDescription("");
        this.JTFFNRadicacion.getAccessibleContext().setAccessibleDescription("");
        this.JDFFechaC.getAccessibleContext().setAccessibleDescription("");
        this.JTFFVCompra.getAccessibleContext().setAccessibleDescription("");
        this.JSPVUtil.getAccessibleContext().setAccessibleDescription("");
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.setToolTipText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Activos.JDGestioActivoGrupo.8
            public void actionPerformed(ActionEvent evt) {
                JDGestioActivoGrupo.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/salir16x16.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.setToolTipText("Editar");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Activos.JDGestioActivoGrupo.9
            public void actionPerformed(ActionEvent evt) {
                JDGestioActivoGrupo.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JLBId.setFont(new Font("Arial", 1, 18));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 225, -2).addGap(91, 91, 91).addComponent(this.JBTSalir, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBId, -2, 98, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBId, -1, 55, 32767).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSalir, -2, 50, -2).addComponent(this.JBTGrabar, -2, 50, -2)))).addGap(15, 15, 15)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnoActionPerformed(ActionEvent evt) {
        this.xforma = 1;
        mCarcularVDrepeciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMesActionPerformed(ActionEvent evt) {
        this.xforma = 2;
        mCarcularVDrepeciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDiaActionPerformed(ActionEvent evt) {
        this.xforma = 3;
        mCarcularVDrepeciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.rhActivoContable == null) {
                    this.rhActivoContable = new RhActivoContable();
                }
                this.rhActivoContable.setCBCredito(this.JTFD_Credito.getText());
                this.rhActivoContable.setCBDebito(this.JTFD_Debito.getText());
                this.rhActivoContable.setCDCredito(this.JTFM_Credito.getText());
                this.rhActivoContable.setCDDebito(this.JTFM_Debito.getText());
                this.rhActivoContable.setDAcomulada(Double.valueOf(0.0d));
                this.rhActivoContable.setEsContable(Boolean.valueOf(this.JCHActivo.isSelected()));
                this.rhActivoContable.setFDepreciacion(Integer.valueOf(this.xforma));
                this.rhActivoContable.setFecha(this.xmt.getFechaActual());
                this.rhActivoContable.setFechaC(this.JDFFechaC.getDate());
                this.rhActivoContable.setIdActivo(this.rhActivos);
                this.rhActivoContable.setIdCategoria(this.listaTipoCategorias.get(this.JCBCategoria.getSelectedIndex()));
                this.rhActivoContable.setIdRhPolitica(this.listaTipoPoliticas.get(this.JCBPolitica.getSelectedIndex()));
                this.rhActivoContable.setIdUbicacion(this.listaTipoUbicaciones.get(this.JCBUbicacion.getSelectedIndex()));
                this.rhActivoContable.setIdUfContable(this.listaUnidadFuncional.get(this.JCBUnidadF.getSelectedIndex()));
                this.rhActivoContable.setNRadicacion(Integer.valueOf(this.JTFFNRadicacion.getValue().toString()));
                this.rhActivoContable.setNbre(this.JTFNombre.getText());
                this.rhActivoContable.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.rhActivoContable.setVCompra(Double.valueOf(this.JTFFVCompra.getValue().toString()));
                this.rhActivoContable.setVDepreciacion(Double.valueOf(this.JTFFVDepreciacion.getValue().toString()));
                this.rhActivoContable.setVInicialD(Double.valueOf(this.JTFFVInicial.getValue().toString()));
                this.rhActivoContable.setVSaldo(Double.valueOf(this.JTFFSaldo.getValue().toString()));
                this.rhActivoContable.setVUtil(Integer.valueOf(this.JSPVUtil.getValue().toString()));
                this.rhActivoContable.setEstado(true);
                this.rhActivoContable.setIdDoc(BigInteger.ZERO);
                this.rhActivoContable = this.iRhActivoContableService.grabar(this.rhActivoContable);
                this.JLBId.setText("" + this.rhActivoContable.getId());
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPoliticaItemStateChanged(ItemEvent evt) {
        if (this.JCBPolitica.getSelectedIndex() != -1) {
            this.JSPVUtil.setValue(this.listaTipoPoliticas.get(this.JCBPolitica.getSelectedIndex()).getAno());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPVUtilStateChanged(ChangeEvent evt) {
        mCarcularVDrepeciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVCompraFocusLost(FocusEvent evt) {
        mCarcularVDrepeciacion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVInicialFocusLost(FocusEvent evt) {
    }

    private void mNuevo() {
        this.JTFNombre.setText(this.rhActivos.getDescripcion());
        this.JCHActivo.setSelected(false);
        this.JCBPolitica.removeAllItems();
        this.JCBCategoria.removeAllItems();
        this.JCBUbicacion.removeAllItems();
        this.JCBUnidadF.removeAllItems();
        this.listaTipoUbicaciones = new ArrayList();
        this.listaTipoCategorias = new ArrayList();
        this.listaTipoUbicaciones = this.iRhTipoUbicacionService.listaTipoUbicacionPorEstado(true);
        if (!this.listaTipoUbicaciones.isEmpty()) {
            this.listaTipoUbicaciones.forEach(items -> {
                this.JCBUbicacion.addItem(items.getNbre());
            });
            this.JCBUbicacion.setSelectedItem(this.rhActivos.getIdUbicacion().getNbre());
        }
        this.listaTipoCategorias = this.iRhTipoCategoriaService.listaTIpoCategoriaPorEstado(true);
        if (!this.listaTipoCategorias.isEmpty()) {
            this.listaTipoCategorias.forEach(items2 -> {
                this.JCBCategoria.addItem(items2.getNbre());
            });
            this.JCBCategoria.setSelectedItem(this.rhActivos.getIdCategoria().getNbre());
        }
        this.listaTipoPoliticas = this.iRhTipoPoliticasService.listaTipoPoliticasPorEstado(true);
        if (!this.listaTipoPoliticas.isEmpty()) {
            this.listaTipoPoliticas.forEach(items3 -> {
                this.JCBPolitica.addItem(items3.getNbre());
            });
            if (this.listaTipoPoliticas.size() > 1) {
                this.JCBPolitica.setSelectedIndex(-1);
            }
        }
        this.listaUnidadFuncional = this.iCcUnidadFuncionalService.listaUnidadFuncionalPorEstado(true);
        if (!this.listaUnidadFuncional.isEmpty()) {
            this.listaUnidadFuncional.forEach(items4 -> {
                this.JCBUnidadF.addItem(items4.getNbre());
            });
            if (this.listaUnidadFuncional.size() > 1) {
                this.JCBUnidadF.setSelectedIndex(-1);
            }
        }
        this.JTFFNRadicacion.setValue(0);
        this.JTFFVInicial.setValue(0);
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFFVCompra.setValue(0);
        this.JTFFVDepreciacion.setValue(0);
        this.JTFFSaldo.setValue(0);
        this.JRBAno.setSelected(true);
        this.xforma = 1;
        this.JTFNombre.requestFocus();
    }

    private void mBuscarDatos() {
        this.rhActivoContable = new RhActivoContable();
        this.rhActivoContable = this.iRhActivoContableService.buscarPorRhActivos(this.rhActivos);
        if (this.rhActivoContable != null) {
            this.JLBId.setText("" + this.rhActivoContable.getId());
            this.JTFNombre.setText(this.rhActivoContable.getNbre());
            this.JCBPolitica.setSelectedItem(this.rhActivoContable.getIdRhPolitica().getNbre());
            this.JTFFNRadicacion.setValue(this.rhActivoContable.getNRadicacion());
            this.JDFFechaC.setDate(this.rhActivoContable.getFechaC());
            this.JTFFVCompra.setValue(this.rhActivoContable.getVCompra());
            this.JTFFSaldo.setValue(this.rhActivoContable.getVSaldo());
            this.JCBCategoria.setSelectedItem(this.rhActivoContable.getIdCategoria().getNbre());
            this.JTFFVInicial.setValue(this.rhActivoContable.getVInicialD());
            this.JCBUbicacion.setSelectedItem(this.rhActivoContable.getIdUbicacion().getNbre());
            this.JCBUnidadF.setSelectedItem(this.rhActivoContable.getIdUfContable().getNbre());
            this.JSPVUtil.setValue(this.rhActivoContable.getVUtil());
            if (null != this.rhActivoContable.getFDepreciacion()) {
                switch (this.rhActivoContable.getFDepreciacion().intValue()) {
                    case 1:
                        this.JRBAno.setSelected(true);
                        break;
                    case 2:
                        this.JRBMes.setSelected(true);
                        break;
                    case 3:
                        this.JRBDia.setSelected(true);
                        break;
                }
            }
            this.JTFFVDepreciacion.setValue(this.rhActivoContable.getVDepreciacion());
            this.JCHActivo.setSelected(this.rhActivoContable.getEsContable().booleanValue());
            this.JTFM_Credito.setText(this.rhActivoContable.getCDCredito());
            this.JTFM_Debito.setText(this.rhActivoContable.getCDDebito());
            this.JTFD_Credito.setText(this.rhActivoContable.getCBCredito());
            this.JTFD_Debito.setText(this.rhActivoContable.getCBDebito());
        }
    }

    private void mCarcularVDrepeciacion() {
        double xvalor;
        if (this.JTFFVCompra.getValue() != null && Double.valueOf(this.JTFFVCompra.getValue().toString()).doubleValue() > 0.0d) {
            if (this.JRBAno.isSelected()) {
                xvalor = Double.valueOf(this.JTFFVCompra.getValue().toString()).doubleValue() / ((double) Integer.valueOf(this.JSPVUtil.getValue().toString()).intValue());
            } else if (this.JRBMes.isSelected()) {
                xvalor = Double.valueOf(this.JTFFVCompra.getValue().toString()).doubleValue() / ((double) (Integer.valueOf(this.JSPVUtil.getValue().toString()).intValue() * 12));
            } else {
                xvalor = Double.valueOf(this.JTFFVCompra.getValue().toString()).doubleValue() / ((double) (Integer.valueOf(this.JSPVUtil.getValue().toString()).intValue() * 360));
            }
            this.JTFFVDepreciacion.setValue(Double.valueOf(xvalor));
        }
    }
}
