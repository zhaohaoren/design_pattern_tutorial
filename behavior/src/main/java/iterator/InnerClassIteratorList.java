package iterator;

import java.util.List;

/**
 * 迭代器类使用内部类的方式
 * JDK的迭代器类就是通过这种方式来实现的
 *
 * @author zhaohaoren
 */
public class InnerClassIteratorList extends AbstractObjectList {
    public InnerClassIteratorList(List objects) {
        super(objects);
    }

    @Override
    public AbstractIterator createIterator() {
        return new InnerIterator();
    }

    private class InnerIterator implements AbstractIterator {
        private int cursor1;
        private int cursor2;

        public InnerIterator() {
            cursor1 = 0;
            cursor2 = objects.size() - 1;
        }

        @Override
        public void next() {
            if (cursor1 < objects.size()) {
                cursor1++;
            }
        }

        @Override
        public boolean isLast() {
            return cursor1 == objects.size();
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
            return objects.get(cursor1);
        }

        @Override
        public Object getPreviousItem() {
            return objects.get(cursor2);
        }
    }


}
