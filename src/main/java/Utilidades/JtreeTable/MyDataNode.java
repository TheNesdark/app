package Utilidades.JtreeTable;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyDataNode.class */
public class MyDataNode {
    private String name;
    private String xCodAlterno;
    private String xTipoRubro;
    private String xUNivel;
    private String xATercero;
    private String parentId;
    private String IdRubro;
    private List<MyDataNode> children;

    public MyDataNode(String name, String xCodAlterno, String xTipoRubro, String xUNivel, List<MyDataNode> children, String parentId, String IdRubro, String xATercero) {
        this.name = name;
        this.xCodAlterno = xCodAlterno;
        this.xTipoRubro = xTipoRubro;
        this.xUNivel = xUNivel;
        this.children = children;
        this.IdRubro = IdRubro;
        this.xATercero = xATercero;
        this.parentId = parentId;
        if (this.children == null) {
            this.children = Collections.emptyList();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getxCodAlterno() {
        return this.xCodAlterno;
    }

    public String getxTipoRubro() {
        return this.xTipoRubro;
    }

    public String getxUNivel() {
        return this.xUNivel;
    }

    public List<MyDataNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<MyDataNode> children) {
        this.children = children;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getIdRubro() {
        return this.IdRubro;
    }

    public String getxATercero() {
        return this.xATercero;
    }

    public String toString() {
        return this.name;
    }
}
