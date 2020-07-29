package prototype;

/**
 * 使用java的clone方法实现原型模式
 * Object里面有个clone方法，想要使用该方法的类需要实现Cloneable接口，否则会抛CloneNotSupportedException异常
 * 该对象复制方式是浅克隆
 *
 * @author zhaohaoren
 */
public class JavaPrototypeDemo implements Cloneable {

    @Override
    protected JavaPrototypeDemo clone() {
        try {
            return (JavaPrototypeDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        JavaPrototypeDemo demo = new JavaPrototypeDemo();
        JavaPrototypeDemo clone = demo.clone();
        System.out.println(clone == demo);
    }
}
