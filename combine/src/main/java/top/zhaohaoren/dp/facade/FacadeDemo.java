package top.zhaohaoren.dp.facade;

/**
 * 外观模式
 *
 * @author zhaohaoren
 */
public class FacadeDemo {

    public static void main(String[] args) {
        Facade facade = new Facade(new SubSystem01(),new SubSystem02());
        facade.op();

        // 可以通过配置来加载具体的外观类
        AbstractFacade abstractFacade = new FacadeNew(new SubSystem01());
        abstractFacade.op();
    }
}
