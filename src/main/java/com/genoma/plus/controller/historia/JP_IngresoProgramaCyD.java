package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GAtendioparto;
import com.genoma.plus.jpa.entities.GDetalleIngresoCyd;
import com.genoma.plus.jpa.entities.GDiscapacidad;
import com.genoma.plus.jpa.entities.GMunicipio;
import com.genoma.plus.jpa.entities.GPatologiaPrograma;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GTipoprograma;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.GUsuarioxprograma;
import com.genoma.plus.jpa.entities.GdetallePatologiacyd;
import com.genoma.plus.jpa.projection.IGDetalleIngresoCyDProjection;
import com.genoma.plus.jpa.projection.IGDetallePatologiaCyDProjection;
import com.genoma.plus.jpa.service.IngresoCYDService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JP_IngresoProgramaCyD.class */
public class JP_IngresoProgramaCyD extends JPanel {
    private List<GDiscapacidad> discapacidad;
    private List<GAtendioparto> atendioParto;
    private GDetalleIngresoCyd detalleIngreso;
    private JMBuscarPatologiaPorPrograma buscarPatologia;
    private List<IGDetalleIngresoCyDProjection> iGDetalleIngresoCyDProjections;
    private List<IGDetallePatologiaCyDProjection> iGDetallePatologiaCyDProjection;
    public GUsuarioxprograma xGUsuarioxprograma;
    private List<GUsuarioxprograma> listaGUsuarioxprograma;
    private GUsuario xGUsuario;
    private GTipoprograma xGTipoprograma;
    private List<GMunicipio> listGMunicipio;
    private GdetallePatologiacyd detallepatologia;
    public List<GdetallePatologiacyd> listaDetallePatologias;
    private Object[] xdatos;
    private List<GDetalleIngresoCyd> listDetalleIngreso;
    private JButton JBAgregar;
    private JButton JBGuardar;
    private JComboBox<String> JCBDiscapacidad;
    private JComboBox<String> JCBMunicipio;
    private JComboBox<String> JCBQuienAtendioParto;
    private JCheckBox JCHBPartoEnCasa;
    private JDateChooser JDCFechaIngreso;
    private JLabel JLBNumeroRegistro;
    private JTable JTDetallePatologia;
    private JTextField JTFCie10;
    private JTextField JTFEdadGestacional;
    public JTextField JTFPeso;
    public JTextField JTFTalla;
    private JTextField TJFNombreCie10;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private final IngresoCYDService service = (IngresoCYDService) Principal.contexto.getBean(IngresoCYDService.class);
    private Metodos xmts = new Metodos();
    private DefaultTableModel xmodelo = new DefaultTableModel();
    private final Long idUsuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido();
    private final String usuarioSist = Principal.usuarioSistemaDTO.getLogin();
    private List<GPatologiaPrograma> listaGPatologiaPrograma = new ArrayList();

    public JP_IngresoProgramaCyD() {
        initComponents();
        mCargarCombo();
        mBuscarIngresoCYD();
        mCargarTabla();
    }

    private void mCargarCombo() {
        this.JCBDiscapacidad.removeAllItems();
        this.discapacidad = new ArrayList();
        this.discapacidad = this.service.buscarDisapacidad();
        this.discapacidad.forEach(e -> {
            this.JCBDiscapacidad.addItem(e.getNbr());
        });
        this.JCBDiscapacidad.setSelectedIndex(-1);
        this.JCBMunicipio.removeAllItems();
        this.listGMunicipio = new ArrayList();
        this.listGMunicipio = this.service.buscarMunicipioDep();
        this.listGMunicipio.forEach(e2 -> {
            this.JCBMunicipio.addItem(e2.getNbre());
        });
        this.JCBMunicipio.setSelectedIndex(-1);
        this.JCBQuienAtendioParto.removeAllItems();
        this.atendioParto = new ArrayList();
        this.atendioParto = this.service.buscarAtendioParto();
        this.atendioParto.forEach(e3 -> {
            this.JCBQuienAtendioParto.addItem(e3.getNbr());
        });
        this.JCBQuienAtendioParto.setSelectedIndex(-1);
        this.JDCFechaIngreso.setDate(this.xmts.getFechaActual());
    }

