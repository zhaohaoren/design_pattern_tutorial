package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象聚合类
 *
 * @author zhaohaoren
 */
public abstract class AbstractObjectList {

    protected List<Object> objects = new ArrayList<>();

    public AbstractObjectList(List objects) {
        this.objects = objects;
    }

    public void addObject(Object object) {
        this.objects.add(object);
    }

    public void removeObject(Object object) {
        this.objects.remove(object);
    }

    public List<Object> getObjects() {
        return objects;
    }

    /**
     * 创建一个迭代器
     */
    public abstract AbstractIterator createIterator();
}
