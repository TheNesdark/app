package Utilidades.tree;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/HierarchicalItem.class */
public interface HierarchicalItem {
    void setData(Object obj);

    Object getData();

    void setId(Object obj);

    Object getId();

    Object getParentId();

    void setParentId(Object obj);

    boolean isRoot();
}
