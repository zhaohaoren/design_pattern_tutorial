package state;

/**
 * 具体状态类：温水
 *
 * @author zhaohaoren
 */
public class WarmWaterState implements WaterState {

    @Override
    public void showState() {
        System.out.println("i am warm");
    }
}
