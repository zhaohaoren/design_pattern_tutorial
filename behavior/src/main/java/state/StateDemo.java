package state;

/**
 * 状态模式
 *
 * @author zhaohaoren
 */
public class StateDemo {
    public static void main(String[] args) {
        WaterContext context = new WaterContext();
        context.setWaterState(0);
        context.getState().showState();
        context.setWaterState(1);
        context.getState().showState();
        context.setWaterState(2);
        context.getState().showState();
    }
}