    private void mBuscarIngresoCYD() {
        this.listaGUsuarioxprograma = new ArrayList();
        this.listaDetallePatologias = new ArrayList();
        this.listDetalleIngreso = new ArrayList();
        this.detalleIngreso = new GDetalleIngresoCyd();
        this.listDetalleIngreso.add(this.detalleIngreso);
        this.xGUsuario = new GUsuario();
        this.xGTipoprograma = new GTipoprograma();
        this.xGTipoprograma.setIdTipoPrograma(4);
        this.xGUsuarioxprograma = new GUsuarioxprograma();
        this.xGUsuarioxprograma.setIdPrograma(this.xGTipoprograma);
        this.xGUsuarioxprograma.setIdUsuario(this.xGUsuario);
        this.xGUsuarioxprograma.setFechaIngreso(this.JDCFechaIngreso.getDate());
        this.xGUsuarioxprograma.setFecha(this.xmts.getFechaActual());
        this.xGUsuarioxprograma.setUsuarioS(this.usuarioSist);
        this.xGUsuarioxprograma.setCardinal(0);
        this.xGUsuarioxprograma.setGDetalleIngresoCydList(this.listDetalleIngreso);
        this.detalleIngreso.setIdusuarioxprograma(this.xGUsuarioxprograma);
        this.iGDetalleIngresoCyDProjections = this.service.buscarDetalleIngreso(this.idUsuario);
        if (!this.iGDetalleIngresoCyDProjections.isEmpty()) {
            this.JLBNumeroRegistro.setText(this.iGDetalleIngresoCyDProjections.get(0).getId());
            this.JDCFechaIngreso.setDate(this.iGDetalleIngresoCyDProjections.get(0).getFechaIngreso());
            if (!this.iGDetalleIngresoCyDProjections.isEmpty()) {
                this.JCBMunicipio.setSelectedItem(this.iGDetalleIngresoCyDProjections.get(0).getNombreMunicipio());
                this.JCHBPartoEnCasa.setSelected(this.iGDetalleIngresoCyDProjections.get(0).getPartoEnCasa().booleanValue());
                this.JCBQuienAtendioParto.setSelectedItem(this.iGDetalleIngresoCyDProjections.get(0).getNombreAtendioParto());
                this.JTFEdadGestacional.setText(this.iGDetalleIngresoCyDProjections.get(0).getEdadGestacional());
                this.JTFPeso.setText(this.iGDetalleIngresoCyDProjections.get(0).getPeso().toString());
                this.JTFTalla.setText(this.iGDetalleIngresoCyDProjections.get(0).getTalla().toString());
                this.JCBDiscapacidad.setSelectedItem(this.iGDetalleIngresoCyDProjections.get(0).getNombreDiscapacidad());
            } else {
                this.detalleIngreso.setIdusuarioxprograma(this.xGUsuarioxprograma);
                this.listDetalleIngreso.add(this.detalleIngreso);
            }
            this.xmts.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloPatologias() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "CIE10", "Nombre"}) { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.1
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetallePatologia.setModel(this.xmodelo);
        this.JTDetallePatologia.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetallePatologia.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetallePatologia.getColumnModel().getColumn(2).setPreferredWidth(500);
    }

