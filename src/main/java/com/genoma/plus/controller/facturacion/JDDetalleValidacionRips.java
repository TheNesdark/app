package com.genoma.plus.controller.facturacion;

import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.genoma.plus.controller.facturacion.dto.validacionrips.ValidacionRipsRespuesta;
import com.genoma.plus.controller.general.JIFRecursosMicroServicios;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.ws.rs.core.Response;
import org.jdesktop.swingx.JXTree;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDDetalleValidacionRips.class */
public class JDDetalleValidacionRips extends JDialog {
    private Metodos metodos;
    private Long idNumeroFactura;
    private List<ValidacionRipsRespuesta> ripsRespuesta;
    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode root;
    private JLabel JLB_CodigoValidacion;
    private JLabel JLB_FechaHoraValidacion;
    private JLabel JLB_NFactura;
    private JLabel JLB_NRegistros;
    private JLabel JLB_ObservacionGeneral;
    private JLabel JLB_Resultado;
    private JPanel JPI_InfoFactura;
    private JScrollPane JSP_Datos;
    private JScrollPane JSP_Detalle;
    private JTextPane JTP_Detalle;
    private JXTree JTX_Datos;

    public JDDetalleValidacionRips(Frame parent, boolean modal, Long idNumeroFactura) {
        super(parent, modal);
        initComponents();
        this.metodos = new Metodos();
        this.idNumeroFactura = idNumeroFactura;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.ripsRespuesta = new ArrayList();
        buscarInfoFactura();
        configJtree();
        mExpandAll(this.JTX_Datos, true);
    }

