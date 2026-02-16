package Utilidades.tree;

import java.util.Vector;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/HierarchicalDataStore.class */
public interface HierarchicalDataStore {
    HierarchicalItem getItem(Object obj) throws StorageException;

    Vector<HierarchicalItem> getChildItems(Object obj) throws StorageException;

    Vector<HierarchicalItem> getRootItems() throws StorageException;

    HierarchicalItem putItem(HierarchicalItem hierarchicalItem) throws StorageException;

    Object createItem(HierarchicalItem hierarchicalItem) throws StorageException;

    Object deleteItem(Object obj) throws StorageException;
}
