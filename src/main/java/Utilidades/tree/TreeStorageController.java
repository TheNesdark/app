package Utilidades.tree;

import java.util.Vector;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeNode;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/TreeStorageController.class */
public class TreeStorageController implements TreeModelListener {
    private HierarchicalDataStore store;

    public TreeStorageController(HierarchicalDataStore store) {
        this.store = store;
    }

    public TreeNode getRoot() {
        DynamicTreeNode root = null;
        try {
            Vector<HierarchicalItem> v = this.store.getRootItems();
            if (v != null && v.size() > 0) {
                root = new DynamicTreeNode(this.store, v.firstElement());
            }
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return root;
    }

    public HierarchicalDataStore getStore() {
        return this.store;
    }

    public Object createItem(HierarchicalItem item) {
        Object newId = null;
        try {
            newId = (Integer) this.store.createItem(item);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return newId;
    }

    public Object deleteItem(Object id) {
        Object deletedId = null;
        try {
            deletedId = this.store.deleteItem(id);
        } catch (StorageException e) {
            e.printStackTrace();
        }
        return deletedId;
    }

    private void updateChangedItems(DynamicTreeNode parent, Object[] children) {
        for (Object obj : children) {
            DynamicTreeNode child = (DynamicTreeNode) obj;
            try {
                HierarchicalItem item = child.m61getUserObject();
                if (parent != null) {
                    item.setParentId(parent.m61getUserObject().getId());
                }
                if (this.store.putItem(item) == null) {
                }
            } catch (StorageException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void treeNodesChanged(TreeModelEvent e) {
        updateChangedItems(null, e.getChildren());
    }

    public void treeNodesInserted(TreeModelEvent e) {
        updateChangedItems((DynamicTreeNode) e.getTreePath().getLastPathComponent(), e.getChildren());
    }

    public void treeNodesRemoved(TreeModelEvent e) {
        System.out.println("");
    }

    public void treeStructureChanged(TreeModelEvent e) {
    }
}
