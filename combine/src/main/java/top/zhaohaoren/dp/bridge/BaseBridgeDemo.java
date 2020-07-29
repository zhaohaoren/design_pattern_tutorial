package top.zhaohaoren.dp.bridge;

/**
 * 桥接模式
 *
 * @author zhaohaoren
 */
public class BaseBridgeDemo {
    public static void main(String[] args) {
        Pen p = new Pen1();
        Color c = new Red();
        p.setColor(c);
        p.size();
    }
}


/**
 * 抽象类
 */
abstract class Pen {
    Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    abstract void size();
}

/**
 * 某个变化维度的接口
 */
interface Color {
    void color();
}

/**
 * 变化维度接口的实现
 */
class Red implements Color {
    @Override
    public void color() {
        System.out.println("red");
    }
}

class Black implements Color {
    @Override
    public void color() {
        System.out.println("black");
    }
}

class Blue implements Color {
    @Override
    public void color() {
        System.out.println("blue");
    }
}

/**
 * 抽象类的具体实现
 */
class Pen1 extends Pen {
    @Override
    void size() {
        color.color();
        System.out.println("size:1");
    }
}

class Pen2 extends Pen {
    @Override
    void size() {
        color.color();
        System.out.println("size:2");
    }
}