    public void mCargarTabla() {
        mCrearModeloPatologias();
        if (!this.JLBNumeroRegistro.getText().isEmpty()) {
            this.iGDetallePatologiaCyDProjection = this.service.buscarPatologiaIngreso(Integer.valueOf(Integer.parseInt(this.JLBNumeroRegistro.getText())));
            this.iGDetallePatologiaCyDProjection.forEach(e -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(e.getIdDetallePatologia(), this.JTDetallePatologia.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(e.getCodigoPatologia(), this.JTDetallePatologia.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(e.getNombrePatologia(), this.JTDetallePatologia.getRowCount() - 1, 2);
            });
            return;
        }
        for (int i = 0; i < this.listaDetallePatologias.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            try {
                this.xmodelo.setValueAt(this.listaDetallePatologias.get(i).getId(), i, 0);
            } catch (Exception e2) {
                this.xmodelo.setValueAt("*", i, 0);
            }
            this.xmodelo.setValueAt(this.listaDetallePatologias.get(i).getIdPatologiaPrograma().getIdPatologia().getId(), i, 1);
            this.xmodelo.setValueAt(this.listaDetallePatologias.get(i).getIdPatologiaPrograma().getIdPatologia().getNbre(), i, 2);
        }
    }

    private Boolean mValidarCampos() {
        Boolean valido = true;
        if (this.JDCFechaIngreso.getDate() == null) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la fecha de ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JDCFechaIngreso.requestFocus();
            valido = false;
        } else if (this.JCBMunicipio.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el lugar de atencion del parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMunicipio.requestFocus();
            valido = false;
        } else if (this.JCBQuienAtendioParto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar quien atendio el parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBQuienAtendioParto.requestFocus();
            valido = false;
        } else if (this.JTFEdadGestacional.getText().isEmpty() || this.JTFEdadGestacional.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la edad gestacional al nacer", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFEdadGestacional.requestFocus();
            valido = false;
        } else if (this.JTFPeso.getText().isEmpty() || this.JTFPeso.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el peso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFPeso.requestFocus();
            valido = false;
        } else if (this.JTFTalla.getText().isEmpty() || this.JTFTalla.getText().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar la talla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFTalla.requestFocus();
            valido = false;
        } else if (this.JCBDiscapacidad.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar discapacidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBDiscapacidad.requestFocus();
            valido = false;
        }
        return valido;
    }

