package Utilidades.JtreeTable;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyDataModel.class */
public class MyDataModel extends MyAbstractTreeTableModel {
    protected static String[] columnNames = {"Nombre Rubro", "Codigo", "TipoRubro", "UltimoNivel?", "AplicaTercero?"};
    protected static Class<?>[] columnTypes = {MyTreeTableModel.class, String.class, String.class, String.class, String.class};

    public MyDataModel(MyDataNode rootNode) {
        super(rootNode);
        this.root = rootNode;
    }

    public Object getChild(Object parent, int index) {
        return ((MyDataNode) parent).getChildren().get(index);
    }

    public int getChildCount(Object parent) {
        return ((MyDataNode) parent).getChildren().size();
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public Class<?> getColumnClass(int column) {
        return columnTypes[column];
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public Object getValueAt(Object node, int column) {
        switch (column) {
            case 0:
                return ((MyDataNode) node).getName();
            case 1:
                return ((MyDataNode) node).getIdRubro();
            case 2:
                return ((MyDataNode) node).getxTipoRubro();
            case 3:
                return ((MyDataNode) node).getxUNivel();
            case 4:
                return ((MyDataNode) node).getxATercero();
            default:
                return null;
        }
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public boolean isCellEditable(Object node, int column) {
        return true;
    }

    @Override // Utilidades.JtreeTable.MyTreeTableModel
    public void setValueAt(Object aValue, Object node, int column) {
    }
}
