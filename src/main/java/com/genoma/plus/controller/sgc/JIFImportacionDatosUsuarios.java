package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import ParametrizacionN.AutoCompletarComboBox;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.jpa.entities.BarrioEntity;
import com.genoma.plus.jpa.entities.EstadoCivilEntity;
import com.genoma.plus.jpa.entities.GCargos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GEmpresacont;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GPoblacionEspecial;
import com.genoma.plus.jpa.entities.GSoJornada;
import com.genoma.plus.jpa.entities.GSoLateralidad;
import com.genoma.plus.jpa.entities.GTipoafiliado;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.MunicipioDTO;
import com.genoma.plus.jpa.entities.PersonaDTO;
import com.genoma.plus.jpa.entities.SexoEntity;
import com.genoma.plus.jpa.entities.SoTipoGrupo;
import com.genoma.plus.jpa.entities.SoTipoSegmento;
import com.genoma.plus.jpa.entities.TipoIdentificacionDTO;
import com.genoma.plus.jpa.service.GEmpresacontService;
import com.genoma.plus.jpa.service.GUsuarioService;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.PersonaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFImportacionDatosUsuarios.class */
public class JIFImportacionDatosUsuarios extends JInternalFrame {
    public static WorkerSQL xWorkerSQL;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloHt;
    private Object[] xdatos;
    private List<GEmpresa> listarEmpresa;
    private JButton JBImportar;
    public JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private JComboBox jcbEmpresa;
    private Vector columna = new Vector();
    private Vector filas = new Vector();
    private Metodos metodos = new Metodos();
    private JFileChooser FileChooser = new JFileChooser();
    private final PersonaService personaService = (PersonaService) Principal.contexto.getBean(PersonaService.class);
    private final GUsuarioService usuarioService = (GUsuarioService) Principal.contexto.getBean(GUsuarioService.class);
    File file = null;
    private final IGEmpresaService gEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
    private final GEmpresacontService gEmpresaContService = (GEmpresacontService) Principal.contexto.getBean(GEmpresacontService.class);
    private DefaultComboBoxModel combo = new DefaultComboBoxModel();
    private PersonaDTO personaDTO = null;

    public JIFImportacionDatosUsuarios() {
        initComponents();
        nuevo();
    }

