package visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构
 *
 * @author zhaohaoren
 */

public class ObjectStructure {

    /**
     * 使用集合集合来存放所有的元素。
     */
    private List<Element> list = new ArrayList<>();

    public void addElement(Element e) {
        list.add(e);
    }

    public void removeElement(Element e) {
        list.remove(e);
    }

    /**
     * 使用某个访问者来遍历集合元素
     */
    public void accept(Visitor visitor) {
        list.forEach(item -> item.accept(visitor));
    }
}
