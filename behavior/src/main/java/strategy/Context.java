package strategy;

/**
 * 环境类
 *
 * @author zhaohaoren
 */
public class Context {
    /**
     * 具体策略的引用
     */
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        this.strategy.algorithm();
    }
}