    public void nuevo() {
        mCrearModeloDatos();
        llenarComboEmpresa();
        autocompletarComboEmpresa();
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JBImportar = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jcbEmpresa = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("IMPORTAR INFORMACIÓN DE USUARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifImporteDatosUsuarios");
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jTabbedPane1.setOpaque(true);
        this.JBImportar.setFont(new Font("Arial", 1, 12));
        this.JBImportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImportar.setText("Importar Archivo de Excel");
        this.JBImportar.setToolTipText("");
        this.JBImportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFImportacionDatosUsuarios.1
            public void actionPerformed(ActionEvent evt) {
                JIFImportacionDatosUsuarios.this.JBImportarActionPerformed(evt);
            }
        });
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 11));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFImportacionDatosUsuarios.2
            public void mouseClicked(MouseEvent evt) {
                JIFImportacionDatosUsuarios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 896, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JBImportar, -2, 268, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 361, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImportar, -2, 59, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("DATOS", this.jPanel1);
        this.jcbEmpresa.setFont(new Font("Arial", 1, 12));
        this.jcbEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jcbEmpresa, 0, -1, 32767).addComponent(this.jTabbedPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jcbEmpresa, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImportarActionPerformed(ActionEvent evt) {
        try {
            Importar();
        } catch (IOException ex) {
            Logger.getLogger(JIFImportacionDatosUsuarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void Importar() throws IOException {
        mCrearModeloDatos();
        this.FileChooser.showDialog((Component) null, "Importar Hoja ");
        this.file = this.FileChooser.getSelectedFile();
        if (!this.file.getName().endsWith("xls")) {
            JOptionPane.showMessageDialog((Component) null, "Seleccione un archivo excel...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        xWorkerSQL = null;
        xWorkerSQL = new WorkerSQL("Cargando la Informacion...", "jifImporteDatosUsuariosExcel");
        xWorkerSQL.execute();
    }

    public void CrearTabla_0() throws IOException {
        if (this.file != null) {
            try {
                WorkbookSettings workbookSettings = new WorkbookSettings();
                workbookSettings.setEncoding("Cp1252");
                Workbook workbook = Workbook.getWorkbook(this.file, workbookSettings);
                Sheet sheet = workbook.getSheet(0);
                this.columna.clear();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell1 = sheet.getCell(i, 0);
                    this.columna.add(cell1.getContents());
                }
                this.filas.clear();
                TipoIdentificacionDTO identificacionDTO = null;
                for (int j = 1; j < sheet.getRows(); j++) {
                    Vector d = new Vector();
                    for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                        Cell cell = sheet.getCell(i2, j);
                        if (i2 == 1) {
                            identificacionDTO = new TipoIdentificacionDTO();
                            identificacionDTO.setId(cell.getContents());
                        } else if (i2 == 2 && cell.getContents() != null && !identificacionDTO.getId().isEmpty() && !cell.getContents().isEmpty()) {
                            System.out.println("identificacionDTO -> " + identificacionDTO);
                            System.out.println("cell.getContents() -> " + cell.getContents());
                            this.personaDTO = this.personaService.consultarPersonaToDocumentoNoDocumento(identificacionDTO, cell.getContents());
                        }
                        if (i2 == 0) {
                            d.add("");
                        } else {
                            d.add(cell.getContents().toString().trim().toUpperCase());
                        }
                    }
                    d.add("\n");
                    this.xmodelo.addRow(d);
                    if (this.personaDTO != null) {
                        this.xmodelo.setValueAt(this.personaDTO.id, j - 1, 0);
                    } else {
                        this.xmodelo.setValueAt("", j - 1, 0);
                    }
                }
            } catch (BiffException e) {
                e.printStackTrace();
            }
        }
    }

    public void CrearTabla() throws IOException {
        boolean todosExisten = true;
        WorkbookSettings workbookSettings = new WorkbookSettings();
        if (this.file != null) {
            try {
                workbookSettings.setEncoding("Cp1252");
                Workbook workbook = Workbook.getWorkbook(this.file, workbookSettings);
                Sheet sheet = workbook.getSheet(0);
                this.columna.clear();
                for (int i = 0; i < sheet.getColumns(); i++) {
                    Cell cell1 = sheet.getCell(i, 0);
                    this.columna.add(cell1.getContents());
                }
                this.filas.clear();
                for (int j = 1; j < sheet.getRows(); j++) {
                    TipoIdentificacionDTO identificacionDTO = new TipoIdentificacionDTO();
                    String noDocumento = null;
                    for (int i2 = 0; i2 < sheet.getColumns(); i2++) {
                        Cell cell = sheet.getCell(i2, j);
                        if (i2 == 1) {
                            identificacionDTO.setId(cell.getContents());
                        } else if (i2 == 2) {
                            noDocumento = cell.getContents();
                        }
                    }
                    if (identificacionDTO != null && noDocumento != null && !identificacionDTO.getId().isEmpty() && !noDocumento.isEmpty()) {
                        this.personaDTO = this.personaService.consultarPersonaToDocumentoNoDocumento(identificacionDTO, noDocumento);
                        if (this.personaDTO == null) {
                            Vector d = new Vector();
                            for (int i3 = 0; i3 < sheet.getColumns(); i3++) {
                                Cell cell2 = sheet.getCell(i3, j);
                                if (i3 == 0) {
                                    d.add("");
                                } else {
                                    d.add(cell2.getContents().toString().trim().toUpperCase());
                                }
                            }
                            d.add("\n");
                            this.xmodelo.addRow(d);
                            todosExisten = false;
                        } else {
                            System.out.println("Persona existente: " + this.personaDTO.getId() + " - " + noDocumento);
                        }
                    }
                }
            } catch (BiffException e) {
                e.printStackTrace();
            }
            if (todosExisten) {
                JOptionPane.showMessageDialog((Component) null, "Todos las personas ya existen en la base de datos.", "Información", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public boolean isInteger(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isDouble(String cadena) {
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFImportacionDatosUsuarios$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Boolean.valueOf(table.getValueAt(row, 0).toString());
            if (!table.getValueAt(row, 0).toString().isEmpty()) {
                cell.setBackground(new Color(144, 229, 210));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(254, 90, 104));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void llenarComboEmpresa() {
        this.jcbEmpresa.setModel(this.combo);
        this.jcbEmpresa.removeAllItems();
        this.listarEmpresa = new ArrayList();
        this.listarEmpresa = this.gEmpresaService.listarEmpresa();
        this.listarEmpresa.forEach(e -> {
            if (!e.getNbre().isEmpty()) {
                this.combo.addElement(e.getNbre());
            } else {
                this.combo.addElement(e.getApellido1().concat(" ").concat(e.getApellido2()).concat(" ").concat(e.getNombre1()));
            }
        });
        this.jcbEmpresa.setSelectedIndex(-1);
    }

    private void autocompletarComboEmpresa() {
        new AutoCompletarComboBox(this.jcbEmpresa);
    }

    public void Cargar() {
        this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
        if (this.JTDetalle.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (this.xmodelo.getValueAt(i, 0).toString().isEmpty()) {
                    try {
                        if ((this.xmodelo.getValueAt(i, 7).toString().equals("F") || this.xmodelo.getValueAt(i, 7).toString().equals("M")) && isInteger(this.xmodelo.getValueAt(i, 9).toString()) && isInteger(this.xmodelo.getValueAt(i, 10).toString()) && isInteger(this.xmodelo.getValueAt(i, 12).toString()) && isInteger(this.xmodelo.getValueAt(i, 16).toString()) && isInteger(this.xmodelo.getValueAt(i, 19).toString()) && isDouble(this.xmodelo.getValueAt(i, 21).toString()) && isInteger(this.xmodelo.getValueAt(i, 24).toString()) && isInteger(this.xmodelo.getValueAt(i, 26).toString()) && isInteger(this.xmodelo.getValueAt(i, 29).toString()) && isInteger(this.xmodelo.getValueAt(i, 30).toString())) {
                            System.out.println("---------------->>>>>>>>");
                            PersonaDTO personaDTO = new PersonaDTO();
                            TipoIdentificacionDTO identificacionDTO = new TipoIdentificacionDTO();
                            SexoEntity sexoIdentity = new SexoEntity();
                            BarrioEntity barrioIdentity = new BarrioEntity();
                            new MunicipioDTO();
                            MunicipioDTO municipioNacDTO = new MunicipioDTO();
                            EstadoCivilEntity estadoCivilEntity = new EstadoCivilEntity();
                            sexoIdentity.setId(this.xmodelo.getValueAt(i, 7).toString());
                            barrioIdentity.setId(Integer.valueOf(this.xmodelo.getValueAt(i, 12).toString()));
                            estadoCivilEntity.setId(Integer.valueOf(this.xmodelo.getValueAt(i, 16).toString()));
                            municipioNacDTO.setId(this.xmodelo.getValueAt(i, 11).toString());
                            identificacionDTO.setId(this.xmodelo.getValueAt(i, 1).toString());
                            personaDTO.setIdTipoIdentificacion(identificacionDTO);
                            personaDTO.setNoDocumento(this.xmodelo.getValueAt(i, 2).toString());
                            personaDTO.setNombre1(this.xmodelo.getValueAt(i, 3).toString());
                            personaDTO.setNombre2(this.xmodelo.getValueAt(i, 4).toString());
                            personaDTO.setApellido1(this.xmodelo.getValueAt(i, 5).toString());
                            personaDTO.setApellido2(this.xmodelo.getValueAt(i, 6).toString());
                            personaDTO.setIdSexo(sexoIdentity);
                            personaDTO.setFechaNac(this.metodos.getPasarTextoAFecha(this.xmodelo.getValueAt(i, 8).toString()));
                            personaDTO.setEdad(Integer.valueOf(this.xmodelo.getValueAt(i, 9).toString()));
                            personaDTO.setId_TipoEdad(Integer.valueOf(this.xmodelo.getValueAt(i, 10).toString()));
                            personaDTO.setIdMunicipio(municipioNacDTO);
                            personaDTO.setIdBarrio(barrioIdentity);
                            personaDTO.setDireccion(this.xmodelo.getValueAt(i, 13).toString());
                            personaDTO.setTelefono(this.xmodelo.getValueAt(i, 14).toString());
                            personaDTO.setMovil(this.xmodelo.getValueAt(i, 15).toString());
                            personaDTO.setIdEstadoCivil(estadoCivilEntity);
                            personaDTO.setCorreo(this.xmodelo.getValueAt(i, 17).toString());
                            personaDTO.setGrupoSangre(this.xmodelo.getValueAt(i, 18).toString());
                            personaDTO.setRh(Integer.valueOf(this.xmodelo.getValueAt(i, 19).toString()));
                            personaDTO.setUrlF(this.xmodelo.getValueAt(i, 20).toString());
                            personaDTO.setCodigo1Sap(Double.valueOf(0.0d));
                            personaDTO.setId_MunicipioNac(this.xmodelo.getValueAt(i, 22).toString());
                            personaDTO.setUrlFoto(this.xmodelo.getValueAt(i, 23).toString());
                            personaDTO.setIdEtnia(Integer.valueOf(this.xmodelo.getValueAt(i, 24).toString()));
                            personaDTO.setNAfiliacion(this.xmodelo.getValueAt(i, 25).toString());
                            personaDTO.setActivoSo(Boolean.valueOf(this.xmodelo.getValueAt(i, 26).toString()));
                            personaDTO.setFEPeriodico((Date) null);
                            personaDTO.setHuella((byte[]) null);
                            personaDTO.setEstadoEps(true);
                            personaDTO.setTipoPersona(Boolean.valueOf(this.xmodelo.getValueAt(i, 29).toString()));
                            personaDTO.setIdPrincipal(Integer.valueOf(this.xmodelo.getValueAt(i, 30).toString()));
                            personaDTO.setFecha(this.metodos.getFechaActual());
                            personaDTO.setUsuarioS(this.xmodelo.getValueAt(i, 32).toString());
                            long idPersona = this.personaService.crearPersona(personaDTO).longValue();
                            this.xmodelo.setValueAt(Long.valueOf(idPersona), i, 0);
                            GTipoafiliado gTipoAfiliado = new GTipoafiliado();
                            gTipoAfiliado.setId(1);
                            GCargos gCargos = new GCargos();
                            SoTipoSegmento soTipoSegmento = new SoTipoSegmento();
                            SoTipoGrupo soTipoGrupo = new SoTipoGrupo();
                            new GEmpresa();
                            GSoLateralidad gSoLateralidad = new GSoLateralidad();
                            GSoJornada gSoJornada = new GSoJornada();
                            GPoblacionEspecial gPoblacionEspecial = new GPoblacionEspecial();
                            GEmpresa gEmpresa = this.listarEmpresa.get(this.jcbEmpresa.getSelectedIndex());
                            System.out.println("IdEmpresa Seleccionada --> " + gEmpresa.getId() + " Nombre empresa --> " + gEmpresa.getNbre() + " select item --> " + this.jcbEmpresa.getSelectedItem());
                            gCargos.setId(2);
                            soTipoSegmento.setId(1);
                            soTipoGrupo.setId(1);
                            gSoLateralidad.setId(1);
                            gSoJornada.setId(1);
                            gPoblacionEspecial.setId(99);
                            GEmpresacont gEmpresacont = (GEmpresacont) this.gEmpresaContService.findByIdempresa(gEmpresa).get();
                            personaDTO.setId(Long.valueOf(idPersona));
                            GUsuario gUsuario = new GUsuario();
                            GPersona persona = new GPersona();
                            persona.setId(personaDTO.getId());
                            gUsuario.setGPersona(persona);
                            gUsuario.setNoHistoria(personaDTO.noDocumento);
                            gUsuario.setIdOcupacion("6");
                            gUsuario.setIdTipoAfiliado(gTipoAfiliado);
                            gUsuario.setEstado(false);
                            gUsuario.setDetalleAnulacion((String) null);
                            gUsuario.setIdEmpresaCont(gEmpresacont);
                            gUsuario.setEsFpz(false);
                            gUsuario.setFechaDA((Date) null);
                            gUsuario.setNAfiliacion("");
                            gUsuario.setIdCargo(gCargos);
                            gUsuario.setIdSupervisor(1L);
                            gUsuario.setIdSegmento(soTipoSegmento);
                            gUsuario.setIdTipoGrupo(soTipoGrupo);
                            gUsuario.setIdArl(gEmpresa);
                            gUsuario.setIdLateralidad(gSoLateralidad);
                            gUsuario.setIdHorario(gSoJornada);
                            gUsuario.setHorasTrabajadas(0);
                            gUsuario.setNHijo(0);
                            gUsuario.setCSEconomica(0);
                            gUsuario.setFechaIngreso(this.metodos.getPasarTextoAFecha("01-02-1900"));
                            gUsuario.setEtnia("OTRAS ETNIAS ND NO DEFINIDO");
                            gUsuario.setIdPoblacionEspecial(gPoblacionEspecial);
                            gUsuario.setNEducativo("NINGUNO");
                            gUsuario.setOcupacion("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                            gUsuario.setEmail("");
                            gUsuario.setFecha(this.metodos.getFechaActual());
                            gUsuario.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            gUsuario.setEsta(false);
                            this.usuarioService.crearUsuario(gUsuario);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println(this.xmodelo.getValueAt(i, 1).toString());
                        System.out.println(this.xmodelo.getValueAt(i, 2).toString());
                    }
                }
                this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            }
        }
    }

    public void mGrabar() {
        if (this.jcbEmpresa.getSelectedIndex() != -1) {
            xWorkerSQL = null;
            xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
            xWorkerSQL.execute();
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Seleccione una empresa ...", "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdGenoma", "Id_TipoIdentificacion", "NoDocumento", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Id_Sexo", "FechaNac", "Edad", "Id_TipoEdad", "Id_Municipio", "Id_Barrio", "Direccion", "Telefono", "Movil", "Id_EstadoCivil", "Correo", "GrupoSangre", "Rh", "UrlF", "Codigo1Sap", "Id_MunicipioNac", "UrlFoto", "Id_Etnia", "NAfiliacion", "ActivoSo", "FEPeriodico", "Huella", "TipoPersona", "Id_Principal", "Fecha", "UsuarioS", "EPS"}) { // from class: com.genoma.plus.controller.sgc.JIFImportacionDatosUsuarios.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(32).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(33).setPreferredWidth(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }
}
