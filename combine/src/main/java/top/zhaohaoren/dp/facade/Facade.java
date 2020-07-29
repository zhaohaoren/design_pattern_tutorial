package top.zhaohaoren.dp.facade;

/**
 * 对子系统包装的一个外观类
 *
 * @author zhaohaoren
 */
public class Facade {
    private SubSystem01 s1;
    private SubSystem02 s2;

    public Facade(SubSystem01 s1, SubSystem02 s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public void op() {
        s1.op1();
        s2.op2();
    }
}
