package visitor;

/**
 * 抽象访问者
 * 这里要对结合中的所有的元素种类都定义一个访问的方法抽象。
 *
 * @author zhaohaoren
 */
public interface Visitor {
    void visit(ConcreteElementA concreteElementA);
    void visit(ConcreteElementB concreteElementB);
}
