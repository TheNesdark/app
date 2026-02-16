package Utilidades.JtreeTable;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultTreeSelectionModel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/JtreeTable/MyTreeTableSelectionModel.class */
public class MyTreeTableSelectionModel extends DefaultTreeSelectionModel {
    public MyTreeTableSelectionModel() {
        getListSelectionModel().addListSelectionListener(new ListSelectionListener() { // from class: Utilidades.JtreeTable.MyTreeTableSelectionModel.1
            public void valueChanged(ListSelectionEvent e) {
            }
        });
    }

    ListSelectionModel getListSelectionModel() {
        return this.listSelectionModel;
    }
}
