package iterator;

/**
 * 抽象迭代器
 *
 * @author zhaohaoren
 */
interface AbstractIterator {
    void next();

    boolean isLast();

    void previous();

    boolean isFirst();

    Object getNextItem();

    Object getPreviousItem();
}
