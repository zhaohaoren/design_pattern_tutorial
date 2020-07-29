package top.zhaohaoren.dp.decorator;

/**
 * 具体对象
 *
 * @author zhaohaoren
 */
public class ComponentA implements Component{
    @Override
    public void display() {
        System.out.println("A");
    }
}
