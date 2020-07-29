package visitor;

/**
 * 具体访问者
 *
 * @author zhaohaoren
 */
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("A visit:" + concreteElementA.getName());
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("A visit:" +concreteElementB.getName());
    }
}