    private void initComponents() {
        this.JPI_InfoFactura = new JPanel();
        this.JLB_NFactura = new JLabel();
        this.JLB_Resultado = new JLabel();
        this.JLB_CodigoValidacion = new JLabel();
        this.JLB_FechaHoraValidacion = new JLabel();
        this.JLB_ObservacionGeneral = new JLabel();
        this.JSP_Datos = new JScrollPane();
        this.JTX_Datos = new JXTree();
        this.JSP_Detalle = new JScrollPane();
        this.JTP_Detalle = new JTextPane();
        this.JLB_NRegistros = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("DETALLE VALIDACIÓN RIPS");
        this.JPI_InfoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN FACTURA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLB_NFactura.setFont(new Font("Arial", 1, 12));
        this.JLB_NFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_Resultado.setFont(new Font("Arial", 1, 12));
        this.JLB_Resultado.setForeground(Color.red);
        this.JLB_Resultado.setHorizontalAlignment(0);
        this.JLB_Resultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_CodigoValidacion.setFont(new Font("Arial", 1, 12));
        this.JLB_CodigoValidacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Código único validación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_FechaHoraValidacion.setFont(new Font("Arial", 1, 12));
        this.JLB_FechaHoraValidacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha radicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLB_ObservacionGeneral.setFont(new Font("Arial", 1, 12));
        this.JLB_ObservacionGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle validación general", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_InfoFacturaLayout = new GroupLayout(this.JPI_InfoFactura);
        this.JPI_InfoFactura.setLayout(JPI_InfoFacturaLayout);
        JPI_InfoFacturaLayout.setHorizontalGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_ObservacionGeneral, -2, 680, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_FechaHoraValidacion, -2, 171, -2)).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addComponent(this.JLB_NFactura, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_Resultado, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_CodigoValidacion, -2, 600, -2))).addContainerGap(53, 32767)));
        JPI_InfoFacturaLayout.setVerticalGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InfoFacturaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_CodigoValidacion, -2, 50, -2).addComponent(this.JLB_Resultado, -2, 50, -2).addComponent(this.JLB_NFactura, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_InfoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_ObservacionGeneral, -2, 50, -2).addComponent(this.JLB_FechaHoraValidacion, -2, 50, -2)).addContainerGap()));
        this.JTX_Datos.setFont(new Font("Arial", 1, 12));
        this.JTX_Datos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JDDetalleValidacionRips.1
            public void mouseClicked(MouseEvent evt) {
                JDDetalleValidacionRips.this.JTX_DatosMouseClicked(evt);
            }
        });
        this.JSP_Datos.setViewportView(this.JTX_Datos);
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTP_Detalle.setFont(new Font("Arial", 1, 12));
        this.JSP_Detalle.setViewportView(this.JTP_Detalle);
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Validaciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSP_Datos, -1, 165, 32767).addComponent(this.JLB_NRegistros, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_InfoFactura, -1, -1, 32767).addComponent(this.JSP_Detalle, -2, 920, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JPI_InfoFactura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -2, 390, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JSP_Datos, -2, 461, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_NRegistros, -2, 50, -2))).addGap(0, 37, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTX_DatosMouseClicked(MouseEvent evt) {
        if (getNodoSeleccionado() > 0) {
            cargarDetalle();
        }
    }

    private void buscarInfoFactura() {
        RecursosMicroserviciosDomain microserviciosDomain = this.metodos.getParametrosEncriptados("26", "findByIdValidacionRips");
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + this.idNumeroFactura;
        System.err.println("fullUrl" + fullUrl);
        Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                this.ripsRespuesta = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<ValidacionRipsRespuesta>>() { // from class: com.genoma.plus.controller.facturacion.JDDetalleValidacionRips.2
                });
            } catch (JsonProcessingException e) {
                Logger.getLogger(JIFRecursosMicroServicios.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        response.close();
        this.metodos.getResteasyClient().close();
    }

    private void configJtree() {
        this.root = new DefaultMutableTreeNode("Info");
        this.treeModel = new DefaultTreeModel(this.root);
        this.JTX_Datos.setModel(this.treeModel);
        this.JLB_NRegistros.setText("");
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.ripsRespuesta.forEach(e -> {
            addNode("" + e.getId() + "_" + formateador.format(e.getFechaRegistro()) + "_    " + e.getUsuario());
        });
        this.JLB_NRegistros.setText("" + this.ripsRespuesta.size());
    }

    public static void mExpandAll(JTree tree, boolean expand) {
        TreeNode root = (TreeNode) tree.getModel().getRoot();
        mExpandAll(tree, new TreePath(root), expand);
    }

    private static void mExpandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode) parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            Enumeration e = node.children();
            while (e.hasMoreElements()) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                mExpandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }

    private void addNode(String nodeName) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
        this.treeModel.insertNodeInto(newNode, this.root, this.root.getChildCount());
    }

    private void cargarDetalle() {
        if (!this.ripsRespuesta.isEmpty()) {
            int x = getNodoSeleccionado() - 1;
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSXXX");
            System.out.println("");
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            this.JLB_NFactura.setText(this.ripsRespuesta.get(x).getResponse().getNumFactura());
            if (this.ripsRespuesta.get(x).getResponse().isResultState()) {
                this.JLB_Resultado.setForeground(new Color(0, 103, 0));
                this.JLB_Resultado.setText("VALIDADO");
            } else {
                this.JLB_Resultado.setForeground(Color.red);
                this.JLB_Resultado.setText("ERROR");
            }
            this.JLB_CodigoValidacion.setText(this.ripsRespuesta.get(x).getResponse().getCodigoUnicoValidacion());
            this.JLB_ObservacionGeneral.setText(this.ripsRespuesta.get(x).getResponse().getCodigoUnicoValidacionToShow());
            this.JTP_Detalle.setText("");
            if (!this.ripsRespuesta.get(x).getResponse().getResultadosValidacion().isEmpty()) {
                this.ripsRespuesta.get(x).getResponse().getResultadosValidacion().forEach(e -> {
                    this.JTP_Detalle.setText(this.JTP_Detalle.getText().concat("Clase: ").concat(e.getClase() + "\nCódigo: " + e.getCodigo() + "\nDescripcion : " + e.getDescripcion() + "\nObservaciones:  " + e.getObservaciones() + "\nPath Fuente: " + e.getPathFuente() + "\nFuente: " + e.getFuente() + "\n\n-------------------------------\n"));
                });
            }
        }
    }

    private int getNodoSeleccionado() {
        int position = 0;
        int[] selectedRows = this.JTX_Datos.getSelectionRows();
        if (selectedRows != null) {
            for (int i : selectedRows) {
                TreePath path = this.JTX_Datos.getPathForRow(i);
                position = this.JTX_Datos.getRowForPath(path);
            }
        }
        return position;
    }
}
