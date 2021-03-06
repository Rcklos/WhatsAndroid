package club.andnext.dataset;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseDataset<E extends BaseEntry> {

    @SerializedName("list")
    protected ArrayList<E> list;

    public BaseDataset() {
        this.list = new ArrayList<>();
    }

    public E get(String id) {
        if (id == null) {
            return null;
        }

        int index = this.indexOf(id);
        if (index >= 0) {
            return list.get(index);
        }

        return null;
    }

    public int size() {
        return list.size();
    }

    public E get(int index) {
        return list.get(index);
    }

    public void add(int index, E entry) {
        list.add(index, entry);
    }

    public boolean add(E entry) {
        return list.add(entry);
    }

    public E remove(int index) {
        return list.remove(index);
    }

    public boolean remove(E e) {
        return list.remove(e);
    }

    public void clear() {
        list.clear();
    }

    public int indexOf(String id) {
        for (int i = 0, size = list.size(); i < size; i++) {
            E e = list.get(i);
            if (e.id.equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
