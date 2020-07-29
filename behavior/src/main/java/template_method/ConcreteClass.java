package template_method;

/**
 * 具体子类
 *
 * @author zhaohaoren
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public void op2() {
        System.out.println("sub op2");
    }

    @Override
    public void op3() {
        System.out.println("sub op3");
    }
}
