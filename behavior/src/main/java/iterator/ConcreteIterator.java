package iterator;

import java.util.List;

/**
 * 具体的迭代器实现
 *
 * @author zhaohaoren
 */
public class ConcreteIterator implements AbstractIterator {

    /**
     * 引用被迭代的数据
     */
    private ConcreteList concreteList;
    private List data;

    /**
     * 开始位置 往后移动的标志
     */
    private int cursor1;
    /**
     * 结束位置 往前移动的标志
     */
    private int cursor2;

    public ConcreteIterator(ConcreteList concreteList) {
        this.concreteList = concreteList;
        this.data = concreteList.getObjects();
        cursor1 = 0;
        cursor2 = data.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < data.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return cursor1 == data.size();
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }

    @Override
    public Object getNextItem() {
        return data.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return data.get(cursor2);
    }
}
