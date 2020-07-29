package state;

/**
 * 环境类
 *
 * @author zhaohaoren
 */
public class WaterContext {
    /**
     * 引用该Context所有可能的State
     */
    private WaterState state;

    public WaterState getState() {
        return state;
    }

    /**
     * 使用环境类来完成状态的转换
     *
     * @param value 环境切换的判断依据
     */
    public void setWaterState(int value) {
        if (value == 0) {
            state = new IceWaterState();
        } else if (value == 1) {
            state = new WarmWaterState();
        } else if (value == 2) {
            state = new HotWaterState();
        }
    }
}
