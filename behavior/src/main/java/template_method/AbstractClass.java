package template_method;

/**
 * 抽象类
 *
 * @author zhaohaoren
 */
public abstract class AbstractClass {

    /**
     * 模板方法
     */
    public final void templateMethod() {
        op1();
        op2();
        op3();
    }

    /*
     * 基本方法
     */

    /**
     * 基本具体方法
     */
    public void op1() {
        System.out.println("op1");
    }

    /**
     * 基本抽象方法
     */
    public abstract void op2();

    /**
     * 钩子方法
     */
    public void op3() {

    }
}
