package state;

/**
 * 具体状态类：冰水
 *
 * @author zhaohaoren
 */
public class IceWaterState implements WaterState {
    @Override
    public void showState() {
        System.out.println("i am ice");
    }
}
