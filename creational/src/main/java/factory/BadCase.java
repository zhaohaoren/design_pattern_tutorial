package factory;

/**
 * 需要被改进的案例
 *
 * @author zhaohaoren
 */
public class BadCase {

    private String name;

    public BadCase(String shape) {
        if ("circle".equals(shape)) {
            this.name = "circle";
        } else if ("rect".equals(shape)) {
            this.name = "rect";
        } else if ("triangle".equals(shape)) {
            this.name = "triangle";
        }
        //else if ...
    }

    public void draw() {
        if ("circle".equals(this.name)) {
            System.out.println("i am circle");
        } else if ("rect".equals(this.name)) {
            System.out.println("i am rect");
        } else if ("triangle".equals(this.name)) {
            System.out.println("i am triangle");
        }
        //else if ...
    }

    public static void main(String[] args) {
        BadCase bad = new BadCase("rect");
        bad.draw();
    }
}
