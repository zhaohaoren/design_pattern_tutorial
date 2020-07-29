package template_method;

/**
 * 模板方法模式
 *
 * @author zhaohaoren
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
