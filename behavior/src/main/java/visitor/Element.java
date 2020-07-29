package visitor;

/**
 * 抽象元素类
 *
 * @author zhaohaoren
 */
public interface Element {
    /**
     * 这accept对该类的元素传入一个accept。则集合中该元素都会使用该访问者处理。
     * 而这个访问者也实现了visit该元素的方法。所以传入this就可以重载到对应实现逻辑里面
     * @param visitor
     */
    void accept(Visitor visitor);
}
