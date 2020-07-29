package command;

/**
 * 命令模式Demo
 *
 * @author zhaohaoren
 */
public class CommandDemo {
    public static void main(String[] args) {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
