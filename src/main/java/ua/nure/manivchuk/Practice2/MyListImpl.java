package ua.nure.manivchuk.Practice2;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Lenovo on 11/6/2017.
 */
public class MyListImpl implements MyList, ListIterable {

    private Object[] list;
    private int count = 0;

    public MyListImpl() {
        this.list = new Object[10];
    }

    public void add(Object e) {
        if(count == list.length-1){
            Object[] newList = new Object[count * 2];
            System.arraycopy(list,0,newList,0,list.length);
            list = newList;
        }
        list[count++] = e;
    }

    public void clear() {
        for(int i = 0; i < count; i++){
            list[i] = null;
        }
        count = 0;
    }

    public boolean remove(Object o) {
        for(int i = 0; i < count; i++){
            if(o.equals(list[i])){
                //list[i] = null;
                System.arraycopy(list,i+1,list,i,list.length-1-i);
                count--;
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] obj = new Object[count];
        for(int i = 0; i < count; i++){
            obj[i] = list[i];
        }
        return obj;
    }

    public int size() {
        return count;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < count; i++)
                if (list[i]==null)
                    return i;
        } else {
            for (int i = 0; i < count; i++)
                if (o.equals(list[i]))
                    return i;
        }
        return -1;
    }

    public boolean containsAll(MyList c) {
        Object[] objects = c.toArray();
        for (int i = 0; i < c.size(); i++)
            if (!contains(objects[i]))
                return false;
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyListImpl myList = (MyListImpl) o;

        if (count != myList.count) return false;
        return Arrays.equals(list, myList.list);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(list);
        result = 31 * result + count;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer("[");
        for(int i = 0; i < count; i++){
            buffer.append("результат вызова toString для элемента ").append(i).append(" : ").append(list[i]);

            if(i+1 < count){
                buffer.append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
   /*     return new Iterator<Object>() {
            private int pos = 0;
            private boolean flag = false;
            private int countt = size();

            @Override
            public boolean hasNext() {
                return countt > pos;
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
                countt = countt-1;
                pos--;
                flag = false;
            }
        };*/
    }

    @Override
    public ListIterator listIterator() {
        return new ListIteratorImpl();
    }


    private class IteratorImpl implements Iterator<Object> {
        protected int pos = 0;
        protected boolean flag = false;
//        private int countt = size();

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

    private class ListIteratorImpl extends IteratorImpl implements ListIterator {
        // returns true if this list iterator has more elements when traversing the list in the reverse direction
        @Override
        public boolean hasPrevious() {
            return pos != 0;
        }

        // returns the previous element in the list and moves the cursor position backwards
        @Override
        public Object previous() {
            flag = true;
            return list[--pos];
        }

        // replaces the last element returned by next or previous with the specified element
        @Override
        public void set(Object e) {
            if(!flag){
                throw new IllegalStateException();
            }
            list[pos] = e;
            flag = false;
        }
    }
}
