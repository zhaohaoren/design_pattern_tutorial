package strategy;

/**
 * 策略模式
 *
 * @author zhaohaoren
 */
public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new ConcreteStrategyA());
        context.execute();
        context.setStrategy(new ConcreteStrategyB());
        context.execute();
    }
}