    public void mGuardar() {
        if (mValidarCampos().booleanValue()) {
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setIdMunicipio(this.listGMunicipio.get(this.JCBMunicipio.getSelectedIndex()));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setPartoEnCasa(Boolean.valueOf(this.JCHBPartoEnCasa.isSelected()));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setIdAtendioParto(this.atendioParto.get(this.JCBQuienAtendioParto.getSelectedIndex()));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setEdadGestacional(Double.valueOf(Double.parseDouble(this.JTFEdadGestacional.getText().replaceAll(",", "."))));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setPeso(Short.valueOf(Short.parseShort(this.JTFPeso.getText())));
            System.out.println("XGUsiario Validar campo ----------------------- : " + this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setTalla(Short.valueOf(Short.parseShort(this.JTFTalla.getText())));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setIdDiscapacidad(this.discapacidad.get(this.JCBDiscapacidad.getSelectedIndex()));
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setEstado(true);
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setFecha(this.xmts.getFechaActual());
            ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setUsuarioSistema(this.usuarioSist);
            if (this.listaDetallePatologias.size() > 0) {
                for (int i = 0; i < this.listaDetallePatologias.size(); i++) {
                    this.listaDetallePatologias.get(i).setIdDetalleIngreso((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0));
                }
                ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).setGdetallePatologiacydList(this.listaDetallePatologias);
            }
            GPersona persona = new GPersona();
            persona.setId(this.idUsuario);
            this.xGUsuario.setGPersona(persona);
            this.xGUsuarioxprograma.setGDetalleIngresoCydList(this.xGUsuarioxprograma.getGDetalleIngresoCydList());
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") || Principal.informacionIps.getIdentificacion().equals("900273372") || Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579")) {
                GUsuario usuario = new GUsuario();
                usuario.setId(this.idUsuario);
                usuario.setGPersona(this.xGUsuario.getGPersona());
                this.xGUsuarioxprograma.setIdUsuario(usuario);
            }
            this.xGUsuarioxprograma = this.service.grabarIngreso(this.xGUsuarioxprograma);
            this.JLBNumeroRegistro.setText(this.xGUsuarioxprograma.getId().toString());
            if (this.xGUsuarioxprograma.getGDetalleIngresoCydList().size() > 0) {
                if (((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList().size() > 0) {
                    this.listaDetallePatologias = ((GDetalleIngresoCyd) this.xGUsuarioxprograma.getGDetalleIngresoCydList().get(0)).getGdetallePatologiacydList();
                } else {
                    this.listaDetallePatologias = new ArrayList();
                }
            }
            this.xmts.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mCargarTabla();
        }
    }

    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JDCFechaIngreso = new JDateChooser();
        this.jPanel3 = new JPanel();
        this.JCBMunicipio = new JComboBox<>();
        this.JCHBPartoEnCasa = new JCheckBox();
        this.JCBQuienAtendioParto = new JComboBox<>();
        this.JTFEdadGestacional = new JTextField();
        this.JTFPeso = new JTextField();
        this.JTFTalla = new JTextField();
        this.JCBDiscapacidad = new JComboBox<>();
        this.jPanel4 = new JPanel();
        this.JTFCie10 = new JTextField();
        this.TJFNombreCie10 = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetallePatologia = new JTable();
        this.jButton1 = new JButton();
        this.JBAgregar = new JButton();
        this.JBGuardar = new JButton();
        this.JLBNumeroRegistro = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("ingresocyd");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setName("ingreso");
        this.JDCFechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Ingreso", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaIngreso.setFont(new Font("Arial", 1, 12));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "LUGAR DE ATENCIÓN DEL PARTO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHBPartoEnCasa.setText("Parto en casa");
        this.JCHBPartoEnCasa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.2
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.JCHBPartoEnCasaActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCBMunicipio, 0, 257, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBPartoEnCasa).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHBPartoEnCasa)).addComponent(this.JCBMunicipio, GroupLayout.Alignment.TRAILING, -1, 57, 32767));
        this.JCBQuienAtendioParto.setFont(new Font("Arial", 1, 12));
        this.JCBQuienAtendioParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Quien atendio el parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEdadGestacional.setFont(new Font("Arial", 1, 18));
        this.JTFEdadGestacional.setHorizontalAlignment(0);
        this.JTFEdadGestacional.setText("0");
        this.JTFEdadGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad gestacional al nacer", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEdadGestacional.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.3
            public void keyPressed(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFEdadGestacionalKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFEdadGestacionalKeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFEdadGestacionalKeyTyped(evt);
            }
        });
        this.JTFPeso.setFont(new Font("Arial", 1, 18));
        this.JTFPeso.setHorizontalAlignment(0);
        this.JTFPeso.setText("0");
        this.JTFPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso al nacer (gr)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPeso.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.4
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.JTFPesoActionPerformed(evt);
            }
        });
        this.JTFPeso.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.5
            public void keyPressed(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFPesoKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFPesoKeyTyped(evt);
            }
        });
        this.JTFTalla.setFont(new Font("Arial", 1, 18));
        this.JTFTalla.setHorizontalAlignment(0);
        this.JTFTalla.setText("0");
        this.JTFTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla al nacer (cm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTalla.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.6
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.JTFTallaActionPerformed(evt);
            }
        });
        this.JTFTalla.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.7
            public void keyPressed(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFTallaKeyPressed(evt);
            }

            public void keyTyped(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFTallaKeyTyped(evt);
            }
        });
        this.JCBDiscapacidad.setFont(new Font("Arial", 1, 12));
        this.JCBDiscapacidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Discapacidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "PATOLOGÍA DEL RECIEN NACIDO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFCie10.setFont(new Font("Arial", 1, 18));
        this.JTFCie10.setHorizontalAlignment(0);
        this.JTFCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCie10.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.8
            public void keyReleased(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTFCie10KeyReleased(evt);
            }
        });
        this.TJFNombreCie10.setEditable(false);
        this.TJFNombreCie10.setFont(new Font("Arial", 1, 18));
        this.TJFNombreCie10.setHorizontalAlignment(0);
        this.TJFNombreCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE PATOLOGIAS", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTDetallePatologia.setFont(new Font("Arial", 1, 12));
        this.JTDetallePatologia.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.9
            public void keyPressed(KeyEvent evt) {
                JP_IngresoProgramaCyD.this.JTDetallePatologiaKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetallePatologia);
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.10
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.jButton1ActionPerformed(evt);
            }
        });
        this.JBAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Aceptar30x30.png")));
        this.JBAgregar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.11
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.JBAgregarActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jScrollPane1)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JTFCie10, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.TJFNombreCie10, -2, 489, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregar, -1, -1, 32767))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCie10, -2, -1, -2).addComponent(this.TJFNombreCie10, -2, -1, -2)).addComponent(this.jButton1, -1, -1, 32767).addComponent(this.JBAgregar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 223, -2)));
        this.JBGuardar.setFont(new Font("Arial", 1, 14));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JP_IngresoProgramaCyD.12
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoProgramaCyD.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JLBNumeroRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNumeroRegistro.setHorizontalAlignment(0);
        this.JLBNumeroRegistro.setVerticalAlignment(3);
        this.JLBNumeroRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLBNumeroRegistro.setVerticalTextPosition(3);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 580, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNumeroRegistro, -2, 191, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JDCFechaIngreso, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBQuienAtendioParto, -2, 257, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.JTFEdadGestacional, -2, 166, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPeso, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTalla, -2, 125, -2).addGap(12, 12, 12).addComponent(this.JCBDiscapacidad, -2, 226, -2)).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JDCFechaIngreso, -2, 52, -2).addComponent(this.JCBQuienAtendioParto, -2, 57, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFEdadGestacional, -2, -1, -2).addComponent(this.JTFPeso, -2, -1, -2).addComponent(this.JTFTalla, -2, -1, -2))).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDiscapacidad, -2, 57, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGuardar, -2, 46, -2).addComponent(this.JLBNumeroRegistro, -2, 46, -2)).addGap(0, 0, 0)));
        this.jTabbedPane1.addTab("INGRESO", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.TRAILING, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1));
        this.jTabbedPane1.getAccessibleContext().setAccessibleName("Ingreso");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBPartoEnCasaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        this.buscarPatologia = new JMBuscarPatologiaPorPrograma(null, true, this);
        this.buscarPatologia.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10KeyReleased(KeyEvent evt) {
        this.listaGPatologiaPrograma = this.service.buscarPatologiaPorCie10(this.JTFCie10.getText(), 4);
        if (this.listaGPatologiaPrograma.size() == 1) {
            this.JTFCie10.setText(this.listaGPatologiaPrograma.get(0).getIdPatologia().getId());
            this.TJFNombreCie10.setText(this.listaGPatologiaPrograma.get(0).getIdPatologia().getNbre());
        } else {
            this.listaGPatologiaPrograma = new ArrayList();
            this.TJFNombreCie10.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarActionPerformed(ActionEvent evt) {
        if (this.listaGPatologiaPrograma.size() == 1) {
            Boolean validarCie10 = true;
            int i = 0;
            while (i < this.listaDetallePatologias.size()) {
                if (this.listaDetallePatologias.get(i).getIdPatologiaPrograma().getId().equals(this.listaGPatologiaPrograma.get(0).getId())) {
                    validarCie10 = false;
                    i = this.listaDetallePatologias.size();
                }
                i++;
            }
            if (validarCie10.booleanValue()) {
                this.detallepatologia = new GdetallePatologiacyd();
                this.detallepatologia.setIdDetalleIngreso(new GDetalleIngresoCyd());
                this.detallepatologia.setEstado(true);
                this.detallepatologia.setFecha(this.xmts.getFechaActual());
                this.detallepatologia.setIdPatologiaPrograma(this.listaGPatologiaPrograma.get(0));
                this.detallepatologia.setUsuarioSistema(this.usuarioSist);
                this.listaDetallePatologias.add(this.detallepatologia);
                this.JTFCie10.setText("");
                this.TJFNombreCie10.setText("");
                mCargarTabla();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEdadGestacionalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPesoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTallaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEdadGestacionalKeyTyped(KeyEvent evt) {
        this.xmts.mValidarSoloNumerosDouble(evt, this, this.JTFEdadGestacional.getText(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPesoKeyTyped(KeyEvent evt) {
        this.xmts.mValidarSoloNumeros(evt, this, this.JTFPeso.getText(), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTallaKeyTyped(KeyEvent evt) {
        this.xmts.mValidarSoloNumeros(evt, this, this.JTFTalla.getText(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEdadGestacionalKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePatologiaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.listaDetallePatologias.get(this.JTDetallePatologia.getSelectedRow()).getId() == null) {
            int v = JOptionPane.showConfirmDialog(this, "DESEA ELIMINAR PATOLOGIA", "ELIMINAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (v == 0) {
                this.listaDetallePatologias.remove(this.JTDetallePatologia.getSelectedRow());
                mCargarTabla();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPesoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTallaActionPerformed(ActionEvent evt) {
    }
}
