package Utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.ListCellRenderer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/CheckComboBox.class */
public class CheckComboBox extends JComboBox {
    private List<ObjCheckBox> cbs;
    private Map<Object, Boolean> mapObjSelected;
    private List<CheckComboBoxSelectionChangedListener> changedListeners;
    private Object nullObject;

    public CheckComboBox(Set objs) {
        this(objs, false);
    }

    public CheckComboBox(Set objs, boolean selected) {
        this.changedListeners = new Vector();
        this.nullObject = new Object();
        resetObjs(objs, selected);
    }

    public CheckComboBox(Set objs, Set selected) {
        this.changedListeners = new Vector();
        this.nullObject = new Object();
        this.mapObjSelected = new LinkedHashMap();
        for (Object obj : objs) {
            if (obj == null) {
                obj = this.nullObject;
            }
            this.mapObjSelected.put(obj, Boolean.valueOf(selected.contains(obj)));
        }
        reset();
    }

    public CheckComboBox(Map<Object, Boolean> mapObjSelected) {
        this.changedListeners = new Vector();
        this.nullObject = new Object();
        this.mapObjSelected = mapObjSelected;
        reset();
    }

    public void addSelectionChangedListener(CheckComboBoxSelectionChangedListener l) {
        if (l == null) {
            return;
        }
        this.changedListeners.add(l);
    }

    public void removeSelectionChangedListener(CheckComboBoxSelectionChangedListener l) {
        this.changedListeners.remove(l);
    }

    public void resetObjs(Set objs, boolean selected) {
        this.mapObjSelected = new LinkedHashMap();
        for (Object obj : objs) {
            this.mapObjSelected.put(obj, Boolean.valueOf(selected));
        }
        reset();
    }

    public Object[] getSelectedItems() {
        Set ret = new TreeSet();
        for (Map.Entry<Object, Boolean> entry : this.mapObjSelected.entrySet()) {
            Object obj = entry.getKey();
            Boolean selected = entry.getValue();
            if (selected.booleanValue()) {
                ret.add(obj);
            }
        }
        if (ret.isEmpty()) {
            return null;
        }
        return ret.toArray(new Object[ret.size()]);
    }

    public void addSelectedItems(Collection c) {
        if (c == null) {
            return;
        }
        for (Object obj : c) {
            if (this.mapObjSelected.containsKey(obj)) {
                this.mapObjSelected.put(obj, true);
            }
        }
        reset();
        repaint();
    }

    public void addSelectedItems(Object[] objs) {
        if (objs == null) {
            return;
        }
        for (Object obj : objs) {
            if (this.mapObjSelected.containsKey(obj)) {
                this.mapObjSelected.put(obj, true);
            }
        }
        reset();
        repaint();
    }

    private void reset() {
        removeAllItems();
        initCBs();
        addItem(new String());
        for (JCheckBox cb : this.cbs) {
            addItem(cb);
        }
        setRenderer(new CheckBoxRenderer(this.cbs));
        addActionListener(this);
    }

    private void initCBs() {
        this.cbs = new Vector();
        boolean selectedAll = true;
        boolean selectedNone = true;
        for (Map.Entry<Object, Boolean> entry : this.mapObjSelected.entrySet()) {
            Object obj = entry.getKey();
            Boolean selected = entry.getValue();
            if (selected.booleanValue()) {
                selectedNone = false;
            } else {
                selectedAll = false;
            }
            ObjCheckBox cb = new ObjCheckBox(obj);
            cb.setSelected(selected.booleanValue());
            this.cbs.add(cb);
        }
        ObjCheckBox cb2 = new ObjCheckBox("Seleccionar todo");
        cb2.setSelected(selectedAll);
        this.cbs.add(cb2);
        ObjCheckBox cb3 = new ObjCheckBox("Quitar Selección");
        cb3.setSelected(selectedNone);
        this.cbs.add(cb3);
    }

    private void checkBoxSelectionChanged(int index) {
        int n = this.cbs.size();
        if (index < 0 || index >= n) {
            return;
        }
        if (index < n - 2) {
            ObjCheckBox cb = this.cbs.get(index);
            if (cb.getObj() == this.nullObject) {
                return;
            }
            if (cb.isSelected()) {
                cb.setSelected(false);
                this.mapObjSelected.put(cb.getObj(), false);
                this.cbs.get(n - 2).setSelected(false);
                this.cbs.get(n - 1).setSelected(getSelectedItems() == null);
                return;
            }
            cb.setSelected(true);
            this.mapObjSelected.put(cb.getObj(), true);
            Object[] sobjs = getSelectedItems();
            this.cbs.get(n - 2).setSelected(sobjs != null && sobjs.length == n - 2);
            this.cbs.get(n - 1).setSelected(false);
            return;
        }
        if (index == n - 2) {
            for (Object obj : this.mapObjSelected.keySet()) {
                if (obj != this.nullObject) {
                    this.mapObjSelected.put(obj, true);
                }
                System.out.println("Entra" + obj);
            }
            for (int i = 0; i < n - 1; i++) {
                if (this.cbs.get(i) != this.nullObject) {
                    this.cbs.get(i).setSelected(true);
                }
            }
            this.cbs.get(n - 1).setSelected(false);
            return;
        }
        Iterator<Object> it = this.mapObjSelected.keySet().iterator();
        while (it.hasNext()) {
            this.mapObjSelected.put(it.next(), false);
        }
        for (int i2 = 0; i2 < n - 1; i2++) {
            this.cbs.get(i2).setSelected(false);
        }
        this.cbs.get(n - 1).setSelected(true);
    }

    public void actionPerformed(ActionEvent e) {
        int sel = getSelectedIndex();
        if (sel == 0) {
            getUI().setPopupVisible(this, false);
        } else if (sel > 0) {
            checkBoxSelectionChanged(sel - 1);
            for (CheckComboBoxSelectionChangedListener l : this.changedListeners) {
                l.selectionChanged(sel - 1);
            }
            System.out.println("seleccione uno " + sel);
        }
        setSelectedIndex(-1);
    }

    public void setPopupVisible(boolean flag) {
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/CheckComboBox$CheckBoxRenderer.class */
    class CheckBoxRenderer implements ListCellRenderer {
        private final DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
        private JSeparator separator = new JSeparator(0);
        private final List<ObjCheckBox> cbs;

        public CheckBoxRenderer(List<ObjCheckBox> cbs) {
            this.cbs = cbs;
        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            String str;
            if (index > 0 && index <= this.cbs.size()) {
                ObjCheckBox cb = this.cbs.get(index - 1);
                if (cb.getObj() == CheckComboBox.this.nullObject) {
                    return this.separator;
                }
                cb.setBackground(isSelected ? Color.blue : Color.white);
                cb.setForeground(isSelected ? Color.white : Color.black);
                return cb;
            }
            Object[] objs = CheckComboBox.this.getSelectedItems();
            Vector<String> strs = new Vector<>();
            if (objs == null) {
                str = "Seleccione una o mas opciones";
            } else {
                for (Object obj : objs) {
                    strs.add(obj.toString());
                }
                str = strs.toString();
            }
            return this.defaultRenderer.getListCellRendererComponent(list, str, index, isSelected, cellHasFocus);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/CheckComboBox$ObjCheckBox.class */
    class ObjCheckBox extends JCheckBox {
        private final Object obj;

        public ObjCheckBox(Object obj) {
            super(obj.toString());
            this.obj = obj;
        }

        public Object getObj() {
            return this.obj;
        }
    }
}
