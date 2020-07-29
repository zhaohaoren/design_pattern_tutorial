package visitor;

/**
 * 访问者模式
 *
 * @author zhaohaoren
 */
public class VisitorDemo {

    public static void main(String[] args) {
        Element e1, e2, e3, ee1, ee2, ee3;
        ObjectStructure objectStructure = new ObjectStructure();
        e1 = new ConcreteElementA("A1");
        e2 = new ConcreteElementA("A2");
        e3 = new ConcreteElementA("A3");
        ee1 = new ConcreteElementA("B1");
        ee2 = new ConcreteElementA("B2");
        ee3 = new ConcreteElementA("B3");
        objectStructure.addElement(e1);
        objectStructure.addElement(e2);
        objectStructure.addElement(e3);
        objectStructure.addElement(ee1);
        objectStructure.addElement(ee2);
        objectStructure.addElement(ee3);
        //可以通过配置来获取使用哪个访问类
        Visitor v = new ConcreteVisitorA();
        objectStructure.accept(v);

    }
}
