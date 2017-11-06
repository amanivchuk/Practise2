package ua.nure.manivchuk.Practice2;

import java.io.BufferedReader;
import java.util.Arrays;

/**
 * Created by Lenovo on 11/6/2017.
 */
public class MyListImpl implements MyList {

    private Object[] list;
    private int count = 0;

    public MyListImpl() {
        this.list = new Object[10];
    }

    public void add(Object e) {
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
}