package builder;

/**
 * 需要被构建的实体类
 *
 * @author zhaohaoren
 */
public class Car {
    private String light;
    private String wheel;
    private String chair;

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    @Override
    public String toString() {
        return "Car{" +
                "light='" + light + '\'' +
                ", wheel='" + wheel + '\'' +
                ", chair='" + chair + '\'' +
                '}';
    }
}
