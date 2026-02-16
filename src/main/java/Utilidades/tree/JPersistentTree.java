package Utilidades.tree;

import java.util.Enumeration;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/JPersistentTree.class */
public class JPersistentTree extends JTree {
    private TreeStorageController storageController;

    public JPersistentTree(HierarchicalDataStore store) {
        this.storageController = new TreeStorageController(store);
        setModel(new DefaultTreeModel(this.storageController.getRoot()));
    }

    public void deleteSelectedNode() {
        Object o;
        TreePath selectedPath = getSelectionPath();
        if (selectedPath != null && (o = selectedPath.getLastPathComponent()) != null) {
            DynamicTreeNode selectedNode = (DynamicTreeNode) o;
            if (deleteItem(selectedNode)) {
                getModel().removeNodeFromParent(selectedNode);
            }
        }
    }

    private boolean deleteItem(DynamicTreeNode node) {
        boolean success = true;
        if (!node.isLeaf()) {
            Enumeration<TreeNode> en = node.children();
            while (en.hasMoreElements() && success) {
                success = deleteItem((DynamicTreeNode) en.nextElement());
            }
        }
        if (success) {
            HierarchicalItem item = node.m61getUserObject();
            try {
                Object deletedId = this.storageController.deleteItem(item.getId());
                if (deletedId == null) {
                    success = false;
                }
            } catch (Exception e) {
                success = false;
                e.printStackTrace();
            }
        }
        return success;
    }

    public void createInSelectedNode(HierarchicalItem item) {
        Object o;
        TreePath selectedPath = getSelectionPath();
        if (selectedPath != null && (o = selectedPath.getLastPathComponent()) != null) {
            DynamicTreeNode selectedNode = (DynamicTreeNode) o;
            item.setParentId(selectedNode.m61getUserObject().getId());
            Object newId = this.storageController.createItem(item);
            item.setId(newId);
            DynamicTreeNode newChild = new DynamicTreeNode(this.storageController.getStore(), item);
            getModel().insertNodeInto(newChild, selectedNode, selectedNode.getChildCount());
            TreePath newPath = selectedPath.pathByAddingChild(newChild);
            setSelectionPath(newPath);
            startEditingAtPath(newPath);
        }
    }

    public TreeStorageController getStorageController() {
        return this.storageController;
    }

    public void setModel(TreeModel newModel) {
        TreeModel model = getModel();
        if (model != null) {
            model.removeTreeModelListener(this.storageController);
        }
        newModel.addTreeModelListener(this.storageController);
        super.setModel(newModel);
    }
}
