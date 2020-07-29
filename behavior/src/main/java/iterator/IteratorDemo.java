package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式案例
 *
 * @author zhaohaoren
 */
public class IteratorDemo {
    public static void main(String[] args) {
        List data = new ArrayList();
        data.add("A");
        data.add("B");
        data.add("C");
        data.add("D");
        data.add("E");
        data.add("F");

        ConcreteList concreteList = new ConcreteList(data);
        AbstractIterator iterator = concreteList.createIterator();
        while (!iterator.isLast()) {
            System.out.println(iterator.getNextItem());
            iterator.next();
        }
    }
}
