package Utilidades;

import Acceso.Principal;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.CheckboxTree;
import it.cnr.imaa.essi.lablib.gui.checkboxtree.TreeCheckingModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/BuildChecBoxTree.class */
public class BuildChecBoxTree {
    public DefaultMutableTreeNode root;
    public CheckboxTree tree;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xTablaMenu;
    private String xTablaMenuUsuario;

    public BuildChecBoxTree(String xTablaMenu, String xTablaMenuUsuario) {
        this.xTablaMenu = xTablaMenu;
        this.xTablaMenuUsuario = xTablaMenuUsuario;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/BuildChecBoxTree$Skill.class */
    static class Skill {
        private final int id;
        private final int parentId;
        private final String title;

        public Skill(int id, String title, int parentId) {
            this.id = id;
            this.title = title;
            this.parentId = parentId;
        }

        public int getId() {
            return this.id;
        }

        public int getParentId() {
            return this.parentId;
        }

        public String getTitle() {
            return this.title;
        }

        public String toString() {
            return this.title;
        }
    }

    public CheckboxTree mCheckboxTree() {
        List<Skill> skills = new ArrayList<>();
        String sql = "SELECT Id, menuName, parentId FROM " + this.xTablaMenu + " WHERE Estado=1;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    skills.add(new Skill(xrs.getInt(1), xrs.getString(2), xrs.getInt(3)));
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuildChecBoxTree.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.root = new DefaultMutableTreeNode(new Skill(0, "Permisos Menú x Usuario", -1));
        buildTree(skills, this.root);
        this.tree = new CheckboxTree(this.root);
        this.tree.expandRow(1);
        this.tree.getCheckingModel().setCheckingMode(TreeCheckingModel.CheckingMode.PROPAGATE_PRESERVING_UNCHECK);
        return this.tree;
    }

    public void mSeleccionar(String xIdUsuario) {
        String sql = "SELECT IdMenu FROM " + this.xTablaMenuUsuario + " WHERE (IdUsuario='" + xIdUsuario + "' AND Estado=1);";
        System.out.println("menu usuarios-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        Integer[] arr = null;
        try {
            if (xrs.next()) {
                xrs.last();
                arr = new Integer[xrs.getRow()];
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    if (xrs.getInt(1) != 1 && !mEsPadre(xrs.getInt(1))) {
                        arr[n] = Integer.valueOf(xrs.getInt(1));
                        n++;
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuildChecBoxTree.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (arr != null) {
            List<Integer> ids = Arrays.asList(arr);
            List<TreePath> previousSelection = getPreviousSelection(this.tree, this.root, ids);
            this.tree.setCheckingPaths((TreePath[]) previousSelection.toArray(new TreePath[previousSelection.size()]));
        }
    }

    private boolean mEsPadre(int xIdMenu) {
        boolean x = false;
        String sql = "SELECT Id ,`parentId` FROM " + this.xTablaMenu + " WHERE (`parentId` ='" + xIdMenu + "')";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        ResultSet xrs2 = xct2.traerRs(sql);
        try {
            if (xrs2.next()) {
                xrs2.first();
                x = true;
            }
            xrs2.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuildChecBoxTree.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return x;
    }

    private static void buildTree(List<Skill> skills, DefaultMutableTreeNode root) {
        for (Skill power : skills) {
            if (power.getParentId() == ((Skill) root.getUserObject()).getId()) {
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(power);
                root.add(node);
                buildTree(skills, node);
            }
        }
    }

    public void printTree(CheckboxTree tree, DefaultMutableTreeNode node, String xidUsuario) {
        if (node.getAllowsChildren()) {
            Skill power = (Skill) node.getUserObject();
            boolean selected = tree.isPathChecked(new TreePath(node.getPath()));
            int xEstado = 0;
            if (selected) {
                xEstado = 1;
            }
            if (power.getId() > 0) {
                mGuardaMenu(xidUsuario, power.getId(), xEstado);
            }
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            printTree(tree, (DefaultMutableTreeNode) node.getChildAt(i), xidUsuario);
        }
    }

    private static List<TreePath> getPreviousSelection(CheckboxTree tree, DefaultMutableTreeNode node, List<Integer> ids) {
        List<TreePath> list = new ArrayList<>();
        Skill power = (Skill) node.getUserObject();
        if (ids.contains(Integer.valueOf(power.getId()))) {
            list.add(new TreePath(node.getPath()));
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            list.addAll(getPreviousSelection(tree, node.getChildAt(i), ids));
        }
        return list;
    }

    public void mNuevo() {
        if (this.tree != null) {
            this.tree.setCheckingPaths(new TreePath[0]);
        }
    }

    private void mGuardaMenu(String xIdPersona, int xIdMenu, int xEstado) {
        ConsultasMySQL xct = new ConsultasMySQL();
        if (!mVerificaMenu(xIdPersona, xIdMenu) && xEstado == 1) {
            String sql = "INSERT INTO " + this.xTablaMenuUsuario + " (`IdUsuario`,`IdMenu`,`Estado`,`UsuarioS`) VALUES ('" + xIdPersona + "','" + xIdMenu + "','" + xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
            System.out.println("inserta menu-->" + sql);
            xct.ejecutarSQL(sql);
            xct.cerrarConexionBd();
            return;
        }
        if (xIdMenu != 1) {
            String sql2 = "UPDATE " + this.xTablaMenuUsuario + " SET Estado='" + xEstado + "' WHERE(IdMenu='" + xIdMenu + "' AND IdUsuario='" + xIdPersona + "')";
            System.out.println("actualiza menu-->" + sql2);
            xct.ejecutarSQL(sql2);
            xct.cerrarConexionBd();
        }
    }

    private boolean mVerificaMenu(String xIdPersona, int xIdMenu) {
        boolean xExiste = false;
        String sql = "SELECT IdMenu,IdUsuario FROM " + this.xTablaMenuUsuario + " WHERE (IdMenu='" + xIdMenu + "'AND IdUsuario='" + xIdPersona + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xExiste = true;
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(BuildChecBoxTree.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }
}
