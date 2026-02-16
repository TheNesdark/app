package Utilidades.corrector.jortho;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/corrector/jortho/LowMemoryArrayList.class */
class LowMemoryArrayList<E> {
    private transient E[] elementData;

    LowMemoryArrayList() {
    }

    public int size() {
        if (this.elementData == null) {
            return 0;
        }
        return this.elementData.length;
    }

    public E get(int index) {
        return this.elementData[index];
    }

    public void add(E e) {
        int size = size();
        Object[] objArr = new Object[size + 1];
        if (size > 0) {
            System.arraycopy(this.elementData, 0, objArr, 0, size);
        }
        this.elementData = (E[]) objArr;
        this.elementData[size] = e;
    }

    public void add(int i, E e) {
        int size = size();
        Object[] objArr = new Object[size + 1];
        if (size > 0) {
            System.arraycopy(this.elementData, 0, objArr, 0, i);
            System.arraycopy(this.elementData, i, objArr, i + 1, size - i);
        }
        this.elementData = (E[]) objArr;
        this.elementData[i] = e;
    }
}
