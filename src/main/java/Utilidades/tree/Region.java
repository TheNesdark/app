package Utilidades.tree;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/tree/Region.class */
public class Region implements HierarchicalItem {
    private Integer regionId;
    private String regionName;
    private Integer superId;

    public Region() {
        this.superId = null;
    }

    public Region(Integer id, String rName) {
        this();
        setId(id);
        setName(rName);
    }

    public String toString() {
        return getName();
    }

    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Region) {
            Region compareTo = (Region) obj;
            Object thisId = getId();
            Object otherId = compareTo.getId();
            if (thisId != null && otherId != null && thisId.equals(otherId)) {
                isEqual = true;
            } else {
                String thisName = getName();
                String otherName = compareTo.getName();
                if (thisName != null && otherName != null && thisName.equalsIgnoreCase(otherName)) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    }

    public void setId(Integer itemId) {
        this.regionId = itemId;
    }

    @Override // Utilidades.tree.HierarchicalItem
    public Object getId() {
        return this.regionId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superId = superiorId;
    }

    public Integer getSuperiorId() {
        return this.superId;
    }

    public void setName(String name) {
        this.regionName = name;
    }

    public String getName() {
        return this.regionName;
    }

    @Override // Utilidades.tree.HierarchicalItem
    public void setData(Object data) {
        setName(data.toString());
    }

    @Override // Utilidades.tree.HierarchicalItem
    public Object getData() {
        return getName();
    }

    @Override // Utilidades.tree.HierarchicalItem
    public void setId(Object itemId) {
        if (itemId instanceof Integer) {
            setId((Integer) itemId);
        }
    }

    @Override // Utilidades.tree.HierarchicalItem
    public Object getParentId() {
        return this.superId;
    }

    @Override // Utilidades.tree.HierarchicalItem
    public void setParentId(Object parentId) {
        if (parentId instanceof Integer) {
            setSuperiorId((Integer) parentId);
        }
    }

    @Override // Utilidades.tree.HierarchicalItem
    public boolean isRoot() {
        return this.superId == null;
    }
}
