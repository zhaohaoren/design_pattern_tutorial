package visitor;

/**
 * 具体访问者
 *
 * @author zhaohaoren
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("B visit:" + concreteElementA.getName());
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("B visit:" + concreteElementB.getName());
    }
}
