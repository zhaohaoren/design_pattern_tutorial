package prototype;

/**
 * 通用原型模式实现
 * 任何语言都可以通过这种方式来clone一个相似对象。
 *
 * @author zhaohaoren
 */
public class BasePrototypeDemo implements Prototype {

    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    //内部克隆一个新的对象
    @Override
    public Prototype clone() {
        BasePrototypeDemo instance = new BasePrototypeDemo();
        instance.setAttr(this.attr);
        return instance;
    }

    public static void main(String[] args) {
        BasePrototypeDemo demo = new BasePrototypeDemo();
        demo.setAttr("Hello Beijing");
        Prototype clone = demo.clone();
        System.out.println(((BasePrototypeDemo) clone).getAttr());
        System.out.println(demo == clone);
    }
}
