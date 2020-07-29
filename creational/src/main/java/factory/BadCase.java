package factory;

/**
 * 需要被改进的案例
 *
 * @author zhaohaoren
 */
public class BadCase {

    private String name;


    public BadCase(String name) {
        if (name.equalsIgnoreCase("a")) {
            this.name = "a";
        } else if (name.equals("b")) {
            this.name = "b";
        }
        //else if ...
        /* bad points：
         * 1.太多if else。性能差，代码冗余
         * 2.如果要加个c产品，需要修改该类。
         * 3.类职责过重，既要创建各种对象，又要负责各种对象的使用。
         * */
    }

    public void printName() {
        if (this.name.equalsIgnoreCase("a")) {
            System.out.println("a");
        } else if (this.name.equalsIgnoreCase("b")) {
            System.out.println("b");
        }
        //else if ...
    }

    public static void main(String[] args) {
        BadCase bad = new BadCase("a");
        bad.printName();
    }
}
