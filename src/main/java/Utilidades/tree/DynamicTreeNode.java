package Utilidades.tree;

import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/DynamicTreeNode.class */
public class DynamicTreeNode extends DefaultMutableTreeNode {
    private boolean loaded;
    private boolean loadInProgress;
    private HierarchicalDataStore store;

    public DynamicTreeNode(HierarchicalDataStore store, HierarchicalItem item) {
        super(item);
        this.loaded = false;
        this.loadInProgress = false;
        this.store = store;
    }

    public void setUserObject(HierarchicalItem userObject) {
        super.setUserObject(userObject);
    }

    /* JADX INFO: renamed from: getUserObject, reason: merged with bridge method [inline-methods] */
    public HierarchicalItem m61getUserObject() {
        return (HierarchicalItem) super.getUserObject();
    }

    public int getChildCount() {
        if (!this.loaded && !this.loadInProgress) {
            loadChildren();
        }
        return super.getChildCount();
    }

    private void loadChildren() {
        try {
            if (!this.loaded && !this.loadInProgress) {
                this.loadInProgress = true;
                HierarchicalItem item = m61getUserObject();
                Vector<HierarchicalItem> childNodes = this.store.getChildItems(item.getId());
                if (childNodes != null) {
                    for (int i = 0; i < childNodes.size(); i++) {
                        HierarchicalItem childItem = childNodes.elementAt(i);
                        add(new DynamicTreeNode(this.store, childItem));
                    }
                }
                this.loaded = true;
                this.loadInProgress = false;
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public boolean isLoaded() {
        return this.loaded;
    }
}
