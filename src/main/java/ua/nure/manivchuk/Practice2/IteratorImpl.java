package ua.nure.manivchuk.Practice2;

import java.util.Iterator;

/**
 * Created by nec on 07.11.17.
 */
public class IteratorImpl implements Iterator<Object> {
    MyListImpl content = new MyListImpl();
    Object[] list = content.getList();
    int count = content.getCount();
    private int pos = 0;
    private boolean flag = false;

    @Override
    public boolean hasNext() {
        return count > pos;
    }

    @Override
    public Object next() {
        flag = true;
        return list[pos++];
    }

    @Override
    public void remove() {
        if(!flag){
            throw new IllegalStateException();
        }
        System.arraycopy(list, pos, list, pos-1, list.length-1-pos);
        count = count-1;
        pos--;
        flag = false;
    }
}
