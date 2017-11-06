package ua.nure.manivchuk.Practice2;

/**
 * Created by Lenovo on 11/6/2017.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("==== Part1");
        MyList list = new MyListImpl();
// [A, A2]
        list.add("A");
        list.add("A2");
        System.out.println(list);
// []
        list.clear();
        System.out.println(list);
// [A, A3]
        list.add("A");
        list.add("A2");
        list.add("A3");
        list.remove("A2");
        System.out.println(list);
// AA3
        for (Object el : list.toArray()) {
            System.out.print(el);
        }
        System.out.println();
// 2
        System.out.println(list.size());
// false
        System.out.println(list.contains("B"));
// true
        System.out.println(list.contains("A3"));
// true
        list.add("A2");
        MyList anotherList = new MyListImpl();
        anotherList.add("A");
        anotherList.add("A2");
        System.out.println(list.containsAll(anotherList));
// false
        anotherList.add("B");
        System.out.println(list.containsAll(anotherList));
// true
        list.add("B");
        System.out.println(list.containsAll(anotherList));
    }
}
