package strategy;

/**
 * 具体策略类
 *
 * @author zhaohaoren
 */
public class ConcreteStrategyA implements Strategy {
    @Override
    public void algorithm() {
        System.out.println("use A");
    }
}
