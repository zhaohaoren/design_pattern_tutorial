package top.zhaohaoren.dp.facade;

/**
 * 新的外观类
 *
 * @author zhaohaoren
 */
public class FacadeNew extends AbstractFacade {
    private SubSystem01 s1;

    public FacadeNew(SubSystem01 s1) {
        this.s1 = s1;
    }

    @Override
    public void op() {
        s1.op1();
    }
}
