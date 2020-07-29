package iterator;

import java.util.List;

/**
 * 具体集合类
 *
 * @author zhaohaoren
 */
public class ConcreteList extends AbstractObjectList {

    public ConcreteList(List objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {
        return new ConcreteIterator(this);
    }
}
