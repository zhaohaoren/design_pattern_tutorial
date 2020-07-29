package state;

/**
 * 具体状态类：热水
 *
 * @author zhaohaoren
 */
public class HotWaterState implements WaterState {
    @Override
    public void showState() {
        System.out.println("i am hot");
    }
}
