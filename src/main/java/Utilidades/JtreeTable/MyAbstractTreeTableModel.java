package Utilidades.JtreeTable;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyAbstractTreeTableModel.class */
public abstract class MyAbstractTreeTableModel implements MyTreeTableModel {
    protected Object root;
    protected EventListenerList listenerList = new EventListenerList();
    private static final int CHANGED = 0;
    private static final int INSERTED = 1;
    private static final int REMOVED = 2;
    private static final int STRUCTURE_CHANGED = 3;

    public MyAbstractTreeTableModel(Object root) {
        this.root = root;
    }

    public Object getRoot() {
        return this.root;
    }

    public boolean isLeaf(Object node) {
        return getChildCount(node) == 0;
    }

    public void valueForPathChanged(TreePath path, Object newValue) {
    }

    public int getIndexOfChild(Object parent, Object child) {
        return CHANGED;
    }

    public void addTreeModelListener(TreeModelListener l) {
        this.listenerList.add(TreeModelListener.class, l);
    }

    public void removeTreeModelListener(TreeModelListener l) {
        this.listenerList.remove(TreeModelListener.class, l);
    }

    private void fireTreeNode(int changeType, Object source, Object[] path, int[] childIndices, Object[] children) {
        Object[] listeners = this.listenerList.getListenerList();
        TreeModelEvent e = new TreeModelEvent(source, path, childIndices, children);
        for (int i = listeners.length - REMOVED; i >= 0; i -= 2) {
            if (listeners[i] == TreeModelListener.class) {
                switch (changeType) {
                    case CHANGED /* 0 */:
                        ((TreeModelListener) listeners[i + INSERTED]).treeNodesChanged(e);
                        break;
                    case INSERTED /* 1 */:
                        ((TreeModelListener) listeners[i + INSERTED]).treeNodesInserted(e);
                        break;
                    case REMOVED /* 2 */:
                        ((TreeModelListener) listeners[i + INSERTED]).treeNodesRemoved(e);
                        break;
                    case STRUCTURE_CHANGED /* 3 */:
                        ((TreeModelListener) listeners[i + INSERTED]).treeStructureChanged(e);
                        break;
                }
            }
        }
    }

    protected void fireTreeNodesChanged(Object source, Object[] path, int[] childIndices, Object[] children) {
        fireTreeNode(CHANGED, source, path, childIndices, children);
    }

    protected void fireTreeNodesInserted(Object source, Object[] path, int[] childIndices, Object[] children) {
        fireTreeNode(INSERTED, source, path, childIndices, children);
    }

    protected void fireTreeNodesRemoved(Object source, Object[] path, int[] childIndices, Object[] children) {
        fireTreeNode(REMOVED, source, path, childIndices, children);
    }

    protected void fireTreeStructureChanged(Object source, Object[] path, int[] childIndices, Object[] children) {
        fireTreeNode(STRUCTURE_CHANGED, source, path, childIndices, children);
    }
}
