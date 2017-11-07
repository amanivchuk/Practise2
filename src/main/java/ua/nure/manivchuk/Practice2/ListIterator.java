package ua.nure.manivchuk.Practice2;

import java.util.Iterator;

/**
 * Created by nec on 07.11.17.
 */
public interface ListIterator extends Iterator<Object> {
    // returns true if this list iterator has more elements when traversing the list in the reverse direction
    boolean hasPrevious();
    // returns the previous element in the list and moves the cursor position backwards
    Object previous();
    // replaces the last element returned by next or previous with the specified element
    void set(Object e);
    // replaces the last element returned by next or previous with the specified element
    void remove();
}